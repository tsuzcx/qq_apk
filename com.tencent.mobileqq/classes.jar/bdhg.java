import android.content.Context;

public class bdhg
{
  private android.webkit.CookieSyncManager jdField_a_of_type_AndroidWebkitCookieSyncManager;
  private com.tencent.smtt.sdk.CookieSyncManager jdField_a_of_type_ComTencentSmttSdkCookieSyncManager;
  
  public bdhg(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentSmttSdkCookieSyncManager = com.tencent.smtt.sdk.CookieSyncManager.createInstance(paramContext);
    this.jdField_a_of_type_AndroidWebkitCookieSyncManager = android.webkit.CookieSyncManager.createInstance(paramContext);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkCookieSyncManager != null) {
      this.jdField_a_of_type_ComTencentSmttSdkCookieSyncManager.sync();
    }
    if (this.jdField_a_of_type_AndroidWebkitCookieSyncManager != null) {
      this.jdField_a_of_type_AndroidWebkitCookieSyncManager.sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhg
 * JD-Core Version:    0.7.0.1
 */