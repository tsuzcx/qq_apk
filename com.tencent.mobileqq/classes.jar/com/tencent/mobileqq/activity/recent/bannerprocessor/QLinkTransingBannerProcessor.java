package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QLinkTransingBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.O;
  }
  
  public QLinkTransingBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131560886, null);
    paramBanner.setOnClickListener(new QLinkTransingBannerProcessor.1(this));
    paramBanner.findViewById(2131374019).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    Object localObject = paramBanner.a.findViewById(2131374019);
    paramMessage = (TextView)paramBanner.a.findViewById(2131374020);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() != null))
    {
      int i = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getQQProxyForQlink().a();
      if (i != 0)
      {
        ((View)localObject).setVisibility(0);
        int j = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getQQProxyForQlink().a().mMode;
        paramBanner = HardCodeUtil.a(2131701140);
        if (1 == j) {
          paramBanner = HardCodeUtil.a(2131701150);
        } else if (2 == j) {
          paramBanner = HardCodeUtil.a(2131701139);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698449));
        ((StringBuilder)localObject).append(paramBanner);
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698450));
        paramMessage.setText(((StringBuilder)localObject).toString());
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
        return;
      }
      ((View)localObject).setVisibility(8);
      return;
    }
    ((View)localObject).setVisibility(8);
  }
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b()
  {
    int i = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getQQProxyForQlink().a();
    int j = 0;
    if (i != 0) {
      i = 1;
    } else {
      i = 0;
    }
    BannerManager localBannerManager = BannerManager.a();
    int k = jdField_a_of_type_Int;
    if (i != 0) {
      j = 2;
    }
    localBannerManager.a(k, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor
 * JD-Core Version:    0.7.0.1
 */