package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QQHeadDownloadHandler$UpdateSettingRunnable
  implements Runnable
{
  FaceInfo mFaceInfo;
  QQHeadInfo mInfo;
  Setting mSetting;
  
  public QQHeadDownloadHandler$UpdateSettingRunnable(QQHeadDownloadHandler paramQQHeadDownloadHandler, Setting paramSetting, FaceInfo paramFaceInfo)
  {
    this.mSetting = paramSetting;
    this.mInfo = paramFaceInfo.a;
    this.mFaceInfo = paramFaceInfo;
  }
  
  private void clearAvatar(String paramString)
  {
    FaceUtil.a(paramString);
    FaceUtil.b(paramString);
    FaceUtil.a(QQHeadDownloadHandler.access$100(this.this$0), paramString);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UpdateSettingRunnable", 2, "run start. | uin=" + this.mSetting.uin + ", updateTimestamp=" + this.mSetting.updateTimestamp + ", usrtype=" + this.mSetting.bUsrType + ", headImgTimestamp=" + this.mSetting.headImgTimestamp + ", usrtype=" + this.mSetting.bHeadType + ", status=" + this.mSetting.getStatus() + ", id=" + this.mSetting.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
    }
    Object localObject1 = QQHeadDownloadHandler.access$100(this.this$0).getEntityManagerFactory().createEntityManager();
    if (this.mSetting.getStatus() == 1000)
    {
      ((EntityManager)localObject1).persistOrReplace(this.mSetting);
      ((EntityManager)localObject1).close();
      localObject1 = QQHeadDownloadHandler.access$000(this.this$0).a(this.mInfo.uin, this.mInfo.phoneNum);
      String str = ((IQQAvatarDataService)QQHeadDownloadHandler.access$100(this.this$0).getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(this.mInfo.dstUsrType, (String)localObject1, this.mInfo.idType, this.mInfo.sizeType);
      Object localObject2 = str.substring(0, str.lastIndexOf("/"));
      str = str.substring(str.lastIndexOf("/") + 1);
      if ((!TextUtils.isEmpty(str)) && (str.endsWith("jpg_")))
      {
        localObject2 = new File((String)localObject2 + File.separator + str.substring(0, str.lastIndexOf("jpg_")) + "png");
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
      }
      if (this.mInfo.dstUsrType != 32) {
        break label452;
      }
      clearAvatar("stranger_" + this.mInfo.idType + "_" + (String)localObject1);
    }
    for (;;)
    {
      QQHeadDownloadHandler.access$000(this.this$0).notifyUI(0, true, this.mSetting);
      return;
      if ((this.mSetting.getStatus() != 1001) && (this.mSetting.getStatus() != 1002)) {
        break;
      }
      ((EntityManager)localObject1).update(this.mSetting);
      break;
      label452:
      if (this.mInfo.dstUsrType == 16) {
        clearAvatar("qcall_" + this.mInfo.idType + "_" + (String)localObject1);
      } else {
        clearAvatar((String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler.UpdateSettingRunnable
 * JD-Core Version:    0.7.0.1
 */