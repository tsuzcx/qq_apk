package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentFactory;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.concurrent.ConcurrentHashMap;
import mov;

public class ReadinjoyTabbar
  extends BaseTabbar
{
  private ReadInJoyNewFeedsActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity;
  protected KandianMergeManager a;
  protected QQAppInterface a;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private BubblePopupWindow b;
  
  public ReadinjoyTabbar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadinjoyTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setUnselectColor(-8947849);
    setTabTextSize(17);
    setBackgroundDrawable(new ColorDrawable(0));
    setTabHeight(AIOUtils.a(65.0F, getResources()));
    setUnderLineHeight(AIOUtils.a(6.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    setSelectColor(((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).a(8).a());
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "dimissVideoBubbleTips()");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "dimissSelfBubbleTips()");
    }
    if ((this.b != null) && (this.b.b())) {}
    try
    {
      this.b.a();
      this.b = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public ReadInJoyBaseFragment a(ReadinjoyTabbar.Tab paramTab)
  {
    if (paramTab == null) {
      return null;
    }
    return paramTab.a();
  }
  
  public BaseTabbar.TabHolder a(int paramInt, String paramString)
  {
    paramString = super.a(paramInt, paramString);
    ReadinjoyTabbar.Tab localTab = new ReadinjoyTabbar.Tab();
    localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = null;
    localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localTab);
    return paramString;
  }
  
  public ReadinjoyTabbar.Tab a(int paramInt)
  {
    return (ReadinjoyTabbar.Tab)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, View paramView)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 3: 
      c();
      return;
    }
    b();
  }
  
  public int b()
  {
    if ((this.b != null) && (this.b.b())) {
      return 3;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return 1;
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    ReadinjoyTabbar.Tab localTab = (ReadinjoyTabbar.Tab)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder.a.post(new mov(this, paramInt, localTab));
  }
  
  public void setCurrentActivity(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity = paramReadInJoyNewFeedsActivity;
  }
  
  public void setSelection(int paramInt1, int paramInt2, FragmentManager paramFragmentManager, Intent paramIntent, int paramInt3, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      ReadinjoyTabbar.Tab localTab;
      try
      {
        paramIntent = a(paramInt2);
        localTab = a(paramInt1);
        if ((paramInt1 == paramInt2) && (a(localTab) != null) && (paramInt3 == 256))
        {
          localTab.a().e();
          setTabState(paramInt1, false);
          return;
        }
        if (paramInt3 != 256) {
          setSelectedTab(paramInt1, true, true);
        }
        paramFragmentManager = paramFragmentManager.beginTransaction();
        if (paramInt1 < paramInt2)
        {
          paramFragmentManager.setCustomAnimations(2131034391, 2131034394);
          if ((paramIntent != null) && (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) && (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a()))
          {
            paramFragmentManager.hide(paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
            paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.d();
          }
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a() != localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment)) {
            paramFragmentManager.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a());
          }
          if (localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null)
          {
            localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ReadInJoyFragmentFactory.a(paramInt1);
            if (localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null) {
              continue;
            }
          }
          if (!localTab.jdField_a_of_type_Boolean) {
            paramFragmentManager.add(2131363974, localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment, String.valueOf(paramInt1));
          }
          paramFragmentManager.show(localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
          paramFragmentManager.commitAllowingStateLoss();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a(localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
          if (paramInt3 == 258) {
            localTab.a().a(paramBundle);
          }
          if (paramInt3 != 257) {
            break label442;
          }
          paramFragmentManager = localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
          if (localTab.jdField_a_of_type_Boolean) {
            break label480;
          }
          paramFragmentManager.a(bool1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, paramBundle);
          if (!localTab.jdField_a_of_type_Boolean) {
            localTab.jdField_a_of_type_Boolean = true;
          }
          a(paramInt2, paramInt1);
          if (((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).a() != 0) {
            continue;
          }
          if (!paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder.a()) {
            paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder.a(true, false);
          }
          if (!localTab.b) {
            continue;
          }
          localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder.a(false, false);
          continue;
        }
        if (paramInt1 <= paramInt2) {
          continue;
        }
      }
      finally {}
      if ((paramBundle != null) && (paramBundle.getBoolean("READINJOY_VIDEO_FORCE_INSERT_SET_SELECTION", false)))
      {
        paramFragmentManager.setCustomAnimations(2131034397, 2131034398);
      }
      else
      {
        paramFragmentManager.setCustomAnimations(2131034393, 2131034395);
        continue;
        label442:
        paramFragmentManager = localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
        if (!localTab.jdField_a_of_type_Boolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramFragmentManager.a(bool1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, null);
          break;
        }
        label480:
        bool1 = false;
      }
    }
  }
  
  public void setTabState(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260);
    if ((paramBoolean) && (((ReadInJoySkinManager)localObject).a() != 0)) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("TabBarView", 4, "setTabState type:" + paramInt + " isRefreshState:" + paramBoolean);
    }
    localObject = a(paramInt);
    ((ReadinjoyTabbar.Tab)localObject).b = paramBoolean;
    BaseTabbar.TabHolder localTabHolder = ((ReadinjoyTabbar.Tab)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder;
    if (!((ReadinjoyTabbar.Tab)localObject).b) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTabHolder.a(paramBoolean, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar
 * JD-Core Version:    0.7.0.1
 */