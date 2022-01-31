package com.tencent.av.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.service.RecvMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import jfd;

public class GAudioUIObserver
  implements Observer
{
  Handler a = null;
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4) {}
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, ArrayList paramArrayList) {}
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt, String paramString) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(long paramLong, String paramString) {}
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(RecvMsg paramRecvMsg) {}
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, "OnUpdate，msgType = " + i);
    }
    long l;
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("VideoObserver", 2, "OnUpdate-->Wrong notify type.Type = " + i);
      }
      return;
    case 10: 
      a();
      return;
    case 12: 
      a((RecvMsg)paramObject[1]);
      return;
    case 61: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
    case 62: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 69: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 70: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 77: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), true, ((Boolean)paramObject[3]).booleanValue());
      return;
    case 78: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), false, ((Boolean)paramObject[3]).booleanValue());
      return;
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
      a(i, ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 96: 
    case 97: 
    case 98: 
      a(i, 0L, ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 63: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 64: 
      a(((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 66: 
      c(((Long)paramObject[1]).longValue());
      return;
    case 202: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 67: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 68: 
      b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 21: 
      a(((Integer)paramObject[1]).intValue());
      return;
    case 79: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 80: 
      b(((Long)paramObject[1]).longValue());
      return;
    case 83: 
      a(((Long)paramObject[1]).longValue());
      return;
    case 200: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 81: 
      c(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 82: 
      a((String)paramObject[1], (String[])paramObject[2]);
      return;
    case 84: 
      b();
      return;
    case 85: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 86: 
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 87: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 71: 
      l = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l, ((Long)paramObject[3]).longValue(), i, true);
      return;
    case 72: 
      l = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l, ((Long)paramObject[3]).longValue(), i, false);
      return;
    case 73: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), true);
      return;
    case 74: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), false);
      return;
    case 88: 
      b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 89: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
    case 138: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
    case 139: 
      b(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 140: 
      c(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 141: 
      a((ArrayList)paramObject[1]);
      return;
    case 142: 
      a((ArrayList)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    case 301: 
      d(((Long)paramObject[1]).longValue());
      return;
    case 302: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 303: 
      c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 307: 
      c();
      return;
    case 406: 
      d();
      return;
    case 404: 
      e(((Long)paramObject[1]).longValue());
      return;
    case 407: 
      i = ((Integer)paramObject[1]).intValue();
      if (paramObject[2] == null)
      {
        a(i, null);
        return;
      }
      a(i, (ArrayList)paramObject[2]);
      return;
    case 409: 
      a(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 500: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Long)paramObject[5]).longValue(), ((Long)paramObject[6]).longValue());
      return;
    case 502: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Long)paramObject[6]).longValue(), ((Long)paramObject[7]).longValue());
      return;
    case 309: 
      a((String)paramObject[1], (String)paramObject[2]);
      return;
    case 701: 
      b(((Integer)paramObject[1]).intValue());
      return;
    case 702: 
      e();
      return;
    case 703: 
      c(((Integer)paramObject[1]).intValue());
      return;
    case 704: 
      f();
      return;
    case 705: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 410: 
      f(((Long)paramObject[1]).longValue());
      return;
    case 707: 
      g();
      return;
    case 513: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
    case 514: 
      g(((Long)paramObject[1]).longValue());
      return;
    case 515: 
      h(((Long)paramObject[1]).longValue());
      return;
    case 516: 
      a(((Long)paramObject[1]).longValue(), (String)paramObject[2]);
      return;
    case 209: 
      if (QLog.isColorLevel()) {
        QLog.d("VideoObserver", 2, "TYPE_NOTIFY_RANDOM_MULTI_OWNER_PUSH [random room owner]");
      }
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 210: 
      b(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    }
    d(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
  }
  
  protected void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, String[] paramArrayOfString) {}
  
  public void a(ArrayList paramArrayList) {}
  
  public void a(ArrayList paramArrayList, int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
  protected void b() {}
  
  public void b(int paramInt) {}
  
  public void b(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void b(int paramInt, String paramString) {}
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, int paramInt) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2) {}
  
  public void b(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  public void b(long paramLong1, long paramLong2, String paramString) {}
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void c(long paramLong) {}
  
  public void c(long paramLong, int paramInt) {}
  
  public void c(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void c(long paramLong, boolean paramBoolean) {}
  
  public void d() {}
  
  protected void d(long paramLong) {}
  
  public void d(long paramLong, boolean paramBoolean) {}
  
  public void e() {}
  
  protected void e(long paramLong) {}
  
  public void f() {}
  
  public void f(long paramLong) {}
  
  protected void g() {}
  
  public void g(long paramLong) {}
  
  public void h(long paramLong) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new jfd(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.GAudioUIObserver
 * JD-Core Version:    0.7.0.1
 */