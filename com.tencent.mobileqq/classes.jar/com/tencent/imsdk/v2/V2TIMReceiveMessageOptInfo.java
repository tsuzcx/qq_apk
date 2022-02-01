package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;

public class V2TIMReceiveMessageOptInfo
{
  private ReceiveMessageOptInfo ReceiveMessageOptInfo = new ReceiveMessageOptInfo();
  
  public int getC2CReceiveMessageOpt()
  {
    int i = this.ReceiveMessageOptInfo.getC2CReceiveMessageOpt();
    if (i == 1) {
      return 0;
    }
    if (i == 2) {
      return 1;
    }
    if (i == 3) {
      return 2;
    }
    return 0;
  }
  
  public ReceiveMessageOptInfo getReceiveMessageOptInfo()
  {
    return this.ReceiveMessageOptInfo;
  }
  
  public String getUserID()
  {
    return this.ReceiveMessageOptInfo.getUserID();
  }
  
  void setC2CReceiveMessageOpt(int paramInt)
  {
    this.ReceiveMessageOptInfo.setC2CReceiveMessageOpt(paramInt);
  }
  
  public void setUserID(String paramString)
  {
    this.ReceiveMessageOptInfo.setUserID(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMReceiveMessageOptInfo
 * JD-Core Version:    0.7.0.1
 */