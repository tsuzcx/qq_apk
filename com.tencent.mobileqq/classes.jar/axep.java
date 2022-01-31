import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class axep
{
  protected axem a;
  TeamWorkFileImportInfo a;
  
  public axep(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Axem = ((axem)paramQQAppInterface.a(120));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  protected void a(boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (bace.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportJob", 2, "---notifyUIFailed try local fileName: " + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
      }
      this.jdField_a_of_type_Axem.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a = false;
      this.jdField_a_of_type_Axem.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_Axem.f(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    for (;;)
    {
      if (i != 0) {
        this.jdField_a_of_type_Axem.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      }
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axep
 * JD-Core Version:    0.7.0.1
 */