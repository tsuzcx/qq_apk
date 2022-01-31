package com.tencent.biz.common.offline.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kny;
import knz;

public class OfflineDownloader
  implements IOfflineDownloader
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new knz(this);
  public TMAssistantDownloadClient a;
  
  public int a(Context paramContext, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null) {
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload" + Process.myPid());
    }
    try
    {
      paramContext = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramContext == null) {
        return 0;
      }
      int i = paramContext.mState;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack)
  {
    a(paramContext, paramString1, "0", paramString2, paramAsyncBack, null);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, AsyncBack paramAsyncBack, Map paramMap)
  {
    if (paramAsyncBack == null) {}
    int i;
    for (;;)
    {
      return;
      if (paramContext == null)
      {
        paramAsyncBack.loaded(paramString1, 11);
        return;
      }
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
      {
        paramAsyncBack.loaded(paramString1, 12);
        return;
      }
      if (AppNetConnInfo.getRecentNetworkInfo() == null)
      {
        paramAsyncBack.loaded(paramString1, 10);
        return;
      }
      i = paramString3.lastIndexOf("/");
      Object localObject = new File(paramString3.substring(0, i));
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        paramAsyncBack.loaded(paramString1, 13);
        return;
      }
      localObject = paramString3.substring(i + 1);
      paramString2 = new kny((String)localObject, paramString3, paramString2, paramAsyncBack);
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null) {
        this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload" + Process.myPid());
      }
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
      try
      {
        i = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.startDownloadTask(paramString1, 0, "resource/tm.android.unknown", (String)localObject, paramMap);
        if (i == 0)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("OfflineDownload", 2, "offline downloader start, url: " + paramString1);
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + -1 + ", url: " + paramString1);
        }
        paramAsyncBack.loaded(paramString1, 10);
        return;
      }
    }
    if (i == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "offline downloader start fail, file exists, url: " + paramString1);
      }
      a(this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient, paramString2, paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + i + ", url: " + paramString1);
    }
    paramAsyncBack.loaded(paramString1, 10);
  }
  
  public void a(AsyncBack paramAsyncBack, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, paramString3 + ", bid: " + paramString2 + ", errCode: " + paramInt);
    }
    if ((paramAsyncBack != null) && (paramInt >= 0)) {
      paramAsyncBack.loaded(paramString1, paramInt);
    }
    jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, kny paramkny, String paramString)
  {
    TMAssistantDownloadClient localTMAssistantDownloadClient = null;
    Object localObject = null;
    try
    {
      paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramTMAssistantDownloadClient == null) {}
      for (paramTMAssistantDownloadClient = localObject;; paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.mSavePath)
      {
        localTMAssistantDownloadClient = paramTMAssistantDownloadClient;
        if (!TextUtils.isEmpty(paramTMAssistantDownloadClient)) {
          break;
        }
        a(paramkny.a, paramString, paramkny.c, 14, "get current download path fail after download");
        return;
      }
      paramTMAssistantDownloadClient = new File(localTMAssistantDownloadClient);
    }
    catch (Exception paramTMAssistantDownloadClient)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
      }
    }
    finally
    {
      if (TextUtils.isEmpty(null))
      {
        a(paramkny.a, paramString, paramkny.c, 14, "get current download path fail after download");
        return;
      }
    }
    if (!paramTMAssistantDownloadClient.exists())
    {
      a(paramkny.a, paramString, paramkny.c, 15, "cannot get current file after download");
      return;
    }
    boolean bool = FileUtils.c(localTMAssistantDownloadClient, paramkny.b);
    if (!bool) {
      bool = FileUtils.b(localTMAssistantDownloadClient, paramkny.b);
    }
    for (;;)
    {
      if (!bool)
      {
        a(paramkny.a, paramString, paramkny.c, 16, "rename file fail after download");
        paramTMAssistantDownloadClient.delete();
        return;
      }
      a(paramkny.a, paramString, paramkny.c, 0, "offline zip download success");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.pauseDownloadTask(paramString);
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.util.OfflineDownloader
 * JD-Core Version:    0.7.0.1
 */