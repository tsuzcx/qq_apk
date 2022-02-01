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

public class bjiz
  implements bjit
{
  private ArrayList<bjjd> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, bjjf> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
  
  public void a(bjjd parambjjd)
  {
    if ((parambjjd != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambjjd))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambjjd);
    }
  }
  
  public void a(bjjf parambjjf)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((parambjjf == null) || (TextUtils.isEmpty(parambjjf.jdField_a_of_type_JavaLangString))) {}
    while (this.jdField_a_of_type_JavaUtilMap.containsKey(parambjjf.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(parambjjf.jdField_a_of_type_JavaLangString, parambjjf);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      ((bjjf)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = true;
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
      bjje localbjje = new bjje();
      localbjje.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjjd)((Iterator)localObject).next()).d(localbjje);
      }
    }
  }
  
  public void b(bjjd parambjjd)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambjjd);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bjje localbjje = new bjje();
      localbjje.jdField_a_of_type_JavaLangString = paramString1;
      localbjje.b = paramString2;
      localbjje.jdField_a_of_type_Int = 7;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bjjd)paramString1.next()).a(localbjje);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjje localbjje = new bjje();
      localbjje.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bjjd)paramDownloadInfo.next()).a(localbjje);
      }
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjje localbjje = new bjje();
      localbjje.a(paramDownloadInfo);
      localbjje.jdField_a_of_type_Int = localbjje.a(paramDownloadInfo.a());
      localbjje.jdField_c_of_type_Int = localbjje.b(paramInt1);
      localbjje.jdField_c_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext()) {
        ((bjjd)paramString.next()).b(localbjje);
      }
      if (localbjje.jdField_c_of_type_Int == 201)
      {
        paramString = (bjjf)this.jdField_a_of_type_JavaUtilMap.get(localbjje.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (!paramString.b)) {
          bjiq.a().a(paramDownloadInfo);
        }
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjje localbjje = new bjje();
      localbjje.a(paramDownloadInfo);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bjjd)localIterator.next()).a(localbjje);
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
      bjje localbjje = new bjje();
      localbjje.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bjjd)paramDownloadInfo.next()).a(localbjje);
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
      bjje localbjje = new bjje();
      localbjje.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjjd)((Iterator)localObject).next()).c(localbjje);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bjje localbjje = new bjje();
      localbjje.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bjjd)paramDownloadInfo.next()).a(localbjje);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bjje localbjje = new bjje();
      localbjje.jdField_a_of_type_JavaLangString = paramString1;
      localbjje.b = paramString2;
      localbjje.jdField_a_of_type_Int = 9;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bjjd)paramString1.next()).a(localbjje);
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bjje localbjje = new bjje();
      localbjje.jdField_a_of_type_JavaLangString = paramString1;
      localbjje.b = paramString2;
      localbjje.jdField_a_of_type_Int = 8;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bjjd)paramString1.next()).a(localbjje);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjiz
 * JD-Core Version:    0.7.0.1
 */