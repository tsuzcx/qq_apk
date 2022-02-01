package com.tencent.av.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;

public class DoodleController
{
  private static ColorPickerView a(ViewGroup paramViewGroup, AVActivity paramAVActivity)
  {
    ColorPickerView localColorPickerView2 = (ColorPickerView)paramViewGroup.findViewById(2131441040);
    ColorPickerView localColorPickerView1 = localColorPickerView2;
    if (localColorPickerView2 == null)
    {
      localColorPickerView1 = new ColorPickerView(paramViewGroup.getContext());
      localColorPickerView1.setOnCancelClickListener(new DoodleController.1(paramAVActivity));
      paramAVActivity = paramViewGroup.getResources();
      int i = paramAVActivity.getDimensionPixelOffset(2131298393);
      int j = paramAVActivity.getDimensionPixelOffset(2131298382);
      int k = paramAVActivity.getDimensionPixelOffset(2131298383);
      paramAVActivity = new RelativeLayout.LayoutParams(i, j);
      paramAVActivity.setMargins(0, k, 0, 0);
      paramAVActivity.addRule(11);
      paramViewGroup.addView(localColorPickerView1, paramAVActivity);
    }
    return localColorPickerView1;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext != null)
    {
      int i = b();
      if (i != 0) {
        return paramContext.getString(i);
      }
    }
    return "";
  }
  
  public static void a(long paramLong, AVActivity paramAVActivity)
  {
    DoodleLogic localDoodleLogic = DoodleLogic.b();
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
      if (localDoodleLogic != null) {
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
      if (localDoodleLogic == null) {
        return;
      }
      localObject = (ViewGroup)paramAVActivity.findViewById(2131428980);
      if (localObject != null)
      {
        View localView = DoodleUtils.a((ViewGroup)localObject);
        if (localView != null) {
          localView.setClickable(true);
        }
        paramAVActivity = a((ViewGroup)localObject, paramAVActivity);
        paramAVActivity.clearAnimation();
        paramAVActivity.setVisibility(0);
        localDoodleLogic.m.a(true);
      }
    }
  }
  
  private static void a(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131441040);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static boolean a()
  {
    DoodleLogic localDoodleLogic = DoodleLogic.b();
    return (DoodleUtils.a()) && (localDoodleLogic.k) && (localDoodleLogic.g());
  }
  
  public static int b()
  {
    DoodleLogic localDoodleLogic = DoodleLogic.b();
    if (!DoodleUtils.a()) {
      return 2131893201;
    }
    if (!localDoodleLogic.g()) {
      return 2131893200;
    }
    if (!localDoodleLogic.k) {
      return 2131893199;
    }
    return 0;
  }
  
  public static void b(long paramLong, AVActivity paramAVActivity)
  {
    DoodleLogic localDoodleLogic = DoodleLogic.b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideDoodle, activity[");
      boolean bool2 = true;
      boolean bool1;
      if (paramAVActivity != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], logic[");
      if (localDoodleLogic != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("Doodle", 2, ((StringBuilder)localObject).toString());
    }
    if (paramAVActivity != null)
    {
      if (localDoodleLogic == null) {
        return;
      }
      paramAVActivity = (ViewGroup)paramAVActivity.findViewById(2131428980);
      if (paramAVActivity != null)
      {
        localObject = (DoodleSurfaceView)paramAVActivity.findViewById(2131441050);
        if (localObject != null)
        {
          ((DoodleSurfaceView)localObject).setClickable(false);
          if (!((DoodleSurfaceView)localObject).getRunning()) {
            DoodleUtils.b(paramAVActivity);
          }
        }
        localObject = (ColorPickerView)paramAVActivity.findViewById(2131441040);
        if (localObject != null)
        {
          ((ColorPickerView)localObject).clearAnimation();
          ((ColorPickerView)localObject).setVisibility(8);
          a(paramAVActivity);
        }
        localDoodleLogic.m.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleController
 * JD-Core Version:    0.7.0.1
 */