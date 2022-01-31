package com.tencent.component.network.module.common;

import android.text.TextUtils;

public class DnsService$IpRecord
{
  public long a;
  public String a;
  
  public DnsService$IpRecord(DnsService paramDnsService, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    return (l >= 0L) && (l <= 3600000L) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.DnsService.IpRecord
 * JD-Core Version:    0.7.0.1
 */