package com.tencent.mobileqq.activity.contacts.publicaccount;

import aaej;
import adab;
import ahnc;
import ajvn;
import ajvo;
import ajvp;
import ajvq;
import ajvr;
import ajvs;
import ajvt;
import ajvu;
import ajvw;
import ammh;
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
import antf;
import anwz;
import anyu;
import aody;
import aoeg;
import arhp;
import arhq;
import avmc;
import avme;
import ayvd;
import ayvf;
import bdll;
import bicz;
import bign;
import biyw;
import bkgt;
import blha;
import bljm;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
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
import ocd;
import oga;
import tzq;
import ueg;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements biyw, bljm
{
  protected ajvu a;
  public Drawable a;
  protected Handler.Callback a;
  protected View a;
  private anyu jdField_a_of_type_Anyu = new ajvr(this);
  protected aody a;
  private aoeg jdField_a_of_type_Aoeg = new ajvs(this);
  protected IndexView a;
  public PinnedDividerListView a;
  private Comparator<ajvt> jdField_a_of_type_JavaUtilComparator = new ajvq(this);
  public List<ajvt> a;
  protected MqqHandler a;
  protected View c;
  private boolean c;
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new ajvn(this);
  }
  
  private ajvt a(PublicAccountInfo paramPublicAccountInfo)
  {
    ajvt localajvt = new ajvt(paramPublicAccountInfo);
    localajvt.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localajvt.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localajvt;
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
        localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131366048);
      } while (localViewStub == null);
      this.jdField_c_of_type_AndroidViewView = localViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.findViewById(2131377192).setOnClickListener(new ajvo(this));
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
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558942, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373140));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368624));
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
    if (this.jdField_a_of_type_Ajvu != null) {
      this.jdField_a_of_type_Ajvu.c();
    }
    this.jdField_a_of_type_Ajvu = null;
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
      i = this.jdField_a_of_type_Ajvu.a(paramString);
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
      if (this.jdField_a_of_type_Ajvu == null)
      {
        this.jdField_a_of_type_Ajvu = new ajvu(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajvu);
      }
      if (this.jdField_a_of_type_Aody == null) {
        this.jdField_a_of_type_Aody = ((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
      }
    } while (this.jdField_a_of_type_Aody == null);
    if (this.jdField_a_of_type_Aody.a)
    {
      this.jdField_a_of_type_AndroidViewView.postDelayed(new PublicAccountFragment.2(this), 200L);
      return;
    }
    h();
  }
  
  public void ap_()
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
    localObject = (anwz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localObject != null) {
      ((anwz)localObject).a(SystemClock.uptimeMillis());
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
      if (this.jdField_a_of_type_Ajvu != null)
      {
        this.jdField_a_of_type_Ajvu.a();
        this.jdField_a_of_type_Ajvu.c();
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Ajvu = new ajvu(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajvu);
        i();
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoeg);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoeg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_Ajvu != null)
      {
        this.jdField_a_of_type_Ajvu.a();
        this.jdField_a_of_type_Ajvu.c();
        this.jdField_a_of_type_Ajvu.notifyDataSetChanged();
        this.jdField_a_of_type_Ajvu = null;
      }
      this.jdField_a_of_type_Aody = null;
    }
  }
  
  protected void h()
  {
    ThreadManager.post(new PublicAccountFragment.4(this), 5, new ajvp(this), true);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ajvu == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_Aody == null) {
      this.jdField_a_of_type_Aody = ((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ajvu.a();
    this.jdField_a_of_type_Ajvu.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_Aody.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkgt localbkgt = (bkgt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((!antf.aQ.equals(localPublicAccountInfo.getUin())) && (!antf.aR.equals(localPublicAccountInfo.getUin())) && ((localbkgt == null) || (!localbkgt.f(localPublicAccountInfo.getUin())))) {
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_Ajvu.b();
      this.jdField_a_of_type_Ajvu.notifyDataSetChanged();
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
    if ((paramView instanceof ajvw)) {
      paramAdapterView = ((ajvw)paramView).a;
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
        } while (((ahnc.a(paramView)) && (ammh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || ((bign.a(paramView)) && (bign.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAdapterView.a.name, 161))));
        if (tzq.a(paramAdapterView.a.accountFlag2) == -10L)
        {
          aaej.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
          return;
        }
        if (paramAdapterView.a.extendType == 2)
        {
          localIntent.putExtra("chat_subType", 1);
          paramInt = 0;
        }
        if (TextUtils.equals(paramView, antf.aP))
        {
          ueg.a(getActivity(), "from_user_contacts", 3, false);
          return;
        }
        if (TextUtils.equals(paramView, antf.aV))
        {
          tzq.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      } while ((TextUtils.equals(paramView, "2290230341")) && (QZoneMsgActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      if ((TextUtils.equals(paramView, "2747277822")) && (avmc.a()))
      {
        avme.b(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("2747277822", 1008, false);
        return;
      }
      if (MiniGamePublicAccountHelper.shouldOpenWebFragment(paramView))
      {
        MiniGamePublicAccountHelper.launchMiniGamePublicAccount(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.aW, 1008, false);
        return;
      }
      if ((TextUtils.equals(paramView, antf.aX)) && (bicz.b(getActivity())))
      {
        bicz.a(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.aX, 1008, false);
        return;
      }
      if ((TextUtils.equals(paramView, ayvd.a)) && (ayvf.a(getActivity(), paramView, 4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvd.a, 1008, false);
        return;
      }
      if (TextUtils.equals("3046055438", paramView))
      {
        oga.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("3046055438", 1008, false);
        return;
      }
    } while (arhp.a().a(paramView, getActivity(), 1035, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131694618));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */