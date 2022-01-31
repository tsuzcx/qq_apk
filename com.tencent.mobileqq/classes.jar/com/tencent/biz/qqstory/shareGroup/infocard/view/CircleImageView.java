package com.tencent.biz.qqstory.shareGroup.infocard.view;

import aepi;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class CircleImageView
  extends URLImageView
{
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_CROP;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public CircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    for (;;)
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      try
      {
        if ((paramDrawable instanceof ColorDrawable)) {}
        for (Bitmap localBitmap = Bitmap.createBitmap(1, 1, jdField_a_of_type_AndroidGraphicsBitmap$Config);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), jdField_a_of_type_AndroidGraphicsBitmap$Config))
        {
          if (localBitmap != null) {
            break label75;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("CircleImageView", 2, "猜猜是不是魅族");
          return null;
        }
        label75:
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
    return null;
  }
  
  private void c()
  {
    float f1 = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(null);
    float f3;
    float f2;
    if (this.c * this.jdField_a_of_type_AndroidGraphicsRectF.height() > this.jdField_a_of_type_AndroidGraphicsRectF.width() * this.d)
    {
      f3 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.d;
      f2 = (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.c * f3) * 0.5F;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f3, f3);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((int)(f2 + 0.5F) + this.jdField_b_of_type_Int, (int)(f1 + 0.5F) + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
      f3 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.c;
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
      float f4 = this.d;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      b();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  protected void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    while (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_b_of_type_Int = aepi.a(1.0F, getContext().getResources());
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
    this.d = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.c = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
    this.jdField_b_of_type_Float = Math.min((this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_b_of_type_Int) / 2.0F, (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_b_of_type_Int) / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Float = Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F);
    c();
    invalidate();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 4, "onLoadSuccessed");
    }
    setImageDrawable(paramURLDrawable);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    b();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramDrawable);
    b();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(getDrawable());
    b();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != jdField_a_of_type_AndroidWidgetImageView$ScaleType) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView
 * JD-Core Version:    0.7.0.1
 */