package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;

class ComponentContentRecommendFollowList$3
  implements Runnable
{
  ComponentContentRecommendFollowList$3(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void run()
  {
    ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
    long l = this.a.uin;
    if (this.a.isFollowed) {}
    for (int i = 2;; i = 1)
    {
      localReadInJoyLogicEngine.c(l, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList.3
 * JD-Core Version:    0.7.0.1
 */