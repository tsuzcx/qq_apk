package com.huawei.hms.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BridgeActivity$a
  implements View.OnApplyWindowInsetsListener
{
  public BridgeActivity$a(BridgeActivity paramBridgeActivity, ViewGroup paramViewGroup) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    try
    {
      Object localObject1 = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
      localObject1 = ((Class)localObject1).getMethod("getDisplaySideRegion", new Class[] { WindowInsets.class }).invoke(null, new Object[] { paramWindowInsets });
      if (localObject1 == null)
      {
        HMSLog.i("BridgeActivity", "sideRegion is null");
      }
      else
      {
        localObject2 = Class.forName("com.huawei.android.view.DisplaySideRegionEx");
        localObject1 = (Rect)((Class)localObject2).getMethod("getSafeInsets", new Class[0]).invoke(localObject1, new Object[0]);
        if (this.a != null) {
          this.a.setPadding(((Rect)localObject1).left, 0, ((Rect)localObject1).right, 0);
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException) {}catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}catch (InvocationTargetException localInvocationTargetException) {}
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("An exception occurred while reading: onApplyWindowInsets");
    ((StringBuilder)localObject2).append(localInvocationTargetException.getMessage());
    HMSLog.e("BridgeActivity", ((StringBuilder)localObject2).toString());
    return paramView.onApplyWindowInsets(paramWindowInsets);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.activity.BridgeActivity.a
 * JD-Core Version:    0.7.0.1
 */