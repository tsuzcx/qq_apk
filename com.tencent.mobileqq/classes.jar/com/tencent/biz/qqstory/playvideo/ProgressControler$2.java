package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import vng;
import vwa;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(vng paramvng) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    vwa localvwa;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localvwa = (vwa)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localvwa == null);
    if (localvwa.b() > 0L)
    {
      this.this$0.a(localvwa.a(), localvwa.b(), localvwa);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */