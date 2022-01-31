package com.tencent.mobileqq.activity;

import aaju;
import aajv;
import aajw;
import aajx;
import aajy;
import aajz;
import aaka;
import aakb;
import aakc;
import aild;
import ajsd;
import ajxj;
import akat;
import akhb;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.TextView;
import ayao;
import ayap;
import ayaq;
import ayax;
import ayaz;
import bbbx;
import bbcz;
import bbdj;
import bbgu;
import bfpc;
import bfpp;
import bfub;
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
  public aild a;
  private ajxj jdField_a_of_type_Ajxj = new aajw(this);
  private akat jdField_a_of_type_Akat = new aajy(this);
  private akhb jdField_a_of_type_Akhb = new aajx(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aajv(this);
  private bfub jdField_a_of_type_Bfub = new aajz(this);
  public PullRefreshHeader a;
  public SlideDetectListView a;
  public String a;
  public ArrayList<SubAccountInfo> a;
  public MqqHandler a;
  public boolean a;
  public int b;
  public ArrayList<SimpleAccount> b;
  public boolean b;
  public ArrayList<ayao> c;
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
  
  private void a(ayaz paramayaz)
  {
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      paramayaz = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      while (paramayaz.hasNext())
      {
        Object localObject = (ayao)paramayaz.next();
        if ((localObject != null) && (((ayao)localObject).jdField_a_of_type_Int == 5) && (((ayao)localObject).jdField_a_of_type_JavaLangObject != null))
        {
          localObject = ((ArrayList)((ayao)localObject).jdField_a_of_type_JavaLangObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ayao localayao = (ayao)((Iterator)localObject).next();
            SimpleAccount localSimpleAccount = (SimpleAccount)localayao.jdField_a_of_type_JavaLangObject;
            int j = ayaq.a(this.app, localSimpleAccount.getUin());
            if (localayao.jdField_d_of_type_Int != j)
            {
              localayao.jdField_d_of_type_Int = j;
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
        this.jdField_a_of_type_Aild.notifyDataSetChanged();
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
        ayap.a(this.app, this);
        bbbx.b();
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
    ayax localayax = (ayax)this.app.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
      if (localayax != null)
      {
        if (paramBoolean1) {
          localayax.b(localSubAccountInfo.subuin);
        }
        localayax.f(localSubAccountInfo.subuin);
      }
      ayaq.a(this.app, localSubAccountInfo.subuin, false);
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
      paramBoolean1 = ayaq.a(this.app, false);
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
    ayao localayao;
    Object localObject3;
    Object localObject2;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Aild != null))
    {
      localObject1 = null;
      j = 0;
      i = 0;
      if (j < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        localayao = (ayao)this.jdField_c_of_type_JavaUtilArrayList.get(j);
        localObject3 = localObject1;
        if (localayao.jdField_a_of_type_Int != 2) {
          break label240;
        }
        localObject3 = localObject1;
        if (localayao.jdField_a_of_type_JavaLangObject == null) {
          break label240;
        }
        localObject3 = localObject1;
        if (!(localayao.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
          break label240;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (ayax)this.app.getManager(61);
        }
        localObject3 = localObject2;
        if (localObject2 == null) {
          break label240;
        }
        int k = ((ayax)localObject2).a(((SubAccountInfo)localayao.jdField_a_of_type_JavaLangObject).subuin);
        if ((k != 1) || (localayao.e == 0))
        {
          localObject3 = localObject2;
          if (k == 1) {
            break label240;
          }
          localObject3 = localObject2;
          if (localayao.e != 0) {
            break label240;
          }
        }
        if (k == 1)
        {
          localayao.e = 0;
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
      localayao.e = 1;
      break label206;
      if (i != 0) {
        this.jdField_a_of_type_Aild.notifyDataSetChanged();
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
      ayaq.c(this.app);
    }
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.app.a().c(ajsd.x, 7000);
      localQQAppInterface = this.app;
      if ((!paramBoolean) && (this.jdField_b_of_type_Int <= 0)) {
        break label105;
      }
    }
    label105:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ayaq.a(localQQAppInterface, paramBoolean, null);
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
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    if (paramBoolean) {
      localbfpc.a(getResources().getString(2131719824), 5);
    }
    localbfpc.a(getResources().getString(2131720634), 5);
    localbfpc.a(getResources().getString(2131719828), 5);
    localbfpc.c(2131690596);
    localbfpc.a(new aakc(this, paramBoolean, localbfpc));
    localbfpc.show();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initUI");
    }
    if (this.g) {
      setTitle(2131719826);
    }
    for (;;)
    {
      TextView localTextView = this.rightViewText;
      localTextView.setVisibility(0);
      localTextView.setText(2131719827);
      localTextView.setOnClickListener(new aaju(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131376637));
      if (AppSetting.d) {
        localTextView.setContentDescription(getText(2131719827));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559459, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_Bfub);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setBackgroundResource(2130838514);
      return;
      setTitle(2131719823);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initData");
    }
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Aild = new aild(this.app, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Aild);
    i();
    j();
  }
  
  private void h()
  {
    this.jdField_b_of_type_Int = 0;
    ayax localayax = (ayax)this.app.getManager(61);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (localayax.c(((SubAccountInfo)localIterator.next()).subuin) > 0) {
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
      localObject1 = (ayax)this.app.getManager(61);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(((ayax)localObject1).b());
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
      localObject3 = (ayax)this.app.getManager(61);
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
            localObject5 = new ayao();
            ((ayao)localObject5).jdField_a_of_type_Int = 2;
            localObject2 = bbcz.c(this.app, localSubAccountInfo.subuin, true);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = localSubAccountInfo.subuin;
            }
            ((ayao)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((ayao)localObject5).jdField_c_of_type_JavaLangString = localSubAccountInfo.subuin;
            ((ayao)localObject5).jdField_a_of_type_JavaLangObject = localSubAccountInfo;
            ((ayao)localObject5).jdField_b_of_type_JavaLangString = "";
            localObject1 = null;
            if (localSubAccountInfo.status != 1)
            {
              ((ayao)localObject5).e = 1;
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
        ((ayao)localObject5).jdField_a_of_type_Boolean = true;
        ((ayao)localObject5).jdField_b_of_type_Int = 0;
        if (AppSetting.d) {
          ((ayao)localObject5).jdField_d_of_type_JavaLangString = getString(2131719837, new Object[] { ((ayao)localObject5).jdField_a_of_type_JavaLangString });
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
        localObject2 = ayaq.a(this.app, localSubAccountInfo.subuin);
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
          localObject6 = new ayao();
          ((ayao)localObject6).jdField_a_of_type_Int = 3;
          if (m == k - 1) {}
          for (((ayao)localObject6).jdField_b_of_type_Int = 2;; ((ayao)localObject6).jdField_b_of_type_Int = 1)
          {
            if ((localObject2 != null) && (((ArrayList)localObject2).contains(((SubAccountMessage)localObject5).senderuin))) {
              ((ayao)localObject6).jdField_c_of_type_Int = 2;
            }
            if (m == 0) {
              ((ayao)localObject6).jdField_b_of_type_Boolean = true;
            }
            ((ayao)localObject6).jdField_a_of_type_JavaLangObject = localObject5;
            localArrayList.add(localObject6);
            m += 1;
            break label439;
            ((ayao)localObject5).jdField_a_of_type_Boolean = false;
            break;
            ((ayao)localObject5).e = 0;
            localObject1 = ((ayax)localObject3).a(localSubAccountInfo.subuin);
            break;
          }
        }
        if (j == 0) {
          break;
        }
        localObject1 = new ayao();
        ((ayao)localObject1).jdField_a_of_type_Int = 1;
        ((ayao)localObject1).jdField_b_of_type_Int = 3;
        ((ayao)localObject1).jdField_a_of_type_JavaLangObject = localSubAccountInfo;
        localArrayList.add(localObject1);
        break;
        label629:
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount no msg");
        }
        boolean bool = ((ayao)localObject5).jdField_a_of_type_Boolean;
        localObject1 = new ayao();
        ((ayao)localObject1).jdField_a_of_type_Int = 7;
        ((ayao)localObject1).jdField_b_of_type_Boolean = true;
        ((ayao)localObject1).jdField_b_of_type_Int = 3;
        ((ayao)localObject1).jdField_a_of_type_JavaLangObject = localSubAccountInfo;
        ((ayao)localObject1).jdField_a_of_type_Boolean = bool;
        localArrayList.add(localObject1);
        break;
        localObject1 = new ayao();
        ((ayao)localObject1).jdField_a_of_type_Int = 4;
        ((ayao)localObject1).jdField_b_of_type_Int = 3;
        ((ayao)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131719824);
        ((ayao)localObject1).jdField_c_of_type_JavaLangString = getResources().getString(2131719825);
        if (AppSetting.d)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((ayao)localObject1).jdField_a_of_type_JavaLangString).append(",");
          ((StringBuilder)localObject2).append(((ayao)localObject1).jdField_c_of_type_JavaLangString);
          ((ayao)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        }
        localArrayList.add(localObject1);
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject1 = new ayao();
          ((ayao)localObject1).jdField_a_of_type_Int = 0;
          ((ayao)localObject1).jdField_b_of_type_Int = 0;
          localArrayList.add(localObject1);
          localObject1 = new ayao();
          ((ayao)localObject1).jdField_a_of_type_Int = 5;
          ((ayao)localObject1).jdField_b_of_type_Int = 3;
          localObject2 = new ArrayList();
          j = this.jdField_b_of_type_JavaUtilArrayList.size();
          i = 0;
          if (i < j)
          {
            localObject4 = (SimpleAccount)this.jdField_b_of_type_JavaUtilArrayList.get(i);
            localObject3 = new ayao();
            ((ayao)localObject3).jdField_a_of_type_Int = 6;
            ((ayao)localObject3).jdField_a_of_type_JavaLangString = ayaq.a(this.app, (SimpleAccount)localObject4);
            ((ayao)localObject3).jdField_d_of_type_Int = ayaq.a(this.app, ((SimpleAccount)localObject4).getUin());
            ((ayao)localObject3).jdField_a_of_type_JavaLangObject = localObject4;
            if (AppSetting.d)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(((ayao)localObject3).jdField_a_of_type_JavaLangString).append(",");
              if (((ayao)localObject3).jdField_d_of_type_Int != 0) {
                break label1032;
              }
            }
            for (;;)
            {
              ((ayao)localObject3).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject4).toString();
              ((ArrayList)localObject2).add(localObject3);
              i += 1;
              break;
              if (((ayao)localObject3).jdField_d_of_type_Int == 1) {
                ((StringBuilder)localObject4).append("有一条未读");
              } else if (((ayao)localObject3).jdField_d_of_type_Int == 2) {
                ((StringBuilder)localObject4).append("有两条未读");
              } else if (((ayao)localObject3).jdField_d_of_type_Int > 0) {
                ((StringBuilder)localObject4).append("有").append(((ayao)localObject3).jdField_d_of_type_Int).append("条未读,");
              }
            }
          }
          ((ayao)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
          localArrayList.add(localObject1);
        }
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        this.jdField_c_of_type_JavaUtilArrayList.addAll(localArrayList);
        this.jdField_a_of_type_Aild.notifyDataSetChanged();
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
    bbgu localbbgu = bbdj.a(this, 230).setTitle(getString(2131719863)).setMessage(getString(2131719862));
    localbbgu.setPositiveButton(2131691035, new aakb(this));
    localbbgu.setCancelable(true);
    localbbgu.show();
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
    Object localObject2 = (ayax)this.app.getManager(61);
    if (localObject2 != null) {
      ((List)localObject1).addAll(((ayax)localObject2).a());
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
      ayaq.a(this.app, this);
      return;
    }
  }
  
  private void n()
  {
    bfpc localbfpc = (bfpc)bfpp.a(getActivity(), null);
    localbfpc.a(2131720635);
    localbfpc.a(2131694794, 3);
    localbfpc.c(2131690596);
    localbfpc.a(new aaka(this, localbfpc));
    localbfpc.show();
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
      bool = ayaq.d(this.app);
    } while ((paramInt2 != -1) && (this.f == bool));
    this.f = bool;
    a(true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562464);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnCreate");
    }
    this.e = ayaq.b(this.app, true);
    this.f = ayaq.d(this.app);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), AccountManageActivity.class.getSimpleName()))) {
      this.g = true;
    }
    f();
    g();
    addObserver(this.jdField_a_of_type_Ajxj);
    addObserver(this.jdField_a_of_type_Akhb);
    addObserver(this.jdField_a_of_type_Akat);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.a().addObserver(this);
    sendBroadcast(new Intent("before_account_change"));
    ayap.b(this.app);
    ayap.a(this.app);
    ayap.c(this.app);
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
    removeObserver(this.jdField_a_of_type_Ajxj);
    removeObserver(this.jdField_a_of_type_Akhb);
    removeObserver(this.jdField_a_of_type_Akat);
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
    axbt.jdField_a_of_type_Int = 0;
    removeObserver(this.jdField_a_of_type_Ajxj);
    removeObserver(this.jdField_a_of_type_Akat);
    removeObserver(this.jdField_a_of_type_Akhb);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if ((!this.d) || (this.app != null))
    {
      this.app.removeHandler(getClass());
      this.app.getApplication().refreAccountList();
    }
    ayap.b(this.app, this);
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
    } while ((paramObservable.length != 2) || (!ajsd.x.equals(paramObservable[0])));
    runOnUiThread(new AssociatedAccountActivity.16(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity
 * JD-Core Version:    0.7.0.1
 */