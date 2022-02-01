import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class arhb
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  
  private static Intent a(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    if (paramActivity == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent actCaller is null");
      }
    }
    do
    {
      return null;
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent app is null");
    return null;
    String str = paramAppInterface.getCurrentAccountUin();
    paramAppInterface = a(a(paramInt), paramAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebEntrance", 2, "AuthDevUgAct url=" + paramAppInterface);
    }
    paramActivity = new Intent(paramActivity, QQBrowserActivity.class);
    paramActivity.putExtra("portraitOnly", true);
    paramActivity.putExtra("url", paramAppInterface);
    paramActivity.putExtra("uin", str);
    paramActivity.putExtra("hide_operation_bar", true);
    paramActivity.putExtra("hide_more_button", true);
    return paramActivity;
  }
  
  private static String a(int paramInt)
  {
    String str = arhf.a().a();
    Object localObject;
    if ((str != null) && (str.length() > 0))
    {
      localObject = str;
      if (!str.startsWith("https"))
      {
        if (!str.startsWith("http")) {
          break label193;
        }
        localObject = str;
      }
    }
    for (;;)
    {
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append("type=" + Integer.toString(paramInt));
      ((StringBuilder)localObject).append("&plat=1");
      ((StringBuilder)localObject).append("&app=1");
      ((StringBuilder)localObject).append("&version=8.4.8.4810");
      ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      return ((StringBuilder)localObject).toString();
      label193:
      localObject = "https://" + str;
      continue;
      localObject = "https://accounts.qq.com/cn2/manage/mobile_h5/mobile_index";
    }
  }
  
  private static String a(String paramString, AppInterface paramAppInterface)
  {
    Object localObject = null;
    String str = null;
    if (paramString == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "handlePhoneContact url is null");
      }
    }
    for (;;)
    {
      return paramString;
      if (paramAppInterface != null)
      {
        paramAppInterface = (avsy)paramAppInterface.getManager(11);
        if (paramAppInterface != null)
        {
          paramAppInterface = paramAppInterface.a();
          if (paramAppInterface == null)
          {
            if (!QLog.isColorLevel()) {
              break label250;
            }
            QLog.d("EquipLockWebEntrance", 2, "mgr can't find stat");
            paramAppInterface = null;
          }
        }
      }
      while ((str != null) && (str.length() > 0) && (paramAppInterface != null) && (paramAppInterface.length() > 0))
      {
        paramString = new StringBuilder(paramString);
        paramString.append("&area=" + str);
        paramString.append("&mob=" + paramAppInterface);
        return paramString.toString();
        if (QLog.isColorLevel()) {
          QLog.d("EquipLockWebEntrance", 2, "mgr find stat, nationCode=" + paramAppInterface.nationCode + " no.=" + paramAppInterface.mobileNo);
        }
        str = paramAppInterface.nationCode;
        paramAppInterface = paramAppInterface.mobileNo;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("EquipLockWebEntrance", 2, "mgr is null");
        }
        for (;;)
        {
          str = null;
          paramAppInterface = localObject;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("EquipLockWebEntrance", 2, "getEntranceIntent:app is null");
          }
        }
        label250:
        paramAppInterface = null;
      }
    }
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "enter actCaller is null");
      }
      return;
    }
    paramAppInterface = a(paramActivity, paramAppInterface, paramInt);
    try
    {
      VasWebviewUtil.openQQBrowserActivity(paramActivity, "", 16384L, paramAppInterface, false, -1);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    if (paramActivity == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "enterForResult actCaller is null");
      }
    }
    do
    {
      return;
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("EquipLockWebEntrance", 4, "enterForResult app is null");
    return;
    paramAppInterface = a(paramActivity, paramAppInterface, paramInt1);
    if (paramString != null) {
      paramAppInterface.putExtra("tag", paramString);
    }
    paramAppInterface.putExtra("needResult", true);
    try
    {
      VasWebviewUtil.openQQBrowserActivity(paramActivity, "", 16384L, paramAppInterface, true, paramInt2);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "subaccountEnter actCaller is null");
      }
      return;
    }
    String str = a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebEntrance", 2, "AuthDevUgAct url=" + str);
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", str);
    localIntent.putExtra("subAccountUin", paramString2);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    if ((paramString1 != null) && (!paramString1.equals(paramString2))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebEntrance", 2, "globalEnter currentUin=" + paramString1 + " reqUin=" + paramString2 + " isSubaccount=" + bool);
      }
      localIntent.putExtra("isSubaccount", bool);
      localIntent.putExtra("avoidLoginWeb", bool);
      try
      {
        VasWebviewUtil.openQQBrowserActivity(paramActivity, "", 16384L, localIntent, false, -1);
        return;
      }
      catch (SecurityException paramActivity)
      {
        return;
      }
      bool = false;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "subaccountEnter actCaller is null");
      }
      return;
    }
    String str = a(paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebEntrance", 2, "AuthDevUgAct url=" + str);
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", str);
    localIntent.putExtra("subAccountUin", paramString2);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebEntrance", 2, "globalEnter currentUin=" + paramString1 + " reqUin=" + paramString2 + " isSubaccount=" + bool1);
    }
    localIntent.putExtra("isSubaccount", bool1);
    localIntent.putExtra("avoidLoginWeb", bool1);
    if (paramString3 != null) {
      localIntent.putExtra("tag", paramString3);
    }
    localIntent.putExtra("needResult", true);
    try
    {
      VasWebviewUtil.openQQBrowserActivity(paramActivity, "", 16384L, localIntent, true, paramInt2);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhb
 * JD-Core Version:    0.7.0.1
 */