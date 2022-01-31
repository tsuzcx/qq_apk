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

public class bdgt
  implements bdgn
{
  private ArrayList<bdgx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, bdgz> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
  
  public void a(bdgx parambdgx)
  {
    if ((parambdgx != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambdgx))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambdgx);
    }
  }
  
  public void a(bdgz parambdgz)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((parambdgz == null) || (TextUtils.isEmpty(parambdgz.jdField_a_of_type_JavaLangString))) {}
    while (this.jdField_a_of_type_JavaUtilMap.containsKey(parambdgz.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(parambdgz.jdField_a_of_type_JavaLangString, parambdgz);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      ((bdgz)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = true;
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
      bdgy localbdgy = new bdgy();
      localbdgy.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bdgx)((Iterator)localObject).next()).d(localbdgy);
      }
    }
  }
  
  public void b(bdgx parambdgx)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambdgx);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bdgy localbdgy = new bdgy();
      localbdgy.jdField_a_of_type_JavaLangString = paramString1;
      localbdgy.b = paramString2;
      localbdgy.jdField_a_of_type_Int = 7;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bdgx)paramString1.next()).a(localbdgy);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bdgy localbdgy = new bdgy();
      localbdgy.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bdgx)paramDownloadInfo.next()).a(localbdgy);
      }
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bdgy localbdgy = new bdgy();
      localbdgy.a(paramDownloadInfo);
      localbdgy.jdField_a_of_type_Int = localbdgy.a(paramDownloadInfo.a());
      localbdgy.jdField_c_of_type_Int = localbdgy.b(paramInt1);
      localbdgy.jdField_c_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext()) {
        ((bdgx)paramString.next()).b(localbdgy);
      }
      if (localbdgy.jdField_c_of_type_Int == 201)
      {
        paramString = (bdgz)this.jdField_a_of_type_JavaUtilMap.get(localbdgy.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (!paramString.b)) {
          bdgk.a().a(paramDownloadInfo);
        }
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bdgy localbdgy = new bdgy();
      localbdgy.a(paramDownloadInfo);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bdgx)localIterator.next()).a(localbdgy);
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
      bdgy localbdgy = new bdgy();
      localbdgy.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bdgx)paramDownloadInfo.next()).a(localbdgy);
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
      bdgy localbdgy = new bdgy();
      localbdgy.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bdgx)((Iterator)localObject).next()).c(localbdgy);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bdgy localbdgy = new bdgy();
      localbdgy.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bdgx)paramDownloadInfo.next()).a(localbdgy);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bdgy localbdgy = new bdgy();
      localbdgy.jdField_a_of_type_JavaLangString = paramString1;
      localbdgy.b = paramString2;
      localbdgy.jdField_a_of_type_Int = 9;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bdgx)paramString1.next()).a(localbdgy);
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bdgy localbdgy = new bdgy();
      localbdgy.jdField_a_of_type_JavaLangString = paramString1;
      localbdgy.b = paramString2;
      localbdgy.jdField_a_of_type_Int = 8;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bdgx)paramString1.next()).a(localbdgy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgt
 * JD-Core Version:    0.7.0.1
 */