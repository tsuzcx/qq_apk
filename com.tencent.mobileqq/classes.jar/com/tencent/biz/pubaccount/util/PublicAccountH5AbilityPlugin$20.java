package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bbac;
import bbms;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import mpo;
import rsv;
import vvp;

public class PublicAccountH5AbilityPlugin$20
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$20(rsv paramrsv, String paramString, Bundle paramBundle, bbms parambbms) {}
  
  public void run()
  {
    Object localObject = mpo.a(this.this$0.mRuntime.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    int i;
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
    {
      i = 1;
      if (i != 0)
      {
        this.this$0.a.post(new PublicAccountH5AbilityPlugin.20.1(this));
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
        i = 2131655008;
        if (i == -1) {
          break label168;
        }
        vvp.a(0, i);
        localObject = new Intent(this.this$0.mRuntime.a(), PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("url", "http://weixin.qq.com/download");
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
        i = 2131655009;
        continue;
        label168:
        WXShareHelper.a().a(localOutOfMemoryError, localBitmap, 1, true);
        return;
        label179:
        vvp.a(1, 2131629908);
      }
      else
      {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.20
 * JD-Core Version:    0.7.0.1
 */