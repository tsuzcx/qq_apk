package com.tencent.av.ui;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.GroupInviteFlag;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ControlUIObserver
  implements Observer
{
  Handler b = null;
  
  public static <T extends ControlUIObserver.BaseParameter> T a(Object[] paramArrayOfObject)
  {
    return (ControlUIObserver.BaseParameter)paramArrayOfObject[1];
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(int paramInt, long paramLong) {}
  
  protected void a(int paramInt, boolean paramBoolean) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(long paramLong, boolean paramBoolean, String paramString) {}
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {}
  
  protected void a(ControlUIObserver.CEffectEntrancePreClickInfo paramCEffectEntrancePreClickInfo) {}
  
  protected void a(ControlUIObserver.CPreChangButtonStyleInfo paramCPreChangButtonStyleInfo) {}
  
  public void a(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  protected void a(QAVGroupConfig.GroupInviteFlag paramGroupInviteFlag) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  protected void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage) {}
  
  protected void a(String paramString, Boolean paramBoolean) {}
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(ArrayList<VideoViewInfo> paramArrayList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void b() {}
  
  protected void b(int paramInt) {}
  
  protected void b(int paramInt, long paramLong) {}
  
  protected void b(long paramLong) {}
  
  protected void b(long paramLong, boolean paramBoolean, String paramString) {}
  
  protected void b(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  void b(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = 0;
    int j = ((Integer)paramObject[0]).intValue();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnUpdate，msgType = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("qav.ControlUIObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (j != 158)
    {
      if (j != 159)
      {
        if (j != 6104)
        {
          if (j != 6105) {}
          switch (j)
          {
          default: 
            switch (j)
            {
            default: 
              boolean bool1;
              switch (j)
              {
              default: 
                switch (j)
                {
                default: 
                  switch (j)
                  {
                  default: 
                    switch (j)
                    {
                    default: 
                      switch (j)
                      {
                      default: 
                        switch (j)
                        {
                        default: 
                          return;
                        case 7004: 
                          a((String)paramObject[1], (Boolean)paramObject[2]);
                          return;
                        case 7003: 
                          d((String)paramObject[1]);
                          return;
                        case 7002: 
                          b((ControlUIObserver.CPreEventInfo)paramObject[1]);
                          return;
                        case 7001: 
                          b((String)paramObject[1], (Boolean)paramObject[2]);
                          return;
                        }
                        e((String)paramObject[1]);
                        return;
                      case 174: 
                        b(SeqUtil.a(paramObject, 1));
                        return;
                      case 173: 
                        a((String)paramObject[1], (AVFunChat.AVFunChatMessage)paramObject[2]);
                        return;
                      }
                      a(((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
                      return;
                    case 165: 
                      e(((Integer)paramObject[1]).intValue());
                      return;
                    case 164: 
                      d(((Integer)paramObject[1]).intValue());
                      return;
                    case 163: 
                      d();
                      return;
                    case 162: 
                      a((String)paramObject[1], (String)paramObject[2]);
                      return;
                    }
                    c();
                    return;
                  case 137: 
                    r();
                    return;
                  case 136: 
                    q();
                    return;
                  case 135: 
                    p();
                    return;
                  }
                  m();
                  return;
                case 127: 
                  o();
                  return;
                case 126: 
                  bool1 = ((Boolean)paramObject[1]).booleanValue();
                  i = ((Integer)paramObject[2]).intValue();
                  a(SeqUtil.a(paramObject, 3), bool1, i);
                  return;
                case 125: 
                  e(SeqUtil.a(paramObject, 1));
                  return;
                case 124: 
                  g(SeqUtil.a(paramObject, 1));
                  return;
                case 123: 
                  if (paramObject.length > 1) {
                    i = ((Integer)paramObject[1]).intValue();
                  }
                  a(SeqUtil.a(paramObject, 2), i);
                  return;
                case 122: 
                  a(paramObject[1]);
                  return;
                }
                l();
                return;
              case 119: 
                c(((Integer)paramObject[1]).intValue());
                return;
              case 118: 
                if (paramObject.length < 4) {
                  break;
                }
                bool1 = ((Boolean)paramObject[1]).booleanValue();
                boolean bool2 = ((Boolean)paramObject[2]).booleanValue();
                long l = ((Long)paramObject[3]).longValue();
                a(SeqUtil.a(paramObject, 4), bool1, bool2, l);
                return;
              case 117: 
                i = -1;
                if (paramObject.length > 1) {
                  i = ((Integer)paramObject[1]).intValue();
                }
                a(i);
                return;
              }
              break;
            case 115: 
              a((String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Integer)paramObject[4]).intValue());
              return;
            case 114: 
              e();
              return;
            case 113: 
              b();
              return;
            }
            break;
          case 22201: 
            if (((Boolean)paramObject[1]).booleanValue())
            {
              f();
              return;
            }
            g();
            return;
          case 20001: 
            b(SeqUtil.a(paramObject, 1), ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3]);
            return;
          case 15001: 
            a(SeqUtil.a(paramObject, 1), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
            return;
          case 9051: 
            h();
            return;
          case 9050: 
            a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3]);
            return;
          case 9008: 
            a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
            return;
          case 9007: 
            a(((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
            return;
          case 9006: 
            b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
            return;
          case 9005: 
            d((ControlUIObserver.CPreEventInfo)paramObject[1]);
            return;
          case 9004: 
            a((ControlUIObserver.CPreChangButtonStyleInfo)paramObject[1]);
            return;
          case 9003: 
            a((ControlUIObserver.CEffectEntrancePreClickInfo)paramObject[1]);
            return;
          case 9002: 
            f((ControlUIObserver.CPreEventInfo)paramObject[1]);
            return;
          case 9001: 
            e((ControlUIObserver.CPreEventInfo)paramObject[1]);
            return;
          case 9000: 
            c((ControlUIObserver.CPreEventInfo)paramObject[1]);
            return;
          case 8005: 
            b((String)paramObject[1], (String)paramObject[2]);
            return;
          case 8004: 
            a((ControlUIObserver.CPreEventInfo)paramObject[1]);
            return;
          case 8003: 
            b(((Integer)paramObject[1]).intValue());
            return;
          case 8002: 
            k();
            return;
          case 8001: 
            b((String)paramObject[1]);
            return;
          case 6012: 
            n();
            return;
          case 6009: 
            c((String)paramObject[2]);
            return;
          case 169: 
            a((QAVGroupConfig.GroupInviteFlag)paramObject[1]);
            return;
          case 167: 
            b(((Boolean)paramObject[1]).booleanValue());
            return;
          case 111: 
            a(((Boolean)paramObject[1]).booleanValue());
            return;
          case 110: 
            f(SeqUtil.a(paramObject, 1));
            return;
          case 109: 
            j();
            return;
          case 108: 
            i();
            return;
          case 107: 
            d(SeqUtil.a(paramObject, 1));
            return;
          case 106: 
            c(SeqUtil.a(paramObject, 1));
            return;
          case 105: 
            a(((Boolean)paramObject[1]).booleanValue(), SeqUtil.a(paramObject, 2));
            return;
          case 104: 
            a((ArrayList)paramObject[1]);
            return;
          case 103: 
            localObject = (ArrayList)paramObject[1];
            a(SeqUtil.a(paramObject, 2), (ArrayList)localObject);
            return;
          case 102: 
            a();
            return;
          case 101: 
            a(SeqUtil.a(paramObject, 1));
            return;
            a(((Integer)paramObject[1]).intValue(), SeqUtil.a(paramObject, 2));
            return;
          }
        }
        else
        {
          a((String)paramObject[1]);
        }
      }
      else {
        f(((Integer)paramObject[1]).intValue());
      }
    }
    else {
      s();
    }
  }
  
  protected void b(String paramString) {}
  
  protected void b(String paramString, Boolean paramBoolean) {}
  
  public void b(String paramString1, String paramString2) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void c() {}
  
  protected void c(int paramInt) {}
  
  protected void c(long paramLong) {}
  
  protected void c(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  public void c(String paramString) {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  protected void d(long paramLong) {}
  
  protected void d(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  protected void d(String paramString) {}
  
  protected void e() {}
  
  protected void e(int paramInt) {}
  
  protected void e(long paramLong) {}
  
  protected void e(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  protected void e(String paramString) {}
  
  protected void f() {}
  
  protected void f(int paramInt) {}
  
  protected void f(long paramLong) {}
  
  protected void f(ControlUIObserver.CPreEventInfo paramCPreEventInfo) {}
  
  protected void g() {}
  
  protected void g(long paramLong) {}
  
  protected void h() {}
  
  protected void i() {}
  
  protected void j() {}
  
  public void k() {}
  
  protected void l() {}
  
  protected void m() {}
  
  protected void n() {}
  
  protected void o() {}
  
  protected void p() {}
  
  protected void q() {}
  
  protected void r() {}
  
  protected void s() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.b == null) {
        this.b = new Handler(paramObservable);
      }
      this.b.post(new ControlUIObserver.1(this, paramObject));
      return;
    }
    b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver
 * JD-Core Version:    0.7.0.1
 */