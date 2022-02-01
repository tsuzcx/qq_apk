package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
public class MsgBackupBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.P;
  }
  
  public MsgBackupBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.a instanceof TipsBar)) {
      return;
    }
    if (paramMessage == null) {
      return;
    }
    if ((paramMessage.obj instanceof String))
    {
      String str = (String)paramMessage.obj;
      int i = paramMessage.arg1;
      paramBanner = (TipsBar)paramBanner.a;
      paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839347));
      paramBanner.setTipsText(str);
      paramBanner.setOnClickListener(new MsgBackupBannerProcessor.1(this, i));
      paramBanner.setVisibility(0);
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MsgBackupBannerProcessor
 * JD-Core Version:    0.7.0.1
 */