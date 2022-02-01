package com.huawei.hms.api;

import java.util.List;

public class ProtocolNegotiate
{
  private static ProtocolNegotiate b = new ProtocolNegotiate();
  private int a = 1;
  
  public static ProtocolNegotiate getInstance()
  {
    return b;
  }
  
  public int getVersion()
  {
    return this.a;
  }
  
  public int negotiate(List<Integer> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (!paramList.contains(Integer.valueOf(2))) {
        this.a = ((Integer)paramList.get(paramList.size() - 1)).intValue();
      } else {
        this.a = 2;
      }
      return this.a;
    }
    this.a = 1;
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.ProtocolNegotiate
 * JD-Core Version:    0.7.0.1
 */