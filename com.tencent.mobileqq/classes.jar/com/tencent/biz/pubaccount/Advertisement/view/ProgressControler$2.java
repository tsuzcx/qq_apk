package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import java.lang.ref.WeakReference;

class ProgressControler$2
  implements Runnable
{
  ProgressControler$2(ProgressControler paramProgressControler) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    IVideoView localIVideoView;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localIVideoView = (IVideoView)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localIVideoView == null);
    if (localIVideoView.b() > 0L)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_Int, localIVideoView.a(), localIVideoView.b(), localIVideoView);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */