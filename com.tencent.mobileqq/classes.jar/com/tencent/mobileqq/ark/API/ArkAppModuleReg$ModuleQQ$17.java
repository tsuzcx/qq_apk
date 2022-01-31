package com.tencent.mobileqq.ark.API;

import android.content.Intent;
import android.os.Bundle;
import anfv;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;

public class ArkAppModuleReg$ModuleQQ$17
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$17(anfv paramanfv, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent = new Intent(localBaseActivity, TroopAvatarWallPreviewActivity.class);
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
    localBaseActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.17
 * JD-Core Version:    0.7.0.1
 */