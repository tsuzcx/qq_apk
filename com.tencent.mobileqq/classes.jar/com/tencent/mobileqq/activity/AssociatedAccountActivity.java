package com.tencent.mobileqq.activity;

import Override;
import advt;
import advu;
import advv;
import advw;
import advx;
import advy;
import advz;
import adwa;
import adwb;
import agej;
import ammv;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import antf;
import anyu;
import aocj;
import aoib;
import aran;
import arjg;
import bdll;
import bdwr;
import bdws;
import bdwt;
import bdxb;
import bdxc;
import bdxd;
import bdxe;
import bhkd;
import bhlg;
import bhlq;
import bhpc;
import blir;
import blji;
import blnt;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AssociatedAccountActivity
  extends SubAccountBaseActivity
  implements Observer
{
  public int a;
  public long a;
  public ammv a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new advu(this);
  public View a;
  private anyu jdField_a_of_type_Anyu = new advv(this);
  private aocj jdField_a_of_type_Aocj = new advx(this);
  private aoib jdField_a_of_type_Aoib = new advw(this);
  private blnt jdField_a_of_type_Blnt = new advy(this);
  public SubAccountInfo a;
  public PullRefreshHeader a;
  public SlideDetectListView a;
  public HorizontalListView a;
  public String a;
  public ArrayList<SubAccountInfo> a;
  public MqqHandler a;
  public boolean a;
  public int b;
  public ammv b;
  public ArrayList<SimpleAccount> b;
  public boolean b;
  public ArrayList<bdwr> c;
  public boolean c;
  public ArrayList<bdwr> d;
  public boolean d;
  public boolean e = true;
  public boolean f = true;
  public boolean g;
  public boolean h = true;
  
  public AssociatedAccountActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  }
  
  private void a(bdxe parambdxe)
  {
    int i;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      parambdxe = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (i = 0; parambdxe.hasNext(); i = 1)
      {
        label27:
        bdwr localbdwr = (bdwr)parambdxe.next();
        if ((localbdwr == null) || (localbdwr.jdField_a_of_type_Int != 6) || (localbdwr.jdField_a_of_type_JavaLangObject == null)) {
          break label27;
        }
        SimpleAccount localSimpleAccount = (SimpleAccount)localbdwr.jdField_a_of_type_JavaLangObject;
        int j = bdwt.a(this.app, localSimpleAccount.getUin());
        if (localbdwr.jdField_d_of_type_Int == j) {
          break label139;
        }
        localbdwr.jdField_d_of_type_Int = j;
      }
    }
    label139:
    for (;;)
    {
      break;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "updateThirdQQUnread changed");
        }
        this.jdField_a_of_type_Ammv.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchAccount to Uin = " + paramString);
    }
    if (paramString == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new ArrayList();
      localObject2 = this.app.getApplication().getAllAccounts();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    } while (((List)localObject1).size() < 1);
    Object localObject2 = ((List)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (SimpleAccount)((Iterator)localObject2).next();
    } while (!((SimpleAccount)localObject1).getUin().equalsIgnoreCase(paramString));
    for (;;)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "switchAccount change ");
        }
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_d_of_type_Boolean = true;
        sendBroadcast(new Intent("before_account_change"));
        this.app.switchAccount((SimpleAccount)localObject1, null);
        bdws.a(this.app, this);
        bhkd.b();
        return;
      }
      e();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AssociatedAccountActivity", 2, "switchAccount no change ");
      return;
      localObject1 = null;
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    if (this.rightViewText != null)
    {
      this.rightViewText.setEnabled(paramBoolean);
      this.rightViewText.setAlpha(paramFloat);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanOneSubAccountMessagesUnread");
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          this.app.a().c(paramString, 7000);
          if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
              if (paramString.equals(localSimpleAccount.getUin()))
              {
                bdwt.a(this.app, localSimpleAccount);
                return;
              }
            }
          }
        } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    } while (!paramString.equals(((SubAccountInfo)((Iterator)localObject).next()).subuin));
    Object localObject = this.app;
    if ((paramBoolean) || (this.jdField_b_of_type_Int > 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      bdwt.a((QQAppInterface)localObject, paramBoolean, null, paramString);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "getDataList needChangeReaded = " + paramBoolean1 + " isRefresh = " + paramBoolean2);
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_c_of_type_Boolean = false;
    }
    a(paramBoolean1);
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if ((System.currentTimeMillis() - this.jdField_a_of_type_Long >= 30000L) || (!paramBoolean2)) {
        break label220;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.3(this), 800L);
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "getDataList current-last<30000ms, startGetThirdQQUnreadNum be ignored.");
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.4(this), 800L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "getDataList mPullReqNeedBackNum = " + this.jdField_a_of_type_Int);
      }
      return;
      label220:
      paramBoolean1 = bdwt.a(this.app, false);
      if ((this.jdField_b_of_type_Boolean) && (paramBoolean1)) {
        this.jdField_a_of_type_Int += 1;
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  private boolean a(String paramString, bdxd parambdxd)
  {
    return (TextUtils.isEmpty(paramString)) || (isFinishing()) || (parambdxd == null);
  }
  
  private boolean a(String paramString, bdxe parambdxe)
  {
    return (isFinishing()) || (parambdxe == null) || (this.app == null) || (!TextUtils.equals(paramString, this.app.c()));
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnreadAsync");
    }
    ThreadManager.post(new AssociatedAccountActivity.7(this, paramBoolean, paramString), 8, null, true);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() mPullReqNeedBackNum = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int -= 1;
    if ((paramBoolean1) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Int <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() end");
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Boolean = false;
      PullRefreshHeader localPullRefreshHeader = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (this.jdField_c_of_type_Boolean) {
        i = 0;
      }
      localPullRefreshHeader.a(i);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.9(this), 800L);
      if (this.jdField_c_of_type_Boolean) {
        c();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "refreshAllData direct=" + paramBoolean);
    }
    if (isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      a();
      c();
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new AssociatedAccountActivity.2(this));
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "showSettingDialog underTwo = " + paramBoolean);
    }
    blir localblir = (blir)blji.a(this, null);
    if (paramBoolean) {
      localblir.a(getResources().getString(2131718387), 5);
    }
    localblir.a(getResources().getString(2131719069), 5);
    localblir.a(getResources().getString(2131718390), 5);
    localblir.c(2131690580);
    localblir.a(new adwb(this, paramBoolean, localblir));
    localblir.show();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initUI");
    }
    setTitle(2131718386);
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131718389);
    localTextView.setOnClickListener(new advt(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131378167));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378808);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131378807));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(agej.a(22.0F, getResources()));
    if (AppSetting.jdField_c_of_type_Boolean) {
      localTextView.setContentDescription(getText(2131718389));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559652, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_Blnt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setBackgroundResource(2130838778);
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initData");
    }
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Ammv = new ammv(this.app, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_b_of_type_Ammv);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Ammv = new ammv(this.app, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Ammv);
    a();
    c();
  }
  
  private void j()
  {
    this.jdField_b_of_type_Int = 0;
    bdxc localbdxc = (bdxc)this.app.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (localbdxc.c(((SubAccountInfo)localIterator.next()).subuin) > 0) {
        this.jdField_b_of_type_Int += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "checkNeed2ConfirmMsgNum mNeed2ConfirmMsgNum = " + this.jdField_b_of_type_Int);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.leftView == null) || (this.jdField_a_of_type_Ammv == null) || (this.jdField_b_of_type_Ammv == null)) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Ammv.notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_b_of_type_Ammv.notifyDataSetChanged();
      if (this.leftView != null) {
        this.leftView.setText("");
      }
      j();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchFail");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    f();
    bhpc localbhpc = bhlq.a(this, 230).setTitle(getString(2131718415)).setMessage(getString(2131718414));
    localbhpc.setPositiveButton(2131690912, new adwa(this));
    localbhpc.setCancelable(true);
    localbhpc.show();
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "gotoManageAssociatedAccount");
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, AssociatedAccountManageActivity.class);
    if (this.g) {
      localIntent.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    }
    startActivityForResult(localIntent, 1012);
    overridePendingTransition(2130771997, 2130771990);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "bindNewSubAccount currentUin=" + this.app.c());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (bdxc)this.app.getManager(61);
    if (localObject2 != null) {
      ((List)localObject1).addAll(((bdxc)localObject2).a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "bindNewSubAccount binded = " + ((List)localObject1).size());
    }
    Intent localIntent;
    if (((List)localObject1).size() < 2)
    {
      localIntent = new Intent();
      localObject2 = new ArrayList();
      Object localObject3 = this.app.getApplication().getAllAccounts();
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        ((List)localObject2).addAll((Collection)localObject3);
      }
      localObject2 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (SimpleAccount)((Iterator)localObject2).next();
      } while ((localObject3 == null) || (TextUtils.equals(((SimpleAccount)localObject3).getUin(), this.app.c())) || (((List)localObject1).contains(((SimpleAccount)localObject3).getUin())));
    }
    for (localObject1 = SubAccountBindActivity.class;; localObject1 = SubLoginActivity.class)
    {
      localIntent.setClass(this, (Class)localObject1);
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = AssociatedAccountActivity.class.getSimpleName();
      }
      localIntent.putExtra("fromWhere", (String)localObject1);
      startActivity(localIntent);
      return;
      bdwt.a(this.app, this);
      return;
    }
  }
  
  private void o()
  {
    blir localblir = (blir)blji.a(getActivity(), null);
    localblir.a(2131719070);
    localblir.a(2131694098, 3);
    localblir.c(2131690580);
    localblir.a(new advz(this, localblir));
    localblir.show();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadAccountList");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = (bdxc)this.app.getManager(61);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(((bdxc)localObject).b());
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mSubAccountList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      localObject = this.app.getApplication().getAllAccounts();
      a((List)localObject);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) && ((this.f) || (localObject == null) || (((List)localObject).size() <= 1))) {
        break label174;
      }
      a(true, 1.0F);
    }
    for (;;)
    {
      b();
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label174:
      a(false, 0.5F);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (bdxc)paramQQAppInterface.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      paramQQAppInterface.d(((SubAccountInfo)localIterator.next()).subuin);
    }
    b(true);
    c(paramString);
    c();
  }
  
  public void a(List<SimpleAccount> paramList)
  {
    label157:
    SimpleAccount localSimpleAccount;
    int i;
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, new Object[] { "loadAccountList mThirdAccountList.mIsDisplayThirdFuc = ", Boolean.valueOf(this.e), " mIsFromAccountManage=", Boolean.valueOf(this.g), " mIsDisplayThirdQQChecked=", Boolean.valueOf(this.f) });
      }
      if ((!this.e) || (this.g) || (!this.f)) {
        break label318;
      }
      Object localObject = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        ((List)localObject).addAll(paramList);
      }
      if (((List)localObject).size() <= 0) {
        break label280;
      }
      paramList = this.app.getAccount();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
          if ((localSimpleAccount != null) && (!paramList.equals(localSimpleAccount.getUin())))
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            i = 0;
            label205:
            if (localIterator.hasNext())
            {
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo == null) || (!localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                break label319;
              }
              i = 1;
            }
          }
        }
      }
    }
    label280:
    label318:
    label319:
    for (;;)
    {
      break label205;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break;
      if (i != 0) {
        break label157;
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localSimpleAccount);
      break label157;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mThirdAccountList.size() = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    bdxc localbdxc = (bdxc)this.app.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
      if (localbdxc != null)
      {
        if (paramBoolean) {
          localbdxc.b(localSubAccountInfo.subuin);
        }
        localbdxc.g(localSubAccountInfo.subuin);
      }
      bdwt.a(this.app, localSubAccountInfo.subuin, false);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Int += 1;
      }
      arjg localarjg = (arjg)aran.a().a(607);
      if ((localarjg != null) && (!localarjg.jdField_a_of_type_Boolean)) {
        bdxb.a(this.app, localSubAccountInfo.subuin);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.jdField_d_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_d_of_type_JavaUtilArrayList.size() > 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            bdxc localbdxc = null;
            i = 0;
            bool1 = false;
            if (i < this.jdField_d_of_type_JavaUtilArrayList.size())
            {
              Object localObject = (bdwr)this.jdField_d_of_type_JavaUtilArrayList.get(i);
              if ((((bdwr)localObject).jdField_a_of_type_Int == 2) && (((bdwr)localObject).jdField_a_of_type_JavaLangObject != null) && ((((bdwr)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList)))
              {
                if (localbdxc != null) {
                  break label268;
                }
                localbdxc = (bdxc)this.app.getManager(61);
                label127:
                bool2 = bool1;
                if (localbdxc == null) {
                  break label274;
                }
                localObject = ((ArrayList)((bdwr)localObject).jdField_a_of_type_JavaLangObject).iterator();
                bool2 = bool1;
                if (!((Iterator)localObject).hasNext()) {
                  break label274;
                }
                bdwr localbdwr = (bdwr)((Iterator)localObject).next();
                int j = localbdxc.a(((SubAccountInfo)localbdwr.jdField_a_of_type_JavaLangObject).subuin);
                if (((j != 1) || (localbdwr.e == 0)) && ((j == 1) || (localbdwr.e != 0))) {
                  break label271;
                }
                if (j == 1) {}
                for (localbdwr.e = 0;; localbdwr.e = 1)
                {
                  bool1 = true;
                  label229:
                  break;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ((bool1) && (this.jdField_b_of_type_Ammv != null)) {
        this.jdField_b_of_type_Ammv.notifyDataSetChanged();
      }
      return bool1;
      label268:
      break label127;
      label271:
      break label229;
      label274:
      bool1 = bool2;
    }
  }
  
  public void b()
  {
    Object localObject = getIntent();
    String str;
    if (localObject != null)
    {
      str = ((Intent)localObject).getStringExtra("subAccount");
      ((Intent)localObject).removeExtra("subAccount");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          if (!TextUtils.isEmpty(str))
          {
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject).next();
              if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(str))) {
                this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = localSubAccountInfo;
              }
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = null;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
          }
          return;
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = null;
          return;
        }
      }
      str = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnread");
    }
    if (((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) || (this.g)) {
      bdwt.c(this.app);
    }
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.app.a().c(antf.x, 7000);
      localQQAppInterface = this.app;
      if ((!paramBoolean) && (this.jdField_b_of_type_Int <= 0)) {
        break label105;
      }
    }
    label105:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bdwt.a(localQQAppInterface, paramBoolean, null);
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadItemDataList");
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3;
    Object localObject4;
    Object localObject1;
    boolean bool1;
    ArrayList localArrayList2;
    int i;
    SubAccountInfo localSubAccountInfo;
    boolean bool2;
    bdwr localbdwr;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject3 = (bdxc)this.app.getManager(61);
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject4 = new ArrayList();
      localObject1 = this.app.getApplication().getAllAccounts();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject4).addAll((Collection)localObject1);
      }
      bool1 = false;
      localArrayList2 = new ArrayList(k);
      i = 0;
      for (;;)
      {
        if (i < k)
        {
          localSubAccountInfo = (SubAccountInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          bool2 = bool1;
          if (localSubAccountInfo != null)
          {
            if (TextUtils.isEmpty(localSubAccountInfo.subuin)) {
              bool2 = bool1;
            }
          }
          else
          {
            i += 1;
            bool1 = bool2;
            continue;
          }
          localbdwr = new bdwr();
          localbdwr.jdField_a_of_type_Int = 2;
          localObject2 = bhlg.c(this.app, localSubAccountInfo.subuin, true);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localSubAccountInfo.subuin;
          }
          localbdwr.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localbdwr.jdField_c_of_type_JavaLangString = localSubAccountInfo.subuin;
          localbdwr.jdField_a_of_type_JavaLangObject = localSubAccountInfo;
          localbdwr.jdField_b_of_type_JavaLangString = "";
          if (localSubAccountInfo.subuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))
          {
            localbdwr.jdField_b_of_type_Boolean = true;
            label275:
            if (localSubAccountInfo.status == 1) {
              break label448;
            }
            localbdwr.e = 1;
            localObject1 = ((List)localObject4).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (SimpleAccount)((Iterator)localObject1).next();
            } while ((localObject2 == null) || (!TextUtils.equals(localSubAccountInfo.subuin, ((SimpleAccount)localObject2).getUin())));
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localbdwr.jdField_a_of_type_Boolean = true;
        label354:
        localbdwr.jdField_b_of_type_Int = 0;
        if (AppSetting.jdField_c_of_type_Boolean) {
          localbdwr.jdField_d_of_type_JavaLangString = getString(2131718396, new Object[] { localbdwr.jdField_a_of_type_JavaLangString });
        }
        if (!localSubAccountInfo.subuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)) {
          break label905;
        }
        bool1 = localbdwr.jdField_a_of_type_Boolean;
      }
      label905:
      for (;;)
      {
        localArrayList2.add(localbdwr);
        bool2 = bool1;
        break;
        localbdwr.jdField_b_of_type_Boolean = false;
        break label275;
        localbdwr.jdField_a_of_type_Boolean = false;
        break label354;
        label448:
        localbdwr.e = 0;
        break label354;
        localObject1 = new bdwr();
        ((bdwr)localObject1).jdField_a_of_type_Int = 2;
        ((bdwr)localObject1).jdField_a_of_type_JavaLangObject = localArrayList2;
        ((bdwr)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject1);
        localObject1 = ((bdxc)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          j = ((List)localObject1).size();
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount msg msgSize = " + j);
          }
          if (j > 0)
          {
            localObject2 = bdwt.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
            i = 0;
            if (i < j)
            {
              localObject3 = (SubAccountMessage)((List)localObject1).get(i);
              localObject4 = new bdwr();
              ((bdwr)localObject4).jdField_a_of_type_Int = 3;
              if (i == j - 1) {}
              for (((bdwr)localObject4).jdField_b_of_type_Int = 2;; ((bdwr)localObject4).jdField_b_of_type_Int = 1)
              {
                if ((localObject2 != null) && (((ArrayList)localObject2).contains(((SubAccountMessage)localObject3).senderuin))) {
                  ((bdwr)localObject4).jdField_c_of_type_Int = 2;
                }
                if (i == 0) {
                  ((bdwr)localObject4).jdField_b_of_type_Boolean = true;
                }
                ((bdwr)localObject4).jdField_a_of_type_JavaLangObject = localObject3;
                localArrayList1.add(localObject4);
                i += 1;
                break;
              }
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount no msg");
          }
          localObject1 = new bdwr();
          ((bdwr)localObject1).jdField_a_of_type_Int = 7;
          ((bdwr)localObject1).jdField_b_of_type_Boolean = true;
          ((bdwr)localObject1).jdField_b_of_type_Int = 3;
          ((bdwr)localObject1).jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
          ((bdwr)localObject1).jdField_a_of_type_Boolean = bool1;
          localArrayList1.add(localObject1);
        }
        for (;;)
        {
          this.jdField_d_of_type_JavaUtilArrayList.clear();
          this.jdField_d_of_type_JavaUtilArrayList.addAll(localArrayList1);
          d();
          k();
          return;
          localObject1 = new bdwr();
          ((bdwr)localObject1).jdField_a_of_type_Int = 4;
          ((bdwr)localObject1).jdField_b_of_type_Int = 3;
          ((bdwr)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131718387);
          ((bdwr)localObject1).jdField_c_of_type_JavaLangString = getResources().getString(2131718388);
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((bdwr)localObject1).jdField_a_of_type_JavaLangString).append(",");
            ((StringBuilder)localObject2).append(((bdwr)localObject1).jdField_c_of_type_JavaLangString);
            ((bdwr)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
          }
          localArrayList1.add(localObject1);
        }
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList.size());
      int j = this.jdField_b_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (SimpleAccount)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        bdwr localbdwr = new bdwr();
        localbdwr.jdField_a_of_type_Int = 6;
        localbdwr.jdField_a_of_type_JavaLangString = bdwt.a(this.app, (SimpleAccount)localObject);
        localbdwr.jdField_d_of_type_Int = bdwt.a(this.app, ((SimpleAccount)localObject).getUin());
        localbdwr.jdField_a_of_type_JavaLangObject = localObject;
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localbdwr.jdField_a_of_type_JavaLangString);
          localbdwr.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
        }
        localArrayList.add(localbdwr);
        i += 1;
      }
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      this.jdField_c_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnActivityResult requestCode = " + paramInt1 + " resultCode=" + paramInt2);
    }
    switch (paramInt1)
    {
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      finish();
      return;
      bool = bdwt.d(this.app);
    } while ((paramInt2 != -1) && (this.f == bool));
    this.f = bool;
    c(true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562959);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnCreate");
    }
    this.e = bdwt.b(this.app, true);
    this.f = bdwt.d(this.app);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), AccountManageActivity.class.getSimpleName()))) {
      this.g = true;
    }
    h();
    i();
    addObserver(this.jdField_a_of_type_Anyu);
    addObserver(this.jdField_a_of_type_Aoib);
    addObserver(this.jdField_a_of_type_Aocj);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.a().addObserver(this);
    sendBroadcast(new Intent("before_account_change"));
    bdws.b(this.app);
    bdws.a(this.app);
    bdws.c(this.app);
    if (b()) {
      a(false, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    paramBundle = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.g) {}
    for (int i = 1;; i = 0)
    {
      bdll.b(paramBundle, "dc00898", "", "", "0X800AC3B", "0X800AC3B", 0, 0, i + "", "", "", "");
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnDestroy");
    }
    removeObserver(this.jdField_a_of_type_Anyu);
    removeObserver(this.jdField_a_of_type_Aoib);
    removeObserver(this.jdField_a_of_type_Aocj);
    this.app.removeHandler(getClass());
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverscrollHeader(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnPause");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnResume");
    }
    e();
    if (!this.h) {
      a();
    }
    this.h = false;
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccountChanged() mClick2Switch=" + this.jdField_d_of_type_Boolean);
    }
    super.onAccountChanged();
    removeObserver(this.jdField_a_of_type_Anyu);
    removeObserver(this.jdField_a_of_type_Aocj);
    removeObserver(this.jdField_a_of_type_Aoib);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if ((!this.jdField_d_of_type_Boolean) || (this.app != null))
    {
      this.app.removeHandler(getClass());
      this.app.getApplication().refreAccountList();
    }
    bdws.b(this.app, this);
    e();
    this.jdField_a_of_type_JavaLangString = null;
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  public void onAccoutChangeFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccoutChangeFailed");
    }
    e();
    l();
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onBackEvent");
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.g)) {
      bdwt.c(this.app);
    }
    this.app.a().c(antf.x, 7000);
    if (!this.g)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "update()");
    }
    if ((paramObject instanceof MessageRecord)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!antf.x.equals(paramObservable[0])));
    runOnUiThread(new AssociatedAccountActivity.16(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity
 * JD-Core Version:    0.7.0.1
 */