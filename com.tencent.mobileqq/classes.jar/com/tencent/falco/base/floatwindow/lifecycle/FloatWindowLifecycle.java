package com.tencent.falco.base.floatwindow.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.text.TextUtils;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.utils.Logger;
import com.tencent.falco.base.floatwindow.widget.appfloat.FWAppManager;
import com.tencent.falco.base.floatwindow.widget.appfloat.FWAppOperator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class FloatWindowLifecycle
{
  private static final String TAG = "FloatWindowLifecycle";
  private static int activityCount = 0;
  
  private static void checkWhenResume(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Iterator localIterator = FWAppManager.INSTANCE.getFloatMap().entrySet().iterator();
    label22:
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      FloatWindowConfig localFloatWindowConfig = ((FWAppOperator)((Map.Entry)localObject).getValue()).getConfig();
      localObject = (String)((Map.Entry)localObject).getKey();
      if (localFloatWindowConfig != null) {
        if ((localFloatWindowConfig.showPattern == 3) || (localFloatWindowConfig.showPattern == 1)) {
          setVisible(false, (String)localObject);
        } else if (localFloatWindowConfig.needShow.booleanValue()) {
          if (localFloatWindowConfig.filterList.contains(paramActivity.getComponentName().getClassName())) {
            break label135;
          }
        }
      }
    }
    label135:
    for (boolean bool = true;; bool = false)
    {
      setVisible(bool, (String)localObject);
      break label22;
      break;
    }
  }
  
  private static void checkWhenStop(Activity paramActivity)
  {
    if (isForeground()) {
      return;
    }
    Iterator localIterator = FWAppManager.INSTANCE.getFloatMap().entrySet().iterator();
    label24:
    Object localObject;
    FloatWindowConfig localFloatWindowConfig;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      localFloatWindowConfig = ((FWAppOperator)((Map.Entry)localObject).getValue()).getConfig();
      localObject = (String)((Map.Entry)localObject).getKey();
      if (localFloatWindowConfig != null)
      {
        if ((localFloatWindowConfig.showPattern == 1) && (!TextUtils.isEmpty(localFloatWindowConfig.currentActivityName)) && (!paramActivity.getComponentName().getClassName().equals(localFloatWindowConfig.currentActivityName))) {}
        for (int i = 1; i != 0; i = 0)
        {
          setVisible(false, (String)localObject);
          return;
        }
        if ((localFloatWindowConfig.showPattern == 2) || (!localFloatWindowConfig.needShow.booleanValue())) {
          break label200;
        }
      }
    }
    label200:
    for (boolean bool = true;; bool = false)
    {
      Logger.d("FloatWindowLifecycle", "checkHide:" + bool + "floatWindowConfig.needShow:" + localFloatWindowConfig.needShow);
      setVisible(bool, (String)localObject);
      break label24;
      break;
    }
  }
  
  public static boolean isForeground()
  {
    return activityCount > 0;
  }
  
  public static void setLifecycleCallbacks(@NotNull Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new FloatWindowLifecycle.1());
  }
  
  private static void setVisible(boolean paramBoolean, String paramString)
  {
    FWAppManager.INSTANCE.visible(paramBoolean, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.lifecycle.FloatWindowLifecycle
 * JD-Core Version:    0.7.0.1
 */