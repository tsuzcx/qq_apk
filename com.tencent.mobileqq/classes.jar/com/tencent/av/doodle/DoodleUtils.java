package com.tencent.av.doodle;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class DoodleUtils
{
  public static boolean a;
  
  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  public static int a(int[] paramArrayOfInt, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return paramArrayOfInt[0];
    }
    if (paramFloat >= 1.0F) {
      return paramArrayOfInt[(paramArrayOfInt.length - 1)];
    }
    paramFloat = (paramArrayOfInt.length - 1) * paramFloat;
    int j = (int)paramFloat;
    paramFloat -= j;
    int i = paramArrayOfInt[j];
    j = paramArrayOfInt[(j + 1)];
    return Color.argb(a(Color.alpha(i), Color.alpha(j), paramFloat), a(Color.red(i), Color.red(j), paramFloat), a(Color.green(i), Color.green(j), paramFloat), a(Color.blue(i), Color.blue(j), paramFloat));
  }
  
  public static DoodleItem a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      localObject = new LineDoodleItem();
    }
    for (;;)
    {
      ((DoodleItem)localObject).a = paramInt;
      return localObject;
      localObject = new LineDoodleItem();
      continue;
      localObject = new PathParticleDoodleItem(2131296345);
    }
  }
  
  public static DoodleSurfaceView a(ViewGroup paramViewGroup)
  {
    Object localObject2 = (DoodleSurfaceView)paramViewGroup.findViewById(2131362514);
    Object localObject1 = localObject2;
    View localView;
    if (localObject2 == null)
    {
      localObject1 = new DoodleSurfaceView(paramViewGroup.getContext());
      localObject2 = new ViewGroup.LayoutParams(-1, -1);
      localView = paramViewGroup.findViewById(2131362516);
      if (localView == null) {
        break label67;
      }
    }
    label67:
    for (int i = paramViewGroup.indexOfChild(localView);; i = -1)
    {
      paramViewGroup.addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject2);
      return localObject1;
    }
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131362514);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    if (!b()) {
      return false;
    }
    a = true;
    return a;
  }
  
  public static boolean b()
  {
    int i = VcSystemInfo.e();
    if (i < 4)
    {
      AVLog.c("DoodleUtils", "isSupportOfDevice error cpucount = " + i);
      return false;
    }
    long l = VcSystemInfo.c();
    if (l < 1400000L)
    {
      AVLog.c("DoodleUtils", "isSupportOfDevice error cpuFrequency = " + l);
      return false;
    }
    l = DeviceInfoUtil.e();
    if (l < 1073741824L)
    {
      AVLog.c("DoodleUtils", "isSupportOfDevice error memory = " + l);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleUtils
 * JD-Core Version:    0.7.0.1
 */