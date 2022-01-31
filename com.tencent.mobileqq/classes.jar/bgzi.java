import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.manager.JsApiUpdateManager.2.1;

public final class bgzi
  implements bgyt
{
  bgzi(bgxn parambgxn) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, bgyu parambgyu, String paramString)
  {
    if ((paramInt == 0) && (parambgyu != null))
    {
      bgnt.a().a(parambgyu, true);
      ThreadManager.a(new JsApiUpdateManager.2.1(this), 16, null, true);
      bgzg.b(this.a, true);
      return;
    }
    bgzg.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzi
 * JD-Core Version:    0.7.0.1
 */