package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import java.lang.ref.WeakReference;
import nml;
import vrr;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(nml paramnml) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    vrr localvrr;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localvrr = (vrr)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localvrr == null);
    if (localvrr.b() > 0L)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_Int, localvrr.a(), localvrr.b(), localvrr);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */