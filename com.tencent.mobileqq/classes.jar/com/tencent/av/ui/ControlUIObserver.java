package com.tencent.av.ui;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.mobileqq.utils.QAVGroupConfig.GroupInviteFlag;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import jub;

public class ControlUIObserver
  implements Observer
{
  Handler a = null;
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(ControlUIObserver.CEffectEntrancePreClickInfo paramCEffectEntrancePreClickInfo) {}
  
  public void a(ControlUIObserver.CPreChangButtonStyleInfo paramCPreChangButtonStyleInfo) {}
  
  public void a(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  public void a(QAVGroupConfig.GroupInviteFlag paramGroupInviteFlag) {}
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject1, Object paramObject2) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong) {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  public void b(Object paramObject) {}
  
  public void b(String paramString) {}
  
  public void b(String paramString1, String paramString2) {}
  
  public void b(ArrayList paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void c(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  public void c(Object paramObject) {}
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  public void d(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  public void d(Object paramObject)
  {
    int i = -1;
    Object localObject = (Object[])paramObject;
    switch (((Integer)localObject[0]).intValue())
    {
    default: 
      return;
    case 100: 
      a();
      return;
    case 101: 
      b();
      return;
    case 102: 
      c();
      return;
    case 103: 
      a((ArrayList)localObject[1]);
      return;
    case 104: 
      b((ArrayList)localObject[1]);
      return;
    case 105: 
      a(((Boolean)localObject[1]).booleanValue());
      return;
    case 106: 
      d();
      return;
    case 107: 
      j();
      return;
    case 108: 
      k();
      return;
    case 109: 
      l();
      return;
    case 110: 
      e();
      return;
    case 8001: 
      b((String)localObject[1]);
      return;
    case 119: 
      c(((Integer)localObject[1]).intValue());
      return;
    case 111: 
      b(((Boolean)localObject[1]).booleanValue());
      return;
    case 112: 
      o();
      return;
    case 113: 
      f();
      return;
    case 114: 
      i();
      return;
    case 115: 
      a((String)localObject[1], ((Integer)localObject[2]).intValue(), (String)localObject[3], ((Integer)localObject[4]).intValue());
      return;
    case 117: 
      if (localObject.length <= 1) {
        break;
      }
    }
    for (i = ((Integer)localObject[1]).intValue();; i = -1)
    {
      a(i);
      return;
      throw new IllegalArgumentException("美颜需要重新响应, 记得加break");
      n();
      return;
      if (localObject.length > 1) {}
      for (i = ((Integer)localObject[1]).intValue();; i = 0)
      {
        d(i);
        return;
        b(((Integer)localObject[1]).intValue());
        return;
        a((ControlUIObserver.CPreEventInfo)localObject[1]);
        return;
        paramObject = (String)localObject[1];
        localObject = (String)localObject[2];
        ARZimuTask.a(paramObject, (String)localObject);
        b(paramObject, (String)localObject);
        return;
        if (localObject.length > 1) {
          i = ((Integer)localObject[1]).intValue();
        }
        e(i);
        return;
        if (localObject.length != 4) {
          break;
        }
        a(((Boolean)localObject[1]).booleanValue(), ((Boolean)localObject[2]).booleanValue(), ((Long)localObject[3]).longValue());
        return;
        p();
        return;
        a(localObject[1]);
        return;
        m();
        return;
        a(((Boolean)localObject[1]).booleanValue(), ((Integer)localObject[2]).intValue());
        return;
        a((String)localObject[1]);
        return;
        s();
        return;
        q();
        return;
        b(localObject[1]);
        return;
        a(localObject[1], localObject[2]);
        return;
        c(localObject[1]);
        return;
        t();
        return;
        u();
        return;
        v();
        return;
        w();
        return;
        i(((Integer)localObject[1]).intValue());
        return;
        g();
        return;
        f(((Integer)localObject[1]).intValue());
        return;
        r();
        return;
        d((String)localObject[1]);
        return;
        e((String)localObject[1]);
        return;
        f((String)localObject[1]);
        return;
        a((String)localObject[1], (Boolean)localObject[2]);
        return;
        b((ControlUIObserver.CPreEventInfo)localObject[1]);
        return;
        a((ControlUIObserver.CEffectEntrancePreClickInfo)localObject[1]);
        return;
        a((ControlUIObserver.CPreChangButtonStyleInfo)localObject[1]);
        return;
        c((ControlUIObserver.CPreEventInfo)localObject[1]);
        return;
        d((ControlUIObserver.CPreEventInfo)localObject[1]);
        return;
        e((ControlUIObserver.CPreEventInfo)localObject[1]);
        return;
        a((QAVGroupConfig.GroupInviteFlag)localObject[1]);
        return;
        a((String)localObject[1], (String)localObject[2]);
        return;
        h();
        return;
        g(((Integer)localObject[1]).intValue());
        return;
        c((String)localObject[2]);
        return;
        h(((Integer)localObject[1]).intValue());
        return;
        c(((Boolean)localObject[1]).booleanValue());
        return;
      }
    }
  }
  
  public void d(String paramString) {}
  
  public void e() {}
  
  public void e(int paramInt) {}
  
  public void e(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  public void e(String paramString) {}
  
  public void f() {}
  
  public void f(int paramInt) {}
  
  public void f(String paramString) {}
  
  public void g() {}
  
  public void g(int paramInt) {}
  
  public void h() {}
  
  public void h(int paramInt) {}
  
  public void i() {}
  
  protected void i(int paramInt) {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void p() {}
  
  public void q() {}
  
  public void r() {}
  
  protected void s() {}
  
  protected void t() {}
  
  protected void u() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new jub(this, paramObject));
      return;
    }
    d(paramObject);
  }
  
  protected void v() {}
  
  protected void w() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver
 * JD-Core Version:    0.7.0.1
 */