package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import apvx;
import apwn;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;

public class ArkAppQQModule$17
  implements Runnable
{
  public ArkAppQQModule$17(apwn paramapwn, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    Activity localActivity = apvx.a();
    Intent localIntent = new Intent(localActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", this.jdField_a_of_type_Int);
    localBundle.putStringArrayList("seqNum", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putBoolean("needBottomBar", false);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", false);
    localBundle.putBoolean("is_index_show_bottom", true);
    localIntent.putExtras(localBundle);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.17
 * JD-Core Version:    0.7.0.1
 */