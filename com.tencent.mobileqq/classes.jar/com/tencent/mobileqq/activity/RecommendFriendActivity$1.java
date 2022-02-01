package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.MayKnowAdapter.OnRecommendsUpdateListener;
import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.List;

class RecommendFriendActivity$1
  implements MayKnowAdapter.OnRecommendsUpdateListener
{
  RecommendFriendActivity$1(RecommendFriendActivity paramRecommendFriendActivity) {}
  
  public void a()
  {
    RecommendFriendActivity.a(this.a).setVisibility(0);
  }
  
  public void a(String paramString)
  {
    RecommendFriendActivity.a(this.a, paramString);
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    Intent localIntent = this.a.getIntent();
    int i = localIntent.getIntExtra("EntranceId", 0);
    RecommendFriendActivity.a(this.a, localIntent, i, paramList);
  }
  
  public void b()
  {
    RecommendFriendActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecommendFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */