package com.tencent.aelight.camera.ae.download;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.download.old.AEOldResManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig_V2;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AEResManager
  implements ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig_V2
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEResManagerHandlerThread", 0);
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<AEResInfo, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<AEResInfo> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<IAEDownloadCallBack> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<AEResInfo, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private AEResManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static AEResManager a()
  {
    return AEResManager.InstanceHolder.a;
  }
  
  private QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 0) {
      return "DOWNLOAD_STATUS_IDLE";
    }
    if (paramInt == 1) {
      return "DOWNLOAD_STATUS_WAIT";
    }
    if (paramInt == 2) {
      return "DOWNLOAD_STATUS_PREDOWNLOAD_WAIT";
    }
    if (paramInt == 3) {
      return "DOWNLOAD_STATUS_DOWNLOADING";
    }
    if (paramInt == 4) {
      return "DOWNLOAD_STATUS_READY";
    }
    return "DOWNLOAD_STATUS_UNKNOWN";
  }
  
  private void a(@NonNull AEResInfo paramAEResInfo, @Nullable IAEDownloadCallBack paramIAEDownloadCallBack)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=");
    ((StringBuilder)localObject).append(paramAEResInfo.index);
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo)).intValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadWithoutLoginInternal], status=");
    ((StringBuilder)localObject).append(a(i));
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    localObject = null;
    if (i == 4)
    {
      i = AEResUtil.a(paramAEResInfo.index);
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAEResInfo.resPrefix);
        ((StringBuilder)localObject).append(i);
        localObject = AEResUtil.a(((StringBuilder)localObject).toString());
      }
      if (paramIAEDownloadCallBack != null) {
        paramIAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, (String)localObject, true, 0);
      }
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadWithoutLoginInternal], packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      paramIAEDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      return;
    }
    if (i == 3)
    {
      b(paramIAEDownloadCallBack);
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadWithoutLoginInternal], packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      paramIAEDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(null))
    {
      if (paramIAEDownloadCallBack != null) {
        paramIAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, null, false, -6);
      }
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadWithoutLoginInternal], packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      paramIAEDownloadCallBack.append(", networkStatus=UNUSABLE");
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadWithoutLoginInternal], packageIndex=");
    ((StringBuilder)localObject).append(paramAEResInfo.index);
    ((StringBuilder)localObject).append(", networkStatus=USABLE");
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    b(paramIAEDownloadCallBack);
    if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEResInfo))
    {
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEResInfo);
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(1));
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(AEResInfo.AE_RES_CONFIG))
    {
      this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(3));
      ShortVideoResDownload.a(a(), this);
    }
    else if ((this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG)).intValue() == 4))
    {
      a(1, 0);
    }
    paramIAEDownloadCallBack = new StringBuilder();
    paramIAEDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
    paramIAEDownloadCallBack.append(paramAEResInfo.index);
    AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
  }
  
  private void a(@NonNull AEResInfo paramAEResInfo, @Nullable IAEDownloadCallBack paramIAEDownloadCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadInternal] - BEGIN -, packageIndex=");
    ((StringBuilder)localObject).append(paramAEResInfo.index);
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEResInfo);
    Integer localInteger = Integer.valueOf(0);
    if (!bool) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, localInteger);
    }
    int j = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEResInfo)).intValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadInternal], status=");
    ((StringBuilder)localObject).append(a(j));
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    localObject = null;
    if ((j == 4) && (AEResUtil.b(paramAEResInfo)))
    {
      i = AEResUtil.a(paramAEResInfo.index);
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAEResInfo.resPrefix);
        ((StringBuilder)localObject).append(i);
        localObject = AEResUtil.a(((StringBuilder)localObject).toString());
      }
      if (paramIAEDownloadCallBack != null) {
        paramIAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, (String)localObject, true, 0);
      }
      AEResUtil.a(paramAEResInfo, (String)localObject);
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal], packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      paramIAEDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      return;
    }
    int i = j;
    if (j == 4)
    {
      i = j;
      if (!AEResUtil.b(paramAEResInfo))
      {
        AEQLog.b("AEResManager", "[requestDownloadInternal], 重置内存中的文件状态为IDLE");
        this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, localInteger);
        i = 0;
      }
    }
    if (i == 3)
    {
      b(paramIAEDownloadCallBack);
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal], packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      paramIAEDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      return;
    }
    if ((NetworkUtil.isNetworkAvailable(null)) && ((!paramBoolean1) || (NetworkUtil.isWifiConnected(null)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (paramIAEDownloadCallBack != null) {
        paramIAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, null, false, -6);
      }
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal], packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      paramIAEDownloadCallBack.append(", networkStatus=UNUSABLE");
      AEQLog.d("AEResManager", paramIAEDownloadCallBack.toString());
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadInternal], packageIndex=");
    ((StringBuilder)localObject).append(paramAEResInfo.index);
    ((StringBuilder)localObject).append(", networkStatus=USABLE");
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    b(paramIAEDownloadCallBack);
    if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEResInfo))
    {
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEResInfo);
      this.jdField_a_of_type_JavaUtilMap.put(paramAEResInfo, Integer.valueOf(1));
    }
    if ((paramAEResInfo.isPredownload) && (paramBoolean2)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    paramAEResInfo.isPredownload = paramBoolean1;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(AEResInfo.AE_RES_CONFIG))
    {
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal] 强制拉取配置列表");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(3));
      ShortVideoResourceManager.a(a(), this);
    }
    else if ((this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEResInfo.AE_RES_CONFIG)).intValue() == 4))
    {
      paramIAEDownloadCallBack = new StringBuilder();
      paramIAEDownloadCallBack.append("[requestDownloadInternal] 配置列表已经存在, packageIndex = ");
      paramIAEDownloadCallBack.append(paramAEResInfo.index);
      AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
      onConfigResult(1, 0);
    }
    paramIAEDownloadCallBack = new StringBuilder();
    paramIAEDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
    paramIAEDownloadCallBack.append(paramAEResInfo.index);
    AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString1;
    paramString1 = new StringBuilder();
    paramString1.append("[onDownloadFinishInternal] - BEGIN -, result=");
    paramString1.append(paramInt);
    paramString1.append(", name=");
    paramString1.append(str);
    paramString1.append(", filePath=");
    paramString1.append(paramString2);
    AEQLog.b("AEResManager", paramString1.toString());
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    int i;
    if ((paramInt != 0) && (paramInt != 1)) {
      i = paramInt;
    } else {
      i = 0;
    }
    Object localObject = AEResInfo.packageValues;
    int k = localObject.length;
    int j = 0;
    while (j < k)
    {
      str = localObject[j];
      if (paramString1.startsWith(str.resPrefix))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onDownloadFinishInternal], matched aeResInfo=");
        ((StringBuilder)localObject).append(str);
        AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
        if (i == 0)
        {
          this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(4));
          this.jdField_a_of_type_JavaUtilQueue.remove(str);
          AEResUtil.a(str, paramString2);
          j = Integer.valueOf(paramString1.substring(str.resPrefix.length())).intValue();
          AEResUtil.a(str.index, j);
        }
        else
        {
          this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(0));
          this.jdField_a_of_type_JavaUtilQueue.remove(str);
        }
        paramString1 = this.jdField_b_of_type_JavaUtilList.iterator();
        boolean bool;
        while (paramString1.hasNext())
        {
          localObject = (IAEDownloadCallBack)paramString1.next();
          if (i == 0) {
            bool = true;
          } else {
            bool = false;
          }
          ((IAEDownloadCallBack)localObject).onAEDownloadFinish(str, paramString2, bool, i);
        }
        if (paramInt != 1)
        {
          long l = -1L;
          if (this.jdField_b_of_type_JavaUtilMap.get(str) != null) {
            l = System.currentTimeMillis() - ((Long)this.jdField_b_of_type_JavaUtilMap.get(str)).longValue();
          }
          paramString1 = AEBaseDataReporter.a();
          if (paramInt == 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramString1.a(bool, str.index, "", "", paramInt, l);
        }
        AEQLog.b("AEResManager", "[onDownloadFinishInternal], start download next package");
        paramString1 = a();
        a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        break;
      }
      j += 1;
    }
    AEQLog.b("AEResManager", "[onDownloadFinishInternal] - END -");
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    if (paramString == null) {
      paramString = "";
    }
    AEResInfo[] arrayOfAEResInfo = AEResInfo.packageValues;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[i];
      if (paramString.startsWith(localAEResInfo.resPrefix))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(3));
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((IAEDownloadCallBack)localIterator.next()).onAEProgressUpdate(localAEResInfo, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEResInfo paramAEResInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[cancelPreDownLoad] - BEGIN -, aeResInfo=");
    ((StringBuilder)localObject).append(paramAEResInfo);
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    paramQQAppInterface = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject).next();
      if (paramList.name.startsWith(paramAEResInfo.resPrefix))
      {
        AEQLog.b("AEResManager", "[cancelPreDownLoad], chosenConfigItem matched");
        break label102;
      }
    }
    paramList = null;
    label102:
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isEnable()) && (paramList != null))
    {
      if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramList.check64BitReady())) {
        paramQQAppInterface.cancelPreDownload(paramList.arm64v8a_url);
      } else {
        paramQQAppInterface.cancelPreDownload(paramList.armv7a_url);
      }
      paramList = new StringBuilder();
      paramList.append("[cancelPreDownLoad], preDownloadController.isEnable() == ");
      paramList.append(paramQQAppInterface.isEnable());
      AEQLog.b("AEResManager", paramList.toString());
    }
    paramList = new StringBuilder();
    paramList.append("[cancelPreDownLoad] - END -, aeResInfo=");
    paramList.append(paramAEResInfo);
    AEQLog.b("AEResManager", paramList.toString());
  }
  
  private void a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    AEQLog.b("AEResManager_download", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      AEQLog.d("AEResManager_download", "[startDownLoad], mDownLoadTaskQueue is empty");
      AEQLog.b("AEResManager_download", "[startDownLoad] - END -");
      return;
    }
    AEResInfo localAEResInfo = (AEResInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localAEResInfo == null)
    {
      AEQLog.d("AEResManager_download", "[startDownLoad], mDownLoadTaskQueue top element is null");
      AEQLog.b("AEResManager_download", "[startDownLoad] + END");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localAEResInfo))
    {
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localAEResInfo)).intValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[startDownLoad], resNeedDownload=");
      localStringBuilder.append(localAEResInfo);
      AEQLog.a("AEResManager_download", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[startDownLoad], status=");
      localStringBuilder.append(a(i));
      AEQLog.a("AEResManager_download", localStringBuilder.toString());
      if ((!paramBoolean) && (localAEResInfo.isPredownload))
      {
        AEQLog.b("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
        if (i != 3)
        {
          if (i == 2) {
            return;
          }
          if (!a(paramList, this, paramQQAppInterface, localAEResInfo))
          {
            a(paramList, paramQQAppInterface, localAEResInfo);
            localAEResInfo.isPredownload = false;
            this.jdField_b_of_type_JavaUtilMap.put(localAEResInfo, Long.valueOf(System.currentTimeMillis()));
            AEQLog.b("AEResManager", "[startDownLoad], realDownloadResource()");
            this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(3));
            AEResDownload.a(localAEResInfo, paramList, this);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(2));
          }
        }
      }
      else
      {
        AEQLog.b("AEResManager", "[startDownLoad], isDownLoadImmediately=true");
        if (i != 3)
        {
          this.jdField_a_of_type_JavaUtilMap.put(localAEResInfo, Integer.valueOf(3));
          if (i == 2) {
            a(paramList, paramQQAppInterface, localAEResInfo);
          }
          this.jdField_b_of_type_JavaUtilMap.put(localAEResInfo, Long.valueOf(System.currentTimeMillis()));
          AEQLog.b("AEResManager", "[startDownLoad], realDownloadResource()");
          AEResDownload.a(localAEResInfo, paramList, this);
        }
      }
      AEQLog.b("AEResManager", "[startDownLoad] + END");
      return;
    }
    AEQLog.d("AEResManager_download", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
    AEQLog.b("AEResManager_download", "[startDownLoad] + END");
  }
  
  private void a(boolean paramBoolean)
  {
    AEQLog.b("AEResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      AEQLog.b("AEResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
    }
    else
    {
      AEQLog.b("AEResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
      localObject1 = new LinkedList();
      i = ShortVideoResourceManager.a(null, (List)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = ");
      ((StringBuilder)localObject2).append(localObject1);
      AEQLog.b("AEResManager", ((StringBuilder)localObject2).toString());
      if ((i == 0) && (((List)localObject1).size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onConfigResultInternal] 生成配置列表结果 errCode = ");
    ((StringBuilder)localObject1).append(i);
    AEQLog.b("AEResManager", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onConfigResultInternal] 内存中'当前的'配置列表信息，size = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
    AEQLog.b("AEResManager", ((StringBuilder)localObject1).toString());
    int j = i;
    if (i == 0) {
      j = AEResUtil.a(this.jdField_a_of_type_JavaUtilList);
    }
    localObject1 = a();
    if (j == 0)
    {
      this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(4));
      AEQLog.b("AEResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
      a(new LinkedList(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject1, paramBoolean ^ true);
    }
    else
    {
      AEQLog.b("AEResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
      ShortVideoResourceManager.a((QQAppInterface)localObject1, null);
      localObject2 = AELocalConfig.jdField_a_of_type_JavaUtilList;
      if (((List)localObject2).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      this.jdField_a_of_type_JavaUtilMap.put(AEResInfo.AE_RES_CONFIG, Integer.valueOf(4));
      AEQLog.b("AEResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
      a(new LinkedList(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject1, paramBoolean ^ true);
    }
    AEQLog.b("AEResManager", "[onConfigResultInternal] ++++++ END");
  }
  
  private boolean a(@NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEResInfo paramAEResInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[startPreDownLoad] - BEGIN -, aeResInfo=");
    ((StringBuilder)localObject).append(paramAEResInfo);
    AEQLog.b("AEResManager", ((StringBuilder)localObject).toString());
    IPreDownloadController localIPreDownloadController = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if (((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(paramAEResInfo.resPrefix))
      {
        AEQLog.b("AEResManager", "[startPreDownLoad], chosenConfigItem matched");
        break label108;
      }
    }
    localObject = null;
    label108:
    if ((localIPreDownloadController != null) && (localIPreDownloadController.isEnable()))
    {
      paramINet_ShortVideoResource = new AEResManager.5(this, paramQQAppInterface, "ae_camera_res", new AEResManager.4(this, paramAEResInfo, paramList, paramINet_ShortVideoResource), 4000L);
      if (localObject != null)
      {
        if ((VideoEnvironment64BitUtils.checkIs64bit()) && (((ShortVideoResourceManager.SVConfigItem)localObject).check64BitReady())) {
          paramList = ((ShortVideoResourceManager.SVConfigItem)localObject).arm64v8a_url;
        } else {
          paramList = ((ShortVideoResourceManager.SVConfigItem)localObject).armv7a_url;
        }
        boolean bool = localIPreDownloadController.requestPreDownload(10091, null, ((ShortVideoResourceManager.SVConfigItem)localObject).name, 0, paramList, AEResUtil.a(((ShortVideoResourceManager.SVConfigItem)localObject).name), 4, 0, true, paramINet_ShortVideoResource);
        paramList = new StringBuilder();
        paramList.append("[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=");
        paramList.append(bool);
        AEQLog.b("AEResManager", paramList.toString());
        paramList = new StringBuilder();
        paramList.append("[startPreDownLoad] - END -, aeResInfo=");
        paramList.append(paramAEResInfo);
        AEQLog.b("AEResManager", paramList.toString());
        return bool;
      }
      AEQLog.b("AEResManager", "[startPreDownLoad], chosenConfigItem == nul");
      paramList = new StringBuilder();
      paramList.append("[startPreDownLoad] - END -, aeResInfo=");
      paramList.append(paramAEResInfo);
      AEQLog.b("AEResManager", paramList.toString());
      return false;
    }
    AEQLog.b("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
    paramList = new StringBuilder();
    paramList.append("[startPreDownLoad] - END -, aeResInfo=");
    paramList.append(paramAEResInfo);
    AEQLog.b("AEResManager", paramList.toString());
    return false;
  }
  
  private void b(@Nullable IAEDownloadCallBack paramIAEDownloadCallBack)
  {
    if (paramIAEDownloadCallBack == null) {
      return;
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (!localList.contains(paramIAEDownloadCallBack))) {
      this.jdField_b_of_type_JavaUtilList.add(paramIAEDownloadCallBack);
    }
  }
  
  public int a(@NonNull AEResInfo paramAEResInfo)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null)
    {
      paramAEResInfo = (Integer)localMap.get(paramAEResInfo);
      if (paramAEResInfo != null) {
        return paramAEResInfo.intValue();
      }
    }
    return 0;
  }
  
  public void a()
  {
    a().b(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
    a().b(AEResInfo.LIGHT_RES_BASE_PACKAGE, null, false);
    AEOldResManager.a().a(AEOldResInfo.b, null, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResultWithoutLogin] - BEGIN -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.9(this));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResultWithoutLogin] - END -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEResManager", localStringBuilder.toString());
  }
  
  public void a(@NonNull AEResInfo paramAEResInfo, @Nullable IAEDownloadCallBack paramIAEDownloadCallBack, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestDownload] - BEGIN -, aeResInfo=");
    localStringBuilder.append(paramAEResInfo);
    AEQLog.b("AEResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.1(this, paramAEResInfo, paramIAEDownloadCallBack, paramBoolean));
    paramIAEDownloadCallBack = new StringBuilder();
    paramIAEDownloadCallBack.append("[requestDownload] - END -, aeResInfo=");
    paramIAEDownloadCallBack.append(paramAEResInfo);
    AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
  }
  
  public void a(@Nullable IAEDownloadCallBack paramIAEDownloadCallBack)
  {
    if (paramIAEDownloadCallBack == null) {
      return;
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      localList.remove(paramIAEDownloadCallBack);
    }
  }
  
  public void b(@NonNull AEResInfo paramAEResInfo, @Nullable IAEDownloadCallBack paramIAEDownloadCallBack, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestDownload] - BEGIN -, aeResInfo=");
    localStringBuilder.append(paramAEResInfo);
    AEQLog.b("AEResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.2(this, paramAEResInfo, paramIAEDownloadCallBack, paramBoolean));
    paramIAEDownloadCallBack = new StringBuilder();
    paramIAEDownloadCallBack.append("[requestDownload] - END -, aeResInfo=");
    paramIAEDownloadCallBack.append(paramAEResInfo);
    AEQLog.b("AEResManager", paramIAEDownloadCallBack.toString());
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResult] - BEGIN -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.6(this));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResult] - END -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEResManager", localStringBuilder.toString());
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDownloadFinish] - BEGIN -, result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", filePath=");
    localStringBuilder.append(paramString2);
    AEQLog.b("AEResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.7(this, paramString1, paramInt, paramString2));
    AEQLog.b("AEResManager", "[onDownloadFinish] - END -");
  }
  
  public void onNetWorkNone()
  {
    AEQLog.d("AEResManager", HardCodeUtil.a(2131700225));
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEResManager.8(this, paramString, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResManager
 * JD-Core Version:    0.7.0.1
 */