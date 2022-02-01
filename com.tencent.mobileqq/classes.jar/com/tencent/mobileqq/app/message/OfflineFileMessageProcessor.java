package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
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
  ArrayList<String> a;
  
  public OfflineFileMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
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
    if ((paramInt2 == 0) || (paramInt2 == 241))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send successfully.");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramLong);
      if (133 == paramInt1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString, paramToServiceMsg.extraData.getLong("sessionid"), true);
      }
      if (135 == paramInt1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), true);
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : can not handle transc2ccmd:" + paramInt1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send failed:" + paramInt2 + ", transc2ccmd:" + paramInt1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramLong);
      if (133 == paramInt1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
        return;
      }
    } while (135 != paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong4, int paramInt3, msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    if ((paramInt3 == 0) || (paramInt3 == 241))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send successfully.");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramLong2);
      if ((paramPbSendMsgResp.send_time.has()) && (paramLong1 != 0L))
      {
        paramLong2 = paramPbSendMsgResp.send_time.get() & 0xFFFFFFFF;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramString1, 0, paramLong1, paramLong2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "updateSendTransMsgTime: sendBuddyPb: respData.uSendTime:" + paramLong2 + ",peerUin:" + paramString1);
        }
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramString1, paramString2, paramInt1, paramInt2, paramPbSendMsgResp);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send failed:" + paramInt3 + ", transc2ccmd:" + paramInt1);
    }
    if (((paramLong4 == 100L) || (paramLong4 == 127L)) && (paramPbSendMsgResp != null) && (paramPbSendMsgResp.errmsg.has()))
    {
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramPbSendMsgResp.errmsg.get(), 1001, false, false);
      paramFromServiceMsg.setMsgFail();
      paramPbSendMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramLong4 != 100L) {
        break label326;
      }
    }
    label326:
    for (paramString2 = "0";; paramString2 = "1")
    {
      ReportController.b(paramPbSendMsgResp, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, paramString2, "" + paramInt3, "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramLong3);
      a(paramToServiceMsg, paramFromServiceMsg, paramString1, paramInt1, paramInt2);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if (paramOffLineFileInfo == null) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + paramOffLineFileInfo.b);
      }
      if (paramOffLineFileInfo.b == 6)
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
        return;
      }
      if (paramOffLineFileInfo.b == 2)
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
        return;
      }
    } while (paramOffLineFileInfo.b != 1);
    b(paramToServiceMsg, paramFromServiceMsg, paramOffLineFileInfo);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp");
    }
    String str2 = paramToServiceMsg.getServiceCmd();
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    String str1 = paramToServiceMsg.extraData.getString("uin");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int i = 0;
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:" + str2 + "----replyCode:" + i + ",sendC2CMessage resp : peerUin:" + str1 + ",msgSeq:" + l + ",transc2ccmd:" + k);
        }
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
        if (paramFromServiceMsg != null) {
          break label314;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:" + str2 + ",no SendMessageHandler found.");
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp::invalid.", paramObject);
        }
        paramObject = null;
        continue;
        if (paramObject.result.get() != 0) {
          i = paramObject.result.get();
        }
      }
    }
    label314:
    if (i == 255) {}
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
        paramFromServiceMsg.getClass();
        if (paramObject.a(paramFromServiceMsg, "server")) {
          break;
        }
      }
      a(paramToServiceMsg, l, str1, k, i);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, int paramInt1, int paramInt2)
  {
    if (529 == paramInt1) {
      switch (paramInt2)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + paramInt2);
        }
        break;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramToServiceMsg, paramFromServiceMsg);
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
          } while (!QLog.isColorLevel());
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
          return;
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file fail");
        }
        long l = paramToServiceMsg.extraData.getLong("sessionid");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().b(l);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync fail");
      return;
    }
    QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + paramInt1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString1, String paramString2, int paramInt1, int paramInt2, msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    if (529 == paramInt1) {
      switch (paramInt2)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + paramInt2);
        }
        break;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramString1, paramToServiceMsg.extraData.getLong("sessionid"), true);
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramToServiceMsg, paramFromServiceMsg);
            return;
            if (paramPbSendMsgResp.send_time.has()) {
              a(paramString2 + String.valueOf(paramPbSendMsgResp.send_time.get()));
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
          } while (!QLog.isColorLevel());
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  suc");
          return;
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt suc");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file suc");
        }
        long l = paramToServiceMsg.extraData.getLong("sessionid");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a(l);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync suc");
      return;
    }
    QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + paramInt1);
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    im_msg_body.RichText localRichText;
    Object localObject1;
    int i;
    if (!paramPbSendMsgReq.msg_body.rich_text.has())
    {
      localRichText = new im_msg_body.RichText();
      localObject1 = new generalflags.ResvAttr();
      i = 0;
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject2;
        if (i < localRichText.elems.size())
        {
          localObject2 = (im_msg_body.Elem)localRichText.elems.get(i);
          if ((!((im_msg_body.Elem)localObject2).general_flags.has()) || (!((im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject2).general_flags.get()).bytes_pb_reserve.has())) {}
        }
        else
        {
          try
          {
            ((generalflags.ResvAttr)localObject1).mergeFrom(((im_msg_body.Elem)localObject2).general_flags.bytes_pb_reserve.get().toByteArray());
            localRichText.elems.remove(i);
            ((generalflags.ResvAttr)localObject1).uint32_device_type.set(QFileAssistantUtils.a());
            localObject2 = new im_msg_body.GeneralFlags();
            ((im_msg_body.GeneralFlags)localObject2).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((generalflags.ResvAttr)localObject1).toByteArray()));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).general_flags.set((MessageMicro)localObject2);
            localRichText.elems.add((MessageMicro)localObject1);
            paramPbSendMsgReq.msg_body.rich_text.set(localRichText);
            return;
            localRichText = (im_msg_body.RichText)paramPbSendMsgReq.msg_body.rich_text.get();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
          }
        }
      }
      i += 1;
    }
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    if (paramFMTransC2CMsgInfo.entity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("IMG_FILE_QR", 1, "add image QrInfo , info is null, maybe is not qr image");
      }
    }
    for (;;)
    {
      return;
      paramFMTransC2CMsgInfo = JumpShareUtils.a(paramFMTransC2CMsgInfo.entity.getFilePath(), paramFMTransC2CMsgInfo.entity.imgWidth, paramFMTransC2CMsgInfo.entity.imgHeight, paramFMTransC2CMsgInfo.entity.strQRUrl);
      if (paramFMTransC2CMsgInfo != null)
      {
        paramPbSendMsgReq.msg_ctrl.set(paramFMTransC2CMsgInfo);
        try
        {
          if (QLog.isColorLevel())
          {
            if (paramFMTransC2CMsgInfo.resv_resv_info.has())
            {
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_flag:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_flag.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint64_reserv2:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint64_reserv2.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint64_reserv3:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint64_reserv3.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_create_time:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_create_time.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_pic_width:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_pic_width.get());
              QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_pic_height:" + ((msg_ctrl.ResvResvInfo)paramFMTransC2CMsgInfo.resv_resv_info.get()).uint32_pic_height.get());
              return;
            }
            QLog.i("IMG_FILE_QR", 1, "eqFeeds without ImageInfo");
            return;
          }
        }
        catch (Throwable paramPbSendMsgReq) {}
      }
    }
  }
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, TransMsgContext paramTransMsgContext)
  {
    if ((paramFMTransC2CMsgInfo == null) || (paramFMTransC2CMsgInfo.entity == null)) {
      return;
    }
    paramFMTransC2CMsgInfo = paramFMTransC2CMsgInfo.entity;
    msg_svc.RoutingHead localRoutingHead = paramPbSendMsgReq.routing_head;
    int i = (int)paramFMTransC2CMsgInfo.tmpSessionType;
    switch (i)
    {
    default: 
      return;
    case 100: 
      e(paramFMTransC2CMsgInfo, localRoutingHead);
    }
    for (;;)
    {
      if ((paramTransMsgContext != null) && (paramTransMsgContext.jdField_a_of_type_ArrayOfByte != null)) {
        break label195;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession Bug msgContext or msgContext.msg null!");
      return;
      g(paramFMTransC2CMsgInfo, localRoutingHead);
      continue;
      f(paramFMTransC2CMsgInfo, localRoutingHead);
      continue;
      d(paramFMTransC2CMsgInfo, localRoutingHead);
      continue;
      c(paramFMTransC2CMsgInfo, localRoutingHead);
      continue;
      b(paramFMTransC2CMsgInfo, localRoutingHead);
      continue;
      a(paramFMTransC2CMsgInfo, localRoutingHead);
    }
    label195:
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession msg0x211[" + i + "]");
    }
    localRoutingHead.trans_0x211.setHasFlag(false);
    paramPbSendMsgReq.msg_body.msg_content.setHasFlag(false);
    paramPbSendMsgReq.msg_body.rich_text.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.bytes_msg_body.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.uint32_c2c_cmd.set(4);
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
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSendOfflineFileResp-->handleError");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5004, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp");
    }
    Object localObject1 = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("queueSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str1 = paramToServiceMsg.extraData.getString("uin");
    String str2 = paramToServiceMsg.extraData.getString("uuid");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int m = paramToServiceMsg.extraData.getInt("busiType");
    long l4 = paramToServiceMsg.extraData.getLong("tmpSessionType");
    int i = 0;
    Object localObject2 = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject2).mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject1 + "----replyCode:" + i + ",sendC2CMessage resp : peerUin:" + str1 + ",uniseq:" + l1 + ",msgSeq:" + l3 + ",transc2ccmd:" + k);
        }
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
        if (localObject2 != null) {
          break label387;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject1 + ",no SendMessageHandler found.");
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp::invalid.", paramObject);
        }
        paramObject = null;
        continue;
        if (paramObject.result.get() != 0) {
          i = paramObject.result.get();
        }
      }
    }
    label387:
    if (i == 255) {}
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
        localObject2.getClass();
        if (((MessageHandler)localObject1).a((SendMessageHandler)localObject2, "server")) {
          break;
        }
      }
      a(paramToServiceMsg, paramFromServiceMsg, l1, l2, l3, str1, str2, k, m, l4, i, paramObject);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, int paramInt1, int paramInt2)
  {
    if (529 == paramInt1) {
      switch (paramInt2)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + paramInt2);
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramString, paramToServiceMsg.extraData.getLong("sessionid"), false);
          return;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramToServiceMsg, paramFromServiceMsg);
          return;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExError : qlink send file state fail");
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
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "handleSetOfflineFileState-->handleError");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5005, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
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
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    StatictisInfo localStatictisInfo = new StatictisInfo();
    localStatictisInfo.b = paramFromServiceMsg.getResultCode();
    localStatictisInfo.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5003, true, new Object[] { paramOffLineFileInfo.jdField_a_of_type_ArrayOfByte, localStatictisInfo });
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
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramFileManagerEntity.tmpSessionRelatedUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + paramFileManagerEntity.tmpSessionRelatedUin + "]");
      }
    }
    paramRoutingHead.grp_tmp.group_uin.set(l1);
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
      for (;;)
      {
        QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + paramFileManagerEntity.tmpSessionRelatedUin + "]");
      }
    }
    paramRoutingHead.dis_tmp.dis_uin.set(l1);
    paramRoutingHead.dis_tmp.to_uin.set(Long.parseLong(paramFileManagerEntity.peerUin));
    paramRoutingHead.dis_tmp.setHasFlag(true);
    paramRoutingHead.setHasFlag(true);
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
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
    case 7001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (MessageFactoryReceiver.OffLineFileInfo)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 7002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel()) {
      QLog.d("wk", 2, "handleReqOffFilePackError, count: " + i);
    }
    if (i < 2)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.send(paramToServiceMsg);
    }
    StatictisInfo localStatictisInfo;
    do
    {
      return;
      localStatictisInfo = new StatictisInfo();
      localStatictisInfo.b = paramFromServiceMsg.getResultCode();
      localStatictisInfo.c = i;
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localStatictisInfo.b = 2900;
        localStatictisInfo.jdField_a_of_type_Long = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
      }
      MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      localStatictisInfo.jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 3006, false, paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
        return;
      }
    } while (paramToServiceMsg.extraData.getInt("offfile_type") != 3);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 20) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
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
    switch (paramInt)
    {
    default: 
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><E><---handleSendTransMessageError: ---cmd:" + (String)localObject + ",sendC2CMessage error : peerUin:" + str + ",msgSeq:" + l1 + ",transc2ccmd:" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label192;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageError, msf said:RESNDMSG");
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      localObject.getClass();
      if (!paramFromServiceMsg.a((SendMessageHandler)localObject, "msf")) {
        break label192;
      }
    }
    label192:
    do
    {
      do
      {
        return;
      } while ((480000L != l2) && (!((SendMessageHandler)localObject).a()));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
      if (133 == i)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
        return;
      }
    } while (135 != i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><E><---handleSendTransMessageExError: ---cmd:" + (String)localObject + ",sendC2CMessage error : peerUin:" + str + ",uniseq:" + l1 + ",msgSeq:" + l3 + ",transc2ccmd:" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExError, msf said:RESNDMSG");
      }
      MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      localObject.getClass();
      if (!localMessageHandler.a((SendMessageHandler)localObject, "msf")) {
        break label241;
      }
    }
    label241:
    while ((480000L != l4) && (!((SendMessageHandler)localObject).a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
    b(paramToServiceMsg, paramFromServiceMsg, str, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OfflineFileMessageProcessor
 * JD-Core Version:    0.7.0.1
 */