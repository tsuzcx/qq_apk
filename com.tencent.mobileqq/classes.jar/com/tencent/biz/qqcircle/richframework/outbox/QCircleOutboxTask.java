package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.qphone.base.util.QLog;

public abstract class QCircleOutboxTask
  implements IQueueTask
{
  @NeedParcel
  protected final long a = System.nanoTime();
  @NeedParcel
  public long b = 0L;
  @NeedParcel
  public int c = 0;
  @NeedParcel
  public int d;
  @NeedParcel
  public byte[] e = null;
  @NeedParcel
  public long[] f = null;
  @NeedParcel
  public long g;
  @NeedParcel
  public String h;
  public QCircleOutboxTask.OutboxListener i;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    QCircleOutboxTask.OutboxListener localOutboxListener = this.i;
    if (localOutboxListener != null) {
      localOutboxListener.a(this.d, paramInt);
    }
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(o());
      paramString1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" id:");
      localStringBuilder.append(a());
      localStringBuilder.append(" ,state:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" ,resultCode:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" ,errMsg:");
      localStringBuilder.append(this.h);
      QLog.e(paramString1, 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(o());
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" id:");
    localStringBuilder.append(a());
    localStringBuilder.append(" ,state:");
    localStringBuilder.append(this.d);
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void c() {}
  
  public void d()
  {
    this.c += 1;
  }
  
  public void e() {}
  
  public void f() {}
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public long h()
  {
    return this.b;
  }
  
  public long i()
  {
    return this.g;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public int l()
  {
    return this.c;
  }
  
  public long[] m()
  {
    return this.f;
  }
  
  public String n()
  {
    return null;
  }
  
  protected abstract String o();
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTask
 * JD-Core Version:    0.7.0.1
 */