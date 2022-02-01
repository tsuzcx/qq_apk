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
  private Vibrator A;
  private Runnable B = new AlphabetFriendFragment.1(this);
  private String C = "";
  protected View a;
  protected PinnedDividerListView b;
  protected IndexBar c;
  protected IndexBarTipsLayout d;
  private boolean e = true;
  private boolean f = false;
  private View g;
  private AlphabetFriendAdapter h;
  private final AlphabetFriendFragment.MyFriendListObserver i = new AlphabetFriendFragment.MyFriendListObserver(this, null);
  private final AlphabetFriendFragment.MyFriendObserver j = new AlphabetFriendFragment.MyFriendObserver(this, null);
  private final AlphabetFriendFragment.MyAvatarObserver k = new AlphabetFriendFragment.MyAvatarObserver(this, null);
  private final AlphabetFriendFragment.MyCardObserver l = new AlphabetFriendFragment.MyCardObserver(this, null);
  private final AlphabetFriendFragment.MyProfileCardObserver m = new AlphabetFriendFragment.MyProfileCardObserver(this, null);
  private final AlphabetFriendFragment.MyMessageObserver n = new AlphabetFriendFragment.MyMessageObserver(this, null);
  private final AlphabetFriendFragment.StatusIconListener o = new AlphabetFriendFragment.StatusIconListener(this, null);
  private MqqHandler y = new MqqHandler(Looper.getMainLooper(), this);
  private boolean z = true;
  
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
    this.y.removeMessages(4);
    int i1 = 9527;
    if (paramBoolean) {
      this.y.removeMessages(9527);
    } else if (this.y.hasMessages(9527)) {
      return;
    }
    if (paramLong == 0L)
    {
      e(paramBoolean);
      return;
    }
    Object localObject = this.y;
    if (!paramBoolean) {
      i1 = 4;
    }
    ((MqqHandler)localObject).sendEmptyMessageDelayed(i1, paramLong);
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
      ProfileUtils.openProfileCard(this.w, paramObject);
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
      ((StringBuilder)localObject).append(this.v);
      ((StringBuilder)localObject).append(",needTabRefresh =");
      ((StringBuilder)localObject).append(this.z);
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.v)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<<--doRefreshBuddyList, return mIsTabSelected =");
        ((StringBuilder)localObject).append(this.v);
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, ((StringBuilder)localObject).toString());
      }
      this.z = true;
      return;
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((AlphabetFriendAdapter)localObject).b();
        return;
      }
      ((AlphabetFriendAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  private void j()
  {
    PinnedDividerListView localPinnedDividerListView = this.b;
    if ((localPinnedDividerListView != null) && (localPinnedDividerListView.getFooterViewsCount() <= 0))
    {
      if (this.g == null)
      {
        if (getActivity() == null)
        {
          QLog.e("contacts.fragment.AlphabetFriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
          return;
        }
        this.g = LayoutInflater.from(getActivity()).inflate(2131624517, this.b, false);
      }
      this.b.addFooterView(this.g);
    }
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "getView ");
    }
    paramBundle = this.a;
    if (paramBundle == null)
    {
      this.a = paramLayoutInflater.inflate(2131624540, null, false);
      this.b = ((PinnedDividerListView)this.a.findViewById(2131428289));
      this.b.mForContacts = true;
      this.c = ((IndexBar)this.a.findViewById(2131435678));
      this.d = ((IndexBarTipsLayout)this.a.findViewById(2131435679));
      this.c.setOnIndexBarTouchListener(this);
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.a);
      }
    }
    return this.a;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnDestroy.");
    }
    this.y.removeCallbacksAndMessages(null);
    e();
    AlphabetFriendAdapter localAlphabetFriendAdapter = this.h;
    if (localAlphabetFriendAdapter != null) {
      localAlphabetFriendAdapter.h();
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
    if ((this.q != null) && (paramInt == 0)) {
      this.q.bT_();
    }
    ReportController.b(null, "dc00898", "", "", "0X800A1F8", "0X800A1F8", 0, 0, "", "", "", "");
    IndexBarTipsLayout localIndexBarTipsLayout = this.d;
    if (localIndexBarTipsLayout != null) {
      localIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.C.equals(paramString))
    {
      this.C = paramString;
      if ("★".equals(paramString))
      {
        this.b.setSelection(0);
      }
      else
      {
        paramInt = this.h.a(paramString);
        if (paramInt != -1)
        {
          paramString = this.b;
          paramString.setSelection(paramInt + paramString.getHeaderViewsCount());
        }
      }
      if (this.B != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.B);
        ThreadManager.getSubThreadHandler().post(this.B);
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
      localStringBuilder.append(this.b);
      localStringBuilder.append(", mAdapter=");
      localStringBuilder.append(this.h);
      localStringBuilder.append(", needTabRefresh=");
      localStringBuilder.append(this.z);
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, localStringBuilder.toString());
    }
    if (this.b == null) {
      return;
    }
    if (this.h == null)
    {
      this.h = new AlphabetFriendAdapter(getActivity(), this.s, this.b, this.c, this);
      j();
      this.h.a(this.g);
      this.b.setAdapter(this.h);
    }
    if (this.z)
    {
      a(300L, true);
      this.z = false;
    }
    ((FriendListHandler)this.s.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(this.s.getCurrentAccountUin(), (byte)1);
    if (!this.y.hasMessages(5))
    {
      int i1 = HotReactiveHelper.a();
      this.y.sendEmptyMessageDelayed(5, i1 * 1000);
    }
    ((FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
    ReportController.b(null, "dc00898", "", "", "0X800A1F7", "0X800A1F7", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnPause.");
    }
  }
  
  public void bU_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refresh");
    }
    if (this.e) {
      ((FriendListHandler)this.s.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, true);
    }
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "updateBuddyList succeeded");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "resetData");
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((IndexBar)localObject).setLetters(null);
    }
    this.y.removeCallbacksAndMessages(null);
    localObject = this.h;
    if (localObject != null)
    {
      ((AlphabetFriendAdapter)localObject).f();
      this.h.e();
      this.h.h();
      if (this.b != null)
      {
        this.h = new AlphabetFriendAdapter(getActivity(), this.s, this.b, this.c, this);
        j();
        this.h.a(this.g);
        this.b.setAdapter(this.h);
      }
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.C = "";
    }
    IndexBarTipsLayout localIndexBarTipsLayout = this.d;
    if (localIndexBarTipsLayout != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      localIndexBarTipsLayout.setVisibility(i1);
    }
  }
  
  public void d()
  {
    this.s.addObserver(this.i);
    this.s.addObserver(this.j);
    this.s.addObserver(this.k);
    this.s.addObserver(this.l);
    this.s.addObserver(this.m);
    this.s.addObserver(this.n);
    StatusManager localStatusManager = (StatusManager)this.s.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.o);
    }
    ((IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
  }
  
  public void e()
  {
    this.s.removeObserver(this.i);
    this.s.removeObserver(this.j);
    this.s.removeObserver(this.k);
    this.s.removeObserver(this.l);
    this.s.removeObserver(this.m);
    this.s.removeObserver(this.n);
    StatusManager localStatusManager = (StatusManager)this.s.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.b(this.o);
    }
    ((IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
  }
  
  public void f() {}
  
  public View getScrollableView()
  {
    return this.b;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 4)
    {
      if (i1 != 5)
      {
        if (i1 != 9527) {
          return true;
        }
        a(0L, true);
        return true;
      }
      if (this.e)
      {
        a(0L, false);
        return true;
      }
    }
    else if (this.e)
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
      if ((localViewTag != null) && (localViewTag.c != null)) {
        a(localViewTag.c);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment
 * JD-Core Version:    0.7.0.1
 */