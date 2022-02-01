package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;

public abstract interface TextFaceEditLayer$LayerListener
{
  public abstract void a(GestureHelper.ZoomItem paramZoomItem);
  
  public abstract void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2);
  
  public abstract void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer.LayerListener
 * JD-Core Version:    0.7.0.1
 */