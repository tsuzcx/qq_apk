package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class QQWifiBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.z;
  
  public QQWifiBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.f, 2131628228, null);
    ImageView localImageView = (ImageView)paramBanner.findViewById(2131442806);
    paramBanner.setOnClickListener(new QQWifiBannerProcessor.1(this));
    localImageView.setOnClickListener(new QQWifiBannerProcessor.2(this));
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.findViewById(2131442805).setVisibility(0);
    ((TextView)paramBanner.c.findViewById(2131442807)).setText(HardCodeUtil.a(2131899153));
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor
 * JD-Core Version:    0.7.0.1
 */