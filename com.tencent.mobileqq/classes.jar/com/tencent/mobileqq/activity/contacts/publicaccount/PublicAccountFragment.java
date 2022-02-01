package com.tencent.mobileqq.activity.contacts.publicaccount;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements IndexView.OnIndexChangedListener, AdapterView.OnItemClickListener
{
  protected View a;
  protected PinnedDividerListView b;
  protected IndexView c;
  protected View d;
  protected PublicAccountFragment.ListAdapter e = null;
  protected IPublicAccountDataManager f;
  protected MqqHandler g;
  protected List<PublicAccountFragment.InnerPAInfo> h;
  protected Drawable i;
  protected Handler.Callback j = new PublicAccountFragment.1(this);
  private boolean k = false;
  private Comparator<PublicAccountFragment.InnerPAInfo> l = new PublicAccountFragment.7(this);
  private FriendListObserver m = new PublicAccountFragment.8(this);
  private IPublicAccountObserver n;
  
  private PublicAccountFragment.InnerPAInfo a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountFragment.InnerPAInfo localInnerPAInfo = new PublicAccountFragment.InnerPAInfo(paramPublicAccountInfo);
    localInnerPAInfo.a(ChnToSpell.b(paramPublicAccountInfo.name, 2));
    localInnerPAInfo.b(ChnToSpell.b(paramPublicAccountInfo.name, 1));
    return localInnerPAInfo;
  }
  
  private void l()
  {
    if (this.d == null)
    {
      Object localObject = this.a;
      if (localObject == null) {
        return;
      }
      localObject = (ViewStub)((View)localObject).findViewById(2131432530);
      if (localObject == null) {
        return;
      }
      this.d = ((ViewStub)localObject).inflate();
      this.d.findViewById(2131445441).setOnClickListener(new PublicAccountFragment.4(this));
    }
    this.d.setVisibility(0);
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "getView");
    }
    paramBundle = this.a;
    if (paramBundle == null)
    {
      this.a = paramLayoutInflater.inflate(2131624542, null, false);
      this.b = ((PinnedDividerListView)this.a.findViewById(2131440827));
      paramLayoutInflater = this.b;
      paramLayoutInflater.mForContacts = true;
      paramLayoutInflater.setOnItemClickListener(this);
      this.c = ((IndexView)this.a.findViewById(2131435678));
      this.c.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.c.setOnIndexChangedListener(this);
      this.c.setVisibility(8);
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
    e();
    PublicAccountFragment.ListAdapter localListAdapter = this.e;
    if (localListAdapter != null) {
      localListAdapter.d();
    }
    this.e = null;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Contacts.PublicAccountFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.n == null)
    {
      this.n = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
      this.n.setOnCallback(new PublicAccountFragment.2(this));
    }
    if (this.a == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.e == null)
    {
      this.e = new PublicAccountFragment.ListAdapter(this);
      this.b.setAdapter(this.e);
    }
    if (this.f == null) {
      this.f = ((IPublicAccountDataManager)this.s.getRuntimeService(IPublicAccountDataManager.class, "all"));
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((IPublicAccountDataManager)localObject).isCached())
      {
        this.a.postDelayed(new PublicAccountFragment.3(this), 200L);
        return;
      }
      j();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e();
      this.b.setVisibility(4);
      this.c.setVisibility(4);
    }
  }
  
  public void bU_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
    }
    Object localObject = (IPublicAccountHandler)this.s.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localObject != null)
    {
      ((IPublicAccountHandler)localObject).clearPublicAccountSeq();
      ((IPublicAccountHandler)localObject).getUserFollowList();
    }
    localObject = (EnterpriseQQHandler)this.s.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    if (localObject != null) {
      ((EnterpriseQQHandler)localObject).a(SystemClock.uptimeMillis());
    }
    this.k = true;
  }
  
  public void c()
  {
    if (this.v)
    {
      PublicAccountFragment.ListAdapter localListAdapter = this.e;
      if (localListAdapter != null)
      {
        localListAdapter.b();
        this.e.d();
      }
      if (this.a != null)
      {
        this.e = new PublicAccountFragment.ListAdapter(this);
        this.b.setAdapter(this.e);
        k();
      }
    }
  }
  
  protected void d()
  {
    if ((this.s != null) && (this.v))
    {
      this.s.addObserver(this.m);
      this.s.addObserver(this.n.getBusinessObserver());
      if (this.g == null)
      {
        this.g = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.j);
        this.s.setHandler(getClass(), this.g);
      }
    }
  }
  
  protected void e()
  {
    if (this.s != null)
    {
      this.s.removeObserver(this.m);
      if (this.n != null) {
        this.s.removeObserver(this.n.getBusinessObserver());
      }
      this.s.removeHandler(getClass());
      Object localObject = this.g;
      if (localObject != null) {
        ((MqqHandler)localObject).removeCallbacksAndMessages(null);
      }
      localObject = this.h;
      if (localObject != null) {
        ((List)localObject).clear();
      }
      localObject = this.e;
      if (localObject != null)
      {
        ((PublicAccountFragment.ListAdapter)localObject).b();
        this.e.d();
        this.e.notifyDataSetChanged();
        this.e = null;
      }
      this.f = null;
    }
  }
  
  public View getScrollableView()
  {
    return this.b;
  }
  
  protected void j()
  {
    ThreadManager.post(new PublicAccountFragment.5(this), 5, new PublicAccountFragment.6(this), true);
  }
  
  protected void k()
  {
    if (this.e == null) {
      return;
    }
    if (this.h == null) {
      this.h = new ArrayList();
    }
    if (this.f == null) {
      this.f = ((IPublicAccountDataManager)this.s.getRuntimeService(IPublicAccountDataManager.class, "all"));
    }
    this.h.clear();
    this.e.b();
    this.e.notifyDataSetChanged();
    Object localObject1 = this.f.getPublicAccountListNotIVR();
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      Object localObject2 = this.d;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      this.b.setVisibility(0);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QidianManager)this.s.getManager(QQManagerFactory.QIDIAN_MANAGER);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject1).next();
        if ((!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(localPublicAccountInfo.getUin())) && (!AppConstants.KANDIAN_DAILY_UIN.equals(localPublicAccountInfo.getUin())) && ((localObject2 == null) || (!((QidianManager)localObject2).m(localPublicAccountInfo.getUin())))) {
          this.h.add(a(localPublicAccountInfo));
        }
      }
      this.e.c();
      this.e.notifyDataSetChanged();
      return;
    }
    l();
    this.b.setVisibility(4);
    this.c.setVisibility(4);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.b.setSelection(0);
      return;
    }
    int i1 = this.e.b(paramString);
    if (i1 != -1)
    {
      paramString = this.b;
      paramString.setSelection(i1 + paramString.getHeaderViewsCount());
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView instanceof PublicAccountFragment.PAViewHolder)) {
      paramAdapterView = ((PublicAccountFragment.PAViewHolder)paramAdapterView).a;
    } else {
      paramAdapterView = null;
    }
    if (paramAdapterView == null)
    {
      if (QLog.isColorLevel())
      {
        paramAdapterView = new StringBuilder();
        paramAdapterView.append("onItemClick - info = null[position = ");
        paramAdapterView.append(paramInt);
        paramAdapterView.append("]");
        QLog.w("Contacts.PublicAccountFragment", 2, paramAdapterView.toString());
      }
      return;
    }
    paramView = paramAdapterView.a.getUin();
    Intent localIntent = new Intent(this.w, ChatActivity.class);
    if (TextUtils.isEmpty(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - uin = null");
      }
      return;
    }
    Object localObject = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
    if ((((IWeatherCommApi)localObject).isWeatherPA(paramView)) && (((IWeatherCommApi)localObject).startNewWeatherWebPageActivity(this.w, this.s))) {
      return;
    }
    if (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(paramView))
    {
      boolean bool = ((IQQHealthService)this.s.getRuntimeService(IQQHealthService.class)).redirectAIOToMainPage(this.w, 165);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("health contact redirect aio to mainPage is");
      ((StringBuilder)localObject).append(bool);
      QLog.i("Contacts.PublicAccountFragment", 1, ((StringBuilder)localObject).toString());
      if (bool) {
        return;
      }
    }
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramAdapterView.a.accountFlag2) == -10L)
    {
      SubscribeLaucher.a(this.w, paramView);
      return;
    }
    if (paramAdapterView.a.extendType == 2)
    {
      localIntent.putExtra("chat_subType", 1);
      paramInt = 0;
    }
    else
    {
      paramInt = 1008;
    }
    if (TextUtils.equals(paramView, AppConstants.WEISHI_UIN))
    {
      ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(getActivity(), "from_user_contacts", false);
      return;
    }
    if (TextUtils.equals(paramView, AppConstants.TIM_TEAM_UIN))
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam(getBaseActivity(), this.s);
      return;
    }
    if ((TextUtils.equals(paramView, "2290230341")) && (((IQzoneMsgApi)QRoute.api(IQzoneMsgApi.class)).open(getBaseActivity(), this.s))) {
      return;
    }
    if ((TextUtils.equals(paramView, "2747277822")) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
    {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(getBaseActivity(), 1);
      this.s.getConversationFacade().a("2747277822", 1008, false);
      return;
    }
    localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if (((IMiniAppService)localObject).shouldOpenWebFragment(paramView))
    {
      ((IMiniAppService)localObject).launchMiniGamePublicAccount(getBaseActivity());
      this.s.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
      return;
    }
    if ((TextUtils.equals(paramView, AppConstants.QQ_VIP_UIN)) && (QQVipHelper.d(getBaseActivity())))
    {
      QQVipHelper.a(getBaseActivity());
      this.s.getConversationFacade().a(AppConstants.QQ_VIP_UIN, 1008, false);
      return;
    }
    if ((TextUtils.equals(paramView, NowQQLiveConstant.a)) && (NowQQLiveHelper.a(getBaseActivity(), paramView, 4)))
    {
      this.s.getConversationFacade().a(NowQQLiveConstant.a, 1008, false);
      return;
    }
    if (TextUtils.equals("3046055438", paramView))
    {
      ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).jump(getBaseActivity());
      this.s.getConversationFacade().a("3046055438", 1008, false);
      return;
    }
    if (((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).launchIfMatched(paramView, getBaseActivity(), 1035, this.s)) {
      return;
    }
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131892898));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.s, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    ReportController.b(this.s, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */