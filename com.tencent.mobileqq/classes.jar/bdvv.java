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

public class bdvv
{
  public static bdvv a;
  private int jdField_a_of_type_Int;
  private bdvs jdField_a_of_type_Bdvs;
  private bdvu jdField_a_of_type_Bdvu = new bdvw(this);
  private Downloader jdField_a_of_type_ComTencentHlyybDownloaderDownloader;
  private HashMap<String, bdvt> jdField_a_of_type_JavaUtilHashMap;
  Map<String, bdvx> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Bdvv = new bdvv();
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
          bdvx localbdvx = (bdvx)((Map.Entry)paramString.next()).getValue();
          if (localbdvx != null)
          {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask next task url=%s", new Object[] { localbdvx.b }));
            a(localbdvx);
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
  
  private void b(bdvx parambdvx)
  {
    DownloaderTask localDownloaderTask = this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.createNewTask(parambdvx.b, parambdvx.g, parambdvx.h, this.jdField_a_of_type_Bdvs);
    localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
    localDownloaderTask.setAppScene(parambdvx.d);
    if (!TextUtils.isEmpty(parambdvx.e)) {
      localDownloaderTask.setApkId(parambdvx.e);
    }
    localDownloaderTask.setNotUseTempFile();
    parambdvx.a(localDownloaderTask);
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
    this.jdField_a_of_type_Bdvs = new bdvs(this.jdField_a_of_type_Bdvu);
  }
  
  public void a(bdvx parambdvx)
  {
    if (this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        DownloaderTask localDownloaderTask = a(parambdvx.b);
        try
        {
          str = parambdvx.b;
          if (!TextUtils.isEmpty(str)) {
            break label134;
          }
          QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)))
          {
            ((bdvt)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a(-1000, -1, "url is invalid");
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
    a(parambdvx);
    return;
    label134:
    if ((localException == null) || (!str.equals(localException.getUrl())))
    {
      QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, thread = " + Thread.currentThread().getId() + "," + str + "path = " + parambdvx.h);
      if (localException != null) {}
      b(parambdvx);
      this.jdField_a_of_type_ComTencentHlyybDownloaderDownloader.addNewTask(parambdvx.a());
      QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
      return;
    }
    parambdvx.a(localException);
    DownloaderTaskStatus localDownloaderTaskStatus = localException.getStatus();
    QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + localDownloaderTaskStatus);
    if (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE)
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
        ((bdvt)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
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
  
  public void a(String paramString, bdvt parambdvt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, parambdvt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvv
 * JD-Core Version:    0.7.0.1
 */