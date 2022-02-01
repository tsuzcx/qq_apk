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
    int i;
    int j;
    try
    {
      i = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      j = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      paramArrayOfObject.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
      }
      i = -5;
      j = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Before send, ivrRequestSeq = %d", new Object[] { Integer.valueOf(j) }));
    }
    b(i, j);
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    int i = -1;
    int j;
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
      paramArrayOfObject.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
      }
      j = -4;
      paramArrayOfObject = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Receive request ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramArrayOfObject }));
    }
    a(i, j, paramArrayOfObject);
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    Object localObject = "";
    int i = -1;
    int j = i;
    try
    {
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      j = i;
      i = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      j = i;
      String str1 = String.valueOf(paramArrayOfObject[3]);
      try
      {
        String str2 = String.valueOf(paramArrayOfObject[4]);
        localObject = str2;
        l = Long.parseLong(String.valueOf(paramArrayOfObject[5]));
        j = k;
        paramArrayOfObject = str1;
        localObject = str2;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        paramArrayOfObject = str1;
      }
      localNumberFormatException2.printStackTrace();
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      paramArrayOfObject = "";
      i = j;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoObserver", 2, "Data transfer error", localNumberFormatException2);
    }
    long l = -1L;
    j = -3;
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Get data from VideoController, errorCode = %d, seq = %d, url = %s, str = %s, roomId = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramArrayOfObject, localObject, Long.valueOf(l) }));
    }
    a(j, i, paramArrayOfObject, (String)localObject, l);
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
    if (paramObject == null) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    int i = ((Integer)arrayOfObject[0]).intValue();
    String str2;
    if (i != 0) {
      if (i != 47) {
        if (i != 48)
        {
          str2 = null;
          str1 = null;
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
                          switch (i)
                          {
                          default: 
                            return;
                          case 10007: 
                            f();
                            return;
                          case 10006: 
                            a(((Boolean)arrayOfObject[1]).booleanValue());
                            return;
                          case 10005: 
                            a(((Boolean)arrayOfObject[1]).booleanValue(), ((Boolean)arrayOfObject[2]).booleanValue());
                            return;
                          case 10004: 
                            a(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
                            return;
                          case 10003: 
                            a(((Integer)arrayOfObject[1]).intValue());
                            return;
                          case 10002: 
                            a(((Boolean)arrayOfObject[1]).booleanValue(), ((Integer)arrayOfObject[2]).intValue(), (String)arrayOfObject[3], ((Integer)arrayOfObject[4]).intValue());
                            return;
                          }
                          a(((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), ((Long)arrayOfObject[3]).longValue());
                          return;
                        case 525: 
                          f(((Boolean)arrayOfObject[1]).booleanValue());
                          return;
                        case 524: 
                          a((String)arrayOfObject[1], (byte[])arrayOfObject[2]);
                          return;
                        case 523: 
                          a((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue(), (String)arrayOfObject[3]);
                          return;
                        }
                        a((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue(), (String)arrayOfObject[3]);
                        return;
                      case 520: 
                        a(((Integer)arrayOfObject[1]).intValue(), ((Long)arrayOfObject[2]).longValue(), ((Integer)arrayOfObject[3]).intValue());
                        return;
                      case 519: 
                        a(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue(), ((Integer)arrayOfObject[3]).intValue(), ((Long)arrayOfObject[4]).longValue(), ((Integer)arrayOfObject[5]).intValue());
                        return;
                      }
                      a(((Boolean)arrayOfObject[1]).booleanValue(), ((Long)arrayOfObject[2]).longValue(), ((Integer)arrayOfObject[3]).intValue(), ((Integer)arrayOfObject[4]).intValue(), ((Integer)arrayOfObject[5]).intValue(), (String)arrayOfObject[6]);
                      return;
                    case 306: 
                      b(arrayOfObject);
                      return;
                    case 305: 
                      a(arrayOfObject);
                      return;
                    }
                    c(arrayOfObject);
                    return;
                  case 208: 
                    g((String)arrayOfObject[1]);
                    return;
                  case 207: 
                    f((String)arrayOfObject[1]);
                    return;
                  case 206: 
                    e((String)arrayOfObject[1]);
                    return;
                  case 205: 
                    d((String)arrayOfObject[1]);
                    return;
                  case 204: 
                    h();
                    return;
                  }
                  paramObject = (String)arrayOfObject[1];
                  bool = ((Boolean)arrayOfObject[2]).booleanValue();
                  b(SeqUtil.a(arrayOfObject, 3), paramObject, bool);
                  return;
                case 52: 
                  a((byte[])arrayOfObject[2], ((Integer)arrayOfObject[3]).intValue(), ((Integer)arrayOfObject[4]).intValue());
                  return;
                case 51: 
                  l();
                  return;
                }
                e(((Boolean)arrayOfObject[1]).booleanValue());
                return;
              case 44: 
                b(paramObject);
                return;
              case 43: 
                b((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
                return;
              case 42: 
                a((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
                return;
              case 41: 
                a((String)arrayOfObject[1], ((Long)arrayOfObject[2]).longValue(), (byte[])arrayOfObject[3]);
                return;
              case 40: 
                b((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
                return;
              case 39: 
                c(((Integer)arrayOfObject[1]).intValue());
                return;
              case 38: 
                i = ((Integer)arrayOfObject[1]).intValue();
                a(SeqUtil.a(arrayOfObject, 2), i);
                return;
              case 37: 
                k();
                return;
              }
              j();
              return;
            case 34: 
              c(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
              return;
            case 33: 
              bool = ((Boolean)arrayOfObject[2]).booleanValue();
              c((String)arrayOfObject[1], bool);
              return;
            case 32: 
              i = arrayOfObject.length;
              int j = -1;
              if (i > 2)
              {
                j = ((Integer)arrayOfObject[1]).intValue();
                i = ((Integer)arrayOfObject[2]).intValue();
              }
              else
              {
                i = -1;
              }
              a(SeqUtil.a(arrayOfObject, 3), j, i);
              return;
            case 31: 
              a(((Integer)arrayOfObject[1]).intValue(), (String)arrayOfObject[2]);
              return;
            case 30: 
              str2 = (String)arrayOfObject[1];
              paramObject = str1;
            }
            break;
          }
        }
      }
    }
    try
    {
      if (arrayOfObject.length > 2)
      {
        paramObject = str1;
        if (arrayOfObject[2] != null)
        {
          paramObject = str1;
          if ((arrayOfObject[2] instanceof String)) {
            paramObject = (String)arrayOfObject[2];
          }
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        try
        {
          if ((arrayOfObject.length > 1) && (arrayOfObject[1] != null) && ((arrayOfObject[1] instanceof String)))
          {
            paramObject = (String)arrayOfObject[1];
            a(SeqUtil.a(arrayOfObject, 2), paramObject, true);
            return;
            c(((Long)arrayOfObject[1]).longValue());
            return;
            a((String)arrayOfObject[1], (Bitmap)arrayOfObject[2]);
            return;
            c(((Boolean)arrayOfObject[1]).booleanValue());
            return;
            bool = ((Boolean)arrayOfObject[1]).booleanValue();
            a(SeqUtil.a(arrayOfObject, 2), bool);
            return;
            b(((Boolean)arrayOfObject[1]).booleanValue());
            return;
            b(false, ((Boolean)arrayOfObject[1]).booleanValue());
            return;
            b(true, ((Boolean)arrayOfObject[1]).booleanValue());
            return;
            b(((Integer)arrayOfObject[1]).intValue());
            return;
            g();
            return;
            a((String)arrayOfObject[1]);
            return;
            e();
            return;
            d();
            return;
            b(SeqUtil.a(arrayOfObject, 1));
            return;
            c();
            return;
            i = ((Integer)arrayOfObject[1]).intValue();
            paramObject = str2;
            if (arrayOfObject.length > 2) {
              paramObject = (String)arrayOfObject[2];
            }
            a(SeqUtil.a(arrayOfObject, 3), i, paramObject);
            return;
            a(SeqUtil.a(arrayOfObject, 1));
            return;
            a((RecvMsg)arrayOfObject[1]);
            return;
            b();
            return;
            a();
            return;
            d(((Boolean)arrayOfObject[1]).booleanValue());
            return;
            a(((Boolean)arrayOfObject[1]).booleanValue(), (String)arrayOfObject[2], (String)arrayOfObject[3], (String)arrayOfObject[4]);
          }
          return;
        }
        catch (Exception paramObject) {}
        paramObject = paramObject;
        paramObject = str1;
      }
    }
    a(str2, paramObject);
    return;
    i();
    return;
    String str1 = (String)arrayOfObject[1];
    boolean bool = ((Boolean)arrayOfObject[2]).booleanValue();
    paramObject = str1;
    if (TextUtils.isEmpty(str1)) {
      paramObject = "";
    }
    a(paramObject, bool);
    return;
    b((String)arrayOfObject[1]);
    return;
    b(((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), ((Long)arrayOfObject[3]).longValue());
    return;
    c((String)arrayOfObject[1]);
    return;
    a((RecvGVideoLevelInfo[])arrayOfObject[1]);
    return;
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString1, int paramInt, String paramString2) {}
  
  protected void a(String paramString, long paramLong, byte[] paramArrayOfByte) {}
  
  protected void a(String paramString, Bitmap paramBitmap) {}
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(String paramString1, boolean paramBoolean, String paramString2) {}
  
  protected void a(String paramString, byte[] paramArrayOfByte) {}
  
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
  
  protected void d() {}
  
  protected void d(String paramString) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void e() {}
  
  protected void e(String paramString) {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void f() {}
  
  protected void f(String paramString) {}
  
  protected void f(boolean paramBoolean) {}
  
  protected void g() {}
  
  protected void g(String paramString) {}
  
  protected void h() {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.VideoObserver
 * JD-Core Version:    0.7.0.1
 */