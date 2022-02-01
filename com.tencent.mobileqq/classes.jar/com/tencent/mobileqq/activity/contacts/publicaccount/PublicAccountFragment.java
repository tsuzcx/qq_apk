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
  protected Drawable a;
  protected Handler.Callback a;
  protected View a;
  protected IPublicAccountDataManager a;
  private IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
  protected PublicAccountFragment.ListAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PublicAccountFragment.8(this);
  protected IndexView a;
  protected PinnedDividerListView a;
  private Comparator<PublicAccountFragment.InnerPAInfo> jdField_a_of_type_JavaUtilComparator = new PublicAccountFragment.7(this);
  protected List<PublicAccountFragment.InnerPAInfo> a;
  protected MqqHandler a;
  protected View c;
  private boolean d = false;
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = null;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new PublicAccountFragment.1(this);
  }
  
  private PublicAccountFragment.InnerPAInfo a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountFragment.InnerPAInfo localInnerPAInfo = new PublicAccountFragment.InnerPAInfo(paramPublicAccountInfo);
    localInnerPAInfo.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localInnerPAInfo.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localInnerPAInfo;
  }
  
  private void j()
  {
    if (this.c == null)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        return;
      }
      localObject = (ViewStub)((View)localObject).findViewById(2131366238);
      if (localObject == null) {
        return;
      }
      this.c = ((ViewStub)localObject).inflate();
      this.c.findViewById(2131377072).setOnClickListener(new PublicAccountFragment.4(this));
    }
    this.c.setVisibility(0);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "getView");
    }
    paramBundle = this.jdField_a_of_type_AndroidViewView;
    if (paramBundle == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558912, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373218));
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramLayoutInflater.mForContacts = true;
      paramLayoutInflater.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368761));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
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
    e();
    PublicAccountFragment.ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter;
    if (localListAdapter != null) {
      localListAdapter.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = null;
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(new PublicAccountFragment.2(this));
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = new PublicAccountFragment.ListAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager = ((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all"));
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager;
    if (localObject != null)
    {
      if (((IPublicAccountDataManager)localObject).isCached())
      {
        this.jdField_a_of_type_AndroidViewView.postDelayed(new PublicAccountFragment.3(this), 200L);
        return;
      }
      h();
    }
  }
  
  public void ae_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
    }
    Object localObject = (IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localObject != null)
    {
      ((IPublicAccountHandler)localObject).clearPublicAccountSeq();
      ((IPublicAccountHandler)localObject).getUserFollowList();
    }
    localObject = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    if (localObject != null) {
      ((EnterpriseQQHandler)localObject).a(SystemClock.uptimeMillis());
    }
    this.d = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    }
  }
  
  public void c()
  {
    if (this.b)
    {
      PublicAccountFragment.ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter;
      if (localListAdapter != null)
      {
        localListAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.c();
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = new PublicAccountFragment.ListAdapter(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter);
        i();
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null) {
        ((MqqHandler)localObject).removeCallbacksAndMessages(null);
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null) {
        ((List)localObject).clear();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter;
      if (localObject != null)
      {
        ((PublicAccountFragment.ListAdapter)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = null;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new PublicAccountFragment.5(this), 5, new PublicAccountFragment.6(this), true);
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager = ((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all"));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.notifyDataSetChanged();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.getPublicAccountListNotIVR();
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      Object localObject2 = this.c;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject1).next();
        if ((!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(localPublicAccountInfo.getUin())) && (!AppConstants.KANDIAN_DAILY_UIN.equals(localPublicAccountInfo.getUin())) && ((localObject2 == null) || (!((QidianManager)localObject2).f(localPublicAccountInfo.getUin())))) {
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.notifyDataSetChanged();
      return;
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
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
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
    if (TextUtils.isEmpty(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - uin = null");
      }
      return;
    }
    Object localObject = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
    if ((((IWeatherCommApi)localObject).isWeatherPA(paramView)) && (((IWeatherCommApi)localObject).startNewWeatherWebPageActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return;
    }
    if ((((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(paramView)) && (((IQQHealthService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQHealthService.class)).redirectAIOToMainPage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramAdapterView.a.name, 161))) {
      return;
    }
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramAdapterView.a.accountFlag2) == -10L)
    {
      SubscribeLaucher.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
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
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if ((TextUtils.equals(paramView, "2290230341")) && (((IQzoneMsgApi)QRoute.api(IQzoneMsgApi.class)).open(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return;
    }
    if ((TextUtils.equals(paramView, "2747277822")) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
    {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(getBaseActivity(), 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("2747277822", 1008, false);
      return;
    }
    localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if (((IMiniAppService)localObject).shouldOpenWebFragment(paramView))
    {
      ((IMiniAppService)localObject).launchMiniGamePublicAccount(getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
      return;
    }
    if ((TextUtils.equals(paramView, AppConstants.QQ_VIP_UIN)) && (QQVipHelper.b(getBaseActivity())))
    {
      QQVipHelper.a(getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.QQ_VIP_UIN, 1008, false);
      return;
    }
    if ((TextUtils.equals(paramView, NowQQLiveConstant.a)) && (NowQQLiveHelper.a(getBaseActivity(), paramView, 4)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(NowQQLiveConstant.a, 1008, false);
      return;
    }
    if (TextUtils.equals("3046055438", paramView))
    {
      ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).jump(getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("3046055438", 1008, false);
      return;
    }
    if (((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).launchIfMatched(paramView, getBaseActivity(), 1035, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return;
    }
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131695165));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */