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

public class anon
  implements bapx, Manager
{
  static bapw jdField_a_of_type_Bapw = new anoo();
  anok jdField_a_of_type_Anok;
  private bapv jdField_a_of_type_Bapv;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<anoq> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public anon(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bapv = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Anok = new anok();
  }
  
  private String a(anop paramanop)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramanop);
    }
    String str = this.jdField_a_of_type_Anok.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramanop.jdField_a_of_type_Int).a(paramanop);
    if (!bdcs.a(str)) {}
    try
    {
      bdcs.a(this.jdField_a_of_type_Anok.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramanop.jdField_a_of_type_Int).b(paramanop), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      bdcs.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramanop + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(anop paramanop)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramanop);
    }
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = this;
    localbaps.jdField_a_of_type_JavaLangString = paramanop.jdField_a_of_type_JavaLangString;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.c = this.jdField_a_of_type_Anok.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramanop.jdField_a_of_type_Int).b(paramanop);
    localbaps.e = 1;
    localbaps.a(paramanop);
    localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
    this.jdField_a_of_type_Bapv.a(localbaps);
  }
  
  private boolean b(anop paramanop)
  {
    return this.jdField_a_of_type_Anok.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramanop.jdField_a_of_type_Int).a(paramanop);
  }
  
  public void a(anoq paramanoq)
  {
    if (paramanoq == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramanoq)) {
        this.jdField_a_of_type_JavaUtilList.add(paramanoq);
      }
      return;
    }
  }
  
  public boolean a(anop paramanop)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramanop);
    }
    Object localObject2 = this.jdField_a_of_type_Anok.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramanop.jdField_a_of_type_Int);
    if ((!TextUtils.isEmpty(paramanop.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramanop.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + paramanop);
      }
      return false;
    }
    Object localObject1;
    if (!b(paramanop))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + paramanop);
      }
      if (paramanop.jdField_a_of_type_Boolean)
      {
        localObject1 = ((anom)localObject2).a(paramanop);
        if ((bdcs.a((String)localObject1)) && (!((anom)localObject2).a(paramanop, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + paramanop);
          }
          bdcs.a((String)localObject1);
        }
        localObject1 = a(paramanop);
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
              anoq localanoq = (anoq)this.jdField_a_of_type_JavaUtilList.get(j);
              if (localanoq != null) {
                localanoq.a(paramanop.jdField_a_of_type_JavaLangString, paramanop.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramanop.jdField_a_of_type_JavaLangObject);
              }
              j += 1;
              continue;
              localObject1 = ((anom)localObject2).b(paramanop);
              break;
            }
          }
          if (paramanop.jdField_a_of_type_Anoq != null) {
            paramanop.jdField_a_of_type_Anoq.a(paramanop.jdField_a_of_type_JavaLangString, paramanop.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramanop.jdField_a_of_type_JavaLangObject);
          }
          return true;
        }
        finally {}
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramanop.jdField_b_of_type_JavaLangString);
      for (;;)
      {
        try
        {
          localObject1 = (awjh)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(179);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool = ((awjj)localObject1).a(paramanop.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ResDownloadManager", 2, "downloading by precover=" + bool + ", md5=" + paramanop.jdField_b_of_type_JavaLangString);
            }
            if (bool) {
              ((awjj)localObject1).a(paramanop.jdField_b_of_type_JavaLangString);
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
          QLog.i("ResDownloadManager", 2, "download send request ,url = " + paramanop.jdField_a_of_type_JavaLangString);
        }
        if (paramanop.jdField_a_of_type_Int == 4) {
          lvz.a(paramanop.jdField_b_of_type_JavaLangString);
        }
        localObject1 = new baps();
        ((baps)localObject1).jdField_a_of_type_Bapx = this;
        ((baps)localObject1).jdField_a_of_type_JavaLangString = paramanop.jdField_a_of_type_JavaLangString;
        ((baps)localObject1).jdField_a_of_type_Int = 0;
        ((baps)localObject1).c = ((anom)localObject2).b(paramanop);
        ((baps)localObject1).e = 1;
        ((baps)localObject1).a(paramanop);
        ((baps)localObject1).jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
        this.jdField_a_of_type_Bapv.a((baqv)localObject1);
        return true;
        localObject1 = ((awjh)localObject1).a();
      }
      label633:
      i = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, anoq paramanoq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    anop localanop = new anop();
    localanop.jdField_a_of_type_Int = paramInt;
    localanop.jdField_a_of_type_JavaLangString = paramString1;
    localanop.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localanop.c = str;
    localanop.jdField_a_of_type_Boolean = paramBoolean;
    localanop.jdField_a_of_type_JavaLangObject = paramObject;
    localanop.jdField_a_of_type_Anoq = paramanoq;
    if (TextUtils.isEmpty(paramString2)) {
      localanop.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localanop.jdField_b_of_type_Boolean = false;; localanop.jdField_b_of_type_Boolean = true)
    {
      return a(localanop);
      localanop.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(anoq paramanoq)
  {
    if (paramanoq == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramanoq);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(baqw parambaqw)
  {
    boolean bool1;
    baps localbaps;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    Object localObject3;
    boolean bool2;
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localbaps = (baps)parambaqw.jdField_a_of_type_Baqv;
      localObject1 = new File(localbaps.c);
      localObject2 = localbaps.a();
      i = parambaqw.jdField_b_of_type_Int;
      if (parambaqw.jdField_a_of_type_JavaLangString != null) {
        break label446;
      }
      str = "0";
      j = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof anop))) {
        break label603;
      }
      localObject2 = (anop)localObject2;
      localObject3 = this.jdField_a_of_type_Anok.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((anop)localObject2).jdField_a_of_type_Int);
      localObject4 = ((anop)localObject2).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label455;
      }
      if (!((anop)localObject2).jdField_b_of_type_Boolean) {
        break label1193;
      }
      if (((anom)localObject3).b((anop)localObject2)) {
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
      localObject3 = ((anom)localObject3).a((anop)localObject2);
      if ((!bool2) || (!((anop)localObject2).jdField_a_of_type_Boolean)) {
        break label1179;
      }
      bdcs.a((String)localObject3);
      a((anop)localObject2);
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
        QLog.i("ResDownloadManager", 2, "onResp url:" + localbaps.jdField_a_of_type_JavaLangString + " result:" + parambaqw.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (j == 0) {
        break label655;
      }
      label439:
      return;
      bool1 = false;
      break;
      label446:
      str = parambaqw.jdField_a_of_type_JavaLangString;
      break label57;
      label455:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + parambaqw.jdField_a_of_type_Int + "|errCode:" + i + "|errDesc:" + str + "|params:" + localObject2);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((anop)localObject2).jdField_b_of_type_Int > 0)
      {
        ((anop)localObject2).jdField_b_of_type_Int -= 1;
        a((anop)localObject2);
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
          anoq localanoq = (anoq)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localanoq == null) || (localObject1 == null)) {
            break label1200;
          }
          localanoq.a(localbaps.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((anop)localObject1).jdField_a_of_type_JavaLangObject);
          break label1200;
        }
        if ((localObject1 != null) && (((anop)localObject1).jdField_a_of_type_Anoq != null)) {
          ((anop)localObject1).jdField_a_of_type_Anoq.a(localbaps.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((anop)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label439;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + parambaqw.c);
        if ((parambaqw.jdField_a_of_type_JavaUtilHashMap != null) && (parambaqw.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", awjn.b(((anop)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((anop)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((anop)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((anop)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((anop)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((anop)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((anop)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", parambaqw.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          azmz.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
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
  
  public void onUpdateProgeress(baqv arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof baps))) {}
    String str1;
    do
    {
      return;
      str1 = ((baps)???).jdField_a_of_type_JavaLangString;
      ??? = ???.a();
    } while ((??? == null) || (!(??? instanceof anop)));
    anop localanop = (anop)???;
    String str2 = localanop.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localanop);
    }
    if (localanop.jdField_a_of_type_Boolean) {}
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
            anoq localanoq = (anoq)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localanoq == null) {
              break label235;
            }
            localanoq.a(str1, str2, i);
            break label235;
          }
          if (localanop.jdField_a_of_type_Anoq == null) {
            break;
          }
          localanop.jdField_a_of_type_Anoq.a(str1, str2, i);
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
 * Qualified Name:     anon
 * JD-Core Version:    0.7.0.1
 */