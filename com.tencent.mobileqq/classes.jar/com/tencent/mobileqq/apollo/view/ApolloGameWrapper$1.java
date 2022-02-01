package com.tencent.mobileqq.apollo.view;

import amyv;
import android.app.Activity;
import annk;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, annk paramannk) {}
  
  public void run()
  {
    amyv localamyv = amyv.a(this.jdField_a_of_type_JavaLangString);
    if ((localamyv == null) || (localamyv.a == null) || (localamyv.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Annk.a(false, localamyv);
      return;
    }
    this.jdField_a_of_type_Annk.a(true, localamyv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */