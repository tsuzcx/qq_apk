import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;

class aqws
  implements bkgc<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  aqws(aqwl paramaqwl, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    aqwl.a(this.jdField_a_of_type_Aqwl).a().a();
    aqwl.a(this.jdField_a_of_type_Aqwl).a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    aqwl.a(this.jdField_a_of_type_Aqwl).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, 1005);
    aqwl.a(this.jdField_a_of_type_Aqwl).a().a(false, 33, new Object[] { Integer.valueOf(paramInt), paramString, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
    arni.a(aqwl.a(this.jdField_a_of_type_Aqwl), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", "", paramInt, paramString, 0L, 0L, 0L, "", "", 0, paramString, null);
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^! [CS Replay]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]sendWyFile2Offline onSucceed,But uuid is null!!!");
      aqwl.a(this.jdField_a_of_type_Aqwl).a().a(false, 33, new Object[] { Integer.valueOf(13), "", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
      arni.a(aqwl.a(this.jdField_a_of_type_Aqwl), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, "onSucceed but guid null", 0L, 0L, 0L, "", "", 0, "onSucceed but guid null", null);
      return;
    }
    QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^ [CS Replay] Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]sendWyFile2Offline onSucceed, Uuid[" + paramCrossBidProxyCopyFileToOtherBidMsgRsp + "]");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramCrossBidProxyCopyFileToOtherBidMsgRsp;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
    aqwl.a(this.jdField_a_of_type_Aqwl).a().a();
    aqwl.a(this.jdField_a_of_type_Aqwl).a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    arni.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^ [CS Replay]->[CC] Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]sendWyFile2Offline onSucceed, entity thumbSize(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + ":" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ")");
    if (this.jdField_a_of_type_Int == 3000)
    {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^ [Disc Feed]sendDiscFileFeed[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
      aqwl.a(this.jdField_a_of_type_Aqwl).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, aqwl.a(this.jdField_a_of_type_Aqwl).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, null);
    }
    for (;;)
    {
      aqwl.a(this.jdField_a_of_type_Aqwl).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 8, "");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = new arnh();
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.b = "send_file_suc";
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.jdField_a_of_type_Int = 1;
      arng.a(aqwl.a(this.jdField_a_of_type_Aqwl).getCurrentAccountUin(), paramCrossBidProxyCopyFileToOtherBidMsgRsp);
      arni.a(aqwl.a(this.jdField_a_of_type_Aqwl), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin.replace("+", "");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^ [Offline CC]sendC2COfflineFileMsg[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
      aqwl.a(this.jdField_a_of_type_Aqwl).a().a(paramCrossBidProxyCopyFileToOtherBidMsgRsp, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqws
 * JD-Core Version:    0.7.0.1
 */