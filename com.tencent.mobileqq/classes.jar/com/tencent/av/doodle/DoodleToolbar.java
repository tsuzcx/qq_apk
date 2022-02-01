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
import lls;
import llv;
import llw;
import mcl;

public class DoodleToolbar
  extends BaseToolbar
{
  private lls mDoodleLogic = lls.a();
  mcl mUIInfo = null;
  
  public DoodleToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private static ColorPickerView addColorPickerView(ViewGroup paramViewGroup)
  {
    Object localObject2 = (ColorPickerView)paramViewGroup.findViewById(2131373481);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ColorPickerView(paramViewGroup.getContext());
      localObject2 = paramViewGroup.getResources();
      int i = ((Resources)localObject2).getDimensionPixelOffset(2131297668);
      int j = ((Resources)localObject2).getDimensionPixelOffset(2131297657);
      int k = ((Resources)localObject2).getDimensionPixelOffset(2131297658);
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, k, 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    return localObject1;
  }
  
  public static void hideDoodle(long paramLong, AVActivity paramAVActivity, lls paramlls)
  {
    boolean bool2 = true;
    Object localObject1;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("hideDoodle, activity[");
      if (paramAVActivity != null)
      {
        bool1 = true;
        localObject1 = ((StringBuilder)localObject1).append(bool1).append("], logic[");
        if (paramlls == null) {
          break label97;
        }
        bool1 = bool2;
        label52:
        QLog.w("Doodle", 2, bool1 + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if ((paramAVActivity != null) && (paramlls != null)) {
        break label103;
      }
    }
    label97:
    label103:
    do
    {
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label52;
      localObject1 = (ViewGroup)paramAVActivity.findViewById(2131363136);
    } while (localObject1 == null);
    Object localObject2 = (DoodleSurfaceView)((ViewGroup)localObject1).findViewById(2131373491);
    if (localObject2 != null)
    {
      ((DoodleSurfaceView)localObject2).setClickable(false);
      if (!((DoodleSurfaceView)localObject2).a()) {
        llw.a((ViewGroup)localObject1);
      }
    }
    localObject2 = (ColorPickerView)((ViewGroup)localObject1).findViewById(2131373481);
    if (localObject2 != null)
    {
      ((ColorPickerView)localObject2).clearAnimation();
      ((ColorPickerView)localObject2).setVisibility(8);
      removeColorPickerView((ViewGroup)localObject1);
    }
    paramlls.a.a(false);
    paramAVActivity.a.D(paramLong);
  }
  
  private static void removeColorPickerView(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131373481);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static void showDoodle(long paramLong, AVActivity paramAVActivity, lls paramlls)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("showDoodle, activity[");
      if (paramAVActivity != null)
      {
        bool = true;
        localObject = ((StringBuilder)localObject).append(bool).append("], logic[");
        if (paramlls == null) {
          break label93;
        }
        bool = true;
        label48:
        QLog.w("Doodle", 2, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if ((paramAVActivity != null) && (paramlls != null)) {
        break label99;
      }
    }
    label93:
    label99:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label48;
      localObject = (ViewGroup)paramAVActivity.findViewById(2131363136);
    } while (localObject == null);
    DoodleSurfaceView localDoodleSurfaceView = llw.a((ViewGroup)localObject);
    if (localDoodleSurfaceView != null) {
      localDoodleSurfaceView.setClickable(true);
    }
    Object localObject = addColorPickerView((ViewGroup)localObject);
    if (localObject != null)
    {
      ((ColorPickerView)localObject).clearAnimation();
      ((ColorPickerView)localObject).setVisibility(0);
    }
    paramlls.a.a(true);
    paramAVActivity.a.L();
  }
  
  public mcl getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mcl();
      this.mUIInfo.d = 3;
      this.mUIInfo.f = 2131559820;
      this.mUIInfo.e = 2130842041;
      this.mUIInfo.a = this.mApp.getApp().getString(2131695667);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      int i = 0;
      lls locallls = lls.a();
      if (!llw.a()) {
        i = 2131695198;
      }
      while (i != 0)
      {
        return localAVActivity.getString(i);
        if (!locallls.a()) {
          i = 2131695197;
        } else if (!locallls.b) {
          i = 2131695196;
        }
      }
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    lls locallls = lls.a();
    return (llw.a()) && (locallls.b) && (locallls.a());
  }
  
  public void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    onHide(paramLong);
  }
  
  public void onHide(long paramLong)
  {
    hideDoodle(paramLong, (AVActivity)this.mActivity.get(), this.mDoodleLogic);
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    showDoodle(paramLong, (AVActivity)this.mActivity.get(), this.mDoodleLogic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleToolbar
 * JD-Core Version:    0.7.0.1
 */