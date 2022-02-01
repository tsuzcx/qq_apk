package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class ArkInfoBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.f;
  
  public ArkInfoBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    return ArkTipsManager.b().b(this.f);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      ((TipsBar)paramBanner.c).setTipsText((String)paramMessage.obj);
      paramBanner.c.setOnClickListener(new ArkInfoBannerProcessor.1(this));
    }
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ArkInfoBannerProcessor
 * JD-Core Version:    0.7.0.1
 */