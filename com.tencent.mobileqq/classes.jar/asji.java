import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class asji
{
  public static asjj a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("_appinfo");
        if (!TextUtils.isEmpty(paramString)) {
          try
          {
            paramString = Base64.decode(paramString, 10);
            if (paramString == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("miniAppJump", 2, "appinfo decode error 2");
              return null;
            }
          }
          catch (Exception paramString)
          {
            QLog.e("miniAppJump", 1, "parse miniapp jump url error", paramString);
            return null;
          }
        }
      }
    }
    paramString = new JSONObject(new String(paramString, "UTF-8"));
    asjj localasjj = new asjj();
    localasjj.jdField_a_of_type_Int = paramString.getInt("type");
    localasjj.jdField_a_of_type_JavaLangString = paramString.getString("appid");
    localasjj.jdField_b_of_type_JavaLangString = paramString.optString("pageName");
    localasjj.jdField_b_of_type_Int = paramString.optInt("from");
    localasjj.jdField_a_of_type_OrgJsonJSONObject = paramString.optJSONObject("param");
    return localasjj;
  }
  
  public static boolean a(Activity paramActivity, asjj paramasjj, Bundle paramBundle)
  {
    if (paramasjj == null) {}
    while ((paramasjj.jdField_a_of_type_Int == 4) || (paramasjj.jdField_a_of_type_Int != 3)) {
      return false;
    }
    asiz.a(paramActivity, paramasjj.jdField_a_of_type_JavaLangString, paramasjj.jdField_a_of_type_Int, null);
    return true;
  }
  
  public static boolean a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    return a(paramActivity, a(paramString), paramBundle);
  }
  
  public static boolean a(BaseActivity paramBaseActivity, String paramString, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface = paramBaseActivity.app;
    localBundle.putString("uin", localQQAppInterface.getCurrentAccountUin());
    boolean bool;
    if (paramMessageRecord.istroop == 1)
    {
      localBundle.putString("gc", paramMessageRecord.frienduin);
      if ((bamn.a(localQQAppInterface, paramMessageRecord.frienduin, localQQAppInterface.c())) || (bamn.b(localQQAppInterface, paramMessageRecord.frienduin, localQQAppInterface.c())))
      {
        bool = true;
        localBundle.putBoolean("isAdmin", bool);
      }
    }
    else
    {
      paramString = a(paramString);
      bool = a(paramBaseActivity, paramString, localBundle);
      if ((paramString != null) && (bool) && ((paramMessageRecord instanceof MessageForGrayTips)) && (paramString.jdField_a_of_type_Int == 4) && (paramString.jdField_a_of_type_JavaLangString.equals("101474665")))
      {
        if (paramString.jdField_b_of_type_Int != 1) {
          break label186;
        }
        axqw.b(localQQAppInterface, "dc00899", "Grp_idol", "", "idol_follow", "follow_suc_clk", 0, 0, paramMessageRecord.frienduin, "", "", "");
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      break;
      label186:
      if (paramString.jdField_b_of_type_Int == 2) {
        bbbb.a("Grp_idol", "Grp_AIO", "clk_renwu", 0, 0, new String[] { paramMessageRecord.frienduin });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asji
 * JD-Core Version:    0.7.0.1
 */