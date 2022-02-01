package com.tencent.av.doodle;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.BaseToolbar.UIInfo;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoodleToolbar
  extends BaseToolbar
{
  private DoodleLogic mDoodleLogic = null;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public DoodleToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private static ColorPickerView addColorPickerView(ViewGroup paramViewGroup)
  {
    Object localObject2 = (ColorPickerView)paramViewGroup.findViewById(2131373367);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ColorPickerView(paramViewGroup.getContext());
      localObject2 = paramViewGroup.getResources();
      int i = ((Resources)localObject2).getDimensionPixelOffset(2131297726);
      int j = ((Resources)localObject2).getDimensionPixelOffset(2131297715);
      int k = ((Resources)localObject2).getDimensionPixelOffset(2131297716);
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, k, 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    return localObject1;
  }
  
  public static void hideDoodle(long paramLong, AVActivity paramAVActivity, DoodleLogic paramDoodleLogic)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("hideDoodle, activity[");
      boolean bool2 = true;
      boolean bool1;
      if (paramAVActivity != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("], logic[");
      if (paramDoodleLogic != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("], seq[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("]");
      QLog.w("Doodle", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramAVActivity != null)
    {
      if (paramDoodleLogic == null) {
        return;
      }
      localObject1 = (ViewGroup)paramAVActivity.findViewById(2131363127);
      if (localObject1 != null)
      {
        Object localObject2 = (DoodleSurfaceView)((ViewGroup)localObject1).findViewById(2131373377);
        if (localObject2 != null)
        {
          ((DoodleSurfaceView)localObject2).setClickable(false);
          if (!((DoodleSurfaceView)localObject2).a()) {
            DoodleUtils.a((ViewGroup)localObject1);
          }
        }
        localObject2 = (ColorPickerView)((ViewGroup)localObject1).findViewById(2131373367);
        if (localObject2 != null)
        {
          ((ColorPickerView)localObject2).clearAnimation();
          ((ColorPickerView)localObject2).setVisibility(8);
          removeColorPickerView((ViewGroup)localObject1);
        }
        paramDoodleLogic.a.a(false);
        paramAVActivity.a.C(paramLong);
      }
    }
  }
  
  private static void removeColorPickerView(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131373367);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static void showDoodle(long paramLong, AVActivity paramAVActivity, DoodleLogic paramDoodleLogic)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDoodle, activity[");
      boolean bool;
      if (paramAVActivity != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], logic[");
      if (paramDoodleLogic != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("Doodle", 2, ((StringBuilder)localObject).toString());
    }
    if (paramAVActivity != null)
    {
      if (paramDoodleLogic == null) {
        return;
      }
      localObject = (ViewGroup)paramAVActivity.findViewById(2131363127);
      if (localObject != null)
      {
        View localView = DoodleUtils.a((ViewGroup)localObject);
        if (localView != null) {
          localView.setClickable(true);
        }
        localObject = addColorPickerView((ViewGroup)localObject);
        if (localObject != null)
        {
          ((ColorPickerView)localObject).clearAnimation();
          ((ColorPickerView)localObject).setVisibility(0);
        }
        paramDoodleLogic.a.a(true);
        paramAVActivity.a.N();
      }
    }
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 3;
      localUIInfo.g = 2131559767;
      localUIInfo.f = 2130842082;
      localUIInfo.a = this.mApp.getApp().getString(2131695925);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      int i = 0;
      DoodleLogic localDoodleLogic = DoodleLogic.a();
      if (!DoodleUtils.a()) {
        i = 2131695451;
      } else if (!localDoodleLogic.a()) {
        i = 2131695450;
      } else if (!localDoodleLogic.b) {
        i = 2131695449;
      }
      if (i != 0) {
        return localAVActivity.getString(i);
      }
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    DoodleLogic localDoodleLogic = DoodleLogic.a();
    return (DoodleUtils.a()) && (localDoodleLogic.b) && (localDoodleLogic.a());
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    onHide(paramLong);
  }
  
  protected void onHide(long paramLong)
  {
    hideDoodle(paramLong, (AVActivity)this.mActivity.get(), this.mDoodleLogic);
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    showDoodle(paramLong, (AVActivity)this.mActivity.get(), this.mDoodleLogic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleToolbar
 * JD-Core Version:    0.7.0.1
 */