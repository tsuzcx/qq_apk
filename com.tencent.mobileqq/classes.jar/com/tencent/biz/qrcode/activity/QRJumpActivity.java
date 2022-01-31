package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.net.URLDecoder;
import mqq.app.NewIntent;
import osk;
import osl;

public class QRJumpActivity
  extends BaseActivity
{
  protected QQProgressDialog a;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent().getStringExtra("url");
    if (TextUtils.isEmpty(paramBundle)) {
      finish();
    }
    while (isFinishing()) {
      return false;
    }
    this.a = new QQProgressDialog(this, super.getTitleBarHeight());
    this.a.c(2131429995);
    this.a.setOnCancelListener(new osk(this));
    this.a.show();
    String str = URLDecoder.decode(paramBundle);
    paramBundle = Uri.parse(str);
    if (!paramBundle.isHierarchical())
    {
      finish();
      return false;
    }
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getQueryParameter("auth"))
    {
      paramBundle = new osl(this, paramBundle, this, str);
      NewIntent localNewIntent = new NewIntent(this, QRCodeServlet.class);
      localNewIntent.putExtra("d", str);
      localNewIntent.putExtra("cmd", "QRCodeSvc.decode");
      localNewIntent.putExtra("bqq", "1");
      localNewIntent.setObserver(paramBundle);
      this.app.startServlet(localNewIntent);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRJumpActivity
 * JD-Core Version:    0.7.0.1
 */