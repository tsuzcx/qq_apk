package com.tencent.mobileqq.apollo.view;

import amrr;
import android.app.Activity;
import anfe;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, anfe paramanfe) {}
  
  public void run()
  {
    amrr localamrr = amrr.a(this.jdField_a_of_type_JavaLangString);
    if ((localamrr == null) || (localamrr.a == null) || (localamrr.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Anfe.a(false, localamrr);
      return;
    }
    this.jdField_a_of_type_Anfe.a(true, localamrr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */