package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CanvasDrawer
  extends AbsDrawer<Canvas>
{
  private Paint b = new Paint(2);
  private Rect c = new Rect();
  private Rect d = new Rect();
  
  public boolean a(Canvas paramCanvas, float paramFloat)
  {
    if (paramCanvas == null) {
      return false;
    }
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Barrage localBarrage = (Barrage)localIterator.next();
        localBarrage.d();
        Object localObject;
        if (!localBarrage.a())
        {
          localIterator.remove();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("remove invalidate barrage:");
            ((StringBuilder)localObject).append(localBarrage);
            QLog.d("[cmshow]CanvasDrawer", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = localBarrage.c();
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            paramCanvas.save();
            float f = 1.0F;
            if (paramFloat == 1.0F)
            {
              if (this.b.getAlpha() != localBarrage.p) {
                this.b.setAlpha(localBarrage.p);
              }
            }
            else {
              this.b.setAlpha((int)(255.0F * paramFloat));
            }
            if (localBarrage.u > 0.0F) {
              f = localBarrage.u;
            }
            paramCanvas.clipRect(localBarrage.i, localBarrage.j, localBarrage.i + localBarrage.q * f, localBarrage.j + localBarrage.r * f);
            paramCanvas.translate(localBarrage.i, localBarrage.j);
            if (localBarrage.u != 0.0F) {
              paramCanvas.scale(localBarrage.u, localBarrage.u);
            }
            this.c.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            this.d.set(0, 0, localBarrage.q, localBarrage.r);
            paramCanvas.drawBitmap((Bitmap)localObject, this.c, this.d, this.b);
            paramCanvas.restore();
          }
        }
      }
      boolean bool = this.a.isEmpty();
      return bool ^ true;
    }
    finally {}
    for (;;)
    {
      throw paramCanvas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.CanvasDrawer
 * JD-Core Version:    0.7.0.1
 */