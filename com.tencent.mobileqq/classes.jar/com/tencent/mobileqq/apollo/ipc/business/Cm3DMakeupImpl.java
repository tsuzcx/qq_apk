package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;
import mqq.app.AppRuntime;

public class Cm3DMakeupImpl
  implements ICm3DMakeup
{
  private AppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      QLog.i("[cmshow][apollo]Cm3DMakeupImpl", 2, "onRemoteInvoke cannot get QQAppInterface");
      return null;
    }
    return (QQAppInterface)localAppRuntime;
  }
  
  public void a(String paramString, ICm3DMakeup.Save3DFaceListener paramSave3DFaceListener)
  {
    ThreadManagerV2.executeOnSubThread(new Cm3DMakeupImpl.1(this, paramString, paramSave3DFaceListener));
  }
  
  public void b(String paramString, ICm3DMakeup.Save3DFaceListener paramSave3DFaceListener)
  {
    Object localObject = a();
    if (paramString != null)
    {
      if (localObject == null) {
        return;
      }
      FileUtils.writeFile("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/json/face.json", paramString);
      FileUtils.zipFiles("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/json/", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/face3d.zip");
      paramString = (ITransFileController)((AppRuntime)localObject).getRuntimeService(ITransFileController.class, "all");
      paramSave3DFaceListener = new Cm3DMakeupImpl.2(this, ThreadManager.getSubThreadLooper(), paramSave3DFaceListener, paramString);
      paramSave3DFaceListener.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      paramString.addHandle(paramSave3DFaceListener);
      paramSave3DFaceListener = new TransferRequest();
      paramSave3DFaceListener.mFileType = 24;
      paramSave3DFaceListener.mCommandId = 79;
      paramSave3DFaceListener.mSelfUin = ((AppRuntime)localObject).getCurrentUin();
      paramSave3DFaceListener.mPeerUin = "0";
      paramSave3DFaceListener.mUniseq = ((Math.random() * 1000000.0D));
      paramSave3DFaceListener.mIsUp = true;
      paramSave3DFaceListener.mRequestLength = ((int)new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/face3d.zip").length());
      paramSave3DFaceListener.mLocalPath = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/face3d/face3d.zip";
      paramSave3DFaceListener.mRichTag = "cmshow3DFace";
      localObject = new Bdh_extinfo.CommFileExtReq();
      ((Bdh_extinfo.CommFileExtReq)localObject).uint32_action_type.set(0);
      PBBytesField localPBBytesField = ((Bdh_extinfo.CommFileExtReq)localObject).bytes_uuid;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(UUID.randomUUID().toString());
      localStringBuilder.append(".zip");
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(localStringBuilder.toString()));
      paramSave3DFaceListener.mExtentionInfo = ((Bdh_extinfo.CommFileExtReq)localObject).toByteArray();
      paramString.transferAsync(paramSave3DFaceListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.Cm3DMakeupImpl
 * JD-Core Version:    0.7.0.1
 */