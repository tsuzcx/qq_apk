package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.text.TextUtils;
import aoks;
import axpp;
import bgzh;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
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
    this.mInfo = paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo;
    this.mFaceInfo = paramFaceInfo;
  }
  
  private void clearAvatar(String paramString)
  {
    aoks.a(paramString);
    aoks.b(paramString);
    aoks.a(QQHeadDownloadHandler.access$100(this.this$0), paramString);
  }
  
  public void run()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("UpdateSettingRunnable", 2, "run start. | uin=" + this.mSetting.uin + ", updateTimestamp=" + this.mSetting.updateTimestamp + ", usrtype=" + this.mSetting.bUsrType + ", headImgTimestamp=" + this.mSetting.headImgTimestamp + ", usrtype=" + this.mSetting.bHeadType + ", status=" + this.mSetting.getStatus() + ", id=" + this.mSetting.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
    }
    localObject1 = QQHeadDownloadHandler.access$100(this.this$0).getEntityManagerFactory().createEntityManager();
    String str1;
    if (this.mSetting.getStatus() == 1000)
    {
      ((EntityManager)localObject1).persistOrReplace(this.mSetting);
      ((EntityManager)localObject1).close();
      if (this.mInfo.dstUsrType == 32)
      {
        localObject1 = QQHeadDownloadHandler.access$100(this.this$0).getNearbyProxy().a(true);
        if (localObject1 != null) {
          ((bgzh)localObject1).a(32, this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.b);
        }
      }
      localObject1 = QQHeadDownloadHandler.access$000(this.this$0).getUinOrMobile(this.mInfo.uin, this.mInfo.phoneNum);
      str1 = QQHeadDownloadHandler.access$100(this.this$0).getCustomFaceFilePath(this.mInfo.dstUsrType, (String)localObject1, this.mInfo.idType, this.mInfo.sizeType);
      Object localObject2 = str1.substring(0, str1.lastIndexOf("/"));
      String str2 = str1.substring(str1.lastIndexOf("/") + 1);
      if ((!TextUtils.isEmpty(str2)) && (str2.endsWith("jpg_")))
      {
        localObject2 = new File((String)localObject2 + File.separator + str2.substring(0, str2.lastIndexOf("jpg_")) + "png");
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
      }
    }
    for (;;)
    {
      try
      {
        int j = NetworkUtil.getNetworkType(QQHeadDownloadHandler.access$100(this.this$0).getApp());
        if (this.mInfo.dstUsrType != 1) {
          continue;
        }
        k = (int)new File(str1).length();
        if (k > 0) {
          QQHeadDownloadHandler.access$100(this.this$0).sendAppDataIncerment(QQHeadDownloadHandler.access$100(this.this$0).getCurrentAccountUin(), false, j, 131074, i, k + 126 + 239);
        }
      }
      catch (Throwable localThrowable)
      {
        int k;
        localThrowable.printStackTrace();
        continue;
        if (this.mInfo.dstUsrType != 16) {
          continue;
        }
        clearAvatar("qcall_" + this.mInfo.idType + "_" + (String)localObject1);
        continue;
        clearAvatar((String)localObject1);
        continue;
      }
      if (this.mInfo.dstUsrType != 32) {
        continue;
      }
      clearAvatar("stranger_" + this.mInfo.idType + "_" + (String)localObject1);
      QQHeadDownloadHandler.access$000(this.this$0).notifyUI(45, true, this.mSetting);
      return;
      if ((this.mSetting.getStatus() != 1001) && (this.mSetting.getStatus() != 1002)) {
        break;
      }
      ((EntityManager)localObject1).update(this.mSetting);
      break;
      if (this.mInfo.dstUsrType == 4)
      {
        i = 1;
      }
      else if (this.mInfo.dstUsrType == 11)
      {
        i = 3;
      }
      else if (this.mInfo.dstUsrType == 32)
      {
        i = 1003;
      }
      else
      {
        k = this.mInfo.dstUsrType;
        if (k == 116) {
          i = 1045;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler.UpdateSettingRunnable
 * JD-Core Version:    0.7.0.1
 */