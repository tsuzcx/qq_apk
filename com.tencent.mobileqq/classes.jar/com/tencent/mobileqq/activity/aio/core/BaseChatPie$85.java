package com.tencent.mobileqq.activity.aio.core;

import afgw;
import afss;
import agwt;
import bfur;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

class BaseChatPie$85
  implements QQPermissionCallback
{
  BaseChatPie$85(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(this.this$0.getActivity());
    ((afss)this.this$0.getHelper(29)).b(2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    afgw.a().a(this.this$0.mContext);
    this.this$0.root.a(2);
    agwt.a(this.this$0.app, "0X8005CAC", this.this$0.sessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.85
 * JD-Core Version:    0.7.0.1
 */