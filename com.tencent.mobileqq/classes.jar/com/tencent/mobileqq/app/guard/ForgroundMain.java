package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.qphone.base.util.QLog;

public class ForgroundMain
  extends GuardState
{
  protected long a;
  protected long b;
  private String h = null;
  
  protected void a()
  {
    super.a();
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = true;
    if (bool1) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onTick mClearTick: ", Long.valueOf(this.g), " m" });
    }
    this.a += 1L;
    this.b += 1L;
    if (this.g >= 3L)
    {
      if (this.e.mFgProcess != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QGuardUtils.a(bool1, new String[] { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:plugins", "com.tencent.mobileqq:mini", this.h });
      this.g = 0L;
      GuardStateScheduler.a().a(2, this.h, 0);
    }
    if ((this.a >= 15L) && (!((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.disable_qzone_kill.name())))
    {
      if (this.e.mFgProcess != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QGuardUtils.a(bool1, "com.tencent.mobileqq:qzone");
      StatisticHitRateCollector.a().d(StatisticHitRateCollector.b());
      this.a = 0L;
    }
    if (this.b >= GuardManager.sTickToolBgFgKill)
    {
      if (this.e.mFgProcess != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      QGuardUtils.a(bool1, "com.tencent.mobileqq:tool");
      QGuardUtils.a(bool1, "com.tencent.mobileqq:plugins");
      this.b = 0L;
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onForground proc: ", paramString });
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onEnter proc: ", paramString });
    }
    this.a = 0L;
    this.b = 0L;
    CoreService.startCoreService(GuardConfig.a().a);
    this.e.startTimer();
  }
  
  protected void c(String paramString)
  {
    this.h = paramString;
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onBackground proc: ", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.ForgroundMain
 * JD-Core Version:    0.7.0.1
 */