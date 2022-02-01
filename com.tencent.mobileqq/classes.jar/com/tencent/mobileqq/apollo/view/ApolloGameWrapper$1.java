package com.tencent.mobileqq.apollo.view;

import andl;
import android.app.Activity;
import anqz;
import java.lang.ref.WeakReference;

public final class ApolloGameWrapper$1
  implements Runnable
{
  public ApolloGameWrapper$1(String paramString, Activity paramActivity, anqz paramanqz) {}
  
  public void run()
  {
    andl localandl = andl.a(this.jdField_a_of_type_JavaLangString);
    if ((localandl == null) || (localandl.a == null) || (localandl.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_Anqz.a(false, localandl);
      return;
    }
    this.jdField_a_of_type_Anqz.a(true, localandl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */