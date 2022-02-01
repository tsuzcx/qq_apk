package com.tencent.aelight.camera.ae.download.old;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.download.old.api.AEOldDownloadCallBack;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.INet_ShortVideoResource;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResStatus.ISVConfig;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResStatus.ISVConfig_V2;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AEOldResManager
  implements AEOldShortVideoResManager.INet_ShortVideoResource, AEOldShortVideoResStatus.ISVConfig, AEOldShortVideoResStatus.ISVConfig_V2
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AEOldResManagerHandlerThread", 0);
  private List<AEOldShortVideoResManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<AEOldResInfo, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<AEOldResInfo> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private List<AEOldDownloadCallBack> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<AEOldResInfo, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private AEOldResManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static AEOldResManager a()
  {
    return AEOldResManager.InstanceHolder.a;
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
  
  private void a(@Nullable AEOldDownloadCallBack paramAEOldDownloadCallBack)
  {
    if (paramAEOldDownloadCallBack == null) {
      return;
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (!localList.contains(paramAEOldDownloadCallBack))) {
      this.jdField_b_of_type_JavaUtilList.add(paramAEOldDownloadCallBack);
    }
  }
  
  private void a(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldDownloadCallBack paramAEOldDownloadCallBack)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadWithoutLoginInternal] - BEGIN -, packageIndex=");
    ((StringBuilder)localObject).append(paramAEOldResInfo.jdField_a_of_type_Int);
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEOldResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEOldResInfo)).intValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadWithoutLoginInternal], status=");
    ((StringBuilder)localObject).append(a(i));
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    localObject = null;
    if (i == 4)
    {
      i = AEOldResUtil.a(paramAEOldResInfo.jdField_a_of_type_Int);
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAEOldResInfo.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(i);
        localObject = AEOldResUtil.a(((StringBuilder)localObject).toString());
      }
      if (paramAEOldDownloadCallBack != null) {
        paramAEOldDownloadCallBack.a(paramAEOldResInfo, (String)localObject, true, 0);
      }
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadWithoutLoginInternal], packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      paramAEOldDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      return;
    }
    if (i == 3)
    {
      a(paramAEOldDownloadCallBack);
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadWithoutLoginInternal], packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      paramAEOldDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(null))
    {
      if (paramAEOldDownloadCallBack != null) {
        paramAEOldDownloadCallBack.a(paramAEOldResInfo, null, false, -6);
      }
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadWithoutLoginInternal], packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      paramAEOldDownloadCallBack.append(", networkStatus=UNUSABLE");
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadWithoutLoginInternal], packageIndex=");
    ((StringBuilder)localObject).append(paramAEOldResInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", networkStatus=USABLE");
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    a(paramAEOldDownloadCallBack);
    if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEOldResInfo))
    {
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEOldResInfo);
      this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(1));
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo))
    {
      this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo, Integer.valueOf(3));
      AEOldShortVideoResDownload.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
    }
    else if ((this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo)).intValue() == 4))
    {
      b(1, 0);
    }
    paramAEOldDownloadCallBack = new StringBuilder();
    paramAEOldDownloadCallBack.append("[requestDownloadWithoutLoginInternal] - END -, packageIndex=");
    paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
    AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
  }
  
  private void a(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadInternal] - BEGIN -, packageIndex=");
    ((StringBuilder)localObject).append(paramAEOldResInfo.jdField_a_of_type_Int);
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAEOldResInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramAEOldResInfo)).intValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadInternal], status=");
    ((StringBuilder)localObject).append(a(i));
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    localObject = null;
    if (i == 4)
    {
      i = AEOldResUtil.a(paramAEOldResInfo.jdField_a_of_type_Int);
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAEOldResInfo.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(i);
        localObject = AEOldResUtil.a(((StringBuilder)localObject).toString());
      }
      if (paramAEOldDownloadCallBack != null) {
        paramAEOldDownloadCallBack.a(paramAEOldResInfo, (String)localObject, true, 0);
      }
      AEOldResUtil.a(paramAEOldResInfo, (String)localObject);
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal], packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      paramAEOldDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_READY");
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      return;
    }
    if (i == 3)
    {
      a(paramAEOldDownloadCallBack);
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal], packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      paramAEOldDownloadCallBack.append(", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      return;
    }
    if ((NetworkUtil.isNetworkAvailable(null)) && ((!paramBoolean1) || (NetworkUtil.isWifiConnected(null)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (paramAEOldDownloadCallBack != null) {
        paramAEOldDownloadCallBack.a(paramAEOldResInfo, null, false, -6);
      }
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal], packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      paramAEOldDownloadCallBack.append(", networkStatus=UNUSABLE");
      AEQLog.d("AEOldResManager", paramAEOldDownloadCallBack.toString());
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDownloadInternal], packageIndex=");
    ((StringBuilder)localObject).append(paramAEOldResInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", networkStatus=USABLE");
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    a(paramAEOldDownloadCallBack);
    if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramAEOldResInfo))
    {
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEOldResInfo);
      this.jdField_a_of_type_JavaUtilMap.put(paramAEOldResInfo, Integer.valueOf(1));
    }
    if ((paramAEOldResInfo.jdField_b_of_type_Boolean) && (paramBoolean2)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    paramAEOldResInfo.jdField_b_of_type_Boolean = paramBoolean1;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo))
    {
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal] 强制拉取配置列表");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo, Integer.valueOf(3));
      AEOldShortVideoResManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
    }
    else if ((this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo) != null) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo)).intValue() == 4))
    {
      paramAEOldDownloadCallBack = new StringBuilder();
      paramAEOldDownloadCallBack.append("[requestDownloadInternal] 配置列表已经存在, packageIndex = ");
      paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
      AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
      a(1, 0);
    }
    paramAEOldDownloadCallBack = new StringBuilder();
    paramAEOldDownloadCallBack.append("[requestDownloadInternal] - END -, packageIndex=");
    paramAEOldDownloadCallBack.append(paramAEOldResInfo.jdField_a_of_type_Int);
    AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
  }
  
  private void a(@NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEOldResInfo paramAEOldResInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[cancelPreDownLoad] - BEGIN -, aeResInfo=");
    ((StringBuilder)localObject).append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    paramQQAppInterface = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (AEOldShortVideoResManager.SVConfigItem)((Iterator)localObject).next();
      if (paramList.name.startsWith(paramAEOldResInfo.jdField_b_of_type_JavaLangString))
      {
        AEQLog.b("AEOldResManager", "[cancelPreDownLoad], chosenConfigItem matched");
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
      AEQLog.b("AEOldResManager", paramList.toString());
    }
    paramList = new StringBuilder();
    paramList.append("[cancelPreDownLoad] - END -, aeResInfo=");
    paramList.append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", paramList.toString());
  }
  
  private void a(@NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    AEQLog.b("AEOldResManager", "[startDownLoad] + BEGIN");
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilQueue))
    {
      AEQLog.d("AEOldResManager", "[startDownLoad], mDownLoadTaskQueue is empty");
      AEQLog.b("AEOldResManager", "[startDownLoad] - END -");
      return;
    }
    AEOldResInfo localAEOldResInfo = (AEOldResInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localAEOldResInfo == null)
    {
      AEQLog.d("AEOldResManager", "[startDownLoad], mDownLoadTaskQueue top element is null");
      AEQLog.b("AEOldResManager", "[startDownLoad] + END");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localAEOldResInfo))
    {
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localAEOldResInfo)).intValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[startDownLoad], resNeedDownload=");
      localStringBuilder.append(localAEOldResInfo);
      AEQLog.a("AEOldResManager", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[startDownLoad], status=");
      localStringBuilder.append(a(i));
      AEQLog.a("AEOldResManager", localStringBuilder.toString());
      if ((!paramBoolean) && (localAEOldResInfo.jdField_b_of_type_Boolean))
      {
        AEQLog.b("AEOldResManager", "[startDownLoad], isDownLoadImmediately=false");
        if (i != 3)
        {
          if (i == 2) {
            return;
          }
          if (!a(paramList, this, paramQQAppInterface, localAEOldResInfo))
          {
            a(paramList, paramQQAppInterface, localAEOldResInfo);
            localAEOldResInfo.jdField_b_of_type_Boolean = false;
            this.jdField_b_of_type_JavaUtilMap.put(localAEOldResInfo, Long.valueOf(System.currentTimeMillis()));
            AEQLog.b("AEOldResManager", "[startDownLoad], realDownloadResource()");
            this.jdField_a_of_type_JavaUtilMap.put(localAEOldResInfo, Integer.valueOf(3));
            AEOldResDownload.a(localAEOldResInfo, paramList, this);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilMap.put(localAEOldResInfo, Integer.valueOf(2));
          }
        }
      }
      else
      {
        AEQLog.b("AEOldResManager", "[startDownLoad], isDownLoadImmediately=true");
        if (i != 3)
        {
          this.jdField_a_of_type_JavaUtilMap.put(localAEOldResInfo, Integer.valueOf(3));
          if (i == 2) {
            a(paramList, paramQQAppInterface, localAEOldResInfo);
          }
          this.jdField_b_of_type_JavaUtilMap.put(localAEOldResInfo, Long.valueOf(System.currentTimeMillis()));
          AEQLog.b("AEOldResManager", "[startDownLoad], realDownloadResource()");
          AEOldResDownload.a(localAEOldResInfo, paramList, this);
        }
      }
      AEQLog.b("AEOldResManager", "[startDownLoad] + END");
      return;
    }
    AEQLog.d("AEOldResManager", "[startDownLoad], cannot find resNeedDownload in mStatusMap");
    AEQLog.b("AEOldResManager", "[startDownLoad] + END");
  }
  
  private void a(boolean paramBoolean)
  {
    AEQLog.b("AEOldResManager", "[onConfigResultInternal] ++++++ BEGIN");
    int i;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 内存中'还没有'列表信息，开始生成配置列表");
      i = AEOldShortVideoResManager.a(null, this.jdField_a_of_type_JavaUtilList);
    }
    else
    {
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 内存中'已经有'列表信息，执行检查刷新列表");
      localObject1 = new LinkedList();
      i = AEOldShortVideoResManager.a(null, (List)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onConfigResultInternal] 内存中'已经有'列表信息，刷新后列表为 = ");
      ((StringBuilder)localObject2).append(localObject1);
      AEQLog.b("AEOldResManager", ((StringBuilder)localObject2).toString());
      if ((i == 0) && (((List)localObject1).size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onConfigResultInternal] 生成配置列表结果 errCode = ");
    ((StringBuilder)localObject1).append(i);
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onConfigResultInternal] 内存中'当前的'配置列表信息，size = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject1).toString());
    int j = i;
    if (i == 0) {
      j = AEOldResUtil.a(this.jdField_a_of_type_JavaUtilList);
    }
    localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (j == 0)
    {
      this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo, Integer.valueOf(4));
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 配置列表拉取成功，开始进行ZIP包下载");
      a(new LinkedList(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject1, paramBoolean ^ true);
    }
    else
    {
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 配置列表拉取失败，尝试构造内置列表进行下载");
      localObject2 = AEOldLocalConfig.jdField_a_of_type_JavaUtilList;
      if (((List)localObject2).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      this.jdField_a_of_type_JavaUtilMap.put(AEOldResInfo.jdField_a_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo, Integer.valueOf(4));
      AEQLog.b("AEOldResManager", "[onConfigResultInternal] 构造内置列表成功，开始下载");
      a(new LinkedList(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject1, paramBoolean ^ true);
    }
    AEQLog.b("AEOldResManager", "[onConfigResultInternal] ++++++ END");
  }
  
  private boolean a(@NonNull List<AEOldShortVideoResManager.SVConfigItem> paramList, @NonNull AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource, @NonNull QQAppInterface paramQQAppInterface, @NonNull AEOldResInfo paramAEOldResInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[startPreDownLoad] - BEGIN -, aeResInfo=");
    ((StringBuilder)localObject).append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject).toString());
    IPreDownloadController localIPreDownloadController = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (AEOldShortVideoResManager.SVConfigItem)localIterator.next();
      if (((AEOldShortVideoResManager.SVConfigItem)localObject).name.startsWith(paramAEOldResInfo.jdField_b_of_type_JavaLangString))
      {
        AEQLog.b("AEOldResManager", "[startPreDownLoad], chosenConfigItem matched");
        break label108;
      }
    }
    localObject = null;
    label108:
    if ((localIPreDownloadController != null) && (localIPreDownloadController.isEnable()))
    {
      paramINet_ShortVideoResource = new AEOldResManager.9(this, paramQQAppInterface, "ae_camera_res", new AEOldResManager.8(this, paramAEOldResInfo, paramList, paramINet_ShortVideoResource), 4000L);
      if (localObject != null)
      {
        if ((VideoEnvironment64BitUtils.checkIs64bit()) && (((AEOldShortVideoResManager.SVConfigItem)localObject).check64BitReady())) {
          paramList = ((AEOldShortVideoResManager.SVConfigItem)localObject).arm64v8a_url;
        } else {
          paramList = ((AEOldShortVideoResManager.SVConfigItem)localObject).armv7a_url;
        }
        boolean bool = localIPreDownloadController.requestPreDownload(10091, null, ((AEOldShortVideoResManager.SVConfigItem)localObject).name, 0, paramList, AEOldResUtil.a(((AEOldShortVideoResManager.SVConfigItem)localObject).name), 4, 0, true, paramINet_ShortVideoResource);
        paramList = new StringBuilder();
        paramList.append("[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=");
        paramList.append(bool);
        AEQLog.b("AEOldResManager", paramList.toString());
        paramList = new StringBuilder();
        paramList.append("[startPreDownLoad] - END -, aeResInfo=");
        paramList.append(paramAEOldResInfo);
        AEQLog.b("AEOldResManager", paramList.toString());
        return bool;
      }
      AEQLog.b("AEOldResManager", "[startPreDownLoad], chosenConfigItem == nul");
      paramList = new StringBuilder();
      paramList.append("[startPreDownLoad] - END -, aeResInfo=");
      paramList.append(paramAEOldResInfo);
      AEQLog.b("AEOldResManager", paramList.toString());
      return false;
    }
    AEQLog.b("AEOldResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
    paramList = new StringBuilder();
    paramList.append("[startPreDownLoad] - END -, aeResInfo=");
    paramList.append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", paramList.toString());
    return false;
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onDownloadFinishInternal] - BEGIN -, result=");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", name=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(", filePath=");
    ((StringBuilder)localObject1).append(paramString2);
    AEQLog.b("AEOldResManager", ((StringBuilder)localObject1).toString());
    localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "";
    }
    int i;
    if ((paramInt != 0) && (paramInt != 1)) {
      i = paramInt;
    } else {
      i = 0;
    }
    Object localObject2 = AEOldResInfo.jdField_b_of_type_ArrayOfComTencentAelightCameraDownloadOldApiAEOldResInfo;
    int k = localObject2.length;
    int j = 0;
    while (j < k)
    {
      paramString1 = localObject2[j];
      if (((String)localObject1).startsWith(paramString1.jdField_b_of_type_JavaLangString))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[onDownloadFinishInternal], matched aeResInfo=");
        ((StringBuilder)localObject2).append(paramString1);
        AEQLog.b("AEOldResManager", ((StringBuilder)localObject2).toString());
        if (i == 0)
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(4));
          this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
          AEOldResUtil.a(paramString1, paramString2);
          j = Integer.valueOf(((String)localObject1).substring(paramString1.jdField_b_of_type_JavaLangString.length())).intValue();
          AEOldResUtil.a(paramString1.jdField_a_of_type_Int, j);
        }
        else
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString1, Integer.valueOf(0));
          this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
        }
        localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AEOldDownloadCallBack)((Iterator)localObject1).next();
          boolean bool;
          if (i == 0) {
            bool = true;
          } else {
            bool = false;
          }
          ((AEOldDownloadCallBack)localObject2).a(paramString1, paramString2, bool, i);
        }
        if ((paramInt != 1) && (this.jdField_b_of_type_JavaUtilMap.get(paramString1) != null))
        {
          System.currentTimeMillis();
          ((Long)this.jdField_b_of_type_JavaUtilMap.get(paramString1)).longValue();
        }
        AEQLog.b("AEOldResManager", "[onDownloadFinishInternal], start download next package");
        paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        a(new LinkedList(this.jdField_a_of_type_JavaUtilList), paramString1, true);
        break;
      }
      j += 1;
    }
    AEQLog.b("AEOldResManager", "[onDownloadFinishInternal] - END -");
  }
  
  private void b(String paramString, long paramLong1, long paramLong2)
  {
    if (paramString == null) {
      paramString = "";
    }
    AEOldResInfo[] arrayOfAEOldResInfo = AEOldResInfo.jdField_b_of_type_ArrayOfComTencentAelightCameraDownloadOldApiAEOldResInfo;
    int j = arrayOfAEOldResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEOldResInfo localAEOldResInfo = arrayOfAEOldResInfo[i];
      if (paramString.startsWith(localAEOldResInfo.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localAEOldResInfo, Integer.valueOf(3));
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((AEOldDownloadCallBack)localIterator.next()).a(localAEOldResInfo, paramLong1, paramLong2);
        }
      }
      i += 1;
    }
  }
  
  public void a()
  {
    AEQLog.d("AEOldResManager", HardCodeUtil.a(2131700225));
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResult] - BEGIN -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.4(this));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResult] - END -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
  }
  
  public void a(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestDownload] - BEGIN -, aeResInfo=");
    localStringBuilder.append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.1(this, paramAEOldResInfo, paramAEOldDownloadCallBack, paramBoolean));
    paramAEOldDownloadCallBack = new StringBuilder();
    paramAEOldDownloadCallBack.append("[requestDownload] - END -, aeResInfo=");
    paramAEOldDownloadCallBack.append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDownloadFinish] - BEGIN -, result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", filePath=");
    localStringBuilder.append(paramString2);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.6(this, paramString1, paramInt, paramString2));
    AEQLog.b("AEOldResManager", "[onDownloadFinish] - END -");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.7(this, paramString, paramLong1, paramLong2));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResultWithoutLogin] - BEGIN -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.5(this));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onConfigResultWithoutLogin] - END -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
  }
  
  public void b(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestDownload] - BEGIN -, AEOldResInfo=");
    localStringBuilder.append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new AEOldResManager.3(this, paramAEOldResInfo, paramAEOldDownloadCallBack, paramBoolean));
    paramAEOldDownloadCallBack = new StringBuilder();
    paramAEOldDownloadCallBack.append("[requestDownload] - END -, AEOldResInfo=");
    paramAEOldDownloadCallBack.append(paramAEOldResInfo);
    AEQLog.b("AEOldResManager", paramAEOldDownloadCallBack.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldResManager
 * JD-Core Version:    0.7.0.1
 */