package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.view.View;

abstract interface PhotoListLogic$IitemClickCallback
{
  public abstract void caseCamera(View paramView, int paramInt);
  
  public abstract Intent caseNoSingModeImage(View paramView, int paramInt);
  
  public abstract void caseSingleModeImage(View paramView, int paramInt);
  
  public abstract void caseVideo(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IitemClickCallback
 * JD-Core Version:    0.7.0.1
 */