import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ashu
{
  private static List<asif> a = new ArrayList();
  
  static
  {
    
    if (!azjl.a()) {
      azjl.a(BaseApplicationImpl.getApplication(), new ashv());
    }
  }
  
  public static asif a(asrm arg0)
  {
    String str1 = ???.a();
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "try create downloader:" + str1);
    Object localObject2 = a(str1);
    if (localObject2 != null)
    {
      a(???);
      synchronized (a)
      {
        a.add(0, localObject2);
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("find downloader %s and set to head", new Object[] { str1 }));
        return localObject2;
      }
    }
    localObject2 = new ashx(???);
    synchronized (a)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "new downloader:" + str2);
      a.add(0, localObject2);
      return localObject2;
    }
  }
  
  private static asif a(String paramString)
  {
    for (;;)
    {
      synchronized (a)
      {
        Iterator localIterator = a.iterator();
        if (localIterator.hasNext())
        {
          asif localasif = (asif)localIterator.next();
          if (!localasif.a().equalsIgnoreCase(paramString)) {
            continue;
          }
          paramString = localasif;
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public static void a()
  {
    ??? = a.iterator();
    while (((Iterator)???).hasNext()) {
      ((asif)((Iterator)???).next()).b();
    }
    synchronized (a)
    {
      a.clear();
      return;
    }
  }
  
  public static void a(asrm paramasrm)
  {
    d(paramasrm.a());
  }
  
  public static void a(String paramString)
  {
    e(paramString);
    d(paramString);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(paramBoolean);
      return;
    }
  }
  
  public static void b()
  {
    if (a.size() == 0)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "download queue is empty");
      return;
    }
    ??? = a.iterator();
    asif localasif;
    while (((Iterator)???).hasNext())
    {
      localasif = (asif)((Iterator)???).next();
      if (localasif.b())
      {
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", new Object[] { localasif.a() }));
        return;
      }
    }
    synchronized (a)
    {
      localasif = (asif)a.get(0);
      if (localasif == null)
      {
        QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, "next queue has elment, why get head is null?");
        return;
      }
    }
    localObject2.a();
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("start %s to download", new Object[] { localObject2.a() }));
  }
  
  public static void b(String paramString)
  {
    asif localasif1 = a(paramString);
    if (localasif1 == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        asif localasif2 = (asif)localIterator.next();
        if (localasif2 != localasif1) {
          localasif2.b();
        }
      }
    }
    a.remove(localasif1);
    a.add(0, localasif1);
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", new Object[] { paramString }));
    localasif1.a();
  }
  
  public static void c(String paramString)
  {
    asif localasif = a(paramString);
    if (localasif == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    localasif.c();
  }
  
  public static void d(String paramString)
  {
    asif localasif = a(paramString);
    if (localasif == null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "cann't find downloader with:" + paramString);
      return;
    }
    localasif.b();
    synchronized (a)
    {
      a.remove(localasif);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", new Object[] { paramString, Integer.valueOf(a.size()) }));
      return;
    }
  }
  
  private static void e(String paramString)
  {
    asif localasif = a(paramString);
    if (localasif != null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", new Object[] { paramString }));
      localasif.b();
    }
    for (;;)
    {
      d(paramString);
      return;
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause failed, not find!", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashu
 * JD-Core Version:    0.7.0.1
 */