package com.tencent.biz.qqstory.channel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import java.net.URI;

public class QQStoryCmdMonitor
{
  private boolean a = false;
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return;
    }
    paramString1 = Uri.parse(paramString1.toURI().toString());
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramString1, paramString2);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdMonitor
 * JD-Core Version:    0.7.0.1
 */