package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class PhotoListLogicQzone$1
  extends RecyclerView.OnScrollListener
{
  PhotoListLogicQzone$1(PhotoListLogicQzone paramPhotoListLogicQzone) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if ((PhotoListLogicQzone.a(this.a)) && (paramInt == 0) && (((NewPhotoListActivity)this.a.mActivity).mGridView != null) && (((NewPhotoListActivity)this.a.mActivity).photoListAdapter != null) && (PhotoListLogicQzone.a(this.a).selectedMediaInfoHashMap != null)) {
      PhotoListLogicQzone.a(this.a);
    }
    if (paramInt == 0)
    {
      DropFrameMonitor.a().a("list_photo", false);
      return;
    }
    DropFrameMonitor.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicQzone.1
 * JD-Core Version:    0.7.0.1
 */