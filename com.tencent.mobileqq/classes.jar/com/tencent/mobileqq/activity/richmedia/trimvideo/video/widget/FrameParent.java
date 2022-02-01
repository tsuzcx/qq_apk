package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;

public abstract interface FrameParent
{
  public abstract Context getContext();
  
  public abstract void invalidate();
  
  public abstract void postInvalidate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FrameParent
 * JD-Core Version:    0.7.0.1
 */