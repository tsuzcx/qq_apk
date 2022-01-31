import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bdlt
  implements bdlu
{
  protected static final String TAG = "UIProxy";
  public Activity mActivity;
  protected Intent mIntent;
  protected MiniAppInfo mMiniAppInfo;
  protected ViewGroup mRootLayout;
  protected bdcw mRuntime;
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    bdnw.b("UIProxy", "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    bdel.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    bdnw.b("UIProxy", "onBackPressed");
    if (this.mRuntime != null) {}
    for (boolean bool = this.mRuntime.g();; bool = false)
    {
      if (bdli.a().a() != null) {
        bdli.a().a().notifyRuntimeEvent(25, new Object[0]);
      }
      return bool;
    }
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    bdnw.b("UIProxy", "onCreate");
    paramBundle = paramActivity.getWindow();
    if (paramBundle != null) {
      paramBundle.setSoftInputMode(18);
    }
    this.mActivity = paramActivity;
    this.mRootLayout = paramViewGroup;
    this.mIntent = paramActivity.getIntent();
    if (this.mIntent != null) {
      this.mMiniAppInfo = ((MiniAppInfo)this.mIntent.getParcelableExtra("KEY_APPINFO"));
    }
    bdle.a().a().onAppStart(this.mMiniAppInfo, null);
    bdsh.a();
  }
  
  public void onDestroy(Activity paramActivity)
  {
    bdnw.b("UIProxy", "onDestroy");
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
    if (bdli.a().a() != null) {
      bdli.a().a().notifyRuntimeEvent(62, new Object[0]);
    }
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    bdnw.b("UIProxy", "onNewIntent");
    this.mIntent = paramIntent;
    if (this.mIntent != null) {
      this.mMiniAppInfo = ((MiniAppInfo)this.mIntent.getParcelableExtra("KEY_APPINFO"));
    }
    bdsh.a();
  }
  
  public void onPause(Activity paramActivity)
  {
    bdnw.b("UIProxy", "onPause");
    if (this.mRuntime != null) {
      this.mRuntime.c();
    }
    if (bdli.a().a() != null) {
      bdli.a().a().notifyRuntimeEvent(24, new Object[0]);
    }
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdnw.b("UIProxy", "onRequestPermissionsResult requestCode=" + paramInt + " permissions=" + paramArrayOfString + "grantResults=" + paramArrayOfInt);
    bdel.a().a(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume(Activity paramActivity)
  {
    bdnw.b("UIProxy", "onResume");
    if (this.mRuntime != null) {
      this.mRuntime.a(this.mMiniAppInfo, false);
    }
    this.mIntent = null;
    bdle.a().a().onAppForeground(this.mMiniAppInfo, null);
    if (bdli.a().a() != null) {
      bdli.a().a().notifyRuntimeEvent(21, new Object[0]);
    }
  }
  
  public void onStart(Activity paramActivity)
  {
    bdnw.b("UIProxy", "onStart");
  }
  
  public void onStop(Activity paramActivity)
  {
    bdnw.b("UIProxy", "onStop");
    if (this.mRuntime != null) {
      this.mRuntime.d();
    }
    bdle.a().a().onAppBackground(this.mMiniAppInfo, null);
    if (bdli.a().a() != null) {
      bdli.a().a().notifyRuntimeEvent(22, new Object[0]);
    }
    bdli.a().a();
  }
  
  public void quit()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdlt
 * JD-Core Version:    0.7.0.1
 */