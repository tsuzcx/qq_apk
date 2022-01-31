package com.tencent.mobileqq.activity;

import aajy;
import aajz;
import aaka;
import aakb;
import aakc;
import aakd;
import aake;
import aakf;
import aakg;
import ailf;
import ajsf;
import ajxl;
import akav;
import akhc;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.TextView;
import ayam;
import ayan;
import ayao;
import ayav;
import ayax;
import bbbj;
import bbcl;
import bbcv;
import bbgg;
import bfol;
import bfoy;
import bftk;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
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
  public ailf a;
  private ajxl jdField_a_of_type_Ajxl = new aaka(this);
  private akav jdField_a_of_type_Akav = new aakc(this);
  private akhc jdField_a_of_type_Akhc = new aakb(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aajz(this);
  private bftk jdField_a_of_type_Bftk = new aakd(this);
  public PullRefreshHeader a;
  public SlideDetectListView a;
  public String a;
  public ArrayList<SubAccountInfo> a;
  public MqqHandler a;
  public boolean a;
  public int b;
  public ArrayList<SimpleAccount> b;
  public boolean b;
  public ArrayList<ayam> c;
  public boolean c;
  public boolean d;
  public boolean e = true;
  public boolean f = true;
  public boolean g;
  public boolean h = true;
  
  public AssociatedAccountActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  }
  
  private void a(ayax paramayax)
  {
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      paramayax = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      while (paramayax.hasNext())
      {
        Object localObject = (ayam)paramayax.next();
        if ((localObject != null) && (((ayam)localObject).jdField_a_of_type_Int == 5) && (((ayam)localObject).jdField_a_of_type_JavaLangObject != null))
        {
          localObject = ((ArrayList)((ayam)localObject).jdField_a_of_type_JavaLangObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ayam localayam = (ayam)((Iterator)localObject).next();
            SimpleAccount localSimpleAccount = (SimpleAccount)localayam.jdField_a_of_type_JavaLangObject;
            int j = ayao.a(this.app, localSimpleAccount.getUin());
            if (localayam.jdField_d_of_type_Int != j)
            {
              localayam.jdField_d_of_type_Int = j;
              i = 1;
            }
          }
        }
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "updateThirdQQUnread changed");
        }
        this.jdField_a_of_type_Ailf.notifyDataSetChanged();
      }
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
        this.d = true;
        sendBroadcast(new Intent("before_account_change"));
        this.app.switchAccount((SimpleAccount)localObject1, null);
        ayan.a(this.app, this);
        bbbj.b();
        return;
      }
      c();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AssociatedAccountActivity", 2, "switchAccount no change ");
      return;
      localObject1 = null;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "refreshAllData direct=" + paramBoolean);
    }
    if (isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      i();
      j();
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new AssociatedAccountActivity.2(this));
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
    ayav localayav = (ayav)this.app.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
      if (localayav != null)
      {
        if (paramBoolean1) {
          localayav.b(localSubAccountInfo.subuin);
        }
        localayav.f(localSubAccountInfo.subuin);
      }
      ayao.a(this.app, localSubAccountInfo.subuin, false);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Int += 1;
      }
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if ((System.currentTimeMillis() - this.jdField_a_of_type_Long >= 30000L) || (!paramBoolean2)) {
        break label319;
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
      label319:
      paramBoolean1 = ayao.a(this.app, false);
      if ((this.jdField_b_of_type_Boolean) && (paramBoolean1)) {
        this.jdField_a_of_type_Int += 1;
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  private void b()
  {
    int j;
    int i;
    ayam localayam;
    Object localObject3;
    Object localObject2;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Ailf != null))
    {
      localObject1 = null;
      j = 0;
      i = 0;
      if (j < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        localayam = (ayam)this.jdField_c_of_type_JavaUtilArrayList.get(j);
        localObject3 = localObject1;
        if (localayam.jdField_a_of_type_Int != 2) {
          break label240;
        }
        localObject3 = localObject1;
        if (localayam.jdField_a_of_type_JavaLangObject == null) {
          break label240;
        }
        localObject3 = localObject1;
        if (!(localayam.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
          break label240;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (ayav)this.app.getManager(61);
        }
        localObject3 = localObject2;
        if (localObject2 == null) {
          break label240;
        }
        int k = ((ayav)localObject2).a(((SubAccountInfo)localayam.jdField_a_of_type_JavaLangObject).subuin);
        if ((k != 1) || (localayam.e == 0))
        {
          localObject3 = localObject2;
          if (k == 1) {
            break label240;
          }
          localObject3 = localObject2;
          if (localayam.e != 0) {
            break label240;
          }
        }
        if (k == 1)
        {
          localayam.e = 0;
          label206:
          i = 1;
        }
      }
    }
    label240:
    for (Object localObject1 = localObject2;; localObject1 = localObject3)
    {
      j += 1;
      break;
      localayam.e = 1;
      break label206;
      if (i != 0) {
        this.jdField_a_of_type_Ailf.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnread");
    }
    if (((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) || (this.g)) {
      ayao.c(this.app);
    }
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.app.a().c(ajsf.x, 7000);
      localQQAppInterface = this.app;
      if ((!paramBoolean) && (this.jdField_b_of_type_Int <= 0)) {
        break label105;
      }
    }
    label105:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ayao.a(localQQAppInterface, paramBoolean, null);
      return;
    }
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
        j();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnreadAsync");
    }
    ThreadManager.post(new AssociatedAccountActivity.7(this, paramBoolean), 8, null, true);
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "showSettingDialog underTwo = " + paramBoolean);
    }
    bfol localbfol = (bfol)bfoy.a(this, null);
    if (paramBoolean) {
      localbfol.a(getResources().getString(2131719813), 5);
    }
    localbfol.a(getResources().getString(2131720623), 5);
    localbfol.a(getResources().getString(2131719817), 5);
    localbfol.c(2131690596);
    localbfol.a(new aakg(this, paramBoolean, localbfol));
    localbfol.show();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initUI");
    }
    if (this.g) {
      setTitle(2131719815);
    }
    for (;;)
    {
      TextView localTextView = this.rightViewText;
      localTextView.setVisibility(0);
      localTextView.setText(2131719816);
      localTextView.setOnClickListener(new aajy(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131376635));
      if (AppSetting.d) {
        localTextView.setContentDescription(getText(2131719816));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559459, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_Bftk);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setBackgroundResource(2130838514);
      return;
      setTitle(2131719812);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initData");
    }
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Ailf = new ailf(this.app, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Ailf);
    i();
    j();
  }
  
  private void h()
  {
    this.jdField_b_of_type_Int = 0;
    ayav localayav = (ayav)this.app.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (localayav.c(((SubAccountInfo)localIterator.next()).subuin) > 0) {
        this.jdField_b_of_type_Int += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "checkNeed2ConfirmMsgNum mNeed2ConfirmMsgNum = " + this.jdField_b_of_type_Int);
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadAccountList");
    }
    Object localObject1;
    label114:
    SimpleAccount localSimpleAccount;
    label204:
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = (ayav)this.app.getManager(61);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(((ayav)localObject1).b());
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mSubAccountList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        break label312;
      }
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = this.app.getApplication().getAllAccounts();
      if ((!this.e) || (this.g) || (!this.f)) {
        break label377;
      }
      Object localObject2 = new ArrayList();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      if (((List)localObject2).size() <= 0) {
        break label339;
      }
      String str = this.app.getAccount();
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
          if ((localSimpleAccount != null) && (!str.equals(localSimpleAccount.getUin())))
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            i = 0;
            label254:
            if (localIterator.hasNext())
            {
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo == null) || (!localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                break label454;
              }
              i = 1;
            }
          }
        }
      }
    }
    label312:
    label454:
    for (;;)
    {
      break label254;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break label114;
      if (i != 0) {
        break label204;
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localSimpleAccount);
      break label204;
      label339:
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mThirdAccountList.size() = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      }
      label377:
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) || ((!this.f) && (localObject1 != null) && (((List)localObject1).size() > 1)))
      {
        this.rightViewText.setEnabled(true);
        this.rightViewText.setAlpha(1.0F);
        return;
      }
      this.rightViewText.setEnabled(false);
      this.rightViewText.setAlpha(0.5F);
      return;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadItemDataList");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject4;
    Object localObject1;
    int i;
    SubAccountInfo localSubAccountInfo;
    Object localObject5;
    Object localObject2;
    Object localObject6;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject3 = (ayav)this.app.getManager(61);
      int n = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject4 = new ArrayList();
      localObject1 = this.app.getApplication().getAllAccounts();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject4).addAll((Collection)localObject1);
      }
      i = 0;
      for (;;)
      {
        if (i < n)
        {
          localSubAccountInfo = (SubAccountInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localSubAccountInfo == null) || (TextUtils.isEmpty(localSubAccountInfo.subuin)))
          {
            i += 1;
          }
          else
          {
            localObject5 = new ayam();
            ((ayam)localObject5).jdField_a_of_type_Int = 2;
            localObject2 = bbcl.c(this.app, localSubAccountInfo.subuin, true);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = localSubAccountInfo.subuin;
            }
            ((ayam)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((ayam)localObject5).jdField_c_of_type_JavaLangString = localSubAccountInfo.subuin;
            ((ayam)localObject5).jdField_a_of_type_JavaLangObject = localSubAccountInfo;
            ((ayam)localObject5).jdField_b_of_type_JavaLangString = "";
            localObject1 = null;
            if (localSubAccountInfo.status != 1)
            {
              ((ayam)localObject5).e = 1;
              localObject2 = ((List)localObject4).iterator();
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localObject6 = (SimpleAccount)((Iterator)localObject2).next();
              } while ((localObject6 == null) || (!TextUtils.equals(localSubAccountInfo.subuin, ((SimpleAccount)localObject6).getUin())));
            }
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      int k;
      if (j != 0)
      {
        ((ayam)localObject5).jdField_a_of_type_Boolean = true;
        ((ayam)localObject5).jdField_b_of_type_Int = 0;
        if (AppSetting.d) {
          ((ayam)localObject5).jdField_d_of_type_JavaLangString = getString(2131719826, new Object[] { ((ayam)localObject5).jdField_a_of_type_JavaLangString });
        }
        localArrayList.add(localObject5);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label629;
        }
        k = ((List)localObject1).size();
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount msg msgSize = " + k);
        }
        if (k <= 0) {
          break;
        }
        localObject2 = ayao.a(this.app, localSubAccountInfo.subuin);
        if (k <= 5) {
          break label1183;
        }
        k = 5;
      }
      label1032:
      label1183:
      for (j = 1;; j = 0)
      {
        int m = 0;
        label439:
        if (m < k)
        {
          localObject5 = (SubAccountMessage)((List)localObject1).get(m);
          localObject6 = new ayam();
          ((ayam)localObject6).jdField_a_of_type_Int = 3;
          if (m == k - 1) {}
          for (((ayam)localObject6).jdField_b_of_type_Int = 2;; ((ayam)localObject6).jdField_b_of_type_Int = 1)
          {
            if ((localObject2 != null) && (((ArrayList)localObject2).contains(((SubAccountMessage)localObject5).senderuin))) {
              ((ayam)localObject6).jdField_c_of_type_Int = 2;
            }
            if (m == 0) {
              ((ayam)localObject6).jdField_b_of_type_Boolean = true;
            }
            ((ayam)localObject6).jdField_a_of_type_JavaLangObject = localObject5;
            localArrayList.add(localObject6);
            m += 1;
            break label439;
            ((ayam)localObject5).jdField_a_of_type_Boolean = false;
            break;
            ((ayam)localObject5).e = 0;
            localObject1 = ((ayav)localObject3).a(localSubAccountInfo.subuin);
            break;
          }
        }
        if (j == 0) {
          break;
        }
        localObject1 = new ayam();
        ((ayam)localObject1).jdField_a_of_type_Int = 1;
        ((ayam)localObject1).jdField_b_of_type_Int = 3;
        ((ayam)localObject1).jdField_a_of_type_JavaLangObject = localSubAccountInfo;
        localArrayList.add(localObject1);
        break;
        label629:
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount no msg");
        }
        boolean bool = ((ayam)localObject5).jdField_a_of_type_Boolean;
        localObject1 = new ayam();
        ((ayam)localObject1).jdField_a_of_type_Int = 7;
        ((ayam)localObject1).jdField_b_of_type_Boolean = true;
        ((ayam)localObject1).jdField_b_of_type_Int = 3;
        ((ayam)localObject1).jdField_a_of_type_JavaLangObject = localSubAccountInfo;
        ((ayam)localObject1).jdField_a_of_type_Boolean = bool;
        localArrayList.add(localObject1);
        break;
        localObject1 = new ayam();
        ((ayam)localObject1).jdField_a_of_type_Int = 4;
        ((ayam)localObject1).jdField_b_of_type_Int = 3;
        ((ayam)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131719813);
        ((ayam)localObject1).jdField_c_of_type_JavaLangString = getResources().getString(2131719814);
        if (AppSetting.d)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((ayam)localObject1).jdField_a_of_type_JavaLangString).append(",");
          ((StringBuilder)localObject2).append(((ayam)localObject1).jdField_c_of_type_JavaLangString);
          ((ayam)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        }
        localArrayList.add(localObject1);
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject1 = new ayam();
          ((ayam)localObject1).jdField_a_of_type_Int = 0;
          ((ayam)localObject1).jdField_b_of_type_Int = 0;
          localArrayList.add(localObject1);
          localObject1 = new ayam();
          ((ayam)localObject1).jdField_a_of_type_Int = 5;
          ((ayam)localObject1).jdField_b_of_type_Int = 3;
          localObject2 = new ArrayList();
          j = this.jdField_b_of_type_JavaUtilArrayList.size();
          i = 0;
          if (i < j)
          {
            localObject4 = (SimpleAccount)this.jdField_b_of_type_JavaUtilArrayList.get(i);
            localObject3 = new ayam();
            ((ayam)localObject3).jdField_a_of_type_Int = 6;
            ((ayam)localObject3).jdField_a_of_type_JavaLangString = ayao.a(this.app, (SimpleAccount)localObject4);
            ((ayam)localObject3).jdField_d_of_type_Int = ayao.a(this.app, ((SimpleAccount)localObject4).getUin());
            ((ayam)localObject3).jdField_a_of_type_JavaLangObject = localObject4;
            if (AppSetting.d)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(((ayam)localObject3).jdField_a_of_type_JavaLangString).append(",");
              if (((ayam)localObject3).jdField_d_of_type_Int != 0) {
                break label1032;
              }
            }
            for (;;)
            {
              ((ayam)localObject3).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject4).toString();
              ((ArrayList)localObject2).add(localObject3);
              i += 1;
              break;
              if (((ayam)localObject3).jdField_d_of_type_Int == 1) {
                ((StringBuilder)localObject4).append("有一条未读");
              } else if (((ayam)localObject3).jdField_d_of_type_Int == 2) {
                ((StringBuilder)localObject4).append("有两条未读");
              } else if (((ayam)localObject3).jdField_d_of_type_Int > 0) {
                ((StringBuilder)localObject4).append("有").append(((ayam)localObject3).jdField_d_of_type_Int).append("条未读,");
              }
            }
          }
          ((ayam)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
          localArrayList.add(localObject1);
        }
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        this.jdField_c_of_type_JavaUtilArrayList.addAll(localArrayList);
        this.jdField_a_of_type_Ailf.notifyDataSetChanged();
        if (this.g) {
          if (this.leftView != null) {
            this.leftView.setText("");
          }
        }
        for (;;)
        {
          h();
          return;
          a();
        }
      }
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchFail");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    d();
    bbgg localbbgg = bbcv.a(this, 230).setTitle(getString(2131719852)).setMessage(getString(2131719851));
    localbbgg.setPositiveButton(2131691035, new aakf(this));
    localbbgg.setCancelable(true);
    localbbgg.show();
  }
  
  private void l()
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
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "bindNewSubAccount currentUin=" + this.app.c());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (ayav)this.app.getManager(61);
    if (localObject2 != null) {
      ((List)localObject1).addAll(((ayav)localObject2).a());
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
      ayao.a(this.app, this);
      return;
    }
  }
  
  private void n()
  {
    bfol localbfol = (bfol)bfoy.a(getActivity(), null);
    localbfol.a(2131720624);
    localbfol.a(2131694793, 3);
    localbfol.c(2131690596);
    localbfol.a(new aake(this, localbfol));
    localbfol.show();
  }
  
  void a()
  {
    if ((!this.g) && (this.leftView != null)) {
      ThreadManager.post(new AssociatedAccountActivity.5(this, this.app.a()), 8, null, false);
    }
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
      bool = ayao.d(this.app);
    } while ((paramInt2 != -1) && (this.f == bool));
    this.f = bool;
    a(true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562465);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnCreate");
    }
    this.e = ayao.b(this.app, true);
    this.f = ayao.d(this.app);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), AccountManageActivity.class.getSimpleName()))) {
      this.g = true;
    }
    f();
    g();
    addObserver(this.jdField_a_of_type_Ajxl);
    addObserver(this.jdField_a_of_type_Akhc);
    addObserver(this.jdField_a_of_type_Akav);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.a().addObserver(this);
    sendBroadcast(new Intent("before_account_change"));
    ayan.b(this.app);
    ayan.a(this.app);
    ayan.c(this.app);
    if (a()) {
      a(false, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnDestroy");
    }
    removeObserver(this.jdField_a_of_type_Ajxl);
    removeObserver(this.jdField_a_of_type_Akhc);
    removeObserver(this.jdField_a_of_type_Akav);
    this.app.removeHandler(getClass());
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    c();
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
    c();
    if (!this.h) {
      b();
    }
    this.h = false;
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccountChanged() mClick2Switch=" + this.d);
    }
    super.onAccountChanged();
    axbr.jdField_a_of_type_Int = 0;
    removeObserver(this.jdField_a_of_type_Ajxl);
    removeObserver(this.jdField_a_of_type_Akav);
    removeObserver(this.jdField_a_of_type_Akhc);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if ((!this.d) || (this.app != null))
    {
      this.app.removeHandler(getClass());
      this.app.getApplication().refreAccountList();
    }
    ayan.b(this.app, this);
    c();
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
    c();
    k();
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onBackEvent");
    }
    c(false);
    if (!this.g)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "update()");
    }
    if ((paramObject instanceof MessageRecord)) {
      if (!((MessageRecord)paramObject).isSendFromLocal()) {
        a();
      }
    }
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!ajsf.x.equals(paramObservable[0])));
    runOnUiThread(new AssociatedAccountActivity.16(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity
 * JD-Core Version:    0.7.0.1
 */