package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class UpdateBannerProcessor
  extends BaseBannerProcessor
{
  public UpdateBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131563187, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131380963);
    localTextView.setOnClickListener(new UpdateBannerProcessor.1(this));
    localTextView.setText(this.a.getString(2131720398));
    ((ImageView)paramBanner.findViewById(2131364842)).setOnClickListener(new UpdateBannerProcessor.2(this));
    paramBanner.findViewById(2131380962).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.findViewById(2131380962).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpdateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */