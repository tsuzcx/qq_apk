package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class TroopAssistBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a = BannerTypeCollections.s;
  private boolean b = true;
  private boolean c = false;
  private String d = "";
  
  public TroopAssistBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.f, 2131624574, null);
    View localView = paramBanner.findViewById(2131431402);
    paramBanner.setOnClickListener(new TroopAssistBannerProcessor.1(this));
    localView.setVisibility(8);
    return paramBanner;
  }
  
  public void a(String paramString)
  {
    if ((BannerManager.a().c(a)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(paramString)) && (this.d.equals(paramString)))
    {
      this.d = "";
      this.g.sendEmptyMessageDelayed(1000, 1000L);
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
    this.b = true;
    this.c = false;
    this.d = "";
  }
  
  public void d() {}
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    if (this.f != null) {
      localQQAppInterface = (QQAppInterface)this.f.getAppRuntime();
    } else {
      localQQAppInterface = null;
    }
    if ((localQQAppInterface != null) && ((TroopAssistantManager.a().g(localQQAppInterface, this.d)) || (this.c)))
    {
      Object localObject = localQQAppInterface.getProxyManager().g();
      int m = 0;
      localObject = ((RecentUserProxy)localObject).a(false);
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((List)localObject).size();
      }
      int j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= i) {
          break;
        }
        if (((RecentUser)((List)localObject).get(j)).getType() == 5000)
        {
          if (this.c) {
            this.g.sendEmptyMessage(1000);
          }
          return;
        }
        j += 1;
      }
      while (k < i)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(k);
        if ((localRecentUser.getType() == 1) && (!TextUtils.isEmpty(localRecentUser.uin)) && (!TroopAssistantManager.a().c(localQQAppInterface, localRecentUser.uin)) && (TroopAssistantManager.a().b(localQQAppInterface, localRecentUser.uin) == 1))
        {
          if (localQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.c) && (!TextUtils.isEmpty(this.d)) && (this.d.equals(localRecentUser.uin))) {
              return;
            }
            this.d = localRecentUser.uin;
            return;
          }
          if ((!TextUtils.isEmpty(this.d)) && (this.d.equals(localRecentUser.uin)))
          {
            this.g.sendEmptyMessage(1000);
            return;
          }
        }
        k += 1;
      }
      if ((this.c) && (!TextUtils.isEmpty(this.d))) {
        this.g.sendEmptyMessage(1000);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      this.d = "";
      BannerManager.a().a(a, 0, paramMessage);
    }
    else if (paramMessage.what == 2000)
    {
      e();
    }
    else if (paramMessage.what == 2001)
    {
      a(paramMessage.getData().getString("troopUin"));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.TroopAssistBannerProcessor
 * JD-Core Version:    0.7.0.1
 */