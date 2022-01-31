package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import vne;
import vwa;

public class NewProgressControler$2
  implements Runnable
{
  public NewProgressControler$2(vne paramvne) {}
  
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
      vne.a(this.this$0, localvwa.a(), localvwa.b());
      vne.a(this.this$0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.2
 * JD-Core Version:    0.7.0.1
 */