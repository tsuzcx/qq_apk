import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atfe
  implements audq
{
  atfe(atfd paramatfd, FileManagerEntity paramFileManagerEntity) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 3) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0)
      {
        this.jdField_a_of_type_Atfd.a.getOnlineFileSessionCenter().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        return;
      }
      this.jdField_a_of_type_Atfd.a.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0)
    {
      this.jdField_a_of_type_Atfd.a.getOnlineFileSessionCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return;
    }
    this.jdField_a_of_type_Atfd.a.getFileManagerEngine().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfe
 * JD-Core Version:    0.7.0.1
 */