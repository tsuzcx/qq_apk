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
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = null;
  private Thread jdField_a_of_type_JavaLangThread = null;
  private final ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public CEOffscreenSurfaceView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
  }
  
  public void run()
  {
    while (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().isValid()) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Object localObject = new Paint();
        ((Paint)localObject).setAntiAlias(true);
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        Canvas localCanvas = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)this.jdField_a_of_type_JavaUtilArrayList.remove(0));
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)localIterator.next();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
          localIterator.remove();
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
          localCanvas.drawPaint((Paint)localObject);
          ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
          localCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, (Paint)localObject);
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas);
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          System.gc();
        }
      }
    }
  }
  
  public void setRenderData(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    this.jdField_a_of_type_JavaUtilArrayList.add(0, paramBitmap);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenSurfaceView
 * JD-Core Version:    0.7.0.1
 */