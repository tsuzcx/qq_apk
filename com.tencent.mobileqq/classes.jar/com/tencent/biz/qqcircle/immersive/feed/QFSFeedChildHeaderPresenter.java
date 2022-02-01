package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import feedcloud.FeedCloudMeta.StFeed;

public class QFSFeedChildHeaderPresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener
{
  private LinearLayout i;
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.i = ((LinearLayout)paramView.findViewById(2131433372));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    a(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    LinearLayout localLinearLayout = this.i;
    if (localLinearLayout == null) {
      return;
    }
    int j;
    if (paramBoolean) {
      j = 4;
    } else {
      j = 0;
    }
    localLinearLayout.setVisibility(j);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildHeaderPresenter
 * JD-Core Version:    0.7.0.1
 */