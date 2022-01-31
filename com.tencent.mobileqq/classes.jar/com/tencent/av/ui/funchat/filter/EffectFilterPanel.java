package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import kfa;
import kfb;
import kfc;

public class EffectFilterPanel
  extends RelativeLayout
  implements EffectConfigBase.IEffectConfigCallback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private EffectFilterTools jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools;
  private EffectFilterTextPager jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager;
  kfa jdField_a_of_type_Kfa;
  private kfb jdField_a_of_type_Kfb;
  private boolean jdField_a_of_type_Boolean;
  
  public EffectFilterPanel(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Kfb = new kfb(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools = ((EffectFilterTools)paramVideoAppInterface.a(1));
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a(this);
    a(paramContext, paramVideoAppInterface);
  }
  
  public void a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new kfc(this, this.jdField_a_of_type_AndroidWidgetImageView));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
  }
  
  void a(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    paramContext = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130969365, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131366298));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager = ((EffectFilterTextPager)paramContext.findViewById(2131366297));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setApp(paramVideoAppInterface);
    setOnFilterListenner(null);
    paramContext = (FilterItem)this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a();
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a(null);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setCurrentFilter(paramContext);
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a(paramContext);
  }
  
  public void a(FilterItem paramFilterItem)
  {
    AVLog.c("EffectFilterPanel", "onItemSelectedChanged item: " + paramFilterItem);
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setCurrentFilter(paramFilterItem);
    }
    paramFilterItem = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
    if ((paramFilterItem != null) && (paramFilterItem.b())) {
      paramFilterItem.b(false);
    }
  }
  
  public void a(FilterItem paramFilterItem, int paramInt) {}
  
  public void a(FilterItem paramFilterItem, boolean paramBoolean) {}
  
  @TargetApi(11)
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AVLog.c("EffectFilterPanel", "changeLayoutStyle: " + this.jdField_a_of_type_Boolean + "|" + paramBoolean1 + "|" + paramBoolean2);
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Boolean != paramBoolean1)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if (!paramBoolean1) {
        break label241;
      }
      localObject = getContext().getResources().getDisplayMetrics();
      AVLog.c("EffectFilterPanel", "changeLayoutStyle 22: " + ((DisplayMetrics)localObject).widthPixels);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject).widthPixels / 2, -1);
      if (!paramBoolean2) {
        break label229;
      }
      i = 11;
      localLayoutParams.addRule(i);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams(localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject).widthPixels / 2, -1);
      if (!paramBoolean2) {
        break label235;
      }
      i = 11;
      label165:
      ((RelativeLayout.LayoutParams)localObject).addRule(i);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, -(int)getContext().getResources().getDimension(2131560072), 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(0.9F);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(0.9F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(paramBoolean1);
      return;
      label229:
      i = 9;
      break;
      label235:
      i = 9;
      break label165;
      label241:
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      ((RelativeLayout.LayoutParams)localObject).height = -1;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)getContext().getResources().getDimension(2131560071), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(1.0F);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.dispatchTouchEvent(paramMotionEvent);
      AVLog.c("EffectFilterPanel", "onTouchEvent: " + paramMotionEvent.toString());
      return true;
    }
    return false;
  }
  
  public void setOnFilterListenner(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    if (this.jdField_a_of_type_Kfa == null) {
      this.jdField_a_of_type_Kfa = new kfa(this, paramOnEffectFilterChangeListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setOnFilterListenner(this.jdField_a_of_type_Kfa);
      return;
      this.jdField_a_of_type_Kfa.a(paramOnEffectFilterChangeListener);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setVisibility(paramInt);
    SessionInfo localSessionInfo = VideoController.a().a();
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = localSessionInfo.a;
    if ((localPtvTemplateInfo != null) && (!TextUtils.isEmpty(localPtvTemplateInfo.filtername))) {}
    for (int i = 1;; i = 0)
    {
      if ((localSessionInfo.ay) && (i == 0))
      {
        localSessionInfo.ay = false;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Kfb, 4000L);
      }
      super.setVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel
 * JD-Core Version:    0.7.0.1
 */