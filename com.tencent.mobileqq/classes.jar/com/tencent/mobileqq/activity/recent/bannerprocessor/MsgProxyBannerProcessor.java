package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.text.Html;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.util.Pair;

@KeepClassConstructor
public class MsgProxyBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.L;
  
  public MsgProxyBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130842164));
    paramBanner.b(true);
    paramBanner.setOnClickListener(new MsgProxyBannerProcessor.1(this));
    paramBanner.setCloseListener(new MsgProxyBannerProcessor.2(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    Object localObject;
    if (paramMessage.what == 3000)
    {
      paramBanner.c.setVisibility(0);
      paramMessage = (Pair)paramMessage.obj;
      localObject = (TipsBar)paramBanner.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)paramMessage.second);
      localStringBuilder.append(HardCodeUtil.a(2131899158));
      ((TipsBar)localObject).setTipsText(Html.fromHtml(localStringBuilder.toString()));
      paramBanner.c.setTag(paramMessage);
      return;
    }
    if (paramMessage.what == 3001) {
      if (paramMessage.obj != null)
      {
        paramMessage = (Long)paramMessage.obj;
        localObject = (Pair)paramBanner.c.getTag();
        if ((localObject != null) && (((Long)((Pair)localObject).first).equals(paramMessage)))
        {
          paramBanner.c.setVisibility(8);
          BannerManager.a().a(a, 0, null);
        }
      }
      else
      {
        paramBanner.c.setVisibility(8);
        BannerManager.a().a(a, 0, null);
      }
    }
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MsgProxyBannerProcessor
 * JD-Core Version:    0.7.0.1
 */