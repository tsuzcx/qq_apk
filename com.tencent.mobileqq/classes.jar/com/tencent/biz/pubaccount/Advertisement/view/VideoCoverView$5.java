package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

class VideoCoverView$5
  implements Runnable
{
  VideoCoverView$5(VideoCoverView paramVideoCoverView, Context paramContext) {}
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(this.a, new VideoCoverView.5.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("installSDK t==");
        localStringBuilder.append(localThrowable.toString());
        QLog.d("VideoCoverView", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.5
 * JD-Core Version:    0.7.0.1
 */