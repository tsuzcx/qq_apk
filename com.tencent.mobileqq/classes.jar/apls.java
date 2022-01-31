import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class apls
  extends aplp
{
  private final String a;
  
  public apls(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_a_of_type_JavaLangString = "VideoForDisc<QFile>";
  }
  
  public void a(apaf paramapaf)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, new aplt(this, paramapaf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apls
 * JD-Core Version:    0.7.0.1
 */