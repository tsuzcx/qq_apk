import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class beux
  implements bevb
{
  beux(bevb parambevb) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, bevc parambevc, String paramString)
  {
    if (paramInt == 0) {
      if (this.a != null) {
        this.a.onInitGpkgInfo(0, parambevc, null);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.onInitGpkgInfo(paramInt, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beux
 * JD-Core Version:    0.7.0.1
 */