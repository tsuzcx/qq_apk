package com.tencent.biz.qqstory.network;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class INetPageLoader
{
  public boolean a;
  public long b;
  public long c;
  public String d = null;
  public boolean e;
  protected AtomicBoolean f = new AtomicBoolean(false);
  
  public void a()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    this.a = false;
  }
  
  public void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    long l3 = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("page network respond times ");
    localStringBuilder.append(l2 - l3);
    SLog.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("page db times ");
    localStringBuilder.append(l1 - l2);
    SLog.c(paramString, localStringBuilder.toString());
  }
  
  public void b()
  {
    this.c = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.INetPageLoader
 * JD-Core Version:    0.7.0.1
 */