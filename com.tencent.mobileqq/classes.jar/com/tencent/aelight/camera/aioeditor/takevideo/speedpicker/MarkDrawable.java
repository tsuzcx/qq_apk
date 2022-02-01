package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkDrawable
  extends Drawable
  implements Animatable
{
  private float jdField_a_of_type_Float = 68.0F;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Property<MarkDrawable, Integer> jdField_a_of_type_AndroidUtilProperty = new MarkDrawable.1(this, Integer.class, "bfIndex");
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<MarkDrawable.MarkDrawableListener> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 68.0F;
  private int jdField_b_of_type_Int = 255;
  private AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  Property<MarkDrawable, Integer> jdField_b_of_type_AndroidUtilProperty = new MarkDrawable.2(this, Integer.class, "textAlpha");
  private Map<String, Drawable> jdField_b_of_type_JavaUtilMap = new HashMap();
  private float jdField_c_of_type_Float = 30.0F;
  private int jdField_c_of_type_Int = 1;
  private AnimationDrawable jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
  Property<MarkDrawable, Float> jdField_c_of_type_AndroidUtilProperty = new MarkDrawable.3(this, Float.class, "textPos");
  private float d = 70.0F;
  private float e = 60.0F;
  private float f = 50.0F;
  private float g = 35.0F;
  private float h = 5.0F;
  private float i = this.h;
  
  private float a()
  {
    return this.i;
  }
  
  private int a(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames()) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() - paramInt;
  }
  
  private AnimationDrawable a(Context paramContext, int paramInt)
  {
    paramContext = (AnimationDrawable)paramContext.getResources().getDrawable(paramInt);
    paramContext.setVisible(true, false);
    paramContext.setOneShot(true);
    return paramContext;
  }
  
  private void a(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramFloat4 /= 2.0F;
    localRectF.bottom = (paramFloat2 + paramFloat4);
    localRectF.top = (paramFloat2 - paramFloat4);
    paramFloat2 = paramFloat3 / 2.0F;
    localRectF.right = (paramFloat1 + paramFloat2);
    localRectF.left = (paramFloat1 - paramFloat2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startValueAnimator: state:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append(" mIndex:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" mTextAlpha:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 2)
    {
      localObject = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { this.jdField_a_of_type_Int, ((AnimationDrawable)localObject).getNumberOfFrames() }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(600L);
      }
    }
    else if (paramInt1 == 4)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
      {
        paramInt1 = a(this.jdField_a_of_type_Int);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("calcBackIndex return : ");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { paramInt1, this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
      }
    }
    else if (paramInt1 == 5)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 255 }), PropertyValuesHolder.ofFloat(this.jdField_c_of_type_AndroidUtilProperty, new float[] { this.i, 0.0F }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    else if (paramInt1 == 6)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 0 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).setRepeatMode(1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new MarkDrawable.4(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new MarkDrawable.5(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Float = PickerContainer.a(paramContext, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = PickerContainer.a(paramContext, this.jdField_b_of_type_Float);
    this.jdField_c_of_type_Float = PickerContainer.a(paramContext, this.jdField_c_of_type_Float);
    this.d = PickerContainer.a(paramContext, this.d);
    this.e = PickerContainer.a(paramContext, this.e);
    this.f = PickerContainer.a(paramContext, this.f);
    this.g = PickerContainer.a(paramContext, this.g);
    this.h = PickerContainer.a(paramContext, this.h);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
    {
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        localList = this.jdField_a_of_type_JavaUtilList;
        localList.set(j, Integer.valueOf((int)PickerContainer.a(paramContext, ((Integer)localList.get(j)).intValue())));
        j += 1;
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    int j = this.jdField_c_of_type_Int;
    if (j == 1) {
      return;
    }
    Object localObject;
    if (j == 2)
    {
      localObject = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
      if (localObject != null)
      {
        j = ((AnimationDrawable)localObject).getNumberOfFrames();
        if (this.jdField_a_of_type_Int >= j) {
          this.jdField_a_of_type_Int = (j - 1);
        }
        localObject = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(this.jdField_a_of_type_Int);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
      }
    }
    else if (j == 3)
    {
      localObject = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
      localObject = ((AnimationDrawable)localObject).getFrame(((AnimationDrawable)localObject).getNumberOfFrames() - 1);
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
    else if (j == 4)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
      if (localObject == null) {
        return;
      }
      j = ((AnimationDrawable)localObject).getNumberOfFrames();
      if (this.jdField_a_of_type_Int >= j) {
        this.jdField_a_of_type_Int = (j - 1);
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(this.jdField_a_of_type_Int);
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(this.jdField_a_of_type_Int);
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
  }
  
  private int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1000));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(42));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(47));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(54));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(61));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(65));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(67));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(69));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(66));
    List localList = this.jdField_a_of_type_JavaUtilList;
    Integer localInteger = Integer.valueOf(64);
    localList.add(localInteger);
    this.jdField_a_of_type_JavaUtilList.add(localInteger);
    this.jdField_a_of_type_JavaUtilList.add(localInteger);
    this.jdField_a_of_type_JavaUtilList.add(localInteger);
    this.jdField_a_of_type_JavaUtilList.add(localInteger);
  }
  
  private void b(float paramFloat)
  {
    a(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), paramFloat, paramFloat);
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("1/2", paramContext.getResources().getDrawable(2130841568));
    this.jdField_a_of_type_JavaUtilMap.put("1/4", paramContext.getResources().getDrawable(2130841569));
    this.jdField_a_of_type_JavaUtilMap.put("1x", paramContext.getResources().getDrawable(2130841570));
    this.jdField_a_of_type_JavaUtilMap.put("2x", paramContext.getResources().getDrawable(2130841571));
    this.jdField_a_of_type_JavaUtilMap.put("4x", paramContext.getResources().getDrawable(2130841572));
    this.jdField_a_of_type_JavaUtilMap.put(PickerContainer.jdField_a_of_type_JavaLangString, paramContext.getResources().getDrawable(2130841595));
    this.jdField_b_of_type_JavaUtilMap.put("1/2", paramContext.getResources().getDrawable(2130841612));
    this.jdField_b_of_type_JavaUtilMap.put("1/4", paramContext.getResources().getDrawable(2130841613));
    this.jdField_b_of_type_JavaUtilMap.put("1x", paramContext.getResources().getDrawable(2130841614));
    this.jdField_b_of_type_JavaUtilMap.put("2x", paramContext.getResources().getDrawable(2130841615));
    this.jdField_b_of_type_JavaUtilMap.put("4x", paramContext.getResources().getDrawable(2130841616));
    this.jdField_b_of_type_JavaUtilMap.put(PickerContainer.jdField_a_of_type_JavaLangString, paramContext.getResources().getDrawable(2130841617));
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    if (this.jdField_c_of_type_Int == 1) {
      return;
    }
    Rect localRect = new Rect((int)this.jdField_a_of_type_AndroidGraphicsRectF.left, (int)this.jdField_a_of_type_AndroidGraphicsRectF.top, (int)this.jdField_a_of_type_AndroidGraphicsRectF.right, (int)this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  private int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void c(float paramFloat)
  {
    a(getBounds().width() - paramFloat, this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height());
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_c_of_type_Int;
    if (paramInt == 2)
    {
      paramInt = this.jdField_a_of_type_Int;
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        paramInt = ((Integer)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).intValue();
        c(this.g + paramInt);
        b(this.jdField_a_of_type_Float);
      }
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt == 1)
      {
        this.jdField_b_of_type_Int = 51;
        return;
      }
      if (paramInt == 2)
      {
        this.jdField_b_of_type_Int = 127;
        return;
      }
      this.jdField_b_of_type_Int = 255;
      return;
    }
    if (paramInt == 4)
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null))
      {
        localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((MarkDrawable.MarkDrawableListener)localObject).a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames());
        }
      }
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    int j = this.jdField_c_of_type_Int;
    if ((j != 2) && (j != 4))
    {
      if (j == 3) {
        return;
      }
      Rect localRect = getBounds();
      j = (int)(localRect.right - this.d - this.e);
      float f1 = localRect.centerY();
      float f2 = this.f;
      int k = (int)(f1 - f2 / 2.0F);
      localRect = new Rect(j, k, (int)(j + this.e), (int)(k + f2));
      if (this.jdField_c_of_type_Int == 5) {
        localRect.offset(0, (int)this.i);
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((MarkDrawable.MarkDrawableListener)localObject).e(paramInt);
  }
  
  private void e(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((MarkDrawable.MarkDrawableListener)localObject).d(paramInt);
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((MarkDrawable.MarkDrawableListener)localObject).f(paramInt);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Boolean = false;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidUtilProperty = null;
    this.jdField_b_of_type_AndroidUtilProperty = null;
    this.jdField_c_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAnimState: old state:");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(" new state:");
      localStringBuilder.append(paramInt);
      QLog.d("MarkDrawable", 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_Int = paramInt;
    paramInt = this.jdField_c_of_type_Int;
    if (paramInt != 2)
    {
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 5)) {}
    }
    else
    {
      this.jdField_a_of_type_Int = 0;
      b(this.jdField_a_of_type_Float);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)this.jdField_a_of_type_JavaUtilMap.get(paramString));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)this.jdField_b_of_type_JavaUtilMap.get(paramString));
    invalidateSelf();
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, MarkDrawable.MarkDrawableListener paramMarkDrawableListener)
  {
    b();
    a(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = a(paramContext, paramInt1);
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = a(paramContext, paramInt2);
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = a(paramContext, paramInt3);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMarkDrawableListener);
    b(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16777215);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = this.jdField_c_of_type_Int;
    if (j == 0) {
      return;
    }
    if ((j != 2) && (j != 4) && (j != 3))
    {
      if ((j == 5) || (j == 1) || (j == 6)) {
        c(paramCanvas);
      }
    }
    else
    {
      a(paramCanvas);
      if (this.jdField_c_of_type_Int != 4) {
        b(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBoundsChange: mState:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append(" bound:");
      ((StringBuilder)localObject).append(paramRect);
      QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
    int k = 0;
    int j;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).setBounds(paramRect);
      j = 0;
      while (j < this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        localObject = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(j);
        if (localObject != null) {
          ((Drawable)localObject).setBounds(paramRect);
        }
        j += 1;
      }
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).setBounds(paramRect);
      j = 0;
      while (j < this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(j);
        if (localObject != null) {
          ((Drawable)localObject).setBounds(paramRect);
        }
        j += 1;
      }
    }
    localObject = this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).setBounds(paramRect);
      j = k;
      while (j < this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        localObject = this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(j);
        if (localObject != null) {
          ((Drawable)localObject).setBounds(paramRect);
        }
        j += 1;
      }
    }
    a(paramRect.centerX(), paramRect.centerY(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start:");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(" isRunning:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("MarkDrawable", 2, localStringBuilder.toString());
    }
    if (isRunning()) {
      stop();
    }
    this.jdField_a_of_type_Boolean = true;
    int j = this.jdField_c_of_type_Int;
    if ((j != 2) && (j != 1))
    {
      if ((j != 4) && (j != 3))
      {
        if ((j == 5) || (j == 6)) {
          a(this.jdField_c_of_type_Int, 200);
        }
      }
      else
      {
        this.jdField_c_of_type_Int = 4;
        a(this.jdField_c_of_type_Int, 400);
      }
    }
    else
    {
      this.jdField_c_of_type_Int = 2;
      a(this.jdField_c_of_type_Int, 600);
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stop:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append(" isRunning:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.MarkDrawable
 * JD-Core Version:    0.7.0.1
 */