package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class PhotoListCustomizationQzone$1
  extends RecyclerView.OnScrollListener
{
  PhotoListCustomizationQzone$1(PhotoListCustomizationQzone paramPhotoListCustomizationQzone) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if ((PhotoListCustomizationQzone.a(this.a)) && (paramInt == 0) && (this.a.h.l != null) && (this.a.h.t != null) && (this.a.e.selectedMediaInfoHashMap != null)) {
      PhotoListCustomizationQzone.b(this.a);
    }
    if (paramInt == 0)
    {
      DropFrameMonitor.b().a("list_photo", false);
      return;
    }
    DropFrameMonitor.b().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.1
 * JD-Core Version:    0.7.0.1
 */