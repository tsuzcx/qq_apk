package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.support.logging.SLog;

public final class EmptyLayer
  extends BaseLayer
{
  public static final String a = "EmptyLayer";
  
  public EmptyLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public String a()
  {
    return a;
  }
  
  protected void a(Canvas paramCanvas) {}
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    SLog.b(a, "EmptyLayer handle touch event.");
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.EmptyLayer
 * JD-Core Version:    0.7.0.1
 */