import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bbcx
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = bbdx.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    bbdx.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, amor paramamor)
  {
    str1 = paramQQAppInterface.c();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.a(269))
      {
        paramString = ((amnn)paramQQAppInterface.getManager(269)).a();
        paramamor.b = paramString.a(paramamor.jdField_a_of_type_JavaLangString);
        ((amnk)paramQQAppInterface.a(125)).a(paramQQAppInterface, paramString);
        paramamor.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramamor.b = amnj.b(paramamor.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        a(paramQQAppInterface.getApp(), str1, paramString, paramamor.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface.a(264)) {
          ((aoeu)paramQQAppInterface.getManager(264)).a(paramamor.jdField_a_of_type_JavaLangString);
        }
        paramamor.jdField_a_of_type_Boolean = true;
        paramamor.b = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramamor.b = SosoInterface.a(paramamor.jdField_a_of_type_JavaLangString);
        paramamor.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramamor.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          bbkb.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          bbkb.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          bbkb.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramamor.jdField_a_of_type_Boolean = false;
          paramamor.b = true;
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
        localObject = new JSONObject(paramamor.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        bbkb.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        bbkb.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        bbkb.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        bbkb.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        bbkb.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        bbkb.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        bbkb.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        bbkb.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramamor.jdField_a_of_type_Boolean = false;
      paramamor.b = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcx
 * JD-Core Version:    0.7.0.1
 */