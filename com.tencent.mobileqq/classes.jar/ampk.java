import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.1;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ampk
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<ampm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ampk(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static ampe a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    ampe localampe = null;
    while (localIterator.hasNext())
    {
      ampd localampd = (ampd)((Map.Entry)localIterator.next()).getValue();
      if (!ampn.a(localampd.jdField_b_of_type_Long))
      {
        localampe = a(paramBoolean, paramPromotionConfigInfo.mUin, localampd);
        if (localampe != null) {
          return localampe;
        }
      }
    }
    return localampe;
  }
  
  static ampe a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, ampd paramampd)
  {
    ampe localampe = a(paramBoolean, paramPromotionConfigInfo.mUin, paramampd);
    paramampd = localampe;
    if (localampe == null)
    {
      paramampd = localampe;
      if (paramBoolean) {
        paramampd = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramampd;
  }
  
  public static ampe a(boolean paramBoolean, String paramString, ampd paramampd)
  {
    paramampd = paramampd.a().entrySet().iterator();
    while (paramampd.hasNext())
    {
      ampe localampe = (ampe)((Map.Entry)paramampd.next()).getValue();
      if (localampe.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(ampn.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localampe.e + "], index[" + localampe.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localampe.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(ampn.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localampe.e + "], index[" + localampe.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localampe)) {
        return localampe;
      }
    }
    return null;
  }
  
  private ArrayList<ampm> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, ampe paramampe)
  {
    if ((a() == null) || (paramampe == null))
    {
      a(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramampe);
    paramampe.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (bavr)paramAppInterface.getManager(193);
    ((bavr)localObject1).a(paramampe.jdField_a_of_type_JavaLangString);
    ((bavr)localObject1).a(paramampe.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramampe.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramampe))
    {
      paramAppInterface = paramampe.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramampe.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramampe + "], zipPath[" + (String)localObject1 + "]");
        paramampe.a(2);
        paramString2.a(paramampe.jdField_a_of_type_JavaLangString, paramampe.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramampe);
        return;
      }
      finally {}
    }
    Object localObject2 = paramampe.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramampe.jdField_a_of_type_Boolean = false;
        if (paramampe.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramampe + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramampe.a(1);
      boolean bool = ((anon)paramAppInterface.getManager(191)).a(paramampe.jdField_a_of_type_JavaLangString, paramampe.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramampe, paramampe.jdField_a_of_type_Anoq);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramampe + "]");
      if (!bool) {
        paramString2.a(paramampe.jdField_a_of_type_JavaLangString, paramampe.jdField_b_of_type_JavaLangString, -4, null, paramampe);
      }
    }
  }
  
  static boolean a(ampe paramampe)
  {
    if (paramampe.jdField_a_of_type_Int == 0)
    {
      String str = ampj.a(paramampe);
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
        paramampe = ampj.b(paramampe);
        if (new File(paramampe + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramampe + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramampe.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, ampe paramampe)
  {
    String str = paramampe.d;
    if (bdkx.a(paramString, paramampe.e, paramampe.jdField_a_of_type_Int, paramampe.jdField_b_of_type_JavaLangString, str)) {
      return a(paramampe);
    }
    return false;
  }
  
  /* Error */
  anoq a(AppInterface paramAppInterface, ampe paramampe)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 218	ampe:jdField_a_of_type_Anoq	Lanoq;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 218	ampe:jdField_a_of_type_Anoq	Lanoq;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	ampe:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 265	ampl
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	ampe:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 268	ampl:<init>	(Lampk;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 218	ampe:jdField_a_of_type_Anoq	Lanoq;
    //   41: aload_2
    //   42: getfield 218	ampe:jdField_a_of_type_Anoq	Lanoq;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ampk
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramampe	ampe
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
  
  public void a(ampm paramampm)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramampm);
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
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (ampd)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((ampd)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((ampe)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((ampe)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((ampe)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new bavs((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (ampe)localObject1), 0L);
        paramBoolean = ((bavr)paramAppInterface.getManager(193)).a(10074, "prd", paramString, 0, ((ampe)localObject1).jdField_a_of_type_JavaLangString, ((ampe)localObject1).jdField_c_of_type_JavaLangString, ((ampe)localObject1).jdField_b_of_type_Int, 0, true, (bavo)localObject2);
        ((ampe)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((ampe)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.e());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((ampe)localObject1).e + "], index[" + ((ampe)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(alpo.a(2131708899), paramBoolean, paramAppInterface, ((ampe)localObject1).e, ((ampe)localObject1).jdField_a_of_type_Int, (ampe)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    while (paramPromotionConfigInfo.hasNext())
    {
      Iterator localIterator = ((ampd)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ampe)((Map.Entry)localIterator.next()).getValue()).a();
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
      ((ampm)localIterator.next()).a();
    }
  }
  
  public void b(ampm paramampm)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramampm);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((ampm)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampk
 * JD-Core Version:    0.7.0.1
 */