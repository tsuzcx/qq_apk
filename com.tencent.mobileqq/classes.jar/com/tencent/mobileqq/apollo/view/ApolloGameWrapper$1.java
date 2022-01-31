package com.tencent.mobileqq.apollo.view;

import ajco;
import ajpy;
import android.app.Activity;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, ajpy paramajpy) {}
  
  public void run()
  {
    ajco localajco = ajco.a(this.jdField_a_of_type_JavaLangString);
    if ((localajco == null) || (localajco.a == null) || (localajco.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Ajpy.a(false, localajco);
      return;
    }
    this.jdField_a_of_type_Ajpy.a(true, localajco);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */