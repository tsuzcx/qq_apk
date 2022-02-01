package com.tencent.mobileqq.activity.aio.photo;

import adak;
import ahng;
import aics;
import aicv;
import aidh;
import aidi;
import aidj;
import aidk;
import aidl;
import aidm;
import aidn;
import aidy;
import aiea;
import aiec;
import aiyz;
import akrx;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anua;
import anxg;
import anzj;
import anzr;
import aous;
import atpa;
import atqx;
import atup;
import atur;
import atvk;
import atvv;
import aufc;
import aufg;
import aufj;
import aufl;
import aunj;
import auog;
import auoo;
import avlv;
import axpx;
import axqb;
import azqb;
import azqk;
import azqq;
import azqw;
import bcwu;
import bcwx;
import bcxn;
import bdll;
import bdmc;
import bdqr;
import beqz;
import berj;
import berz;
import beyb;
import beyq;
import bfrs;
import bftf;
import bgrn;
import bgsk;
import bhmi;
import bhnt;
import bhnv;
import blhq;
import bmko;
import bnzk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
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
  extends aiea
{
  public static final HashMap<String, AIOImageProviderService> a;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public aidl a;
  private anua jdField_a_of_type_Anua;
  atpa jdField_a_of_type_Atpa;
  blhq jdField_a_of_type_Blhq;
  private AIOImageProviderService.IncreasinglyLoadMediaTask jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask = new AIOImageProviderService.IncreasinglyLoadMediaTask(this);
  String jdField_a_of_type_JavaLangString;
  public ArrayList<Long> a;
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
  
  protected AIOImageProviderService()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    if (paramChatMessage != null)
    {
      this.jdField_a_of_type_Boolean = paramChatMessage.isMultiMsg;
      this.jdField_a_of_type_Long = paramChatMessage.msgseq;
      this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
      if (adak.a(paramChatMessage.istroop) == 1032) {
        this.jdField_b_of_type_Int = paramChatMessage.getConfessTopicId();
      }
    }
    this.jdField_a_of_type_Blhq = new blhq(ThreadManager.getFileThreadLooper(), null);
    this.jdField_b_of_type_Boolean = anxg.a(paramChatMessage);
    if ((!this.jdField_a_of_type_Boolean) && (!MessageForApollo.class.isInstance(paramChatMessage)))
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
      QLog.e("AIOImageProviderService", 1, "～～～～～～～call AIOImageProviderService～～～～～～～");
      paramString1 = BaseActivity.sTopActivity;
      if (paramString1 != null)
      {
        this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramString1);
        return;
      }
    }
    catch (AccountNotMatchException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
      a("Static Null", "Init");
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
    localBundle.putString("from_uin", ShortVideoUtils.d(paramMessageForShortVideo));
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str2 = ShortVideoUtils.c(paramMessageForShortVideo);
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
    if (bhmi.b(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
    }
    return new Intent().putExtras(localBundle);
  }
  
  private Intent a(MessageForTroopFile paramMessageForTroopFile)
  {
    Object localObject1;
    try
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      localObject1 = bgsk.a((QQAppInterface)localObject1, paramMessageForTroopFile);
      if (localObject1 == null)
      {
        QLog.w("AIOImageProviderService", 1, "getFileStatusInfo is null");
        return null;
      }
    }
    catch (AccountNotMatchException paramMessageForTroopFile)
    {
      paramMessageForTroopFile.printStackTrace();
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject2 = aunj.a((bftf)localObject1);
    ((FileManagerEntity)localObject2).status = 2;
    ((FileManagerEntity)localObject2).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
    localForwardFileInfo.b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).getFilePath())) {
      localForwardFileInfo.a(((bftf)localObject1).jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(((bftf)localObject1).g);
    localForwardFileInfo.d(((bftf)localObject1).jdField_c_of_type_Long);
    localForwardFileInfo.a(Long.parseLong(paramMessageForTroopFile.frienduin));
    if (((bftf)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
      localForwardFileInfo.e(((bftf)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
    }
    if (!TextUtils.isEmpty(((bftf)localObject1).jdField_c_of_type_JavaLangString)) {
      localForwardFileInfo.f(((bftf)localObject1).jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras(localBundle);
      ((Intent)localObject2).putExtra("forward_text", ((bftf)localObject1).g);
      ((Intent)localObject2).putExtra("forward_from_troop_file", true);
      ((Intent)localObject2).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject2).putExtra("forward _key_nojump", false);
      ((Intent)localObject2).putExtra("sender_uin", paramMessageForTroopFile.senderuin);
      ((Intent)localObject2).putExtra("last_time", paramMessageForTroopFile.lastTime);
      return localObject2;
      if (!TextUtils.isEmpty(((bftf)localObject1).jdField_d_of_type_JavaLangString)) {
        localForwardFileInfo.f(((bftf)localObject1).jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private axqb a()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if (localQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOImageProviderService", 2, "getRichMedialSaveManager app == null");
        }
        return null;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      Object localObject;
      for (;;)
      {
        localAccountNotMatchException.printStackTrace();
        localObject = null;
      }
      return (axqb)localObject.getManager(324);
    }
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
  
  private BaseActivity a(String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject);
      return localObject;
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      localObject = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    for (String str = null; localObject != null; str = "WeakReference Null") {
      return localObject;
    }
    localObject = str;
    if (str == null) {
      localObject = "WeakReference has freed";
    }
    a((String)localObject, paramString);
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
  
  private MessageForTroopFile a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (!this.jdField_b_of_type_JavaUtilHashMap.isEmpty())) {}
    for (Object localObject1 = (MessageForTroopFile)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);; localObject1 = null)
    {
      if (localObject1 == null) {
        for (;;)
        {
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            if (localIterator.hasNext())
            {
              Object localObject2 = (ChatMessage)localIterator.next();
              if (MessageForTroopFile.class.isInstance(localObject2))
              {
                localObject2 = (MessageForTroopFile)localObject2;
                if ((!TextUtils.isEmpty(((MessageForTroopFile)localObject2).url)) && (((MessageForTroopFile)localObject2).url.equals(paramString)))
                {
                  localObject1 = localObject2;
                  if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (localObject1 != null)) {
                    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localObject1);
                  }
                  return localObject1;
                }
              }
            }
          }
        }
      }
      return localObject1;
    }
  }
  
  private String a()
  {
    String str2 = this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int;
    String str1 = str2;
    if (this.jdField_b_of_type_Boolean) {
      str1 = str2 + "_f";
    }
    return str1;
  }
  
  private void a(int paramInt, String paramString, AIOFilePicData paramAIOFilePicData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      case 17: 
      case 19: 
      default: 
        return;
      case 18: 
        paramAIOFilePicData.jdField_a_of_type_Boolean = true;
        return;
      case 20: 
        paramAIOFilePicData.jdField_b_of_type_Boolean = true;
        return;
      }
      paramAIOFilePicData.jdField_c_of_type_Boolean = true;
      return;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      return;
    case 16: 
      paramAIOFilePicData.jdField_b_of_type_JavaLangString = paramString;
      return;
    case 18: 
      paramAIOFilePicData.jdField_c_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOFilePicData.jdField_d_of_type_JavaLangString = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOImageData paramAIOImageData)
  {
    if ("I:E".equals(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      paramAIOImageData.jdField_b_of_type_Boolean = true;
      return;
      paramAIOImageData.jdField_c_of_type_Boolean = true;
      return;
      paramAIOImageData.jdField_a_of_type_Boolean = true;
      return;
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      case 1: 
        paramAIOImageData.jdField_a_of_type_JavaLangString = paramString;
        return;
      case 2: 
        paramAIOImageData.jdField_b_of_type_JavaLangString = paramString;
      }
    } while ((paramAIOImageData.jdField_g_of_type_Boolean) || (!new File(paramAIOImageData.jdField_a_of_type_JavaLangString + "_hd").exists()));
    paramAIOImageData.jdField_a_of_type_JavaLangString += "_hd";
    return;
    paramAIOImageData.jdField_c_of_type_JavaLangString = paramString;
    return;
    paramAIOImageData.jdField_d_of_type_JavaLangString = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOShortVideoData paramAIOShortVideoData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        paramAIOShortVideoData.jdField_a_of_type_Boolean = true;
        return;
      }
      paramAIOShortVideoData.jdField_b_of_type_Boolean = true;
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAIOShortVideoData.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOShortVideoData.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, aufc paramaufc)
  {
    atvv localatvv = atvk.a(paramaufc);
    localatvv.a(new aidj(this, paramaufc, paramLong, paramInt1, paramInt2));
    localatvv.a(new aidk(this, paramaufc, paramLong));
    localatvv.a(true);
    localatvv.a();
  }
  
  private void a(QQAppInterface paramQQAppInterface, bftf parambftf, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
    if ((parambftf.jdField_b_of_type_Int == 11) && (bhmi.a(parambftf.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Aiec != null) {
        this.jdField_a_of_type_Aiec.a(paramLong, paramInt1, paramInt2, 1, parambftf.jdField_a_of_type_JavaLangString, false);
      }
      return;
    }
    if ((parambftf.jdField_b_of_type_Int == 7) || ((parambftf.jdField_b_of_type_Int == 11) && (!bhmi.a(parambftf.jdField_a_of_type_JavaLangString))))
    {
      paramQQAppInterface.a(parambftf.e, parambftf.g, parambftf.jdField_c_of_type_Long, parambftf.h);
      return;
    }
    paramQQAppInterface.c(parambftf.jdField_a_of_type_JavaUtilUUID);
  }
  
  private void a(QQAppInterface paramQQAppInterface, bftf parambftf, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!bhmi.b(parambftf.jdField_c_of_type_JavaLangString)) {
      if (!bhnv.d(BaseApplicationImpl.getApplication())) {
        if (this.jdField_a_of_type_Aiec != null) {
          this.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 18, 2, parambftf.jdField_c_of_type_JavaLangString, false);
        }
      }
    }
    while (this.jdField_a_of_type_Aiec == null)
    {
      return;
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (parambftf.jdField_a_of_type_JavaUtilUUID != null)
      {
        paramQQAppInterface.a(parambftf.jdField_a_of_type_JavaUtilUUID, 640);
        return;
      }
      paramQQAppInterface.a(parambftf.e, parambftf.g, parambftf.h, 640);
      return;
    }
    this.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 18, 1, parambftf.jdField_c_of_type_JavaLangString, false);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, long paramLong, int paramInt)
  {
    String str = paramChatMessage.frienduin;
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      paramChatMessage = bgsk.a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
      if (paramChatMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("VideoPlayControllerForFile.main", 2, "onFileVideoStatusChange[" + paramInt + "], info == null");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.main", 1, "set mobileqq video pause id:" + paramLong + " type:" + paramInt + " troopId:" + paramChatMessage.jdField_a_of_type_JavaUtilUUID);
    }
    TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(str).longValue()).d(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {
      return;
    }
    ((azqq)paramQQAppInterface.getManager(73)).c(paramMessageForPic);
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface.a.b(paramMessageForPic, paramMessageForPic.size);
    paramQQAppInterface.d();
  }
  
  private void a(MessageForFile paramMessageForFile, long paramLong)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      paramMessageForFile = aunj.a(localQQAppInterface, paramMessageForFile);
      localQQAppInterface.a().a(paramMessageForFile.nSessionId);
      return;
    }
    catch (Exception paramMessageForFile)
    {
      while (!QLog.isColorLevel()) {}
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
    bdmc.a(BaseApplication.getContext()).a(null, "ImageProviderService_getTopActivity_event", false, 0L, 0L, localHashMap, null);
  }
  
  private void a(List<AIORichMediaData> paramList)
  {
    aiec localaiec = this.jdField_a_of_type_Aiec;
    ArrayList localArrayList;
    if (localaiec != null)
    {
      localArrayList = new ArrayList();
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 1026)) {
        break label140;
      }
    }
    label140:
    for (Object localObject = paramList; (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 3000); localObject = this.jdField_b_of_type_JavaUtilList)
    {
      localObject = (AIORichMediaData[])((List)localObject).toArray(new AIORichMediaData[((List)localObject).size()]);
      if (localObject.length > 0) {
        localaiec.a((AIORichMediaData[])localObject, -1);
      }
      localObject = this.jdField_a_of_type_Aidl;
      if (localObject != null)
      {
        paramList = (AIORichMediaData[])paramList.toArray(new AIORichMediaData[paramList.size()]);
        if (paramList.length > 0) {
          ((aidl)localObject).a(paramList, -1);
        }
      }
      return;
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < ((List)localObject).size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)((List)localObject).get(i);
          if (a(localAIORichMediaData)) {
            break label238;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      localObject = (AIORichMediaData[])localArrayList.toArray(new AIORichMediaData[localArrayList.size()]);
      break;
      label238:
      i += 1;
    }
  }
  
  private void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageForTroopFile paramMessageForTroopFile)
  {
    int j = 1;
    int k = aunj.a(paramMessageForTroopFile.fileName);
    int i;
    label26:
    Object localObject;
    if (k == 0)
    {
      i = 1;
      if (k != 2) {
        break label48;
      }
      localObject = bgsk.a(a(), paramMessageForTroopFile);
      if (localObject != null) {
        break label54;
      }
    }
    label48:
    label54:
    label92:
    do
    {
      do
      {
        do
        {
          return;
          i = 0;
          break;
          j = 0;
          break label26;
          if (i == 0) {
            break label92;
          }
          localObject = aicv.a(paramMessageForTroopFile, a());
        } while (localObject == null);
        paramList.add(localObject);
        paramList1.add(paramMessageForTroopFile);
        return;
      } while ((j == 0) || ((!auog.b(((bftf)localObject).jdField_a_of_type_JavaLangString)) && (!auoo.a(a()))));
      localObject = aicv.a(paramMessageForTroopFile, a());
    } while (localObject == null);
    paramList.add(localObject);
    paramList1.add(paramMessageForTroopFile);
  }
  
  public static boolean a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaData)) {
      paramAIORichMediaData = (AIOShortVideoData)paramAIORichMediaData;
    }
    while ((AIOFileVideoData.class.isInstance(paramAIORichMediaData)) || (!AIOLightVideoData.class.isInstance(paramAIORichMediaData))) {
      return false;
    }
    return true;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if (MessageForFile.class.isInstance(paramMessageRecord)) {
      paramMessageRecord = (MessageForFile)paramMessageRecord;
    }
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject).a().b(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localFileManagerEntity != null)
        {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.nSessionId);
          if (localObject != null) {
            paramMessageRecord.fileName = ((FileManagerEntity)localObject).fileName;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label84:
      break label84;
    }
    return 2 == aunj.a(paramMessageRecord.fileName);
    if (MessageForTroopFile.class.isInstance(paramMessageRecord)) {
      return 2 == aunj.a(((MessageForTroopFile)paramMessageRecord).fileName);
    }
    return false;
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
  
  private void b(QQAppInterface paramQQAppInterface, bftf parambftf, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!bhmi.b(parambftf.jdField_d_of_type_JavaLangString))
    {
      if ((!bhnv.d(BaseApplicationImpl.getApplication())) && (this.jdField_a_of_type_Aiec != null)) {
        this.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 16, 2, parambftf.jdField_c_of_type_JavaLangString, false);
      }
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (parambftf.jdField_a_of_type_JavaUtilUUID != null) {
        paramQQAppInterface.a(parambftf.jdField_a_of_type_JavaUtilUUID, 383);
      }
    }
    while (this.jdField_a_of_type_Aiec == null)
    {
      return;
      paramQQAppInterface.a(parambftf.e, parambftf.g, parambftf.h, 383);
      return;
    }
    this.jdField_a_of_type_Aiec.a(paramMessageForTroopFile.uniseq, 0, 1, 1, parambftf.jdField_d_of_type_JavaLangString, false);
  }
  
  private void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, long paramLong, int paramInt)
  {
    Object localObject = paramChatMessage.frienduin;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    label191:
    do
    {
      do
      {
        return;
        paramChatMessage = bgsk.a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
        if (paramChatMessage != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.main", 2, "onFileVideoStatusChange[" + paramInt + "], info == null");
      return;
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf((String)localObject).longValue());
      localObject = paramQQAppInterface.a(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
      if (auog.b(paramChatMessage.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop VideoPlayControllerForFile.main", 1, "Play id:" + paramLong + " type: FILE_VIDEO_PEEK_PAUSE file is exsited");
        }
        if (13 == paramInt)
        {
          localObject = BaseApplicationImpl.sApplication.getBaseContext();
          if (localObject == null) {
            break label191;
          }
          aunj.a((Context)localObject, paramChatMessage.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          paramChatMessage = paramQQAppInterface.a(paramChatMessage.jdField_a_of_type_JavaUtilUUID);
          if (paramChatMessage == null) {
            break;
          }
          paramQQAppInterface.a(paramChatMessage, 11);
          return;
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.main", 1, "set mobileqq video Play id:" + paramLong + " type:" + paramInt + " troopId:" + paramChatMessage.jdField_a_of_type_JavaUtilUUID);
      }
    } while (localObject == null);
    paramQQAppInterface.a((TroopFileTransferManager.Item)localObject, 8);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    axqb localaxqb = a();
    if (localaxqb != null) {
      localaxqb.a(paramMessageForPic, paramLong, paramInt1, paramInt2);
    }
  }
  
  private void d(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    int j = 1;
    int k = 0;
    MessageForFile localMessageForFile = (MessageForFile)paramMessageRecord;
    if ((adak.a(this.jdField_a_of_type_Int) == 1032) && (this.jdField_b_of_type_Int > 0) && (paramMessageRecord.getConfessTopicId() != this.jdField_b_of_type_Int)) {
      return;
    }
    paramMessageRecord = a().a().a(localMessageForFile.uniseq, localMessageForFile.frienduin, localMessageForFile.istroop);
    int i;
    if ((paramMessageRecord != null) && (((aunj.e(paramMessageRecord)) && (paramMessageRecord.nFileType != 2)) || (16 != paramMessageRecord.status))) {
      if (paramMessageRecord.nFileType == 0)
      {
        i = 1;
        if (paramMessageRecord.nFileType != 2) {
          break label167;
        }
      }
    }
    for (;;)
    {
      label116:
      Object localObject = null;
      if (i != 0)
      {
        localMessageForFile.parse();
        paramMessageRecord = aicv.a(localMessageForFile, a());
      }
      for (;;)
      {
        if (paramMessageRecord == null) {
          break label236;
        }
        paramList.add(paramMessageRecord);
        paramList1.add(localMessageForFile);
        return;
        i = 0;
        break;
        label167:
        j = 0;
        break label116;
        if (j != 0)
        {
          localMessageForFile.parse();
          paramMessageRecord = aicv.a(localMessageForFile, a());
        }
        else
        {
          paramMessageRecord = localObject;
          if (QLog.isColorLevel())
          {
            QLog.i("AIOImageProviderService", 2, "ignore filePic: " + localMessageForFile);
            paramMessageRecord = localObject;
          }
        }
      }
      label236:
      break;
      i = 0;
      j = k;
    }
  }
  
  public int a(long paramLong, int paramInt)
  {
    int j = -1;
    Object localObject = a();
    int i = j;
    if (localObject != null)
    {
      ChatMessage localChatMessage = b(paramLong, paramInt);
      if ((localChatMessage == null) && (QLog.isColorLevel())) {
        QLog.i("AIOImageProviderService", 2, "getSaveFileProgress chatMessage is null");
      }
      localObject = ((axqb)localObject).a(((axqb)localObject).a(localChatMessage));
      i = j;
      if (localObject != null)
      {
        i = j;
        if (!((axpx)localObject).jdField_a_of_type_Boolean)
        {
          i = j;
          if (((axpx)localObject).jdField_d_of_type_Int == 1) {
            i = ((axpx)localObject).jdField_c_of_type_Int;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageProviderService", 2, "getSaveFileProgress progress = " + i);
    }
    return i;
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
        localObject1 = bmko.a((Entity)localObject1).b((QQAppInterface)localObject2, (MessageRecord)localObject1).a();
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
        break label226;
      }
      localIntent = a((MessageForShortVideo)localObject);
      localObject = localIntent;
      if (localIntent != null) {
        localIntent.putExtra("from_uin_type", paramInt2);
      }
    }
    label226:
    for (localObject = localIntent;; localObject = null)
    {
      return localObject;
      if (MessageForFile.class.isInstance(localObject))
      {
        localObject = (MessageForFile)localObject;
        if (((MessageForFile)localObject).uniseq != paramLong) {
          break;
        }
        return a((MessageForFile)localObject);
      }
      if (!MessageForTroopFile.class.isInstance(localObject)) {
        break;
      }
      localObject = (MessageForTroopFile)localObject;
      if (((MessageForTroopFile)localObject).uniseq != paramLong)
      {
        QLog.e("AIOImageProviderService", 1, "msg id : " + ((MessageForTroopFile)localObject).uniseq + " request id:" + paramLong);
        return null;
      }
      return a((MessageForTroopFile)localObject);
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
      localBundle.putString("forward_text", anzj.a(2131699009) + aunj.d(localFileManagerEntity.fileName) + anzj.a(2131699011) + auog.a(localFileManagerEntity.fileSize) + "。");
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putString("forward_filepath", localFileManagerEntity.getFilePath());
      localBundle.putBoolean("k_favorites", aunj.c(localFileManagerEntity));
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
    return aicv.a(paramMessageForPic);
  }
  
  public ChatMessage a(long paramLong)
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
  
  /* Error */
  public ChatMessage a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7: astore 9
    //   9: aload 9
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore 6
    //   15: iload 6
    //   17: aload_0
    //   18: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   21: invokeinterface 779 1 0
    //   26: if_icmpge +217 -> 243
    //   29: aload_0
    //   30: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   33: iload 6
    //   35: invokeinterface 798 2 0
    //   40: checkcast 99	com/tencent/mobileqq/data/ChatMessage
    //   43: astore 7
    //   45: ldc_w 716
    //   48: aload 7
    //   50: invokevirtual 152	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   53: ifeq +143 -> 196
    //   56: aload 7
    //   58: checkcast 716	com/tencent/mobileqq/data/MessageForPic
    //   61: astore 10
    //   63: lload_1
    //   64: aload 10
    //   66: getfield 852	com/tencent/mobileqq/data/MessageForPic:uniseq	J
    //   69: lcmp
    //   70: ifne +183 -> 253
    //   73: lload_3
    //   74: aload 10
    //   76: getfield 855	com/tencent/mobileqq/data/MessageForPic:subMsgId	I
    //   79: i2l
    //   80: lcmp
    //   81: ifne +172 -> 253
    //   84: iconst_1
    //   85: istore 5
    //   87: iload 5
    //   89: ifeq +15 -> 104
    //   92: aload_0
    //   93: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 1005 2 0
    //   103: pop
    //   104: aload 9
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   111: astore 8
    //   113: aload 8
    //   115: monitorenter
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: aload_0
    //   122: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   125: invokeinterface 779 1 0
    //   130: if_icmpge +107 -> 237
    //   133: aload_0
    //   134: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   137: iload 5
    //   139: invokeinterface 798 2 0
    //   144: checkcast 781	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   147: astore 9
    //   149: aload 9
    //   151: getfield 1007	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:jdField_f_of_type_Long	J
    //   154: lload_1
    //   155: lcmp
    //   156: ifne +64 -> 220
    //   159: aload 9
    //   161: getfield 1009	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:jdField_f_of_type_Int	I
    //   164: i2l
    //   165: lload_3
    //   166: lcmp
    //   167: ifne +53 -> 220
    //   170: iconst_1
    //   171: istore 6
    //   173: iload 6
    //   175: ifeq +15 -> 190
    //   178: aload_0
    //   179: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   182: iload 5
    //   184: invokeinterface 1005 2 0
    //   189: pop
    //   190: aload 8
    //   192: monitorexit
    //   193: aload 7
    //   195: areturn
    //   196: lload_1
    //   197: aload 7
    //   199: getfield 856	com/tencent/mobileqq/data/ChatMessage:uniseq	J
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
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).getManager(52);
      paramString1 = localTroopManager.a(localTroopManager.b(paramString1), paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "getTroopMemberName exception = " + paramString1.getMessage());
      }
      paramString1.printStackTrace();
    }
    return "";
  }
  
  protected List<AIORichMediaData> a(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      a(localMessageRecord);
      if ((localMessageRecord instanceof MessageForPic)) {
        c(localArrayList1, localArrayList2, localMessageRecord);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localMessageRecord instanceof MessageForMixedMsg)) {
          a(localArrayList1, localArrayList2, (MessageForMixedMsg)localMessageRecord);
        } else if ((localMessageRecord instanceof MessageForStructing)) {
          b(localArrayList1, localArrayList2, localMessageRecord);
        } else if (MessageForShortVideo.class.isInstance(localMessageRecord)) {
          a(localArrayList1, localArrayList2, localMessageRecord);
        } else if ((localMessageRecord instanceof MessageForFile)) {
          d(localArrayList1, localArrayList2, localMessageRecord);
        } else if ((localMessageRecord instanceof MessageForTroopFile)) {
          a(localArrayList1, localArrayList2, (MessageForTroopFile)localMessageRecord);
        } else if (QLog.isColorLevel()) {
          QLog.i("AIOImageProviderService", 2, "messageRecordToData " + localMessageRecord.getBaseInfoString());
        }
      }
    }
    if (this.jdField_c_of_type_Boolean)
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
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "[destroy] " + this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilHashMap.remove(a());
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Int = 60;
    this.jdField_a_of_type_Aidl = null;
    if (this.jdField_a_of_type_Atpa != null) {}
    try
    {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a().deleteObserver(this.jdField_a_of_type_Atpa);
      this.jdField_a_of_type_Atpa = null;
      if (this.jdField_a_of_type_Anua == null) {}
    }
    catch (AccountNotMatchException localAccountNotMatchException1)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).removeObserver(this.jdField_a_of_type_Anua);
        this.jdField_a_of_type_Anua = null;
        QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver suc");
        if (this.jdField_b_of_type_JavaUtilHashMap != null)
        {
          this.jdField_b_of_type_JavaUtilHashMap.clear();
          this.jdField_b_of_type_JavaUtilHashMap = null;
        }
        QLog.e("AIOImageProviderService", 1, "～～～～～～～destory AIOImageProviderService～～～～～～～");
        this.jdField_a_of_type_JavaLangString = null;
        return;
        localAccountNotMatchException1 = localAccountNotMatchException1;
        localAccountNotMatchException1.printStackTrace();
      }
      catch (AccountNotMatchException localAccountNotMatchException2)
      {
        for (;;)
        {
          QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver, but AccountNotMatchException");
          localAccountNotMatchException2.printStackTrace();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aiec == null) && (this.jdField_a_of_type_Aidl == null)) {}
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
        ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
        return;
      }
    } while (this.jdField_a_of_type_Aiec == null);
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
            break label324;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      ??? = (AIORichMediaData[])localObject2.toArray(new AIORichMediaData[localObject2.size()]);
      this.jdField_a_of_type_Aiec.a((AIORichMediaData[])???, -1);
      return;
      ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
      return;
      if (this.jdField_a_of_type_Aidl == null) {
        break;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jdField_b_of_type_JavaUtilList.toArray(new AIORichMediaData[this.jdField_b_of_type_JavaUtilList.size()]);
          this.jdField_a_of_type_Aidl.a(arrayOfAIORichMediaData, -1);
          return;
        }
      }
      ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
      return;
      label324:
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
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("revokeMsg msgseq:");
      if (localChatMessage == null) {
        break label65;
      }
    }
    label65:
    for (long l = localChatMessage.uniseq;; l = 0L)
    {
      QLog.i("AIOImageProviderService", 2, l + ", uniseq:" + paramLong);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new AIOImageProviderService.4(this, paramLong, paramInt));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = b(paramLong, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "carverW downloadMedia type=" + paramInt2 + " id=" + paramLong);
    }
    if (localObject != null) {
      if (MessageForPic.class.isInstance(localObject))
      {
        localObject = (MessageForPic)localObject;
        if (paramInt2 == 24) {
          c((MessageForPic)localObject, paramLong, paramInt1, paramInt2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        a((MessageForPic)localObject, paramLong, paramInt1, paramInt2);
        return;
        if (MessageForShortVideo.class.isInstance(localObject))
        {
          localObject = (MessageForShortVideo)localObject;
          if (paramInt2 == 256)
          {
            a((MessageForShortVideo)localObject, paramLong, paramInt1, paramInt2);
            return;
          }
          c((MessageForShortVideo)localObject, paramLong, paramInt1, paramInt2);
          return;
        }
        if (MessageForFile.class.isInstance(localObject))
        {
          localObject = (MessageForFile)localObject;
          Looper localLooper = Looper.getMainLooper();
          if (Thread.currentThread() != localLooper.getThread())
          {
            new Handler(localLooper).post(new AIOImageProviderService.1(this, (MessageForFile)localObject, paramLong, paramInt1, paramInt2));
            return;
          }
          a((MessageForFile)localObject, paramLong, paramInt1, paramInt2);
          return;
        }
        if (MessageForTroopFile.class.isInstance(localObject))
        {
          localObject = (MessageForTroopFile)localObject;
          ((MessageForTroopFile)localObject).isPause = false;
          a((MessageForTroopFile)localObject, paramLong, paramInt1, paramInt2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOImageProviderService", 2, "downloadMedia fail, msg type not recognize");
      return;
    }
    QLog.d("AIOImageProviderService", 2, "downloadMedia fail, not find msg");
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
          break label185;
        }
        localObject = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(i);
        if (AIOImageData.class.isInstance(localObject))
        {
          localObject = (AIOImageData)localObject;
          if ((((AIOImageData)localObject).jdField_f_of_type_Long != paramLong) || (((AIOImageData)localObject).jdField_f_of_type_Int != paramInt1)) {
            break label189;
          }
          a(paramInt2, paramString, (AIOImageData)localObject);
          return;
        }
        if (AIOShortVideoData.class.isInstance(localObject))
        {
          localObject = (AIOShortVideoData)localObject;
          if (((AIOShortVideoData)localObject).jdField_f_of_type_Long != paramLong) {
            break label189;
          }
          a(paramInt2, paramString, (AIOShortVideoData)localObject);
          return;
        }
      }
      finally {}
      if (AIOFilePicData.class.isInstance(localObject))
      {
        localObject = (AIOFilePicData)localObject;
        if (((AIOFilePicData)localObject).jdField_f_of_type_Long == paramLong)
        {
          a(paramInt2, paramString, (AIOFilePicData)localObject);
          return;
          label185:
          return;
        }
      }
      label189:
      i += 1;
    }
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    ChatMessage localChatMessage;
    QQAppInterface localQQAppInterface;
    try
    {
      localChatMessage = a(paramLong);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if ((localChatMessage != null) && (a(localChatMessage))) {
        break label341;
      }
      QLog.e("VideoPlayControllerForFile.main", 1, "msg is not video, id:" + paramLong);
      return;
    }
    catch (AccountNotMatchException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
    atvk.a(paramBundle.getString("contextid"), true);
    return;
    atvk.a(paramBundle.getString("contextid"));
    if (MessageForTroopFile.class.isInstance(localChatMessage))
    {
      a(localQQAppInterface, localChatMessage, paramLong, paramInt);
      return;
    }
    paramBundle = (MessageForFile)localChatMessage;
    paramBundle = localQQAppInterface.a().a(paramBundle.uniseq, paramBundle.frienduin, paramBundle.istroop);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.main", 1, "set  video pause id:" + paramLong + " type: FILE_VIDEO_PEEK_CANCEL entityId:" + paramBundle.nSessionId);
      }
      localQQAppInterface.a().a(paramBundle.nSessionId);
      return;
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
      }
      paramBundle = paramBundle.getString("contextid");
      atvk.b(paramBundle);
      atvk.a(paramBundle, true);
      if (MessageForTroopFile.class.isInstance(localChatMessage))
      {
        b(localQQAppInterface, localChatMessage, paramLong, paramInt);
        return;
        paramBundle = paramBundle.getString("contextid");
        atvk.b(paramBundle);
        atvk.a(paramBundle, false);
        if (MessageForTroopFile.class.isInstance(localChatMessage))
        {
          b(localQQAppInterface, localChatMessage, paramLong, paramInt);
          return;
          atvk.c(paramBundle.getString("contextid"));
        }
      }
    }
    return;
    label341:
    switch (paramInt)
    {
    }
  }
  
  public void a(aidl paramaidl)
  {
    this.jdField_a_of_type_Aidl = paramaidl;
  }
  
  public void a(aiec paramaiec)
  {
    super.a(paramaiec);
    axqb localaxqb = a();
    if (localaxqb != null) {
      localaxqb.a(paramaiec);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageProviderService", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
    }
    if (this.jdField_a_of_type_Atpa == null)
    {
      this.jdField_a_of_type_Atpa = new aidm(this, paramQQAppInterface);
      paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
    }
  }
  
  public void a(MessageForFile paramMessageForFile, long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      AppRuntime localAppRuntime;
      FileManagerEntity localFileManagerEntity;
      try
      {
        localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
        localObject = ((QQAppInterface)localAppRuntime).a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
        if (localObject == null) {
          return;
        }
        localFileManagerEntity = ((QQAppInterface)localAppRuntime).a().a(((FileManagerEntity)localObject).nSessionId);
        if (localFileManagerEntity == null) {
          break label272;
        }
        if (!TextUtils.isEmpty(paramMessageForFile.fileName)) {
          break label275;
        }
        paramMessageForFile.fileName = localFileManagerEntity.fileName;
      }
      catch (AccountNotMatchException paramMessageForFile)
      {
        paramMessageForFile.printStackTrace();
        return;
      }
      if (!a(paramMessageForFile)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 1, "msg is video, isTroop: " + paramMessageForFile.istroop);
      }
      if (paramMessageForFile.istroop == 3000)
      {
        a(paramLong, paramInt1, paramInt2, new aufj((QQAppInterface)localAppRuntime, localFileManagerEntity));
        return;
      }
      a(paramLong, paramInt1, paramInt2, new aufg((QQAppInterface)localAppRuntime, localFileManagerEntity));
      return;
      ((FileManagerEntity)localObject).mContext = new String("igonFlow");
      ((QQAppInterface)localAppRuntime).a().a((FileManagerEntity)localObject, 5);
      return;
      ((FileManagerEntity)localObject).mContext = new String("igonFlow");
      ((QQAppInterface)localAppRuntime).a().a((FileManagerEntity)localObject, 7);
      return;
      ((QQAppInterface)localAppRuntime).a().b((FileManagerEntity)localObject);
      return;
      label272:
      continue;
      label275:
      Object localObject = localFileManagerEntity;
    }
    switch (paramInt2)
    {
    }
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 3: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "downloadImage fail, businessType not recognize");
      }
      break;
    }
    for (;;)
    {
      return;
      azqk localazqk = azqb.a(6, 1536, 1);
      int i = 1;
      try
      {
        for (;;)
        {
          localazqk.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
          String str = beqz.d(beyq.a(paramMessageForPic, i, null).toString().toString());
          localazqk.a(new aidh(this, paramLong, paramInt1, paramInt2, paramMessageForPic.size, str));
          azqb.a(localazqk, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString));
          return;
          localazqk = azqb.a(7, 1);
          i = 131075;
          continue;
          localazqk = azqb.a(5, 1);
          i = 65537;
        }
      }
      catch (AccountNotMatchException paramMessageForPic)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "downloadImage, no appRuntime");
        }
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "downloadImage end");
        }
      }
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo != null) {
      paramMessageForShortVideo.serial();
    }
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      }
      return;
    }
    catch (Exception paramMessageForShortVideo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, paramMessageForShortVideo.toString());
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    axqb localaxqb = a();
    if (localaxqb != null) {
      localaxqb.a(paramMessageForShortVideo, paramLong, paramInt1, paramInt2);
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
      bftf localbftf;
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
            paramMessageForTroopFile.isPause = true;
            localbftf = bgsk.a(localQQAppInterface2, paramMessageForTroopFile);
            if (localbftf != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, info == null");
          return;
          paramMessageForTroopFile = paramMessageForTroopFile.frienduin;
        } while (TextUtils.isEmpty(paramMessageForTroopFile));
        paramMessageForTroopFile = TroopFileTransferManager.a(localQQAppInterface2, Long.valueOf(paramMessageForTroopFile).longValue());
      } while (localbftf.jdField_b_of_type_Int != 8);
      paramMessageForTroopFile.d(localbftf.jdField_a_of_type_JavaUtilUUID);
      paramMessageForTroopFile.a(localbftf.jdField_a_of_type_JavaUtilUUID);
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      localObject = localQQAppInterface;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      bftf localbftf;
      String str;
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
              localbftf = bgsk.a(localObject, paramMessageForTroopFile);
              if (localbftf != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info == null");
            return;
            if (a(paramMessageForTroopFile))
            {
              if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 1, "troop file is video, getUrl");
              }
              a(paramLong, paramInt1, paramInt2, new aufl(localObject, localbftf));
              return;
            }
            if (!TextUtils.isEmpty(localbftf.e)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info.FilePath is empty");
          return;
          str = localbftf.e;
          str = paramMessageForTroopFile.frienduin;
        } while (TextUtils.isEmpty(str));
        if (paramInt2 == 20)
        {
          a(localObject, localbftf, str, paramLong, paramInt1, paramInt2);
          return;
        }
        if (paramInt2 == 18)
        {
          a(localObject, localbftf, str, paramMessageForTroopFile, paramLong, paramInt1, paramInt2);
          return;
        }
      } while (paramInt2 != 16);
      b(localObject, localbftf, str, paramMessageForTroopFile, paramLong, paramInt1, paramInt2);
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, app == null");
      }
      return;
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
        akrx.a(paramString, this.jdField_a_of_type_Int, (QQAppInterface)localAppRuntime);
        return;
      }
      bdmc.a(BaseApplication.getContext()).a(localAppRuntime, this.jdField_a_of_type_JavaLangString, "Pic", paramString, 0, 1, null, String.valueOf(paramInt), null, null, null);
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
      MessageRecord localMessageRecord = (MessageRecord)paramMessageForMixedMsg.next();
      if (((localMessageRecord instanceof MessageForPic)) && (!a((MessageForPic)localMessageRecord)))
      {
        ((MessageForPic)localMessageRecord).isInMixedMsg = true;
        paramList.add(a((MessageForPic)localMessageRecord));
        paramList1.add((MessageForPic)localMessageRecord);
      }
    }
  }
  
  protected void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    if (MessageForLightVideo.class.isInstance(paramMessageRecord))
    {
      paramMessageRecord = (MessageForLightVideo)paramMessageRecord;
      paramList.add(aicv.a(paramMessageRecord));
      paramList1.add(paramMessageRecord);
    }
    do
    {
      return;
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
    } while ((paramMessageRecord.busiType != 1) && (paramMessageRecord.busiType != 2) && (paramMessageRecord.busiType != 1007) && (paramMessageRecord.busiType != 1009) && (paramMessageRecord.busiType != 0));
    paramList.add(aicv.a(paramMessageRecord));
    paramList1.add(paramMessageRecord);
  }
  
  public void a(long[] paramArrayOfLong)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
      List localList = a(paramArrayOfLong);
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "saveToWeiyunMulti, idList.length = " + paramArrayOfLong.length);
      }
      paramArrayOfLong = a("saveToWeiyunMulti");
      if (paramArrayOfLong != null)
      {
        bnzk.a((QQAppInterface)localAppRuntime, paramArrayOfLong, paramArrayOfLong.getTitleBarHeight(), localList, null);
        bdll.b((QQAppInterface)localAppRuntime, "dc00898", "", "", "0X8009DBA", "0X8009DBA", 0, 0, "", "", "", "");
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
    if ((paramMessageForPic.msgtype == -3000) || (paramMessageForPic.msgtype == -30003)) {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "LoadMediaTask msgType is " + paramMessageForPic.msgtype);
      }
    }
    while ((anzr.a(paramMessageForPic)) || (anxg.a(paramMessageForPic)) || ((adak.a(this.jdField_a_of_type_Int) == 1032) && (this.jdField_b_of_type_Int > 0) && (paramMessageForPic.getConfessTopicId() != this.jdField_b_of_type_Int)) || (ahng.a(paramMessageForPic)) || (aiyz.a(paramMessageForPic))) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public ChatMessage b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore_3
    //   11: iload_3
    //   12: aload_0
    //   13: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: invokeinterface 779 1 0
    //   21: if_icmpge +156 -> 177
    //   24: aload_0
    //   25: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   28: iload_3
    //   29: invokeinterface 798 2 0
    //   34: checkcast 99	com/tencent/mobileqq/data/ChatMessage
    //   37: astore 5
    //   39: lload_1
    //   40: aload 5
    //   42: getfield 856	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   45: lcmp
    //   46: ifne +95 -> 141
    //   49: iconst_1
    //   50: istore 4
    //   52: iload 4
    //   54: ifeq +14 -> 68
    //   57: aload_0
    //   58: getfield 54	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   61: iload_3
    //   62: invokeinterface 1005 2 0
    //   67: pop
    //   68: aload 6
    //   70: monitorexit
    //   71: aload_0
    //   72: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   75: astore 6
    //   77: aload 6
    //   79: monitorenter
    //   80: iconst_0
    //   81: istore_3
    //   82: iload_3
    //   83: aload_0
    //   84: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   87: invokeinterface 779 1 0
    //   92: if_icmpge +79 -> 171
    //   95: aload_0
    //   96: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   99: iload_3
    //   100: invokeinterface 798 2 0
    //   105: checkcast 781	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   108: getfield 1007	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:jdField_f_of_type_Long	J
    //   111: lload_1
    //   112: lcmp
    //   113: ifne +43 -> 156
    //   116: iconst_1
    //   117: istore 4
    //   119: iload 4
    //   121: ifeq +14 -> 135
    //   124: aload_0
    //   125: getfield 56	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   128: iload_3
    //   129: invokeinterface 1005 2 0
    //   134: pop
    //   135: aload 6
    //   137: monitorexit
    //   138: aload 5
    //   140: areturn
    //   141: iload_3
    //   142: iconst_1
    //   143: iadd
    //   144: istore_3
    //   145: goto -134 -> 11
    //   148: astore 5
    //   150: aload 6
    //   152: monitorexit
    //   153: aload 5
    //   155: athrow
    //   156: iload_3
    //   157: iconst_1
    //   158: iadd
    //   159: istore_3
    //   160: goto -78 -> 82
    //   163: astore 5
    //   165: aload 6
    //   167: monitorexit
    //   168: aload 5
    //   170: athrow
    //   171: iconst_0
    //   172: istore 4
    //   174: goto -55 -> 119
    //   177: iconst_0
    //   178: istore 4
    //   180: aconst_null
    //   181: astore 5
    //   183: goto -131 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	AIOImageProviderService
    //   0	186	1	paramLong	long
    //   10	150	3	i	int
    //   50	129	4	j	int
    //   37	102	5	localChatMessage	ChatMessage
    //   148	6	5	localObject1	Object
    //   163	6	5	localObject2	Object
    //   181	1	5	localObject3	Object
    //   4	162	6	localList	List
    // Exception table:
    //   from	to	target	type
    //   11	49	148	finally
    //   57	68	148	finally
    //   68	71	148	finally
    //   150	153	148	finally
    //   82	116	163	finally
    //   124	135	163	finally
    //   135	138	163	finally
    //   165	168	163	finally
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Aiec;
    if (localObject != null) {
      ((aiec)localObject).a(null, -1);
    }
    localObject = this.jdField_a_of_type_Aidl;
    if (localObject != null) {
      ((aidl)localObject).a(null, -1);
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
        if (!MessageForShortVideo.class.isInstance(localChatMessage)) {
          break;
        }
      } while (paramInt2 != 256);
      b((MessageForShortVideo)localChatMessage, paramLong, paramInt1, paramInt2);
      return;
      if (MessageForFile.class.isInstance(localChatMessage))
      {
        a((MessageForFile)localChatMessage, paramLong);
        return;
      }
    } while (!MessageForTroopFile.class.isInstance(localChatMessage));
    a((MessageForTroopFile)localChatMessage);
  }
  
  protected void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_a_of_type_Anua == null)
    {
      this.jdField_a_of_type_Anua = new aidn(this);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    axqb localaxqb = a();
    if ((paramInt2 != 24) && (localaxqb != null) && (localaxqb.a(paramMessageForPic))) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "cancelDownloadImage return");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt2 == 24) && (localaxqb != null)) {}
        try
        {
          localaxqb.b(paramMessageForPic, paramLong, paramInt1, paramInt2);
          paramMessageForPic = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString)).a().a(beyb.a(paramMessageForPic.md5, paramMessageForPic.uuid, 131075));
          if (!(paramMessageForPic instanceof berz)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "destroy cancel processor c2c :" + paramMessageForPic);
          }
          ((berj)paramMessageForPic).a();
          return;
        }
        catch (AccountNotMatchException paramMessageForPic) {}
      } while (!QLog.isColorLevel());
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
      return;
      if ((paramMessageForPic instanceof berj))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "destroy cancel processor:" + paramMessageForPic);
        }
        ((berj)paramMessageForPic).a();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "destroy cancel fail");
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    axqb localaxqb = a();
    if (localaxqb != null) {
      localaxqb.b(paramMessageForShortVideo, paramLong, paramInt1, paramInt2);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "cleanMessage type = " + paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      aous.a(paramString, paramInt, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "cleanMessage exception = " + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  protected void b(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    localMessageForStructing.parse();
    StructMsgForImageShare localStructMsgForImageShare;
    Object localObject2;
    Object localObject1;
    if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)))
    {
      localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
      bdqr localbdqr = localStructMsgForImageShare.getFirstImageElement();
      if (localbdqr != null)
      {
        localObject2 = localbdqr.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (localbdqr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
            localbdqr.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = localStructMsgForImageShare;
          }
          localObject1 = localbdqr.a();
        }
        localObject2 = a((MessageForPic)localObject1);
        ((AIOImageData)localObject2).jdField_g_of_type_Long = localMessageForStructing.time;
        ((AIOImageData)localObject2).i = localMessageForStructing.shmsgseq;
        if ((localStructMsgForImageShare.mMsgActionData == null) || (!localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk"))) {
          break label203;
        }
        ((AIOImageData)localObject2).jdField_b_of_type_Int = 1;
        ((AIOImageData)localObject2).jdField_a_of_type_JavaLangObject = localStructMsgForImageShare.getBytes();
        ((AIOImageData)localObject2).jdField_d_of_type_Int = aics.a(aics.a(localStructMsgForImageShare));
      }
    }
    for (;;)
    {
      paramList.add(localObject2);
      paramList1.add(localObject1);
      return;
      label203:
      if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
      {
        ((AIOImageData)localObject2).jdField_b_of_type_Int = 2;
        ((AIOImageData)localObject2).jdField_a_of_type_JavaLangObject = localStructMsgForImageShare.getBytes();
        if ((bhnt.b(paramMessageRecord.issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
          ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = ((MessageForPic)localObject1).path;
        }
      }
      else if (avlv.a(localStructMsgForImageShare))
      {
        ((AIOImageData)localObject2).jdField_b_of_type_Int = 5;
        avlv.a((AIOImageData)localObject2, localStructMsgForImageShare);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aiec = null;
    axqb localaxqb = a();
    if (localaxqb != null) {
      localaxqb.c();
    }
  }
  
  public void c(long paramLong)
  {
    AppRuntime localAppRuntime;
    Object localObject2;
    label92:
    String str;
    label200:
    BaseActivity localBaseActivity;
    do
    {
      do
      {
        do
        {
          try
          {
            localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
            Object localObject1 = a(paramLong);
            if (localObject1 != null)
            {
              if (!MessageForFile.class.isInstance(localObject1)) {
                break label200;
              }
              localObject1 = (MessageForFile)localObject1;
              if (((MessageForFile)localObject1).uniseq == paramLong)
              {
                localObject2 = ((QQAppInterface)localAppRuntime).a().a(((MessageForFile)localObject1).uniseq, ((MessageForFile)localObject1).frienduin, ((MessageForFile)localObject1).istroop);
                if (localObject2 != null) {
                  break label92;
                }
              }
            }
            return;
          }
          catch (AccountNotMatchException localAccountNotMatchException)
          {
            localAccountNotMatchException.printStackTrace();
            QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
            return;
          }
          switch (((FileManagerEntity)localObject2).getCloudType())
          {
          case 2: 
          case 4: 
          default: 
            return;
          case 1: 
            if (localAccountNotMatchException.isSend()) {}
            for (str = ((QQAppInterface)localAppRuntime).getCurrentAccountUin();; str = ((FileManagerEntity)localObject2).peerUin)
            {
              ((QQAppInterface)localAppRuntime).a().a((FileManagerEntity)localObject2, str);
              return;
            }
          }
          ((QQAppInterface)localAppRuntime).a().a(((FileManagerEntity)localObject2).getFilePath(), null, localAppRuntime.getAccount(), 0, false);
          return;
          if (MessageForTroopFile.class.isInstance(str))
          {
            localObject2 = BaseApplicationImpl.sApplication.getBaseContext();
            if (localObject2 != null)
            {
              bgsk.b((Context)localObject2, (QQAppInterface)localAppRuntime, str);
              return;
            }
            QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file to weiyun].");
            return;
          }
          if (!(str instanceof MessageForPic)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "saveToWeiyun, save single pic, uniseq = " + str.uniseq);
          }
          localObject2 = new ArrayList(1);
          ((List)localObject2).add(str);
          localBaseActivity = a("saveToWeiyun_MessageForPic");
        } while (localBaseActivity == null);
        bnzk.b((QQAppInterface)localAppRuntime, localBaseActivity, localBaseActivity.getTitleBarHeight(), (List)localObject2, null);
        bdll.b((QQAppInterface)localAppRuntime, "dc00898", "", str.frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
        return;
      } while (!(str instanceof MessageForShortVideo));
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "saveToWeiyun, save single video, uniseq = " + str.uniseq);
      }
      localObject2 = new ArrayList(1);
      ((List)localObject2).add(str);
      localBaseActivity = a("saveToWeiyun_MessageForShortVideo");
    } while (localBaseActivity == null);
    bnzk.b((QQAppInterface)localAppRuntime, localBaseActivity, localBaseActivity.getTitleBarHeight(), (List)localObject2, null);
    bdll.b((QQAppInterface)localAppRuntime, "dc00898", "", str.frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
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
        new aidy((QQAppInterface)localAppRuntime, paramMessageForShortVideo, this.jdField_a_of_type_Aiec, paramLong, paramInt1, paramInt2).a();
        return;
      }
      localbcxn = bcwu.a(2, 2);
      localbcwx = paramMessageForShortVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
      if (paramInt2 != 0) {
        break label173;
      }
      localbcwx.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localbcwx.a(paramMessageForShortVideo.istroop, 1);
    }
    catch (AccountNotMatchException paramMessageForShortVideo)
    {
      AppRuntime localAppRuntime;
      bcxn localbcxn;
      bcwx localbcwx;
      while (QLog.isColorLevel())
      {
        QLog.d("AIOImageProviderService", 2, "no appRuntime");
        return;
        label173:
        localbcwx.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localbcwx.a(paramMessageForShortVideo.istroop, 0);
      }
    }
    localbcxn.a(localbcwx);
    localbcxn.a(new aidi(this, paramLong, paramInt1, paramInt2));
    bcwu.a(localbcxn, (QQAppInterface)localAppRuntime);
    return;
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
    ChatMessage localChatMessage;
    do
    {
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
        localChatMessage = a(paramLong);
        if (localChatMessage == null) {
          return;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        localAccountNotMatchException.printStackTrace();
        QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
        return;
      }
      if (MessageForFile.class.isInstance(localChatMessage))
      {
        localContext = BaseApplicationImpl.sApplication.getBaseContext();
        if (localContext != null)
        {
          aunj.a((QQAppInterface)localAccountNotMatchException, localChatMessage, localContext);
          return;
        }
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file send pc].");
        return;
      }
    } while (!MessageForTroopFile.class.isInstance(localChatMessage));
    Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
    if (localContext != null)
    {
      bgsk.a(localContext, (QQAppInterface)localAccountNotMatchException, localChatMessage);
      return;
    }
    QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file send pc].");
  }
  
  public void e(long paramLong)
  {
    Object localObject2 = a(paramLong);
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_JavaLangString);
        if (localObject2 != null)
        {
          if (!MessageForFile.class.isInstance(localObject2)) {
            break label130;
          }
          localObject2 = (MessageForFile)localObject2;
          localObject1 = ((QQAppInterface)localObject1).a().a(((MessageForFile)localObject2).uniseq, ((MessageForFile)localObject2).frienduin, ((MessageForFile)localObject2).istroop);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        localAccountNotMatchException.printStackTrace();
        QLog.e("AIOImageProviderService", 1, "getAppRuntime Exception!");
        return;
      }
      localObject2 = new Intent(BaseApplicationImpl.sApplication.getBaseContext(), FilePicQFavActivity.class);
      ((Intent)localObject2).putExtra("file_pic_favorites", localAccountNotMatchException.nSessionId);
      BaseApplicationImpl.sApplication.getBaseContext().startActivity((Intent)localObject2);
      return;
      label130:
      if (MessageForTroopFile.class.isInstance(localObject2))
      {
        MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)localObject2;
        Object localObject3 = bgsk.a((QQAppInterface)localAccountNotMatchException, localMessageForTroopFile);
        FileManagerEntity localFileManagerEntity = aunj.a((bftf)localObject3);
        localObject3 = bgrn.a((QQAppInterface)localAccountNotMatchException, ((bftf)localObject3).jdField_b_of_type_Long).a(localFileManagerEntity.strTroopFilePath);
        if (localObject3 != null)
        {
          localFileManagerEntity.lastTime = ((bfrs)localObject3).jdField_c_of_type_Int;
          localFileManagerEntity.selfUin = String.valueOf(((bfrs)localObject3).jdField_b_of_type_Long);
        }
        localObject3 = BaseApplicationImpl.sApplication.getBaseContext();
        if (localObject3 != null) {
          new bmko(3).a((QQAppInterface)localAccountNotMatchException, (Context)localObject3, localFileManagerEntity, (ChatMessage)localObject2, false);
        }
        while (localMessageForTroopFile.isMultiMsg)
        {
          bdll.b((QQAppInterface)localAccountNotMatchException, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
          return;
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save fav].");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
 * JD-Core Version:    0.7.0.1
 */