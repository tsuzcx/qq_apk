package com.tencent.mobileqq.activity.contacts.friend;

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
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class FriendFragment
  extends ContactsBaseFragment
  implements Handler.Callback, View.OnClickListener, PhoneContactManager.IPhoneContactListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected BuddyListAdapter a;
  protected ContactsFPSPinnedHeaderExpandableListView a;
  private final FriendFragment.MyAvatarObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyAvatarObserver = new FriendFragment.MyAvatarObserver(this, null);
  private final FriendFragment.MyCardObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyCardObserver = new FriendFragment.MyCardObserver(this, null);
  private final FriendFragment.MyFriendListObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendListObserver = new FriendFragment.MyFriendListObserver(this, null);
  private final FriendFragment.MyMessageObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyMessageObserver = new FriendFragment.MyMessageObserver(this, null);
  private final FriendFragment.MyProfileCardObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyProfileCardObserver = new FriendFragment.MyProfileCardObserver(this, null);
  private final FriendFragment.StatusIconListener jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$StatusIconListener = new FriendFragment.StatusIconListener(this, null);
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new FriendFragment.MyContactObserver(this, null);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean d = true;
  private boolean e = false;
  
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
        if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692257, 1).a();
          return;
        }
        if (!(paramView instanceof Friends)) {
          break;
        }
        i = ((Integer)localObject).intValue();
        paramView = (Friends)paramView;
        localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (i == BuddyListFriends.a[1])
        {
          ((FriendListHandler)localObject).setSpecialCareSwitch(1, new String[] { paramView.uin }, new boolean[] { true });
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
          return;
        }
      } while (i != BuddyListFriends.a[0]);
      ((FriendListHandler)localObject).setSpecialCareSwitch(1, new String[] { paramView.uin }, new boolean[] { false });
      return;
      if ((paramView instanceof TroopInfo))
      {
        paramView = (TroopInfo)paramView;
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).a(paramView.troopcode, 1);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist").d("Clk_unstick").a(new String[] { paramView.troopuin }).a();
        return;
      }
    } while (!(paramView instanceof DiscussionInfo));
    paramView = (DiscussionInfo)paramView;
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).e(Long.valueOf(paramView.uin).longValue());
  }
  
  private void a(Friends paramFriends)
  {
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtensionInfo(paramFriends.uin, false);
    if ((localExtensionInfo != null) && (localExtensionInfo.feedType == 2) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00898").e(paramFriends.uin).c("mystatus_notice").d("contact_notice_clk").a();
    }
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView) {
      if (paramListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setSelection(0);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.a();
  }
  
  private void h()
  {
    ThreadManager.getSubThreadHandler().post(new FriendFragment.1(this));
  }
  
  private void i()
  {
    int i = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c();
    if (i <= 0)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      int j = localPhoneContactManagerImp.d();
      if ((localPhoneContactManagerImp.d()) || (j == 8)) {
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
        if ((this.jdField_a_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)) {
          if (this.jdField_a_of_type_AndroidViewView == null) {
            if (getActivity() == null) {
              QLog.e("contacts.fragment.FriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
            }
          }
        }
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0))
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559003, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, false);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
        } while (this.jdField_a_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
      return;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "resetContactsList, mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.b();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.resetState();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter = new BuddyListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559003, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, false);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "getView mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView == null) {
      if (paramLayoutInflater != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView = ((ContactsFPSPinnedHeaderExpandableListView)paramLayoutInflater.inflate(2131559017, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setSelector(2131167305);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setGroupIndicator(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.mForContacts = true;
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView;
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnDestroy.");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.b();
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
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnResume. tabChange:" + paramBoolean + ",mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView + ", mGroupingBuddyListAdapter=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter == null) {
      j();
    }
    d();
    a(500L, true);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter != null)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.getGroupCount();
      int j = 0;
      while (i < k)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.isGroupExpanded(i)) {
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
      i = HotReactiveHelper.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, i * 1000);
    }
    ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void ag_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "refresh");
    }
    h();
    if (this.d) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, true);
    }
    this.e = true;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "updateBuddyList succeeded");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnPause.");
    }
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.hideCurShowingRightView();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.c();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$StatusIconListener);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(this);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$StatusIconListener);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter != null))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.getGroupCount();
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.collapseGroup(i);
        i += 1;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
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
      } while (!this.d);
      a(0L, false);
      return true;
      a(0L, true);
      return true;
    } while (!this.d);
    a(0L, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (Utils.a("tag_swip_icon_menu_item", paramView.getTag())) {
        a(paramView);
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      startActivity(new Intent(getActivity(), UncommonlyUsedContactsActivity.class));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
      continue;
      BuddyListItem.ViewTag localViewTag = (BuddyListItem.ViewTag)paramView.getTag();
      if ((localViewTag != null) && (localViewTag.a != null)) {
        a(localViewTag.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment
 * JD-Core Version:    0.7.0.1
 */