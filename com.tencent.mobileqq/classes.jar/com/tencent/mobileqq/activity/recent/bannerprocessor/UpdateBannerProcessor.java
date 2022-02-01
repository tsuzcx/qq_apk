package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.graphics.Color;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.QQTheme;

@KeepClassConstructor
public class UpdateBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.p;
  
  public UpdateBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.f, 2131629620, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131449147);
    localTextView.setOnClickListener(new UpdateBannerProcessor.1(this));
    localTextView.setText(this.f.getString(2131917767));
    ImageView localImageView = (ImageView)paramBanner.findViewById(2131430835);
    if (QQTheme.isNowThemeSimpleNight())
    {
      localTextView.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView.setBackgroundColor(Color.parseColor("#1A1A1A"));
      localImageView.setBackgroundColor(Color.parseColor("#999999"));
    }
    localImageView.setOnClickListener(new UpdateBannerProcessor.2(this));
    paramBanner.findViewById(2131449146).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.findViewById(2131449146).setVisibility(0);
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpdateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */