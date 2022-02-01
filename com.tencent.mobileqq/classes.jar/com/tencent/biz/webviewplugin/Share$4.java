package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class Share$4
  implements Runnable
{
  Share$4(Share paramShare, String paramString1, String paramString2, String paramString3, String paramString4, ApplicationInfo paramApplicationInfo) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = Share.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareMsgToSina download image:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    String str = ImageUtil.a(BaseApplication.getContext(), this.a, null);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = Share.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareMsgToSina path:");
      localStringBuilder.append(str);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (WBShareHelper.a(this.this$0.y))
    {
      WBShareHelper.a(2).a(this.this$0.y, this.b, this.c, this.d, " ", BitmapFactory.decodeFile(str));
      QLog.d(Share.a, 1, "shareMsgToSina use weibo sdk!");
    }
    else
    {
      localObject = new Intent("android.intent.action.SEND");
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setType("image/*");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(this.d);
      ((Intent)localObject).putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
      if (!TextUtils.isEmpty(str)) {
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
      }
      FileProvider7Helper.intentCompatForN(this.this$0.y, (Intent)localObject);
      ((Intent)localObject).setPackage(this.e.packageName);
      this.this$0.y.startActivity((Intent)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d(Share.a, 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.4
 * JD-Core Version:    0.7.0.1
 */