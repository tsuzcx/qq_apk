package com.tencent.mobileqq.activity.contacts.fragment;

import afqy;
import afqz;
import afra;
import afrb;
import afrc;
import ails;
import aiqp;
import ajsx;
import ajvg;
import ajxl;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import asko;
import asyj;
import aumg;
import aweq;
import axqy;
import axrc;
import bbbr;
import bbfj;
import bcql;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.contacts.view.ContactsFPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class FriendFragment
  extends ContactsBaseFragment
  implements Handler.Callback, View.OnClickListener, asko
{
  private final afqy jdField_a_of_type_Afqy = new afqy(this, null);
  private final afra jdField_a_of_type_Afra = new afra(this, null);
  private final afrb jdField_a_of_type_Afrb = new afrb(this, null);
  private final afrc jdField_a_of_type_Afrc = new afrc(this, null);
  public ails a;
  private View jdField_a_of_type_AndroidViewView;
  private aumg jdField_a_of_type_Aumg = new afqz(this, null);
  protected ContactsFPSPinnedHeaderExpandableListView a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean c = true;
  private boolean d;
  
  private void a(long paramLong, boolean paramBoolean)
  {
    int i = 9527;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "refreshBuddyList, delay=" + paramLong + ", load=" + paramBoolean);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9527);
    }
    while (paramLong == 0L)
    {
      c(paramBoolean);
      return;
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(9527)) {
        return;
      }
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramBoolean) {}
    for (;;)
    {
      localMqqHandler.sendEmptyMessageDelayed(i, paramLong);
      return;
      i = 4;
    }
  }
  
  private void a(View paramView)
  {
    Object localObject = paramView.getTag(-2);
    paramView = paramView.getTag(-10);
    if ((!(localObject instanceof Integer)) || ((!(paramView instanceof Friends)) && (!(paramView instanceof TroopInfo)) && (!(paramView instanceof DiscussionInfo)))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "handleRightMenuClick onClick tag is not int");
      }
    }
    do
    {
      int i;
      do
      {
        return;
        if (!bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692321, 1).a();
          return;
        }
        if (!(paramView instanceof Friends)) {
          break;
        }
        i = ((Integer)localObject).intValue();
        paramView = (Friends)paramView;
        localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (i == aiqk.a[1])
        {
          ((FriendListHandler)localObject).b(1, new String[] { paramView.uin }, new boolean[] { true });
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
          return;
        }
      } while (i != aiqk.a[0]);
      ((FriendListHandler)localObject).b(1, new String[] { paramView.uin }, new boolean[] { false });
      return;
      if ((paramView instanceof TroopInfo))
      {
        paramView = (TroopInfo)paramView;
        ((ajsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramView.troopcode, 1);
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist").d("Clk_unstick").a(new String[] { paramView.troopuin }).a();
        return;
      }
    } while (!(paramView instanceof DiscussionInfo));
    paramView = (DiscussionInfo)paramView;
    ((ajvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).e(Long.valueOf(paramView.uin).longValue());
  }
  
  private void a(Friends paramFriends)
  {
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramFriends.uin, false);
    if ((localExtensionInfo != null) && (localExtensionInfo.feedType == 2) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
      new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00898").e(paramFriends.uin).c("mystatus_notice").d("contact_notice_clk").a();
    }
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView) {
      if (paramListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setSelection(0);
      }
    }
    while (paramListView.getFirstVisiblePosition() <= 0) {
      return;
    }
    paramListView.setSelection(0);
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Hyim", 2, "onItemClick:" + paramObject.name + paramObject.uin + "--[" + paramObject.detalStatusFlag + "] [" + paramObject.iTermType + "] [" + paramObject.getLastLoginType() + "] [" + paramObject.showLoginClient + "]");
      }
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramObject.uin, 1);
      localAllInOne.h = 59;
      localAllInOne.j = 2;
      ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAllInOne);
      a(paramObject);
      return true;
    }
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "<<--doRefreshBuddyList, load=" + paramBoolean);
    }
    i();
    if (this.jdField_a_of_type_Ails != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Ails.notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ails.a();
  }
  
  private void h()
  {
    ThreadManager.getSubThreadHandler().post(new FriendFragment.1(this));
  }
  
  private void i()
  {
    int i = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c();
    if (i <= 0)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      int j = localPhoneContactManagerImp.d();
      if ((localPhoneContactManagerImp.c()) || (j == 8)) {
        i = localPhoneContactManagerImp.a(false).size() + i;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.FriendFragment", 2, "refreshUnusualContactsFooter " + i);
      }
      if (i > 0)
      {
        if ((this.jdField_a_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView != null)) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)) {
          if (this.jdField_a_of_type_AndroidViewView == null) {
            if (getActivity() == null) {
              QLog.e("contacts.fragment.FriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
            }
          }
        }
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0))
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558821, this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView, false);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
        } while (this.jdField_a_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
      return;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "resetContactsList, mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_Ails != null)
      {
        this.jdField_a_of_type_Ails.f();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.c();
      }
      this.jdField_a_of_type_Ails = new ails(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558821, this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView, false);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ails);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_a_of_type_Ails);
    }
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "getView mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView == null) {
      if (paramLayoutInflater != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView = ((ContactsFPSPinnedHeaderExpandableListView)paramLayoutInflater.inflate(2131558834, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setSelector(2131167087);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setGroupIndicator(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.mForContacts = true;
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView;
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnDestroy.");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ails != null) {
      this.jdField_a_of_type_Ails.f();
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onBindStateChanged bindState=" + paramInt);
    }
    i();
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnResume. tabChange:" + paramBoolean + ",mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView + ", mGroupingBuddyListAdapter=" + this.jdField_a_of_type_Ails);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView == null) {
      return;
    }
    if (this.jdField_a_of_type_Ails == null) {
      j();
    }
    d();
    a(500L, true);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)1);
    if (this.jdField_a_of_type_Ails != null)
    {
      int k = this.jdField_a_of_type_Ails.getGroupCount();
      int j = 0;
      while (i < k)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.c(i)) {
          j = 1;
        }
        i += 1;
      }
      if (j != 0) {
        h();
      }
    }
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5))
    {
      i = asyj.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, i * 1000);
    }
    ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(true);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void an_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "refresh");
    }
    h();
    if (this.c) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true, true);
    }
    this.d = true;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "updateBuddyList succeeded");
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnPause.");
    }
    if (paramBoolean) {
      e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.a();
    }
    if (this.jdField_a_of_type_Ails != null) {
      this.jdField_a_of_type_Ails.b();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "resetData");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    j();
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Afra);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Afqy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Afrb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aumg);
    aweq localaweq = (aweq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if (localaweq != null) {
      localaweq.a(this.jdField_a_of_type_Afrc);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Afra);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Afqy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Afrb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aumg);
    aweq localaweq = (aweq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if (localaweq != null) {
      localaweq.b(this.jdField_a_of_type_Afrc);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_Ails != null))
    {
      int j = this.jdField_a_of_type_Ails.getGroupCount();
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.b(i);
        i += 1;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (!this.c);
      a(0L, false);
      return true;
      a(0L, true);
      return true;
    } while (!this.c);
    a(0L, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (bbbr.a("tag_swip_icon_menu_item", paramView.getTag())) {
        a(paramView);
      }
      break;
    }
    do
    {
      return;
      GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
      return;
      startActivity(new Intent(getActivity(), UncommonlyUsedContactsActivity.class));
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
      return;
      paramView = (aiqp)paramView.getTag();
    } while ((paramView == null) || (paramView.a == null));
    a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.FriendFragment
 * JD-Core Version:    0.7.0.1
 */