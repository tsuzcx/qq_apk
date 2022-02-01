package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.bar.MultiVideoBarHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
public class MultiVideoBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
  public MultiVideoBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131559595, null);
    paramBanner.setOnClickListener(new MultiVideoBannerProcessor.1(this));
    paramBanner.findViewById(2131371999).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 2000) {
      c();
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (this.a != null) {
      MultiVideoBarHelper.a((QQAppInterface)this.a.getAppRuntime(), paramBanner.a, paramMessage, this.a.isResume());
    }
  }
  
  public void b()
  {
    c();
  }
  
  public void b(AppRuntime paramAppRuntime) {}
  
  public void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface != null)
    {
      if (localQQAppInterface.getAVNotifyCenter().b() <= 0) {
        break label35;
      }
      BannerManager.a().a(42, 2);
    }
    label35:
    int i;
    do
    {
      return;
      if (!localQQAppInterface.isVideoChatting()) {
        break;
      }
      i = localQQAppInterface.getAVNotifyCenter().e();
      if (i == 3)
      {
        if (localQQAppInterface.getAVNotifyCenter().b() > 0L)
        {
          BannerManager.a().a(42, 2);
          return;
        }
        BannerManager.a().a(42, 0);
        return;
      }
      if (i == 1)
      {
        BannerManager.a().a(42, 2);
        return;
      }
    } while (i != 2);
    BannerManager.a().a(42, 2);
    return;
    BannerManager.a().a(42, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor
 * JD-Core Version:    0.7.0.1
 */