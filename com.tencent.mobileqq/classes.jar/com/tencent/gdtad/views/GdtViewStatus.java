package com.tencent.gdtad.views;

import android.view.View;
import java.lang.ref.WeakReference;
import qlf;

public class GdtViewStatus
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference b;
  
  public GdtViewStatus(WeakReference paramWeakReference1, WeakReference paramWeakReference2)
  {
    this(paramWeakReference1, paramWeakReference2, 0.0F);
  }
  
  public GdtViewStatus(WeakReference paramWeakReference1, WeakReference paramWeakReference2, float paramFloat)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference1;
    this.b = paramWeakReference2;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    if (paramInt == 1) {
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2)) {
        this.jdField_a_of_type_Int = paramInt;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != i) {
        e();
      }
      return;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Int = paramInt;
        }
      }
      else if (paramInt == 3) {
        this.jdField_a_of_type_Int = paramInt;
      }
    }
  }
  
  private void e()
  {
    if (this.b.get() == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((GdtViewStatus.Listener)this.b.get()).a();
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    ((GdtViewStatus.Listener)this.b.get()).b();
  }
  
  public void a()
  {
    a(3);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new qlf(this), 500L);
  }
  
  public void c()
  {
    a(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    if (GdtUIUtils.a((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= this.jdField_a_of_type_Float)
    {
      a(2);
      return;
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.GdtViewStatus
 * JD-Core Version:    0.7.0.1
 */