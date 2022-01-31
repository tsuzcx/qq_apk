package com.tencent.av.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import lgf;
import lmd;
import lme;
import lmf;
import lmh;

public class DoodleSurfaceView
  extends MySurfaceView
  implements Handler.Callback, lmf
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public Handler a;
  private lme jdField_a_of_type_Lme;
  private long jdField_b_of_type_Long = -1L;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  
  public DoodleSurfaceView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DoodleSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DoodleSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Lme.a(0, paramFloat1, paramFloat2);
  }
  
  @TargetApi(11)
  private void a(Context paramContext)
  {
    setId(2131372240);
    setClickable(false);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    a(lme.a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(Canvas paramCanvas, lmd paramlmd, boolean paramBoolean)
  {
    if (paramlmd != null) {
      paramlmd.a(paramCanvas, this, paramBoolean);
    }
  }
  
  private void a(lme paramlme)
  {
    this.jdField_a_of_type_Lme = paramlme;
    this.jdField_a_of_type_Lme.d = getHeight();
    this.jdField_a_of_type_Lme.c = getWidth();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      try
      {
        if (((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() == paramInt1) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() == paramInt2)) || (paramInt1 == 0) || (paramInt2 == 0)) {
          return;
        }
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
            return;
          }
          synchronized (this.jdField_a_of_type_AndroidGraphicsCanvas)
          {
            this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
            return;
          }
          QLog.e("DoodleSurfaceView", 2, "WL_DEBUG updateBitmap e = " + localThrowable);
        }
        catch (Throwable localThrowable)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("DoodleSurfaceView", 2, "WL_DEBUG updateBitmap e = " + localException);
    }
    else if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Lme.b(0, paramFloat1, paramFloat2);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Lme.c(0, paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {}
    synchronized (this.jdField_a_of_type_AndroidGraphicsCanvas)
    {
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[paramInt], false);
      if (this.jdField_b_of_type_Long == -1L) {
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[paramInt].jdField_a_of_type_Long;
      }
      return;
    }
  }
  
  protected void a(long paramLong)
  {
    this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    Object localObject3;
    try
    {
      if ((this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfBoolean[1] != 0) || (this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfBoolean[0] != 0))
      {
        Iterator localIterator = this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (lmd)localIterator.next();
          if (this.jdField_a_of_type_Long - ((lmd)localObject3).jdField_a_of_type_Long <= 1200L) {
            ((lmd)localObject3).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
          }
        }
      }
      if (this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() <= 0) {
        break label225;
      }
    }
    finally
    {
      this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    for (;;)
    {
      ??? = (lmd)this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
      if ((??? == null) || (this.jdField_a_of_type_Long - ((lmd)???).jdField_a_of_type_Long <= 2000L)) {
        break;
      }
      this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      QLog.w("DoodleSurfaceView", 1, "onUpdateDoodle, poll[" + ??? + "], size[" + this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + "]");
    }
    label225:
    ??? = this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (lmd)((Iterator)???).next();
      if (this.jdField_a_of_type_Long - ((lmd)localObject3).jdField_a_of_type_Long <= 1200L) {
        break;
      }
      ((lmd)localObject3).a(paramLong);
    }
    if ((this.jdField_b_of_type_Long != -1L) && (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long > 1200L) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      long l1;
      synchronized (this.jdField_a_of_type_AndroidGraphicsCanvas)
      {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_b_of_type_AndroidGraphicsPaint);
        l1 = -1L;
        localObject3 = this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          lmd locallmd = (lmd)((Iterator)localObject3).next();
          long l2 = l1;
          if (l1 == -1L)
          {
            l2 = l1;
            if (this.jdField_a_of_type_Long - locallmd.jdField_a_of_type_Long <= 1200L) {
              l2 = locallmd.jdField_a_of_type_Long;
            }
          }
          l1 = l2;
          if (l2 != -1L)
          {
            l1 = l2;
            if (locallmd.jdField_a_of_type_Long - l2 >= 0L)
            {
              a(this.jdField_a_of_type_AndroidGraphicsCanvas, locallmd, false);
              l1 = l2;
            }
          }
        }
      }
      this.jdField_b_of_type_Long = l1;
    }
    this.jdField_a_of_type_Lme.b(paramLong);
    this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      paramCanvas.drawPaint(this.jdField_b_of_type_AndroidGraphicsPaint);
      Object localObject = this.jdField_a_of_type_Lme.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((!this.jdField_a_of_type_Lme.jdField_a_of_type_ComTencentAvVideoController.q()) && ((localObject == null) || (((lgf)localObject).d != 2))) {
        break label245;
      }
      localObject = this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (((Iterator)localObject).hasNext())
      {
        lmd locallmd = (lmd)((Iterator)localObject).next();
        if ((this.jdField_b_of_type_Long == -1L) || (locallmd.jdField_a_of_type_Long - this.jdField_b_of_type_Long < 0L)) {
          a(paramCanvas, locallmd, false);
        }
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label205;
      }
    }
    finally
    {
      this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if ((this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) && (this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[0] == null) && (this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[1] == null)) {
        b(false);
      }
    }
    if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    label205:
    if (this.jdField_a_of_type_Lme.jdField_a_of_type_Boolean)
    {
      a(paramCanvas, this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[1], true);
      a(paramCanvas, this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[0], true);
    }
    for (;;)
    {
      label245:
      this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if ((this.jdField_a_of_type_Lme.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) && (this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[0] == null) && (this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[1] == null)) {
        b(false);
      }
      return;
      a(paramCanvas, this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[0], true);
      a(paramCanvas, this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[1], true);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    a(paramBoolean, getWidth(), getHeight());
    if ((!paramBoolean) && (!isClickable()))
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleSurfaceView", 2, "handleMessage, msg.what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (ViewGroup)getParent();
      if (paramMessage != null) {
        paramMessage.removeView(this);
      }
    }
  }
  
  public void invalidate()
  {
    b(true);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {}
    try
    {
      a(a(), paramInt1, paramInt2);
      if (this.jdField_a_of_type_Lme != null)
      {
        this.jdField_a_of_type_Lme.d = paramInt2;
        this.jdField_a_of_type_Lme.c = paramInt1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DoodleSurfaceView", 2, "WL_DEBUG onSizeChanged e = " + localThrowable);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = isClickable();
    if (bool)
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      }
    }
    while (this.jdField_a_of_type_Lme.jdField_a_of_type_ArrayOfLmd[0] == null)
    {
      float f1;
      float f2;
      do
      {
        return bool;
        localObject = (View)getParent();
      } while (!bool);
      a(f1, f2);
      paramMotionEvent = getContext();
      if ((paramMotionEvent instanceof AVActivity))
      {
        localObject = ((View)localObject).findViewById(2131372229);
        if (localObject != null)
        {
          paramMotionEvent = ((AVActivity)paramMotionEvent).a;
          ((View)localObject).startAnimation(paramMotionEvent.a(false));
          paramMotionEvent.K();
        }
      }
      invalidate();
      return bool;
      b(f1, f2);
      invalidate();
      return bool;
      c(f1, f2);
      Object localObject = getContext();
      if ((localObject instanceof AVActivity))
      {
        paramMotionEvent = ((View)getParent()).findViewById(2131372229);
        if (paramMotionEvent != null)
        {
          localObject = ((AVActivity)localObject).a;
          if (localObject != null)
          {
            paramMotionEvent.startAnimation(((VideoControlUI)localObject).a(true));
            ((VideoControlUI)localObject).K();
          }
        }
      }
      invalidate();
      return bool;
    }
    c(paramMotionEvent.getX(), paramMotionEvent.getY());
    invalidate();
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Lme != null))
    {
      this.jdField_a_of_type_Lme.d = getHeight();
      this.jdField_a_of_type_Lme.c = getWidth();
    }
  }
  
  public void setColor(int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_Lme.jdField_a_of_type_Lmh.a(this.jdField_a_of_type_Lme.jdField_a_of_type_Int);
    this.jdField_a_of_type_Lme.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Lme.b = paramInt2;
    this.jdField_a_of_type_Lme.jdField_a_of_type_Float = paramFloat;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_Lme.a() != this) {
      this.jdField_a_of_type_Lme.a(this);
    }
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.jdField_a_of_type_Lme.a() == this) {
      this.jdField_a_of_type_Lme.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleSurfaceView
 * JD-Core Version:    0.7.0.1
 */