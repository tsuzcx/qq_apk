package com.tencent.biz.qqstory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageButton;
import baxi;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(14)
public class PressDarkImageButton
  extends ImageButton
{
  public static final int[] a;
  public float a;
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  public int b;
  private boolean b;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 16843210, 16843211, 2131034363 };
  }
  
  public PressDarkImageButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.5F;
    Object localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Float = ((TypedArray)localObject1).getFloat(0, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = ((TypedArray)localObject1).getFloat(1, this.jdField_b_of_type_Float);
    this.jdField_a_of_type_Boolean = ((TypedArray)localObject1).getBoolean(2, false);
    ((TypedArray)localObject1).recycle();
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = null;
      localObject1 = null;
    }
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842996, 16842997 });
      localObject1 = paramContext;
      localObject2 = paramContext;
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(0, 0);
      localObject1 = paramContext;
      localObject2 = paramContext;
      this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(1, 0);
      localObject1 = paramContext;
      localObject2 = paramContext;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localObject1 = paramContext;
        localObject2 = paramContext;
        if (BaseApplicationImpl.sImageCache != null)
        {
          localObject1 = paramContext;
          localObject2 = paramContext;
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)BaseApplicationImpl.sImageCache.get("IMAGE_CACHE_KEY"));
        }
        localObject1 = paramContext;
        localObject2 = paramContext;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          localObject1 = paramContext;
          localObject2 = paramContext;
          this.jdField_a_of_type_AndroidGraphicsBitmap = baxi.b(BaseApplicationImpl.getApplication().getResources(), 2130845587);
          localObject1 = paramContext;
          localObject2 = paramContext;
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            localObject1 = paramContext;
            localObject2 = paramContext;
            if (BaseApplicationImpl.sImageCache != null)
            {
              localObject1 = paramContext;
              localObject2 = paramContext;
              BaseApplicationImpl.sImageCache.put("IMAGE_CACHE_KEY", this.jdField_a_of_type_AndroidGraphicsBitmap);
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.recycle();
      }
      return;
    }
    catch (Exception paramContext)
    {
      localObject2 = localObject1;
      paramContext.printStackTrace();
      return;
    }
    finally
    {
      if (localObject2 != null) {
        ((TypedArray)localObject2).recycle();
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Matrix localMatrix;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      }
      float f = getResources().getDisplayMetrics().density / 2.0F;
      localMatrix = new Matrix();
      localMatrix.setScale(f, f);
      localMatrix.setTranslate(this.jdField_a_of_type_Int * 0.625F, this.jdField_b_of_type_Int * 0.2564103F);
      if (!isPressed()) {
        break label141;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_b_of_type_Float * 255.0F));
    }
    for (;;)
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label141:
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (!this.c) {
      return;
    }
    if (isPressed())
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.jdField_b_of_type_Float * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.jdField_b_of_type_Float);
        return;
      }
      super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.jdField_a_of_type_Float);
      return;
    }
    super.clearColorFilter();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      invalidate();
    }
  }
  
  public void setEnableDark(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (!paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        super.setImageAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
      }
    }
    else {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.jdField_a_of_type_Float);
      return;
    }
    super.clearColorFilter();
  }
  
  public void setInvalid()
  {
    this.c = false;
    super.setEnabled(false);
    super.setClickable(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.jdField_b_of_type_Float * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.jdField_b_of_type_Float);
      return;
    }
    super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PressDarkImageButton
 * JD-Core Version:    0.7.0.1
 */