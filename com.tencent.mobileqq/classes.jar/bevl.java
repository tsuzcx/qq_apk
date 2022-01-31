import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bevl
  implements bevs
{
  bevl(bevs parambevs) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (this.a != null) {
      this.a.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bevt parambevt, String paramString)
  {
    if (this.a != null) {
      this.a.onInitGpkgInfo(paramInt, parambevt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevl
 * JD-Core Version:    0.7.0.1
 */