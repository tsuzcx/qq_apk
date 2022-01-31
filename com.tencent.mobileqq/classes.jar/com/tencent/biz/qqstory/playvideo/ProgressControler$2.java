package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import thm;
import tqg;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(thm paramthm) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    tqg localtqg;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localtqg = (tqg)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localtqg == null);
    if (localtqg.b() > 0L)
    {
      this.this$0.a(localtqg.a(), localtqg.b(), localtqg);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */