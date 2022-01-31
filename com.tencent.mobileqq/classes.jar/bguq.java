import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.BaseUIProxy.2;
import com.tencent.qqmini.sdk.launcher.BaseUIProxy.3;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.log.QMLog;

public abstract class bguq
  implements IUIProxy
{
  protected static final String TAG = "UIProxy";
  private static volatile boolean mIgnorePreload;
  protected bgun mActivatedRuntimeLoader;
  public Activity mActivity;
  protected Handler mMainHandler;
  public MiniAppInfo mMiniAppInfo;
  public ViewGroup mRootLayout;
  public bgls mRuntime;
  
  private bgup createRuntimeLoaderListener()
  {
    return new bgur(this);
  }
  
  public static final boolean shouldIgnorePreload()
  {
    return mIgnorePreload;
  }
  
  private void start(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      QMLog.e("UIProxy", "Failed to start. miniAppInfo is null");
    }
    do
    {
      return;
      mIgnorePreload = true;
      bgun localbgun = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
      if (localbgun == null) {
        break;
      }
      QMLog.i("UIProxy", "start().Resume the existing runtime of existing runtime loader = " + localbgun);
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(20, new Object[0]);
      if ((!paramMiniAppInfo.isShortcutFakeApp()) && (!paramMiniAppInfo.isFakeAppInfo())) {
        this.mMiniAppInfo = paramMiniAppInfo;
      }
      if (localbgun.isLoadSucceed()) {
        resumeRuntime(localbgun);
      }
      this.mMiniAppInfo.dump();
    } while ((this.mMiniAppInfo == null) || (TextUtils.isEmpty(this.mMiniAppInfo.appId)));
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("start_mode", 3);; i = 3)
    {
      if (i != 3) {
        break label279;
      }
      bhbu.d(this.mMiniAppInfo.appId, false);
      return;
      showLoading(paramMiniAppInfo);
      bhck.a(paramMiniAppInfo, 1013, "1");
      this.mMiniAppInfo = paramMiniAppInfo;
      this.mActivatedRuntimeLoader = AppRuntimeLoaderManager.g().createAppRuntimeLoader(paramMiniAppInfo, createRuntimeLoaderListener(), paramBundle);
      QMLog.i("UIProxy", "start(). Create a new runtime loader = " + this.mActivatedRuntimeLoader);
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(20, new Object[0]);
      if (!paramMiniAppInfo.isEngineTypeMiniApp()) {
        break;
      }
      QMLog.i("UIProxy", "start(). Start " + this.mActivatedRuntimeLoader);
      this.mActivatedRuntimeLoader.start();
      break;
    }
    label279:
    bhbu.d(this.mMiniAppInfo.appId, true);
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  protected MiniAppInfo getMiniAppInfoFromIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (this.mMiniAppInfo != null)
      {
        bhcn.a(this.mMiniAppInfo, "1", null, "load_fail", "start_no_intent");
        bhbs.a("2launch_fail", "start_no_intent", null, this.mMiniAppInfo);
      }
      paramIntent = null;
    }
    MiniAppInfo localMiniAppInfo;
    do
    {
      return paramIntent;
      localMiniAppInfo = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
      paramIntent = localMiniAppInfo;
    } while (localMiniAppInfo != null);
    QMLog.w("UIProxy", "handleNewIntent. Do nothing, mini app info is null");
    return null;
  }
  
  protected bgls getRuntime()
  {
    return this.mRuntime;
  }
  
  protected abstract void hideLoading();
  
  /* Error */
  protected boolean isRuntimeLoaderValid(bgun parambgun)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 148	bguq:mActivatedRuntimeLoader	Lbgun;
    //   8: ifnonnull +12 -> 20
    //   11: aload_0
    //   12: aload_1
    //   13: putfield 148	bguq:mActivatedRuntimeLoader	Lbgun;
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_2
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 148	bguq:mActivatedRuntimeLoader	Lbgun;
    //   24: aload_1
    //   25: if_acmpeq -9 -> 16
    //   28: ldc 10
    //   30: new 62	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   37: ldc 199
    //   39: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 190	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore_2
    //   54: goto -38 -> 16
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	bguq
    //   0	62	1	parambgun	bgun
    //   1	53	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	16	57	finally
    //   20	52	57	finally
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.i("UIProxy", "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    bgnk.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onBackPressed");
    if (this.mRuntime != null) {}
    for (boolean bool = this.mRuntime.d();; bool = false)
    {
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(25, new Object[0]);
      return bool;
    }
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    QMLog.i("UIProxy", "onCreate " + this + ", pid:" + Process.myPid());
    paramBundle = paramActivity.getWindow();
    if (paramBundle != null) {
      paramBundle.setSoftInputMode(18);
    }
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.mActivity = paramActivity;
    this.mRootLayout = paramViewGroup;
    paramActivity = paramActivity.getIntent();
    paramBundle = getMiniAppInfoFromIntent(paramActivity);
    start(paramBundle, paramActivity.getExtras());
    AppLoaderFactory.g().getAppBrandProxy().onAppStart(paramBundle, null);
    bhbx.a();
  }
  
  public void onDestroy(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onDestroy");
    if (this.mActivity == paramActivity)
    {
      this.mActivity = null;
      this.mRootLayout = null;
      if (this.mRuntime != null)
      {
        this.mRuntime.e();
        this.mRuntime.a(paramActivity);
      }
    }
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(62, new Object[0]);
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    QMLog.i("UIProxy", "onNewIntent");
    start(getMiniAppInfoFromIntent(paramIntent), paramIntent.getExtras());
    bhbx.a();
  }
  
  public void onPause(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onPause");
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(24, new Object[0]);
    bgwl.b(paramActivity, this.mMiniAppInfo);
    if (this.mRuntime != null) {
      this.mRuntime.c();
    }
  }
  
  public void onRefreshMiniBadge(Activity paramActivity, Bundle paramBundle)
  {
    QMLog.i("UIProxy", "onRefreshMiniBadge");
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
      QMLog.e("UIProxy", "Failed to refreshMiniBadge, runtime or miniappinfo is null");
    }
    for (;;)
    {
      return;
      if (paramBundle != null)
      {
        paramActivity = paramBundle.getString("KEY_APPID");
        if (QMLog.isColorLevel()) {
          QMLog.d("TAG", "onRefreshMiniBadge appID : " + paramActivity);
        }
        if (!this.mRuntime.a().appId.equals(paramActivity)) {
          break;
        }
        int i = paramBundle.getInt("KEY_BADGE_COUNT");
        if (QMLog.isColorLevel()) {
          QMLog.e("UIProxy", "onRefreshMiniBadge badge : " + i);
        }
        paramActivity = this.mRuntime.a();
        if (paramActivity != null) {}
        for (paramActivity = paramActivity.a(); paramActivity != null; paramActivity = null)
        {
          paramActivity.setUnReadCount(i, false);
          return;
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QMLog.i("UIProxy", "onRequestPermissionsResult requestCode=" + paramInt + " permissions=" + paramArrayOfString + "grantResults=" + paramArrayOfInt);
    bgnk.a().a(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onResume");
    if (this.mRuntime != null) {
      this.mRuntime.a(this.mMiniAppInfo, false);
    }
    AppLoaderFactory.g().getAppBrandProxy().onAppForeground(this.mMiniAppInfo, null);
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(21, new Object[0]);
    bgwl.a(paramActivity, this.mMiniAppInfo);
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    QMLog.e("UIProxy", "onRuntimeFail. Whoops, failed to load the runtime, retCode = " + paramInt + ", msg = " + paramString);
    this.mMainHandler.postDelayed(new BaseUIProxy.3(this, paramInt, paramString), 1000L);
  }
  
  protected void onRuntimeReady()
  {
    QMLog.i("UIProxy", "onRuntimeReady. Here we go, start the runtime lifecycle");
    this.mMiniAppInfo = this.mActivatedRuntimeLoader.getMiniAppInfo();
    this.mRuntime = this.mActivatedRuntimeLoader.getRuntime();
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      this.mRuntime.a(this.mActivity, this.mRootLayout);
      this.mRuntime.a(this.mMiniAppInfo, null);
      this.mRuntime.a(this.mMiniAppInfo, false);
      return;
    }
    this.mMainHandler.post(new BaseUIProxy.2(this));
  }
  
  public void onStart(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onStart");
  }
  
  public void onStop(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onStop");
    if (this.mRuntime != null) {
      this.mRuntime.d();
    }
    AppLoaderFactory.g().getAppBrandProxy().onAppBackground(this.mMiniAppInfo, null);
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(22, new Object[0]);
    AppRuntimeLoaderManager.g().preloadRuntime();
  }
  
  public void quit()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  protected void resumeRuntime(bgun parambgun)
  {
    if (this.mActivity == null) {
      QMLog.w("UIProxy", "Failed to resumeRuntime. Activity is null");
    }
    do
    {
      return;
      if (!isRuntimeLoaderValid(parambgun))
      {
        QMLog.w("UIProxy", "Failed to resumeRuntime. runtime loader is valid");
        return;
      }
      this.mMiniAppInfo = this.mActivatedRuntimeLoader.getMiniAppInfo();
      this.mRuntime = this.mActivatedRuntimeLoader.getRuntime();
      hideLoading();
    } while (this.mRuntime == null);
    this.mRuntime.a(this.mActivity, this.mRootLayout);
  }
  
  protected abstract void showLoading(MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguq
 * JD-Core Version:    0.7.0.1
 */