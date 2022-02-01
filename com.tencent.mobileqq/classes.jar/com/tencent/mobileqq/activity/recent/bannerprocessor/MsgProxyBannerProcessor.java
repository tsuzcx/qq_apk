package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.text.Html;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.util.Pair;

@KeepClassConstructor
public class MsgProxyBannerProcessor
  extends BaseBannerProcessor
{
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
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130841482));
    paramBanner.b(true);
    paramBanner.setOnClickListener(new MsgProxyBannerProcessor.1(this));
    paramBanner.setCloseListener(new MsgProxyBannerProcessor.2(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage == null) {}
    Pair localPair;
    do
    {
      do
      {
        return;
        if (paramMessage.what == 3000)
        {
          paramBanner.a.setVisibility(0);
          paramMessage = (Pair)paramMessage.obj;
          ((TipsBar)paramBanner.a).setTipsText(Html.fromHtml((String)paramMessage.second + HardCodeUtil.a(2131700998)));
          paramBanner.a.setTag(paramMessage);
          return;
        }
      } while (paramMessage.what != 3001);
      if (paramMessage.obj == null) {
        break;
      }
      paramMessage = (Long)paramMessage.obj;
      localPair = (Pair)paramBanner.a.getTag();
    } while ((localPair == null) || (!((Long)localPair.first).equals(paramMessage)));
    paramBanner.a.setVisibility(8);
    BannerManager.a().a(39, 0, null);
    return;
    paramBanner.a.setVisibility(8);
    BannerManager.a().a(39, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MsgProxyBannerProcessor
 * JD-Core Version:    0.7.0.1
 */