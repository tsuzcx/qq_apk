package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ark.open.ArkView;
import com.tencent.widget.XPanelContainer;

class LimitChatPie$11
  implements Runnable
{
  LimitChatPie$11(LimitChatPie paramLimitChatPie) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.isFinishing())) {}
    XPanelContainer localXPanelContainer;
    View localView;
    do
    {
      return;
      localXPanelContainer = this.this$0.a();
      localView = localXPanelContainer.findViewById(2131363017);
    } while (localView == null);
    localXPanelContainer.removeView(localView);
    LimitChatPie.a(this.this$0, (ArkView)localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.11
 * JD-Core Version:    0.7.0.1
 */