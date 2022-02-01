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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("run start. | uin=");
      ((StringBuilder)localObject1).append(this.mSetting.uin);
      ((StringBuilder)localObject1).append(", updateTimestamp=");
      ((StringBuilder)localObject1).append(this.mSetting.updateTimestamp);
      ((StringBuilder)localObject1).append(", usrtype=");
      ((StringBuilder)localObject1).append(this.mSetting.bUsrType);
      ((StringBuilder)localObject1).append(", headImgTimestamp=");
      ((StringBuilder)localObject1).append(this.mSetting.headImgTimestamp);
      ((StringBuilder)localObject1).append(", usrtype=");
      ((StringBuilder)localObject1).append(this.mSetting.bHeadType);
      ((StringBuilder)localObject1).append(", status=");
      ((StringBuilder)localObject1).append(this.mSetting.getStatus());
      ((StringBuilder)localObject1).append(", id=");
      ((StringBuilder)localObject1).append(this.mSetting.getId());
      ((StringBuilder)localObject1).append(", currentTimeMillis=");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.i("UpdateSettingRunnable", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = QQHeadDownloadHandler.access$100(this.this$0).getEntityManagerFactory().createEntityManager();
    if (this.mSetting.getStatus() == 1000) {
      ((EntityManager)localObject1).persistOrReplace(this.mSetting);
    } else if ((this.mSetting.getStatus() == 1001) || (this.mSetting.getStatus() == 1002)) {
      ((EntityManager)localObject1).update(this.mSetting);
    }
    ((EntityManager)localObject1).close();
    localObject1 = QQHeadDownloadHandler.access$000(this.this$0).a(this.mInfo.uin, this.mInfo.phoneNum);
    String str = ((IQQAvatarDataService)QQHeadDownloadHandler.access$100(this.this$0).getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(this.mInfo.dstUsrType, (String)localObject1, this.mInfo.idType, this.mInfo.sizeType);
    Object localObject2 = str.substring(0, str.lastIndexOf("/"));
    str = str.substring(str.lastIndexOf("/") + 1);
    if ((!TextUtils.isEmpty(str)) && (str.endsWith("jpg_")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str.substring(0, str.lastIndexOf("jpg_")));
      localStringBuilder.append("png");
      localObject2 = new File(localStringBuilder.toString());
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
    }
    if (this.mInfo.dstUsrType == 32)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("stranger_");
      ((StringBuilder)localObject2).append(this.mInfo.idType);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append((String)localObject1);
      clearAvatar(((StringBuilder)localObject2).toString());
    }
    else if (this.mInfo.dstUsrType == 16)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("qcall_");
      ((StringBuilder)localObject2).append(this.mInfo.idType);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append((String)localObject1);
      clearAvatar(((StringBuilder)localObject2).toString());
    }
    else
    {
      clearAvatar((String)localObject1);
    }
    QQHeadDownloadHandler.access$000(this.this$0).notifyUI(0, true, this.mSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler.UpdateSettingRunnable
 * JD-Core Version:    0.7.0.1
 */