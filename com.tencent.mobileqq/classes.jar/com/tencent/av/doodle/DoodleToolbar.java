package com.tencent.av.doodle;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lkz;
import llc;
import lld;
import mbl;

public class DoodleToolbar
  extends BaseToolbar
{
  private lkz mDoodleLogic = lkz.a();
  mbl mUIInfo = null;
  
  public DoodleToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ColorPickerView addColorPickerView(ViewGroup paramViewGroup)
  {
    Object localObject2 = (ColorPickerView)paramViewGroup.findViewById(2131373227);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ColorPickerView(paramViewGroup.getContext());
      localObject2 = paramViewGroup.getResources();
      int i = ((Resources)localObject2).getDimensionPixelOffset(2131297600);
      int j = ((Resources)localObject2).getDimensionPixelOffset(2131297589);
      int k = ((Resources)localObject2).getDimensionPixelOffset(2131297590);
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, k, 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    return localObject1;
  }
  
  private void removeColorPickerView(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131373227);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public mbl getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mbl();
      this.mUIInfo.d = 3;
      this.mUIInfo.f = 2131559775;
      this.mUIInfo.e = 2130841974;
      this.mUIInfo.a = this.mApp.getApp().getString(2131695268);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      int i = 0;
      lkz locallkz = lkz.a();
      if (!lld.a()) {
        i = 2131694802;
      }
      while (i != 0)
      {
        return localAVActivity.getString(i);
        if (!locallkz.a()) {
          i = 2131694801;
        } else if (!locallkz.b) {
          i = 2131694800;
        }
      }
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    lkz locallkz = lkz.a();
    return (lld.a()) && (locallkz.b) && (locallkz.a());
  }
  
  public void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    onHide(paramLong);
  }
  
  public void onHide(long paramLong)
  {
    AVActivity localAVActivity = getAVActivity();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder().append("onHide, avActivity[");
    if (localAVActivity != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject1, 1, bool + "], seq[" + paramLong + "]");
      if (localAVActivity != null)
      {
        localObject1 = (ViewGroup)localAVActivity.findViewById(2131363079);
        if (localObject1 != null)
        {
          localObject2 = (DoodleSurfaceView)((ViewGroup)localObject1).findViewById(2131373238);
          if (localObject2 != null)
          {
            ((DoodleSurfaceView)localObject2).setClickable(false);
            if (!((DoodleSurfaceView)localObject2).a()) {
              lld.a((ViewGroup)localObject1);
            }
          }
          localObject2 = (ColorPickerView)((ViewGroup)localObject1).findViewById(2131373227);
          if (localObject2 != null)
          {
            ((ColorPickerView)localObject2).clearAnimation();
            ((ColorPickerView)localObject2).setVisibility(8);
            removeColorPickerView((ViewGroup)localObject1);
          }
          this.mDoodleLogic.a.a(false);
          localAVActivity.a.C(paramLong);
        }
      }
      return;
    }
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (this.mActivity.get() != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      Object localObject = (ViewGroup)localAVActivity.findViewById(2131363079);
      if (localObject != null)
      {
        DoodleSurfaceView localDoodleSurfaceView = lld.a((ViewGroup)localObject);
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
        localAVActivity.a.K();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleToolbar
 * JD-Core Version:    0.7.0.1
 */