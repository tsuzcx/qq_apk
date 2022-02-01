package com.tencent.mobileqq.activity.photo.album;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import java.util.concurrent.atomic.AtomicBoolean;

class AbstractPhotoListActivity$1
  extends RecyclerView.OnScrollListener
{
  AbstractPhotoListActivity$1(AbstractPhotoListActivity paramAbstractPhotoListActivity) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 0) && (this.this$0.mPhotoListLogic.mPhotoCommonData.mMediaQueryHelper != null) && (this.this$0.gridLayoutManager.findLastVisibleItemPosition() + this.this$0.mPhotoListLogic.mPhotoCommonData.mMediaQueryHelper.mEachCount / 2 > this.this$0.photoListAdapter.getItemCount()) && (!this.this$0.mPhotoListLogic.mPhotoListData.isQuerying.get())) {
      this.this$0.excuteAddPhotoTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.1
 * JD-Core Version:    0.7.0.1
 */