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
  public static final HashMap<String, AIOImageProviderService> a;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  AIOImageProviderService.AIOImageProviderListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener;
  AIOImageProviderService.DatalineFileObserver jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$DatalineFileObserver;
  private AIOImageProviderService.IncreasinglyLoadMediaTask jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask = new AIOImageProviderService.IncreasinglyLoadMediaTask(this);
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString;
  ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  final List<ChatMessage> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  WeakReference<BaseActivity> jdField_a_of_type_MqqUtilWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 9223372036854775807L;
  String jdField_b_of_type_JavaLangString;
  private HashMap<String, MessageForTroopFile> jdField_b_of_type_JavaUtilHashMap;
  final List<AIORichMediaData> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 3;
  long jdField_c_of_type_Long = 9223372036854775807L;
  volatile boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 60;
  long jdField_d_of_type_Long = 9223372036854775807L;
  volatile boolean jdField_d_of_type_Boolean = false;
  int e = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  protected AIOImageProviderService() {}
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    if (paramChatMessage != null)
    {
      this.jdField_a_of_type_Boolean = paramChatMessage.isMultiMsg;
      this.jdField_a_of_type_Long = paramChatMessage.msgseq;
      this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
      if (UinTypeUtil.a(paramChatMessage.istroop) == 1032) {
        this.jdField_b_of_type_Int = paramChatMessage.getConfessTopicId();
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), null);
    this.jdField_b_of_type_Boolean = ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage);
    if ((!this.jdField_a_of_type_Boolean) && (!ApolloClassFactoryApi.e().isInstance(paramChatMessage)))
    {
      paramString2 = a();
      paramChatMessage = (AIOImageProviderService)jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      if (paramChatMessage != null) {
        paramChatMessage.a();
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString2, this);
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
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramString1);
      return;
    }
    a("Static Null", "Init");
  }
  
  public static Intent a(MessageForShortVideo paramMessageForShortVideo)
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
  
  private Intent a(MessageForTroopFile paramMessageForTroopFile)
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
        localForwardFileInfo.a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
      }
      localForwardFileInfo.d(((TroopFileStatusInfo)localObject1).g);
      localForwardFileInfo.d(((TroopFileStatusInfo)localObject1).jdField_c_of_type_Long);
      localForwardFileInfo.a(Long.parseLong(paramMessageForTroopFile.frienduin));
      if (((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
        localForwardFileInfo.e(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
      }
      if (!TextUtils.isEmpty(((TroopFileStatusInfo)localObject1).jdField_c_of_type_JavaLangString)) {
        localForwardFileInfo.f(((TroopFileStatusInfo)localObject1).jdField_c_of_type_JavaLangString);
      } else if (!TextUtils.isEmpty(((TroopFileStatusInfo)localObject1).jdField_d_of_type_JavaLangString)) {
        localForwardFileInfo.f(((TroopFileStatusInfo)localObject1).jdField_d_of_type_JavaLangString);
      }
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras(localBundle);
      ((Intent)localObject2).putExtra("forward_text", ((TroopFileStatusInfo)localObject1).g);
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
      localObject1 = (AIOImageProviderService)jdField_a_of_type_JavaUtilHashMap.get(localObject1);
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
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject2);
      return localObject2;
    }
    Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
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
    a((String)localObject2, paramString);
    return null;
  }
  
  private QQAppInterface a()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
  
  private MessageForDLFile a(long paramLong)
  {
    label85:
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  private MessageForTroopFile a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    ??? = this.jdField_b_of_type_JavaUtilHashMap;
    Object localObject1 = localObject2;
    if (??? != null)
    {
      localObject1 = localObject2;
      if (!((HashMap)???).isEmpty()) {
        localObject1 = (MessageForTroopFile)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
      }
    }
    if (localObject1 == null) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
        if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
          this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localObject2);
        }
        return localObject2;
      }
    }
    return localObject1;
  }
  
  private MultiRichMediaSaveManager a()
  {
    Object localObject;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
  
  private String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_f");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
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
      return TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)localChatMessage).e;
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
          paramAIOFilePicData.jdField_b_of_type_Boolean = true;
          return;
        }
        paramAIOFilePicData.jdField_a_of_type_Boolean = true;
        return;
      }
      paramAIOFilePicData.jdField_c_of_type_Boolean = true;
      return;
    }
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          return;
        }
        paramAIOFilePicData.jdField_d_of_type_JavaLangString = paramString;
        return;
      }
      paramAIOFilePicData.jdField_c_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOFilePicData.jdField_b_of_type_JavaLangString = paramString;
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
          paramAIOImageData.jdField_c_of_type_Boolean = true;
          return;
        }
        paramAIOImageData.jdField_b_of_type_Boolean = true;
        return;
      }
      paramAIOImageData.jdField_a_of_type_Boolean = true;
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
          paramAIOImageData.jdField_d_of_type_JavaLangString = paramString;
          return;
        }
        paramAIOImageData.jdField_c_of_type_JavaLangString = paramString;
        return;
      }
      paramAIOImageData.jdField_b_of_type_JavaLangString = paramString;
      if (!paramAIOImageData.jdField_g_of_type_Boolean)
      {
        paramString = new StringBuilder();
        paramString.append(paramAIOImageData.jdField_a_of_type_JavaLangString);
        paramString.append("_hd");
        if (new File(paramString.toString()).exists())
        {
          paramString = new StringBuilder();
          paramString.append(paramAIOImageData.jdField_a_of_type_JavaLangString);
          paramString.append("_hd");
          paramAIOImageData.jdField_a_of_type_JavaLangString = paramString.toString();
        }
      }
    }
    else
    {
      paramAIOImageData.jdField_a_of_type_JavaLangString = paramString;
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
        paramAIOShortVideoData.jdField_b_of_type_Boolean = true;
        return;
      }
      paramAIOShortVideoData.jdField_a_of_type_Boolean = true;
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramAIOShortVideoData.jdField_b_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOShortVideoData.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, BaseVideoBiz paramBaseVideoBiz)
  {
    IFileVideoDownloader localIFileVideoDownloader = FileVideoDownloadManager.a(paramBaseVideoBiz);
    localIFileVideoDownloader.a(new AIOImageProviderService.7(this, paramBaseVideoBiz, paramLong, paramInt1, paramInt2));
    localIFileVideoDownloader.a(new AIOImageProviderService.8(this, paramBaseVideoBiz, paramLong));
    localIFileVideoDownloader.a(true);
    localIFileVideoDownloader.a();
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
      localStringBuilder.append(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
      QLog.i("VideoPlayControllerForFile.main", 1, localStringBuilder.toString());
    }
    TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(str).longValue()).d(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
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
    if ((paramTroopFileStatusInfo.jdField_b_of_type_Int == 11) && (FileUtils.fileExists(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramLong, paramInt1, paramInt2, 1, paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString, false);
      }
    }
    else
    {
      if ((paramTroopFileStatusInfo.jdField_b_of_type_Int != 7) && ((paramTroopFileStatusInfo.jdField_b_of_type_Int != 11) || (FileUtils.fileExists(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString))))
      {
        paramQQAppInterface.c(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        return;
      }
      paramQQAppInterface.a(paramTroopFileStatusInfo.e, paramTroopFileStatusInfo.g, paramTroopFileStatusInfo.jdField_c_of_type_Long, paramTroopFileStatusInfo.h);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString))
    {
      if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getApplication()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 2, paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString, false);
        }
        return;
      }
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null)
      {
        paramQQAppInterface.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 640);
        return;
      }
      paramQQAppInterface.a(paramTroopFileStatusInfo.e, paramTroopFileStatusInfo.g, paramTroopFileStatusInfo.h, 640);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 1, paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString, false);
    }
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    int i = FileManagerUtil.a(paramDataLineMsgRecord.filename);
    if (i == 2)
    {
      a(paramLong, paramInt1, paramInt2, new VideoForDataline((QQAppInterface)localObject, paramDataLineMsgRecord));
      return;
    }
    if (i == 0)
    {
      localObject = (DataLineHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
      ((DataLineHandler)localObject).a(localArrayList);
    }
  }
  
  private void a(MessageForDLFile paramMessageForDLFile)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    int i = paramMessageForDLFile.deviceType;
    long l = paramMessageForDLFile.associatedId;
    paramMessageForDLFile = localQQAppInterface.getMessageFacade().a(i);
    if (paramMessageForDLFile == null) {
      return;
    }
    paramMessageForDLFile = paramMessageForDLFile.a(l);
    ((DataLineHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMessageForDLFile.groupId, paramMessageForDLFile.sessionid, false);
  }
  
  private void a(MessageForDLFile paramMessageForDLFile, long paramLong, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    int i = paramMessageForDLFile.deviceType;
    long l = paramMessageForDLFile.associatedId;
    paramMessageForDLFile = localQQAppInterface.getMessageFacade().a(i);
    if (paramMessageForDLFile == null) {
      return;
    }
    paramMessageForDLFile = paramMessageForDLFile.a(l);
    if (paramMessageForDLFile == null) {
      return;
    }
    i = FileManagerUtil.a(paramMessageForDLFile.filename);
    if ((paramInt2 != 20) && (i != 2))
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
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
    if (paramMessageRecord.shmsgseq < this.jdField_c_of_type_Long) {
      this.jdField_c_of_type_Long = paramMessageRecord.shmsgseq;
    }
    if (paramMessageRecord.versionCode < this.jdField_c_of_type_Int) {
      this.jdField_c_of_type_Int = paramMessageRecord.versionCode;
    }
    if ((paramMessageRecord.getId() > 0L) && (paramMessageRecord.getId() < this.jdField_b_of_type_Long)) {
      this.jdField_b_of_type_Long = paramMessageRecord.getId();
    }
    if (paramMessageRecord.time < this.jdField_d_of_type_Long) {
      this.jdField_d_of_type_Long = paramMessageRecord.time;
    }
  }
  
  private void a(String paramString1, String paramString2)
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
  
  private void a(List<AIORichMediaData> paramList)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    ArrayList localArrayList;
    int i;
    Object localObject;
    List localList;
    if (localIAIOImageProviderCallBack != null)
    {
      localArrayList = new ArrayList();
      i = this.jdField_a_of_type_Int;
      if ((i != 1) && (i != 1026)) {
        localObject = this.jdField_b_of_type_JavaUtilList;
      } else {
        localObject = paramList;
      }
      i = this.jdField_a_of_type_Int;
      if ((i != 1) && (i != 0) && (i != 3000))
      {
        localList = this.jdField_b_of_type_JavaUtilList;
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i < ((List)localObject).size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)((List)localObject).get(i);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener;
      if (localObject != null)
      {
        paramList = (AIORichMediaData[])paramList.toArray(new AIORichMediaData[paramList.size()]);
        if (paramList.length > 0) {
          ((AIOImageProviderService.AIOImageProviderListener)localObject).a(paramList, -1);
        }
      }
      return;
      label239:
      i += 1;
    }
  }
  
  private void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageForTroopFile paramMessageForTroopFile)
  {
    int k = FileManagerUtil.a(paramMessageForTroopFile.fileName);
    int j = 1;
    int i;
    if (k == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (k != 2) {
      j = 0;
    }
    Object localObject = TroopFileUtils.a(a(), paramMessageForTroopFile);
    if (localObject == null) {
      return;
    }
    if (i != 0)
    {
      localObject = AIOGalleryUtils.a(paramMessageForTroopFile, a());
      if (localObject != null)
      {
        paramList.add(localObject);
        paramList1.add(paramMessageForTroopFile);
      }
    }
    else if ((j != 0) && ((FileUtil.a(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString)) || (QFileUtils.a(a()))))
    {
      localObject = AIOGalleryUtils.a(paramMessageForTroopFile, a());
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
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = MessageForFile.class.isInstance(paramMessageRecord);
    String str2 = "";
    if (bool) {
      paramMessageRecord = (MessageForFile)paramMessageRecord;
    }
    label154:
    try
    {
      Object localObject = a();
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
    return 2 == FileManagerUtil.a(str1);
  }
  
  private QQAppInterface b()
  {
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
  
  private ChatMessage b(long paramLong1, long paramLong2)
  {
    label117:
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    localObject = paramQQAppInterface.a(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
    if (FileUtil.a(paramChatMessage.jdField_a_of_type_JavaLangString))
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
          FileManagerUtil.a((Context)localObject, paramChatMessage.jdField_a_of_type_JavaLangString);
        } else {
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
        }
      }
      paramChatMessage = paramQQAppInterface.a(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
      if (paramChatMessage != null) {
        paramQQAppInterface.a(paramChatMessage, 11);
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
      localStringBuilder.append(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
      QLog.i("VideoPlayControllerForFile.main", 1, localStringBuilder.toString());
    }
    if (localObject != null) {
      paramQQAppInterface.a((TroopFileTransferManager.Item)localObject, 8);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString))
    {
      if ((!NetworkUtil.isNetSupport(BaseApplicationImpl.getApplication())) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 16, 2, paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString, false);
      }
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null)
      {
        paramQQAppInterface.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 383);
        return;
      }
      paramQQAppInterface.a(paramTroopFileStatusInfo.e, paramTroopFileStatusInfo.g, paramTroopFileStatusInfo.h, 383);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 1, 1, paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString, false);
    }
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord, long paramLong, int paramInt1, int paramInt2)
  {
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
      }
      return;
    }
    FileManagerUtil.a(paramDataLineMsgRecord.filename);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = a();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.a(paramMessageForPic, paramLong, paramInt1, paramInt2);
    }
  }
  
  private void d(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramMessageRecord;
    if ((UinTypeUtil.a(this.jdField_a_of_type_Int) == 1032) && (this.jdField_b_of_type_Int > 0) && (paramMessageRecord.getConfessTopicId() != this.jdField_b_of_type_Int)) {
      return;
    }
    paramMessageRecord = a().getFileManagerDataCenter().a(localMessageForFile.uniseq, localMessageForFile.frienduin, localMessageForFile.istroop);
    int i = 0;
    int j = 0;
    if ((paramMessageRecord != null) && (((FileManagerUtil.f(paramMessageRecord)) && (paramMessageRecord.nFileType != 2)) || (16 != paramMessageRecord.status)))
    {
      if (paramMessageRecord.nFileType == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramMessageRecord.nFileType == 2) {
        j = 1;
      }
    }
    else
    {
      j = 0;
    }
    Object localObject = null;
    if (i != 0)
    {
      localMessageForFile.parse();
      paramMessageRecord = AIOGalleryUtils.a(localMessageForFile, a());
    }
    else if (j != 0)
    {
      localMessageForFile.parse();
      paramMessageRecord = AIOGalleryUtils.a(localMessageForFile, a());
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
  
  private void e(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    MessageForDLFile localMessageForDLFile = (MessageForDLFile)paramMessageRecord;
    int i = localMessageForDLFile.deviceType;
    long l = localMessageForDLFile.associatedId;
    paramMessageRecord = ((QQAppInterface)localObject).getMessageFacade().a(i);
    if (paramMessageRecord == null) {
      return;
    }
    localObject = paramMessageRecord.a(l);
    if (localObject == null) {
      return;
    }
    localMessageForDLFile.parse();
    paramMessageRecord = null;
    i = FileManagerUtil.a(((DataLineMsgRecord)localObject).filename);
    if ((i == 2) || (i == 0)) {
      paramMessageRecord = AIOGalleryUtils.a(localMessageForDLFile, a());
    }
    if (paramMessageRecord != null)
    {
      paramList.add(paramMessageRecord);
      paramList1.add(localMessageForDLFile);
    }
  }
  
  public int a(long paramLong, int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      ChatMessage localChatMessage = b(paramLong, paramInt);
      if ((localChatMessage == null) && (QLog.isColorLevel())) {
        QLog.i("AIOImageProviderService", 2, "getSaveFileProgress chatMessage is null");
      }
      localObject = ((MultiRichMediaSaveManager)localObject).a(((MultiRichMediaSaveManager)localObject).a(localChatMessage));
      if ((localObject != null) && (!((FileSaveResult)localObject).jdField_a_of_type_Boolean) && (((FileSaveResult)localObject).jdField_d_of_type_Int == 1))
      {
        paramInt = ((FileSaveResult)localObject).jdField_c_of_type_Int;
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
  
  public Intent a(long paramLong, int paramInt)
  {
    long l = paramInt;
    try
    {
      Object localObject1 = b(paramLong, l);
      if ((localObject1 != null) && (MessageForPic.class.isInstance(localObject1)))
      {
        Object localObject2 = (MessageForPic)localObject1;
        localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
        localObject1 = QfavBuilder.a((Entity)localObject1).b((QQAppInterface)localObject2, (MessageRecord)localObject1).a();
        return localObject1;
      }
      throw new IllegalArgumentException("message not find..");
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      throw new IllegalArgumentException("no appRuntime", localAccountNotMatchException);
    }
  }
  
  public Intent a(long paramLong, int paramInt1, int paramInt2)
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
          localObject2 = a((MessageForShortVideo)localObject3);
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
          localObject1 = a((MessageForTroopFile)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public Intent a(MessageForFile paramMessageForFile)
  {
    try
    {
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).getFileManagerDataCenter().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
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
      paramMessageForFile.append(HardCodeUtil.a(2131700314));
      paramMessageForFile.append(FileManagerUtil.c(localFileManagerEntity.fileName));
      paramMessageForFile.append(HardCodeUtil.a(2131700316));
      paramMessageForFile.append(FileUtil.a(localFileManagerEntity.fileSize));
      paramMessageForFile.append("。");
      localBundle.putString("forward_text", paramMessageForFile.toString());
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putString("forward_filepath", localFileManagerEntity.getFilePath());
      localBundle.putBoolean("k_favorites", FileManagerUtil.d(localFileManagerEntity));
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
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    int k = 0;
    int i = 0;
    label100:
    int j;
    try
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label253;
      }
      localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
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
        j = 1;
      }
      label244:
      i += 1;
    }
    if (j != 0) {
      this.jdField_a_of_type_JavaUtilList.remove(i);
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    i = 0;
    for (;;)
    {
      j = k;
      try
      {
        if (i < this.jdField_b_of_type_JavaUtilList.size())
        {
          localObject4 = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(i);
          if ((((AIORichMediaData)localObject4).jdField_f_of_type_Long != paramLong1) || (((AIORichMediaData)localObject4).jdField_f_of_type_Int != paramLong2)) {
            break label262;
          }
          j = 1;
        }
        if (j != 0) {
          this.jdField_b_of_type_JavaUtilList.remove(i);
        }
        return localChatMessage;
      }
      finally {}
      break;
      label253:
      Object localObject3 = null;
      j = 0;
      break label100;
      label262:
      i += 1;
    }
  }
  
  public MessageForShortVideo a(long paramLong)
  {
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  public String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      try
      {
        TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).getManager(QQManagerFactory.TROOP_MANAGER);
        paramString1 = localTroopManager.a(localTroopManager.b(paramString1), paramString2);
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
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
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
      i += 1;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(0, localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(0, localArrayList1);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("messageRecordToData total size ");
      paramList.append(localArrayList2.size());
      paramList.append(", cost ");
      paramList.append(System.currentTimeMillis() - l);
      QLog.d("AIOImageProviderService", 2, paramList.toString());
    }
    return localArrayList1;
  }
  
  public List<ChatMessage> a(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      ChatMessage localChatMessage = a(paramArrayOfLong[i]);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      i += 1;
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("AIOImageProviderService", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilHashMap.remove(a());
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Int = 60;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
        QLog.i("AIOImageProviderService<QFile>", 1, "clear fmObserver suc");
      }
      catch (AccountNotMatchException localAccountNotMatchException1)
      {
        QLog.i("AIOImageProviderService<QFile>", 1, "clear fmObserver, but AccountNotMatchException");
        localAccountNotMatchException1.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
        QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver suc");
      }
      catch (AccountNotMatchException localAccountNotMatchException2)
      {
        QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver, but AccountNotMatchException");
        localAccountNotMatchException2.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$DatalineFileObserver != null) {
      try
      {
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$DatalineFileObserver);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    HashMap localHashMap = this.jdField_b_of_type_JavaUtilHashMap;
    if (localHashMap != null)
    {
      localHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    QLog.e("AIOImageProviderService", 1, "～～～～～～～destory AIOImageProviderService～～～～～～～");
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[loadMedias] + loadType: ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(", dataList.size = ");
      ((StringBuilder)???).append(this.jdField_b_of_type_JavaUtilList.size());
      QLog.d("AIOImageProviderService", 2, ((StringBuilder)???).toString());
    }
    int i = 0;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null) {
          return;
        }
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          synchronized (this.jdField_b_of_type_JavaUtilList)
          {
            AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jdField_b_of_type_JavaUtilList.toArray(new AIORichMediaData[this.jdField_b_of_type_JavaUtilList.size()]);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener.a(arrayOfAIORichMediaData, -1);
            return;
          }
        }
        ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) {
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 0)
      {
        localArrayList = new ArrayList();
        ??? = this.jdField_b_of_type_JavaUtilList;
        paramInt = i;
      }
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label335;
          }
          localArrayList.add(localAIORichMediaData);
          break label335;
        }
        ??? = (AIORichMediaData[])localArrayList.toArray(new AIORichMediaData[localArrayList.size()]);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a((AIORichMediaData[])???, -1);
        return;
      }
      finally {}
      ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
      return;
      ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
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
  
  public void a(long paramLong)
  {
    ChatMessage localChatMessage = b(paramLong);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("revokeMsg msgseq:");
      long l;
      if (localChatMessage != null) {
        l = localChatMessage.uniseq;
      } else {
        l = 0L;
      }
      localStringBuilder.append(l);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramLong);
      QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new AIOImageProviderService.4(this, paramLong, paramInt));
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
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_b_of_type_JavaUtilList.size())
        {
          Object localObject = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(i);
          if (AIOImageData.class.isInstance(localObject))
          {
            localObject = (AIOImageData)localObject;
            if ((((AIOImageData)localObject).jdField_f_of_type_Long == paramLong) && (((AIOImageData)localObject).jdField_f_of_type_Int == paramInt1)) {
              a(paramInt2, paramString, (AIOImageData)localObject);
            }
          }
          else if (AIOShortVideoData.class.isInstance(localObject))
          {
            localObject = (AIOShortVideoData)localObject;
            if (((AIOShortVideoData)localObject).jdField_f_of_type_Long == paramLong) {
              a(paramInt2, paramString, (AIOShortVideoData)localObject);
            }
          }
          else if (AIOFilePicData.class.isInstance(localObject))
          {
            localObject = (AIOFilePicData)localObject;
            if (((AIOFilePicData)localObject).jdField_f_of_type_Long == paramLong) {
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
        i += 1;
      }
    }
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    try
    {
      Object localObject = a(paramLong);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        boolean bool = a((MessageRecord)localObject);
        if (bool) {
          switch (paramInt)
          {
          default: 
            return;
          case 14: 
            FileVideoDownloadManager.c(paramBundle.getString("contextid"));
            return;
          case 13: 
            if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) {
              this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener = paramAIOImageProviderListener;
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    super.a(paramIAIOImageProviderCallBack);
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new AIOImageProviderService.OfflineFileObserver(this, paramQQAppInterface);
      paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void a(MessageForFile paramMessageForFile, long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      FileManagerEntity localFileManagerEntity;
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
          if (a(paramMessageForFile))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("msg is video, isTroop: ");
              ((StringBuilder)localObject).append(paramMessageForFile.istroop);
              QLog.i("AIOImageProviderService", 1, ((StringBuilder)localObject).toString());
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
              ((QQAppInterface)localAppRuntime).getFileManagerEngine().c((FileManagerEntity)localObject);
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
    //   18: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 197
    //   26: iconst_2
    //   27: ldc_w 1384
    //   30: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: ldc_w 1386
    //   37: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   40: checkcast 1386	com/tencent/mobileqq/pic/api/IPicBus
    //   43: bipush 7
    //   45: iconst_1
    //   46: invokeinterface 1390 3 0
    //   51: astore 7
    //   53: ldc_w 1391
    //   56: istore 6
    //   58: goto +54 -> 112
    //   61: ldc_w 1386
    //   64: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   67: checkcast 1386	com/tencent/mobileqq/pic/api/IPicBus
    //   70: bipush 6
    //   72: sipush 1536
    //   75: iconst_1
    //   76: invokeinterface 1394 4 0
    //   81: astore 7
    //   83: iconst_1
    //   84: istore 6
    //   86: goto +26 -> 112
    //   89: ldc_w 1386
    //   92: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   95: checkcast 1386	com/tencent/mobileqq/pic/api/IPicBus
    //   98: iconst_5
    //   99: iconst_1
    //   100: invokeinterface 1390 3 0
    //   105: astore 7
    //   107: ldc_w 1395
    //   110: istore 6
    //   112: aload 7
    //   114: aload_1
    //   115: aload_1
    //   116: invokevirtual 1399	com/tencent/mobileqq/data/MessageForPic:getPicDownloadInfo	()Lcom/tencent/mobileqq/pic/PicDownloadInfo;
    //   119: invokevirtual 1404	com/tencent/mobileqq/pic/PicReq:a	(Lcom/tencent/mobileqq/data/MessageForPic;Lcom/tencent/mobileqq/pic/PicDownloadInfo;)Z
    //   122: pop
    //   123: aload_1
    //   124: iload 6
    //   126: aconst_null
    //   127: invokestatic 1410	com/tencent/mobileqq/transfile/URLDrawableHelper:getURL	(Lcom/tencent/mobileqq/pic/PicUiInterface;ILjava/lang/String;)Ljava/net/URL;
    //   130: invokevirtual 1413	java/net/URL:toString	()Ljava/lang/String;
    //   133: invokevirtual 1414	java/lang/String:toString	()Ljava/lang/String;
    //   136: invokestatic 1418	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 8
    //   141: aload 7
    //   143: new 1420	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService$2
    //   146: dup
    //   147: aload_0
    //   148: lload_2
    //   149: iload 4
    //   151: iload 5
    //   153: aload_1
    //   154: getfield 1422	com/tencent/mobileqq/data/MessageForPic:size	J
    //   157: aload 8
    //   159: invokespecial 1425	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService$2:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;JIIJLjava/lang/String;)V
    //   162: invokevirtual 1428	com/tencent/mobileqq/pic/PicReq:a	(Lcom/tencent/mobileqq/pic/UiCallBack;)V
    //   165: getstatic 182	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   168: astore_1
    //   169: aload_1
    //   170: aload_0
    //   171: getfield 94	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: invokevirtual 186	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   177: pop
    //   178: ldc_w 1386
    //   181: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   184: checkcast 1386	com/tencent/mobileqq/pic/api/IPicBus
    //   187: aload 7
    //   189: invokeinterface 1432 2 0
    //   194: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +40 -> 237
    //   200: goto +28 -> 228
    //   203: astore_1
    //   204: goto +35 -> 239
    //   207: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +12 -> 222
    //   213: ldc 197
    //   215: iconst_2
    //   216: ldc_w 1434
    //   219: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +12 -> 237
    //   228: ldc 197
    //   230: iconst_2
    //   231: ldc_w 1436
    //   234: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: return
    //   238: astore_1
    //   239: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +12 -> 254
    //   245: ldc 197
    //   247: iconst_2
    //   248: ldc_w 1436
    //   251: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   56	69	6	i	int
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
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = a();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.a(paramMessageForShortVideo, paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile)
  {
    QQAppInterface localQQAppInterface2;
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 8)
    {
      paramMessageForTroopFile.d(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      paramMessageForTroopFile.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface2;
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
    if (a(paramMessageForTroopFile))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 1, "troop file is video, getUrl");
      }
      a(paramLong, paramInt1, paramInt2, new VideoForTroop(localQQAppInterface2, localTroopFileStatusInfo));
      return;
    }
    if (TextUtils.isEmpty(localTroopFileStatusInfo.e))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info.FilePath is empty");
      }
      return;
    }
    String str = localTroopFileStatusInfo.e;
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
      localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if (paramInt == 55)
      {
        StatisticConstants.a(paramString, this.jdField_a_of_type_Int, (QQAppInterface)localObject);
        return;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount((AppRuntime)localObject, this.jdField_a_of_type_JavaLangString, "Pic", paramString, 0, 1, null, String.valueOf(paramInt), null, null, null);
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
        if (!a((MessageForPic)localObject))
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
    if ((paramMessageRecord.busiType != 1) && (paramMessageRecord.busiType != 2) && (paramMessageRecord.busiType != 1007) && (paramMessageRecord.busiType != 1009) && (paramMessageRecord.busiType != 0)) {
      return;
    }
    paramList.add(AIOGalleryUtils.a(paramMessageRecord));
    paramList1.add(paramMessageRecord);
  }
  
  public void a(long[] paramArrayOfLong)
  {
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
  
  protected boolean a(MessageForPic paramMessageForPic)
  {
    if ((paramMessageForPic.msgtype != -3000) && (paramMessageForPic.msgtype != -30003))
    {
      if (!HotChatHelper.a(paramMessageForPic))
      {
        if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageForPic)) {
          return true;
        }
        if ((UinTypeUtil.a(this.jdField_a_of_type_Int) == 1032) && (this.jdField_b_of_type_Int > 0) && (paramMessageForPic.getConfessTopicId() != this.jdField_b_of_type_Int)) {
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
  
  public ChatMessage b(long paramLong)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int k = 0;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
          if (paramLong == localChatMessage.uniseq)
          {
            j = 1;
            if (j != 0) {
              this.jdField_a_of_type_JavaUtilList.remove(i);
            }
            localList = this.jdField_b_of_type_JavaUtilList;
            i = 0;
            j = k;
            try
            {
              if (i < this.jdField_b_of_type_JavaUtilList.size())
              {
                if (((AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_f_of_type_Long != paramLong) {
                  break label192;
                }
                j = 1;
              }
              if (j != 0) {
                this.jdField_b_of_type_JavaUtilList.remove(i);
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
        i += 1;
      }
      Object localObject3 = null;
      int j = 0;
      continue;
      label192:
      i += 1;
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    if (localObject != null) {
      ((IAIOImageProviderCallBack)localObject).a(null, -1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener;
    if (localObject != null) {
      ((AIOImageProviderService.AIOImageProviderListener)localObject).a(null, -1);
    }
  }
  
  public void b(long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new AIOImageProviderService.5(this, paramLong));
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
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new AIOImageProviderService.TroopFileObserver(this);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = a();
    if ((paramInt2 != 24) && (localObject != null) && (((MultiRichMediaSaveManager)localObject).a(paramMessageForPic)))
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
      paramMessageForPic = ((ITransFileController)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, 131075));
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
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = a();
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
        MessageDeleteUtils.a(paramString, paramInt, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString));
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
        Object localObject2 = localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
            localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = localStructMsgForImageShare;
          }
          localObject1 = localStructMsgItemImage.a();
        }
        localObject2 = a((MessageForPic)localObject1);
        ((AIOImageData)localObject2).jdField_g_of_type_Long = localMessageForStructing.time;
        ((AIOImageData)localObject2).i = localMessageForStructing.shmsgseq;
        if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
        {
          ((AIOImageData)localObject2).jdField_b_of_type_Int = 1;
          ((AIOImageData)localObject2).jdField_a_of_type_JavaLangObject = localStructMsgForImageShare.getBytes();
          ((AIOImageData)localObject2).jdField_d_of_type_Int = AIOGallerySceneWithBusiness.a(AIOGallerySceneWithBusiness.a(localStructMsgForImageShare));
        }
        else if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
        {
          ((AIOImageData)localObject2).jdField_b_of_type_Int = 2;
          ((AIOImageData)localObject2).jdField_a_of_type_JavaLangObject = localStructMsgForImageShare.getBytes();
          if ((MessageRecordInfo.b(paramMessageRecord.issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
            ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = ((MessageForPic)localObject1).path;
          }
        }
        else if (((IGameShareUtil)QRoute.api(IGameShareUtil.class)).isGameShare(localStructMsgForImageShare))
        {
          ((AIOImageData)localObject2).jdField_b_of_type_Int = 5;
          ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).convertDataForGallery(localObject2, localStructMsgForImageShare);
        }
        paramList.add(localObject2);
        paramList1.add(localObject1);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = null;
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = a();
    if (localMultiRichMediaSaveManager != null) {
      localMultiRichMediaSaveManager.c();
    }
  }
  
  public void c(long paramLong)
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
            int i = ((FileManagerEntity)localObject3).getCloudType();
            if (i != 1)
            {
              if ((i != 3) && (i != 5)) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$DatalineFileObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$DatalineFileObserver = new AIOImageProviderService.DatalineFileObserver(this);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$DatalineFileObserver);
    }
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if ((paramMessageForShortVideo.busiType == 0) && ((localAppRuntime instanceof QQAppInterface)) && (paramInt2 != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "carverW downloadVideo GetUrlAction");
        }
        new GetUrlAction((QQAppInterface)localAppRuntime, paramMessageForShortVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack, paramLong, paramInt1, paramInt2).a();
        return;
      }
      localShortVideoReq = SVBusiUtil.a(2, 2);
      ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
      if (paramInt2 == 0)
      {
        localShortVideoDownloadInfo.i = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
      }
      else
      {
        localShortVideoDownloadInfo.h = SVUtils.a(paramMessageForShortVideo, "mp4");
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
    if (a(paramMessageRecord)) {
      return;
    }
    paramList.add(a(paramMessageRecord));
    paramList1.add(paramMessageRecord);
  }
  
  public void d(long paramLong)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
          FileManagerUtil.a((QQAppInterface)localAppRuntime, localChatMessage, localContext);
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
  
  public void e(long paramLong)
  {
    QQAppInterface localQQAppInterface = b();
    if (localQQAppInterface == null) {
      return;
    }
    String str = a(localQQAppInterface, paramLong);
    if (str == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!localDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a())
    {
      localQQAppInterface.getApplicationContext().startActivity(new Intent(localQQAppInterface.getApplicationContext(), PrinterDefaultActivity.class));
      return;
    }
    localDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(localQQAppInterface.getApplicationContext(), str);
  }
  
  public void f(long paramLong)
  {
    Object localObject1 = a(paramLong);
    try
    {
      Object localObject2 = BaseApplicationImpl.sApplication;
      try
      {
        Object localObject3 = ((BaseApplicationImpl)localObject2).getAppRuntime(this.jdField_a_of_type_JavaLangString);
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
            localObject4 = TroopFileManager.a((QQAppInterface)localObject3, ((TroopFileStatusInfo)localObject4).jdField_b_of_type_Long).a(localFileManagerEntity.strTroopFilePath);
            if (localObject4 != null)
            {
              localFileManagerEntity.lastTime = ((TroopFileInfo)localObject4).jdField_c_of_type_Int;
              localFileManagerEntity.selfUin = String.valueOf(((TroopFileInfo)localObject4).jdField_b_of_type_Long);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
 * JD-Core Version:    0.7.0.1
 */