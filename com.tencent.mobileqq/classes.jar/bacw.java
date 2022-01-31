import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class bacw
  extends bacq
{
  public bacw(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject3;
    String str2;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (paramQQAppInterface != null) && (this.jdField_a_of_type_Bacn != null))
    {
      localObject3 = bacb.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      str2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.n;
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int != 6000)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int != 6003) {}
      }
      else
      {
        localObject2 = "";
        localObject1 = localObject3;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label291;
      }
    }
    for (;;)
    {
      long l2 = 0L;
      int i;
      long l1;
      long l3;
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int == 1)
      {
        i = 3;
        l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString).longValue();
        l2 = 0L;
        l3 = 0L;
      }
      for (;;)
      {
        label122:
        paramQQAppInterface = new JSONObject();
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            paramQQAppInterface.put("fileid", localObject1);
            paramQQAppInterface.put("filename", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
            paramQQAppInterface.put("filesize", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
            paramQQAppInterface.put("filetype", i);
            paramQQAppInterface.put("businesstype", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int);
            paramQQAppInterface.put("groupuin", l1);
            paramQQAppInterface.put("senderuin", l3);
            paramQQAppInterface.put("discussuin", l2);
            if (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_g_of_type_Boolean) {
              continue;
            }
            paramQQAppInterface.put("ownertype", 1);
          }
          catch (JSONException localJSONException)
          {
            label291:
            QLog.e("TeamWorkFileImportJobForFile2Form", 2, "put fileid exception: " + localJSONException.toString());
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_g_of_type_Int != 0) {
              continue;
            }
            this.jdField_a_of_type_Bacn.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
            this.jdField_a_of_type_Bacn.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
            return;
            this.jdField_a_of_type_Bacn.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_g_of_type_Int != 0)) {
            continue;
          }
          this.jdField_a_of_type_Bacn.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
          this.jdField_a_of_type_Bacn.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
          return;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label596;
          }
          if (TextUtils.isEmpty(str2))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c;
            localObject3 = new File((String)localObject1);
            if ((localObject3 == null) || (!((File)localObject3).exists())) {
              break label596;
            }
            localObject1 = badg.a((String)localObject1);
            break;
          }
          localObject1 = str2;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)
          {
            i = 2;
            l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString).longValue();
            l3 = 0L;
            l1 = 0L;
            break label122;
          }
          i = 1;
          localObject3 = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Long);
          l1 = l2;
          if (localObject3 != null)
          {
            l1 = l2;
            if ((localObject3 instanceof MessageForFile)) {
              l1 = Long.valueOf(((MessageRecord)localObject3).senderuin).longValue();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label585;
          }
          l3 = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
          l2 = 0L;
          l1 = 0L;
          break label122;
          localObject1 = localObject2;
          continue;
          paramQQAppInterface.put("ownertype", 2);
        }
        label585:
        l2 = 0L;
        l3 = l1;
        l1 = 0L;
      }
      label596:
      String str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacw
 * JD-Core Version:    0.7.0.1
 */