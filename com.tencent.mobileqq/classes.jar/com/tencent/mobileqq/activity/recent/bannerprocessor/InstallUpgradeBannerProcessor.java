package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import java.util.Date;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class InstallUpgradeBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.q;
  }
  
  public InstallUpgradeBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  private void a(Message paramMessage)
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
    if (localUpgradeDetailWrapper.a == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getPreferences();
    long l1 = localSharedPreferences.getLong("YELLOW_BAR_LAST_SHOW", 0L);
    long l2 = new Date().getTime();
    if (l2 - l1 > localUpgradeDetailWrapper.a.dialog.b * 24 * 60 * 60 * 1000)
    {
      BannerManager.a().a(jdField_a_of_type_Int, 2);
      BannerManager.a().a(UpgradeBannerProcessor.jdField_a_of_type_Int, 0);
      BannerManager.a().a(jdField_a_of_type_Int, paramMessage);
      localSharedPreferences.edit().putLong("YELLOW_BAR_LAST_SHOW", l2).commit();
    }
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof UpgradeActivity)))
    {
      paramMessage = (UpgradeActivity)paramMessage.obj;
      UpgradeController.a().a(paramMessage);
    }
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131563011, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131380229);
    localTextView.setOnClickListener(new InstallUpgradeBannerProcessor.1(this));
    localTextView.setText("");
    if (AppSetting.d) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131720138));
    }
    ((ImageView)paramBanner.findViewById(2131364709)).setOnClickListener(new InstallUpgradeBannerProcessor.2(this));
    paramBanner.findViewById(2131380228).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000) {
      a(paramMessage);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.findViewById(2131380228).setVisibility(0);
    paramBanner = (TextView)paramBanner.a.findViewById(2131380229);
    if (paramMessage != null)
    {
      if (!ConfigHandler.b((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()))
      {
        paramMessage = UpgradeController.a().a();
        if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
        {
          paramBanner.setText(paramMessage.a.dialog.h);
          return;
        }
        paramBanner.setText(HardCodeUtil.a(2131701135));
        return;
      }
      paramMessage = UpgradeController.a().a();
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
      {
        paramBanner.setText(paramMessage.a.dialog.g);
        return;
      }
      paramBanner.setText(HardCodeUtil.a(2131701143));
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor
 * JD-Core Version:    0.7.0.1
 */