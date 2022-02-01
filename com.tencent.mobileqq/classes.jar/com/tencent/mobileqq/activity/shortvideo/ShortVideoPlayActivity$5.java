package com.tencent.mobileqq.activity.shortvideo;

import android.widget.SeekBar;
import android.widget.TextView;
import bctj;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$5
  implements Runnable
{
  ShortVideoPlayActivity$5(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    Object localObject;
    if (this.this$0.b())
    {
      if (this.this$0.d <= 0L) {
        this.this$0.h();
      }
      if ((this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ShortVideoPlayActivity.a(this.this$0, ((TVK_IMediaPlayer)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion());
      }
      if (ShortVideoPlayActivity.a(this.this$0) != 0L)
      {
        ShortVideoPlayActivity.a(this.this$0, (int)(ShortVideoPlayActivity.a(this.this$0) * 10000L / this.this$0.d + 0.5D));
        if (!ShortVideoPlayActivity.a(this.this$0)) {
          ShortVideoPlayActivity.b(this.this$0, ShortVideoPlayActivity.a(this.this$0));
        }
        if (!ShortVideoPlayActivity.b(this.this$0))
        {
          this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(ShortVideoPlayActivity.a(this.this$0));
          this.this$0.b(ShortVideoPlayActivity.a(this.this$0));
        }
        if ((ShortVideoPlayActivity.b(this.this$0) == 0L) && (((TVK_IMediaPlayer)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).getFirsFrameCost() > 0L))
        {
          ShortVideoPlayActivity.c(this.this$0, ((TVK_IMediaPlayer)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).getFirsFrameCost());
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "mProgressChecker run , mTCOfMCFirstFrame = " + ShortVideoPlayActivity.b(this.this$0) + ", mPlayProgress = " + ShortVideoPlayActivity.a(this.this$0));
          }
          localObject = new HashMap();
          ((HashMap)localObject).put("param_timeCost", String.valueOf(ShortVideoPlayActivity.b(this.this$0)));
          bctj.a(BaseApplication.getContext()).a(null, "videoMCFFTimeCost", true, ShortVideoPlayActivity.b(this.this$0), 0L, (HashMap)localObject, "");
        }
      }
    }
    if ((this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.this$0.jdField_i_of_type_Long == 0L) || (this.this$0.jdField_i_of_type_Boolean)) {}
    try
    {
      ShortVideoPlayActivity.b(this.this$0, (int)(this.this$0.h * 10000L / this.this$0.jdField_i_of_type_Long));
      label411:
      if (this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.b(this.this$0)) {
        this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(ShortVideoPlayActivity.b(this.this$0));
      }
      if ((this.this$0.c()) && (ShortVideoPlayActivity.c(this.this$0) > 0) && (ShortVideoPlayActivity.a(this.this$0) != null) && (ShortVideoPlayActivity.a(this.this$0).getVisibility() == 0))
      {
        localObject = ShortVideoUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.c(this.this$0) * 1024);
        ShortVideoPlayActivity.a(this.this$0).setText((String)localObject + "/s");
      }
      if (this.this$0.isFinishing()) {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "check progress, while finishing");
        }
      }
      while (this.this$0.b.get() == null)
      {
        return;
        ShortVideoPlayActivity.b(this.this$0, 10000);
        break;
      }
      ((MqqHandler)this.this$0.b.get()).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 50L);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label411;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */