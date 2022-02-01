import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vip.QueueDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public final class bhzg
  implements bhyt, INetInfoHandler
{
  private bhys jdField_a_of_type_Bhys;
  private LinkedList<bhyo> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public AtomicInteger a;
  
  public bhzg(AppRuntime paramAppRuntime, bhys parambhys)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    bhys localbhys = parambhys;
    if (parambhys == null) {
      localbhys = new bhys();
    }
    this.jdField_a_of_type_Bhys = localbhys;
    if (this.jdField_a_of_type_Bhys.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private bhyo a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bhyo localbhyo = (bhyo)localIterator.next();
          if (!localbhyo.a())
          {
            localbhyo.a();
            return localbhyo;
          }
        }
      }
      return null;
    }
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
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
        localObject = (bhyo)paramString.next();
        ((bhyo)localObject).a(true);
        ((bhyo)localObject).i();
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
        bhyo localbhyo = (bhyo)((Iterator)localObject).next();
        if (paramString.equals(localbhyo.jdField_a_of_type_JavaLangString))
        {
          if (!localbhyo.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localbhyo);
          }
          else
          {
            localbhyo.a(true);
            localbhyo.i();
          }
        }
        else if ((localbhyo.b()) && (!localbhyo.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localbhyo);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public bhyo a(String paramString)
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
          bhyo localbhyo = (bhyo)localIterator.next();
          if (paramString.equals(localbhyo.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "getTask | " + paramString + " task find =" + localbhyo);
            }
            return localbhyo;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "getTask | " + paramString + " task not find");
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
          bhyo localbhyo2 = (bhyo)localIterator.next();
          if (localbhyo2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localbhyo2.a()) && (l > localbhyo2.c + localbhyo2.d))
          {
            bool = true;
            if ((!localbhyo2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QueueDownloader", 2, "remove task[" + localbhyo2.jdField_a_of_type_JavaLangString + "], isCancal=" + localbhyo2.b() + ", timeOut=" + bool);
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label185:
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "doTask | downloadLimitCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxDownloadCount=" + 3 + ",downloadQueue size=" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      for (;;)
      {
        bhyo localbhyo1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localbhyo1 = a();
          if (localbhyo1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new QueueDownloader.1(this, localbhyo1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(bhyo parambhyo)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (parambhyo != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(parambhyo)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QueueDownloader", 2, "removeTask | task=" + parambhyo);
        }
        parambhyo.i();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(parambhyo);
      }
      return;
    }
    finally {}
  }
  
  public void a(bhyo parambhyo, bhyn arg2, Bundle paramBundle)
  {
    if ((!bhyq.a(parambhyo)) || (a(parambhyo.jdField_a_of_type_JavaLangString) == parambhyo)) {}
    bhyo localbhyo;
    do
    {
      return;
      localbhyo = a(parambhyo.jdField_a_of_type_JavaLangString);
      if (localbhyo == null) {
        break;
      }
    } while ((localbhyo == null) || (!localbhyo.s));
    parambhyo.a(???);
    parambhyo.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambhyo.jdField_a_of_type_Bhyp.a < 0L)) {
      parambhyo.jdField_a_of_type_Bhyp.a = ???.getLongAccountUin();
    }
    localbhyo.a(parambhyo);
    return;
    parambhyo.a(???);
    parambhyo.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambhyo.jdField_a_of_type_Bhyp.a < 0L)) {
      parambhyo.jdField_a_of_type_Bhyp.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(parambhyo.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          parambhyo.c = ((int)(System.currentTimeMillis() / 1000L));
          if (parambhyo.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambhyo);
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "startDownload | task=" + parambhyo.jdField_a_of_type_JavaLangString);
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(parambhyo);
        }
      }
      if ((parambhyo.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle))) {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramBundle);
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
        QLog.d("QueueDownloader", 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bhyo localbhyo = (bhyo)localIterator.next();
          if (localbhyo.a() == 2) {
            localbhyo.h();
          }
        }
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "queueDownload network-onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "queueDownload network-onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "queueDownload network-onNetNone2Wifi");
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
          bhyo localbhyo = (bhyo)localIterator.next();
          if (localbhyo.a() == 2) {
            localbhyo.f();
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
        QLog.d("QueueDownloader", 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bhyo localbhyo = (bhyo)localIterator.next();
          if (localbhyo.a() == 2) {
            localbhyo.g();
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
          bhyo localbhyo = (bhyo)localIterator.next();
          localStringBuilder.append("key=").append(localbhyo.jdField_a_of_type_JavaLangString);
          if ((localbhyo.jdField_a_of_type_JavaUtilList != null) && (localbhyo.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localbhyo.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localbhyo.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzg
 * JD-Core Version:    0.7.0.1
 */