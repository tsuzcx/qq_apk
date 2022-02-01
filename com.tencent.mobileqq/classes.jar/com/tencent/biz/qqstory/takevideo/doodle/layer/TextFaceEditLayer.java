package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.qphone.base.util.QLog;

public class TextFaceEditLayer
  extends BaseLayer
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public TextFaceEditLayer.LayerListener a;
  public GestureHelper.ZoomItem a;
  public GestureHelper a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = TextFaceEditLayer.class.getSimpleName();
  }
  
  public TextFaceEditLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(6.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
      }
    }
    while ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) || (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2, true)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null)) {
      return;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, paramFloat1, paramFloat2, true);
  }
  
  public GestureHelper.ZoomItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(TextFaceEditLayer.LayerListener paramLayerListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener = paramLayerListener;
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof TextLayer.TextItem))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(6.0F);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof FaceLayer.FaceItem));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(18.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean e(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.f, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.k, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.l, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.m, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.a, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.e = false;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.e = false;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.e = true;
            continue;
            if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(false, 0.0F, 0, 0, null, false, 2);
    return true;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    g();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer
 * JD-Core Version:    0.7.0.1
 */