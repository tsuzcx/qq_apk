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
  EffectFilterPanel.MyOnEffectFilterChangeListener a;
  private EffectFilterTextPager b;
  private ImageView c;
  private Handler d;
  private EffectFilterPanel.MyScroolTextDispearRunnable e;
  private boolean f;
  private EffectFilterTools g;
  private VideoAppInterface h;
  
  public EffectFilterPanel(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext);
    this.h = paramVideoAppInterface;
    this.d = new Handler();
    this.e = new EffectFilterPanel.MyScroolTextDispearRunnable(this);
    this.g = ((EffectFilterTools)paramVideoAppInterface.c(1));
    this.g.a(-1043L, this);
    a(paramContext, paramVideoAppInterface);
  }
  
  void a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new EffectFilterPanel.MyTextAlphaAnimationListener(this, this.c));
    this.c.startAnimation(localAlphaAnimation);
  }
  
  public void a(long paramLong, FilterItem paramFilterItem)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onItemSelectedChanged, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], mFilterPager[");
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("], current[");
    ((StringBuilder)localObject).append(paramFilterItem);
    ((StringBuilder)localObject).append("]");
    QLog.w("EffectFilterPanel", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((EffectFilterTextPager)localObject).setCurrentFilter(paramFilterItem);
    }
    paramFilterItem = (EffectOperateManager)this.h.c(8);
    if ((paramFilterItem != null) && (paramFilterItem.h())) {
      paramFilterItem.c(false);
    }
  }
  
  public void a(long paramLong, FilterItem paramFilterItem, boolean paramBoolean) {}
  
  void a(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    long l = AudioHelper.c();
    paramContext = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131625819, this);
    this.c = ((ImageView)paramContext.findViewById(2131441059));
    this.b = ((EffectFilterTextPager)paramContext.findViewById(2131449540));
    this.b.setApp(paramVideoAppInterface);
    setOnFilterListenner(null);
    paramContext = (FilterItem)this.g.c();
    paramVideoAppInterface = this.g.c(null);
    this.b.a(paramVideoAppInterface);
    this.b.setCurrentFilter(paramContext);
    this.g.a(l, paramContext);
  }
  
  public void a(FilterItem paramFilterItem, int paramInt) {}
  
  @TargetApi(11)
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeLayoutStyle: ");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramBoolean2);
    AVLog.printColorLog("EffectFilterPanel", ((StringBuilder)localObject1).toString());
    if (this.f != paramBoolean1)
    {
      this.f = paramBoolean1;
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
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject1).widthPixels / 2, -1);
        if (paramBoolean2) {
          i = j;
        } else {
          i = 9;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(i);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, -(int)getContext().getResources().getDimension(2131298436), 0, 0);
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.c.setScaleX(0.9F);
        this.c.setScaleY(0.9F);
      }
      else
      {
        localObject1 = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -1;
        ((RelativeLayout.LayoutParams)localObject1).height = -1;
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, (int)getContext().getResources().getDimension(2131298435), 0, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.c.setScaleX(1.0F);
        this.c.setScaleY(1.0F);
      }
      this.b.a(paramBoolean1);
    }
  }
  
  public void b()
  {
    int i = VideoController.f().k().aQ;
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
    if (this.f)
    {
      this.b.dispatchTouchEvent(paramMotionEvent);
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
    this.b.setAnimationTrigger(paramAnimationTrigger);
  }
  
  public void setOnFilterListenner(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    EffectFilterPanel.MyOnEffectFilterChangeListener localMyOnEffectFilterChangeListener = this.a;
    if (localMyOnEffectFilterChangeListener == null) {
      this.a = new EffectFilterPanel.MyOnEffectFilterChangeListener(this, paramOnEffectFilterChangeListener);
    } else {
      localMyOnEffectFilterChangeListener.a(paramOnEffectFilterChangeListener);
    }
    this.b.setOnFilterListenner(this.a);
  }
  
  public void setVisibility(int paramInt)
  {
    this.b.setVisibility(paramInt);
    SessionInfo localSessionInfo = VideoController.f().k();
    if (localSessionInfo.bK)
    {
      localSessionInfo.bK = false;
      this.c.setVisibility(0);
      this.d.postDelayed(this.e, 4000L);
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel
 * JD-Core Version:    0.7.0.1
 */