package com.tencent.mobileqq.activity.photo.album.photolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import java.util.concurrent.atomic.AtomicBoolean;

class PhotoListSceneBase$1
  extends RecyclerView.OnScrollListener
{
  PhotoListSceneBase$1(PhotoListSceneBase paramPhotoListSceneBase) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.d.e.mMediaQueryHelper != null) && (this.a.m.findLastVisibleItemPosition() + this.a.d.e.mMediaQueryHelper.mEachCount / 2 > this.a.t.getItemCount()) && (!this.a.d.g.L.get())) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase.1
 * JD-Core Version:    0.7.0.1
 */