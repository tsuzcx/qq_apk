package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.helper.TopGestureTouchEventListener;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class ChatPieSelectableHelper
  implements OnFinishListener, TopGestureTouchEventListener, ILifeCycleHelper, PanelListener, OnSelectListener
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
    paramBaseChatPie.b().a().a(this);
    paramBaseChatPie.b().a().a(this);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    if (b()) {
      return 2;
    }
    return 0;
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
    b(paramMotionEvent);
  }
  
  public void a(@NonNull SelectableDelegate paramSelectableDelegate)
  {
    boolean bool = paramSelectableDelegate.c();
    paramSelectableDelegate = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((paramSelectableDelegate instanceof MultiForwardChatPie)) {
      paramSelectableDelegate = ((MultiForwardChatPie)paramSelectableDelegate).a();
    } else {
      paramSelectableDelegate = paramSelectableDelegate.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    }
    if (paramSelectableDelegate != null) {
      paramSelectableDelegate.requestDisallowInterceptTouchEvent(bool);
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
  
  public boolean a(int paramInt)
  {
    return (paramInt == 0) && (a());
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
    {
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.jdField_a_of_type_Int = 1;
        return;
      }
      if ("2101".equals(ThemeUtil.getCurrentThemeId()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.jdField_a_of_type_Int = 2;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.jdField_a_of_type_Int = 0;
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.c())
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getRawX();
      int k = (int)paramMotionEvent.getRawY();
      if (i == 0)
      {
        this.jdField_a_of_type_Boolean = (localAIOSelectableDelegateImpl.a(j, k) ^ true);
        this.jdField_a_of_type_Long = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Boolean)
        {
          this.d = j;
          this.e = k;
        }
        else
        {
          this.d = -1;
          this.e = -1;
        }
        this.c = 0;
        return;
      }
      if (i == 2)
      {
        if ((this.jdField_a_of_type_Boolean) && (Math.pow(this.d - j, 2.0D) + Math.pow(this.e - k, 2.0D) > jdField_b_of_type_Int))
        {
          this.c = 2;
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
          }
        }
      }
      else if (((i == 1) || (i == 3)) && (this.jdField_a_of_type_Boolean))
      {
        if (this.c == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
          }
          long l1 = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
          long l2 = this.jdField_a_of_type_Long;
          if ((l2 != -1L) && (l1 != -1L))
          {
            if (l2 == l1) {
              localAIOSelectableDelegateImpl.d();
            }
          }
          else {
            localAIOSelectableDelegateImpl.d();
          }
        }
        this.c = 1;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Long = -1L;
      }
    }
  }
  
  public boolean b()
  {
    return AIOSelectableDelegateImpl.a().c();
  }
  
  public void d(int paramInt) {}
  
  public String getTag()
  {
    return "ChatPieSelectableHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 11, 14, 18, 16, 17, 22, 0 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      AIOSelectableDelegateImpl localAIOSelectableDelegateImpl;
      if (paramInt != 7)
      {
        if (paramInt != 11)
        {
          if (paramInt != 14)
          {
            if (paramInt != 22) {
              switch (paramInt)
              {
              default: 
                return;
              case 18: 
                localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
                if ((!localAIOSelectableDelegateImpl.c()) || (localAIOSelectableDelegateImpl.a())) {
                  break;
                }
                View localView = localAIOSelectableDelegateImpl.a();
                if (localView == null) {
                  break;
                }
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
              case 16: 
              case 17: 
                localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
                if ((!localAIOSelectableDelegateImpl.c()) || (!localAIOSelectableDelegateImpl.a())) {
                  break;
                }
                localAIOSelectableDelegateImpl.b();
                return;
              }
            }
          }
          else
          {
            localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
            if (!localAIOSelectableDelegateImpl.c()) {
              return;
            }
            localAIOSelectableDelegateImpl.d();
          }
        }
        else
        {
          AIOSelectableDelegateImpl.a().b(this);
          this.jdField_b_of_type_Boolean = false;
        }
      }
      else
      {
        localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
        localAIOSelectableDelegateImpl.a(this);
        this.jdField_b_of_type_Boolean = true;
        if ((!localAIOSelectableDelegateImpl.c()) || (localAIOSelectableDelegateImpl.a())) {
          return;
        }
        localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        return;
      }
    }
    b();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    a();
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper
 * JD-Core Version:    0.7.0.1
 */