package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.qcircleshadow.local.fragment.QCircleHostTransFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.concurrent.CopyOnWriteArrayList;

public class HostUIHelper
{
  public static final String KEY_IS_AUTO_CLOSE_HOST = "key_is_auto_close_host";
  private static final String TAG = "HostUIHelper";
  private static Context mCurrentContext;
  private static CopyOnWriteArrayList<HostUIHelper.HostEnvironmentLifeCycle> mListeners = new CopyOnWriteArrayList();
  private static Context mShadowTopContext;
  private static HostUIHelper sInstance;
  private final Context mHostApplicationContext;
  
  private HostUIHelper(Context paramContext)
  {
    this.mHostApplicationContext = paramContext;
  }
  
  public static boolean closeHostEnvironment()
  {
    if (isHostEnvironment(mCurrentContext))
    {
      getLifeCycleListeners().clear();
      ((Activity)mCurrentContext).finish();
      mShadowTopContext = null;
      return true;
    }
    return false;
  }
  
  public static HostUIHelper getInstance()
  {
    return sInstance;
  }
  
  private static CopyOnWriteArrayList<HostUIHelper.HostEnvironmentLifeCycle> getLifeCycleListeners()
  {
    if (mListeners == null) {
      mListeners = new CopyOnWriteArrayList();
    }
    return mListeners;
  }
  
  public static Context getShadowTopContext()
  {
    return mShadowTopContext;
  }
  
  public static void init(Context paramContext)
  {
    sInstance = new HostUIHelper(paramContext);
    BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(new HostUIHelper.1());
  }
  
  private static boolean isHostEnvironment(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if ((paramContext instanceof PublicTransFragmentActivity))
      {
        boolean bool3 = ((PublicTransFragmentActivity)paramContext).getIntent().getStringExtra("public_fragment_class").equals(QCircleHostTransFragment.class.getCanonicalName());
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static void openHostEnvironment(HostUIHelper.HostEnvironmentLifeCycle paramHostEnvironmentLifeCycle)
  {
    openHostEnvironment(paramHostEnvironmentLifeCycle, null);
  }
  
  public static void openHostEnvironment(HostUIHelper.HostEnvironmentLifeCycle paramHostEnvironmentLifeCycle, Intent paramIntent)
  {
    if (paramHostEnvironmentLifeCycle == null) {}
    do
    {
      return;
      if (!getLifeCycleListeners().contains(paramHostEnvironmentLifeCycle)) {
        getLifeCycleListeners().add(paramHostEnvironmentLifeCycle);
      }
      if (!isHostEnvironment(mCurrentContext))
      {
        mShadowTopContext = mCurrentContext;
        paramHostEnvironmentLifeCycle = paramIntent;
        if (paramIntent == null) {
          paramHostEnvironmentLifeCycle = new Intent();
        }
        paramHostEnvironmentLifeCycle.addFlags(268435456);
        paramHostEnvironmentLifeCycle.setClass(BaseApplicationImpl.getContext(), PublicTransFragmentActivity.class);
        paramHostEnvironmentLifeCycle.putExtra("public_fragment_class", QCircleHostTransFragment.class.getCanonicalName());
        paramHostEnvironmentLifeCycle.putExtra("public_fragment_window_feature", 1);
        BaseApplicationImpl.getContext().startActivity(paramHostEnvironmentLifeCycle);
        return;
      }
    } while (mCurrentContext == null);
    paramHostEnvironmentLifeCycle.onEnvironmentCreated(mCurrentContext);
    paramHostEnvironmentLifeCycle.onEnvironmentStarted(mCurrentContext);
    paramHostEnvironmentLifeCycle.onEnvironmentResume(mCurrentContext);
  }
  
  private static void registerDaTongReport(Activity paramActivity)
  {
    VideoReport.addToDetectionWhitelist(paramActivity);
    VideoReport.setPageId(paramActivity, "small_world_base");
    VideoReport.setPageParams(paramActivity, new QCircleDTParamBuilder().setPageSubclass("HostUIHelper").buildPageParams());
    QLog.i("HostUIHelper", 1, "reportDaTongRegister  subPage: HostUIHelper");
  }
  
  public Context getCurrentContext()
  {
    return mCurrentContext;
  }
  
  public Context getHostApplicationContext()
  {
    return this.mHostApplicationContext;
  }
  
  public int getHostLayoutId(String paramString)
  {
    return this.mHostApplicationContext.getResources().getIdentifier(paramString, "layout", this.mHostApplicationContext.getPackageName());
  }
  
  public int getHostResourceId(String paramString1, String paramString2)
  {
    return this.mHostApplicationContext.getResources().getIdentifier(paramString2, paramString1, this.mHostApplicationContext.getPackageName());
  }
  
  public int getHostString(String paramString)
  {
    return this.mHostApplicationContext.getResources().getIdentifier(paramString, "string", this.mHostApplicationContext.getPackageName());
  }
  
  public View getHostView(String paramString)
  {
    return LayoutInflater.from(this.mHostApplicationContext).inflate(getHostLayoutId(paramString), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostUIHelper
 * JD-Core Version:    0.7.0.1
 */