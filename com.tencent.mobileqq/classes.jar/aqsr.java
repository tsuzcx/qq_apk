import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class aqsr
  implements bkgy
{
  aqsr(aqsk paramaqsk, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, bkgj parambkgj, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (parambkgj.jdField_a_of_type_Int == 2) {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
        }
      }
      do
      {
        return;
        if (parambkgj.jdField_a_of_type_Int == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
          }
          paramString = new Bundle();
          paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
          paramString.putInt("errorCode", parambkgj.jdField_b_of_type_Int);
          paramString.putString("errorMsg", parambkgj.jdField_a_of_type_JavaLangString);
          QIPCServerHelper.getInstance().callClient(aqxc.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", paramString, null);
          this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
          this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqsk.jdField_b_of_type_Long, this.jdField_a_of_type_Aqsk.c, this.jdField_a_of_type_Aqsk.e, this.jdField_a_of_type_Aqsk.jdField_a_of_type_Int, 36, null, parambkgj.jdField_b_of_type_Int, parambkgj.jdField_a_of_type_JavaLangString);
          return;
        }
      } while (parambkgj.jdField_a_of_type_Int != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
      }
      paramString = new Bundle();
      paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
      paramString.putString("filePath", parambkgj.jdField_b_of_type_JavaLangString);
      QIPCServerHelper.getInstance().callClient(aqxc.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(parambkgj.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arni.a(this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqsk.jdField_b_of_type_Long, this.jdField_a_of_type_Aqsk.c, this.jdField_a_of_type_Aqsk.e, this.jdField_a_of_type_Aqsk.jdField_a_of_type_Int, 35, null, 0, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
    }
    paramString = new Bundle();
    paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
    paramString.putInt("progress", (int)((float)parambkgj.jdField_b_of_type_Long / (float)parambkgj.jdField_a_of_type_Long * 100.0F));
    paramString.putLong("currSize", parambkgj.jdField_b_of_type_Long);
    paramString.putLong("totalSize", parambkgj.jdField_a_of_type_Long);
    QIPCServerHelper.getInstance().callClient(aqxc.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", paramString, null);
    this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Aqsk.jdField_a_of_type_Long / (float)this.jdField_a_of_type_Aqsk.d);
    this.jdField_a_of_type_Aqsk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqsk.jdField_b_of_type_Long, this.jdField_a_of_type_Aqsk.c, this.jdField_a_of_type_Aqsk.e, this.jdField_a_of_type_Aqsk.jdField_a_of_type_Int, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsr
 * JD-Core Version:    0.7.0.1
 */