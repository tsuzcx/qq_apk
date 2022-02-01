package com.tencent.av.gaudio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class AVObserver
  implements Observer
{
  Handler a = null;
  
  protected void a(int paramInt, long paramLong) {}
  
  protected void a(int paramInt, long paramLong1, long paramLong2) {}
  
  protected void a(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  protected void a(long paramLong1, int paramInt, long paramLong2, String paramString) {}
  
  void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (i != 28)
    {
      if (i != 29)
      {
        if (i != 32)
        {
          if (i != 33)
          {
            if (i != 36)
            {
              if (i != 37)
              {
                if (i != 408)
                {
                  if (i != 800)
                  {
                    switch (i)
                    {
                    default: 
                      int j = ((Integer)paramObject[1]).intValue();
                      long l1 = ((Long)paramObject[2]).longValue();
                      long l2 = ((Long)paramObject[3]).longValue();
                      if (QLog.isDevelopLevel())
                      {
                        paramObject = new StringBuilder();
                        paramObject.append("onUpdate, relationType[");
                        paramObject.append(j);
                        paramObject.append("], discussId[");
                        paramObject.append(l1);
                        paramObject.append("], memberUin[");
                        paramObject.append(l2);
                        paramObject.append("], msg[");
                        paramObject.append(i);
                        paramObject.append("]");
                        QLog.w("GAudioObserver", 1, paramObject.toString());
                      }
                      a(j, l1, l2);
                      return;
                    case 23: 
                      c(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
                      return;
                    case 22: 
                      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
                      return;
                    }
                    a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
                    return;
                  }
                  a((String)paramObject[1]);
                  return;
                }
                a(((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2]);
                return;
              }
              b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
              return;
            }
            a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
            return;
          }
          i = ((Integer)paramObject[1]).intValue();
          a(((Long)paramObject[2]).longValue(), i, ((Long)paramObject[3]).longValue(), (String)paramObject[4]);
          return;
        }
        i = ((Integer)paramObject[1]).intValue();
        a(((Long)paramObject[2]).longValue(), i, ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
        return;
      }
      a((String)paramObject[2], (String)paramObject[3]);
      return;
    }
    a(((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void b(int paramInt, long paramLong) {}
  
  protected void b(int paramInt, long paramLong1, long paramLong2) {}
  
  protected void c(int paramInt, long paramLong1, long paramLong2) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new AVObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVObserver
 * JD-Core Version:    0.7.0.1
 */