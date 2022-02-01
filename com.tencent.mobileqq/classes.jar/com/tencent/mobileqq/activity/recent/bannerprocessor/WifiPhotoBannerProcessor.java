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
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.j;
  }
  
  public WifiPhotoBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131560849, null);
    paramBanner.findViewById(2131381140).setOnClickListener(new WifiPhotoBannerProcessor.1(this));
    paramBanner.findViewById(2131381139).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    TextView localTextView = (TextView)paramBanner.a.findViewById(2131381140);
    if (paramMessage != null) {
      if (paramMessage.arg1 == 1) {
        localTextView.setText(2131720409);
      } else if (paramMessage.arg1 == 2) {
        localTextView.setText(2131720407);
      }
    }
    paramBanner.a.findViewById(2131381139).setVisibility(0);
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.WifiPhotoBannerProcessor
 * JD-Core Version:    0.7.0.1
 */