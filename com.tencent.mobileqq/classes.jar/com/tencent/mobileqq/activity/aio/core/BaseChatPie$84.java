package com.tencent.mobileqq.activity.aio.core;

import afyb;
import agkg;
import ahpt;
import bhdj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

class BaseChatPie$84
  implements QQPermissionCallback
{
  BaseChatPie$84(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.this$0.getActivity());
    ((agkg)this.this$0.getHelper(29)).b(2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    afyb.a().a(this.this$0.mContext);
    this.this$0.root.a(2);
    ahpt.a(this.this$0.app, "0X8005CAC", this.this$0.sessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.84
 * JD-Core Version:    0.7.0.1
 */