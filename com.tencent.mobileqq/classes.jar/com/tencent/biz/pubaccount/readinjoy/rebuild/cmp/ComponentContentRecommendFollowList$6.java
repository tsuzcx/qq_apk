package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ComponentContentRecommendFollowList$6
  extends ReadInJoyObserver
{
  ComponentContentRecommendFollowList$6(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    ComponentContentRecommendFollowList.6.1 local1 = new ComponentContentRecommendFollowList.6.1(this, paramLong, paramBoolean);
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ThreadManager.getUIHandler().post(local1);
      return;
    }
    local1.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList.6
 * JD-Core Version:    0.7.0.1
 */