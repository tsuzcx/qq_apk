package com.tencent.mobileqq.activity.contacts.alphabet;

import ajry;
import ajse;
import ajsf;
import ajsg;
import ajsh;
import ajsj;
import ajsp;
import ajti;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import anyw;
import axfs;
import axtp;
import bbvd;
import bdll;
import bhjx;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class AlphabetFriendFragment
  extends ContactsBaseFragment
  implements ajsj, Handler.Callback, View.OnClickListener, axfs
{
  private ajry jdField_a_of_type_Ajry;
  private final ajse jdField_a_of_type_Ajse = new ajse(this, null);
  private final ajsf jdField_a_of_type_Ajsf = new ajsf(this, null);
  private final ajsg jdField_a_of_type_Ajsg = new ajsg(this, null);
  private final ajsh jdField_a_of_type_Ajsh = new ajsh(this, null);
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  protected View a;
  protected IndexBar a;
  protected IndexBarTipsLayout a;
  protected PinnedDividerListView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AlphabetFriendFragment.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  private boolean e = true;
  
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
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, load=" + paramBoolean + ", mIsTabSelected=" + this.b + ",needTabRefresh =" + this.e);
    }
    if (!this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, return mIsTabSelected =" + this.b);
      }
      this.e = true;
    }
    while (this.jdField_a_of_type_Ajry == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ajry.a();
      return;
    }
    this.jdField_a_of_type_Ajry.notifyDataSetChanged();
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFooterViewsCount() <= 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        break label61;
      }
      if (getActivity() == null) {
        QLog.e("contacts.fragment.AlphabetFriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558925, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    label61:
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addFooterView(this.jdField_c_of_type_AndroidViewView);
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
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558940, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362665));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar = ((IndexBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368624));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout = ((IndexBarTipsLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368625));
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
    if (this.jdField_a_of_type_Ajry != null) {
      this.jdField_a_of_type_Ajry.e();
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
    if ((this.jdField_a_of_type_Ajti != null) && (paramInt == 0)) {
      this.jdField_a_of_type_Ajti.ao_();
    }
    bdll.b(null, "dc00898", "", "", "0X800A1F8", "0X800A1F8", 0, 0, "", "", "", "");
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
      paramInt = this.jdField_a_of_type_Ajry.a(paramString);
      if (paramInt != -1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(paramInt + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnResume. tabChange:" + paramBoolean + ",mListView=" + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView + ", mAdapter=" + this.jdField_a_of_type_Ajry + ", needTabRefresh=" + this.e);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView == null) {
      return;
    }
    if (this.jdField_a_of_type_Ajry == null)
    {
      this.jdField_a_of_type_Ajry = new ajry(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar, this);
      h();
      this.jdField_a_of_type_Ajry.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajry);
    }
    if (this.e)
    {
      a(300L, true);
      this.e = false;
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)1);
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5))
    {
      int i = axtp.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, i * 1000);
    }
    ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(true);
    bdll.b(null, "dc00898", "", "", "0X800A1F7", "0X800A1F7", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void ap_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refresh");
    }
    if (this.jdField_c_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true, true);
    }
    this.d = true;
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
    if (this.jdField_a_of_type_Ajry != null)
    {
      this.jdField_a_of_type_Ajry.d();
      this.jdField_a_of_type_Ajry.c();
      this.jdField_a_of_type_Ajry.e();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null)
      {
        this.jdField_a_of_type_Ajry = new ajry(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar, this);
        h();
        this.jdField_a_of_type_Ajry.a(this.jdField_c_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajry);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsf);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajse);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsg);
    bbvd localbbvd = (bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if (localbbvd != null) {
      localbbvd.a(this.jdField_a_of_type_Ajsh);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsf);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajse);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsg);
    bbvd localbbvd = (bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if (localbbvd != null) {
      localbbvd.b(this.jdField_a_of_type_Ajsh);
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
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
      } while (!this.jdField_c_of_type_Boolean);
      a(0L, false);
      return true;
      a(0L, true);
      return true;
    } while (!this.jdField_c_of_type_Boolean);
    a(0L, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    if (bhjx.a("tag_swip_icon_menu_item", paramView.getTag())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ajsp localajsp = (ajsp)paramView.getTag();
      if ((localajsp != null) && (localajsp.a != null)) {
        a(localajsp.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment
 * JD-Core Version:    0.7.0.1
 */