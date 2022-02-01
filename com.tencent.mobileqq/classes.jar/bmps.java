import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

class bmps
  implements QzoneZipCacheHelperCallBack
{
  bmps(bmpr parambmpr) {}
  
  public void onResult(boolean paramBoolean)
  {
    bmpr.a(this.a, paramBoolean);
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmps
 * JD-Core Version:    0.7.0.1
 */