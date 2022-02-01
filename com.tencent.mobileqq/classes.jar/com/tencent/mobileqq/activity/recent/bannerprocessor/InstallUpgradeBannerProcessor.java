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
  public static final int a = BannerTypeCollections.q;
  
  public InstallUpgradeBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  private void a(Message paramMessage)
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().d();
    if (localUpgradeDetailWrapper.f == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.f.getAppRuntime().getPreferences();
    long l1 = localSharedPreferences.getLong("YELLOW_BAR_LAST_SHOW", 0L);
    long l2 = new Date().getTime();
    if (l2 - l1 > localUpgradeDetailWrapper.f.dialog.j * 24 * 60 * 60 * 1000)
    {
      BannerManager.a().a(a, 2);
      BannerManager.a().a(UpgradeBannerProcessor.a, 0);
      BannerManager.a().a(a, paramMessage);
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
    paramBanner = View.inflate(this.f, 2131629619, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131449147);
    localTextView.setOnClickListener(new InstallUpgradeBannerProcessor.1(this));
    localTextView.setText("");
    if (AppSetting.e) {
      localTextView.setContentDescription(this.f.getString(2131917768));
    }
    ((ImageView)paramBanner.findViewById(2131430815)).setOnClickListener(new InstallUpgradeBannerProcessor.2(this));
    paramBanner.findViewById(2131449146).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000) {
      a(paramMessage);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.findViewById(2131449146).setVisibility(0);
    paramBanner = (TextView)paramBanner.c.findViewById(2131449147);
    if (paramMessage != null)
    {
      if (!ConfigHandler.d((QQAppInterface)this.f.getAppRuntime()))
      {
        paramMessage = UpgradeController.a().d();
        if ((paramMessage != null) && (paramMessage.f != null) && (paramMessage.f.dialog != null))
        {
          paramBanner.setText(paramMessage.f.dialog.l);
          return;
        }
        paramBanner.setText(HardCodeUtil.a(2131899152));
        return;
      }
      paramMessage = UpgradeController.a().d();
      if ((paramMessage != null) && (paramMessage.f != null) && (paramMessage.f.dialog != null))
      {
        paramBanner.setText(paramMessage.f.dialog.k);
        return;
      }
      paramBanner.setText(HardCodeUtil.a(2131899160));
    }
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    BannerManager.a().a(a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor
 * JD-Core Version:    0.7.0.1
 */