import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp;

class auiq
  implements bmsc<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp>
{
  auiq(auie paramauie, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a + "]strFileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c + "]errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    auie.a(this.jdField_a_of_type_Auie).getFileManagerNotifyCenter().a(false, 20, new Object[] { Integer.valueOf(paramInt), paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c, Boolean.valueOf(false) });
  }
  
  public void a(WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a + "]strFileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c + "]");
    }
    auie.a(this.jdField_a_of_type_Auie).getFileManagerNotifyCenter().a(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiq
 * JD-Core Version:    0.7.0.1
 */