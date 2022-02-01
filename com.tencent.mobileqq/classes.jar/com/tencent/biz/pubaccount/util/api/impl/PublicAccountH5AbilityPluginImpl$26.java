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
    Object localObject1 = ImageUtil.a(this.this$0.mRuntime.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    int i;
    if ((localObject2 != null) && (((QQProgressDialog)localObject2).isShowing())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      PublicAccountH5AbilityPluginImpl.access$100(this.this$0).post(new PublicAccountH5AbilityPluginImpl.26.1(this));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          if (!WXShareHelper.a().a()) {
            i = 2131720478;
          } else if (!WXShareHelper.a().b()) {
            i = 2131720479;
          } else {
            i = -1;
          }
          if (i != -1)
          {
            QRUtils.a(0, i);
            localObject1 = new Intent(this.this$0.mRuntime.a(), PublicAccountBrowserImpl.class);
            ((Intent)localObject1).putExtra("url", "https://weixin.qq.com/download");
            this.this$0.mRuntime.a().startActivity((Intent)localObject1);
            return;
          }
          WXShareHelper.a().a((String)localObject1, (Bitmap)localObject2, 1, true);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          return;
        }
      }
      QRUtils.a(1, 2131695240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.26
 * JD-Core Version:    0.7.0.1
 */