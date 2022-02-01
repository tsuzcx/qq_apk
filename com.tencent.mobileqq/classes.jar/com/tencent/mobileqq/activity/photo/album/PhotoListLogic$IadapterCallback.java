package com.tencent.mobileqq.activity.photo.album;

import android.support.annotation.NonNull;

public abstract interface PhotoListLogic$IadapterCallback
{
  public abstract AbstractPhotoListActivity.Holder getViewCaseCamera(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt);
  
  public abstract AbstractPhotoListActivity.Holder getViewCaseImage(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt);
  
  public abstract AbstractPhotoListActivity.Holder getViewCaseVideo(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IadapterCallback
 * JD-Core Version:    0.7.0.1
 */