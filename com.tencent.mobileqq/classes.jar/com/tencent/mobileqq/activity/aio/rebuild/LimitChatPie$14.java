package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.XPanelContainer;

class LimitChatPie$14
  implements Runnable
{
  LimitChatPie$14(LimitChatPie paramLimitChatPie) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.isFinishing())) {
      return;
    }
    XPanelContainer localXPanelContainer = this.this$0.a();
    View localView = localXPanelContainer.findViewById(2131362965);
    if (localView != null)
    {
      localXPanelContainer.removeView(localView);
      LimitChatPie.a(this.this$0, (ArkView)localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.14
 * JD-Core Version:    0.7.0.1
 */