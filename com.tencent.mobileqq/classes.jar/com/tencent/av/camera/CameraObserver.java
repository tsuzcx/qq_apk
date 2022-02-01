package com.tencent.av.camera;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class CameraObserver
  implements Observer
{
  Handler a = null;
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate, msgType[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w("CameraObserver", 1, localStringBuilder.toString());
    }
    long l = 0L;
    boolean bool;
    switch (i)
    {
    default: 
      return;
    case 8: 
      b(((Boolean)paramObject[1]).booleanValue());
      return;
    case 7: 
      try
      {
        paramObject = (byte[])paramObject[1];
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        paramObject = null;
      }
      a(paramObject);
      return;
    case 6: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 5: 
      b();
      return;
    case 4: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      if (paramObject.length > 2) {
        l = ((Long)paramObject[2]).longValue();
      }
      b(l, bool);
      return;
    case 3: 
      if (paramObject.length > 1) {
        l = ((Long)paramObject[1]).longValue();
      }
      a(l);
      return;
    case 2: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      i = ((Integer)paramObject[2]).intValue();
      if (paramObject.length > 3) {
        l = ((Long)paramObject[3]).longValue();
      }
      a(l, bool, i);
      return;
    }
    if (paramObject.length > 1)
    {
      bool = ((Boolean)paramObject[1]).booleanValue();
      if (paramObject.length > 2) {
        l = ((Long)paramObject[2]).longValue();
      }
      a(l, bool);
      return;
    }
    a();
  }
  
  @Deprecated
  protected void a() {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(byte[] paramArrayOfByte) {}
  
  protected void b() {}
  
  protected void b(long paramLong, boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new CameraObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.CameraObserver
 * JD-Core Version:    0.7.0.1
 */