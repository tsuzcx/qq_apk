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
    if (this.a.a.mHandler.get() != null)
    {
      paramDialogInterface = ThreadManager.getFileThreadHandler();
      String str = this.a.a.mVideoPath;
      MqqHandler localMqqHandler = (MqqHandler)this.a.a.mHandler.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a.mMd5);
      localStringBuilder.append(".mp4");
      paramDialogInterface.post(new ShortVideoUtils.VideoFileSaveRunnable(str, localMqqHandler, localStringBuilder.toString(), true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.2.1
 * JD-Core Version:    0.7.0.1
 */