package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.Date;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class UpgradeBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.o;
  
  public UpgradeBannerProcessor(QBaseActivity paramQBaseActivity)
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
      BannerManager.a().a(a, 2, paramMessage);
      localSharedPreferences.edit().putLong("YELLOW_BAR_LAST_SHOW", l2);
    }
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.f, 2131629620, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131449147);
    localTextView.setOnClickListener(new UpgradeBannerProcessor.1(this));
    localTextView.setText(this.f.getString(2131917767));
    ImageView localImageView = (ImageView)paramBanner.findViewById(2131430835);
    if (QQTheme.isNowThemeSimpleNight())
    {
      localTextView.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView.setBackgroundColor(Color.parseColor("#1A1A1A"));
      localImageView.setBackgroundColor(Color.parseColor("#999999"));
    }
    localImageView.setOnClickListener(new UpgradeBannerProcessor.2(this));
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor
 * JD-Core Version:    0.7.0.1
 */