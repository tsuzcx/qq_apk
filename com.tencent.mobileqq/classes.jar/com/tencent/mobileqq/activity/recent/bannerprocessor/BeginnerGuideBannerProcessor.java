package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

@KeepClassConstructor
public class BeginnerGuideBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.R;
  
  public BeginnerGuideBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    return new NewerGuideBannerView(this.f);
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000)
    {
      if (!BannerManager.a().d(a)) {
        return;
      }
      BannerManager.a().a(a, 0, paramMessage);
      paramMessage = (Conversation)FrameHelperActivity.a((BaseActivity)this.f).a(Conversation.class);
      if (paramMessage != null) {
        paramMessage.a(0L);
      }
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && ((paramBanner.c instanceof NewerGuideBannerView)) && ((paramMessage.obj instanceof oidb_0x59f.Guidelines_8410))) {
      ((NewerGuideBannerView)paramBanner.c).a((oidb_0x59f.Guidelines_8410)paramMessage.obj);
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BeginnerGuideBannerProcessor
 * JD-Core Version:    0.7.0.1
 */