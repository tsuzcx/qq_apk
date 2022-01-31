import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

class bhvq
  implements QzoneZipCacheHelperCallBack
{
  bhvq(bhvp parambhvp) {}
  
  public void onResult(boolean paramBoolean)
  {
    bhvp.a(this.a, paramBoolean);
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhvq
 * JD-Core Version:    0.7.0.1
 */