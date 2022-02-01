package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentFactory;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.concurrent.ConcurrentHashMap;

public class ReadinjoyTabbar
  extends BaseTabbar
{
  private ReadInJoyNewFeedsActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity = null;
  protected KandianMergeManager a;
  protected QQAppInterface a;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  private ConcurrentHashMap<Integer, ReadinjoyTabbar.Tab> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private BubblePopupWindow b = null;
  
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
  
  public static BubblePopupWindow a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null)) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    paramView1.getLocationOnScreen(arrayOfInt);
    return a(paramView1, paramView2, arrayOfInt[0] + paramView1.getMeasuredWidth() / 2, arrayOfInt[1]);
  }
  
  private static BubblePopupWindow a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    try
    {
      BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
      localBubblePopupWindow.a(paramView2);
      localBubblePopupWindow.a(new ColorDrawable(0));
      localBubblePopupWindow.b(false);
      localBubblePopupWindow.a(false);
      localBubblePopupWindow.c(1);
      localBubblePopupWindow.b(2);
      localBubblePopupWindow.b(paramView1, paramInt1, paramInt2);
      return localBubblePopupWindow;
    }
    catch (Exception paramView1)
    {
      QLog.d("TabBarView", 1, "showAtLocation", paramView1);
    }
    return null;
  }
  
  private void a()
  {
    setUnselectColor(-8947849);
    setTabTextSize(17);
    setBackgroundDrawable(new ColorDrawable(0));
    setTabHeight(AIOUtils.a(65.0F, getResources()));
    setUnderLineHeight(AIOUtils.a(6.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    setSelectColor(((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(8).a());
  }
  
  private void a(int paramInt, Object paramObject, View paramView)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 3: 
      b(paramView);
      return;
    }
    a(paramView);
  }
  
  private void a(View paramView)
  {
    if ((this.b != null) && (this.b.b())) {}
    while ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "showVideoBubbleTips()");
    }
    Context localContext = paramView.getContext();
    RelativeLayout localRelativeLayout = new RelativeLayout(localContext);
    TextView localTextView = new TextView(localContext);
    localTextView.setText(HardCodeUtil.a(2131712728));
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 16.0F);
    localTextView.setGravity(17);
    int i = DisplayUtil.a(localContext, 10.0F);
    localTextView.setPadding(i, 0, i, 0);
    localRelativeLayout.addView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = a(paramView, localRelativeLayout);
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
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {}
    Context localContext;
    RelativeLayout localRelativeLayout;
    TextView localTextView;
    int i;
    long l;
    do
    {
      do
      {
        return;
      } while ((this.b != null) && (this.b.b()));
      if (QLog.isColorLevel()) {
        QLog.d("TabBarView", 2, "showSelfBubbleTips()");
      }
      localContext = paramView.getContext();
      localRelativeLayout = new RelativeLayout(localContext);
      localTextView = new TextView(localContext);
      localTextView.setId(2131376551);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(1, 16.0F);
      localTextView.setGravity(17);
      i = DisplayUtil.a(localContext, 10.0F);
      localTextView.setPadding(i, 0, i, 0);
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    } while (i <= 0);
    localTextView.setText(" " + i + HardCodeUtil.a(2131712833));
    Object localObject = ImageUtil.d();
    if (l != -1L) {}
    for (localObject = FaceDrawable.getFaceDrawable((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1, Long.toString(l), 3, (Drawable)localObject, (Drawable)localObject);; localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.getApplicationContext().getResources().getDrawable(2130843201))
    {
      ((Drawable)localObject).setBounds(0, 0, DisplayUtil.a(localContext, 25.0F), DisplayUtil.a(localContext, 25.0F));
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localRelativeLayout.addView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      localRelativeLayout.setOnClickListener(new ReadinjoyTabbar.3(this));
      this.b = a(paramView, localRelativeLayout);
      if (this.b == null) {
        break;
      }
      this.b.b(true);
      this.b.c(true);
      this.b.b();
      return;
    }
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
    localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder.a.post(new ReadinjoyTabbar.2(this, paramInt, localTab));
  }
  
  public void setCurrentActivity(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity = paramReadInJoyNewFeedsActivity;
  }
  
  public void setSelection(int paramInt1, int paramInt2, FragmentManager paramFragmentManager, Intent paramIntent, int paramInt3, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    ReadinjoyTabbar.Tab localTab;
    for (;;)
    {
      try
      {
        paramIntent = a(paramInt2);
        localTab = a(paramInt1);
        if ((paramInt1 == paramInt2) && (a(localTab) != null) && (paramInt3 == 256))
        {
          localTab.a().f();
          setTabState(paramInt1, false);
          return;
        }
        if (paramInt3 != 256) {
          setSelectedTab(paramInt1, true, true);
        }
        paramFragmentManager = paramFragmentManager.beginTransaction();
        if (paramInt1 < paramInt2)
        {
          paramFragmentManager.setCustomAnimations(2130772329, 2130772332);
          if ((paramIntent != null) && (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) && (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a()))
          {
            paramFragmentManager.hide(paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
            paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.g();
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
            paramFragmentManager.add(2131365303, localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment, String.valueOf(paramInt1));
          }
          paramFragmentManager.show(localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
          paramFragmentManager.commitAllowingStateLoss();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a(localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
          if (paramInt3 == 258) {
            localTab.a().a(paramBundle);
          }
          if (paramInt3 != 257) {
            break;
          }
          paramFragmentManager = localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
          if (localTab.jdField_a_of_type_Boolean) {
            break label483;
          }
          label297:
          paramFragmentManager.a(bool1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, paramBundle);
          label309:
          if (!localTab.jdField_a_of_type_Boolean) {
            localTab.jdField_a_of_type_Boolean = true;
          }
          a(paramInt2, paramInt1);
          if (((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() != 0) {
            break label477;
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
      if ((paramBundle != null) && (paramBundle.getBoolean("READINJOY_VIDEO_FORCE_INSERT_SET_SELECTION", false))) {
        paramFragmentManager.setCustomAnimations(2130772337, 2130772338);
      } else {
        paramFragmentManager.setCustomAnimations(2130772331, 2130772333);
      }
    }
    paramFragmentManager = localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if (!localTab.jdField_a_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramFragmentManager.a(bool1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, null);
      break label309;
      label477:
      AbstractGifImage.resumeAll();
      break;
      label483:
      bool1 = false;
      break label297;
    }
  }
  
  public void setTabState(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar
 * JD-Core Version:    0.7.0.1
 */