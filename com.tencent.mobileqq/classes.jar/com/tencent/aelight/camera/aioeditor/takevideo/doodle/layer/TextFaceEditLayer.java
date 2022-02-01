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
  public GestureHelper.ZoomItem b;
  public GestureHelper c = new GestureHelper();
  public int d;
  public boolean e;
  public TextFaceEditLayer.LayerListener f;
  
  public TextFaceEditLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.c.a(true);
    this.c.a(6.0F);
    this.c.b(0.2F);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.c.a(this.b, paramFloat1, paramFloat2, true);
  }
  
  private void c(GestureHelper.ZoomItem paramZoomItem)
  {
    boolean bool1 = this.c.a(paramZoomItem, StoryGuideLineView.a, true);
    boolean bool2 = this.c.a(paramZoomItem, StoryGuideLineView.b, false);
    boolean bool3 = this.c.b(paramZoomItem, StoryGuideLineView.d, false);
    TextFaceEditLayer.LayerListener localLayerListener = this.f;
    if (localLayerListener != null) {
      localLayerListener.a(bool1, bool2, false, bool3, paramZoomItem.S);
    }
    if (paramZoomItem != null)
    {
      if (paramZoomItem.M)
      {
        this.z.a(paramZoomItem.S, paramZoomItem.C, paramZoomItem.D, paramZoomItem.E, paramZoomItem.A, paramZoomItem.T, 2);
        return;
      }
      this.z.a(paramZoomItem.S, paramZoomItem.C, paramZoomItem.D, paramZoomItem.E, paramZoomItem.A, paramZoomItem.T, 1);
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.c.a(this.b, f1, f2))
    {
      this.b.O = 0;
      return;
    }
    if (this.c.c(this.b, f1, f2))
    {
      this.b.O = 1;
      return;
    }
    if (this.c.b(this.b, f1, f2)) {
      this.b.O = 2;
    }
  }
  
  private void f(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject;
    if (this.c.a(this.b, f1, f2))
    {
      paramMotionEvent = this.f;
      if (paramMotionEvent != null)
      {
        localObject = this.b;
        if ((localObject instanceof TextLayer.TextItem))
        {
          paramMotionEvent = ((TextLayer.TextItem)localObject).c;
          if (paramMotionEvent != null) {
            this.f.a(this.b, paramMotionEvent.g(), 2);
          }
        }
        else
        {
          paramMotionEvent.a((GestureHelper.ZoomItem)localObject, 0, 0);
        }
      }
    }
    else if (this.c.c(this.b, f1, f2))
    {
      paramMotionEvent = this.f;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.b);
      }
    }
    else if (this.c.b(this.b, f1, f2))
    {
      paramMotionEvent = this.f;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(this.b);
      }
    }
    else if ((this.c.a(this.b, f1, f2, true)) && (this.f != null))
    {
      localObject = this.b;
      if (localObject != null) {
        if ((localObject instanceof TextLayer.TextItem))
        {
          localObject = ((TextLayer.TextItem)localObject).c;
          if (localObject != null)
          {
            if ((((DynamicTextItem)localObject).a()) && (((DynamicTextItem)localObject).q()))
            {
              int i = ((DynamicTextItem)localObject).a(paramMotionEvent, s(), t(), (TextLayer.TextItem)this.b, this.c);
              ((DynamicTextItem)localObject).e(i);
              this.f.a(this.b, i, 3, f1, f2);
              return;
            }
            this.f.a(this.b, ((DynamicTextItem)localObject).g(), 0, f1, f2);
          }
        }
        else
        {
          paramMotionEvent = a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("click the item:");
          ((StringBuilder)localObject).append(this.b);
          SLog.b(paramMotionEvent, ((StringBuilder)localObject).toString());
          this.f.a(this.b, 0, 0, f1, f2);
        }
      }
    }
  }
  
  private void j()
  {
    this.z.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public String a()
  {
    return a;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.b == null) {
      return;
    }
    paramCanvas.save();
    this.b.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(TextFaceEditLayer.LayerListener paramLayerListener)
  {
    this.f = paramLayerListener;
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    this.b = paramZoomItem;
    if (this.b == null) {
      return;
    }
    TextLayer.c(true);
    paramZoomItem = this.b;
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      this.c.a(6.0F);
      this.c.b(0.2F);
      return;
    }
    if (((paramZoomItem instanceof FaceLayer.FaceItem)) || ((paramZoomItem instanceof FaceLayer.FaceAndTextItem)))
    {
      this.c.a(18.0F);
      this.c.b(0.2F);
    }
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b()
  {
    this.b = null;
    this.c.a();
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
    paramZoomItem.M = true;
    if (this.b != null) {
      paramZoomItem.U.lockData(this.b.U.isDataLocked());
    }
    if ((paramZoomItem instanceof FaceLayer.FaceItem))
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
      if ((localFaceItem.y == 1) || (localFaceItem.y == 3)) {
        localFaceItem.l.setCallback(this);
      }
    }
    this.b = paramZoomItem;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    String str;
    StringBuilder localStringBuilder;
    if (this.c.a(this.b, f1, f2, true))
    {
      if (QLog.isColorLevel())
      {
        str = a;
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
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("accept outside x:");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(" y:");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (this.K != null) {
      this.K.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.d);
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
        this.e = true;
        continue;
        if (!this.e) {
          f(paramMotionEvent);
        }
        GestureHelper.ZoomItem localZoomItem = this.b;
        if (localZoomItem != null) {
          localZoomItem.O = -1;
        }
        this.c.a();
        break;
        this.d = j;
        this.e = false;
        a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
        localZoomItem = this.b;
        if (localZoomItem != null) {
          this.c.a(localZoomItem);
        }
        if (this.b != null) {
          e(paramMotionEvent);
        }
      }
    }
    this.c.a(paramMotionEvent, true);
    if (i == 0)
    {
      j();
      return true;
    }
    paramMotionEvent = this.b;
    if (((paramMotionEvent instanceof FaceLayer.FaceItem)) || ((paramMotionEvent instanceof TextLayer.TextItem))) {
      c(this.b);
    }
    return true;
  }
  
  public boolean d()
  {
    return this.b != null;
  }
  
  public GestureHelper.ZoomItem h()
  {
    return this.b;
  }
  
  public void i()
  {
    this.b = null;
    TextLayer.c(false);
    u();
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    u();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer
 * JD-Core Version:    0.7.0.1
 */