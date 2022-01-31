import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class awjj
  implements bapx
{
  public static bapw a;
  private awjh jdField_a_of_type_Awjh;
  private bapv jdField_a_of_type_Bapv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<awjg> jdField_a_of_type_JavaUtilList = new Vector();
  private Map<String, baps> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  private ConcurrentHashMap<String, awjm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  
  static
  {
    jdField_a_of_type_Bapw = new awjk();
  }
  
  public awjj(QQAppInterface paramQQAppInterface, awjh paramawjh)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Awjh = paramawjh;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(PrecoverResource paramPrecoverResource)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramPrecoverResource == null)
      {
        localObject = "null";
        QLog.d("PrecoverResDownloader", 2, new Object[] { "isNeedDownload, resource=", localObject });
      }
    }
    else
    {
      if (paramPrecoverResource != null) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, "isNeedDownload, resource == null");
      }
    }
    for (;;)
    {
      return false;
      localObject = paramPrecoverResource;
      break;
      label57:
      if (TextUtils.isEmpty(paramPrecoverResource.businessId))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, businessId is empty");
          return false;
        }
      }
      else if (TextUtils.isEmpty(paramPrecoverResource.md5))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, md5 is empty");
          return false;
        }
      }
      else if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramPrecoverResource.md5))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, md5 is in set");
          return false;
        }
      }
      else {
        try
        {
          boolean bool = awjn.a(paramPrecoverResource.businessId, paramPrecoverResource.md5);
          QLog.i("PrecoverResDownloader", 1, "isNeedDownload. file exist=" + bool + ", md5=" + paramPrecoverResource.md5 + ", businessid=" + paramPrecoverResource.businessId + ", resId=" + paramPrecoverResource.resId);
          if (!bool) {}
          for (bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Throwable localThrowable)
        {
          QLog.i("PrecoverResDownloader", 1, "isNeedDownload.exception happen.e=" + localThrowable.getMessage() + ", md5=" + paramPrecoverResource.md5 + ", businessid=" + paramPrecoverResource.businessId + ", resId=" + paramPrecoverResource.resId);
        }
      }
    }
    localThrowable.printStackTrace();
    return false;
  }
  
  private boolean b(PrecoverResource paramPrecoverResource)
  {
    return (this.jdField_a_of_type_Awjh != null) && (this.jdField_a_of_type_Awjh.a(paramPrecoverResource));
  }
  
  public awjm a(String paramString)
  {
    return (awjm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(awjg paramawjg)
  {
    if (paramawjg == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramawjg)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramawjg);
  }
  
  public void a(awjl paramawjl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "sendReqToNetEngine, task=" + paramawjl + ", mNetEngine=" + this.jdField_a_of_type_Bapv);
    }
    if ((paramawjl == null) || (paramawjl.a == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bapv == null) {
      this.jdField_a_of_type_Bapv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    }
    this.jdField_a_of_type_Bapv.a(paramawjl.a);
  }
  
  public void a(String paramString)
  {
    baps localbaps = (baps)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbaps != null)
    {
      this.jdField_a_of_type_Bapv.b(localbaps);
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  public boolean a(PrecoverResource paramPrecoverResource, Object paramObject)
  {
    return a(paramPrecoverResource, paramObject, false, false);
  }
  
  public boolean a(PrecoverResource paramPrecoverResource, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      if (paramPrecoverResource != null) {
        break label79;
      }
      localObject1 = "null";
      if (paramObject != null) {
        break label85;
      }
    }
    label79:
    label85:
    for (Object localObject2 = "null";; localObject2 = paramObject)
    {
      QLog.d("PrecoverResDownloader", 2, new Object[] { "resource=", localObject1, ", userData=", localObject2, ", checkControl=", Boolean.valueOf(paramBoolean1) });
      if (paramPrecoverResource != null) {
        break label91;
      }
      QLog.d("PrecoverResDownloader", 1, "download, resource is null");
      return false;
      localObject1 = paramPrecoverResource;
      break;
    }
    label91:
    if (!paramPrecoverResource.isValid())
    {
      QLog.d("PrecoverResDownloader", 1, "download, resource.isValid() return false");
      return false;
    }
    if (!a(paramPrecoverResource))
    {
      QLog.d("PrecoverResDownloader", 1, "download, isNeedDownload() return false");
      return false;
    }
    if ((paramBoolean1) && (!b(paramPrecoverResource)))
    {
      QLog.d("PrecoverResDownloader", 1, "download, canDownload() return false");
      return false;
    }
    if (this.jdField_a_of_type_Bapv == null) {
      this.jdField_a_of_type_Bapv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPrecoverResource.md5, new awjm());
    Object localObject1 = new baps();
    ((baps)localObject1).jdField_a_of_type_Bapx = this;
    ((baps)localObject1).jdField_a_of_type_JavaLangString = paramPrecoverResource.url;
    ((baps)localObject1).jdField_a_of_type_Int = 0;
    if ((paramBoolean2) && (!TextUtils.isEmpty(paramPrecoverResource.thirdPartDownloadPath))) {}
    for (((baps)localObject1).c = paramPrecoverResource.thirdPartDownloadPath;; ((baps)localObject1).c = awjn.a(paramPrecoverResource.businessId, paramPrecoverResource.md5))
    {
      ((baps)localObject1).e = 2;
      ((baps)localObject1).a(new Object[] { paramPrecoverResource, paramObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      ((baps)localObject1).jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
      this.jdField_a_of_type_JavaUtilMap.put(paramPrecoverResource.md5, localObject1);
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Bapv.a((baqv)localObject1);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "innerDownload, mUsePreDownScheduler==true");
    }
    int i;
    switch (this.jdField_a_of_type_Awjh.a())
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      paramObject = new awjl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPrecoverResource, (baps)localObject1);
      paramBoolean1 = ((bavr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193)).a(10064, "prd", paramPrecoverResource.md5, 0, paramPrecoverResource.url, ((baps)localObject1).c, i, 0, true, paramObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PrecoverResDownloader", 2, "innerDownload, PreDownloadController.ret=" + paramBoolean1);
      break;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void b(awjg paramawjg)
  {
    if (paramawjg == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramawjg);
  }
  
  public void onResp(baqw parambaqw)
  {
    int i;
    baps localbaps;
    Object localObject1;
    int j;
    Object localObject4;
    String str1;
    label56:
    Object localObject3;
    Object localObject2;
    boolean bool;
    int k;
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      i = 1;
      localbaps = (baps)parambaqw.jdField_a_of_type_Baqv;
      localObject1 = localbaps.a();
      j = parambaqw.b;
      localObject4 = new File(localbaps.c);
      if (parambaqw.jdField_a_of_type_JavaLangString != null) {
        break label535;
      }
      str1 = "0";
      if ((localObject1 == null) || (!(localObject1 instanceof Object[])) || (((Object[])localObject1).length < 4)) {
        break label569;
      }
      localObject3 = (Object[])localObject1;
      localObject1 = (PrecoverResource)localObject3[0];
      localObject2 = localObject3[1];
      bool = ((Boolean)localObject3[3]).booleanValue();
      if (i == 0) {
        break label544;
      }
      localObject3 = awiz.a(((File)localObject4).getAbsolutePath());
      if (((PrecoverResource)localObject1).md5.equalsIgnoreCase((String)localObject3)) {
        break label842;
      }
      k = -6103066;
      ((File)localObject4).delete();
      i = 0;
      QLog.i("PrecoverResDownloader", 1, "onResp.md5 verify fail.md5=" + ((PrecoverResource)localObject1).md5 + ",calMD5=" + (String)localObject3);
    }
    for (;;)
    {
      j = k;
      int m = i;
      if (i != 0)
      {
        j = k;
        m = i;
        if (!bool)
        {
          j = k;
          m = i;
          if (this.jdField_a_of_type_Awjh != null)
          {
            this.jdField_a_of_type_Awjh.a((PrecoverResource)localObject1);
            m = i;
            j = k;
          }
        }
      }
      label249:
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(((PrecoverResource)localObject1).md5)) {
        this.jdField_a_of_type_JavaUtilMap.remove(((PrecoverResource)localObject1).md5);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((PrecoverResource)localObject1).md5)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PrecoverResource)localObject1).md5);
      }
      i = j;
      j = m;
      label314:
      label342:
      long l1;
      if (QLog.isColorLevel())
      {
        String str2 = localbaps.jdField_a_of_type_JavaLangString;
        k = parambaqw.jdField_a_of_type_Int;
        if (localObject1 == null)
        {
          localObject3 = "null";
          QLog.d("PrecoverResDownloader", 2, new Object[] { "onResp.url=", str2, ", result=", Integer.valueOf(k), ", errCode=", Integer.valueOf(i), ", resource=", localObject3 });
        }
      }
      else
      {
        if ((j == 0) || (!((File)localObject4).exists())) {
          break label624;
        }
        l1 = ((File)localObject4).length();
        label423:
        if (this.jdField_a_of_type_Boolean)
        {
          localObject3 = (bavr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
          localObject4 = localbaps.jdField_a_of_type_JavaLangString;
          if (j == 0) {
            break label630;
          }
        }
      }
      label535:
      label544:
      label569:
      label624:
      label630:
      for (long l2 = l1;; l2 = -1L)
      {
        ((bavr)localObject3).a((String)localObject4, l2);
        k = 0;
        while (k < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject3 = (awjg)this.jdField_a_of_type_JavaUtilList.get(k);
          if (localObject3 != null) {
            ((awjg)localObject3).a(i, str1, (PrecoverResource)localObject1, localObject2);
          }
          k += 1;
        }
        i = 0;
        break;
        str1 = parambaqw.jdField_a_of_type_JavaLangString;
        break label56;
        if ((localObject4 != null) && (((File)localObject4).exists())) {
          ((File)localObject4).delete();
        }
        m = i;
        break label249;
        if ((localObject4 != null) && (((File)localObject4).exists())) {
          ((File)localObject4).delete();
        }
        QLog.i("PrecoverResDownloader", 1, "onResp objects == null || objects not instanceof Object[] || ((Object[]) objects).length < 3");
        localObject1 = null;
        k = i;
        i = j;
        localObject2 = null;
        bool = false;
        j = k;
        break label314;
        localObject3 = localObject1;
        break label342;
        l1 = 0L;
        break label423;
      }
      if (j == 0)
      {
        localObject3 = new StringBuilder().append("onResp.url=").append(localbaps.jdField_a_of_type_JavaLangString).append(", result=").append(parambaqw.jdField_a_of_type_Int).append(", errCode=").append(i).append(",md5 = ");
        if (localObject1 == null)
        {
          localObject2 = "null";
          QLog.i("PrecoverResDownloader", 1, (String)localObject2 + ", errDesc=" + str1);
        }
      }
      else if (!bool)
      {
        if (this.jdField_a_of_type_Awjh != null) {
          break label813;
        }
        localObject2 = null;
        label745:
        if ((localObject2 == null) || (localObject1 == null)) {
          break label832;
        }
        if ((parambaqw.jdField_a_of_type_JavaUtilHashMap == null) || (!parambaqw.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason"))) {
          break label825;
        }
      }
      label813:
      label825:
      for (parambaqw = (String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; parambaqw = "0")
      {
        ((awji)localObject2).a((PrecoverResource)localObject1, i, str1, parambaqw, l1);
        return;
        localObject2 = ((PrecoverResource)localObject1).md5;
        break;
        localObject2 = this.jdField_a_of_type_Awjh.a();
        break label745;
      }
      label832:
      QLog.i("PrecoverResDownloader", 1, "onResp，reporter or resource is null");
      return;
      label842:
      k = j;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    Object localObject1 = null;
    if (parambaqv == null)
    {
      QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, req is null");
      return;
    }
    parambaqv = parambaqv.a();
    if ((parambaqv != null) && ((parambaqv instanceof Object[])) && (((Object[])parambaqv).length >= 2))
    {
      localObject1 = (Object[])parambaqv;
      parambaqv = (PrecoverResource)localObject1[0];
      localObject1 = localObject1[1];
    }
    for (;;)
    {
      if (parambaqv == null)
      {
        QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, resource is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, new Object[] { "onUpdateProgeress, resource=", parambaqv, ", userData=", localObject1, ", currOffSet=", Long.valueOf(paramLong1), ", totalLen=", Long.valueOf(paramLong2) });
      }
      awjm localawjm = (awjm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambaqv.md5);
      Object localObject2 = localawjm;
      if (localawjm == null) {
        localObject2 = new awjm();
      }
      ((awjm)localObject2).a = paramLong2;
      ((awjm)localObject2).b = paramLong1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(parambaqv.md5, localObject2);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = (awjg)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject2 != null) {
          ((awjg)localObject2).a(parambaqv, localObject1, paramLong1, paramLong2);
        }
        i += 1;
      }
      break;
      parambaqv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjj
 * JD-Core Version:    0.7.0.1
 */