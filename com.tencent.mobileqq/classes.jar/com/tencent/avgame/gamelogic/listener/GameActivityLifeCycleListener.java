package com.tencent.avgame.gamelogic.listener;

import android.app.Activity;
import java.lang.ref.WeakReference;

public abstract class GameActivityLifeCycleListener
{
  private int jdField_a_of_type_Int = -1;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public Activity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference == null) || (localWeakReference.get() != paramActivity)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                a();
                return;
              }
              a();
              return;
            }
            f();
            return;
          }
          e();
          return;
        }
        d();
        return;
      }
      c();
      return;
    }
    b();
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 5) || (i == -1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener
 * JD-Core Version:    0.7.0.1
 */