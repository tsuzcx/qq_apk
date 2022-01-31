import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bevo
  implements bevs
{
  bevo(bevs parambevs) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, bevt parambevt, String paramString)
  {
    if (paramInt == 0) {
      if (this.a != null) {
        this.a.onInitGpkgInfo(0, parambevt, null);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.onInitGpkgInfo(paramInt, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevo
 * JD-Core Version:    0.7.0.1
 */