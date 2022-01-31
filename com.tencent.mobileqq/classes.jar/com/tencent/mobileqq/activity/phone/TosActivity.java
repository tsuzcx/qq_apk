package com.tencent.mobileqq.activity.phone;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ProtectedWebView;
import xbd;

public class TosActivity
  extends IphoneTitleBarActivity
{
  private ProtectedWebView a;
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = new ProtectedWebView(BaseApplicationImpl.sApplication);
    this.a.setFadingEdgeLength(0);
    if (VersionUtils.c()) {
      this.a.setOverScrollMode(2);
    }
    setContentView(this.a);
    removeWebViewLayerType();
    setTitle("服务声明");
    if (getIntent().getIntExtra("key_file", 1) == 2) {}
    paramBundle = getIntent();
    if (paramBundle != null) {
      if (paramBundle.getIntExtra("frombusiness", 1) == 0) {
        this.a.loadUrl("file:///android_asset/business_tos.html");
      }
    }
    for (;;)
    {
      this.a.setOnLongClickListener(new xbd(this));
      return true;
      this.a.loadUrl("file:///android_asset/phone_tos.html");
      continue;
      this.a.loadUrl("file:///android_asset/phone_tos.html");
    }
  }
  
  protected void doOnDestroy()
  {
    setContentView(new TextView(this));
    try
    {
      this.a.stopLoading();
      try
      {
        label19:
        this.a.clearView();
        try
        {
          label26:
          this.a.destroy();
          label33:
          super.doOnDestroy();
          return;
        }
        catch (Exception localException1)
        {
          break label33;
        }
      }
      catch (Exception localException2)
      {
        break label26;
      }
    }
    catch (Exception localException3)
    {
      break label19;
    }
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.TosActivity
 * JD-Core Version:    0.7.0.1
 */