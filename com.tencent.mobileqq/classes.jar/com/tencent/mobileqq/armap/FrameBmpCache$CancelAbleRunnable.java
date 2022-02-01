package com.tencent.mobileqq.armap;

import android.support.v4.util.MQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FrameBmpCache$CancelAbleRunnable
  implements Runnable
{
  public int a;
  volatile boolean b = false;
  
  public FrameBmpCache$CancelAbleRunnable(FrameBmpCache paramFrameBmpCache, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameBmpCache", 2, "cancel");
    }
    this.b = true;
  }
  
  public void run()
  {
    if (!this.b) {}
    try
    {
      ??? = (String)this.this$0.e.get(FrameBmpCache.a(this.this$0, this.a));
      Object localObject2;
      if (this.this$0.a.get(???) == null)
      {
        localObject2 = FrameBmpCache.a(this.this$0, (String)???);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeBitmap, index=");
          localStringBuilder.append(this.a);
          localStringBuilder.append(", not in cache:");
          localStringBuilder.append((String)???);
          localStringBuilder.append(", after decode=");
          localStringBuilder.append(localObject2);
          QLog.i("FrameBmpCache", 2, localStringBuilder.toString());
        }
        this.this$0.a.put(???, localObject2);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("decodeBitmap, index=");
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(", is in cache:");
        ((StringBuilder)localObject2).append((String)???);
        QLog.i("FrameBmpCache", 2, ((StringBuilder)localObject2).toString());
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label221;
    }
    catch (Throwable localThrowable)
    {
      label195:
      break label195;
    }
    FrameBmpCache.b(this.this$0, 2);
    if (QLog.isColorLevel())
    {
      QLog.d("FrameBmpCache", 2, "decodeBitmap,Throwable e");
      break label270;
      label221:
      FrameBmpCache.b(this.this$0, 1);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("decodeBitmap,OutOfMemory Error index:");
        ((StringBuilder)???).append(this.a);
        QLog.d("FrameBmpCache", 2, ((StringBuilder)???).toString());
      }
    }
    label270:
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("decode end......");
      ((StringBuilder)???).append(this.a);
      QLog.i("FrameBmpCache", 2, ((StringBuilder)???).toString());
    }
    if (!this.b) {
      synchronized (this.this$0.i)
      {
        FrameBmpCache.a(this.this$0);
        return;
      }
    }
  }
  
  public String toString()
  {
    return Integer.toString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.FrameBmpCache.CancelAbleRunnable
 * JD-Core Version:    0.7.0.1
 */