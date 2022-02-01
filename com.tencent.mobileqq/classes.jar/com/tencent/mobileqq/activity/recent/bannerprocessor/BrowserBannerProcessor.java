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
import com.tencent.mobileqq.banner.BannerTypeCollections;
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
  public static final int a = BannerTypeCollections.H;
  
  public BrowserBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
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
    paramBanner = LayoutInflater.from(this.f).inflate(2131624142, null);
    paramBanner.findViewById(2131428110).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && ((paramMessage.what == 1134041) || (paramMessage.what == 1134042)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateBrowserBar msg.obj = ");
        ((StringBuilder)localObject).append(paramMessage.obj);
        QLog.d("BrowserBar", 2, ((StringBuilder)localObject).toString());
      }
      if (paramMessage.what == 1134042)
      {
        paramBanner.c.setVisibility(8);
        return;
      }
      Object localObject = (TextView)paramBanner.c.findViewById(2131428113);
      if (((paramMessage.obj instanceof Bundle)) && (localObject != null))
      {
        paramMessage = (Bundle)paramMessage.obj;
        String str = (String)paramMessage.getCharSequence("tips");
        int i = paramMessage.getInt("icon");
        if (i != -1) {
          ((ImageView)paramBanner.c.findViewById(2131428112)).setImageResource(i);
        }
        if (!TextUtils.isEmpty(str))
        {
          ((TextView)localObject).setText(str);
          paramBanner.c.setOnClickListener(new BrowserBannerProcessor.1(this, paramMessage));
          paramBanner.c.findViewById(2131428110).setVisibility(0);
          this.g.removeMessages(1000);
          this.g.sendEmptyMessageDelayed(1000, paramMessage.getInt("timeout", 120000));
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBanner = new StringBuilder();
      paramBanner.append("updateBrowserBar msg ");
      paramBanner.append(paramMessage);
      QLog.d("BrowserBar", 2, paramBanner.toString());
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.g.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    return a;
  }
  
  public void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      BannerManager.a().a(a, 0, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor
 * JD-Core Version:    0.7.0.1
 */