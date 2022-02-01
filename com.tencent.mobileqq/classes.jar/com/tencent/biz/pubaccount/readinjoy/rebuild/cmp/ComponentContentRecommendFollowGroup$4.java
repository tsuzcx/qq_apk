package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ComponentContentRecommendFollowGroup$4
  extends ReadInJoyObserver
{
  ComponentContentRecommendFollowGroup$4(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    ComponentContentRecommendFollowGroup.4.1 local1 = new ComponentContentRecommendFollowGroup.4.1(this, paramLong, paramBoolean);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup.4
 * JD-Core Version:    0.7.0.1
 */