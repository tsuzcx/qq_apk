package com.tencent.mobileqq.ark.API;

import alpe;
import android.content.Intent;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppModuleReg$ModuleQQ$20
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$20(alpe paramalpe, int paramInt, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    String str = ArkEnvironmentManager.getInstance().getAppResPath(this.this$0.jdField_a_of_type_JavaLangString);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent = new Intent(localBaseActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_a_of_type_Int);
    localIntent.putExtra("enter_from", 3);
    localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
    localIntent.putExtra("key_ark_app_res_path", str);
    localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("key_ark_app_engine_res_dir", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localBaseActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.20
 * JD-Core Version:    0.7.0.1
 */