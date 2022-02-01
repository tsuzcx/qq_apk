import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import org.json.JSONObject;

public class beaz
  extends beay
{
  private atrl jdField_a_of_type_Atrl = new beba(this);
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public beaz(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (TextUtils.isEmpty(paramJSONObject.optString("ownertype"))) {
      return false;
    }
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (paramQQAppInterface != null))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString))) {
        break label247;
      }
      MessageRecord localMessageRecord = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Long);
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForFile))) {
        break label226;
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.j = localMessageRecord.senderuin;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = aunj.a(paramQQAppInterface, (MessageForFile)localMessageRecord);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid))) {
        break label247;
      }
      paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, this.jdField_a_of_type_Atrl);
    }
    label226:
    label247:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Beav.f(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      }
      this.jdField_a_of_type_Beav.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaz
 * JD-Core Version:    0.7.0.1
 */