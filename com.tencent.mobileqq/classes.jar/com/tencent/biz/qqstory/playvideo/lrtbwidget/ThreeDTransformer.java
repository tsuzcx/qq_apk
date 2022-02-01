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
  public int a;
  float b;
  boolean c = true;
  boolean d = true;
  boolean e = false;
  boolean f = false;
  boolean g = "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
  HashMap<Integer, Integer> h = new HashMap();
  
  public ThreeDTransformer(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  private void a(View paramView)
  {
    if (this.g)
    {
      paramView.setScaleX(1.0F);
      paramView.setTranslationX(0.0F);
      return;
    }
    paramView.setRotationY(0.0F);
  }
  
  private void a(View paramView, float paramFloat)
  {
    if ((this.a == 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F))
    {
      int i = paramView.hashCode();
      if (this.h.get(Integer.valueOf(i)) == null)
      {
        this.h.put(Integer.valueOf(i), Integer.valueOf(0));
        paramView = new StringBuilder();
        paramView.append("mInitMatcher viewId: ");
        paramView.append(i);
        paramView.append(" | count: ");
        paramView.append(0);
        SLog.b("ThreeDTransformer", paramView.toString());
      }
      else
      {
        this.a = i;
        this.b = paramFloat;
        this.h.clear();
        paramView = new StringBuilder();
        paramView.append("initDrawingView pos: ");
        paramView.append(this.a);
        SLog.b("ThreeDTransformer", paramView.toString());
        return;
      }
    }
    if ((this.a != 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F) && (this.d))
    {
      boolean bool;
      if (paramFloat < this.b) {
        bool = true;
      } else {
        bool = false;
      }
      this.c = bool;
      if (this.c) {
        a();
      } else {
        b();
      }
      this.d = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDrawingView direction: ");
      if (this.c) {
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
    boolean bool = this.c;
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (bool)
    {
      if (this.f)
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
    if (this.e)
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
    if (this.a == paramView.hashCode())
    {
      this.b = paramFloat;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("mlastPos: ");
        paramView.append(this.b);
        paramView.append(" | mDragingViewID: ");
        paramView.append(this.a);
        QLog.d("ThreeDTransformer", 2, paramView.toString());
      }
      if ((paramFloat <= -1.0F) || (paramFloat >= 0.0F))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThreeDTransformer", 2, "is OVER");
        }
        this.a = 0;
        this.b = 0.0F;
        this.d = true;
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
    if (this.c)
    {
      if (this.f)
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
    if (this.e)
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
    if ((!this.e) && (!this.f))
    {
      a(paramView);
      return;
    }
    a(paramView, paramFloat);
    if (this.a == 0)
    {
      a(paramView);
      return;
    }
    if (paramFloat <= -1.0F) {
      a(paramView);
    } else if (paramFloat <= 0.0F)
    {
      if (this.g) {
        b(paramView, paramFloat, true);
      } else {
        a(paramView, paramFloat, true);
      }
    }
    else if (paramFloat < 1.0F)
    {
      if (this.g) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.ThreeDTransformer
 * JD-Core Version:    0.7.0.1
 */