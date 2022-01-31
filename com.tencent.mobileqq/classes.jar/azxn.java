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

public class azxn
{
  public static azxn a;
  private int jdField_a_of_type_Int;
  private azxk jdField_a_of_type_Azxk;
  private azxm jdField_a_of_type_Azxm = new azxo(this);
  private Downloader jdField_a_of_type_ComTencentHlyybDownloaderDownloader;
  private HashMap<String, azxl> jdField_a_of_type_JavaUtilHashMap;
  Map<String, azxp> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Azxn = new azxn();
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
          azxp localazxp = (azxp)((Map.Entry)paramString.next()).getValue();
          if (localazxp != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localazxp.b }));
            a(localazxp);
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
  
  private void b(azxp paramazxp)
  {
    DownloaderTask localDownloaderTask = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.createNewTask(paramazxp.b, paramazxp.g, paramazxp.h, this.jdField_a_of_type_Azxk);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(paramazxp.d);
    if (!TextUtils.isEmpty(paramazxp.e)) {
      localDownloaderTask.setApkId(paramazxp.e);
    }
    localDownloaderTask.setNotUseTempFile();
    paramazxp.a(localDownloaderTask);
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
    this.jdField_a_of_type_Azxk = new azxk(this.jdField_a_of_type_Azxm);
  }
  
  public void a(azxp paramazxp)
  {
    if (this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        DownloaderTask localDownloaderTask = a(paramazxp.b);
        try
        {
          str = paramazxp.b;
          if (!TextUtils.isEmpty(str)) {
            break label134;
          }
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)))
          {
            ((azxl)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a(-1000, -1, "url is invalid");
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
    a(paramazxp);
    return;
    label134:
    if ((localException == null) || (!str.equals(localException.getUrl())))
    {
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, thread = " + Thread.currentThread().getId() + "," + str + "path = " + paramazxp.h);
      if (localException != null) {}
      b(paramazxp);
      this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(paramazxp.a());
      QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
      return;
    }
    paramazxp.a(localException);
    DownloaderTaskStatus localDownloaderTaskStatus = localException.getStatus();
    QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + localDownloaderTaskStatus);
    if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
        ((azxl)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
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
  
  public void a(String paramString, azxl paramazxl)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramazxl);
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
    bfnq.c("DownloadManager_Now_for_qq", "removeDownloadTask---delete unactive halley task, Id:" + localDownloaderTask.getId());
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.deleteTask(localDownloaderTask, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxn
 * JD-Core Version:    0.7.0.1
 */