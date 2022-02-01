package com.tencent.mobileqq.app;

import android.text.TextUtils;
import aoke;
import axoc;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class NearByFaceDownloader$UpdateSettingRunnable
  implements Runnable
{
  FaceInfo jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting;
  
  public NearByFaceDownloader$UpdateSettingRunnable(NearByFaceDownloader paramNearByFaceDownloader, Setting paramSetting, FaceInfo paramFaceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo = paramFaceInfo;
  }
  
  public void run()
  {
    Object localObject1 = (aoke)this.this$0.a.getManager(axoc.k);
    ((aoke)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataSetting);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a;
    localObject2 = ((aoke)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/"));
    localObject2 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).endsWith("jpg_")))
    {
      localObject1 = (String)localObject1 + File.separator + ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("jpg_")) + "png";
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        if (QLog.isColorLevel()) {
          QLog.i("qqhead", 2, "delete old file,oldpath=" + (String)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader.UpdateSettingRunnable
 * JD-Core Version:    0.7.0.1
 */