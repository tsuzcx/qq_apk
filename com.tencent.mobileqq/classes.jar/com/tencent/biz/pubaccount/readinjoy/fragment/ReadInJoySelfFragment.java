package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySelfInnerListViewAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.Switch;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.ReadInJoyHelper.DefaultSetting;
import cooperation.readinjoy.ReadInJoyHelper.OperatingSetting;
import java.util.List;
import lqj;
import lqk;
import lql;
import lqm;
import lqn;
import lqo;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, KandianMergeManager.OnTabRedNumsChangeListenner
{
  private int jdField_a_of_type_Int;
  public View a;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private ReadInjoySelfInnerListViewAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianMergeManager jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private View d;
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    ReadinjoyFormSimpleItem localReadinjoyFormSimpleItem;
    do
    {
      return;
      localReadinjoyFormSimpleItem = (ReadinjoyFormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(paramInt1);
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
      this.d.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
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
  
  private void h()
  {
    Object localObject2 = ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    Object localObject3;
    Object localObject4;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      i = 0;
      if (i < ((List)localObject2).size())
      {
        localObject3 = (ReadInJoyHelper.DefaultSetting)((List)localObject2).get(i);
        if (((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_Int == 10)
        {
          localObject4 = this.jdField_a_of_type_AndroidViewView.findViewById(2131367284);
          if (localObject4 != null)
          {
            ((View)localObject4).setOnClickListener(this);
            if (((ReadInJoyHelper.DefaultSetting)localObject3).b != 0) {
              break label126;
            }
            ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367285)).setText(((ReadInJoyHelper.DefaultSetting)localObject3).jdField_a_of_type_JavaLangString);
            ((View)localObject4).setVisibility(0);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label126:
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
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131367284);
      if (localObject2 != null)
      {
        ((View)localObject2).setVisibility(0);
        ((View)localObject2).setOnClickListener(this);
      }
      a(2131367288, "最近浏览", 2, 0);
      a(2131367287, "我的收藏", 2, 0);
      if (localObject1 == null) {
        break label499;
      }
      a(2131367286, "我的话题", 2, 0);
      a(2131367293, "设置", 2, 0);
      a(2131367292, "贴纸设置", 2, 0);
    }
    localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367283);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      i = 0;
      label416:
      if (i < ((List)localObject1).size())
      {
        localObject3 = (ReadInJoyHelper.OperatingSetting)((List)localObject1).get(i);
        localObject4 = new ReadinjoyFormSimpleItem(getActivity());
        if ((localObject3 != null) && (i != ((List)localObject1).size() - 1))
        {
          a(2, (ReadinjoyFormSimpleItem)localObject4, ((ReadInJoyHelper.OperatingSetting)localObject3).jdField_a_of_type_JavaLangString, ((ReadInJoyHelper.OperatingSetting)localObject3).jdField_b_of_type_JavaLangString, true);
          ((LinearLayout)localObject2).addView((View)localObject4);
        }
        for (;;)
        {
          i += 1;
          break label416;
          label499:
          a(2131367286, "我的话题", 3, 0);
          break;
          if (localObject3 != null)
          {
            a(3, (ReadinjoyFormSimpleItem)localObject4, ((ReadInJoyHelper.OperatingSetting)localObject3).jdField_a_of_type_JavaLangString, ((ReadInJoyHelper.OperatingSetting)localObject3).jdField_b_of_type_JavaLangString, true);
            ((LinearLayout)localObject2).addView((View)localObject4);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362724));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365455));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131367270).setOnClickListener(this);
    localObject1 = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131367291);
    ((Switch)localObject1).setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c());
    ((Switch)localObject1).setTrackResource(2130840565);
    ((Switch)localObject1).setThumbResource(2130840564);
    ((Switch)localObject1).setOnClickListener(this);
    ((Switch)localObject1).setOnCheckedChangeListener(new lqj(this));
    if (ReadInJoyConstants.a)
    {
      a(2131367294, "我要反馈", 3, 0);
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131367294);
      if (localObject1 == null) {
        return;
      }
      ((TextView)((View)localObject1).findViewById(2131371304)).setText(ReadInJoyConstants.j);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367293).setBackgroundResource(2130838639);
    }
    i();
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131362696);
    if (localObject1 != null)
    {
      ((View)localObject1).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367276));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        i = ReadInJoyHelper.A(getActivity().getAppRuntime());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + i);
        }
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131367277);
    if (localObject1 != null)
    {
      ((View)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367279));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367280));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367281));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter = new ReadInjoySelfInnerListViewAdapter(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter);
    }
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131367282);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367272);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367271);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (!ReadInJoyHelper.a(getActivity().getAppRuntime()).booleanValue()) {
        break label1021;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362846));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new lqk(this));
      n();
      return;
      label1021:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void i()
  {
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    if (this.jdField_a_of_type_Int > 0) {}
    for (;;)
    {
      CustomWidgetUtil.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366830), i, this.jdField_a_of_type_Int, 2130846137, 99, null);
      return;
      i = 0;
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -AIOUtils.a(70.0F, getResources()));
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new lqn(this));
    }
    this.d.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    if (this.jdField_b_of_type_AndroidViewAnimationRotateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillEnabled(true);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationRotateAnimation);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ReadInJoyWebDataManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    ReadInJoyWebDataManager localReadInJoyWebDataManager = ReadInJoyWebDataManager.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c() <= 0) {}
    for (int i = 0;; i = 1)
    {
      localReadInJoyWebDataManager.a(str, i);
      return;
    }
  }
  
  private void m()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.invalidate();
    }
  }
  
  private void n()
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
      List localList = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!bool) {
          break label224;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      if ((!bool) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        if (ReadInJoyHelper.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
          break label236;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label224:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    label236:
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "updateFollowAndFansCount followCnt:" + paramInt1 + ", fansCnt:" + paramInt2);
    }
    n();
  }
  
  protected void a(int paramInt, ReadinjoyFormSimpleItem paramReadinjoyFormSimpleItem, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReadinjoyFormSimpleItem.setOnClickListener(new lql(this, paramString2, paramString1));
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
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    i();
    k();
    l();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "notifyShowSelf()");
    }
    ReadInJoyLogicEngine.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    m();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new lqo(this));
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
  }
  
  public void e() {}
  
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
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
        }
        i = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.f() - this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c() > 0)
        {
          paramView = ReadInJoyConstants.g + i;
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.self.SelfFragment", 2, "person message box url: " + paramView);
          }
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c()), false);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.l();
          if (ReadInJoyHelper.f()) {
            break;
          }
          ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).k();
          return;
          paramView = ReadInJoyConstants.jdField_c_of_type_JavaLangString + i;
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), i);
        }
        paramView = ReadInJoyUtils.a();
        if (TextUtils.isEmpty(paramView)) {
          QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
        }
        for (;;)
        {
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
          return;
          paramView = ReadInJoyConstants.f + Base64Util.encodeToString(paramView.getBytes(), 2);
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView);
        }
        ThreadManager.postImmediately(new lqm(this), null, true);
        startActivity(new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoySettingActivity.class));
        ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", ReadInJoyUtils.c());
        return;
        ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidViewView.getContext());
        return;
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.k);
        return;
        ReadInJoyUtils.b(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.p);
        paramView = new ReadInJoyUtils.ReportR5Builder().a().a();
      } while (TextUtils.isEmpty(paramView));
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + ReadInJoyHelper.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", paramView, false);
      return;
    case 2131367277: 
      paramView = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0)
      {
        j();
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
          ReadInJoyUtils.b(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.q);
          i = 2;
        }
      }
    case 2131367288: 
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.l);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    case 2131367286: 
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.m);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    }
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.n);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), "7.6.8".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969643, paramViewGroup, false);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    h();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    ReadInJoyLogicEngine.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment
 * JD-Core Version:    0.7.0.1
 */