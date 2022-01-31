package com.tencent.mobileqq.activity.selectmember;

import aciy;
import ahsu;
import ahsx;
import ahsy;
import ahsz;
import ahta;
import ahtb;
import ajee;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import awqx;
import bbmy;
import begh;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopDiscussionTroop
  extends TroopDiscussionBaseV
  implements View.OnClickListener, begh
{
  int jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131167813);
  private ahsu jdField_a_of_type_Ahsu;
  private ahsz jdField_a_of_type_Ahsz;
  private ahta jdField_a_of_type_Ahta;
  private ahtb jdField_a_of_type_Ahtb;
  private ajee jdField_a_of_type_Ajee = new ahsy(this);
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private SwipPinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  
  public TroopDiscussionTroop(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Ahsz == null) {
      this.jdField_a_of_type_Ahsz = new ahsz(this);
    }
    if (this.jdField_a_of_type_Ahtb == null) {
      this.jdField_a_of_type_Ahtb = new ahtb(this);
    }
    if (this.jdField_a_of_type_Ahta == null) {
      this.jdField_a_of_type_Ahta = new ahta(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahsz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahtb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahta);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajee);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahsz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahtb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahta);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajee);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    a(2131494575);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)findViewById(2131313707));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312075));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131101491);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, aciy.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_Ahsu = new ahsu(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ahsu);
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_Ahsu != null) {
      this.jdField_a_of_type_Ahsu.b();
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
    if (this.jdField_a_of_type_Ahsu != null) {
      this.jdField_a_of_type_Ahsu.notifyDataSetChanged();
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  public void onClick(View paramView)
  {
    paramView = (ahsx)paramView.getTag();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity instanceof SelectMemberActivity)) && (!((TroopInfo)localObject).isAllowCreateDiscuss()) && (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c)) {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131632141), 0).b(getResources().getDimensionPixelSize(2131167766));
        }
      }
    }
    while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null))
    {
      return;
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131632143), 0).b(getResources().getDimensionPixelSize(2131167766));
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
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject).troopuin + "", String.valueOf(i), "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop
 * JD-Core Version:    0.7.0.1
 */