package com.tencent.av.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.utils.SeqUtil;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GAudioUIObserver
  implements Observer
{
  Handler a = null;
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4) {}
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, byte[] paramArrayOfByte) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2) {}
  
  protected void a(long paramLong, int paramInt, String paramString) {}
  
  protected void a(long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString) {}
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(long paramLong, String paramString) {}
  
  protected void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  protected void a(RecvMsg paramRecvMsg) {}
  
  void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (i != 209)
    {
      if (i != 210)
      {
        if (i != 409)
        {
          if (i != 410) {
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                long l1;
                long l2;
                switch (i)
                {
                default: 
                  int j;
                  switch (i)
                  {
                  default: 
                    switch (i)
                    {
                    default: 
                      switch (i)
                      {
                      default: 
                        switch (i)
                        {
                        default: 
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          paramObject = new StringBuilder();
                          paramObject.append("OnUpdate-->Wrong notify type.Type = ");
                          paramObject.append(i);
                          QLog.e("qav.GAudioUIObserver", 2, paramObject.toString());
                          return;
                        case 516: 
                          a(((Long)paramObject[1]).longValue(), (String)paramObject[2]);
                          return;
                        case 515: 
                          e(((Long)paramObject[1]).longValue());
                          return;
                        case 514: 
                          d(((Long)paramObject[1]).longValue());
                          return;
                        case 513: 
                          b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
                          return;
                        }
                        break;
                      case 303: 
                        c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
                        return;
                      case 302: 
                        b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
                        return;
                      case 301: 
                        b(((Long)paramObject[1]).longValue());
                        return;
                      }
                      break;
                    case 142: 
                      a((ArrayList)paramObject[1], ((Integer)paramObject[2]).intValue());
                      return;
                    case 141: 
                      a((ArrayList)paramObject[1]);
                      return;
                    case 140: 
                      d(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
                      return;
                    case 139: 
                      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue());
                      return;
                    case 138: 
                      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue());
                      return;
                    }
                    break;
                  case 99: 
                    a();
                    return;
                  case 96: 
                  case 97: 
                  case 98: 
                    l1 = ((Long)paramObject[1]).longValue();
                    l2 = ((Long)paramObject[2]).longValue();
                    j = ((Integer)paramObject[3]).intValue();
                    a(SeqUtil.a(paramObject, 4), i, 0L, l1, l2, j);
                    return;
                  case 90: 
                  case 91: 
                  case 92: 
                  case 93: 
                  case 94: 
                  case 95: 
                    l1 = ((Long)paramObject[1]).longValue();
                    l2 = ((Long)paramObject[2]).longValue();
                    long l3 = ((Long)paramObject[3]).longValue();
                    j = ((Integer)paramObject[4]).intValue();
                    a(SeqUtil.a(paramObject, 5), i, l1, l2, l3, j);
                    return;
                  case 89: 
                    a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
                    return;
                  case 88: 
                    b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
                    return;
                  case 87: 
                    a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
                    return;
                  case 86: 
                    b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
                    return;
                  case 85: 
                    a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
                    return;
                  case 84: 
                    c();
                    return;
                  case 83: 
                    l1 = ((Long)paramObject[1]).longValue();
                    a(SeqUtil.a(paramObject, 2), l1);
                    return;
                  case 82: 
                    a((String)paramObject[1], (String[])paramObject[2]);
                    return;
                  case 81: 
                    c(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
                    return;
                  case 80: 
                    l1 = ((Long)paramObject[1]).longValue();
                    b(SeqUtil.a(paramObject, 2), l1);
                    return;
                  case 79: 
                    a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Integer)paramObject[3]).intValue());
                    return;
                  case 78: 
                    b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), false, ((Boolean)paramObject[3]).booleanValue());
                    return;
                  case 77: 
                    b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), true, ((Boolean)paramObject[3]).booleanValue());
                    return;
                  }
                  break;
                case 74: 
                  l1 = ((Long)paramObject[1]).longValue();
                  l2 = ((Long)paramObject[2]).longValue();
                  i = ((Integer)paramObject[3]).intValue();
                  a(SeqUtil.a(paramObject, 4), l1, l2, i, false);
                  return;
                case 73: 
                  l1 = ((Long)paramObject[1]).longValue();
                  l2 = ((Long)paramObject[2]).longValue();
                  i = ((Integer)paramObject[3]).intValue();
                  a(SeqUtil.a(paramObject, 4), l1, l2, i, true);
                  return;
                case 72: 
                  l1 = ((Long)paramObject[1]).longValue();
                  i = ((Integer)paramObject[2]).intValue();
                  a(l1, ((Long)paramObject[3]).longValue(), i, false);
                  return;
                case 71: 
                  l1 = ((Long)paramObject[1]).longValue();
                  i = ((Integer)paramObject[2]).intValue();
                  a(l1, ((Long)paramObject[3]).longValue(), i, true);
                  return;
                case 70: 
                  l1 = ((Long)paramObject[1]).longValue();
                  l2 = ((Long)paramObject[2]).longValue();
                  i = ((Integer)paramObject[3]).intValue();
                  a(SeqUtil.a(paramObject, 4), l1, l2, i);
                  return;
                case 69: 
                  c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
                  return;
                case 68: 
                  b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
                  return;
                case 67: 
                  a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
                  return;
                case 66: 
                  a(((Long)paramObject[1]).longValue());
                  return;
                }
                break;
              case 64: 
                a(((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
                return;
              case 63: 
                a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue());
                return;
              case 62: 
                a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
                return;
              case 61: 
                a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue(), ((Boolean)paramObject[4]).booleanValue());
                return;
              }
              break;
            case 707: 
              f();
              return;
            case 521: 
              a(((Integer)paramObject[1]).intValue(), (byte[])paramObject[2]);
              return;
            case 502: 
              a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), SeqUtil.a(paramObject, 6), ((Long)paramObject[7]).longValue());
              return;
            case 500: 
              a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), SeqUtil.a(paramObject, 5), ((Long)paramObject[6]).longValue());
              return;
            case 406: 
              e();
              return;
            case 404: 
              d(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
              return;
            case 311: 
              g();
              return;
            case 309: 
              a((String)paramObject[1], (String)paramObject[2]);
              return;
            case 307: 
              d();
              return;
            case 202: 
              a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
              return;
            case 200: 
              a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
              return;
            case 157: 
              b(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
              return;
            case 21: 
              a(((Integer)paramObject[1]).intValue());
              return;
            case 12: 
              a((RecvMsg)paramObject[1]);
              return;
            case 10: 
              b();
              return;
            }
          } else {
            c(((Long)paramObject[1]).longValue());
          }
        }
        else {
          a(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        }
      }
      else {
        b(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("qav.GAudioUIObserver", 2, "TYPE_NOTIFY_RANDOM_MULTI_OWNER_PUSH [random room owner]");
      }
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
    }
  }
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(String paramString, String[] paramArrayOfString) {}
  
  protected void a(ArrayList<AVUserInfo> paramArrayList) {}
  
  protected void a(ArrayList<Long> paramArrayList, int paramInt) {}
  
  protected void b() {}
  
  protected void b(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void b(int paramInt, String paramString) {}
  
  protected void b(long paramLong) {}
  
  protected void b(long paramLong, int paramInt) {}
  
  protected void b(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void b(long paramLong1, long paramLong2) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString) {}
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(long paramLong, boolean paramBoolean) {}
  
  protected void c() {}
  
  protected void c(long paramLong) {}
  
  protected void c(long paramLong, int paramInt) {}
  
  protected void c(long paramLong1, long paramLong2) {}
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  protected void d() {}
  
  protected void d(long paramLong) {}
  
  protected void d(long paramLong, int paramInt) {}
  
  protected void d(long paramLong1, long paramLong2) {}
  
  protected void e() {}
  
  protected void e(long paramLong) {}
  
  protected void f() {}
  
  protected void g() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new GAudioUIObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAudioUIObserver
 * JD-Core Version:    0.7.0.1
 */