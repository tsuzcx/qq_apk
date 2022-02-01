package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.multiaio.MultiAIOStarter;
import com.tencent.qphone.base.util.QLog;

class FrameControllerInjectImpl$3
  implements View.OnLongClickListener
{
  FrameControllerInjectImpl$3(FrameControllerInjectImpl paramFrameControllerInjectImpl, FrameFragment paramFrameFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.w() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FrameControllerInjectImpl", 2, "Mainfragment onLongClick");
      }
      long l = SystemClock.uptimeMillis() - this.a.S;
      if ((this.a.S > 0L) && (l < 1000L))
      {
        paramView = new StringBuilder();
        paramView.append("Mainfragment onLongClick interval = [");
        paramView.append(l);
        paramView.append("], not start multi aio");
        QLog.d("FrameControllerInjectImpl", 1, paramView.toString());
        return false;
      }
      paramView = (Conversation)this.a.a(Conversation.class);
      if (paramView != null)
      {
        paramView = paramView.K().k();
        if (paramView != null) {
          MultiAIOStarter.a(this.a.C(), paramView.getRecentUserUin(), paramView.getRecentUserType(), paramView.getTitleName(), "conversation_tab_bottom");
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl.3
 * JD-Core Version:    0.7.0.1
 */