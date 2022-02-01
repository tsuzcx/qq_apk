package com.tencent.mobileqq.apollo.view;

import alyf;
import amlt;
import android.app.Activity;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, amlt paramamlt) {}
  
  public void run()
  {
    alyf localalyf = alyf.a(this.jdField_a_of_type_JavaLangString);
    if ((localalyf == null) || (localalyf.a == null) || (localalyf.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Amlt.a(false, localalyf);
      return;
    }
    this.jdField_a_of_type_Amlt.a(true, localalyf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */