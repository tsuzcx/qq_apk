package com.tencent.avgame.gamelogic.listener;

import android.app.Activity;
import java.lang.ref.WeakReference;

public abstract class GameActivityLifeCycleListener
{
  private int jdField_a_of_type_Int = -1;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() != paramActivity)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    }
    switch (paramInt)
    {
    default: 
      a();
      return;
    case 0: 
      b();
      return;
    case 1: 
      c();
      return;
    case 2: 
      d();
      return;
    case 3: 
      e();
      return;
    case 4: 
      f();
      return;
    }
    a();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == -1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Int = 3;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener
 * JD-Core Version:    0.7.0.1
 */