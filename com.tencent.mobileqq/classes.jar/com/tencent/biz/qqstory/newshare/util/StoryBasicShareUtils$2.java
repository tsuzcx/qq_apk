package com.tencent.biz.qqstory.newshare.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.callback.StoryShareCallback;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;
import mqq.os.MqqHandler;

final class StoryBasicShareUtils$2
  implements Runnable
{
  StoryBasicShareUtils$2(ApplicationInfo paramApplicationInfo, ShareSinaData paramShareSinaData, Context paramContext, StoryShareCallback paramStoryShareCallback) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setPackage(this.a.packageName);
    localIntent.setType("image/*");
    localIntent.setFlags(268435456);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.a);
    localStringBuilder.append(this.b.f);
    localIntent.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
    if (!TextUtils.isEmpty(this.b.g)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.b.g)));
    }
    FileProvider7Helper.intentCompatForN(this.c, localIntent);
    this.c.startActivity(localIntent);
    ThreadManager.getUIHandler().post(new StoryBasicShareUtils.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils.2
 * JD-Core Version:    0.7.0.1
 */