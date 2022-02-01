package com.tencent.mobileqq.app.message.messageclean;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
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
  public PeakAppInterface a;
  private MessageDataManager b;
  private FileCleanManager c;
  private ConcurrentHashMap<String, List<String>> d;
  private ConcurrentHashMap<String, MessageRecord> e;
  private volatile boolean f = false;
  private volatile boolean g = false;
  private volatile boolean h = false;
  private volatile boolean i = false;
  private IAIOImageProvider j;
  private List<CleanMessageItemInfo> k;
  private IMessageLoadListener l;
  private HashMap<String, String> m;
  private HashMap<String, Integer> n;
  private long o = 0L;
  private volatile boolean p = false;
  
  public MessageCleanManager()
  {
    d();
  }
  
  private long a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    long l3 = l2;
    if (!bool)
    {
      if (this.d == null) {
        return 0L;
      }
      Object localObject1 = this.c.c();
      Object localObject2 = (List)this.d.get(paramString);
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
              l2 += localFileInfo.b;
              localFileInfo.d += 1;
              this.c.a(str, localFileInfo);
            }
          }
        }
      }
      localObject1 = this.n;
      l3 = l1;
      if (localObject1 != null)
      {
        l3 = l1;
        if (((HashMap)localObject1).containsKey(paramString))
        {
          l3 = l1;
          if (((Integer)this.n.get(paramString)).intValue() > 0) {
            l3 = l1 + ((Integer)this.n.get(paramString)).intValue() * 200;
          }
        }
      }
    }
    return l3;
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramMessageRecord != null)
    {
      HashMap localHashMap = this.m;
      localObject2 = localObject1;
      if (localHashMap != null)
      {
        if (localHashMap.isEmpty()) {
          return "";
        }
        int i1 = paramMessageRecord.istroop;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 1000)
            {
              if (i1 != 1004)
              {
                if (i1 == 3000) {
                  localObject1 = this.b.a(paramMessageRecord.frienduin);
                }
              }
              else {
                localObject1 = this.b.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
              }
            }
            else
            {
              localObject2 = this.j;
              if (localObject2 != null) {
                localObject1 = ((IAIOImageProvider)localObject2).a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
              }
            }
          }
          else
          {
            localObject1 = this.m;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramMessageRecord.frienduin);
            ((StringBuilder)localObject2).append(1);
            localObject1 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = this.m;
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
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HashMap localHashMap = this.n;
      if (localHashMap != null)
      {
        if (localHashMap.containsKey(paramString))
        {
          int i1 = ((Integer)this.n.get(paramString)).intValue();
          this.n.put(paramString, Integer.valueOf(i1 + paramInt));
          return;
        }
        this.n.put(paramString, Integer.valueOf(paramInt));
      }
    }
  }
  
  private boolean a(CleanMessageItemInfo paramCleanMessageItemInfo)
  {
    if (paramCleanMessageItemInfo != null)
    {
      if (this.j == null) {
        return true;
      }
      String str = MessageRecord.getTableName(paramCleanMessageItemInfo.a, paramCleanMessageItemInfo.c);
      if (!TextUtils.isEmpty(str))
      {
        c(str);
        IAIOImageProvider localIAIOImageProvider = this.j;
        if (localIAIOImageProvider != null) {
          localIAIOImageProvider.b(paramCleanMessageItemInfo.a, paramCleanMessageItemInfo.c);
        }
        b(str);
      }
    }
    return true;
  }
  
  private Pair<Integer, List<MessageRecord>> b(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForText)) {
          i1 += 1;
        } else {
          localArrayList.add(localMessageRecord);
        }
      }
      return new Pair(Integer.valueOf(i1), localArrayList);
    }
    return null;
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.d;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(paramString);
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
      paramList = b(paramList);
      if (paramList != null)
      {
        a(paramString, ((Integer)paramList.first).intValue());
        paramString = c(paramString, (List)paramList.second);
        if (paramString != null) {
          d((String)paramString.first, (List)paramString.second);
        }
      }
    }
  }
  
  private boolean b(int paramInt)
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
  
  private Pair<String, List<String>> c(String paramString, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (MessageRecord)localIterator.next();
        int i1 = paramList.msgtype;
        if (MessageTypeUtils.a(i1))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForPic)))
          {
            paramList = (MessageForPic)paramList;
            paramList = ((IPicHelper)QRoute.api(IPicHelper.class)).getBiggestFilePath(paramList);
            break label302;
          }
        }
        else if (MessageTypeUtils.b(i1))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramList;
            paramList = SVUtils.a(localMessageForShortVideo, "mp4");
            if (TextUtils.isEmpty(paramList))
            {
              paramList = ShortVideoUtils.getVideoTmpPath(localMessageForShortVideo);
              break label302;
            }
            break label302;
          }
        }
        else if (MessageTypeUtils.c(i1))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if (paramList != null)
          {
            paramList = QFileUtils.a(this.a, paramList);
            break label302;
          }
        }
        else if (MessageTypeUtils.d(i1))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForMixedMsg))) {
            b(paramString, ((MessageForMixedMsg)paramList).getPicMsgList());
          }
        }
        else if (MessageTypeUtils.e(i1))
        {
          paramList = Cursor2EntityConvert.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForStructing)) && (MultiMsgUtil.a((MessageForStructing)paramList))) {
            b(paramString, this.b.c(MessageRecord.class, "select * from mr_multimessage where msgseq=?", "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramList.uniseq) }));
          }
        }
        paramList = "";
        label302:
        if ((!TextUtils.isEmpty(paramList)) && (!localArrayList.contains(paramList))) {
          localArrayList.add(new File(paramList).getName());
        }
      }
      return new Pair(paramString, localArrayList);
    }
    return new Pair(paramString, localArrayList);
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.d;
      if (localConcurrentHashMap != null)
      {
        Object localObject = (List)localConcurrentHashMap.get(paramString);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramString = new ArrayList();
          localConcurrentHashMap = this.c.c();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            FileInfo localFileInfo = (FileInfo)localConcurrentHashMap.get(str1);
            if (localFileInfo != null)
            {
              localFileInfo.d -= 1;
              if (localFileInfo.d == 0)
              {
                String str2 = this.c.a(localFileInfo);
                if (!TextUtils.isEmpty(str2))
                {
                  this.o += localFileInfo.b;
                  paramString.add(str2);
                }
                this.c.a(str1);
              }
              else
              {
                this.c.a(str1, localFileInfo);
              }
            }
          }
          this.c.a(paramString);
        }
      }
    }
  }
  
  private void d()
  {
    this.b = new MessageDataManager();
    AppInterface localAppInterface = this.b.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.a = ((PeakAppInterface)localAppInterface);
    }
  }
  
  private void d(String paramString, List<String> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      Object localObject = this.d;
      if (localObject == null) {
        return;
      }
      if (((ConcurrentHashMap)localObject).containsKey(paramString))
      {
        localObject = (List)this.d.get(paramString);
        int i2 = paramList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          String str = (String)paramList.get(i1);
          if (!((List)localObject).contains(str)) {
            ((List)localObject).add(str);
          }
          i1 += 1;
        }
        this.d.put(paramString, localObject);
        return;
      }
      this.d.put(paramString, paramList);
    }
  }
  
  private void e()
  {
    this.i = false;
    this.d = new ConcurrentHashMap();
    this.e = new ConcurrentHashMap();
    this.k = new ArrayList();
    this.m = new HashMap();
    this.n = new HashMap();
    this.o = 0L;
    this.b.a(this);
    this.c = new FileCleanManager(this);
  }
  
  private void f()
  {
    this.b.a(0, this.m);
    this.b.b(1, this.m);
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadNameList finish");
    }
    k();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord");
    }
    Object localObject = this.b.b();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = String.format("select * from %s", new Object[] { str1 });
        b(str1, this.b.a(MessageRecord.class, str2, str1, null, null));
      }
      this.g = true;
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadMessageRecord finish");
      }
      k();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord tableNames is empty");
    }
    this.g = true;
    k();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord");
    }
    Object localObject = this.b.c();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = String.format("select * from %s", new Object[] { str1 });
        b(str1, this.b.b(MessageRecord.class, str2, str1, null, null));
      }
      this.h = true;
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord finish");
      }
      k();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord tableNames is empty");
    }
    this.h = true;
    k();
  }
  
  private boolean i()
  {
    return (this.f) && (this.g) && (this.h);
  }
  
  private boolean j()
  {
    FileCleanManager localFileCleanManager = this.c;
    return (localFileCleanManager != null) && (localFileCleanManager.b());
  }
  
  private void k()
  {
    if ((i()) && (j()))
    {
      if (this.d != null)
      {
        Object localObject1 = this.e;
        if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
        {
          localObject1 = this.d.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (String)((Iterator)localObject1).next();
            CleanMessageItemInfo localCleanMessageItemInfo = new CleanMessageItemInfo();
            localObject2 = (MessageRecord)this.e.get(localObject2);
            if ((localObject2 != null) && (b(((MessageRecord)localObject2).istroop)))
            {
              localCleanMessageItemInfo.a = ((MessageRecord)localObject2).frienduin;
              localCleanMessageItemInfo.b = a((MessageRecord)localObject2);
              localCleanMessageItemInfo.c = ((MessageRecord)localObject2).istroop;
              localCleanMessageItemInfo.f = ((MessageRecord)localObject2).time;
              localCleanMessageItemInfo.d = a(MessageRecord.getTableName(localCleanMessageItemInfo.a, ((MessageRecord)localObject2).istroop));
              if ((localCleanMessageItemInfo.d > 0L) && (this.k != null))
              {
                localCleanMessageItemInfo.e = FileCleanUtils.a(localCleanMessageItemInfo.d);
                this.k.add(localCleanMessageItemInfo);
              }
            }
          }
          localObject1 = this.e;
          if (localObject1 != null) {
            ((ConcurrentHashMap)localObject1).clear();
          }
          localObject1 = this.m;
          if (localObject1 != null) {
            ((HashMap)localObject1).clear();
          }
          localObject1 = this.n;
          if (localObject1 != null) {
            ((HashMap)localObject1).clear();
          }
          if (this.l == null) {
            break label317;
          }
          a(1);
          if (QLog.isColorLevel()) {
            QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish");
          }
          this.l.a(this.k);
          break label317;
        }
      }
      if (this.l != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish cleanMessageList is empty");
        }
        this.l.a(this.k);
      }
      label317:
      this.p = false;
    }
  }
  
  private void l()
  {
    this.p = false;
    this.i = true;
    this.g = false;
    this.h = false;
    this.f = false;
    this.o = 0L;
    Object localObject = this.k;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.k = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.e = null;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.m = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.n = null;
    }
    localObject = this.b;
    if (localObject != null) {
      ((MessageDataManager)localObject).d();
    }
    localObject = this.c;
    if (localObject != null) {
      ((FileCleanManager)localObject).d();
    }
  }
  
  public List<CleanMessageItemInfo> a(int paramInt)
  {
    List localList = this.k;
    if (localList != null) {
      Collections.sort(localList, new CleanMessageComparator(paramInt));
    }
    return this.k;
  }
  
  public List<CleanMessageItemInfo> a(List<CleanMessageItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (this.j != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "deleteMessages");
      }
      ThreadManager.getFileThreadHandler().post(new MessageCleanManager.4(this, paramList));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CleanMessageItemInfo localCleanMessageItemInfo = (CleanMessageItemInfo)paramList.next();
        List localList = this.k;
        if (localList != null) {
          localList.remove(localCleanMessageItemInfo);
        }
      }
      return this.k;
    }
    return this.k;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "onScanFinish");
    }
    k();
  }
  
  public void a(IAIOImageProvider paramIAIOImageProvider)
  {
    this.j = paramIAIOImageProvider;
  }
  
  public void a(IMessageLoadListener paramIMessageLoadListener)
  {
    this.l = paramIMessageLoadListener;
  }
  
  public void a(String paramString, Entity paramEntity)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramEntity != null))
    {
      if ((paramEntity instanceof MessageRecord))
      {
        ConcurrentHashMap localConcurrentHashMap = this.e;
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
    if (this.p)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord isLoadingData");
      }
      return;
    }
    IMessageLoadListener localIMessageLoadListener = this.l;
    if (localIMessageLoadListener != null) {
      localIMessageLoadListener.a();
    }
    l();
    e();
    try
    {
      this.p = true;
      this.c.a();
      ThreadManager.getSubThreadHandler().post(new MessageCleanManager.1(this));
      ThreadManagerV2.excute(new MessageCleanManager.2(this), 64, null, true);
      ThreadManagerV2.excute(new MessageCleanManager.3(this), 64, null, true);
      return;
    }
    catch (Exception localException)
    {
      if (this.l == null) {
        break label221;
      }
      if (!QLog.isColorLevel()) {
        break label208;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadAllMessageRecord exception = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("MessageCleanManager", 2, localStringBuilder.toString());
      this.l.a(this.k);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label121:
      break label121;
    }
    if (this.l != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord OutOfMemoryError");
      }
      this.l.a(this.k);
      return;
    }
  }
  
  public long c()
  {
    return this.o;
  }
  
  public void onDestroy()
  {
    l();
    this.l = null;
    this.j = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager
 * JD-Core Version:    0.7.0.1
 */