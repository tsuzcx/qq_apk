package com.tencent.mobileqq.app.message.messageclean;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.persistence.Cursor2EntityConvert;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class MessageCleanManager
  implements IFileScanListener, IMessageDataListener, Manager
{
  private long jdField_a_of_type_Long = 0L;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  public PeakAppInterface a;
  private FileCleanManager jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager;
  private IMessageLoadListener jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener;
  private MessageDataManager jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<CleanMessageItemInfo> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, List<String>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap;
  private ConcurrentHashMap<String, MessageRecord> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile boolean e = false;
  
  public MessageCleanManager()
  {
    c();
  }
  
  private long a(String paramString)
  {
    long l1 = 0L;
    long l3 = l1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label25;
      }
      l3 = l1;
    }
    label25:
    long l2;
    do
    {
      do
      {
        do
        {
          return l3;
          ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a();
          Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          l2 = l1;
          if (localObject != null)
          {
            l2 = l1;
            if (((List)localObject).size() > 0)
            {
              localObject = ((List)localObject).iterator();
              for (;;)
              {
                l2 = l1;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                String str = (String)((Iterator)localObject).next();
                FileInfo localFileInfo = (FileInfo)localConcurrentHashMap.get(str);
                l2 = l1;
                if (localFileInfo != null)
                {
                  l2 = l1 + localFileInfo.jdField_a_of_type_Long;
                  localFileInfo.b += 1;
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a(str, localFileInfo);
                }
                l1 = l2;
              }
            }
          }
          l3 = l2;
        } while (this.jdField_b_of_type_JavaUtilHashMap == null);
        l3 = l2;
      } while (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString));
      l3 = l2;
    } while (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() <= 0);
    return l2 + ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() * 200;
  }
  
  private Pair<String, List<String>> a(String paramString, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return new Pair(paramString, localArrayList);
    }
    Iterator localIterator = paramList.iterator();
    label327:
    label344:
    label345:
    for (;;)
    {
      int i;
      if (localIterator.hasNext())
      {
        paramList = (MessageRecord)localIterator.next();
        i = paramList.msgtype;
        if (MessageTypeUtils.a(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList == null) || (!(paramList instanceof MessageForPic))) {
            break label327;
          }
          paramList = ((MessageForPic)paramList).getBiggestFilePath();
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(paramList)) || (localArrayList.contains(paramList))) {
          break label345;
        }
        localArrayList.add(new File(paramList).getName());
        break;
        if (MessageTypeUtils.b(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramList;
            paramList = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
            if (!TextUtils.isEmpty(paramList)) {
              break label344;
            }
            paramList = ShortVideoUtils.getVideoTmpPath(localMessageForShortVideo);
          }
        }
        else if (MessageTypeUtils.c(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if (paramList != null) {
            paramList = QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, paramList);
          }
        }
        else if (MessageTypeUtils.d(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForMixedMsg)))
          {
            b(paramString, ((MessageForMixedMsg)paramList).getPicMsgList());
            paramList = "";
          }
        }
        else if (MessageTypeUtils.e(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForStructing)) && (MultiMsgUtil.a((MessageForStructing)paramList))) {
            b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.c(MessageRecord.class, "select * from mr_multimessage where msgseq=?", "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramList.uniseq) }));
          }
        }
        paramList = "";
        continue;
        return new Pair(paramString, localArrayList);
      }
    }
  }
  
  private Pair<Integer, List<MessageRecord>> a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof MessageForText)) {
        i += 1;
      }
      for (;;)
      {
        break;
        localArrayList.add(localMessageRecord);
      }
    }
    return new Pair(Integer.valueOf(i), localArrayList);
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    String str1 = "";
    String str2;
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      str2 = "";
      return str2;
    }
    switch (paramMessageRecord.istroop)
    {
    }
    for (;;)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return paramMessageRecord.frienduin;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin + 0);
      continue;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin + 1);
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(paramMessageRecord.frienduin);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null)
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
        continue;
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_b_of_type_JavaUtilHashMap != null))
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        int i = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue();
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i + paramInt));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1000) || (paramInt == 1004);
  }
  
  private boolean a(CleanMessageItemInfo paramCleanMessageItemInfo)
  {
    if ((paramCleanMessageItemInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)) {}
    String str;
    do
    {
      return true;
      str = MessageRecord.getTableName(paramCleanMessageItemInfo.jdField_a_of_type_JavaLangString, paramCleanMessageItemInfo.jdField_a_of_type_Int);
    } while (TextUtils.isEmpty(str));
    b(str);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(paramCleanMessageItemInfo.jdField_a_of_type_JavaLangString, paramCleanMessageItemInfo.jdField_a_of_type_Int);
    }
    a(str);
    return true;
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramString = new ArrayList();
        ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          FileInfo localFileInfo = (FileInfo)localConcurrentHashMap.get(str1);
          if (localFileInfo != null)
          {
            localFileInfo.b -= 1;
            if (localFileInfo.b == 0)
            {
              String str2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a(localFileInfo);
              if (!TextUtils.isEmpty(str2))
              {
                this.jdField_a_of_type_Long += localFileInfo.jdField_a_of_type_Long;
                paramString.add(str2);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a(str1);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a(str1, localFileInfo);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a(paramString);
      }
    }
  }
  
  private void b(String paramString, List<MessageRecord> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        paramList = a(paramList);
      } while (paramList == null);
      a(paramString, ((Integer)paramList.first).intValue());
      paramString = a(paramString, (List)paramList.second);
    } while (paramString == null);
    c((String)paramString.first, (List)paramString.second);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a());
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager = new MessageDataManager();
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)localAppInterface);
    }
  }
  
  private void c(String paramString, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramList.get(i);
        if (!localList.contains(str)) {
          localList.add(str);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localList);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramList);
  }
  
  private void d()
  {
    this.d = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager = new FileCleanManager(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(0, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.b(1, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadNameList finish");
    }
    h();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadMessageRecord tableNames is empty");
      }
      this.jdField_b_of_type_Boolean = true;
      h();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      b(str1, this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(MessageRecord.class, str2, str1, null, null));
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord finish");
    }
    h();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.b();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord tableNames is empty");
      }
      this.c = true;
      h();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      b(str1, this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.b(MessageRecord.class, str2, str1, null, null));
    }
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord finish");
    }
    h();
  }
  
  private void h()
  {
    if ((a()) && (b()))
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0)) {
        break label288;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        CleanMessageItemInfo localCleanMessageItemInfo = new CleanMessageItemInfo();
        localObject = (MessageRecord)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if ((localObject != null) && (a(((MessageRecord)localObject).istroop)))
        {
          localCleanMessageItemInfo.jdField_a_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
          localCleanMessageItemInfo.jdField_b_of_type_JavaLangString = a((MessageRecord)localObject);
          localCleanMessageItemInfo.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
          localCleanMessageItemInfo.jdField_b_of_type_Long = ((MessageRecord)localObject).time;
          localCleanMessageItemInfo.jdField_a_of_type_Long = a(MessageRecord.getTableName(localCleanMessageItemInfo.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject).istroop));
          if ((localCleanMessageItemInfo.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_JavaUtilList != null))
          {
            localCleanMessageItemInfo.c = FileCleanUtils.a(localCleanMessageItemInfo.jdField_a_of_type_Long);
            this.jdField_a_of_type_JavaUtilList.add(localCleanMessageItemInfo);
          }
        }
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilHashMap != null) {
        this.jdField_b_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener != null)
      {
        a(1);
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      this.e = false;
      return;
      label288:
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish cleanMessageList is empty");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
  
  private void i()
  {
    this.e = false;
    this.d = true;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.b();
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public List<CleanMessageItemInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new CleanMessageComparator(paramInt));
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<CleanMessageItemInfo> a(List<CleanMessageItemInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "deleteMessages");
    }
    ThreadManager.getFileThreadHandler().post(new MessageCleanManager.4(this, paramList));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CleanMessageItemInfo localCleanMessageItemInfo = (CleanMessageItemInfo)paramList.next();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(localCleanMessageItemInfo);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "onScanFinish");
    }
    h();
  }
  
  public void a(IAIOImageProvider paramIAIOImageProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
  }
  
  public void a(IMessageLoadListener paramIMessageLoadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener = paramIMessageLoadListener;
  }
  
  public void a(String paramString, Entity paramEntity)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramEntity == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyLastMsg tableName or entity is null");
      }
    }
    while ((!(paramEntity instanceof MessageRecord)) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (MessageRecord)paramEntity);
  }
  
  public void a(String paramString, List<? extends Entity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyMessageData messageRecordList is empty");
      }
    }
    while (!(paramList.get(0) instanceof MessageRecord)) {
      return;
    }
    b(paramString, paramList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord");
    }
    if (this.e) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord isLoadingData");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a();
        }
        i();
        d();
        try
        {
          this.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a();
          ThreadManager.getSubThreadHandler().post(new MessageCleanManager.1(this));
          ThreadManager.getFileThreadHandler().post(new MessageCleanManager.2(this));
          ThreadManager.getFileThreadHandler().post(new MessageCleanManager.3(this));
          return;
        }
        catch (Exception localException)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MessageCleanManager", 2, "loadAllMessageRecord exception = " + localException.getMessage());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener == null);
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord OutOfMemoryError");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void onDestroy()
  {
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager
 * JD-Core Version:    0.7.0.1
 */