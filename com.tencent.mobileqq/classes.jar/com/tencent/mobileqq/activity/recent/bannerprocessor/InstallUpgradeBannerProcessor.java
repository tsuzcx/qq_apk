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
  public InstallUpgradeBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  private void a(Message paramMessage)
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
    if (localUpgradeDetailWrapper.a == null) {}
    do
    {
      return;
      SharedPreferences localSharedPreferences = this.a.getAppRuntime().getPreferences();
      long l1 = localSharedPreferences.getLong("YELLOW_BAR_LAST_SHOW", 0L);
      long l2 = new Date().getTime();
      if (l2 - l1 > localUpgradeDetailWrapper.a.dialog.b * 24 * 60 * 60 * 1000)
      {
        BannerManager.a().a(17, 2);
        BannerManager.a().a(15, 0);
        BannerManager.a().a(17, paramMessage);
        localSharedPreferences.edit().putLong("YELLOW_BAR_LAST_SHOW", l2).commit();
      }
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof UpgradeActivity)));
    paramMessage = (UpgradeActivity)paramMessage.obj;
    UpgradeController.a().a(paramMessage);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131563186, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131380963);
    localTextView.setOnClickListener(new InstallUpgradeBannerProcessor.1(this));
    localTextView.setText("");
    if (AppSetting.d) {
      localTextView.setContentDescription(this.a.getString(2131720399));
    }
    ((ImageView)paramBanner.findViewById(2131364822)).setOnClickListener(new InstallUpgradeBannerProcessor.2(this));
    paramBanner.findViewById(2131380962).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(17, 0);
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000) {
      a(paramMessage);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.findViewById(2131380962).setVisibility(0);
    paramBanner = (TextView)paramBanner.a.findViewById(2131380963);
    if (paramMessage != null)
    {
      if (ConfigHandler.b((QQAppInterface)this.a.getAppRuntime())) {
        break label99;
      }
      paramMessage = UpgradeController.a().a();
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null)) {
        paramBanner.setText(paramMessage.a.dialog.h);
      }
    }
    else
    {
      return;
    }
    paramBanner.setText(HardCodeUtil.a(2131700992));
    return;
    label99:
    paramMessage = UpgradeController.a().a();
    if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
    {
      paramBanner.setText(paramMessage.a.dialog.g);
      return;
    }
    paramBanner.setText(HardCodeUtil.a(2131701000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor
 * JD-Core Version:    0.7.0.1
 */