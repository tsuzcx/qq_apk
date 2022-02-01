package com.tencent.av.doodle;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class DoodleUtils
{
  public static boolean a = false;
  
  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
  
  public static int a(int[] paramArrayOfInt, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return paramArrayOfInt[0];
    }
    if (paramFloat >= 1.0F) {
      return paramArrayOfInt[(paramArrayOfInt.length - 1)];
    }
    paramFloat *= (paramArrayOfInt.length - 1);
    int j = (int)paramFloat;
    paramFloat -= j;
    int i = paramArrayOfInt[j];
    j = paramArrayOfInt[(j + 1)];
    return Color.argb(a(Color.alpha(i), Color.alpha(j), paramFloat), a(Color.red(i), Color.red(j), paramFloat), a(Color.green(i), Color.green(j), paramFloat), a(Color.blue(i), Color.blue(j), paramFloat));
  }
  
  public static View a(ViewGroup paramViewGroup)
  {
    Object localObject2 = paramViewGroup.findViewById(2131441050);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ((IDoodleApi)QRoute.api(IDoodleApi.class)).createDoodleSurfaceView(paramViewGroup.getContext());
      int i = -1;
      localObject2 = new ViewGroup.LayoutParams(-1, -1);
      View localView = paramViewGroup.findViewById(2131441334);
      if (localView != null) {
        i = paramViewGroup.indexOfChild(localView);
      }
      paramViewGroup.addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject2);
    }
    return localObject1;
  }
  
  public static DoodleItem a(int paramInt)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        localObject = new LineDoodleItem();
      } else {
        localObject = new PathParticleDoodleItem(2130968658);
      }
    }
    else {
      localObject = new LineDoodleItem();
    }
    ((DoodleItem)localObject).b = paramInt;
    return localObject;
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
  
  public static void b(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131441050);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static boolean b()
  {
    int i = VcSystemInfo.getNumCores();
    StringBuilder localStringBuilder;
    if (i < 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error cpucount = ");
      localStringBuilder.append(i);
      AVLog.printColorLog("DoodleUtils", localStringBuilder.toString());
      return false;
    }
    long l = VcSystemInfo.getMaxCpuFreq();
    if (l < 1400000L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error cpuFrequency = ");
      localStringBuilder.append(l);
      AVLog.printColorLog("DoodleUtils", localStringBuilder.toString());
      return false;
    }
    l = DeviceInfoUtil.a();
    if (l < 1073741824L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice error memory = ");
      localStringBuilder.append(l);
      AVLog.printColorLog("DoodleUtils", localStringBuilder.toString());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleUtils
 * JD-Core Version:    0.7.0.1
 */