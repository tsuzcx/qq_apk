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
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class DoodleSurfaceView
  extends MySurfaceView
  implements Handler.Callback, DoodleLogic.DoodleLogicListener
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public Handler a;
  private DoodleLogic jdField_a_of_type_ComTencentAvDoodleDoodleLogic = null;
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
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.a(0, paramFloat1, paramFloat2);
  }
  
  @TargetApi(11)
  private void a(Context paramContext)
  {
    setId(2131373377);
    setClickable(false);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    a(DoodleLogic.a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(Canvas paramCanvas, DoodleItem paramDoodleItem, boolean paramBoolean)
  {
    if (paramDoodleItem != null) {
      paramDoodleItem.a(paramCanvas, this, paramBoolean);
    }
  }
  
  private void a(DoodleLogic paramDoodleLogic)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic = paramDoodleLogic;
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.d = getHeight();
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.c = getWidth();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {}
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
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localStringBuilder.append("WL_DEBUG updateBitmap e = ");
      localStringBuilder.append(localThrowable);
      QLog.e("DoodleSurfaceView", 2, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WL_DEBUG updateBitmap e = ");
      localStringBuilder.append(localException);
      QLog.e("DoodleSurfaceView", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      return;
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.b(0, paramFloat1, paramFloat2);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.c(0, paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt)
  {
    ??? = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((??? != null) && (!((Bitmap)???).isRecycled())) {
      synchronized (this.jdField_a_of_type_AndroidGraphicsCanvas)
      {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt], false);
      }
    }
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt].jdField_a_of_type_Long;
    }
  }
  
  protected void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      Object localObject3;
      if ((this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfBoolean[1] != 0) || (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfBoolean[0] != 0))
      {
        ??? = this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (DoodleItem)((Iterator)???).next();
          if (this.jdField_a_of_type_Long - ((DoodleItem)localObject3).jdField_a_of_type_Long <= 1200L) {
            ((DoodleItem)localObject3).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
          }
        }
      }
      while (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0)
      {
        ??? = (DoodleItem)this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if ((??? == null) || (this.jdField_a_of_type_Long - ((DoodleItem)???).jdField_a_of_type_Long <= 2000L)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onUpdateDoodle, poll[");
        ((StringBuilder)localObject3).append(???);
        ((StringBuilder)localObject3).append("], size[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        ((StringBuilder)localObject3).append("]");
        QLog.w("DoodleSurfaceView", 1, ((StringBuilder)localObject3).toString());
      }
      ??? = this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (DoodleItem)((Iterator)???).next();
        if (this.jdField_a_of_type_Long - ((DoodleItem)localObject3).jdField_a_of_type_Long <= 1200L) {
          break;
        }
        ((DoodleItem)localObject3).a(paramLong);
      }
      if ((this.jdField_b_of_type_Long != -1L) && (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long > 1200L) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        synchronized (this.jdField_a_of_type_AndroidGraphicsCanvas)
        {
          this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_b_of_type_AndroidGraphicsPaint);
          localObject3 = this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          long l1 = -1L;
          while (((Iterator)localObject3).hasNext())
          {
            DoodleItem localDoodleItem = (DoodleItem)((Iterator)localObject3).next();
            long l2 = l1;
            if (l1 == -1L)
            {
              l2 = l1;
              if (this.jdField_a_of_type_Long - localDoodleItem.jdField_a_of_type_Long <= 1200L) {
                l2 = localDoodleItem.jdField_a_of_type_Long;
              }
            }
            l1 = l2;
            if (l2 != -1L)
            {
              l1 = l2;
              if (localDoodleItem.jdField_a_of_type_Long - l2 >= 0L)
              {
                a(this.jdField_a_of_type_AndroidGraphicsCanvas, localDoodleItem, false);
                l1 = l2;
              }
            }
          }
          this.jdField_b_of_type_Long = l1;
        }
      }
      this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.b(paramLong);
      this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      paramCanvas.drawPaint(this.jdField_b_of_type_AndroidGraphicsPaint);
      Object localObject = VideoController.a().a();
      if ((localObject != null) && (((SessionInfo)localObject).d == 2))
      {
        localObject = this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (((Iterator)localObject).hasNext())
        {
          DoodleItem localDoodleItem = (DoodleItem)((Iterator)localObject).next();
          if ((this.jdField_b_of_type_Long == -1L) || (localDoodleItem.jdField_a_of_type_Long - this.jdField_b_of_type_Long < 0L)) {
            a(paramCanvas, localDoodleItem, false);
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_Boolean)
        {
          a(paramCanvas, this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1], true);
          a(paramCanvas, this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0], true);
        }
        else
        {
          a(paramCanvas, this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0], true);
          a(paramCanvas, this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1], true);
        }
      }
      this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if ((this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) && (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0] == null) && (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] == null)) {
        b(false);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if ((this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) && (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0] == null) && (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] == null)) {
        b(false);
      }
    }
    for (;;)
    {
      throw paramCanvas;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage, msg.what=");
      localStringBuilder.append(paramMessage.what);
      QLog.d("DoodleSurfaceView", 2, localStringBuilder.toString());
    }
    if (paramMessage.what == 0)
    {
      paramMessage = (ViewGroup)getParent();
      if (paramMessage != null) {
        paramMessage.removeView(this);
      }
    }
    return false;
  }
  
  public void invalidate()
  {
    b(true);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      try
      {
        a(a(), paramInt1, paramInt2);
        if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic != null)
        {
          this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.d = paramInt2;
          this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.c = paramInt1;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("WL_DEBUG onSizeChanged e = ");
          localStringBuilder.append(localThrowable);
          QLog.e("DoodleSurfaceView", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = isClickable();
    if (bool)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              return bool;
            }
          }
          else
          {
            b(f1, f2);
            invalidate();
            return bool;
          }
        }
        c(f1, f2);
        localObject = getContext();
        if ((localObject instanceof AVActivity))
        {
          paramMotionEvent = ((View)getParent()).findViewById(2131373367);
          if (paramMotionEvent != null)
          {
            localObject = ((AVActivity)localObject).a;
            if (localObject != null)
            {
              paramMotionEvent.startAnimation(((VideoControlUI)localObject).a(true));
              ((VideoControlUI)localObject).N();
            }
          }
        }
        invalidate();
        return bool;
      }
      Object localObject = (View)getParent();
      if (bool)
      {
        a(f1, f2);
        paramMotionEvent = getContext();
        if ((paramMotionEvent instanceof AVActivity))
        {
          localObject = ((View)localObject).findViewById(2131373367);
          if (localObject != null)
          {
            paramMotionEvent = ((AVActivity)paramMotionEvent).a;
            ((View)localObject).startAnimation(paramMotionEvent.a(false));
            paramMotionEvent.N();
          }
        }
        invalidate();
        return bool;
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0] != null)
    {
      c(paramMotionEvent.getX(), paramMotionEvent.getY());
      invalidate();
    }
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      DoodleLogic localDoodleLogic = this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic;
      if (localDoodleLogic != null)
      {
        localDoodleLogic.d = getHeight();
        this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.c = getWidth();
      }
    }
  }
  
  public void setColor(int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_ComTencentAvDoodleDoodleReportController.a(this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.jdField_a_of_type_Int);
    DoodleLogic localDoodleLogic = this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic;
    localDoodleLogic.jdField_a_of_type_Int = paramInt1;
    localDoodleLogic.b = paramInt2;
    localDoodleLogic.jdField_a_of_type_Float = paramFloat;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.a() != this) {
      this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.a(this);
    }
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.a() == this) {
      this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleSurfaceView
 * JD-Core Version:    0.7.0.1
 */