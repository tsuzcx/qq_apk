package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkAppQQModule$17
  implements Runnable
{
  ArkAppQQModule$17(ArkAppQQModule paramArkAppQQModule, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    Activity localActivity = ArkAppQQModuleBase.f();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, TroopAvatarWallPreviewActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("index", this.a);
      localBundle.putStringArrayList("seqNum", this.b);
      localBundle.putBoolean("needBottomBar", false);
      localBundle.putBoolean("IS_EDIT", false);
      localBundle.putBoolean("is_use_path", true);
      localBundle.putBoolean("is_show_action", true);
      localBundle.putBoolean("is_not_show_index", false);
      localBundle.putBoolean("is_index_show_bottom", true);
      localIntent.putExtras(localBundle);
      localActivity.startActivity(localIntent);
      return;
    }
    QLog.i("ArkApp", 1, "QQ.PreviewImage top activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.17
 * JD-Core Version:    0.7.0.1
 */