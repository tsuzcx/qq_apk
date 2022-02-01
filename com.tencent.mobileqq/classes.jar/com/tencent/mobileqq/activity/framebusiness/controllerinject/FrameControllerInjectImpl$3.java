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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.a() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FrameControllerInjectImpl", 2, "Mainfragment onLongClick");
      }
      long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b > 0L) && (l < 1000L))
      {
        QLog.d("FrameControllerInjectImpl", 1, "Mainfragment onLongClick interval = [" + l + "], not start multi aio");
        return false;
      }
      paramView = (Conversation)this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.a(Conversation.class);
      if (paramView != null)
      {
        paramView = paramView.a().a();
        if (paramView != null) {
          MultiAIOStarter.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getActivity(), paramView.getRecentUserUin(), paramView.getRecentUserType(), paramView.getTitleName(), "conversation_tab_bottom");
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