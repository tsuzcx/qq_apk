package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import xar;
import xjm;

public class NewProgressControler$2
  implements Runnable
{
  public NewProgressControler$2(xar paramxar) {}
  
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
      xar.a(this.this$0, localxjm.a(), localxjm.b());
      xar.a(this.this$0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.2
 * JD-Core Version:    0.7.0.1
 */