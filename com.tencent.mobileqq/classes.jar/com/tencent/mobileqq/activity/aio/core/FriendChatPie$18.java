package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;

class FriendChatPie$18
  implements View.OnTouchListener
{
  long jdField_a_of_type_Long = 0L;
  
  FriendChatPie$18(FriendChatPie paramFriendChatPie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.z)
    {
      if (!(paramView instanceof ImageView)) {
        return false;
      }
      Object localObject = (ImageView)paramView;
      int i = paramMotionEvent.getAction();
      localObject = null;
      paramMotionEvent = (MotionEvent)localObject;
      if (paramView.getTag() != null)
      {
        paramMotionEvent = (MotionEvent)localObject;
        if ((paramView.getTag() instanceof MutualMarkForDisplayInfo)) {
          paramMotionEvent = (MutualMarkForDisplayInfo)paramView.getTag();
        }
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3) {
            return true;
          }
          if (paramMotionEvent != null)
          {
            paramView.setAlpha(paramMotionEvent.a());
            return true;
          }
          paramView.setAlpha(1.0F);
          return true;
        }
        if (paramMotionEvent != null) {
          paramView.setAlpha(paramMotionEvent.a());
        } else {
          paramView.setAlpha(1.0F);
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 800L) {
          return true;
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        localObject = MutualMarkConfProcessor.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        MutualMarkBusinessLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramMotionEvent);
        paramView.putExtra("url", (String)localObject);
        paramView.putExtra("finish_animation_out_to_right", true);
        paramView.putExtra("is_wrap_content", true);
        paramView.putExtra("hide_left_button", false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
          return true;
        }
      }
      else
      {
        if (paramMotionEvent != null)
        {
          paramView.setAlpha(paramMotionEvent.a() * 0.5F);
          return true;
        }
        paramView.setAlpha(0.5F);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.18
 * JD-Core Version:    0.7.0.1
 */