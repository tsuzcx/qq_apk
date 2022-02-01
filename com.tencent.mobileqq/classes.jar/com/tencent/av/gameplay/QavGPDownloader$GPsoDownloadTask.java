package com.tencent.av.gameplay;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QavGPDownloader$GPsoDownloadTask
{
  int jdField_a_of_type_Int = 0;
  QAVGamePlaySoConfigInfo jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = null;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo == paramQAVGamePlaySoConfigInfo) || (TextUtils.isEmpty(paramQAVGamePlaySoConfigInfo.b)) || (paramQAVGamePlaySoConfigInfo.b.equals(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo.b))) {
        break label279;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGPDownloadManager", 2, String.format("GPsoDownloadTask, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = (IHttpEngineService)((AppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all");
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
              ((IHttpEngineService)localObject).cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = paramQAVGamePlaySoConfigInfo;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!QavGamePlayUtil.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo, 3);
        return this.jdField_a_of_type_Boolean;
        label279:
        bool = false;
      }
    }
  }
  
  boolean a(QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!QavGamePlayUtil.a(paramQAVGamePlaySoConfigInfo))
    {
      str2 = paramQAVGamePlaySoConfigInfo.a;
      str1 = paramQAVGamePlaySoConfigInfo.b;
      str3 = QavGamePlayUtil.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramQAVGamePlaySoConfigInfo }));
        QavGPDownloader.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      QavGPDownloader.a(100);
      return false;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new QavGPDownloader.GPsoDownloadTask.1(this, str1, paramQAVGamePlaySoConfigInfo, paramInt);
    localHttpNetReq.setUserData(str1);
    localHttpNetReq.mReqUrl = str2;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(str3).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    paramQAVGamePlaySoConfigInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramQAVGamePlaySoConfigInfo instanceof QQAppInterface))
    {
      paramQAVGamePlaySoConfigInfo = (IHttpEngineService)((QQAppInterface)paramQAVGamePlaySoConfigInfo).getRuntimeService(IHttpEngineService.class, "all");
      if (paramQAVGamePlaySoConfigInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
        paramQAVGamePlaySoConfigInfo.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        QavGPDownloader.a(-2);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QavGPDownloadManager", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool1) }));
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGPDownloader.GPsoDownloadTask
 * JD-Core Version:    0.7.0.1
 */