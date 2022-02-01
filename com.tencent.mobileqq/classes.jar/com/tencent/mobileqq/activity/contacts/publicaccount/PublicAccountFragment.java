package com.tencent.mobileqq.activity.contacts.publicaccount;

import acmw;
import ahcf;
import ajlz;
import ajma;
import ajmb;
import ajmc;
import ajmd;
import ajme;
import ajmf;
import ajmg;
import ajmi;
import amfb;
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
import antw;
import anvi;
import aoan;
import aoav;
import arek;
import aveq;
import aves;
import ayoq;
import ayos;
import bdla;
import bhsf;
import bhxi;
import bipq;
import bjxa;
import bkyc;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import olh;
import oph;
import uuc;
import uyt;
import zqm;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements bipq, AdapterView.OnItemClickListener
{
  protected ajmg a;
  public Drawable a;
  protected Handler.Callback a;
  protected View a;
  private anvi jdField_a_of_type_Anvi = new ajmd(this);
  protected aoan a;
  private aoav jdField_a_of_type_Aoav = new ajme(this);
  protected IndexView a;
  public PinnedDividerListView a;
  private Comparator<ajmf> jdField_a_of_type_JavaUtilComparator = new ajmc(this);
  public List<ajmf> a;
  protected MqqHandler a;
  protected View c;
  private boolean c;
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new ajlz(this);
  }
  
  private ajmf a(PublicAccountInfo paramPublicAccountInfo)
  {
    ajmf localajmf = new ajmf(paramPublicAccountInfo);
    localajmf.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localajmf.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localajmf;
  }
  
  private void j()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {}
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131366179);
      } while (localViewStub == null);
      this.jdField_c_of_type_AndroidViewView = localViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.findViewById(2131377214).setOnClickListener(new ajma(this));
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
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
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558977, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373321));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368807));
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
    if (this.jdField_a_of_type_Ajmg != null) {
      this.jdField_a_of_type_Ajmg.c();
    }
    this.jdField_a_of_type_Ajmg = null;
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
      i = this.jdField_a_of_type_Ajmg.a(paramString);
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
      if (this.jdField_a_of_type_Ajmg == null)
      {
        this.jdField_a_of_type_Ajmg = new ajmg(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajmg);
      }
      if (this.jdField_a_of_type_Aoan == null) {
        this.jdField_a_of_type_Aoan = ((aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER));
      }
    } while (this.jdField_a_of_type_Aoan == null);
    if (this.jdField_a_of_type_Aoan.a)
    {
      this.jdField_a_of_type_AndroidViewView.postDelayed(new PublicAccountFragment.2(this), 200L);
      return;
    }
    h();
  }
  
  public void ah_()
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
    localObject = (antw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    if (localObject != null) {
      ((antw)localObject).a(SystemClock.uptimeMillis());
    }
    this.jdField_c_of_type_Boolean = true;
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
      if (this.jdField_a_of_type_Ajmg != null)
      {
        this.jdField_a_of_type_Ajmg.a();
        this.jdField_a_of_type_Ajmg.c();
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Ajmg = new ajmg(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajmg);
        i();
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoav);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoav);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_Ajmg != null)
      {
        this.jdField_a_of_type_Ajmg.a();
        this.jdField_a_of_type_Ajmg.c();
        this.jdField_a_of_type_Ajmg.notifyDataSetChanged();
        this.jdField_a_of_type_Ajmg = null;
      }
      this.jdField_a_of_type_Aoan = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new PublicAccountFragment.4(this), 5, new ajmb(this), true);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ajmg == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_Aoan == null) {
      this.jdField_a_of_type_Aoan = ((aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ajmg.a();
    this.jdField_a_of_type_Ajmg.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_Aoan.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bjxa localbjxa = (bjxa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(localPublicAccountInfo.getUin())) && (!AppConstants.KANDIAN_DAILY_UIN.equals(localPublicAccountInfo.getUin())) && ((localbjxa == null) || (!localbjxa.f(localPublicAccountInfo.getUin())))) {
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_Ajmg.b();
      this.jdField_a_of_type_Ajmg.notifyDataSetChanged();
      return;
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    paramView = paramView.getTag();
    if ((paramView instanceof ajmi)) {
      paramAdapterView = ((ajmi)paramView).a;
    }
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
        } while (((ahcf.a(paramView)) && (amfb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || ((bhxi.a(paramView)) && (bhxi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAdapterView.a.name, 161))));
        if (uuc.a(paramAdapterView.a.accountFlag2) == -10L)
        {
          zqm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
          return;
        }
        if (paramAdapterView.a.extendType == 2)
        {
          localIntent.putExtra("chat_subType", 1);
          paramInt = 0;
        }
        if (TextUtils.equals(paramView, AppConstants.WEISHI_UIN))
        {
          uyt.a(getActivity(), "from_user_contacts", 3, false);
          return;
        }
        if (TextUtils.equals(paramView, AppConstants.TIM_TEAM_UIN))
        {
          uuc.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      } while ((TextUtils.equals(paramView, "2290230341")) && (QZoneMsgActivity.open(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      if ((TextUtils.equals(paramView, "2747277822")) && (aveq.a()))
      {
        aves.b(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("2747277822", 1008, false);
        return;
      }
      if (MiniGamePublicAccountHelper.shouldOpenWebFragment(paramView))
      {
        MiniGamePublicAccountHelper.launchMiniGamePublicAccount(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
        return;
      }
      if ((TextUtils.equals(paramView, AppConstants.QQ_VIP_UIN)) && (bhsf.b(getActivity())))
      {
        bhsf.a(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.QQ_VIP_UIN, 1008, false);
        return;
      }
      if ((TextUtils.equals(paramView, ayoq.a)) && (ayos.a(getActivity(), paramView, 4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(ayoq.a, 1008, false);
        return;
      }
      if (TextUtils.equals("3046055438", paramView))
      {
        oph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("3046055438", 1008, false);
        return;
      }
    } while (QQComicConfBean.a().a(paramView, getActivity(), 1035, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131694937));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */