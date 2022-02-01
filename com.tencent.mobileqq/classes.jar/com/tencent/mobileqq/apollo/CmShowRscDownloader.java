package com.tencent.mobileqq.apollo;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CmShowRscDownloader
{
  public static void a(AppInterface paramAppInterface, String paramString1, CmShowRscDownloader.OnRscDownLoadListener paramOnRscDownLoadListener, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, boolean paramBoolean, String paramString2)
  {
    Object localObject2 = paramOnRscDownLoadListener;
    Object localObject3 = paramList;
    boolean bool = QLog.isColorLevel();
    String str = "rscContent_CmShowRscDownloader";
    if (bool) {
      QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes");
    }
    if (paramAppInterface == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = new CmShowRscCacheManagerImpl.IdolRscItem();
      ((CmShowRscCacheManagerImpl.IdolRscItem)localObject1).jdField_a_of_type_JavaLangString = paramString2;
      ((CmShowRscCacheManagerImpl.IdolRscItem)localObject1).jdField_a_of_type_Int = 6;
      localArrayList.add(localObject1);
      paramString2 = (String)localObject1;
    }
    else
    {
      paramString2 = null;
    }
    if (localObject3 != null) {
      localArrayList.addAll((Collection)localObject3);
    }
    bool = localArrayList.isEmpty();
    Object localObject1 = "";
    if (bool)
    {
      QLog.e("rscContent_CmShowRscDownloader", 1, "downloadApolloRes tasks is empty ");
      if (localObject2 != null) {
        ((CmShowRscDownloader.OnRscDownLoadListener)localObject2).a(false, paramString1, (List)localObject3, "");
      }
      return;
    }
    paramAppInterface = (DownloaderFactory)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (paramAppInterface == null) {
      return;
    }
    localObject3 = paramAppInterface.a(3);
    if (localObject3 == null) {
      return;
    }
    Object localObject4 = new AtomicInteger(localArrayList.size());
    localObject2 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    int i = localArrayList.size();
    int j = 0;
    paramAppInterface = (AppInterface)localObject1;
    localObject1 = localObject4;
    for (;;)
    {
      localObject4 = paramOnRscDownLoadListener;
      if (j >= i) {
        break;
      }
      Object localObject6 = (CmShowRscCacheManagerImpl.IdolRscItem)localArrayList.get(j);
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("IdolRscItem:");
        ((StringBuilder)localObject5).append(localObject6);
        QLog.d(str, 2, ((StringBuilder)localObject5).toString());
      }
      int m = ((CmShowRscCacheManagerImpl.IdolRscItem)localObject6).jdField_a_of_type_Int;
      int n = ((CmShowRscCacheManagerImpl.IdolRscItem)localObject6).b;
      Object localObject5 = ((CmShowRscCacheManagerImpl.IdolRscItem)localObject6).a();
      if (TextUtils.isEmpty((CharSequence)localObject5))
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("downloadApolloRes url is empty resType->");
          ((StringBuilder)localObject4).append(m);
          ((StringBuilder)localObject4).append(" id->");
          ((StringBuilder)localObject4).append(n);
          QLog.d(str, 2, ((StringBuilder)localObject4).toString());
        }
        ((AtomicInteger)localObject1).decrementAndGet();
      }
      else
      {
        File localFile = new File(((CmShowRscCacheManagerImpl.IdolRscItem)localObject6).b());
        if (!paramBoolean)
        {
          int k;
          if ((localFile.exists()) && (((CmShowRscCacheManagerImpl.IdolRscItem)localObject6).b())) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0)
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("file exsit resType->");
              ((StringBuilder)localObject4).append(m);
              ((StringBuilder)localObject4).append(" id->");
              ((StringBuilder)localObject4).append(n);
              QLog.d(str, 2, ((StringBuilder)localObject4).toString());
            }
            ((AtomicInteger)localObject1).decrementAndGet();
            break label708;
          }
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("file not exsit resType->");
            ((StringBuilder)localObject6).append(m);
            ((StringBuilder)localObject6).append(" id->");
            ((StringBuilder)localObject6).append(n);
            QLog.d(str, 2, ((StringBuilder)localObject6).toString());
          }
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
        {
          if (localObject4 != null) {
            ((CmShowRscDownloader.OnRscDownLoadListener)localObject4).a(false, paramString1, paramList, paramAppInterface);
          }
          if (QLog.isColorLevel()) {
            QLog.d(str, 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
          }
          return;
        }
        localFile.getParentFile().mkdirs();
        localObject4 = new DownloadTask((String)localObject5, localFile);
        ((DownloadTask)localObject4).p = true;
        ((DownloadTask)localObject4).n = true;
        ((DownloadTask)localObject4).f = "apollo_res";
        ((DownloadTask)localObject4).b = 1;
        ((DownloadTask)localObject4).q = true;
        ((DownloadTask)localObject4).r = true;
        ((DownloaderInterface)localObject3).startDownload((DownloadTask)localObject4, new CmShowRscDownloader.1((String)localObject5, localFile, localAtomicInteger, m, n, (AtomicInteger)localObject2, (AtomicInteger)localObject1, paramOnRscDownLoadListener, paramString2, paramString1, paramList), null);
      }
      label708:
      j += 1;
    }
    if (((AtomicInteger)localObject1).get() == 0)
    {
      if (paramOnRscDownLoadListener != null)
      {
        if (paramString2 != null) {
          paramAppInterface = paramString2.c();
        }
        paramOnRscDownLoadListener.a(true, paramString1, paramList, paramAppInterface);
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("downloadApolloRes local dress ok uin:");
        paramAppInterface.append(paramString1);
        paramAppInterface.append(", all cnt: ");
        paramAppInterface.append(((AtomicInteger)localObject1).get());
        QLog.d(str, 2, paramAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.CmShowRscDownloader
 * JD-Core Version:    0.7.0.1
 */