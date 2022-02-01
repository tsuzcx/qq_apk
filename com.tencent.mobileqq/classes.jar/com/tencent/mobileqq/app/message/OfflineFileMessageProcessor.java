package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkServiceManager;
import java.util.ArrayList;
import java.util.Random;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_ctrl.ResvResvInfo;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Trans211TmpMsg;

public class OfflineFileMessageProcessor
  extends BaseMessageProcessor
{
  ArrayList<String> t = new ArrayList(20);
  
  public OfflineFileMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, msg_svc.RoutingHead paramRoutingHead)
  {
    paramRoutingHead.business_wpa_tmp.to_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
    if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
      paramRoutingHead.business_wpa_tmp.sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
    }
    paramRoutingHead.business_wpa_tmp.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt2 != 241))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleSendTransMessageResp : send failed:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", transc2ccmd:");
        localStringBuilder.append(paramInt1);
        QLog.e("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
      this.r.c(paramLong);
      if (133 == paramInt1)
      {
        ((QQAppInterface)this.q).getFileTransferHandler().a(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
        return;
      }
      if (135 == paramInt1) {
        ((QQAppInterface)this.q).getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send successfully.");
      }
      this.r.c(paramLong);
      if (133 == paramInt1) {
        ((QQAppInterface)this.q).getFileTransferHandler().a(paramString, paramToServiceMsg.extraData.getLong("sessionid"), true);
      }
      if (135 == paramInt1)
      {
        ((QQAppInterface)this.q).getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), true);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("<---handleSendTransMessageResp : can not handle transc2ccmd:");
        paramToServiceMsg.append(paramInt1);
        QLog.w("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong4, int paramInt3, msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    StringBuilder localStringBuilder;
    if ((paramInt3 != 0) && (paramInt3 != 241))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("<---handleSendTransMessageExResp : send failed:");
        paramString2.append(paramInt3);
        paramString2.append(", transc2ccmd:");
        paramString2.append(paramInt1);
        QLog.e("Q.msg.BaseMessageProcessor", 2, paramString2.toString());
      }
      if (((paramLong4 == 100L) || (paramLong4 == 127L)) && (paramPbSendMsgResp != null) && (paramPbSendMsgResp.errmsg.has()))
      {
        AddMessageHelper.a(this.q, paramString1, paramPbSendMsgResp.errmsg.get(), 1001, false, false);
        paramFromServiceMsg.setMsgFail();
        paramPbSendMsgResp = this.q;
        if (paramLong4 == 100L) {
          paramString2 = "0";
        } else {
          paramString2 = "1";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt3);
        ReportController.b(paramPbSendMsgResp, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, paramString2, localStringBuilder.toString(), "", "");
      }
      this.r.c(paramLong3);
      a(paramToServiceMsg, paramFromServiceMsg, paramString1, paramInt1, paramInt2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send successfully.");
    }
    this.r.c(paramLong2);
    if ((paramPbSendMsgResp.send_time.has()) && (paramLong1 != 0L))
    {
      paramLong2 = paramPbSendMsgResp.send_time.get() & 0xFFFFFFFF;
      this.r.a(paramString1, 0, paramLong1, paramLong2);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSendTransMsgTime: sendBuddyPb: respData.uSendTime:");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(",peerUin:");
        localStringBuilder.append(paramString1);
        QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramString1, paramString2, paramInt1, paramInt2, paramPbSendMsgResp);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if (paramOffLineFileInfo == null)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: ");
      localStringBuilder.append(paramOffLineFileInfo.k);
      QLog.d("wk", 2, localStringBuilder.toString());
    }
    if (paramOffLineFileInfo.k == 6)
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
      return;
    }
    if (paramOffLineFileInfo.k == 2)
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
      return;
    }
    if (paramOffLineFileInfo.k == 1) {
      b(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, int paramInt1, int paramInt2)
  {
    if (529 == paramInt1)
    {
      if (paramInt2 != 1025)
      {
        if (paramInt2 != 1055)
        {
          if (paramInt2 != 1028)
          {
            if (paramInt2 != 1029)
            {
              if (paramInt2 != 1032)
              {
                if (paramInt2 != 1033)
                {
                  if (QLog.isColorLevel())
                  {
                    paramToServiceMsg = new StringBuilder();
                    paramToServiceMsg.append("<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType");
                    paramToServiceMsg.append(paramInt2);
                    QLog.d("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
                  }
                }
                else if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync fail");
                }
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file fail");
                }
                long l = paramToServiceMsg.extraData.getLong("sessionid");
                ((QQAppInterface)this.q).getQlinkServiceMgr().b(l);
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
            }
          }
          else
          {
            ((QQAppInterface)this.q).getFileTransferHandler().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
            }
          }
        }
        else {
          ((QQAppInterface)this.q).getFileTransferHandler().b(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      else {
        ((QQAppInterface)this.q).getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<---handleSendTransMessageExResp : can not handle transc2ccmd:");
      paramToServiceMsg.append(paramInt1);
      QLog.w("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString1, String paramString2, int paramInt1, int paramInt2, msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    if (529 == paramInt1)
    {
      if (paramInt2 != 1025)
      {
        if (paramInt2 != 1055)
        {
          if (paramInt2 != 1028)
          {
            if (paramInt2 != 1029)
            {
              if (paramInt2 != 1032)
              {
                if (paramInt2 != 1033)
                {
                  if (QLog.isColorLevel())
                  {
                    paramToServiceMsg = new StringBuilder();
                    paramToServiceMsg.append("<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType");
                    paramToServiceMsg.append(paramInt2);
                    QLog.d("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
                  }
                }
                else if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync suc");
                }
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file suc");
                }
                long l = paramToServiceMsg.extraData.getLong("sessionid");
                ((QQAppInterface)this.q).getQlinkServiceMgr().a(l);
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt suc");
            }
          }
          else
          {
            if (paramPbSendMsgResp.send_time.has())
            {
              paramString1 = new StringBuilder();
              paramString1.append(paramString2);
              paramString1.append(String.valueOf(paramPbSendMsgResp.send_time.get()));
              a(paramString1.toString());
            }
            ((QQAppInterface)this.q).getFileTransferHandler().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  suc");
            }
          }
        }
        else {
          ((QQAppInterface)this.q).getFileTransferHandler().b(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      else {
        ((QQAppInterface)this.q).getFileTransferHandler().b(paramString1, paramToServiceMsg.extraData.getLong("sessionid"), true);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<---handleSendTransMessageExResp : can not handle transc2ccmd:");
      paramToServiceMsg.append(paramInt1);
      QLog.w("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
    }
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    im_msg_body.RichText localRichText;
    if (!paramPbSendMsgReq.msg_body.rich_text.has()) {
      localRichText = new im_msg_body.RichText();
    } else {
      localRichText = (im_msg_body.RichText)paramPbSendMsgReq.msg_body.rich_text.get();
    }
    Object localObject = new generalflags.ResvAttr();
    int i = 0;
    while (i < localRichText.elems.size())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localRichText.elems.get(i);
      if ((localElem.general_flags.has()) && (((im_msg_body.GeneralFlags)localElem.general_flags.get()).bytes_pb_reserve.has()))
      {
        try
        {
          ((generalflags.ResvAttr)localObject).mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        localRichText.elems.remove(i);
        break;
      }
      i += 1;
    }
    ((generalflags.ResvAttr)localObject).uint32_device_type.set(QFileAssistantUtils.c());
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    localGeneralFlags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((generalflags.ResvAttr)localObject).toByteArray()));
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).general_flags.set(localGeneralFlags);
    localRichText.elems.add((MessageMicro)localObject);
    paramPbSendMsgReq.msg_body.rich_text.set(localRichText);
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    if (paramFMTransC2CMsgInfo.entity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IMG_FILE_QR", 1, "add image QrInfo , info is null, maybe is not qr image");
      }
      return;
    }
    paramFMTransC2CMsgInfo = JumpShareUtils.a(paramFMTransC2CMsgInfo.entity.getFilePath(), paramFMTransC2CMsgInfo.entity.imgWidth, paramFMTransC2CMsgInfo.entity.imgHeight, paramFMTransC2CMsgInfo.entity.strQRUrl);
    if (paramFMTransC2CMsgInfo != null) {
      paramPbSendMsgReq.msg_ctrl.set(paramFMTransC2CMsgInfo);
    }
    try
    {
      if (QLog.isColorLevel())
      {
        if (paramFMTransC2CMsgInfo.resv_resv_info.has())
        {
          paramPbSendMsgReq = new StringBuilder();
          paramPbSendMsgReq.append("reqFeeds with ImageInfo has uint32_flag:");
          paramPbSendMsgReq.append(((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_flag.get());
          QLog.i("IMG_FILE_QR", 1, paramPbSendMsgReq.toString());
          paramPbSendMsgReq = new StringBuilder();
          paramPbSendMsgReq.append("reqFeeds with ImageInfo has uint64_reserv2:");
          paramPbSendMsgReq.append(((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint64_reserv2.get());
          QLog.i("IMG_FILE_QR", 1, paramPbSendMsgReq.toString());
          paramPbSendMsgReq = new StringBuilder();
          paramPbSendMsgReq.append("reqFeeds with ImageInfo has uint64_reserv3:");
          paramPbSendMsgReq.append(((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint64_reserv3.get());
          QLog.i("IMG_FILE_QR", 1, paramPbSendMsgReq.toString());
          paramPbSendMsgReq = new StringBuilder();
          paramPbSendMsgReq.append("reqFeeds with ImageInfo has uint32_create_time:");
          paramPbSendMsgReq.append(((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_create_time.get());
          QLog.i("IMG_FILE_QR", 1, paramPbSendMsgReq.toString());
          paramPbSendMsgReq = new StringBuilder();
          paramPbSendMsgReq.append("reqFeeds with ImageInfo has uint32_pic_width:");
          paramPbSendMsgReq.append(((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_pic_width.get());
          QLog.i("IMG_FILE_QR", 1, paramPbSendMsgReq.toString());
          paramPbSendMsgReq = new StringBuilder();
          paramPbSendMsgReq.append("reqFeeds with ImageInfo has uint32_pic_height:");
          paramPbSendMsgReq.append(((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_pic_height.get());
          QLog.i("IMG_FILE_QR", 1, paramPbSendMsgReq.toString());
          return;
        }
        QLog.i("IMG_FILE_QR", 1, "eqFeeds without ImageInfo");
      }
      return;
    }
    catch (Throwable paramPbSendMsgReq) {}
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, TransMsgContext paramTransMsgContext)
  {
    if (paramFMTransC2CMsgInfo != null)
    {
      if (paramFMTransC2CMsgInfo.entity == null) {
        return;
      }
      Object localObject = paramFMTransC2CMsgInfo.entity;
      paramFMTransC2CMsgInfo = paramPbSendMsgReq.routing_head;
      int i = (int)((FileManagerEntity)localObject).tmpSessionType;
      if (i != 100)
      {
        if (i != 102)
        {
          if (i != 109)
          {
            if (i != 124)
            {
              if (i != 127)
              {
                if (i != 104)
                {
                  if (i != 105) {
                    return;
                  }
                  g((FileManagerEntity)localObject, paramFMTransC2CMsgInfo);
                }
                else
                {
                  f((FileManagerEntity)localObject, paramFMTransC2CMsgInfo);
                }
              }
              else {
                d((FileManagerEntity)localObject, paramFMTransC2CMsgInfo);
              }
            }
            else {
              a((FileManagerEntity)localObject, paramFMTransC2CMsgInfo);
            }
          }
          else {
            c((FileManagerEntity)localObject, paramFMTransC2CMsgInfo);
          }
        }
        else {
          b((FileManagerEntity)localObject, paramFMTransC2CMsgInfo);
        }
      }
      else {
        e((FileManagerEntity)localObject, paramFMTransC2CMsgInfo);
      }
      if ((paramTransMsgContext != null) && (paramTransMsgContext.b != null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tmpsession msg0x211[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("]");
          QLog.e("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
        }
        paramFMTransC2CMsgInfo.trans_0x211.setHasFlag(false);
        paramPbSendMsgReq.msg_body.msg_content.setHasFlag(false);
        paramPbSendMsgReq.msg_body.rich_text.setHasFlag(true);
        paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.setHasFlag(true);
        paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.bytes_msg_body.set(ByteStringMicro.copyFrom(paramTransMsgContext.b));
        paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.uint32_c2c_cmd.set(4);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession Bug msgContext or msgContext.msg null!");
      }
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, msg_svc.RoutingHead paramRoutingHead)
  {
    if (paramFileManagerEntity.tmpSessionFromPhone == null) {
      paramFileManagerEntity.tmpSessionFromPhone = "";
    }
    paramRoutingHead.address_list.from_phone.set(paramFileManagerEntity.tmpSessionFromPhone);
    if (paramFileManagerEntity.tmpSessionToPhone == null) {
      paramFileManagerEntity.tmpSessionToPhone = "";
    }
    paramRoutingHead.address_list.to_phone.set(paramFileManagerEntity.tmpSessionToPhone);
    String str = paramFileManagerEntity.peerUin.replace("+", "");
    paramRoutingHead.address_list.to_uin.set(Long.parseLong(str));
    if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
      paramRoutingHead.address_list.sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
    }
    paramRoutingHead.address_list.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo != null) && (paramOffLineFileInfo.b == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
      }
      int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      StatictisInfo localStatictisInfo = new StatictisInfo();
      localStatictisInfo.b = paramFromServiceMsg.getResultCode();
      localStatictisInfo.c = i;
      this.r.a(paramToServiceMsg, 5004, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSendOfflineFileResp-->handleError");
    }
    this.r.c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp");
    }
    String str1 = paramToServiceMsg.getServiceCmd();
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    String str2 = paramToServiceMsg.extraData.getString("uin");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp::invalid.", paramObject);
      }
      paramObject = null;
    }
    int i;
    if ((paramObject != null) && (paramObject.result.has()))
    {
      if (paramObject.result.get() != 0) {
        i = paramObject.result.get();
      } else {
        i = 0;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
      }
      i = 4;
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:");
      paramObject.append(str1);
      paramObject.append("----replyCode:");
      paramObject.append(i);
      paramObject.append(",sendC2CMessage resp : peerUin:");
      paramObject.append(str2);
      paramObject.append(",msgSeq:");
      paramObject.append(l);
      paramObject.append(",transc2ccmd:");
      paramObject.append(k);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramObject.toString());
    }
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
    this.r.b(paramToServiceMsg, paramFromServiceMsg);
    paramFromServiceMsg = this.r.b(l);
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:");
        paramToServiceMsg.append(str1);
        paramToServiceMsg.append(",no SendMessageHandler found.");
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
      }
      return;
    }
    int j;
    if (i == 255) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (this.r.a(paramFromServiceMsg, "server"))) {
      return;
    }
    a(paramToServiceMsg, l, str2, k, i);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, int paramInt1, int paramInt2)
  {
    if (529 == paramInt1) {
      if (paramInt2 != 1025)
      {
        if (paramInt2 != 1033)
        {
          if (paramInt2 != 1055)
          {
            if (paramInt2 != 1028)
            {
              if (paramInt2 != 1029)
              {
                if (QLog.isColorLevel())
                {
                  paramToServiceMsg = new StringBuilder();
                  paramToServiceMsg.append("<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType");
                  paramToServiceMsg.append(paramInt2);
                  QLog.d("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
              }
            }
            else
            {
              ((QQAppInterface)this.q).getFileTransferHandler().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
              }
            }
          }
          else {
            ((QQAppInterface)this.q).getFileTransferHandler().b(paramToServiceMsg, paramFromServiceMsg);
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExError : qlink send file state fail");
        }
      }
      else {
        ((QQAppInterface)this.q).getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
      }
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, msg_svc.RoutingHead paramRoutingHead)
  {
    paramRoutingHead.nearby_dating_tmp.to_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
    if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
      paramRoutingHead.nearby_dating_tmp.sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
    }
    paramRoutingHead.nearby_dating_tmp.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo != null) && (paramOffLineFileInfo.b == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
      }
      int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      StatictisInfo localStatictisInfo = new StatictisInfo();
      localStatictisInfo.b = paramFromServiceMsg.getResultCode();
      localStatictisInfo.c = i;
      this.r.a(paramToServiceMsg, 5005, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSetOfflineFileState-->handleError");
    }
    this.r.c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp");
    }
    String str1 = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("queueSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str2 = paramToServiceMsg.extraData.getString("uin");
    String str3 = paramToServiceMsg.extraData.getString("uuid");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int m = paramToServiceMsg.extraData.getInt("busiType");
    long l4 = paramToServiceMsg.extraData.getLong("tmpSessionType");
    Object localObject = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject).mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp::invalid.", paramObject);
      }
      paramObject = null;
    }
    int i;
    if ((paramObject != null) && (paramObject.result.has()))
    {
      if (paramObject.result.get() != 0) {
        i = paramObject.result.get();
      } else {
        i = 0;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
      }
      i = 4;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("----replyCode:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",sendC2CMessage resp : peerUin:");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(",uniseq:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(",msgSeq:");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(",transc2ccmd:");
      ((StringBuilder)localObject).append(k);
      QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
    this.r.b(paramToServiceMsg, paramFromServiceMsg);
    localObject = this.r.b(l2);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:");
        paramToServiceMsg.append(str1);
        paramToServiceMsg.append(",no SendMessageHandler found.");
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramToServiceMsg.toString());
      }
      return;
    }
    int j;
    if (i == 255) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (this.r.a((SendMessageHandler)localObject, "server"))) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, l1, l2, l3, str2, str3, k, m, l4, i, paramObject);
  }
  
  private void d(FileManagerEntity paramFileManagerEntity, msg_svc.RoutingHead paramRoutingHead)
  {
    paramRoutingHead.comm_tmp.to_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
    if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
      paramRoutingHead.comm_tmp.sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
    }
    paramRoutingHead.comm_tmp.c2c_type.set(1);
    paramRoutingHead.comm_tmp.svr_type.set(149);
    paramRoutingHead.comm_tmp.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if (paramOffLineFileInfo == null)
    {
      this.r.c(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = i;
    this.r.a(paramToServiceMsg, 5003, true, new Object[] { paramOffLineFileInfo.m, localStatictisInfo });
  }
  
  private void e(FileManagerEntity paramFileManagerEntity, msg_svc.RoutingHead paramRoutingHead)
  {
    paramRoutingHead.accost_tmp.to_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
    if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
      paramRoutingHead.accost_tmp.sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
    }
    paramRoutingHead.accost_tmp.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  private void f(FileManagerEntity paramFileManagerEntity, msg_svc.RoutingHead paramRoutingHead)
  {
    try
    {
      l = Long.parseLong(paramFileManagerEntity.tmpSessionRelatedUin);
    }
    catch (Exception localException)
    {
      long l;
      label11:
      StringBuilder localStringBuilder;
      break label11;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("case to long faild, relatedUin[");
    localStringBuilder.append(paramFileManagerEntity.tmpSessionRelatedUin);
    localStringBuilder.append("]");
    QLog.e("Q.msg.BaseMessageProcessor", 1, localStringBuilder.toString());
    l = 0L;
    paramRoutingHead.grp_tmp.group_uin.set(l);
    paramRoutingHead.grp_tmp.to_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
    paramRoutingHead.grp_tmp.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  private void g(FileManagerEntity paramFileManagerEntity, msg_svc.RoutingHead paramRoutingHead)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "addTempSessionData add disctmp Info");
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramFileManagerEntity.tmpSessionRelatedUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label32:
      StringBuilder localStringBuilder;
      break label32;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("case to long faild, relatedUin[");
    localStringBuilder.append(paramFileManagerEntity.tmpSessionRelatedUin);
    localStringBuilder.append("]");
    QLog.e("Q.msg.BaseMessageProcessor", 1, localStringBuilder.toString());
    paramRoutingHead.dis_tmp.dis_uin.set(l1);
    paramRoutingHead.dis_tmp.to_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
    paramRoutingHead.dis_tmp.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramInt != 7001) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 7002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (MessageFactoryReceiver.OffLineFileInfo)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleReqOffFilePackError, count: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("wk", 2, ((StringBuilder)localObject).toString());
    }
    if (i < 2)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      this.r.send(paramToServiceMsg);
      return;
    }
    Object localObject = new StatictisInfo();
    ((StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
    ((StatictisInfo)localObject).c = i;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      ((StatictisInfo)localObject).b = 2900;
      ((StatictisInfo)localObject).d = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
    }
    BaseMessageHandler localBaseMessageHandler = this.r;
    ((StatictisInfo)localObject).e = BaseMessageHandler.a(paramFromServiceMsg);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    if (paramToServiceMsg.extraData.getInt("offfile_type") == 0)
    {
      this.r.a(paramToServiceMsg, 3006, false, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.extraData.getInt("offfile_type") == 1)
    {
      this.r.a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localObject });
      return;
    }
    if (paramToServiceMsg.extraData.getInt("offfile_type") == 2)
    {
      this.r.a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localObject });
      return;
    }
    if (paramToServiceMsg.extraData.getInt("offfile_type") == 3) {
      this.r.a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localObject });
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.t.contains(paramString))
    {
      if (this.t.size() >= 20) {
        this.t.remove(0);
      }
      this.t.add(paramString);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt, byte[] paramArrayOfByte, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    paramFMTransC2CMsgInfo.queueSeq = l;
    a(true, true, true, l, new OfflineFileMessageProcessor.2(this, paramString, paramFMTransC2CMsgInfo, paramInt, paramArrayOfByte));
    return true;
  }
  
  public boolean a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    a(true, true, true, l, new OfflineFileMessageProcessor.3(this, paramString, paramLong, Math.abs(new Random().nextInt()), l, paramInt, paramArrayOfByte));
    return true;
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramInt != 7001) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str = paramToServiceMsg.extraData.getString("uin");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    int i = paramToServiceMsg.extraData.getInt("transC2CCmd");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbSendMsg><E><---handleSendTransMessageError: ---cmd:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",sendC2CMessage error : peerUin:");
      localStringBuilder.append(str);
      localStringBuilder.append(",msgSeq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(",transc2ccmd:");
      localStringBuilder.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    this.r.b(paramToServiceMsg, paramFromServiceMsg);
    localObject = this.r.b(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() == 2901)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageError, msf said:RESNDMSG");
        }
        if (this.r.a((SendMessageHandler)localObject, "msf")) {
          return;
        }
      }
      if ((480000L == l2) || (((SendMessageHandler)localObject).b()))
      {
        this.r.c(l1);
        if (133 == i)
        {
          ((QQAppInterface)this.q).getFileTransferHandler().a(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
          return;
        }
        if (135 == i) {
          ((QQAppInterface)this.q).getFileTransferHandler().b(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
        }
      }
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("queueSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str = paramToServiceMsg.extraData.getString("uin");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    int i = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int j = paramToServiceMsg.extraData.getInt("busiType");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbSendMsg><E><---handleSendTransMessageExError: ---cmd:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",sendC2CMessage error : peerUin:");
      localStringBuilder.append(str);
      localStringBuilder.append(",uniseq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(",msgSeq:");
      localStringBuilder.append(l3);
      localStringBuilder.append(",transc2ccmd:");
      localStringBuilder.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    this.r.b(paramToServiceMsg, paramFromServiceMsg);
    localObject = this.r.b(l2);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() == 2901)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExError, msf said:RESNDMSG");
        }
        if (this.r.a((SendMessageHandler)localObject, "msf")) {
          return;
        }
      }
      if ((480000L == l4) || (((SendMessageHandler)localObject).b()))
      {
        this.r.c(l2);
        b(paramToServiceMsg, paramFromServiceMsg, str, i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OfflineFileMessageProcessor
 * JD-Core Version:    0.7.0.1
 */