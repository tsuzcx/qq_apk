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
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class AlphabetFriendFragment
  extends ContactsBaseFragment
  implements Handler.Callback, View.OnClickListener, IndexBar.OnIndexBarTouchListener, IPhoneContactListener
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  protected View a;
  private AlphabetFriendAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter;
  private final AlphabetFriendFragment.MyAvatarObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyAvatarObserver = new AlphabetFriendFragment.MyAvatarObserver(this, null);
  private final AlphabetFriendFragment.MyCardObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyCardObserver = new AlphabetFriendFragment.MyCardObserver(this, null);
  private final AlphabetFriendFragment.MyFriendListObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendListObserver = new AlphabetFriendFragment.MyFriendListObserver(this, null);
  private final AlphabetFriendFragment.MyFriendObserver jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendObserver = new AlphabetFriendFragment.MyFriendObserver(this, null);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshBuddyList, delay=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", load=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, ((StringBuilder)localObject).toString());
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
      e(paramBoolean);
      return;
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (!paramBoolean) {
      i = 4;
    }
    ((MqqHandler)localObject).sendEmptyMessageDelayed(i, paramLong);
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onItemClick:");
        localStringBuilder.append(paramObject.name);
        localStringBuilder.append(paramObject.uin);
        localStringBuilder.append("--[");
        localStringBuilder.append(paramObject.detalStatusFlag);
        localStringBuilder.append("] [");
        localStringBuilder.append(paramObject.iTermType);
        localStringBuilder.append("] [");
        localStringBuilder.append(paramObject.getLastLoginType());
        localStringBuilder.append("] [");
        localStringBuilder.append(paramObject.showLoginClient);
        localStringBuilder.append("]");
        QLog.d("Hyim", 2, localStringBuilder.toString());
      }
      paramObject = new AllInOne(paramObject.uin, 1);
      paramObject.profileEntryType = 59;
      paramObject.chatEntrance = 2;
      ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramObject);
      return true;
    }
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<--doRefreshBuddyList, load=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", mIsTabSelected=");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(",needTabRefresh =");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.b)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<<--doRefreshBuddyList, return mIsTabSelected =");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, ((StringBuilder)localObject).toString());
      }
      this.f = true;
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((AlphabetFriendAdapter)localObject).a();
        return;
      }
      ((AlphabetFriendAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  private void h()
  {
    PinnedDividerListView localPinnedDividerListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
    if ((localPinnedDividerListView != null) && (localPinnedDividerListView.getFooterViewsCount() <= 0))
    {
      if (this.c == null)
      {
        if (getActivity() == null)
        {
          QLog.e("contacts.fragment.AlphabetFriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
          return;
        }
        this.c = LayoutInflater.from(getActivity()).inflate(2131558895, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addFooterView(this.c);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "getView ");
    }
    paramBundle = this.jdField_a_of_type_AndroidViewView;
    if (paramBundle == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558910, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362666));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar = ((IndexBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368761));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout = ((IndexBarTipsLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368762));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setOnIndexBarTouchListener(this);
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnDestroy.");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    e();
    AlphabetFriendAdapter localAlphabetFriendAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter;
    if (localAlphabetFriendAdapter != null) {
      localAlphabetFriendAdapter.e();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged bindState=");
      localStringBuilder.append(paramInt);
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString, int paramInt, float paramFloat)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener != null) && (paramInt == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener.ad_();
    }
    ReportController.b(null, "dc00898", "", "", "0X800A1F8", "0X800A1F8", 0, 0, "", "", "", "");
    IndexBarTipsLayout localIndexBarTipsLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout;
    if (localIndexBarTipsLayout != null) {
      localIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      if ("★".equals(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      }
      else
      {
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter.a(paramString);
        if (paramInt != -1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
          paramString.setSelection(paramInt + paramString.getHeaderViewsCount());
        }
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnResume. tabChange:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",mListView=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
      localStringBuilder.append(", mAdapter=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter);
      localStringBuilder.append(", needTabRefresh=");
      localStringBuilder.append(this.f);
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, localStringBuilder.toString());
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
  
  public void ae_()
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (localObject != null) {
      ((IndexBar)localObject).setLetters(null);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter;
    if (localObject != null)
    {
      ((AlphabetFriendAdapter)localObject).d();
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
    IndexBarTipsLayout localIndexBarTipsLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout;
    if (localIndexBarTipsLayout != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      localIndexBarTipsLayout.setVisibility(i);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyMessageObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$StatusIconListener);
    }
    ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$MyMessageObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$StatusIconListener);
    }
    ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
  }
  
  public void f() {}
  
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
    paramView.getId();
    if (!Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      BuddyListItem.ViewTag localViewTag = (BuddyListItem.ViewTag)paramView.getTag();
      if ((localViewTag != null) && (localViewTag.a != null)) {
        a(localViewTag.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment
 * JD-Core Version:    0.7.0.1
 */