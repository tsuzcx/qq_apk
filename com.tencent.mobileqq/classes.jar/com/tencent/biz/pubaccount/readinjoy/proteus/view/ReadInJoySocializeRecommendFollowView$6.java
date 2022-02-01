package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;

class ReadInJoySocializeRecommendFollowView$6
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$6(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView, RecommendFollowInfo paramRecommendFollowInfo) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.6
 * JD-Core Version:    0.7.0.1
 */