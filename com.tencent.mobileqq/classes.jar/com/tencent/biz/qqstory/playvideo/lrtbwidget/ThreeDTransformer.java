package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Build;
import android.view.View;
import androidx.viewpager.widget.ViewPager.PageTransformer;
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
    if ((this.jdField_a_of_type_Int == 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F))
    {
      int i = paramView.hashCode();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) == null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(0));
        paramView = new StringBuilder();
        paramView.append("mInitMatcher viewId: ");
        paramView.append(i);
        paramView.append(" | count: ");
        paramView.append(0);
        SLog.b("ThreeDTransformer", paramView.toString());
      }
      else
      {
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Float = paramFloat;
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        paramView = new StringBuilder();
        paramView.append("initDrawingView pos: ");
        paramView.append(this.jdField_a_of_type_Int);
        SLog.b("ThreeDTransformer", paramView.toString());
        return;
      }
    }
    if ((this.jdField_a_of_type_Int != 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F) && (this.b))
    {
      boolean bool;
      if (paramFloat < this.jdField_a_of_type_Float) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        a();
      } else {
        b();
      }
      this.b = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDrawingView direction: ");
      if (this.jdField_a_of_type_Boolean) {
        paramView = "toLeft";
      } else {
        paramView = "toRight";
      }
      localStringBuilder.append(paramView);
      SLog.b("ThreeDTransformer", localStringBuilder.toString());
    }
  }
  
  private void a(View paramView, float paramFloat, boolean paramBoolean)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (bool)
    {
      if (this.d)
      {
        if (paramBoolean) {
          f1 = paramView.getMeasuredWidth();
        }
        paramView.setPivotX(f1);
        paramView.setPivotY(paramView.getMeasuredHeight() * 0.5F);
        paramView.setRotationY(paramFloat * 20.0F);
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
      paramView.setRotationY(paramFloat * 20.0F);
      return;
    }
    paramView.setRotationY(0.0F);
  }
  
  private void b(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_Int == paramView.hashCode())
    {
      this.jdField_a_of_type_Float = paramFloat;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("mlastPos: ");
        paramView.append(this.jdField_a_of_type_Float);
        paramView.append(" | mDragingViewID: ");
        paramView.append(this.jdField_a_of_type_Int);
        QLog.d("ThreeDTransformer", 2, paramView.toString());
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
    float f1 = paramFloat + 1.0F;
    double d1 = f1;
    Double.isNaN(d1);
    float f2 = (float)(Math.sin(d1 * 3.141592653589793D) * 0.1599999964237213D);
    paramFloat = 1.0F - paramFloat;
    d1 = paramFloat;
    Double.isNaN(d1);
    float f3 = (float)(Math.sin(d1 * 3.141592653589793D) * 0.1599999964237213D);
    f1 += f2;
    paramFloat += f3;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.d)
      {
        if (paramBoolean)
        {
          paramView.setScaleX(f1);
          paramView.setTranslationX(paramView.getMeasuredWidth() * (1.0F - f1) / 2.0F);
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
        paramView.setScaleX(f1);
        paramView.setTranslationX(paramView.getMeasuredWidth() * (1.0F - f1) / 2.0F);
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
    } else if (paramFloat <= 0.0F)
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
    b(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.ThreeDTransformer
 * JD-Core Version:    0.7.0.1
 */