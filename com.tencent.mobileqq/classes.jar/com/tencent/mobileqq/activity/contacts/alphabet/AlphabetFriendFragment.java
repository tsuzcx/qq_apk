package com.tencent.mobileqq.activity.contacts.alphabet;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class AlphabetFriendFragment
  extends ContactsBaseFragment
  implements Handler.Callback, View.OnClickListener, IndexBar.OnIndexBarTouchListener, PhoneContactManager.IPhoneContactListener
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  protected View a;
  private AlphabetFriendAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter;
  private final AlphabetFriendFragment.MyAvatarObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyAvatarObserver = new AlphabetFriendFragment.MyAvatarObserver(this, null);
  private final AlphabetFriendFragment.MyCardObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyCardObserver = new AlphabetFriendFragment.MyCardObserver(this, null);
  private final AlphabetFriendFragment.MyFriendListObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendListObserver = new AlphabetFriendFragment.MyFriendListObserver(this, null);
  private final AlphabetFriendFragment.MyMessageObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyMessageObserver = new AlphabetFriendFragment.MyMessageObserver(this, null);
  private final AlphabetFriendFragment.MyProfileCardObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyProfileCardObserver = new AlphabetFriendFragment.MyProfileCardObserver(this, null);
  private final AlphabetFriendFragment.StatusIconListener jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$StatusIconListener = new AlphabetFriendFragment.StatusIconListener(this, null);
  protected IndexBar a;
  protected IndexBarTipsLayout a;
  protected PinnedDividerListView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AlphabetFriendFragment.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private View c;
  private boolean d = true;
  private boolean e = false;
  private boolean f = true;
  
  private void a(long paramLong, boolean paramBoolean)
  {
    int i = 9527;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refreshBuddyList, delay=" + paramLong + ", load=" + paramBoolean);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9527);
    }
    while (paramLong == 0L)
    {
      f(paramBoolean);
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
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Hyim", 2, "onItemClick:" + paramObject.name + paramObject.uin + "--[" + paramObject.detalStatusFlag + "] [" + paramObject.iTermType + "] [" + paramObject.getLastLoginType() + "] [" + paramObject.showLoginClient + "]");
      }
      paramObject = new ProfileActivity.AllInOne(paramObject.uin, 1);
      paramObject.h = 59;
      paramObject.j = 2;
      ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramObject);
      return true;
    }
    return false;
  }
  
  private void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, load=" + paramBoolean + ", mIsTabSelected=" + this.b + ",needTabRefresh =" + this.f);
    }
    if (!this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, return mIsTabSelected =" + this.b);
      }
      this.f = true;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.notifyDataSetChanged();
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFooterViewsCount() <= 0))
    {
      if (this.c != null) {
        break label62;
      }
      if (getActivity() == null) {
        QLog.e("contacts.fragment.AlphabetFriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
      }
    }
    else
    {
      return;
    }
    this.c = LayoutInflater.from(getActivity()).inflate(2131559001, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    label62:
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addFooterView(this.c);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "getView ");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559016, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362709));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar = ((IndexBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131369039));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout = ((IndexBarTipsLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369040));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setOnIndexBarTouchListener(this);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnDestroy.");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.e();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onBindStateChanged bindState=" + paramInt);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString, int paramInt, float paramFloat)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener != null) && (paramInt == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener.af_();
    }
    ReportController.b(null, "dc00898", "", "", "0X800A1F8", "0X800A1F8", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      if (!"★".equals(paramString)) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      label126:
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.a(paramString);
      if (paramInt != -1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(paramInt + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnResume. tabChange:" + paramBoolean + ",mListView=" + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView + ", mAdapter=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter + ", needTabRefresh=" + this.f);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter = new AlphabetFriendAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar, this);
      h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.a(this.c);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter);
    }
    if (this.f)
    {
      a(300L, true);
      this.f = false;
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)1);
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5))
    {
      int i = HotReactiveHelper.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, i * 1000);
    }
    ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
    ReportController.b(null, "dc00898", "", "", "0X800A1F7", "0X800A1F7", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void ag_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refresh");
    }
    if (this.d) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, true);
    }
    this.e = true;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "updateBuddyList succeeded");
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnPause.");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "resetData");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setLetters(null);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.e();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter = new AlphabetFriendAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar, this);
        h();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.a(this.c);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter);
      }
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    IndexBarTipsLayout localIndexBarTipsLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout != null)
    {
      localIndexBarTipsLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = 4)
    {
      localIndexBarTipsLayout.setVisibility(i);
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyMessageObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$StatusIconListener);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(this);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyMessageObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$StatusIconListener);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this);
  }
  
  public void f() {}
  
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
    paramView.getId();
    if (Utils.a("tag_swip_icon_menu_item", paramView.getTag())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BuddyListItem.ViewTag localViewTag = (BuddyListItem.ViewTag)paramView.getTag();
      if ((localViewTag != null) && (localViewTag.a != null)) {
        a(localViewTag.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment
 * JD-Core Version:    0.7.0.1
 */