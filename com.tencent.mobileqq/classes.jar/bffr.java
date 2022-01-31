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

public class bffr
  implements bffl
{
  private ArrayList<bffv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, bffx> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
  
  public void a(bffv parambffv)
  {
    if ((parambffv != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambffv))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambffv);
    }
  }
  
  public void a(bffx parambffx)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((parambffx == null) || (TextUtils.isEmpty(parambffx.jdField_a_of_type_JavaLangString))) {}
    while (this.jdField_a_of_type_JavaUtilMap.containsKey(parambffx.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(parambffx.jdField_a_of_type_JavaLangString, parambffx);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      ((bffx)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = true;
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
      bffw localbffw = new bffw();
      localbffw.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bffv)((Iterator)localObject).next()).d(localbffw);
      }
    }
  }
  
  public void b(bffv parambffv)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambffv);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bffw localbffw = new bffw();
      localbffw.jdField_a_of_type_JavaLangString = paramString1;
      localbffw.b = paramString2;
      localbffw.jdField_a_of_type_Int = 7;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bffv)paramString1.next()).a(localbffw);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bffw localbffw = new bffw();
      localbffw.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bffv)paramDownloadInfo.next()).a(localbffw);
      }
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bffw localbffw = new bffw();
      localbffw.a(paramDownloadInfo);
      localbffw.jdField_a_of_type_Int = localbffw.a(paramDownloadInfo.a());
      localbffw.jdField_c_of_type_Int = localbffw.b(paramInt1);
      localbffw.jdField_c_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext()) {
        ((bffv)paramString.next()).b(localbffw);
      }
      if (localbffw.jdField_c_of_type_Int == 201)
      {
        paramString = (bffx)this.jdField_a_of_type_JavaUtilMap.get(localbffw.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (!paramString.b)) {
          bffi.a().a(paramDownloadInfo);
        }
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bffw localbffw = new bffw();
      localbffw.a(paramDownloadInfo);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bffv)localIterator.next()).a(localbffw);
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
      bffw localbffw = new bffw();
      localbffw.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bffv)paramDownloadInfo.next()).a(localbffw);
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
      bffw localbffw = new bffw();
      localbffw.a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bffv)((Iterator)localObject).next()).c(localbffw);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      bffw localbffw = new bffw();
      localbffw.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((bffv)paramDownloadInfo.next()).a(localbffw);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bffw localbffw = new bffw();
      localbffw.jdField_a_of_type_JavaLangString = paramString1;
      localbffw.b = paramString2;
      localbffw.jdField_a_of_type_Int = 9;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bffv)paramString1.next()).a(localbffw);
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bffw localbffw = new bffw();
      localbffw.jdField_a_of_type_JavaLangString = paramString1;
      localbffw.b = paramString2;
      localbffw.jdField_a_of_type_Int = 8;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((bffv)paramString1.next()).a(localbffw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffr
 * JD-Core Version:    0.7.0.1
 */