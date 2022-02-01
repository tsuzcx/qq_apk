package com.tencent.av.app;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

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
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {}
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong, int paramInt, String paramString) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  protected void a(long paramLong, String paramString, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(RecvMsg paramRecvMsg) {}
  
  void a(Object paramObject)
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
      if (arrayOfObject.length > 2) {
        j = ((Integer)arrayOfObject[1]).intValue();
      }
      break;
    }
    for (int i = ((Integer)arrayOfObject[2]).intValue();; i = -1)
    {
      a(SeqUtil.a(arrayOfObject, 3), j, i);
      return;
      b();
      return;
      a((RecvMsg)arrayOfObject[1]);
      return;
      a(SeqUtil.a(arrayOfObject, 1));
      return;
      i = ((Integer)arrayOfObject[1]).intValue();
      paramObject = null;
      if (arrayOfObject.length > 2) {
        paramObject = (String)arrayOfObject[2];
      }
      a(SeqUtil.a(arrayOfObject, 3), i, paramObject);
      return;
      c();
      return;
      b(SeqUtil.a(arrayOfObject, 1));
      return;
      d();
      return;
      e();
      return;
      a((String)arrayOfObject[1]);
      return;
      a(((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), ((Long)arrayOfObject[3]).longValue());
      return;
      a(((Boolean)arrayOfObject[1]).booleanValue(), ((Integer)arrayOfObject[2]).intValue(), (String)arrayOfObject[3], ((Integer)arrayOfObject[4]).intValue());
      return;
      b(((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), ((Long)arrayOfObject[3]).longValue());
      return;
      g();
      return;
      b(((Integer)arrayOfObject[1]).intValue());
      return;
      c(((Integer)arrayOfObject[1]).intValue());
      return;
      b(true, ((Boolean)arrayOfObject[1]).booleanValue());
      return;
      b(false, ((Boolean)arrayOfObject[1]).booleanValue());
      return;
      b(((Boolean)arrayOfObject[1]).booleanValue());
      return;
      boolean bool = ((Boolean)arrayOfObject[1]).booleanValue();
      a(SeqUtil.a(arrayOfObject, 2), bool);
      return;
      b((String)arrayOfObject[1]);
      return;
      c((String)arrayOfObject[1]);
      return;
      String str = (String)arrayOfObject[1];
      bool = ((Boolean)arrayOfObject[2]).booleanValue();
      paramObject = str;
      if (TextUtils.isEmpty(str)) {
        paramObject = "";
      }
      a(paramObject, bool);
      return;
      i();
      return;
      str = (String)arrayOfObject[1];
      for (;;)
      {
        for (;;)
        {
          try
          {
            if ((arrayOfObject.length <= 2) || (arrayOfObject[2] == null) || (!(arrayOfObject[2] instanceof String))) {
              break label1875;
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
          try
          {
            if ((arrayOfObject.length <= 1) || (arrayOfObject[1] == null) || (!(arrayOfObject[1] instanceof String))) {
              break;
            }
            paramObject = (String)arrayOfObject[1];
            a(SeqUtil.a(arrayOfObject, 2), paramObject, true);
            return;
          }
          catch (Exception paramObject)
          {
            return;
          }
        }
        a(((Integer)arrayOfObject[1]).intValue(), (String)arrayOfObject[2]);
        return;
        c(arrayOfObject);
        return;
        a(arrayOfObject);
        return;
        b(arrayOfObject);
        return;
        bool = ((Boolean)arrayOfObject[2]).booleanValue();
        c((String)arrayOfObject[1], bool);
        return;
        c(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
        return;
        j();
        return;
        k();
        return;
        i = ((Integer)arrayOfObject[1]).intValue();
        a(SeqUtil.a(arrayOfObject, 2), i);
        return;
        b((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
        return;
        a(((Boolean)arrayOfObject[1]).booleanValue(), ((Long)arrayOfObject[2]).longValue(), ((Integer)arrayOfObject[3]).intValue(), ((Integer)arrayOfObject[4]).intValue(), ((Integer)arrayOfObject[5]).intValue(), (String)arrayOfObject[6]);
        return;
        c(((Long)arrayOfObject[1]).longValue());
        return;
        a((String)arrayOfObject[1], (Bitmap)arrayOfObject[2]);
        return;
        paramObject = (String)arrayOfObject[1];
        bool = ((Boolean)arrayOfObject[2]).booleanValue();
        b(SeqUtil.a(arrayOfObject, 3), paramObject, bool);
        return;
        h();
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
        d(((Boolean)arrayOfObject[1]).booleanValue());
        return;
        l();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VideoObserver", 1, "WL_DEBUG VideoConstants.TYPE_NOTIFY_REDPACKET_FLOATWINDOW_ANIMATION");
        }
        c(((Boolean)arrayOfObject[1]).booleanValue(), ((Boolean)arrayOfObject[2]).booleanValue());
        return;
        a((byte[])arrayOfObject[2], ((Integer)arrayOfObject[3]).intValue(), ((Integer)arrayOfObject[4]).intValue());
        return;
        a(((Integer)arrayOfObject[1]).intValue());
        return;
        a(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
        return;
        a(((Boolean)arrayOfObject[1]).booleanValue(), ((Boolean)arrayOfObject[2]).booleanValue());
        return;
        a(((Boolean)arrayOfObject[1]).booleanValue());
        return;
        f();
        return;
        a(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue(), ((Integer)arrayOfObject[3]).intValue(), ((Long)arrayOfObject[4]).longValue(), ((Integer)arrayOfObject[5]).intValue());
        return;
        a(((Integer)arrayOfObject[1]).intValue(), ((Long)arrayOfObject[2]).longValue(), ((Integer)arrayOfObject[3]).intValue());
        return;
        label1875:
        paramObject = null;
      }
    }
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString, long paramLong, byte[] paramArrayOfByte) {}
  
  protected void a(String paramString, Bitmap paramBitmap) {}
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  protected void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  protected void b() {}
  
  protected void b(int paramInt) {}
  
  protected void b(int paramInt1, int paramInt2) {}
  
  protected void b(long paramLong) {}
  
  protected void b(long paramLong1, long paramLong2, long paramLong3) {}
  
  protected void b(long paramLong, String paramString, boolean paramBoolean) {}
  
  protected void b(Object paramObject) {}
  
  protected void b(String paramString) {}
  
  protected void b(String paramString, int paramInt) {}
  
  protected void b(String paramString, boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c() {}
  
  protected void c(int paramInt) {}
  
  protected void c(int paramInt1, int paramInt2) {}
  
  protected void c(long paramLong) {}
  
  protected void c(String paramString) {}
  
  protected void c(String paramString, boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d() {}
  
  protected void d(String paramString) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void e() {}
  
  protected void e(String paramString) {}
  
  protected void f() {}
  
  protected void f(String paramString) {}
  
  protected void g() {}
  
  protected void g(String paramString) {}
  
  protected void h() {}
  
  protected void h(String paramString) {}
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k() {}
  
  protected void l() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new VideoObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.VideoObserver
 * JD-Core Version:    0.7.0.1
 */