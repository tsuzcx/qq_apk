import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

final class aqpl
  implements arrh
{
  aqpl(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, arhw paramarhw) {}
  
  public void a()
  {
    Object localObject = arrr.b(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe resoved ,recreateFilePath[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    bdhb.c(this.b, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.a((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = arrr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.b);
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.setFilePath((String)localObject);
      localFileManagerEntity.fileName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin);
      if (localObject != null) {
        ((TroopFileTransferManager)localObject).a(localFileManagerEntity.strTroopFileID, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
    }
    arrr.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    if (this.jdField_a_of_type_Arhw != null) {
      this.jdField_a_of_type_Arhw.a();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpl
 * JD-Core Version:    0.7.0.1
 */