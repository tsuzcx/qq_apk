import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class answ
  implements baug, Manager
{
  static bauf jdField_a_of_type_Bauf = new ansx();
  anst jdField_a_of_type_Anst;
  private baue jdField_a_of_type_Baue;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<ansz> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public answ(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Baue = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Anst = new anst();
  }
  
  private String a(ansy paramansy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramansy);
    }
    String str = this.jdField_a_of_type_Anst.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramansy.jdField_a_of_type_Int).a(paramansy);
    if (!bdhb.a(str)) {}
    try
    {
      bdhb.a(this.jdField_a_of_type_Anst.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramansy.jdField_a_of_type_Int).b(paramansy), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      bdhb.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramansy + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(ansy paramansy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramansy);
    }
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_JavaLangString = paramansy.jdField_a_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.c = this.jdField_a_of_type_Anst.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramansy.jdField_a_of_type_Int).b(paramansy);
    localbaub.e = 1;
    localbaub.a(paramansy);
    localbaub.jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
    this.jdField_a_of_type_Baue.a(localbaub);
  }
  
  private boolean b(ansy paramansy)
  {
    return this.jdField_a_of_type_Anst.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramansy.jdField_a_of_type_Int).a(paramansy);
  }
  
  public void a(ansz paramansz)
  {
    if (paramansz == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramansz)) {
        this.jdField_a_of_type_JavaUtilList.add(paramansz);
      }
      return;
    }
  }
  
  public boolean a(ansy paramansy)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramansy);
    }
    Object localObject2 = this.jdField_a_of_type_Anst.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramansy.jdField_a_of_type_Int);
    if ((!TextUtils.isEmpty(paramansy.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramansy.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + paramansy);
      }
      return false;
    }
    Object localObject1;
    if (!b(paramansy))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + paramansy);
      }
      if (paramansy.jdField_a_of_type_Boolean)
      {
        localObject1 = ((ansv)localObject2).a(paramansy);
        if ((bdhb.a((String)localObject1)) && (!((ansv)localObject2).a(paramansy, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + paramansy);
          }
          bdhb.a((String)localObject1);
        }
        localObject1 = a(paramansy);
        if (new File((String)localObject1).exists()) {
          break label633;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        int j = 0;
        try
        {
          for (;;)
          {
            if (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              ansz localansz = (ansz)this.jdField_a_of_type_JavaUtilList.get(j);
              if (localansz != null) {
                localansz.a(paramansy.jdField_a_of_type_JavaLangString, paramansy.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramansy.jdField_a_of_type_JavaLangObject);
              }
              j += 1;
              continue;
              localObject1 = ((ansv)localObject2).b(paramansy);
              break;
            }
          }
          if (paramansy.jdField_a_of_type_Ansz != null) {
            paramansy.jdField_a_of_type_Ansz.a(paramansy.jdField_a_of_type_JavaLangString, paramansy.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramansy.jdField_a_of_type_JavaLangObject);
          }
          return true;
        }
        finally {}
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramansy.jdField_b_of_type_JavaLangString);
      for (;;)
      {
        try
        {
          localObject1 = (awnq)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(179);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool = ((awns)localObject1).a(paramansy.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ResDownloadManager", 2, "downloading by precover=" + bool + ", md5=" + paramansy.jdField_b_of_type_JavaLangString);
            }
            if (bool) {
              ((awns)localObject1).a(paramansy.jdField_b_of_type_JavaLangString);
            }
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ResDownloadManager", 2, "download send request ,url = " + paramansy.jdField_a_of_type_JavaLangString);
        }
        if (paramansy.jdField_a_of_type_Int == 4) {
          lvz.a(paramansy.jdField_b_of_type_JavaLangString);
        }
        localObject1 = new baub();
        ((baub)localObject1).jdField_a_of_type_Baug = this;
        ((baub)localObject1).jdField_a_of_type_JavaLangString = paramansy.jdField_a_of_type_JavaLangString;
        ((baub)localObject1).jdField_a_of_type_Int = 0;
        ((baub)localObject1).c = ((ansv)localObject2).b(paramansy);
        ((baub)localObject1).e = 1;
        ((baub)localObject1).a(paramansy);
        ((baub)localObject1).jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
        this.jdField_a_of_type_Baue.a((bave)localObject1);
        return true;
        localObject1 = ((awnq)localObject1).a();
      }
      label633:
      i = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, ansz paramansz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    ansy localansy = new ansy();
    localansy.jdField_a_of_type_Int = paramInt;
    localansy.jdField_a_of_type_JavaLangString = paramString1;
    localansy.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localansy.c = str;
    localansy.jdField_a_of_type_Boolean = paramBoolean;
    localansy.jdField_a_of_type_JavaLangObject = paramObject;
    localansy.jdField_a_of_type_Ansz = paramansz;
    if (TextUtils.isEmpty(paramString2)) {
      localansy.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localansy.jdField_b_of_type_Boolean = false;; localansy.jdField_b_of_type_Boolean = true)
    {
      return a(localansy);
      localansy.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(ansz paramansz)
  {
    if (paramansz == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramansz);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(bavf parambavf)
  {
    boolean bool1;
    baub localbaub;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    Object localObject3;
    boolean bool2;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localbaub = (baub)parambavf.jdField_a_of_type_Bave;
      localObject1 = new File(localbaub.c);
      localObject2 = localbaub.a();
      i = parambavf.jdField_b_of_type_Int;
      if (parambavf.jdField_a_of_type_JavaLangString != null) {
        break label446;
      }
      str = "0";
      j = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof ansy))) {
        break label603;
      }
      localObject2 = (ansy)localObject2;
      localObject3 = this.jdField_a_of_type_Anst.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((ansy)localObject2).jdField_a_of_type_Int);
      localObject4 = ((ansy)localObject2).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label455;
      }
      if (!((ansy)localObject2).jdField_b_of_type_Boolean) {
        break label1193;
      }
      if (((ansv)localObject3).b((ansy)localObject2)) {
        break label1188;
      }
      j = -6103066;
      ((File)localObject1).delete();
      bool1 = false;
      i = j;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 1, "onResp.md5 verify suc|" + bool1 + "|" + localObject2);
        bool2 = bool1;
        i = j;
      }
      label198:
      localObject3 = ((ansv)localObject3).a((ansy)localObject2);
      if ((!bool2) || (!((ansy)localObject2).jdField_a_of_type_Boolean)) {
        break label1179;
      }
      bdhb.a((String)localObject3);
      a((ansy)localObject2);
      localObject3 = new File((String)localObject3);
      bool2 = ((File)localObject3).exists();
      if (!bool2) {
        i = 2;
      }
      j = i;
      localObject1 = localObject3;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 2, "onResp.unCompressZipFile suc|" + bool2 + "|" + localObject2);
        bool1 = bool2;
        localObject1 = localObject3;
        j = i;
      }
      label323:
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
      }
      i = j;
      j = 0;
      label353:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp url:" + localbaub.jdField_a_of_type_JavaLangString + " result:" + parambavf.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (j == 0) {
        break label655;
      }
      label439:
      return;
      bool1 = false;
      break;
      label446:
      str = parambavf.jdField_a_of_type_JavaLangString;
      break label57;
      label455:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + parambavf.jdField_a_of_type_Int + "|errCode:" + i + "|errDesc:" + str + "|params:" + localObject2);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((ansy)localObject2).jdField_b_of_type_Int > 0)
      {
        ((ansy)localObject2).jdField_b_of_type_Int -= 1;
        a((ansy)localObject2);
        j = 1;
        break label353;
      }
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
      }
      j = 0;
      break label353;
      label603:
      ((File)localObject1).delete();
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp userdata|" + localObject2);
      }
      localObject3 = localObject1;
      localObject2 = null;
      localObject1 = null;
    }
    label655:
    Object localObject4 = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          ansz localansz = (ansz)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localansz == null) || (localObject1 == null)) {
            break label1200;
          }
          localansz.a(localbaub.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((ansy)localObject1).jdField_a_of_type_JavaLangObject);
          break label1200;
        }
        if ((localObject1 != null) && (((ansy)localObject1).jdField_a_of_type_Ansz != null)) {
          ((ansy)localObject1).jdField_a_of_type_Ansz.a(localbaub.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((ansy)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label439;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + parambavf.c);
        if ((parambavf.jdField_a_of_type_JavaUtilHashMap != null) && (parambavf.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)parambavf.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", awnw.b(((ansy)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((ansy)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((ansy)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((ansy)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((ansy)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((ansy)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((ansy)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", parambavf.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          azri.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
          return;
        }
      }
      finally {}
      localObject2 = "0";
      continue;
      label1179:
      bool1 = bool2;
      j = i;
      break label323;
      label1188:
      j = i;
      break;
      label1193:
      bool2 = bool1;
      break label198;
      label1200:
      j += 1;
    }
  }
  
  public void onUpdateProgeress(bave arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof baub))) {}
    String str1;
    do
    {
      return;
      str1 = ((baub)???).jdField_a_of_type_JavaLangString;
      ??? = ???.a();
    } while ((??? == null) || (!(??? instanceof ansy)));
    ansy localansy = (ansy)???;
    String str2 = localansy.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localansy);
    }
    if (localansy.jdField_a_of_type_Boolean) {}
    for (int i = 90;; i = 100)
    {
      if (paramLong2 > 0L) {
        i = (int)(i * paramLong1 / paramLong2);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            ansz localansz = (ansz)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localansz == null) {
              break label235;
            }
            localansz.a(str1, str2, i);
            break label235;
          }
          if (localansy.jdField_a_of_type_Ansz == null) {
            break;
          }
          localansy.jdField_a_of_type_Ansz.a(str1, str2, i);
          return;
        }
        i = 0;
        continue;
        label235:
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     answ
 * JD-Core Version:    0.7.0.1
 */