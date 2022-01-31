package com.tencent.mobileqq.activity.contacts.fragment;

import afrg;
import afrh;
import afri;
import afrj;
import afrk;
import afrl;
import afrm;
import afrn;
import afrp;
import ajsf;
import ajvr;
import ajxl;
import akdi;
import akdo;
import akpc;
import android.content.Intent;
import android.content.res.Resources;
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
import aqss;
import axqw;
import bcmq;
import bdto;
import bfmt;
import bfpc;
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
import noo;
import nrk;
import nrw;
import sgj;
import sjs;
import wiv;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements bcmq, bfpc
{
  protected afrn a;
  private ajxl jdField_a_of_type_Ajxl = new afrk(this);
  protected akdi a;
  private akdo jdField_a_of_type_Akdo = new afrl(this);
  public Drawable a;
  protected Handler.Callback a;
  protected View a;
  protected IndexView a;
  public PinnedDividerListView a;
  private Comparator<afrm> jdField_a_of_type_JavaUtilComparator = new afrj(this);
  public List<afrm> a;
  protected MqqHandler a;
  protected View c;
  private boolean c;
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new afrg(this);
  }
  
  private afrm a(PublicAccountInfo paramPublicAccountInfo)
  {
    afrm localafrm = new afrm(paramPublicAccountInfo);
    localafrm.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localafrm.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localafrm;
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
        localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365676);
      } while (localViewStub == null);
      this.jdField_c_of_type_AndroidViewView = localViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.findViewById(2131375724).setOnClickListener(new afrh(this));
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
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558835, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372100));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368074));
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
    if (this.jdField_a_of_type_Afrn != null) {
      this.jdField_a_of_type_Afrn.c();
    }
    this.jdField_a_of_type_Afrn = null;
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
      i = this.jdField_a_of_type_Afrn.a(paramString);
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
      if (this.jdField_a_of_type_Afrn == null)
      {
        this.jdField_a_of_type_Afrn = new afrn(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Afrn);
      }
      if (this.jdField_a_of_type_Akdi == null) {
        this.jdField_a_of_type_Akdi = ((akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
      }
    } while (this.jdField_a_of_type_Akdi == null);
    if (this.jdField_a_of_type_Akdi.a)
    {
      this.jdField_a_of_type_AndroidViewView.postDelayed(new PublicAccountFragment.2(this), 200L);
      return;
    }
    h();
  }
  
  public void an_()
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
    localObject = (ajvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localObject != null) {
      ((ajvr)localObject).a(SystemClock.uptimeMillis());
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
      if (this.jdField_a_of_type_Afrn != null)
      {
        this.jdField_a_of_type_Afrn.a();
        this.jdField_a_of_type_Afrn.c();
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Afrn = new afrn(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Afrn);
        i();
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akdo);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akdo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_Afrn != null)
      {
        this.jdField_a_of_type_Afrn.a();
        this.jdField_a_of_type_Afrn.c();
        this.jdField_a_of_type_Afrn.notifyDataSetChanged();
        this.jdField_a_of_type_Afrn = null;
      }
      this.jdField_a_of_type_Akdi = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new PublicAccountFragment.4(this), 5, new afri(this), true);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Afrn == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_Akdi == null) {
      this.jdField_a_of_type_Akdi = ((akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Afrn.a();
    this.jdField_a_of_type_Afrn.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_Akdi.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdto localbdto = (bdto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((!ajsf.aQ.equals(localPublicAccountInfo.getUin())) && (!ajsf.aR.equals(localPublicAccountInfo.getUin())) && ((localbdto == null) || (!localbdto.f(localPublicAccountInfo.getUin())))) {
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_Afrn.b();
      this.jdField_a_of_type_Afrn.notifyDataSetChanged();
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
    if ((paramView instanceof afrp)) {
      paramAdapterView = ((afrp)paramView).a;
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
      if (sgj.a(paramAdapterView.a.accountFlag2) == -10L)
      {
        wiv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
        return;
      }
      if (paramAdapterView.a.extendType == 2)
      {
        localIntent.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      if (TextUtils.equals(paramView, ajsf.aP))
      {
        sjs.a(getActivity(), "from_user_contacts", 3, false);
        return;
      }
      if (TextUtils.equals(paramView, ajsf.aU))
      {
        sgj.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while ((TextUtils.equals(paramView, "2290230341")) && (QZoneMsgActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    if ((TextUtils.equals(paramView, "2747277822")) && (aqss.a()))
    {
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("settingInfo", "");
      paramAdapterView.putExtra("big_brother_source_key", "biz_src_zf_games");
      paramAdapterView.putExtra("moduleId", "cmshowgame_module");
      if (aqss.b()) {
        PublicFragmentActivityForTool.b(getActivity(), paramAdapterView, QQGameFeedWebFragment.class, 10000);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("2747277822", 1008, false);
        return;
        PublicFragmentActivity.a(getActivity(), paramAdapterView, QQGamePubAccountFragment.class, 10000);
      }
    }
    if ((TextUtils.equals("3046055438", paramView)) && (nrw.a()))
    {
      nrk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, getResources().getString(2131691960));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("3046055438", 1008, false);
      return;
    }
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131695523));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */