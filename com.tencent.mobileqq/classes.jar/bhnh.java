import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhnh
{
  private static bhnh jdField_a_of_type_Bhnh;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private bhnh()
  {
    String str = a();
    int i = a();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpForwardPkgManager", 2, "LocalConfig: version= " + i);
      }
      b(str);
    }
  }
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("jump_pkg_toast_cfg_798", 4).getInt("jump_pkg_toast_cfg_version", 0);
  }
  
  public static bhnh a()
  {
    if (jdField_a_of_type_Bhnh == null) {}
    try
    {
      if (jdField_a_of_type_Bhnh == null) {
        jdField_a_of_type_Bhnh = new bhnh();
      }
      return jdField_a_of_type_Bhnh;
    }
    finally {}
  }
  
  private static String a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("jump_pkg_toast_cfg", 4);
    if (!TextUtils.isEmpty(((SharedPreferences)localObject).getString("short_video_res_config_key", ""))) {
      ((SharedPreferences)localObject).edit().putString("short_video_res_config_key", "").commit();
    }
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("jump_pkg_toast_cfg_798", 4).getString("short_video_res_config_key", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = avqg.b((String)localObject);
      return localObject;
    }
    catch (XorCipherException localXorCipherException) {}
    return null;
    return "";
  }
  
  public static String a(Activity paramActivity)
  {
    Object localObject;
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      localObject = null;
      return localObject;
    }
    if (Build.VERSION.SDK_INT >= 22) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
          ((Field)localObject).setAccessible(true);
          localObject = (String)((Field)localObject).get(paramActivity);
          localObject = a().a((String)localObject);
          bool = TextUtils.isEmpty((CharSequence)localObject);
          if (!bool) {
            break;
          }
        }
        catch (Exception localException2)
        {
          boolean bool;
          String str;
          continue;
        }
        try
        {
          localObject = paramActivity.getReferrer();
          if (localObject != null)
          {
            localObject = ((Uri)localObject).getAuthority();
            localObject = a().a((String)localObject);
            bool = TextUtils.isEmpty((CharSequence)localObject);
            if (!bool) {
              break;
            }
          }
        }
        catch (Exception localException1) {}
      }
      try
      {
        str = paramActivity.getCallingPackage();
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          paramActivity = paramActivity.getCallingActivity();
          localObject = str;
          if (paramActivity != null) {
            localObject = paramActivity.getPackageName();
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramActivity = a().a((String)localObject);
          return paramActivity;
        }
      }
      catch (Exception paramActivity) {}
    }
    return null;
  }
  
  public static HashSet<String> a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    if (Build.VERSION.SDK_INT >= 22) {}
    try
    {
      Object localObject = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
      ((Field)localObject).setAccessible(true);
      localObject = (String)((Field)localObject).get(paramActivity);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashSet.add(localObject);
      }
      for (;;)
      {
        try
        {
          label67:
          localObject = paramActivity.getReferrer();
          if (localObject != null)
          {
            localObject = ((Uri)localObject).getAuthority();
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localHashSet.add(localObject);
            }
          }
        }
        catch (Exception localException1)
        {
          String str;
          continue;
        }
        try
        {
          str = paramActivity.getCallingPackage();
          localObject = str;
          if (TextUtils.isEmpty(str))
          {
            paramActivity = paramActivity.getCallingActivity();
            localObject = str;
            if (paramActivity != null) {
              localObject = paramActivity.getPackageName();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localHashSet.add(localObject);
          }
        }
        catch (Exception paramActivity) {}
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpForwardPkgManager", 2, "getCallerReferrerPkg :");
      }
      return localHashSet;
    }
    catch (Exception localException2)
    {
      break label67;
    }
  }
  
  public static final boolean a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    while ((!a().a()) || (TextUtils.isEmpty(a(paramActivity)))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "needHidePreview true");
    }
    return true;
  }
  
  public static final boolean a(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return true;
      try
      {
        if (a().a())
        {
          String str = a(paramActivity);
          if (!TextUtils.isEmpty(str))
          {
            if (paramBoolean) {
              QQToast.a(paramActivity, 1, str, 1000).b(paramActivity.getResources().getDimensionPixelSize(2131299011));
            }
            paramActivity.moveTaskToBack(true);
            if (QLog.isColorLevel()) {
              QLog.d("JumpForwardPkgManager", 2, "checkAllowShare false");
            }
            return false;
          }
        }
      }
      catch (Throwable paramActivity) {}
    }
    return true;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("jump_pkg_toast_cfg_798", 4).edit();
    try
    {
      paramString = avqg.a(paramString);
      localEditor.putString("short_video_res_config_key", paramString);
      localEditor.putInt("jump_pkg_toast_cfg_version", paramInt);
      return localEditor.commit();
    }
    catch (XorCipherException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        if (j <= 0) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        i = 0;
        if (i < j)
        {
          Object localObject = paramString.getJSONObject(i);
          String str = ((JSONObject)localObject).optString("pkgName");
          localObject = ((JSONObject)localObject).optString("toastWording");
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "parseConfigData list size= " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "parseConfigData[JSONException]", paramString);
        }
        return false;
      }
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("JumpForwardPkgManager", 2, "getPkgShareToast: ");
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0));
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "clearConfig list size= " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a("", paramInt);
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer|received version: " + paramInt);
    }
    if (TextUtils.isEmpty(paramString))
    {
      a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer| version=" + paramInt + ",config_content is null, clear");
      }
    }
    do
    {
      boolean bool;
      do
      {
        return;
        if (!b(paramString)) {
          break;
        }
        bool = a(paramString, paramInt);
      } while (!QLog.isColorLevel());
      QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer| saveContentOK=" + bool);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer| parseConfigData false");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0);
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      boolean bool1;
      try
      {
        String str = Uri.parse(paramString).getHost();
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str))) {
          break label129;
        }
        if (!a()) {
          break label112;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
          break label133;
        }
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
          break label107;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("JumpForwardPkgManager", 1, paramString, new Object[0]);
        return false;
      }
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("JumpForwardPkgManager", 2, new Object[] { "contain :", Boolean.valueOf(bool1) });
        return bool1;
        label107:
        bool1 = false;
        continue;
        label112:
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "needCheckPkg false");
        }
        return false;
        label129:
        bool2 = false;
      }
      else
      {
        return bool2;
        label133:
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnh
 * JD-Core Version:    0.7.0.1
 */