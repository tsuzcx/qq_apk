import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class bebo
{
  protected bebl a;
  TeamWorkFileImportInfo a;
  
  public bebo(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Bebl = ((bebl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  protected void a(boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportJob", 2, "---notifyUIFailed try local fileName: " + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
      }
      this.jdField_a_of_type_Bebl.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a = false;
      this.jdField_a_of_type_Bebl.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_Bebl.f(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    for (;;)
    {
      if (i != 0) {
        this.jdField_a_of_type_Bebl.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      }
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebo
 * JD-Core Version:    0.7.0.1
 */