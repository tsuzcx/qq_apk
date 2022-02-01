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
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.g;
  }
  
  public MissedCallBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131560980, null);
    ((TextView)paramBanner.findViewById(2131374178)).setText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698686));
    paramBanner.findViewById(2131374177).setVisibility(8);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMissedCallBar state: ");
      ((StringBuilder)localObject).append(paramBanner.b);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getManager(QQManagerFactory.RECENT_CALL_FACADE);
    int i;
    if (localObject != null) {
      i = ((QCallFacade)localObject).a();
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    if (paramBanner.b == 0)
    {
      if (paramBanner.a.getVisibility() == 0) {
        paramBanner.a.setVisibility(8);
      }
      return;
    }
    paramBanner.a.findViewById(2131374177).setVisibility(0);
    ((TextView)paramBanner.a.findViewById(2131374178)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698686), new Object[] { Integer.valueOf(i) }));
    if (i <= 0) {
      BannerManager.a().a(jdField_a_of_type_Int, 0, paramMessage);
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor
 * JD-Core Version:    0.7.0.1
 */