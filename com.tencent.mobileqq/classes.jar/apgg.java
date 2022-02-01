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

public class apgg
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<apgi> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public apgg(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static apga a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    apga localapga = null;
    while (localIterator.hasNext())
    {
      apfz localapfz = (apfz)((Map.Entry)localIterator.next()).getValue();
      if (!apgj.a(localapfz.jdField_b_of_type_Long))
      {
        localapga = a(paramBoolean, paramPromotionConfigInfo.mUin, localapfz);
        if (localapga != null) {
          return localapga;
        }
      }
    }
    return localapga;
  }
  
  static apga a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, apfz paramapfz)
  {
    apga localapga = a(paramBoolean, paramPromotionConfigInfo.mUin, paramapfz);
    paramapfz = localapga;
    if (localapga == null)
    {
      paramapfz = localapga;
      if (paramBoolean) {
        paramapfz = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramapfz;
  }
  
  public static apga a(boolean paramBoolean, String paramString, apfz paramapfz)
  {
    paramapfz = paramapfz.a().entrySet().iterator();
    while (paramapfz.hasNext())
    {
      apga localapga = (apga)((Map.Entry)paramapfz.next()).getValue();
      if (localapga.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(apgj.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localapga.e + "], index[" + localapga.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localapga.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(apgj.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localapga.e + "], index[" + localapga.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localapga)) {
        return localapga;
      }
    }
    return null;
  }
  
  private ArrayList<apgi> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, apga paramapga)
  {
    if ((a() == null) || (paramapga == null))
    {
      a(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramapga);
    paramapga.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (bezv)paramAppInterface.getManager(193);
    ((bezv)localObject1).a(paramapga.jdField_a_of_type_JavaLangString);
    ((bezv)localObject1).a(paramapga.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramapga.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramapga))
    {
      paramAppInterface = paramapga.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramapga.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramapga + "], zipPath[" + (String)localObject1 + "]");
        paramapga.a(2);
        paramString2.a(paramapga.jdField_a_of_type_JavaLangString, paramapga.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramapga);
        return;
      }
      finally {}
    }
    Object localObject2 = paramapga.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramapga.jdField_a_of_type_Boolean = false;
        if (paramapga.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramapga + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramapga.a(1);
      boolean bool = ((aqgr)paramAppInterface.getManager(191)).a(paramapga.jdField_a_of_type_JavaLangString, paramapga.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramapga, paramapga.jdField_a_of_type_Aqgu);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramapga + "]");
      if (!bool) {
        paramString2.a(paramapga.jdField_a_of_type_JavaLangString, paramapga.jdField_b_of_type_JavaLangString, -4, null, paramapga);
      }
    }
  }
  
  static boolean a(apga paramapga)
  {
    if (paramapga.jdField_a_of_type_Int == 0)
    {
      String str = apgf.a(paramapga);
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
        paramapga = apgf.b(paramapga);
        if (new File(paramapga + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramapga + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramapga.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, apga paramapga)
  {
    String str = paramapga.d;
    if (bhui.a(paramString, paramapga.e, paramapga.jdField_a_of_type_Int, paramapga.jdField_b_of_type_JavaLangString, str)) {
      return a(paramapga);
    }
    return false;
  }
  
  /* Error */
  aqgu a(AppInterface paramAppInterface, apga paramapga)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 218	apga:jdField_a_of_type_Aqgu	Laqgu;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 218	apga:jdField_a_of_type_Aqgu	Laqgu;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	apga:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 265	apgh
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	apga:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 268	apgh:<init>	(Lapgg;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 218	apga:jdField_a_of_type_Aqgu	Laqgu;
    //   41: aload_2
    //   42: getfield 218	apga:jdField_a_of_type_Aqgu	Laqgu;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	apgg
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramapga	apga
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
  
  public void a(apgi paramapgi)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramapgi);
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
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (apfz)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((apfz)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((apga)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((apga)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((apga)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new bezw((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (apga)localObject1), 0L);
        paramBoolean = ((bezv)paramAppInterface.getManager(193)).a(10074, "prd", paramString, 0, ((apga)localObject1).jdField_a_of_type_JavaLangString, ((apga)localObject1).jdField_c_of_type_JavaLangString, ((apga)localObject1).jdField_b_of_type_Int, 0, true, (bezs)localObject2);
        ((apga)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((apga)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.f());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((apga)localObject1).e + "], index[" + ((apga)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(anzj.a(2131707396), paramBoolean, paramAppInterface, ((apga)localObject1).e, ((apga)localObject1).jdField_a_of_type_Int, (apga)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    if (paramPromotionConfigInfo != null)
    {
      paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
      while (paramPromotionConfigInfo.hasNext())
      {
        Iterator localIterator = ((apfz)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
        while (localIterator.hasNext()) {
          ((apga)((Map.Entry)localIterator.next()).getValue()).a();
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
      ((apgi)localIterator.next()).a();
    }
  }
  
  public void b(apgi paramapgi)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramapgi);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((apgi)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgg
 * JD-Core Version:    0.7.0.1
 */