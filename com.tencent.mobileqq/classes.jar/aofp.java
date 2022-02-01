import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
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
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Trans211TmpMsg;

public class aofp
  extends acvl
{
  ArrayList<String> a;
  
  public aofp(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bbyy parambbyy)
  {
    if (parambbyy == null) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + parambbyy.b);
      }
      if (parambbyy.b == 6)
      {
        d(paramToServiceMsg, paramFromServiceMsg, parambbyy);
        return;
      }
      if (parambbyy.b == 2)
      {
        c(paramToServiceMsg, paramFromServiceMsg, parambbyy);
        return;
      }
    } while (parambbyy.b != 1);
    b(paramToServiceMsg, paramFromServiceMsg, parambbyy);
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
          break label297;
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
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp::invalid.", paramObject);
        }
        paramObject = null;
        continue;
        if (paramObject.result.get() != 0)
        {
          i = paramObject.result.get();
          continue;
          label297:
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
            if ((i != 0) && (i != 241)) {
              break label469;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send successfully.");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
            if (133 == k) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, paramToServiceMsg.extraData.getLong("sessionid"), true);
            }
            if (135 != k) {
              break label436;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, paramToServiceMsg.extraData.getLong("sessionid"), true);
            return;
          }
          label436:
          if (QLog.isColorLevel())
          {
            QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : can not handle transc2ccmd:" + k);
            return;
            label469:
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send failed:" + i + ", transc2ccmd:" + k);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
            if (133 == k)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, paramToServiceMsg.extraData.getLong("sessionid"), false);
              return;
            }
            if (135 == k) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, paramToServiceMsg.extraData.getLong("sessionid"), false);
            }
          }
        }
        else
        {
          i = 0;
        }
      }
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
      paramFMTransC2CMsgInfo = auxv.a(paramFMTransC2CMsgInfo.entity.getFilePath(), paramFMTransC2CMsgInfo.entity.imgWidth, paramFMTransC2CMsgInfo.entity.imgHeight, paramFMTransC2CMsgInfo.entity.strQRUrl);
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
  
  private void a(msg_svc.PbSendMsgReq paramPbSendMsgReq, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, bbzm parambbzm)
  {
    long l1 = 0L;
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
      localRoutingHead.accost_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.accost_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.accost_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
    }
    for (;;)
    {
      if ((parambbzm != null) && (parambbzm.jdField_a_of_type_ArrayOfByte != null)) {
        break label786;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession Bug msgContext or msgContext.msg null!");
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "addTempSessionData add disctmp Info");
      }
      long l2;
      try
      {
        l2 = Long.parseLong(paramFMTransC2CMsgInfo.tmpSessionRelatedUin);
        l1 = l2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + paramFMTransC2CMsgInfo.tmpSessionRelatedUin + "]");
        }
      }
      localRoutingHead.dis_tmp.dis_uin.set(l1);
      localRoutingHead.dis_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      localRoutingHead.dis_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      try
      {
        l2 = Long.parseLong(paramFMTransC2CMsgInfo.tmpSessionRelatedUin);
        l1 = l2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + paramFMTransC2CMsgInfo.tmpSessionRelatedUin + "]");
        }
      }
      localRoutingHead.grp_tmp.group_uin.set(l1);
      localRoutingHead.grp_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      localRoutingHead.grp_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.comm_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.comm_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.comm_tmp.c2c_type.set(1);
      localRoutingHead.comm_tmp.svr_type.set(149);
      localRoutingHead.comm_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.nearby_dating_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.nearby_dating_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.nearby_dating_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      if (paramFMTransC2CMsgInfo.tmpSessionFromPhone == null) {
        paramFMTransC2CMsgInfo.tmpSessionFromPhone = "";
      }
      localRoutingHead.address_list.from_phone.set(paramFMTransC2CMsgInfo.tmpSessionFromPhone);
      if (paramFMTransC2CMsgInfo.tmpSessionToPhone == null) {
        paramFMTransC2CMsgInfo.tmpSessionToPhone = "";
      }
      localRoutingHead.address_list.to_phone.set(paramFMTransC2CMsgInfo.tmpSessionToPhone);
      String str = paramFMTransC2CMsgInfo.peerUin.replace("+", "");
      localRoutingHead.address_list.to_uin.set(Long.parseLong(str));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.address_list.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.address_list.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
      continue;
      localRoutingHead.business_wpa_tmp.to_uin.set(Long.parseLong(paramFMTransC2CMsgInfo.peerUin));
      if ((paramFMTransC2CMsgInfo.tmpSessionSig != null) && (paramFMTransC2CMsgInfo.tmpSessionSig.length > 0)) {
        localRoutingHead.business_wpa_tmp.sig.set(ByteStringMicro.copyFrom(paramFMTransC2CMsgInfo.tmpSessionSig));
      }
      localRoutingHead.business_wpa_tmp.setHasFlag(true);
      localRoutingHead.setHasFlag(true);
    }
    label786:
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession msg0x211[" + i + "]");
    }
    localRoutingHead.trans_0x211.setHasFlag(false);
    paramPbSendMsgReq.msg_body.msg_content.setHasFlag(false);
    paramPbSendMsgReq.msg_body.rich_text.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.setHasFlag(true);
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.bytes_msg_body.set(ByteStringMicro.copyFrom(parambbzm.jdField_a_of_type_ArrayOfByte));
    paramPbSendMsgReq.msg_body.rich_text.trans_211_tmp_msg.uint32_c2c_cmd.set(4);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bbyy parambbyy)
  {
    if ((parambbyy == null) || (parambbyy.jdField_a_of_type_Long != 0L))
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
    anqe localanqe = new anqe();
    localanqe.b = paramFromServiceMsg.getResultCode();
    localanqe.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5004, true, new Object[] { parambbyy, localanqe });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp");
    }
    Object localObject2 = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("queueSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    String str = paramToServiceMsg.extraData.getString("uin");
    Object localObject1 = paramToServiceMsg.extraData.getString("uuid");
    int k = paramToServiceMsg.extraData.getInt("transC2CCmd");
    int m = paramToServiceMsg.extraData.getInt("busiType");
    long l4 = paramToServiceMsg.extraData.getLong("tmpSessionType");
    Object localObject3 = new msg_svc.PbSendMsgResp();
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject3).mergeFrom((byte[])paramObject);
      label329:
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject2 + "----replyCode:" + i + ",sendC2CMessage resp : peerUin:" + str + ",uniseq:" + l1 + ",msgSeq:" + l3 + ",transc2ccmd:" + k);
        }
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
        if (localObject3 != null) {
          break label374;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + (String)localObject2 + ",no SendMessageHandler found.");
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp::invalid.", paramObject);
        }
        paramObject = null;
        continue;
        if (paramObject.result.get() != 0)
        {
          i = paramObject.result.get();
          continue;
          label374:
          if (i == 255) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
              localObject3.getClass();
              if (((MessageHandler)localObject2).a((SendMessageHandler)localObject3, "server")) {
                break;
              }
            }
            if ((i != 0) && (i != 241)) {
              break label848;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send successfully.");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
            if ((paramObject.send_time.has()) && (l1 != 0L))
            {
              l2 = 0xFFFFFFFF & paramObject.send_time.get();
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, 0, l1, l2);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "updateSendTransMsgTime: sendBuddyPb: respData.uSendTime:" + l2 + ",peerUin:" + str);
              }
            }
            if (529 != k) {
              break label814;
            }
            switch (m)
            {
            case 1026: 
            case 1027: 
            case 1030: 
            case 1031: 
            default: 
              if (!QLog.isColorLevel()) {
                break label329;
              }
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + m);
              return;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, paramToServiceMsg.extraData.getLong("sessionid"), true);
          return;
          if (paramObject.send_time.has()) {
            a((String)localObject1 + String.valueOf(paramObject.send_time.get()));
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  suc");
            return;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt suc");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file suc");
              }
              l1 = paramToServiceMsg.extraData.getLong("sessionid");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
              return;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync suc");
                return;
                label814:
                if (QLog.isColorLevel())
                {
                  QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + k);
                  return;
                  label848:
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send failed:" + i + ", transc2ccmd:" + k);
                  }
                  if (((l4 == 100L) || (l4 == 127L)) && (paramObject != null) && (paramObject.errmsg.has()))
                  {
                    aoey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramObject.errmsg.get(), 1001, false, false);
                    paramFromServiceMsg.setMsgFail();
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                    if (l4 != 100L) {
                      break label1122;
                    }
                  }
                  label1122:
                  for (paramObject = "0";; paramObject = "1")
                  {
                    bcst.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, paramObject, "" + i, "", "");
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
                    if (529 != k) {
                      break label1260;
                    }
                    switch (m)
                    {
                    case 1026: 
                    case 1027: 
                    case 1030: 
                    case 1031: 
                    default: 
                      if (!QLog.isColorLevel()) {
                        break label329;
                      }
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + m);
                      return;
                    }
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
                  return;
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
                    return;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
                      return;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file fail");
                      }
                      l1 = paramToServiceMsg.extraData.getLong("sessionid");
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l1);
                      return;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync fail");
                        return;
                        label1260:
                        if (QLog.isColorLevel()) {
                          QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + k);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bbyy parambbyy)
  {
    if ((parambbyy == null) || (parambbyy.jdField_a_of_type_Long != 0L))
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
    anqe localanqe = new anqe();
    localanqe.b = paramFromServiceMsg.getResultCode();
    localanqe.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5005, true, new Object[] { parambbyy, localanqe });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bbyy parambbyy)
  {
    if (parambbyy == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    anqe localanqe = new anqe();
    localanqe.b = paramFromServiceMsg.getResultCode();
    localanqe.c = i;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5003, true, new Object[] { parambbyy.jdField_a_of_type_ArrayOfByte, localanqe });
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
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (bbyy)paramVarArgs[2]);
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
    anqe localanqe;
    do
    {
      return;
      localanqe = new anqe();
      localanqe.b = paramFromServiceMsg.getResultCode();
      localanqe.c = i;
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localanqe.b = 2900;
        localanqe.jdField_a_of_type_Long = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
      }
      MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      localanqe.jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 3006, false, paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localanqe });
        return;
      }
      if (paramToServiceMsg.extraData.getInt("offfile_type") == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localanqe });
        return;
      }
    } while (paramToServiceMsg.extraData.getInt("offfile_type") != 3);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localanqe });
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
    int i = bbxc.a;
    bbxc.a = i + 1;
    long l = i;
    paramFMTransC2CMsgInfo.queueSeq = l;
    a(true, true, true, l, new aofq(this, paramString, paramFMTransC2CMsgInfo, paramInt, paramArrayOfByte));
    return true;
  }
  
  public boolean a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    int i = bbxc.a;
    bbxc.a = i + 1;
    long l = i;
    a(true, true, true, l, new aofr(this, paramString, paramLong, Math.abs(new Random().nextInt()), l, paramInt, paramArrayOfByte));
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
        break label187;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageError, msf said:RESNDMSG");
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      localObject.getClass();
      if (!paramFromServiceMsg.a((SendMessageHandler)localObject, "msf")) {
        break label187;
      }
    }
    label187:
    do
    {
      do
      {
        return;
      } while ((480000L != l2) && (!((SendMessageHandler)localObject).a()));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
      if (133 == i)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
        return;
      }
    } while (135 != i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
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
        break label236;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExError, msf said:RESNDMSG");
      }
      MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      localObject.getClass();
      if (!localMessageHandler.a((SendMessageHandler)localObject, "msf")) {
        break label236;
      }
    }
    label236:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((480000L != l4) && (!((SendMessageHandler)localObject).a()));
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2);
            if (529 != i) {
              break;
            }
            switch (j)
            {
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + j);
          return;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, paramToServiceMsg.extraData.getLong("sessionid"), false);
          return;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, paramFromServiceMsg, paramToServiceMsg.extraData.getLong("sessionid"));
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExError : qlink send file state fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofp
 * JD-Core Version:    0.7.0.1
 */