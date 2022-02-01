package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private RecentMemberInnerFrame.RecentMemberAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<RecentUser> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public RecentMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (localObject1 != null)
    {
      Object localObject2 = ((RecentUserProxy)localObject1).a(true);
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser != null) {
            try
            {
              if ((localRecentUser.getType() == 0) && (Long.parseLong(localRecentUser.uin) >= 10000L) && (!localRecentUser.uin.equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d.contains(localRecentUser.uin)))
              {
                Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(localRecentUser.uin);
                if ((localFriends != null) && (localFriends.isFriend())) {
                  this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131563008);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131382091));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167305);
    paramBundle = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562951, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131366452));
    ((Button)paramBundle.findViewById(2131363942)).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter = new RecentMemberInnerFrame.RecentMemberAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719002), HardCodeUtil.a(2131713154));
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberRecentMemberInnerFrame$RecentMemberAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    RecentMemberInnerFrame.ViewHolder localViewHolder = (RecentMemberInnerFrame.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && (localViewHolder.jdField_a_of_type_JavaLangString != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localViewHolder.jdField_a_of_type_JavaLangString, localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.d)
      {
        if (!localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label140;
        }
        paramView.setContentDescription(localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + HardCodeUtil.a(2131713152));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label140:
      paramView.setContentDescription(localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + HardCodeUtil.a(2131713155));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */