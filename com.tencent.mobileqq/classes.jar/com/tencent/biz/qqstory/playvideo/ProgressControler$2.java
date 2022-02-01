package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import xat;
import xjm;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(xat paramxat) {}
  
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
      this.this$0.a(localxjm.a(), localxjm.b(), localxjm);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */