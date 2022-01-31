import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class bdii
{
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_versioncode", 0);
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_versioncode", paramInt);
    localEditor.apply();
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_predownload_success_key", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_predownload_success_key", false);
  }
  
  public static boolean a(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0);
    if (localSharedPreferences.getInt("key_normal_upgrade_version", 0) != paramInt) {}
    while (!localSharedPreferences.getBoolean("key_normal_upgrade", false)) {
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_dialog_versioncode", 0);
  }
  
  public static void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_dialog_versioncode", paramInt);
    localEditor.apply();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_has_show_upgrade_dialog", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_has_show_upgrade_dialog", false);
  }
  
  public static void c(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_normal_upgrade_version", paramInt);
    localEditor.apply();
  }
  
  public static void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_normal_upgrade", paramBoolean);
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdii
 * JD-Core Version:    0.7.0.1
 */