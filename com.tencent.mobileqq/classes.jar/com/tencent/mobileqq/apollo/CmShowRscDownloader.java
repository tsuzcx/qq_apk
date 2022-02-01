package com.tencent.mobileqq.apollo;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CmShowRscDownloader
{
  public static void a(AppInterface paramAppInterface, String paramString1, CmShowRscDownloader.OnRscDownLoadListener paramOnRscDownLoadListener, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes");
    }
    if (paramAppInterface == null) {}
    label192:
    do
    {
      CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem;
      do
      {
        ArrayList localArrayList;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localIdolRscItem = null;
              if (!TextUtils.isEmpty(paramString2))
              {
                localIdolRscItem = new CmShowRscCacheManagerImpl.IdolRscItem();
                localIdolRscItem.jdField_a_of_type_JavaLangString = paramString2;
                localIdolRscItem.jdField_a_of_type_Int = 6;
                localArrayList.add(localIdolRscItem);
              }
              if (paramList != null) {
                localArrayList.addAll(paramList);
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
              QLog.e("rscContent_CmShowRscDownloader", 1, "downloadApolloRes tasks is empty ");
            } while (paramOnRscDownLoadListener == null);
            paramOnRscDownLoadListener.a(false, paramString1, paramList, "");
            return;
            paramAppInterface = (DownloaderFactory)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
          } while (paramAppInterface == null);
          paramAppInterface = paramAppInterface.a(3);
        } while (paramAppInterface == null);
        paramString2 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        int k = localArrayList.size();
        int i = 0;
        if (i < k)
        {
          Object localObject = (CmShowRscCacheManagerImpl.IdolRscItem)localArrayList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscDownloader", 2, "IdolRscItem:" + localObject);
          }
          int m = ((CmShowRscCacheManagerImpl.IdolRscItem)localObject).jdField_a_of_type_Int;
          int n = ((CmShowRscCacheManagerImpl.IdolRscItem)localObject).b;
          String str = ((CmShowRscCacheManagerImpl.IdolRscItem)localObject).a();
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes url is empty resType->" + m + " id->" + n);
            }
            paramString2.decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break label192;
            File localFile = new File(((CmShowRscCacheManagerImpl.IdolRscItem)localObject).b());
            if (!paramBoolean)
            {
              if ((localFile.exists()) && (((CmShowRscCacheManagerImpl.IdolRscItem)localObject).b())) {}
              for (int j = 1;; j = 0)
              {
                if (j == 0) {
                  break label431;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscDownloader", 2, "file exsit resType->" + m + " id->" + n);
                }
                paramString2.decrementAndGet();
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscDownloader", 2, "file not exsit resType->" + m + " id->" + n);
              }
            }
            if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
            {
              if (paramOnRscDownLoadListener != null) {
                paramOnRscDownLoadListener.a(false, paramString1, paramList, "");
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localFile.getParentFile().mkdirs();
            localObject = new DownloadTask(str, localFile);
            ((DownloadTask)localObject).p = true;
            ((DownloadTask)localObject).n = true;
            ((DownloadTask)localObject).f = "apollo_res";
            ((DownloadTask)localObject).b = 1;
            ((DownloadTask)localObject).q = true;
            ((DownloadTask)localObject).r = true;
            paramAppInterface.a((DownloadTask)localObject, new CmShowRscDownloader.1(str, localFile, localAtomicInteger2, m, n, localAtomicInteger1, paramString2, paramOnRscDownLoadListener, localIdolRscItem, paramString1, paramList), null);
          }
        }
      } while (paramString2.get() != 0);
      if (paramOnRscDownLoadListener != null)
      {
        paramAppInterface = "";
        if (localIdolRscItem != null) {
          paramAppInterface = localIdolRscItem.c();
        }
        paramOnRscDownLoadListener.a(true, paramString1, paramList, paramAppInterface);
      }
    } while (!QLog.isColorLevel());
    label431:
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString1 + ", all cnt: " + paramString2.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.CmShowRscDownloader
 * JD-Core Version:    0.7.0.1
 */