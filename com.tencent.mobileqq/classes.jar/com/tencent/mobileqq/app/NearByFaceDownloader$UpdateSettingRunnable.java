package com.tencent.mobileqq.app;

import android.text.TextUtils;
import bdbu;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class NearByFaceDownloader$UpdateSettingRunnable
  implements Runnable
{
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting;
  FaceInfo jdField_a_of_type_ComTencentMobileqqUtilFaceInfo;
  
  public NearByFaceDownloader$UpdateSettingRunnable(NearByFaceDownloader paramNearByFaceDownloader, Setting paramSetting, FaceInfo paramFaceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
  }
  
  public void run()
  {
    Object localObject1 = (bdbu)this.this$0.a.getManager(216);
    ((bdbu)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataSetting);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a;
    localObject2 = ((bdbu)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader.UpdateSettingRunnable
 * JD-Core Version:    0.7.0.1
 */