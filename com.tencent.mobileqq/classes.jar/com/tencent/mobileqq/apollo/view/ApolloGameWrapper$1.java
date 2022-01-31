package com.tencent.mobileqq.apollo.view;

import akyn;
import ally;
import android.app.Activity;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, ally paramally) {}
  
  public void run()
  {
    akyn localakyn = akyn.a(this.jdField_a_of_type_JavaLangString);
    if ((localakyn == null) || (localakyn.a == null) || (localakyn.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Ally.a(false, localakyn);
      return;
    }
    this.jdField_a_of_type_Ally.a(true, localakyn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */