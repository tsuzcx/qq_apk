package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class IntimateInfoShareHelper$6$1
  implements Runnable
{
  IntimateInfoShareHelper$6$1(IntimateInfoShareHelper.6 param6, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.a)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(this.b);
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      IntimateInfoShareHelper.e(this.c.this$0).sendBroadcast(localIntent);
      QQToast.makeText(IntimateInfoShareHelper.e(this.c.this$0), 2, IntimateInfoShareHelper.e(this.c.this$0).getString(2131892639), 1).show(IntimateInfoShareHelper.e(this.c.this$0).getTitleBarHeight());
      return;
    }
    QQToast.makeText(IntimateInfoShareHelper.e(this.c.this$0), 1, IntimateInfoShareHelper.e(this.c.this$0).getString(2131892638), 1).show(IntimateInfoShareHelper.e(this.c.this$0).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6.1
 * JD-Core Version:    0.7.0.1
 */