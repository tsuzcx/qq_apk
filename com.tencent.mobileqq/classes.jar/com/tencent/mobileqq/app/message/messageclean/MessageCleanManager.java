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
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVUtils;
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
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    long l3 = l2;
    if (!bool)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        return 0L;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a();
      Object localObject2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            l1 = l2;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            String str = (String)((Iterator)localObject2).next();
            FileInfo localFileInfo = (FileInfo)((ConcurrentHashMap)localObject1).get(str);
            if (localFileInfo != null)
            {
              l2 += localFileInfo.jdField_a_of_type_Long;
              localFileInfo.b += 1;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a(str, localFileInfo);
            }
          }
        }
      }
      localObject1 = this.jdField_b_of_type_JavaUtilHashMap;
      l3 = l1;
      if (localObject1 != null)
      {
        l3 = l1;
        if (((HashMap)localObject1).containsKey(paramString))
        {
          l3 = l1;
          if (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() > 0) {
            l3 = l1 + ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() * 200;
          }
        }
      }
    }
    return l3;
  }
  
  private Pair<String, List<String>> a(String paramString, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (MessageRecord)localIterator.next();
        int i = paramList.msgtype;
        if (MessageTypeUtils.a(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForPic)))
          {
            paramList = (MessageForPic)paramList;
            paramList = ((IPicHelper)QRoute.api(IPicHelper.class)).getBiggestFilePath(paramList);
            break label297;
          }
        }
        else if (MessageTypeUtils.b(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramList;
            paramList = SVUtils.a(localMessageForShortVideo, "mp4");
            if (TextUtils.isEmpty(paramList))
            {
              paramList = ShortVideoUtils.getVideoTmpPath(localMessageForShortVideo);
              break label297;
            }
            break label297;
          }
        }
        else if (MessageTypeUtils.c(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if (paramList != null)
          {
            paramList = QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, paramList);
            break label297;
          }
        }
        else if (MessageTypeUtils.d(i))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForMixedMsg))) {
            b(paramString, ((MessageForMixedMsg)paramList).getPicMsgList());
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
        label297:
        if ((!TextUtils.isEmpty(paramList)) && (!localArrayList.contains(paramList))) {
          localArrayList.add(new File(paramList).getName());
        }
      }
      return new Pair(paramString, localArrayList);
    }
    return new Pair(paramString, localArrayList);
  }
  
  private Pair<Integer, List<MessageRecord>> a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForText)) {
          i += 1;
        } else {
          localArrayList.add(localMessageRecord);
        }
      }
      return new Pair(Integer.valueOf(i), localArrayList);
    }
    return null;
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramMessageRecord != null)
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      localObject2 = localObject1;
      if (localHashMap != null)
      {
        if (localHashMap.isEmpty()) {
          return "";
        }
        int i = paramMessageRecord.istroop;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 1000)
            {
              if (i != 1004)
              {
                if (i == 3000) {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(paramMessageRecord.frienduin);
                }
              }
              else {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
              }
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
              if (localObject2 != null) {
                localObject1 = ((IAIOImageProvider)localObject2).a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
              }
            }
          }
          else
          {
            localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramMessageRecord.frienduin);
            ((StringBuilder)localObject2).append(1);
            localObject1 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramMessageRecord.frienduin);
          ((StringBuilder)localObject2).append(0);
          localObject1 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = paramMessageRecord.frienduin;
        }
      }
    }
    return localObject2;
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(paramString);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HashMap localHashMap = this.jdField_b_of_type_JavaUtilHashMap;
      if (localHashMap != null)
      {
        if (localHashMap.containsKey(paramString))
        {
          int i = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue();
          this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i + paramInt));
          return;
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
      }
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 3000)
        {
          bool1 = bool2;
          if (paramInt != 1000)
          {
            if (paramInt == 1004) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(CleanMessageItemInfo paramCleanMessageItemInfo)
  {
    if (paramCleanMessageItemInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null) {
        return true;
      }
      String str = MessageRecord.getTableName(paramCleanMessageItemInfo.jdField_a_of_type_JavaLangString, paramCleanMessageItemInfo.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(str))
      {
        b(str);
        IAIOImageProvider localIAIOImageProvider = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
        if (localIAIOImageProvider != null) {
          localIAIOImageProvider.b(paramCleanMessageItemInfo.jdField_a_of_type_JavaLangString, paramCleanMessageItemInfo.jdField_a_of_type_Int);
        }
        a(str);
      }
    }
    return true;
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localConcurrentHashMap != null)
      {
        Object localObject = (List)localConcurrentHashMap.get(paramString);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramString = new ArrayList();
          localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager.a();
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
  }
  
  private void b(String paramString, List<MessageRecord> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = a(paramList);
      if (paramList != null)
      {
        a(paramString, ((Integer)paramList.first).intValue());
        paramString = a(paramString, (List)paramList.second);
        if (paramString != null) {
          c((String)paramString.first, (List)paramString.second);
        }
      }
    }
  }
  
  private boolean b()
  {
    FileCleanManager localFileCleanManager = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager;
    return (localFileCleanManager != null) && (localFileCleanManager.a());
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
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localObject == null) {
        return;
      }
      if (((ConcurrentHashMap)localObject).containsKey(paramString))
      {
        localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          String str = (String)paramList.get(i);
          if (!((List)localObject).contains(str)) {
            ((List)localObject).add(str);
          }
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramList);
    }
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
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord tableNames is empty");
    }
    this.jdField_b_of_type_Boolean = true;
    h();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.b();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord tableNames is empty");
    }
    this.c = true;
    h();
  }
  
  private void h()
  {
    if ((a()) && (b()))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        Object localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
        {
          localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (String)((Iterator)localObject1).next();
            CleanMessageItemInfo localCleanMessageItemInfo = new CleanMessageItemInfo();
            localObject2 = (MessageRecord)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
            if ((localObject2 != null) && (a(((MessageRecord)localObject2).istroop)))
            {
              localCleanMessageItemInfo.jdField_a_of_type_JavaLangString = ((MessageRecord)localObject2).frienduin;
              localCleanMessageItemInfo.jdField_b_of_type_JavaLangString = a((MessageRecord)localObject2);
              localCleanMessageItemInfo.jdField_a_of_type_Int = ((MessageRecord)localObject2).istroop;
              localCleanMessageItemInfo.jdField_b_of_type_Long = ((MessageRecord)localObject2).time;
              localCleanMessageItemInfo.jdField_a_of_type_Long = a(MessageRecord.getTableName(localCleanMessageItemInfo.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject2).istroop));
              if ((localCleanMessageItemInfo.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_JavaUtilList != null))
              {
                localCleanMessageItemInfo.c = FileCleanUtils.a(localCleanMessageItemInfo.jdField_a_of_type_Long);
                this.jdField_a_of_type_JavaUtilList.add(localCleanMessageItemInfo);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
          if (localObject1 != null) {
            ((ConcurrentHashMap)localObject1).clear();
          }
          localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
          if (localObject1 != null) {
            ((HashMap)localObject1).clear();
          }
          localObject1 = this.jdField_b_of_type_JavaUtilHashMap;
          if (localObject1 != null) {
            ((HashMap)localObject1).clear();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener == null) {
            break label317;
          }
          a(1);
          if (QLog.isColorLevel()) {
            QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
          break label317;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish cleanMessageList is empty");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
      }
      label317:
      this.e = false;
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    localObject = this.jdField_b_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager;
    if (localObject != null) {
      ((MessageDataManager)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanFileCleanManager;
    if (localObject != null) {
      ((FileCleanManager)localObject).b();
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public List<CleanMessageItemInfo> a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      Collections.sort(localList, new CleanMessageComparator(paramInt));
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<CleanMessageItemInfo> a(List<CleanMessageItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "deleteMessages");
      }
      ThreadManager.getFileThreadHandler().post(new MessageCleanManager.4(this, paramList));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CleanMessageItemInfo localCleanMessageItemInfo = (CleanMessageItemInfo)paramList.next();
        List localList = this.jdField_a_of_type_JavaUtilList;
        if (localList != null) {
          localList.remove(localCleanMessageItemInfo);
        }
      }
      return this.jdField_a_of_type_JavaUtilList;
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
    if ((!TextUtils.isEmpty(paramString)) && (paramEntity != null))
    {
      if ((paramEntity instanceof MessageRecord))
      {
        ConcurrentHashMap localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (localConcurrentHashMap != null) {
          localConcurrentHashMap.put(paramString, (MessageRecord)paramEntity);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "onNotifyLastMsg tableName or entity is null");
    }
  }
  
  public void a(String paramString, List<? extends Entity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if ((paramList.get(0) instanceof MessageRecord)) {
        b(paramString, paramList);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "onNotifyMessageData messageRecordList is empty");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord");
    }
    if (this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord isLoadingData");
      }
      return;
    }
    IMessageLoadListener localIMessageLoadListener = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener;
    if (localIMessageLoadListener != null) {
      localIMessageLoadListener.a();
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener == null) {
        break label221;
      }
      if (!QLog.isColorLevel()) {
        break label208;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadAllMessageRecord exception = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("MessageCleanManager", 2, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label121:
      break label121;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord OutOfMemoryError");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener.a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  public void onDestroy()
  {
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIMessageLoadListener = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager
 * JD-Core Version:    0.7.0.1
 */