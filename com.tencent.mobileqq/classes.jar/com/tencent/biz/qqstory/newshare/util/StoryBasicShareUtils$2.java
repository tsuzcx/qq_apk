package com.tencent.biz.qqstory.newshare.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;
import mqq.os.MqqHandler;
import tpl;
import trs;

public final class StoryBasicShareUtils$2
  implements Runnable
{
  public StoryBasicShareUtils$2(ApplicationInfo paramApplicationInfo, trs paramtrs, Context paramContext, tpl paramtpl) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    localIntent.setType("image/*");
    localIntent.setFlags(268435456);
    localIntent.putExtra("android.intent.extra.TEXT", this.jdField_a_of_type_Trs.a + this.jdField_a_of_type_Trs.c);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Trs.d)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_a_of_type_Trs.d)));
    }
    FileProvider7Helper.intentCompatForN(this.jdField_a_of_type_AndroidContentContext, localIntent);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ThreadManager.getUIHandler().post(new StoryBasicShareUtils.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils.2
 * JD-Core Version:    0.7.0.1
 */