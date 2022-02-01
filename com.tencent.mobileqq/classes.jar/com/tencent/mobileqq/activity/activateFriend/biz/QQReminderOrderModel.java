package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import com.tencent.mobileqq.data.MessageRecord;

public class QQReminderOrderModel
{
  public MessageRecord a;
  public AcsMsg b;
  public long c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQReminderOrderModel{messageRecord=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", acsMsg=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", orderTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.QQReminderOrderModel
 * JD-Core Version:    0.7.0.1
 */