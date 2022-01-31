package com.tencent.biz.pubaccount.AccountDetail.activity;

import alrt;
import alud;
import alzl;
import amrw;
import amsb;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import awgf;
import awgg;
import azqs;
import bdiu;
import bfyh;
import bhuf;
import bhus;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mzx;
import ndv;
import ngk;
import ngl;
import ngm;
import ngn;
import ngo;
import ngp;
import ngq;
import ngr;
import ngs;
import ngt;
import ngu;
import ngw;
import npn;
import npo;
import nrt;
import nrz;
import yuq;
import yus;

public class EqqAccountDetailActivity
  extends AccountDetailActivity
{
  public int a;
  amrw jdField_a_of_type_Amrw;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bfyh jdField_a_of_type_Bfyh;
  public EqqDetail a;
  public mobileqq_mp.GetEqqAccountDetailInfoResponse a;
  public String a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  boolean jdField_a_of_type_Boolean = true;
  NewIntent b;
  public boolean b;
  
  public EqqAccountDetailActivity()
  {
    this.jdField_a_of_type_JavaLangString = "EqqAccountDetailActivity";
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
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
  
  public int a()
  {
    return 2;
  }
  
  protected View a(npo paramnpo)
  {
    View localView = super.getLayoutInflater().inflate(2131558683, null);
    ((ImageView)localView.findViewById(2131368518)).setImageResource(2130838630);
    ((ImageView)localView.findViewById(2131362823)).setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131364771);
    String str = paramnpo.b;
    if (!TextUtils.isEmpty(str))
    {
      localTextView.setText(str);
      localView.setOnClickListener(new ngt(this, paramnpo, str));
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
  
  public String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name;
    }
    return str;
  }
  
  public yus a()
  {
    return new yus(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.summary);
  }
  
  public void a()
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
  
  void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (b())
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      continue;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  void a(EqqDetail paramEqqDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a();
  }
  
  public void a(EqqDetail paramEqqDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.3(this, paramEqqDetail, paramBoolean), 10L);
  }
  
  void a(String paramString)
  {
    bhuf localbhuf = (bhuf)bhus.b(this, null);
    localbhuf.b(2131720910);
    localbhuf.c(getString(2131691700) + paramString);
    localbhuf.c(2131690648);
    localbhuf.a(new ngn(this, localbhuf, paramString));
    localbhuf.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
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
  
  public void a(npo paramnpo)
  {
    int i = paramnpo.d;
    this.jdField_a_of_type_Boolean = false;
    if ((i == 1) || (i == 2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693900);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693901);
  }
  
  public void a(npo paramnpo, int paramInt)
  {
    int i = 1;
    bhuf localbhuf = (bhuf)bhus.b(this, null);
    localbhuf.a(2131693900, 5, false);
    localbhuf.a(2131693901, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localbhuf.d(0);
    }
    for (;;)
    {
      if ((paramInt == 1) || (paramInt == 2)) {
        i = 0;
      }
      localbhuf.c(2131690648);
      localbhuf.setOnDismissListener(new ngp(this));
      localbhuf.a(new ngq(this, paramnpo, localbhuf, i));
      if (!localbhuf.isShowing())
      {
        this.jdField_b_of_type_Boolean = false;
        localbhuf.show();
      }
      return;
      localbhuf.d(1);
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
      ndv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, this.jdField_d_of_type_JavaLangString, "IvrEnterpriseDetailEngineFalse");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showCallConfirm no phone ability and no ivr ability");
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = ((EqqDetail)((awgf)localObject).a(EqqDetail.class, this.jdField_d_of_type_JavaLangString));
    ((awgf)localObject).a();
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
  
  boolean a(ViewGroup paramViewGroup, npo paramnpo, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addCrmDetailItem");
    }
    Object localObject = super.getLayoutInflater();
    int j = (int)(10.0F * this.jdField_a_of_type_Float);
    int k = (int)(15.0F * this.jdField_a_of_type_Float);
    int i;
    if (paramnpo.jdField_a_of_type_Int == 3)
    {
      if (paramnpo.jdField_c_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        return false;
      }
      if (paramnpo.jdField_c_of_type_Int == 10)
      {
        localObject = e(paramnpo);
        if (localObject != null) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        switch (paramInt)
        {
        default: 
          ((View)localObject).setBackgroundResource(2130837520);
        case 4: 
          label148:
          if (paramnpo.jdField_a_of_type_Int == 4)
          {
            ((View)localObject).setPadding(k, k, k, k);
            paramnpo = (npo)localObject;
          }
          break;
        }
        for (;;)
        {
          paramViewGroup.addView((View)localObject);
          if ((i != 0) && (paramInt == 2))
          {
            paramnpo = new View(paramnpo.getContext());
            paramnpo.setBackgroundColor(Color.parseColor("#dedfe0"));
            paramViewGroup.addView(paramnpo, new ViewGroup.LayoutParams(-1, 1));
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addCrmDetailItem exit");
          }
          return true;
          return false;
          if (paramnpo.jdField_c_of_type_Int == 7)
          {
            paramnpo.g = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.latitude;
            paramnpo.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.longitude;
            localObject = a(paramnpo);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (paramnpo.jdField_c_of_type_Int == 8)
          {
            localObject = b(paramnpo);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (paramnpo.jdField_c_of_type_Int == 9)
          {
            localObject = d(paramnpo);
            if (localObject != null)
            {
              i = 1;
              break;
            }
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unhandled event_id: " + paramnpo.jdField_c_of_type_Int);
          }
          return false;
          if (paramnpo.jdField_a_of_type_Int == 1)
          {
            localObject = ((LayoutInflater)localObject).inflate(2131558683, null);
            ((ImageView)((View)localObject).findViewById(2131368518)).setImageResource(2130838631);
            ((ImageView)((View)localObject).findViewById(2131362823)).setVisibility(0);
            String str = paramnpo.jdField_c_of_type_JavaLangString;
            if (TextUtils.isEmpty(str)) {
              return false;
            }
            ((TextView)((View)localObject).findViewById(2131364771)).setText(str);
            if (paramnpo.jdField_a_of_type_JavaLangString.contains(alud.a(2131704578))) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
            }
            ((View)localObject).setOnClickListener(new ngk(this, str, paramnpo));
            i = 0;
            break;
          }
          if (paramnpo.jdField_a_of_type_Int == 2)
          {
            localObject = f(paramnpo);
            if (localObject != null) {
              break label863;
            }
            return false;
          }
          if (paramnpo.jdField_a_of_type_Int == 4)
          {
            localObject = c(paramnpo);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (paramnpo.jdField_a_of_type_Int == 5) {
            return false;
          }
          localObject = ((LayoutInflater)localObject).inflate(2131558683, null);
          i = 0;
          break;
          ((View)localObject).setBackgroundResource(2130837520);
          break label148;
          ((View)localObject).setBackgroundResource(2130837523);
          break label148;
          ((View)localObject).setBackgroundResource(2130837522);
          break label148;
          ((View)localObject).setBackgroundResource(2130837522);
          break label148;
          ((View)localObject).setBackgroundResource(2130837522);
          break label148;
          if (paramnpo.jdField_a_of_type_Int == 2)
          {
            if (paramnpo.e == 5)
            {
              ((View)localObject).setPadding(k, j, k, k);
              paramnpo = (npo)localObject;
            }
            else
            {
              ((View)localObject).setPadding(k, 0, k, 0);
              paramnpo = (npo)localObject;
            }
          }
          else
          {
            ((View)localObject).setPadding(k, j, k, k);
            paramnpo = (npo)localObject;
          }
        }
      }
      paramnpo = ((View)localObject).findViewById(2131364789);
      switch (paramInt)
      {
      default: 
        paramnpo.setBackgroundResource(2130837520);
      }
      for (;;)
      {
        paramnpo.setPadding(0, k, k, k);
        break;
        paramnpo.setBackgroundResource(2130837520);
        continue;
        paramnpo.setBackgroundResource(2130837523);
        continue;
        paramnpo.setBackgroundResource(2130837521);
        continue;
        paramnpo.setBackgroundResource(2130837522);
        continue;
        paramnpo.setBackgroundResource(2130837522);
      }
      label863:
      i = 1;
    }
  }
  
  public boolean a(npn paramnpn, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup start");
    }
    ViewGroup localViewGroup = a();
    paramnpn = a(paramnpn.a, paramBoolean1);
    Object localObject = paramnpn.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((npo)((Iterator)localObject).next()).e == 5) {
        ((Iterator)localObject).remove();
      }
    }
    int j = paramnpn.size();
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
      if ((a(localViewGroup, (npo)paramnpn.get(i), k, paramBoolean1)) || (paramBoolean2)) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        i += 1;
        break;
      }
    }
    if ((!paramBoolean1) && (paramInt1 == paramInt2 - 1))
    {
      paramnpn = new View(this);
      paramnpn.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
      paramnpn.setBackgroundColor(Color.parseColor("#d6d6d6"));
      localViewGroup.addView(paramnpn);
    }
    a(localViewGroup, paramBoolean1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup exit");
    }
    return paramBoolean2;
  }
  
  protected View b(npo paramnpo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2131558683, null);
    ((ImageView)localView.findViewById(2131368518)).setImageResource(2130838633);
    ((ImageView)localView.findViewById(2131362823)).setVisibility(0);
    String str = paramnpo.b;
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
      ((TextView)localView.findViewById(2131364771)).setText(str);
    }
    for (;;)
    {
      localView.setOnClickListener(new ngu(this, bool2, str, bool1, paramnpo));
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
      return localView;
      return null;
      label166:
      if (!bool1) {
        break;
      }
      ((TextView)localView.findViewById(2131364771)).setText(2131720910);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "buildPhoneItem no phone ability and no ivr ability");
    }
    return null;
  }
  
  public String b()
  {
    if (this.h == null) {
      this.h = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_d_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.eqqAccountFlag + "&jumptype=1&card_type=crm");
    }
    return this.h;
  }
  
  protected void b()
  {
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
    for (List localList = npn.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);; localList = null)
    {
      if (localList != null)
      {
        int j = localList.size();
        boolean bool = false;
        while (i < j)
        {
          bool = a((npn)localList.get(i), i, j, true, bool);
          i += 1;
        }
      }
      c();
      return;
    }
  }
  
  void b(EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailToDBAndCache");
    }
    Object localObject = (alrt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    if (localObject != null) {
      ((alrt)localObject).a(paramEqqDetail);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramEqqDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.clone(paramEqqDetail);
      if (!((awgf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail)) {
        ((awgf)localObject).a(EqqDetail.class);
      }
    }
    for (;;)
    {
      ((awgf)localObject).a();
      if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
      {
        localObject = (alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        if (localObject != null) {
          ((alzl)localObject).a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailToDBAndCache exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
      ((awgf)localObject).a(paramEqqDetail);
    }
  }
  
  public void b(npo paramnpo, int paramInt)
  {
    int i = paramnpo.e;
    String str1;
    String str2;
    if (paramInt == 1)
    {
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A2B", "0X8005A2B", 0, 0, "", "", "", "", false);
      i = 1;
      b(2131695780);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrw);
      this.jdField_a_of_type_Amrw = new amrw(new ngr(this, paramnpo, i, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amrw);
      paramnpo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin;
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name;
      if (paramInt != 1) {
        break label186;
      }
    }
    label186:
    for (paramInt = 1;; paramInt = 0)
    {
      amsb.a(paramnpo, str1, str2, paramInt);
      this.jdField_c_of_type_Int += 1;
      return;
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A2A", "0X8005A2A", 0, 0, "", "", "", "", false);
      i = 3;
      break;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility());
  }
  
  protected View c(npo paramnpo)
  {
    Object localObject = paramnpo.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).equals(alud.a(2131704572)))) {
      return null;
    }
    localObject = super.getLayoutInflater().inflate(2131558683, null);
    ((ImageView)((View)localObject).findViewById(2131368518)).setImageResource(2130838632);
    ((TextView)((View)localObject).findViewById(2131364771)).setText(paramnpo.jdField_a_of_type_JavaLangString + " " + paramnpo.b);
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
    localTextView.setTextColor(getActivity().getBaseContext().getResources().getColor(2131165307));
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
    if (paramEqqDetail == null) {
      return;
    }
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localawgf.b(paramEqqDetail);
    localawgf.a();
  }
  
  public boolean c()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType;
    }
    return i == 1;
  }
  
  protected View d(npo paramnpo)
  {
    View localView = super.getLayoutInflater().inflate(2131562664, null);
    TextView localTextView = (TextView)localView.findViewById(2131377938);
    String str2 = paramnpo.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.startsWith(alud.a(2131704577))) {
        str1 = str2.replaceFirst(alud.a(2131704576), "");
      }
    }
    localTextView.setText(str1);
    ((TextView)localView.findViewById(2131377008)).setText(paramnpo.b);
    localView.setOnClickListener(new ngl(this));
    return localView;
  }
  
  public void d()
  {
    e();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bfyh = ((bfyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_a_of_type_Bfyh.c(this.jdField_d_of_type_JavaLangString, false)))
    {
      paramBundle = new Intent(this, QidianProfileCardActivity.class);
      paramBundle.putExtra("uin", this.jdField_d_of_type_JavaLangString);
      startActivity(paramBundle);
      finish();
    }
    return true;
  }
  
  View e(npo paramnpo)
  {
    if (paramnpo.e != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Unhandled ConfigInfo(" + paramnpo.jdField_a_of_type_Int + ", " + paramnpo.jdField_c_of_type_Int + ", " + paramnpo.e + ")");
      }
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2131562664, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377008));
    if ((paramnpo.d == 1) || (paramnpo.d == 2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693900);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131377938)).setText(paramnpo.jdField_a_of_type_JavaLangString);
      localView.setOnClickListener(new ngo(this, paramnpo));
      return localView;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693901);
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
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), mzx.class);
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
        this.jdField_a_of_type_MqqObserverBusinessObserver = new ngs(this);
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
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
  
  View f(npo paramnpo)
  {
    return null;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, ChatActivity.class);
    }
  }
  
  public void g()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.5(this), 10L);
  }
  
  public void h()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.6(this), 10L);
  }
  
  public void i()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.7(this), 10L);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView");
    }
    m();
    k();
    l();
  }
  
  public void k()
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
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (!b()) {
          break label145;
        }
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_AndroidWidgetButton.getVisibility() != 8) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8)) {
          break label164;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_Ngw == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_Ngw.a() == null)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() != null)
      {
        ((ngw)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter()).a();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      }
      this.jdField_a_of_type_Ngw = new ngw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_Ngw.c(c());
      this.jdField_a_of_type_Ngw.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
        this.jdField_a_of_type_Ngw.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
      this.jdField_a_of_type_Ngw.a(b());
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Ngw);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_Ngw.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
    }
    this.jdField_a_of_type_Ngw.c(c());
    this.jdField_a_of_type_Ngw.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Ngw.a(b());
    this.jdField_a_of_type_Ngw.notifyDataSetChanged();
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
      List localList = npn.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);
      int j = localList.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool = a((npn)localList.get(i), i, j, false, bool);
        i += 1;
      }
    }
    c();
  }
  
  public void o()
  {
    bdiu.a(null, "pubAcc_follow_confirm", this.jdField_d_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow uin=" + this.jdField_d_of_type_JavaLangString);
    }
    this.g = true;
    this.jdField_b_of_type_AndroidViewView.postDelayed(new EqqAccountDetailActivity.11(this), 3000L);
    b(2131695704);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_d_of_type_JavaLangString);
    this.jdField_d_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nrz.class);
    this.jdField_d_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_f_of_type_Boolean)) {
      localFollowRequest.ext.set(this.jdField_f_of_type_JavaLangString);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
    localFollowRequest.account_type.set(a());
    this.jdField_d_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new ngm(this);
    this.jdField_d_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_d_of_type_MqqAppNewIntent);
    this.jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
    }
  }
  
  public void onDestroy()
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
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.toByteArray();
    }
  }
  
  public void q()
  {
    super.q();
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return;
    }
    if (this.jdField_a_of_type_Yuq == null) {
      this.jdField_a_of_type_Yuq = new yuq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), a(), b());
    }
    this.jdField_a_of_type_Yuq.a();
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */