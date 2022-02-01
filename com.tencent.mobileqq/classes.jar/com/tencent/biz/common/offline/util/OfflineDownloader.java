package com.tencent.biz.common.offline.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.temp.api.IWebViewOpenSdkApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OfflineDownloader
  implements IOfflineDownloader
{
  private static HashMap<String, DownloadInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new OfflineDownloader.1(this);
  public TMAssistantDownloadClient a;
  
  public int a(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload");
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
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, AsyncBack paramAsyncBack, Map<String, String> paramMap)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if (paramContext == null)
    {
      paramAsyncBack.loaded(paramString1, 11);
      return;
    }
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (AppNetConnInfo.getRecentNetworkInfo() == null)
      {
        paramAsyncBack.loaded(paramString1, 10);
        return;
      }
      localObject = new File(paramString3.substring(0, paramString3.lastIndexOf("/")));
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        paramAsyncBack.loaded(paramString1, 13);
        return;
      }
      localObject = Md5Utils.getMD5(paramString1);
      paramString2 = new DownloadInfo((String)localObject, paramString3, paramString2, paramAsyncBack);
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    }
    try
    {
      paramString3 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
    }
    catch (Exception paramContext)
    {
      int i;
      label407:
      label410:
      break label410;
    }
    try
    {
      i = paramString3.startDownloadTask(paramString1, 0, "resource/tm.android.unknown", (String)localObject, paramMap);
      if (i == 0)
      {
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("offline downloader start, url: ");
          paramString3.append(paramString1);
          QLog.d("OfflineDownload", 2, paramString3.toString());
        }
      }
      else if (i == 4)
      {
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("offline downloader start fail, file exists, url: ");
          paramString3.append(paramString1);
          QLog.d("OfflineDownload", 2, paramString3.toString());
        }
        a(this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient, paramString2, paramString1);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("offline downloader start fail, result ");
          paramString3.append(i);
          paramString3.append(", url: ");
          paramString3.append(paramString1);
          QLog.d("OfflineDownload", 2, paramString3.toString());
        }
        paramAsyncBack.loaded(paramString1, 10);
      }
    }
    catch (Exception paramContext)
    {
      break label407;
    }
    try
    {
      paramString3 = new com.tencent.open.downloadnew.DownloadInfo();
      paramString3.d = paramString1;
      paramString3.l = paramString2.b;
      paramString3.e = paramString2.jdField_a_of_type_JavaLangString;
      ((IWebViewOpenSdkApi)QRoute.api(IWebViewOpenSdkApi.class)).reportDownloadInfo(paramContext, paramString3);
      return;
    }
    catch (Throwable paramContext) {}
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("offline downloader start fail, result ");
      paramContext.append(-1);
      paramContext.append(", url: ");
      paramContext.append(paramString1);
      QLog.d("OfflineDownload", 2, paramContext.toString());
    }
    paramAsyncBack.loaded(paramString1, 10);
    return;
    paramAsyncBack.loaded(paramString1, 12);
    return;
  }
  
  public void a(AsyncBack paramAsyncBack, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", bid: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", errCode: ");
      localStringBuilder.append(paramInt);
      QLog.d("OfflineDownload", 2, localStringBuilder.toString());
    }
    if ((paramAsyncBack != null) && (paramInt >= 0)) {
      paramAsyncBack.loaded(paramString1, paramInt);
    }
    jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
  }
  
  /* Error */
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, DownloadInfo paramDownloadInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: aload_3
    //   8: invokevirtual 53	com/tencent/tmdownloader/TMAssistantDownloadClient:getDownloadTaskState	(Ljava/lang/String;)Lcom/tencent/tmassistant/aidl/TMAssistantDownloadTaskInfo;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +9 -> 22
    //   16: aload 5
    //   18: astore_1
    //   19: goto +8 -> 27
    //   22: aload_1
    //   23: getfield 211	com/tencent/tmassistant/aidl/TMAssistantDownloadTaskInfo:mSavePath	Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: astore 4
    //   30: aload_1
    //   31: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +67 -> 101
    //   37: aload_0
    //   38: aload_2
    //   39: getfield 214	com/tencent/biz/common/offline/util/DownloadInfo:jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack	Lcom/tencent/biz/common/offline/AsyncBack;
    //   42: aload_3
    //   43: aload_2
    //   44: getfield 217	com/tencent/biz/common/offline/util/DownloadInfo:c	Ljava/lang/String;
    //   47: bipush 14
    //   49: ldc 219
    //   51: invokevirtual 221	com/tencent/biz/common/offline/util/OfflineDownloader:a	(Lcom/tencent/biz/common/offline/AsyncBack;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   54: return
    //   55: astore_1
    //   56: goto +132 -> 188
    //   59: astore_1
    //   60: invokestatic 224	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   63: ifeq +13 -> 76
    //   66: ldc 41
    //   68: iconst_4
    //   69: aload_1
    //   70: invokevirtual 225	java/lang/Exception:toString	()Ljava/lang/String;
    //   73: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifeq +21 -> 101
    //   83: aload_0
    //   84: aload_2
    //   85: getfield 214	com/tencent/biz/common/offline/util/DownloadInfo:jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack	Lcom/tencent/biz/common/offline/AsyncBack;
    //   88: aload_3
    //   89: aload_2
    //   90: getfield 217	com/tencent/biz/common/offline/util/DownloadInfo:c	Ljava/lang/String;
    //   93: bipush 14
    //   95: ldc 219
    //   97: invokevirtual 221	com/tencent/biz/common/offline/util/OfflineDownloader:a	(Lcom/tencent/biz/common/offline/AsyncBack;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   100: return
    //   101: new 87	java/io/File
    //   104: dup
    //   105: aload 4
    //   107: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 106	java/io/File:exists	()Z
    //   115: ifne +21 -> 136
    //   118: aload_0
    //   119: aload_2
    //   120: getfield 214	com/tencent/biz/common/offline/util/DownloadInfo:jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack	Lcom/tencent/biz/common/offline/AsyncBack;
    //   123: aload_3
    //   124: aload_2
    //   125: getfield 217	com/tencent/biz/common/offline/util/DownloadInfo:c	Ljava/lang/String;
    //   128: bipush 15
    //   130: ldc 227
    //   132: invokevirtual 221	com/tencent/biz/common/offline/util/OfflineDownloader:a	(Lcom/tencent/biz/common/offline/AsyncBack;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   135: return
    //   136: aload 4
    //   138: aload_2
    //   139: getfield 177	com/tencent/biz/common/offline/util/DownloadInfo:b	Ljava/lang/String;
    //   142: invokestatic 233	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   145: ifne +26 -> 171
    //   148: aload_0
    //   149: aload_2
    //   150: getfield 214	com/tencent/biz/common/offline/util/DownloadInfo:jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack	Lcom/tencent/biz/common/offline/AsyncBack;
    //   153: aload_3
    //   154: aload_2
    //   155: getfield 217	com/tencent/biz/common/offline/util/DownloadInfo:c	Ljava/lang/String;
    //   158: bipush 16
    //   160: ldc 235
    //   162: invokevirtual 221	com/tencent/biz/common/offline/util/OfflineDownloader:a	(Lcom/tencent/biz/common/offline/AsyncBack;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_1
    //   166: invokevirtual 238	java/io/File:delete	()Z
    //   169: pop
    //   170: return
    //   171: aload_0
    //   172: aload_2
    //   173: getfield 214	com/tencent/biz/common/offline/util/DownloadInfo:jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack	Lcom/tencent/biz/common/offline/AsyncBack;
    //   176: aload_3
    //   177: aload_2
    //   178: getfield 217	com/tencent/biz/common/offline/util/DownloadInfo:c	Ljava/lang/String;
    //   181: iconst_0
    //   182: ldc 240
    //   184: invokevirtual 221	com/tencent/biz/common/offline/util/OfflineDownloader:a	(Lcom/tencent/biz/common/offline/AsyncBack;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   187: return
    //   188: aconst_null
    //   189: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   192: ifeq +21 -> 213
    //   195: aload_0
    //   196: aload_2
    //   197: getfield 214	com/tencent/biz/common/offline/util/DownloadInfo:jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack	Lcom/tencent/biz/common/offline/AsyncBack;
    //   200: aload_3
    //   201: aload_2
    //   202: getfield 217	com/tencent/biz/common/offline/util/DownloadInfo:c	Ljava/lang/String;
    //   205: bipush 14
    //   207: ldc 219
    //   209: invokevirtual 221	com/tencent/biz/common/offline/util/OfflineDownloader:a	(Lcom/tencent/biz/common/offline/AsyncBack;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   212: return
    //   213: aload_1
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	OfflineDownloader
    //   0	215	1	paramTMAssistantDownloadClient	TMAssistantDownloadClient
    //   0	215	2	paramDownloadInfo	DownloadInfo
    //   0	215	3	paramString	String
    //   1	136	4	localTMAssistantDownloadClient	TMAssistantDownloadClient
    //   4	13	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	55	finally
    //   22	27	55	finally
    //   60	76	55	finally
    //   6	12	59	java/lang/Exception
    //   22	27	59	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TMAssistantDownloadClient localTMAssistantDownloadClient = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
      if (localTMAssistantDownloadClient == null) {
        return;
      }
      localTMAssistantDownloadClient.pauseDownloadTask(paramString);
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.util.OfflineDownloader
 * JD-Core Version:    0.7.0.1
 */