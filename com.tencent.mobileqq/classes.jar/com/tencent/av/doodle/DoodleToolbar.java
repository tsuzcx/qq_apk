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
import java.lang.ref.WeakReference;

public class DoodleToolbar
  extends BaseToolbar
{
  public static String TAG = "DoodleToolbar";
  private DoodleLogic mDoodleLogic = DoodleLogic.a();
  BaseToolbar.UIInfo mUIInfo = null;
  
  public DoodleToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ColorPickerView addColorPickerView(ViewGroup paramViewGroup)
  {
    Object localObject2 = (ColorPickerView)paramViewGroup.findViewById(2131362539);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ColorPickerView(paramViewGroup.getContext());
      localObject2 = paramViewGroup.getResources();
      int i = ((Resources)localObject2).getDimensionPixelOffset(2131560054);
      int j = ((Resources)localObject2).getDimensionPixelOffset(2131560055);
      int k = ((Resources)localObject2).getDimensionPixelOffset(2131560056);
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, k, 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    return localObject1;
  }
  
  private void removeColorPickerView(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131362539);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 3;
      this.mUIInfo.g = 2130969357;
      this.mUIInfo.e = 103413;
      this.mUIInfo.f = 2130840159;
      this.mUIInfo.a = this.mApp.getApp().getResources().getString(2131428743);
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
        i = 2131429593;
      }
      while (i != 0)
      {
        return localAVActivity.getString(i);
        if (!localDoodleLogic.a()) {
          i = 2131429595;
        } else if (!localDoodleLogic.b) {
          i = 2131429594;
        }
      }
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    DoodleLogic localDoodleLogic = DoodleLogic.a();
    return (DoodleUtils.a()) && (localDoodleLogic.b) && (localDoodleLogic.a());
  }
  
  protected void onHide()
  {
    if (this.mActivity != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      if (localAVActivity != null)
      {
        ViewGroup localViewGroup = (ViewGroup)localAVActivity.findViewById(2131365830);
        if (localViewGroup != null)
        {
          Object localObject = (DoodleSurfaceView)localViewGroup.findViewById(2131362540);
          if (localObject != null)
          {
            ((DoodleSurfaceView)localObject).setClickable(false);
            if (!((DoodleSurfaceView)localObject).a()) {
              DoodleUtils.a(localViewGroup);
            }
          }
          localObject = (ColorPickerView)localViewGroup.findViewById(2131362539);
          if (localObject != null)
          {
            ((ColorPickerView)localObject).clearAnimation();
            ((ColorPickerView)localObject).setVisibility(8);
            removeColorPickerView(localViewGroup);
          }
          this.mDoodleLogic.a.a(false);
          localAVActivity.a.ad();
        }
      }
    }
  }
  
  protected void onShow(int paramInt, boolean paramBoolean)
  {
    if (this.mActivity.get() != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      Object localObject = (ViewGroup)localAVActivity.findViewById(2131365830);
      if (localObject != null)
      {
        DoodleSurfaceView localDoodleSurfaceView = DoodleUtils.a((ViewGroup)localObject);
        if (localDoodleSurfaceView != null) {
          localDoodleSurfaceView.setClickable(true);
        }
        localObject = addColorPickerView((ViewGroup)localObject);
        if (localObject != null)
        {
          ((ColorPickerView)localObject).clearAnimation();
          ((ColorPickerView)localObject).setVisibility(0);
        }
        this.mDoodleLogic.a.a(true);
        localAVActivity.a.z();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleToolbar
 * JD-Core Version:    0.7.0.1
 */