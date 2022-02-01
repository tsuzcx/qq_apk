import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bjsi
  implements bjsc
{
  private ArrayList<bjsm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, bjso> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadCallbackNativeImpl.1(this, paramInt), 3000L);
  }
  
  public void a(bjsm parambjsm)
  {
    if ((parambjsm != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambjsm))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambjsm);
    }
  }
  
  public void a(bjso parambjso)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((parambjso == null) || (TextUtils.isEmpty(parambjso.jdField_a_of_type_JavaLangString))) {}
    while (this.jdField_a_of_type_JavaUtilMap.containsKey(parambjso.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(parambjso.jdField_a_of_type_JavaLangString, parambjso);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      ((bjso)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = true;
    }
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject == null) {
        break;
      }
      bjsn localbjsn = new bjsn();
      localbjsn.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjsm)((Iterator)localObject).next()).d(localbjsn);
      }
    }
  }
  
  public void b(bjsm parambjsm)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambjsm);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bjsn localbjsn = new bjsn();
      localbjsn.jdField_a_of_type_JavaLangString = paramString1;
      localbjsn.b = paramString2;
      localbjsn.jdField_a_of_type_Int = 7;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bjsm)paramString1.next()).a(localbjsn);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjsn localbjsn = new bjsn();
      localbjsn.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bjsm)paramDownloadInfo.next()).a(localbjsn);
      }
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjsn localbjsn = new bjsn();
      localbjsn.a(paramDownloadInfo);
      localbjsn.jdField_a_of_type_Int = localbjsn.a(paramDownloadInfo.a());
      localbjsn.jdField_c_of_type_Int = localbjsn.b(paramInt1);
      localbjsn.jdField_c_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext()) {
        ((bjsm)paramString.next()).b(localbjsn);
      }
      if (localbjsn.jdField_c_of_type_Int == 201)
      {
        paramString = (bjso)this.jdField_a_of_type_JavaUtilMap.get(localbjsn.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (!paramString.b)) {
          bjrz.a().a(paramDownloadInfo);
        }
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjsn localbjsn = new bjsn();
      localbjsn.a(paramDownloadInfo);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bjsm)localIterator.next()).a(localbjsn);
      }
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilMap.remove(paramDownloadInfo.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjsn localbjsn = new bjsn();
      localbjsn.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bjsm)paramDownloadInfo.next()).a(localbjsn);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject == null) {
        break;
      }
      bjsn localbjsn = new bjsn();
      localbjsn.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjsm)((Iterator)localObject).next()).c(localbjsn);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjsn localbjsn = new bjsn();
      localbjsn.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bjsm)paramDownloadInfo.next()).a(localbjsn);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bjsn localbjsn = new bjsn();
      localbjsn.jdField_a_of_type_JavaLangString = paramString1;
      localbjsn.b = paramString2;
      localbjsn.jdField_a_of_type_Int = 9;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bjsm)paramString1.next()).a(localbjsn);
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bjsn localbjsn = new bjsn();
      localbjsn.jdField_a_of_type_JavaLangString = paramString1;
      localbjsn.b = paramString2;
      localbjsn.jdField_a_of_type_Int = 8;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bjsm)paramString1.next()).a(localbjsn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsi
 * JD-Core Version:    0.7.0.1
 */