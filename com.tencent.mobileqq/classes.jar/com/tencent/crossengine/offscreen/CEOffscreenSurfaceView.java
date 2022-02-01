package com.tencent.crossengine.offscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CEOffscreenSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2, Runnable
{
  private Thread a = null;
  private SurfaceHolder b = null;
  private volatile boolean c = false;
  private final Lock d = new ReentrantLock();
  private final ArrayList<Bitmap> e = new ArrayList();
  private Bitmap f = null;
  
  public CEOffscreenSurfaceView(Context paramContext)
  {
    super(paramContext);
    this.b.setFormat(-2);
    this.b.addCallback(this);
  }
  
  public void run()
  {
    while (this.c) {
      if ((this.b.getSurface().isValid()) && (!this.e.isEmpty()))
      {
        Object localObject = new Paint();
        ((Paint)localObject).setAntiAlias(true);
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        Canvas localCanvas = this.b.lockCanvas();
        this.d.lock();
        this.f = ((Bitmap)this.e.remove(0));
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)localIterator.next();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
          localIterator.remove();
        }
        this.e.clear();
        this.d.unlock();
        if (this.f != null)
        {
          ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
          localCanvas.drawPaint((Paint)localObject);
          ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
          localCanvas.drawBitmap(this.f, 0.0F, 0.0F, (Paint)localObject);
        }
        this.b.unlockCanvasAndPost(localCanvas);
        localObject = this.f;
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          this.f.recycle();
          this.f = null;
          System.gc();
        }
      }
    }
  }
  
  public void setRenderData(Bitmap paramBitmap)
  {
    this.d.lock();
    this.e.add(0, paramBitmap);
    this.d.unlock();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenSurfaceView
 * JD-Core Version:    0.7.0.1
 */