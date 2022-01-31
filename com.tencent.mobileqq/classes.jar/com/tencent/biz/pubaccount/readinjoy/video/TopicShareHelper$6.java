package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nap;
import onk;
import qko;

public class TopicShareHelper$6
  implements Runnable
{
  public TopicShareHelper$6(qko paramqko, String paramString1, String paramString2, String paramString3, ApplicationInfo paramApplicationInfo, Activity paramActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina download image:" + this.jdField_a_of_type_JavaLangString);
    }
    String str = nap.a(qko.a(this.this$0), this.jdField_a_of_type_JavaLangString, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina path:" + str);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.b + this.c);
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
    }
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    if (qko.a(this.this$0) != null) {}
    for (int i = qko.a(this.this$0).mChannelID;; i = 0)
    {
      localIntent.putExtra("big_brother_source_key", onk.f(i));
      FileProvider7Helper.intentCompatForN(this.jdField_a_of_type_AndroidAppActivity, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TopicShareHelper.6.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina start weibo!");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.6
 * JD-Core Version:    0.7.0.1
 */