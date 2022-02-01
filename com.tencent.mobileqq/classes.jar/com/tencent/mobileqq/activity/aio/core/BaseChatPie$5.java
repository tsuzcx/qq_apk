package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper;
import com.tencent.mobileqq.bubble.ChatXListView;

class BaseChatPie$5
  implements View.OnLayoutChangeListener
{
  BaseChatPie$5(BaseChatPie paramBaseChatPie) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    paramInt3 = 0;
    paramView = (TroopRobotHelper)this.a.a(23);
    if ((paramView != null) && (paramView.b()))
    {
      paramInt3 = paramView.a();
      paramInt1 += paramInt3;
    }
    for (;;)
    {
      paramView = (ShortcutBarAIOHelper)this.a.a(52);
      if ((paramView != null) && (paramView.b()) && (paramInt3 == 0))
      {
        paramInt7 = AIOUtils.a(39.0F, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        paramInt5 = paramInt1 + paramInt7;
      }
      for (paramInt1 = paramInt7;; paramInt1 = paramInt7)
      {
        if ((paramInt6 - paramInt2 != 0) && (paramView != null)) {
          paramView.g();
        }
        BaseChatPie.a(this.a, paramInt5);
        if (!BaseChatPie.a(this.a, paramInt2, paramInt4, paramInt6, paramInt8)) {
          break label156;
        }
        label156:
        while (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() <= 0) {
          return;
        }
        paramInt8 = paramInt2 - paramInt3 - paramInt1;
        paramInt6 = -1;
        paramInt7 = 0;
        paramInt4 = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
        for (;;)
        {
          paramInt5 = paramInt7;
          paramInt2 = paramInt6;
          if (paramInt4 >= 0)
          {
            View localView = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt4);
            if ((paramInt8 > localView.getTop()) && (paramInt8 <= localView.getBottom()))
            {
              paramInt2 = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() + paramInt4;
              paramInt5 = paramInt8 - localView.getBottom();
            }
          }
          else
          {
            if (paramInt2 != -1) {
              break label310;
            }
            if ((paramView == null) || (paramView.c()) || (!paramView.b()) || (paramInt3 != 0)) {
              break;
            }
            paramView.f();
            return;
          }
          paramInt4 -= 1;
        }
        label310:
        this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnMeasureListener(new BaseChatPie.5.1(this, paramView, paramInt3, paramInt2, paramInt1 + (paramInt5 + paramInt3)));
        return;
        paramInt7 = 0;
        paramInt5 = paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.5
 * JD-Core Version:    0.7.0.1
 */