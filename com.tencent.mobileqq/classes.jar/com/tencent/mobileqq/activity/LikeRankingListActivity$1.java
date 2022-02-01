package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;

class LikeRankingListActivity$1
  extends CallBacker
{
  LikeRankingListActivity$1(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (paramInt1 == 0) && (this.a.a != null))
    {
      paramString1 = this.a;
      paramString1.b(paramString1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.1
 * JD-Core Version:    0.7.0.1
 */