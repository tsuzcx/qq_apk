package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import java.lang.ref.WeakReference;

class ProgressControler$2
  implements Runnable
{
  ProgressControler$2(ProgressControler paramProgressControler) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      IVideoView localIVideoView = (IVideoView)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localIVideoView == null) {
        return;
      }
      if (localIVideoView.b() > 0L)
      {
        this.this$0.a(localIVideoView.a(), localIVideoView.b(), localIVideoView);
        return;
      }
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */