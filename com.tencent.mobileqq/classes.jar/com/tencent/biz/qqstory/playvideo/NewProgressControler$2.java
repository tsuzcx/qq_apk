package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import tug;
import udc;

public class NewProgressControler$2
  implements Runnable
{
  public NewProgressControler$2(tug paramtug) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    udc localudc;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localudc = (udc)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localudc == null);
    if (localudc.b() > 0L)
    {
      tug.a(this.this$0, localudc.a(), localudc.b());
      tug.a(this.this$0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.2
 * JD-Core Version:    0.7.0.1
 */