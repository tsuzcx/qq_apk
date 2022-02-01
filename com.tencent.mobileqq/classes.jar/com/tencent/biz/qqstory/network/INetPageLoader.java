package com.tencent.biz.qqstory.network;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class INetPageLoader
{
  public long a;
  public String a;
  protected AtomicBoolean a;
  public boolean a;
  public long b;
  public boolean b;
  
  public INetPageLoader()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    long l2 = System.currentTimeMillis();
    long l1 = this.b - this.jdField_a_of_type_Long;
    l2 -= this.b;
    SLog.c(paramString, "page network respond times " + l1);
    SLog.c(paramString, "page db times " + l2);
  }
  
  public void b()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.INetPageLoader
 * JD-Core Version:    0.7.0.1
 */