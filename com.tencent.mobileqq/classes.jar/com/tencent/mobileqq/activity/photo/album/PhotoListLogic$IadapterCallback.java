package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.ViewGroup;

public abstract interface PhotoListLogic$IadapterCallback
{
  public abstract View getViewCaseCamera(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract View getViewCaseImage(int paramInt, View paramView, ViewGroup paramViewGroup, AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, AbstractPhotoListActivity.CheckBoxClickedListener paramCheckBoxClickedListener);
  
  public abstract View getViewCaseVideo(int paramInt, View paramView, ViewGroup paramViewGroup, AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, AbstractPhotoListActivity.CheckBoxClickedListener paramCheckBoxClickedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IadapterCallback
 * JD-Core Version:    0.7.0.1
 */