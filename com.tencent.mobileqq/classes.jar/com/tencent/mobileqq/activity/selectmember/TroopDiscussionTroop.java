package com.tencent.mobileqq.activity.selectmember;

import aepi;
import akbj;
import akbm;
import akbn;
import akbo;
import akbp;
import akbq;
import alog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import azqs;
import bhtv;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopDiscussionTroop
  extends TroopDiscussionBaseV
  implements View.OnClickListener, bhtv
{
  int jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298961);
  private akbj jdField_a_of_type_Akbj;
  private akbo jdField_a_of_type_Akbo;
  private akbp jdField_a_of_type_Akbp;
  private akbq jdField_a_of_type_Akbq;
  private alog jdField_a_of_type_Alog = new akbn(this);
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private SwipPinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  
  public TroopDiscussionTroop(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Akbo == null) {
      this.jdField_a_of_type_Akbo = new akbo(this);
    }
    if (this.jdField_a_of_type_Akbq == null) {
      this.jdField_a_of_type_Akbq = new akbq(this);
    }
    if (this.jdField_a_of_type_Akbp == null) {
      this.jdField_a_of_type_Akbp = new akbp(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akbo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akbq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akbp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alog);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akbo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akbq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akbp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alog);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    a(2131560254);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)findViewById(2131380348));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378502));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167140);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, aepi.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_Akbj = new akbj(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Akbj);
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_Akbj != null) {
      this.jdField_a_of_type_Akbj.b();
    }
    g();
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    d();
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopDiscussionTroop.1(this), 200L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akbj != null) {
      this.jdField_a_of_type_Akbj.notifyDataSetChanged();
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  public void onClick(View paramView)
  {
    paramView = (akbm)paramView.getTag();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity instanceof SelectMemberActivity)) && (!((TroopInfo)localObject).isAllowCreateDiscuss()) && (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c)) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131698050), 0).b(getResources().getDimensionPixelSize(2131298914));
        }
      }
    }
    while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null))
    {
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131698052), 0).b(getResources().getDimensionPixelSize(2131298914));
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", ((TroopInfo)localObject).troopuin);
      localBundle.putString("group_name", ((TroopInfo)localObject).getTroopName());
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, localBundle);
      int i;
      switch (paramView.jdField_a_of_type_Int)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        i = 0;
      }
      for (;;)
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject).troopuin + "", String.valueOf(i), "", "");
        return;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
      }
    }
    paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("group_uin", paramView.uin);
    ((Bundle)localObject).putString("group_name", paramView.discussionName);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, (Bundle)localObject);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop
 * JD-Core Version:    0.7.0.1
 */