package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ArResourceConfigUtils;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArResourceDownload
  implements INetEngineListener
{
  public AppInterface a;
  public ArResourceManager b;
  Set<String> c = Collections.synchronizedSet(new HashSet());
  ArrayList<ArResourceDownload.DownloadInfo> d = new ArrayList();
  private final byte[] e = new byte[0];
  private long f = 0L;
  private long g = 0L;
  private boolean h = false;
  private boolean i = false;
  private IHttpEngineService j;
  
  public ArResourceDownload(AppInterface paramAppInterface, ArResourceManager paramArResourceManager)
  {
    this.a = paramAppInterface;
    this.b = paramArResourceManager;
  }
  
  private void a(ArResourceDownload.DownloadInfo paramDownloadInfo)
  {
    if (!TextUtils.isEmpty(paramDownloadInfo.b))
    {
      if (TextUtils.isEmpty(paramDownloadInfo.c)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downLoad:url=");
        ((StringBuilder)localObject).append(paramDownloadInfo.b);
        ((StringBuilder)localObject).append(",md5= ");
        ((StringBuilder)localObject).append(paramDownloadInfo.c);
        QLog.i("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject).toString());
      }
      paramDownloadInfo.e += 1;
      if (this.j == null) {
        this.j = ((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all"));
      }
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).mCallback = this;
      ((HttpNetReq)localObject).mReqUrl = paramDownloadInfo.b;
      ((HttpNetReq)localObject).mHttpMethod = 0;
      ((HttpNetReq)localObject).mOutPath = paramDownloadInfo.d;
      ((HttpNetReq)localObject).mPrioty = 1;
      ((HttpNetReq)localObject).setUserData(paramDownloadInfo);
      ((HttpNetReq)localObject).mSupportBreakResume = true;
      this.j.sendReq((NetReq)localObject);
      paramDownloadInfo.j = ((HttpNetReq)localObject);
    }
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo.e == 100)
    {
      File localFile = null;
      Object localObject2 = paramArCloudConfigInfo.k;
      Object localObject1 = "";
      if (localObject2 != null)
      {
        localFile = new File(paramArCloudConfigInfo.k.h);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ArConfigUtils.a());
        ((StringBuilder)localObject2).append("ar_model/");
        ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(paramArCloudConfigInfo.k.b);
        ((StringBuilder)localObject2).append("_model.zip");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = "";
      }
      if (localFile == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceDownload", 2, "copyAndCheckBinHai3dRes return for null zipfile");
        }
        return;
      }
      Object localObject3 = new File((String)localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadArResource:binhai:oldFilePath=");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(", exist=");
        localStringBuilder.append(((File)localObject3).exists());
        QLog.d("ArConfig_ArResourceDownload", 2, localStringBuilder.toString());
      }
      if ((((File)localObject3).exists()) && (!localFile.exists()))
      {
        bool1 = localFile.mkdirs();
        boolean bool2 = FileUtils.copyFile((File)localObject3, localFile);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadArResource:binhai:copy old to new dir, ret=");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append(", mkRet=");
        ((StringBuilder)localObject2).append(bool1);
        QLog.d("ArConfig_ArResourceDownload", 1, ((StringBuilder)localObject2).toString());
      }
      localObject2 = localObject1;
      if (localFile.exists()) {
        try
        {
          localObject3 = PortalUtils.a(localFile.getAbsolutePath());
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject3;
            localObject2 = new StringBuilder();
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append("download binhai calc md5=");
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append((String)localObject3);
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append(", modelMd5=");
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append(paramArCloudConfigInfo.k.b);
            localObject1 = localObject3;
            QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!paramArCloudConfigInfo.k.b.equalsIgnoreCase((String)localObject3))
          {
            localObject1 = localObject3;
            localFile.delete();
            localObject2 = localObject3;
          }
        }
        catch (Throwable paramArCloudConfigInfo)
        {
          QLog.e("ArConfig_ArResourceDownload", 1, "download binhai check md5 error", paramArCloudConfigInfo);
          localObject2 = localObject1;
        }
      }
      boolean bool1 = localFile.exists();
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("md5", localObject2);
      ((HashMap)localObject1).put("uin", this.a.getCurrentAccountUin());
      if (bool1) {
        paramArCloudConfigInfo = "1";
      } else {
        paramArCloudConfigInfo = "0";
      }
      ((HashMap)localObject1).put("exist", paramArCloudConfigInfo);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "binhai_predownload", bool1, 0L, 0L, (HashMap)localObject1, "", true);
    }
  }
  
  private boolean a(ArConfigInfo paramArConfigInfo)
  {
    if (paramArConfigInfo == null) {
      return true;
    }
    try
    {
      if (!paramArConfigInfo.mArCloudConfigInfos.isEmpty())
      {
        paramArConfigInfo = paramArConfigInfo.mArCloudConfigInfos.iterator();
        while (paramArConfigInfo.hasNext())
        {
          localObject = (ArCloudConfigInfo)paramArConfigInfo.next();
          if (!FileUtils.fileExists(((ArCloudConfigInfo)localObject).j.d)) {
            return false;
          }
          if (((((ArCloudConfigInfo)localObject).e == 0) || (((ArCloudConfigInfo)localObject).e == 100)) && (((ArCloudConfigInfo)localObject).k != null))
          {
            boolean bool = new File(((ArCloudConfigInfo)localObject).k.h).exists();
            if (!bool) {
              return false;
            }
          }
        }
      }
      return true;
    }
    catch (Exception paramArConfigInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isResourceReady e=");
      ((StringBuilder)localObject).append(paramArConfigInfo.getMessage());
      QLog.i("ArConfig_ArResourceDownload", 1, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  public void a()
  {
    if (this.h) {
      synchronized (this.e)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
          if (localDownloadInfo.g < localDownloadInfo.f) {
            this.j.cancelReq(localDownloadInfo.j);
          }
        }
        this.d.clear();
        this.h = false;
        this.c.clear();
        return;
      }
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloadArResource|isDownloading=");
          ((StringBuilder)localObject1).append(this.h);
          QLog.i("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject1).toString());
        }
        paramBoolean2 = this.h;
        if (paramBoolean2) {
          return;
        }
      }
      finally
      {
        Object localObject1;
        int k;
        Object localObject2;
        continue;
        throw paramArConfigInfo;
        continue;
        Object localObject3 = null;
        continue;
        continue;
        localObject3 = null;
        continue;
        Object localObject4 = null;
        continue;
        int m = k;
        continue;
        if (m == 1) {
          continue;
        }
        if (m == 2) {
          continue;
        }
        if (m == 3) {
          continue;
        }
        m = 4;
        continue;
        m = 1;
        continue;
        m = 3;
        continue;
        m = 2;
        continue;
      }
      synchronized (this.e)
      {
        this.d.clear();
        if (paramArConfigInfo != null)
        {
          try
          {
            if ((paramArConfigInfo.mArCloudConfigInfos != null) && (paramArConfigInfo.mArCloudConfigInfos.size() > 0))
            {
              Iterator localIterator = paramArConfigInfo.mArCloudConfigInfos.iterator();
              m = 0;
              if (localIterator.hasNext())
              {
                localObject5 = (ArCloudConfigInfo)localIterator.next();
                if ((localObject5 != null) && (((ArCloudConfigInfo)localObject5).j != null) && (!TextUtils.isEmpty(((ArCloudConfigInfo)localObject5).j.c)))
                {
                  if ((!TextUtils.isEmpty(((ArCloudConfigInfo)localObject5).j.d)) && (!FileUtils.fileExists(((ArCloudConfigInfo)localObject5).j.d)))
                  {
                    localObject1 = new ArResourceDownload.DownloadInfo();
                    ((ArResourceDownload.DownloadInfo)localObject1).a = 2;
                    ((ArResourceDownload.DownloadInfo)localObject1).b = ((ArCloudConfigInfo)localObject5).j.c;
                    ((ArResourceDownload.DownloadInfo)localObject1).c = ((ArCloudConfigInfo)localObject5).j.a;
                    ((ArResourceDownload.DownloadInfo)localObject1).d = ((ArCloudConfigInfo)localObject5).j.d;
                    ((ArResourceDownload.DownloadInfo)localObject1).f = ((ArCloudConfigInfo)localObject5).j.b;
                    ((ArResourceDownload.DownloadInfo)localObject1).h = true;
                    if (!this.c.contains(((ArResourceDownload.DownloadInfo)localObject1).c))
                    {
                      this.c.add(((ArResourceDownload.DownloadInfo)localObject1).c);
                      this.d.add(localObject1);
                    }
                  }
                  a((ArCloudConfigInfo)localObject5);
                  if ((((ArCloudConfigInfo)localObject5).e != 0) && (((ArCloudConfigInfo)localObject5).e != 100))
                  {
                    k = m;
                    if (((ArCloudConfigInfo)localObject5).i == null) {
                      continue;
                    }
                    k = m;
                    if (((ArCloudConfigInfo)localObject5).i.size() <= 0) {
                      continue;
                    }
                    localObject4 = ((ArCloudConfigInfo)localObject5).i.iterator();
                    k = m;
                    if (!((Iterator)localObject4).hasNext()) {
                      continue;
                    }
                    localObject5 = (ArVideoResourceInfo)((Iterator)localObject4).next();
                    if (((ArVideoResourceInfo)localObject5).h == 4) {
                      continue;
                    }
                    localObject6 = new File(((ArVideoResourceInfo)localObject5).j);
                    paramBoolean2 = ((File)localObject6).exists();
                    if (!paramBoolean2) {
                      continue;
                    }
                    try
                    {
                      localObject1 = PortalUtils.a(((File)localObject6).getAbsolutePath());
                    }
                    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("e");
                      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
                      QLog.e("ArConfig_ArResourceDownload", 1, localStringBuilder.toString());
                      continue;
                    }
                    if (((((File)localObject6).exists()) && (!TextUtils.isEmpty(localUnsatisfiedLinkError)) && (localUnsatisfiedLinkError.equals(((ArVideoResourceInfo)localObject5).e))) || (this.c.contains(((ArVideoResourceInfo)localObject5).i))) {
                      continue;
                    }
                    localObject2 = new ArResourceDownload.DownloadInfo();
                    ((ArResourceDownload.DownloadInfo)localObject2).a = 3;
                    ((ArResourceDownload.DownloadInfo)localObject2).b = ((ArVideoResourceInfo)localObject5).i;
                    ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArVideoResourceInfo)localObject5).e;
                    ((ArResourceDownload.DownloadInfo)localObject2).f = ((ArVideoResourceInfo)localObject5).b;
                    ((ArResourceDownload.DownloadInfo)localObject2).d = ((ArVideoResourceInfo)localObject5).j;
                    ((ArResourceDownload.DownloadInfo)localObject2).h = true;
                    this.d.add(localObject2);
                    this.c.add(((ArVideoResourceInfo)localObject5).e);
                    continue;
                  }
                  if (((ArCloudConfigInfo)localObject5).k == null) {
                    continue;
                  }
                  localObject2 = new File(((ArCloudConfigInfo)localObject5).k.h);
                  if ((localObject2 == null) || (!((File)localObject2).exists())) {
                    continue;
                  }
                  localObject4 = PortalUtils.a(((File)localObject2).getAbsolutePath());
                  if ((localObject2 != null) && (((File)localObject2).exists()) && (!TextUtils.isEmpty((CharSequence)localObject4)))
                  {
                    paramBoolean2 = ((String)localObject4).equals(((ArCloudConfigInfo)localObject5).k.b);
                    if (!paramBoolean2) {}
                  }
                }
              }
            }
          }
          catch (Exception paramArConfigInfo)
          {
            Object localObject5;
            Object localObject6;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("e");
            ((StringBuilder)localObject2).append(paramArConfigInfo.getMessage());
            QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          try
          {
            localObject2 = new File(((ArCloudConfigInfo)localObject5).k.h);
            localObject4 = ((ArCloudConfigInfo)localObject5).k.h;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(((File)localObject2).getParentFile().getAbsolutePath());
            ((StringBuilder)localObject6).append(File.separator);
            ((StringBuilder)localObject6).append(((ArCloudConfigInfo)localObject5).k.b);
            ((StringBuilder)localObject6).append(File.separator);
            ArResourceConfigUtils.b((String)localObject4, ((StringBuilder)localObject6).toString());
          }
          catch (Exception localException1)
          {
            int n;
            continue;
          }
          try
          {
            QLog.i("ArConfig_ArResourceDownload", 1, "onARMarkerModelDownloadComplete  ");
            k = 1;
          }
          catch (Exception localException2)
          {
            continue;
          }
          m = 1;
          new File(((ArCloudConfigInfo)localObject5).k.h).delete();
          localObject2 = new ArResourceDownload.DownloadInfo();
          ((ArResourceDownload.DownloadInfo)localObject2).a = 3;
          ((ArResourceDownload.DownloadInfo)localObject2).b = ((ArCloudConfigInfo)localObject5).k.c;
          ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArCloudConfigInfo)localObject5).k.b;
          ((ArResourceDownload.DownloadInfo)localObject2).d = ((ArCloudConfigInfo)localObject5).k.h;
          ((ArResourceDownload.DownloadInfo)localObject2).f = ((ArCloudConfigInfo)localObject5).k.a;
          ((ArResourceDownload.DownloadInfo)localObject2).h = true;
          k = m;
          if (this.c.contains(((ArResourceDownload.DownloadInfo)localObject2).c)) {
            continue;
          }
          this.c.add(((ArResourceDownload.DownloadInfo)localObject2).c);
          this.d.add(localObject2);
          k = m;
          continue;
          localObject2 = new ArResourceDownload.DownloadInfo();
          ((ArResourceDownload.DownloadInfo)localObject2).a = 3;
          if (((ArCloudConfigInfo)localObject5).k != null)
          {
            ((ArResourceDownload.DownloadInfo)localObject2).b = ((ArCloudConfigInfo)localObject5).k.c;
            ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArCloudConfigInfo)localObject5).k.b;
            ((ArResourceDownload.DownloadInfo)localObject2).d = ((ArCloudConfigInfo)localObject5).k.h;
            ((ArResourceDownload.DownloadInfo)localObject2).f = ((ArCloudConfigInfo)localObject5).k.a;
          }
          ((ArResourceDownload.DownloadInfo)localObject2).h = true;
          k = m;
          if (this.c.contains(((ArResourceDownload.DownloadInfo)localObject2).c)) {
            continue;
          }
          this.c.add(((ArResourceDownload.DownloadInfo)localObject2).c);
          this.d.add(localObject2);
          k = m;
          continue;
          QLog.i("ArConfig_ArResourceDownload", 1, "resource null continue ");
          k = m;
          continue;
          if (m != 0) {
            this.b.a(paramArConfigInfo);
          }
          if (this.d.size() > 0)
          {
            if (QLog.isColorLevel())
            {
              paramArConfigInfo = new StringBuilder();
              paramArConfigInfo.append("downloadArResource|download num= ");
              paramArConfigInfo.append(this.d.size());
              QLog.d("ArConfig_ArResourceDownload", 2, paramArConfigInfo.toString());
            }
            this.f = 0L;
            this.g = 0L;
            this.h = true;
            this.i = false;
            try
            {
              k = this.d.size();
              int i1 = k - 1;
              k = 0;
              m = k;
              if (i1 < 0) {
                continue;
              }
              n = k;
              try
              {
                paramArConfigInfo = (ArResourceDownload.DownloadInfo)this.d.get(i1);
                if (paramBoolean1)
                {
                  n = k;
                  paramArConfigInfo.i = true;
                  n = k;
                  if (!this.b.a(paramArConfigInfo.c))
                  {
                    n = k;
                    this.d.remove(i1);
                    n = k;
                    this.c.remove(paramArConfigInfo.c);
                    m = k;
                    continue;
                  }
                }
                n = k;
                this.f += paramArConfigInfo.f;
                n = k;
                m = ((ArResourceManager)this.a.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)).g();
                n = k;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                n = k;
                localObject2 = new StringBuilder();
                n = k;
                ((StringBuilder)localObject2).append("dpcNet=");
                n = k;
                ((StringBuilder)localObject2).append(m);
                n = k;
                QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
              }
              catch (Exception paramArConfigInfo)
              {
                continue;
              }
              n = k;
              localObject2 = new ArResourceDownload.DownloadTask((QQAppInterface)this.a, paramArConfigInfo, this);
              n = k;
              paramBoolean2 = ((IPreDownloadController)((QQAppInterface)this.a).getRuntimeService(IPreDownloadController.class)).requestPreDownload(10067, "prd", paramArConfigInfo.c, 0, paramArConfigInfo.b, paramArConfigInfo.d, m, 0, true, (AbsPreDownloadTask)localObject2);
              m = k;
              if (paramBoolean2) {
                m = k + 1;
              }
              n = m;
              if (QLog.isColorLevel())
              {
                n = m;
                paramArConfigInfo = new StringBuilder();
                n = m;
                paramArConfigInfo.append(" downloadArResource.ret=");
                n = m;
                paramArConfigInfo.append(paramBoolean2);
                n = m;
                QLog.d("ArConfig_ArResourceDownload", 2, paramArConfigInfo.toString());
              }
              i1 -= 1;
              k = m;
              continue;
              this.c.clear();
            }
            catch (Exception paramArConfigInfo)
            {
              n = 0;
            }
            m = n;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("e= ");
              ((StringBuilder)localObject2).append(paramArConfigInfo.getMessage());
              QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject2).toString());
              m = n;
            }
            if (m == 0) {
              this.h = false;
            }
          }
          else
          {
            this.b.h();
          }
          return;
        }
      }
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      QLog.d("ArConfig_ArResourceDownload", 1, "doOnResp is downloading...");
      return;
    }
    boolean bool1;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int k = paramNetResp.mErrCode;
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    ??? = localHttpNetReq.getUserData();
    boolean bool2 = bool1;
    Object localObject4;
    ArResourceDownload.DownloadInfo localDownloadInfo;
    boolean bool3;
    int n;
    Object localObject3;
    if (??? != null)
    {
      bool2 = bool1;
      if ((??? instanceof ArResourceDownload.DownloadInfo))
      {
        localObject4 = this.b.a();
        localDownloadInfo = (ArResourceDownload.DownloadInfo)???;
        if (TextUtils.isEmpty(localHttpNetReq.mOutPath))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("req.mOutPath is null, md5=");
          ((StringBuilder)???).append(localDownloadInfo.c);
          QLog.d("ArConfig_ArResourceDownload", 1, ((StringBuilder)???).toString());
          if (bool1) {
            k = 98765;
          }
          bool1 = false;
        }
        if (bool1)
        {
          ??? = new File(localHttpNetReq.mOutPath);
          ??? = PortalUtils.a(((File)???).getAbsolutePath());
          Object localObject5;
          int m;
          if ((!TextUtils.isEmpty((CharSequence)???)) && (!((String)???).equalsIgnoreCase(localDownloadInfo.c)))
          {
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("Md5 error|fileMD5=");
              ((StringBuilder)localObject5).append((String)???);
              ((StringBuilder)localObject5).append(", type=");
              ((StringBuilder)localObject5).append(localDownloadInfo.a);
              QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)localObject5).toString());
            }
            bool2 = bool1;
            m = k;
            if (localDownloadInfo.a != 1)
            {
              ((File)???).delete();
              bool2 = false;
              m = -100001;
            }
          }
          else
          {
            bool2 = bool1;
            m = k;
            if (localDownloadInfo.a == 3) {
              try
              {
                synchronized (this.e)
                {
                  localObject5 = ((ArConfigInfo)localObject4).getModelResByMd5(localDownloadInfo.c);
                  if ((!TextUtils.isEmpty(localDownloadInfo.d)) && (localObject5 != null) && ((((ArCloudConfigInfo)localObject5).e == 0) || (((ArCloudConfigInfo)localObject5).e == 100)))
                  {
                    localObject5 = new File(localDownloadInfo.d);
                    String str = localDownloadInfo.d;
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append(((File)localObject5).getParentFile().getAbsolutePath());
                    localStringBuilder.append(File.separator);
                    localStringBuilder.append(localDownloadInfo.c);
                    localStringBuilder.append(File.separator);
                    ArResourceConfigUtils.b(str, localStringBuilder.toString());
                    this.b.a((ArConfigInfo)localObject4);
                  }
                  bool2 = bool1;
                  m = k;
                }
                bool3 = bool2;
              }
              catch (Exception localException)
              {
                ((File)???).delete();
                if (localDownloadInfo.h)
                {
                  k = -100002;
                  bool1 = false;
                }
                bool2 = bool1;
                m = k;
                if (QLog.isColorLevel())
                {
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("e= ");
                  ((StringBuilder)???).append(localException.getMessage());
                  QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)???).toString());
                  m = k;
                  bool2 = bool1;
                }
              }
            }
          }
          n = m;
          if (localDownloadInfo.i)
          {
            this.b.a(localDownloadInfo.c, true);
            bool3 = bool2;
            n = m;
          }
        }
        else
        {
          if ((localDownloadInfo.e <= 3) && (!localDownloadInfo.i))
          {
            a(localDownloadInfo);
            if (QLog.isColorLevel())
            {
              paramNetResp = new StringBuilder();
              paramNetResp.append("retry downLoad:retryUrl=");
              paramNetResp.append(localDownloadInfo.b);
              paramNetResp.append(",retryMd5= ");
              paramNetResp.append(localDownloadInfo.c);
              QLog.i("ArConfig_ArResourceDownload", 2, paramNetResp.toString());
            }
            return;
          }
          bool3 = bool1;
          n = k;
          if (localDownloadInfo.i)
          {
            this.b.a(localDownloadInfo.c, false);
            n = k;
            bool3 = bool1;
          }
        }
        if (this.c.contains(localDownloadInfo.c)) {
          this.c.remove(localDownloadInfo.c);
        }
        if (this.c.isEmpty()) {
          this.h = false;
        }
        if ((localDownloadInfo.a != 1) && (localDownloadInfo.a != 2) && (localDownloadInfo.a != 3) && (localDownloadInfo.a != 4)) {
          k = 0;
        } else {
          k = 1;
        }
        if (!TextUtils.isEmpty(paramNetResp.mErrDesc))
        {
          localObject3 = paramNetResp.mErrDesc;
          ??? = localObject3;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("errDesc: ");
            ((StringBuilder)???).append((String)localObject3);
            QLog.d("ArConfig_ArResourceDownload", 2, ((StringBuilder)???).toString());
            ??? = localObject3;
          }
        }
        else
        {
          ??? = "0";
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("url", OlympicUtil.b(localHttpNetReq.mReqUrl));
        ((HashMap)localObject3).put("resultCode", String.valueOf(paramNetResp.mResult));
        ((HashMap)localObject3).put("fileSize", String.valueOf(localDownloadInfo.f));
        ((HashMap)localObject3).put("param_errorDesc", ???);
        if (bool3)
        {
          ((HashMap)localObject3).put("param_FailCode", "0");
          if ((k != 0) && (!this.h) && (a((ArConfigInfo)localObject4))) {
            synchronized (this.e)
            {
              if (!this.i)
              {
                this.b.h();
                this.i = true;
              }
              if (!QLog.isColorLevel()) {
                break label1186;
              }
              QLog.i("ArConfig_ArResourceDownload", 2, "onResp:downloadSuccess!");
            }
          }
        }
        else
        {
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(n));
          this.c.clear();
        }
      }
    }
    label1186:
    label1402:
    for (;;)
    {
      synchronized (this.e)
      {
        this.h = false;
        localObject4 = this.d.iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localDownloadInfo = (ArResourceDownload.DownloadInfo)((Iterator)localObject4).next();
          if (localDownloadInfo.g >= localDownloadInfo.f) {
            break label1402;
          }
          this.j.cancelReq(localDownloadInfo.j);
          break label1402;
        }
        if ((k != 0) && (!this.i))
        {
          this.b.a(n, paramNetResp.mResult);
          this.i = true;
        }
        ??? = this.a.getCurrentAccountUin();
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)???, "olympic_ar_download", bool3, 0L, 0L, (HashMap)localObject3, null);
        bool2 = bool3;
      }
      ??? = new File(localHttpNetReq.mOutPath);
      long l;
      if ((bool2) && (((File)???).exists())) {
        l = ((File)???).length();
      } else {
        l = 0L;
      }
      ??? = (IPreDownloadController)this.a.getRuntimeService(IPreDownloadController.class, "");
      localObject3 = localHttpNetReq.mReqUrl;
      if (!bool2) {
        l = -1L;
      }
      ((IPreDownloadController)???).preDownloadSuccess((String)localObject3, l);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onResp:");
        ((StringBuilder)???).append(localHttpNetReq.mReqUrl);
        ((StringBuilder)???).append(", ");
        ((StringBuilder)???).append(paramNetResp.mResult);
        ((StringBuilder)???).append(", ");
        ((StringBuilder)???).append(paramNetResp.mErrCode);
        QLog.i("ArConfig_ArResourceDownload", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.getUserData();
    if ((??? != null) && ((??? instanceof ArResourceDownload.DownloadInfo)))
    {
      ??? = (ArResourceDownload.DownloadInfo)???;
      if (???.a == 1) {
        return;
      }
      String str = ???.c;
      synchronized (this.e)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
          if (str.equals(localDownloadInfo.c))
          {
            paramLong2 = localDownloadInfo.g;
            localDownloadInfo.g = paramLong1;
            this.g += paramLong1 - paramLong2;
          }
        }
        if (!this.i) {
          this.b.a(this.g, this.f);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload
 * JD-Core Version:    0.7.0.1
 */