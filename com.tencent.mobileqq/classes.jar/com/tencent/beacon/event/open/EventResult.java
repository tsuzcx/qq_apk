package com.tencent.beacon.event.open;

public final class EventResult
{
  public static final int ERROR_CODE_NAME_NULL = 106;
  public static final int ERROR_CODE_NOT_ENABLE = 102;
  public static final int ERROR_CODE_OFFER_FAIL = 103;
  public static final int ERROR_CODE_OTHER = 199;
  public static final int ERROR_CODE_PREVENT = 100;
  public static final int ERROR_CODE_SAMPLE = 101;
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final int ERROR_PARAMS_LONG = 105;
  public String errMsg;
  public int errorCode;
  public long eventID;
  
  public EventResult(int paramInt, long paramLong, String paramString)
  {
    this.errorCode = paramInt;
    this.eventID = paramLong;
    this.errMsg = paramString;
  }
  
  public boolean isSuccess()
  {
    return this.errorCode == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.EventResult
 * JD-Core Version:    0.7.0.1
 */