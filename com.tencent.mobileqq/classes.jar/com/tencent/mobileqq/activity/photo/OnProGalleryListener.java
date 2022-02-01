package com.tencent.mobileqq.activity.photo;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.RegionDrawableData;

public abstract interface OnProGalleryListener
{
  public abstract View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData);
  
  public abstract void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean);
  
  public abstract void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.OnProGalleryListener
 * JD-Core Version:    0.7.0.1
 */