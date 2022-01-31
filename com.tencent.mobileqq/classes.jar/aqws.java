import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqws
  implements aqxn
{
  aqws(aqwp paramaqwp, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] init cancel!");
  }
  
  public void b()
  {
    QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] init success, start video download");
    new arix(this.jdField_a_of_type_Aqwp.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {}
    for (Object localObject = new arja(this.jdField_a_of_type_Aqwp.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);; localObject = new arix(this.jdField_a_of_type_Aqwp.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))
    {
      aqxi.a((arit)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqws
 * JD-Core Version:    0.7.0.1
 */