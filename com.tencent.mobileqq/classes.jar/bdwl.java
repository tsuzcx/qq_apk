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

public final class bdwl
  implements bdwa, INetInfoHandler
{
  private bdvz jdField_a_of_type_Bdvz;
  private LinkedList<bdvv> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public AtomicInteger a;
  
  public bdwl(AppRuntime paramAppRuntime, bdvz parambdvz)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    bdvz localbdvz = parambdvz;
    if (parambdvz == null) {
      localbdvz = new bdvz();
    }
    this.jdField_a_of_type_Bdvz = localbdvz;
    if (this.jdField_a_of_type_Bdvz.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private bdvv a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bdvv localbdvv = (bdvv)localIterator.next();
          if (!localbdvv.a())
          {
            localbdvv.a();
            return localbdvv;
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
        localObject = (bdvv)paramString.next();
        ((bdvv)localObject).a(true);
        ((bdvv)localObject).i();
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
        bdvv localbdvv = (bdvv)((Iterator)localObject).next();
        if (paramString.equals(localbdvv.jdField_a_of_type_JavaLangString))
        {
          if (!localbdvv.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localbdvv);
          }
          else
          {
            localbdvv.a(true);
            localbdvv.i();
          }
        }
        else if ((localbdvv.b()) && (!localbdvv.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localbdvv);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public bdvv a(String paramString)
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
          bdvv localbdvv = (bdvv)localIterator.next();
          if (paramString.equals(localbdvv.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "getTask | " + paramString + " task find =" + localbdvv);
            }
            return localbdvv;
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
          bdvv localbdvv2 = (bdvv)localIterator.next();
          if (localbdvv2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localbdvv2.a()) && (l > localbdvv2.c + localbdvv2.d))
          {
            bool = true;
            if ((!localbdvv2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QueueDownloader", 2, "remove task[" + localbdvv2.jdField_a_of_type_JavaLangString + "], isCancal=" + localbdvv2.b() + ", timeOut=" + bool);
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
        bdvv localbdvv1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localbdvv1 = a();
          if (localbdvv1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new QueueDownloader.1(this, localbdvv1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(bdvv parambdvv)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (parambdvv != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(parambdvv)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QueueDownloader", 2, "removeTask | task=" + parambdvv);
        }
        parambdvv.i();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(parambdvv);
      }
      return;
    }
    finally {}
  }
  
  public void a(bdvv parambdvv, bdvu arg2, Bundle paramBundle)
  {
    if ((!bdvx.a(parambdvv)) || (a(parambdvv.jdField_a_of_type_JavaLangString) == parambdvv)) {}
    bdvv localbdvv;
    do
    {
      return;
      localbdvv = a(parambdvv.jdField_a_of_type_JavaLangString);
      if (localbdvv == null) {
        break;
      }
    } while ((localbdvv == null) || (!localbdvv.s));
    parambdvv.a(???);
    parambdvv.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambdvv.jdField_a_of_type_Bdvw.a < 0L)) {
      parambdvv.jdField_a_of_type_Bdvw.a = ???.getLongAccountUin();
    }
    localbdvv.a(parambdvv);
    return;
    parambdvv.a(???);
    parambdvv.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambdvv.jdField_a_of_type_Bdvw.a < 0L)) {
      parambdvv.jdField_a_of_type_Bdvw.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(parambdvv.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          parambdvv.c = ((int)(System.currentTimeMillis() / 1000L));
          if (parambdvv.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambdvv);
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "startDownload | task=" + parambdvv.jdField_a_of_type_JavaLangString);
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(parambdvv);
        }
      }
      if ((parambdvv.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle))) {
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
          bdvv localbdvv = (bdvv)localIterator.next();
          if (localbdvv.a() == 2) {
            localbdvv.h();
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
          bdvv localbdvv = (bdvv)localIterator.next();
          if (localbdvv.a() == 2) {
            localbdvv.f();
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
          bdvv localbdvv = (bdvv)localIterator.next();
          if (localbdvv.a() == 2) {
            localbdvv.g();
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
          bdvv localbdvv = (bdvv)localIterator.next();
          localStringBuilder.append("key=").append(localbdvv.jdField_a_of_type_JavaLangString);
          if ((localbdvv.jdField_a_of_type_JavaUtilList != null) && (localbdvv.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localbdvv.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localbdvv.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwl
 * JD-Core Version:    0.7.0.1
 */