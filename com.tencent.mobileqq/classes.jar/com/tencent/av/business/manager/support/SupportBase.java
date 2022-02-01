package com.tencent.av.business.manager.support;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public abstract class SupportBase
{
  protected int a;
  protected long a;
  protected VideoAppInterface a;
  protected String a;
  protected int b;
  protected long b;
  
  public SupportBase(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public abstract int a(String paramString);
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = Build.MODEL.toLowerCase();
    this.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
    this.jdField_a_of_type_Long = VcSystemInfo.getMaxCpuFreq();
    this.jdField_b_of_type_Int = VcSystemInfo.getNumCores();
    this.jdField_b_of_type_Long = DeviceInfoUtil.a();
  }
  
  public abstract boolean a(int paramInt, String paramString);
  
  public abstract boolean a(String paramString);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportBase
 * JD-Core Version:    0.7.0.1
 */