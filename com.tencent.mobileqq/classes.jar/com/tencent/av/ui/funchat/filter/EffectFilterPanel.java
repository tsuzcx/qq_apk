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
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.ui.AVActivity.AnimationTrigger;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lek;
import lid;
import ljn;
import ljs;
import mpn;
import mpo;
import mps;

public class EffectFilterPanel
  extends RelativeLayout
  implements ljn<FilterItem>
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private EffectFilterPanel.MyScroolTextDispearRunnable jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable;
  private EffectFilterTextPager jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager;
  private ljs jdField_a_of_type_Ljs;
  mpn jdField_a_of_type_Mpn;
  private boolean jdField_a_of_type_Boolean;
  
  public EffectFilterPanel(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable = new EffectFilterPanel.MyScroolTextDispearRunnable(this);
    this.jdField_a_of_type_Ljs = ((ljs)paramVideoAppInterface.a(1));
    this.jdField_a_of_type_Ljs.a(-1043L, this);
    a(paramContext, paramVideoAppInterface);
  }
  
  void a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new mpo(this, this.jdField_a_of_type_AndroidWidgetImageView));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
  }
  
  public void a(long paramLong, FilterItem paramFilterItem)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onItemSelectedChanged, seq[").append(paramLong).append("], mFilterPager[");
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("EffectFilterPanel", 1, bool + "], current[" + paramFilterItem + "]");
      if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setCurrentFilter(paramFilterItem);
      }
      paramFilterItem = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if ((paramFilterItem != null) && (paramFilterItem.a())) {
        paramFilterItem.c(false);
      }
      return;
    }
  }
  
  public void a(long paramLong, FilterItem paramFilterItem, boolean paramBoolean) {}
  
  void a(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    long l = AudioHelper.b();
    paramContext = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559648, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131372633));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager = ((EffectFilterTextPager)paramContext.findViewById(2131379676));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setApp(paramVideoAppInterface);
    setOnFilterListenner(null);
    paramContext = (FilterItem)this.jdField_a_of_type_Ljs.a();
    paramVideoAppInterface = this.jdField_a_of_type_Ljs.a(null);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setCurrentFilter(paramContext);
    this.jdField_a_of_type_Ljs.a(l, paramContext);
  }
  
  public void a(FilterItem paramFilterItem, int paramInt) {}
  
  @TargetApi(11)
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    lek.c("EffectFilterPanel", "changeLayoutStyle: " + this.jdField_a_of_type_Boolean + "|" + paramBoolean1 + "|" + paramBoolean2);
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Boolean != paramBoolean1)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if (!paramBoolean1) {
        break label243;
      }
      localObject = getContext().getResources().getDisplayMetrics();
      lek.c("EffectFilterPanel", "changeLayoutStyle 22: " + ((DisplayMetrics)localObject).widthPixels);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject).widthPixels / 2, -1);
      if (!paramBoolean2) {
        break label231;
      }
      i = 11;
      localLayoutParams.addRule(i);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams(localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject).widthPixels / 2, -1);
      if (!paramBoolean2) {
        break label237;
      }
      i = 11;
      label165:
      ((RelativeLayout.LayoutParams)localObject).addRule(i);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, -(int)getContext().getResources().getDimension(2131297562), 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(0.9F);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(0.9F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(paramBoolean1);
      return;
      label231:
      i = 9;
      break;
      label237:
      i = 9;
      break label165;
      label243:
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      ((RelativeLayout.LayoutParams)localObject).height = -1;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)getContext().getResources().getDimension(2131297561), 0, 0);
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
      lek.c("EffectFilterPanel", "onTouchEvent: " + paramMotionEvent.toString());
      return true;
    }
    return false;
  }
  
  public void setAnimationTrigger(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setAnimationTrigger(paramAnimationTrigger);
  }
  
  public void setOnFilterListenner(mps parammps)
  {
    if (this.jdField_a_of_type_Mpn == null) {
      this.jdField_a_of_type_Mpn = new mpn(this, parammps);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setOnFilterListenner(this.jdField_a_of_type_Mpn);
      return;
      this.jdField_a_of_type_Mpn.a(parammps);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setVisibility(paramInt);
    lid locallid = VideoController.a().a();
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = locallid.a;
    if ((localPtvTemplateInfo != null) && (!TextUtils.isEmpty(localPtvTemplateInfo.filtername))) {}
    for (int i = 1;; i = 0)
    {
      if ((locallid.av) && (i == 0))
      {
        locallid.av = false;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable, 4000L);
      }
      super.setVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel
 * JD-Core Version:    0.7.0.1
 */