package com.tencent.mobileqq.activity.chathistory;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TroopAIOImageGeter
{
  int jdField_a_of_type_Int = 1;
  long jdField_a_of_type_Long;
  TroopAIOImageGeter.LoadMediaDataCallBack jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack;
  TroopAIOImageGeter.LoadMediaDataListener jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString;
  final List<AIORichMediaData> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  volatile boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 9223372036854775807L;
  String jdField_b_of_type_JavaLangString;
  final List<ChatMessage> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 3;
  long jdField_c_of_type_Long = 9223372036854775807L;
  volatile boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 9223372036854775807L;
  
  public TroopAIOImageGeter(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt;
    if (paramChatMessage != null)
    {
      this.jdField_b_of_type_Boolean = paramChatMessage.isMultiMsg;
      this.jdField_a_of_type_Long = paramChatMessage.msgseq;
      this.jdField_b_of_type_JavaUtilList.add(paramChatMessage);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), null);
  }
  
  private List<AIORichMediaData> a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = 0;
    while (k < paramList.size())
    {
      Object localObject3 = (MessageRecord)paramList.get(k);
      int i = ((MessageRecord)localObject3).msgtype;
      if (((MessageRecord)localObject3).shmsgseq < this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = ((MessageRecord)localObject3).shmsgseq;
      }
      if (((MessageRecord)localObject3).versionCode < this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Int = ((MessageRecord)localObject3).versionCode;
      }
      if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.jdField_c_of_type_Long)) {
        this.jdField_c_of_type_Long = ((MessageRecord)localObject3).getId();
      }
      if (((MessageRecord)localObject3).time < this.jdField_d_of_type_Long) {
        this.jdField_d_of_type_Long = ((MessageRecord)localObject3).time;
      }
      Object localObject1;
      if ((localObject3 instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localObject3;
        ((MessageForPic)localObject1).parse();
        if ((i != -3000) && (i != -30003))
        {
          if ((!HotChatHelper.a((MessageRecord)localObject1)) && (!((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg((MessageRecord)localObject1)) && (!((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject1)))
          {
            localArrayList1.add(AIOGalleryUtils.a((MessageForPic)localObject1));
            localArrayList2.add(localObject1);
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("LoadMediaTask msgType is ");
          ((StringBuilder)localObject1).append(i);
          QLog.i("TroopAIOImageGeter", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        Object localObject2;
        if ((localObject3 instanceof MessageForMixedMsg))
        {
          localObject1 = (MessageForMixedMsg)localObject3;
          ((MessageForMixedMsg)localObject1).parse();
          localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof MessageForPic))
            {
              localObject2 = (MessageForPic)localObject2;
              localArrayList1.add(AIOGalleryUtils.a((MessageForPic)localObject2));
              localArrayList2.add(localObject2);
            }
          }
        }
        if ((localObject3 instanceof MessageForStructing))
        {
          MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)))
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
              ((AIOImageData)localObject2).g = localMessageForStructing.time;
              ((AIOImageData)localObject2).i = localMessageForStructing.shmsgseq;
              if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
              {
                ((AIOImageData)localObject2).jdField_b_of_type_Int = 1;
                ((AIOImageData)localObject2).a = localStructMsgForImageShare.getBytes();
                ((AIOImageData)localObject2).jdField_d_of_type_Int = AIOGallerySceneWithBusiness.a(AIOGallerySceneWithBusiness.a(localStructMsgForImageShare));
              }
              else if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
              {
                ((AIOImageData)localObject2).jdField_b_of_type_Int = 2;
                ((AIOImageData)localObject2).a = localStructMsgForImageShare.getBytes();
                if ((MessageRecordInfo.b(((MessageRecord)localObject3).issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
                  ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = ((MessageForPic)localObject1).path;
                }
              }
              localArrayList1.add(localObject2);
              localArrayList2.add(localObject1);
            }
          }
        }
        else if (MessageForShortVideo.class.isInstance(localObject3))
        {
          localObject1 = (MessageForShortVideo)localObject3;
          if ((((MessageForShortVideo)localObject1).busiType == 1) || (((MessageForShortVideo)localObject1).busiType == 2) || (((MessageForShortVideo)localObject1).busiType == 1007) || (((MessageForShortVideo)localObject1).busiType == 1009) || (((MessageForShortVideo)localObject1).busiType == 0))
          {
            localArrayList1.add(AIOGalleryUtils.a((MessageForShortVideo)localObject1));
            localArrayList2.add(localObject1);
          }
        }
        else
        {
          int j;
          if ((localObject3 instanceof MessageForFile))
          {
            localObject3 = (MessageForFile)localObject3;
            localObject1 = paramQQAppInterface.getFileManagerDataCenter().a(((MessageForFile)localObject3).uniseq, ((MessageForFile)localObject3).frienduin, ((MessageForFile)localObject3).istroop);
            if ((localObject1 != null) && (((FileManagerUtil.f((FileManagerEntity)localObject1)) && (((FileManagerEntity)localObject1).nFileType != 2)) || (16 != ((FileManagerEntity)localObject1).status)))
            {
              if (((FileManagerEntity)localObject1).nFileType == 0) {
                i = 1;
              } else {
                i = 0;
              }
              if (((FileManagerEntity)localObject1).nFileType == 2) {
                j = 1;
              } else {
                j = 0;
              }
            }
            else
            {
              j = 0;
              i = 0;
            }
            localObject2 = null;
            if (i != 0)
            {
              ((MessageForFile)localObject3).parse();
              localObject1 = AIOGalleryUtils.a((ChatMessage)localObject3, paramQQAppInterface);
            }
            else if (j != 0)
            {
              ((MessageForFile)localObject3).parse();
              localObject1 = AIOGalleryUtils.a((ChatMessage)localObject3, paramQQAppInterface);
            }
            else
            {
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("ignore filePic: ");
                ((StringBuilder)localObject1).append(localObject3);
                QLog.i("TroopAIOImageGeter", 2, ((StringBuilder)localObject1).toString());
                localObject1 = localObject2;
              }
            }
            if (localObject1 != null)
            {
              localArrayList1.add(localObject1);
              localArrayList2.add(localObject3);
            }
          }
          else if ((localObject3 instanceof MessageForTroopFile))
          {
            localObject1 = (MessageForTroopFile)localObject3;
            j = FileManagerUtil.a(((MessageForTroopFile)localObject1).fileName);
            if ((j == 0) && (((MessageForTroopFile)localObject1).fileSize < 10485760L)) {
              i = 1;
            } else {
              i = 0;
            }
            if (j == 2) {
              j = 1;
            } else {
              j = 0;
            }
            if (i != 0)
            {
              localArrayList1.add(AIOGalleryUtils.a((MessageForTroopFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
            }
            else if ((j != 0) && (QFileUtils.a(paramQQAppInterface)))
            {
              localArrayList1.add(AIOGalleryUtils.a((ChatMessage)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("messageRecordToData ");
            ((StringBuilder)localObject1).append(((MessageRecord)localObject3).getBaseInfoString());
            QLog.i("TroopAIOImageGeter", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      k += 1;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilList.addAll(0, localArrayList2);
      this.jdField_a_of_type_JavaUtilList.addAll(0, localArrayList1);
    }
    else
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("messageRecordToData total size ");
      paramQQAppInterface.append(localArrayList2.size());
      paramQQAppInterface.append(", cost ");
      paramQQAppInterface.append(System.currentTimeMillis() - l);
      QLog.d("TroopAIOImageGeter", 2, paramQQAppInterface.toString());
    }
    return localArrayList1;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack;
    if (localObject != null) {
      ((TroopAIOImageGeter.LoadMediaDataCallBack)localObject).a(null, -1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener;
    if (localObject != null) {
      ((TroopAIOImageGeter.LoadMediaDataListener)localObject).a(null, -1);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener == null))
    {
      a();
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[loadMedias] + loadType: ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(", dataList.size = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("TroopAIOImageGeter", 2, ((StringBuilder)???).toString());
    }
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener == null) {
          return;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jdField_a_of_type_JavaUtilList.toArray(new AIORichMediaData[this.jdField_a_of_type_JavaUtilList.size()]);
            this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener.a(arrayOfAIORichMediaData, -1);
            return;
          }
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack == null) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localArrayList = new ArrayList();
        ??? = this.jdField_a_of_type_JavaUtilList;
        paramInt = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label343;
          }
          localArrayList.add(localAIORichMediaData);
          break label343;
        }
        ??? = (AIORichMediaData[])localArrayList.toArray(new AIORichMediaData[localArrayList.size()]);
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack.a((AIORichMediaData[])???, -1);
        return;
      }
      finally {}
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
      return;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
      return;
      label343:
      paramInt += 1;
    }
  }
  
  public void a(TroopAIOImageGeter.LoadMediaDataCallBack paramLoadMediaDataCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack = paramLoadMediaDataCallBack;
  }
  
  boolean a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaData))
    {
      if (((AIOShortVideoData)paramAIORichMediaData).jdField_b_of_type_Int == 0) {
        return true;
      }
    }
    else if (AIOFileVideoData.class.isInstance(paramAIORichMediaData)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter
 * JD-Core Version:    0.7.0.1
 */