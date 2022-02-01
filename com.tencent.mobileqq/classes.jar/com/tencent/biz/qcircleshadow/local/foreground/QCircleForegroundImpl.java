package com.tencent.biz.qcircleshadow.local.foreground;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.IForeground;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class QCircleForegroundImpl
  implements IForeground
{
  private static final String TAG = "QCircleForegroundImpl";
  WeakReference<Activity> mActivity;
  
  public QCircleForegroundImpl()
  {
    updateRuntime();
  }
  
  public void onCreate(Context paramContext)
  {
    AppRuntime localAppRuntime = updateRuntime();
    QLog.d("QCircleForegroundImpl", 2, "onCreate context = " + paramContext);
    Foreground.updateRuntimeState(localAppRuntime);
    if ((paramContext instanceof Activity)) {
      this.mActivity = new WeakReference((Activity)paramContext);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("QCircleForegroundImpl", 2, "onDestroy runtime = ");
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity != null) {
      Foreground.onDestroy(localActivity);
    }
  }
  
  public void onPause()
  {
    AppRuntime localAppRuntime = updateRuntime();
    QLog.d("QCircleForegroundImpl", 2, "onPause mActivity = " + this.mActivity);
    Foreground.onPause(localAppRuntime);
  }
  
  public void onResume()
  {
    AppRuntime localAppRuntime = updateRuntime();
    QLog.d("QCircleForegroundImpl", 2, "onResume mActivity = " + this.mActivity);
    Foreground.onResume(localAppRuntime);
  }
  
  public void onStart()
  {
    AppRuntime localAppRuntime = updateRuntime();
    QLog.d("QCircleForegroundImpl", 2, "onStart mActivity = " + this.mActivity);
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity != null) {
      Foreground.onStart(localAppRuntime, localActivity);
    }
  }
  
  public void onStop()
  {
    AppRuntime localAppRuntime = updateRuntime();
    QLog.d("QCircleForegroundImpl", 2, "onStop runtime = " + localAppRuntime);
    Foreground.onStop(localAppRuntime);
  }
  
  protected void startUnlockActivity()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.context, GesturePWDUnlockActivity.class);
    BaseApplicationImpl.context.startActivity(localIntent);
  }
  
  public AppRuntime updateRuntime()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.foreground.QCircleForegroundImpl
 * JD-Core Version:    0.7.0.1
 */