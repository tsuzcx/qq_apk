package com.tencent.biz.qqcircle.bizparts.danmaku;

import android.app.Activity;

public class QCircleNewDanmakuPart
  extends QCircleAbsDanmakuPart
{
  public String a()
  {
    return "Refactor-QCircleNewDanmakuPart";
  }
  
  public boolean ah_()
  {
    i();
    return super.ah_();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    i();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    m();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    if (paramActivity.isFinishing())
    {
      o();
      return;
    }
    n();
  }
  
  protected boolean r()
  {
    Activity localActivity = c();
    if (localActivity == null) {
      return true;
    }
    return localActivity.isFinishing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleNewDanmakuPart
 * JD-Core Version:    0.7.0.1
 */