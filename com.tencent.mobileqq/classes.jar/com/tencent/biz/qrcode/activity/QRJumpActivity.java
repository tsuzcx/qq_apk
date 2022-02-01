package com.tencent.biz.qrcode.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import bjbs;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLDecoder;
import mqq.app.NewIntent;
import zvq;
import zxa;
import zxb;

public class QRJumpActivity
  extends BaseActivity
{
  protected bjbs a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent().getStringExtra("url");
    String str3 = super.getIntent().getStringExtra("attr_original_url");
    if (TextUtils.isEmpty(paramBundle))
    {
      finish();
      return false;
    }
    if (isFinishing()) {
      return false;
    }
    this.a = new bjbs(this, super.getTitleBarHeight());
    this.a.c(2131715973);
    this.a.setOnCancelListener(new zxa(this));
    this.a.show();
    String str1;
    try
    {
      str1 = URLDecoder.decode(paramBundle);
      if (TextUtils.isEmpty(str1))
      {
        finish();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("QRJumpActivity", 1, "QRJumpActivity doOnCreate URLDecoder.decode error:" + paramBundle.getMessage());
        str1 = null;
      }
      paramBundle = Uri.parse(str1);
      if (!paramBundle.isHierarchical())
      {
        finish();
        return false;
      }
      if (paramBundle != null) {
        break label336;
      }
    }
    Object localObject1 = null;
    int i;
    if (!TextUtils.isEmpty(str3)) {
      if (str3.startsWith("mqqopensdkapi://bizAgent/"))
      {
        paramBundle = "authSig";
        i = 1;
        label199:
        if (i == 0) {}
      }
    }
    for (;;)
    {
      try
      {
        str2 = URLDecoder.decode(str3);
        localUri = Uri.parse(str2);
        if (str2 == null) {
          paramBundle = localObject2;
        }
      }
      catch (Exception paramBundle)
      {
        String str2;
        Uri localUri;
        label336:
        paramBundle = null;
        continue;
      }
      try
      {
        str2 = URLDecoder.decode(paramBundle);
        paramBundle = str2;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRJumpActivity", 2, String.format("JumpUrl authSig=%s oriUrl=%s", new Object[] { paramBundle, str3 }));
      }
      paramBundle = new zxb(this, (String)localObject1, paramBundle, this, str1);
      localObject1 = new NewIntent(this, zvq.class);
      ((NewIntent)localObject1).putExtra("d", str1);
      ((NewIntent)localObject1).putExtra("cmd", "QRCodeSvc.decode");
      ((NewIntent)localObject1).putExtra("bqq", "1");
      ((NewIntent)localObject1).setObserver(paramBundle);
      this.app.startServlet((NewIntent)localObject1);
      return true;
      localObject1 = paramBundle.getQueryParameter("auth");
      break;
      str2 = str3;
      continue;
      paramBundle = localUri.getQueryParameter(paramBundle);
      continue;
      paramBundle = "authKey";
      i = 0;
      break label199;
      paramBundle = null;
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRJumpActivity
 * JD-Core Version:    0.7.0.1
 */