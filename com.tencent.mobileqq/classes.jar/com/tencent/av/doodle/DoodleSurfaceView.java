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
  public Handler a;
  private Bitmap c;
  private Canvas d = new Canvas();
  private Paint e;
  private DoodleLogic f = null;
  private Paint g;
  private long h = -1L;
  
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
    this.f.a(0, paramFloat1, paramFloat2);
  }
  
  @TargetApi(11)
  private void a(Context paramContext)
  {
    setId(2131441050);
    setClickable(false);
    this.e = new Paint();
    this.g = new Paint();
    this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setDoodleLogic(DoodleLogic.b());
    this.a = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(Canvas paramCanvas, DoodleItem paramDoodleItem, boolean paramBoolean)
  {
    if (paramDoodleItem != null) {
      paramDoodleItem.a(paramCanvas, this, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {}
    try
    {
      if (((this.c != null) && (!this.c.isRecycled()) && (this.c.getWidth() == paramInt1) && (this.c.getHeight() == paramInt2)) || (paramInt1 == 0) || (paramInt2 == 0)) {
        return;
      }
      if ((this.c != null) && (!this.c.isRecycled())) {
        this.c.recycle();
      }
      try
      {
        this.c = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        if (this.c == null) {
          return;
        }
        synchronized (this.d)
        {
          this.d.setBitmap(this.c);
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
    if (this.c != null)
    {
      if (!this.c.isRecycled()) {
        this.c.recycle();
      }
      this.c = null;
      return;
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.f.b(0, paramFloat1, paramFloat2);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    this.f.c(0, paramFloat1, paramFloat2);
  }
  
  private void setDoodleLogic(DoodleLogic paramDoodleLogic)
  {
    this.f = paramDoodleLogic;
    this.f.h = getHeight();
    this.f.g = getWidth();
  }
  
  public void a(int paramInt)
  {
    ??? = this.c;
    if ((??? != null) && (!((Bitmap)???).isRecycled())) {
      synchronized (this.d)
      {
        a(this.d, this.f.b[paramInt], false);
      }
    }
    if (this.h == -1L) {
      this.h = this.f.b[paramInt].i;
    }
  }
  
  protected void a(long paramLong)
  {
    this.f.i.lock();
    try
    {
      Object localObject3;
      if ((this.f.j[1] != 0) || (this.f.j[0] != 0))
      {
        ??? = this.f.a.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (DoodleItem)((Iterator)???).next();
          if (this.b - ((DoodleItem)localObject3).i <= 1200L) {
            ((DoodleItem)localObject3).i = this.b;
          }
        }
      }
      while (this.f.a.size() > 0)
      {
        ??? = (DoodleItem)this.f.a.peek();
        if ((??? == null) || (this.b - ((DoodleItem)???).i <= 2000L)) {
          break;
        }
        this.f.a.poll();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onUpdateDoodle, poll[");
        ((StringBuilder)localObject3).append(???);
        ((StringBuilder)localObject3).append("], size[");
        ((StringBuilder)localObject3).append(this.f.a.size());
        ((StringBuilder)localObject3).append("]");
        QLog.w("DoodleSurfaceView", 1, ((StringBuilder)localObject3).toString());
      }
      ??? = this.f.a.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (DoodleItem)((Iterator)???).next();
        if (this.b - ((DoodleItem)localObject3).i <= 1200L) {
          break;
        }
        ((DoodleItem)localObject3).a(paramLong);
      }
      if ((this.h != -1L) && (this.b - this.h > 1200L) && (this.c != null) && (!this.c.isRecycled())) {
        synchronized (this.d)
        {
          this.d.drawPaint(this.g);
          localObject3 = this.f.a.iterator();
          long l1 = -1L;
          while (((Iterator)localObject3).hasNext())
          {
            DoodleItem localDoodleItem = (DoodleItem)((Iterator)localObject3).next();
            long l2 = l1;
            if (l1 == -1L)
            {
              l2 = l1;
              if (this.b - localDoodleItem.i <= 1200L) {
                l2 = localDoodleItem.i;
              }
            }
            l1 = l2;
            if (l2 != -1L)
            {
              l1 = l2;
              if (localDoodleItem.i - l2 >= 0L)
              {
                a(this.d, localDoodleItem, false);
                l1 = l2;
              }
            }
          }
          this.h = l1;
        }
      }
      this.f.b(paramLong);
      this.f.i.unlock();
      return;
    }
    finally
    {
      this.f.i.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.f.i.lock();
    try
    {
      paramCanvas.drawPaint(this.g);
      Object localObject = VideoController.f().k();
      if ((localObject != null) && (((SessionInfo)localObject).g == 2))
      {
        localObject = this.f.a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          DoodleItem localDoodleItem = (DoodleItem)((Iterator)localObject).next();
          if ((this.h == -1L) || (localDoodleItem.i - this.h < 0L)) {
            a(paramCanvas, localDoodleItem, false);
          }
        }
        if ((this.c != null) && (!this.c.isRecycled())) {
          paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.e);
        }
        if (this.f.c)
        {
          a(paramCanvas, this.f.b[1], true);
          a(paramCanvas, this.f.b[0], true);
        }
        else
        {
          a(paramCanvas, this.f.b[0], true);
          a(paramCanvas, this.f.b[1], true);
        }
      }
      this.f.i.unlock();
      if ((this.f.a.isEmpty()) && (this.f.b[0] == null) && (this.f.b[1] == null)) {
        setRunning(false);
      }
      return;
    }
    finally
    {
      this.f.i.unlock();
      if ((this.f.a.isEmpty()) && (this.f.b[0] == null) && (this.f.b[1] == null)) {
        setRunning(false);
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
      this.a.sendMessage(localMessage);
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
    setRunning(true);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      try
      {
        a(getRunning(), paramInt1, paramInt2);
        if (this.f != null)
        {
          this.f.h = paramInt2;
          this.f.g = paramInt1;
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
          paramMotionEvent = ((View)getParent()).findViewById(2131441040);
          if (paramMotionEvent != null)
          {
            localObject = ((AVActivity)localObject).K;
            if (localObject != null)
            {
              paramMotionEvent.startAnimation(((VideoControlUI)localObject).j(true));
              ((VideoControlUI)localObject).ai();
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
          localObject = ((View)localObject).findViewById(2131441040);
          if (localObject != null)
          {
            paramMotionEvent = ((AVActivity)paramMotionEvent).K;
            ((View)localObject).startAnimation(paramMotionEvent.j(false));
            paramMotionEvent.ai();
          }
        }
        invalidate();
        return bool;
      }
    }
    else if (this.f.b[0] != null)
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
      DoodleLogic localDoodleLogic = this.f;
      if (localDoodleLogic != null)
      {
        localDoodleLogic.h = getHeight();
        this.f.g = getWidth();
      }
    }
  }
  
  public void setColor(int paramInt1, int paramInt2, float paramFloat)
  {
    this.f.m.a(this.f.d);
    DoodleLogic localDoodleLogic = this.f;
    localDoodleLogic.d = paramInt1;
    localDoodleLogic.e = paramInt2;
    localDoodleLogic.f = paramFloat;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.f.f() != this) {
      this.f.a(this);
    }
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.f.f() == this) {
      this.f.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleSurfaceView
 * JD-Core Version:    0.7.0.1
 */