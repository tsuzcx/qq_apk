package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.data.Setting;
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
    Object localObject1 = (IQQAvatarManagerService)this.this$0.a.getRuntimeService(IQQAvatarManagerService.class, "nearby");
    ((IQQAvatarManagerService)localObject1).updateFaceSetting(this.jdField_a_of_type_ComTencentMobileqqDataSetting);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a;
    localObject2 = ((IQQAvatarManagerService)localObject1).getFacePath(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/"));
    localObject2 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).endsWith("jpg_")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("jpg_")));
      localStringBuilder.append("png");
      localObject1 = localStringBuilder.toString();
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delete old file,oldpath=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("qqhead", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader.UpdateSettingRunnable
 * JD-Core Version:    0.7.0.1
 */