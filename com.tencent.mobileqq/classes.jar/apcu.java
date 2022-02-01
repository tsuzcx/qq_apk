import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.1;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class apcu
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<apcw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public apcu(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static apco a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    apco localapco = null;
    while (localIterator.hasNext())
    {
      apcn localapcn = (apcn)((Map.Entry)localIterator.next()).getValue();
      if (!apcx.a(localapcn.jdField_b_of_type_Long))
      {
        localapco = a(paramBoolean, paramPromotionConfigInfo.mUin, localapcn);
        if (localapco != null) {
          return localapco;
        }
      }
    }
    return localapco;
  }
  
  static apco a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, apcn paramapcn)
  {
    apco localapco = a(paramBoolean, paramPromotionConfigInfo.mUin, paramapcn);
    paramapcn = localapco;
    if (localapco == null)
    {
      paramapcn = localapco;
      if (paramBoolean) {
        paramapcn = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramapcn;
  }
  
  public static apco a(boolean paramBoolean, String paramString, apcn paramapcn)
  {
    paramapcn = paramapcn.a().entrySet().iterator();
    while (paramapcn.hasNext())
    {
      apco localapco = (apco)((Map.Entry)paramapcn.next()).getValue();
      if (localapco.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(apcx.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localapco.e + "], index[" + localapco.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localapco.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(apcx.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localapco.e + "], index[" + localapco.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localapco)) {
        return localapco;
      }
    }
    return null;
  }
  
  private ArrayList<apcw> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, apco paramapco)
  {
    if ((a() == null) || (paramapco == null)) {
      a(paramString2, paramInt, -3);
    }
    do
    {
      return;
      paramString2 = a(paramAppInterface, paramapco);
    } while (paramString2 == null);
    paramapco.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (PreDownloadController)paramAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    ((PreDownloadController)localObject1).cancelPreDownload(paramapco.jdField_a_of_type_JavaLangString);
    ((PreDownloadController)localObject1).preDownloadSuccess(paramapco.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramapco.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramapco))
    {
      paramAppInterface = paramapco.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramapco.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramapco + "], zipPath[" + (String)localObject1 + "]");
        paramapco.a(2);
        paramString2.a(paramapco.jdField_a_of_type_JavaLangString, paramapco.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramapco);
        return;
      }
      finally {}
    }
    Object localObject2 = paramapco.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramapco.jdField_a_of_type_Boolean = false;
        if (paramapco.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramapco + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramapco.a(1);
      boolean bool = ((aqdg)paramAppInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD)).a(paramapco.jdField_a_of_type_JavaLangString, paramapco.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramapco, paramapco.jdField_a_of_type_Aqdj);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramapco + "]");
      if (!bool) {
        paramString2.a(paramapco.jdField_a_of_type_JavaLangString, paramapco.jdField_b_of_type_JavaLangString, -4, null, paramapco);
      }
    }
  }
  
  static boolean a(apco paramapco)
  {
    if (paramapco.jdField_a_of_type_Int == 0)
    {
      String str = apct.a(paramapco);
      if (!new File(str + "entry.png").exists()) {
        if (QLog.isDevelopLevel()) {
          QLog.w("PromotionResDownload", 1, "文件不存在, path[" + str + "], name[" + "entry.png" + "]");
        }
      }
      do
      {
        do
        {
          return false;
          if (new File(str + "entry.json").exists()) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.w("PromotionResDownload", 1, "文件不存在, path[" + str + "], name[" + "entry.json" + "]");
        return false;
        paramapco = apct.b(paramapco);
        if (new File(paramapco + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramapco + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramapco.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, apco paramapco)
  {
    String str = paramapco.d;
    if (bhjo.a(paramString, paramapco.e, paramapco.jdField_a_of_type_Int, paramapco.jdField_b_of_type_JavaLangString, str)) {
      return a(paramapco);
    }
    return false;
  }
  
  /* Error */
  aqdj a(AppInterface paramAppInterface, apco paramapco)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 228	apco:jdField_a_of_type_Aqdj	Laqdj;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 228	apco:jdField_a_of_type_Aqdj	Laqdj;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	apco:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 275	apcv
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	apco:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 278	apcv:<init>	(Lapcu;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 228	apco:jdField_a_of_type_Aqdj	Laqdj;
    //   41: aload_2
    //   42: getfield 228	apco:jdField_a_of_type_Aqdj	Laqdj;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	apcu
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramapco	apco
    //   22	13	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   18	46	49	finally
  }
  
  PromotionConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  }
  
  public void a(apcw paramapcw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramapcw);
      return;
    }
  }
  
  void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, ConfigInfo为空, callByPreDownload[" + paramBoolean + "], activatyid[" + paramString + "], index[" + paramInt + "]");
    }
    do
    {
      Object localObject2;
      for (;;)
      {
        return;
        if (!(paramAppInterface instanceof QQAppInterface))
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 不在主进程");
          return;
        }
        localObject2 = ((PromotionConfigInfo)localObject1).getItem(paramString);
        if (localObject2 == null)
        {
          a(paramString, paramInt, -3);
          return;
        }
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (apcn)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((apcn)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((apco)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((apco)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((apco)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new RunnableTask((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (apco)localObject1), 0L);
        paramBoolean = ((PreDownloadController)paramAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).requestPreDownload(10074, "prd", paramString, 0, ((apco)localObject1).jdField_a_of_type_JavaLangString, ((apco)localObject1).jdField_c_of_type_JavaLangString, ((apco)localObject1).jdField_b_of_type_Int, 0, true, (AbsPreDownloadTask)localObject2);
        ((apco)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((apco)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.f());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((apco)localObject1).e + "], index[" + ((apco)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(anvx.a(2131707975), paramBoolean, paramAppInterface, ((apco)localObject1).e, ((apco)localObject1).jdField_a_of_type_Int, (apco)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    if (paramPromotionConfigInfo != null)
    {
      paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
      while (paramPromotionConfigInfo.hasNext())
      {
        Iterator localIterator = ((apcn)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
        while (localIterator.hasNext()) {
          ((apco)((Map.Entry)localIterator.next()).getValue()).a();
        }
      }
    }
  }
  
  void a(String paramString, int paramInt1, int paramInt2)
  {
    b(paramString, paramInt1, paramInt2);
    BusinessCommonConfig.sendDownloadResultNotify(2, paramString, paramInt1, paramInt2);
  }
  
  void b()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((apcw)localIterator.next()).a();
    }
  }
  
  public void b(apcw paramapcw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramapcw);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((apcw)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcu
 * JD-Core Version:    0.7.0.1
 */