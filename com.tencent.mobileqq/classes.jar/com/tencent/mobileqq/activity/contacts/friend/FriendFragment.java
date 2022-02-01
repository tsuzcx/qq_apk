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
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
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
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
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
  implements Handler.Callback, View.OnClickListener, IPhoneContactListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected BuddyListAdapter a;
  protected ContactsFPSPinnedHeaderExpandableListView a;
  private final FriendFragment.MyAvatarObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyAvatarObserver = new FriendFragment.MyAvatarObserver(this, null);
  private final FriendFragment.MyCardObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyCardObserver = new FriendFragment.MyCardObserver(this, null);
  private final FriendFragment.MyFriendListObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendListObserver = new FriendFragment.MyFriendListObserver(this, null);
  private final FriendFragment.MyFriendObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendObserver = new FriendFragment.MyFriendObserver(this, null);
  private final FriendFragment.MyMessageObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyMessageObserver = new FriendFragment.MyMessageObserver(this, null);
  private final FriendFragment.MyProfileCardObserver jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyProfileCardObserver = new FriendFragment.MyProfileCardObserver(this, null);
  private final FriendFragment.StatusIconListener jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$StatusIconListener = new FriendFragment.StatusIconListener(this, null);
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new FriendFragment.MyContactObserver(this, null);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean d = true;
  private boolean e = false;
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshBuddyList, delay=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", load=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
    int i = 9527;
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9527);
    } else if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(9527)) {
      return;
    }
    if (paramLong == 0L)
    {
      c(paramBoolean);
      return;
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (!paramBoolean) {
      i = 4;
    }
    ((MqqHandler)localObject).sendEmptyMessageDelayed(i, paramLong);
  }
  
  private void a(View paramView)
  {
    Object localObject = paramView.getTag(-2);
    paramView = paramView.getTag(-10);
    if ((localObject instanceof Integer))
    {
      boolean bool = paramView instanceof Friends;
      if ((bool) || ((paramView instanceof TroopInfo)) || ((paramView instanceof DiscussionInfo)))
      {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692183, 1).a();
          return;
        }
        if (bool)
        {
          int i = ((Integer)localObject).intValue();
          paramView = (Friends)paramView;
          localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          if (i == BuddyListFriends.a[1])
          {
            ((FriendListHandler)localObject).setSpecialCareSwitch(1, new String[] { paramView.uin }, new boolean[] { true });
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
            return;
          }
          if (i == BuddyListFriends.a[0]) {
            ((FriendListHandler)localObject).setSpecialCareSwitch(1, new String[] { paramView.uin }, new boolean[] { false });
          }
        }
        else
        {
          if ((paramView instanceof TroopInfo))
          {
            paramView = (TroopInfo)paramView;
            ((ITroopCommonlyUsedHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(paramView.troopcode, 1);
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist").d("Clk_unstick").a(new String[] { paramView.troopuin }).a();
            return;
          }
          if ((paramView instanceof DiscussionInfo))
          {
            paramView = (DiscussionInfo)paramView;
            ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).e(Long.valueOf(paramView.uin).longValue());
          }
        }
        return;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "handleRightMenuClick onClick tag is not int");
    }
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
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView)
    {
      if (paramListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setSelection(0);
      }
    }
    else if (paramListView.getFirstVisiblePosition() > 0) {
      paramListView.setSelection(0);
    }
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemClick:");
        ((StringBuilder)localObject).append(paramObject.name);
        ((StringBuilder)localObject).append(paramObject.uin);
        ((StringBuilder)localObject).append("--[");
        ((StringBuilder)localObject).append(paramObject.detalStatusFlag);
        ((StringBuilder)localObject).append("] [");
        ((StringBuilder)localObject).append(paramObject.iTermType);
        ((StringBuilder)localObject).append("] [");
        ((StringBuilder)localObject).append(paramObject.getLastLoginType());
        ((StringBuilder)localObject).append("] [");
        ((StringBuilder)localObject).append(paramObject.showLoginClient);
        ((StringBuilder)localObject).append("]");
        QLog.d("Hyim", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new AllInOne(paramObject.uin, 1);
      ((AllInOne)localObject).profileEntryType = 59;
      ((AllInOne)localObject).chatEntrance = 2;
      ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (AllInOne)localObject);
      a(paramObject);
      return true;
    }
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<--doRefreshBuddyList, load=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    i();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((BuddyListAdapter)localObject).notifyDataSetChanged();
        return;
      }
      ((BuddyListAdapter)localObject).a();
    }
  }
  
  private void h()
  {
    ThreadManager.getSubThreadHandler().post(new FriendFragment.1(this));
  }
  
  private void i()
  {
    int j = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c();
    int i = j;
    Object localObject;
    if (j <= 0)
    {
      localObject = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      int k = ((IPhoneContactService)localObject).getSelfBindState();
      if (!((IPhoneContactService)localObject).isBindContactOk())
      {
        i = j;
        if (k != 8) {}
      }
      else
      {
        i = j + ((IPhoneContactService)localObject).getBindHideNoneFriendList(false).size();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshUnusualContactsFooter ");
      ((StringBuilder)localObject).append(i);
      QLog.i("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      if ((this.jdField_a_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView;
      if ((localObject != null) && (((ContactsFPSPinnedHeaderExpandableListView)localObject).getFooterViewsCount() <= 0))
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          if (getBaseActivity() == null)
          {
            QLog.e("contacts.fragment.FriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
            return;
          }
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131558897, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, false);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView;
      if ((localObject != null) && (((ContactsFPSPinnedHeaderExpandableListView)localObject).getFooterViewsCount() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  private void j()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetContactsList, mElvGroupingBuddies=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter;
      if (localObject != null)
      {
        ((BuddyListAdapter)localObject).b();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.resetState();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter = new BuddyListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131558897, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, false);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter);
    }
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getView mElvGroupingBuddies=");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
      QLog.d("contacts.fragment.FriendFragment", 2, paramBundle.toString());
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView;
    if (paramBundle == null)
    {
      if (paramLayoutInflater != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView = ((ContactsFPSPinnedHeaderExpandableListView)paramLayoutInflater.inflate(2131558911, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setSelector(2131167333);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setGroupIndicator(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.mForContacts = true;
      }
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnDestroy.");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    BuddyListAdapter localBuddyListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter;
    if (localBuddyListAdapter != null) {
      localBuddyListAdapter.b();
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged bindState=");
      localStringBuilder.append(paramInt);
      QLog.d("contacts.fragment.FriendFragment", 2, localStringBuilder.toString());
    }
    i();
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume. tabChange:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",mElvGroupingBuddies=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
      ((StringBuilder)localObject).append(", mGroupingBuddyListAdapter=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter;
    int i;
    if (localObject != null)
    {
      int k = ((BuddyListAdapter)localObject).getGroupCount();
      i = 0;
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
  
  public void ae_()
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView;
    if (localObject != null)
    {
      if (((ContactsFPSPinnedHeaderExpandableListView)localObject).getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.hideCurShowingRightView();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter;
    if (localObject != null) {
      ((BuddyListAdapter)localObject).c();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$StatusIconListener);
    }
    ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$StatusIconListener);
    }
    ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)
    {
      BuddyListAdapter localBuddyListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter;
      if (localBuddyListAdapter != null)
      {
        int j = localBuddyListAdapter.getGroupCount();
        int i = 0;
        while (i < j)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.collapseGroup(i);
          i += 1;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 4)
    {
      if (i != 5)
      {
        if (i != 9527) {
          return true;
        }
        a(0L, true);
        return true;
      }
      if (this.d)
      {
        a(0L, false);
        return true;
      }
    }
    else if (this.d)
    {
      a(0L, false);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131380211)
    {
      if (Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
      {
        a(paramView);
      }
      else
      {
        BuddyListItem.ViewTag localViewTag = (BuddyListItem.ViewTag)paramView.getTag();
        if ((localViewTag != null) && (localViewTag.a != null)) {
          a(localViewTag.a);
        }
      }
    }
    else
    {
      startActivity(new Intent(getBaseActivity(), UncommonlyUsedContactsActivity.class));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment
 * JD-Core Version:    0.7.0.1
 */