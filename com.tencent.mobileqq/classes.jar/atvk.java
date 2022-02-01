import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atvk
{
  private static List<atvv> a = new ArrayList();
  
  static
  {
    
    if (!bapg.a()) {
      bapg.a(BaseApplicationImpl.getApplication(), new atvl());
    }
  }
  
  public static atvv a(aufc arg0)
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
    localObject2 = new atvn(???);
    synchronized (a)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "new downloader:" + str2);
      a.add(0, localObject2);
      return localObject2;
    }
  }
  
  private static atvv a(String paramString)
  {
    for (;;)
    {
      synchronized (a)
      {
        Iterator localIterator = a.iterator();
        if (localIterator.hasNext())
        {
          atvv localatvv = (atvv)localIterator.next();
          if (!localatvv.a().equalsIgnoreCase(paramString)) {
            continue;
          }
          paramString = localatvv;
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
      ((atvv)((Iterator)???).next()).b();
    }
    synchronized (a)
    {
      a.clear();
      return;
    }
  }
  
  public static void a(aufc paramaufc)
  {
    d(paramaufc.a());
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
    atvv localatvv;
    while (((Iterator)???).hasNext())
    {
      localatvv = (atvv)((Iterator)???).next();
      if (localatvv.b())
      {
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", new Object[] { localatvv.a() }));
        return;
      }
    }
    synchronized (a)
    {
      localatvv = (atvv)a.get(0);
      if (localatvv == null)
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
    atvv localatvv1 = a(paramString);
    if (localatvv1 == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        atvv localatvv2 = (atvv)localIterator.next();
        if (localatvv2 != localatvv1) {
          localatvv2.b();
        }
      }
    }
    a.remove(localatvv1);
    a.add(0, localatvv1);
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", new Object[] { paramString }));
    localatvv1.a();
  }
  
  public static void c(String paramString)
  {
    atvv localatvv = a(paramString);
    if (localatvv == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    localatvv.c();
  }
  
  public static void d(String paramString)
  {
    atvv localatvv = a(paramString);
    if (localatvv == null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "cann't find downloader with:" + paramString);
      return;
    }
    localatvv.b();
    synchronized (a)
    {
      a.remove(localatvv);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", new Object[] { paramString, Integer.valueOf(a.size()) }));
      return;
    }
  }
  
  private static void e(String paramString)
  {
    atvv localatvv = a(paramString);
    if (localatvv != null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", new Object[] { paramString }));
      localatvv.b();
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
 * Qualified Name:     atvk
 * JD-Core Version:    0.7.0.1
 */