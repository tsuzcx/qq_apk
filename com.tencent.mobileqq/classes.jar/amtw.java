import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloQueueDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class amtw
  implements bihz, INetInfoHandler
{
  private bihy jdField_a_of_type_Bihy;
  private LinkedList<bihu> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public AtomicInteger a;
  
  public amtw(AppRuntime paramAppRuntime, bihy parambihy)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    bihy localbihy = parambihy;
    if (parambihy == null) {
      localbihy = new bihy();
    }
    this.jdField_a_of_type_Bihy = localbihy;
    if (this.jdField_a_of_type_Bihy.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private bihu a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bihu localbihu = (bihu)localIterator.next();
          if (!localbihu.a())
          {
            localbihu.a();
            return localbihu;
          }
        }
      }
      return null;
    }
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
    }
    Object localObject;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label115;
      }
      if (!paramBoolean) {
        break label119;
      }
      paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (paramString.hasNext())
      {
        localObject = (bihu)paramString.next();
        ((bihu)localObject).a(true);
        ((bihu)localObject).i();
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    for (;;)
    {
      label115:
      return 0;
      label119:
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject).hasNext())
      {
        bihu localbihu = (bihu)((Iterator)localObject).next();
        if (paramString.equals(localbihu.jdField_a_of_type_JavaLangString))
        {
          if (!localbihu.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localbihu);
          }
          else
          {
            localbihu.a(true);
            localbihu.i();
          }
        }
        else if ((localbihu.b()) && (!localbihu.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localbihu);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public bihu a(String paramString)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramString != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bihu localbihu = (bihu)localIterator.next();
          if (paramString.equals(localbihu.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task find =" + localbihu);
            }
            return localbihu;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task not find");
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
          if (!localIterator.hasNext()) {
            break label185;
          }
          bihu localbihu2 = (bihu)localIterator.next();
          if (localbihu2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localbihu2.a()) && (l > localbihu2.c + localbihu2.d))
          {
            bool = true;
            if ((!localbihu2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloQueue_Downloader", 2, "remove task[" + localbihu2.jdField_a_of_type_JavaLangString + "], isCancal=" + localbihu2.b() + ", timeOut=" + bool);
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label185:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "doTask | downloadLimitCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxDownloadCount=" + 3 + ",downloadQueue size=" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      for (;;)
      {
        bihu localbihu1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localbihu1 = a();
          if (localbihu1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloQueue_Downloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new ApolloQueueDownloader.1(this, localbihu1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(bihu parambihu)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (parambihu != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(parambihu)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloQueue_Downloader", 2, "removeTask | task=" + parambihu);
        }
        parambihu.i();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(parambihu);
      }
      return;
    }
    finally {}
  }
  
  public void a(bihu parambihu, biht arg2, Bundle paramBundle)
  {
    if ((!bihw.a(parambihu)) || (a(parambihu.jdField_a_of_type_JavaLangString) == parambihu)) {}
    bihu localbihu;
    do
    {
      return;
      localbihu = a(parambihu.jdField_a_of_type_JavaLangString);
      if (localbihu == null) {
        break;
      }
    } while ((localbihu == null) || (!localbihu.s));
    parambihu.a(???);
    parambihu.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambihu.jdField_a_of_type_Bihv.a < 0L)) {
      parambihu.jdField_a_of_type_Bihv.a = ???.getLongAccountUin();
    }
    localbihu.a(parambihu);
    return;
    parambihu.a(???);
    parambihu.a(paramBundle);
    parambihu.g = 3;
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambihu.jdField_a_of_type_Bihv.a < 0L)) {
      parambihu.jdField_a_of_type_Bihv.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(parambihu.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          parambihu.c = ((int)(System.currentTimeMillis() / 1000L));
          if (parambihu.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambihu);
            if ((parambihu.jdField_a_of_type_JavaUtilList != null) && (parambihu.jdField_a_of_type_JavaUtilList.size() != 0)) {
              break label328;
            }
            ??? = null;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, new Object[] { "startDownload | task=" + parambihu.jdField_a_of_type_JavaLangString, ", url:", ??? });
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(parambihu);
        }
      }
      if ((parambihu.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle)))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramBundle);
        continue;
        label328:
        ??? = (String)parambihu.jdField_a_of_type_JavaUtilList.get(0);
      }
    }
  }
  
  public void b()
  {
    a(true, null);
  }
  
  public void onNetMobile2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bihu localbihu = (bihu)localIterator.next();
          if (localbihu.a() == 2) {
            localbihu.h();
          }
        }
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bihu localbihu = (bihu)localIterator.next();
          if (localbihu.a() == 2) {
            localbihu.f();
          }
        }
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bihu localbihu = (bihu)localIterator.next();
          if (localbihu.a() == 2) {
            localbihu.g();
          }
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        if (localIterator.hasNext())
        {
          bihu localbihu = (bihu)localIterator.next();
          localStringBuilder.append("key=").append(localbihu.jdField_a_of_type_JavaLangString);
          if ((localbihu.jdField_a_of_type_JavaUtilList != null) && (localbihu.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localbihu.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localbihu.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtw
 * JD-Core Version:    0.7.0.1
 */