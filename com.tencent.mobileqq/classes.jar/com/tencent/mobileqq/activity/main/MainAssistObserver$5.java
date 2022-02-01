package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.kandian.repo.push.api.RIJTabObserverCallBack;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import org.jetbrains.annotations.Nullable;

class MainAssistObserver$5
  implements RIJTabObserverCallBack
{
  MainAssistObserver$5(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    if (this.a.a != null) {
      this.a.a.updateMain(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void a(int paramInt, @Nullable BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.a.a != null) {
      this.a.a.updateTabRedTouch(39, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.5
 * JD-Core Version:    0.7.0.1
 */