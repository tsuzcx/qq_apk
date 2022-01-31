import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;

public class bghp
  implements IMiniRuntime
{
  private bgho a;
  
  public bghp(bgho parambgho)
  {
    this.a = parambgho;
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
    ShareState localShareState = bgic.a(this.a);
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
    if (bglq.a("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localShareState.withShareWeChatFriend = false;
      localShareState.withShareWeChatMoment = false;
    }
    localShareState.isOrientationLandscape = this.a.c();
    return localShareState;
  }
  
  public boolean restart()
  {
    return ((Boolean)this.a.a(bgig.a())).booleanValue();
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
      this.a.a(bgik.a(14, localBundle));
      return;
    case 1: 
      this.a.a(bgik.a(2));
      return;
    case 2: 
      this.a.a(bgik.a(6));
      return;
    case 3: 
      this.a.a(bgik.a(7));
      return;
    case 4: 
      this.a.a(bgik.a(8));
      return;
    }
    this.a.a(bgik.a(13, paramBundle));
  }
  
  public boolean toggleDebugPanel()
  {
    return bgim.a(this.a).booleanValue();
  }
  
  public boolean toggleMonitorPanel()
  {
    return bgim.b(this.a).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bghp
 * JD-Core Version:    0.7.0.1
 */