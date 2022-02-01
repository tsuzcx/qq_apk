package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import java.util.Date;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class UpgradeBannerProcessor
  extends BaseBannerProcessor
{
  public UpgradeBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  private void a(Message paramMessage)
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
    if (localUpgradeDetailWrapper.a == null) {}
    SharedPreferences localSharedPreferences;
    long l1;
    long l2;
    do
    {
      return;
      localSharedPreferences = this.a.getAppRuntime().getPreferences();
      l1 = localSharedPreferences.getLong("YELLOW_BAR_LAST_SHOW", 0L);
      l2 = new Date().getTime();
    } while (l2 - l1 <= localUpgradeDetailWrapper.a.dialog.b * 24 * 60 * 60 * 1000);
    BannerManager.a().a(15, 2, paramMessage);
    localSharedPreferences.edit().putLong("YELLOW_BAR_LAST_SHOW", l2);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131563187, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131380963);
    localTextView.setOnClickListener(new UpgradeBannerProcessor.1(this));
    localTextView.setText(this.a.getString(2131720398));
    ((ImageView)paramBanner.findViewById(2131364842)).setOnClickListener(new UpgradeBannerProcessor.2(this));
    paramBanner.findViewById(2131380962).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(15, 0);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor
 * JD-Core Version:    0.7.0.1
 */