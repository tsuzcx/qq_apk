package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public final class EmptyLayer
  extends BaseLayer
{
  public EmptyLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public String a()
  {
    return "EmptyLayer";
  }
  
  public void a() {}
  
  protected void a(Canvas paramCanvas) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    SLog.b("EmptyLayer", "EmptyLayer handle touch event.");
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer
 * JD-Core Version:    0.7.0.1
 */