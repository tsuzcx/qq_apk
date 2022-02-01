package com.tencent.mobileqq.banner.processor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class BaseBannerProcessor
  implements IBannerProcessor
{
  public QBaseActivity a;
  public MqqHandler a;
  
  public BaseBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramMessage.what);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, paramLong);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage) {}
  
  public void a(AppRuntime paramAppRuntime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.processor.BaseBannerProcessor
 * JD-Core Version:    0.7.0.1
 */