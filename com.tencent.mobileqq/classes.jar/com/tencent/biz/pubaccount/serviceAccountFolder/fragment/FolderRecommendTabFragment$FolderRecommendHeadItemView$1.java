package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.CirclePageIndicator;

class FolderRecommendTabFragment$FolderRecommendHeadItemView$1
  implements Runnable
{
  FolderRecommendTabFragment$FolderRecommendHeadItemView$1(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a) && (FolderRecommendTabFragment.FolderRecommendHeadItemView.b(this.this$0).getVisibility() == 8))
    {
      FolderRecommendTabFragment.FolderRecommendHeadItemView.b(this.this$0).setVisibility(0);
      FolderRecommendTabFragment.FolderRecommendHeadItemView.c(this.this$0).setVisibility(0);
      return;
    }
    if ((!this.a) && (FolderRecommendTabFragment.FolderRecommendHeadItemView.b(this.this$0).getVisibility() == 0))
    {
      FolderRecommendTabFragment.FolderRecommendHeadItemView.b(this.this$0).setVisibility(8);
      FolderRecommendTabFragment.FolderRecommendHeadItemView.c(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView.1
 * JD-Core Version:    0.7.0.1
 */