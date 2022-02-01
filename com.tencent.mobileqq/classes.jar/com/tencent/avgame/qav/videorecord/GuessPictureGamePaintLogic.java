package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class GuessPictureGamePaintLogic
{
  public int a;
  public int b;
  private GameImageData c;
  private Object d = new Object();
  private volatile boolean e;
  private int f;
  private int g;
  
  public int a(ArrayList<GameImageData> paramArrayList)
  {
    boolean bool = false;
    Bitmap localBitmap;
    Canvas localCanvas;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      if (((GameImageData)paramArrayList.get(0)).a == null) {
        return 0;
      }
      localBitmap = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      a(localCanvas, (GameImageData)paramArrayList.get(0), true);
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (QLog.isColorLevel())
        {
          if (this.c == null) {
            bool = true;
          }
          QLog.d("GuessPictureGamePaintLogic", 2, new Object[] { "generateTexture, AnswerImageDataIsNull:", Boolean.valueOf(bool) });
        }
        if (this.c == null) {
          break label207;
        }
        localCanvas.drawColor(this.c.f);
        b(localCanvas, this.c, true);
        continue;
        if (i < paramArrayList.size())
        {
          b(localCanvas, (GameImageData)paramArrayList.get(i), true);
          i += 1;
          continue;
        }
        i = GlUtil.createTexture(3553, localBitmap);
        localBitmap.recycle();
        return i;
      }
      return 0;
      label207:
      int i = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.a = paramInt3;
    this.b = paramInt4;
  }
  
  public void a(Canvas paramCanvas, GameImageData paramGameImageData, boolean paramBoolean)
  {
    paramGameImageData = paramGameImageData.a;
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(new RectF(0.0F, 0.0F, paramGameImageData.getWidth(), paramGameImageData.getHeight()), new RectF(0.0F, 0.0F, this.a, this.b), Matrix.ScaleToFit.FILL);
    if (paramBoolean) {
      localMatrix.postScale(1.0F, -1.0F, this.a / 2, this.b / 2);
    }
    if (!paramGameImageData.isRecycled()) {
      paramCanvas.drawBitmap(paramGameImageData, localMatrix, null);
    }
  }
  
  public void a(View arg1)
  {
    synchronized (this.d)
    {
      if ((this.c != null) && (!this.c.a.isRecycled())) {
        this.c.a.recycle();
      }
      this.c = null;
      this.e = true;
      return;
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().postDelayed(new GuessPictureGamePaintLogic.1(this, paramView, paramInt, paramBoolean), 200L);
  }
  
  public boolean a()
  {
    GameImageData localGameImageData = this.c;
    return (localGameImageData != null) && (localGameImageData.i);
  }
  
  public void b(Canvas paramCanvas, GameImageData paramGameImageData, boolean paramBoolean)
  {
    if (paramGameImageData.a == null) {
      return;
    }
    int i = paramGameImageData.a.getWidth();
    int j = paramGameImageData.a.getHeight();
    float f1 = this.f / this.a;
    float f2 = this.g / this.b;
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(new RectF(0.0F, 0.0F, i, j), new RectF(paramGameImageData.d / f1, paramGameImageData.e / f2, (paramGameImageData.d + i) / f1, (paramGameImageData.e + j) / f2), Matrix.ScaleToFit.CENTER);
    if (paramBoolean) {
      localMatrix.postScale(1.0F, -1.0F, this.a / 2, this.b / 2);
    }
    if (!paramGameImageData.a.isRecycled()) {
      paramCanvas.drawBitmap(paramGameImageData.a, localMatrix, null);
    }
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GuessPictureGamePaintLogic
 * JD-Core Version:    0.7.0.1
 */