package com.tencent.beacon.core.c;

public abstract interface j
{
  public abstract String getEventSerialNumber(String paramString);
  
  public abstract void incCommonEventCalls();
  
  public abstract void incCommonEventWriteSucc(int paramInt);
  
  public abstract void incRealTimeEventCalls();
  
  public abstract void incRealTimeEventUploadSucc(int paramInt);
  
  public abstract void incRealTimeEventWriteSucc(int paramInt);
  
  public abstract void record(int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.c.j
 * JD-Core Version:    0.7.0.1
 */