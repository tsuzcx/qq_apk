package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class WifiPhotoBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.j;
  
  public WifiPhotoBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.f, 2131627107, null);
    paramBanner.findViewById(2131450159).setOnClickListener(new WifiPhotoBannerProcessor.1(this));
    paramBanner.findViewById(2131450158).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    TextView localTextView = (TextView)paramBanner.c.findViewById(2131450159);
    if (paramMessage != null) {
      if (paramMessage.arg1 == 1) {
        localTextView.setText(2131918085);
      } else if (paramMessage.arg1 == 2) {
        localTextView.setText(2131918083);
      }
    }
    paramBanner.c.findViewById(2131450158).setVisibility(0);
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.WifiPhotoBannerProcessor
 * JD-Core Version:    0.7.0.1
 */