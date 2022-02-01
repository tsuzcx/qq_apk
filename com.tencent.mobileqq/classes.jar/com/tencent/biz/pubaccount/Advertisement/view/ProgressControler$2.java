package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import java.lang.ref.WeakReference;
import ofn;
import xjm;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(ofn paramofn) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    xjm localxjm;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localxjm = (xjm)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localxjm == null);
    if (localxjm.b() > 0L)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_Int, localxjm.a(), localxjm.b(), localxjm);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */