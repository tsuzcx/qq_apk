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

public class attx
  implements axrt
{
  public static axrs a;
  private attv jdField_a_of_type_Attv;
  private axrr jdField_a_of_type_Axrr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<attu> jdField_a_of_type_JavaUtilList = new Vector();
  private Map<String, axro> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  private ConcurrentHashMap<String, atua> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  
  static
  {
    jdField_a_of_type_Axrs = new atty();
  }
  
  public attx(QQAppInterface paramQQAppInterface, attv paramattv)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Attv = paramattv;
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
          boolean bool = atub.a(paramPrecoverResource.businessId, paramPrecoverResource.md5);
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
    return (this.jdField_a_of_type_Attv != null) && (this.jdField_a_of_type_Attv.a(paramPrecoverResource));
  }
  
  public atua a(String paramString)
  {
    return (atua)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(attu paramattu)
  {
    if (paramattu == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramattu)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramattu);
  }
  
  public void a(attz paramattz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "sendReqToNetEngine, task=" + paramattz + ", mNetEngine=" + this.jdField_a_of_type_Axrr);
    }
    if ((paramattz == null) || (paramattz.a == null)) {
      return;
    }
    if (this.jdField_a_of_type_Axrr == null) {
      this.jdField_a_of_type_Axrr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    }
    this.jdField_a_of_type_Axrr.a(paramattz.a);
  }
  
  public void a(String paramString)
  {
    axro localaxro = (axro)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localaxro != null)
    {
      this.jdField_a_of_type_Axrr.b(localaxro);
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
    if (this.jdField_a_of_type_Axrr == null) {
      this.jdField_a_of_type_Axrr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPrecoverResource.md5, new atua());
    Object localObject1 = new axro();
    ((axro)localObject1).jdField_a_of_type_Axrt = this;
    ((axro)localObject1).jdField_a_of_type_JavaLangString = paramPrecoverResource.url;
    ((axro)localObject1).jdField_a_of_type_Int = 0;
    if ((paramBoolean2) && (!TextUtils.isEmpty(paramPrecoverResource.thirdPartDownloadPath))) {}
    for (((axro)localObject1).c = paramPrecoverResource.thirdPartDownloadPath;; ((axro)localObject1).c = atub.a(paramPrecoverResource.businessId, paramPrecoverResource.md5))
    {
      ((axro)localObject1).e = 2;
      ((axro)localObject1).a(new Object[] { paramPrecoverResource, paramObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      ((axro)localObject1).jdField_a_of_type_Axrs = jdField_a_of_type_Axrs;
      this.jdField_a_of_type_JavaUtilMap.put(paramPrecoverResource.md5, localObject1);
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Axrr.a((axsp)localObject1);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "innerDownload, mUsePreDownScheduler==true");
    }
    int i;
    switch (this.jdField_a_of_type_Attv.a())
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      paramObject = new attz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPrecoverResource, (axro)localObject1);
      paramBoolean1 = ((axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193)).a(10064, "prd", paramPrecoverResource.md5, 0, paramPrecoverResource.url, ((axro)localObject1).c, i, 0, true, paramObject);
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
  
  public void b(attu paramattu)
  {
    if (paramattu == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramattu);
  }
  
  public void onResp(axsq paramaxsq)
  {
    int i;
    axro localaxro;
    Object localObject1;
    int j;
    Object localObject4;
    String str1;
    label56:
    Object localObject3;
    Object localObject2;
    boolean bool;
    int k;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      i = 1;
      localaxro = (axro)paramaxsq.jdField_a_of_type_Axsp;
      localObject1 = localaxro.a();
      j = paramaxsq.b;
      localObject4 = new File(localaxro.c);
      if (paramaxsq.jdField_a_of_type_JavaLangString != null) {
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
      localObject3 = attn.a(((File)localObject4).getAbsolutePath());
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
          if (this.jdField_a_of_type_Attv != null)
          {
            this.jdField_a_of_type_Attv.a((PrecoverResource)localObject1);
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
        String str2 = localaxro.jdField_a_of_type_JavaLangString;
        k = paramaxsq.jdField_a_of_type_Int;
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
          localObject3 = (axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
          localObject4 = localaxro.jdField_a_of_type_JavaLangString;
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
        ((axxj)localObject3).a((String)localObject4, l2);
        k = 0;
        while (k < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject3 = (attu)this.jdField_a_of_type_JavaUtilList.get(k);
          if (localObject3 != null) {
            ((attu)localObject3).a(i, str1, (PrecoverResource)localObject1, localObject2);
          }
          k += 1;
        }
        i = 0;
        break;
        str1 = paramaxsq.jdField_a_of_type_JavaLangString;
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
        localObject3 = new StringBuilder().append("onResp.url=").append(localaxro.jdField_a_of_type_JavaLangString).append(", result=").append(paramaxsq.jdField_a_of_type_Int).append(", errCode=").append(i).append(",md5 = ");
        if (localObject1 == null)
        {
          localObject2 = "null";
          QLog.i("PrecoverResDownloader", 1, (String)localObject2 + ", errDesc=" + str1);
        }
      }
      else if (!bool)
      {
        if (this.jdField_a_of_type_Attv != null) {
          break label813;
        }
        localObject2 = null;
        label745:
        if ((localObject2 == null) || (localObject1 == null)) {
          break label832;
        }
        if ((paramaxsq.jdField_a_of_type_JavaUtilHashMap == null) || (!paramaxsq.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason"))) {
          break label825;
        }
      }
      label813:
      label825:
      for (paramaxsq = (String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; paramaxsq = "0")
      {
        ((attw)localObject2).a((PrecoverResource)localObject1, i, str1, paramaxsq, l1);
        return;
        localObject2 = ((PrecoverResource)localObject1).md5;
        break;
        localObject2 = this.jdField_a_of_type_Attv.a();
        break label745;
      }
      label832:
      QLog.i("PrecoverResDownloader", 1, "onResp，reporter or resource is null");
      return;
      label842:
      k = j;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    Object localObject1 = null;
    if (paramaxsp == null)
    {
      QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, req is null");
      return;
    }
    paramaxsp = paramaxsp.a();
    if ((paramaxsp != null) && ((paramaxsp instanceof Object[])) && (((Object[])paramaxsp).length >= 2))
    {
      localObject1 = (Object[])paramaxsp;
      paramaxsp = (PrecoverResource)localObject1[0];
      localObject1 = localObject1[1];
    }
    for (;;)
    {
      if (paramaxsp == null)
      {
        QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, resource is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, new Object[] { "onUpdateProgeress, resource=", paramaxsp, ", userData=", localObject1, ", currOffSet=", Long.valueOf(paramLong1), ", totalLen=", Long.valueOf(paramLong2) });
      }
      atua localatua = (atua)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaxsp.md5);
      Object localObject2 = localatua;
      if (localatua == null) {
        localObject2 = new atua();
      }
      ((atua)localObject2).a = paramLong2;
      ((atua)localObject2).b = paramLong1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaxsp.md5, localObject2);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = (attu)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject2 != null) {
          ((attu)localObject2).a(paramaxsp, localObject1, paramLong1, paramLong2);
        }
        i += 1;
      }
      break;
      paramaxsp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     attx
 * JD-Core Version:    0.7.0.1
 */