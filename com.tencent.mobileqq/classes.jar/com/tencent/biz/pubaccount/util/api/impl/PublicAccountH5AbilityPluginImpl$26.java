package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class PublicAccountH5AbilityPluginImpl$26
  implements Runnable
{
  PublicAccountH5AbilityPluginImpl$26(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString, Bundle paramBundle, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    Object localObject = ImageUtil.a(this.this$0.mRuntime.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      i = 1;
      if (i != 0)
      {
        PublicAccountH5AbilityPluginImpl.access$100(this.this$0).post(new PublicAccountH5AbilityPluginImpl.26.1(this));
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label179;
        }
      }
    }
    for (;;)
    {
      Bitmap localBitmap;
      try
      {
        localBitmap = BitmapFactory.decodeFile((String)localObject);
        if (WXShareHelper.a().a()) {
          break label153;
        }
        i = 2131720753;
        if (i == -1) {
          break label168;
        }
        QRUtils.a(0, i);
        localObject = new Intent(this.this$0.mRuntime.a(), PublicAccountBrowserImpl.class);
        ((Intent)localObject).putExtra("url", "https://weixin.qq.com/download");
        this.this$0.mRuntime.a().startActivity((Intent)localObject);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      i = 0;
      break;
      label153:
      if (!WXShareHelper.a().b())
      {
        i = 2131720754;
        continue;
        label168:
        WXShareHelper.a().a(localOutOfMemoryError, localBitmap, 1, true);
        return;
        label179:
        QRUtils.a(1, 2131695244);
      }
      else
      {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.26
 * JD-Core Version:    0.7.0.1
 */