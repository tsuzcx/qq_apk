package com.tencent.mobileqq.activity.chathistory;

import afsf;
import agej;
import agem;
import agzr;
import agzs;
import alnp;
import alpw;
import android.text.TextUtils;
import aqsc;
import arni;
import aroo;
import azsp;
import bdec;
import bhow;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
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
  agzr jdField_a_of_type_Agzr;
  agzs jdField_a_of_type_Agzs;
  bhow jdField_a_of_type_Bhow;
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
    this.jdField_a_of_type_Bhow = new bhow(ThreadManager.getFileThreadLooper(), null);
  }
  
  private List<AIORichMediaData> a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = 0;
    Object localObject3;
    int i;
    Object localObject1;
    Object localObject2;
    label812:
    int j;
    if (k < paramList.size())
    {
      localObject3 = (MessageRecord)paramList.get(k);
      i = ((MessageRecord)localObject3).msgtype;
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
      if ((localObject3 instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localObject3;
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
        if ((!alpw.a((MessageRecord)localObject1)) && (!alnp.a((MessageRecord)localObject1)) && (!afsf.a((MessageForPic)localObject1)))
        {
          localArrayList1.add(agem.a((MessageForPic)localObject1));
          localArrayList2.add(localObject1);
          continue;
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
                localArrayList1.add(agem.a((MessageForPic)localObject2));
                localArrayList2.add((MessageForPic)localObject2);
              }
            }
          }
          else if ((localObject3 instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
            localMessageForStructing.parse();
            if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)))
            {
              StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
              azsp localazsp = localStructMsgForImageShare.getFirstImageElement();
              if (localazsp != null)
              {
                localObject2 = localazsp.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  if (localazsp.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                    localazsp.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = localStructMsgForImageShare;
                  }
                  localObject1 = localazsp.a();
                }
                localObject2 = agem.a((MessageForPic)localObject1);
                ((AIOImageData)localObject2).g = localMessageForStructing.time;
                ((AIOImageData)localObject2).i = localMessageForStructing.shmsgseq;
                if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
                {
                  ((AIOImageData)localObject2).jdField_b_of_type_Int = 1;
                  ((AIOImageData)localObject2).a = localStructMsgForImageShare.getBytes();
                  ((AIOImageData)localObject2).jdField_d_of_type_Int = agej.a(agej.a(localStructMsgForImageShare));
                }
                for (;;)
                {
                  localArrayList1.add(localObject2);
                  localArrayList2.add(localObject1);
                  break;
                  if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
                  {
                    ((AIOImageData)localObject2).jdField_b_of_type_Int = 2;
                    ((AIOImageData)localObject2).a = localStructMsgForImageShare.getBytes();
                    if ((bdec.b(((MessageRecord)localObject3).issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
                      ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = ((MessageForPic)localObject1).path;
                    }
                  }
                }
              }
            }
          }
          else
          {
            if (!MessageForShortVideo.class.isInstance(localObject3)) {
              break label812;
            }
            if (MessageForLightVideo.class.isInstance(localObject3))
            {
              localObject1 = (MessageForLightVideo)localObject3;
              localArrayList1.add(agem.a((MessageForLightVideo)localObject1));
              localArrayList2.add(localObject1);
            }
            else
            {
              localObject1 = (MessageForShortVideo)localObject3;
              if ((((MessageForShortVideo)localObject1).busiType == 1) || (((MessageForShortVideo)localObject1).busiType == 2) || (((MessageForShortVideo)localObject1).busiType == 1007) || (((MessageForShortVideo)localObject1).busiType == 1009) || (((MessageForShortVideo)localObject1).busiType == 0))
              {
                localArrayList1.add(agem.a((MessageForShortVideo)localObject1));
                localArrayList2.add(localObject1);
              }
            }
          }
        }
      }
      if ((localObject3 instanceof MessageForFile))
      {
        localObject3 = (MessageForFile)localObject3;
        localObject1 = paramQQAppInterface.a().a(((MessageForFile)localObject3).uniseq, ((MessageForFile)localObject3).frienduin, ((MessageForFile)localObject3).istroop);
        j = 0;
        if ((localObject1 == null) || (((!arni.e((FileManagerEntity)localObject1)) || (((FileManagerEntity)localObject1).nFileType == 2)) && (16 == ((FileManagerEntity)localObject1).status))) {
          break label1339;
        }
        if (((FileManagerEntity)localObject1).nFileType == 0)
        {
          i = 1;
          label896:
          if (((FileManagerEntity)localObject1).nFileType != 2) {
            break label961;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      label908:
      localObject2 = null;
      if (i != 0)
      {
        ((MessageForFile)localObject3).parse();
        localObject1 = agem.a((ChatMessage)localObject3, paramQQAppInterface);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label1030;
        }
        localArrayList1.add(localObject1);
        localArrayList2.add(localObject3);
        break;
        i = 0;
        break label896;
        label961:
        j = 0;
        break label908;
        if (j != 0)
        {
          ((MessageForFile)localObject3).parse();
          localObject1 = agem.a((ChatMessage)localObject3, paramQQAppInterface);
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("TroopAIOImageGeter", 2, "ignore filePic: " + localObject3);
            localObject1 = localObject2;
          }
        }
      }
      label1030:
      break;
      if ((localObject3 instanceof MessageForTroopFile))
      {
        localObject1 = (MessageForTroopFile)localObject3;
        j = arni.a(((MessageForTroopFile)localObject1).fileName);
        if ((j == 0) && (((MessageForTroopFile)localObject1).fileSize < 10485760L))
        {
          i = 1;
          label1076:
          if (j != 2) {
            break label1121;
          }
        }
        label1121:
        for (j = 1;; j = 0)
        {
          if (i == 0) {
            break label1127;
          }
          localArrayList1.add(agem.a((MessageForTroopFile)localObject1, paramQQAppInterface));
          localArrayList2.add(localObject1);
          break;
          i = 0;
          break label1076;
        }
        label1127:
        if ((j == 0) || (!aroo.a(paramQQAppInterface))) {
          break;
        }
        localArrayList1.add(agem.a((ChatMessage)localObject1, paramQQAppInterface));
        localArrayList2.add(localObject1);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopAIOImageGeter", 2, "messageRecordToData " + ((MessageRecord)localObject3).getBaseInfoString());
      break;
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
      label1339:
      i = 0;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Agzr;
    if (localObject != null) {
      ((agzr)localObject).a(null, -1);
    }
    localObject = this.jdField_a_of_type_Agzs;
    if (localObject != null) {
      ((agzs)localObject).a(null, -1);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Agzr == null) && (this.jdField_a_of_type_Agzs == null)) {
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
        this.jdField_a_of_type_Bhow.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
        return;
      }
    } while (this.jdField_a_of_type_Agzr == null);
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
      this.jdField_a_of_type_Agzr.a((AIORichMediaData[])???, -1);
      return;
      this.jdField_a_of_type_Bhow.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
      return;
      if (this.jdField_a_of_type_Agzs == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jdField_a_of_type_JavaUtilList.toArray(new AIORichMediaData[this.jdField_a_of_type_JavaUtilList.size()]);
          this.jdField_a_of_type_Agzs.a(arrayOfAIORichMediaData, -1);
          return;
        }
      }
      this.jdField_a_of_type_Bhow.post(new TroopAIOImageGeter.IncreasinglyLoadMediaTask(this));
      return;
      label344:
      paramInt += 1;
    }
  }
  
  public void a(agzr paramagzr)
  {
    this.jdField_a_of_type_Agzr = paramagzr;
  }
  
  boolean a(AIORichMediaData paramAIORichMediaData)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter
 * JD-Core Version:    0.7.0.1
 */