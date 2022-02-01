package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer.LayerEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DoodleUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MosaicOperator
  implements DoodleOperator
{
  private static final int z = Color.parseColor("#FF000000");
  private int A = 103;
  private boolean B = true;
  private int C = 0;
  public byte[] a;
  public byte[][] b;
  public int c = 10;
  public float d;
  public float e;
  public int f;
  public int g;
  public int h;
  public int i;
  public MosaicLinePath j;
  public BitmapShader k;
  public Paint l = new Paint();
  public boolean m = false;
  public LineLayer.LayerEventListener n;
  DoodleLineListener o;
  float p;
  Bitmap q;
  Rect r;
  public float s;
  public float t;
  DoodleLayout u;
  public Bitmap v;
  Canvas w;
  int x;
  int y;
  
  public MosaicOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.l.setAntiAlias(true);
    this.l.setStyle(Paint.Style.STROKE);
    this.l.setStrokeJoin(Paint.Join.ROUND);
    this.l.setStrokeCap(Paint.Cap.ROUND);
    this.o = paramDoodleLineListener;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("increaseMask:x=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(",y=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(",MosaicMaskWidth:");
    ((StringBuilder)localObject1).append(this.h);
    ((StringBuilder)localObject1).append(",MosaicMaskHeight:");
    ((StringBuilder)localObject1).append(this.i);
    SLog.b("MosaicOperator", ((StringBuilder)localObject1).toString());
    localObject1 = new int[5];
    int i1 = 0;
    localObject1[0] = paramInt1;
    localObject1[1] = (paramInt1 - 1);
    localObject1[2] = paramInt1;
    localObject1[3] = (paramInt1 + 1);
    localObject1[4] = paramInt1;
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = paramInt2;
    arrayOfInt[1] = paramInt2;
    arrayOfInt[2] = (paramInt2 - 1);
    arrayOfInt[3] = paramInt2;
    arrayOfInt[4] = (paramInt2 + 1);
    paramInt1 = i1;
    while ((paramInt1 < localObject1.length) && (paramInt1 < arrayOfInt.length))
    {
      paramInt2 = localObject1[paramInt1];
      i1 = arrayOfInt[paramInt1];
      if ((paramInt2 >= 0) && (i1 >= 0))
      {
        int i2 = this.h;
        if ((paramInt2 < i2) && (i1 < this.i))
        {
          i2 = i2 * i1 + paramInt2;
          Object localObject2 = this.a;
          if (localObject2[i2] != 127) {
            localObject2[i2] = ((byte)(localObject2[i2] + 1));
          }
          if (this.m)
          {
            localObject2 = this.b;
            if (localObject2[i1][paramInt2] < 127)
            {
              localObject2 = localObject2[i1];
              localObject2[paramInt2] = ((byte)(localObject2[paramInt2] + 1));
            }
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("decreaseMask:x=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(",y=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(",MosaicMaskWidth:");
    ((StringBuilder)localObject1).append(this.h);
    ((StringBuilder)localObject1).append(",MosaicMaskHeight:");
    ((StringBuilder)localObject1).append(this.i);
    SLog.b("MosaicOperator", ((StringBuilder)localObject1).toString());
    localObject1 = new int[5];
    int i1 = 0;
    localObject1[0] = paramInt1;
    localObject1[1] = (paramInt1 - 1);
    localObject1[2] = paramInt1;
    localObject1[3] = (paramInt1 + 1);
    localObject1[4] = paramInt1;
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = paramInt2;
    arrayOfInt[1] = paramInt2;
    arrayOfInt[2] = (paramInt2 - 1);
    arrayOfInt[3] = paramInt2;
    arrayOfInt[4] = (paramInt2 + 1);
    paramInt1 = i1;
    while ((paramInt1 < localObject1.length) && (paramInt1 < arrayOfInt.length))
    {
      paramInt2 = localObject1[paramInt1];
      i1 = arrayOfInt[paramInt1];
      if ((paramInt2 >= 0) && (i1 >= 0))
      {
        int i2 = this.h;
        if ((paramInt2 < i2) && (i1 < this.i))
        {
          i2 = i2 * i1 + paramInt2;
          Object localObject2 = this.a;
          if (localObject2[i2] > 0) {
            localObject2[i2] = ((byte)(localObject2[i2] - 1));
          }
          if (this.m)
          {
            localObject2 = this.b;
            if (localObject2[i1][paramInt2] > 0)
            {
              localObject2 = localObject2[i1];
              localObject2[paramInt2] = ((byte)(localObject2[paramInt2] - 1));
            }
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void f()
  {
    if (!this.m) {
      return;
    }
    SLog.b("MosaicOperator", "------------------------------------------------------------------------");
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i1 = 0;
    while (i1 < this.b.length)
    {
      int i2 = 0;
      while (i2 < this.b[0].length)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.b[i1][i2]);
        localStringBuilder2.append(" ");
        localStringBuilder1.append(localStringBuilder2.toString());
        i2 += 1;
      }
      SLog.b("MosaicOperator", localStringBuilder1.toString());
      localStringBuilder1.delete(0, localStringBuilder1.length());
      i1 += 1;
    }
  }
  
  public void a()
  {
    if (this.A == 105)
    {
      this.l.setXfermode(null);
      this.l.setColor(z);
      this.l.setStrokeWidth(this.C);
      return;
    }
    this.l.setXfermode(null);
    this.l.setStrokeWidth(this.C);
    BitmapShader localBitmapShader = this.k;
    if (localBitmapShader != null) {
      this.l.setShader(localBitmapShader);
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.A != 105)
    {
      this.C = ((int)paramFloat);
      this.l.setStrokeWidth(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.v != null) {
      return;
    }
    this.x = paramInt1;
    this.y = paramInt2;
    this.v = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.w = new Canvas(this.v);
    this.B = true;
  }
  
  public void a(Canvas paramCanvas, MosaicLinePath paramMosaicLinePath, float paramFloat)
  {
    if (paramMosaicLinePath.a == 103) {
      return;
    }
    if (paramMosaicLinePath.a == 104)
    {
      if (this.k == null) {
        b();
      }
      this.l.setXfermode(null);
      this.l.setStrokeWidth(paramMosaicLinePath.d);
      BitmapShader localBitmapShader = this.k;
      if (localBitmapShader != null) {
        this.l.setShader(localBitmapShader);
      }
      paramCanvas.drawPath(paramMosaicLinePath.b, this.l);
      return;
    }
    if (paramMosaicLinePath.a == 105)
    {
      paramCanvas = this.w;
      if (paramCanvas == null)
      {
        SLog.d("MosaicOperator", "do not init yet");
        return;
      }
      paramCanvas.save();
      this.w.scale(paramFloat, paramFloat);
      if (this.C == 0) {
        this.C = AIOUtils.b(16.0F, BaseApplicationImpl.getContext().getResources());
      }
      this.l.setXfermode(null);
      this.l.setStrokeWidth(this.C);
      this.l.setShader(null);
      this.l.setColor(z);
      this.w.drawPath(paramMosaicLinePath.b, this.l);
      this.w.restore();
      this.B = true;
    }
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener, float paramFloat, Bitmap paramBitmap, Rect paramRect)
  {
    this.n = paramLayerEventListener;
    this.p = paramFloat;
    this.q = paramBitmap;
    this.r = paramRect;
  }
  
  public void a(DoodleLayout paramDoodleLayout)
  {
    this.u = paramDoodleLayout;
  }
  
  public void a(MosaicLinePath paramMosaicLinePath)
  {
    if (paramMosaicLinePath.a == 103)
    {
      DoodleLayout.a("delete_mosaics");
      VideoEditReport.a("0X80076C2");
      List localList = paramMosaicLinePath.e;
      paramMosaicLinePath = paramMosaicLinePath.f;
      int i1 = 0;
      while ((i1 < localList.size()) && (i1 < paramMosaicLinePath.size()))
      {
        e(((Integer)localList.get(i1)).intValue(), ((Integer)paramMosaicLinePath.get(i1)).intValue());
        i1 += 1;
      }
      c();
      return;
    }
    if (paramMosaicLinePath.a == 104)
    {
      VideoEditReport.b("0X80075CF");
      return;
    }
    if (paramMosaicLinePath.a == 105)
    {
      a(true);
      DoodleLayout.a("delete_mosaics");
      VideoEditReport.a("0X80076C2");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.A == 105) && (this.w != null))
    {
      SLog.a("MosaicOperator", "clearMp4MosaicCanvasAndDraw notify=%s", Boolean.valueOf(paramBoolean));
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.w.drawPaint(localPaint);
      this.B = true;
      if (paramBoolean) {
        c();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    int i2;
    float f3;
    float f4;
    if (i1 != 0)
    {
      int i4;
      int i3;
      if (i1 != 1)
      {
        if (i1 != 2) {
          return true;
        }
        i1 = this.A;
        if (i1 == 103)
        {
          i1 = ((Integer)this.j.e.get(this.j.e.size() - 1)).intValue();
          i2 = ((Integer)this.j.f.get(this.j.f.size() - 1)).intValue();
          f3 = this.e;
          i4 = this.c;
          i3 = (int)(f1 * f3 / i4);
          i4 = (int)(f2 * f3 / i4);
          if (((i3 != i1) || (i4 != i2)) && (i3 >= 0) && (i4 >= 0))
          {
            this.j.e.add(Integer.valueOf(i3));
            this.j.f.add(Integer.valueOf(i4));
            d(i3, i4);
            c();
            return true;
          }
        }
        else
        {
          if (i1 == 104)
          {
            f3 = (this.s + f1) / 2.0F;
            f4 = (this.t + f2) / 2.0F;
            this.j.b.quadTo(this.s, this.t, f3, f4);
            this.j.g.add(new PointAction(PointAction.c, this.s, this.t, f3, f4));
            this.s = f1;
            this.t = f2;
            return true;
          }
          if (i1 == 105)
          {
            f3 = (this.s + f1) / 2.0F;
            f4 = (this.t + f2) / 2.0F;
            this.j.b.quadTo(this.s, this.t, f3, f4);
            this.j.g.add(new PointAction(PointAction.c, this.s, this.t, f3, f4));
            this.s = f1;
            this.t = f2;
            return true;
          }
        }
      }
      else if (this.A == 103)
      {
        i1 = ((Integer)this.j.e.get(this.j.e.size() - 1)).intValue();
        i2 = ((Integer)this.j.f.get(this.j.f.size() - 1)).intValue();
        f3 = this.e;
        i4 = this.c;
        i3 = (int)(f1 * f3 / i4);
        i4 = (int)(f2 * f3 / i4);
        if (((i3 != i1) || (i4 != i2)) && (i3 >= 0) && (i4 >= 0))
        {
          this.j.e.add(Integer.valueOf(i3));
          this.j.f.add(Integer.valueOf(i4));
          d(i3, i4);
          c();
          return true;
        }
      }
    }
    else
    {
      this.s = f1;
      this.t = f2;
      this.j = new MosaicLinePath(this.A, this.C);
      paramMotionEvent = this.o;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.j);
      }
      i1 = this.A;
      if (i1 == 103)
      {
        DoodleLayout.a("use_mosaics");
        VideoEditReport.a("0X80076C1");
        f3 = this.e;
        i2 = this.c;
        i1 = (int)(f1 * f3 / i2);
        i2 = (int)(f2 * f3 / i2);
        if ((i1 >= 0) && (i2 >= 0))
        {
          this.j.e.add(Integer.valueOf(i1));
          this.j.f.add(Integer.valueOf(i2));
          d(i1, i2);
          c();
          return true;
        }
      }
      else
      {
        if (i1 == 104)
        {
          this.j.b.reset();
          this.j.b.moveTo(f1, f2);
          paramMotionEvent = this.j.b;
          f3 = f1 + 1.0F;
          f4 = 1.0F + f2;
          paramMotionEvent.lineTo(f3, f4);
          this.j.g.add(new PointAction(PointAction.a, f1, f2));
          this.j.g.add(new PointAction(PointAction.b, f3, f4));
          return true;
        }
        if (i1 == 105)
        {
          this.j.b.reset();
          this.j.b.moveTo(f1, f2);
          paramMotionEvent = this.j.b;
          f3 = f1 + 1.0F;
          f4 = 1.0F + f2;
          paramMotionEvent.lineTo(f3, f4);
          this.j.g.add(new PointAction(PointAction.a, f1, f2));
          this.j.g.add(new PointAction(PointAction.b, f3, f4));
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    if (this.k != null) {
      return;
    }
    Object localObject1 = this.u;
    if (localObject1 != null) {
      localObject1 = ((DoodleLayout)localObject1).getEditPicRawImageBitmap();
    } else {
      localObject1 = null;
    }
    this.q = ((Bitmap)localObject1);
    if (this.q == null) {
      return;
    }
    Object localObject2 = this.u.v.getContentBounds();
    int i2 = Math.min(this.r.width(), this.r.height());
    int i1 = 8;
    if (i2 / 8 < 28) {
      i1 = 2;
    }
    try
    {
      localObject1 = Bitmap.createBitmap(this.r.width() / i1, this.r.height() / i1, Bitmap.Config.RGB_565);
      float f1 = i1;
      float f2 = 1.0F / f1;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initMosaicPicMode -- contentBounds=");
      ((StringBuilder)localObject3).append(localObject2);
      SLog.c("MosaicOperator", ((StringBuilder)localObject3).toString());
      localObject3 = new RectF(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      if (localObject2 != null)
      {
        localMatrix = new Matrix();
        localMatrix.postScale(f2, f2);
        localMatrix.mapRect((RectF)localObject3, (RectF)localObject2);
      }
      SLog.a("MosaicOperator", "init matrix. scale[%f, %f].", Float.valueOf(f2), Float.valueOf(f2));
      new Canvas((Bitmap)localObject1).drawBitmap(this.q, null, (RectF)localObject3, null);
      i2 = Math.min(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight()) / 28;
      i1 = i2;
      if (i2 == 0) {
        i1 = 1;
      }
      DoodleUtil.a((Bitmap)localObject1, i1);
      localObject2 = Bitmap.createBitmap(this.r.width(), this.r.height(), Bitmap.Config.RGB_565);
      if (localObject2 == null)
      {
        ((Bitmap)localObject1).recycle();
        if (QLog.isColorLevel()) {
          QLog.e("MosaicOperator", 2, "failed to create mosaic bitmap");
        }
        return;
      }
      localObject3 = new Canvas((Bitmap)localObject2);
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f1);
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, localMatrix, null);
      ((Bitmap)localObject1).recycle();
      this.k = new BitmapShader((Bitmap)localObject2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SLog.c("MosaicOperator", "initMosaicPicMode.", localIllegalArgumentException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SLog.c("MosaicOperator", "initMosaicPicMode.", localOutOfMemoryError);
    }
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set MosaicSize:");
    localStringBuilder.append(paramInt);
    SLog.b("MosaicOperator", localStringBuilder.toString());
    this.c = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("standardWidth:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",standardHeight:");
    localStringBuilder.append(paramInt2);
    SLog.b("MosaicOperator", localStringBuilder.toString());
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void c()
  {
    LineLayer.LayerEventListener localLayerEventListener = this.n;
    if (localLayerEventListener != null) {
      if (this.A == 105) {
        localLayerEventListener.a(this.v, this.B);
      } else {
        localLayerEventListener.a(this.a, this.h, this.i);
      }
    }
    this.B = false;
    if (this.m) {
      f();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    float f2 = this.f;
    float f1 = paramInt1;
    this.d = (f2 / f1);
    this.e = (this.g / paramInt2);
    if (this.e <= 0.0F)
    {
      SLog.e("MosaicOperator", "mosaicHeightScale <= 0.");
      this.e = this.p;
    }
    f2 = this.e;
    paramInt1 = this.c;
    this.h = ((int)(f1 * f2 / paramInt1));
    this.i = ((int)(this.g / paramInt1));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create mosaic mask array, width:");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(",height:");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(",array length:");
    ((StringBuilder)localObject).append(this.h * this.i);
    SLog.b("MosaicOperator", ((StringBuilder)localObject).toString());
    this.a = new byte[this.h * this.i];
    paramInt1 = 0;
    for (;;)
    {
      localObject = this.a;
      if (paramInt1 >= localObject.length) {
        break;
      }
      localObject[paramInt1] = 0;
      paramInt1 += 1;
    }
    if (this.m)
    {
      this.b = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { this.i, this.h }));
      paramInt1 = 0;
      while (paramInt1 < this.i)
      {
        paramInt2 = 0;
        while (paramInt2 < this.h)
        {
          this.b[paramInt1][paramInt2] = 0;
          paramInt2 += 1;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void d()
  {
    this.j = new MosaicLinePath(this.A, this.C);
    int i1 = this.A;
    if (i1 == 104) {
      return;
    }
    if (i1 == 105)
    {
      a(true);
      return;
    }
    Object localObject;
    if (this.a != null)
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.a;
        if (i1 >= localObject.length) {
          break;
        }
        localObject[i1] = 0;
        i1 += 1;
      }
    }
    if (this.m)
    {
      i1 = 0;
      while (i1 < this.b.length)
      {
        int i2 = 0;
        for (;;)
        {
          localObject = this.b;
          if (i2 >= localObject[0].length) {
            break;
          }
          localObject[i1][i2] = 0;
          i2 += 1;
        }
        i1 += 1;
      }
    }
    c();
  }
  
  public void e()
  {
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.MosaicOperator
 * JD-Core Version:    0.7.0.1
 */