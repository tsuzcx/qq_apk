package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
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
import com.tencent.av.ui.AVActivity.AnimationTrigger;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class EffectFilterPanel
  extends RelativeLayout
  implements EffectConfigBase.IEffectConfigCallback<FilterItem>
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private EffectFilterTools jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools;
  EffectFilterPanel.MyOnEffectFilterChangeListener jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyOnEffectFilterChangeListener;
  private EffectFilterPanel.MyScroolTextDispearRunnable jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable;
  private EffectFilterTextPager jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager;
  private boolean jdField_a_of_type_Boolean;
  
  public EffectFilterPanel(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable = new EffectFilterPanel.MyScroolTextDispearRunnable(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools = ((EffectFilterTools)paramVideoAppInterface.a(1));
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a(-1043L, this);
    a(paramContext, paramVideoAppInterface);
  }
  
  void a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new EffectFilterPanel.MyTextAlphaAnimationListener(this, this.jdField_a_of_type_AndroidWidgetImageView));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
  }
  
  public void a(long paramLong, FilterItem paramFilterItem)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onItemSelectedChanged, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], mFilterPager[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("], current[");
    ((StringBuilder)localObject).append(paramFilterItem);
    ((StringBuilder)localObject).append("]");
    QLog.w("EffectFilterPanel", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager;
    if (localObject != null) {
      ((EffectFilterTextPager)localObject).setCurrentFilter(paramFilterItem);
    }
    paramFilterItem = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
    if ((paramFilterItem != null) && (paramFilterItem.a())) {
      paramFilterItem.c(false);
    }
  }
  
  public void a(long paramLong, FilterItem paramFilterItem, boolean paramBoolean) {}
  
  void a(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    long l = AudioHelper.b();
    paramContext = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559777, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131373386));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager = ((EffectFilterTextPager)paramContext.findViewById(2131380581));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setApp(paramVideoAppInterface);
    setOnFilterListenner(null);
    paramContext = (FilterItem)this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a();
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a(null);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setCurrentFilter(paramContext);
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a(l, paramContext);
  }
  
  public void a(FilterItem paramFilterItem, int paramInt) {}
  
  @TargetApi(11)
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeLayoutStyle: ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramBoolean2);
    AVLog.printColorLog("EffectFilterPanel", ((StringBuilder)localObject1).toString());
    if (this.jdField_a_of_type_Boolean != paramBoolean1)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if (paramBoolean1)
      {
        localObject1 = getContext().getResources().getDisplayMetrics();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("changeLayoutStyle 22: ");
        ((StringBuilder)localObject2).append(((DisplayMetrics)localObject1).widthPixels);
        AVLog.printColorLog("EffectFilterPanel", ((StringBuilder)localObject2).toString());
        localObject2 = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject1).widthPixels / 2, -1);
        int j = 11;
        int i;
        if (paramBoolean2) {
          i = 11;
        } else {
          i = 9;
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(i);
        this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject1).widthPixels / 2, -1);
        if (paramBoolean2) {
          i = j;
        } else {
          i = 9;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(i);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, -(int)getContext().getResources().getDimension(2131297767), 0, 0);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(0.9F);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(0.9F);
      }
      else
      {
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -1;
        ((RelativeLayout.LayoutParams)localObject1).height = -1;
        this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, (int)getContext().getResources().getDimension(2131297766), 0, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(1.0F);
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(paramBoolean1);
    }
  }
  
  public void b()
  {
    int i = VideoController.a().a().E;
    if ((i != 1) && (i != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      i = 2;
    } else {
      i = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BC06", "0X800BC06", i, 0, "", "", "", "");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.dispatchTouchEvent(paramMotionEvent);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent: ");
      localStringBuilder.append(paramMotionEvent.toString());
      AVLog.printColorLog("EffectFilterPanel", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void setAnimationTrigger(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setAnimationTrigger(paramAnimationTrigger);
  }
  
  public void setOnFilterListenner(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    EffectFilterPanel.MyOnEffectFilterChangeListener localMyOnEffectFilterChangeListener = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyOnEffectFilterChangeListener;
    if (localMyOnEffectFilterChangeListener == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyOnEffectFilterChangeListener = new EffectFilterPanel.MyOnEffectFilterChangeListener(this, paramOnEffectFilterChangeListener);
    } else {
      localMyOnEffectFilterChangeListener.a(paramOnEffectFilterChangeListener);
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setOnFilterListenner(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyOnEffectFilterChangeListener);
  }
  
  public void setVisibility(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setVisibility(paramInt);
    SessionInfo localSessionInfo = VideoController.a().a();
    if (localSessionInfo.am)
    {
      localSessionInfo.am = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable, 4000L);
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel
 * JD-Core Version:    0.7.0.1
 */