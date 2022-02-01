package com.tencent.ilivesdk.domain.usecase;

public class GetLinkMicUserInfoCase$RequestValue
{
  public String linkMicId;
  public long roomId;
  
  public GetLinkMicUserInfoCase$RequestValue(long paramLong, String paramString)
  {
    this.roomId = paramLong;
    this.linkMicId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetLinkMicUserInfoCase.RequestValue
 * JD-Core Version:    0.7.0.1
 */