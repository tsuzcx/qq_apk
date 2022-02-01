package com.tencent.aelight.camera.aeeditor.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

public class AEEditorMusicWaveScrollProcessor
{
  private static final int a = ViewUtils.dip2px(2.0F);
  private static final int b = ViewUtils.dip2px(4.0F);
  private boolean A;
  private int B;
  private int C = 0;
  private int D = 0;
  private Bitmap E;
  private boolean F = false;
  private int G = 0;
  private GestureDetector.OnGestureListener H = new AEEditorMusicWaveScrollProcessor.1(this);
  private float c;
  private float d;
  private float e;
  private float f;
  private AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private Paint s = new Paint();
  private GestureDetector t;
  private AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener u;
  private Paint v = new Paint();
  private Paint w = new Paint();
  private int x;
  private int y;
  private int z;
  
  AEEditorMusicWaveScrollProcessor(AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent paramIMusicScrollProcessorParent, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    this.g = paramIMusicScrollProcessorParent;
    this.A = paramBoolean;
    this.i = paramInt2;
    if (this.i == 0) {
      this.i = 60000;
    }
    this.h = paramInt1;
    this.k = paramInt3;
    this.l = ViewUtils.dip2px(7.0F);
    this.m = ViewUtils.dip2px(3.0F);
    this.n = ViewUtils.dip2px(2.0F);
    this.o = (this.n / 2);
    this.q = paramInt4;
    this.j = paramInt5;
    int i2 = this.q;
    int i1 = paramInt3 * 2;
    this.B = (i2 - i1);
    int i3 = this.h;
    int i4 = this.i;
    if (i3 < i4) {
      this.p = i2;
    } else {
      this.p = ((int)(i3 * 1.0F / i4 * this.B) + i1);
    }
    i3 = this.k;
    this.x = i3;
    i2 = this.p;
    this.y = (i2 - i3);
    i3 = this.i;
    float f1 = 1000.0F / i3;
    i4 = this.B;
    f1 *= i4;
    this.e = 0.0F;
    int i5 = this.h;
    if (i5 < i3) {
      this.d = (i5 * 1.0F / i3 * i4 - f1);
    } else {
      this.d = (i2 - i1 - f1);
    }
    if (!this.A)
    {
      this.C = this.k;
      this.D = ViewUtils.dip2px(9.0F);
    }
    this.t = new GestureDetector(this.g.getViewContext(), this.H);
    this.s.setAntiAlias(true);
    this.v.setAntiAlias(true);
    this.w.setAntiAlias(true);
    this.w.setFilterBitmap(true);
    this.w.setDither(true);
    i2 = this.h;
    i3 = this.i;
    if (i2 < i3) {
      this.r = ((int)((i2 * 1.0F / i3 * this.B + i1) / b));
    } else {
      this.r = ((int)(this.p * 1.0F / b));
    }
    if (this.r > 10000)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AEEditorMusicWaveScrollProcessor() called with: parent = [");
      localStringBuilder.append(paramIMusicScrollProcessorParent);
      localStringBuilder.append("], audioPath = [");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], audioDuration = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], perScreenDuration = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], padding = [");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], isFromLibrary = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], width = [");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], height = [");
      localStringBuilder.append(paramInt5);
      localStringBuilder.append("] lineCount=");
      localStringBuilder.append(this.r);
      AEQLog.c("AEEditorMusicWaveScrollProcessor", localStringBuilder.toString());
    }
    AEEditorMusicWaveRandomGenerator.a(paramString1, paramString2, this.r);
  }
  
  private void i()
  {
    if (this.E == null) {
      this.E = BitmapUtils.decodeSampledBitmapFromResource(BaseApplicationImpl.getApplication().getResources(), 2130853662, 16, 118);
    }
  }
  
  int a()
  {
    return this.C;
  }
  
  void a(int paramInt)
  {
    int i1 = this.k;
    if ((paramInt >= i1) && (paramInt <= this.q - i1)) {
      this.C = paramInt;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 * 1.0F / paramInt2;
    paramInt1 = this.p;
    paramInt2 = this.k;
    this.z = ((int)(f1 * (paramInt1 - paramInt2 * 2)) + paramInt2);
    AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent localIMusicScrollProcessorParent = this.g;
    if (localIMusicScrollProcessorParent != null) {
      localIMusicScrollProcessorParent.a();
    }
  }
  
  void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    int i1 = BaseApplicationImpl.getContext().getResources().getColor(2063794221);
    Object localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2063794221);
    if (localObject != null) {
      i1 = ((ColorStateList)localObject).getDefaultColor();
    }
    int i2 = BaseApplicationImpl.getContext().getResources().getColor(2063794223);
    localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2063794223);
    if (localObject != null) {
      i2 = ((ColorStateList)localObject).getDefaultColor();
    }
    int i3 = BaseApplicationImpl.getContext().getResources().getColor(2063794222);
    localObject = BaseApplicationImpl.getContext().getResources().getColorStateList(2063794222);
    if (localObject != null) {
      i3 = ((ColorStateList)localObject).getDefaultColor();
    }
    if (!paramBoolean) {
      i2 = i1;
    }
    if (!this.A)
    {
      localObject = this.v;
      if ((localObject != null) && (paramCanvas != null))
      {
        ((Paint)localObject).setStyle(Paint.Style.FILL);
        this.v.setColor(BaseApplicationImpl.getContext().getResources().getColor(2063794219));
        i4 = this.k;
        i5 = this.o;
        f1 = i4 - i5;
        i6 = this.l;
        localObject = new RectF(f1, i6, this.q - i4 + i5, this.j - i6);
        i4 = this.m;
        paramCanvas.drawRoundRect((RectF)localObject, i4, i4, this.v);
      }
    }
    int i4 = this.q;
    float f1 = i4;
    int i5 = this.k;
    float f2 = i5;
    float f3 = i5;
    i5 = b;
    int i6 = i4 / i5;
    double d1 = this.x;
    Double.isNaN(d1);
    double d2 = i5;
    Double.isNaN(d2);
    i5 = (int)Math.ceil(d1 * 1.0D / d2);
    i4 = Math.max(Math.min((int)this.c / b, this.r), i5);
    i6 = Math.min(i6 + i4, this.r);
    localObject = new RectF(0.0F, 0.0F, a, this.j);
    while (i4 < i6)
    {
      int i7;
      int i8;
      if (!this.A)
      {
        d1 = AEEditorMusicWaveRandomGenerator.a(i4 - i5);
        i7 = this.j;
        d2 = i7 - this.l * 4;
        Double.isNaN(d2);
        i8 = (int)(d1 * d2);
        ((RectF)localObject).top = ((i7 - i8) / 2);
        ((RectF)localObject).bottom = (((RectF)localObject).top + i8);
      }
      else
      {
        d1 = AEEditorMusicWaveRandomGenerator.a(i4 - i5);
        i7 = this.j;
        d2 = i7;
        Double.isNaN(d2);
        i8 = (int)(d1 * d2);
        ((RectF)localObject).top = ((i7 - i8) / 2);
        ((RectF)localObject).bottom = (((RectF)localObject).top + i8);
      }
      if ((this.c + ((RectF)localObject).right >= this.x) && (this.c + ((RectF)localObject).left <= this.y))
      {
        if ((((RectF)localObject).left >= f2 + 0.0F) && (((RectF)localObject).left <= f1 - f3))
        {
          if (this.A)
          {
            if (((RectF)localObject).left < this.z - this.c) {
              this.s.setColor(i3);
            } else {
              this.s.setColor(i2);
            }
          }
          else if (((RectF)localObject).left < this.G) {
            this.s.setColor(i3);
          } else {
            this.s.setColor(i2);
          }
        }
        else {
          this.s.setColor(i1);
        }
        i7 = a;
        paramCanvas.drawRoundRect((RectF)localObject, i7 / 2, i7 / 2, this.s);
      }
      ((RectF)localObject).left += b;
      ((RectF)localObject).right += b;
      i4 += 1;
    }
    if (!this.A)
    {
      localObject = this.v;
      if ((localObject != null) && (paramCanvas != null))
      {
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        this.v.setColor(BaseApplicationImpl.getContext().getResources().getColor(2063794220));
        this.v.setStrokeWidth(this.n);
        i1 = this.k;
        i2 = this.o;
        f1 = i1 - i2;
        i3 = this.l;
        localObject = new RectF(f1, i3, this.q - i1 + i2, this.j - i3);
        i1 = this.m;
        paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.v);
        i();
        localObject = new Rect(0, 0, this.E.getWidth(), this.E.getHeight());
        i1 = this.C;
        i2 = this.D;
        RectF localRectF = new RectF(i1 - i2 / 2, 0.0F, i1 + i2 / 2, this.j);
        paramCanvas.drawBitmap(this.E, (Rect)localObject, localRectF, this.w);
      }
    }
    paramCanvas.restore();
  }
  
  void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.u;
      if (paramMotionEvent != null) {
        paramMotionEvent.b();
      }
    }
    else
    {
      GestureDetector localGestureDetector = this.t;
      if (localGestureDetector != null) {
        localGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  void a(AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener paramIMusicBarMoveListener)
  {
    this.u = paramIMusicBarMoveListener;
  }
  
  void a(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  int b()
  {
    return this.D;
  }
  
  void b(int paramInt)
  {
    this.G = paramInt;
  }
  
  int c()
  {
    return this.k;
  }
  
  void c(int paramInt)
  {
    this.c = (paramInt * 1.0F / this.i * this.B);
    AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent localIMusicScrollProcessorParent = this.g;
    if (localIMusicScrollProcessorParent != null) {
      localIMusicScrollProcessorParent.a();
    }
  }
  
  int d()
  {
    return this.q;
  }
  
  int e()
  {
    return this.j;
  }
  
  int f()
  {
    return this.i;
  }
  
  int g()
  {
    int i1 = (int)(this.c * 1.0F / this.B * this.i);
    int i2 = this.h;
    if (i1 > i2) {
      return i2;
    }
    return i1;
  }
  
  int h()
  {
    float f1 = this.c * 1.0F / this.B;
    int i1 = this.i;
    i1 = (int)(f1 * i1) + i1;
    int i2 = this.h;
    if (i1 <= i2) {
      return i1;
    }
    return i2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveScrollProcessor
 * JD-Core Version:    0.7.0.1
 */