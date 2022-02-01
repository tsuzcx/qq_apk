package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class GroupManagerActivity$11
  extends Handler
{
  GroupManagerActivity$11(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("mWaitingDialogControlHandler operationFinished = ");
      paramMessage.append(GroupManagerActivity.b(this.a));
      QLog.d("GroupManagerActivity", 2, paramMessage.toString());
    }
    GroupManagerActivity.b(this.a, true);
    if (GroupManagerActivity.b(this.a))
    {
      this.a.a(true);
      return;
    }
    paramMessage = GroupManagerActivity.a(this.a).obtainMessage(0);
    GroupManagerActivity.a(this.a).sendMessageDelayed(paramMessage, 60000L);
    GroupManagerActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.11
 * JD-Core Version:    0.7.0.1
 */