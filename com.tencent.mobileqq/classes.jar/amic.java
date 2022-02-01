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

public class amic
  implements bhhk, INetInfoHandler
{
  private bhhj jdField_a_of_type_Bhhj;
  private LinkedList<bhhf> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public AtomicInteger a;
  
  public amic(AppRuntime paramAppRuntime, bhhj parambhhj)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    bhhj localbhhj = parambhhj;
    if (parambhhj == null) {
      localbhhj = new bhhj();
    }
    this.jdField_a_of_type_Bhhj = localbhhj;
    if (this.jdField_a_of_type_Bhhj.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private bhhf a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bhhf localbhhf = (bhhf)localIterator.next();
          if (!localbhhf.a())
          {
            localbhhf.a();
            return localbhhf;
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
        localObject = (bhhf)paramString.next();
        ((bhhf)localObject).a(true);
        ((bhhf)localObject).i();
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
        bhhf localbhhf = (bhhf)((Iterator)localObject).next();
        if (paramString.equals(localbhhf.jdField_a_of_type_JavaLangString))
        {
          if (!localbhhf.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localbhhf);
          }
          else
          {
            localbhhf.a(true);
            localbhhf.i();
          }
        }
        else if ((localbhhf.b()) && (!localbhhf.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localbhhf);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public bhhf a(String paramString)
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
          bhhf localbhhf = (bhhf)localIterator.next();
          if (paramString.equals(localbhhf.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, "getTask | " + paramString + " task find =" + localbhhf);
            }
            return localbhhf;
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
          bhhf localbhhf2 = (bhhf)localIterator.next();
          if (localbhhf2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localbhhf2.a()) && (l > localbhhf2.c + localbhhf2.d))
          {
            bool = true;
            if ((!localbhhf2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloQueue_Downloader", 2, "remove task[" + localbhhf2.jdField_a_of_type_JavaLangString + "], isCancal=" + localbhhf2.b() + ", timeOut=" + bool);
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
        bhhf localbhhf1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localbhhf1 = a();
          if (localbhhf1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloQueue_Downloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new ApolloQueueDownloader.1(this, localbhhf1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(bhhf parambhhf)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (parambhhf != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(parambhhf)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloQueue_Downloader", 2, "removeTask | task=" + parambhhf);
        }
        parambhhf.i();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(parambhhf);
      }
      return;
    }
    finally {}
  }
  
  public void a(bhhf parambhhf, bhhe arg2, Bundle paramBundle)
  {
    if ((!bhhh.a(parambhhf)) || (a(parambhhf.jdField_a_of_type_JavaLangString) == parambhhf)) {}
    bhhf localbhhf;
    do
    {
      return;
      localbhhf = a(parambhhf.jdField_a_of_type_JavaLangString);
      if (localbhhf == null) {
        break;
      }
    } while ((localbhhf == null) || (!localbhhf.s));
    parambhhf.a(???);
    parambhhf.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambhhf.jdField_a_of_type_Bhhg.a < 0L)) {
      parambhhf.jdField_a_of_type_Bhhg.a = ???.getLongAccountUin();
    }
    localbhhf.a(parambhhf);
    return;
    parambhhf.a(???);
    parambhhf.a(paramBundle);
    parambhhf.g = 3;
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambhhf.jdField_a_of_type_Bhhg.a < 0L)) {
      parambhhf.jdField_a_of_type_Bhhg.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(parambhhf.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          parambhhf.c = ((int)(System.currentTimeMillis() / 1000L));
          if (parambhhf.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambhhf);
            if ((parambhhf.jdField_a_of_type_JavaUtilList != null) && (parambhhf.jdField_a_of_type_JavaUtilList.size() != 0)) {
              break label328;
            }
            ??? = null;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloQueue_Downloader", 2, new Object[] { "startDownload | task=" + parambhhf.jdField_a_of_type_JavaLangString, ", url:", ??? });
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(parambhhf);
        }
      }
      if ((parambhhf.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle)))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramBundle);
        continue;
        label328:
        ??? = (String)parambhhf.jdField_a_of_type_JavaUtilList.get(0);
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
          bhhf localbhhf = (bhhf)localIterator.next();
          if (localbhhf.a() == 2) {
            localbhhf.h();
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
          bhhf localbhhf = (bhhf)localIterator.next();
          if (localbhhf.a() == 2) {
            localbhhf.f();
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
          bhhf localbhhf = (bhhf)localIterator.next();
          if (localbhhf.a() == 2) {
            localbhhf.g();
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
          bhhf localbhhf = (bhhf)localIterator.next();
          localStringBuilder.append("key=").append(localbhhf.jdField_a_of_type_JavaLangString);
          if ((localbhhf.jdField_a_of_type_JavaUtilList != null) && (localbhhf.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localbhhf.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localbhhf.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amic
 * JD-Core Version:    0.7.0.1
 */