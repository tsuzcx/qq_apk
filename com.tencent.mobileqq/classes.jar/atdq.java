import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atdq
{
  private static List<ateb> a = new ArrayList();
  
  static
  {
    
    if (!azwq.a()) {
      azwq.a(BaseApplicationImpl.getApplication(), new atdr());
    }
  }
  
  public static ateb a(atnh arg0)
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
    localObject2 = new atdt(???);
    synchronized (a)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "new downloader:" + str2);
      a.add(0, localObject2);
      return localObject2;
    }
  }
  
  private static ateb a(String paramString)
  {
    for (;;)
    {
      synchronized (a)
      {
        Iterator localIterator = a.iterator();
        if (localIterator.hasNext())
        {
          ateb localateb = (ateb)localIterator.next();
          if (!localateb.a().equalsIgnoreCase(paramString)) {
            continue;
          }
          paramString = localateb;
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
      ((ateb)((Iterator)???).next()).b();
    }
    synchronized (a)
    {
      a.clear();
      return;
    }
  }
  
  public static void a(atnh paramatnh)
  {
    d(paramatnh.a());
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
    ateb localateb;
    while (((Iterator)???).hasNext())
    {
      localateb = (ateb)((Iterator)???).next();
      if (localateb.b())
      {
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", new Object[] { localateb.a() }));
        return;
      }
    }
    synchronized (a)
    {
      localateb = (ateb)a.get(0);
      if (localateb == null)
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
    ateb localateb1 = a(paramString);
    if (localateb1 == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        ateb localateb2 = (ateb)localIterator.next();
        if (localateb2 != localateb1) {
          localateb2.b();
        }
      }
    }
    a.remove(localateb1);
    a.add(0, localateb1);
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", new Object[] { paramString }));
    localateb1.a();
  }
  
  public static void c(String paramString)
  {
    ateb localateb = a(paramString);
    if (localateb == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    localateb.c();
  }
  
  public static void d(String paramString)
  {
    ateb localateb = a(paramString);
    if (localateb == null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "cann't find downloader with:" + paramString);
      return;
    }
    localateb.b();
    synchronized (a)
    {
      a.remove(localateb);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", new Object[] { paramString, Integer.valueOf(a.size()) }));
      return;
    }
  }
  
  private static void e(String paramString)
  {
    ateb localateb = a(paramString);
    if (localateb != null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", new Object[] { paramString }));
      localateb.b();
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
 * Qualified Name:     atdq
 * JD-Core Version:    0.7.0.1
 */