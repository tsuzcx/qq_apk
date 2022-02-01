package com.qq.ac.sdk.api;

public enum AcType$UidType
{
  OTHER(0),  QQ(1),  WEIXIN(2);
  
  private int mType;
  
  private AcType$UidType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  final String getString()
  {
    return String.valueOf(this.mType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.ac.sdk.api.AcType.UidType
 * JD-Core Version:    0.7.0.1
 */