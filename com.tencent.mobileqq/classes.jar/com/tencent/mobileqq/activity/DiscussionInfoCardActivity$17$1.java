package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

class DiscussionInfoCardActivity$17$1
  implements Runnable
{
  DiscussionInfoCardActivity$17$1(DiscussionInfoCardActivity.17 param17, String paramString) {}
  
  public void run()
  {
    if (this.this$0.b.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.a))
    {
      QQToast.makeText(this.this$0.b, 1, 2131914169, 0).show(this.this$0.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(this.a)) {
      ((ArrayList)localObject).add(this.a);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.this$0.d);
    localBundle.putString("desc", "");
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.this$0.c);
    localBundle.putStringArrayList("image_url", (ArrayList)localObject);
    QZoneShareManager.jumpToQzoneShare(this.this$0.e, this.this$0.b, localBundle, null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareToQzone.title:");
      ((StringBuilder)localObject).append(this.this$0.d);
      ((StringBuilder)localObject).append(" filePath:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" shareLink:");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append(" desc:");
      ((StringBuilder)localObject).append("");
      QLog.i("DiscussionInfoCardActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.17.1
 * JD-Core Version:    0.7.0.1
 */