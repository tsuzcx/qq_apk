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

public abstract class beqp
  implements beqv
{
  protected static final String TAG = "UIProxy";
  protected beqm mActivatedRuntimeLoader;
  public Activity mActivity;
  protected Handler mMainHandler;
  public MiniAppInfo mMiniAppInfo;
  public ViewGroup mRootLayout;
  public behn mRuntime;
  
  private beqo createRuntimeLoaderListener()
  {
    return new beqq(this);
  }
  
  private MiniAppInfo getMiniAppInfoFromIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (this.mMiniAppInfo != null)
      {
        bezl.a(this.mMiniAppInfo, "1", null, "load_fail", "start_no_intent");
        beyq.a("2launch_fail", "start_no_intent", null, this.mMiniAppInfo);
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
    betc.c("UIProxy", "handleNewIntent. Do nothing, mini app info is null");
    return null;
  }
  
  private void start(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      betc.d("UIProxy", "Failed to start. miniAppInfo is null");
    }
    beqm localbeqm;
    do
    {
      return;
      localbeqm = beqf.a().a(paramMiniAppInfo);
      if (localbeqm == null) {
        break;
      }
      betc.b("UIProxy", "start.Resume the existing runtime of existing runtime loader = " + localbeqm);
    } while (!localbeqm.isLoadSucceed());
    resumeRuntime(localbeqm);
    return;
    showLoading(paramMiniAppInfo);
    bezi.a(paramMiniAppInfo, 1013, "1");
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mActivatedRuntimeLoader = beqf.a().a(paramMiniAppInfo, createRuntimeLoaderListener(), paramBundle);
    betc.b("UIProxy", "start.Create a new runtime loader = " + this.mActivatedRuntimeLoader);
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  protected behn getRuntime()
  {
    return this.mRuntime;
  }
  
  protected abstract void hideLoading();
  
  /* Error */
  protected boolean isRuntimeLoaderValid(beqm parambeqm)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 135	beqp:mActivatedRuntimeLoader	Lbeqm;
    //   8: ifnonnull +12 -> 20
    //   11: aload_0
    //   12: aload_1
    //   13: putfield 135	beqp:mActivatedRuntimeLoader	Lbeqm;
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_2
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 135	beqp:mActivatedRuntimeLoader	Lbeqm;
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
    //   49: invokestatic 75	betc:c	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	62	0	this	beqp
    //   0	62	1	parambeqm	beqm
    //   1	53	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	16	57	finally
    //   20	52	57	finally
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    betc.b("UIProxy", "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    bejc.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    betc.b("UIProxy", "onBackPressed");
    if (this.mRuntime != null) {}
    for (boolean bool = this.mRuntime.g();; bool = false)
    {
      beqf.a().a(25, new Object[0]);
      return bool;
    }
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    betc.b("UIProxy", "onCreate");
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
    beqb.a().a().onAppStart(paramBundle, null);
    beyv.a();
  }
  
  public void onDestroy(Activity paramActivity)
  {
    betc.b("UIProxy", "onDestroy");
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
    if (beqf.a().a() != null) {
      beqf.a().a().notifyRuntimeEvent(62, new Object[0]);
    }
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    betc.b("UIProxy", "onNewIntent");
    start(getMiniAppInfoFromIntent(paramIntent), paramIntent.getExtras());
    beyv.a();
  }
  
  public void onPause(Activity paramActivity)
  {
    betc.b("UIProxy", "onPause");
    if (this.mRuntime != null) {
      this.mRuntime.c();
    }
    if (beqf.a().a() != null) {
      beqf.a().a().notifyRuntimeEvent(24, new Object[0]);
    }
    betx.b(paramActivity, this.mMiniAppInfo);
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    betc.b("UIProxy", "onRequestPermissionsResult requestCode=" + paramInt + " permissions=" + paramArrayOfString + "grantResults=" + paramArrayOfInt);
    bejc.a().a(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume(Activity paramActivity)
  {
    betc.b("UIProxy", "onResume");
    if (this.mRuntime != null) {
      this.mRuntime.a(this.mMiniAppInfo, false);
    }
    beqb.a().a().onAppForeground(this.mMiniAppInfo, null);
    if (beqf.a().a() != null) {
      beqf.a().a().notifyRuntimeEvent(21, new Object[0]);
    }
    betx.a(paramActivity, this.mMiniAppInfo);
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    betc.d("UIProxy", "onRuntimeFail. Whoops, failed to load the runtime, retCode = " + paramInt + ", msg = " + paramString);
    benn.a(MiniAppEnv.g().getContext(), "加载失败 retCode=" + paramInt + " " + paramString, 0).a();
    this.mMainHandler.postDelayed(new BaseUIProxy.3(this), 1000L);
  }
  
  protected void onRuntimeReady()
  {
    betc.b("UIProxy", "onRuntimeReady. Here we go, start the runtime lifecycle");
    this.mMiniAppInfo = this.mActivatedRuntimeLoader.getMiniAppInfo();
    this.mRuntime = this.mActivatedRuntimeLoader.getRuntime();
    this.mMainHandler.post(new BaseUIProxy.2(this));
  }
  
  public void onStart(Activity paramActivity)
  {
    betc.b("UIProxy", "onStart");
  }
  
  public void onStop(Activity paramActivity)
  {
    betc.b("UIProxy", "onStop");
    if (this.mRuntime != null) {
      this.mRuntime.d();
    }
    beqb.a().a().onAppBackground(this.mMiniAppInfo, null);
    if (beqf.a().a() != null) {
      beqf.a().a().notifyRuntimeEvent(22, new Object[0]);
    }
    beqf.a().a();
  }
  
  public void quit()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  protected void resumeRuntime(beqm parambeqm)
  {
    if (this.mActivity == null) {
      betc.c("UIProxy", "Failed to resumeRuntime. Activity is null");
    }
    do
    {
      return;
      if (!isRuntimeLoaderValid(parambeqm))
      {
        betc.c("UIProxy", "Failed to resumeRuntime. runtime loader is valid");
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
 * Qualified Name:     beqp
 * JD-Core Version:    0.7.0.1
 */