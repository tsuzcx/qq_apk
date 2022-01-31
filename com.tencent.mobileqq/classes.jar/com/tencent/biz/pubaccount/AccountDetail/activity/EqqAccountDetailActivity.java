package com.tencent.biz.pubaccount.AccountDetail.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianManager.OnLbsStateChangedListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kow;
import kox;
import koy;
import koz;
import kpa;
import kpc;
import kpd;
import kpe;
import kpf;
import kpg;
import kph;
import kpi;
import kpj;
import kpk;
import kpl;
import kpm;
import kpn;
import kpp;
import kpq;
import kpr;
import kps;
import kpu;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class EqqAccountDetailActivity
  extends AccountDetailActivity
{
  public int a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public EqqDetail a;
  public mobileqq_mp.GetEqqAccountDetailInfoResponse a;
  private QidianManager.OnLbsStateChangedListener jdField_a_of_type_ComTencentQidianQidianManager$OnLbsStateChangedListener = new kow(this);
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public String a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public boolean a;
  NewIntent jdField_b_of_type_MqqAppNewIntent;
  BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public EqqAccountDetailActivity()
  {
    this.jdField_a_of_type_JavaLangString = "EqqAccountDetailActivity";
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramInt3 == 0) {
        if (paramInt3 == paramInt2 - 1) {
          if (paramInt1 != 1) {}
        }
      }
    }
    while (paramInt1 <= 1)
    {
      do
      {
        do
        {
          return 0;
        } while (paramInt1 <= 1);
        if (paramInt4 == 0) {
          return 1;
        }
        if (paramInt4 == paramInt1 - 1) {
          return 2;
        }
        return 3;
        if (paramInt4 == 0) {
          return 1;
        }
        if (paramInt4 == paramInt1 - 1) {
          return 5;
        }
        return 3;
        if (paramInt3 > 0)
        {
          if (paramInt3 == paramInt2 - 1)
          {
            if (paramInt4 == paramInt1 - 1) {
              return 2;
            }
            if (paramInt4 == 0) {
              return 4;
            }
            return 3;
          }
          if (paramInt4 == 0) {
            return 4;
          }
          if (paramInt4 == paramInt1 - 1) {
            return 5;
          }
          return 3;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getItemBgType error groupId < 0");
      return 0;
    }
    if (paramInt4 == 0) {
      return 1;
    }
    if (paramInt4 == paramInt1 - 1) {
      return 5;
    }
    return 3;
  }
  
  protected int a()
  {
    return 2;
  }
  
  protected View a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130968724, null);
    ((ImageView)localView.findViewById(2131362729)).setImageResource(2130838256);
    ((ImageView)localView.findViewById(2131363425)).setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131363039);
    String str = paramPaConfigInfo.b;
    if (!TextUtils.isEmpty(str))
    {
      localTextView.setText(str);
      localView.setOnClickListener(new kpu(this, paramPaConfigInfo, str));
      return localView;
    }
    return null;
  }
  
  ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createGroupLayout exit");
    }
    return localLinearLayout;
  }
  
  protected ShareActionSheet.Detail a()
  {
    return new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.summary);
  }
  
  protected String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name;
    }
    return str;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mShowMsgFlag = paramInt;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.toByteArray();
    if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mIsSyncLbs = true;
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mIsAgreeSyncLbs = paramBoolean;
    }
    c(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
  }
  
  void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (b())
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      continue;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    int i = paramPaConfigInfo.jdField_d_of_type_Int;
    this.jdField_a_of_type_Boolean = false;
    if ((i == 1) || (i == 2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437757);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437758);
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    int i = 1;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.a(2131437757, 5, false);
    localActionSheet.a(2131437758, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localActionSheet.d(0);
    }
    for (;;)
    {
      if ((paramInt == 1) || (paramInt == 2)) {
        i = 0;
      }
      localActionSheet.c(2131432998);
      localActionSheet.setOnDismissListener(new kpf(this));
      localActionSheet.a(new kpg(this, paramPaConfigInfo, localActionSheet, i));
      if (!localActionSheet.isShowing())
      {
        this.jdField_d_of_type_Boolean = false;
        localActionSheet.show();
      }
      return;
      localActionSheet.d(1);
    }
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch)
  {
    boolean bool = true;
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    int i = 1;
    b(2131430012);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent = localNewIntent;
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
    int j = paramPaConfigInfo.e;
    if (paramBoolean) {}
    for (;;)
    {
      localSetFunctionFlagRequset.type.set(j);
      localSetFunctionFlagRequset.value.set(i);
      localSetFunctionFlagRequset.account_type.set(a());
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      this.jdField_a_of_type_MqqObserverBusinessObserver = new kpj(this, paramPaConfigInfo, paramSwitch, i, j, paramBoolean);
      localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      this.jdField_c_of_type_Int += 1;
      return;
      i = 2;
    }
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b();
  }
  
  public void a(EqqDetail paramEqqDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new kpn(this, paramEqqDetail, paramBoolean), 10L);
  }
  
  void a(String paramString)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.b(2131433811);
    localActionSheet.c(getString(2131435075) + paramString);
    localActionSheet.c(2131432998);
    localActionSheet.a(new kpc(this, localActionSheet, paramString));
    localActionSheet.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Class paramClass, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1)
    {
      paramString2 = new Intent(this, ChatActivity.class);
      paramString2.putExtra("chat_subType", 1);
      paramString2.putExtra("cSpecialFlag", this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("cSpecialFlag"));
      paramString2.putExtra("uin", paramString1);
      paramString2.putExtra("uintype", 0);
      paramString2.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
      paramString2.putExtra("isforceRequestDetail", paramBoolean);
      paramString2.putExtra("jump_from", 2);
      startActivity(paramString2);
      return;
    }
    paramString2 = new Intent(this, ChatActivity.class);
    paramString2.putExtra("chat_subType", 1);
    paramString2.putExtra("uin", paramString1);
    paramString2.putExtra("uintype", 1024);
    paramString2.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
    paramString2.putExtra("isforceRequestDetail", paramBoolean);
    paramString2.putExtra("jump_from", 2);
    startActivity(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.isConfirmed = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1)) {
      a(paramString);
    }
    do
    {
      do
      {
        return;
        if (paramBoolean1)
        {
          d(paramString);
          return;
        }
        if (!paramBoolean2) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null);
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, this.jdField_d_of_type_JavaLangString, "IvrEnterpriseDetailEngineFalse");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showCallConfirm no phone ability and no ivr ability");
  }
  
  protected boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = ((EqqDetail)((EntityManager)localObject).a(EqqDetail.class, this.jdField_d_of_type_JavaLangString));
    ((EntityManager)localObject).a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.config_group_info;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList = ((PBRepeatMessageField)localObject).get();
      }
    }
    catch (Exception localException)
    {
      label90:
      break label90;
    }
    return true;
  }
  
  boolean a(ViewGroup paramViewGroup, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addCrmDetailItem");
    }
    Object localObject1 = super.getLayoutInflater();
    int j = (int)(10.0F * this.jdField_a_of_type_Float);
    int k = (int)(15.0F * this.jdField_a_of_type_Float);
    int i;
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3)
    {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        return false;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 10)
      {
        i = 1;
        localObject1 = e(paramPaConfigInfo);
        if (localObject1 != null)
        {
          if (i == 0) {
            break label692;
          }
          switch (paramInt)
          {
          default: 
            ((View)localObject1).setBackgroundResource(2130837517);
          case 4: 
            label148:
            if (paramPaConfigInfo.jdField_a_of_type_Int == 4) {
              ((View)localObject1).setPadding(k, k, k, k);
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addCrmDetailItem exit");
      }
      return true;
      return false;
      if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
      {
        paramPaConfigInfo.g = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.latitude;
        paramPaConfigInfo.f = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.longitude;
        localObject1 = a(paramPaConfigInfo);
        if (localObject1 != null)
        {
          i = 0;
          break;
        }
        return false;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        localObject1 = b(paramPaConfigInfo);
        if (localObject1 != null)
        {
          i = 0;
          break;
        }
        return false;
      }
      Object localObject2;
      if (paramPaConfigInfo.jdField_c_of_type_Int == 9)
      {
        i = 1;
        localObject2 = d(paramPaConfigInfo);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
      }
      return false;
      if (paramPaConfigInfo.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((LayoutInflater)localObject1).inflate(2130968724, null);
        ((ImageView)((View)localObject1).findViewById(2131362729)).setImageResource(2130838257);
        ((ImageView)((View)localObject1).findViewById(2131363425)).setVisibility(0);
        localObject2 = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return false;
        }
        ((TextView)((View)localObject1).findViewById(2131363039)).setText((CharSequence)localObject2);
        if (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史")) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
        }
        ((View)localObject1).setOnClickListener(new kpi(this, (String)localObject2, paramPaConfigInfo));
        i = 0;
        break;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
      {
        i = 1;
        localObject2 = f(paramPaConfigInfo);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return false;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 4)
      {
        localObject1 = c(paramPaConfigInfo);
        if (localObject1 != null)
        {
          i = 0;
          break;
        }
        return false;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 5) {
        return false;
      }
      localObject1 = ((LayoutInflater)localObject1).inflate(2130968724, null);
      i = 0;
      break;
      ((View)localObject1).setBackgroundResource(2130837517);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837520);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837518);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837519);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837519);
      break label148;
      if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
      {
        if (paramPaConfigInfo.e == 5) {
          ((View)localObject1).setPadding(k, j, k, k);
        } else {
          ((View)localObject1).setPadding(k, 0, k, 0);
        }
      }
      else {
        ((View)localObject1).setPadding(k, j, k, k);
      }
    }
    label692:
    paramPaConfigInfo = ((View)localObject1).findViewById(2131363424);
    switch (paramInt)
    {
    default: 
      paramPaConfigInfo.setBackgroundResource(2130837517);
    }
    for (;;)
    {
      paramPaConfigInfo.setPadding(0, k, k, k);
      break;
      paramPaConfigInfo.setBackgroundResource(2130837517);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837520);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837518);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837519);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837519);
    }
  }
  
  public boolean a(PaConfigAttr paramPaConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup start");
    }
    ViewGroup localViewGroup = a();
    paramPaConfigAttr = a(paramPaConfigAttr.a, paramBoolean1);
    Object localObject = paramPaConfigAttr.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((PaConfigAttr.PaConfigInfo)((Iterator)localObject).next()).e == 5) {
        ((Iterator)localObject).remove();
      }
    }
    int j = paramPaConfigAttr.size();
    if ((paramBoolean1) && (paramInt1 > 0) && (j > 0) && (paramBoolean2))
    {
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.jdField_a_of_type_Float)));
      ((View)localObject).setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView((View)localObject);
    }
    int i = 0;
    paramBoolean2 = false;
    if (i < j)
    {
      int k = a(j, paramInt2, paramInt1, i, paramBoolean1);
      if ((a(localViewGroup, (PaConfigAttr.PaConfigInfo)paramPaConfigAttr.get(i), k, paramBoolean1)) || (paramBoolean2)) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        i += 1;
        break;
      }
    }
    if ((!paramBoolean1) && (paramInt1 == paramInt2 - 1))
    {
      paramPaConfigAttr = new View(this);
      paramPaConfigAttr.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
      paramPaConfigAttr.setBackgroundColor(Color.parseColor("#d6d6d6"));
      localViewGroup.addView(paramPaConfigAttr);
    }
    a(localViewGroup, paramBoolean1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup exit");
    }
    return paramBoolean2;
  }
  
  protected View b(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2130968724, null);
    ((ImageView)localView.findViewById(2131362729)).setImageResource(2130838259);
    ((ImageView)localView.findViewById(2131363425)).setVisibility(0);
    String str = paramPaConfigInfo.b;
    boolean bool1;
    boolean bool2;
    if (str != null)
    {
      str = str.trim();
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility();
      bool2 = Pattern.compile("[\\d-]+?").matcher(str).matches();
      if (!bool2) {
        break label166;
      }
      ((TextView)localView.findViewById(2131363039)).setText(str);
    }
    for (;;)
    {
      localView.setOnClickListener(new kox(this, bool2, str, bool1, paramPaConfigInfo));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
      return localView;
      return null;
      label166:
      if (!bool1) {
        break;
      }
      ((TextView)localView.findViewById(2131363039)).setText(2131433811);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "buildPhoneItem no phone ability and no ivr ability");
    }
    return null;
  }
  
  public String b()
  {
    if (this.jdField_h_of_type_JavaLangString == null) {
      this.jdField_h_of_type_JavaLangString = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_d_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.eqqAccountFlag + "&jumptype=1&card_type=crm");
    }
    return this.jdField_h_of_type_JavaLangString;
  }
  
  protected void b()
  {
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
    for (List localList = PaConfigAttr.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);; localList = null)
    {
      if (localList != null)
      {
        int j = localList.size();
        boolean bool = false;
        while (i < j)
        {
          bool = a((PaConfigAttr)localList.get(i), i, j, true, bool);
          i += 1;
        }
      }
      c();
      return;
    }
  }
  
  public void b(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    b(2131430012);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_b_of_type_MqqAppNewIntent = localNewIntent;
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
    int j = paramPaConfigInfo.e;
    if (paramInt == 1) {
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A2B", "0X8005A2B", 0, 0, "", "", "", "", false);
    }
    for (int i = 1;; i = 3)
    {
      localSetFunctionFlagRequset.type.set(j);
      localSetFunctionFlagRequset.value.set(i);
      localSetFunctionFlagRequset.account_type.set(a());
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      this.jdField_b_of_type_MqqObserverBusinessObserver = new kph(this, paramPaConfigInfo, i, paramInt);
      localNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      this.jdField_c_of_type_Int += 1;
      return;
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A2A", "0X8005A2A", 0, 0, "", "", "", "", false);
    }
  }
  
  public void b(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    String str = paramPaConfigInfo.jdField_d_of_type_JavaLangString;
    if (3 == paramPaConfigInfo.e) {
      str = String.format(getString(2131428082), new Object[] { a() });
    }
    localQQCustomDialog.setTitle("温馨提示");
    localQQCustomDialog.setMessage(str);
    localQQCustomDialog.setOnCancelListener(new kpk(this, paramPaConfigInfo, paramSwitch));
    paramPaConfigInfo = new kpl(this, paramPaConfigInfo, paramSwitch, paramBoolean);
    localQQCustomDialog.setNegativeButton("取消", paramPaConfigInfo);
    localQQCustomDialog.setPositiveButton("确定", paramPaConfigInfo);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramPaConfigInfo) {}
  }
  
  public void b(EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailToDBAndCache");
    }
    Object localObject = (EqqDetailDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68);
    if (localObject != null) {
      ((EqqDetailDataManager)localObject).a(paramEqqDetail);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramEqqDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.clone(paramEqqDetail);
      if (!((EntityManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail)) {
        ((EntityManager)localObject).a(EqqDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
      {
        localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if (localObject != null) {
          ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailToDBAndCache exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
      ((EntityManager)localObject).a(paramEqqDetail);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (isFinishing()) {}
    while (this.jdField_a_of_type_ComTencentWidgetSwitch == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
  }
  
  protected boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility());
  }
  
  protected View c(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).equals("消息公告"))) {
      return null;
    }
    localObject = super.getLayoutInflater().inflate(2130968724, null);
    ((ImageView)((View)localObject).findViewById(2131362729)).setImageResource(2130838258);
    ((TextView)((View)localObject).findViewById(2131363039)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString + " " + paramPaConfigInfo.b);
    return localObject;
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.realSummary))) {
      return;
    }
    TextView localTextView = new TextView(getActivity().getBaseContext());
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.realSummary);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getActivity().getBaseContext().getResources().getColor(2131492970));
    int i = (int)(this.jdField_a_of_type_Float * 16.5D);
    int j = (int)(this.jdField_a_of_type_Float * 16.5D);
    int k = (int)(this.jdField_a_of_type_Float * 22.5D);
    int m = (int)(this.jdField_a_of_type_Float * 22.5D);
    int n = (int)(5.0F * this.jdField_a_of_type_Float);
    localTextView.setPadding(i, k, j, m);
    localTextView.setLineSpacing(n, 1.0F);
    localTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView);
  }
  
  void c(EqqDetail paramEqqDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new kpp(this, paramEqqDetail), 10L);
  }
  
  protected boolean c()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType;
    }
    return i == 1;
  }
  
  protected View d(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130971539, null);
    TextView localTextView = (TextView)localView.findViewById(2131363360);
    String str2 = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.startsWith("查看")) {
        str1 = str2.replaceFirst("查看", "");
      }
    }
    localTextView.setText(str1);
    ((TextView)localView.findViewById(2131363185)).setText(paramPaConfigInfo.b);
    localView.setOnClickListener(new koy(this));
    return localView;
  }
  
  public void d()
  {
    e();
  }
  
  public void d(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.b(paramEqqDetail);
    localEntityManager.a();
  }
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164));
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_d_of_type_JavaLangString, false)))
    {
      paramBundle = new Intent(this, QidianProfileCardActivity.class);
      paramBundle.putExtra("uin", this.jdField_d_of_type_JavaLangString);
      startActivity(paramBundle);
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentQidianQidianManager$OnLbsStateChangedListener);
    return true;
  }
  
  View e(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo.e != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Unhandled ConfigInfo(" + paramPaConfigInfo.jdField_a_of_type_Int + ", " + paramPaConfigInfo.jdField_c_of_type_Int + ", " + paramPaConfigInfo.e + ")");
      }
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2130971539, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363185));
    if ((paramPaConfigInfo.jdField_d_of_type_Int == 1) || (paramPaConfigInfo.jdField_d_of_type_Int == 2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437757);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131363360)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
      localView.setOnClickListener(new kpd(this, paramPaConfigInfo));
      return localView;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437758);
    }
  }
  
  void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendDetailInfoRequest");
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
    localGetEqqDetailInfoRequest.version.set(2);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      localGetEqqDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
        label151:
        this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        this.jdField_c_of_type_MqqObserverBusinessObserver = new kpm(this);
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
        this.jdField_c_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendCrmDetailInfoRequest exit");
        }
        return;
        localGetEqqDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label151;
    }
  }
  
  View f(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = true;
    View localView = getLayoutInflater().inflate(2130971578, null);
    ((TextView)localView.findViewById(2131363360)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    Switch localSwitch = (Switch)localView.findViewById(2131364096);
    this.jdField_a_of_type_ComTencentWidgetSwitch = localSwitch;
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1)
    {
      localSwitch.setChecked(true);
      if (paramPaConfigInfo.jdField_d_of_type_Int != 1) {
        break label107;
      }
    }
    for (;;)
    {
      a(paramPaConfigInfo.e, bool);
      localSwitch.setOnCheckedChangeListener(new kpe(this, paramPaConfigInfo, localSwitch));
      return localView;
      localSwitch.setChecked(false);
      break;
      label107:
      bool = false;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, ChatActivity.class);
    }
  }
  
  public void g()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new kpq(this), 10L);
  }
  
  protected void h()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new kpr(this), 10L);
  }
  
  public void i()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new kps(this), 10L);
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView");
    }
    m();
    k();
    l();
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {}
    label145:
    label164:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!b()) {
          break label145;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_AndroidWidgetButton.getVisibility() != 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
          break label164;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        break;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a() == null)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() != null)
      {
        ((AccountDetailBaseAdapter)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter()).a();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter = new AccountDetailBaseAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c(c());
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(b());
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c(c());
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(b());
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.notifyDataSetChanged();
  }
  
  void m()
  {
    if (c())
    {
      b();
      return;
    }
    n();
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList != null)
    {
      List localList = PaConfigAttr.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);
      int j = localList.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool = a((PaConfigAttr)localList.get(i), i, j, false, bool);
        i += 1;
      }
    }
    c();
  }
  
  protected void o()
  {
    PAStartupTracker.a(null, "pubAcc_follow_confirm", this.jdField_d_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow uin=" + this.jdField_d_of_type_JavaLangString);
    }
    this.i = true;
    this.jdField_a_of_type_AndroidViewView.postDelayed(new koz(this), 3000L);
    b(2131430015);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_d_of_type_JavaLangString);
    this.jdField_d_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_d_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.f)) && (this.jdField_h_of_type_Boolean)) {
      localFollowRequest.ext.set(this.f);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
    localFollowRequest.account_type.set(a());
    this.jdField_d_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_d_of_type_MqqObserverBusinessObserver = new kpa(this);
    this.jdField_d_of_type_MqqAppNewIntent.setObserver(this.jdField_d_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_d_of_type_MqqAppNewIntent);
    this.jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_MqqAppNewIntent != null)
    {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_a_of_type_MqqAppNewIntent = null;
    }
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      this.jdField_b_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentQidianQidianManager$OnLbsStateChangedListener);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.toByteArray();
    }
  }
  
  protected void q()
  {
    super.q();
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet == null) {
      this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet = new ShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), a(), b());
    }
    this.jdField_a_of_type_ComTencentBizTroopbarShareActionSheet.a();
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */