package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import xgq;
import xpl;

public class NewProgressControler$2
  implements Runnable
{
  public NewProgressControler$2(xgq paramxgq) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    xpl localxpl;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localxpl = (xpl)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localxpl == null);
    if (localxpl.b() > 0L)
    {
      xgq.a(this.this$0, localxpl.a(), localxpl.b());
      xgq.a(this.this$0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.2
 * JD-Core Version:    0.7.0.1
 */