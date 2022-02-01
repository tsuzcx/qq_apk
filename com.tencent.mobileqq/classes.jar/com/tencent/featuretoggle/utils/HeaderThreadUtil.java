package com.tencent.featuretoggle.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.db.DBManager;

public class HeaderThreadUtil
{
  private Handler a;
  private HandlerThread b;
  
  public static HeaderThreadUtil a()
  {
    return HeaderThreadUtil.Holder.a;
  }
  
  private static void e()
  {
    long l = DBManager.a().c();
    ToggleSetting.c(l);
    LogUtils.e("[Database] t_f_e count:%d", new Object[] { Long.valueOf(l) });
  }
  
  Looper a(int paramInt)
  {
    try
    {
      if (this.b != null)
      {
        this.b.quit();
        this.b = null;
      }
      this.b = new HandlerThread("ToggleThread", paramInt);
      this.b.start();
      Looper localLooper = this.b.getLooper();
      return localLooper;
    }
    finally {}
  }
  
  public Message a(int paramInt, Object paramObject)
  {
    if (c()) {
      return this.a.obtainMessage(paramInt, paramObject);
    }
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (c()) {
      this.a.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  public void a(Message paramMessage, long paramLong)
  {
    if (c()) {
      this.a.sendMessageDelayed(paramMessage, paramLong);
    }
  }
  
  public void b(int paramInt)
  {
    if (c()) {
      this.a.sendEmptyMessage(paramInt);
    }
  }
  
  boolean b()
  {
    Looper localLooper2 = a(0);
    Looper localLooper1 = localLooper2;
    if (localLooper2 == null) {
      localLooper1 = a(-2);
    }
    if (localLooper1 == null) {
      return false;
    }
    this.a = new HeaderThreadUtil.1(this, localLooper1);
    return true;
  }
  
  public void c(int paramInt)
  {
    if (c()) {
      this.a.removeMessages(paramInt);
    }
  }
  
  public boolean c()
  {
    if (this.a == null) {
      return b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.HeaderThreadUtil
 * JD-Core Version:    0.7.0.1
 */