package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectTouchBarView;
import com.tencent.widget.ListView;
import java.util.List;

public class SelectToBottomHelper
  implements ILifeCycleHelper
{
  private int jdField_a_of_type_Int = 0;
  private ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private SelectTouchBarView jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  
  public SelectToBottomHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentWidgetListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_a_of_type_AndroidWidgetListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    }
  }
  
  private int a()
  {
    c();
    int k = -1;
    int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (a(i)) {
          j = i + m - 1;
        }
      }
      else
      {
        QLog.d("SelectToBottomHelper", 3, "Real last visible index is: " + j);
        return j;
      }
      i -= 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = MultiMsgManager.a();
    int i = paramInt1;
    if (i <= paramInt2)
    {
      ChatMessage localChatMessage;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((MultiMsgManager)localObject).a(localChatMessage) != paramBoolean) {
          break label69;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label69:
        if ((MultiMsgUtil.c(localChatMessage)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
        {
          int j = MultiMsgManager.a().a();
          if ((paramBoolean) && (MultiMsgManager.a().a(localChatMessage, j)))
          {
            if (MultiMsgManager.a().jdField_a_of_type_Int == 7) {}
            for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131698463, new Object[] { Integer.valueOf(j) });; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131698462, new Object[] { Integer.valueOf(j) }))
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject, 0).a();
              return;
            }
          }
          ((MultiMsgManager)localObject).a(localChatMessage, paramBoolean);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(localChatMessage, null, paramBoolean);
          ((ChatAdapter1)this.jdField_a_of_type_AndroidWidgetListAdapter).notifyDataSetChanged();
        }
      }
    }
    QLog.d("SelectToBottomHelper", 3, "item index: " + paramInt1 + " to " + paramInt2 + " Perform select");
  }
  
  private void a(View paramView)
  {
    int i = 1;
    c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null)) {}
    do
    {
      do
      {
        return;
        c();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        if (MultiMsgManager.a().c() == 0) {
          QQToast.a(paramView.getContext(), HardCodeUtil.a(2131713720), 0).a();
        }
        j = b();
        m = c();
        k = a();
      } while ((k < 0) || (j < 0) || (m < 0) || (k < j));
      int m = k + 1;
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1;
      if ((m < this.jdField_a_of_type_ComTencentWidgetListView.getCount()) && (m <= n)) {
        a(m, n, false);
      }
      a(j, k);
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    int j = MultiMsgManager.a().c();
    int k = Integer.valueOf(ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).intValue();
    if (k == 0) {}
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", "", "0X800A510", "0X800A510", i, j, "", "", "", "");
      return;
      if (k == 1) {
        i = 3;
      } else if (k == 3) {
        i = 2;
      } else if (k == 2) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
  
  private boolean a()
  {
    int i = b();
    int j = c();
    int k = a();
    if ((k < 0) || (i < 0) || (j < 0)) {}
    while (k < i) {
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt)
  {
    c();
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (paramInt < 0) || (paramInt > this.jdField_a_of_type_ComTencentWidgetListView.getCount()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView == null)) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt);
    int i = ((View)localObject).getTop();
    paramInt = i;
    if ((localObject instanceof BaseChatItemLayout)) {
      paramInt = ((BaseChatItemLayout)localObject).a.getTop() + i;
    }
    localObject = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.findViewById(2131362527);
    i = this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.getTop();
    return paramInt < ((RelativeLayout)localObject).getHeight() / 2 + i;
  }
  
  private int b()
  {
    c();
    MultiMsgManager localMultiMsgManager = MultiMsgManager.a();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!localMultiMsgManager.a(localChatMessage)) || (!MultiMsgUtil.c(localChatMessage))) {}
    }
    for (;;)
    {
      QLog.d("SelectToBottomHelper", 3, "First selected index is: " + i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private int c()
  {
    c();
    MultiMsgManager localMultiMsgManager = MultiMsgManager.a();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    if (i >= 0)
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!localMultiMsgManager.a(localChatMessage)) || (!MultiMsgUtil.c(localChatMessage))) {}
    }
    for (;;)
    {
      QLog.d("SelectToBottomHelper", 3, "Last selected index is: " + i);
      return i;
      i -= 1;
      break;
      i = -1;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      this.jdField_a_of_type_AndroidWidgetListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
      if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView != null)
    {
      if ((paramInt != 0) && ((this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.getMeasuredHeight() == 0) || (a()))) {
        break label46;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setCheckedNum(paramInt);
      return;
      label46:
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(0);
    }
  }
  
  public void a(LinearLayout paramLinearLayout, int paramInt, RelativeLayout paramRelativeLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView = new SelectTouchBarView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, paramInt);
      localLayoutParams.addRule(2, paramLinearLayout.getId());
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.a(HardCodeUtil.a(2131713719)).a(paramInt).a();
      paramRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setId(2131362526);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setOnClickListener(new SelectToBottomHelper.1(this));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    c();
    int i;
    int j;
    if (paramInt == 17)
    {
      i = a();
      j = b();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView != null) && (j >= 0)) {}
    }
    else
    {
      return;
    }
    paramInt = i;
    if (this.jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilList.size())
    {
      paramInt = i + (this.jdField_a_of_type_JavaUtilList.size() - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    }
    if (paramInt < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(0);
  }
  
  public String getTag()
  {
    return "SelectToBottomHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 17, 19 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("SelectToBottomHelper", 1, "onResume");
              }
            } while (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView == null);
            this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.a();
          } while (!QLog.isColorLevel());
          QLog.d("SelectToBottomHelper", 1, "onResume->updateDotLine");
          return;
          b(paramInt);
        } while (!QLog.isColorLevel());
        QLog.d("SelectToBottomHelper", 1, "onScrollStateIdle");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView == null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.a();
    } while (!QLog.isColorLevel());
    QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged->updateDotLine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper
 * JD-Core Version:    0.7.0.1
 */