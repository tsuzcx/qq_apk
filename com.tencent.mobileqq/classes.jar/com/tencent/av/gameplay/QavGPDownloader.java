package com.tencent.av.gameplay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class QavGPDownloader
{
  QAVGamePlaySoConfigInfo jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = null;
  QavGPDownloader.GPsoDownloadTask jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask = null;
  boolean jdField_a_of_type_Boolean = false;
  
  QavGPDownloader()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "QavGPDownloader in QQAppInterface");
    }
    this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask = new QavGPDownloader.GPsoDownloadTask();
  }
  
  static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.qavgameplaysomgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo)
  {
    SharedPreferences localSharedPreferences = QavGamePlayUtil.a();
    paramQAVGamePlaySoConfigInfo = paramQAVGamePlaySoConfigInfo.b;
    localSharedPreferences.edit().putString("so_zip_md5", paramQAVGamePlaySoConfigInfo).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, "onEnterBackground");
    }
    a();
  }
  
  public static void a(String paramString)
  {
    if (QavGPDownloadManager.a()) {
      QavGPDownloadManager.a().a.b(paramString);
    }
  }
  
  public static boolean a()
  {
    return QavGPDownloadManager.a().a.b();
  }
  
  private boolean b()
  {
    QLog.d("QavGPDownloadManager", 4, "innerDownload, start");
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGPDownloadManager", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo == null) {
      this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = QAVGamePlaySoConfigInfo.a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo;
    if (localObject == null)
    {
      QLog.d("QavGPDownloadManager", 2, "downloadInfo == null");
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (11 == QavGamePlayUtil.a((QAVGamePlaySoConfigInfo)localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        QLog.d("QavGPDownloadManager", 2, "downloadTask.start");
        return this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.a((QAVGamePlaySoConfigInfo)localObject);
      }
      QLog.d("QavGPDownloadManager", 2, "bDownloading = false");
      return bool;
    }
  }
  
  void b(String paramString)
  {
    QAVGamePlaySoConfigInfo localQAVGamePlaySoConfigInfo = null;
    if (!TextUtils.isEmpty(paramString)) {
      localQAVGamePlaySoConfigInfo = QAVGamePlaySoConfigInfo.a(paramString);
    }
    this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = localQAVGamePlaySoConfigInfo;
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("QavGPDownloadManager", 1, "handle_QAG_QavGameplay_Config, mNeedDownloadAfterGetConfig == true");
      this.jdField_a_of_type_Boolean = false;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGPDownloader
 * JD-Core Version:    0.7.0.1
 */