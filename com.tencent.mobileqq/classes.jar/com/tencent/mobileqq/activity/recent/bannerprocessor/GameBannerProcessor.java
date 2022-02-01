package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class GameBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a = BannerTypeCollections.J;
  
  public GameBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBar", 2, "initGameBar");
    }
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130838358));
    paramBanner.setVisibility(8);
    paramBanner.b(true);
    return paramBanner;
  }
  
  public void a(Message paramMessage)
  {
    Bundle localBundle = (Bundle)paramMessage.obj;
    String str = localBundle.getString("iconURL");
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = Message.obtain(paramMessage);
      ImageLoader.a().a(str, new GameBannerProcessor.3(this, localBundle, paramMessage));
      return;
    }
    BannerManager.a().a(a, 2, paramMessage);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && ((paramMessage.what == 1134049) || (paramMessage.what == 1134050)))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateGameBar msg.obj = ");
        ((StringBuilder)localObject).append(paramMessage.obj);
        QLog.d("GameBar", 2, ((StringBuilder)localObject).toString());
      }
      if (paramMessage.what == 1134050)
      {
        paramBanner.c.setVisibility(8);
        return;
      }
      if (((paramMessage.obj instanceof Bundle)) && ((paramBanner.c instanceof TipsBar)))
      {
        paramBanner = (TipsBar)paramBanner.c;
        paramMessage = (Bundle)paramMessage.obj;
        localObject = (String)paramMessage.getCharSequence("tips");
        int i = paramMessage.getInt("icon");
        if (paramMessage.containsKey("iconURLBitmap")) {
          paramBanner.setTipsIcon(new BitmapDrawable((Bitmap)paramMessage.getParcelable("iconURLBitmap")));
        } else if (i != 1) {
          paramBanner.setTipsIcon(this.f.getResources().getDrawable(i));
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramBanner.setTipsText((CharSequence)localObject);
          paramBanner.setOnClickListener(new GameBannerProcessor.1(this, paramMessage));
          paramBanner.setCloseListener(new GameBannerProcessor.2(this));
          paramBanner.setVisibility(0);
          this.g.removeMessages(1000);
          this.g.sendEmptyMessageDelayed(1000, paramMessage.getInt("timeout", 900000));
          ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 4, 0, "", "", "", "");
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBanner = new StringBuilder();
      paramBanner.append("updateGameBar msg ");
      paramBanner.append(paramMessage);
      QLog.d("GameBar", 2, paramBanner.toString());
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
  
  public void c()
  {
    BannerManager.a().a(a, 0);
  }
  
  public void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      BannerManager.a().a(a, 0, paramMessage);
    } else if (paramMessage.what == 1134049) {
      a(paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor
 * JD-Core Version:    0.7.0.1
 */