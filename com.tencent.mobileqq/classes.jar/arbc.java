import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;

class arbc
  implements bkkj<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  arbc(arau paramarau, TroopFileTransferManager paramTroopFileTransferManager, bbtn parambbtn, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.a, paramInt, null, paramString);
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop onSucceed,But uuid is null!!!");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.a, -1, null, alud.a(2131717316));
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop onSucceed, Uuid[" + paramCrossBidProxyCopyFileToOtherBidMsgRsp + "]");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.a, 0, paramCrossBidProxyCopyFileToOtherBidMsgRsp, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbc
 * JD-Core Version:    0.7.0.1
 */