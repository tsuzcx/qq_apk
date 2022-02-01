package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import bjvd;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import mqq.os.MqqHandler;

class BaseChatPie$2
  implements bjvd
{
  BaseChatPie$2(BaseChatPie paramBaseChatPie) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((this.this$0.mContext == null) || (this.this$0.uiHandler == null)) {
      return;
    }
    paramInt2 = this.this$0.mContext.getResources().getDimensionPixelSize(2131298111);
    paramInt1 = 0;
    if (paramInt5 > paramInt3) {
      paramInt1 = this.this$0.mContext.getResources().getDimensionPixelSize(2131298112) + paramInt5 - paramInt3;
    }
    paramInt2 = Math.max(paramInt2, paramInt1);
    paramInt1 = paramInt2;
    if (this.this$0.panelicons != null)
    {
      paramInt1 = paramInt2;
      if (this.this$0.panelicons.getVisibility() == 0) {
        paramInt1 = paramInt2 + this.this$0.panelicons.getHeight();
      }
    }
    if (this.this$0.loadSearchedMessage)
    {
      this.this$0.uiHandler.sendMessageDelayed(this.this$0.uiHandler.obtainMessage(54, paramInt1, paramInt4), 10L);
      return;
    }
    this.this$0.uiHandler.sendMessage(this.this$0.uiHandler.obtainMessage(54, paramInt1, paramInt4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.2
 * JD-Core Version:    0.7.0.1
 */