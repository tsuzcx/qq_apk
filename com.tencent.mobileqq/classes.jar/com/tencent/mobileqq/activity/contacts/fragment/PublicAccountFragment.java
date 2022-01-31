package com.tencent.mobileqq.activity.contacts.fragment;

import affj;
import affk;
import affl;
import affm;
import affn;
import affo;
import affp;
import affq;
import affs;
import ajed;
import ajho;
import ajjh;
import ajoy;
import ajpe;
import akaq;
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
import apyq;
import awqx;
import bbjs;
import bcpn;
import beez;
import behi;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ndn;
import rtr;
import rww;
import vvy;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements bbjs, behi
{
  protected affq a;
  private ajjh jdField_a_of_type_Ajjh = new affn(this);
  protected ajoy a;
  private ajpe jdField_a_of_type_Ajpe = new affo(this);
  public Drawable a;
  protected Handler.Callback a;
  protected View a;
  protected IndexView a;
  public PinnedDividerListView a;
  private Comparator<affp> jdField_a_of_type_JavaUtilComparator = new affm(this);
  public List<affp> a;
  protected MqqHandler a;
  protected View c;
  private boolean c;
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new affj(this);
  }
  
  private affp a(PublicAccountInfo paramPublicAccountInfo)
  {
    affp localaffp = new affp(paramPublicAccountInfo);
    localaffp.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localaffp.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localaffp;
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
        localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131300079);
      } while (localViewStub == null);
      this.jdField_c_of_type_AndroidViewView = localViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.findViewById(2131309963).setOnClickListener(new affk(this));
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
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
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493274, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306403));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302454));
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
    if (this.jdField_a_of_type_Affq != null) {
      this.jdField_a_of_type_Affq.c();
    }
    this.jdField_a_of_type_Affq = null;
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
      i = this.jdField_a_of_type_Affq.a(paramString);
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
      if (this.jdField_a_of_type_Affq == null)
      {
        this.jdField_a_of_type_Affq = new affq(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Affq);
      }
      if (this.jdField_a_of_type_Ajoy == null) {
        this.jdField_a_of_type_Ajoy = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
      }
    } while (this.jdField_a_of_type_Ajoy == null);
    if (this.jdField_a_of_type_Ajoy.a)
    {
      this.jdField_a_of_type_AndroidViewView.postDelayed(new PublicAccountFragment.2(this), 200L);
      return;
    }
    h();
  }
  
  public void aq_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
    }
    Object localObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (localObject != null)
    {
      ((PublicAccountHandler)localObject).c();
      ((PublicAccountHandler)localObject).a();
    }
    localObject = (ajho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localObject != null) {
      ((ajho)localObject).a(SystemClock.uptimeMillis());
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
      if (this.jdField_a_of_type_Affq != null)
      {
        this.jdField_a_of_type_Affq.a();
        this.jdField_a_of_type_Affq.c();
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Affq = new affq(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Affq);
        i();
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajpe);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajpe);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_Affq != null)
      {
        this.jdField_a_of_type_Affq.a();
        this.jdField_a_of_type_Affq.c();
        this.jdField_a_of_type_Affq.notifyDataSetChanged();
        this.jdField_a_of_type_Affq = null;
      }
      this.jdField_a_of_type_Ajoy = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new PublicAccountFragment.4(this), 5, new affl(this), true);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Affq == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_Ajoy == null) {
      this.jdField_a_of_type_Ajoy = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Affq.a();
    this.jdField_a_of_type_Affq.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_Ajoy.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bcpn localbcpn = (bcpn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((!ajed.aP.equals(localPublicAccountInfo.getUin())) && (!ajed.aQ.equals(localPublicAccountInfo.getUin())) && ((localbcpn == null) || (!localbcpn.f(localPublicAccountInfo.getUin())))) {
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_Affq.b();
      this.jdField_a_of_type_Affq.notifyDataSetChanged();
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
    if ((paramView instanceof affs)) {
      paramAdapterView = ((affs)paramView).a;
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
      if (rtr.a(paramAdapterView.a.accountFlag2) == -10L)
      {
        vvy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
        return;
      }
      if (paramAdapterView.a.extendType == 2)
      {
        localIntent.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      if (TextUtils.equals(paramView, ajed.aO))
      {
        rww.a(getActivity(), "from_user_contacts", 3, false);
        return;
      }
    } while ((TextUtils.equals(paramView, "2290230341")) && (QZoneMsgActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    if ((TextUtils.equals(paramView, "2747277822")) && (apyq.a()))
    {
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("settingInfo", "");
      paramAdapterView.putExtra("big_brother_source_key", "biz_src_zf_games");
      paramAdapterView.putExtra("moduleId", "cmshowgame_module");
      if (apyq.b()) {
        PublicFragmentActivityForTool.b(getActivity(), paramAdapterView, QQGameFeedWebFragment.class, 10000);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("2747277822", 1008, false);
        return;
        PublicFragmentActivity.a(getActivity(), paramAdapterView, QQGamePubAccountFragment.class, 10000);
      }
    }
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131629842));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */