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
      paramMessage.append(GroupManagerActivity.i(this.a));
      QLog.d("GroupManagerActivity", 2, paramMessage.toString());
    }
    GroupManagerActivity.b(this.a, true);
    if (GroupManagerActivity.i(this.a))
    {
      this.a.a(true);
      return;
    }
    paramMessage = GroupManagerActivity.j(this.a).obtainMessage(0);
    GroupManagerActivity.j(this.a).sendMessageDelayed(paramMessage, 60000L);
    GroupManagerActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.11
 * JD-Core Version:    0.7.0.1
 */