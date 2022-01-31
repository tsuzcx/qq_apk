package com.tencent.mobileqq.arcard;

import aasr;
import aass;
import aast;
import aasu;
import aasv;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class ARCardPageProcess
  extends FrameLayout
{
  public static final int a;
  public static final float[] a;
  public static final int b;
  private static int c = 16;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public volatile boolean a;
  public volatile boolean b;
  private int d;
  private volatile int e = -1;
  private int f;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.75F, 0.5F };
    jdField_a_of_type_Int = jdField_a_of_type_ArrayOfFloat.length;
    jdField_b_of_type_Int = 9 - jdField_a_of_type_Int * 2;
  }
  
  public ARCardPageProcess(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ARCardPageProcess(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ARCardPageProcess(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  private int a(int paramInt)
  {
    return paramInt / 2 * c * -1;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private ValueAnimator a(ARCardPageProcess.Circle paramCircle, float paramFloat)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramCircle.getTranslationX(), paramFloat });
    localValueAnimator.setTarget(paramCircle);
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new aasu(this, paramCircle));
    return localValueAnimator;
  }
  
  private ValueAnimator a(ARCardPageProcess.Circle paramCircle, boolean paramBoolean)
  {
    float f2 = 1.0F;
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label67;
      }
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f1, f2 });
      localValueAnimator.setTarget(paramCircle);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new aasv(this, paramCircle));
      return localValueAnimator;
      f1 = 1.0F;
      break;
      label67:
      f2 = 0.0F;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      ARCardPageProcess.Circle localCircle;
      for (int i = this.f - 1;; i = this.f + 1)
      {
        localCircle = (ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localCircle != null) {
          break;
        }
        return false;
      }
      i = localCircle.a();
      if (i != 0) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  private boolean b(boolean paramBoolean)
  {
    boolean bool = true;
    int i;
    if (a(paramBoolean))
    {
      if (!paramBoolean) {
        break label73;
      }
      i = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
      if (i >= jdField_a_of_type_Int) {
        break label46;
      }
    }
    label46:
    label73:
    do
    {
      return false;
      if (this.d - this.e - (i + jdField_b_of_type_Int) > 0) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
      i = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a() * -1;
    } while (i < jdField_a_of_type_Int);
    if (this.e + 1 - (i + jdField_b_of_type_Int) > 0) {}
    for (paramBoolean = bool;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  private void c()
  {
    c = a(this.jdField_a_of_type_AndroidContentContext, 16.0F);
    this.jdField_a_of_type_Boolean = false;
    setClickable(false);
  }
  
  private boolean c(boolean paramBoolean)
  {
    boolean bool = true;
    if (a(paramBoolean))
    {
      if (paramBoolean)
      {
        i = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a();
        return this.e + 1 - i * -1 > 0;
      }
      int i = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
      if (this.d - this.e - i > 0) {}
      for (paramBoolean = bool;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    return false;
  }
  
  private void d()
  {
    int i = 0;
    if (this.d <= 0) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    int j;
    ARCardPageProcess.Circle localCircle;
    FrameLayout.LayoutParams localLayoutParams;
    for (;;)
    {
      removeAllViews();
      if (this.d >= 9) {
        break label174;
      }
      j = a(this.d);
      while (i < this.d)
      {
        localCircle = new ARCardPageProcess.Circle(this, this.jdField_a_of_type_AndroidContentContext);
        localCircle.setCircleRadius(4.0F);
        localLayoutParams = new FrameLayout.LayoutParams(c, c);
        localCircle.setTranslationX(j);
        j += c;
        localCircle.setLayoutParams(localLayoutParams);
        addView(localCircle);
        this.jdField_a_of_type_JavaUtilArrayList.add(localCircle);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.f = this.e;
    ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.f)).setChecked(true);
    return;
    label174:
    int k;
    label202:
    int m;
    if (this.e + 1 < jdField_a_of_type_Int)
    {
      k = jdField_b_of_type_Int + jdField_a_of_type_Int;
      j = a(k);
      i = 0;
      if (i < k)
      {
        localCircle = new ARCardPageProcess.Circle(this, this.jdField_a_of_type_AndroidContentContext);
        localCircle.setCircleRadius(4.0F);
        localLayoutParams = new FrameLayout.LayoutParams(c, c);
        localCircle.setTranslationX(j);
        j += c;
        localCircle.setLayoutParams(localLayoutParams);
        if (i != this.e) {
          break label336;
        }
        this.f = i;
        localCircle.setChecked(true);
      }
      for (;;)
      {
        if (i >= jdField_b_of_type_Int)
        {
          m = i - jdField_b_of_type_Int;
          if (m < jdField_a_of_type_Int) {
            localCircle.setScarleType(m + 1);
          }
        }
        addView(localCircle);
        this.jdField_a_of_type_JavaUtilArrayList.add(localCircle);
        i += 1;
        break label202;
        break;
        label336:
        localCircle.setChecked(false);
      }
    }
    if (this.d - this.e <= jdField_a_of_type_Int)
    {
      k = jdField_b_of_type_Int + jdField_a_of_type_Int;
      i = a(k);
      j = 0;
      label376:
      if (j < k)
      {
        localCircle = new ARCardPageProcess.Circle(this, this.jdField_a_of_type_AndroidContentContext);
        localCircle.setCircleRadius(4.0F);
        localLayoutParams = new FrameLayout.LayoutParams(c, c);
        localCircle.setTranslationX(i);
        m = c;
        localCircle.setLayoutParams(localLayoutParams);
        this.f = (k - (this.d - this.e));
        if (j != this.f) {
          break label514;
        }
      }
      label514:
      for (bool = true;; bool = false)
      {
        localCircle.setChecked(bool);
        if (j < jdField_a_of_type_Int) {
          localCircle.setScarleType(j - jdField_a_of_type_Int);
        }
        addView(localCircle);
        this.jdField_a_of_type_JavaUtilArrayList.add(localCircle);
        j += 1;
        i = m + i;
        break label376;
        break;
      }
    }
    i = this.e + 1 - (jdField_b_of_type_Int / 2 + jdField_b_of_type_Int % 2);
    label546:
    label575:
    int n;
    label594:
    int i1;
    label671:
    int i2;
    int i3;
    int i4;
    if (i < jdField_a_of_type_Int)
    {
      j = this.d - this.e - (jdField_b_of_type_Int / 2 + jdField_b_of_type_Int % 2);
      if (j >= jdField_a_of_type_Int) {
        break label765;
      }
      n = jdField_b_of_type_Int + i + j;
      k = a(n);
      m = 0;
      if (m < n)
      {
        localCircle = new ARCardPageProcess.Circle(this, this.jdField_a_of_type_AndroidContentContext);
        localCircle.setCircleRadius(4.0F);
        localLayoutParams = new FrameLayout.LayoutParams(c, c);
        localCircle.setTranslationX(k);
        i1 = c;
        localCircle.setLayoutParams(localLayoutParams);
        if (m >= i) {
          break label772;
        }
        localCircle.setScarleType(m - i);
        i2 = this.e;
        i3 = this.d;
        i4 = this.e;
        if (i2 - i >= jdField_b_of_type_Int / 2) {
          break label817;
        }
        this.f = this.e;
        if (m != this.f) {
          break label811;
        }
      }
    }
    label772:
    label811:
    for (boolean bool = true;; bool = false)
    {
      localCircle.setChecked(bool);
      addView(localCircle);
      this.jdField_a_of_type_JavaUtilArrayList.add(localCircle);
      m += 1;
      k = i1 + k;
      break label594;
      break;
      i = jdField_a_of_type_Int;
      break label546;
      label765:
      j = jdField_a_of_type_Int;
      break label575;
      if (n - m > j) {
        break label671;
      }
      i2 = m - (jdField_b_of_type_Int + i);
      if (i2 >= jdField_a_of_type_Int) {
        break label671;
      }
      localCircle.setScarleType(i2 + 1);
      break label671;
    }
    label817:
    if (i3 - i4 - j < jdField_b_of_type_Int / 2)
    {
      this.f = (n - (this.d - this.e));
      if (m == this.f) {}
      for (bool = true;; bool = false)
      {
        localCircle.setChecked(bool);
        break;
      }
    }
    this.f = (jdField_b_of_type_Int / 2 + i);
    if (m == this.f) {}
    for (bool = true;; bool = false)
    {
      localCircle.setChecked(bool);
      break;
    }
  }
  
  public void a()
  {
    if ((this.d <= 0) || (this.e <= 0)) {}
    for (;;)
    {
      return;
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.e -= 1;
        int i;
        Object localObject1;
        boolean bool1;
        if (this.d < 9)
        {
          i = 0;
          while (i < this.d)
          {
            localObject1 = (ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (localObject1 == null)
            {
              i += 1;
            }
            else
            {
              if (i == this.e) {}
              for (bool1 = true;; bool1 = false)
              {
                ((ARCardPageProcess.Circle)localObject1).setChecked(bool1);
                break;
              }
            }
          }
          this.jdField_a_of_type_Boolean = false;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ARCardPageProcess", 2, "PageUp end, pageCount = " + this.d + "  mCurrentPageIndex =" + this.e + " pointList.size = " + this.jdField_a_of_type_JavaUtilArrayList.size() + "  mShowCheckIndex =" + this.f);
          return;
          boolean bool2;
          try
          {
            if (!a(true)) {
              break label767;
            }
            bool1 = c(true);
            bool2 = b(true);
            int j = this.jdField_a_of_type_JavaUtilArrayList.size();
            i = j;
            if (bool1) {
              i = j + 1;
            }
            int m = a(i);
            j = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a();
            int n;
            int k;
            label409:
            int i1;
            if (bool1)
            {
              localObject1 = new ARCardPageProcess.Circle(this, this.jdField_a_of_type_AndroidContentContext);
              ((ARCardPageProcess.Circle)localObject1).setCircleRadius(4.0F);
              localObject2 = new FrameLayout.LayoutParams(c, c);
              ((ARCardPageProcess.Circle)localObject1).setTranslationX(m);
              n = c;
              ((ARCardPageProcess.Circle)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              k = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a();
              i = k;
              if (k * -1 < jdField_a_of_type_Int) {
                i = k - 1;
              }
              ((ARCardPageProcess.Circle)localObject1).setScarleType(i);
              ((ARCardPageProcess.Circle)localObject1).setAlpha(0.0F);
              addView((View)localObject1);
              this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject1);
              k = m + n;
              i = j;
              j = k;
              localObject1 = new ArrayList();
              n = 0;
              m = 0;
              k = j;
              j = n;
              n = i;
              if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
                break label728;
              }
              localObject2 = (ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(j);
              ((List)localObject1).add(a((ARCardPageProcess.Circle)localObject2, k));
              if ((((ARCardPageProcess.Circle)localObject2).getAlpha() == 0.0F) && (bool1)) {
                ((List)localObject1).add(a((ARCardPageProcess.Circle)localObject2, true));
              }
              if ((bool2) && (j == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
                ((List)localObject1).add(a((ARCardPageProcess.Circle)localObject2, false));
              }
              if (bool2)
              {
                i1 = m;
                i = n;
                if (j == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {}
              }
              else
              {
                if (n == 0) {
                  break label617;
                }
                ((ARCardPageProcess.Circle)localObject2).setScarleType(n);
                i = n + 1;
                i1 = m;
              }
              label558:
              if ((i != 0) || (i1 != 1)) {
                break label693;
              }
              ((ARCardPageProcess.Circle)localObject2).setChecked(true);
              this.f = j;
            }
            for (;;)
            {
              k += c;
              j += 1;
              m = i1;
              n = i;
              break label409;
              i = c + m;
              k = j + 1;
              j = i;
              i = k;
              break;
              label617:
              i1 = m;
              i = n;
              if (n != 0) {
                break label558;
              }
              if (m < jdField_b_of_type_Int)
              {
                ((ARCardPageProcess.Circle)localObject2).setScarleType(n);
                i1 = m + 1;
                i = n;
                break label558;
              }
              i1 = m;
              i = n;
              if (m != jdField_b_of_type_Int) {
                break label558;
              }
              i = n + 1;
              ((ARCardPageProcess.Circle)localObject2).setScarleType(i);
              i += 1;
              i1 = m;
              break label558;
              label693:
              ((ARCardPageProcess.Circle)localObject2).setChecked(false);
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ARCardPageProcess", 2, "PageUp has Exception ", localException);
            }
            this.jdField_a_of_type_Boolean = false;
          }
          label728:
          Object localObject2 = new AnimatorSet();
          ((AnimatorSet)localObject2).playTogether(localException);
          ((AnimatorSet)localObject2).addListener(new aass(this, bool2));
          ((AnimatorSet)localObject2).start();
          continue;
          label767:
          if ((this.f >= 0) && (this.f < this.jdField_a_of_type_JavaUtilArrayList.size())) {
            ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.f)).setChecked(false);
          }
          this.f -= 1;
          ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.f)).setChecked(true);
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARCardPageProcess", 2, "ResetPageInfo, pageCount = " + paramInt1 + "  currentIndex =" + paramInt2);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 >= paramInt1)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.d = paramInt1;
    this.e = paramInt2;
    ThreadManager.getUIHandler().post(new aasr(this));
  }
  
  public void b()
  {
    if ((this.d <= 0) || (this.e >= this.d - 1)) {}
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.e += 1;
    int i;
    Object localObject1;
    boolean bool1;
    if (this.d < 9)
    {
      i = 0;
      while (i < this.d)
      {
        localObject1 = (ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localObject1 == null)
        {
          i += 1;
        }
        else
        {
          if (i == this.e) {}
          for (bool1 = true;; bool1 = false)
          {
            ((ARCardPageProcess.Circle)localObject1).setChecked(bool1);
            break;
          }
        }
      }
      this.jdField_a_of_type_Boolean = false;
      label126:
      if (!QLog.isColorLevel()) {
        break label813;
      }
      QLog.d("ARCardPageProcess", 2, "PageDown end, pageCount = " + this.d + "  mCurrentPageIndex =" + this.e + " pointList.size = " + this.jdField_a_of_type_JavaUtilArrayList.size() + "  mShowCheckIndex =" + this.f);
    }
    for (;;)
    {
      boolean bool2;
      int j;
      int m;
      int n;
      int i1;
      try
      {
        if (!a(false)) {
          break label761;
        }
        bool1 = c(false);
        bool2 = b(false);
        j = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = j;
        if (bool1) {
          i = j + 1;
        }
        i = a(i) + i * c;
        j = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
        int k;
        if (bool1)
        {
          localObject1 = new ARCardPageProcess.Circle(this, this.jdField_a_of_type_AndroidContentContext);
          ((ARCardPageProcess.Circle)localObject1).setCircleRadius(4.0F);
          localObject2 = new FrameLayout.LayoutParams(c, c);
          ((ARCardPageProcess.Circle)localObject1).setTranslationX(i);
          k = i - c;
          ((ARCardPageProcess.Circle)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          m = ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
          i = m;
          if (m < jdField_a_of_type_Int) {
            i = m + 1;
          }
          ((ARCardPageProcess.Circle)localObject1).setScarleType(i);
          ((ARCardPageProcess.Circle)localObject1).setAlpha(0.0F);
          addView((View)localObject1);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          i = j;
          j = k;
          localObject1 = new ArrayList();
          n = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          m = 0;
          k = j;
          j = n;
          n = i;
          if (j < 0) {
            break label722;
          }
          localObject2 = (ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          ((List)localObject1).add(a((ARCardPageProcess.Circle)localObject2, k));
          if ((((ARCardPageProcess.Circle)localObject2).getAlpha() == 0.0F) && (bool1)) {
            ((List)localObject1).add(a((ARCardPageProcess.Circle)localObject2, true));
          }
          if ((!bool2) || (j != 0)) {
            break label815;
          }
          ((List)localObject1).add(a((ARCardPageProcess.Circle)localObject2, false));
          break label815;
          if (n != 0)
          {
            ((ARCardPageProcess.Circle)localObject2).setScarleType(n);
            i = n - 1;
            i1 = m;
            if ((i != 0) || (i1 != 1)) {
              continue;
            }
            ((ARCardPageProcess.Circle)localObject2).setChecked(true);
            this.f = j;
            k -= c;
            j -= 1;
            m = i1;
            n = i;
            continue;
          }
        }
        else
        {
          i -= c;
          k = j - 1;
          j = i;
          i = k;
          continue;
        }
        i1 = m;
        i = n;
        if (n != 0) {
          continue;
        }
        if (m < jdField_b_of_type_Int)
        {
          ((ARCardPageProcess.Circle)localObject2).setScarleType(n);
          i1 = m + 1;
          i = n;
          continue;
        }
        i1 = m;
        i = n;
        if (m != jdField_b_of_type_Int) {
          continue;
        }
        i = n - 1;
        ((ARCardPageProcess.Circle)localObject2).setScarleType(i);
        i -= 1;
        i1 = m;
        continue;
        ((ARCardPageProcess.Circle)localObject2).setChecked(false);
        continue;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARCardPageProcess", 2, "PageDown has Exception ", localException);
        }
        this.jdField_a_of_type_Boolean = false;
      }
      label722:
      Object localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).playTogether(localException);
      ((AnimatorSet)localObject2).addListener(new aast(this, bool2));
      ((AnimatorSet)localObject2).start();
      break label126;
      label761:
      ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.f)).setChecked(false);
      this.f += 1;
      ((ARCardPageProcess.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(this.f)).setChecked(true);
      this.jdField_a_of_type_Boolean = false;
      break label126;
      label813:
      break;
      label815:
      if (bool2)
      {
        i1 = m;
        i = n;
        if (j == 0) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardPageProcess
 * JD-Core Version:    0.7.0.1
 */