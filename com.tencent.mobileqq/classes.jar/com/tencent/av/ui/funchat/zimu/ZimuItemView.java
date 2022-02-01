package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class ZimuItemView
  implements IZimuItemView
{
  static int s;
  final String a;
  protected IZimuItemView.FontPara b;
  protected int c = 24;
  protected int d = 255;
  protected boolean e = false;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected SentenceInfo l;
  protected Bitmap m;
  protected Context n;
  protected Paint o;
  protected float p;
  protected Canvas q = new Canvas();
  WeakReference<ZimuView> r;
  
  public ZimuItemView(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.c());
    this.a = localStringBuilder.toString();
    this.n = paramContext;
    this.o = new Paint(1);
    this.p = paramFloat;
    this.j = paramInt1;
    this.k = paramInt2;
    this.r = paramWeakReference;
  }
  
  protected int a(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    return (int)(paramPaint.descent - paramPaint.ascent + paramPaint.leading);
  }
  
  protected int a(Paint paramPaint, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    float f3 = 0.0F;
    if (!bool)
    {
      int i2 = paramString.length();
      float[] arrayOfFloat = new float[i2 + 1];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      int i1 = 0;
      f1 = 0.0F;
      for (;;)
      {
        f2 = f1;
        if (i1 >= i2) {
          break;
        }
        f1 += arrayOfFloat[i1];
        i1 += 1;
      }
    }
    float f2 = 0.0F;
    paramPaint = this.b;
    float f1 = f3;
    if (paramPaint != null) {
      f1 = paramPaint.c;
    }
    return (int)Math.ceil(f2 + f1 / 2.0F);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  protected abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public void a(Typeface paramTypeface, int paramInt, IZimuItemView.FontPara paramFontPara)
  {
    Typeface localTypeface = this.o.getTypeface();
    if ((localTypeface != paramTypeface) || (paramInt != this.o.getTextSize()))
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontAttr, Typeface[");
      localStringBuilder.append(localTypeface);
      localStringBuilder.append("->");
      localStringBuilder.append(paramTypeface);
      localStringBuilder.append("], TextSize[");
      localStringBuilder.append(this.o.getTextSize());
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramTypeface != null) {
      this.o.setTypeface(paramTypeface);
    }
    this.b = paramFontPara;
    this.o.setTextSize(paramInt);
    m();
    paramTypeface = this.l;
    if (paramTypeface != null) {
      paramTypeface = paramTypeface.b;
    } else {
      paramTypeface = null;
    }
    paramTypeface = (String)paramTypeface;
    this.f = a(this.o, paramTypeface);
    this.g = a(this.o);
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    m();
    Object localObject1 = this.l;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((SentenceInfo)localObject1).c;
    } else {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    this.l = paramSentenceInfo;
    SentenceInfo localSentenceInfo = this.l;
    if ((localSentenceInfo != null) && (!localSentenceInfo.a()) && (paramSentenceInfo != null) && (TextUtils.isEmpty(paramSentenceInfo.c)) && (localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.l.c = ((CharSequence)localObject1);
    }
    localObject1 = this.l;
    paramSentenceInfo = localObject2;
    if (localObject1 != null) {
      paramSentenceInfo = ((SentenceInfo)localObject1).b;
    }
    paramSentenceInfo = (String)paramSentenceInfo;
    this.f = a(this.o, paramSentenceInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  void b()
  {
    if (this.r.get() != null) {
      ((ZimuView)this.r.get()).e();
    }
  }
  
  public void b(long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start:");
    localStringBuilder.append(paramLong);
    AVLog.printColorLog(str, localStringBuilder.toString());
  }
  
  public void c()
  {
    this.o.setTypeface(null);
    this.o = null;
    m();
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public void e() {}
  
  public int f()
  {
    return this.h;
  }
  
  public int g()
  {
    return this.i;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public int i()
  {
    if (this.g == 0) {
      this.g = a(this.o);
    }
    return this.g;
  }
  
  public boolean j()
  {
    return true;
  }
  
  public Bitmap k()
  {
    Bitmap localBitmap = this.m;
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      this.m = l();
    }
    return this.m;
  }
  
  Bitmap l()
  {
    boolean bool = TextUtils.isEmpty(this.l.b);
    Object localObject4 = null;
    Object localObject3 = null;
    if (bool) {
      return null;
    }
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("build:");
    ((StringBuilder)localObject2).append(toString());
    AVLog.printColorLog((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = localObject3;
    localObject2 = localObject4;
    try
    {
      int i1 = h();
      localObject1 = localObject3;
      localObject2 = localObject4;
      int i2 = i();
      localObject1 = localObject3;
      localObject2 = localObject4;
      localObject3 = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.q.setBitmap((Bitmap)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      a(this.q, i1, i2);
      return localObject3;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e(this.a, 2, localException.getMessage());
        return localObject1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject3 = localException;
      if (QLog.isColorLevel())
      {
        QLog.e(this.a, 2, localOutOfMemoryError.getMessage());
        localObject3 = localException;
      }
    }
    return localObject3;
  }
  
  void m()
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("releaseBitmap:");
    localStringBuilder.append(this.m);
    AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    localObject = this.m;
    if (localObject != null)
    {
      if (!((Bitmap)localObject).isRecycled()) {
        this.m.recycle();
      }
      this.m = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZimuItemView{mFontPara=");
    localStringBuilder.append(this.b.toString());
    localStringBuilder.append(", getTypeface=");
    localStringBuilder.append(this.o.getTypeface());
    localStringBuilder.append(", mTextSize=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mAlpha=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mWidth=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mHeight=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mCurrentX=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mCurrentY=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mSentenceInfo=");
    localStringBuilder.append(this.l.toString());
    localStringBuilder.append(", mBitmapCache=");
    localStringBuilder.append(this.m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemView
 * JD-Core Version:    0.7.0.1
 */