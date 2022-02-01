package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerManager
  implements Manager
{
  NewerGuideBannerObserver a;
  NewerGuideBannerSharePreferenceHelper b = NewerGuideBannerSharePreferenceHelper.a;
  private AppInterface c;
  private oidb_0x59f.Guidelines_8410 d;
  
  public NewerGuideBannerManager(AppInterface paramAppInterface)
  {
    this.c = paramAppInterface;
    this.a = new NewerGuideBannerObserver(paramAppInterface);
    paramAppInterface.addObserver(this.a);
  }
  
  private <T> boolean a(T paramT)
  {
    return ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).isMayKnowRecentBaseData(paramT);
  }
  
  private <T> void b(List<T> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    int k;
    for (int j = -1; paramList.hasNext(); j = k)
    {
      k = j;
      if (a(paramList.next()))
      {
        paramList.remove();
        k = j;
        if (j < 0) {
          k = i;
        }
      }
      if ((i >= 9) && (k < 0)) {
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.c != null) {
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).getNewerGuideHandler(this.c).a();
    }
  }
  
  public <T> void a(List<T> paramList, BannerManager paramBannerManager)
  {
    if (paramList != null)
    {
      if (paramBannerManager == null) {
        return;
      }
      if (paramBannerManager.d(((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).getBannerId()))
      {
        b(paramList);
        return;
      }
      if (!a(paramList)) {
        d();
      }
    }
  }
  
  void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    this.d = paramGuidelines_8410;
    boolean bool = b(paramGuidelines_8410);
    if (QLog.isColorLevel())
    {
      paramGuidelines_8410 = new StringBuilder();
      paramGuidelines_8410.append("showNewerGuideBannerIfNeed needShow -> ");
      paramGuidelines_8410.append(bool);
      QLog.d("NewerGuideBannerManager", 2, paramGuidelines_8410.toString());
    }
    if (!bool)
    {
      b();
      return;
    }
    e();
  }
  
  public <T> boolean a(List<T> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "canShowNewerGuideBanner");
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < Math.min(10, paramList.size()))
      {
        if (a(paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "hideNewerGuideBanner");
    }
    if (this.c != null) {
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).hideNewerGuideBanner(this.c);
    }
  }
  
  boolean b(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    if ((paramGuidelines_8410 != null) && (this.c != null))
    {
      int i = paramGuidelines_8410.uint32_banner_status.get();
      if (i == 0) {
        return false;
      }
      paramGuidelines_8410 = this.c.getCurrentAccountUin();
      if (i == 2)
      {
        this.b.a(paramGuidelines_8410);
        return true;
      }
      if (this.b.c(paramGuidelines_8410) <= 0L) {
        return true;
      }
    }
    return false;
  }
  
  void c()
  {
    oidb_0x59f.Guidelines_8410 localGuidelines_8410 = this.d;
    if ((localGuidelines_8410 != null) && (localGuidelines_8410.uint32_banner_status.has()) && (this.d.uint32_banner_status.get() == 2)) {
      this.d.uint32_banner_status.set(1);
    }
  }
  
  public void d()
  {
    a(this.d);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBanner called");
    }
    if ((this.c != null) && (this.d != null)) {
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).showNewerGuideBanner(this.c, this.d);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy, instance manager -> ");
      ((StringBuilder)localObject).append(this);
      QLog.d("NewerGuideBannerManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((AppInterface)localObject).removeObserver(this.a);
      this.c = null;
    }
    this.a = null;
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager
 * JD-Core Version:    0.7.0.1
 */