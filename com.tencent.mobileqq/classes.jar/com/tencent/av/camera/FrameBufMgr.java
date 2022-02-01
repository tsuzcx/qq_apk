package com.tencent.av.camera;

import com.tencent.qphone.base.util.QLog;

public class FrameBufMgr
{
  static int a;
  private static volatile FrameBufMgr b;
  private FrameBufMgr.FrameBuf[] c = new FrameBufMgr.FrameBuf[4];
  private Object d = new Object();
  
  public static FrameBufMgr a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new FrameBufMgr();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.d;
    int i = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        if (i < this.c.length)
        {
          if (this.c[i].b == paramInt1)
          {
            this.c[i].b = paramInt2;
            j = 1;
          }
        }
        else
        {
          if (j == 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("setFrameBufState failed. oldState = ");
            ((StringBuilder)localObject1).append(paramInt1);
            ((StringBuilder)localObject1).append(", newState = ");
            ((StringBuilder)localObject1).append(paramInt2);
            QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject1).toString());
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = this.d;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.c.length)
        {
          if (this.c[i].a == paramArrayOfByte) {
            this.c[i].b = paramInt;
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setFrameBufState failed. dataBuf = ");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          ((StringBuilder)localObject).append(", state = ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      finally
      {
        continue;
        throw paramArrayOfByte;
        continue;
        i += 1;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init. bufSize = ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.d;
    int i = 0;
    try
    {
      while (i < this.c.length)
      {
        if (this.c[i] == null) {
          this.c[i] = new FrameBufMgr.FrameBuf(this);
        }
        if ((this.c[i].a == null) || (this.c[i].a.length != paramInt)) {
          this.c[i].a = new byte[paramInt];
        }
        this.c[i].b = 0;
        i += 1;
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b()
  {
    QLog.i("FrameBufMgr", 1, "clear.");
    Object localObject1 = this.d;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.c.length)
        {
          if (this.c[i] != null)
          {
            this.c[i].a = null;
            this.c[i].b = 0;
          }
        }
        else {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public byte[] b(int paramInt)
  {
    Object localObject1 = this.d;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.c.length)
        {
          if (this.c[i].b == paramInt)
          {
            byte[] arrayOfByte = this.c[i].a;
            return arrayOfByte;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getFrameBufByState failed. state = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public int c()
  {
    return this.c.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.FrameBufMgr
 * JD-Core Version:    0.7.0.1
 */