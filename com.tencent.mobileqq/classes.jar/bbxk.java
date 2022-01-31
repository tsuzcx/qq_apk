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

public final class bbxk
  implements bbwz, INetInfoHandler
{
  private bbwy jdField_a_of_type_Bbwy;
  private LinkedList<bbwu> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public AtomicInteger a;
  
  public bbxk(AppRuntime paramAppRuntime, bbwy parambbwy)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    bbwy localbbwy = parambbwy;
    if (parambbwy == null) {
      localbbwy = new bbwy();
    }
    this.jdField_a_of_type_Bbwy = localbbwy;
    if (this.jdField_a_of_type_Bbwy.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private bbwu a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          bbwu localbbwu = (bbwu)localIterator.next();
          if (!localbbwu.a())
          {
            localbbwu.a();
            return localbbwu;
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
        localObject = (bbwu)paramString.next();
        ((bbwu)localObject).a(true);
        ((bbwu)localObject).i();
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
        bbwu localbbwu = (bbwu)((Iterator)localObject).next();
        if (paramString.equals(localbbwu.jdField_a_of_type_JavaLangString))
        {
          if (!localbbwu.a())
          {
            ((Iterator)localObject).remove();
            localArrayList.add(localbbwu);
          }
          else
          {
            localbbwu.a(true);
            localbbwu.i();
          }
        }
        else if ((localbbwu.b()) && (!localbbwu.a()))
        {
          ((Iterator)localObject).remove();
          localArrayList.add(localbbwu);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public bbwu a(String paramString)
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
          bbwu localbbwu = (bbwu)localIterator.next();
          if (paramString.equals(localbbwu.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "getTask | " + paramString + " task find =" + localbbwu);
            }
            return localbbwu;
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
          bbwu localbbwu2 = (bbwu)localIterator.next();
          if (localbbwu2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localbbwu2.a()) && (l > localbbwu2.c + localbbwu2.d))
          {
            bool = true;
            if ((!localbbwu2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QueueDownloader", 2, "remove task[" + localbbwu2.jdField_a_of_type_JavaLangString + "], isCancal=" + localbbwu2.b() + ", timeOut=" + bool);
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
        bbwu localbbwu1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localbbwu1 = a();
          if (localbbwu1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new QueueDownloader.1(this, localbbwu1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(bbwu parambbwu)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (parambbwu != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(parambbwu)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QueueDownloader", 2, "removeTask | task=" + parambbwu);
        }
        parambbwu.i();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(parambbwu);
      }
      return;
    }
    finally {}
  }
  
  public void a(bbwu parambbwu, bbwt arg2, Bundle paramBundle)
  {
    if ((!bbww.a(parambbwu)) || (a(parambbwu.jdField_a_of_type_JavaLangString) == parambbwu)) {}
    bbwu localbbwu;
    do
    {
      return;
      localbbwu = a(parambbwu.jdField_a_of_type_JavaLangString);
      if (localbbwu == null) {
        break;
      }
    } while ((localbbwu == null) || (!localbbwu.s));
    parambbwu.a(???);
    parambbwu.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambbwu.jdField_a_of_type_Bbwv.a < 0L)) {
      parambbwu.jdField_a_of_type_Bbwv.a = ???.getLongAccountUin();
    }
    localbbwu.a(parambbwu);
    return;
    parambbwu.a(???);
    parambbwu.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (parambbwu.jdField_a_of_type_Bbwv.a < 0L)) {
      parambbwu.jdField_a_of_type_Bbwv.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(parambbwu.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          parambbwu.c = ((int)(System.currentTimeMillis() / 1000L));
          if (parambbwu.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambbwu);
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "startDownload | task=" + parambbwu.jdField_a_of_type_JavaLangString);
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(parambbwu);
        }
      }
      if ((parambbwu.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle))) {
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
          bbwu localbbwu = (bbwu)localIterator.next();
          if (localbbwu.a() == 2) {
            localbbwu.h();
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
          bbwu localbbwu = (bbwu)localIterator.next();
          if (localbbwu.a() == 2) {
            localbbwu.f();
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
          bbwu localbbwu = (bbwu)localIterator.next();
          if (localbbwu.a() == 2) {
            localbbwu.g();
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
          bbwu localbbwu = (bbwu)localIterator.next();
          localStringBuilder.append("key=").append(localbbwu.jdField_a_of_type_JavaLangString);
          if ((localbbwu.jdField_a_of_type_JavaUtilList != null) && (localbbwu.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localbbwu.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localbbwu.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxk
 * JD-Core Version:    0.7.0.1
 */