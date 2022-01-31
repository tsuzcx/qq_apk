package com.tencent.mobileqq.activity;

import android.content.Intent;
import baev;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import zzc;

public class ArkFullScreenAppActivity$8$1
  implements Runnable
{
  public ArkFullScreenAppActivity$8$1(zzc paramzzc) {}
  
  public void run()
  {
    Intent localIntent = this.a.a.a(ArkFullScreenAppActivity.a(this.a.a).a);
    ArkAppCenter.a().postToMainThread(new ArkFullScreenAppActivity.8.1.1(this, localIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1
 * JD-Core Version:    0.7.0.1
 */