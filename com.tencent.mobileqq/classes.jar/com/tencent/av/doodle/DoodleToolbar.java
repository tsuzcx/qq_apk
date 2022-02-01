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
    Object localObject2 = (ColorPickerView)paramViewGroup.findViewById(2131373795);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ColorPickerView(paramViewGroup.getContext());
      localObject2 = paramViewGroup.getResources();
      int i = ((Resources)localObject2).getDimensionPixelOffset(2131297735);
      int j = ((Resources)localObject2).getDimensionPixelOffset(2131297724);
      int k = ((Resources)localObject2).getDimensionPixelOffset(2131297725);
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, k, 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    return localObject1;
  }
  
  public static void hideDoodle(long paramLong, AVActivity paramAVActivity, DoodleLogic paramDoodleLogic)
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
        if (paramDoodleLogic == null) {
          break label97;
        }
        bool1 = bool2;
        label52:
        QLog.w("Doodle", 2, bool1 + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if ((paramAVActivity != null) && (paramDoodleLogic != null)) {
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
      localObject1 = (ViewGroup)paramAVActivity.findViewById(2131363187);
    } while (localObject1 == null);
    Object localObject2 = (DoodleSurfaceView)((ViewGroup)localObject1).findViewById(2131373805);
    if (localObject2 != null)
    {
      ((DoodleSurfaceView)localObject2).setClickable(false);
      if (!((DoodleSurfaceView)localObject2).a()) {
        DoodleUtils.a((ViewGroup)localObject1);
      }
    }
    localObject2 = (ColorPickerView)((ViewGroup)localObject1).findViewById(2131373795);
    if (localObject2 != null)
    {
      ((ColorPickerView)localObject2).clearAnimation();
      ((ColorPickerView)localObject2).setVisibility(8);
      removeColorPickerView((ViewGroup)localObject1);
    }
    paramDoodleLogic.a.a(false);
    paramAVActivity.a.D(paramLong);
  }
  
  private static void removeColorPickerView(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131373795);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static void showDoodle(long paramLong, AVActivity paramAVActivity, DoodleLogic paramDoodleLogic)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("showDoodle, activity[");
      if (paramAVActivity != null)
      {
        bool = true;
        localObject = ((StringBuilder)localObject).append(bool).append("], logic[");
        if (paramDoodleLogic == null) {
          break label93;
        }
        bool = true;
        label48:
        QLog.w("Doodle", 2, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if ((paramAVActivity != null) && (paramDoodleLogic != null)) {
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
      localObject = (ViewGroup)paramAVActivity.findViewById(2131363187);
    } while (localObject == null);
    DoodleSurfaceView localDoodleSurfaceView = DoodleUtils.a((ViewGroup)localObject);
    if (localDoodleSurfaceView != null) {
      localDoodleSurfaceView.setClickable(true);
    }
    Object localObject = addColorPickerView((ViewGroup)localObject);
    if (localObject != null)
    {
      ((ColorPickerView)localObject).clearAnimation();
      ((ColorPickerView)localObject).setVisibility(0);
    }
    paramDoodleLogic.a.a(true);
    paramAVActivity.a.N();
  }
  
  public BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 3;
      this.mUIInfo.g = 2131559896;
      this.mUIInfo.f = 2130842184;
      this.mUIInfo.a = this.mApp.getApp().getString(2131695910);
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
        i = 2131695441;
      }
      while (i != 0)
      {
        return localAVActivity.getString(i);
        if (!localDoodleLogic.a()) {
          i = 2131695440;
        } else if (!localDoodleLogic.b) {
          i = 2131695439;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleToolbar
 * JD-Core Version:    0.7.0.1
 */