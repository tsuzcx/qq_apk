package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import wly;
import wur;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(wly paramwly) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    wur localwur;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localwur = (wur)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localwur == null);
    if (localwur.b() > 0L)
    {
      this.this$0.a(localwur.a(), localwur.b(), localwur);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */