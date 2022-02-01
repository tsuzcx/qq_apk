package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import java.util.List;
import otm;

public class ReadInjoyCutImageView
  extends NativeReadInjoyImageView
{
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private List<otm> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_b_of_type_AndroidGraphicsBitmapShader;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  Path jdField_b_of_type_AndroidGraphicsPath = new Path();
  private List<otm> jdField_b_of_type_JavaUtilList;
  private float jdField_c_of_type_Float;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  private float d;
  private float e;
  private float f;
  
  public ReadInjoyCutImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInjoyCutImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsMatrix == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(null);
    float f2;
    float f3;
    if (paramImageView.getScaleType() == ImageView.ScaleType.CENTER_CROP)
    {
      if (paramFloat1 != this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) {
        f1 = paramFloat1 / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      }
      f2 = f1;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * f1 < paramFloat2) {
        f2 = paramFloat2 / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      }
      f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f3 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f2, f2);
      f1 = (paramFloat2 - f1 * f2) * 0.5F;
      paramFloat2 = (paramFloat1 - f3 * f2) * 0.5F;
      paramFloat1 = f1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat2 + 0.5F, paramFloat1 + 0.5F);
      return;
      f2 = paramFloat1 / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      f3 = paramFloat2 / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      paramFloat2 = (paramFloat2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * f3) * 0.5F;
      f1 = (paramFloat1 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * f2) * 0.5F;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f2, f3);
      paramFloat1 = paramFloat2;
      paramFloat2 = f1;
    }
  }
  
  private void b()
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    Paint localPaint = new Paint(1);
    Object localObject = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    localPaint.setShader((Shader)localObject);
    ((BitmapShader)localObject).setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    Canvas localCanvas;
    int i;
    label114:
    float f1;
    float f2;
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
    {
      localObject = Bitmap.createBitmap(getWidth() + 2, getHeight() + 2, this.jdField_a_of_type_AndroidGraphicsBitmap.getConfig());
      ((Bitmap)localObject).eraseColor(0);
      localCanvas = new Canvas((Bitmap)localObject);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label240;
      }
      f1 = ((otm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Float;
      f2 = ((otm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Float;
      if (f1 != 0.0F) {
        break label206;
      }
      f1 = 1.0F;
      label169:
      if (f2 != 0.0F) {
        break label217;
      }
      f2 = 1.0F;
      label177:
      if (i != 0) {
        break label228;
      }
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
    }
    for (;;)
    {
      i += 1;
      break label114;
      localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
      break;
      label206:
      f1 = getWidth() * f1;
      break label169;
      label217:
      f2 = getHeight() * f2;
      break label177;
      label228:
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, f2);
    }
    label240:
    localCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, localPaint);
    this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
    if (this.jdField_c_of_type_AndroidGraphicsBitmap == null)
    {
      localObject = Bitmap.createBitmap(getWidth() + 2, getHeight() + 2, this.jdField_a_of_type_AndroidGraphicsBitmap.getConfig());
      ((Bitmap)localObject).eraseColor(0);
      localCanvas = new Canvas((Bitmap)localObject);
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      i = j;
      label340:
      if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
        break label466;
      }
      f1 = ((otm)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Float;
      f2 = ((otm)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_b_of_type_Float;
      if (f1 != 0.0F) {
        break label432;
      }
      f1 = 1.0F;
      label395:
      if (f2 != 0.0F) {
        break label443;
      }
      f2 = 1.0F;
      label403:
      if (i != 0) {
        break label454;
      }
      this.jdField_b_of_type_AndroidGraphicsPath.moveTo(f1, f2);
    }
    for (;;)
    {
      i += 1;
      break label340;
      localObject = this.jdField_c_of_type_AndroidGraphicsBitmap;
      break;
      label432:
      f1 = getWidth() * f1;
      break label395;
      label443:
      f2 = getHeight() * f2;
      break label403;
      label454:
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(f1, f2);
    }
    label466:
    localCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, localPaint);
    this.jdField_b_of_type_AndroidGraphicsBitmapShader = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.jdField_b_of_type_AndroidGraphicsPaint.setShader(this.jdField_b_of_type_AndroidGraphicsBitmapShader);
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      this.jdField_b_of_type_AndroidGraphicsPath.close();
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsPath.close();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {
      super.onDraw(paramCanvas);
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidGraphicsBitmapShader != null))
        {
          this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
          this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
          this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_b_of_type_AndroidGraphicsMatrix);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
      } while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_AndroidGraphicsBitmapShader == null));
      this.jdField_c_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_c_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_c_of_type_Float, this.d);
      this.jdField_b_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_c_of_type_AndroidGraphicsMatrix);
    } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.e = getMeasuredWidth();
    this.f = getMeasuredHeight();
    c();
    setupBitmap(this, this.e, this.f);
    invalidate();
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }
  
  public void setClipArea(List<otm> paramList1, List<otm> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      b();
    }
    postInvalidate();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    setupBitmap(this, this.e, this.f);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    setupBitmap(this, this.e, this.f);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    setupBitmap(this, this.e, this.f);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setupBitmap(this, this.e, this.f);
  }
  
  public void setIsShowSrc(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    postInvalidate();
  }
  
  public void setLeftAreaTranslate(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public void setRightAreaTranslate(float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_Float = paramFloat1;
    this.d = paramFloat2;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.CENTER_CROP) || (paramScaleType == ImageView.ScaleType.FIT_XY))
    {
      super.setScaleType(paramScaleType);
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
  
  public void setupBitmap(ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    Object localObject = paramImageView.getDrawable();
    if (localObject == null) {}
    do
    {
      return;
      for (;;)
      {
        try
        {
          if (!(localObject instanceof BitmapDrawable)) {
            continue;
          }
          localObject = ((BitmapDrawable)localObject).getBitmap();
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
          if ((paramImageView.getScaleType() == ImageView.ScaleType.CENTER_CROP) || (paramImageView.getScaleType() == ImageView.ScaleType.FIT_XY)) {
            continue;
          }
          paramImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          a(paramImageView, paramFloat1, paramFloat2);
          paramImageView.invalidate();
        }
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          continue;
        }
        paramImageView.invalidate();
        return;
        localObject = Bitmap.createBitmap(((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      }
    } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList == null));
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView
 * JD-Core Version:    0.7.0.1
 */