package com.tencent.biz.pubaccount.readinjoy.view;

import aekt;
import alpo;
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
import bcwh;
import bcxb;
import bdda;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.concurrent.ConcurrentHashMap;
import ors;
import ozn;
import qio;
import qja;
import rox;
import rxh;
import rxi;

public class ReadinjoyTabbar
  extends BaseTabbar
{
  private ReadInJoyNewFeedsActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity;
  protected KandianMergeManager a;
  protected QQAppInterface a;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private ConcurrentHashMap<Integer, rxi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
    setTabHeight(aekt.a(65.0F, getResources()));
    setUnderLineHeight(aekt.a(6.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    setSelectColor(((qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(8).a());
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
    localTextView.setText(alpo.a(2131713137));
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 16.0F);
    localTextView.setGravity(17);
    int i = bcwh.a(localContext, 10.0F);
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
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
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
      localTextView.setId(2131375232);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(1, 16.0F);
      localTextView.setGravity(17);
      i = bcwh.a(localContext, 10.0F);
      localTextView.setPadding(i, 0, i, 0);
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    } while (i <= 0);
    localTextView.setText(" " + Integer.toString(i) + alpo.a(2131713243));
    Object localObject = bdda.a();
    if (l != -1L) {}
    for (localObject = bcxb.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1, Long.toString(l), 3, (Drawable)localObject, (Drawable)localObject);; localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.getApplicationContext().getResources().getDrawable(2130842600))
    {
      ((Drawable)localObject).setBounds(0, 0, bcwh.a(localContext, 25.0F), bcwh.a(localContext, 25.0F));
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localRelativeLayout.addView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      localRelativeLayout.setOnClickListener(new rxh(this));
      this.b = a(paramView, localRelativeLayout);
      if (this.b == null) {
        break;
      }
      this.b.b(true);
      this.b.c(true);
      this.b.c();
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
      this.b.b();
      this.b = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public ReadInJoyBaseFragment a(rxi paramrxi)
  {
    if (paramrxi == null) {
      return null;
    }
    return paramrxi.a();
  }
  
  public rox a(int paramInt, String paramString)
  {
    paramString = super.a(paramInt, paramString);
    rxi localrxi = new rxi();
    localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = null;
    localrxi.jdField_a_of_type_Rox = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localrxi);
    return paramString;
  }
  
  public rxi a(int paramInt)
  {
    return (rxi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
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
    rxi localrxi = (rxi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    localrxi.jdField_a_of_type_Rox.a.post(new ReadinjoyTabbar.2(this, paramInt, localrxi));
  }
  
  public void setCurrentActivity(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity = paramReadInJoyNewFeedsActivity;
  }
  
  public void setSelection(int paramInt1, int paramInt2, FragmentManager paramFragmentManager, Intent paramIntent, int paramInt3, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    rxi localrxi;
    for (;;)
    {
      try
      {
        paramIntent = a(paramInt2);
        localrxi = a(paramInt1);
        if ((paramInt1 == paramInt2) && (a(localrxi) != null) && (paramInt3 == 256))
        {
          localrxi.a().f();
          setTabState(paramInt1, false);
          return;
        }
        if (paramInt3 != 256) {
          setSelectedTab(paramInt1, true, true);
        }
        paramFragmentManager = paramFragmentManager.beginTransaction();
        if (paramInt1 < paramInt2)
        {
          paramFragmentManager.setCustomAnimations(2130772307, 2130772310);
          if ((paramIntent != null) && (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) && (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a()))
          {
            paramFragmentManager.hide(paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
            paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.g();
          }
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a() != localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment)) {
            paramFragmentManager.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a());
          }
          if (localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null)
          {
            localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ozn.a(paramInt1);
            if (localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null) {
              continue;
            }
          }
          if (!localrxi.jdField_a_of_type_Boolean) {
            paramFragmentManager.add(2131364779, localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment, String.valueOf(paramInt1));
          }
          paramFragmentManager.show(localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
          paramFragmentManager.commitAllowingStateLoss();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a(localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
          if (paramInt3 == 258) {
            localrxi.a().a(paramBundle);
          }
          if (paramInt3 != 257) {
            break;
          }
          paramFragmentManager = localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
          if (localrxi.jdField_a_of_type_Boolean) {
            break label483;
          }
          label297:
          paramFragmentManager.a(bool1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, paramBundle);
          label309:
          if (!localrxi.jdField_a_of_type_Boolean) {
            localrxi.jdField_a_of_type_Boolean = true;
          }
          a(paramInt2, paramInt1);
          if (((qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a() != 0) {
            break label477;
          }
          if (!paramIntent.jdField_a_of_type_Rox.a()) {
            paramIntent.jdField_a_of_type_Rox.a(true, false);
          }
          if (!localrxi.b) {
            continue;
          }
          localrxi.jdField_a_of_type_Rox.a(false, false);
          continue;
        }
        if (paramInt1 <= paramInt2) {
          continue;
        }
      }
      finally {}
      if ((paramBundle != null) && (paramBundle.getBoolean("READINJOY_VIDEO_FORCE_INSERT_SET_SELECTION", false))) {
        paramFragmentManager.setCustomAnimations(2130772315, 2130772316);
      } else {
        paramFragmentManager.setCustomAnimations(2130772309, 2130772311);
      }
    }
    paramFragmentManager = localrxi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if (!localrxi.jdField_a_of_type_Boolean) {}
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
    Object localObject = (qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
    if ((paramBoolean) && (((qja)localObject).a() != 0)) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("TabBarView", 4, "setTabState type:" + paramInt + " isRefreshState:" + paramBoolean);
    }
    localObject = a(paramInt);
    ((rxi)localObject).b = paramBoolean;
    rox localrox = ((rxi)localObject).jdField_a_of_type_Rox;
    if (!((rxi)localObject).b) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localrox.a(paramBoolean, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar
 * JD-Core Version:    0.7.0.1
 */