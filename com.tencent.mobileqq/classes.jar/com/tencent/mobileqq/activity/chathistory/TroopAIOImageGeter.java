package com.tencent.mobileqq.activity.chathistory;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.FlashPicHelper;
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
import com.tencent.mobileqq.hotpic.HotPicHelper;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import wma;

public class TroopAIOImageGeter
{
  public int a;
  public long a;
  public TroopAIOImageGeter.LoadMediaDataCallBack a;
  public TroopAIOImageGeter.LoadMediaDataListener a;
  WeakReferenceHandler a;
  public String a;
  public final List a;
  public volatile boolean a;
  public int b;
  public long b;
  public String b;
  final List b;
  public boolean b;
  public int c;
  public long c;
  public volatile boolean c;
  public int d;
  public long d;
  
  public TroopAIOImageGeter(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 3;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_d_of_type_Long = 9223372036854775807L;
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
      if (localMessageRecord.shmsgseq < this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = localMessageRecord.shmsgseq;
      }
      if (localMessageRecord.versionCode < this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Int = localMessageRecord.versionCode;
      }
      if ((localMessageRecord.getId() > 0L) && (localMessageRecord.getId() < this.jdField_c_of_type_Long)) {
        this.jdField_c_of_type_Long = localMessageRecord.getId();
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
            QLog.i("TroopAIOImageGeter", 2, "LoadMediaTask msgType is " + i);
          }
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if ((!HotChatHelper.a((MessageRecord)localObject1)) && (!FlashPicHelper.a((MessageRecord)localObject1)))
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
                  ((AIOImageData)localObject2).a = localStructMsgForImageShare.getBytes();
                  ((AIOImageData)localObject2).e = AIOGallerySceneWithBusiness.a(AIOGallerySceneWithBusiness.a(localStructMsgForImageShare));
                }
                for (;;)
                {
                  localArrayList1.add(localObject2);
                  localArrayList2.add(localObject1);
                  break;
                  if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
                  {
                    ((AIOImageData)localObject2).jdField_c_of_type_Int = 2;
                    ((AIOImageData)localObject2).a = localStructMsgForImageShare.getBytes();
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
                  break label958;
                }
                j = 1;
                label910:
                if (((FileManagerEntity)localObject2).nFileType != 2) {
                  break label964;
                }
              }
            }
            label958:
            label964:
            for (i = 1;; i = 0)
            {
              if (j == 0) {
                break label969;
              }
              ((MessageForFile)localObject1).parse();
              localArrayList1.add(AIOGalleryUtils.a((MessageForFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
              break;
              j = 0;
              break label910;
            }
            label969:
            if (i != 0)
            {
              ((MessageForFile)localObject1).parse();
              localArrayList1.add(AIOGalleryUtils.a((MessageForFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
            }
            else if (QLog.isColorLevel())
            {
              QLog.i("TroopAIOImageGeter", 2, "ignore filePic: " + localObject1);
            }
          }
          else if ((localMessageRecord instanceof MessageForTroopFile))
          {
            localObject1 = (MessageForTroopFile)localMessageRecord;
            if ((FileManagerUtil.a(((MessageForTroopFile)localObject1).fileName) == 0) && (((MessageForTroopFile)localObject1).fileSize < 10485760L)) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1115;
              }
              localArrayList1.add(AIOGalleryUtils.a((MessageForTroopFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
              break;
            }
          }
          else
          {
            label1115:
            if (QLog.isColorLevel()) {
              QLog.i("TroopAIOImageGeter", 2, "messageRecordToData " + localMessageRecord.getBaseInfoString());
            }
          }
        }
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilList.addAll(0, localArrayList2);
      this.jdField_a_of_type_JavaUtilList.addAll(0, localArrayList1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAIOImageGeter", 2, "messageRecordToData total size " + localArrayList2.size() + ", cost " + (System.currentTimeMillis() - l));
      }
      return localArrayList1;
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener == null)) {
      a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopAIOImageGeter", 2, "[loadMedias] + loadType: " + paramInt + ", dataList.size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new wma(this));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack == null);
    ArrayList localArrayList;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localArrayList = new ArrayList();
      ??? = this.jdField_a_of_type_JavaUtilList;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label344;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      ??? = (AIORichMediaData[])localObject2.toArray(new AIORichMediaData[localObject2.size()]);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack.a((AIORichMediaData[])???, -1);
      return;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new wma(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jdField_a_of_type_JavaUtilList.toArray(new AIORichMediaData[this.jdField_a_of_type_JavaUtilList.size()]);
          this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener.a(arrayOfAIORichMediaData, -1);
          return;
        }
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new wma(this));
      return;
      label344:
      paramInt += 1;
    }
  }
  
  public void a(TroopAIOImageGeter.LoadMediaDataCallBack paramLoadMediaDataCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack = paramLoadMediaDataCallBack;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter
 * JD-Core Version:    0.7.0.1
 */