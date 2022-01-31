import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

class bgmi
  implements QzoneZipCacheHelperCallBack
{
  bgmi(bgmh parambgmh) {}
  
  public void onResult(boolean paramBoolean)
  {
    bgmh.a(this.a, paramBoolean);
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmi
 * JD-Core Version:    0.7.0.1
 */