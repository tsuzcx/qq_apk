package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import com.tencent.mobileqq.data.MessageRecord;

public class QQReminderOrderModel
{
  public long a;
  public AcsMsg a;
  public MessageRecord a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQReminderOrderModel{messageRecord=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    localStringBuilder.append(", acsMsg=");
    localStringBuilder.append(this.jdField_a_of_type_WalletAcsMsg);
    localStringBuilder.append(", orderTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.QQReminderOrderModel
 * JD-Core Version:    0.7.0.1
 */