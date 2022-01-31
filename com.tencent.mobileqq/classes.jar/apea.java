import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp;

class apea
  implements bieg<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp>
{
  apea(apdn paramapdn, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a + "]strFileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.c + "]errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    apdn.a(this.jdField_a_of_type_Apdn).a().a(false, 20, new Object[] { Integer.valueOf(paramInt), paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.c, Boolean.valueOf(false) });
  }
  
  public void a(WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a + "]strFileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.c + "]");
    }
    apdn.a(this.jdField_a_of_type_Apdn).a().a(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.c, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apea
 * JD-Core Version:    0.7.0.1
 */