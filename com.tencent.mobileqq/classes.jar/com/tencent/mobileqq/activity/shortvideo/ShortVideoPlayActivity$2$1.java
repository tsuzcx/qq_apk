package com.tencent.mobileqq.activity.shortvideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$2$1
  implements DialogInterface.OnClickListener
{
  ShortVideoPlayActivity$2$1(ShortVideoPlayActivity.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.a.a.jdField_b_of_type_JavaLangString, (MqqHandler)this.a.a.jdField_b_of_type_JavaLangRefWeakReference.get(), this.a.a.g + ".mp4", true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.2.1
 * JD-Core Version:    0.7.0.1
 */