import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bguf
  implements bgum
{
  bguf(bgum parambgum) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (this.a != null) {
      this.a.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bgun parambgun, String paramString)
  {
    if (this.a != null) {
      this.a.onInitGpkgInfo(paramInt, parambgun, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguf
 * JD-Core Version:    0.7.0.1
 */