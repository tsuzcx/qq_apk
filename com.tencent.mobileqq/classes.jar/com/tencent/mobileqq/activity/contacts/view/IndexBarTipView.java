package com.tencent.mobileqq.activity.contacts.view;

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
  private static String jdField_a_of_type_JavaLangString = "IndexBarTipView";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private String jdField_b_of_type_JavaLangString = "";
  private int c;
  private int d;
  private int e;
  
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
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Bitmap localBitmap = a(i, j, Bitmap.Config.ARGB_8888, 1);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.c = paramContext.getResources().getColor(17170444);
    this.jdField_a_of_type_Float = paramContext.getResources().getDimension(2131165989);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.IndexBar);
      this.c = paramContext.getColor(2, this.c);
      this.jdField_a_of_type_Float = paramContext.getDimension(5, this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(7);
      paramContext.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    a();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateImagePaint mWidth =  " + this.jdField_a_of_type_Int + ", getWidth = " + getWidth());
    }
    int i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    if (i * 1.0F / j > 1.0F) {}
    for (float f = this.jdField_a_of_type_Int * 1.0F / i;; f = this.jdField_a_of_type_Int * 1.0F / j)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f, f);
      this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_b_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
      this.jdField_b_of_type_Int = ((int)(f * j));
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
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
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, this.d, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Int != getWidth())
    {
      this.jdField_a_of_type_Int = getWidth();
      b();
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length(), localRect);
      this.d = ((int)(this.jdField_a_of_type_Int * 0.5D - localRect.width() / 2.0D));
      double d1 = this.jdField_b_of_type_Int;
      this.e = ((int)(localRect.height() / 2.0D + d1 * 0.5D));
    }
  }
  
  public void setText(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    paramString = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length(), paramString);
    this.d = ((int)(this.jdField_a_of_type_Int * 0.5D - paramString.width() / 2.0D));
    double d1 = this.jdField_b_of_type_Int;
    this.e = ((int)(paramString.height() / 2.0D + d1 * 0.5D));
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.IndexBarTipView
 * JD-Core Version:    0.7.0.1
 */