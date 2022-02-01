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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.JumpUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.config.business.QQComicConfBean.ServiceAccountConfig;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vashealth.VSHealthUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import cooperation.qzone.contentbox.QZoneMsgActivity;
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
  protected PublicAccountFragment.ListAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PublicAccountFragment.7(this);
  protected PublicAccountDataManager a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new PublicAccountFragment.8(this);
  protected IndexView a;
  protected PinnedDividerListView a;
  private Comparator<PublicAccountFragment.InnerPAInfo> jdField_a_of_type_JavaUtilComparator = new PublicAccountFragment.6(this);
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
      if (this.jdField_a_of_type_AndroidViewView == null) {}
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131366350);
      } while (localViewStub == null);
      this.c = localViewStub.inflate();
      this.c.findViewById(2131377632).setOnClickListener(new PublicAccountFragment.3(this));
    }
    this.c.setVisibility(0);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "getView");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559018, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373645));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369039));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
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
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = null;
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (paramBoolean) {
        d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = new PublicAccountFragment.ListAdapter(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER));
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a)
    {
      this.jdField_a_of_type_AndroidViewView.postDelayed(new PublicAccountFragment.2(this), 200L);
      return;
    }
    h();
  }
  
  public void ag_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
    }
    Object localObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localObject != null)
    {
      ((PublicAccountHandler)localObject).c();
      ((PublicAccountHandler)localObject).a();
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.a();
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
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new PublicAccountFragment.4(this), 5, new PublicAccountFragment.5(this), true);
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$ListAdapter.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.c != null) {
        this.c.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QidianManager localQidianManager = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(localPublicAccountInfo.getUin())) && (!AppConstants.KANDIAN_DAILY_UIN.equals(localPublicAccountInfo.getUin())) && ((localQidianManager == null) || (!localQidianManager.f(localPublicAccountInfo.getUin())))) {
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
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView instanceof PublicAccountFragment.PAViewHolder)) {}
    for (paramAdapterView = ((PublicAccountFragment.PAViewHolder)paramAdapterView).a;; paramAdapterView = null)
    {
      if (paramAdapterView == null) {
        if (QLog.isColorLevel()) {
          QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - info = null[position = " + paramInt + "]");
        }
      }
      Intent localIntent;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramView = paramAdapterView.a.getUin();
              localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
              paramInt = 1008;
              if (!TextUtils.isEmpty(paramView)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - uin = null");
            return;
          } while (((PAWeatherItemBuilder.a(paramView)) && (WeatherWebPageHelperKt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || ((VSHealthUtil.a(paramView)) && (VSHealthUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAdapterView.a.name, 161))));
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
          if (TextUtils.equals(paramView, AppConstants.WEISHI_UIN))
          {
            ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(getActivity(), "from_user_contacts", false);
            return;
          }
          if (TextUtils.equals(paramView, AppConstants.TIM_TEAM_UIN))
          {
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
          }
        } while ((TextUtils.equals(paramView, "2290230341")) && (QZoneMsgActivity.open(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
        if ((TextUtils.equals(paramView, "2747277822")) && (QQGameConfigUtil.b()))
        {
          QQGameHelper.a(getActivity());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("2747277822", 1008, false);
          return;
        }
        IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
        if (localIMiniAppService.shouldOpenWebFragment(paramView))
        {
          localIMiniAppService.launchMiniGamePublicAccount(getActivity());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
          return;
        }
        if ((TextUtils.equals(paramView, AppConstants.QQ_VIP_UIN)) && (QQVipHelper.b(getActivity())))
        {
          QQVipHelper.a(getActivity());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.QQ_VIP_UIN, 1008, false);
          return;
        }
        if ((TextUtils.equals(paramView, NowQQLiveConstant.a)) && (NowQQLiveHelper.a(getActivity(), paramView, 4)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(NowQQLiveConstant.a, 1008, false);
          return;
        }
        if (TextUtils.equals("3046055438", paramView))
        {
          JumpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("3046055438", 1008, false);
          return;
        }
      } while (QQComicConfBean.a().a(paramView, getActivity(), 1035, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      localIntent.putExtra("uin", paramView);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramAdapterView.a.name);
      localIntent.putExtra("selfSet_leftViewText", getString(2131695175));
      localIntent.putExtra("jump_from", 3);
      startActivity(localIntent);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */