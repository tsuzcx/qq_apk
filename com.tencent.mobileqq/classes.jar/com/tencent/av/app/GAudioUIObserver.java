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
    switch (i)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qav.GAudioUIObserver", 2, "OnUpdate-->Wrong notify type.Type = " + i);
      }
      return;
      b();
      return;
      a((RecvMsg)paramObject[1]);
      return;
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
      c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
      long l1 = ((Long)paramObject[1]).longValue();
      long l2 = ((Long)paramObject[2]).longValue();
      i = ((Integer)paramObject[3]).intValue();
      a(SeqUtil.a(paramObject, 4), l1, l2, i);
      return;
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), true, ((Boolean)paramObject[3]).booleanValue());
      return;
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), false, ((Boolean)paramObject[3]).booleanValue());
      return;
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      long l3 = ((Long)paramObject[3]).longValue();
      int j = ((Integer)paramObject[4]).intValue();
      a(SeqUtil.a(paramObject, 5), i, l1, l2, l3, j);
      return;
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      j = ((Integer)paramObject[3]).intValue();
      a(SeqUtil.a(paramObject, 4), i, 0L, l1, l2, j);
      return;
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue());
      return;
      a(((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
      a(((Long)paramObject[1]).longValue());
      return;
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
      b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
      a(((Integer)paramObject[1]).intValue());
      return;
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Integer)paramObject[3]).intValue());
      return;
      l1 = ((Long)paramObject[1]).longValue();
      b(SeqUtil.a(paramObject, 2), l1);
      return;
      l1 = ((Long)paramObject[1]).longValue();
      a(SeqUtil.a(paramObject, 2), l1);
      return;
      a();
      return;
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
      c(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
      a((String)paramObject[1], (String[])paramObject[2]);
      return;
      c();
      return;
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
      l1 = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l1, ((Long)paramObject[3]).longValue(), i, true);
      return;
      l1 = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l1, ((Long)paramObject[3]).longValue(), i, false);
      return;
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      i = ((Integer)paramObject[3]).intValue();
      a(SeqUtil.a(paramObject, 4), l1, l2, i, true);
      return;
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      i = ((Integer)paramObject[3]).intValue();
      a(SeqUtil.a(paramObject, 4), l1, l2, i, false);
      return;
      b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
      d(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
      a((ArrayList)paramObject[1]);
      return;
      a((ArrayList)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
      b(((Long)paramObject[1]).longValue());
      return;
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
      c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
      d();
      return;
      e();
      return;
      d(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
      a(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), SeqUtil.a(paramObject, 5), ((Long)paramObject[6]).longValue());
      return;
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), SeqUtil.a(paramObject, 6), ((Long)paramObject[7]).longValue());
      return;
      a((String)paramObject[1], (String)paramObject[2]);
      return;
      c(((Long)paramObject[1]).longValue());
      return;
      f();
      return;
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
      d(((Long)paramObject[1]).longValue());
      return;
      e(((Long)paramObject[1]).longValue());
      return;
      a(((Long)paramObject[1]).longValue(), (String)paramObject[2]);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("qav.GAudioUIObserver", 2, "TYPE_NOTIFY_RANDOM_MULTI_OWNER_PUSH [random room owner]");
      }
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
      b(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
      b(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
      a(((Integer)paramObject[1]).intValue(), (byte[])paramObject[2]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.GAudioUIObserver
 * JD-Core Version:    0.7.0.1
 */