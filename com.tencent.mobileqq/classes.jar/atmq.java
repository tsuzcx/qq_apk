import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

final class atmq
  implements aumz
{
  atmq(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, auef paramauef) {}
  
  public void a()
  {
    Object localObject = aunj.b(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe resoved ,recreateFilePath[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    bhmi.c(this.b, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aunj.a((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
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
    aunj.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    if (this.jdField_a_of_type_Auef != null) {
      this.jdField_a_of_type_Auef.a();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmq
 * JD-Core Version:    0.7.0.1
 */