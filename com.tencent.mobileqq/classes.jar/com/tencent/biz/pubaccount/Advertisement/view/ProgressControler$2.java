package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import java.lang.ref.WeakReference;
import njp;
import ucz;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(njp paramnjp) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    ucz localucz;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localucz = (ucz)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localucz == null);
    if (localucz.b() > 0L)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_Int, localucz.a(), localucz.b(), localucz);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */