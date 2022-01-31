package com.tencent.mobileqq.activity.emogroupstore;

import afup;
import android.app.Activity;
import android.content.Intent;

public class SDKEmotionSettingManager$7
  implements Runnable
{
  public SDKEmotionSettingManager$7(afup paramafup) {}
  
  public void run()
  {
    if (afup.a(this.this$0).isFinishing()) {
      return;
    }
    afup.a(this.this$0).sendBroadcast(new Intent("com.tencent.mobileqq.action.refresh.emotiom"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7
 * JD-Core Version:    0.7.0.1
 */