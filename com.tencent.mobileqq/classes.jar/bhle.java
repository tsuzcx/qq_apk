import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bhle
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = bhmi.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    bhmi.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aqzt paramaqzt)
  {
    str1 = paramQQAppInterface.c();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.a(269))
      {
        paramString = ((aqyp)paramQQAppInterface.getManager(269)).a();
        paramaqzt.jdField_b_of_type_Boolean = paramString.a(paramaqzt.jdField_a_of_type_JavaLangString);
        ((aqym)paramQQAppInterface.a(125)).a(paramQQAppInterface, paramString);
        paramaqzt.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramaqzt.jdField_b_of_type_Boolean = aqyl.b(paramaqzt.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        paramaqzt.jdField_a_of_type_Boolean = true;
        if (TextUtils.isEmpty(paramaqzt.jdField_a_of_type_JavaLangString))
        {
          QLog.e("ConfigUtil", 2, "processExtendFriendConfig is emtpy !! configParseResult version:" + paramaqzt.jdField_b_of_type_Int + " localVersion " + paramaqzt.jdField_a_of_type_Int);
          paramaqzt.jdField_b_of_type_Boolean = false;
          return;
        }
        a(paramQQAppInterface.getApp(), str1, paramString, paramaqzt.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface.a(264)) {
          ((asvi)paramQQAppInterface.getManager(264)).a(paramaqzt.jdField_a_of_type_JavaLangString);
        }
        paramaqzt.jdField_b_of_type_Boolean = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramaqzt.jdField_b_of_type_Boolean = SosoInterface.a(paramaqzt.jdField_a_of_type_JavaLangString);
        paramaqzt.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramaqzt.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          bhsi.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          bhsi.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          bhsi.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramaqzt.jdField_a_of_type_Boolean = false;
          paramaqzt.jdField_b_of_type_Boolean = true;
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
        localObject = new JSONObject(paramaqzt.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        bhsi.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        bhsi.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        bhsi.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        bhsi.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        bhsi.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        bhsi.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        bhsi.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        bhsi.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramaqzt.jdField_a_of_type_Boolean = false;
      paramaqzt.jdField_b_of_type_Boolean = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhle
 * JD-Core Version:    0.7.0.1
 */