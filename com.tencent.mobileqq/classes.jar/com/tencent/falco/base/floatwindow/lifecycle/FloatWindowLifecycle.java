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
  private static int activityCount;
  
  private static void checkWhenResume(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Iterator localIterator = FWAppManager.INSTANCE.getFloatMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      FloatWindowConfig localFloatWindowConfig = ((FWAppOperator)((Map.Entry)localObject).getValue()).getConfig();
      localObject = (String)((Map.Entry)localObject).getKey();
      if (localFloatWindowConfig != null) {
        if ((localFloatWindowConfig.showPattern != 3) && (localFloatWindowConfig.showPattern != 1))
        {
          if (localFloatWindowConfig.needShow.booleanValue()) {
            setVisible(localFloatWindowConfig.filterList.contains(paramActivity.getComponentName().getClassName()) ^ true, (String)localObject);
          }
        }
        else {
          setVisible(false, (String)localObject);
        }
      }
    }
  }
  
  private static void checkWhenStop(Activity paramActivity)
  {
    if (isForeground()) {
      return;
    }
    Iterator localIterator = FWAppManager.INSTANCE.getFloatMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      FloatWindowConfig localFloatWindowConfig = ((FWAppOperator)((Map.Entry)localObject).getValue()).getConfig();
      localObject = (String)((Map.Entry)localObject).getKey();
      if (localFloatWindowConfig != null)
      {
        int i = localFloatWindowConfig.showPattern;
        boolean bool2 = false;
        if ((i == 1) && (!TextUtils.isEmpty(localFloatWindowConfig.currentActivityName)) && (!paramActivity.getComponentName().getClassName().equals(localFloatWindowConfig.currentActivityName))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          setVisible(false, (String)localObject);
          return;
        }
        boolean bool1 = bool2;
        if (localFloatWindowConfig.showPattern != 2)
        {
          bool1 = bool2;
          if (localFloatWindowConfig.needShow.booleanValue()) {
            bool1 = true;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkHide:");
        localStringBuilder.append(bool1);
        localStringBuilder.append("floatWindowConfig.needShow:");
        localStringBuilder.append(localFloatWindowConfig.needShow);
        Logger.d("FloatWindowLifecycle", localStringBuilder.toString());
        setVisible(bool1, (String)localObject);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.lifecycle.FloatWindowLifecycle
 * JD-Core Version:    0.7.0.1
 */