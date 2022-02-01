package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MissedCallBannerProcessor
  extends BaseBannerProcessor
{
  public MissedCallBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    paramBanner = View.inflate(this.a, 2131561118, null);
    ((TextView)paramBanner.findViewById(2131374640)).setText(this.a.getString(2131698620));
    paramBanner.findViewById(2131374639).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 2000) {
      b();
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + paramBanner.b);
    }
    QCallFacade localQCallFacade = (QCallFacade)this.a.getAppRuntime().getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (localQCallFacade != null) {}
    for (int i = localQCallFacade.a();; i = 0)
    {
      if (i == 0) {}
      do
      {
        do
        {
          return;
          if (paramBanner.b != 0) {
            break;
          }
        } while (paramBanner.a.getVisibility() != 0);
        paramBanner.a.setVisibility(8);
        return;
        paramBanner.a.findViewById(2131374639).setVisibility(0);
        ((TextView)paramBanner.a.findViewById(2131374640)).setText(String.format(this.a.getString(2131698620), new Object[] { Integer.valueOf(i) }));
      } while (i > 0);
      BannerManager.a().a(7, 0, paramMessage);
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor
 * JD-Core Version:    0.7.0.1
 */