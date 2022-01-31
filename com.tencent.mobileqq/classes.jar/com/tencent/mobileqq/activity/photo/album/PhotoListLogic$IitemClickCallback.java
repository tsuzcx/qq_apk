package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.view.View;
import com.tencent.widget.AdapterView;

public abstract interface PhotoListLogic$IitemClickCallback
{
  public abstract void caseCamera(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  
  public abstract Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  
  public abstract void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  
  public abstract void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IitemClickCallback
 * JD-Core Version:    0.7.0.1
 */