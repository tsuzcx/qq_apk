package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class QQWifiBannerProcessor
  extends BaseBannerProcessor
{
  public QQWifiBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131562016, null);
    ImageView localImageView = (ImageView)paramBanner.findViewById(2131375120);
    paramBanner.setOnClickListener(new QQWifiBannerProcessor.1(this));
    localImageView.setOnClickListener(new QQWifiBannerProcessor.2(this));
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.findViewById(2131375119).setVisibility(0);
    ((TextView)paramBanner.a.findViewById(2131375121)).setText(HardCodeUtil.a(2131700993));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor
 * JD-Core Version:    0.7.0.1
 */