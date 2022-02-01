package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class ChatPieSelectableHelper
  implements ILifeCycleHelper, OnSelectListener
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(50.0F);
  private static int jdField_b_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  private int e = -1;
  
  public ChatPieSelectableHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramBaseChatPie.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  public void a()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.c()) {
      localAIOSelectableDelegateImpl.d();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((!localAIOSelectableDelegateImpl.c()) || (!this.jdField_b_of_type_Boolean)) {}
    int i;
    label102:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          return;
          i = paramMotionEvent.getAction();
          j = (int)paramMotionEvent.getRawX();
          k = (int)paramMotionEvent.getRawY();
          if (i == 0)
          {
            if (!localAIOSelectableDelegateImpl.a(j, k))
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
              if (!this.jdField_a_of_type_Boolean) {
                break label102;
              }
              this.d = j;
            }
            for (this.e = k;; this.e = -1)
            {
              this.c = 0;
              return;
              bool = false;
              break;
              this.d = -1;
            }
          }
          if (i != 2) {
            break;
          }
        } while ((!this.jdField_a_of_type_Boolean) || (Math.pow(this.d - j, 2.0D) + Math.pow(this.e - k, 2.0D) <= jdField_b_of_type_Int));
        this.c = 2;
      } while (!QLog.isColorLevel());
      QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
      return;
    } while (((i != 1) && (i != 3)) || (!this.jdField_a_of_type_Boolean));
    if (this.c == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
      }
      long l = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localAIOSelectableDelegateImpl.d();
      }
    }
    for (;;)
    {
      this.c = 1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localAIOSelectableDelegateImpl.d();
    }
  }
  
  public void a(@NonNull SelectableDelegate paramSelectableDelegate)
  {
    boolean bool = paramSelectableDelegate.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof MultiForwardChatPie)) {}
    for (paramSelectableDelegate = ((MultiForwardChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();; paramSelectableDelegate = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView)
    {
      if (paramSelectableDelegate != null) {
        paramSelectableDelegate.requestDisallowInterceptTouchEvent(bool);
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (AIOSelectableDelegateImpl.a().c())
    {
      AIOSelectableDelegateImpl.a().d();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
    {
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.jdField_a_of_type_Int = 1;
      }
    }
    else {
      return;
    }
    if ("2101".equals(ThemeUtil.getCurrentThemeId()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.jdField_a_of_type_Int = 0;
  }
  
  public boolean b()
  {
    return AIOSelectableDelegateImpl.a().c();
  }
  
  public String getTag()
  {
    return "ChatPieSelectableHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10, 13, 17, 15, 16 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl;
    do
    {
      View localView;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
              localAIOSelectableDelegateImpl.a(this);
              this.jdField_b_of_type_Boolean = true;
            } while ((!localAIOSelectableDelegateImpl.c()) || (localAIOSelectableDelegateImpl.a()));
            localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
            return;
            AIOSelectableDelegateImpl.a().b(this);
            this.jdField_b_of_type_Boolean = false;
            return;
            localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
          } while (!localAIOSelectableDelegateImpl.c());
          localAIOSelectableDelegateImpl.d();
          return;
          localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
        } while ((!localAIOSelectableDelegateImpl.c()) || (localAIOSelectableDelegateImpl.a()));
        localView = localAIOSelectableDelegateImpl.a();
      } while (localView == null);
      localView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < jdField_a_of_type_Int + ImmersiveUtils.statusHeight)
      {
        localAIOSelectableDelegateImpl.d();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0))
      {
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        if (paramInt > this.jdField_a_of_type_ArrayOfInt[1])
        {
          localAIOSelectableDelegateImpl.d();
          return;
        }
        localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        return;
      }
      localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      return;
      localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    } while ((!localAIOSelectableDelegateImpl.c()) || (!localAIOSelectableDelegateImpl.a()));
    localAIOSelectableDelegateImpl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper
 * JD-Core Version:    0.7.0.1
 */