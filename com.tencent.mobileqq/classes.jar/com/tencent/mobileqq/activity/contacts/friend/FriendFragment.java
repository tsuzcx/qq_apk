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
  protected ContactsFPSPinnedHeaderExpandableListView a;
  protected BuddyListAdapter b;
  private boolean c = true;
  private boolean d = false;
  private final FriendFragment.MyFriendListObserver e = new FriendFragment.MyFriendListObserver(this, null);
  private final FriendFragment.MyFriendObserver f = new FriendFragment.MyFriendObserver(this, null);
  private final FriendFragment.MyAvatarObserver g = new FriendFragment.MyAvatarObserver(this, null);
  private final FriendFragment.MyCardObserver h = new FriendFragment.MyCardObserver(this, null);
  private final FriendFragment.MyProfileCardObserver i = new FriendFragment.MyProfileCardObserver(this, null);
  private final FriendFragment.MyMessageObserver j = new FriendFragment.MyMessageObserver(this, null);
  private final FriendFragment.StatusIconListener k = new FriendFragment.StatusIconListener(this, null);
  private ContactBindObserver l = new FriendFragment.MyContactObserver(this, null);
  private View m;
  private MqqHandler n = new MqqHandler(Looper.getMainLooper(), this);
  
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
    this.n.removeMessages(4);
    int i1 = 9527;
    if (paramBoolean) {
      this.n.removeMessages(9527);
    } else if (this.n.hasMessages(9527)) {
      return;
    }
    if (paramLong == 0L)
    {
      c(paramBoolean);
      return;
    }
    Object localObject = this.n;
    if (!paramBoolean) {
      i1 = 4;
    }
    ((MqqHandler)localObject).sendEmptyMessageDelayed(i1, paramLong);
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
        if (!NetworkUtil.isNetworkAvailable(this.w))
        {
          QQToast.makeText(this.w, 1, 2131889169, 1).show();
          return;
        }
        if (bool)
        {
          int i1 = ((Integer)localObject).intValue();
          paramView = (Friends)paramView;
          localObject = (FriendListHandler)this.s.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          if (i1 == BuddyListFriends.n[1])
          {
            ((FriendListHandler)localObject).setSpecialCareSwitch(1, new String[] { paramView.uin }, new boolean[] { true });
            ReportController.b(this.s, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
            return;
          }
          if (i1 == BuddyListFriends.n[0]) {
            ((FriendListHandler)localObject).setSpecialCareSwitch(1, new String[] { paramView.uin }, new boolean[] { false });
          }
        }
        else
        {
          if ((paramView instanceof TroopInfo))
          {
            paramView = (TroopInfo)paramView;
            ((ITroopCommonlyUsedHandler)this.s.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(paramView.troopcode, 1);
            new ReportTask(this.s).a("dc00899").b("Grp_set").c("Grp_contactlist").d("Clk_unstick").a(new String[] { paramView.troopuin }).a();
            return;
          }
          if ((paramView instanceof DiscussionInfo))
          {
            paramView = (DiscussionInfo)paramView;
            ((DiscussionHandler)this.s.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).e(Long.valueOf(paramView.uin).longValue());
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
    ExtensionInfo localExtensionInfo = this.s.getExtensionInfo(paramFriends.uin, false);
    if ((localExtensionInfo != null) && (localExtensionInfo.feedType == 2) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
      new ReportTask(this.s).a("dc00898").e(paramFriends.uin).c("mystatus_notice").d("contact_notice_clk").a();
    }
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == this.a)
    {
      if (paramListView.getFirstVisiblePosition() > 0) {
        this.a.setSelection(0);
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
      ProfileUtils.openProfileCard(this.w, (AllInOne)localObject);
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
    k();
    Object localObject = this.b;
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
  
  private void j()
  {
    ThreadManager.getSubThreadHandler().post(new FriendFragment.1(this));
  }
  
  private void k()
  {
    int i2 = ((FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER)).w();
    int i1 = i2;
    Object localObject;
    if (i2 <= 0)
    {
      localObject = (IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "");
      int i3 = ((IPhoneContactService)localObject).getSelfBindState();
      if (!((IPhoneContactService)localObject).isBindContactOk())
      {
        i1 = i2;
        if (i3 != 8) {}
      }
      else
      {
        i1 = i2 + ((IPhoneContactService)localObject).getBindHideNoneFriendList(false).size();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshUnusualContactsFooter ");
      ((StringBuilder)localObject).append(i1);
      QLog.i("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (i1 > 0)
    {
      if ((this.m == null) && (this.a != null)) {
        ReportController.b(this.s, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
      }
      localObject = this.a;
      if ((localObject != null) && (((ContactsFPSPinnedHeaderExpandableListView)localObject).getFooterViewsCount() <= 0))
      {
        if (this.m == null)
        {
          if (getBaseActivity() == null)
          {
            QLog.e("contacts.fragment.FriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
            return;
          }
          this.m = LayoutInflater.from(getBaseActivity()).inflate(2131624519, this.a, false);
          this.m.setOnClickListener(this);
        }
        this.a.addFooterView(this.m);
      }
      localObject = this.m;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.a;
      if ((localObject != null) && (((ContactsFPSPinnedHeaderExpandableListView)localObject).getFooterViewsCount() > 0)) {
        this.a.removeFooterView(this.m);
      }
    }
  }
  
  private void l()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetContactsList, mElvGroupingBuddies=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a != null)
    {
      localObject = this.b;
      if (localObject != null)
      {
        ((BuddyListAdapter)localObject).b();
        this.a.resetState();
      }
      this.b = new BuddyListAdapter(this.w, this.s, this.a, this);
      if (this.a.getFooterViewsCount() <= 0)
      {
        if (this.m == null)
        {
          this.m = LayoutInflater.from(getBaseActivity()).inflate(2131624519, this.a, false);
          this.m.setOnClickListener(this);
        }
        this.a.addFooterView(this.m);
      }
      localObject = this.m;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      this.a.setAdapter(this.b);
      this.a.setOnScrollListener(this.b);
    }
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getView mElvGroupingBuddies=");
      paramBundle.append(this.a);
      QLog.d("contacts.fragment.FriendFragment", 2, paramBundle.toString());
    }
    paramBundle = this.a;
    if (paramBundle == null)
    {
      if (paramLayoutInflater != null)
      {
        this.a = ((ContactsFPSPinnedHeaderExpandableListView)paramLayoutInflater.inflate(2131624541, null));
        this.a.setActTAG("actFPSFriend");
        this.a.setSelector(2131168376);
        this.a.setNeedCheckSpringback(true);
        this.a.setGroupIndicator(null);
        this.a.mForContacts = true;
      }
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.a);
      }
    }
    return this.a;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnDestroy.");
    }
    this.n.removeCallbacksAndMessages(null);
    BuddyListAdapter localBuddyListAdapter = this.b;
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
    k();
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
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(", mGroupingBuddyListAdapter=");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a == null) {
      return;
    }
    if (this.b == null) {
      l();
    }
    d();
    a(500L, true);
    ((FriendListHandler)this.s.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(this.s.getCurrentAccountUin(), (byte)1);
    Object localObject = this.b;
    int i1;
    if (localObject != null)
    {
      int i3 = ((BuddyListAdapter)localObject).getGroupCount();
      i1 = 0;
      int i2 = 0;
      while (i1 < i3)
      {
        if (this.a.isGroupExpanded(i1)) {
          i2 = 1;
        }
        i1 += 1;
      }
      if (i2 != 0) {
        j();
      }
    }
    if (!this.n.hasMessages(5))
    {
      i1 = HotReactiveHelper.a();
      this.n.sendEmptyMessageDelayed(5, i1 * 1000);
    }
    ((FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnPause.");
    }
    e();
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((ContactsFPSPinnedHeaderExpandableListView)localObject).getVisibility() == 0) {
        this.a.hideCurShowingRightView();
      }
      this.a.a();
    }
    localObject = this.b;
    if (localObject != null) {
      ((BuddyListAdapter)localObject).c();
    }
  }
  
  public void bU_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "refresh");
    }
    j();
    if (this.c) {
      ((FriendListHandler)this.s.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, true);
    }
    this.d = true;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "updateBuddyList succeeded");
    }
    ReportController.b(this.s, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "resetData");
    }
    this.n.removeCallbacksAndMessages(null);
    l();
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    this.s.addObserver(this.e);
    this.s.addObserver(this.f);
    this.s.addObserver(this.g);
    this.s.addObserver(this.h);
    this.s.addObserver(this.i);
    this.s.addObserver(this.j);
    this.s.registObserver(this.l);
    StatusManager localStatusManager = (StatusManager)this.s.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.k);
    }
    ((IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
  }
  
  public void e()
  {
    this.s.removeObserver(this.e);
    this.s.removeObserver(this.f);
    this.s.removeObserver(this.g);
    this.s.removeObserver(this.h);
    this.s.removeObserver(this.i);
    this.s.removeObserver(this.j);
    this.s.unRegistObserver(this.l);
    StatusManager localStatusManager = (StatusManager)this.s.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.b(this.k);
    }
    ((IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
  }
  
  public void f()
  {
    if (this.a != null)
    {
      BuddyListAdapter localBuddyListAdapter = this.b;
      if (localBuddyListAdapter != null)
      {
        int i2 = localBuddyListAdapter.getGroupCount();
        int i1 = 0;
        while (i1 < i2)
        {
          this.a.collapseGroup(i1);
          i1 += 1;
        }
        a(this.a);
      }
    }
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
      if (this.c)
      {
        a(0L, false);
        return true;
      }
    }
    else if (this.c)
    {
      a(0L, false);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131449129)
    {
      if (Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
      {
        a(paramView);
      }
      else
      {
        BuddyListItem.ViewTag localViewTag = (BuddyListItem.ViewTag)paramView.getTag();
        if ((localViewTag != null) && (localViewTag.c != null)) {
          a(localViewTag.c);
        }
      }
    }
    else
    {
      startActivity(new Intent(getBaseActivity(), UncommonlyUsedContactsActivity.class));
      ReportController.b(this.s, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment
 * JD-Core Version:    0.7.0.1
 */