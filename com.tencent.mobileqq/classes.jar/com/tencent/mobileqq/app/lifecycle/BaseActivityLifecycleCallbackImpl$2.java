package com.tencent.mobileqq.app.lifecycle;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;

class BaseActivityLifecycleCallbackImpl$2
  implements Runnable
{
  BaseActivityLifecycleCallbackImpl$2(BaseActivityLifecycleCallbackImpl paramBaseActivityLifecycleCallbackImpl, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    ActivityLifecycle.onResume(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl.2
 * JD-Core Version:    0.7.0.1
 */