package com.tencent.mobileqq.apollo.view;

import ajcm;
import ajpw;
import android.app.Activity;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, ajpw paramajpw) {}
  
  public void run()
  {
    ajcm localajcm = ajcm.a(this.jdField_a_of_type_JavaLangString);
    if ((localajcm == null) || (localajcm.a == null) || (localajcm.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Ajpw.a(false, localajcm);
      return;
    }
    this.jdField_a_of_type_Ajpw.a(true, localajcm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */