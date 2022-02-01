package com.tencent.featuretoggle.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.db.DBManager;

public class HeaderThreadUtil
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  
  public static HeaderThreadUtil a()
  {
    return HeaderThreadUtil.Holder.a;
  }
  
  private static void b()
  {
    long l = DBManager.a().a();
    ToggleSetting.c(l);
    LogUtils.c("[Database] t_f_e count:%d", new Object[] { Long.valueOf(l) });
  }
  
  Looper a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ToggleThread", paramInt);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      Looper localLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
      return localLooper;
    }
    finally {}
  }
  
  public Message a(int paramInt, Object paramObject)
  {
    if (b()) {
      return this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramObject);
    }
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  public void a(int paramInt)
  {
    if (b()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (b()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  public void a(Message paramMessage, long paramLong)
  {
    if (b()) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, paramLong);
    }
  }
  
  boolean a()
  {
    Looper localLooper2 = a(0);
    Looper localLooper1 = localLooper2;
    if (localLooper2 == null) {
      localLooper1 = a(-2);
    }
    if (localLooper1 == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidOsHandler = new HeaderThreadUtil.1(this, localLooper1);
    return true;
  }
  
  public void b(int paramInt)
  {
    if (b()) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.HeaderThreadUtil
 * JD-Core Version:    0.7.0.1
 */