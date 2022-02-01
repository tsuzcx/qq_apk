package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MissedCallBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.g;
  
  public MissedCallBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    paramBanner = View.inflate(this.f, 2131627321, null);
    ((TextView)paramBanner.findViewById(2131442273)).setText(this.f.getString(2131896644));
    paramBanner.findViewById(2131442272).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 2000) {
      d();
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMissedCallBar state: ");
      ((StringBuilder)localObject).append(paramBanner.b);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QCallFacade)this.f.getAppRuntime().getManager(QQManagerFactory.RECENT_CALL_FACADE);
    int i;
    if (localObject != null) {
      i = ((QCallFacade)localObject).b();
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    if (paramBanner.b == 0)
    {
      if (paramBanner.c.getVisibility() == 0) {
        paramBanner.c.setVisibility(8);
      }
      return;
    }
    paramBanner.c.findViewById(2131442272).setVisibility(0);
    ((TextView)paramBanner.c.findViewById(2131442273)).setText(String.format(this.f.getString(2131896644), new Object[] { Integer.valueOf(i) }));
    if (i <= 0) {
      BannerManager.a().a(a, 0, paramMessage);
    }
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    d();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor
 * JD-Core Version:    0.7.0.1
 */