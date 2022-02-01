package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageReceipt;

public class V2TIMMessageReceipt
{
  private MessageReceipt messageReceipt;
  
  public long getTimestamp()
  {
    MessageReceipt localMessageReceipt = this.messageReceipt;
    if (localMessageReceipt != null) {
      return localMessageReceipt.getReceiptTimestamp();
    }
    return 0L;
  }
  
  public String getUserID()
  {
    MessageReceipt localMessageReceipt = this.messageReceipt;
    if (localMessageReceipt != null) {
      return localMessageReceipt.getUserID();
    }
    return null;
  }
  
  protected void setMessageReceipt(MessageReceipt paramMessageReceipt)
  {
    this.messageReceipt = paramMessageReceipt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageReceipt
 * JD-Core Version:    0.7.0.1
 */