package com.tencent.mobileqq.activity.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopDiscussionTroop
  extends TroopDiscussionBaseV
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299215);
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private TroopDiscussionMemSelectAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionMemSelectAdapter;
  private TroopDiscussionTroop.MyAvatarObserver jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyAvatarObserver;
  private TroopDiscussionTroop.MyFriendListObserver jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyFriendListObserver;
  private TroopDiscussionTroop.MyMessageObserver jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyMessageObserver;
  private TroopDiscussionTroop.MyTroopBusinessObserver jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopBusinessObserver;
  private TroopDiscussionTroop.MyTroopObserver jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopObserver;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new TroopDiscussionTroop.2(this);
  private SwipPinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  
  public TroopDiscussionTroop(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyFriendListObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyFriendListObserver = new TroopDiscussionTroop.MyFriendListObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyAvatarObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyAvatarObserver = new TroopDiscussionTroop.MyAvatarObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopBusinessObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopBusinessObserver = new TroopDiscussionTroop.MyTroopBusinessObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopObserver = new TroopDiscussionTroop.MyTroopObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyMessageObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyMessageObserver = new TroopDiscussionTroop.MyMessageObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    a(2131560571);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)findViewById(2131382091));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380035));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, AIOUtils.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionMemSelectAdapter = new TroopDiscussionMemSelectAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionMemSelectAdapter);
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionMemSelectAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionMemSelectAdapter.b();
    }
    g();
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    d();
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopDiscussionTroop.1(this), 200L);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionMemSelectAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionMemSelectAdapter.notifyDataSetChanged();
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (TroopDiscussionMemSelectAdapter.TroopViewHolder)paramView.getTag();
    Object localObject2;
    if ((localObject1 != null) && (((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      localObject2 = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity instanceof SelectMemberActivity)) && (!((TroopInfo)localObject2).isAllowCreateDiscuss()) && (!((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!((TroopInfo)localObject2).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c)) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131697618), 0).b(getResources().getDimensionPixelSize(2131299166));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131697620), 0).b(getResources().getDimensionPixelSize(2131299166));
      continue;
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", ((TroopInfo)localObject2).troopuin);
      localBundle.putString("group_name", ((TroopInfo)localObject2).getTroopDisplayName());
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, localBundle);
      int i;
      switch (((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject1).jdField_a_of_type_Int)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        i = 0;
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject2).troopuin + "", String.valueOf(i), "", "");
        break;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
      }
      if ((localObject1 != null) && (((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null))
      {
        localObject1 = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
        ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, (Bundle)localObject2);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop
 * JD-Core Version:    0.7.0.1
 */