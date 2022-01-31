import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class ayer
{
  protected ayeo a;
  TeamWorkFileImportInfo a;
  
  public ayer(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Ayeo = ((ayeo)paramQQAppInterface.a(120));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  protected void a(boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (bbdj.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportJob", 2, "---notifyUIFailed try local fileName: " + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
      }
      this.jdField_a_of_type_Ayeo.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a = false;
      this.jdField_a_of_type_Ayeo.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_Ayeo.f(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    for (;;)
    {
      if (i != 0) {
        this.jdField_a_of_type_Ayeo.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      }
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayer
 * JD-Core Version:    0.7.0.1
 */