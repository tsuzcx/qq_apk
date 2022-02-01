package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
public class MsgBackupBannerProcessor
  extends BaseBannerProcessor
{
  public MsgBackupBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    paramBanner = new TipsBar(this.a);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(45, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.a instanceof TipsBar)) {}
    while ((paramMessage == null) || (!(paramMessage.obj instanceof String))) {
      return;
    }
    String str = (String)paramMessage.obj;
    int i = paramMessage.arg1;
    paramBanner = (TipsBar)paramBanner.a;
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130839491));
    paramBanner.setTipsText(str);
    paramBanner.setOnClickListener(new MsgBackupBannerProcessor.1(this, i));
    paramBanner.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MsgBackupBannerProcessor
 * JD-Core Version:    0.7.0.1
 */