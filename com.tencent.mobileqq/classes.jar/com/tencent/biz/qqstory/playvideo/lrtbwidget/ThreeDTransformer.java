package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Build;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ThreeDTransformer
  implements ViewPager.PageTransformer
{
  float jdField_a_of_type_Float;
  public int a;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = true;
  boolean b = true;
  boolean c = false;
  boolean d = false;
  boolean e = "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
  
  public ThreeDTransformer(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  private void a(View paramView)
  {
    if (this.e)
    {
      paramView.setScaleX(1.0F);
      paramView.setTranslationX(0.0F);
      return;
    }
    paramView.setRotationY(0.0F);
  }
  
  private void a(View paramView, float paramFloat)
  {
    int i;
    boolean bool;
    label144:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_Int == 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F))
    {
      i = paramView.hashCode();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) == null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(0));
        SLog.b("ThreeDTransformer", "mInitMatcher viewId: " + i + " | count: " + 0);
      }
    }
    else if ((this.jdField_a_of_type_Int != 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F) && (this.b))
    {
      if (paramFloat >= this.jdField_a_of_type_Float) {
        break label233;
      }
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label239;
      }
      a();
      this.b = false;
      localStringBuilder = new StringBuilder().append("initDrawingView direction: ");
      if (!this.jdField_a_of_type_Boolean) {
        break label246;
      }
    }
    label233:
    label239:
    label246:
    for (paramView = "toLeft";; paramView = "toRight")
    {
      SLog.b("ThreeDTransformer", paramView);
      return;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      SLog.b("ThreeDTransformer", "initDrawingView pos: " + this.jdField_a_of_type_Int);
      return;
      bool = false;
      break;
      b();
      break label144;
    }
  }
  
  private void a(View paramView, float paramFloat, boolean paramBoolean)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.d)
      {
        if (paramBoolean) {
          f1 = paramView.getMeasuredWidth();
        }
        paramView.setPivotX(f1);
        paramView.setPivotY(paramView.getMeasuredHeight() * 0.5F);
        paramView.setRotationY(20.0F * paramFloat);
        return;
      }
      paramView.setRotationY(0.0F);
      return;
    }
    if (this.c)
    {
      f1 = f2;
      if (paramBoolean) {
        f1 = paramView.getMeasuredWidth();
      }
      paramView.setPivotX(f1);
      paramView.setPivotY(paramView.getMeasuredHeight() * 0.5F);
      paramView.setRotationY(20.0F * paramFloat);
      return;
    }
    paramView.setRotationY(0.0F);
  }
  
  private void b(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_Int == paramView.hashCode())
    {
      this.jdField_a_of_type_Float = paramFloat;
      if (QLog.isColorLevel()) {
        QLog.d("ThreeDTransformer", 2, "mlastPos: " + this.jdField_a_of_type_Float + " | mDragingViewID: " + this.jdField_a_of_type_Int);
      }
      if ((paramFloat <= -1.0F) || (paramFloat >= 0.0F))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThreeDTransformer", 2, "is OVER");
        }
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Float = 0.0F;
        this.b = true;
      }
    }
  }
  
  private void b(View paramView, float paramFloat, boolean paramBoolean)
  {
    float f2 = (float)(Math.sin((1.0F + paramFloat) * 3.141592653589793D) * 0.1599999964237213D);
    float f1 = (float)(Math.sin((1.0F - paramFloat) * 3.141592653589793D) * 0.1599999964237213D);
    f2 += 1.0F + paramFloat;
    paramFloat = f1 + (1.0F - paramFloat);
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.d)
      {
        if (paramBoolean)
        {
          paramView.setScaleX(f2);
          paramView.setTranslationX((1.0F - f2) * paramView.getMeasuredWidth() / 2.0F);
          return;
        }
        paramView.setScaleX(paramFloat);
        paramView.setTranslationX(paramView.getMeasuredWidth() * (paramFloat - 1.0F) / 2.0F);
        return;
      }
      paramView.setScaleX(1.0F);
      paramView.setTranslationX(0.0F);
      return;
    }
    if (this.c)
    {
      if (paramBoolean)
      {
        paramView.setScaleX(f2);
        paramView.setTranslationX((1.0F - f2) * paramView.getMeasuredWidth() / 2.0F);
        return;
      }
      paramView.setScaleX(paramFloat);
      paramView.setTranslationX(paramView.getMeasuredWidth() * (paramFloat - 1.0F) / 2.0F);
      return;
    }
    paramView.setScaleX(1.0F);
    paramView.setTranslationX(0.0F);
  }
  
  protected void a() {}
  
  protected void b() {}
  
  public void transformPage(View paramView, float paramFloat)
  {
    paramView.setAlpha(1.0F);
    paramView.setScaleX(1.0F);
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    if ((!this.c) && (!this.d))
    {
      a(paramView);
      return;
    }
    a(paramView, paramFloat);
    if (this.jdField_a_of_type_Int == 0)
    {
      a(paramView);
      return;
    }
    if (paramFloat <= -1.0F) {
      a(paramView);
    }
    for (;;)
    {
      b(paramView, paramFloat);
      return;
      if (paramFloat <= 0.0F)
      {
        if (this.e) {
          b(paramView, paramFloat, true);
        } else {
          a(paramView, paramFloat, true);
        }
      }
      else if (paramFloat < 1.0F)
      {
        if (this.e) {
          b(paramView, paramFloat, false);
        } else {
          a(paramView, paramFloat, false);
        }
      }
      else {
        a(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.ThreeDTransformer
 * JD-Core Version:    0.7.0.1
 */