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

public class amtz
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<amub> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public amtz(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static amtt a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    amtt localamtt = null;
    while (localIterator.hasNext())
    {
      amts localamts = (amts)((Map.Entry)localIterator.next()).getValue();
      if (!amuc.a(localamts.jdField_b_of_type_Long))
      {
        localamtt = a(paramBoolean, paramPromotionConfigInfo.mUin, localamts);
        if (localamtt != null) {
          return localamtt;
        }
      }
    }
    return localamtt;
  }
  
  static amtt a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, amts paramamts)
  {
    amtt localamtt = a(paramBoolean, paramPromotionConfigInfo.mUin, paramamts);
    paramamts = localamtt;
    if (localamtt == null)
    {
      paramamts = localamtt;
      if (paramBoolean) {
        paramamts = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramamts;
  }
  
  public static amtt a(boolean paramBoolean, String paramString, amts paramamts)
  {
    paramamts = paramamts.a().entrySet().iterator();
    while (paramamts.hasNext())
    {
      amtt localamtt = (amtt)((Map.Entry)paramamts.next()).getValue();
      if (localamtt.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(amuc.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localamtt.e + "], index[" + localamtt.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localamtt.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(amuc.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localamtt.e + "], index[" + localamtt.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localamtt)) {
        return localamtt;
      }
    }
    return null;
  }
  
  private ArrayList<amub> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, amtt paramamtt)
  {
    if ((a() == null) || (paramamtt == null))
    {
      a(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramamtt);
    paramamtt.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (bbaa)paramAppInterface.getManager(193);
    ((bbaa)localObject1).a(paramamtt.jdField_a_of_type_JavaLangString);
    ((bbaa)localObject1).a(paramamtt.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramamtt.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramamtt))
    {
      paramAppInterface = paramamtt.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramamtt.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramamtt + "], zipPath[" + (String)localObject1 + "]");
        paramamtt.a(2);
        paramString2.a(paramamtt.jdField_a_of_type_JavaLangString, paramamtt.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramamtt);
        return;
      }
      finally {}
    }
    Object localObject2 = paramamtt.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramamtt.jdField_a_of_type_Boolean = false;
        if (paramamtt.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramamtt + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramamtt.a(1);
      boolean bool = ((answ)paramAppInterface.getManager(191)).a(paramamtt.jdField_a_of_type_JavaLangString, paramamtt.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramamtt, paramamtt.jdField_a_of_type_Ansz);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramamtt + "]");
      if (!bool) {
        paramString2.a(paramamtt.jdField_a_of_type_JavaLangString, paramamtt.jdField_b_of_type_JavaLangString, -4, null, paramamtt);
      }
    }
  }
  
  static boolean a(amtt paramamtt)
  {
    if (paramamtt.jdField_a_of_type_Int == 0)
    {
      String str = amty.a(paramamtt);
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
        paramamtt = amty.b(paramamtt);
        if (new File(paramamtt + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramamtt + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramamtt.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, amtt paramamtt)
  {
    String str = paramamtt.d;
    if (bdpg.a(paramString, paramamtt.e, paramamtt.jdField_a_of_type_Int, paramamtt.jdField_b_of_type_JavaLangString, str)) {
      return a(paramamtt);
    }
    return false;
  }
  
  /* Error */
  ansz a(AppInterface paramAppInterface, amtt paramamtt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 218	amtt:jdField_a_of_type_Ansz	Lansz;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 218	amtt:jdField_a_of_type_Ansz	Lansz;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	amtt:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 265	amua
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	amtt:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 268	amua:<init>	(Lamtz;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 218	amtt:jdField_a_of_type_Ansz	Lansz;
    //   41: aload_2
    //   42: getfield 218	amtt:jdField_a_of_type_Ansz	Lansz;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	amtz
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramamtt	amtt
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
  
  public void a(amub paramamub)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramamub);
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
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (amts)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((amts)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((amtt)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((amtt)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((amtt)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new bbab((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (amtt)localObject1), 0L);
        paramBoolean = ((bbaa)paramAppInterface.getManager(193)).a(10074, "prd", paramString, 0, ((amtt)localObject1).jdField_a_of_type_JavaLangString, ((amtt)localObject1).jdField_c_of_type_JavaLangString, ((amtt)localObject1).jdField_b_of_type_Int, 0, true, (bazx)localObject2);
        ((amtt)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((amtt)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.e());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((amtt)localObject1).e + "], index[" + ((amtt)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(alud.a(2131708911), paramBoolean, paramAppInterface, ((amtt)localObject1).e, ((amtt)localObject1).jdField_a_of_type_Int, (amtt)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    while (paramPromotionConfigInfo.hasNext())
    {
      Iterator localIterator = ((amts)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
      while (localIterator.hasNext()) {
        ((amtt)((Map.Entry)localIterator.next()).getValue()).a();
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
      ((amub)localIterator.next()).a();
    }
  }
  
  public void b(amub paramamub)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramamub);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((amub)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtz
 * JD-Core Version:    0.7.0.1
 */