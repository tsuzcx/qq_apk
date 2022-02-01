package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.common.StatPreferences;
import com.tencent.acstat.event.EventType;
import com.tencent.acstat.event.b;
import com.tencent.acstat.event.d;
import java.util.Map;

class ab
{
  private static volatile long f;
  private d a;
  private StatReportStrategy b = null;
  private boolean c = false;
  private Context d = null;
  private long e = System.currentTimeMillis();
  
  public ab(d paramd)
  {
    this.a = paramd;
    this.b = StatConfig.getStatSendStrategy();
    this.c = paramd.f();
    this.d = paramd.e();
  }
  
  private void a(StatDispatchCallback paramStatDispatchCallback)
  {
    g.b(StatServiceImpl.e()).a(this.a, paramStatDispatchCallback);
  }
  
  private void b()
  {
    Object localObject1;
    Object localObject2;
    if (this.a.a() == EventType.CUSTOM)
    {
      localObject1 = ((b)this.a).b().a;
      if (StatConfig.isEventIdInDontReportEventIdsSet((String)localObject1))
      {
        localObject2 = StatServiceImpl.f();
        StringBuilder localStringBuilder = new StringBuilder("eventid=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" In DontReportEventIdsSet, droped.");
        ((StatLogger)localObject2).w(localStringBuilder.toString());
        return;
      }
    }
    if ((this.a.d() != null) && (this.a.d().isSendImmediately())) {
      this.b = StatReportStrategy.INSTANT;
    }
    if ((StatConfig.j) && (NetworkManager.getInstance(StatServiceImpl.e()).isWifi())) {
      this.b = StatReportStrategy.INSTANT;
    }
    if (StatConfig.isDebugEnable())
    {
      localObject1 = StatServiceImpl.f();
      localObject2 = new StringBuilder("strategy=");
      ((StringBuilder)localObject2).append(this.b.name());
      ((StatLogger)localObject1).i(((StringBuilder)localObject2).toString());
    }
    switch (s.a[this.b.ordinal()])
    {
    default: 
      localObject1 = StatServiceImpl.f();
      localObject2 = new StringBuilder("Invalid stat strategy:");
      ((StringBuilder)localObject2).append(StatConfig.getStatSendStrategy());
      ((StatLogger)localObject1).error(((StringBuilder)localObject2).toString());
      return;
    case 7: 
      if (StatCommonHelper.isWiFiActive(this.d))
      {
        a(new ad(this));
        return;
      }
      break;
    case 6: 
      if (NetworkManager.getInstance(StatServiceImpl.e()).getNetworkType() == 1)
      {
        c();
        return;
      }
      af.a(this.d).a(this.a, null, this.c, false);
      return;
    case 5: 
      af.a(this.d).a(this.a, new ac(this), this.c, true);
      return;
    case 3: 
    case 4: 
      af.a(this.d).a(this.a, null, this.c, false);
      return;
    case 2: 
      af.a(this.d).a(this.a, null, this.c, false);
      if (StatConfig.isDebugEnable())
      {
        localObject1 = StatServiceImpl.f();
        localObject2 = new StringBuilder("PERIOD currTime=");
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append(",nextPeriodSendTs=");
        ((StringBuilder)localObject2).append(StatServiceImpl.c);
        ((StringBuilder)localObject2).append(",difftime=");
        ((StringBuilder)localObject2).append(StatServiceImpl.c - this.e);
        ((StatLogger)localObject1).i(((StringBuilder)localObject2).toString());
      }
      if (StatServiceImpl.c == 0L)
      {
        StatServiceImpl.c = StatPreferences.getLong(this.d, "last_period_ts", 0L);
        if (this.e > StatServiceImpl.c) {
          StatServiceImpl.d(this.d);
        }
        long l = this.e + StatConfig.getSendPeriodMinutes() * 60 * 1000;
        if (StatServiceImpl.c > l) {
          StatServiceImpl.c = l;
        }
        c.a(this.d).a();
      }
      if (StatConfig.isDebugEnable())
      {
        localObject1 = StatServiceImpl.f();
        localObject2 = new StringBuilder("PERIOD currTime=");
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append(",nextPeriodSendTs=");
        ((StringBuilder)localObject2).append(StatServiceImpl.c);
        ((StringBuilder)localObject2).append(",difftime=");
        ((StringBuilder)localObject2).append(StatServiceImpl.c - this.e);
        ((StatLogger)localObject1).i(((StringBuilder)localObject2).toString());
      }
      if (this.e > StatServiceImpl.c)
      {
        StatServiceImpl.d(this.d);
        return;
      }
      break;
    case 1: 
      c();
    }
  }
  
  private void c()
  {
    if (((af.b().a > 0) && (StatConfig.l)) || (this.a.a() == EventType.BACKGROUND))
    {
      af.b().a(this.a, null, this.c, true);
      af.b().a(-1);
      return;
    }
    a(new ae(this));
  }
  
  private boolean d()
  {
    if (StatConfig.h > 0)
    {
      if (this.e > StatServiceImpl.k())
      {
        StatServiceImpl.l().clear();
        StatServiceImpl.a(this.e + StatConfig.i);
        if (StatConfig.isDebugEnable())
        {
          localObject1 = StatServiceImpl.f();
          localObject2 = new StringBuilder("clear methodsCalledLimitMap, nextLimitCallClearTime=");
          ((StringBuilder)localObject2).append(StatServiceImpl.k());
          ((StatLogger)localObject1).i(((StringBuilder)localObject2).toString());
        }
      }
      Object localObject2 = Integer.valueOf(this.a.a().a());
      Object localObject1 = (Integer)StatServiceImpl.l().get(localObject2);
      if (localObject1 != null)
      {
        StatServiceImpl.l().put(localObject2, Integer.valueOf(((Integer)localObject1).intValue() + 1));
        if (((Integer)localObject1).intValue() > StatConfig.h)
        {
          if (StatConfig.isDebugEnable())
          {
            localObject2 = StatServiceImpl.f();
            StringBuilder localStringBuilder = new StringBuilder("event ");
            localStringBuilder.append(this.a.g());
            localStringBuilder.append(" was discard, cause of called limit, current:");
            localStringBuilder.append(localObject1);
            localStringBuilder.append(", limit:");
            localStringBuilder.append(StatConfig.h);
            localStringBuilder.append(", period:");
            localStringBuilder.append(StatConfig.i);
            localStringBuilder.append(" ms");
            ((StatLogger)localObject2).e(localStringBuilder.toString());
          }
          return true;
        }
      }
      else
      {
        StatServiceImpl.l().put(localObject2, Integer.valueOf(1));
      }
    }
    return false;
  }
  
  public void a()
  {
    if (d()) {
      return;
    }
    StatLogger localStatLogger;
    StringBuilder localStringBuilder;
    if ((StatConfig.m > 0) && (this.e >= f))
    {
      StatServiceImpl.flushDataToDB(this.d);
      f = this.e + StatConfig.n;
      if (StatConfig.isDebugEnable())
      {
        localStatLogger = StatServiceImpl.f();
        localStringBuilder = new StringBuilder("nextFlushTime=");
        localStringBuilder.append(f);
        localStatLogger.i(localStringBuilder.toString());
      }
    }
    if (NetworkManager.getInstance(this.d).isNetworkAvailable())
    {
      if (StatConfig.isDebugEnable())
      {
        localStatLogger = StatServiceImpl.f();
        localStringBuilder = new StringBuilder("sendFailedCount=");
        localStringBuilder.append(StatServiceImpl.a);
        localStatLogger.i(localStringBuilder.toString());
      }
      if (!StatServiceImpl.a())
      {
        b();
        return;
      }
      af.a(this.d).a(this.a, null, this.c, false);
      if (this.e - StatServiceImpl.b > 1800000L) {
        StatServiceImpl.e(this.d);
      }
      return;
    }
    af.a(this.d).a(this.a, null, this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.ab
 * JD-Core Version:    0.7.0.1
 */