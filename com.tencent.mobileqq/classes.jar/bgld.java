import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bgld
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = bgmg.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    bgmg.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aqkq paramaqkq)
  {
    str1 = paramQQAppInterface.c();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.a(269))
      {
        paramString = ((aqjm)paramQQAppInterface.getManager(269)).a();
        paramaqkq.jdField_b_of_type_Boolean = paramString.a(paramaqkq.jdField_a_of_type_JavaLangString);
        ((aqjj)paramQQAppInterface.a(125)).a(paramQQAppInterface, paramString);
        paramaqkq.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramaqkq.jdField_b_of_type_Boolean = aqji.b(paramaqkq.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        paramaqkq.jdField_a_of_type_Boolean = true;
        if (TextUtils.isEmpty(paramaqkq.jdField_a_of_type_JavaLangString))
        {
          QLog.e("ConfigUtil", 2, "processExtendFriendConfig is emtpy !! configParseResult version:" + paramaqkq.jdField_b_of_type_Int + " localVersion " + paramaqkq.jdField_a_of_type_Int);
          paramaqkq.jdField_b_of_type_Boolean = false;
          return;
        }
        a(paramQQAppInterface.getApp(), str1, paramString, paramaqkq.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface.a(264)) {
          ((asfu)paramQQAppInterface.getManager(264)).a(paramaqkq.jdField_a_of_type_JavaLangString);
        }
        paramaqkq.jdField_b_of_type_Boolean = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramaqkq.jdField_b_of_type_Boolean = SosoInterface.a(paramaqkq.jdField_a_of_type_JavaLangString);
        paramaqkq.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramaqkq.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          bgsg.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          bgsg.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          bgsg.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramaqkq.jdField_a_of_type_Boolean = false;
          paramaqkq.jdField_b_of_type_Boolean = true;
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
      }
    } while (!"account_logout_config".equals(paramString));
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramaqkq.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        bgsg.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        bgsg.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        bgsg.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        bgsg.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        bgsg.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        bgsg.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        bgsg.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        bgsg.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramaqkq.jdField_a_of_type_Boolean = false;
      paramaqkq.jdField_b_of_type_Boolean = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgld
 * JD-Core Version:    0.7.0.1
 */