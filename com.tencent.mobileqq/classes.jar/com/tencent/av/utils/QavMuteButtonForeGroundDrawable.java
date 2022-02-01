package com.tencent.av.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public final class QavMuteButtonForeGroundDrawable
  extends Drawable
{
  private Paint a;
  private final int b;
  private final int c;
  private RectF d;
  private Rect e;
  private HashMap<Integer, ArrayList<Bitmap>> f = new HashMap();
  private int g = -1;
  private int h;
  private Rect i = new Rect();
  private boolean j = false;
  
  public QavMuteButtonForeGroundDrawable(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = new Paint(6);
    this.a.setAntiAlias(true);
    this.e = new Rect();
    this.d = new RectF(0.0F, 0.0F, this.b, this.c);
  }
  
  private ArrayList<Bitmap> a()
  {
    return (ArrayList)this.f.get(Integer.valueOf(this.g));
  }
  
  private void a(Canvas paramCanvas) {}
  
  private boolean b()
  {
    int k = this.g;
    if (k != 1) {
      return k == 3;
    }
    return true;
  }
  
  public void a(int paramInt)
  {
    if (this.g == paramInt) {
      return;
    }
    this.g = paramInt;
    invalidateSelf();
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    ArrayList localArrayList = (ArrayList)this.f.get(Integer.valueOf(paramInt));
    if (localArrayList != null)
    {
      localArrayList.add(paramBitmap);
      return;
    }
    localArrayList = new ArrayList();
    localArrayList.add(paramBitmap);
    this.f.put(Integer.valueOf(paramInt), localArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    a(paramCanvas);
    Object localObject2 = a();
    Object localObject1;
    if (b())
    {
      localObject1 = (Bitmap)((ArrayList)localObject2).get(0);
      this.e.set(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      paramCanvas.drawBitmap((Bitmap)localObject1, this.e, this.d, this.a);
      return;
    }
    int k = this.g;
    if (k == 0)
    {
      localObject1 = (Bitmap)((ArrayList)localObject2).get(0);
      localObject2 = (Bitmap)((ArrayList)localObject2).get(1);
      this.e.set(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      paramCanvas.drawBitmap((Bitmap)localObject1, this.e, this.d, this.a);
      paramCanvas.save();
      k = (int)(this.c * (10000 - this.h) / 10000.0F);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doUpdateAudioVolumeChange nexValue:=");
        ((StringBuilder)localObject1).append(this.h);
        QLog.d("huanxxiao", 1, ((StringBuilder)localObject1).toString());
      }
      this.i.set(0, k, this.b, this.c);
      paramCanvas.clipRect(this.i);
      paramCanvas.drawBitmap((Bitmap)localObject2, null, this.d, this.a);
      paramCanvas.restore();
      return;
    }
    if (k == 2)
    {
      if (this.j) {
        localObject1 = ((ArrayList)localObject2).get(1);
      } else {
        localObject1 = ((ArrayList)localObject2).get(0);
      }
      localObject1 = (Bitmap)localObject1;
      this.e.set(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      paramCanvas.drawBitmap((Bitmap)localObject1, this.e, this.d, this.a);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.d = new RectF(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.a.getAlpha() == paramInt) {
      return;
    }
    this.a.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QavMuteButtonForeGroundDrawable
 * JD-Core Version:    0.7.0.1
 */