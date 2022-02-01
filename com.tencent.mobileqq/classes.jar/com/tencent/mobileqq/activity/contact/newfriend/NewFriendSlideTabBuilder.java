package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSlideTabMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class NewFriendSlideTabBuilder
  extends NewFriendBaseBuilder
  implements TabLayoutCompat.OnTabSelectedListener
{
  public NewFriendSlideTabBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.c();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b();
    NewFriendSlideTabBuilder.NewFriendSildeTabHolder localNewFriendSildeTabHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder)))
    {
      localNewFriendSildeTabHolder = new NewFriendSlideTabBuilder.NewFriendSildeTabHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561406, null);
      localNewFriendSildeTabHolder.a = ((ThemeTabLayout)paramView.findViewById(2131378847));
      localNewFriendSildeTabHolder.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage != null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage instanceof NewFriendSlideTabMessage))) {
        localNewFriendSildeTabHolder.a.a(((NewFriendSlideTabMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a, i);
      }
      localNewFriendSildeTabHolder.a.setOnTabSelectedListener(this);
      paramView.setTag(localNewFriendSildeTabHolder);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localNewFriendSildeTabHolder != null) && (localNewFriendSildeTabHolder.a != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage != null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage instanceof NewFriendSlideTabMessage))))
      {
        ArrayList localArrayList = ((NewFriendSlideTabMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
        localNewFriendSildeTabHolder.a.b(localArrayList, i);
      }
      return paramView;
      localNewFriendSildeTabHolder = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)paramView.getTag();
    }
  }
  
  public ArrayList<ConnectionsTabInfo> a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage != null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage instanceof NewFriendSlideTabMessage))) {
      return ((NewFriendSlideTabMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
    }
    return null;
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramTab.a());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter != null) && (paramTab != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b(((Integer)paramTab.a()).intValue(), paramTab.a());
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(TabLayoutCompat.Tab paramTab) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839537);
      return;
    }
    paramView.setBackgroundResource(2130850652);
  }
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendSlideTabBuilder
 * JD-Core Version:    0.7.0.1
 */