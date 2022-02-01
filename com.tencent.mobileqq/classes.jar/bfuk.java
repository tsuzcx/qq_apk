import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bfuk
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = FileUtils.readObject(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    FileUtils.writeObject(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, apte paramapte)
  {
    str1 = paramQQAppInterface.getCurrentUin();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.isCreateManager(269))
      {
        paramString = ((apsa)paramQQAppInterface.getManager(269)).a();
        paramapte.jdField_b_of_type_Boolean = paramString.a(paramapte.jdField_a_of_type_JavaLangString);
        ((aprx)paramQQAppInterface.getBusinessHandler(125)).a(paramQQAppInterface, paramString);
        paramapte.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramapte.jdField_b_of_type_Boolean = aprw.b(paramapte.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        paramapte.jdField_a_of_type_Boolean = true;
        if (TextUtils.isEmpty(paramapte.jdField_a_of_type_JavaLangString))
        {
          QLog.e("ConfigUtil", 2, "processExtendFriendConfig is emtpy !! configParseResult version:" + paramapte.jdField_b_of_type_Int + " localVersion " + paramapte.jdField_a_of_type_Int);
          paramapte.jdField_b_of_type_Boolean = false;
          return;
        }
        a(paramQQAppInterface.getApp(), str1, paramString, paramapte.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface.isCreateManager(264)) {
          ((arhi)paramQQAppInterface.getManager(264)).a(paramapte.jdField_a_of_type_JavaLangString);
        }
        paramapte.jdField_b_of_type_Boolean = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramapte.jdField_b_of_type_Boolean = SosoInterface.saveSosoInterfaceConfig(paramapte.jdField_a_of_type_JavaLangString);
        paramapte.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramapte.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          bfyz.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          bfyz.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          bfyz.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramapte.jdField_a_of_type_Boolean = false;
          paramapte.jdField_b_of_type_Boolean = true;
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
        localObject = new JSONObject(paramapte.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        bfyz.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        bfyz.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        bfyz.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        bfyz.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        bfyz.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        bfyz.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        bfyz.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        bfyz.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramapte.jdField_a_of_type_Boolean = false;
      paramapte.jdField_b_of_type_Boolean = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuk
 * JD-Core Version:    0.7.0.1
 */