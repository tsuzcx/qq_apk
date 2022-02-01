import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atma
{
  private static List<atml> a = new ArrayList();
  
  static
  {
    
    if (!bapt.a()) {
      bapt.a(BaseApplicationImpl.getApplication(), new atmb());
    }
  }
  
  public static atml a(atvt arg0)
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
    localObject2 = new atmd(???);
    synchronized (a)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "new downloader:" + str2);
      a.add(0, localObject2);
      return localObject2;
    }
  }
  
  private static atml a(String paramString)
  {
    for (;;)
    {
      synchronized (a)
      {
        Iterator localIterator = a.iterator();
        if (localIterator.hasNext())
        {
          atml localatml = (atml)localIterator.next();
          if (!localatml.a().equalsIgnoreCase(paramString)) {
            continue;
          }
          paramString = localatml;
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
      ((atml)((Iterator)???).next()).b();
    }
    synchronized (a)
    {
      a.clear();
      return;
    }
  }
  
  public static void a(atvt paramatvt)
  {
    d(paramatvt.a());
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
    atml localatml;
    while (((Iterator)???).hasNext())
    {
      localatml = (atml)((Iterator)???).next();
      if (localatml.b())
      {
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", new Object[] { localatml.a() }));
        return;
      }
    }
    synchronized (a)
    {
      localatml = (atml)a.get(0);
      if (localatml == null)
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
    atml localatml1 = a(paramString);
    if (localatml1 == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        atml localatml2 = (atml)localIterator.next();
        if (localatml2 != localatml1) {
          localatml2.b();
        }
      }
    }
    a.remove(localatml1);
    a.add(0, localatml1);
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", new Object[] { paramString }));
    localatml1.a();
  }
  
  public static void c(String paramString)
  {
    atml localatml = a(paramString);
    if (localatml == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    localatml.c();
  }
  
  public static void d(String paramString)
  {
    atml localatml = a(paramString);
    if (localatml == null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "cann't find downloader with:" + paramString);
      return;
    }
    localatml.b();
    synchronized (a)
    {
      a.remove(localatml);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", new Object[] { paramString, Integer.valueOf(a.size()) }));
      return;
    }
  }
  
  private static void e(String paramString)
  {
    atml localatml = a(paramString);
    if (localatml != null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", new Object[] { paramString }));
      localatml.b();
    }
    for (;;)
    {
      d(paramString);
      return;
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause failed, not find!", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atma
 * JD-Core Version:    0.7.0.1
 */