import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.manager.JsApiUpdateManager.2.1;

public final class bgvb
  implements bgum
{
  bgvb(bgtg parambgtg) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, bgun parambgun, String paramString)
  {
    if ((paramInt == 0) && (parambgun != null))
    {
      bgjm.a().a(parambgun, true);
      ThreadManager.a(new JsApiUpdateManager.2.1(this), 16, null, true);
      bguz.b(this.a, true);
      return;
    }
    bguz.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvb
 * JD-Core Version:    0.7.0.1
 */