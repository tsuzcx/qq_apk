package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.QBaseActivity;

public class MiniAIOBaseActivityLifecycleCallback
  implements BaseActivityLifecycleCallbacks
{
  private MiniMsgUser a;
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 0;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    localMiniMsgUserParam.filterMsgType = 0;
    return localMiniMsgUserParam;
  }
  
  public void doOnActivityCreate(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityDestroyed(Activity paramActivity)
  {
    if (((paramActivity instanceof QBaseActivity)) && (((QBaseActivity)paramActivity).isNeedMiniMsg()))
    {
      paramActivity = this.a;
      if (paramActivity != null) {
        paramActivity.destroy();
      }
    }
  }
  
  public void doOnActivityOnStart(Activity paramActivity) {}
  
  public void doOnActivityPause(Activity paramActivity)
  {
    if (((paramActivity instanceof QBaseActivity)) && (((QBaseActivity)paramActivity).isNeedMiniMsg()))
    {
      paramActivity = this.a;
      if (paramActivity != null) {
        paramActivity.onBackground();
      }
    }
  }
  
  public void doOnActivityPostCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityPostPaused(Activity paramActivity) {}
  
  public void doOnActivityPostResumed(Activity paramActivity) {}
  
  public void doOnActivityPreCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (((paramActivity instanceof QBaseActivity)) && (((QBaseActivity)paramActivity).isNeedMiniMsg())) {
      this.a = new MiniMsgUser(paramActivity, a());
    }
  }
  
  public void doOnActivityPrePaused(Activity paramActivity) {}
  
  public void doOnActivityPreResumed(Activity paramActivity) {}
  
  public void doOnActivityResume(Activity paramActivity)
  {
    if (((paramActivity instanceof QBaseActivity)) && (((QBaseActivity)paramActivity).isNeedMiniMsg()))
    {
      paramActivity = this.a;
      if (paramActivity != null) {
        paramActivity.onForeground();
      }
    }
  }
  
  public void doOnActivityStopped(Activity paramActivity) {}
  
  public void doOnNewIntent(Activity paramActivity, Intent paramIntent) {}
  
  public void doOnWindowFocusChanged(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity instanceof QBaseActivity))
    {
      paramActivity = (QBaseActivity)paramActivity;
      if ((paramBoolean) && (!paramActivity.isShowOnFirst()))
      {
        if (paramActivity.isNeedMiniMsg())
        {
          MiniMsgUser localMiniMsgUser = this.a;
          if (localMiniMsgUser != null) {
            localMiniMsgUser.showOnFirst();
          }
        }
        paramActivity.setShowOnFirst(true);
      }
    }
  }
  
  public void onAccountChanged(Activity paramActivity) {}
  
  public void onMultiWindowModeChanged(Activity paramActivity, boolean paramBoolean) {}
  
  public void onPostThemeChanged(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.MiniAIOBaseActivityLifecycleCallback
 * JD-Core Version:    0.7.0.1
 */