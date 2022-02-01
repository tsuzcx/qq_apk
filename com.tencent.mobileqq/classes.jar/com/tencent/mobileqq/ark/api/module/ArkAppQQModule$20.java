package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.content.Intent;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationArk;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$20
  implements Runnable
{
  ArkAppQQModule$20(ArkAppQQModule paramArkAppQQModule, int paramInt, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    String str = ArkEnvironmentManager.getInstance().getAppResPath(ArkAppQQModule.o(this.this$0));
    Activity localActivity = ArkAppQQModuleBase.f();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.a);
      localIntent.putExtra("enter_from", 3);
      localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationArk.a);
      localIntent.putExtra("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationArk.j);
      localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationArk.a);
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      localIntent.putExtra("key_ark_app_res_path", str);
      localIntent.putExtra("key_should_compress", this.b);
      localIntent.putExtra("key_ark_app_engine_res_dir", this.c);
      localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localActivity.startActivity(localIntent);
      return;
    }
    QLog.i("ArkApp", 1, "QQ.ChooseImage top activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.20
 * JD-Core Version:    0.7.0.1
 */