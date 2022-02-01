package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class ComicBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a = BannerTypeCollections.G;
  
  public ComicBannerProcessor(QBaseActivity paramQBaseActivity)
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
      QLog.d("ComicBar", 2, "initComicBar");
    }
    paramBanner = LayoutInflater.from(this.f).inflate(2131624144, null);
    paramBanner.findViewById(2131428140).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 1134039))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateComicBar msg.obj = ");
        ((StringBuilder)localObject).append(paramMessage.obj);
        QLog.d("ComicBar", 2, ((StringBuilder)localObject).toString());
      }
      TextView localTextView = (TextView)paramBanner.c.findViewById(2131428120);
      if (((paramMessage.obj instanceof Bundle)) && (localTextView != null))
      {
        paramMessage = (Bundle)paramMessage.obj;
        localObject = paramMessage.getString("comicName");
        String str = paramMessage.getString("comicId");
        int j = paramMessage.getInt("type", -1);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramMessage = this.f.getResources().getDisplayMetrics();
          int k = (int)(localTextView.getPaint().measureText((String)localObject) / ((String)localObject).length());
          if (paramMessage.widthPixels > paramMessage.heightPixels) {
            i = paramMessage.heightPixels;
          } else {
            i = paramMessage.widthPixels;
          }
          int i = (int)((i - paramMessage.density * 65.0F) / k) - 8;
          paramMessage = (Message)localObject;
          if (((String)localObject).length() > i)
          {
            paramMessage = new StringBuilder();
            paramMessage.append(((String)localObject).substring(0, i));
            paramMessage.append("...");
            paramMessage = paramMessage.toString();
          }
          if ((j >= 100) && (j <= 300))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899151));
            ((StringBuilder)localObject).append(paramMessage);
            ((StringBuilder)localObject).append("》");
            localTextView.setText(((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899162));
            ((StringBuilder)localObject).append(paramMessage);
            ((StringBuilder)localObject).append("》");
            localTextView.setText(((StringBuilder)localObject).toString());
          }
          paramBanner.c.setOnClickListener(new ComicBannerProcessor.1(this, str));
          paramBanner.c.findViewById(2131428140).setVisibility(0);
          this.g.removeMessages(1000);
          this.g.sendEmptyMessageDelayed(1000, 900000L);
          ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 2, 0, "", "", "", "");
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBanner = new StringBuilder();
      paramBanner.append("updateComicBar msg ");
      paramBanner.append(paramMessage);
      QLog.d("ComicBar", 2, paramBanner.toString());
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
      BannerManager.a().a(a, 0, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ComicBannerProcessor
 * JD-Core Version:    0.7.0.1
 */