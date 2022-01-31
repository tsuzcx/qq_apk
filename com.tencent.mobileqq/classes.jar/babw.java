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

public class babw
{
  public static babw a;
  private int jdField_a_of_type_Int;
  private babt jdField_a_of_type_Babt;
  private babv jdField_a_of_type_Babv = new babx(this);
  private Downloader jdField_a_of_type_ComTencentHlyybDownloaderDownloader;
  private HashMap<String, babu> jdField_a_of_type_JavaUtilHashMap;
  Map<String, baby> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Babw = new babw();
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
  
  private void a(String paramString)
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
          baby localbaby = (baby)((Map.Entry)paramString.next()).getValue();
          if (localbaby != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localbaby.b }));
            a(localbaby);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setProgressInterval(1000);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.enableUserAction(true);
    UserAction.initUserAction(paramContext);
  }
  
  private void b(baby parambaby)
  {
    DownloaderTask localDownloaderTask = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.createNewTask(parambaby.b, parambaby.g, parambaby.h, this.jdField_a_of_type_Babt);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(parambaby.d);
    if (!TextUtils.isEmpty(parambaby.e)) {
      localDownloaderTask.setApkId(parambaby.e);
    }
    localDownloaderTask.setNotUseTempFile();
    parambaby.a(localDownloaderTask);
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
    this.jdField_a_of_type_Babt = new babt(this.jdField_a_of_type_Babv);
  }
  
  public void a(baby parambaby)
  {
    if (this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        DownloaderTask localDownloaderTask = a(parambaby.b);
        try
        {
          str = parambaby.b;
          if (!TextUtils.isEmpty(str)) {
            break label134;
          }
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)))
          {
            ((babu)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a(-1000, -1, "url is invalid");
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", localException);
        }
      }
    } while (this.jdField_a_of_type_Int >= 3);
    this.jdField_a_of_type_Int += 1;
    a(parambaby);
    return;
    label134:
    if ((localException == null) || (!str.equals(localException.getUrl())))
    {
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, thread = " + Thread.currentThread().getId() + "," + str + "path = " + parambaby.h);
      if (localException != null) {}
      b(parambaby);
      this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(parambaby.a());
      QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
      return;
    }
    parambaby.a(localException);
    DownloaderTaskStatus localDownloaderTaskStatus = localException.getStatus();
    QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + localDownloaderTaskStatus);
    if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
        ((babu)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
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
  
  public void a(String paramString, babu parambabu)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, parambabu);
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
    bfrz.c("DownloadManager_Now_for_qq", "removeDownloadTask---delete unactive halley task, Id:" + localDownloaderTask.getId());
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.deleteTask(localDownloaderTask, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babw
 * JD-Core Version:    0.7.0.1
 */