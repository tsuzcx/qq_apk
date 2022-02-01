package com.tencent.aelight.camera.aioeditor.takevideo.doodle.util;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.qphone.base.util.QLog;

public class GestureHelper
{
  private boolean A;
  private final int a = 0;
  private final int b = 1;
  private final int c = 2;
  private final int d = 3;
  private final int e = 4;
  private int f = 0;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private int s = -1;
  private boolean t = false;
  private boolean u = false;
  private float v = 2.147484E+009F;
  private float w = 0.0F;
  private Matrix x = new Matrix();
  private Matrix y = new Matrix();
  private GestureHelper.ZoomItem z;
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.z;
    paramMotionEvent.S = false;
    paramMotionEvent.T = false;
    this.f = 0;
    a();
  }
  
  private void b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.u = true;
    this.f = 1;
    float f2 = paramMotionEvent.getX(0);
    float f1 = paramMotionEvent.getY(0);
    this.g = f2;
    this.h = f1;
    this.o = this.z.D;
    this.p = this.z.E;
    paramMotionEvent = this.z;
    paramMotionEvent.S = false;
    paramMotionEvent.T = false;
    if ((b(paramMotionEvent, f2, f1)) && (paramBoolean))
    {
      this.f = 3;
      this.q = this.z.B;
      this.r = this.z.C;
      f2 = (f2 - this.z.A.x - this.z.D) / this.z.d();
      f1 = (f1 - this.z.A.y - this.z.E) / this.z.d();
      this.i = GestureUtil.a(f2, f1);
      this.j = GestureUtil.b(f2, f1);
      this.k = this.z.A.x;
      this.l = this.z.A.y;
    }
  }
  
  private void c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (!this.u)
    {
      this.u = true;
      b(paramMotionEvent, paramBoolean);
      return;
    }
    this.z.S = true;
    paramMotionEvent.getPointerCount();
    int i1 = this.f;
    float f1;
    float f2;
    float f3;
    if (i1 == 1)
    {
      if (this.t)
      {
        this.t = false;
        this.g = paramMotionEvent.getX(0);
        this.h = paramMotionEvent.getY(0);
        this.o = this.z.D;
        this.p = this.z.E;
        return;
      }
      f1 = paramMotionEvent.getX(0);
      f2 = this.g;
      f3 = paramMotionEvent.getY(0);
      float f4 = this.h;
      paramMotionEvent = this.z;
      paramMotionEvent.D = (this.o + (f1 - f2) / paramMotionEvent.d());
      paramMotionEvent = this.z;
      paramMotionEvent.E = (this.p + (f3 - f4) / paramMotionEvent.d());
      return;
    }
    if ((i1 == 3) && (paramBoolean))
    {
      f2 = (paramMotionEvent.getX() - this.z.A.x - this.z.D) / this.z.d();
      f3 = (paramMotionEvent.getY() - this.z.A.y - this.z.E) / this.z.d();
      f1 = GestureUtil.a(f2, f3);
      f2 = GestureUtil.b(f2, f3);
      paramMotionEvent = this.z;
      paramMotionEvent.B = (this.q * (f1 / this.i));
      paramMotionEvent.C = ((this.r + (f2 - this.j)) % 360.0F);
      if (paramMotionEvent.I)
      {
        f1 = this.z.B;
        f2 = this.v;
        if (f1 > f2) {
          this.z.B = f2;
        }
        f1 = this.z.B;
        f2 = this.w;
        if (f1 < f2) {
          this.z.B = f2;
        }
        if (this.z.C < 0.0F)
        {
          paramMotionEvent = this.z;
          paramMotionEvent.C += 360.0F;
        }
      }
      else
      {
        paramMotionEvent = this.z;
        paramMotionEvent.B = this.q;
        paramMotionEvent.C = this.r;
      }
    }
  }
  
  public int a(TextLayer.TextItem paramTextItem, float paramFloat1, float paramFloat2)
  {
    if (paramTextItem == null) {
      return -1;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    e(paramTextItem).mapPoints(arrayOfFloat);
    float f1 = paramTextItem.G;
    float f3 = paramTextItem.H;
    float f2 = f3;
    paramFloat2 = f1;
    if (this.A)
    {
      paramFloat1 = f1;
      if (paramTextItem.B * f1 < 200.0F) {
        paramFloat1 = 200.0F / paramTextItem.B;
      }
      f2 = f3;
      paramFloat2 = paramFloat1;
      if (paramTextItem.B * f3 < 200.0F)
      {
        f2 = 200.0F / paramTextItem.B;
        paramFloat2 = paramFloat1;
      }
    }
    return paramTextItem.c.a(paramFloat2, f2, arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public Matrix a(GestureHelper.ZoomItem paramZoomItem, boolean paramBoolean)
  {
    this.x.reset();
    if (paramZoomItem == null) {
      return this.x;
    }
    this.x.postRotate(paramZoomItem.C);
    this.x.postScale(c(paramZoomItem, false), c(paramZoomItem, false));
    if (paramZoomItem.A != null) {
      this.x.postTranslate(paramZoomItem.A.x, paramZoomItem.A.y);
    }
    this.x.postTranslate(paramZoomItem.D, paramZoomItem.E);
    if (paramBoolean) {
      this.x.postConcat(paramZoomItem.F);
    }
    return this.x;
  }
  
  public void a()
  {
    this.z = null;
    this.g = 0.0F;
    this.h = 0.0F;
    this.i = 0.0F;
    this.j = 0.0F;
    this.k = 0.0F;
    this.l = 0.0F;
    this.o = 0.0F;
    this.p = 0.0F;
    this.q = 0.0F;
    this.r = 0.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    this.t = false;
    this.u = false;
    this.x.reset();
    this.y.reset();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.v = paramFloat;
    }
  }
  
  public void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (this.z == null) {
      return;
    }
    if (paramMotionEvent.getActionMasked() == 0) {
      this.s = paramMotionEvent.getPointerId(0);
    }
    if (this.s != paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())) {
      return;
    }
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 == 6) {}
        }
        else
        {
          c(paramMotionEvent, paramBoolean);
          return;
        }
      }
      a(paramMotionEvent);
      return;
    }
    b(paramMotionEvent, paramBoolean);
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    a();
    this.z = paramZoomItem;
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    e(paramZoomItem).mapPoints(arrayOfFloat);
    paramFloat1 = d(paramZoomItem);
    paramFloat2 = paramZoomItem.G;
    float f3 = paramZoomItem.N / paramFloat1;
    float f1 = paramZoomItem.H;
    float f2 = paramZoomItem.N / paramFloat1;
    paramFloat2 = (paramFloat2 + f3 * 2.0F) / 2.0F;
    f1 = (f1 + f2 * 2.0F) / 2.0F;
    paramFloat1 = DisplayUtil.a() / paramFloat1 / 2.0F;
    f2 = arrayOfFloat[0];
    paramFloat2 = -paramFloat2;
    if ((f2 >= paramFloat2 - paramFloat1 - 10.0F) && (arrayOfFloat[0] <= paramFloat2 + paramFloat1 + 10.0F))
    {
      paramFloat2 = arrayOfFloat[1];
      f1 = -f1;
      if ((paramFloat2 >= f1 - paramFloat1 - 10.0F) && (arrayOfFloat[1] <= f1 + paramFloat1 + 10.0F)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    e(paramZoomItem).mapPoints(arrayOfFloat);
    float f3 = d(paramZoomItem);
    float f2 = paramZoomItem.G;
    float f1 = paramZoomItem.H;
    paramFloat1 = f2;
    paramFloat2 = f1;
    if (paramBoolean)
    {
      paramFloat1 = f2 + paramZoomItem.N / f3 * 2.0F;
      paramFloat2 = f1 + paramZoomItem.N / f3 * 2.0F;
    }
    f3 = paramFloat1;
    f2 = paramFloat2;
    if (this.A)
    {
      f1 = paramFloat1;
      if (paramZoomItem.B * paramFloat1 < 200.0F) {
        f1 = 200.0F / paramZoomItem.B;
      }
      f3 = f1;
      f2 = paramFloat2;
      if (paramZoomItem.B * paramFloat2 < 200.0F)
      {
        f2 = 200.0F / paramZoomItem.B;
        f3 = f1;
      }
    }
    paramFloat1 = f3 / 2.0F;
    paramFloat2 = f2 / 2.0F;
    float f4 = -paramFloat1;
    f1 = -paramFloat2;
    f2 = DisplayUtil.a() / d(paramZoomItem) / 2.0F;
    if ((arrayOfFloat[0] >= f4) && (arrayOfFloat[0] <= paramFloat1) && (arrayOfFloat[1] >= f1) && (arrayOfFloat[1] <= paramFloat2)) {
      return true;
    }
    float f5 = arrayOfFloat[0];
    f3 = f4 - f2;
    if ((f5 >= f3 - 10.0F) && (arrayOfFloat[0] <= f4 + f2 + 10.0F) && (arrayOfFloat[1] >= f1 - f2 - 10.0F) && (arrayOfFloat[1] <= f1 + f2 + 10.0F)) {
      return true;
    }
    f4 = arrayOfFloat[0];
    f5 = paramFloat1 - f2 - 10.0F;
    if ((f4 >= f5) && (arrayOfFloat[0] <= paramFloat1 + f2 + 10.0F) && (arrayOfFloat[1] >= f1 - f2 - 10.0F) && (arrayOfFloat[1] <= f1 + f2 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f5) && (arrayOfFloat[0] <= paramFloat1 + f2 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - f2 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + f2 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f3) && (arrayOfFloat[0] <= paramFloat1 + f2) && (arrayOfFloat[1] >= f1 - f2) && (arrayOfFloat[1] > paramFloat2 + f2)) {}
    return false;
  }
  
  public boolean a(GestureHelper.ZoomItem paramZoomItem, float paramFloat, boolean paramBoolean)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float f2 = paramZoomItem.G;
    float f1 = paramZoomItem.H / 2.0F;
    f2 /= 2.0F;
    float[] arrayOfFloat1 = new float[2];
    float f3 = -f2;
    arrayOfFloat1[0] = f3;
    float f4 = -f1;
    arrayOfFloat1[1] = f4;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = f2;
    arrayOfFloat2[1] = f4;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = f3;
    arrayOfFloat3[1] = f1;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = f2;
    arrayOfFloat4[1] = f1;
    paramZoomItem = b(paramZoomItem);
    this.x = paramZoomItem;
    paramZoomItem.mapPoints(arrayOfFloat1);
    paramZoomItem.mapPoints(arrayOfFloat2);
    paramZoomItem.mapPoints(arrayOfFloat3);
    paramZoomItem.mapPoints(arrayOfFloat4);
    if (QLog.isColorLevel())
    {
      paramZoomItem = new StringBuilder();
      paramZoomItem.append("isCloseToXLine x=");
      paramZoomItem.append(paramFloat);
      paramZoomItem.append(" leftReach=");
      paramZoomItem.append(paramBoolean);
      paramZoomItem.append("\n");
      paramZoomItem.append("f[");
      paramZoomItem.append(arrayOfFloat1[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat1[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f1[");
      paramZoomItem.append(arrayOfFloat2[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat2[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f2[");
      paramZoomItem.append(arrayOfFloat3[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat3[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f3[");
      paramZoomItem.append(arrayOfFloat4[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat4[1]);
      paramZoomItem.append("]\n");
      QLog.d("GestureHelper", 2, paramZoomItem.toString());
    }
    if (paramBoolean)
    {
      if ((arrayOfFloat1[0] <= paramFloat) || (arrayOfFloat2[0] <= paramFloat) || (arrayOfFloat3[0] <= paramFloat) || (arrayOfFloat4[0] <= paramFloat)) {
        return true;
      }
    }
    else
    {
      if ((arrayOfFloat1[0] >= paramFloat) || (arrayOfFloat2[0] >= paramFloat) || (arrayOfFloat3[0] >= paramFloat)) {
        break label450;
      }
      if (arrayOfFloat4[0] >= paramFloat) {
        return true;
      }
    }
    return false;
    label450:
    return true;
  }
  
  public Matrix b(GestureHelper.ZoomItem paramZoomItem)
  {
    return a(paramZoomItem, true);
  }
  
  public Matrix b(GestureHelper.ZoomItem paramZoomItem, boolean paramBoolean)
  {
    this.x.reset();
    if (paramZoomItem == null) {
      return this.x;
    }
    this.x.postRotate(paramZoomItem.C);
    this.x.postTranslate(paramZoomItem.A.x, paramZoomItem.A.y);
    this.x.postTranslate(paramZoomItem.D, paramZoomItem.E);
    if (paramBoolean) {
      this.x.postConcat(paramZoomItem.F);
    }
    return this.x;
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.w = paramFloat;
    }
  }
  
  public boolean b(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    e(paramZoomItem).mapPoints(arrayOfFloat);
    paramFloat1 = d(paramZoomItem);
    float f2 = paramZoomItem.G;
    float f3 = paramZoomItem.N / paramFloat1;
    paramFloat2 = paramZoomItem.H;
    float f1 = paramZoomItem.N / paramFloat1;
    f2 = (f2 + f3 * 2.0F) / 2.0F;
    paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
    paramFloat1 = DisplayUtil.a() / paramFloat1 / 2.0F;
    return (arrayOfFloat[0] >= f2 - paramFloat1 - 10.0F) && (arrayOfFloat[0] <= f2 + paramFloat1 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - paramFloat1 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + paramFloat1 + 10.0F);
  }
  
  public boolean b(GestureHelper.ZoomItem paramZoomItem, float paramFloat, boolean paramBoolean)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float f2 = paramZoomItem.G;
    float f1 = paramZoomItem.H / 2.0F;
    f2 /= 2.0F;
    float[] arrayOfFloat1 = new float[2];
    float f3 = -f2;
    arrayOfFloat1[0] = f3;
    float f4 = -f1;
    arrayOfFloat1[1] = f4;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = f2;
    arrayOfFloat2[1] = f4;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = f3;
    arrayOfFloat3[1] = f1;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = f2;
    arrayOfFloat4[1] = f1;
    paramZoomItem = b(paramZoomItem);
    this.x = paramZoomItem;
    paramZoomItem.mapPoints(arrayOfFloat1);
    paramZoomItem.mapPoints(arrayOfFloat2);
    paramZoomItem.mapPoints(arrayOfFloat3);
    paramZoomItem.mapPoints(arrayOfFloat4);
    if (QLog.isColorLevel())
    {
      paramZoomItem = new StringBuilder();
      paramZoomItem.append("isCloseToYLine y=");
      paramZoomItem.append(paramFloat);
      paramZoomItem.append(" topReach=");
      paramZoomItem.append(paramBoolean);
      paramZoomItem.append("\n");
      paramZoomItem.append("f[");
      paramZoomItem.append(arrayOfFloat1[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat1[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f1[");
      paramZoomItem.append(arrayOfFloat2[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat2[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f2[");
      paramZoomItem.append(arrayOfFloat3[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat3[1]);
      paramZoomItem.append("]\n");
      paramZoomItem.append("f3[");
      paramZoomItem.append(arrayOfFloat4[0]);
      paramZoomItem.append(",");
      paramZoomItem.append(arrayOfFloat4[1]);
      paramZoomItem.append("]\n");
      QLog.d("GestureHelper", 2, paramZoomItem.toString());
    }
    if (paramBoolean)
    {
      if ((arrayOfFloat1[1] <= paramFloat) || (arrayOfFloat2[1] <= paramFloat) || (arrayOfFloat3[1] <= paramFloat) || (arrayOfFloat4[1] <= paramFloat)) {
        return true;
      }
    }
    else
    {
      if ((arrayOfFloat1[1] >= paramFloat) || (arrayOfFloat2[1] >= paramFloat) || (arrayOfFloat3[1] >= paramFloat)) {
        break label450;
      }
      if (arrayOfFloat4[1] >= paramFloat) {
        return true;
      }
    }
    return false;
    label450:
    return true;
  }
  
  public float c(GestureHelper.ZoomItem paramZoomItem, boolean paramBoolean)
  {
    float f1;
    if (paramZoomItem != null) {
      f1 = paramZoomItem.B * paramZoomItem.K;
    } else {
      f1 = 1.0F;
    }
    float f2 = f1;
    if (paramBoolean) {
      f2 = f1 * paramZoomItem.d();
    }
    return f2;
  }
  
  public Matrix c(GestureHelper.ZoomItem paramZoomItem)
  {
    return b(paramZoomItem, true);
  }
  
  public boolean c(GestureHelper.ZoomItem paramZoomItem, float paramFloat1, float paramFloat2)
  {
    if (paramZoomItem == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    e(paramZoomItem).mapPoints(arrayOfFloat);
    paramFloat1 = d(paramZoomItem);
    float f2 = paramZoomItem.G;
    float f3 = paramZoomItem.N / paramFloat1;
    paramFloat2 = paramZoomItem.H;
    float f1 = paramZoomItem.N / paramFloat1;
    f2 = (f2 + f3 * 2.0F) / 2.0F;
    paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
    paramFloat1 = DisplayUtil.a() / paramFloat1 / 2.0F;
    if ((arrayOfFloat[0] >= f2 - paramFloat1 - 10.0F) && (arrayOfFloat[0] <= f2 + paramFloat1 + 10.0F))
    {
      f1 = arrayOfFloat[1];
      paramFloat2 = -paramFloat2;
      if ((f1 >= paramFloat2 - paramFloat1 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + paramFloat1 + 10.0F)) {
        return true;
      }
    }
    return false;
  }
  
  public float d(GestureHelper.ZoomItem paramZoomItem)
  {
    return c(paramZoomItem, true);
  }
  
  public Matrix e(GestureHelper.ZoomItem paramZoomItem)
  {
    this.y.reset();
    if (paramZoomItem == null) {
      return this.y;
    }
    this.x = b(paramZoomItem);
    this.x.invert(this.y);
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper
 * JD-Core Version:    0.7.0.1
 */