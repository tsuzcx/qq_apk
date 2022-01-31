import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class atix
{
  private static atix jdField_a_of_type_Atix = new atix();
  private static SharedPreferencesProxyManager jdField_a_of_type_ComTencentMqqShared_file_accessorSharedPreferencesProxyManager = SharedPreferencesProxyManager.getInstance();
  static boolean jdField_a_of_type_Boolean;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  public static void a(Context paramContext, String paramString)
  {
    jdField_a_of_type_ComTencentMqqShared_file_accessorSharedPreferencesProxyManager.init(paramContext);
    jdField_a_of_type_Atix.jdField_a_of_type_AndroidContentSharedPreferences = jdField_a_of_type_ComTencentMqqShared_file_accessorSharedPreferencesProxyManager.getProxy(paramString, 0);
    jdField_a_of_type_Boolean = true;
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = jdField_a_of_type_Atix.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = jdField_a_of_type_Atix.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (ClassCastException paramString) {}
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atix
 * JD-Core Version:    0.7.0.1
 */