package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.math.MathUtils;

public class CircularRevealHelper
{
  public static final int a;
  @NonNull
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  @NonNull
  private final Path jdField_a_of_type_AndroidGraphicsPath;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @NonNull
  private final View jdField_a_of_type_AndroidViewView;
  private final CircularRevealHelper.Delegate jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealHelper$Delegate;
  @Nullable
  private CircularRevealWidget.RevealInfo jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      jdField_a_of_type_Int = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      jdField_a_of_type_Int = 1;
      return;
    }
    jdField_a_of_type_Int = 0;
  }
  
  public CircularRevealHelper(CircularRevealHelper.Delegate paramDelegate)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealHelper$Delegate = paramDelegate;
    this.jdField_a_of_type_AndroidViewView = ((View)paramDelegate);
    this.jdField_a_of_type_AndroidViewView.setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(7);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
  }
  
  private float a(@NonNull CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    return MathUtils.a(paramRevealInfo.a, paramRevealInfo.b, 0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight());
  }
  
  private void b(@NonNull Canvas paramCanvas)
  {
    if (d())
    {
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
      float f1 = this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.a - localRect.width() / 2.0F;
      float f2 = this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.b - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private boolean b()
  {
    CircularRevealWidget.RevealInfo localRevealInfo = this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo;
    boolean bool2 = false;
    int i;
    if ((localRevealInfo != null) && (!localRevealInfo.a())) {
      i = 0;
    } else {
      i = 1;
    }
    if (jdField_a_of_type_Int == 0)
    {
      boolean bool1 = bool2;
      if (i == 0)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Boolean) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return i ^ 0x1;
  }
  
  private void c()
  {
    if (jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.rewind();
      CircularRevealWidget.RevealInfo localRevealInfo = this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo;
      if (localRevealInfo != null) {
        this.jdField_a_of_type_AndroidGraphicsPath.addCircle(localRevealInfo.a, this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.b, this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.c, Path.Direction.CW);
      }
    }
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  private boolean c()
  {
    return (!this.jdField_a_of_type_Boolean) && (Color.alpha(this.jdField_b_of_type_AndroidGraphicsPaint.getColor()) != 0);
  }
  
  private boolean d()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo != null);
  }
  
  @ColorInt
  public int a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPaint.getColor();
  }
  
  @Nullable
  public CircularRevealWidget.RevealInfo a()
  {
    CircularRevealWidget.RevealInfo localRevealInfo = this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo;
    if (localRevealInfo == null) {
      return null;
    }
    localRevealInfo = new CircularRevealWidget.RevealInfo(localRevealInfo);
    if (localRevealInfo.a()) {
      localRevealInfo.c = a(localRevealInfo);
    }
    return localRevealInfo;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.buildDrawingCache();
      Object localObject2 = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_AndroidViewView.getWidth() != 0)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_AndroidViewView.getHeight() != 0)
          {
            localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight(), Bitmap.Config.ARGB_8888);
            localObject2 = new Canvas((Bitmap)localObject1);
            this.jdField_a_of_type_AndroidViewView.draw((Canvas)localObject2);
          }
        }
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(new BitmapShader((Bitmap)localObject1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(@ColorInt int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(@NonNull Canvas paramCanvas)
  {
    if (b())
    {
      int i = jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealHelper$Delegate.a(paramCanvas);
            if (c()) {
              paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
            }
          }
          else
          {
            paramCanvas = new StringBuilder();
            paramCanvas.append("Unsupported strategy ");
            paramCanvas.append(jdField_a_of_type_Int);
            throw new IllegalStateException(paramCanvas.toString());
          }
        }
        else
        {
          i = paramCanvas.save();
          paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
          this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealHelper$Delegate.a(paramCanvas);
          if (c()) {
            paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
          }
          paramCanvas.restoreToCount(i);
        }
      }
      else
      {
        paramCanvas.drawCircle(this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.a, this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.b, this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.c, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (c()) {
          paramCanvas.drawCircle(this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.a, this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.b, this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.c, this.jdField_b_of_type_AndroidGraphicsPaint);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealHelper$Delegate.a(paramCanvas);
      if (c()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
    b(paramCanvas);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(@Nullable CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    if (paramRevealInfo == null)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo = null;
    }
    else
    {
      CircularRevealWidget.RevealInfo localRevealInfo = this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo;
      if (localRevealInfo == null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo = new CircularRevealWidget.RevealInfo(paramRevealInfo);
      } else {
        localRevealInfo.a(paramRevealInfo);
      }
      if (MathUtils.a(paramRevealInfo.c, a(paramRevealInfo), 1.0E-004F)) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget$RevealInfo.c = 3.4028235E+38F;
      }
    }
    c();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealHelper$Delegate.a()) && (!b());
  }
  
  public void b()
  {
    if (jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
      this.jdField_a_of_type_AndroidViewView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealHelper
 * JD-Core Version:    0.7.0.1
 */