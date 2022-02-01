package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PromotionResDownload
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  ArrayList<PromotionResDownload.DownloadListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public PromotionResDownload(long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("ARPromotionResDownload_" + paramLong);
  }
  
  static PromotionConfigInfo.ZipItem a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    PromotionConfigInfo.ZipItem localZipItem = null;
    while (localIterator.hasNext())
    {
      PromotionConfigInfo.PromotionItem localPromotionItem = (PromotionConfigInfo.PromotionItem)((Map.Entry)localIterator.next()).getValue();
      if (!PromotionUtil.a(localPromotionItem.jdField_b_of_type_Long))
      {
        localZipItem = a(paramBoolean, paramPromotionConfigInfo.mUin, localPromotionItem);
        if (localZipItem != null) {
          return localZipItem;
        }
      }
    }
    return localZipItem;
  }
  
  static PromotionConfigInfo.ZipItem a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    PromotionConfigInfo.ZipItem localZipItem = a(paramBoolean, paramPromotionConfigInfo.mUin, paramPromotionItem);
    paramPromotionItem = localZipItem;
    if (localZipItem == null)
    {
      paramPromotionItem = localZipItem;
      if (paramBoolean) {
        paramPromotionItem = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return paramPromotionItem;
  }
  
  public static PromotionConfigInfo.ZipItem a(boolean paramBoolean, String paramString, PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    paramPromotionItem = paramPromotionItem.a().entrySet().iterator();
    while (paramPromotionItem.hasNext())
    {
      PromotionConfigInfo.ZipItem localZipItem = (PromotionConfigInfo.ZipItem)((Map.Entry)paramPromotionItem.next()).getValue();
      if (localZipItem.jdField_c_of_type_Int == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(PromotionUtil.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 已经下载失败了, id[" + localZipItem.e + "], index[" + localZipItem.jdField_a_of_type_Int + "]");
        }
      }
      else if ((paramBoolean) && (localZipItem.jdField_b_of_type_Int == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(PromotionUtil.jdField_a_of_type_JavaLangString, 1, "isPromotionResReady, 无需预下载, id[" + localZipItem.e + "], index[" + localZipItem.jdField_a_of_type_Int + "]");
        }
      }
      else if (!a(paramString, localZipItem)) {
        return localZipItem;
      }
    }
    return null;
  }
  
  private ArrayList<PromotionResDownload.DownloadListener> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, PromotionConfigInfo.ZipItem paramZipItem)
  {
    if ((a() == null) || (paramZipItem == null)) {
      a(paramString2, paramInt, -3);
    }
    do
    {
      return;
      paramString2 = a(paramAppInterface, paramZipItem);
    } while (paramString2 == null);
    paramZipItem.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (PreDownloadController)paramAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    ((PreDownloadController)localObject1).cancelPreDownload(paramZipItem.jdField_a_of_type_JavaLangString);
    ((PreDownloadController)localObject1).preDownloadSuccess(paramZipItem.jdField_a_of_type_JavaLangString, 0L);
    localObject1 = paramZipItem.jdField_c_of_type_JavaLangString;
    if (a(paramAppInterface.getAccount(), paramZipItem))
    {
      paramAppInterface = paramZipItem.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramZipItem.jdField_a_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramZipItem + "], zipPath[" + (String)localObject1 + "]");
        paramZipItem.a(2);
        paramString2.a(paramZipItem.jdField_a_of_type_JavaLangString, paramZipItem.jdField_b_of_type_JavaLangString, 100, (String)localObject1, paramZipItem);
        return;
      }
      finally {}
    }
    Object localObject2 = paramZipItem.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramZipItem.jdField_a_of_type_Boolean = false;
        if (paramZipItem.jdField_c_of_type_Int == 1)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramZipItem + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramZipItem.a(1);
      boolean bool = ((ResDownloadManager)paramAppInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD)).a(paramZipItem.jdField_a_of_type_JavaLangString, paramZipItem.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramZipItem, paramZipItem.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramZipItem + "]");
      if ((!bool) && (paramString2 != null)) {
        paramString2.a(paramZipItem.jdField_a_of_type_JavaLangString, paramZipItem.jdField_b_of_type_JavaLangString, -4, null, paramZipItem);
      }
    }
  }
  
  static boolean a(PromotionConfigInfo.ZipItem paramZipItem)
  {
    if (paramZipItem.jdField_a_of_type_Int == 0)
    {
      String str = PromotionPath.a(paramZipItem);
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
        paramZipItem = PromotionPath.b(paramZipItem);
        if (new File(paramZipItem + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramZipItem + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramZipItem.jdField_a_of_type_Int == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, PromotionConfigInfo.ZipItem paramZipItem)
  {
    String str = paramZipItem.d;
    if (ARPromotionConfigSP.a(paramString, paramZipItem.e, paramZipItem.jdField_a_of_type_Int, paramZipItem.jdField_b_of_type_JavaLangString, str)) {
      return a(paramZipItem);
    }
    return false;
  }
  
  PromotionConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  }
  
  /* Error */
  ResDownloadManager.IResDownloadListener a(AppInterface paramAppInterface, PromotionConfigInfo.ZipItem paramZipItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 228	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$ZipItem:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 228	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$ZipItem:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 116	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$ZipItem:jdField_a_of_type_Int	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 277	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionResDownload$2
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 112	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$ZipItem:e	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 280	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionResDownload$2:<init>	(Lcom/tencent/mobileqq/ar/ARPromotionMgr/PromotionResDownload;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 228	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$ZipItem:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   41: aload_2
    //   42: getfield 228	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$ZipItem:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	PromotionResDownload
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramZipItem	PromotionConfigInfo.ZipItem
    //   22	13	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   18	46	49	finally
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
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
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (PromotionConfigInfo.PromotionItem)localObject2);
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((PromotionConfigInfo.PromotionItem)localObject2).a().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          a(paramString, ((PromotionConfigInfo.ZipItem)((Map.Entry)paramAppInterface.next()).getValue()).jdField_a_of_type_Int, 100);
        }
      }
      paramString = ((PromotionConfigInfo.ZipItem)localObject1).jdField_b_of_type_JavaLangString;
      if (!paramBoolean) {
        break;
      }
      if (((PromotionConfigInfo.ZipItem)localObject1).jdField_b_of_type_Int != 0)
      {
        localObject2 = new RunnableTask((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (PromotionConfigInfo.ZipItem)localObject1), 0L);
        paramBoolean = ((PreDownloadController)paramAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).requestPreDownload(10074, "prd", paramString, 0, ((PromotionConfigInfo.ZipItem)localObject1).jdField_a_of_type_JavaLangString, ((PromotionConfigInfo.ZipItem)localObject1).jdField_c_of_type_JavaLangString, ((PromotionConfigInfo.ZipItem)localObject1).jdField_b_of_type_Int, 0, true, (AbsPreDownloadTask)localObject2);
        ((PromotionConfigInfo.ZipItem)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((PromotionConfigInfo.ZipItem)localObject1).jdField_a_of_type_Int + "]");
        return;
      }
    } while (!AudioHelper.e());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, 无需预下载，id[" + ((PromotionConfigInfo.ZipItem)localObject1).e + "], index[" + ((PromotionConfigInfo.ZipItem)localObject1).jdField_a_of_type_Int + "]");
    return;
    a(HardCodeUtil.a(2131708502), paramBoolean, paramAppInterface, ((PromotionConfigInfo.ZipItem)localObject1).e, ((PromotionConfigInfo.ZipItem)localObject1).jdField_a_of_type_Int, (PromotionConfigInfo.ZipItem)localObject1);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
    if (paramPromotionConfigInfo != null)
    {
      paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
      while (paramPromotionConfigInfo.hasNext())
      {
        Iterator localIterator = ((PromotionConfigInfo.PromotionItem)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).a().entrySet().iterator();
        while (localIterator.hasNext()) {
          ((PromotionConfigInfo.ZipItem)((Map.Entry)localIterator.next()).getValue()).a();
        }
      }
    }
  }
  
  public void a(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadListener);
      return;
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
      ((PromotionResDownload.DownloadListener)localIterator.next()).a();
    }
  }
  
  public void b(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramDownloadListener);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((PromotionResDownload.DownloadListener)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload
 * JD-Core Version:    0.7.0.1
 */