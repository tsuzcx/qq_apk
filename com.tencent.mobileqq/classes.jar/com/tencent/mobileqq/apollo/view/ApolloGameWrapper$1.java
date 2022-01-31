package com.tencent.mobileqq.apollo.view;

import akty;
import alhj;
import android.app.Activity;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, alhj paramalhj) {}
  
  public void run()
  {
    akty localakty = akty.a(this.jdField_a_of_type_JavaLangString);
    if ((localakty == null) || (localakty.a == null) || (localakty.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Alhj.a(false, localakty);
      return;
    }
    this.jdField_a_of_type_Alhj.a(true, localakty);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */