public class birv
{
  private android.webkit.CookieManager jdField_a_of_type_AndroidWebkitCookieManager = android.webkit.CookieManager.getInstance();
  private com.tencent.smtt.sdk.CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager = com.tencent.smtt.sdk.CookieManager.getInstance();
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager != null) {
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, paramString2);
    }
    if (this.jdField_a_of_type_AndroidWebkitCookieManager != null) {
      this.jdField_a_of_type_AndroidWebkitCookieManager.setCookie(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager != null) {
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidWebkitCookieManager != null) {
      this.jdField_a_of_type_AndroidWebkitCookieManager.setAcceptCookie(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birv
 * JD-Core Version:    0.7.0.1
 */