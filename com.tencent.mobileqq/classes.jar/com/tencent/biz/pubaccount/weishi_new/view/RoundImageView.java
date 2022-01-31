package com.tencent.biz.pubaccount.weishi_new.view;

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
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.ThreadManager;

public class RoundImageView
  extends ResizeURLImageView
  implements Handler.Callback
{
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_CROP;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public RoundImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      a();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(1, 1, jdField_a_of_type_AndroidGraphicsBitmap$Config);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), jdField_a_of_type_AndroidGraphicsBitmap$Config))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    while (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
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
    b();
    invalidate();
  }
  
  private void a(Drawable paramDrawable)
  {
    ThreadManager.post(new RoundImageView.1(this, paramDrawable), 8, null, true);
  }
  
  private void b()
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
  
  public ImageView.ScaleType getScaleType()
  {
    return jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((paramMessage.what != 101) || (!(paramMessage.obj instanceof Bitmap))) {
      return false;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramMessage.obj);
    a();
    return false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
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
    a();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    a(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    a(getDrawable());
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != jdField_a_of_type_AndroidWidgetImageView$ScaleType) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundImageView
 * JD-Core Version:    0.7.0.1
 */