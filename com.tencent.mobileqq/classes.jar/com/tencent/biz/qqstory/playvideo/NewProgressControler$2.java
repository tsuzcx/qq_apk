package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import xkl;
import xtg;

public class NewProgressControler$2
  implements Runnable
{
  public NewProgressControler$2(xkl paramxkl) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    xtg localxtg;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localxtg = (xtg)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localxtg == null);
    if (localxtg.b() > 0L)
    {
      xkl.a(this.this$0, localxtg.a(), localxtg.b());
      xkl.a(this.this$0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.2
 * JD-Core Version:    0.7.0.1
 */