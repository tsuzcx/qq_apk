package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.Intent;
import apih;
import apix;
import apoh;
import aufz;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;

public class ArkAppQQModule$11
  implements Runnable
{
  public ArkAppQQModule$11(apix paramapix, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Activity localActivity = apih.a();
    if (localActivity != null)
    {
      Intent localIntent = ArkFullScreenAppActivity.a(localActivity, this.a, this.this$0.a, this.b, this.c, apoh.a());
      if (localIntent != null) {
        aufz.a(localActivity, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.11
 * JD-Core Version:    0.7.0.1
 */