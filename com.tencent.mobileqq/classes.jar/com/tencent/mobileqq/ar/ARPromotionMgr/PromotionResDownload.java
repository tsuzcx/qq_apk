package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
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
  final String a;
  PromotionConfigInfo b;
  ArrayList<PromotionResDownload.DownloadListener> c = new ArrayList();
  
  public PromotionResDownload(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARPromotionResDownload_");
    localStringBuilder.append(paramLong);
    this.a = localStringBuilder.toString();
  }
  
  static PromotionConfigInfo.ZipItem a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    Object localObject1 = null;
    Object localObject2;
    do
    {
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (PromotionConfigInfo.PromotionItem)((Map.Entry)localIterator.next()).getValue();
      } while (PromotionUtil.a(((PromotionConfigInfo.PromotionItem)localObject2).b));
      localObject2 = a(paramBoolean, paramPromotionConfigInfo.mUin, (PromotionConfigInfo.PromotionItem)localObject2);
      localObject1 = localObject2;
    } while (localObject2 == null);
    return localObject2;
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
    paramPromotionItem = paramPromotionItem.b().entrySet().iterator();
    while (paramPromotionItem.hasNext())
    {
      PromotionConfigInfo.ZipItem localZipItem = (PromotionConfigInfo.ZipItem)((Map.Entry)paramPromotionItem.next()).getValue();
      String str;
      StringBuilder localStringBuilder;
      if (localZipItem.k == -1)
      {
        if (QLog.isDevelopLevel())
        {
          str = PromotionUtil.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isPromotionResReady, 已经下载失败了, id[");
          localStringBuilder.append(localZipItem.f);
          localStringBuilder.append("], index[");
          localStringBuilder.append(localZipItem.a);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString());
        }
      }
      else if ((paramBoolean) && (localZipItem.g == 0))
      {
        if (QLog.isDevelopLevel())
        {
          str = PromotionUtil.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isPromotionResReady, 无需预下载, id[");
          localStringBuilder.append(localZipItem.f);
          localStringBuilder.append("], index[");
          localStringBuilder.append(localZipItem.a);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString());
        }
      }
      else if (!a(paramString, localZipItem)) {
        return localZipItem;
      }
    }
    return null;
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, PromotionConfigInfo.ZipItem paramZipItem)
  {
    if ((b() != null) && (paramZipItem != null))
    {
      paramString2 = a(paramAppInterface, paramZipItem);
      if (paramString2 == null) {
        return;
      }
      paramZipItem.m = System.currentTimeMillis();
      Object localObject1 = (IPreDownloadController)paramAppInterface.getRuntimeService(IPreDownloadController.class, "");
      ((IPreDownloadController)localObject1).cancelPreDownload(paramZipItem.b);
      ((IPreDownloadController)localObject1).preDownloadSuccess(paramZipItem.b, 0L);
      localObject1 = paramZipItem.d;
      if (a(paramAppInterface.getAccount(), paramZipItem))
      {
        paramAppInterface = paramZipItem.j;
        if (!paramBoolean) {}
        try
        {
          paramZipItem.h = false;
          paramAppInterface = this.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("innerDownloadRes[");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append("], 资源已经存在, callByPreDownload[");
          ((StringBuilder)localObject2).append(paramBoolean);
          ((StringBuilder)localObject2).append("], item[");
          ((StringBuilder)localObject2).append(paramZipItem);
          ((StringBuilder)localObject2).append("], zipPath[");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("]");
          QLog.w(paramAppInterface, 1, ((StringBuilder)localObject2).toString());
          paramZipItem.a(2);
          paramString2.a(paramZipItem.b, paramZipItem.c, 100, (String)localObject1, paramZipItem);
          return;
        }
        finally {}
      }
      Object localObject2 = paramZipItem.j;
      if (!paramBoolean) {}
      try
      {
        paramZipItem.h = false;
        if (paramZipItem.k == 1)
        {
          paramAppInterface = this.a;
          paramString2 = new StringBuilder();
          paramString2.append("innerDownloadRes[");
          paramString2.append(paramString1);
          paramString2.append("], 已经在下载中, callByPreDownload[");
          paramString2.append(paramBoolean);
          paramString2.append("], item[");
          paramString2.append(paramZipItem);
          paramString2.append("], zipPath[");
          paramString2.append((String)localObject1);
          paramString2.append("]");
          QLog.w(paramAppInterface, 1, paramString2.toString());
        }
        else
        {
          paramZipItem.a(1);
          boolean bool = ((ResDownloadManager)paramAppInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD)).a(paramZipItem.b, paramZipItem.c, ".zip", true, 5, paramZipItem, paramZipItem.i);
          paramAppInterface = this.a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("innerDownloadRes[");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append("], 开始下载, callByPreDownload[");
          ((StringBuilder)localObject1).append(paramBoolean);
          ((StringBuilder)localObject1).append("], ret[");
          ((StringBuilder)localObject1).append(bool);
          ((StringBuilder)localObject1).append("], item[");
          ((StringBuilder)localObject1).append(paramZipItem);
          ((StringBuilder)localObject1).append("]");
          QLog.w(paramAppInterface, 1, ((StringBuilder)localObject1).toString());
          if ((!bool) && (paramString2 != null)) {
            paramString2.a(paramZipItem.b, paramZipItem.c, -4, null, paramZipItem);
          }
        }
        return;
      }
      finally {}
    }
    a(paramString2, paramInt, -3);
  }
  
  static boolean a(PromotionConfigInfo.ZipItem paramZipItem)
  {
    if (paramZipItem.a == 0)
    {
      Object localObject = PromotionPath.a(paramZipItem);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("entry.png");
      if (!new File(localStringBuilder.toString()).exists())
      {
        if (QLog.isDevelopLevel())
        {
          paramZipItem = new StringBuilder();
          paramZipItem.append("文件不存在, path[");
          paramZipItem.append((String)localObject);
          paramZipItem.append("], name[");
          paramZipItem.append("entry.png");
          paramZipItem.append("]");
          QLog.w("PromotionResDownload", 1, paramZipItem.toString());
        }
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("entry.json");
      if (!new File(localStringBuilder.toString()).exists())
      {
        if (QLog.isDevelopLevel())
        {
          paramZipItem = new StringBuilder();
          paramZipItem.append("文件不存在, path[");
          paramZipItem.append((String)localObject);
          paramZipItem.append("], name[");
          paramZipItem.append("entry.json");
          paramZipItem.append("]");
          QLog.w("PromotionResDownload", 1, paramZipItem.toString());
        }
        return false;
      }
      paramZipItem = PromotionPath.b(paramZipItem);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramZipItem);
      ((StringBuilder)localObject).append("guide.json");
      if (!new File(((StringBuilder)localObject).toString()).exists())
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("文件不存在, path[");
          ((StringBuilder)localObject).append(paramZipItem);
          ((StringBuilder)localObject).append("], name[");
          ((StringBuilder)localObject).append("guide.json");
          ((StringBuilder)localObject).append("]");
          QLog.w("PromotionResDownload", 1, ((StringBuilder)localObject).toString());
        }
        return false;
      }
    }
    else
    {
      int i = paramZipItem.a;
    }
    return true;
  }
  
  public static boolean a(String paramString, PromotionConfigInfo.ZipItem paramZipItem)
  {
    String str = paramZipItem.e;
    if (ARPromotionConfigSP.a(paramString, paramZipItem.f, paramZipItem.a, paramZipItem.c, str)) {
      return a(paramZipItem);
    }
    return false;
  }
  
  private ArrayList<PromotionResDownload.DownloadListener> d()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.c)
    {
      localArrayList2.addAll(this.c);
      return localArrayList2;
    }
  }
  
  ResDownloadManager.IResDownloadListener a(AppInterface paramAppInterface, PromotionConfigInfo.ZipItem paramZipItem)
  {
    try
    {
      if (paramZipItem.i != null)
      {
        paramAppInterface = paramZipItem.i;
        return paramAppInterface;
      }
      int i = paramZipItem.a;
      paramZipItem.i = new PromotionResDownload.2(this, paramAppInterface, paramZipItem.f, i);
      paramAppInterface = paramZipItem.i;
      return paramAppInterface;
    }
    finally {}
  }
  
  public void a()
  {
    this.b = null;
  }
  
  void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = b();
    if (localObject1 == null)
    {
      paramAppInterface = this.a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestPreDownload, ConfigInfo为空, callByPreDownload[");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("], activatyid[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("], index[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]");
      QLog.w(paramAppInterface, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (!(paramAppInterface instanceof QQAppInterface))
    {
      QLog.w(this.a, 1, "requestPreDownload, 不在主进程");
      return;
    }
    Object localObject2 = ((PromotionConfigInfo)localObject1).getItem(paramString);
    if (localObject2 == null)
    {
      a(paramString, paramInt, -3);
      return;
    }
    localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (PromotionConfigInfo.PromotionItem)localObject2);
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPreDownload, expectID[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], expectIndex[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], callByPreDownload[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], zipItem[");
    localStringBuilder.append(localObject1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (localObject1 == null)
    {
      paramAppInterface = ((PromotionConfigInfo.PromotionItem)localObject2).b().entrySet().iterator();
      while (paramAppInterface.hasNext()) {
        a(paramString, ((PromotionConfigInfo.ZipItem)((Map.Entry)paramAppInterface.next()).getValue()).a, 100);
      }
      return;
    }
    paramString = ((PromotionConfigInfo.ZipItem)localObject1).c;
    if (paramBoolean)
    {
      if (((PromotionConfigInfo.ZipItem)localObject1).g != 0)
      {
        localObject2 = new RunnableTask((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (PromotionConfigInfo.ZipItem)localObject1), 0L);
        paramBoolean = ((IPreDownloadController)paramAppInterface.getRuntimeService(IPreDownloadController.class, "")).requestPreDownload(10074, "prd", paramString, 0, ((PromotionConfigInfo.ZipItem)localObject1).b, ((PromotionConfigInfo.ZipItem)localObject1).d, ((PromotionConfigInfo.ZipItem)localObject1).g, 0, true, (AbsPreDownloadTask)localObject2);
        ((PromotionConfigInfo.ZipItem)localObject1).l = System.currentTimeMillis();
        paramAppInterface = this.a;
        paramString = new StringBuilder();
        paramString.append("requestPreDownload, 预下载申请调度, ret[");
        paramString.append(paramBoolean);
        paramString.append("], index[");
        paramString.append(((PromotionConfigInfo.ZipItem)localObject1).a);
        paramString.append("]");
        QLog.w(paramAppInterface, 1, paramString.toString());
        return;
      }
      if (QQAudioHelper.f())
      {
        paramAppInterface = this.a;
        paramString = new StringBuilder();
        paramString.append("requestPreDownload, 无需预下载，id[");
        paramString.append(((PromotionConfigInfo.ZipItem)localObject1).f);
        paramString.append("], index[");
        paramString.append(((PromotionConfigInfo.ZipItem)localObject1).a);
        paramString.append("]");
        QLog.w(paramAppInterface, 1, paramString.toString());
      }
    }
    else
    {
      a(HardCodeUtil.a(2131906293), paramBoolean, paramAppInterface, ((PromotionConfigInfo.ZipItem)localObject1).f, ((PromotionConfigInfo.ZipItem)localObject1).a, (PromotionConfigInfo.ZipItem)localObject1);
    }
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    this.b = paramPromotionConfigInfo;
    if (paramPromotionConfigInfo != null)
    {
      paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
      while (paramPromotionConfigInfo.hasNext())
      {
        Iterator localIterator = ((PromotionConfigInfo.PromotionItem)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).b().entrySet().iterator();
        while (localIterator.hasNext()) {
          ((PromotionConfigInfo.ZipItem)((Map.Entry)localIterator.next()).getValue()).a();
        }
      }
    }
  }
  
  public void a(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    synchronized (this.c)
    {
      this.c.add(paramDownloadListener);
      return;
    }
  }
  
  void a(String paramString, int paramInt1, int paramInt2)
  {
    b(paramString, paramInt1, paramInt2);
    BusinessCommonConfig.sendDownloadResultNotify(2, paramString, paramInt1, paramInt2);
  }
  
  PromotionConfigInfo b()
  {
    return this.b;
  }
  
  public void b(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    synchronized (this.c)
    {
      this.c.remove(paramDownloadListener);
      return;
    }
  }
  
  void b(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = d().iterator();
    while (localIterator.hasNext()) {
      ((PromotionResDownload.DownloadListener)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
  
  void c()
  {
    Iterator localIterator = d().iterator();
    while (localIterator.hasNext()) {
      ((PromotionResDownload.DownloadListener)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload
 * JD-Core Version:    0.7.0.1
 */