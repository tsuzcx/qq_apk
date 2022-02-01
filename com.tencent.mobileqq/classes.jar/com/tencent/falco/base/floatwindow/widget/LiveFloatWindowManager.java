package com.tencent.falco.base.floatwindow.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.utils.ListUtil;
import com.tencent.falco.base.floatwindow.widget.activityfloat.FWActivityManager;
import com.tencent.falco.base.floatwindow.widget.appfloat.FWAppManager;
import com.tencent.falco.base.floatwindow.widget.appfloat.FWAppOperator;
import com.tencent.falco.base.floatwindow.widget.appfloat.ParentFrameLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class LiveFloatWindowManager
{
  private static LiveFloatWindowManager instance;
  @Nullable
  private WeakReference<Activity> activityWr;
  private boolean isDebug = false;
  public boolean isInitialized = true;
  
  private FloatWindowConfig getConfig(String paramString)
  {
    paramString = FWAppManager.INSTANCE.getAppFloatManager(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getConfig();
  }
  
  private ArrayList<String> getFilterSet(String paramString)
  {
    paramString = getConfig(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.filterList;
  }
  
  public static LiveFloatWindowManager getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new LiveFloatWindowManager();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private FWActivityManager manager(@Nullable Activity paramActivity)
  {
    if (paramActivity != null) {
      return new FWActivityManager(paramActivity);
    }
    paramActivity = this.activityWr;
    if ((paramActivity != null) && (paramActivity.get() != null)) {
      return new FWActivityManager((Activity)this.activityWr.get());
    }
    return null;
  }
  
  public void appFloatDragEnable(boolean paramBoolean)
  {
    appFloatDragEnable(paramBoolean, null);
  }
  
  public void appFloatDragEnable(boolean paramBoolean, @Nullable String paramString)
  {
    paramString = getConfig(paramString);
    if (paramString != null) {
      paramString.dragEnable = paramBoolean;
    }
  }
  
  public boolean appFloatIsShow()
  {
    return appFloatIsShow(null);
  }
  
  public boolean appFloatIsShow(@Nullable String paramString)
  {
    paramString = getConfig(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isShow;
  }
  
  public void dismiss()
  {
    dismiss(null, null);
  }
  
  public void dismiss(@Nullable Activity paramActivity)
  {
    dismiss(paramActivity, null);
  }
  
  public void dismiss(@Nullable Activity paramActivity, @Nullable String paramString)
  {
    paramActivity = manager(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.dismiss(paramString);
  }
  
  public void dismiss(@Nullable String paramString)
  {
    dismiss(null, paramString);
  }
  
  public void dismissAppFloat()
  {
    dismissAppFloat(null);
  }
  
  public void dismissAppFloat(@Nullable String paramString)
  {
    FWAppManager.INSTANCE.dismiss(paramString);
  }
  
  public void filterActivity(@NotNull Activity paramActivity)
  {
    filterActivity(paramActivity, null);
  }
  
  public void filterActivity(@NotNull Activity paramActivity, @Nullable String paramString)
  {
    paramString = getFilterSet(paramString);
    if (ListUtil.isEmpty(paramString)) {
      return;
    }
    paramString.add(paramActivity.getComponentName().getClassName());
  }
  
  public View getAppFloatView()
  {
    return getAppFloatView(null);
  }
  
  public View getAppFloatView(@Nullable String paramString)
  {
    paramString = getConfig(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.layoutView;
  }
  
  public View getFloatView()
  {
    return getFloatView(null, null);
  }
  
  public View getFloatView(@Nullable Activity paramActivity)
  {
    return getFloatView(paramActivity, null);
  }
  
  public View getFloatView(@Nullable Activity paramActivity, @Nullable String paramString)
  {
    paramActivity = manager(paramActivity);
    if (paramActivity == null) {
      return null;
    }
    return paramActivity.getFloatView(paramString);
  }
  
  public View getFloatView(@Nullable String paramString)
  {
    return getFloatView(null, paramString);
  }
  
  public WindowManager.LayoutParams getParams(String paramString)
  {
    paramString = FWAppManager.INSTANCE.getAppFloatManager(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getParams();
  }
  
  public int getWidth(String paramString)
  {
    paramString = FWAppManager.INSTANCE.getAppFloatManager(paramString);
    if ((paramString != null) && (paramString.getFrameLayout() != null)) {
      return paramString.getFrameLayout().getWidth();
    }
    return 0;
  }
  
  public void hide()
  {
    hide(null, null);
  }
  
  public void hide(@Nullable Activity paramActivity)
  {
    hide(paramActivity, null);
  }
  
  public void hide(@Nullable Activity paramActivity, @Nullable String paramString)
  {
    paramActivity = manager(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setVisibility(paramString, 8);
  }
  
  public void hide(@Nullable String paramString)
  {
    hide(null, paramString);
  }
  
  public void hideAppFloat()
  {
    hideAppFloat(null);
  }
  
  public void hideAppFloat(@Nullable String paramString)
  {
    FWAppManager.INSTANCE.visible(false, paramString, false);
  }
  
  public boolean isShow()
  {
    return isShow(null, null);
  }
  
  public boolean isShow(@Nullable Activity paramActivity)
  {
    return isShow(paramActivity, null);
  }
  
  public boolean isShow(@Nullable Activity paramActivity, @Nullable String paramString)
  {
    paramActivity = manager(paramActivity);
    if (paramActivity == null) {
      return false;
    }
    return paramActivity.isShow(paramString);
  }
  
  public boolean isShow(@Nullable String paramString)
  {
    return isShow(null, paramString);
  }
  
  public void removeFilter(@NotNull Activity paramActivity)
  {
    removeFilter(paramActivity, null);
  }
  
  public void removeFilter(@NotNull Activity paramActivity, @Nullable String paramString)
  {
    paramString = getFilterSet(paramString);
    if (ListUtil.isEmpty(paramString)) {
      return;
    }
    paramString.remove(paramActivity.getComponentName().getClassName());
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.isDebug = paramBoolean;
  }
  
  public void setDragEnable(@Nullable Activity paramActivity, boolean paramBoolean)
  {
    setDragEnable(paramActivity, paramBoolean, null);
  }
  
  public void setDragEnable(@Nullable Activity paramActivity, boolean paramBoolean, @Nullable String paramString)
  {
    paramActivity = manager(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setDragEnable(paramBoolean, paramString);
  }
  
  public void setDragEnable(boolean paramBoolean)
  {
    setDragEnable(null, paramBoolean, null);
  }
  
  public void setDragEnable(boolean paramBoolean, @Nullable String paramString)
  {
    setDragEnable(null, paramBoolean, paramString);
  }
  
  public void show()
  {
    show(null, null);
  }
  
  public void show(@Nullable Activity paramActivity)
  {
    show(paramActivity, null);
  }
  
  public void show(@Nullable Activity paramActivity, @Nullable String paramString)
  {
    paramActivity = manager(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setVisibility(paramString, 0);
  }
  
  public void show(@Nullable String paramString)
  {
    show(null, paramString);
  }
  
  public void showAppFloat()
  {
    showAppFloat(null);
  }
  
  public void showAppFloat(@Nullable String paramString)
  {
    FWAppManager.INSTANCE.visible(true, paramString, true);
  }
  
  public void updateParams(String paramString, WindowManager.LayoutParams paramLayoutParams)
  {
    paramString = FWAppManager.INSTANCE.getAppFloatManager(paramString);
    if (paramString == null) {
      return;
    }
    paramString.updateWindowParams(paramLayoutParams);
  }
  
  public LiveFloatWindow with(@NotNull Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      this.activityWr = new WeakReference((Activity)paramContext);
    }
    return new LiveFloatWindow(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.LiveFloatWindowManager
 * JD-Core Version:    0.7.0.1
 */