import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class aqxa
  implements bklf
{
  aqxa(aqwt paramaqwt, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, bkkq parambkkq, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (parambkkq.jdField_a_of_type_Int == 2) {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
        }
      }
      do
      {
        return;
        if (parambkkq.jdField_a_of_type_Int == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
          }
          paramString = new Bundle();
          paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
          paramString.putInt("errorCode", parambkkq.jdField_b_of_type_Int);
          paramString.putString("errorMsg", parambkkq.jdField_a_of_type_JavaLangString);
          QIPCServerHelper.getInstance().callClient(arbl.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", paramString, null);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.c, this.jdField_a_of_type_Aqwt.e, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 36, null, parambkkq.jdField_b_of_type_Int, parambkkq.jdField_a_of_type_JavaLangString);
          return;
        }
      } while (parambkkq.jdField_a_of_type_Int != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
      }
      paramString = new Bundle();
      paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
      paramString.putString("filePath", parambkkq.jdField_b_of_type_JavaLangString);
      QIPCServerHelper.getInstance().callClient(arbl.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(parambkkq.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.c, this.jdField_a_of_type_Aqwt.e, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 35, null, 0, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
    }
    paramString = new Bundle();
    paramString.putString("taskId", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.miniAppDownloadId);
    paramString.putInt("progress", (int)((float)parambkkq.jdField_b_of_type_Long / (float)parambkkq.jdField_a_of_type_Long * 100.0F));
    paramString.putLong("currSize", parambkkq.jdField_b_of_type_Long);
    paramString.putLong("totalSize", parambkkq.jdField_a_of_type_Long);
    QIPCServerHelper.getInstance().callClient(arbl.jdField_a_of_type_JavaLangString, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", paramString, null);
    this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long / (float)this.jdField_a_of_type_Aqwt.d);
    this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.c, this.jdField_a_of_type_Aqwt.e, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxa
 * JD-Core Version:    0.7.0.1
 */