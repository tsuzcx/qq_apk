import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bdga
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = bdhb.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    bdhb.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aojy paramaojy)
  {
    str1 = paramQQAppInterface.c();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.a(269))
      {
        paramString = ((aoiu)paramQQAppInterface.getManager(269)).a();
        paramaojy.b = paramString.a(paramaojy.jdField_a_of_type_JavaLangString);
        ((aoir)paramQQAppInterface.a(125)).a(paramQQAppInterface, paramString);
        paramaojy.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramaojy.b = aoiq.b(paramaojy.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        a(paramQQAppInterface.getApp(), str1, paramString, paramaojy.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface.a(264)) {
          ((aqbg)paramQQAppInterface.getManager(264)).a(paramaojy.jdField_a_of_type_JavaLangString);
        }
        paramaojy.jdField_a_of_type_Boolean = true;
        paramaojy.b = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramaojy.b = SosoInterface.a(paramaojy.jdField_a_of_type_JavaLangString);
        paramaojy.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramaojy.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          bdne.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          bdne.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          bdne.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramaojy.jdField_a_of_type_Boolean = false;
          paramaojy.b = true;
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
        localObject = new JSONObject(paramaojy.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        bdne.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        bdne.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        bdne.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        bdne.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        bdne.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        bdne.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        bdne.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        bdne.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramaojy.jdField_a_of_type_Boolean = false;
      paramaojy.b = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdga
 * JD-Core Version:    0.7.0.1
 */