package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$36$1
  implements DialogInterface.OnClickListener
{
  AEPituCameraUnit$36$1(AEPituCameraUnit.36 param36) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject1 = this.a.this$0.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("PermissionDialog--onClick which=");
    ((StringBuilder)localObject2).append(paramInt);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.a.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    if (paramInt == 1)
    {
      localObject2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      ((Intent)localObject2).setData(Uri.fromParts("package", ((Activity)localObject1).getPackageName(), null));
      ((Activity)localObject1).startActivity((Intent)localObject2);
    }
    else
    {
      ((Activity)localObject1).finish();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.36.1
 * JD-Core Version:    0.7.0.1
 */