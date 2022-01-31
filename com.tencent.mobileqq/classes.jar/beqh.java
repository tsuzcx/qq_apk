import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class beqh
{
  private static volatile beqh jdField_a_of_type_Beqh;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  
  public static beqh a()
  {
    if (jdField_a_of_type_Beqh == null) {}
    try
    {
      if (jdField_a_of_type_Beqh == null) {
        jdField_a_of_type_Beqh = new beqh();
      }
      return jdField_a_of_type_Beqh;
    }
    finally {}
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqh
 * JD-Core Version:    0.7.0.1
 */