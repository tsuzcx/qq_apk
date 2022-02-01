package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.tencent.biz.pubaccount.AccountDetail.activity.api.IEqqAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
      QLog.d(this.TAG, 2, "getItemBgType error groupId < 0");
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
  
  boolean addCrmDetailItem(ViewGroup paramViewGroup, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addCrmDetailItem");
    }
    Object localObject = super.getLayoutInflater();
    int j = (int)(10.0F * this.density);
    int k = (int)(15.0F * this.density);
    int i;
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3)
    {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 3)
      {
        this.sendMsgBtn.setVisibility(0);
        return false;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 10)
      {
        localObject = buildMsgSettingItem(paramPaConfigInfo);
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
          ((View)localObject).setBackgroundResource(2130837522);
        case 4: 
          label143:
          if (paramPaConfigInfo.jdField_a_of_type_Int == 4)
          {
            ((View)localObject).setPadding(k, k, k, k);
            paramPaConfigInfo = (PaConfigAttr.PaConfigInfo)localObject;
          }
          break;
        }
        for (;;)
        {
          paramViewGroup.addView((View)localObject);
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
          return false;
          if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
          {
            paramPaConfigInfo.g = this.eqqDetail.latitude;
            paramPaConfigInfo.f = this.eqqDetail.longitude;
            localObject = buildMapItemForEqq(paramPaConfigInfo);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
          {
            localObject = buildPhoneItemForEqq(paramPaConfigInfo);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (paramPaConfigInfo.jdField_c_of_type_Int == 9)
          {
            localObject = buildHistoryItemForEqq(paramPaConfigInfo);
            if (localObject != null)
            {
              i = 1;
              break;
            }
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
          }
          return false;
          if (paramPaConfigInfo.jdField_a_of_type_Int == 1)
          {
            localObject = ((LayoutInflater)localObject).inflate(2131558818, null);
            ((ImageView)((View)localObject).findViewById(2131369351)).setImageResource(2130839010);
            ((ImageView)((View)localObject).findViewById(2131363027)).setVisibility(0);
            String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
            if (TextUtils.isEmpty(str)) {
              return false;
            }
            ((TextView)((View)localObject).findViewById(2131365294)).setText(str);
            if (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains(HardCodeUtil.a(2131704211))) {
              ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
            }
            ((View)localObject).setOnClickListener(new EqqAccountDetailActivityImpl.1(this, str, paramPaConfigInfo));
            i = 0;
            break;
          }
          if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
          {
            localObject = buildStateChangeItem(paramPaConfigInfo);
            if (localObject != null) {
              break label849;
            }
            return false;
          }
          if (paramPaConfigInfo.jdField_a_of_type_Int == 4)
          {
            localObject = buildRichTextItemForEqq(paramPaConfigInfo);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (paramPaConfigInfo.jdField_a_of_type_Int == 5) {
            return false;
          }
          localObject = ((LayoutInflater)localObject).inflate(2131558818, null);
          i = 0;
          break;
          ((View)localObject).setBackgroundResource(2130837522);
          break label143;
          ((View)localObject).setBackgroundResource(2130837525);
          break label143;
          ((View)localObject).setBackgroundResource(2130837524);
          break label143;
          ((View)localObject).setBackgroundResource(2130837524);
          break label143;
          ((View)localObject).setBackgroundResource(2130837524);
          break label143;
          if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
          {
            if (paramPaConfigInfo.e == 5)
            {
              ((View)localObject).setPadding(k, j, k, k);
              paramPaConfigInfo = (PaConfigAttr.PaConfigInfo)localObject;
            }
            else
            {
              ((View)localObject).setPadding(k, 0, k, 0);
              paramPaConfigInfo = (PaConfigAttr.PaConfigInfo)localObject;
            }
          }
          else
          {
            ((View)localObject).setPadding(k, j, k, k);
            paramPaConfigInfo = (PaConfigAttr.PaConfigInfo)localObject;
          }
        }
      }
      paramPaConfigInfo = ((View)localObject).findViewById(2131365313);
      switch (paramInt)
      {
      default: 
        paramPaConfigInfo.setBackgroundResource(2130837522);
      }
      for (;;)
      {
        paramPaConfigInfo.setPadding(0, k, k, k);
        break;
        paramPaConfigInfo.setBackgroundResource(2130837522);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837525);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837523);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837524);
        continue;
        paramPaConfigInfo.setBackgroundResource(2130837524);
      }
      label849:
      i = 1;
    }
  }
  
  public boolean addGroup(PaConfigAttr paramPaConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addGroup start");
    }
    ViewGroup localViewGroup = createGroupLayout();
    paramPaConfigAttr = resetConfigInfoListForUnfollow(paramPaConfigAttr.a, paramBoolean1);
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
      ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.density)));
      ((View)localObject).setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView((View)localObject);
    }
    int i = 0;
    paramBoolean2 = false;
    if (i < j)
    {
      int k = getItemBgType(j, paramInt2, paramInt1, i, paramBoolean1);
      if ((addCrmDetailItem(localViewGroup, (PaConfigAttr.PaConfigInfo)paramPaConfigAttr.get(i), k, paramBoolean1)) || (paramBoolean2)) {}
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
    afterAddAllDetailItemForEqq(localViewGroup, paramBoolean1);
    this.groupListContainer.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addGroup exit");
    }
    return paramBoolean2;
  }
  
  protected void addGroupList()
  {
    int i = 0;
    this.groupListContainer.removeAllViews();
    if (this.eqqDetail != null) {}
    for (List localList = PaConfigAttr.a(this.eqqDetail.groupInfoList);; localList = null)
    {
      if (localList != null)
      {
        int j = localList.size();
        boolean bool = false;
        while (i < j)
        {
          bool = addGroup((PaConfigAttr)localList.get(i), i, j, true, bool);
          i += 1;
        }
      }
      addSummaryItemForEqq();
      return;
    }
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
    if ((this.eqqDetail == null) || (TextUtils.isEmpty(this.eqqDetail.realSummary))) {
      return;
    }
    TextView localTextView = new TextView(getActivity().getBaseContext());
    localTextView.setText(this.eqqDetail.realSummary);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getActivity().getBaseContext().getResources().getColor(2131165357));
    int i = (int)(this.density * 16.5D);
    int j = (int)(this.density * 16.5D);
    int k = (int)(this.density * 22.5D);
    int m = (int)(this.density * 22.5D);
    int n = (int)(5.0F * this.density);
    localTextView.setPadding(i, k, j, m);
    localTextView.setLineSpacing(n, 1.0F);
    localTextView.setVisibility(0);
    this.groupListContainer.addView(localTextView);
  }
  
  protected void addUnfollowGroupListForEqq()
  {
    this.groupListContainer.removeAllViews();
    if (this.eqqDetail == null) {
      return;
    }
    if (this.eqqDetail.groupInfoList != null)
    {
      List localList = PaConfigAttr.a(this.eqqDetail.groupInfoList);
      int j = localList.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool = addGroup((PaConfigAttr)localList.get(i), i, j, false, bool);
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
      }
    }
    while (needShowQQCall())
    {
      this.callBtn.setVisibility(0);
      return;
      this.callBtn.setVisibility(8);
      continue;
      this.sendMsgBtn.setVisibility(8);
      if (this.eqqDetail.hasIvrAbility()) {
        this.callBtn.setVisibility(0);
      } else {
        this.callBtn.setVisibility(8);
      }
    }
    this.callBtn.setVisibility(8);
  }
  
  protected View buildHistoryItemForEqq(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2131563034, null);
    TextView localTextView = (TextView)localView.findViewById(2131379432);
    String str2 = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.startsWith(HardCodeUtil.a(2131704210))) {
        str1 = str2.replaceFirst(HardCodeUtil.a(2131704209), "");
      }
    }
    localTextView.setText(str1);
    ((TextView)localView.findViewById(2131378436)).setText(paramPaConfigInfo.b);
    localView.setOnClickListener(new EqqAccountDetailActivityImpl.10(this));
    return localView;
  }
  
  protected View buildMapItemForEqq(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2131558818, null);
    ((ImageView)localView.findViewById(2131369351)).setImageResource(2130839009);
    ((ImageView)localView.findViewById(2131363027)).setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131365294);
    String str = paramPaConfigInfo.b;
    if (!TextUtils.isEmpty(str))
    {
      localTextView.setText(str);
      localView.setOnClickListener(new EqqAccountDetailActivityImpl.8(this, paramPaConfigInfo, str));
      return localView;
    }
    return null;
  }
  
  View buildMsgSettingItem(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo.e != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "Unhandled ConfigInfo(" + paramPaConfigInfo.jdField_a_of_type_Int + ", " + paramPaConfigInfo.jdField_c_of_type_Int + ", " + paramPaConfigInfo.e + ")");
      }
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2131563034, null);
    this.statusTextView = ((TextView)localView.findViewById(2131378436));
    if ((paramPaConfigInfo.d == 1) || (paramPaConfigInfo.d == 2)) {
      this.statusTextView.setText(2131693668);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
      localView.setOnClickListener(new EqqAccountDetailActivityImpl.14(this, paramPaConfigInfo));
      return localView;
      this.statusTextView.setText(2131693669);
    }
  }
  
  protected View buildPhoneItemForEqq(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (this.eqqDetail == null) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2131558818, null);
    ((ImageView)localView.findViewById(2131369351)).setImageResource(2130839012);
    ((ImageView)localView.findViewById(2131363027)).setVisibility(0);
    String str = paramPaConfigInfo.b;
    boolean bool1;
    boolean bool2;
    if (str != null)
    {
      str = str.trim();
      bool1 = this.eqqDetail.hasIvrAbility();
      bool2 = Pattern.compile("[\\d-]+?").matcher(str).matches();
      if (!bool2) {
        break label166;
      }
      ((TextView)localView.findViewById(2131365294)).setText(str);
    }
    for (;;)
    {
      localView.setOnClickListener(new EqqAccountDetailActivityImpl.9(this, bool2, str, bool1, paramPaConfigInfo));
      ReportController.b(this.app, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.uin, "", "", "");
      return localView;
      return null;
      label166:
      if (!bool1) {
        break;
      }
      ((TextView)localView.findViewById(2131365294)).setText(2131720000);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "buildPhoneItem no phone ability and no ivr ability");
    }
    return null;
  }
  
  protected View buildRichTextItemForEqq(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).equals(HardCodeUtil.a(2131704205)))) {
      return null;
    }
    localObject = super.getLayoutInflater().inflate(2131558818, null);
    ((ImageView)((View)localObject).findViewById(2131369351)).setImageResource(2130839011);
    ((TextView)((View)localObject).findViewById(2131365294)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString + " " + paramPaConfigInfo.b);
    return localObject;
  }
  
  View buildStateChangeItem(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    return null;
  }
  
  void changeMsgState(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    int i = paramPaConfigInfo.e;
    String str1;
    String str2;
    if (paramInt == 1)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A2B", "0X8005A2B", 0, 0, "", "", "", "", false);
      i = 1;
      delayShowLoading(2131695271);
      this.app.removeObserver(this.newStatusObserver);
      this.newStatusObserver = new NewPublicAccountObserver(new EqqAccountDetailActivityImpl.17(this, paramPaConfigInfo, i, paramInt));
      this.app.addObserver(this.newStatusObserver);
      paramPaConfigInfo = this.app;
      str1 = this.eqqDetail.uin;
      str2 = this.eqqDetail.name;
      if (paramInt != 1) {
        break label204;
      }
    }
    label204:
    for (paramInt = 1;; paramInt = 0)
    {
      PublicAccountStateReporter.a(paramPaConfigInfo, str1, str2, paramInt);
      this.waitingCount += 1;
      return;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A2A", "0X8005A2A", 0, 0, "", "", "", "", false);
      i = 3;
      break;
    }
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.qidianManager = ((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    if ((this.uin != null) && (this.qidianManager.c(this.uin, false)))
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
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "follow uin=" + this.uin);
    }
    this.needUpdateView = true;
    this.followBtn.postDelayed(new EqqAccountDetailActivityImpl.11(this), 3000L);
    delayShowLoading(2131695198);
    ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.uin);
    this.followIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
    this.followIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.mSendMessage)) && (this.mIsReportMessage)) {
      localFollowRequest.ext.set(this.mSendMessage);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.uin));
    localFollowRequest.account_type.set(getAccountType());
    this.followIntent.putExtra("data", localFollowRequest.toByteArray());
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
    String str = "";
    if (this.eqqDetail != null) {
      str = this.eqqDetail.name;
    }
    return str;
  }
  
  protected int getAccountType()
  {
    return 2;
  }
  
  protected int getCertifiedGrade()
  {
    if (this.eqqDetail != null) {
      return this.eqqDetail.certifiedGrade;
    }
    return 0;
  }
  
  protected ShareActionSheet.Detail getShareDetail()
  {
    return new ShareActionSheet.Detail(this.eqqDetail.uin, this.eqqDetail.name, this.eqqDetail.summary);
  }
  
  public String getShareUrl()
  {
    if (this.shareUrl == null) {
      this.shareUrl = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.uin + "&account_flag=" + this.eqqDetail.eqqAccountFlag + "&jumptype=1&card_type=crm");
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
    int i = -1;
    if (this.eqqDetail != null) {
      i = this.eqqDetail.followType;
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
    return (this.eqqDetail != null) && (this.eqqDetail.hasIvrAbility());
  }
  
  protected boolean needShowUnFollowBtnInActionSheet()
  {
    return (this.eqqDetail != null) && (this.eqqDetail.followType == 1);
  }
  
  void notifyUpdateDetailInfo(EqqDetail paramEqqDetail)
  {
    this.publicAccountHandler.a();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.stateIntent != null)
    {
      this.stateIntent.setObserver(null);
      this.stateIntent = null;
    }
    if (this.statusIntent != null)
    {
      this.statusIntent.setObserver(null);
      this.statusIntent = null;
    }
  }
  
  protected void open(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
  {
    this.mIntent.getBooleanExtra("need_finish", false);
    if (this.eqqDetail == null) {
      return;
    }
    if (this.eqqDetail.followType == 1)
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
      this.eqqDetail.mIsSyncLbs = true;
      this.eqqDetail.mIsAgreeSyncLbs = paramBoolean;
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
    if ((this.eqqDetail != null) && (this.eqqDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, paramEqqDetail.name);
      }
      this.eqqDetail.clone(paramEqqDetail);
      if (!((EntityManager)localObject).update(this.eqqDetail)) {
        ((EntityManager)localObject).drop(EqqDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
      {
        localObject = (PublicAccountDataManager)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        if (localObject != null) {
          ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "saveEqqDetailToDBAndCache exit");
      }
      return;
      this.eqqDetail = paramEqqDetail;
      ((EntityManager)localObject).persist(paramEqqDetail);
    }
  }
  
  void sendCrmDetailInfoRequest()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendDetailInfoRequest");
    }
    if (this.detailIntent != null) {
      this.detailIntent.setObserver(null);
    }
    this.detailIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
    this.detailIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
    localGetEqqDetailInfoRequest.version.set(2);
    if (this.eqqDetail != null) {
      localGetEqqDetailInfoRequest.seqno.set(this.eqqDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.uin));
        label151:
        this.detailIntent.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        this.detailObserver = new EqqAccountDetailActivityImpl.2(this);
        this.detailIntent.setObserver(this.detailObserver);
        this.app.startServlet(this.detailIntent);
        this.waitingCount += 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "sendCrmDetailInfoRequest exit");
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
  
  protected void sendDetailInfoRequest()
  {
    sendCrmDetailInfoRequest();
  }
  
  protected void setAccountData()
  {
    if (this.eqqDetail != null) {
      this.eqqDetail.accountData = this.gEqqData.toByteArray();
    }
  }
  
  protected void setIsConfirmed(boolean paramBoolean)
  {
    if (this.eqqDetail != null) {
      this.eqqDetail.isConfirmed = paramBoolean;
    }
  }
  
  protected void setShowMsgFlag(int paramInt)
  {
    if (this.eqqDetail != null) {
      this.eqqDetail.mShowMsgFlag = paramInt;
    }
  }
  
  void setStatusText(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    int i = paramPaConfigInfo.d;
    this.fromUser = false;
    if ((i == 1) || (i == 2))
    {
      this.statusTextView.setText(2131693668);
      return;
    }
    this.statusTextView.setText(2131693669);
  }
  
  protected void share()
  {
    super.share();
    if ((TextUtils.isEmpty(this.uin)) || (this.eqqDetail == null)) {
      return;
    }
    if (this.mShareActionSheet == null) {
      this.mShareActionSheet = new ShareActionSheet(this.app, this, getShareDetail(), getAccountType(), getShareUrl());
    }
    this.mShareActionSheet.a();
    PublicAccountHandler.a(this.app, this.uin, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  void showCallConfirm(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1)) {
      showPhoneActionSheet(paramString);
    }
    do
    {
      do
      {
        return;
        if (paramBoolean1)
        {
          showPhoneConfirm(paramString);
          return;
        }
        if (!paramBoolean2) {
          break;
        }
      } while (this.eqqDetail == null);
      CrmUtils.a(this.app, this, this.eqqDetail.name, this.uin, "IvrEnterpriseDetailEngineFalse");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "showCallConfirm no phone ability and no ivr ability");
  }
  
  void showMessageSettingActionSheet(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    int i = 1;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.addRadioButton(2131693668, 5, false);
    localActionSheet.addRadioButton(2131693669, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localActionSheet.setRadioButtonChecked(0);
    }
    for (;;)
    {
      if ((paramInt == 1) || (paramInt == 2)) {
        i = 0;
      }
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnDismissListener(new EqqAccountDetailActivityImpl.15(this));
      localActionSheet.setOnButtonClickListener(new EqqAccountDetailActivityImpl.16(this, paramPaConfigInfo, localActionSheet, i));
      if (!localActionSheet.isShowing())
      {
        this.messageSettingActionSheetHasClick = false;
        localActionSheet.show();
      }
      return;
      localActionSheet.setRadioButtonChecked(1);
    }
  }
  
  void showPhoneActionSheet(String paramString)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.addButton(2131720000);
    localActionSheet.addButton(getString(2131691678) + paramString);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new EqqAccountDetailActivityImpl.13(this, localActionSheet, paramString));
    localActionSheet.show();
  }
  
  void updateBottomContainer()
  {
    if (this.eqqDetail == null) {}
    label145:
    label164:
    for (;;)
    {
      return;
      if (this.eqqDetail.followType == 1)
      {
        this.sendMsgBtn.setVisibility(0);
        this.followBtn.setVisibility(8);
        this.bottomContainer.setVisibility(0);
        if (!needShowQQCall()) {
          break label145;
        }
        this.btnsDivider1.setVisibility(0);
        this.callBtn.setVisibility(0);
        this.callBtn.setOnClickListener(this);
      }
      for (;;)
      {
        if ((this.sendMsgBtn.getVisibility() != 8) || (this.followBtn.getVisibility() != 8)) {
          break label164;
        }
        this.bottomContainer.setVisibility(8);
        return;
        this.followBtn.setVisibility(0);
        this.followBtn.setOnClickListener(this);
        this.sendMsgBtn.setVisibility(8);
        this.bottomContainer.setVisibility(0);
        break;
        this.btnsDivider1.setVisibility(8);
        this.callBtn.setVisibility(8);
      }
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
    if ((this.mAccountDetailAdapter == null) || (this.mAccountDetailListView.getAdapter() == null) || ((this.eqqDetail != null) && (this.mAccountDetailAdapter.a() == null)))
    {
      if (this.mAccountDetailListView.getAdapter() != null)
      {
        ((AccountDetailBaseAdapter)this.mAccountDetailListView.getAdapter()).a();
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
      return;
    }
    if (this.eqqDetail != null) {
      this.mAccountDetailAdapter.a(this.eqqDetail);
    }
    this.mAccountDetailAdapter.c(getFace());
    this.mAccountDetailAdapter.b(this.groupListContainer);
    this.mAccountDetailAdapter.a(getContainerListviewHeight());
    this.mAccountDetailAdapter.notifyDataSetChanged();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl
 * JD-Core Version:    0.7.0.1
 */