package com.tencent.mobileqq.activity.contacts.publicaccount;

import abwp;
import agjp;
import aiqk;
import aiql;
import aiqm;
import aiqn;
import aiqo;
import aiqp;
import aiqq;
import aiqr;
import aiqt;
import alhb;
import amri;
import amsu;
import amxz;
import amyh;
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
import aqbh;
import atzb;
import atzd;
import axil;
import axin;
import bcef;
import bgjk;
import bgmy;
import bhey;
import bily;
import bjmp;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
import odq;
import ohn;
import ugf;
import ukw;
import zbh;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements bhey, AdapterView.OnItemClickListener
{
  protected aiqr a;
  private amsu jdField_a_of_type_Amsu = new aiqo(this);
  protected amxz a;
  private amyh jdField_a_of_type_Amyh = new aiqp(this);
  public Drawable a;
  protected Handler.Callback a;
  protected View a;
  protected IndexView a;
  public PinnedDividerListView a;
  private Comparator<aiqq> jdField_a_of_type_JavaUtilComparator = new aiqn(this);
  public List<aiqq> a;
  protected MqqHandler a;
  protected View c;
  private boolean c;
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new aiqk(this);
  }
  
  private aiqq a(PublicAccountInfo paramPublicAccountInfo)
  {
    aiqq localaiqq = new aiqq(paramPublicAccountInfo);
    localaiqq.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localaiqq.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localaiqq;
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
        localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131366078);
      } while (localViewStub == null);
      this.jdField_c_of_type_AndroidViewView = localViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.findViewById(2131376942).setOnClickListener(new aiql(this));
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
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558950, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373110));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368648));
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
    if (this.jdField_a_of_type_Aiqr != null) {
      this.jdField_a_of_type_Aiqr.c();
    }
    this.jdField_a_of_type_Aiqr = null;
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
      i = this.jdField_a_of_type_Aiqr.a(paramString);
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
      if (this.jdField_a_of_type_Aiqr == null)
      {
        this.jdField_a_of_type_Aiqr = new aiqr(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aiqr);
      }
      if (this.jdField_a_of_type_Amxz == null) {
        this.jdField_a_of_type_Amxz = ((amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
      }
    } while (this.jdField_a_of_type_Amxz == null);
    if (this.jdField_a_of_type_Amxz.a)
    {
      this.jdField_a_of_type_AndroidViewView.postDelayed(new PublicAccountFragment.2(this), 200L);
      return;
    }
    h();
  }
  
  public void af_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
    }
    Object localObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(11);
    if (localObject != null)
    {
      ((PublicAccountHandler)localObject).c();
      ((PublicAccountHandler)localObject).a();
    }
    localObject = (amri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(21);
    if (localObject != null) {
      ((amri)localObject).a(SystemClock.uptimeMillis());
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
      if (this.jdField_a_of_type_Aiqr != null)
      {
        this.jdField_a_of_type_Aiqr.a();
        this.jdField_a_of_type_Aiqr.c();
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Aiqr = new aiqr(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aiqr);
        i();
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amyh);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amyh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_Aiqr != null)
      {
        this.jdField_a_of_type_Aiqr.a();
        this.jdField_a_of_type_Aiqr.c();
        this.jdField_a_of_type_Aiqr.notifyDataSetChanged();
        this.jdField_a_of_type_Aiqr = null;
      }
      this.jdField_a_of_type_Amxz = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new PublicAccountFragment.4(this), 5, new aiqm(this), true);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Aiqr == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_Amxz == null) {
      this.jdField_a_of_type_Amxz = ((amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aiqr.a();
    this.jdField_a_of_type_Aiqr.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_Amxz.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bily localbily = (bily)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(localPublicAccountInfo.getUin())) && (!AppConstants.KANDIAN_DAILY_UIN.equals(localPublicAccountInfo.getUin())) && ((localbily == null) || (!localbily.f(localPublicAccountInfo.getUin())))) {
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_Aiqr.b();
      this.jdField_a_of_type_Aiqr.notifyDataSetChanged();
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
    if ((paramView instanceof aiqt)) {
      paramAdapterView = ((aiqt)paramView).a;
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
        } while (((agjp.a(paramView)) && (alhb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || ((bgmy.a(paramView)) && (bgmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAdapterView.a.name, 161))));
        if (ugf.a(paramAdapterView.a.accountFlag2) == -10L)
        {
          zbh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
          return;
        }
        if (paramAdapterView.a.extendType == 2)
        {
          localIntent.putExtra("chat_subType", 1);
          paramInt = 0;
        }
        if (TextUtils.equals(paramView, AppConstants.WEISHI_UIN))
        {
          ukw.a(getActivity(), "from_user_contacts", 3, false);
          return;
        }
        if (TextUtils.equals(paramView, AppConstants.TIM_TEAM_UIN))
        {
          ugf.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      } while ((TextUtils.equals(paramView, "2290230341")) && (QZoneMsgActivity.open(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      if ((TextUtils.equals(paramView, "2747277822")) && (atzb.a()))
      {
        atzd.b(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("2747277822", 1008, false);
        return;
      }
      if (MiniGamePublicAccountHelper.shouldOpenWebFragment(paramView))
      {
        MiniGamePublicAccountHelper.launchMiniGamePublicAccount(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
        return;
      }
      if ((TextUtils.equals(paramView, AppConstants.QQ_VIP_UIN)) && (bgjk.b(getActivity())))
      {
        bgjk.a(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.QQ_VIP_UIN, 1008, false);
        return;
      }
      if ((TextUtils.equals(paramView, axil.a)) && (axin.a(getActivity(), paramView, 4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(axil.a, 1008, false);
        return;
      }
      if (TextUtils.equals("3046055438", paramView))
      {
        ohn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("3046055438", 1008, false);
        return;
      }
    } while (QQComicConfBean.a().a(paramView, getActivity(), 1035, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131694734));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */