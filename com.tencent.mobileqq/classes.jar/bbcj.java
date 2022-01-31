import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bbcj
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = bbdj.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    bbdj.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, amos paramamos)
  {
    str1 = paramQQAppInterface.c();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.a(269))
      {
        paramString = ((amno)paramQQAppInterface.getManager(269)).a();
        paramamos.b = paramString.a(paramamos.jdField_a_of_type_JavaLangString);
        ((amnl)paramQQAppInterface.a(125)).a(paramQQAppInterface, paramString);
        paramamos.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramamos.b = amnk.b(paramamos.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        a(paramQQAppInterface.getApp(), str1, paramString, paramamos.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface.a(264)) {
          ((aoep)paramQQAppInterface.getManager(264)).a(paramamos.jdField_a_of_type_JavaLangString);
        }
        paramamos.jdField_a_of_type_Boolean = true;
        paramamos.b = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramamos.b = SosoInterface.a(paramamos.jdField_a_of_type_JavaLangString);
        paramamos.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramamos.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          bbjn.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          bbjn.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          bbjn.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramamos.jdField_a_of_type_Boolean = false;
          paramamos.b = true;
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
        localObject = new JSONObject(paramamos.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        bbjn.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        bbjn.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        bbjn.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        bbjn.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        bbjn.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        bbjn.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        bbjn.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        bbjn.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramamos.jdField_a_of_type_Boolean = false;
      paramamos.b = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcj
 * JD-Core Version:    0.7.0.1
 */