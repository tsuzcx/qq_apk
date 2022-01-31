package com.tencent.mobileqq.apollo.view;

import aipq;
import ajbw;
import android.app.Activity;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, ajbw paramajbw) {}
  
  public void run()
  {
    aipq localaipq = aipq.a(this.jdField_a_of_type_JavaLangString);
    if ((localaipq == null) || (localaipq.a == null) || (localaipq.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Ajbw.a(false, localaipq);
      return;
    }
    this.jdField_a_of_type_Ajbw.a(true, localaipq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */