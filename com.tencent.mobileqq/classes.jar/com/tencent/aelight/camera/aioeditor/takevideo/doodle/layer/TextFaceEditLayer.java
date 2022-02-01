package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;

public class TextFaceEditLayer
  extends BaseLayer
  implements Drawable.Callback
{
  public static final String a = "TextFaceEditLayer";
  public int a;
  public TextFaceEditLayer.LayerListener a;
  public GestureHelper.ZoomItem a;
  public GestureHelper a;
  public boolean a;
  
  public TextFaceEditLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(6.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j = 0;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j = 1;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.j = 2;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, paramFloat1, paramFloat2, true);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2))
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener;
      if (paramMotionEvent != null)
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
        if ((localObject instanceof TextLayer.TextItem))
        {
          paramMotionEvent = ((TextLayer.TextItem)localObject).a;
          if (paramMotionEvent != null) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, paramMotionEvent.b(), 2);
          }
        }
        else
        {
          paramMotionEvent.a((GestureHelper.ZoomItem)localObject, 0, 0);
        }
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2))
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem);
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2))
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem);
      }
    }
    else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2, true)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener != null))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
      if (localObject != null) {
        if ((localObject instanceof TextLayer.TextItem))
        {
          localObject = ((TextLayer.TextItem)localObject).a;
          if (localObject != null)
          {
            if ((((DynamicTextItem)localObject).a()) && (((DynamicTextItem)localObject).f()))
            {
              int i = ((DynamicTextItem)localObject).a(paramMotionEvent, c(), d(), (TextLayer.TextItem)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper);
              ((DynamicTextItem)localObject).b(i);
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, i, 3, f1, f2);
              return;
            }
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, ((DynamicTextItem)localObject).b(), 0, f1, f2);
          }
        }
        else
        {
          paramMotionEvent = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("click the item:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem);
          SLog.b(paramMotionEvent, ((StringBuilder)localObject).toString());
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, 0, 0, f1, f2);
        }
      }
    }
  }
  
  private void c(GestureHelper.ZoomItem paramZoomItem)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramZoomItem, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramZoomItem, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(paramZoomItem, StoryGuideLineView.d, false);
    TextFaceEditLayer.LayerListener localLayerListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener;
    if (localLayerListener != null) {
      localLayerListener.a(bool1, bool2, false, bool3, paramZoomItem.g);
    }
    if (paramZoomItem != null)
    {
      if (paramZoomItem.f)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramZoomItem.g, paramZoomItem.k, paramZoomItem.l, paramZoomItem.m, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF, paramZoomItem.h, 2);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramZoomItem.g, paramZoomItem.k, paramZoomItem.l, paramZoomItem.m, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF, paramZoomItem.h, 1);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public GestureHelper.ZoomItem a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(TextFaceEditLayer.LayerListener paramLayerListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer$LayerListener = paramLayerListener;
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem == null) {
      return;
    }
    TextLayer.c(true);
    paramZoomItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(6.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(0.2F);
      return;
    }
    if (((paramZoomItem instanceof FaceLayer.FaceItem)) || ((paramZoomItem instanceof FaceLayer.FaceAndTextItem)))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(18.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(0.2F);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {
      return;
    }
    paramZoomItem.f = true;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
      paramZoomItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if ((paramZoomItem instanceof FaceLayer.FaceItem))
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
      if ((localFaceItem.h == 1) || (localFaceItem.h == 3)) {
        localFaceItem.a.setCallback(this);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    String str;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2, true))
    {
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("accept inside x:");
        localStringBuilder.append(paramMotionEvent.getX());
        localStringBuilder.append(" y:");
        localStringBuilder.append(paramMotionEvent.getY());
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("accept outside x:");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(" y:");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    int m = paramMotionEvent.getAction() & 0xFF;
    int i = 0;
    if (m != 0) {
      if (m != 1) {
        if (m == 2) {}
      }
    }
    for (;;)
    {
      i = 1;
      break;
      if (k > 10)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (!this.jdField_a_of_type_Boolean) {
          b(paramMotionEvent);
        }
        GestureHelper.ZoomItem localZoomItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
        if (localZoomItem != null) {
          localZoomItem.j = -1;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a();
        break;
        this.jdField_a_of_type_Int = j;
        this.jdField_a_of_type_Boolean = false;
        a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
        localZoomItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
        if (localZoomItem != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(localZoomItem);
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
          a(paramMotionEvent);
        }
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, true);
    if (i == 0)
    {
      e();
      return true;
    }
    paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem;
    if (((paramMotionEvent instanceof FaceLayer.FaceItem)) || ((paramMotionEvent instanceof TextLayer.TextItem))) {
      c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem);
    }
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    TextLayer.c(false);
    k();
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    k();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer
 * JD-Core Version:    0.7.0.1
 */