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
  protected QBaseActivity a;
  protected MqqHandler a;
  
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
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      if (paramBoolean) {
        localMqqHandler.removeMessages(paramMessage.what);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, paramLong);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage) {}
  
  public int b()
  {
    return 0;
  }
  
  public void b(AppRuntime paramAppRuntime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.banner.processor.BaseBannerProcessor
 * JD-Core Version:    0.7.0.1
 */