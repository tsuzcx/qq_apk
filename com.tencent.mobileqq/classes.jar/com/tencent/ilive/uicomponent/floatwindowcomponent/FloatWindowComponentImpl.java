package com.tencent.ilive.uicomponent.floatwindowcomponent;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.falco.base.floatwindow.widget.LiveFloatWindow;
import com.tencent.falco.base.floatwindow.widget.LiveFloatWindowManager;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.uicomponent.UIBaseComponent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback;

public class FloatWindowComponentImpl
  extends UIBaseComponent
  implements ThreadCenter.HandlerKeyable, FloatWindowComponent
{
  private Activity activity;
  private int dismissExt;
  private FloatWindowHandleCallback floatWindowHandleCallback;
  private boolean isCalledShow = false;
  private boolean isDragEnd = true;
  private boolean isReallyShow = false;
  Runnable loacationRunnable = new FloatWindowComponentImpl.3(this);
  long showTime = 0L;
  private final String tag = "FloatWindowComponentImpl";
  
  public void dismiss(int paramInt)
  {
    this.dismissExt = paramInt;
    LiveFloatWindowManager.getInstance().dismissAppFloat("FloatWindowComponentImpl");
    this.isCalledShow = false;
    ThreadCenter.removeUITask(this, this.loacationRunnable);
  }
  
  public long getShowTime()
  {
    return this.showTime;
  }
  
  public void init(@NonNull Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      this.activity = ((Activity)paramContext);
    }
  }
  
  public boolean isCalledShow()
  {
    return this.isCalledShow;
  }
  
  public boolean isDragEnd()
  {
    return this.isDragEnd;
  }
  
  public boolean isReallyShow()
  {
    return this.isReallyShow;
  }
  
  public void onCreate(View paramView) {}
  
  public void onDestroy()
  {
    this.floatWindowHandleCallback = null;
    ThreadCenter.clear(this);
  }
  
  @NonNull
  public void setHandleCallback(@NonNull FloatWindowHandleCallback paramFloatWindowHandleCallback)
  {
    this.floatWindowHandleCallback = paramFloatWindowHandleCallback;
  }
  
  public void show(int paramInt)
  {
    Activity localActivity = this.activity;
    if (localActivity == null) {
      return;
    }
    this.isCalledShow = true;
    int i = UIUtil.dp2px(localActivity, -12.0F);
    int j = UIUtil.dp2px(this.activity, -100.0F);
    int k = UIUtil.dp2px(this.activity, 12.0F);
    int m = UIUtil.dp2px(this.activity, 12.0F);
    LiveFloatWindowManager.getInstance().with(this.activity).setTag("FloatWindowComponentImpl").setVerticalMargin(k).setHorizontalMargin(m).setShowPattern(4).setSidePattern(16).setGravity(8388693, i, j).setLayout(paramInt, new FloatWindowComponentImpl.2(this)).registerCallbacks(new FloatWindowComponentImpl.1(this)).show();
    ThreadCenter.postUITask(this, this.loacationRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.floatwindowcomponent.FloatWindowComponentImpl
 * JD-Core Version:    0.7.0.1
 */