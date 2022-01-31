package com.tencent.av.app;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import jfq;

public class VideoObserver
  implements Observer
{
  Handler a = null;
  
  private void a(Object[] paramArrayOfObject)
  {
    int j = -1;
    try
    {
      i = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        int i = -5;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Before send, ivrRequestSeq = %d", new Object[] { Integer.valueOf(j) }));
    }
    b(i, j);
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    int i = -1;
    str = "";
    try
    {
      j = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      i = j;
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      i = j;
      paramArrayOfObject = String.valueOf(paramArrayOfObject[3]);
      i = j;
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        int j = -4;
        paramArrayOfObject = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Receive request ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramArrayOfObject }));
    }
    a(i, j, paramArrayOfObject);
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    j = -1;
    long l1 = -1L;
    String str3 = "";
    String str4 = "";
    int i = j;
    String str2 = str3;
    String str1 = str4;
    try
    {
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      i = j;
      str2 = str3;
      str1 = str4;
      j = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      i = j;
      str2 = str3;
      str1 = str4;
      str3 = String.valueOf(paramArrayOfObject[3]);
      i = j;
      str2 = str3;
      str1 = str4;
      str4 = String.valueOf(paramArrayOfObject[4]);
      i = j;
      str2 = str3;
      str1 = str4;
      long l2 = Long.parseLong(String.valueOf(paramArrayOfObject[5]));
      l1 = l2;
      str1 = str4;
      str2 = str3;
      i = j;
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        j = -3;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Get data from VideoController, errorCode = %d, seq = %d, url = %s, str = %s, roomId = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), str2, str1, Long.valueOf(l1) }));
    }
    a(j, i, str2, str1, l1);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(long paramLong) {}
  
  public void a(RecvMsg paramRecvMsg) {}
  
  public void a(Object paramObject)
  {
    int j = -1;
    if (paramObject == null) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    case 0: 
    default: 
      return;
    case 10: 
      a();
      return;
    case 32: 
      if (arrayOfObject.length == 3) {
        j = ((Integer)arrayOfObject[1]).intValue();
      }
      break;
    }
    for (int i = ((Integer)arrayOfObject[2]).intValue();; i = -1)
    {
      a(j, i);
      return;
      b();
      return;
      a((RecvMsg)arrayOfObject[1]);
      return;
      c();
      return;
      i = ((Integer)arrayOfObject[1]).intValue();
      if (arrayOfObject.length > 2) {}
      for (paramObject = (String)arrayOfObject[2];; paramObject = null)
      {
        a(i, paramObject);
        return;
        d();
        return;
        e();
        return;
        f();
        return;
        g();
        return;
        a((String)arrayOfObject[1]);
        return;
        h();
        return;
        a(((Integer)arrayOfObject[1]).intValue());
        return;
        b(((Integer)arrayOfObject[1]).intValue());
        return;
        a(true, ((Boolean)arrayOfObject[1]).booleanValue());
        return;
        a(false, ((Boolean)arrayOfObject[1]).booleanValue());
        return;
        a(((Boolean)arrayOfObject[1]).booleanValue());
        return;
        b(((Boolean)arrayOfObject[1]).booleanValue());
        return;
        b((String)arrayOfObject[1]);
        return;
        c((String)arrayOfObject[1]);
        return;
        a((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
        return;
        j();
        return;
        String str = (String)arrayOfObject[1];
        for (;;)
        {
          for (;;)
          {
            try
            {
              if ((arrayOfObject.length <= 2) || (arrayOfObject[2] == null) || (!(arrayOfObject[2] instanceof String))) {
                break label1422;
              }
              paramObject = (String)arrayOfObject[2];
            }
            catch (Exception paramObject)
            {
              paramObject = null;
              continue;
            }
            a(str, paramObject);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("VideoObserver", 2, "TYPE_NOTIFY_CHANGE_DOUBLE_TITLE");
            }
            try
            {
              if ((arrayOfObject.length <= 1) || (arrayOfObject[1] == null) || (!(arrayOfObject[1] instanceof String))) {
                break;
              }
              paramObject = (String)arrayOfObject[1];
              if (QLog.isColorLevel()) {
                QLog.d("VideoObserver", 2, "TYPE_NOTIFY_CHANGE_DOUBLE_TITLE :" + paramObject);
              }
              d(paramObject, true);
              return;
            }
            catch (Exception paramObject)
            {
              return;
            }
          }
          b(((Integer)arrayOfObject[1]).intValue(), (String)arrayOfObject[2]);
          return;
          c(arrayOfObject);
          return;
          a(arrayOfObject);
          return;
          b(arrayOfObject);
          return;
          boolean bool = ((Boolean)arrayOfObject[2]).booleanValue();
          c((String)arrayOfObject[1], bool);
          return;
          c(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
          return;
          k();
          return;
          l();
          return;
          c(((Integer)arrayOfObject[1]).intValue());
          return;
          b((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
          return;
          a(((Long)arrayOfObject[1]).longValue());
          return;
          a((String)arrayOfObject[1], (Bitmap)arrayOfObject[2]);
          return;
          e((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
          return;
          i();
          return;
          e((String)arrayOfObject[1]);
          return;
          f((String)arrayOfObject[1]);
          return;
          g((String)arrayOfObject[1]);
          return;
          h((String)arrayOfObject[1]);
          return;
          a((String)arrayOfObject[1], ((Long)arrayOfObject[2]).longValue(), (byte[])arrayOfObject[3]);
          return;
          a((RecvGVideoLevelInfo[])arrayOfObject[1]);
          return;
          d((String)arrayOfObject[1]);
          return;
          a((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
          return;
          b((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
          return;
          b(paramObject);
          return;
          a(((Boolean)arrayOfObject[1]).booleanValue(), (String)arrayOfObject[2], (String)arrayOfObject[3], (String)arrayOfObject[4]);
          return;
          c(((Boolean)arrayOfObject[1]).booleanValue());
          return;
          d(((Integer)arrayOfObject[2]).intValue());
          return;
          d(((Boolean)arrayOfObject[1]).booleanValue());
          return;
          m();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("VideoObserver", 1, "WL_DEBUG VideoConstants.TYPE_NOTIFY_REDPACKET_FLOATWINDOW_ANIMATION");
          }
          b(((Boolean)arrayOfObject[1]).booleanValue(), ((Boolean)arrayOfObject[2]).booleanValue());
          return;
          a((byte[])arrayOfObject[2], ((Integer)arrayOfObject[3]).intValue(), ((Integer)arrayOfObject[4]).intValue());
          return;
          label1422:
          paramObject = null;
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte) {}
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  protected void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void b(Object paramObject) {}
  
  public void b(String paramString) {}
  
  public void b(String paramString, int paramInt) {}
  
  public void b(String paramString, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void c(int paramInt1, int paramInt2) {}
  
  public void c(String paramString) {}
  
  public void c(String paramString, boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean) {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  public void d(String paramString) {}
  
  public void d(String paramString, boolean paramBoolean) {}
  
  public void d(boolean paramBoolean) {}
  
  public void e() {}
  
  public void e(String paramString) {}
  
  public void e(String paramString, boolean paramBoolean) {}
  
  public void f() {}
  
  public void f(String paramString) {}
  
  public void g() {}
  
  public void g(String paramString) {}
  
  public void h() {}
  
  public void h(String paramString) {}
  
  protected void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new jfq(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.VideoObserver
 * JD-Core Version:    0.7.0.1
 */