package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.dataline.activities.PrinterDefaultActivity;
import com.dataline.data.PrinterManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.messageclean.MessageDeleteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDataline;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop;
import com.tencent.mobileqq.filemanager.guild.VideoForGuild;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qqfav.QfavBuilder;
import cooperation.weiyun.WeiyunAIOUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AIOImageProviderService
  extends IAIOImageProvider.Stub
{
  public static final HashMap<String, AIOImageProviderService> r = new HashMap();
  private BizTroopObserver A;
  private HashMap<String, MessageForTroopFile> B;
  String a;
  String b;
  int c;
  int d;
  boolean e = false;
  boolean f = false;
  long g;
  final List<ChatMessage> h = Collections.synchronizedList(new LinkedList());
  final List<AIORichMediaData> i = Collections.synchronizedList(new LinkedList());
  volatile boolean j = false;
  volatile boolean k = false;
  long l = 9223372036854775807L;
  long m = 9223372036854775807L;
  int n = 3;
  long o = 9223372036854775807L;
  int p = 60;
  int q = 0;
  WeakReferenceHandler s;
  WeakReference<BaseActivity> t = null;
  AIOImageProviderService.AIOImageProviderListener u;
  FMObserver v;
  AIOImageProviderService.DatalineFileObserver w;
  ArrayList<Long> x = new ArrayList();
  private AIOImageProviderService.IncreasinglyLoadMediaTask z = new AIOImageProviderService.IncreasinglyLoadMediaTask(this);
  
  protected AIOImageProviderService() {}
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    if (paramChatMessage != null)
    {
      this.e = paramChatMessage.isMultiMsg;
      this.g = paramChatMessage.msgseq;
      this.h.add(paramChatMessage);
      if (UinTypeUtil.e(paramChatMessage.istroop) == 1032) {
        this.d = paramChatMessage.getConfessTopicId();
      }
    }
    this.s = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), null);
    this.f = ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage);
    if ((!this.e) && (!ApolloClassFactoryApi.e().isInstance(paramChatMessage)))
    {
      paramString2 = e();
      paramChatMessage = (AIOImageProviderService)r.get(paramString2);
      if (paramChatMessage != null) {
        paramChatMessage.a();
      }
      r.put(paramString2, this);
    }
    try
    {
      paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(paramString1);
      a(paramString1);
      b(paramString1);
      c(paramString1);
      QLog.e("AIOImageProviderService", 1, "～～～～～～～call AIOImageProviderService～～～～～～～");
    }
    catch (AccountNotMatchException paramString1)
    {
      paramString1.printStackTrace();
    }
    paramString1 = BaseActivity.sTopActivity;
    if (paramString1 != null)
    {
      this.t = new WeakReference(paramString1);
      return;
    }
    b("Static Null", "Init");
  }
  
  public static AIOImageProviderService a(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    if ((paramBoolean) && ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg))) {
      localObject1 = (AIOImageProviderService)r.get(localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new AIOImageProviderService(paramString1, paramString2, paramInt, paramChatMessage);
    }
    return localObject2;
  }
  
  private BaseActivity a(String paramString)
  {
    Object localObject2 = BaseActivity.sTopActivity;
    if (localObject2 != null)
    {
      this.t = new WeakReference(localObject2);
      return localObject2;
    }
    Object localObject1 = this.t;
    if (localObject1 != null)
    {
      localObject2 = (BaseActivity)((WeakReference)localObject1).get();
      localObject1 = null;
    }
    else
    {
      localObject1 = "WeakReference Null";
    }
    if (localObject2 != null) {
      return localObject2;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "WeakReference has freed";
    }
    b((String)localObject2, paramString);
    return null;
  }
  
  private String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ChatMessage localChatMessage = a(paramLong);
    if (localChatMessage == null) {
      return null;
    }
    if (MessageForFile.class.isInstance(localChatMessage)) {
      return FileManagerUtil.a(paramQQAppInterface, (MessageForFile)localChatMessage).getFilePath();
    }
    if (MessageForTroopFile.class.isInstance(localChatMessage)) {
      return TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)localChatMessage).r;
    }
    return null;
  }
  
  private void a(int paramInt, String paramString, AIOFilePicData paramAIOFilePicData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 16)
      {
        if (paramInt != 18)
        {
          if (paramInt != 20) {
            return;
          }
          paramAIOFilePicData.h = true;
          return;
        }
        paramAIOFilePicData.g = true;
        return;
      }
      paramAIOFilePicData.i = true;
      return;
    }
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          return;
        }
        paramAIOFilePicData.e = paramString;
        return;
      }
      paramAIOFilePicData.d = paramString;
      return;
    }
    paramAIOFilePicData.c = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOImageData paramAIOImageData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return;
          }
          paramAIOImageData.g = true;
          return;
        }
        paramAIOImageData.f = true;
        return;
      }
      paramAIOImageData.e = true;
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            return;
          }
          paramAIOImageData.d = paramString;
          return;
        }
        paramAIOImageData.c = paramString;
        return;
      }
      paramAIOImageData.b = paramString;
      if (!paramAIOImageData.t)
      {
        paramString = new StringBuilder();
        paramString.append(paramAIOImageData.a);
        paramString.append("_hd");
        if (new File(paramString.toString()).exists())
        {
          paramString = new StringBuilder();
          paramString.append(paramAIOImageData.a);
          paramString.append("_hd");
          paramAIOImageData.a = paramString.toString();
        }
      }
    }
    else
    {
      paramAIOImageData.a = paramString;
    }
  }
  
  private void a(int paramInt, String paramString, AIOShortVideoData paramAIOShortVideoData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        paramAIOShortVideoData.f = true;
        return;
      }
      paramAIOShortVideoData.e = true;
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramAIOShortVideoData.b = paramString;
      return;
    }
    paramAIOShortVideoData.a = paramString;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, BaseVideoBiz paramBaseVideoBiz)
  {
    IFileVideoDownloader localIFileVideoDownloader = FileVideoDownloadManager.b(paramBaseVideoBiz);
    localIFileVideoDownloader.a(new AIOImageProviderService.7(this, paramBaseVideoBiz, paramLong, paramInt1, paramInt2));
    localIFileVideoDownloader.a(new AIOImageProviderService.8(this, paramBaseVideoBiz, paramLong));
    localIFileVideoDownloader.a(true);
    localIFileVideoDownloader.c();
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, long paramLong, int paramInt)
  {
    String str = paramChatMessage.frienduin;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramChatMessage = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onFileVideoStatusChange[");
        paramQQAppInterface.append(paramInt);
        paramQQAppInterface.append("], info == null");
        QLog.i("VideoPlayControllerForFile.main", 2, paramQQAppInterface.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set mobileqq video pause id:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" troopId:");
      localStringBuilder.append(paramChatMessage.a);
      QLog.i("VideoPlayControllerForFile.main", 1, localStringBuilder.toString());
    }
    TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(str).longValue()).e(paramChatMessage.a);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if (paramQQAppInterface != null)
    {
      if (paramMessageForPic == null) {
        return;
      }
      ((IPicPreDownload)paramQQAppInterface.getRuntimeService(IPicPreDownload.class)).payPicFlow(paramMessageForPic);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
    if ((paramTroopFileStatusInfo.e == 11) && (FileUtils.fileExists(paramTroopFileStatusInfo.k)))
    {
      if (this.y != null) {
        this.y.a(paramLong, paramInt1, paramInt2, 1, paramTroopFileStatusInfo.k, false);
      }
    }
    else
    {
      if ((paramTroopFileStatusInfo.e != 7) && ((paramTroopFileStatusInfo.e != 11) || (FileUtils.fileExists(paramTroopFileStatusInfo.k))))
      {
        paramQQAppInterface.d(paramTroopFileStatusInfo.a);
        return;
      }
      paramQQAppInterface.a(paramTroopFileStatusInfo.r, paramTroopFileStatusInfo.t, paramTroopFileStatusInfo.i, paramTroopFileStatusInfo.u);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.m))
    {
      if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getApplication()))
      {
        if (this.y != null) {
          this.y.a(paramMessageForTroopFile.uniseq, 0, 18, 2, paramTroopFileStatusInfo.m, false);
        }
        return;
      }
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (paramTroopFileStatusInfo.a != null)
      {
        paramQQAppInterface.a(paramTroopFileStatusInfo.a, 640);
        return;
      }
      paramQQAppInterface.a(paramTroopFileStatusInfo.r, paramTroopFileStatusInfo.t, paramTroopFileStatusInfo.u, 640);
      return;
    }
    if (this.y != null) {
      this.y.a(paramMessageForTroopFile.uniseq, 0, 18, 1, paramTroopFileStatusInfo.m, false);
    }
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = d();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    int i1 = FileManagerUtil.c(paramDataLineMsgRecord.filename);
    if (i1 == 2)
    {
      a(paramLong, paramInt1, paramInt2, new VideoForDataline((QQAppInterface)localObject, paramDataLineMsgRecord));
      return;
    }
    if (i1 == 0)
    {
      localObject = (DataLineHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
      ((DataLineHandler)localObject).b(localArrayList);
    }
  }
  
  private void a(MessageForDLFile paramMessageForDLFile)
  {
    QQAppInterface localQQAppInterface = d();
    if (localQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    int i1 = paramMessageForDLFile.deviceType;
    long l1 = paramMessageForDLFile.associatedId;
    paramMessageForDLFile = localQQAppInterface.getMessageFacade().d(i1);
    if (paramMessageForDLFile == null) {
      return;
    }
    paramMessageForDLFile = paramMessageForDLFile.a(l1);
    ((DataLineHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMessageForDLFile.groupId, paramMessageForDLFile.sessionid, false);
  }
  
  private void a(MessageForDLFile paramMessageForDLFile, long paramLong, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = d();
    if (localQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    int i1 = paramMessageForDLFile.deviceType;
    long l1 = paramMessageForDLFile.associatedId;
    paramMessageForDLFile = localQQAppInterface.getMessageFacade().d(i1);
    if (paramMessageForDLFile == null) {
      return;
    }
    paramMessageForDLFile = paramMessageForDLFile.a(l1);
    if (paramMessageForDLFile == null) {
      return;
    }
    i1 = FileManagerUtil.c(paramMessageForDLFile.filename);
    if ((paramInt2 != 20) && (i1 != 2))
    {
      b(paramMessageForDLFile, paramLong, paramInt1, paramInt2);
      return;
    }
    a(paramMessageForDLFile, paramLong, paramInt1, paramInt2);
  }
  
  private void a(MessageForFile paramMessageForFile, long paramLong)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      paramMessageForFile = FileManagerUtil.a(localQQAppInterface, paramMessageForFile);
      localQQAppInterface.getFileManagerEngine().a(paramMessageForFile.nSessionId);
      return;
    }
    catch (Exception paramMessageForFile)
    {
      label36:
      break label36;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.shmsgseq < this.m) {
      this.m = paramMessageRecord.shmsgseq;
    }
    if (paramMessageRecord.versionCode < this.n) {
      this.n = paramMessageRecord.versionCode;
    }
    if ((paramMessageRecord.getId() > 0L) && (paramMessageRecord.getId() < this.l)) {
      this.l = paramMessageRecord.getId();
    }
    if (paramMessageRecord.time < this.o) {
      this.o = paramMessageRecord.time;
    }
  }
  
  private void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageForTroopFile paramMessageForTroopFile)
  {
    int i3 = FileManagerUtil.c(paramMessageForTroopFile.fileName);
    int i2 = 1;
    int i1;
    if (i3 == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i3 != 2) {
      i2 = 0;
    }
    Object localObject = TroopFileUtils.a(d(), paramMessageForTroopFile);
    if (localObject == null) {
      return;
    }
    if (i1 != 0)
    {
      localObject = AIOGalleryUtils.a(paramMessageForTroopFile, d());
      if (localObject != null)
      {
        paramList.add(localObject);
        paramList1.add(paramMessageForTroopFile);
      }
    }
    else if ((i2 != 0) && ((FileUtil.b(((TroopFileStatusInfo)localObject).k)) || (QFileUtils.a(d()))))
    {
      localObject = AIOGalleryUtils.a(paramMessageForTroopFile, d());
      if (localObject != null)
      {
        paramList.add(localObject);
        paramList1.add(paramMessageForTroopFile);
      }
    }
  }
  
  public static boolean a(AIORichMediaData paramAIORichMediaData)
  {
    boolean bool2 = AIOShortVideoData.class.isInstance(paramAIORichMediaData);
    boolean bool1 = false;
    if (bool2)
    {
      paramAIORichMediaData = (AIOShortVideoData)paramAIORichMediaData;
      return false;
    }
    if (AIOFileVideoData.class.isInstance(paramAIORichMediaData)) {
      return false;
    }
    if (AIOLightVideoData.class.isInstance(paramAIORichMediaData)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static Intent b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "Forward menu clicked, md5 is empty.");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    String str1 = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", SVUtils.a(paramMessageForShortVideo));
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Forward menu clicked, videoPath=");
      localStringBuilder.append(str2);
      localStringBuilder.append(",videoPath = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMessageForShortVideo.toLogString());
      QLog.d("AIOImageProviderService", 2, localStringBuilder.toString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    if (FileUtils.fileExistsAndNotEmpty(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
    }
    return new Intent().putExtras(localBundle);
  }
  
  private Intent b(MessageForTroopFile paramMessageForTroopFile)
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      localObject1 = TroopFileUtils.a((QQAppInterface)localObject1, paramMessageForTroopFile);
      if (localObject1 == null)
      {
        QLog.w("AIOImageProviderService", 1, "getFileStatusInfo is null");
        return null;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      Object localObject2 = FileManagerUtil.a((TroopFileStatusInfo)localObject1);
      ((FileManagerEntity)localObject2).status = 2;
      ((FileManagerEntity)localObject2).nOpType = 24;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
      localForwardFileInfo.b(10006);
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).getFilePath())) {
        localForwardFileInfo.a(((TroopFileStatusInfo)localObject1).k);
      }
      localForwardFileInfo.d(((TroopFileStatusInfo)localObject1).t);
      localForwardFileInfo.d(((TroopFileStatusInfo)localObject1).i);
      localForwardFileInfo.a(Long.parseLong(paramMessageForTroopFile.frienduin));
      if (((TroopFileStatusInfo)localObject1).a != null) {
        localForwardFileInfo.e(((TroopFileStatusInfo)localObject1).a.toString());
      }
      if (!TextUtils.isEmpty(((TroopFileStatusInfo)localObject1).m)) {
        localForwardFileInfo.f(((TroopFileStatusInfo)localObject1).m);
      } else if (!TextUtils.isEmpty(((TroopFileStatusInfo)localObject1).n)) {
        localForwardFileInfo.f(((TroopFileStatusInfo)localObject1).n);
      }
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras(localBundle);
      ((Intent)localObject2).putExtra("forward_text", ((TroopFileStatusInfo)localObject1).t);
      ((Intent)localObject2).putExtra("forward_from_troop_file", true);
      ((Intent)localObject2).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject2).putExtra("forward _key_nojump", false);
      ((Intent)localObject2).putExtra("sender_uin", paramMessageForTroopFile.senderuin);
      ((Intent)localObject2).putExtra("last_time", paramMessageForTroopFile.lastTime);
      return localObject2;
    }
    catch (AccountNotMatchException paramMessageForTroopFile)
    {
      paramMessageForTroopFile.printStackTrace();
    }
    return null;
  }
  
  private ChatMessage b(long paramLong1, long paramLong2)
  {
    label117:
    Object localObject2;
    synchronized (this.h)
    {
      Iterator localIterator = this.h.iterator();
      ChatMessage localChatMessage;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label117;
        }
        localChatMessage = (ChatMessage)localIterator.next();
        if (MessageForPic.class.isInstance(localChatMessage))
        {
          MessageForPic localMessageForPic = (MessageForPic)localChatMessage;
          if ((paramLong1 == localMessageForPic.uniseq) && (paramLong2 == localMessageForPic.subMsgId)) {
            break;
          }
        }
        else if (paramLong1 == localChatMessage.uniseq)
        {
          break;
        }
      }
      return localChatMessage;
    }
  }
  
  private MessageForTroopFile b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    ??? = this.B;
    Object localObject1 = localObject2;
    if (??? != null)
    {
      localObject1 = localObject2;
      if (!((HashMap)???).isEmpty()) {
        localObject1 = (MessageForTroopFile)this.B.get(paramString);
      }
    }
    if (localObject1 == null) {
      synchronized (this.h)
      {
        Iterator localIterator = this.h.iterator();
        do
        {
          do
          {
            localObject2 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (ChatMessage)localIterator.next();
          } while (!MessageForTroopFile.class.isInstance(localObject2));
          localObject2 = (MessageForTroopFile)localObject2;
        } while ((TextUtils.isEmpty(((MessageForTroopFile)localObject2).url)) || (!((MessageForTroopFile)localObject2).url.equals(paramString)));
        if ((this.B != null) && (localObject2 != null)) {
          this.B.put(paramString, localObject2);
        }
        return localObject2;
      }
    }
    return localObject1;
  }
  
  private void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, long paramLong, int paramInt)
  {
    Object localObject = paramChatMessage.frienduin;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    paramChatMessage = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onFileVideoStatusChange[");
        paramQQAppInterface.append(paramInt);
        paramQQAppInterface.append("], info == null");
        QLog.i("VideoPlayControllerForFile.main", 2, paramQQAppInterface.toString());
      }
      return;
    }
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf((String)localObject).longValue());
    localObject = paramQQAppInterface.i(paramChatMessage.a);
    if (FileUtil.b(paramChatMessage.k))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Play id:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" type: FILE_VIDEO_PEEK_PAUSE file is exsited");
        QLog.i("troop VideoPlayControllerForFile.main", 1, ((StringBuilder)localObject).toString());
      }
      if (13 == paramInt)
      {
        localObject = BaseApplicationImpl.sApplication.getBaseContext();
        if (localObject != null) {
          FileManagerUtil.a((Context)localObject, paramChatMessage.k);
        } else {
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
        }
      }
      paramChatMessage = paramQQAppInterface.i(paramChatMessage.a);
      if (paramChatMessage != null) {
        paramQQAppInterface.b(paramChatMessage, 11);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set mobileqq video Play id:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" troopId:");
      localStringBuilder.append(paramChatMessage.a);
      QLog.i("VideoPlayControllerForFile.main", 1, localStringBuilder.toString());
    }
    if (localObject != null) {
      paramQQAppInterface.b((TroopFileTransferManager.Item)localObject, 8);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.n))
    {
      if ((!NetworkUtil.isNetSupport(BaseApplicationImpl.getApplication())) && (this.y != null)) {
        this.y.a(paramMessageForTroopFile.uniseq, 0, 16, 2, paramTroopFileStatusInfo.m, false);
      }
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (paramTroopFileStatusInfo.a != null)
      {
        paramQQAppInterface.a(paramTroopFileStatusInfo.a, 383);
        return;
      }
      paramQQAppInterface.a(paramTroopFileStatusInfo.r, paramTroopFileStatusInfo.t, paramTroopFileStatusInfo.u, 383);
      return;
    }
    if (this.y != null) {
      this.y.a(paramMessageForTroopFile.uniseq, 0, 1, 1, paramTroopFileStatusInfo.n, false);
    }
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord, long paramLong, int paramInt1, int paramInt2)
  {
    if (d() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    FileManagerUtil.c(paramDataLineMsgRecord.filename);
  }
  
  private void b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localHashMap.put("result", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("fromaction", paramString1);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ImageProviderService_getTopActivity_event", false, 0L, 0L, localHashMap, null);
  }
  
  private void b(List<AIORichMediaData> paramList)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.y;
    ArrayList localArrayList;
    int i1;
    Object localObject;
    List localList;
    if (localIAIOImageProviderCallBack != null)
    {
      localArrayList = new ArrayList();
      i1 = this.c;
      if ((i1 != 1) && (i1 != 1026)) {
        localObject = this.i;
      } else {
        localObject = paramList;
      }
      i1 = this.c;
      if ((i1 != 1) && (i1 != 0) && (i1 != 3000))
      {
        localList = this.i;
        i1 = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i1 < ((List)localObject).size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)((List)localObject).get(i1);
          if (a(localAIORichMediaData)) {
            break label239;
          }
          localArrayList.add(localAIORichMediaData);
          break label239;
        }
        localObject = (AIORichMediaData[])localArrayList.toArray(new AIORichMediaData[localArrayList.size()]);
      }
      finally {}
      localObject = (AIORichMediaData[])((List)localObject).toArray(new AIORichMediaData[((List)localObject).size()]);
      if (localObject.length > 0) {
        localIAIOImageProviderCallBack.a((AIORichMediaData[])localObject, -1);
      }
      localObject = this.u;
      if (localObject != null)
      {
        paramList = (AIORichMediaData[])paramList.toArray(new AIORichMediaData[paramList.size()]);
        if (paramList.length > 0) {
          ((AIOImageProviderService.AIOImageProviderListener)localObject).a(paramList, -1);
        }
      }
      return;
      label239:
      i1 += 1;
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool = MessageForFile.class.isInstance(paramMessageRecord);
    String str2 = "";
    if (bool) {
      paramMessageRecord = (MessageForFile)paramMessageRecord;
    }
    label154:
    try
    {
      Object localObject = d();
      str1 = str2;
      if (localObject == null) {
        break label154;
      }
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject).getFileManagerDataCenter().b(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      str1 = str2;
      if (localFileManagerEntity == null) {
        break label154;
      }
      localObject = ((QQAppInterface)localObject).getFileManagerDataCenter().a(localFileManagerEntity.nSessionId);
      str1 = str2;
      if (localObject == null) {
        break label154;
      }
      paramMessageRecord.fileName = ((FileManagerEntity)localObject).fileName;
      str1 = paramMessageRecord.fileName;
    }
    catch (Exception paramMessageRecord)
    {
      String str1;
      label106:
      break label106;
    }
    str1 = str2;
    break label154;
    if (MessageForTroopFile.class.isInstance(paramMessageRecord))
    {
      str1 = ((MessageForTroopFile)paramMessageRecord).fileName;
    }
    else
    {
      str1 = str2;
      if (MessageForDLFile.class.isInstance(paramMessageRecord)) {
        str1 = ((MessageForDLFile)paramMessageRecord).fileName;
      }
    }
    return 2 == FileManagerUtil.c(str1);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = f();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.a(paramMessageForPic, paramLong, paramInt1, paramInt2);
    }
  }
  
  private QQAppInterface d()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      return localQQAppInterface;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "no appRuntime");
      }
    }
    return null;
  }
  
  private void d(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramMessageRecord;
    if ((UinTypeUtil.e(this.c) == 1032) && (this.d > 0) && (paramMessageRecord.getConfessTopicId() != this.d)) {
      return;
    }
    paramMessageRecord = d().getFileManagerDataCenter().a(localMessageForFile.uniseq, localMessageForFile.frienduin, localMessageForFile.istroop);
    int i1 = 0;
    int i2 = 0;
    if ((paramMessageRecord != null) && (((FileManagerUtil.m(paramMessageRecord)) && (paramMessageRecord.nFileType != 2)) || (16 != paramMessageRecord.status)))
    {
      if (paramMessageRecord.nFileType == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (paramMessageRecord.nFileType == 2) {
        i2 = 1;
      }
    }
    else
    {
      i2 = 0;
    }
    Object localObject = null;
    if (i1 != 0)
    {
      localMessageForFile.parse();
      paramMessageRecord = AIOGalleryUtils.a(localMessageForFile, d());
    }
    else if (i2 != 0)
    {
      localMessageForFile.parse();
      paramMessageRecord = AIOGalleryUtils.a(localMessageForFile, d());
    }
    else
    {
      paramMessageRecord = localObject;
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("ignore filePic: ");
        paramMessageRecord.append(localMessageForFile);
        QLog.i("AIOImageProviderService", 2, paramMessageRecord.toString());
        paramMessageRecord = localObject;
      }
    }
    if (paramMessageRecord != null)
    {
      paramList.add(paramMessageRecord);
      paramList1.add(localMessageForFile);
    }
  }
  
  private String e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.c);
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.f)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_f");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void e(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    Object localObject = d();
    if (localObject == null) {
      return;
    }
    MessageForDLFile localMessageForDLFile = (MessageForDLFile)paramMessageRecord;
    int i1 = localMessageForDLFile.deviceType;
    long l1 = localMessageForDLFile.associatedId;
    paramMessageRecord = ((QQAppInterface)localObject).getMessageFacade().d(i1);
    if (paramMessageRecord == null) {
      return;
    }
    localObject = paramMessageRecord.a(l1);
    if (localObject == null) {
      return;
    }
    localMessageForDLFile.parse();
    paramMessageRecord = null;
    i1 = FileManagerUtil.c(((DataLineMsgRecord)localObject).filename);
    if ((i1 == 2) || (i1 == 0)) {
      paramMessageRecord = AIOGalleryUtils.a(localMessageForDLFile, d());
    }
    if (paramMessageRecord != null)
    {
      paramList.add(paramMessageRecord);
      paramList1.add(localMessageForDLFile);
    }
  }
  
  private MultiRichMediaSaveManager f()
  {
    Object localObject;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      localObject = null;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "getRichMedialSaveManager app == null");
      }
      return null;
    }
    return (MultiRichMediaSaveManager)localObject.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
  }
  
  private QQAppInterface g()
  {
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      localObject = (QQAppInterface)localObject;
      if (localObject == null) {
        return null;
      }
      return localObject;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
    }
    return null;
  }
  
  private MessageForDLFile j(long paramLong)
  {
    label85:
    Object localObject3;
    synchronized (this.h)
    {
      Iterator localIterator = this.h.iterator();
      Object localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label85;
        }
        localObject1 = (ChatMessage)localIterator.next();
        if (MessageForDLFile.class.isInstance(localObject1))
        {
          localObject1 = (MessageForDLFile)localObject1;
          if (((MessageForDLFile)localObject1).associatedId == paramLong) {
            break;
          }
        }
      }
      return localObject1;
    }
  }
  
  public int a(long paramLong, int paramInt)
  {
    Object localObject = f();
    if (localObject != null)
    {
      ChatMessage localChatMessage = b(paramLong, paramInt);
      if ((localChatMessage == null) && (QLog.isColorLevel())) {
        QLog.i("AIOImageProviderService", 2, "getSaveFileProgress chatMessage is null");
      }
      localObject = ((MultiRichMediaSaveManager)localObject).a(((MultiRichMediaSaveManager)localObject).a(localChatMessage));
      if ((localObject != null) && (!((FileSaveResult)localObject).a) && (((FileSaveResult)localObject).f == 1))
      {
        paramInt = ((FileSaveResult)localObject).e;
        break label87;
      }
    }
    paramInt = -1;
    label87:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSaveFileProgress progress = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("AIOImageProviderService", 2, ((StringBuilder)localObject).toString());
    }
    return paramInt;
  }
  
  public Intent a(MessageForFile paramMessageForFile)
  {
    try
    {
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a)).getFileManagerDataCenter().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (localFileManagerEntity == null) {
        return null;
      }
      Intent localIntent = new Intent();
      localIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      localBundle.putParcelable("fileinfo", ForwardFileOption.a(localFileManagerEntity, paramMessageForFile));
      paramMessageForFile = new StringBuilder();
      paramMessageForFile.append(HardCodeUtil.a(2131898354));
      paramMessageForFile.append(FileManagerUtil.j(localFileManagerEntity.fileName));
      paramMessageForFile.append(HardCodeUtil.a(2131898356));
      paramMessageForFile.append(FileUtil.a(localFileManagerEntity.fileSize));
      paramMessageForFile.append("。");
      localBundle.putString("forward_text", paramMessageForFile.toString());
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putString("forward_filepath", localFileManagerEntity.getFilePath());
      localBundle.putBoolean("k_favorites", FileManagerUtil.i(localFileManagerEntity));
      if ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7))
      {
        localBundle.putBoolean("isFromShare", true);
        if (localFileManagerEntity.nFileType == 0) {
          localBundle.putInt("forward_type", 1);
        }
      }
      if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
        localBundle.putInt("forward_type", 1);
      }
      localIntent.putExtras(localBundle);
      return localIntent;
    }
    catch (AccountNotMatchException paramMessageForFile)
    {
      paramMessageForFile.printStackTrace();
    }
    return null;
  }
  
  protected AIOImageData a(MessageForPic paramMessageForPic)
  {
    return AIOGalleryUtils.a(paramMessageForPic);
  }
  
  public ChatMessage a(long paramLong)
  {
    label70:
    Object localObject2;
    synchronized (this.h)
    {
      Iterator localIterator = this.h.iterator();
      ChatMessage localChatMessage;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label70;
        }
        localChatMessage = (ChatMessage)localIterator.next();
        if (paramLong == localChatMessage.uniseq) {
          break;
        }
      }
      return localChatMessage;
    }
  }
  
  public ChatMessage a(long paramLong1, long paramLong2)
  {
    List localList = this.h;
    int i3 = 0;
    int i1 = 0;
    label100:
    int i2;
    try
    {
      if (i1 >= this.h.size()) {
        break label253;
      }
      localChatMessage = (ChatMessage)this.h.get(i1);
      if (MessageForPic.class.isInstance(localChatMessage))
      {
        localObject4 = (MessageForPic)localChatMessage;
        if ((paramLong1 != ((MessageForPic)localObject4).uniseq) || (paramLong2 != ((MessageForPic)localObject4).subMsgId)) {
          break label244;
        }
      }
      else
      {
        if (paramLong1 != localChatMessage.uniseq) {
          break label244;
        }
      }
    }
    finally
    {
      for (;;)
      {
        ChatMessage localChatMessage;
        Object localObject4;
        for (;;)
        {
          throw localObject2;
        }
        i2 = 1;
      }
      label244:
      i1 += 1;
    }
    if (i2 != 0) {
      this.h.remove(i1);
    }
    localList = this.i;
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      try
      {
        if (i1 < this.i.size())
        {
          localObject4 = (AIORichMediaData)this.i.get(i1);
          if ((((AIORichMediaData)localObject4).L != paramLong1) || (((AIORichMediaData)localObject4).M != paramLong2)) {
            break label262;
          }
          i2 = 1;
        }
        if (i2 != 0) {
          this.i.remove(i1);
        }
        return localChatMessage;
      }
      finally {}
      break;
      label253:
      Object localObject3 = null;
      i2 = 0;
      break label100;
      label262:
      i1 += 1;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      try
      {
        TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a)).getManager(QQManagerFactory.TROOP_MANAGER);
        paramString1 = localTroopManager.e(localTroopManager.k(paramString1), paramString2);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("getTroopMemberName exception = ");
          paramString2.append(paramString1.getMessage());
          QLog.d("AIOImageProviderService", 2, paramString2.toString());
        }
        paramString1.printStackTrace();
      }
    }
    return "";
  }
  
  public List<AIORichMediaData> a(List<MessageRecord> paramList)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i1);
      a(localMessageRecord);
      if ((localMessageRecord instanceof MessageForPic))
      {
        c(localArrayList1, localArrayList2, localMessageRecord);
      }
      else if ((localMessageRecord instanceof MessageForMixedMsg))
      {
        a(localArrayList1, localArrayList2, (MessageForMixedMsg)localMessageRecord);
      }
      else if ((localMessageRecord instanceof MessageForStructing))
      {
        b(localArrayList1, localArrayList2, localMessageRecord);
      }
      else if (MessageForShortVideo.class.isInstance(localMessageRecord))
      {
        a(localArrayList1, localArrayList2, localMessageRecord);
      }
      else if ((localMessageRecord instanceof MessageForFile))
      {
        d(localArrayList1, localArrayList2, localMessageRecord);
      }
      else if ((localMessageRecord instanceof MessageForTroopFile))
      {
        a(localArrayList1, localArrayList2, (MessageForTroopFile)localMessageRecord);
      }
      else if ((localMessageRecord instanceof MessageForDLFile))
      {
        e(localArrayList1, localArrayList2, localMessageRecord);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("messageRecordToData ");
        localStringBuilder.append(localMessageRecord.getBaseInfoString());
        QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
      }
      i1 += 1;
    }
    if (this.j)
    {
      this.h.addAll(0, localArrayList2);
      this.i.addAll(0, localArrayList1);
    }
    else
    {
      this.h.clear();
      this.i.clear();
      this.h.addAll(localArrayList2);
      this.i.addAll(localArrayList1);
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("messageRecordToData total size ");
      paramList.append(localArrayList2.size());
      paramList.append(", cost ");
      paramList.append(System.currentTimeMillis() - l1);
      QLog.d("AIOImageProviderService", 2, paramList.toString());
    }
    return localArrayList1;
  }
  
  public List<ChatMessage> a(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = paramArrayOfLong.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ChatMessage localChatMessage = a(paramArrayOfLong[i1]);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[destroy] ");
      localStringBuilder.append(this.a);
      localStringBuilder.append("_");
      localStringBuilder.append(this.b);
      localStringBuilder.append("_");
      localStringBuilder.append(this.c);
      QLog.d("AIOImageProviderService", 2, localStringBuilder.toString());
    }
    this.h.clear();
    this.i.clear();
    r.remove(e());
    this.b = null;
    this.c = 0;
    this.p = 60;
    this.u = null;
    if (this.v != null) {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a)).getFileManagerNotifyCenter().deleteObserver(this.v);
        this.v = null;
        QLog.i("AIOImageProviderService<QFile>", 1, "clear fmObserver suc");
      }
      catch (AccountNotMatchException localAccountNotMatchException1)
      {
        QLog.i("AIOImageProviderService<QFile>", 1, "clear fmObserver, but AccountNotMatchException");
        localAccountNotMatchException1.printStackTrace();
      }
    }
    if (this.A != null) {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a)).removeObserver(this.A);
        this.A = null;
        QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver suc");
      }
      catch (AccountNotMatchException localAccountNotMatchException2)
      {
        QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver, but AccountNotMatchException");
        localAccountNotMatchException2.printStackTrace();
      }
    }
    if (this.w != null) {
      try
      {
        d().removeObserver(this.w);
        this.v = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    HashMap localHashMap = this.B;
    if (localHashMap != null)
    {
      localHashMap.clear();
      this.B = null;
    }
    QLog.e("AIOImageProviderService", 1, "～～～～～～～destory AIOImageProviderService～～～～～～～");
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    if ((this.y == null) && (this.u == null)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[loadMedias] + loadType: ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(", dataList.size = ");
      ((StringBuilder)???).append(this.i.size());
      QLog.d("AIOImageProviderService", 2, ((StringBuilder)???).toString());
    }
    int i1 = 0;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (this.u == null) {
          return;
        }
        if (this.i.size() > 0) {
          synchronized (this.i)
          {
            AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.i.toArray(new AIORichMediaData[this.i.size()]);
            this.u.a(arrayOfAIORichMediaData, -1);
            return;
          }
        }
        ThreadManagerV2.excute(this.z, 64, null, false);
        return;
      }
      if (this.y == null) {
        return;
      }
      if (this.i.size() > 0)
      {
        localArrayList = new ArrayList();
        ??? = this.i;
        paramInt = i1;
      }
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.i.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.i.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label335;
          }
          localArrayList.add(localAIORichMediaData);
          break label335;
        }
        ??? = (AIORichMediaData[])localArrayList.toArray(new AIORichMediaData[localArrayList.size()]);
        this.y.a((AIORichMediaData[])???, -1);
        return;
      }
      finally {}
      ThreadManagerV2.excute(this.z, 64, null, false);
      return;
      ThreadManagerV2.excute(this.z, 64, null, false);
      return;
      label335:
      paramInt += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    BaseActivity localBaseActivity = a("safetyReport");
    if (localBaseActivity != null) {
      ThreadManager.getUIHandler().post(new AIOImageProviderService.6(this, paramBoolean, localBaseActivity, paramString2, paramString1, paramString3, paramString4, paramInt));
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject1 = b(paramLong, paramInt1);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("carverW downloadMedia type=");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" id=");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d("AIOImageProviderService", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      if (MessageForPic.class.isInstance(localObject1))
      {
        localObject1 = (MessageForPic)localObject1;
        if (paramInt2 == 24)
        {
          c((MessageForPic)localObject1, paramLong, paramInt1, paramInt2);
          return;
        }
        a((MessageForPic)localObject1, paramLong, paramInt1, paramInt2);
        return;
      }
      if (MessageForShortVideo.class.isInstance(localObject1))
      {
        localObject1 = (MessageForShortVideo)localObject1;
        if (paramInt2 == 256)
        {
          a((MessageForShortVideo)localObject1, paramLong, paramInt1, paramInt2);
          return;
        }
        c((MessageForShortVideo)localObject1, paramLong, paramInt1, paramInt2);
        return;
      }
      if (MessageForFile.class.isInstance(localObject1))
      {
        localObject1 = (MessageForFile)localObject1;
        localObject2 = Looper.getMainLooper();
        if (Thread.currentThread() != ((Looper)localObject2).getThread())
        {
          new Handler((Looper)localObject2).post(new AIOImageProviderService.1(this, (MessageForFile)localObject1, paramLong, paramInt1, paramInt2));
          return;
        }
        a((MessageForFile)localObject1, paramLong, paramInt1, paramInt2);
        return;
      }
      if (MessageForTroopFile.class.isInstance(localObject1))
      {
        localObject1 = (MessageForTroopFile)localObject1;
        ((MessageForTroopFile)localObject1).isPause = false;
        a((MessageForTroopFile)localObject1, paramLong, paramInt1, paramInt2);
        return;
      }
      if (MessageForDLFile.class.isInstance(localObject1))
      {
        a((MessageForDLFile)localObject1, paramLong, paramInt1, paramInt2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "downloadMedia fail, msg type not recognize");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AIOImageProviderService", 2, "downloadMedia fail, not find msg");
    }
  }
  
  void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.i;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.i.size())
        {
          Object localObject = (AIORichMediaData)this.i.get(i1);
          if (AIOImageData.class.isInstance(localObject))
          {
            localObject = (AIOImageData)localObject;
            if ((((AIOImageData)localObject).L == paramLong) && (((AIOImageData)localObject).M == paramInt1)) {
              a(paramInt2, paramString, (AIOImageData)localObject);
            }
          }
          else if (AIOShortVideoData.class.isInstance(localObject))
          {
            localObject = (AIOShortVideoData)localObject;
            if (((AIOShortVideoData)localObject).L == paramLong) {
              a(paramInt2, paramString, (AIOShortVideoData)localObject);
            }
          }
          else if (AIOFilePicData.class.isInstance(localObject))
          {
            localObject = (AIOFilePicData)localObject;
            if (((AIOFilePicData)localObject).L == paramLong) {
              a(paramInt2, paramString, (AIOFilePicData)localObject);
            }
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw paramString;
        continue;
        i1 += 1;
      }
    }
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    try
    {
      Object localObject = a(paramLong);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      if (localObject != null)
      {
        boolean bool = b((MessageRecord)localObject);
        if (bool) {
          switch (paramInt)
          {
          default: 
            return;
          case 14: 
            FileVideoDownloadManager.c(paramBundle.getString("contextid"));
            return;
          case 13: 
            if (!this.x.contains(Long.valueOf(paramLong))) {
              this.x.add(Long.valueOf(paramLong));
            }
            paramBundle = paramBundle.getString("contextid");
            FileVideoDownloadManager.b(paramBundle);
            FileVideoDownloadManager.a(paramBundle, true);
            if (!MessageForTroopFile.class.isInstance(localObject)) {
              break;
            }
            b(localQQAppInterface, (ChatMessage)localObject, paramLong, paramInt);
            return;
          case 12: 
            FileVideoDownloadManager.a(paramBundle.getString("contextid"));
            if (MessageForTroopFile.class.isInstance(localObject))
            {
              a(localQQAppInterface, (ChatMessage)localObject, paramLong, paramInt);
              return;
            }
            paramBundle = (MessageForFile)localObject;
            paramBundle = localQQAppInterface.getFileManagerDataCenter().a(paramBundle.uniseq, paramBundle.frienduin, paramBundle.istroop);
            if (paramBundle == null) {
              return;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("set  video pause id:");
              ((StringBuilder)localObject).append(paramLong);
              ((StringBuilder)localObject).append(" type: FILE_VIDEO_PEEK_CANCEL entityId:");
              ((StringBuilder)localObject).append(paramBundle.nSessionId);
              QLog.i("VideoPlayControllerForFile.main", 1, ((StringBuilder)localObject).toString());
            }
            localQQAppInterface.getFileManagerEngine().a(paramBundle.nSessionId);
            return;
          case 11: 
            paramBundle = paramBundle.getString("contextid");
            FileVideoDownloadManager.b(paramBundle);
            FileVideoDownloadManager.a(paramBundle, false);
            if (!MessageForTroopFile.class.isInstance(localObject)) {
              break;
            }
            b(localQQAppInterface, (ChatMessage)localObject, paramLong, paramInt);
            return;
          case 10: 
            FileVideoDownloadManager.a(paramBundle.getString("contextid"), true);
            return;
          }
        }
      }
      paramBundle = new StringBuilder();
      paramBundle.append("msg is not video, id:");
      paramBundle.append(paramLong);
      QLog.e("VideoPlayControllerForFile.main", 1, paramBundle.toString());
      return;
    }
    catch (AccountNotMatchException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(AIOImageProviderService.AIOImageProviderListener paramAIOImageProviderListener)
  {
    this.u = paramAIOImageProviderListener;
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    super.a(paramIAIOImageProviderCallBack);
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = f();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.a(paramIAIOImageProviderCallBack);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("actbarmemoryleaktest ProgressEvent this ");
      localStringBuilder.append(this);
      localStringBuilder.append(" is added");
      QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
    }
    if (this.v == null)
    {
      this.v = new AIOImageProviderService.OfflineFileObserver(this, paramQQAppInterface);
      paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.v);
    }
  }
  
  public void a(MessageForFile paramMessageForFile, long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      FileManagerEntity localFileManagerEntity;
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
        localObject = ((QQAppInterface)localAppRuntime).getFileManagerDataCenter().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
        if (localObject == null) {
          return;
        }
        localFileManagerEntity = ((QQAppInterface)localAppRuntime).getFileManagerDataCenter().a(((FileManagerEntity)localObject).nSessionId);
        if (localFileManagerEntity != null)
        {
          if (TextUtils.isEmpty(paramMessageForFile.fileName)) {
            paramMessageForFile.fileName = localFileManagerEntity.fileName;
          }
        }
        else
        {
          if (b(paramMessageForFile))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("msg is video, isTroop: ");
              localStringBuilder.append(paramMessageForFile.istroop);
              QLog.i("AIOImageProviderService", 1, localStringBuilder.toString());
            }
            if (((FileManagerEntity)localObject).getCloudType() == 12)
            {
              a(paramLong, paramInt1, paramInt2, new VideoForGuild((QQAppInterface)localAppRuntime, localFileManagerEntity));
              return;
            }
            if (paramMessageForFile.istroop == 3000)
            {
              a(paramLong, paramInt1, paramInt2, new VideoForDisc((QQAppInterface)localAppRuntime, localFileManagerEntity));
              return;
            }
            a(paramLong, paramInt1, paramInt2, new VideoForC2C((QQAppInterface)localAppRuntime, localFileManagerEntity));
            return;
          }
          if (paramInt2 != 16)
          {
            if (paramInt2 != 18)
            {
              if (paramInt2 != 20) {
                return;
              }
              ((QQAppInterface)localAppRuntime).getFileManagerEngine().h((FileManagerEntity)localObject);
              return;
            }
            ((FileManagerEntity)localObject).mContext = new String("igonFlow");
            ((QQAppInterface)localAppRuntime).getFileManagerEngine().a((FileManagerEntity)localObject, 7);
            return;
          }
          ((FileManagerEntity)localObject).mContext = new String("igonFlow");
          ((QQAppInterface)localAppRuntime).getFileManagerEngine().a((FileManagerEntity)localObject, 5);
          return;
        }
      }
      catch (AccountNotMatchException paramMessageForFile)
      {
        paramMessageForFile.printStackTrace();
        return;
      }
      Object localObject = localFileManagerEntity;
    }
  }
  
  /* Error */
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload 5
    //   2: iconst_1
    //   3: if_icmpeq +86 -> 89
    //   6: iload 5
    //   8: iconst_2
    //   9: if_icmpeq +52 -> 61
    //   12: iload 5
    //   14: iconst_4
    //   15: if_icmpeq +19 -> 34
    //   18: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 219
    //   26: iconst_2
    //   27: ldc_w 1366
    //   30: invokestatic 613	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: ldc_w 1368
    //   37: invokestatic 171	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   40: checkcast 1368	com/tencent/mobileqq/pic/api/IPicBus
    //   43: bipush 7
    //   45: iconst_1
    //   46: invokeinterface 1372 3 0
    //   51: astore 7
    //   53: ldc_w 1373
    //   56: istore 6
    //   58: goto +54 -> 112
    //   61: ldc_w 1368
    //   64: invokestatic 171	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   67: checkcast 1368	com/tencent/mobileqq/pic/api/IPicBus
    //   70: bipush 6
    //   72: sipush 1536
    //   75: iconst_1
    //   76: invokeinterface 1376 4 0
    //   81: astore 7
    //   83: iconst_1
    //   84: istore 6
    //   86: goto +26 -> 112
    //   89: ldc_w 1368
    //   92: invokestatic 171	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   95: checkcast 1368	com/tencent/mobileqq/pic/api/IPicBus
    //   98: iconst_5
    //   99: iconst_1
    //   100: invokeinterface 1372 3 0
    //   105: astore 7
    //   107: ldc_w 1377
    //   110: istore 6
    //   112: aload 7
    //   114: aload_1
    //   115: aload_1
    //   116: invokevirtual 1381	com/tencent/mobileqq/data/MessageForPic:getPicDownloadInfo	()Lcom/tencent/mobileqq/pic/PicDownloadInfo;
    //   119: invokevirtual 1386	com/tencent/mobileqq/pic/PicReq:a	(Lcom/tencent/mobileqq/data/MessageForPic;Lcom/tencent/mobileqq/pic/PicDownloadInfo;)Z
    //   122: pop
    //   123: aload_1
    //   124: iload 6
    //   126: aconst_null
    //   127: invokestatic 1392	com/tencent/mobileqq/transfile/URLDrawableHelper:getURL	(Lcom/tencent/mobileqq/pic/PicUiInterface;ILjava/lang/String;)Ljava/net/URL;
    //   130: invokevirtual 1395	java/net/URL:toString	()Ljava/lang/String;
    //   133: invokevirtual 1396	java/lang/String:toString	()Ljava/lang/String;
    //   136: invokestatic 1400	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 8
    //   141: aload 7
    //   143: new 1402	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService$2
    //   146: dup
    //   147: aload_0
    //   148: lload_2
    //   149: iload 4
    //   151: iload 5
    //   153: aload_1
    //   154: getfield 1404	com/tencent/mobileqq/data/MessageForPic:size	J
    //   157: aload 8
    //   159: invokespecial 1407	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService$2:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;JIIJLjava/lang/String;)V
    //   162: invokevirtual 1410	com/tencent/mobileqq/pic/PicReq:a	(Lcom/tencent/mobileqq/pic/UiCallBack;)V
    //   165: getstatic 204	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   168: astore_1
    //   169: aload_1
    //   170: aload_0
    //   171: getfield 116	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:a	Ljava/lang/String;
    //   174: invokevirtual 208	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   177: pop
    //   178: ldc_w 1368
    //   181: invokestatic 171	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   184: checkcast 1368	com/tencent/mobileqq/pic/api/IPicBus
    //   187: aload 7
    //   189: invokeinterface 1414 2 0
    //   194: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +40 -> 237
    //   200: goto +28 -> 228
    //   203: astore_1
    //   204: goto +35 -> 239
    //   207: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +12 -> 222
    //   213: ldc 219
    //   215: iconst_2
    //   216: ldc_w 1416
    //   219: invokestatic 613	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +12 -> 237
    //   228: ldc 219
    //   230: iconst_2
    //   231: ldc_w 1418
    //   234: invokestatic 613	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: return
    //   238: astore_1
    //   239: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +12 -> 254
    //   245: ldc 219
    //   247: iconst_2
    //   248: ldc_w 1418
    //   251: invokestatic 613	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: goto -50 -> 207
    //   260: astore_1
    //   261: goto -54 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	AIOImageProviderService
    //   0	264	1	paramMessageForPic	MessageForPic
    //   0	264	2	paramLong	long
    //   0	264	4	paramInt1	int
    //   0	264	5	paramInt2	int
    //   56	69	6	i1	int
    //   51	137	7	localPicReq	com.tencent.mobileqq.pic.PicReq
    //   139	19	8	str	String
    // Exception table:
    //   from	to	target	type
    //   112	169	203	finally
    //   169	194	238	finally
    //   207	222	238	finally
    //   112	169	256	mqq/app/AccountNotMatchException
    //   169	194	260	mqq/app/AccountNotMatchException
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo != null)
    {
      paramMessageForShortVideo.serial();
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
        if ((localAppRuntime instanceof QQAppInterface))
        {
          ((QQAppInterface)localAppRuntime).getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
          return;
        }
      }
      catch (Exception paramMessageForShortVideo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, paramMessageForShortVideo.toString());
        }
      }
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = f();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.a(paramMessageForShortVideo, paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile)
  {
    QQAppInterface localQQAppInterface2;
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      localQQAppInterface2 = null;
    }
    if (localQQAppInterface2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, app == null");
      }
      return;
    }
    paramMessageForTroopFile.isPause = true;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(localQQAppInterface2, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, info == null");
      }
      return;
    }
    paramMessageForTroopFile = paramMessageForTroopFile.frienduin;
    if (TextUtils.isEmpty(paramMessageForTroopFile)) {
      return;
    }
    paramMessageForTroopFile = TroopFileTransferManager.a(localQQAppInterface2, Long.valueOf(paramMessageForTroopFile).longValue());
    if (localTroopFileStatusInfo.e == 8)
    {
      paramMessageForTroopFile.e(localTroopFileStatusInfo.a);
      paramMessageForTroopFile.a(localTroopFileStatusInfo.a);
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface2;
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      localQQAppInterface2 = null;
    }
    if (localQQAppInterface2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, app == null");
      }
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(localQQAppInterface2, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info == null");
      }
      return;
    }
    if (b(paramMessageForTroopFile))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 1, "troop file is video, getUrl");
      }
      a(paramLong, paramInt1, paramInt2, new VideoForTroop(localQQAppInterface2, localTroopFileStatusInfo));
      return;
    }
    if (TextUtils.isEmpty(localTroopFileStatusInfo.r))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info.FilePath is empty");
      }
      return;
    }
    String str = localTroopFileStatusInfo.r;
    str = paramMessageForTroopFile.frienduin;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (paramInt2 == 20)
    {
      a(localQQAppInterface2, localTroopFileStatusInfo, str, paramLong, paramInt1, paramInt2);
      return;
    }
    if (paramInt2 == 18)
    {
      a(localQQAppInterface2, localTroopFileStatusInfo, str, paramMessageForTroopFile, paramLong, paramInt1, paramInt2);
      return;
    }
    if (paramInt2 == 16) {
      b(localQQAppInterface2, localTroopFileStatusInfo, str, paramMessageForTroopFile, paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportData,sendReportType:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",count:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AIOImageProviderService", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      if (paramInt == 55)
      {
        StatisticConstants.a(paramString, this.c, (QQAppInterface)localObject);
        return;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount((AppRuntime)localObject, this.a, "Pic", paramString, 0, 1, null, String.valueOf(paramInt), null, null, null);
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      throw new IllegalArgumentException("no appRuntime", paramString);
    }
  }
  
  protected void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForMixedMsg.parse();
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList.iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      Object localObject = (MessageRecord)paramMessageForMixedMsg.next();
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if (!b((MessageForPic)localObject))
        {
          ((MessageForPic)localObject).isInMixedMsg = true;
          paramList.add(a((MessageForPic)localObject));
          paramList1.add(localObject);
        }
      }
    }
  }
  
  protected void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
    if ((paramMessageRecord.busiType != 1) && (paramMessageRecord.busiType != 2) && (paramMessageRecord.busiType != 1007) && (paramMessageRecord.busiType != 1009) && (paramMessageRecord.busiType != 0) && (paramMessageRecord.busiType != 4601)) {
      return;
    }
    paramList.add(AIOGalleryUtils.a(paramMessageRecord));
    paramList1.add(paramMessageRecord);
  }
  
  public Intent b(long paramLong, int paramInt)
  {
    long l1 = paramInt;
    try
    {
      Object localObject1 = b(paramLong, l1);
      if ((localObject1 != null) && (MessageForPic.class.isInstance(localObject1)))
      {
        Object localObject2 = (MessageForPic)localObject1;
        localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a);
        localObject1 = QfavBuilder.a((Entity)localObject1).b((QQAppInterface)localObject2, (MessageRecord)localObject1).b();
        return localObject1;
      }
      throw new IllegalArgumentException("message not find..");
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      throw new IllegalArgumentException("no appRuntime", localAccountNotMatchException);
    }
  }
  
  public MessageForShortVideo b(long paramLong)
  {
    Object localObject3;
    synchronized (this.h)
    {
      Object localObject1 = this.h.iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject1).next();
      } while ((paramLong != localChatMessage.uniseq) || (!MessageForShortVideo.class.isInstance(localChatMessage)));
      localObject1 = (MessageForShortVideo)localChatMessage;
      return localObject1;
    }
  }
  
  public void b()
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((IAIOImageProviderCallBack)localObject).a(null, -1);
    }
    localObject = this.u;
    if (localObject != null) {
      ((AIOImageProviderService.AIOImageProviderListener)localObject).a(null, -1);
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    ChatMessage localChatMessage = b(paramLong, paramInt1);
    if (localChatMessage != null)
    {
      if (MessageForPic.class.isInstance(localChatMessage))
      {
        b((MessageForPic)localChatMessage, paramLong, paramInt1, paramInt2);
        return;
      }
      if (MessageForShortVideo.class.isInstance(localChatMessage))
      {
        if (paramInt2 == 256) {
          b((MessageForShortVideo)localChatMessage, paramLong, paramInt1, paramInt2);
        }
      }
      else
      {
        if (MessageForFile.class.isInstance(localChatMessage))
        {
          a((MessageForFile)localChatMessage, paramLong);
          return;
        }
        if (MessageForTroopFile.class.isInstance(localChatMessage))
        {
          a((MessageForTroopFile)localChatMessage);
          return;
        }
        if (MessageForDLFile.class.isInstance(localChatMessage)) {
          a((MessageForDLFile)localChatMessage);
        }
      }
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface)
  {
    if (this.B == null) {
      this.B = new HashMap();
    }
    if (this.A == null)
    {
      this.A = new AIOImageProviderService.TroopFileObserver(this);
      paramQQAppInterface.addObserver(this.A);
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = f();
    if ((paramInt2 != 24) && (localObject != null) && (((MultiRichMediaSaveManager)localObject).b(paramMessageForPic)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "cancelDownloadImage return");
      }
      return;
    }
    if ((paramInt2 == 24) && (localObject != null)) {}
    try
    {
      ((MultiRichMediaSaveManager)localObject).b(paramMessageForPic, paramLong, paramInt1, paramInt2);
      paramMessageForPic = ((ITransFileController)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a)).getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, 131075));
      if ((paramMessageForPic instanceof BaseDownloadProcessor))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("destroy cancel processor:");
          ((StringBuilder)localObject).append(paramMessageForPic);
          QLog.d("AIOImageProviderService", 2, ((StringBuilder)localObject).toString());
        }
        ((BaseDownloadProcessor)paramMessageForPic).cancel();
        return;
      }
      if (!QLog.isColorLevel()) {
        break label197;
      }
      QLog.d("AIOImageProviderService", 2, "destroy cancel fail");
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      label182:
      break label182;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
    label197:
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = f();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.b(paramMessageForShortVideo, paramLong, paramInt1, paramInt2);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanMessage type = ");
      localStringBuilder.append(paramInt);
      QLog.d("AIOImageProviderService", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        MessageDeleteUtils.a(paramString, paramInt, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a));
        return;
      }
      catch (AccountNotMatchException paramString)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("cleanMessage exception = ");
          localStringBuilder.append(paramString.getMessage());
          QLog.d("AIOImageProviderService", 2, localStringBuilder.toString());
        }
        paramString.printStackTrace();
      }
    }
  }
  
  protected void b(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    localMessageForStructing.parse();
    if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)))
    {
      StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
      StructMsgItemImage localStructMsgItemImage = localStructMsgForImageShare.getFirstImageElement();
      if (localStructMsgItemImage != null)
      {
        Object localObject2 = localStructMsgItemImage.aF;
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (localStructMsgItemImage.aE == null) {
            localStructMsgItemImage.aE = localStructMsgForImageShare;
          }
          localObject1 = localStructMsgItemImage.d();
        }
        localObject2 = a((MessageForPic)localObject1);
        ((AIOImageData)localObject2).N = localMessageForStructing.time;
        ((AIOImageData)localObject2).P = localMessageForStructing.shmsgseq;
        if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
        {
          ((AIOImageData)localObject2).r = 1;
          ((AIOImageData)localObject2).s = localStructMsgForImageShare.getBytes();
          ((AIOImageData)localObject2).y = AIOGallerySceneWithBusiness.a(AIOGallerySceneWithBusiness.b(localStructMsgForImageShare));
        }
        else if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
        {
          ((AIOImageData)localObject2).r = 2;
          ((AIOImageData)localObject2).s = localStructMsgForImageShare.getBytes();
          if ((MessageRecordInfo.c(paramMessageRecord.issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
            ((AIOImageData)localObject2).b = ((MessageForPic)localObject1).path;
          }
        }
        else if (((IGameShareUtil)QRoute.api(IGameShareUtil.class)).isGameShare(localStructMsgForImageShare))
        {
          ((AIOImageData)localObject2).r = 5;
          ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).convertDataForGallery(localObject2, localStructMsgForImageShare);
        }
        paramList.add(localObject2);
        paramList1.add(localObject1);
      }
    }
  }
  
  public void b(long[] paramArrayOfLong)
  {
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      List localList = a(paramArrayOfLong);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveToWeiyunMulti, idList.length = ");
        localStringBuilder.append(paramArrayOfLong.length);
        QLog.d("AIOImageProviderService", 2, localStringBuilder.toString());
      }
      paramArrayOfLong = a("saveToWeiyunMulti");
      if (paramArrayOfLong != null)
      {
        localObject = (QQAppInterface)localObject;
        WeiyunAIOUtils.a((QQAppInterface)localObject, paramArrayOfLong, paramArrayOfLong.getTitleBarHeight(), localList, null);
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009DBA", "0X8009DBA", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (AccountNotMatchException paramArrayOfLong)
    {
      paramArrayOfLong.printStackTrace();
      QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
    }
  }
  
  protected boolean b(MessageForPic paramMessageForPic)
  {
    if ((paramMessageForPic.msgtype != -3000) && (paramMessageForPic.msgtype != -30003))
    {
      if (!HotChatHelper.a(paramMessageForPic))
      {
        if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageForPic)) {
          return true;
        }
        if ((UinTypeUtil.e(this.c) == 1032) && (this.d > 0) && (paramMessageForPic.getConfessTopicId() != this.d)) {
          return true;
        }
        if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramMessageForPic)) {
          return true;
        }
        return ZhituManager.a(paramMessageForPic);
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LoadMediaTask msgType is ");
      localStringBuilder.append(paramMessageForPic.msgtype);
      QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public Intent c(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject3 = b(paramLong, paramInt1);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      if (MessageForPic.class.isInstance(localObject3))
      {
        localObject3 = (MessageForPic)localObject3;
        localObject1 = localObject2;
        if (((MessageForPic)localObject3).uniseq == paramLong)
        {
          paramInt1 = ((MessageForPic)localObject3).subMsgId;
          return null;
        }
      }
      else if (MessageForShortVideo.class.isInstance(localObject3))
      {
        localObject3 = (MessageForShortVideo)localObject3;
        localObject1 = localObject2;
        if (((MessageForShortVideo)localObject3).uniseq == paramLong)
        {
          localObject2 = b((MessageForShortVideo)localObject3);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ((Intent)localObject2).putExtra("from_uin_type", paramInt2);
            return localObject2;
          }
        }
      }
      else if (MessageForFile.class.isInstance(localObject3))
      {
        localObject3 = (MessageForFile)localObject3;
        localObject1 = localObject2;
        if (((MessageForFile)localObject3).uniseq == paramLong) {
          return a((MessageForFile)localObject3);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (MessageForTroopFile.class.isInstance(localObject3))
        {
          localObject1 = (MessageForTroopFile)localObject3;
          if (((MessageForTroopFile)localObject1).uniseq != paramLong)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("msg id : ");
            ((StringBuilder)localObject2).append(((MessageForTroopFile)localObject1).uniseq);
            ((StringBuilder)localObject2).append(" request id:");
            ((StringBuilder)localObject2).append(paramLong);
            QLog.e("AIOImageProviderService", 1, ((StringBuilder)localObject2).toString());
            return null;
          }
          localObject1 = b((MessageForTroopFile)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public void c()
  {
    this.y = null;
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = f();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.c();
    }
  }
  
  public void c(long paramLong)
  {
    ChatMessage localChatMessage = i(paramLong);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("revokeMsg msgseq:");
      long l1;
      if (localChatMessage != null) {
        l1 = localChatMessage.uniseq;
      } else {
        l1 = 0L;
      }
      localStringBuilder.append(l1);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramLong);
      QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new AIOImageProviderService.4(this, paramLong, paramInt));
  }
  
  protected void c(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("actbarmemoryleaktest ProgressEvent this ");
      localStringBuilder.append(this);
      localStringBuilder.append(" is added");
      QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
    }
    if (this.w == null)
    {
      this.w = new AIOImageProviderService.DatalineFileObserver(this);
      paramQQAppInterface.addObserver(this.w);
    }
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      if ((paramMessageForShortVideo.busiType == 0) && ((localAppRuntime instanceof QQAppInterface)) && (paramInt2 != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "carverW downloadVideo GetUrlAction");
        }
        new GetUrlAction((QQAppInterface)localAppRuntime, paramMessageForShortVideo, this.y, paramLong, paramInt1, paramInt2).a();
        return;
      }
      localShortVideoReq = SVBusiUtil.a(2, 2);
      ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
      if (paramInt2 == 0)
      {
        localShortVideoDownloadInfo.p = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
      }
      else
      {
        localShortVideoDownloadInfo.o = SVUtils.a(paramMessageForShortVideo, "mp4");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
      }
      localShortVideoReq.a(localShortVideoDownloadInfo);
    }
    catch (AccountNotMatchException paramMessageForShortVideo)
    {
      AppRuntime localAppRuntime;
      ShortVideoReq localShortVideoReq;
      label182:
      label185:
      break label185;
    }
    try
    {
      localShortVideoReq.a(new AIOImageProviderService.3(this, paramLong, paramInt1, paramInt2));
      ShortVideoBusiManager.a(localShortVideoReq, (QQAppInterface)localAppRuntime);
      return;
    }
    catch (AccountNotMatchException paramMessageForShortVideo)
    {
      break label182;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
  
  protected void c(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    paramMessageRecord = (MessageForPic)paramMessageRecord;
    paramMessageRecord.parse();
    if (b(paramMessageRecord)) {
      return;
    }
    paramList.add(a(paramMessageRecord));
    paramList1.add(paramMessageRecord);
  }
  
  public void d(long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new AIOImageProviderService.5(this, paramLong));
  }
  
  public void e(long paramLong)
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      Object localObject2 = a(paramLong);
      if (localObject2 != null)
      {
        Object localObject4;
        Object localObject3;
        if (MessageForFile.class.isInstance(localObject2))
        {
          localObject4 = (MessageForFile)localObject2;
          if (((MessageForFile)localObject4).uniseq == paramLong)
          {
            localObject2 = (QQAppInterface)localObject1;
            localObject3 = ((QQAppInterface)localObject2).getFileManagerDataCenter().a(((MessageForFile)localObject4).uniseq, ((MessageForFile)localObject4).frienduin, ((MessageForFile)localObject4).istroop);
            if (localObject3 == null) {
              return;
            }
            int i1 = ((FileManagerEntity)localObject3).getCloudType();
            if (i1 != 1)
            {
              if ((i1 != 3) && (i1 != 5)) {
                return;
              }
              ((QQAppInterface)localObject2).getFileManagerEngine().a(((FileManagerEntity)localObject3).getFilePath(), null, ((AppRuntime)localObject1).getAccount(), 0, false);
              return;
            }
            if (((MessageForFile)localObject4).isSend()) {
              localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
            } else {
              localObject1 = ((FileManagerEntity)localObject3).peerUin;
            }
            ((QQAppInterface)localObject2).getFileManagerEngine().a((FileManagerEntity)localObject3, (String)localObject1);
          }
        }
        else
        {
          if (MessageForTroopFile.class.isInstance(localObject2))
          {
            localObject3 = BaseApplicationImpl.sApplication.getBaseContext();
            if (localObject3 != null)
            {
              TroopFileUtils.b((Context)localObject3, (QQAppInterface)localObject1, (ChatMessage)localObject2);
              return;
            }
            QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file to weiyun].");
            return;
          }
          if ((localObject2 instanceof MessageForPic))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("saveToWeiyun, save single pic, uniseq = ");
              ((StringBuilder)localObject3).append(((ChatMessage)localObject2).uniseq);
              QLog.d("AIOImageProviderService", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = new ArrayList(1);
            ((List)localObject3).add(localObject2);
            localObject4 = a("saveToWeiyun_MessageForPic");
            if (localObject4 != null)
            {
              localObject1 = (QQAppInterface)localObject1;
              WeiyunAIOUtils.b((QQAppInterface)localObject1, (Activity)localObject4, ((BaseActivity)localObject4).getTitleBarHeight(), (List)localObject3, null);
              ReportController.b((AppRuntime)localObject1, "dc00898", "", ((ChatMessage)localObject2).frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
            }
          }
          else if ((localObject2 instanceof MessageForShortVideo))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("saveToWeiyun, save single video, uniseq = ");
              ((StringBuilder)localObject3).append(((ChatMessage)localObject2).uniseq);
              QLog.d("AIOImageProviderService", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = new ArrayList(1);
            ((List)localObject3).add(localObject2);
            localObject4 = a("saveToWeiyun_MessageForShortVideo");
            if (localObject4 != null)
            {
              localObject1 = (QQAppInterface)localObject1;
              WeiyunAIOUtils.b((QQAppInterface)localObject1, (Activity)localObject4, ((BaseActivity)localObject4).getTitleBarHeight(), (List)localObject3, null);
              ReportController.b((AppRuntime)localObject1, "dc00898", "", ((ChatMessage)localObject2).frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
            }
          }
        }
      }
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
    }
  }
  
  public void f(long paramLong)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.a);
      ChatMessage localChatMessage = a(paramLong);
      if (localChatMessage == null) {
        return;
      }
      Context localContext;
      if (MessageForFile.class.isInstance(localChatMessage))
      {
        localContext = BaseApplicationImpl.sApplication.getBaseContext();
        if (localContext != null)
        {
          FileManagerUtil.b((QQAppInterface)localAppRuntime, localChatMessage, localContext);
          return;
        }
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file send pc].");
        return;
      }
      if (MessageForTroopFile.class.isInstance(localChatMessage))
      {
        localContext = BaseApplicationImpl.sApplication.getBaseContext();
        if (localContext != null)
        {
          TroopFileUtils.a(localContext, (QQAppInterface)localAppRuntime, localChatMessage);
          return;
        }
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file send pc].");
      }
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
    }
  }
  
  public void g(long paramLong)
  {
    QQAppInterface localQQAppInterface = g();
    if (localQQAppInterface == null) {
      return;
    }
    String str = a(localQQAppInterface, paramLong);
    if (str == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!localDataLineHandler.h.d())
    {
      localQQAppInterface.getApplicationContext().startActivity(new Intent(localQQAppInterface.getApplicationContext(), PrinterDefaultActivity.class));
      return;
    }
    localDataLineHandler.e.a(localQQAppInterface.getApplicationContext(), str);
  }
  
  public void h(long paramLong)
  {
    Object localObject1 = a(paramLong);
    try
    {
      Object localObject2 = BaseApplicationImpl.sApplication;
      try
      {
        Object localObject3 = ((BaseApplicationImpl)localObject2).getAppRuntime(this.a);
        if (localObject1 != null)
        {
          if (MessageForFile.class.isInstance(localObject1))
          {
            localObject1 = (MessageForFile)localObject1;
            localObject1 = ((QQAppInterface)localObject3).getFileManagerDataCenter().a(((MessageForFile)localObject1).uniseq, ((MessageForFile)localObject1).frienduin, ((MessageForFile)localObject1).istroop);
            if (localObject1 == null) {
              return;
            }
            localObject2 = new Intent(BaseApplicationImpl.sApplication.getBaseContext(), FilePicQFavActivity.class);
            ((Intent)localObject2).putExtra("file_pic_favorites", ((FileManagerEntity)localObject1).nSessionId);
            BaseApplicationImpl.sApplication.getBaseContext().startActivity((Intent)localObject2);
            return;
          }
          if (MessageForTroopFile.class.isInstance(localObject1))
          {
            localObject2 = (MessageForTroopFile)localObject1;
            localObject3 = (QQAppInterface)localObject3;
            Object localObject4 = TroopFileUtils.a((QQAppInterface)localObject3, (MessageForTroopFile)localObject2);
            FileManagerEntity localFileManagerEntity = FileManagerUtil.a((TroopFileStatusInfo)localObject4);
            localObject4 = TroopFileManager.a((QQAppInterface)localObject3, ((TroopFileStatusInfo)localObject4).d).a(localFileManagerEntity.strTroopFilePath);
            if (localObject4 != null)
            {
              localFileManagerEntity.lastTime = ((TroopFileInfo)localObject4).j;
              localFileManagerEntity.selfUin = String.valueOf(((TroopFileInfo)localObject4).g);
            }
            localObject4 = BaseApplicationImpl.sApplication.getBaseContext();
            if (localObject4 != null) {
              new QfavBuilder(3).a((QQAppInterface)localObject3, (Context)localObject4, localFileManagerEntity, (ChatMessage)localObject1, false);
            } else {
              QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save fav].");
            }
            if (((MessageForTroopFile)localObject2).isMultiMsg) {
              ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
            }
          }
        }
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException1) {}
      localAccountNotMatchException2.printStackTrace();
    }
    catch (AccountNotMatchException localAccountNotMatchException2) {}
    QLog.e("AIOImageProviderService", 1, "getAppRuntime Exception!");
  }
  
  public ChatMessage i(long paramLong)
  {
    List localList = this.h;
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.h.size())
        {
          ChatMessage localChatMessage = (ChatMessage)this.h.get(i1);
          if (paramLong == localChatMessage.uniseq)
          {
            i2 = 1;
            if (i2 != 0) {
              this.h.remove(i1);
            }
            localList = this.i;
            i1 = 0;
            i2 = i3;
            try
            {
              if (i1 < this.i.size())
              {
                if (((AIORichMediaData)this.i.get(i1)).L != paramLong) {
                  break label192;
                }
                i2 = 1;
              }
              if (i2 != 0) {
                this.i.remove(i1);
              }
              return localChatMessage;
            }
            finally {}
          }
          continue;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i1 += 1;
      }
      Object localObject3 = null;
      int i2 = 0;
      continue;
      label192:
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
 * JD-Core Version:    0.7.0.1
 */