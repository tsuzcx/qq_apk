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
  static int i;
  protected float a;
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected Canvas a;
  protected Paint a;
  protected SentenceInfo a;
  protected IZimuItemView.FontPara a;
  final String jdField_a_of_type_JavaLangString;
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference;
  protected boolean a;
  protected int b = 255;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
  public ZimuItemView(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_Int = 24;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Float = paramFloat;
    this.g = paramInt1;
    this.h = paramInt2;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public int a()
  {
    return this.e;
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
      int k = paramString.length();
      float[] arrayOfFloat = new float[k + 1];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      int j = 0;
      f1 = 0.0F;
      for (;;)
      {
        f2 = f1;
        if (j >= k) {
          break;
        }
        f1 += arrayOfFloat[j];
        j += 1;
      }
    }
    float f2 = 0.0F;
    paramPaint = this.jdField_a_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara;
    float f1 = f3;
    if (paramPaint != null) {
      f1 = paramPaint.jdField_a_of_type_Float;
    }
    return (int)Math.ceil(f2 + f1 / 2.0F);
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = b();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((ZimuView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void a(long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start:");
    localStringBuilder.append(paramLong);
    AVLog.printColorLog(str, localStringBuilder.toString());
  }
  
  protected abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public void a(Typeface paramTypeface, int paramInt, IZimuItemView.FontPara paramFontPara)
  {
    Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface();
    if ((localTypeface != paramTypeface) || (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontAttr, Typeface[");
      localStringBuilder.append(localTypeface);
      localStringBuilder.append("->");
      localStringBuilder.append(paramTypeface);
      localStringBuilder.append("], TextSize[");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize());
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara = paramFontPara;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt);
    d();
    paramTypeface = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo;
    if (paramTypeface != null) {
      paramTypeface = paramTypeface.a;
    } else {
      paramTypeface = null;
    }
    paramTypeface = (String)paramTypeface;
    this.c = a(this.jdField_a_of_type_AndroidGraphicsPaint, paramTypeface);
    this.d = a(this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    d();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((SentenceInfo)localObject1).b;
    } else {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo = paramSentenceInfo;
    SentenceInfo localSentenceInfo = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo;
    if ((localSentenceInfo != null) && (!localSentenceInfo.a()) && (paramSentenceInfo != null) && (TextUtils.isEmpty(paramSentenceInfo.b)) && (localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.b = ((CharSequence)localObject1);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo;
    paramSentenceInfo = localObject2;
    if (localObject1 != null) {
      paramSentenceInfo = ((SentenceInfo)localObject1).a;
    }
    paramSentenceInfo = (String)paramSentenceInfo;
    this.c = a(this.jdField_a_of_type_AndroidGraphicsPaint, paramSentenceInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.f;
  }
  
  Bitmap b()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a);
    Object localObject4 = null;
    Object localObject3 = null;
    if (bool) {
      return null;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("build:");
    ((StringBuilder)localObject2).append(toString());
    AVLog.printColorLog((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = localObject3;
    localObject2 = localObject4;
    try
    {
      int j = c();
      localObject1 = localObject3;
      localObject2 = localObject4;
      int k = d();
      localObject1 = localObject3;
      localObject2 = localObject4;
      localObject3 = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap((Bitmap)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, j, k);
      return localObject3;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
        return localObject1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject3 = localException;
      if (QLog.isColorLevel())
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError.getMessage());
        localObject3 = localException;
      }
    }
    return localObject3;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(null);
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    d();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return true;
  }
  
  public int d()
  {
    if (this.d == 0) {
      this.d = a(this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    return this.d;
  }
  
  void d()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("releaseBitmap:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
    AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      if (!((Bitmap)localObject).isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZimuItemView{mFontPara=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara.toString());
    localStringBuilder.append(", getTypeface=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface());
    localStringBuilder.append(", mTextSize=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mAlpha=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mWidth=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mHeight=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mCurrentX=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mCurrentY=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mSentenceInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.toString());
    localStringBuilder.append(", mBitmapCache=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemView
 * JD-Core Version:    0.7.0.1
 */