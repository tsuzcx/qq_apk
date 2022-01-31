package com.tencent.mobileqq.activity.contacts.fragment;

import ahop;
import ahoq;
import ahor;
import ahos;
import ahot;
import akdd;
import akia;
import alkk;
import almt;
import aloz;
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
import aubn;
import aupg;
import awdn;
import axzt;
import azmj;
import azmo;
import bdal;
import bdee;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class FriendFragment
  extends ContactsBaseFragment
  implements Handler.Callback, View.OnClickListener, aubn
{
  private final ahop jdField_a_of_type_Ahop = new ahop(this, null);
  private final ahor jdField_a_of_type_Ahor = new ahor(this, null);
  private final ahos jdField_a_of_type_Ahos = new ahos(this, null);
  private final ahot jdField_a_of_type_Ahot = new ahot(this, null);
  public akdd a;
  private View jdField_a_of_type_AndroidViewView;
  private awdn jdField_a_of_type_Awdn = new ahoq(this, null);
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
        if (!bdee.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692397, 1).a();
          return;
        }
        if (!(paramView instanceof Friends)) {
          break;
        }
        i = ((Integer)localObject).intValue();
        paramView = (Friends)paramView;
        localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (i == akhv.a[1])
        {
          ((FriendListHandler)localObject).b(1, new String[] { paramView.uin }, new boolean[] { true });
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
          return;
        }
      } while (i != akhv.a[0]);
      ((FriendListHandler)localObject).b(1, new String[] { paramView.uin }, new boolean[] { false });
      return;
      if ((paramView instanceof TroopInfo))
      {
        paramView = (TroopInfo)paramView;
        ((alkk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramView.troopcode, 1);
        new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist").d("Clk_unstick").a(new String[] { paramView.troopuin }).a();
        return;
      }
    } while (!(paramView instanceof DiscussionInfo));
    paramView = (DiscussionInfo)paramView;
    ((almt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).e(Long.valueOf(paramView.uin).longValue());
  }
  
  private void a(Friends paramFriends)
  {
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramFriends.uin, false);
    if ((localExtensionInfo != null) && (localExtensionInfo.feedType == 2) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
      new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00898").e(paramFriends.uin).c("mystatus_notice").d("contact_notice_clk").a();
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
    if (this.jdField_a_of_type_Akdd != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Akdd.notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Akdd.a();
  }
  
  private void h()
  {
    ThreadManager.getSubThreadHandler().post(new FriendFragment.1(this));
  }
  
  private void i()
  {
    int i = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c();
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
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
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
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558857, this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView, false);
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
      if (this.jdField_a_of_type_Akdd != null)
      {
        this.jdField_a_of_type_Akdd.f();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.c();
      }
      this.jdField_a_of_type_Akdd = new akdd(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558857, this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView, false);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Akdd);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_a_of_type_Akdd);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView = ((ContactsFPSPinnedHeaderExpandableListView)paramLayoutInflater.inflate(2131558871, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView.setSelector(2131167138);
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
    if (this.jdField_a_of_type_Akdd != null) {
      this.jdField_a_of_type_Akdd.f();
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
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnResume. tabChange:" + paramBoolean + ",mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView + ", mGroupingBuddyListAdapter=" + this.jdField_a_of_type_Akdd);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView == null) {
      return;
    }
    if (this.jdField_a_of_type_Akdd == null) {
      j();
    }
    d();
    a(500L, true);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)1);
    if (this.jdField_a_of_type_Akdd != null)
    {
      int k = this.jdField_a_of_type_Akdd.getGroupCount();
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
      i = aupg.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, i * 1000);
    }
    ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(true);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void av_()
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
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Akdd != null) {
      this.jdField_a_of_type_Akdd.b();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahor);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahop);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahos);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Awdn);
    axzt localaxzt = (axzt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if (localaxzt != null) {
      localaxzt.a(this.jdField_a_of_type_Ahot);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahor);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahop);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahos);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Awdn);
    axzt localaxzt = (axzt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if (localaxzt != null) {
      localaxzt.b(this.jdField_a_of_type_Ahot);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_Akdd != null))
    {
      int j = this.jdField_a_of_type_Akdd.getGroupCount();
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
      if (bdal.a("tag_swip_icon_menu_item", paramView.getTag())) {
        a(paramView);
      }
      break;
    }
    do
    {
      return;
      GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
      return;
      startActivity(new Intent(getActivity(), UncommonlyUsedContactsActivity.class));
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
      return;
      paramView = (akia)paramView.getTag();
    } while ((paramView == null) || (paramView.a == null));
    a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.FriendFragment
 * JD-Core Version:    0.7.0.1
 */