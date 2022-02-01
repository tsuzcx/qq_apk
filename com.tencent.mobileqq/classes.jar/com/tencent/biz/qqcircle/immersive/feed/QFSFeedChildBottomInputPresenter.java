package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;

public class QFSFeedChildBottomInputPresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener
{
  private Context i;
  private View j;
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.i = paramView.getContext();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    a(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    View localView = this.j;
    if (localView == null) {
      return;
    }
    int k;
    if (paramBoolean) {
      k = 4;
    } else {
      k = 0;
    }
    localView.setVisibility(k);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView.getId();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInputPresenter
 * JD-Core Version:    0.7.0.1
 */