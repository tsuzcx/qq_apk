package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class GroundDrawable
  extends Drawable
  implements Animatable
{
  private float jdField_a_of_type_Float = 16.0F;
  private int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Property<GroundDrawable, Float> jdField_a_of_type_AndroidUtilProperty = new GroundDrawable.1(this, Float.class, "backHeight");
  private PickerBack jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBack = new PickerBack();
  private PickerFore jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore = new PickerFore();
  private WeakReference<GroundDrawable.GroundDrawableListener> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 5.0F;
  private int jdField_b_of_type_Int = 255;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  Property<GroundDrawable, Integer> jdField_b_of_type_AndroidUtilProperty = new GroundDrawable.2(this, Integer.class, "backAlpha");
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 50.0F;
  private int jdField_c_of_type_Int = 0;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  Property<GroundDrawable, Integer> jdField_c_of_type_AndroidUtilProperty = new GroundDrawable.3(this, Integer.class, "speedAlpha");
  private float jdField_d_of_type_Float = 50.0F;
  private int jdField_d_of_type_Int = 179;
  Property<GroundDrawable, Integer> jdField_d_of_type_AndroidUtilProperty = new GroundDrawable.4(this, Integer.class, "reverseAlpha");
  private float jdField_e_of_type_Float = 30.0F;
  private int jdField_e_of_type_Int = 0;
  Property<GroundDrawable, Float> jdField_e_of_type_AndroidUtilProperty = new GroundDrawable.5(this, Float.class, "foreSpeed");
  private float jdField_f_of_type_Float = 22.0F;
  private int jdField_f_of_type_Int = 179;
  Property<GroundDrawable, Float> jdField_f_of_type_AndroidUtilProperty = new GroundDrawable.6(this, Float.class, "foreHeight");
  private int jdField_g_of_type_Int = -1;
  Property<GroundDrawable, Float> jdField_g_of_type_AndroidUtilProperty = new GroundDrawable.7(this, Float.class, "speedPos");
  private int jdField_h_of_type_Int = 0;
  Property<GroundDrawable, Integer> jdField_h_of_type_AndroidUtilProperty = new GroundDrawable.8(this, Integer.class, "markAlpha");
  
  private float a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.centerY();
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_h_of_type_Int == 4)
    {
      float f1 = this.jdField_b_of_type_AndroidGraphicsRectF.centerY();
      this.jdField_b_of_type_AndroidGraphicsRectF.offset(0.0F, paramFloat - f1);
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((GroundDrawable.GroundDrawableListener)localObject).a(this.jdField_h_of_type_Int, this.jdField_b_of_type_AndroidGraphicsRectF);
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int i = getBounds().height();
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    if (paramInt1 == 1)
    {
      localObject = this.jdField_a_of_type_AndroidUtilProperty;
      paramFloat1 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
      paramFloat2 = i;
      localObject = PropertyValuesHolder.ofFloat((Property)localObject, new float[] { paramFloat1, paramFloat2 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat(this.jdField_f_of_type_AndroidUtilProperty, new float[] { this.jdField_c_of_type_AndroidGraphicsRectF.height(), paramFloat2 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_a_of_type_Int, 115 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, PropertyValuesHolder.ofInt(this.jdField_c_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 0 }), PropertyValuesHolder.ofInt(this.jdField_d_of_type_AndroidUtilProperty, new int[] { this.jdField_e_of_type_Int, 255 }), localPropertyValuesHolder2, PropertyValuesHolder.ofInt(this.jdField_h_of_type_AndroidUtilProperty, new int[] { this.jdField_f_of_type_Int, 127 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    else if (paramInt1 == 3)
    {
      localObject = PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_a_of_type_Int, 0 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat(this.jdField_a_of_type_AndroidUtilProperty, new float[] { this.jdField_a_of_type_AndroidGraphicsRectF.height(), 0.0F });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat(this.jdField_f_of_type_AndroidUtilProperty, new float[] { this.jdField_c_of_type_AndroidGraphicsRectF.height(), (int)(i * 0.9F) });
      PropertyValuesHolder localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat(this.jdField_e_of_type_AndroidUtilProperty, new float[] { this.jdField_b_of_type_AndroidGraphicsRectF.height(), (int)this.jdField_c_of_type_Float });
      PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofInt(this.jdField_c_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 255 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder2, localPropertyValuesHolder3, PropertyValuesHolder.ofInt(this.jdField_d_of_type_AndroidUtilProperty, new int[] { this.jdField_e_of_type_Int, 0 }), localPropertyValuesHolder1, localPropertyValuesHolder4, PropertyValuesHolder.ofInt(this.jdField_h_of_type_AndroidUtilProperty, new int[] { this.jdField_f_of_type_Int, 179 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    else if (paramInt1 == 4)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.jdField_g_of_type_AndroidUtilProperty, new float[] { paramFloat1, paramFloat2 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).setRepeatMode(1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new GroundDrawable.9(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new GroundDrawable.10(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_c_of_type_Float = PickerContainer.a(paramContext, this.jdField_c_of_type_Float);
    this.jdField_d_of_type_Float = PickerContainer.a(paramContext, this.jdField_d_of_type_Float);
    this.jdField_e_of_type_Float = PickerContainer.a(paramContext, this.jdField_e_of_type_Float);
    this.jdField_f_of_type_Float = PickerContainer.a(paramContext, this.jdField_f_of_type_Float);
    this.jdField_b_of_type_Float = PickerContainer.a(paramContext, this.jdField_b_of_type_Float);
    this.jdField_a_of_type_Float /= paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(this.jdField_g_of_type_Int);
    if (localObject != null)
    {
      float f1 = ((RectF)localObject).centerX();
      float f2 = ((RectF)localObject).centerY();
      f1 -= this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F;
      f2 -= this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F;
      float f3 = this.jdField_b_of_type_AndroidGraphicsRectF.width();
      float f4 = this.jdField_b_of_type_AndroidGraphicsRectF.height();
      paramCanvas.save();
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds((int)f1, (int)f2, (int)(f3 + f1), (int)(f4 + f2));
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    RectF localRectF = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(this.jdField_c_of_type_Int - 1);
    if ((localRectF != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      float f3 = localRectF.centerX();
      float f2 = localRectF.centerY();
      float f1 = this.jdField_e_of_type_Float;
      f3 -= f1 / 2.0F;
      float f4 = this.jdField_f_of_type_Float;
      f2 -= f4 / 2.0F;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)f3, (int)f2, (int)(f1 + f3), (int)(f4 + f2));
      if (!paramBoolean) {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_e_of_type_Int);
      } else {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(255);
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void a(Rect paramRect)
  {
    if (paramRect == null) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramRect = new StringBuilder();
        paramRect.append("isrunning, cannot resetdata:");
        paramRect.append(this.jdField_h_of_type_Int);
        QLog.d("GroundDrawable", 2, paramRect.toString());
      }
      return;
    }
    int i = this.jdField_h_of_type_Int;
    if ((i != 0) && (i != 1))
    {
      if ((i == 3) || (i == 2))
      {
        a(this.jdField_a_of_type_AndroidGraphicsRectF, paramRect.height());
        a(this.jdField_c_of_type_AndroidGraphicsRectF, paramRect.height());
        paramRect = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBack;
        if (paramRect != null) {
          paramRect.a(this.jdField_a_of_type_AndroidGraphicsRectF);
        }
        paramRect = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore;
        if (paramRect != null) {
          paramRect.a(this.jdField_c_of_type_AndroidGraphicsRectF);
        }
      }
    }
    else
    {
      a(this.jdField_a_of_type_AndroidGraphicsRectF, paramRect.height() * 0.4F);
      PickerBack localPickerBack = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBack;
      if (localPickerBack != null) {
        localPickerBack.a(this.jdField_a_of_type_AndroidGraphicsRectF);
      }
      a(this.jdField_c_of_type_AndroidGraphicsRectF, paramRect.height() * 0.9F);
      paramRect = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore;
      if (paramRect != null) {
        paramRect.a(this.jdField_c_of_type_AndroidGraphicsRectF);
      }
    }
  }
  
  private void a(RectF paramRectF, float paramFloat)
  {
    if (paramRectF == null) {
      return;
    }
    Rect localRect = getBounds();
    float f1 = paramFloat;
    if (localRect.height() < paramFloat) {
      f1 = localRect.height();
    }
    float f2 = localRect.width() * 1.0F / localRect.height() * f1;
    paramFloat = f2;
    if (localRect.width() < f2) {
      paramFloat = localRect.width();
    }
    f2 = (localRect.width() - paramFloat) / 2.0F;
    float f3 = (localRect.height() - f1) / 2.0F;
    paramRectF.set(f2, f3, paramFloat + f2, f1 + f3);
  }
  
  private void a(Float paramFloat)
  {
    if (this.jdField_h_of_type_Int == 3)
    {
      RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.left = (localRectF.centerX() - paramFloat.floatValue() / 2.0F);
      localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.right = (localRectF.centerX() + paramFloat.floatValue() / 2.0F);
      localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.top = (localRectF.centerY() - paramFloat.floatValue() / 2.0F);
      localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.bottom = (localRectF.centerY() + paramFloat.floatValue() / 2.0F);
    }
  }
  
  private float b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.height();
  }
  
  private int b()
  {
    return this.jdField_f_of_type_Int;
  }
  
  private void b(float paramFloat)
  {
    int i = this.jdField_h_of_type_Int;
    if ((i == 1) || (i == 3))
    {
      a(this.jdField_a_of_type_AndroidGraphicsRectF, paramFloat);
      PickerBack localPickerBack = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBack;
      if (localPickerBack != null) {
        localPickerBack.a(this.jdField_a_of_type_AndroidGraphicsRectF);
      }
    }
  }
  
  private void b(int paramInt)
  {
    int i = this.jdField_h_of_type_Int;
    if ((i != 3) && (i != 1))
    {
      if (i == 0)
      {
        this.jdField_f_of_type_Int = 179;
        return;
      }
      this.jdField_f_of_type_Int = 127;
      return;
    }
    this.jdField_f_of_type_Int = paramInt;
  }
  
  private void b(Canvas paramCanvas)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      localDrawable.setBounds((int)this.jdField_b_of_type_AndroidGraphicsRectF.left, (int)this.jdField_b_of_type_AndroidGraphicsRectF.top, (int)this.jdField_b_of_type_AndroidGraphicsRectF.right, (int)this.jdField_b_of_type_AndroidGraphicsRectF.bottom);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private float c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.height();
  }
  
  private int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void c(float paramFloat)
  {
    int i = this.jdField_h_of_type_Int;
    if ((i == 1) || (i == 3))
    {
      a(this.jdField_c_of_type_AndroidGraphicsRectF, paramFloat);
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore;
      if (localObject != null)
      {
        ((PickerFore)localObject).a(this.jdField_c_of_type_AndroidGraphicsRectF);
        localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject != null)
        {
          localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
          if (localObject != null) {
            ((GroundDrawable.GroundDrawableListener)localObject).a(this.jdField_h_of_type_Int, a());
          }
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    int i = this.jdField_h_of_type_Int;
    if ((i != 3) && (i != 1))
    {
      this.jdField_a_of_type_Int = 115;
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private float d()
  {
    return this.jdField_c_of_type_AndroidGraphicsRectF.height();
  }
  
  private int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  private void d(int paramInt)
  {
    int i = this.jdField_h_of_type_Int;
    if ((i != 1) && (i != 3))
    {
      this.jdField_a_of_type_Int = 255;
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private int e()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private void e(int paramInt)
  {
    int i = this.jdField_h_of_type_Int;
    if (i == 1)
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_d_of_type_Int = (255 - this.jdField_e_of_type_Int);
      return;
    }
    if (i == 3)
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_d_of_type_Int = ((int)((255 - this.jdField_e_of_type_Int) * 179 * 1.0F / 255.0F));
    }
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((GroundDrawable.GroundDrawableListener)localObject).b(paramInt);
  }
  
  private void g(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((GroundDrawable.GroundDrawableListener)localObject).a(paramInt);
  }
  
  private void h(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((GroundDrawable.GroundDrawableListener)localObject).c(paramInt);
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public int a(float paramFloat)
  {
    PickerFore localPickerFore = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore;
    if (localPickerFore != null) {
      return localPickerFore.a(paramFloat);
    }
    return 0;
  }
  
  public RectF a()
  {
    PickerFore localPickerFore = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore;
    if (localPickerFore != null) {
      return localPickerFore.a(this.jdField_g_of_type_Int);
    }
    return null;
  }
  
  public RectF a(float paramFloat)
  {
    int i = a(paramFloat);
    PickerFore localPickerFore = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore;
    if (localPickerFore != null) {
      return localPickerFore.a(i);
    }
    return null;
  }
  
  public RectF a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.jdField_g_of_type_Int;
    this.jdField_g_of_type_Int = paramInt;
    if (paramBoolean1) {
      this.jdField_a_of_type_Boolean = paramBoolean1;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore;
    if (localObject1 != null)
    {
      localObject1 = ((PickerFore)localObject1).a(paramInt);
      if (localObject1 != null)
      {
        Object localObject2;
        if (!paramBoolean2)
        {
          this.jdField_b_of_type_AndroidGraphicsRectF.set(((RectF)localObject1).centerX() - this.jdField_c_of_type_Float / 2.0F, ((RectF)localObject1).centerY() - this.jdField_d_of_type_Float / 2.0F, ((RectF)localObject1).centerX() + this.jdField_d_of_type_Float / 2.0F, ((RectF)localObject1).centerY() + this.jdField_d_of_type_Float / 2.0F);
          if (paramBoolean1)
          {
            localObject2 = this.jdField_a_of_type_JavaLangRefWeakReference;
            if (localObject2 != null)
            {
              localObject2 = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject2).get();
              if (localObject2 != null)
              {
                ((GroundDrawable.GroundDrawableListener)localObject2).a(this.jdField_h_of_type_Int, this.jdField_g_of_type_Int, (RectF)localObject1);
                this.jdField_a_of_type_Boolean = false;
              }
            }
          }
          invalidateSelf();
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(i);
          if (localObject2 != null)
          {
            this.jdField_b_of_type_AndroidGraphicsRectF.set(((RectF)localObject2).centerX() - this.jdField_c_of_type_Float / 2.0F, ((RectF)localObject2).centerY() - this.jdField_d_of_type_Float / 2.0F, ((RectF)localObject2).centerX() + this.jdField_d_of_type_Float / 2.0F, ((RectF)localObject2).centerY() + this.jdField_d_of_type_Float / 2.0F);
            float f1 = Math.abs(((RectF)localObject2).centerY() - ((RectF)localObject1).centerY());
            float f2 = this.jdField_a_of_type_Float;
            if (isRunning()) {
              stop();
            }
            this.jdField_h_of_type_Int = 4;
            this.jdField_b_of_type_Boolean = true;
            a(this.jdField_h_of_type_Int, (int)(f1 * f2), ((RectF)localObject2).centerY(), ((RectF)localObject1).centerY());
          }
        }
      }
    }
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBack.a();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_Boolean = false;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidUtilProperty = null;
    this.jdField_b_of_type_AndroidUtilProperty = null;
    this.jdField_c_of_type_AndroidUtilProperty = null;
    this.jdField_d_of_type_AndroidUtilProperty = null;
    this.jdField_e_of_type_AndroidUtilProperty = null;
    this.jdField_f_of_type_AndroidUtilProperty = null;
    this.jdField_g_of_type_AndroidUtilProperty = null;
    this.jdField_h_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
    paramInt = this.jdField_h_of_type_Int;
  }
  
  public boolean a(Context paramContext, int paramInt, float paramFloat1, float paramFloat2, GroundDrawable.GroundDrawableListener paramGroundDrawableListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGroundDrawableListener);
    if (paramInt > 0) {
      this.jdField_a_of_type_Float /= paramInt;
    }
    a(paramContext);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(-1, paramInt, this.jdField_b_of_type_Float, paramFloat1, paramFloat2);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBack.a(0, paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841611);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841610);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.jdField_h_of_type_Int;
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(paramCanvas, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, (int)(this.jdField_e_of_type_Int * 1.0F * 179.0F / 255.0F), this.jdField_f_of_type_Int);
      i = this.jdField_g_of_type_Int;
      if ((i >= 0) && (i < this.jdField_c_of_type_Int)) {
        a(paramCanvas);
      }
    }
    else if ((i != 1) && (i != 3) && (i != 2))
    {
      if (i == 4)
      {
        RectF localRectF = a();
        if (localRectF != null) {
          if (Math.abs(localRectF.centerY() - this.jdField_b_of_type_AndroidGraphicsRectF.centerY()) < this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(paramCanvas, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, (int)(this.jdField_e_of_type_Int * 1.0F * 179.0F / 255.0F), this.jdField_f_of_type_Int);
          } else {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(paramCanvas, this.jdField_d_of_type_Int, -1, (int)(this.jdField_e_of_type_Int * 1.0F * 179.0F / 255.0F), this.jdField_f_of_type_Int);
          }
        }
        i = this.jdField_g_of_type_Int;
        if ((i >= 0) && (i < this.jdField_c_of_type_Int)) {
          b(paramCanvas);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBack.a(paramCanvas, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerFore.a(paramCanvas, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, (int)(this.jdField_e_of_type_Int * 1.0F * 127.0F / 255.0F), this.jdField_f_of_type_Int);
      a(paramCanvas, false);
      i = this.jdField_h_of_type_Int;
      if ((i == 3) || (i == 1))
      {
        if (this.jdField_g_of_type_Int == this.jdField_c_of_type_Int - 1)
        {
          a(paramCanvas, true);
          return;
        }
        a(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a(paramRect);
    int i = this.jdField_g_of_type_Int;
    if (i >= 0)
    {
      a(i, false, false);
      if (this.jdField_a_of_type_Boolean)
      {
        paramRect = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (paramRect != null)
        {
          paramRect = (GroundDrawable.GroundDrawableListener)paramRect.get();
          if (paramRect != null)
          {
            RectF localRectF = new RectF();
            localRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
            paramRect.a(this.jdField_h_of_type_Int, this.jdField_g_of_type_Int, localRectF);
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start :");
      localStringBuilder.append(this.jdField_h_of_type_Int);
      QLog.d("GroundDrawable", 2, localStringBuilder.toString());
    }
    int i = this.jdField_h_of_type_Int;
    if ((i != 1) && (i != 0))
    {
      if ((i == 3) || (i == 2))
      {
        this.jdField_h_of_type_Int = 3;
        a(this.jdField_h_of_type_Int, 200, -1.0F, -1.0F);
      }
    }
    else
    {
      this.jdField_h_of_type_Int = 1;
      a(this.jdField_h_of_type_Int, 300, -1.0F, -1.0F);
    }
  }
  
  public void stop()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int i = this.jdField_h_of_type_Int;
    if (i == 1)
    {
      this.jdField_h_of_type_Int = 2;
      a(getBounds());
      this.jdField_a_of_type_Int = 115;
      return;
    }
    if (i == 3)
    {
      this.jdField_h_of_type_Int = 0;
      a(getBounds());
      this.jdField_a_of_type_Int = 115;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.GroundDrawable
 * JD-Core Version:    0.7.0.1
 */