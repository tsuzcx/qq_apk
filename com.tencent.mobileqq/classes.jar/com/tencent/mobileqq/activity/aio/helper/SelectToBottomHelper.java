package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
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
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
    while (i >= 0)
    {
      if (a(i))
      {
        i = i + j - 1;
        break label52;
      }
      i -= 1;
    }
    i = -1;
    label52:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Real last visible index is: ");
    localStringBuilder.append(i);
    QLog.d("SelectToBottomHelper", 3, localStringBuilder.toString());
    return i;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = MultiMsgManager.a();
    int i = paramInt1;
    while (i <= paramInt2)
    {
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((((MultiMsgManager)localObject).a(localChatMessage) != paramBoolean) && (MultiMsgUtil.c(localChatMessage)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
        {
          int j = MultiMsgManager.a().a();
          if ((paramBoolean) && (MultiMsgManager.a().a(localChatMessage, j)))
          {
            if (MultiMsgManager.a().jdField_a_of_type_Int == 7) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131698529, new Object[] { Integer.valueOf(j) });
            } else {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131698528, new Object[] { Integer.valueOf(j) });
            }
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject, 0).a();
            return;
          }
          ((MultiMsgManager)localObject).a(localChatMessage, paramBoolean);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(localChatMessage, null, paramBoolean);
          ((ChatAdapter1)this.jdField_a_of_type_AndroidWidgetListAdapter).notifyDataSetChanged();
        }
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("item index: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" to ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" Perform select");
    QLog.d("SelectToBottomHelper", 3, ((StringBuilder)localObject).toString());
  }
  
  private void a(View paramView)
  {
    c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
        return;
      }
      c();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      if (MultiMsgManager.a().c() == 0) {
        QQToast.a(paramView.getContext(), HardCodeUtil.a(2131713678), 0).a();
      }
      int i = b();
      int k = c();
      int j = a();
      if ((j >= 0) && (i >= 0))
      {
        if (k < 0) {
          return;
        }
        if (j < i) {
          return;
        }
        k = j + 1;
        int m = this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1;
        if ((k < this.jdField_a_of_type_ComTencentWidgetListView.getCount()) && (k <= m)) {
          a(k, m, false);
        }
        a(i, j);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          j = MultiMsgManager.a().c();
          i = Integer.valueOf(ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).intValue();
          if (i == 0) {
            i = 1;
          } else if (i == 1) {
            i = 3;
          } else if (i == 3) {
            i = 2;
          } else if (i == 2) {
            i = 4;
          } else {
            i = 5;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", "", "0X800A510", "0X800A510", i, j, "", "", "", "");
        }
      }
    }
  }
  
  private boolean a()
  {
    int i = b();
    int j = c();
    int k = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (k >= 0)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (j < 0) {
          return false;
        }
        bool1 = bool2;
        if (k >= i) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt)
  {
    c();
    Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (paramInt >= 0)
      {
        bool1 = bool2;
        if (paramInt <= ((ListView)localObject).getCount())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView == null) {
            return false;
          }
          localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt);
          int i = ((View)localObject).getTop();
          paramInt = i;
          if ((localObject instanceof BaseChatItemLayout))
          {
            localObject = (HeadIconWrapper)((BaseChatItemLayout)localObject).a(HeadIconWrapper.class);
            paramInt = i;
            if (localObject != null)
            {
              localObject = ((HeadIconWrapper)localObject).a();
              paramInt = i;
              if (localObject != null) {
                paramInt = i + ((BaseChatItemLayoutViewBasicAbility)localObject).getTop();
              }
            }
          }
          localObject = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.findViewById(2131362483);
          bool1 = bool2;
          if (paramInt < this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.getTop() + ((RelativeLayout)localObject).getHeight() / 2) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private int b()
  {
    c();
    Object localObject = MultiMsgManager.a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((((MultiMsgManager)localObject).a(localChatMessage)) && (MultiMsgUtil.c(localChatMessage))) {
        break label64;
      }
      i += 1;
    }
    i = -1;
    label64:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("First selected index is: ");
    ((StringBuilder)localObject).append(i);
    QLog.d("SelectToBottomHelper", 3, ((StringBuilder)localObject).toString());
    return i;
  }
  
  private int c()
  {
    c();
    Object localObject = MultiMsgManager.a();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((((MultiMsgManager)localObject).a(localChatMessage)) && (MultiMsgUtil.c(localChatMessage))) {
        break label65;
      }
      i -= 1;
    }
    i = -1;
    label65:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Last selected index is: ");
    ((StringBuilder)localObject).append(i);
    QLog.d("SelectToBottomHelper", 3, ((StringBuilder)localObject).toString());
    return i;
  }
  
  private void c()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      this.jdField_a_of_type_AndroidWidgetListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
      if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      }
    }
  }
  
  public void a()
  {
    SelectTouchBarView localSelectTouchBarView = this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView;
    if (localSelectTouchBarView != null) {
      localSelectTouchBarView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    SelectTouchBarView localSelectTouchBarView = this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView;
    if (localSelectTouchBarView != null)
    {
      if ((paramInt != 0) && ((localSelectTouchBarView.getMeasuredHeight() == 0) || (a()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(0);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setCheckedNum(paramInt);
    }
  }
  
  public void a(LinearLayout paramLinearLayout, int paramInt, RelativeLayout paramRelativeLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView == null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView = new SelectTouchBarView(((BaseChatPie)localObject).jdField_a_of_type_AndroidContentContext);
        localObject = new RelativeLayout.LayoutParams(-1, paramInt);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, paramLinearLayout.getId());
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.a(HardCodeUtil.a(2131713677)).a(paramInt).a();
        paramRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setId(2131362482);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView.setOnClickListener(new SelectToBottomHelper.1(this));
      }
    }
  }
  
  public void b()
  {
    SelectTouchBarView localSelectTouchBarView = this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView;
    if (localSelectTouchBarView != null) {
      localSelectTouchBarView.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    c();
    if (paramInt == 18)
    {
      int i = a();
      int j = b();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView != null)
      {
        if (j < 0) {
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
    }
  }
  
  public String getTag()
  {
    return "SelectToBottomHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 18, 19 };
  }
  
  public void onMoveToState(int paramInt)
  {
    SelectTouchBarView localSelectTouchBarView;
    if (paramInt != 7)
    {
      if (paramInt != 18)
      {
        if (paramInt != 19) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged");
        }
        localSelectTouchBarView = this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView;
        if (localSelectTouchBarView != null)
        {
          localSelectTouchBarView.a();
          if (QLog.isColorLevel()) {
            QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged->updateDotLine");
          }
        }
      }
      else
      {
        b(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onScrollStateIdle");
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectToBottomHelper", 1, "onResume");
      }
      localSelectTouchBarView = this.jdField_a_of_type_ComTencentMobileqqWidgetSelectTouchBarView;
      if (localSelectTouchBarView != null)
      {
        localSelectTouchBarView.a();
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onResume->updateDotLine");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper
 * JD-Core Version:    0.7.0.1
 */