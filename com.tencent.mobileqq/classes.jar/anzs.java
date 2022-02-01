import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class anzs
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<anzu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public anzs(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static anzm a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    anzm localanzm = null;
    while (localIterator.hasNext())
    {
      anzl localanzl = (anzl)((Map.Entry)localIterator.next()).getValue();
      if (!anzv.a(localanzl.jdField_b_of_type_Long))
      {
        localanzm = a(paramBoolean, paramPromotionConfigInfo.mUin, localanzl);
        if (localanzm != null) {
          return localanzm;
        }
      }
    }
    return localanzm;
  }
  
  static anzm a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, anzl paramanzl)
  {
    anzm localanzm = a(paramBoolean, paramPromotionConfigInfo.mUin, paramanzl);
    paramanzl = localanzm;
    if (localanzm == null)
    {
      paramanzl = localanzm;
      if (paramBoolean) {
        paramanzl = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramanzl;
  }
  
  public static anzm a(boolean paramBoolean, String paramString, anzl paramanzl)
  {
    paramanzl = paramanzl.a().entrySet().iterator();
    while (paramanzl.hasNext())
    {
      anzm localanzm = (anzm)((Map.Entry)paramanzl.next()).getValue();
      if (localanzm.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(anzv.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localanzm.e + "], index[" + localanzm.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localanzm.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(anzv.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localanzm.e + "], index[" + localanzm.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localanzm)) {
        return localanzm;
      }
    }
    return null;
  }
  
  private ArrayList<anzu> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, anzm paramanzm)
  {
    if ((a() == null) || (paramanzm == null))
    {
      a(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramanzm);
    paramanzm.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (PreDownloadController)paramAppInterface.getManager(193);
    ((PreDownloadController)localObject1).cancelPreDownload(paramanzm.jdField_a_of_type_JavaLangString);
    ((PreDownloadController)localObject1).preDownloadSuccess(paramanzm.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramanzm.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramanzm))
    {
      paramAppInterface = paramanzm.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramanzm.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramanzm + "], zipPath[" + (String)localObject1 + "]");
        paramanzm.a(2);
        paramString2.a(paramanzm.jdField_a_of_type_JavaLangString, paramanzm.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramanzm);
        return;
      }
      finally {}
    }
    Object localObject2 = paramanzm.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramanzm.jdField_a_of_type_Boolean = false;
        if (paramanzm.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramanzm + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramanzm.a(1);
      boolean bool = ((apac)paramAppInterface.getManager(191)).a(paramanzm.jdField_a_of_type_JavaLangString, paramanzm.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramanzm, paramanzm.jdField_a_of_type_Apaf);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramanzm + "]");
      if (!bool) {
        paramString2.a(paramanzm.jdField_a_of_type_JavaLangString, paramanzm.jdField_b_of_type_JavaLangString, -4, null, paramanzm);
      }
    }
  }
  
  static boolean a(anzm paramanzm)
  {
    if (paramanzm.jdField_a_of_type_Int == 0)
    {
      String str = anzr.a(paramanzm);
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
        paramanzm = anzr.b(paramanzm);
        if (new File(paramanzm + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramanzm + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramanzm.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, anzm paramanzm)
  {
    String str = paramanzm.d;
    if (bgax.a(paramString, paramanzm.e, paramanzm.jdField_a_of_type_Int, paramanzm.jdField_b_of_type_JavaLangString, str)) {
      return a(paramanzm);
    }
    return false;
  }
  
  /* Error */
  apaf a(AppInterface paramAppInterface, anzm paramanzm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 220	anzm:jdField_a_of_type_Apaf	Lapaf;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 220	anzm:jdField_a_of_type_Apaf	Lapaf;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	anzm:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 267	anzt
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	anzm:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 270	anzt:<init>	(Lanzs;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 220	anzm:jdField_a_of_type_Apaf	Lapaf;
    //   41: aload_2
    //   42: getfield 220	anzm:jdField_a_of_type_Apaf	Lapaf;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	anzs
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramanzm	anzm
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
  
  public void a(anzu paramanzu)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramanzu);
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
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (anzl)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((anzl)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((anzm)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((anzm)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((anzm)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new RunnableTask((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (anzm)localObject1), 0L);
        paramBoolean = ((PreDownloadController)paramAppInterface.getManager(193)).requestPreDownload(10074, "prd", paramString, 0, ((anzm)localObject1).jdField_a_of_type_JavaLangString, ((anzm)localObject1).jdField_c_of_type_JavaLangString, ((anzm)localObject1).jdField_b_of_type_Int, 0, true, (AbsPreDownloadTask)localObject2);
        ((anzm)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((anzm)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.f());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((anzm)localObject1).e + "], index[" + ((anzm)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(amtj.a(2131707628), paramBoolean, paramAppInterface, ((anzm)localObject1).e, ((anzm)localObject1).jdField_a_of_type_Int, (anzm)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    if (paramPromotionConfigInfo != null)
    {
      paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
      while (paramPromotionConfigInfo.hasNext())
      {
        Iterator localIterator = ((anzl)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
        while (localIterator.hasNext()) {
          ((anzm)((Map.Entry)localIterator.next()).getValue()).a();
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
      ((anzu)localIterator.next()).a();
    }
  }
  
  public void b(anzu paramanzu)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramanzu);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((anzu)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzs
 * JD-Core Version:    0.7.0.1
 */