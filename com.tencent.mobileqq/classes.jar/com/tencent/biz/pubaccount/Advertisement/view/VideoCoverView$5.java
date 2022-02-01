package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import nvp;

public class VideoCoverView$5
  implements Runnable
{
  VideoCoverView$5(VideoCoverView paramVideoCoverView, Context paramContext) {}
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(this.a, new nvp(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoCoverView", 2, "installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.5
 * JD-Core Version:    0.7.0.1
 */