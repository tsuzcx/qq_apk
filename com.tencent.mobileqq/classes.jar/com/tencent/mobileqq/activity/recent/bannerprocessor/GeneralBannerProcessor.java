package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerIconCollection;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.banner.processor.IBannerOnUpdateBannerState;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class GeneralBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle, IBannerOnUpdateBannerState
{
  public static final int a = BannerTypeCollections.M;
  public volatile BBannerHelper.MessageToShowBanner b;
  public volatile BBannerHelper.MessageToShowBanner c;
  
  public GeneralBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt)
  {
    int i = BannerManager.a;
    while (i < BannerManager.b)
    {
      Banner localBanner = BannerManager.a().a(i);
      if ((localBanner != null) && (localBanner.b == 2)) {
        if (i != paramInt)
        {
          b(i, paramInt);
          localBanner.b = 0;
        }
        else if ((i == a) && (this.b != null) && (!this.c.equals(this.b)))
        {
          b(i, paramInt);
        }
      }
      i += 1;
    }
  }
  
  private void a(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideGeneralBanner: ");
      localStringBuilder.append(paramMessage);
      QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
    }
    if (!(paramMessage.obj instanceof BBannerHelper.MessageToShowBanner)) {
      return;
    }
    int i = ((BBannerHelper.MessageToShowBanner)paramMessage.obj).a;
    if (!paramMessage.obj.equals(this.b)) {
      return;
    }
    BannerManager.a().a(a, 0, paramMessage);
  }
  
  private void a(BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideGeneralBannerInBInternal with: ");
      ((StringBuilder)localObject).append(paramMessageToShowBanner);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g.obtainMessage(1000);
    ((Message)localObject).obj = paramMessageToShowBanner;
    this.g.sendMessage((Message)localObject);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[notifyBannerIsOverride], type is ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == a) && (this.b != null)) {
      this.b.e.onOverride();
    }
  }
  
  private void b(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof BBannerHelper.MessageToShowBanner)) {
      return;
    }
    int i = ((BBannerHelper.MessageToShowBanner)paramMessage.obj).a;
    this.c = ((BBannerHelper.MessageToShowBanner)paramMessage.obj);
    this.b = this.c;
    BannerManager.a().a(a, 2, paramMessage);
    b((BBannerHelper.MessageToShowBanner)paramMessage.obj);
  }
  
  private void b(BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    this.g.removeMessages(1000);
    paramMessageToShowBanner = this.g.obtainMessage(1000, paramMessageToShowBanner);
    this.g.sendMessageDelayed(paramMessageToShowBanner, 900000L);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.f);
    paramBanner.b(true);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= BannerManager.a) && (paramInt1 < BannerManager.b) && (paramInt2 == 2)) {
      a(paramInt1);
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner = (TipsBar)paramBanner.c;
    if (paramMessage == null) {
      return;
    }
    paramMessage = (BBannerHelper.MessageToShowBanner)paramMessage.obj;
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(BannerIconCollection.a(paramMessage.c)));
    paramBanner.setTipsText(paramMessage.d);
    paramBanner.setOnClickListener(new BBannerHelper.OnEnterClickDelegate(paramMessage, this.g));
    paramBanner.setCloseListener(new BBannerHelper.OnCloseClickDelegate(paramMessage, this.g));
    paramBanner.setVisibility(0);
    ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.g.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    return a;
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("handleAccountChanged with: ");
      paramAppRuntime.append(this.b);
      QLog.d("Q.recent.banner", 2, paramAppRuntime.toString());
    }
    if ((this.b != null) && (this.b.e.isNeedAutoCloseWhenAccountChange())) {
      a(this.b);
    }
  }
  
  public void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != 1000) && (paramMessage.what != 1134201))
    {
      if (paramMessage.what == 1134200) {
        b(paramMessage);
      }
    }
    else {
      a(paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GeneralBannerProcessor
 * JD-Core Version:    0.7.0.1
 */