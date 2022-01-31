package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import bbms;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.app.NewIntent;
import vsq;
import vtt;
import vtu;

public class QRJumpActivity
  extends BaseActivity
{
  protected bbms a;
  
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
    this.a = new bbms(this, super.getTitleBarHeight());
    this.a.c(2131651451);
    this.a.setOnCancelListener(new vtt(this));
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
      paramBundle = new vtu(this, (String)localObject1, paramBundle, this, str1);
      localObject1 = new NewIntent(this, vsq.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRJumpActivity
 * JD-Core Version:    0.7.0.1
 */