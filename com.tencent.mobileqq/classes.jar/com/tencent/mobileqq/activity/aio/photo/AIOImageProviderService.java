package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpic.HotPicHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import vlf;
import vlg;
import vlh;
import vli;
import vlj;
import vlk;
import vll;
import vlm;

public class AIOImageProviderService
  extends IAIOImageProvider.Stub
{
  static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public int a;
  public long a;
  public AIOImageProviderService.AIOImageProviderListener a;
  public FMObserver a;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public String a;
  public final List a;
  public boolean a;
  int b;
  public long b;
  public String b;
  public final List b;
  public volatile boolean b;
  public int c;
  public long c;
  private List c;
  public volatile boolean c;
  public int d;
  public long d;
  private List d;
  public int e;
  private List e;
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    this.jdField_c_of_type_Long = 9223372036854775807L;
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Long = 9223372036854775807L;
    this.jdField_d_of_type_Int = 60;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    if (paramChatMessage != null)
    {
      this.jdField_a_of_type_Boolean = paramChatMessage.isMultiMsg;
      this.jdField_a_of_type_Long = paramChatMessage.msgseq;
      this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
      if (MsgProxyUtils.a(paramChatMessage.istroop) == 1032) {
        this.jdField_b_of_type_Int = paramChatMessage.getConfessTopicId();
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), null);
    if ((!this.jdField_a_of_type_Boolean) && (!MessageForApollo.class.isInstance(paramChatMessage)))
    {
      paramString1 = paramString1 + "_" + paramString2 + "_" + paramInt;
      paramString2 = (AIOImageProviderService)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.a();
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, this);
    }
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
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.b(paramMessageForShortVideo));
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
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
    return new Intent().putExtras(localBundle);
  }
  
  public static AIOImageProviderService a(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    String str = paramString1 + "_" + paramString2 + "_" + paramInt;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBoolean) {
      if (paramChatMessage != null)
      {
        localObject1 = localObject2;
        if (paramChatMessage.isMultiMsg) {}
      }
      else
      {
        localObject1 = (AIOImageProviderService)jdField_a_of_type_JavaUtilHashMap.get(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new AIOImageProviderService(paramString1, paramString2, paramInt, paramChatMessage);
    }
    return localObject2;
  }
  
  private ChatMessage a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          if (paramLong != localChatMessage.uniseq) {
            continue;
          }
          return localChatMessage;
        }
      }
      Object localObject2 = null;
    }
  }
  
  private List a(QQAppInterface paramQQAppInterface, List paramList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = 0;
    if (k < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(k);
      int i = localMessageRecord.msgtype;
      if (localMessageRecord.shmsgseq < this.jdField_c_of_type_Long) {
        this.jdField_c_of_type_Long = localMessageRecord.shmsgseq;
      }
      if (localMessageRecord.versionCode < this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Int = localMessageRecord.versionCode;
      }
      if ((localMessageRecord.getId() > 0L) && (localMessageRecord.getId() < this.jdField_b_of_type_Long)) {
        this.jdField_b_of_type_Long = localMessageRecord.getId();
      }
      if (localMessageRecord.time < this.jdField_d_of_type_Long) {
        this.jdField_d_of_type_Long = localMessageRecord.time;
      }
      Object localObject1;
      if ((localMessageRecord instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localMessageRecord;
        ((MessageForPic)localObject1).parse();
        if ((i == -3000) || (i == -30003)) {
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageProviderService", 2, "LoadMediaTask msgType is " + i);
          }
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if ((!HotChatHelper.a((MessageRecord)localObject1)) && (!FlashPicHelper.a((MessageRecord)localObject1)) && ((MsgProxyUtils.a(this.jdField_a_of_type_Int) != 1032) || (this.jdField_b_of_type_Int <= 0) || (localMessageRecord.getConfessTopicId() == this.jdField_b_of_type_Int)))
        {
          localArrayList1.add(AIOGalleryUtils.a((MessageForPic)localObject1));
          localArrayList2.add(localObject1);
          continue;
          Object localObject2;
          if ((localMessageRecord instanceof MessageForMixedMsg))
          {
            localObject1 = (MessageForMixedMsg)localMessageRecord;
            ((MessageForMixedMsg)localObject1).parse();
            localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if ((localObject2 instanceof MessageForPic))
              {
                localArrayList1.add(AIOGalleryUtils.a((MessageForPic)localObject2));
                localArrayList2.add((MessageForPic)localObject2);
              }
            }
          }
          else if ((localMessageRecord instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
            localMessageForStructing.parse();
            if ((localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 5))
            {
              StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
              StructMsgItemImage localStructMsgItemImage = localStructMsgForImageShare.getFirstImageElement();
              if (localStructMsgItemImage != null)
              {
                localObject2 = localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  if (localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                    localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = localStructMsgForImageShare;
                  }
                  localObject1 = localStructMsgItemImage.a();
                }
                localObject2 = AIOGalleryUtils.a((MessageForPic)localObject1);
                ((AIOImageData)localObject2).h = localMessageForStructing.time;
                if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
                {
                  ((AIOImageData)localObject2).jdField_c_of_type_Int = 1;
                  ((AIOImageData)localObject2).jdField_a_of_type_JavaLangObject = localStructMsgForImageShare.getBytes();
                  ((AIOImageData)localObject2).jdField_e_of_type_Int = AIOGallerySceneWithBusiness.a(AIOGallerySceneWithBusiness.a(localStructMsgForImageShare));
                }
                for (;;)
                {
                  localArrayList1.add(localObject2);
                  localArrayList2.add(localObject1);
                  break;
                  if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
                  {
                    ((AIOImageData)localObject2).jdField_c_of_type_Int = 2;
                    ((AIOImageData)localObject2).jdField_a_of_type_JavaLangObject = localStructMsgForImageShare.getBytes();
                    if ((MsgUtils.b(localMessageRecord.issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
                      ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = ((MessageForPic)localObject1).path;
                    }
                  }
                  else if ((HotPicHelper.a(localMessageRecord)) && (MsgUtils.b(((MessageForPic)localObject1).issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (TextUtils.isEmpty(((MessageForPic)localObject1).md5)) && (new File(((MessageForPic)localObject1).path).exists()))
                  {
                    ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = ((MessageForPic)localObject1).path;
                  }
                }
              }
            }
          }
          else if (MessageForShortVideo.class.isInstance(localMessageRecord))
          {
            localObject1 = (MessageForShortVideo)localMessageRecord;
            if ((((MessageForShortVideo)localObject1).busiType == 1) || (((MessageForShortVideo)localObject1).busiType == 2) || (((MessageForShortVideo)localObject1).busiType == 1007) || (((MessageForShortVideo)localObject1).busiType == 1009) || (((MessageForShortVideo)localObject1).busiType == 0))
            {
              localArrayList1.add(AIOGalleryUtils.a((MessageForShortVideo)localObject1));
              localArrayList2.add(localObject1);
            }
          }
          else if ((localMessageRecord instanceof MessageForFile))
          {
            localObject1 = (MessageForFile)localMessageRecord;
            if ((MsgProxyUtils.a(this.jdField_a_of_type_Int) != 1032) || (this.jdField_b_of_type_Int <= 0) || (localMessageRecord.getConfessTopicId() == this.jdField_b_of_type_Int))
            {
              localObject2 = paramQQAppInterface.a().a(((MessageForFile)localObject1).uniseq, ((MessageForFile)localObject1).frienduin, ((MessageForFile)localObject1).istroop);
              int m = 0;
              int n = 0;
              int j = m;
              i = n;
              if (localObject2 != null) {
                if ((!FileManagerUtil.e((FileManagerEntity)localObject2)) || (((FileManagerEntity)localObject2).nFileType == 2))
                {
                  j = m;
                  i = n;
                  if (16 == ((FileManagerEntity)localObject2).status) {}
                }
                else
                {
                  if (((FileManagerEntity)localObject2).nFileType != 0) {
                    break label1023;
                  }
                  j = 1;
                  label975:
                  if (((FileManagerEntity)localObject2).nFileType != 2) {
                    break label1029;
                  }
                }
              }
              label1029:
              for (i = 1;; i = 0)
              {
                if (j == 0) {
                  break label1034;
                }
                ((MessageForFile)localObject1).parse();
                localArrayList1.add(AIOGalleryUtils.a((MessageForFile)localObject1, paramQQAppInterface));
                localArrayList2.add(localObject1);
                break;
                label1023:
                j = 0;
                break label975;
              }
              label1034:
              if (i != 0)
              {
                ((MessageForFile)localObject1).parse();
                localArrayList1.add(AIOGalleryUtils.a((MessageForFile)localObject1, paramQQAppInterface));
                localArrayList2.add(localObject1);
              }
              else if (QLog.isColorLevel())
              {
                QLog.i("AIOImageProviderService", 2, "ignore filePic: " + localObject1);
              }
            }
          }
          else if ((localMessageRecord instanceof MessageForTroopFile))
          {
            localObject1 = (MessageForTroopFile)localMessageRecord;
            if ((FileManagerUtil.a(((MessageForTroopFile)localObject1).fileName) == 0) && (((MessageForTroopFile)localObject1).fileSize < 10485760L)) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1180;
              }
              localArrayList1.add(AIOGalleryUtils.a((MessageForTroopFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
              break;
            }
          }
          else
          {
            label1180:
            if (QLog.isColorLevel()) {
              QLog.i("AIOImageProviderService", 2, "messageRecordToData " + localMessageRecord.getBaseInfoString());
            }
          }
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(0, localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(0, localArrayList1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "messageRecordToData total size " + localArrayList2.size() + ", cost " + (System.currentTimeMillis() - l));
      }
      return localArrayList1;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
    }
  }
  
  private void a(MessageForFile paramMessageForFile, long paramLong)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      paramMessageForFile = FileManagerUtil.a(localQQAppInterface, paramMessageForFile);
      localQQAppInterface.a().a(paramMessageForFile.nSessionId);
      return;
    }
    catch (Exception paramMessageForFile)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
  
  private ChatMessage b(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          if (MessageForPic.class.isInstance(localChatMessage))
          {
            MessageForPic localMessageForPic = (MessageForPic)localChatMessage;
            if ((paramLong1 != localMessageForPic.uniseq) || (paramLong2 != localMessageForPic.subMsgId)) {
              continue;
            }
            return localChatMessage;
          }
          if (paramLong1 != localChatMessage.uniseq) {
            continue;
          }
        }
      }
      Object localObject2 = null;
    }
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
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      throw new IllegalArgumentException("no appRuntime", localAccountNotMatchException);
    }
    throw new IllegalArgumentException("message not find..");
  }
  
  public Intent a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = b(paramLong, paramInt1);
    if (localObject != null)
    {
      if (!MessageForPic.class.isInstance(localObject)) {
        break label53;
      }
      localObject = (MessageForPic)localObject;
      if ((((MessageForPic)localObject).uniseq != paramLong) || (((MessageForPic)localObject).subMsgId != paramInt1)) {}
    }
    return null;
    label53:
    Intent localIntent;
    if (MessageForShortVideo.class.isInstance(localObject))
    {
      localObject = (MessageForShortVideo)localObject;
      if (((MessageForShortVideo)localObject).uniseq != paramLong) {
        break label149;
      }
      localIntent = a((MessageForShortVideo)localObject);
      localObject = localIntent;
      if (localIntent != null) {
        localIntent.putExtra("from_uin_type", paramInt2);
      }
    }
    label149:
    for (localObject = localIntent;; localObject = null)
    {
      return localObject;
      if (!MessageForFile.class.isInstance(localObject)) {
        break;
      }
      localObject = (MessageForFile)localObject;
      if (((MessageForFile)localObject).uniseq != paramLong) {
        break;
      }
      return a((MessageForFile)localObject);
    }
  }
  
  public Intent a(MessageForFile paramMessageForFile)
  {
    try
    {
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (localFileManagerEntity == null) {
        return null;
      }
      Intent localIntent = new Intent();
      localIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      localBundle.putParcelable("fileinfo", ForwardFileOption.a(localFileManagerEntity, paramMessageForFile));
      localBundle.putString("forward_text", "已选择" + FileManagerUtil.d(localFileManagerEntity.fileName) + "，大小" + FileUtil.a(localFileManagerEntity.fileSize) + "。");
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putString("forward_filepath", localFileManagerEntity.getFilePath());
      localBundle.putBoolean("k_favorites", FileManagerUtil.c(localFileManagerEntity));
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
  
  /* Error */
  public ChatMessage a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7: astore 9
    //   9: aload 9
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore 6
    //   15: iload 6
    //   17: aload_0
    //   18: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   21: invokeinterface 328 1 0
    //   26: if_icmpge +217 -> 243
    //   29: aload_0
    //   30: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   33: iload 6
    //   35: invokeinterface 331 2 0
    //   40: checkcast 71	com/tencent/mobileqq/data/ChatMessage
    //   43: astore 7
    //   45: ldc_w 350
    //   48: aload 7
    //   50: invokevirtual 119	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   53: ifeq +143 -> 196
    //   56: aload 7
    //   58: checkcast 350	com/tencent/mobileqq/data/MessageForPic
    //   61: astore 10
    //   63: lload_1
    //   64: aload 10
    //   66: getfield 581	com/tencent/mobileqq/data/MessageForPic:uniseq	J
    //   69: lcmp
    //   70: ifne +183 -> 253
    //   73: lload_3
    //   74: aload 10
    //   76: getfield 584	com/tencent/mobileqq/data/MessageForPic:subMsgId	I
    //   79: i2l
    //   80: lcmp
    //   81: ifne +172 -> 253
    //   84: iconst_1
    //   85: istore 5
    //   87: iload 5
    //   89: ifeq +15 -> 104
    //   92: aload_0
    //   93: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 684 2 0
    //   103: pop
    //   104: aload 9
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 45	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   111: astore 8
    //   113: aload 8
    //   115: monitorenter
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: aload_0
    //   122: getfield 45	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   125: invokeinterface 328 1 0
    //   130: if_icmpge +107 -> 237
    //   133: aload_0
    //   134: getfield 45	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   137: iload 5
    //   139: invokeinterface 331 2 0
    //   144: checkcast 686	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   147: astore 9
    //   149: aload 9
    //   151: getfield 689	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:jdField_g_of_type_Long	J
    //   154: lload_1
    //   155: lcmp
    //   156: ifne +64 -> 220
    //   159: aload 9
    //   161: getfield 692	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:f	I
    //   164: i2l
    //   165: lload_3
    //   166: lcmp
    //   167: ifne +53 -> 220
    //   170: iconst_1
    //   171: istore 6
    //   173: iload 6
    //   175: ifeq +15 -> 190
    //   178: aload_0
    //   179: getfield 45	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   182: iload 5
    //   184: invokeinterface 684 2 0
    //   189: pop
    //   190: aload 8
    //   192: monitorexit
    //   193: aload 7
    //   195: areturn
    //   196: lload_1
    //   197: aload 7
    //   199: getfield 302	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   202: lcmp
    //   203: ifne +50 -> 253
    //   206: iconst_1
    //   207: istore 5
    //   209: goto -122 -> 87
    //   212: astore 7
    //   214: aload 9
    //   216: monitorexit
    //   217: aload 7
    //   219: athrow
    //   220: iload 5
    //   222: iconst_1
    //   223: iadd
    //   224: istore 5
    //   226: goto -107 -> 119
    //   229: astore 7
    //   231: aload 8
    //   233: monitorexit
    //   234: aload 7
    //   236: athrow
    //   237: iconst_0
    //   238: istore 6
    //   240: goto -67 -> 173
    //   243: iconst_0
    //   244: istore 5
    //   246: aload 8
    //   248: astore 7
    //   250: goto -163 -> 87
    //   253: iload 6
    //   255: iconst_1
    //   256: iadd
    //   257: istore 6
    //   259: goto -244 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	AIOImageProviderService
    //   0	262	1	paramLong1	long
    //   0	262	3	paramLong2	long
    //   85	160	5	i	int
    //   13	245	6	j	int
    //   43	155	7	localChatMessage	ChatMessage
    //   212	6	7	localObject1	Object
    //   229	6	7	localObject2	Object
    //   248	1	7	localList1	List
    //   1	246	8	localList2	List
    //   7	208	9	localObject3	Object
    //   61	14	10	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   15	84	212	finally
    //   92	104	212	finally
    //   104	107	212	finally
    //   196	206	212	finally
    //   214	217	212	finally
    //   119	170	229	finally
    //   178	190	229	finally
    //   190	193	229	finally
    //   231	234	229	finally
  }
  
  public MessageForShortVideo a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject1).next();
          if ((paramLong != localChatMessage.uniseq) || (!MessageForShortVideo.class.isInstance(localChatMessage))) {
            continue;
          }
          localObject1 = (MessageForShortVideo)localChatMessage;
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "[destroy] " + this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener = null;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "[loadMedias] + loadType: " + paramInt + ", dataList.size = " + this.jdField_b_of_type_JavaUtilList.size());
      }
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new vlm(this));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null);
    ArrayList localArrayList;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      localArrayList = new ArrayList();
      ??? = this.jdField_b_of_type_JavaUtilList;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label340;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      ??? = (AIORichMediaData[])localObject2.toArray(new AIORichMediaData[localObject2.size()]);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a((AIORichMediaData[])???, -1);
      return;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new vlm(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null) {
        break;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jdField_b_of_type_JavaUtilList.toArray(new AIORichMediaData[this.jdField_b_of_type_JavaUtilList.size()]);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener.a(arrayOfAIORichMediaData, -1);
          return;
        }
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new vlm(this));
      return;
      label340:
      paramInt += 1;
    }
  }
  
  public void a(long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new vll(this, paramLong));
  }
  
  public void a(long paramLong, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new vlk(this, paramLong, paramInt));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = b(paramLong, paramInt1);
    if (localObject != null)
    {
      if (!MessageForPic.class.isInstance(localObject)) {
        break label39;
      }
      a((MessageForPic)localObject, paramLong, paramInt1, paramInt2);
    }
    label39:
    do
    {
      return;
      if (MessageForShortVideo.class.isInstance(localObject))
      {
        a((MessageForShortVideo)localObject, paramLong, paramInt1, paramInt2);
        return;
      }
      if (MessageForFile.class.isInstance(localObject))
      {
        localObject = (MessageForFile)localObject;
        Looper localLooper = Looper.getMainLooper();
        if (Thread.currentThread() != localLooper.getThread())
        {
          new Handler(localLooper).post(new vlf(this, (MessageForFile)localObject, paramLong, paramInt1, paramInt2));
          return;
        }
        a((MessageForFile)localObject, paramLong, paramInt1, paramInt2);
        return;
      }
    } while (!MessageForTroopFile.class.isInstance(localObject));
    a((MessageForTroopFile)localObject, paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label517;
        }
        localObject = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(i);
        if (!AIOImageData.class.isInstance(localObject)) {
          break label277;
        }
        localObject = (AIOImageData)localObject;
        if ((((AIOImageData)localObject).jdField_g_of_type_Long != paramLong) || (((AIOImageData)localObject).f != paramInt1)) {
          break label651;
        }
        if (!"I:E".equals(paramString)) {
          break label524;
        }
        switch (paramInt2)
        {
        case 3: 
          return;
        }
      }
      finally {}
      ((AIOImageData)localObject).jdField_b_of_type_Boolean = true;
      continue;
      ((AIOImageData)localObject).jdField_c_of_type_Boolean = true;
      continue;
      ((AIOImageData)localObject).jdField_a_of_type_Boolean = true;
      continue;
      ((AIOImageData)localObject).jdField_a_of_type_JavaLangString = paramString;
      continue;
      ((AIOImageData)localObject).jdField_b_of_type_JavaLangString = paramString;
      if ((!((AIOImageData)localObject).jdField_g_of_type_Boolean) && (new File(((AIOImageData)localObject).jdField_a_of_type_JavaLangString + "_hd").exists()))
      {
        ((AIOImageData)localObject).jdField_a_of_type_JavaLangString += "_hd";
        continue;
        ((AIOImageData)localObject).jdField_c_of_type_JavaLangString = paramString;
        continue;
        ((AIOImageData)localObject).d = paramString;
        continue;
        label277:
        if (AIOShortVideoData.class.isInstance(localObject))
        {
          localObject = (AIOShortVideoData)localObject;
          if (((AIOShortVideoData)localObject).jdField_g_of_type_Long != paramLong) {
            break label651;
          }
          if (!"I:E".equals(paramString)) {}
        }
        else
        {
          switch (paramInt2)
          {
          case 0: 
          case 1: 
            for (;;)
            {
              label340:
              return;
              ((AIOShortVideoData)localObject).jdField_a_of_type_Boolean = true;
              continue;
              ((AIOShortVideoData)localObject).jdField_b_of_type_Boolean = true;
              continue;
              ((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString = paramString;
              continue;
              ((AIOShortVideoData)localObject).jdField_b_of_type_JavaLangString = paramString;
            }
            if (!AIOFilePicData.class.isInstance(localObject)) {
              break label651;
            }
            localObject = (AIOFilePicData)localObject;
            if (((AIOFilePicData)localObject).jdField_g_of_type_Long != paramLong) {
              break label651;
            }
            if ("I:E".equals(paramString)) {
              switch (paramInt2)
              {
              }
            }
            break;
          }
        }
        for (;;)
        {
          return;
          ((AIOFilePicData)localObject).jdField_a_of_type_Boolean = true;
          continue;
          ((AIOFilePicData)localObject).jdField_b_of_type_Boolean = true;
          continue;
          ((AIOFilePicData)localObject).jdField_c_of_type_Boolean = true;
          continue;
          ((AIOFilePicData)localObject).jdField_b_of_type_JavaLangString = paramString;
          continue;
          ((AIOFilePicData)localObject).jdField_c_of_type_JavaLangString = paramString;
          continue;
          ((AIOFilePicData)localObject).d = paramString;
          continue;
          label517:
          return;
          break;
          label524:
          switch (paramInt2)
          {
          }
          break;
          break label340;
          switch (paramInt2)
          {
          }
          break label340;
          continue;
          switch (paramInt2)
          {
          }
        }
        label651:
        i += 1;
      }
    }
  }
  
  public void a(AIOImageProviderService.AIOImageProviderListener paramAIOImageProviderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener = paramAIOImageProviderListener;
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageProviderService", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new vlg(this);
      paramQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {
      return;
    }
    ((PicStatisticsManager)paramQQAppInterface.getManager(72)).c(paramMessageForPic);
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface.a.b(paramMessageForPic, paramMessageForPic.size);
    paramQQAppInterface.f();
  }
  
  public void a(MessageForFile paramMessageForFile, long paramLong, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime;
    try
    {
      localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      paramMessageForFile = ((QQAppInterface)localAppRuntime).a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (paramMessageForFile == null) {
        return;
      }
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)localAppRuntime).a().a(paramMessageForFile.nSessionId);
      if (localFileManagerEntity != null) {
        paramMessageForFile = localFileManagerEntity;
      }
      if (this.jdField_c_of_type_JavaUtilList == null) {
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_d_of_type_JavaUtilList == null) {
        this.jdField_d_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_e_of_type_JavaUtilList == null) {
        this.jdField_e_of_type_JavaUtilList = new ArrayList();
      }
      a((QQAppInterface)localAppRuntime);
      switch (paramInt2)
      {
      case 16: 
        this.jdField_c_of_type_JavaUtilList.add(paramMessageForFile);
        paramMessageForFile.mContext = new String("igonFlow");
        ((QQAppInterface)localAppRuntime).a().a(paramMessageForFile, 5);
        return;
      }
    }
    catch (AccountNotMatchException paramMessageForFile)
    {
      paramMessageForFile.printStackTrace();
      return;
    }
    this.jdField_c_of_type_JavaUtilList.add(paramMessageForFile);
    paramMessageForFile.mContext = new String("igonFlow");
    ((QQAppInterface)localAppRuntime).a().a(paramMessageForFile, 7);
    return;
    this.jdField_e_of_type_JavaUtilList.add(paramMessageForFile);
    ((QQAppInterface)localAppRuntime).a().b(paramMessageForFile);
    return;
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    PicReq localPicReq;
    int i;
    switch (paramInt2)
    {
    case 3: 
    default: 
      return;
    case 2: 
      localPicReq = PicBusiManager.a(6, 1536, 1);
      i = 1;
    }
    for (;;)
    {
      try
      {
        localPicReq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, i, null).toString().toString());
        localPicReq.a(new vlh(this, paramLong, paramInt1, paramInt2, paramMessageForPic.size, str));
        PicBusiManager.a(localPicReq, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString));
        return;
      }
      catch (AccountNotMatchException paramMessageForPic) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
      return;
      localPicReq = PicBusiManager.a(7, 1);
      i = 131075;
      continue;
      localPicReq = PicBusiManager.a(5, 1);
      i = 65537;
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 2);
      ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
      if (paramInt2 == 0)
      {
        localShortVideoDownloadInfo.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
      }
      for (;;)
      {
        localShortVideoReq.a(localShortVideoDownloadInfo);
        localShortVideoReq.a(new vlj(this, paramLong, paramInt1, paramInt2));
        ShortVideoBusiManager.a(localShortVideoReq, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString));
        return;
        localShortVideoDownloadInfo.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForShortVideo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "no appRuntime");
      }
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile)
  {
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if (localQQAppInterface1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, app == null");
        }
        return;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      TroopFileStatusInfo localTroopFileStatusInfo;
      do
      {
        QQAppInterface localQQAppInterface2;
        do
        {
          do
          {
            for (;;)
            {
              localAccountNotMatchException.printStackTrace();
              localQQAppInterface2 = null;
            }
            localTroopFileStatusInfo = TroopFileUtils.a(localQQAppInterface2, paramMessageForTroopFile);
            if (localTroopFileStatusInfo != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, info == null");
          return;
          paramMessageForTroopFile = paramMessageForTroopFile.frienduin;
        } while (TextUtils.isEmpty(paramMessageForTroopFile));
        paramMessageForTroopFile = TroopFileTransferManager.a(localQQAppInterface2, Long.valueOf(paramMessageForTroopFile).longValue());
      } while (localTroopFileStatusInfo.jdField_b_of_type_Int != 8);
      paramMessageForTroopFile.f(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      paramMessageForTroopFile.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      localObject1 = localQQAppInterface;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                localAccountNotMatchException.printStackTrace();
              }
              localTroopFileStatusInfo = TroopFileUtils.a(localObject1, paramMessageForTroopFile);
              if (localTroopFileStatusInfo != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("AIOImageProviderService", 2, "downloadTroopOriginalImage, info == null");
            return;
            if (!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("AIOImageProviderService", 2, "downloadTroopOriginalImage, info.FilePath is empty");
          return;
          str = localTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
        } while (paramInt2 != 4);
        localObject2 = paramMessageForTroopFile.frienduin;
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      localObject2 = TroopFileTransferManager.a(localObject1, Long.valueOf((String)localObject2).longValue());
      if (localTroopFileStatusInfo.jdField_b_of_type_Int != 11) {
        break label224;
      }
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadTroopOriginalImage, app == null");
      }
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo;
    String str;
    Object localObject2;
    if (FileUtils.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramLong, paramInt1, paramInt2, 1, localTroopFileStatusInfo.jdField_a_of_type_JavaLangString, false);
      }
    }
    for (;;)
    {
      localObject1.addObserver(new vli(this, str, paramLong, paramInt1, paramInt2, paramMessageForTroopFile, localObject1));
      return;
      label224:
      if ((localTroopFileStatusInfo.jdField_b_of_type_Int == 7) || ((localTroopFileStatusInfo.jdField_b_of_type_Int == 11) && (!FileUtils.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)))) {
        ((TroopFileTransferManager)localObject2).a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo.jdField_e_of_type_Int);
      } else {
        ((TroopFileTransferManager)localObject2).e(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "reportData,sendReportType:" + paramString + ",count:" + paramInt);
    }
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if (paramInt == 55)
      {
        StatisticConstants.a(paramString, this.jdField_a_of_type_Int, (QQAppInterface)localAppRuntime);
        return;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(localAppRuntime, this.jdField_a_of_type_JavaLangString, "Pic", paramString, 0, 1, null, String.valueOf(paramInt), null, null, null);
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      throw new IllegalArgumentException("no appRuntime", paramString);
    }
  }
  
  public boolean a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaData))
    {
      if (((AIOShortVideoData)paramAIORichMediaData).jdField_b_of_type_Int != 0) {}
    }
    else {
      while (AIOFileVideoData.class.isInstance(paramAIORichMediaData)) {
        return true;
      }
    }
    return false;
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
    Object localObject = a(paramLong);
    if ((localObject != null) && (MessageForFile.class.isInstance(localObject)))
    {
      localObject = (MessageForFile)localObject;
      if (((MessageForFile)localObject).uniseq == paramLong)
      {
        AppRuntime localAppRuntime;
        FileManagerEntity localFileManagerEntity;
        for (;;)
        {
          try
          {
            localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
            localFileManagerEntity = ((QQAppInterface)localAppRuntime).a().a(((MessageForFile)localObject).uniseq, ((MessageForFile)localObject).frienduin, ((MessageForFile)localObject).istroop);
            if (localFileManagerEntity == null) {
              return;
            }
            switch (localFileManagerEntity.getCloudType())
            {
            case 1: 
              if (((MessageForFile)localObject).isSend())
              {
                localObject = ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
                ((QQAppInterface)localAppRuntime).a().a(localFileManagerEntity, (String)localObject);
                return;
              }
              break;
            }
          }
          catch (AccountNotMatchException localAccountNotMatchException)
          {
            localAccountNotMatchException.printStackTrace();
            return;
          }
          String str = localFileManagerEntity.peerUin;
        }
        ((QQAppInterface)localAppRuntime).a().a(localFileManagerEntity.getFilePath(), null, localAppRuntime.getAccount(), 0, false);
      }
    }
    return;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    ChatMessage localChatMessage = b(paramLong, paramInt1);
    if (localChatMessage != null)
    {
      if (!MessageForPic.class.isInstance(localChatMessage)) {
        break label39;
      }
      b((MessageForPic)localChatMessage, paramLong, paramInt1, paramInt2);
    }
    label39:
    do
    {
      do
      {
        return;
      } while (MessageForShortVideo.class.isInstance(localChatMessage));
      if (MessageForFile.class.isInstance(localChatMessage))
      {
        a((MessageForFile)localChatMessage, paramLong);
        return;
      }
    } while (!MessageForTroopFile.class.isInstance(localChatMessage));
    a((MessageForTroopFile)localChatMessage);
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      paramMessageForPic = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a().a(TransFileController.a(paramMessageForPic.md5, paramMessageForPic.uuid, 131075));
      if ((paramMessageForPic instanceof C2CPicDownloadProcessor))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "destroy cancel processor:" + paramMessageForPic);
        }
        ((BaseDownloadProcessor)paramMessageForPic).a();
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = null;
  }
  
  public void c(long paramLong)
  {
    Object localObject = a(paramLong);
    if ((localObject != null) && (MessageForFile.class.isInstance(localObject)))
    {
      localObject = (MessageForFile)localObject;
      try
      {
        localObject = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a().a(((MessageForFile)localObject).uniseq, ((MessageForFile)localObject).frienduin, ((MessageForFile)localObject).istroop);
        if (localObject == null) {
          return;
        }
        Intent localIntent = new Intent(BaseApplicationImpl.sApplication.getBaseContext(), FilePicQFavActivity.class);
        localIntent.putExtra("file_pic_favorites", ((FileManagerEntity)localObject).nSessionId);
        BaseActivity.sTopActivity.startActivity(localIntent);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        localAccountNotMatchException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
 * JD-Core Version:    0.7.0.1
 */