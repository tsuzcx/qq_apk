package com.tencent.av.camera;

import android.os.Handler;
import android.os.Looper;
import java.util.Observable;
import java.util.Observer;
import jgs;

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
    switch (((Integer)paramObject[0]).intValue())
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      a(((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 3: 
      b();
      return;
    case 4: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 5: 
      c();
      return;
    case 6: 
      b(((Boolean)paramObject[1]).booleanValue());
      return;
    case 7: 
      try
      {
        paramObject = (byte[])paramObject[1];
        a(paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
          paramObject = null;
        }
      }
    }
    c(((Boolean)paramObject[1]).booleanValue());
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(byte[] paramArrayOfByte) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(boolean paramBoolean) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new jgs(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.camera.CameraObserver
 * JD-Core Version:    0.7.0.1
 */