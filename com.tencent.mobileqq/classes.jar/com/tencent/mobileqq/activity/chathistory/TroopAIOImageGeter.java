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
  volatile boolean a = false;
  int b = 1;
  String c;
  String d;
  boolean e = false;
  volatile boolean f = false;
  int g;
  long h;
  int i = 3;
  long j = 9223372036854775807L;
  int k = 0;
  long l = 9223372036854775807L;
  final List<AIORichMediaData> m = Collections.synchronizedList(new LinkedList());
  final List<ChatMessage> n = Collections.synchronizedList(new LinkedList());
  TroopAIOImageGeter.LoadMediaDataCallBack o;
  TroopAIOImageGeter.LoadMediaDataListener p;
  long q = 9223372036854775807L;
  WeakReferenceHandler r;
  
  public TroopAIOImageGeter(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.g = paramInt;
    if (paramChatMessage != null)
    {
      this.e = paramChatMessage.isMultiMsg;
      this.h = paramChatMessage.msgseq;
      this.n.add(paramChatMessage);
    }
    this.r = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), null);
  }
  
  private List<AIORichMediaData> a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i3 = 0;
    while (i3 < paramList.size())
    {
      Object localObject3 = (MessageRecord)paramList.get(i3);
      int i1 = ((MessageRecord)localObject3).msgtype;
      if (((MessageRecord)localObject3).shmsgseq < this.j) {
        this.j = ((MessageRecord)localObject3).shmsgseq;
      }
      if (((MessageRecord)localObject3).versionCode < this.i) {
        this.i = ((MessageRecord)localObject3).versionCode;
      }
      if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.l)) {
        this.l = ((MessageRecord)localObject3).getId();
      }
      if (((MessageRecord)localObject3).time < this.q) {
        this.q = ((MessageRecord)localObject3).time;
      }
      Object localObject1;
      if ((localObject3 instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localObject3;
        ((MessageForPic)localObject1).parse();
        if ((i1 != -3000) && (i1 != -30003))
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
          ((StringBuilder)localObject1).append(i1);
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
              localObject2 = localStructMsgItemImage.aF;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                if (localStructMsgItemImage.aE == null) {
                  localStructMsgItemImage.aE = localStructMsgForImageShare;
                }
                localObject1 = localStructMsgItemImage.d();
              }
              localObject2 = AIOGalleryUtils.a((MessageForPic)localObject1);
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
                if ((MessageRecordInfo.c(((MessageRecord)localObject3).issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
                  ((AIOImageData)localObject2).b = ((MessageForPic)localObject1).path;
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
          int i2;
          if ((localObject3 instanceof MessageForFile))
          {
            localObject3 = (MessageForFile)localObject3;
            localObject1 = paramQQAppInterface.getFileManagerDataCenter().a(((MessageForFile)localObject3).uniseq, ((MessageForFile)localObject3).frienduin, ((MessageForFile)localObject3).istroop);
            if ((localObject1 != null) && (((FileManagerUtil.m((FileManagerEntity)localObject1)) && (((FileManagerEntity)localObject1).nFileType != 2)) || (16 != ((FileManagerEntity)localObject1).status)))
            {
              if (((FileManagerEntity)localObject1).nFileType == 0) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (((FileManagerEntity)localObject1).nFileType == 2) {
                i2 = 1;
              } else {
                i2 = 0;
              }
            }
            else
            {
              i2 = 0;
              i1 = 0;
            }
            localObject2 = null;
            if (i1 != 0)
            {
              ((MessageForFile)localObject3).parse();
              localObject1 = AIOGalleryUtils.a((ChatMessage)localObject3, paramQQAppInterface);
            }
            else if (i2 != 0)
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
            i2 = FileManagerUtil.c(((MessageForTroopFile)localObject1).fileName);
            if ((i2 == 0) && (((MessageForTroopFile)localObject1).fileSize < 10485760L)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i2 == 2) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (i1 != 0)
            {
              localArrayList1.add(AIOGalleryUtils.b((MessageForTroopFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
            }
            else if ((i2 != 0) && (QFileUtils.a(paramQQAppInterface)))
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
      i3 += 1;
    }
    if (this.f)
    {
      this.n.addAll(0, localArrayList2);
      this.m.addAll(0, localArrayList1);
    }
    else
    {
      this.n.clear();
      this.m.clear();
      this.n.addAll(localArrayList2);
      this.m.addAll(localArrayList1);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("messageRecordToData total size ");
      paramQQAppInterface.append(localArrayList2.size());
      paramQQAppInterface.append(", cost ");
      paramQQAppInterface.append(System.currentTimeMillis() - l1);
      QLog.d("TroopAIOImageGeter", 2, paramQQAppInterface.toString());
    }
    return localArrayList1;
  }
  
  public void a()
  {
    Object localObject = this.o;
    if (localObject != null) {
      ((TroopAIOImageGeter.LoadMediaDataCallBack)localObject).a(null, -1);
    }
    localObject = this.p;
    if (localObject != null) {
      ((TroopAIOImageGeter.LoadMediaDataListener)localObject).a(null, -1);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.o == null) && (this.p == null))
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
      ((StringBuilder)???).append(this.m.size());
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
        if (this.p == null) {
          return;
        }
        if (this.m.size() > 0) {
          synchronized (this.m)
          {
            AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.m.toArray(new AIORichMediaData[this.m.size()]);
            this.p.a(arrayOfAIORichMediaData, -1);
            return;
          }
        }
        this.r.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
        return;
      }
      if (this.o == null) {
        return;
      }
      if (this.m.size() > 0)
      {
        localArrayList = new ArrayList();
        ??? = this.m;
        paramInt = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.m.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.m.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label343;
          }
          localArrayList.add(localAIORichMediaData);
          break label343;
        }
        ??? = (AIORichMediaData[])localArrayList.toArray(new AIORichMediaData[localArrayList.size()]);
        this.o.a((AIORichMediaData[])???, -1);
        return;
      }
      finally {}
      this.r.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
      return;
      this.r.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
      return;
      label343:
      paramInt += 1;
    }
  }
  
  public void a(TroopAIOImageGeter.LoadMediaDataCallBack paramLoadMediaDataCallBack)
  {
    this.o = paramLoadMediaDataCallBack;
  }
  
  boolean a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaData))
    {
      if (((AIOShortVideoData)paramAIORichMediaData).d == 0) {
        return true;
      }
    }
    else if (AIOFileVideoData.class.isInstance(paramAIORichMediaData)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter
 * JD-Core Version:    0.7.0.1
 */