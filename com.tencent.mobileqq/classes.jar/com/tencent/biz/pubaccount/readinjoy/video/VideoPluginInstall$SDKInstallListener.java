package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerSDKEventListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class VideoPluginInstall$SDKInstallListener
  implements IPlayerSDKEventListener
{
  private Handler a;
  
  public VideoPluginInstall$SDKInstallListener(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.excute(new VideoPluginInstall.SDKInstallListener.1(this, paramBoolean, paramInt), 16, null, true);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onInstalledSuccessed: ");
    }
    a(true, 0);
    if (this.a != null) {
      this.a.sendEmptyMessage(0);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onInstalledFailed: code=" + paramInt);
    }
    a(false, paramInt);
    if (this.a != null) {
      this.a.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.SDKInstallListener
 * JD-Core Version:    0.7.0.1
 */