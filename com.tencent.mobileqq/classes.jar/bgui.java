import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bgui
  implements bgum
{
  bgui(bgum parambgum) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, bgun parambgun, String paramString)
  {
    if (paramInt == 0) {
      if (this.a != null) {
        this.a.onInitGpkgInfo(0, parambgun, null);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.onInitGpkgInfo(paramInt, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgui
 * JD-Core Version:    0.7.0.1
 */