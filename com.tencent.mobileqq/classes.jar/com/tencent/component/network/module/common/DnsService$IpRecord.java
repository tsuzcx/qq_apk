package com.tencent.component.network.module.common;

import android.text.TextUtils;

public class DnsService$IpRecord
{
  public long createTime;
  public String ip;
  
  public DnsService$IpRecord(DnsService paramDnsService, String paramString, long paramLong)
  {
    this.ip = paramString;
    this.createTime = paramLong;
  }
  
  public boolean isValid()
  {
    long l = System.currentTimeMillis() - this.createTime;
    return (l >= 0L) && (l <= 3600000L) && (!TextUtils.isEmpty(this.ip));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.DnsService.IpRecord
 * JD-Core Version:    0.7.0.1
 */