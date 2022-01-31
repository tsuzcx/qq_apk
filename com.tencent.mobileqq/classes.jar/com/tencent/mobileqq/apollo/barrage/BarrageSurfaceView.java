package com.tencent.mobileqq.apollo.barrage;

import aijg;
import aijh;
import aiji;
import aijk;
import aijl;
import aijm;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import befq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class BarrageSurfaceView
  extends SurfaceView
  implements aijl, Handler.Callback, SurfaceHolder.Callback
{
  private int jdField_a_of_type_Int;
  private aijg jdField_a_of_type_Aijg;
  private aijh<Canvas> jdField_a_of_type_Aijh;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private befq jdField_a_of_type_Befq;
  private int b;
  
  public BarrageSurfaceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BarrageSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    super.setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = super.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-3);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Befq == null) {
      return;
    }
    this.jdField_a_of_type_Befq.removeMessages(16);
    this.jdField_a_of_type_Befq.sendEmptyMessage(16);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aijg a()
  {
    if (this.jdField_a_of_type_Aijg == null) {
      this.jdField_a_of_type_Aijg = new aiji();
    }
    return this.jdField_a_of_type_Aijg;
  }
  
  public void a(List<aijk> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Befq == null) {}
    while (paramList == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Befq.obtainMessage(13);
    localMessage.obj = paramList;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Befq == null) {
      return;
    }
    this.jdField_a_of_type_Befq.obtainMessage(15).sendToTarget();
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (this.jdField_a_of_type_Aijh == null);
          localObject = (List)paramMessage.obj;
          if (paramMessage.arg1 > 0) {
            this.jdField_a_of_type_Aijh.a(false);
          }
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            paramMessage = ((List)localObject).iterator();
            while (paramMessage.hasNext()) {
              ((aijk)paramMessage.next()).a();
            }
          }
          this.jdField_a_of_type_Aijh.a((List)localObject);
          b();
          return false;
        } while (this.jdField_a_of_type_Aijh == null);
        paramMessage = (aijk)paramMessage.obj;
        this.jdField_a_of_type_Aijh.a(paramMessage);
        b();
        return false;
      } while (this.jdField_a_of_type_Aijh == null);
      this.jdField_a_of_type_Aijh.a(false);
      b();
      return false;
    } while (this.jdField_a_of_type_Aijh == null);
    long l = System.currentTimeMillis();
    localObject = null;
    paramMessage = null;
    boolean bool2 = true;
    SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceHolder;
    bool1 = bool2;
    for (;;)
    {
      try
      {
        localCanvas = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.save();
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        bool2 = this.jdField_a_of_type_Aijh.a(localCanvas, 1.0F);
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.restore();
        bool3 = bool2;
        if (localCanvas == null) {}
      }
      catch (Exception localException)
      {
        Canvas localCanvas;
        localObject = paramMessage;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = paramMessage;
        QLog.e("BarrageSurfaceView", 2, localException.getMessage());
        boolean bool3 = bool1;
        if (paramMessage == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramMessage);
        bool3 = bool1;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost((Canvas)localObject);
      }
      try
      {
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas);
        bool3 = bool2;
        if ((bool3) && (this.jdField_a_of_type_Befq != null)) {
          this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(16, 20L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("BarrageSurfaceView", 2, "handle MSG_CODE_DRAW_BARRAGE use->" + (System.currentTimeMillis() - l));
        }
        return false;
      }
      finally {}
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_Aijg == null) {
      this.jdField_a_of_type_Aijg = new aiji();
    }
    if (this.jdField_a_of_type_Aijh == null) {
      this.jdField_a_of_type_Aijh = new aijm();
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Barrage-Surface-Thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Befq = new befq(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageSurfaceView
 * JD-Core Version:    0.7.0.1
 */