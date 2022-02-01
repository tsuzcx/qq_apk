import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class awbo
{
  public static awbo a;
  private int jdField_a_of_type_Int;
  private awbl jdField_a_of_type_Awbl;
  private awbn jdField_a_of_type_Awbn = new awbp(this);
  private Downloader jdField_a_of_type_ComTencentHlyybDownloaderDownloader;
  private HashMap<String, awbm> jdField_a_of_type_JavaUtilHashMap;
  Map<String, awbq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Awbo = new awbo();
  }
  
  private DownloaderTask a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.getAllTasks();
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownloaderTask localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
      if (localDownloaderTask.getUrl().equals(paramString))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "isHalleyTaskAlreadyExist:YES");
        return localDownloaderTask;
      }
    }
    return null;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setProgressInterval(1000);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.enableUserAction(true);
    UserAction.initUserAction(paramContext);
  }
  
  private void b(String paramString)
  {
    try
    {
      QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask taskUrl=%s", new Object[] { paramString }));
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        paramString = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          awbq localawbq = (awbq)((Map.Entry)paramString.next()).getValue();
          if (localawbq != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localawbq.b }));
            b(localawbq);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private void c(awbq paramawbq)
  {
    DownloaderTask localDownloaderTask = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.createNewTask(paramawbq.b, paramawbq.g, paramawbq.h, this.jdField_a_of_type_Awbl);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(paramawbq.d);
    if (!TextUtils.isEmpty(paramawbq.e)) {
      localDownloaderTask.setApkId(paramawbq.e);
    }
    localDownloaderTask.setNotUseTempFile();
    paramawbq.a(localDownloaderTask);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awbl != null)
    {
      this.jdField_a_of_type_Awbl.a();
      this.jdField_a_of_type_Awbl = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    HalleyAgent.init(paramContext, "1", "now_for_qq");
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader = HalleyAgent.getDownloader();
    b(paramContext);
    this.jdField_a_of_type_Awbl = new awbl(this.jdField_a_of_type_Awbn);
  }
  
  /* Error */
  public void a(awbq paramawbq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 82
    //   4: iconst_1
    //   5: ldc 229
    //   7: iconst_2
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: getfield 160	awbq:b	Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: getfield 29	awbo:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   24: invokeinterface 141 1 0
    //   29: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 128	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: getfield 29	awbo:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   43: invokeinterface 141 1 0
    //   48: ifne +26 -> 74
    //   51: aload_0
    //   52: getfield 29	awbo:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   55: aload_1
    //   56: getfield 160	awbq:b	Ljava/lang/String;
    //   59: aload_1
    //   60: invokeinterface 239 3 0
    //   65: pop
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 163	awbo:b	(Lawbq;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: getfield 29	awbo:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   78: aload_1
    //   79: getfield 160	awbq:b	Ljava/lang/String;
    //   82: aload_1
    //   83: invokeinterface 239 3 0
    //   88: pop
    //   89: goto -18 -> 71
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	awbo
    //   0	97	1	paramawbq	awbq
    // Exception table:
    //   from	to	target	type
    //   2	71	92	finally
    //   74	89	92	finally
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, awbm paramawbm)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramawbm);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.getAllTasks();
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {}
    DownloaderTask localDownloaderTask;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = ((List)localObject).iterator();
      }
      localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
    } while (!localDownloaderTask.getUrl().equals(paramString));
    bkad.c("DownloadManager_Now_for_qq", "removeDownloadTask---delete unactive halley task, Id:" + localDownloaderTask.getId());
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.deleteTask(localDownloaderTask, paramBoolean);
  }
  
  public void b(awbq paramawbq)
  {
    DownloaderTask localDownloaderTask = a(paramawbq.b);
    try
    {
      str = paramawbq.b;
      if (TextUtils.isEmpty(str))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
          ((awbm)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a(-1000, -1, "url is invalid");
        }
      }
      else if ((localDownloaderTask == null) || (!str.equals(localDownloaderTask.getUrl())))
      {
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, thread = " + Thread.currentThread().getId() + "," + str + "path = " + paramawbq.h);
        if (localDownloaderTask != null) {}
        c(paramawbq);
        this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(paramawbq.a());
        QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
        return;
      }
    }
    catch (Exception localException)
    {
      String str;
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", localException);
      if (this.jdField_a_of_type_Int < 3)
      {
        this.jdField_a_of_type_Int += 1;
        b(paramawbq);
        return;
        paramawbq.a(localException);
        DownloaderTaskStatus localDownloaderTaskStatus = localException.getStatus();
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + localDownloaderTaskStatus);
        if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
            ((awbm)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
          }
          a(localException.getUrl(), false);
          return;
        }
        if (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING)
        {
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----Task is already Downloading!");
          return;
        }
        QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----resume halley task");
        localException.resume();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbo
 * JD-Core Version:    0.7.0.1
 */