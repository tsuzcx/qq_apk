package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySelfInnerListViewAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.HorizontalListView;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.ReadInJoyHelper.DefaultSetting;
import cooperation.readinjoy.ReadInJoyHelper.OperatingSetting;
import java.util.List;
import lgo;
import lgp;
import lgq;
import lgr;
import lgs;
import lgt;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoySelfActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, KandianMergeManager.OnTabRedNumsChangeListenner
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public KandianMergeManager a;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lgt(this);
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private ReadInjoySelfInnerListViewAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter;
  public QQAppInterface a;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View c;
  
  private void a()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {}
    label106:
    label502:
    do
    {
      return;
      ReadInJoyWebDataManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      int i;
      Object localObject3;
      Object localObject4;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
      {
        localObject1 = ReadInJoyWebDataManager.a();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c() <= 0)
        {
          i = 0;
          ((ReadInJoyWebDataManager)localObject1).a((String)localObject2, i);
        }
      }
      else
      {
        setContentView(2130969643);
        localObject2 = ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label390;
        }
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label474;
        }
        localObject3 = (ReadInJoyHelper.DefaultSetting)((List)localObject2).get(i);
        if (((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_Int != 10) {
          break label216;
        }
        localObject4 = this.mContentView.findViewById(2131367284);
        if (localObject4 != null)
        {
          ((View)localObject4).setOnClickListener(this);
          if (((ReadInJoyHelper.DefaultSetting)localObject3).b != 0) {
            break label206;
          }
          ((TextView)this.mContentView.findViewById(2131367285)).setText(((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString);
          ((View)localObject4).setVisibility(0);
        }
      }
      for (;;)
      {
        i += 1;
        break label106;
        i = 1;
        break;
        ((View)localObject4).setVisibility(8);
        continue;
        if (((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_Int == 11) {
          a(2131367286, ((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString, 2, ((ReadInJoyHelper.DefaultSetting)localObject3).b);
        } else if (((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_Int == 12) {
          a(2131367287, ((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString, 2, ((ReadInJoyHelper.DefaultSetting)localObject3).b);
        } else if (((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_Int == 13)
        {
          if (localObject1 != null) {
            a(2131367288, ((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString, 2, ((ReadInJoyHelper.DefaultSetting)localObject3).b);
          } else {
            a(2131367288, ((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString, 3, ((ReadInJoyHelper.DefaultSetting)localObject3).b);
          }
        }
        else if (((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_Int == 14) {
          a(2131367292, ((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString, 2, ((ReadInJoyHelper.DefaultSetting)localObject3).b);
        } else if (((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_Int == 15) {
          a(2131367293, ((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString, 2, ((ReadInJoyHelper.DefaultSetting)localObject3).b);
        }
      }
      Object localObject2 = this.mContentView.findViewById(2131367284);
      if (localObject2 != null)
      {
        ((View)localObject2).setVisibility(0);
        ((View)localObject2).setOnClickListener(this);
      }
      a(2131367288, "最近浏览", 2, 0);
      a(2131367287, "我的收藏", 2, 0);
      if (localObject1 != null)
      {
        a(2131367286, "我的话题", 2, 0);
        a(2131367292, "贴纸设置", 2, 0);
        if (!ReadInJoyConstants.jdField_a_of_type_Boolean) {
          break label598;
        }
        a(2131367293, "设置", 2, 0);
        localObject2 = (LinearLayout)this.mContentView.findViewById(2131367283);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label643;
        }
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label643;
        }
        localObject3 = (ReadInJoyHelper.OperatingSetting)((List)localObject1).get(i);
        localObject4 = new ReadinjoyFormSimpleItem(getActivity());
        if ((localObject3 == null) || (i == ((List)localObject1).size() - 1)) {
          break label611;
        }
        a(2, (ReadinjoyFormSimpleItem)localObject4, ((ReadInJoyHelper.OperatingSetting)localObject3).jdField_a_of_type_JavaLangString, ((ReadInJoyHelper.OperatingSetting)localObject3).b, true);
        ((LinearLayout)localObject2).addView((View)localObject4);
      }
      for (;;)
      {
        i += 1;
        break label502;
        a(2131367286, "我的话题", 3, 0);
        break;
        a(2131367293, "设置", 3, 0);
        break label474;
        if (localObject3 != null)
        {
          a(3, (ReadinjoyFormSimpleItem)localObject4, ((ReadInJoyHelper.OperatingSetting)localObject3).jdField_a_of_type_JavaLangString, ((ReadInJoyHelper.OperatingSetting)localObject3).b, true);
          ((LinearLayout)localObject2).addView((View)localObject4);
        }
      }
      setTitle("我的");
      this.leftView.setText("返回");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.mContentView.findViewById(2131362724));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.mContentView.findViewById(2131365455));
      this.mContentView.findViewById(2131367270).setOnClickListener(this);
      this.mContentView.findViewById(2131367289).setVisibility(8);
      if (!ReadInJoyConstants.jdField_a_of_type_Boolean) {
        break;
      }
      a(2131367294, "我要反馈", 3, 0);
      localObject1 = this.mContentView.findViewById(2131367294);
    } while (localObject1 == null);
    label206:
    label216:
    label474:
    label611:
    ((TextView)((View)localObject1).findViewById(2131371304)).setText(ReadInJoyConstants.j);
    label390:
    label598:
    this.mContentView.findViewById(2131367293).setBackgroundResource(2130838639);
    label643:
    c();
    Object localObject1 = this.mContentView.findViewById(2131362696);
    if (localObject1 != null)
    {
      ((View)localObject1).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131367276));
    }
    localObject1 = this.mContentView.findViewById(2131367277);
    if (localObject1 != null)
    {
      ((View)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131367279));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131367280));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.mContentView.findViewById(2131367281));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter = new ReadInjoySelfInnerListViewAdapter(this, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter);
    }
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131367272);
    this.c = this.mContentView.findViewById(2131367282);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131367271);
    f();
    ((BounceScrollView)this.mContentView.findViewById(2131362846)).setDrawFinishedListener(new lgo(this));
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (this.mContentView == null) {}
    ReadinjoyFormSimpleItem localReadinjoyFormSimpleItem;
    do
    {
      return;
      localReadinjoyFormSimpleItem = (ReadinjoyFormSimpleItem)this.mContentView.findViewById(paramInt1);
    } while (localReadinjoyFormSimpleItem == null);
    a(paramInt2, localReadinjoyFormSimpleItem, paramString, null, true);
    if ((paramInt3 == 0) && (!TextUtils.isEmpty(paramString))) {
      localReadinjoyFormSimpleItem.setVisibility(0);
    }
    for (;;)
    {
      localReadinjoyFormSimpleItem.setOnClickListener(this);
      return;
      localReadinjoyFormSimpleItem.setVisibility(8);
    }
  }
  
  private void a(List paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if (paramList.size() == 2) {}
    for (int i = AIOUtils.a(11.0F, getResources());; i = AIOUtils.a(7.5F, getResources()))
    {
      localHorizontalListView.setDividerWidth(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter.a(paramList);
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -AIOUtils.a(70.0F, getResources()), 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      }
      this.c.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(300L);
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillEnabled(true);
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      return;
    }
  }
  
  private void c()
  {
    int i = 3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    if (this.mContentView == null) {
      return;
    }
    if (this.jdField_a_of_type_Int > 0) {}
    for (;;)
    {
      CustomWidgetUtil.a((DragTextView)this.mContentView.findViewById(2131366830), i, this.jdField_a_of_type_Int, 2130846137, 99, null);
      return;
      i = 0;
    }
  }
  
  private void d()
  {
    ReadInJoyLogicEngine.a().d(this.app.c());
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -AIOUtils.a(70.0F, getResources()));
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new lgr(this));
    }
    this.c.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    if (this.jdField_b_of_type_AndroidViewAnimationRotateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillEnabled(true);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationRotateAnimation);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    }
    int i;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      i = ReadInJoyHelper.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(i));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      i = ReadInJoyHelper.B(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(i));
    }
    boolean bool;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      List localList = ReadInJoyHelper.a(getAppRuntime());
      if ((localList != null) && (localList.size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter.a(ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      bool = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (!bool) {
          break label224;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      if ((!bool) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        if (ReadInJoyHelper.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
          break label236;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label224:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label236:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(int paramInt, ReadinjoyFormSimpleItem paramReadinjoyFormSimpleItem, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReadinjoyFormSimpleItem.setOnClickListener(new lgp(this, paramString2, paramString1));
      paramReadinjoyFormSimpleItem.a(true);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      paramReadinjoyFormSimpleItem.getBackground().setAlpha(255);
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      paramReadinjoyFormSimpleItem.setLeftText(paramString2);
      paramReadinjoyFormSimpleItem.setLeftTextColor(0);
      paramReadinjoyFormSimpleItem = paramReadinjoyFormSimpleItem.a();
      paramReadinjoyFormSimpleItem.setTextColor(getResources().getColor(2131492971));
      paramReadinjoyFormSimpleItem.setEditableFactory(QQTextBuilder.a);
      return;
      paramReadinjoyFormSimpleItem.setTag(null);
      paramReadinjoyFormSimpleItem.setOnClickListener(null);
      paramReadinjoyFormSimpleItem.a(false);
      break;
      paramReadinjoyFormSimpleItem.setBgType(0);
      continue;
      paramReadinjoyFormSimpleItem.setBgType(1);
      continue;
      paramReadinjoyFormSimpleItem.setBgType(2);
      continue;
      paramReadinjoyFormSimpleItem.setBgType(3);
      continue;
      paramReadinjoyFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
    }
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new lgs(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    a();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationRotateAnimation != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    c();
    d();
    if (!this.jdField_a_of_type_Boolean) {
      PublicTracker.a("self_tab_cost", null);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    case 2131367295: 
    default: 
    case 2131367284: 
    case 2131367270: 
    case 2131367293: 
    case 2131367292: 
    case 2131367294: 
    case 2131362696: 
      do
      {
        return;
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_a_of_type_Int), false);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
        }
        i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.f() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c() > 0)
        {
          paramView = ReadInJoyConstants.g + i;
          ReadInJoyUtils.a(this.mContentView.getContext(), paramView);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.self.ReadInJoySelfActivity", 2, "person message box url: " + paramView);
          }
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c()), false);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.l();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
          return;
          paramView = ReadInJoyConstants.c + i;
          ReadInJoyUtils.a(this.mContentView.getContext(), i);
        }
        paramView = ReadInJoyUtils.a();
        if (TextUtils.isEmpty(paramView)) {
          QLog.e("Q.readinjoy.self.ReadInJoySelfActivity", 2, "click personal page , but uin is empty !");
        }
        for (;;)
        {
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
          return;
          paramView = ReadInJoyConstants.f + Base64Util.encodeToString(paramView.getBytes(), 2);
          ReadInJoyUtils.a(this.mContentView.getContext(), paramView);
        }
        ThreadManager.postImmediately(new lgq(this), null, true);
        startActivity(new Intent(this.mContentView.getContext(), ReadInJoySettingActivity.class));
        ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", ReadInJoyUtils.c());
        return;
        ReadInJoyActivityHelper.b(this.mContentView.getContext());
        return;
        ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.k);
        return;
        ReadInJoyUtils.b(this.mContentView.getContext(), ReadInJoyConstants.p);
        paramView = new ReadInJoyUtils.ReportR5Builder().a().a();
      } while (TextUtils.isEmpty(paramView));
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + ReadInJoyHelper.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", paramView, false);
      return;
    case 2131367277: 
      paramView = ReadInJoyHelper.a(getAppRuntime());
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0)
      {
        e();
        i = 0;
      }
      while (i > 0)
      {
        paramView = new ReadInJoyUtils.ReportR5Builder().a().a();
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + ReadInJoyHelper.B(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + i, "", paramView, false);
        return;
        if ((paramView != null) && (paramView.size() > 1))
        {
          a(paramView);
          i = 1;
        }
        else
        {
          ReadInJoyUtils.b(this.mContentView.getContext(), ReadInJoyConstants.q);
          i = 2;
        }
      }
    case 2131367288: 
      ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.l);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    case 2131367286: 
      ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.m);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    }
    ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.n);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", ReadInJoyUtils.a(this.mContentView.getContext(), "7.6.8".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity
 * JD-Core Version:    0.7.0.1
 */