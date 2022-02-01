import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bhdc
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aqwh paramaqwh)
  {
    str1 = paramQQAppInterface.getCurrentUin();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.isCreateManager(QQManagerFactory.CONFESS_MANAGER))
      {
        paramString = ((aqvd)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
        paramaqwh.jdField_b_of_type_Boolean = paramString.a(paramaqwh.jdField_a_of_type_JavaLangString);
        ((aqva)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).a(paramQQAppInterface, paramString);
        paramaqwh.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramaqwh.jdField_b_of_type_Boolean = aquz.b(paramaqwh.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        paramaqwh.jdField_a_of_type_Boolean = true;
        if (TextUtils.isEmpty(paramaqwh.jdField_a_of_type_JavaLangString))
        {
          QLog.e("ConfigUtil", 2, "processExtendFriendConfig is emtpy !! configParseResult version:" + paramaqwh.jdField_b_of_type_Int + " localVersion " + paramaqwh.jdField_a_of_type_Int);
          paramaqwh.jdField_b_of_type_Boolean = false;
          return;
        }
        a(paramQQAppInterface.getApp(), str1, paramString, paramaqwh.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface.isCreateManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)) {
          ((aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramaqwh.jdField_a_of_type_JavaLangString);
        }
        paramaqwh.jdField_b_of_type_Boolean = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramaqwh.jdField_b_of_type_Boolean = SosoInterface.saveSosoInterfaceConfig(paramaqwh.jdField_a_of_type_JavaLangString);
        paramaqwh.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramaqwh.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          bhhr.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          bhhr.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          bhhr.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramaqwh.jdField_a_of_type_Boolean = false;
          paramaqwh.jdField_b_of_type_Boolean = true;
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
        localObject = new JSONObject(paramaqwh.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        bhhr.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        bhhr.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        bhhr.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        bhhr.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        bhhr.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        bhhr.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        bhhr.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        bhhr.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramaqwh.jdField_a_of_type_Boolean = false;
      paramaqwh.jdField_b_of_type_Boolean = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdc
 * JD-Core Version:    0.7.0.1
 */