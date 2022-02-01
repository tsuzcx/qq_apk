package com.tencent.mobileqq.banner.processor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class BaseBannerProcessor
  implements IBannerProcessor
{
  protected QBaseActivity f;
  protected MqqHandler g;
  
  public BaseBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    this.f = paramQBaseActivity;
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    return null;
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    MqqHandler localMqqHandler = this.g;
    if (localMqqHandler != null)
    {
      if (paramBoolean) {
        localMqqHandler.removeMessages(paramMessage.what);
      }
      this.g.sendMessageDelayed(paramMessage, paramLong);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage) {}
  
  public int b()
  {
    return 0;
  }
  
  public void b(AppRuntime paramAppRuntime) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.processor.BaseBannerProcessor
 * JD-Core Version:    0.7.0.1
 */