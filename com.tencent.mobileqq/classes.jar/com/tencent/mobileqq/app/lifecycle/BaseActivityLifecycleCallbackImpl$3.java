package com.tencent.mobileqq.app.lifecycle;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;

class BaseActivityLifecycleCallbackImpl$3
  implements Runnable
{
  BaseActivityLifecycleCallbackImpl$3(BaseActivityLifecycleCallbackImpl paramBaseActivityLifecycleCallbackImpl, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    ActivityLifecycle.onPause(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl.3
 * JD-Core Version:    0.7.0.1
 */