package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.Intent;
import aopk;
import aoqa;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;

public class ArkAppQQModule$20
  implements Runnable
{
  public ArkAppQQModule$20(aoqa paramaoqa, int paramInt, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    String str = ArkEnvironmentManager.getInstance().getAppResPath(this.this$0.jdField_a_of_type_JavaLangString);
    Activity localActivity = aopk.a();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_a_of_type_Int);
      localIntent.putExtra("enter_from", 3);
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      localIntent.putExtra("key_ark_app_res_path", str);
      localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_ark_app_engine_res_dir", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localActivity.startActivity(localIntent);
      return;
    }
    QLog.i("ArkApp", 1, "QQ.ChooseImage top activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.20
 * JD-Core Version:    0.7.0.1
 */