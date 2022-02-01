package com.tencent.mobileqq.apollo.debug;

import alsn;
import also;
import alsp;
import alsq;
import alsr;
import alss;
import alst;
import alsu;
import alvx;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SimpleAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugBaseFragment;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugLogFragment;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class CmGameDebugView
  extends FrameworkView
  implements View.OnClickListener
{
  public int a;
  private also jdField_a_of_type_Also = new alsu(this);
  private Context jdField_a_of_type_AndroidContentContext;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private SparseArray<CmGameDebugBaseFragment> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public View.OnTouchListener a;
  private View jdField_a_of_type_AndroidViewView;
  public AdapterView.OnItemClickListener a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CmGameDebugBaseFragment jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private boolean jdField_a_of_type_Boolean = true;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  
  public CmGameDebugView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new alsp(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new alss(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public CmGameDebugView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new alsp(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new alss(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode > 0)
    {
      if (this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels > this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels)
      {
        i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Int = i;
        if (this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels) {
          break label263;
        }
      }
      label263:
      for (i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;; i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels)
      {
        this.jdField_b_of_type_Int = i;
        paramContext = (FrameLayout)LayoutInflater.from(paramContext).inflate(2131558906, null);
        this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131364677);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext.findViewById(2131364679));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramContext.findViewById(2131364680));
        this.c = paramContext.findViewById(2131364678);
        this.c.setOnClickListener(this);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.leftMargin = (this.jdField_a_of_type_Int - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 130.0F));
        localLayoutParams.topMargin = (this.jdField_b_of_type_Int - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 46.0F));
        this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        addView(paramContext);
        ((RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131376688)).addView(this, new RelativeLayout.LayoutParams(-2, -2));
        c();
        return;
        i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
        break;
      }
    }
    if (this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels < this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels)
    {
      i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
      label299:
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels >= this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels) {
        break label348;
      }
    }
    label348:
    for (int i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;; i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels)
    {
      this.jdField_b_of_type_Int = i;
      break;
      i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
      break label299;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
    }
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
    if (localView != null)
    {
      localView.setSelected(true);
      this.jdField_b_of_type_AndroidViewView = localView;
    }
  }
  
  private void c(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      CmGameDebugBaseFragment localCmGameDebugBaseFragment = (CmGameDebugBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((localCmGameDebugBaseFragment instanceof CmGameDebugLogFragment)) {
        ((CmGameDebugLogFragment)localCmGameDebugBaseFragment).a(paramInt);
      }
      i += 1;
    }
  }
  
  private void h()
  {
    alsn localalsn = alvx.a();
    if (localalsn != null) {
      localalsn.a(this.jdField_a_of_type_Also);
    }
  }
  
  public List<HashMap<String, Object>> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < alsn.a.length)
    {
      String str = alsn.a[i];
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", str);
      localArrayList.add(localHashMap);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getSupportFragmentManager();
    }
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment != null) {
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment);
    }
    CmGameDebugBaseFragment localCmGameDebugBaseFragment2 = (CmGameDebugBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    CmGameDebugBaseFragment localCmGameDebugBaseFragment1 = localCmGameDebugBaseFragment2;
    if (localCmGameDebugBaseFragment2 == null)
    {
      localCmGameDebugBaseFragment1 = alsn.a(paramInt);
      localCmGameDebugBaseFragment1.a(new alst(this));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localCmGameDebugBaseFragment1);
    }
    if (!localCmGameDebugBaseFragment1.isAdded()) {
      localFragmentTransaction.add(2131364676, localCmGameDebugBaseFragment1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment = localCmGameDebugBaseFragment1;
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      localFragmentTransaction.show(localCmGameDebugBaseFragment1);
    }
  }
  
  public void aj_()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight(), 0.0F);
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new alsq(this));
  }
  
  public void b()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new alsr(this));
  }
  
  public void c()
  {
    SimpleAdapter localSimpleAdapter = new SimpleAdapter(this.jdField_a_of_type_AndroidContentContext, a(), 2131558907, new String[] { "title" }, new int[] { 2131364681 });
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localSimpleAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    a(0);
    h();
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameDebugView", 2, "game debug view init");
    }
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugView
 * JD-Core Version:    0.7.0.1
 */