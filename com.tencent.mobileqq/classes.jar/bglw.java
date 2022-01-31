import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;

public class bglw
  implements IMiniRuntime
{
  private bglv a;
  
  public bglw(bglv parambglv)
  {
    this.a = parambglv;
  }
  
  public void close()
  {
    Activity localActivity = this.a.a();
    if ((localActivity != null) && (!localActivity.isFinishing()) && (!localActivity.moveTaskToBack(true)))
    {
      QMLog.e("MiniRuntime", "moveTaskToBack failed, finish the activity.");
      localActivity.finish();
    }
  }
  
  public Activity getAttachedActivity()
  {
    return this.a.a();
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.a.a();
  }
  
  public int getRuntimeId()
  {
    return 0;
  }
  
  public ShareState getShareState()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QMLog.w("MiniRuntime", "getShareState. Failed to get share state, mini app info is null");
      return null;
    }
    ShareState localShareState = bgmj.a(this.a);
    if (localShareState == null)
    {
      QMLog.w("MiniRuntime", "getShareState. Failed to get share state, share state is null");
      return null;
    }
    if ((localMiniAppInfo.verType != 3) || (QUAUtil.isDemoApp()))
    {
      localShareState.showDebug = true;
      localShareState.showMonitor = true;
    }
    if (bgpx.a("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localShareState.withShareWeChatFriend = false;
      localShareState.withShareWeChatMoment = false;
    }
    localShareState.isOrientationLandscape = this.a.c();
    return localShareState;
  }
  
  public boolean restart()
  {
    return ((Boolean)this.a.a(bgmn.a())).booleanValue();
  }
  
  public void share(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("id", paramInt);
      this.a.a(bgmr.a(14, localBundle));
      return;
    case 1: 
      this.a.a(bgmr.a(2));
      return;
    case 2: 
      this.a.a(bgmr.a(6));
      return;
    case 3: 
      this.a.a(bgmr.a(7));
      return;
    case 4: 
      this.a.a(bgmr.a(8));
      return;
    }
    this.a.a(bgmr.a(13, paramBundle));
  }
  
  public boolean toggleDebugPanel()
  {
    return bgmt.a(this.a).booleanValue();
  }
  
  public boolean toggleMonitorPanel()
  {
    return bgmt.b(this.a).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglw
 * JD-Core Version:    0.7.0.1
 */