package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.CirclePageIndicator;

class FolderRecommendTabFragment$FolderRecommendHeadItemView$1
  implements Runnable
{
  FolderRecommendTabFragment$FolderRecommendHeadItemView$1(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a) && (FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.this$0).getVisibility() == 8))
    {
      FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.this$0).setVisibility(0);
      FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.this$0).setVisibility(0);
    }
    while ((this.a) || (FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.this$0).getVisibility() != 0)) {
      return;
    }
    FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.this$0).setVisibility(8);
    FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView.1
 * JD-Core Version:    0.7.0.1
 */