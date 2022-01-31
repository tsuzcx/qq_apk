package com.example.tissue;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.qqmini.sdk.core.IAppBrandRuntime;
import com.tencent.qqmini.sdk.core.MiniAppFactory;
import com.tencent.qqmini.sdk.core.utils.SpeedUtil;
import com.tencent.tissue.miniapp.V8JsService;
import com.tencent.tissue.v8rt.engine.Util;

public class MiniAppActivity
  extends Activity
{
  private static final int REQUEST_WRITE_STORAGE = 112;
  IAppBrandRuntime appBrandRuntime;
  ViewGroup layout;
  V8JsService v8JsService;
  
  private void checkAndLoadApkg()
  {
    if ((Util.SDK_INT >= 23) && (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (Util.SDK_INT >= 23) {
        requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" }, 112);
      }
      return;
    }
    loadApkg();
  }
  
  private void loadApkg()
  {
    SpeedUtil.DEFAULT.clear();
    SpeedUtil.DEFAULT.event("createAppRuntime start");
    this.v8JsService = new V8JsService(getApplicationContext());
    this.appBrandRuntime = MiniAppFactory.createAppRuntime(this, this.v8JsService);
    this.appBrandRuntime.onAppAttachWindow(this, this.layout);
    SpeedUtil.DEFAULT.event("loadApkg start");
    this.appBrandRuntime.loadMiniApp("miniapp/myvideo.qapkg", null);
    SpeedUtil.DEFAULT.event("loadApkg finish");
  }
  
  public void onBackPressed()
  {
    if (!this.appBrandRuntime.onBackPress()) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    this.layout = ((ViewGroup)findViewById(2130837509));
    checkAndLoadApkg();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.v8JsService.release();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.appBrandRuntime.onBackPress()) {
        return true;
      }
      super.onBackPressed();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 112)
    {
      if ((paramArrayOfInt[0] != 0) || (paramArrayOfInt[1] != 0)) {
        break label30;
      }
      loadApkg();
    }
    for (;;)
    {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
      label30:
      Toast.makeText(this, "您拒绝了授权", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MiniAppActivity
 * JD-Core Version:    0.7.0.1
 */