package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class WifiPhotoBannerProcessor
  extends BaseBannerProcessor
{
  public WifiPhotoBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131560974, null);
    paramBanner.findViewById(2131381937).setOnClickListener(new WifiPhotoBannerProcessor.1(this));
    paramBanner.findViewById(2131381936).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(10, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    TextView localTextView = (TextView)paramBanner.a.findViewById(2131381937);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label45;
      }
      localTextView.setText(2131720690);
    }
    for (;;)
    {
      paramBanner.a.findViewById(2131381936).setVisibility(0);
      return;
      label45:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131720688);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.WifiPhotoBannerProcessor
 * JD-Core Version:    0.7.0.1
 */