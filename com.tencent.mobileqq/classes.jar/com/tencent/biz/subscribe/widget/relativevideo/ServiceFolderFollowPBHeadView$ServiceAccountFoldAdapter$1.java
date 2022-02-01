package com.tencent.biz.subscribe.widget.relativevideo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$1
  extends RecyclerView.OnScrollListener
{
  ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$1(ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter paramServiceAccountFoldAdapter) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.a(this.a)) && (!paramRecyclerView.isComputingLayout()) && (paramInt == 0))
    {
      ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.a(this.a, false);
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.1
 * JD-Core Version:    0.7.0.1
 */