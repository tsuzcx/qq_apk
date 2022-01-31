import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.BaseUIProxy.2;
import com.tencent.qqmini.sdk.launcher.BaseUIProxy.3;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class bepy
  implements beqe
{
  protected static final String TAG = "UIProxy";
  protected bepv mActivatedRuntimeLoader;
  public Activity mActivity;
  protected Handler mMainHandler;
  public MiniAppInfo mMiniAppInfo;
  public ViewGroup mRootLayout;
  public begw mRuntime;
  
  private bepx createRuntimeLoaderListener()
  {
    return new bepz(this);
  }
  
  private MiniAppInfo getMiniAppInfoFromIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (this.mMiniAppInfo != null)
      {
        beyu.a(this.mMiniAppInfo, "1", null, "load_fail", "start_no_intent");
        bexz.a("2launch_fail", "start_no_intent", null, this.mMiniAppInfo);
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
    besl.c("UIProxy", "handleNewIntent. Do nothing, mini app info is null");
    return null;
  }
  
  private void start(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      besl.d("UIProxy", "Failed to start. miniAppInfo is null");
    }
    bepv localbepv;
    do
    {
      return;
      localbepv = bepo.a().a(paramMiniAppInfo);
      if (localbepv == null) {
        break;
      }
      besl.b("UIProxy", "start.Resume the existing runtime of existing runtime loader = " + localbepv);
    } while (!localbepv.isLoadSucceed());
    resumeRuntime(localbepv);
    return;
    showLoading(paramMiniAppInfo);
    beyr.a(paramMiniAppInfo, 1013, "1");
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mActivatedRuntimeLoader = bepo.a().a(paramMiniAppInfo, createRuntimeLoaderListener(), paramBundle);
    besl.b("UIProxy", "start.Create a new runtime loader = " + this.mActivatedRuntimeLoader);
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  protected begw getRuntime()
  {
    return this.mRuntime;
  }
  
  protected abstract void hideLoading();
  
  /* Error */
  protected boolean isRuntimeLoaderValid(bepv parambepv)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 135	bepy:mActivatedRuntimeLoader	Lbepv;
    //   8: ifnonnull +12 -> 20
    //   11: aload_0
    //   12: aload_1
    //   13: putfield 135	bepy:mActivatedRuntimeLoader	Lbepv;
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_2
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 135	bepy:mActivatedRuntimeLoader	Lbepv;
    //   24: aload_1
    //   25: if_acmpeq -9 -> 16
    //   28: ldc 10
    //   30: new 92	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   37: ldc 148
    //   39: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 75	besl:c	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	62	0	this	bepy
    //   0	62	1	parambepv	bepv
    //   1	53	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	16	57	finally
    //   20	52	57	finally
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    besl.b("UIProxy", "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    beil.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    besl.b("UIProxy", "onBackPressed");
    if (this.mRuntime != null) {}
    for (boolean bool = this.mRuntime.g();; bool = false)
    {
      bepo.a().a(25, new Object[0]);
      return bool;
    }
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    besl.b("UIProxy", "onCreate");
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
    bepk.a().a().onAppStart(paramBundle, null);
    beye.a();
  }
  
  public void onDestroy(Activity paramActivity)
  {
    besl.b("UIProxy", "onDestroy");
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
    if (bepo.a().a() != null) {
      bepo.a().a().notifyRuntimeEvent(62, new Object[0]);
    }
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    besl.b("UIProxy", "onNewIntent");
    start(getMiniAppInfoFromIntent(paramIntent), paramIntent.getExtras());
    beye.a();
  }
  
  public void onPause(Activity paramActivity)
  {
    besl.b("UIProxy", "onPause");
    if (this.mRuntime != null) {
      this.mRuntime.c();
    }
    if (bepo.a().a() != null) {
      bepo.a().a().notifyRuntimeEvent(24, new Object[0]);
    }
    betg.b(paramActivity, this.mMiniAppInfo);
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    besl.b("UIProxy", "onRequestPermissionsResult requestCode=" + paramInt + " permissions=" + paramArrayOfString + "grantResults=" + paramArrayOfInt);
    beil.a().a(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume(Activity paramActivity)
  {
    besl.b("UIProxy", "onResume");
    if (this.mRuntime != null) {
      this.mRuntime.a(this.mMiniAppInfo, false);
    }
    bepk.a().a().onAppForeground(this.mMiniAppInfo, null);
    if (bepo.a().a() != null) {
      bepo.a().a().notifyRuntimeEvent(21, new Object[0]);
    }
    betg.a(paramActivity, this.mMiniAppInfo);
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    besl.d("UIProxy", "onRuntimeFail. Whoops, failed to load the runtime, retCode = " + paramInt + ", msg = " + paramString);
    bemw.a(MiniAppEnv.g().getContext(), "加载失败 retCode=" + paramInt + " " + paramString, 0).a();
    this.mMainHandler.postDelayed(new BaseUIProxy.3(this), 1000L);
  }
  
  protected void onRuntimeReady()
  {
    besl.b("UIProxy", "onRuntimeReady. Here we go, start the runtime lifecycle");
    this.mMiniAppInfo = this.mActivatedRuntimeLoader.getMiniAppInfo();
    this.mRuntime = this.mActivatedRuntimeLoader.getRuntime();
    this.mMainHandler.post(new BaseUIProxy.2(this));
  }
  
  public void onStart(Activity paramActivity)
  {
    besl.b("UIProxy", "onStart");
  }
  
  public void onStop(Activity paramActivity)
  {
    besl.b("UIProxy", "onStop");
    if (this.mRuntime != null) {
      this.mRuntime.d();
    }
    bepk.a().a().onAppBackground(this.mMiniAppInfo, null);
    if (bepo.a().a() != null) {
      bepo.a().a().notifyRuntimeEvent(22, new Object[0]);
    }
    bepo.a().a();
  }
  
  public void quit()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  protected void resumeRuntime(bepv parambepv)
  {
    if (this.mActivity == null) {
      besl.c("UIProxy", "Failed to resumeRuntime. Activity is null");
    }
    do
    {
      return;
      if (!isRuntimeLoaderValid(parambepv))
      {
        besl.c("UIProxy", "Failed to resumeRuntime. runtime loader is valid");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepy
 * JD-Core Version:    0.7.0.1
 */