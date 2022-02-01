package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class IndexBarTipView
  extends View
{
  private static String a = "IndexBarTipView";
  private RectF b = new RectF();
  private String c = "";
  private Paint d;
  private int e;
  private int f;
  private float g;
  private int h;
  private int i;
  private int j;
  private Drawable k;
  private Matrix l;
  private Paint m;
  private BitmapShader n;
  
  public IndexBarTipView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndexBarTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IndexBarTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    Bitmap localBitmap = a(i1, i2, Bitmap.Config.ARGB_8888, 1);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, i1, i2);
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void a()
  {
    Drawable localDrawable = this.k;
    if (localDrawable == null) {
      return;
    }
    this.n = new BitmapShader(a(localDrawable), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.h = paramContext.getResources().getColor(17170444);
    this.g = paramContext.getResources().getDimension(2131297647);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.IndexBar);
      this.h = paramContext.getColor(2, this.h);
      this.g = paramContext.getDimension(5, this.g);
      this.k = paramContext.getDrawable(7);
      paramContext.recycle();
    }
    this.d = new Paint(1);
    this.d.setColor(this.h);
    this.d.setTypeface(Typeface.DEFAULT);
    this.d.setTextAlign(Paint.Align.CENTER);
    this.d.setTextSize(this.g);
    this.l = new Matrix();
    this.m = new Paint();
    this.m.setAntiAlias(true);
    a();
  }
  
  private void b()
  {
    if (this.k == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateImagePaint mWidth =  ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", getWidth = ");
      localStringBuilder.append(getWidth());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i1 = this.k.getIntrinsicWidth();
    int i2 = this.k.getIntrinsicHeight();
    float f1 = i1;
    float f2 = i2;
    if (f1 * 1.0F / f2 > 1.0F) {
      f1 = this.e * 1.0F / f1;
    } else {
      f1 = this.e * 1.0F / f2;
    }
    this.l.setScale(f1, f1);
    this.n.setLocalMatrix(this.l);
    this.m.setShader(this.n);
    this.f = ((int)(f1 * f2));
    this.b.set(0.0F, 0.0F, this.e, this.f);
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig, int paramInt3)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      if (paramInt3 > 0)
      {
        System.gc();
        return a(paramInt1, paramInt2, paramConfig, paramInt3 - 1);
      }
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (TextUtils.isEmpty(this.c)) {
      return;
    }
    if (this.k != null) {
      paramCanvas.drawRect(this.b, this.m);
    }
    paramCanvas.drawText(this.c, this.i, this.j, this.d);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.e != getWidth())
    {
      this.e = getWidth();
      b();
    }
    if (!TextUtils.isEmpty(this.c))
    {
      Rect localRect = new Rect();
      Paint localPaint = this.d;
      String str = this.c;
      localPaint.getTextBounds(str, 0, str.length(), localRect);
      double d1 = this.e;
      Double.isNaN(d1);
      double d2 = localRect.width();
      Double.isNaN(d2);
      this.i = ((int)(d1 * 0.5D - d2 / 2.0D));
      d1 = this.f;
      Double.isNaN(d1);
      d2 = localRect.height();
      Double.isNaN(d2);
      this.j = ((int)(d1 * 0.5D + d2 / 2.0D));
    }
  }
  
  public void setText(String paramString)
  {
    this.c = paramString;
    paramString = new Rect();
    Paint localPaint = this.d;
    String str = this.c;
    localPaint.getTextBounds(str, 0, str.length(), paramString);
    double d1 = this.e;
    Double.isNaN(d1);
    double d2 = paramString.width();
    Double.isNaN(d2);
    this.i = ((int)(d1 * 0.5D - d2 / 2.0D));
    d1 = this.f;
    Double.isNaN(d1);
    d2 = paramString.height();
    Double.isNaN(d2);
    this.j = ((int)(d1 * 0.5D + d2 / 2.0D));
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipView
 * JD-Core Version:    0.7.0.1
 */