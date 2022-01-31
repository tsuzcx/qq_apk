import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class aozt
  implements bifc
{
  aozt(aozm paramaozm, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, bien parambien, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (parambien.jdField_a_of_type_Int == 2) {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
        }
      }
      do
      {
        return;
        if (parambien.jdField_a_of_type_Int == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
          }
          paramString = new Bundle();
          paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
          paramString.putInt("errorCode", parambien.jdField_b_of_type_Int);
          paramString.putString("errorMsg", parambien.jdField_a_of_type_JavaLangString);
          QIPCServerHelper.getInstance().callClient(apee.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", paramString, null);
          this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
          this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aozm.jdField_b_of_type_Long, this.jdField_a_of_type_Aozm.c, this.jdField_a_of_type_Aozm.e, this.jdField_a_of_type_Aozm.jdField_a_of_type_Int, 36, null, parambien.jdField_b_of_type_Int, parambien.jdField_a_of_type_JavaLangString);
          return;
        }
      } while (parambien.jdField_a_of_type_Int != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
      }
      paramString = new Bundle();
      paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
      paramString.putString("filePath", parambien.jdField_b_of_type_JavaLangString);
      QIPCServerHelper.getInstance().callClient(apee.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(parambien.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apug.a(this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aozm.jdField_b_of_type_Long, this.jdField_a_of_type_Aozm.c, this.jdField_a_of_type_Aozm.e, this.jdField_a_of_type_Aozm.jdField_a_of_type_Int, 35, null, 0, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
    }
    paramString = new Bundle();
    paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
    paramString.putInt("progress", (int)((float)parambien.jdField_b_of_type_Long / (float)parambien.jdField_a_of_type_Long * 100.0F));
    paramString.putLong("currSize", parambien.jdField_b_of_type_Long);
    paramString.putLong("totalSize", parambien.jdField_a_of_type_Long);
    QIPCServerHelper.getInstance().callClient(apee.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", paramString, null);
    this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Aozm.jdField_a_of_type_Long / (float)this.jdField_a_of_type_Aozm.d);
    this.jdField_a_of_type_Aozm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aozm.jdField_b_of_type_Long, this.jdField_a_of_type_Aozm.c, this.jdField_a_of_type_Aozm.e, this.jdField_a_of_type_Aozm.jdField_a_of_type_Int, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozt
 * JD-Core Version:    0.7.0.1
 */