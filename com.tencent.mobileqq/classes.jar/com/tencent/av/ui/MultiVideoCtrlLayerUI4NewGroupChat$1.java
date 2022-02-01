package com.tencent.av.ui;

import com.tencent.mobileqq.utils.QAVGroupConfig.GroupInviteFlag;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUI4NewGroupChat$1
  extends ControlUIObserver
{
  MultiVideoCtrlLayerUI4NewGroupChat$1(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(QAVGroupConfig.GroupInviteFlag paramGroupInviteFlag)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != paramGroupInviteFlag.a))
    {
      String str = this.a.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[");
      localStringBuilder.append(this.a.a);
      localStringBuilder.append("->");
      localStringBuilder.append(paramGroupInviteFlag.a);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.a.a != paramGroupInviteFlag.a)
    {
      this.a.a = paramGroupInviteFlag.a;
      this.a.i(0L, 16777215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.1
 * JD-Core Version:    0.7.0.1
 */