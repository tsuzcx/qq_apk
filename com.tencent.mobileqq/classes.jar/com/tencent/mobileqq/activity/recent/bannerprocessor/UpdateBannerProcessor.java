package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class UpdateBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.p;
  }
  
  public UpdateBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131563012, null);
    TextView localTextView = (TextView)paramBanner.findViewById(2131380229);
    localTextView.setOnClickListener(new UpdateBannerProcessor.1(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131720137));
    ((ImageView)paramBanner.findViewById(2131364728)).setOnClickListener(new UpdateBannerProcessor.2(this));
    paramBanner.findViewById(2131380228).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.findViewById(2131380228).setVisibility(0);
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpdateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */