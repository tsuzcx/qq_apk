package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class BrowserBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public BrowserBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    paramBanner = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(2131558686, null);
    paramBanner.findViewById(2131362545).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage == null) || ((paramMessage.what != 1134041) && (paramMessage.what != 1134042))) {
      if (QLog.isColorLevel()) {
        QLog.d("BrowserBar", 2, "updateBrowserBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BrowserBar", 2, "updateBrowserBar msg.obj = " + paramMessage.obj);
        }
        if (paramMessage.what == 1134042)
        {
          paramBanner.a.setVisibility(8);
          return;
        }
        localTextView = (TextView)paramBanner.a.findViewById(2131362548);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int i = paramMessage.getInt("icon");
      if (i != -1) {
        ((ImageView)paramBanner.a.findViewById(2131362547)).setImageResource(i);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramBanner.a.setOnClickListener(new BrowserBannerProcessor.1(this, paramMessage));
    paramBanner.a.findViewById(2131362545).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, paramMessage.getInt("timeout", 120000));
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      BannerManager.a().a(34, 0, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor
 * JD-Core Version:    0.7.0.1
 */