import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class bcuw
  extends bcup
{
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private zsa jdField_a_of_type_Zsa = new bcux(this);
  
  public bcuw(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  private FileManagerEntity a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null) || (paramString2.length() == 0)) {
      paramQQAppInterface = null;
    }
    Object localObject;
    do
    {
      do
      {
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.getFileManagerProxy();
        localObject = paramQQAppInterface.c();
        if (localObject == null) {
          paramQQAppInterface.a();
        }
        if (localObject == null) {
          return null;
        }
        paramQQAppInterface = ((List)localObject).iterator();
        do
        {
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
          localObject = (FileManagerEntity)paramQQAppInterface.next();
        } while ((((FileManagerEntity)localObject).peerUin == null) || (!TextUtils.equals(paramString1, ((FileManagerEntity)localObject).strTroopFileID)) || (!((FileManagerEntity)localObject).peerUin.equals(paramString2)));
        paramQQAppInterface = (QQAppInterface)localObject;
      } while (((FileManagerEntity)localObject).cloudType != 1);
      paramQQAppInterface = (QQAppInterface)localObject;
    } while (!aszt.a((FileManagerEntity)localObject));
    ((FileManagerEntity)localObject).status = 16;
    return localObject;
    return null;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while ((TextUtils.isEmpty(paramJSONObject.optString("groupuin"))) || (TextUtils.isEmpty(paramJSONObject.optString("businesstype")))) {
      return false;
    }
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (paramQQAppInterface != null))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d)) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString))) {
        break label417;
      }
      Object localObject = new bebc();
      ((bebc)localObject).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d.getBytes());
      ((bebc)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d;
      ((bebc)localObject).c = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString;
      ((bebc)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int;
      localObject = new TroopFileTransferManager.Item((bebc)localObject);
      ((TroopFileTransferManager.Item)localObject).FileName = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString;
      zrj.a(paramQQAppInterface, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString).longValue(), (TroopFileTransferManager.Item)localObject, 0, false, false, this.jdField_a_of_type_Zsa);
      localObject = paramQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Long);
      if (localObject == null) {
        break label404;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().b(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Long);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFileID, ((MessageRecord)localObject).frienduin);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Long);
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bcum.f(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      }
      this.jdField_a_of_type_Bcum.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      return;
      label404:
      QLog.w("TeamWorkFileImportJobForGroup", 2, "can not find message");
      i = j;
      continue;
      label417:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuw
 * JD-Core Version:    0.7.0.1
 */