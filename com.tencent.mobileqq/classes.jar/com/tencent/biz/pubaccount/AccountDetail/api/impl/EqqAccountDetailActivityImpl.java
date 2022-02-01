package com.tencent.biz.pubaccount.accountdetail.api.impl;

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
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.accountdetail.api.IEqqAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class EqqAccountDetailActivityImpl
  extends PublicAccountDetailActivityImpl
  implements IEqqAccountDetailActivity
{
  String TAG = "EqqAccountDetailActivity";
  EqqDetail eqqDetail = null;
  boolean fromUser = true;
  mobileqq_mp.GetEqqAccountDetailInfoResponse gEqqData;
  LinearLayout groupListContainer;
  boolean messageSettingActionSheetHasClick = false;
  NewPublicAccountObserver newStatusObserver;
  QidianManager qidianManager;
  int selectedState = 0;
  NewIntent stateIntent;
  NewIntent statusIntent;
  TextView statusTextView;
  
  private int getItemBgType(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = 3;
    if (paramBoolean)
    {
      if (paramInt3 == 0)
      {
        if (paramInt3 == paramInt2 - 1)
        {
          if ((paramInt1 == 1) || (paramInt1 <= 1)) {
            break label173;
          }
          if (paramInt4 == 0) {
            break label158;
          }
          paramInt2 = i;
          if (paramInt4 != paramInt1 - 1) {
            return paramInt2;
          }
        }
        else
        {
          if (paramInt4 == 0) {
            break label158;
          }
          paramInt2 = i;
          if (paramInt4 != paramInt1 - 1) {
            return paramInt2;
          }
          break label171;
        }
      }
      else
      {
        if (paramInt3 <= 0) {
          break label129;
        }
        if (paramInt3 != paramInt2 - 1) {
          break label108;
        }
        if (paramInt4 != paramInt1 - 1) {
          break label97;
        }
      }
      return 2;
      label97:
      paramInt2 = i;
      if (paramInt4 != 0) {
        return paramInt2;
      }
      label108:
      if (paramInt4 == 0) {
        return 4;
      }
      paramInt2 = i;
      if (paramInt4 != paramInt1 - 1) {
        return paramInt2;
      }
      break label171;
      label129:
      if (!QLog.isColorLevel()) {
        break label173;
      }
      QLog.d(this.TAG, 2, "getItemBgType error groupId < 0");
      break label173;
    }
    else
    {
      if (paramInt1 <= 1) {
        break label173;
      }
      if (paramInt4 != 0) {
        break label160;
      }
    }
    label158:
    return 1;
    label160:
    paramInt2 = i;
    if (paramInt4 == paramInt1 - 1)
    {
      label171:
      return 5;
      label173:
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  boolean addCrmDetailItem(ViewGroup paramViewGroup, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addCrmDetailItem");
    }
    Object localObject1 = super.getLayoutInflater();
    int j = (int)(this.density * 10.0F);
    int k = (int)(this.density * 15.0F);
    Object localObject2;
    if (paramPaConfigInfo.a == 3)
    {
      if (paramPaConfigInfo.e == 3)
      {
        this.sendMsgBtn.setVisibility(0);
        return false;
      }
      if (paramPaConfigInfo.e == 10)
      {
        localObject1 = buildMsgSettingItem(paramPaConfigInfo);
        if (localObject1 == null) {
          return false;
        }
      }
      else
      {
        if (paramPaConfigInfo.e == 7)
        {
          paramPaConfigInfo.m = this.eqqDetail.latitude;
          paramPaConfigInfo.l = this.eqqDetail.longitude;
          localObject1 = buildMapItemForEqq(paramPaConfigInfo);
          if (localObject1 != null) {
            break label440;
          }
        }
        do
        {
          return false;
          if (paramPaConfigInfo.e != 8) {
            break;
          }
          localObject1 = buildPhoneItemForEqq(paramPaConfigInfo);
        } while (localObject1 != null);
        return false;
        if (paramPaConfigInfo.e == 9)
        {
          localObject1 = buildHistoryItemForEqq(paramPaConfigInfo);
          if (localObject1 == null) {
            return false;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramViewGroup = this.TAG;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("unhandled event_id: ");
            ((StringBuilder)localObject1).append(paramPaConfigInfo.e);
            QLog.d(paramViewGroup, 2, ((StringBuilder)localObject1).toString());
          }
          return false;
        }
      }
    }
    else if (paramPaConfigInfo.a == 1)
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131624335, null);
      ((ImageView)((View)localObject1).findViewById(2131436047)).setImageResource(2130838992);
      ((ImageView)((View)localObject1).findViewById(2131428774)).setVisibility(0);
      localObject2 = paramPaConfigInfo.h;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return false;
      }
      ((TextView)((View)localObject1).findViewById(2131431322)).setText((CharSequence)localObject2);
      if (paramPaConfigInfo.b.contains(HardCodeUtil.a(2131902216))) {
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
      }
      ((View)localObject1).setOnClickListener(new EqqAccountDetailActivityImpl.1(this, (String)localObject2, paramPaConfigInfo));
    }
    int i;
    for (;;)
    {
      i = 0;
      break;
      if (paramPaConfigInfo.a == 2)
      {
        localObject2 = buildStateChangeItem(paramPaConfigInfo);
        localObject1 = localObject2;
        if (localObject2 == null) {
          return false;
        }
        i = 1;
        break;
      }
      if (paramPaConfigInfo.a == 4)
      {
        localObject1 = buildRichTextItemForEqq(paramPaConfigInfo);
        if (localObject1 == null) {
          label440:
          return false;
        }
      }
      else
      {
        if (paramPaConfigInfo.a == 5) {
          return false;
        }
        localObject1 = ((LayoutInflater)localObject1).inflate(2131624335, null);
      }
    }
    if (i != 0)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4) {
                if (paramInt != 5) {
                  ((View)localObject1).setBackgroundResource(2130837615);
                } else {
                  ((View)localObject1).setBackgroundResource(2130837617);
                }
              }
            }
            else {
              ((View)localObject1).setBackgroundResource(2130837617);
            }
          }
          else {
            ((View)localObject1).setBackgroundResource(2130837617);
          }
        }
        else {
          ((View)localObject1).setBackgroundResource(2130837618);
        }
      }
      else {
        ((View)localObject1).setBackgroundResource(2130837615);
      }
      if (paramPaConfigInfo.a == 4) {
        ((View)localObject1).setPadding(k, k, k, k);
      } else if (paramPaConfigInfo.a == 2)
      {
        if (paramPaConfigInfo.g == 5) {
          ((View)localObject1).setPadding(k, j, k, k);
        } else {
          ((View)localObject1).setPadding(k, 0, k, 0);
        }
      }
      else {
        ((View)localObject1).setPadding(k, j, k, k);
      }
      paramPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)localObject1;
    }
    else
    {
      paramPaConfigInfo = ((View)localObject1).findViewById(2131431350);
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt != 3) {
              if (paramInt != 4)
              {
                if (paramInt == 5) {
                  break label694;
                }
                paramPaConfigInfo.setBackgroundResource(2130837615);
              }
            }
          }
        }
      }
      for (;;)
      {
        break;
        label694:
        paramPaConfigInfo.setBackgroundResource(2130837617);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837617);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837616);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837618);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837615);
      }
      paramPaConfigInfo.setPadding(0, k, k, k);
    }
    paramViewGroup.addView((View)localObject1);
    if ((i != 0) && (paramInt == 2))
    {
      paramPaConfigInfo = new View(paramPaConfigInfo.getContext());
      paramPaConfigInfo.setBackgroundColor(Color.parseColor("#dedfe0"));
      paramViewGroup.addView(paramPaConfigInfo, new ViewGroup.LayoutParams(-1, 1));
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addCrmDetailItem exit");
    }
    return true;
  }
  
  public boolean addGroup(IPublicAccountConfigAttr paramIPublicAccountConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addGroup start");
    }
    ViewGroup localViewGroup = createGroupLayout();
    paramIPublicAccountConfigAttr = resetConfigInfoListForUnfollow(paramIPublicAccountConfigAttr.getConfigs(), paramBoolean1);
    Object localObject = paramIPublicAccountConfigAttr.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject).next()).g == 5) {
        ((Iterator)localObject).remove();
      }
    }
    int j = paramIPublicAccountConfigAttr.size();
    if ((paramBoolean1) && (paramInt1 > 0) && (j > 0) && (paramBoolean2))
    {
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.density * 9.0F)));
      ((View)localObject).setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView((View)localObject);
    }
    int i = 0;
    paramBoolean2 = false;
    while (i < j)
    {
      int k = getItemBgType(j, paramInt2, paramInt1, i, paramBoolean1);
      if ((!addCrmDetailItem(localViewGroup, (IPublicAccountConfigAttr.PaConfigInfo)paramIPublicAccountConfigAttr.get(i), k, paramBoolean1)) && (!paramBoolean2)) {
        paramBoolean2 = false;
      } else {
        paramBoolean2 = true;
      }
      i += 1;
    }
    if ((!paramBoolean1) && (paramInt1 == paramInt2 - 1))
    {
      paramIPublicAccountConfigAttr = new View(this);
      paramIPublicAccountConfigAttr.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
      paramIPublicAccountConfigAttr.setBackgroundColor(Color.parseColor("#d6d6d6"));
      localViewGroup.addView(paramIPublicAccountConfigAttr);
    }
    afterAddAllDetailItemForEqq(localViewGroup, paramBoolean1);
    this.groupListContainer.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addGroup exit");
    }
    return paramBoolean2;
  }
  
  protected void addGroupList()
  {
    this.groupListContainer.removeAllViews();
    List localList;
    if (this.eqqDetail != null) {
      localList = ((IPublicAccountConfigAttr)QRoute.api(IPublicAccountConfigAttr.class)).castToPaConfigAttrs(this.eqqDetail.groupInfoList);
    } else {
      localList = null;
    }
    if (localList != null)
    {
      int j = localList.size();
      boolean bool = false;
      int i = 0;
      while (i < j)
      {
        bool = addGroup((IPublicAccountConfigAttr)localList.get(i), i, j, true, bool);
        i += 1;
      }
    }
    addSummaryItemForEqq();
  }
  
  void addGroupListForEqq()
  {
    if (isFollowed())
    {
      addGroupList();
      return;
    }
    addUnfollowGroupListForEqq();
  }
  
  protected void addSummaryItemForEqq()
  {
    Object localObject = this.eqqDetail;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((EqqDetail)localObject).realSummary)) {
        return;
      }
      localObject = new TextView(getActivity().getBaseContext());
      ((TextView)localObject).setText(this.eqqDetail.realSummary);
      ((TextView)localObject).setTextSize(14.0F);
      ((TextView)localObject).setTextColor(getActivity().getBaseContext().getResources().getColor(2131165564));
      double d = this.density;
      Double.isNaN(d);
      int i = (int)(d * 16.5D);
      d = this.density;
      Double.isNaN(d);
      int j = (int)(d * 16.5D);
      d = this.density;
      Double.isNaN(d);
      int k = (int)(d * 22.5D);
      d = this.density;
      Double.isNaN(d);
      int m = (int)(d * 22.5D);
      int n = (int)(this.density * 5.0F);
      ((TextView)localObject).setPadding(i, k, j, m);
      ((TextView)localObject).setLineSpacing(n, 1.0F);
      ((TextView)localObject).setVisibility(0);
      this.groupListContainer.addView((View)localObject);
    }
  }
  
  protected void addUnfollowGroupListForEqq()
  {
    this.groupListContainer.removeAllViews();
    Object localObject = this.eqqDetail;
    if (localObject == null) {
      return;
    }
    if (((EqqDetail)localObject).groupInfoList != null)
    {
      localObject = ((IPublicAccountConfigAttr)QRoute.api(IPublicAccountConfigAttr.class)).castToPaConfigAttrs(this.eqqDetail.groupInfoList);
      int j = ((List)localObject).size();
      boolean bool = false;
      int i = 0;
      while (i < j)
      {
        bool = addGroup((IPublicAccountConfigAttr)((List)localObject).get(i), i, j, false, bool);
        i += 1;
      }
    }
    addSummaryItemForEqq();
  }
  
  void afterAddAllDetailItemForEqq(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.eqqDetail == null) {
      return;
    }
    if (paramBoolean)
    {
      this.sendMsgBtn.setVisibility(0);
      if (this.eqqDetail.hasIvrAbility()) {
        this.callBtn.setVisibility(0);
      } else {
        this.callBtn.setVisibility(8);
      }
    }
    else
    {
      this.sendMsgBtn.setVisibility(8);
      if (this.eqqDetail.hasIvrAbility()) {
        this.callBtn.setVisibility(0);
      } else {
        this.callBtn.setVisibility(8);
      }
    }
    if (needShowQQCall())
    {
      this.callBtn.setVisibility(0);
      return;
    }
    this.callBtn.setVisibility(8);
  }
  
  protected View buildHistoryItemForEqq(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2131629308, null);
    TextView localTextView = (TextView)localView.findViewById(2131447463);
    String str2 = paramPaConfigInfo.b;
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.startsWith(HardCodeUtil.a(2131902215))) {
        str1 = str2.replaceFirst(HardCodeUtil.a(2131902214), "");
      }
    }
    localTextView.setText(str1);
    ((TextView)localView.findViewById(2131446326)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new EqqAccountDetailActivityImpl.10(this));
    return localView;
  }
  
  protected View buildMapItemForEqq(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2131624335, null);
    ((ImageView)localView.findViewById(2131436047)).setImageResource(2130838991);
    ((ImageView)localView.findViewById(2131428774)).setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131431322);
    String str = paramPaConfigInfo.c;
    if (!TextUtils.isEmpty(str))
    {
      localTextView.setText(str);
      localView.setOnClickListener(new EqqAccountDetailActivityImpl.8(this, paramPaConfigInfo, str));
      return localView;
    }
    return null;
  }
  
  View buildMsgSettingItem(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo.g != 6)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unhandled ConfigInfo(");
        localStringBuilder.append(paramPaConfigInfo.a);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramPaConfigInfo.e);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramPaConfigInfo.g);
        localStringBuilder.append(")");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    Object localObject = super.getLayoutInflater().inflate(2131629308, null);
    this.statusTextView = ((TextView)((View)localObject).findViewById(2131446326));
    if ((paramPaConfigInfo.f != 1) && (paramPaConfigInfo.f != 2)) {
      this.statusTextView.setText(2131891197);
    } else {
      this.statusTextView.setText(2131891196);
    }
    ((TextView)((View)localObject).findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((View)localObject).setOnClickListener(new EqqAccountDetailActivityImpl.14(this, paramPaConfigInfo));
    return localObject;
  }
  
  protected View buildPhoneItemForEqq(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (this.eqqDetail == null) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2131624335, null);
    ((ImageView)localView.findViewById(2131436047)).setImageResource(2130838994);
    ((ImageView)localView.findViewById(2131428774)).setVisibility(0);
    String str = paramPaConfigInfo.c;
    if (str != null)
    {
      str = str.trim();
      boolean bool1 = this.eqqDetail.hasIvrAbility();
      boolean bool2 = Pattern.compile("[\\d-]+?").matcher(str).matches();
      if (bool2)
      {
        ((TextView)localView.findViewById(2131431322)).setText(str);
      }
      else
      {
        if (!bool1) {
          break label187;
        }
        ((TextView)localView.findViewById(2131431322)).setText(2131917335);
      }
      localView.setOnClickListener(new EqqAccountDetailActivityImpl.9(this, bool2, str, bool1, paramPaConfigInfo));
      ReportController.b(this.app, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.uin, "", "", "");
      return localView;
      label187:
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "buildPhoneItem no phone ability and no ivr ability");
      }
    }
    return null;
  }
  
  protected View buildRichTextItemForEqq(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject = paramPaConfigInfo.b;
    if ((localObject != null) && (((String)localObject).equals(HardCodeUtil.a(2131902212)))) {
      return null;
    }
    localObject = super.getLayoutInflater().inflate(2131624335, null);
    ((ImageView)((View)localObject).findViewById(2131436047)).setImageResource(2130838993);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131431322);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPaConfigInfo.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramPaConfigInfo.c);
    localTextView.setText(localStringBuilder.toString());
    return localObject;
  }
  
  View buildStateChangeItem(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    return null;
  }
  
  void changeMsgState(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    int i = paramPaConfigInfo.g;
    if (paramInt == 1)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A2B", "0X8005A2B", 0, 0, "", "", "", "", false);
      i = 1;
    }
    else
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A2A", "0X8005A2A", 0, 0, "", "", "", "", false);
      i = 3;
    }
    delayShowLoading(2131893010);
    this.app.removeObserver(this.newStatusObserver);
    this.newStatusObserver = new NewPublicAccountObserver(new EqqAccountDetailActivityImpl.17(this, paramPaConfigInfo, i, paramInt));
    this.app.addObserver(this.newStatusObserver);
    paramPaConfigInfo = this.app;
    String str1 = this.eqqDetail.uin;
    String str2 = this.eqqDetail.name;
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    PublicAccountStateReporter.a(paramPaConfigInfo, str1, str2, paramInt);
    this.waitingCount += 1;
  }
  
  ViewGroup createGroupLayout()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "createGroupLayout exit");
    }
    return localLinearLayout;
  }
  
  void deleteAccount(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramEqqDetail);
    localEntityManager.close();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.qidianManager = ((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    if ((this.uin != null) && (this.qidianManager.d(this.uin, false)))
    {
      paramBundle = new Intent(this, QidianProfileCardActivity.class);
      paramBundle.putExtra("uin", this.uin);
      startActivity(paramBundle);
      finish();
    }
    return true;
  }
  
  protected void follow()
  {
    PAStartupTracker.a(null, "pubAcc_follow_confirm", this.uin);
    if (QLog.isColorLevel())
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("follow uin=");
      localStringBuilder.append(this.uin);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.needUpdateView = true;
    this.followBtn.postDelayed(new EqqAccountDetailActivityImpl.11(this), 3000L);
    delayShowLoading(2131892923);
    ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.uin);
    this.followIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
    this.followIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.mSendMessage)) && (this.mIsReportMessage)) {
      ((mobileqq_mp.FollowRequest)localObject).ext.set(this.mSendMessage);
    }
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.uin));
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(getAccountType());
    this.followIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    this.followObserver = new EqqAccountDetailActivityImpl.12(this);
    this.followIntent.setObserver(this.followObserver);
    this.app.startServlet(this.followIntent);
    this.waitingCount += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "follow exit");
    }
  }
  
  protected String getAccountName()
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    if (localEqqDetail != null) {
      return localEqqDetail.name;
    }
    return "";
  }
  
  protected int getAccountType()
  {
    return 2;
  }
  
  protected int getCertifiedGrade()
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    if (localEqqDetail != null) {
      return localEqqDetail.certifiedGrade;
    }
    return 0;
  }
  
  protected ShareActionSheet.Detail getShareDetail()
  {
    return new ShareActionSheet.Detail(this.eqqDetail.uin, this.eqqDetail.name, this.eqqDetail.summary);
  }
  
  public String getShareUrl()
  {
    if (this.shareUrl == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=");
      localStringBuilder.append(this.uin);
      localStringBuilder.append("&account_flag=");
      localStringBuilder.append(this.eqqDetail.eqqAccountFlag);
      localStringBuilder.append("&jumptype=1&card_type=crm");
      this.shareUrl = localStringBuilder.toString();
    }
    return this.shareUrl;
  }
  
  protected void gotoChatActivity()
  {
    if (this.eqqDetail != null) {
      open(this.uin, 1008, this.eqqDetail.name, ChatActivity.class);
    }
  }
  
  protected void initAccountDetailListView()
  {
    super.initAccountDetailListView();
    this.groupListContainer = new LinearLayout(this);
    this.groupListContainer.setOrientation(1);
    this.groupListContainer.setBackgroundColor(Color.parseColor("#FFFFFF"));
  }
  
  protected boolean isFollowed()
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    int i;
    if (localEqqDetail != null) {
      i = localEqqDetail.followType;
    } else {
      i = -1;
    }
    return i == 1;
  }
  
  protected boolean loadCache()
  {
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
    this.eqqDetail = ((EqqDetail)((EntityManager)localObject).find(EqqDetail.class, this.uin));
    ((EntityManager)localObject).close();
    if (this.eqqDetail == null) {
      return false;
    }
    try
    {
      this.gEqqData = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      this.gEqqData.mergeFrom(this.eqqDetail.accountData);
      localObject = this.gEqqData.config_group_info;
      if (localObject != null) {
        this.eqqDetail.groupInfoList = ((PBRepeatMessageField)localObject).get();
      }
    }
    catch (Exception localException)
    {
      label90:
      break label90;
    }
    return true;
  }
  
  protected boolean needShowQQCall()
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    return (localEqqDetail != null) && (localEqqDetail.hasIvrAbility());
  }
  
  protected boolean needShowUnFollowBtnInActionSheet()
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    return (localEqqDetail != null) && (localEqqDetail.followType == 1);
  }
  
  void notifyUpdateDetailInfo(EqqDetail paramEqqDetail)
  {
    this.publicAccountHandler.onGetPublicAccount();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    NewIntent localNewIntent = this.stateIntent;
    if (localNewIntent != null)
    {
      localNewIntent.setObserver(null);
      this.stateIntent = null;
    }
    localNewIntent = this.statusIntent;
    if (localNewIntent != null)
    {
      localNewIntent.setObserver(null);
      this.statusIntent = null;
    }
  }
  
  protected void open(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
  {
    this.mIntent.getBooleanExtra("need_finish", false);
    paramString2 = this.eqqDetail;
    if (paramString2 == null) {
      return;
    }
    if (paramString2.followType == 1)
    {
      paramString2 = new Intent(this, ChatActivity.class);
      paramString2.putExtra("chat_subType", 1);
      paramString2.putExtra("cSpecialFlag", this.mIntent.getExtras().getInt("cSpecialFlag"));
      paramString2.putExtra("uin", paramString1);
      paramString2.putExtra("uintype", 0);
      paramString2.putExtra("uinname", this.eqqDetail.name);
      paramString2.putExtra("isforceRequestDetail", paramBoolean);
      paramString2.putExtra("jump_from", 2);
      startActivity(paramString2);
      return;
    }
    paramString2 = new Intent(this, ChatActivity.class);
    paramString2.putExtra("chat_subType", 1);
    paramString2.putExtra("uin", paramString1);
    paramString2.putExtra("uintype", 1024);
    paramString2.putExtra("uinname", this.eqqDetail.name);
    paramString2.putExtra("isforceRequestDetail", paramBoolean);
    paramString2.putExtra("jump_from", 2);
    startActivity(paramString2);
  }
  
  protected void saveAccountDetailInSubThread()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivityImpl.5(this), 10L);
  }
  
  protected void saveDetailForStateChange(int paramInt, boolean paramBoolean)
  {
    this.eqqDetail.accountData = this.gEqqData.toByteArray();
    if (paramInt == 3)
    {
      EqqDetail localEqqDetail = this.eqqDetail;
      localEqqDetail.mIsSyncLbs = true;
      localEqqDetail.mIsAgreeSyncLbs = paramBoolean;
    }
    saveEqqDetailInSubThread(this.eqqDetail);
  }
  
  void saveEqqDetailInSubThread(EqqDetail paramEqqDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivityImpl.4(this, paramEqqDetail), 10L);
  }
  
  void saveEqqDetailToDBAndCache(EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "saveEqqDetailToDBAndCache");
    }
    Object localObject = (EqqDetailDataManager)this.app.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
    if (localObject != null) {
      ((EqqDetailDataManager)localObject).a(paramEqqDetail);
    }
    localObject = this.app.getEntityManagerFactory().createEntityManager();
    EqqDetail localEqqDetail = this.eqqDetail;
    if ((localEqqDetail != null) && (localEqqDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, paramEqqDetail.name);
      }
      this.eqqDetail.clone(paramEqqDetail);
      if (!((EntityManager)localObject).update(this.eqqDetail)) {
        ((EntityManager)localObject).drop(EqqDetail.class);
      }
    }
    else
    {
      this.eqqDetail = paramEqqDetail;
      ((EntityManager)localObject).persist(paramEqqDetail);
    }
    ((EntityManager)localObject).close();
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
    {
      localObject = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        ((IPublicAccountDataManager)localObject).savePublicAccountInfo(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "saveEqqDetailToDBAndCache exit");
    }
  }
  
  void sendCrmDetailInfoRequest()
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCrmDetailInfoRequest, ts=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("crmtest", 4, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendDetailInfoRequest");
    }
    if (this.detailIntent != null) {
      this.detailIntent.setObserver(null);
    }
    this.detailIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
    this.detailIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
    Object localObject = new mobileqq_mp.GetEqqDetailInfoRequest();
    ((mobileqq_mp.GetEqqDetailInfoRequest)localObject).version.set(2);
    if (this.eqqDetail != null) {
      ((mobileqq_mp.GetEqqDetailInfoRequest)localObject).seqno.set(this.eqqDetail.seqno);
    } else {
      ((mobileqq_mp.GetEqqDetailInfoRequest)localObject).seqno.set(0);
    }
    try
    {
      ((mobileqq_mp.GetEqqDetailInfoRequest)localObject).eqq_id.set((int)Long.parseLong(this.uin));
      label168:
      this.detailIntent.putExtra("data", ((mobileqq_mp.GetEqqDetailInfoRequest)localObject).toByteArray());
      this.detailObserver = new EqqAccountDetailActivityImpl.2(this);
      this.detailIntent.setObserver(this.detailObserver);
      this.app.startServlet(this.detailIntent);
      this.waitingCount += 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "sendCrmDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception localException)
    {
      break label168;
    }
  }
  
  protected void sendDetailInfoRequest()
  {
    sendCrmDetailInfoRequest();
  }
  
  protected void setAccountData()
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    if (localEqqDetail != null) {
      localEqqDetail.accountData = this.gEqqData.toByteArray();
    }
  }
  
  protected void setIsConfirmed(boolean paramBoolean)
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    if (localEqqDetail != null) {
      localEqqDetail.isConfirmed = paramBoolean;
    }
  }
  
  protected void setShowMsgFlag(int paramInt)
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    if (localEqqDetail != null) {
      localEqqDetail.mShowMsgFlag = paramInt;
    }
  }
  
  void setStatusText(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    int i = paramPaConfigInfo.f;
    this.fromUser = false;
    if ((i != 1) && (i != 2))
    {
      this.statusTextView.setText(2131891197);
      return;
    }
    this.statusTextView.setText(2131891196);
  }
  
  protected void share()
  {
    super.share();
    if (!TextUtils.isEmpty(this.uin))
    {
      if (this.eqqDetail == null) {
        return;
      }
      if (this.mShareActionSheet == null) {
        this.mShareActionSheet = new ShareActionSheet(this.app, this, getShareDetail(), getAccountType(), getShareUrl());
      }
      this.mShareActionSheet.a();
      PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, this.uin, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
    }
  }
  
  void showCallConfirm(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1))
    {
      showPhoneActionSheet(paramString);
      return;
    }
    if (paramBoolean1)
    {
      showPhoneConfirm(paramString);
      return;
    }
    if (paramBoolean2)
    {
      if (this.eqqDetail != null) {
        CrmUtils.a(this.app, this, this.eqqDetail.name, this.uin, "IvrEnterpriseDetailEngineFalse");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showCallConfirm no phone ability and no ivr ability");
    }
  }
  
  void showMessageSettingActionSheet(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.c(this, null);
    localActionSheet.addRadioButton(2131891196, 5, false);
    localActionSheet.addRadioButton(2131891197, 5, false);
    int i = 1;
    if ((paramInt != 1) && (paramInt != 2)) {
      localActionSheet.setRadioButtonChecked(1);
    } else {
      localActionSheet.setRadioButtonChecked(0);
    }
    if ((paramInt == 1) || (paramInt == 2)) {
      i = 0;
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new EqqAccountDetailActivityImpl.15(this));
    localActionSheet.setOnButtonClickListener(new EqqAccountDetailActivityImpl.16(this, paramPaConfigInfo, localActionSheet, i));
    if (!localActionSheet.isShowing())
    {
      this.messageSettingActionSheetHasClick = false;
      localActionSheet.show();
    }
  }
  
  void showPhoneActionSheet(String paramString)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.c(this, null);
    localActionSheet.addButton(2131917335);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131888562));
    localStringBuilder.append(paramString);
    localActionSheet.addButton(localStringBuilder.toString());
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new EqqAccountDetailActivityImpl.13(this, localActionSheet, paramString));
    localActionSheet.show();
  }
  
  void updateBottomContainer()
  {
    EqqDetail localEqqDetail = this.eqqDetail;
    if (localEqqDetail == null) {
      return;
    }
    if (localEqqDetail.followType == 1)
    {
      this.sendMsgBtn.setVisibility(0);
      this.followBtn.setVisibility(8);
      this.bottomContainer.setVisibility(0);
    }
    else
    {
      this.followBtn.setVisibility(0);
      this.followBtn.setOnClickListener(this);
      this.sendMsgBtn.setVisibility(8);
      this.bottomContainer.setVisibility(0);
    }
    if (needShowQQCall())
    {
      this.btnsDivider1.setVisibility(0);
      this.callBtn.setVisibility(0);
      this.callBtn.setOnClickListener(this);
    }
    else
    {
      this.btnsDivider1.setVisibility(8);
      this.callBtn.setVisibility(8);
    }
    if ((this.sendMsgBtn.getVisibility() == 8) && (this.followBtn.getVisibility() == 8)) {
      this.bottomContainer.setVisibility(8);
    }
  }
  
  void updateDetailInfo(EqqDetail paramEqqDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivityImpl.3(this, paramEqqDetail, paramBoolean), 10L);
  }
  
  protected void updateFollowInfo()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivityImpl.7(this), 10L);
  }
  
  void updateListView()
  {
    if ((this.mAccountDetailAdapter != null) && (this.mAccountDetailListView.getAdapter() != null) && ((this.eqqDetail == null) || (this.mAccountDetailAdapter.c() != null)))
    {
      if (this.eqqDetail != null) {
        this.mAccountDetailAdapter.a(this.eqqDetail);
      }
      this.mAccountDetailAdapter.c(getFace());
      this.mAccountDetailAdapter.b(this.groupListContainer);
      this.mAccountDetailAdapter.a(getContainerListviewHeight());
      this.mAccountDetailAdapter.notifyDataSetChanged();
      return;
    }
    if (this.mAccountDetailListView.getAdapter() != null)
    {
      ((AccountDetailBaseAdapter)this.mAccountDetailListView.getAdapter()).d();
      this.mAccountDetailListView.setAdapter(null);
    }
    this.mAccountDetailAdapter = new AccountDetailBaseAdapter(this.app, this, this.uin, this.mAccountDetailListView, this.iconTop, this.iconCicleTop, this.titleViewLayout, this.iconCertifiedTop, this.mTopGestureLayout);
    this.mAccountDetailAdapter.c(getFace());
    this.mAccountDetailAdapter.b(this.groupListContainer);
    if (this.eqqDetail != null) {
      this.mAccountDetailAdapter.a(this.eqqDetail);
    }
    this.mAccountDetailListView.a(false);
    this.mAccountDetailAdapter.a(getContainerListviewHeight());
    this.mAccountDetailListView.setAdapter(this.mAccountDetailAdapter);
  }
  
  protected void updateUnfollowInfo()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivityImpl.6(this), 10L);
  }
  
  protected void updateView()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateView");
    }
    addGroupListForEqq();
    updateBottomContainer();
    updateListView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl
 * JD-Core Version:    0.7.0.1
 */