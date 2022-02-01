package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionDevice;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class ARMarkerResourceManager
{
  private static String r = "";
  Object a = new Object();
  AppInterface b;
  long c;
  long d;
  String e = null;
  long f;
  long g;
  long h;
  int i;
  long j;
  long k;
  long l;
  int m;
  long n;
  int o;
  long p;
  int q;
  private ArrayList<ArCloudConfigInfo> s = null;
  private ARResourceManagerTools t;
  private Context u = null;
  
  public ARMarkerResourceManager(AppInterface paramAppInterface, Context paramContext)
  {
    r = ARResouceDir.a();
    this.s = new ArrayList();
    this.t = new ARResourceManagerTools(paramAppInterface);
    this.b = paramAppInterface;
    this.u = paramContext;
  }
  
  static void a()
  {
    if (TextUtils.isEmpty(r)) {
      r = ARResouceDir.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AR_MODEL);
    localStringBuilder.append(".nomedia");
    ARResouceDir.b(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_AR_TRANSFER);
    localStringBuilder.append(".nomedia");
    ARResouceDir.b(localStringBuilder.toString());
  }
  
  private void a(long paramLong)
  {
    this.s.clear();
    File[] arrayOfFile = new File(g()).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i1 = 0;
    while (i1 < arrayOfFile.length)
    {
      Object localObject1 = arrayOfFile[i1];
      if (((File)localObject1).getName().endsWith("_config.dat"))
      {
        Object localObject2 = g();
        Object localObject3 = ((File)localObject1).getName();
        if (((File)localObject1).lastModified() + paramLong >= System.currentTimeMillis())
        {
          localObject1 = ArResourceConfigUtils.a((String)localObject2, (String)localObject3);
          a((ArCloudConfigInfo)localObject1);
          if (((localObject1 == null) || (((ArCloudConfigInfo)localObject1).j == null) || (new File(((ArCloudConfigInfo)localObject1).j.d).exists())) && ((localObject1 == null) || (((ArCloudConfigInfo)localObject1).k == null) || (new File(((ArCloudConfigInfo)localObject1).k.h).exists())))
          {
            if ((localObject1 != null) && (((ArCloudConfigInfo)localObject1).i != null) && (((ArCloudConfigInfo)localObject1).i.size() > 0) && (((ArCloudConfigInfo)localObject1).j != null))
            {
              localObject2 = ((ArCloudConfigInfo)localObject1).i.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (ArVideoResourceInfo)((Iterator)localObject2).next();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(((ArCloudConfigInfo)localObject1).j.e);
                localStringBuilder.append(((ArVideoResourceInfo)localObject3).e);
                localStringBuilder.append("_model.zip");
                if (!new File(localStringBuilder.toString()).exists()) {
                  int i2 = ((ArVideoResourceInfo)localObject3).h;
                }
              }
            }
            this.s.add(localObject1);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void a(ARCloudMarkerRecogResult paramARCloudMarkerRecogResult, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerModelResources");
    Object localObject1 = new File(paramArCloudConfigInfo.j.d);
    e();
    this.c = System.currentTimeMillis();
    this.e = paramArCloudConfigInfo.j.a;
    if ((!((File)localObject1).exists()) && (!paramArCloudConfigInfo.a()))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).a = 2;
      ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.j.c;
      ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.j.a;
      this.f = (paramArCloudConfigInfo.j.b / 8192L);
      ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.j.b;
      ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.j.d;
      ((ARResourceDownload.DownloadInfo)localObject1).e = false;
      this.o = paramArCloudConfigInfo.e;
      this.p += this.f;
      localArrayList.add(localObject1);
    }
    Object localObject2;
    if ((paramArCloudConfigInfo.m != null) && (paramArCloudConfigInfo.m.a()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(r);
      ((StringBuilder)localObject1).append("pddata/app/offline/html5/");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.m.d);
      ((StringBuilder)localObject1).append(File.separator);
      localObject1 = new File(((StringBuilder)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("offlie  ");
      ((StringBuilder)localObject2).append(OfflineEnvHelper.b(paramArCloudConfigInfo.m.d));
      QLog.i("AREngine_ARMarkerResourceManager", 1, ((StringBuilder)localObject2).toString());
      if ((!((File)localObject1).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.m.d)))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).b = String.valueOf(paramArCloudConfigInfo.m.d);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.r != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.r.i))) {
      if (!new File(paramArCloudConfigInfo.r.i).exists())
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 7;
        ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.r.f;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.r.h;
        ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.r.g;
        ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.r.i;
        ((ARResourceDownload.DownloadInfo)localObject1).e = true;
        localArrayList.add(localObject1);
      }
    }
    try
    {
      ArResourceConfigUtils.b(paramArCloudConfigInfo.r.i, ARResouceDir.a(paramArCloudConfigInfo.r.h));
    }
    catch (Exception localException)
    {
      label514:
      Object localObject3;
      label1149:
      break label514;
    }
    if ((paramArCloudConfigInfo.n == 1) && (paramArCloudConfigInfo.o != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.o.d)) && (!new File(paramArCloudConfigInfo.o.d).exists()))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).a = 6;
      ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.o.b;
      ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.o.c;
      ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.o.h;
      ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.o.d;
      ((ARResourceDownload.DownloadInfo)localObject1).e = true;
      localArrayList.add(localObject1);
    }
    if ((paramArCloudConfigInfo.e != 0) && (paramArCloudConfigInfo.e != 100) && (paramArCloudConfigInfo.e != 7) && (paramArCloudConfigInfo.e != 8))
    {
      if ((paramArCloudConfigInfo.i != null) && (paramArCloudConfigInfo.i.size() > 0))
      {
        localObject2 = new ArrayList();
        localObject3 = paramArCloudConfigInfo.i.iterator();
      }
    }
    else {
      while (((Iterator)localObject3).hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)((Iterator)localObject3).next();
        if (localArVideoResourceInfo.h != 4)
        {
          File localFile = new File(localArVideoResourceInfo.j);
          if (localFile.exists()) {
            localObject1 = PortalUtils.a(localFile.getAbsolutePath());
          } else {
            localObject1 = null;
          }
          if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.e))) && (!((ArrayList)localObject2).contains(localArVideoResourceInfo.i)))
          {
            localObject1 = new ARResourceDownload.DownloadInfo();
            ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
            ((ARResourceDownload.DownloadInfo)localObject1).b = localArVideoResourceInfo.i;
            ((ARResourceDownload.DownloadInfo)localObject1).c = localArVideoResourceInfo.e;
            this.j = (localArVideoResourceInfo.b / 8192L);
            ((ARResourceDownload.DownloadInfo)localObject1).g = localArVideoResourceInfo.b;
            this.p += this.j;
            this.l = System.currentTimeMillis();
            ((ARResourceDownload.DownloadInfo)localObject1).d = localArVideoResourceInfo.j;
            ((ARResourceDownload.DownloadInfo)localObject1).e = false;
            localArrayList.add(localObject1);
            ((ArrayList)localObject2).add(localArVideoResourceInfo.i);
          }
          continue;
          if (paramArCloudConfigInfo.k != null) {
            localObject1 = new File(paramArCloudConfigInfo.k.h);
          } else {
            localObject1 = null;
          }
          if ((localObject1 != null) && (((File)localObject1).exists())) {
            localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
          } else {
            localObject2 = null;
          }
          if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramArCloudConfigInfo.k.b))) {}
        }
        try
        {
          localObject1 = new File(paramArCloudConfigInfo.k.h);
          localObject2 = paramArCloudConfigInfo.k.h;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((File)localObject1).getParentFile().getAbsolutePath());
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(paramArCloudConfigInfo.k.b);
          ((StringBuilder)localObject3).append(File.separator);
          ArResourceConfigUtils.b((String)localObject2, ((StringBuilder)localObject3).toString());
          paramARMarkerResourceCallback.a(true, 3, paramArCloudConfigInfo);
          QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
        }
        catch (Exception paramARCloudMarkerRecogResult)
        {
          break label1149;
        }
        new File(paramArCloudConfigInfo.k.h).delete();
        QLog.i("AREngine_ARMarkerResourceManager", 1, "Download end. uncompressZip error. url = ");
        paramARMarkerResourceCallback.a(false, 3, paramArCloudConfigInfo);
        QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
        paramARMarkerResourceCallback.a(false, paramArCloudConfigInfo);
        return;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null))
        {
          localObject1 = new ARResourceDownload.DownloadInfo();
          ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
          ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.k.c;
          ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.k.b;
          this.j = (paramArCloudConfigInfo.k.a / 8192L);
          ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.k.a;
          this.p += this.j;
          this.l = System.currentTimeMillis();
          ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.k.h;
          ((ARResourceDownload.DownloadInfo)localObject1).e = true;
          localArrayList.add(localObject1);
        }
      }
    }
    if ((paramARMarkerResourceCallback != null) && ((paramArCloudConfigInfo.a()) || (paramArCloudConfigInfo.b()))) {
      paramARMarkerResourceCallback.g();
    }
    if (localArrayList.size() > 0)
    {
      this.t.a(localArrayList, new ARMarkerResourceManager.3(this, paramARMarkerResourceCallback, paramArCloudConfigInfo, paramARCloudMarkerRecogResult));
      return;
    }
    paramARMarkerResourceCallback.a(true, paramArCloudConfigInfo);
    if (paramArCloudConfigInfo.c != 1) {
      a(paramArCloudConfigInfo.j.a, paramARCloudMarkerRecogResult);
    }
    b(paramArCloudConfigInfo);
  }
  
  private void a(ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectModelResources");
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArCloudConfigInfo.m != null) && (paramArCloudConfigInfo.m.a()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(r);
      ((StringBuilder)localObject1).append("pddata/app/offline/html5/");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.m.d);
      ((StringBuilder)localObject1).append(File.separator);
      if ((!new File(((StringBuilder)localObject1).toString()).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.m.d)))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).b = String.valueOf(paramArCloudConfigInfo.m.d);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.r != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.r.i))) {
      if (!new File(paramArCloudConfigInfo.r.i).exists())
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 7;
        ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.r.f;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.r.h;
        ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.r.g;
        ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.r.i;
        ((ARResourceDownload.DownloadInfo)localObject1).e = true;
        localArrayList.add(localObject1);
      }
    }
    try
    {
      ArResourceConfigUtils.b(paramArCloudConfigInfo.r.i, ARResouceDir.a(paramArCloudConfigInfo.r.h));
    }
    catch (Exception localException1)
    {
      label283:
      break label283;
    }
    if ((paramArCloudConfigInfo.n == 1) && (paramArCloudConfigInfo.o != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.o.d))) {
      if (!new File(paramArCloudConfigInfo.o.d).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(r);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.o.c);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!new File((String)localObject1).exists()) {}
      }
    }
    try
    {
      ArResourceConfigUtils.b((String)localObject1, ARResouceDir.b());
    }
    catch (Exception localException2)
    {
      label403:
      break label403;
    }
    Object localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).a = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.o.b;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.o.c;
    ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.o.h;
    ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.o.d;
    ((ARResourceDownload.DownloadInfo)localObject1).e = true;
    localArrayList.add(localObject1);
    break label565;
    localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).a = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.o.b;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.o.c;
    ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.o.h;
    ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.o.d;
    ((ARResourceDownload.DownloadInfo)localObject1).e = true;
    localArrayList.add(localObject1);
    try
    {
      ArResourceConfigUtils.b(paramArCloudConfigInfo.o.d, ARResouceDir.b());
    }
    catch (Exception localException3)
    {
      label565:
      Object localObject2;
      break label565;
    }
    if ((paramArCloudConfigInfo.e == 0) || (paramArCloudConfigInfo.e == 7) || (paramArCloudConfigInfo.e == 8))
    {
      if (paramArCloudConfigInfo.k != null) {
        localObject1 = new File(paramArCloudConfigInfo.k.h);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
      } else {
        localObject2 = null;
      }
      if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramArCloudConfigInfo.k.b))) {}
    }
    try
    {
      localObject1 = new File(paramArCloudConfigInfo.k.h);
      localObject2 = paramArCloudConfigInfo.k.h;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((File)localObject1).getParentFile().getAbsolutePath());
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(paramArCloudConfigInfo.k.b);
      ((StringBuilder)localObject3).append(File.separator);
      ArResourceConfigUtils.b((String)localObject2, ((StringBuilder)localObject3).toString());
      paramARMarkerResourceCallback.b(true, paramArCloudConfigInfo);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete.");
    }
    catch (Exception localException4)
    {
      Object localObject3;
      label784:
      break label784;
    }
    new File(paramArCloudConfigInfo.k.h).delete();
    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete. uncompressZip error.");
    paramARMarkerResourceCallback.b(false, paramArCloudConfigInfo);
    return;
    if ((paramArCloudConfigInfo.k != null) && (paramArCloudConfigInfo.e == 7))
    {
      if (paramArCloudConfigInfo.k.b != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(r);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.k.b);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.k.b);
      ((StringBuilder)localObject2).append(File.separator);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject1).exists()) {}
    }
    try
    {
      ArResourceConfigUtils.b((String)localObject1, (String)localObject2);
    }
    catch (Exception localException5)
    {
      label998:
      break label998;
    }
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
      ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.k.c;
      ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.k.b;
      this.j = (paramArCloudConfigInfo.k.a / 8192L);
      ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.k.a;
      this.p += this.j;
      this.l = System.currentTimeMillis();
      ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.k.h;
      ((ARResourceDownload.DownloadInfo)localObject1).e = true;
      localArrayList.add(localObject1);
      break label1349;
      if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
        ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.k.c;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.k.b;
        this.j = (paramArCloudConfigInfo.k.a / 8192L);
        ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.k.a;
        this.p += this.j;
        this.l = System.currentTimeMillis();
        ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.k.h;
        ((ARResourceDownload.DownloadInfo)localObject1).e = true;
        localArrayList.add(localObject1);
        break label1349;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null))
        {
          localObject1 = new ARResourceDownload.DownloadInfo();
          ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
          ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.k.c;
          ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.k.b;
          this.j = (paramArCloudConfigInfo.k.a / 8192L);
          ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.k.a;
          this.p += this.j;
          this.l = System.currentTimeMillis();
          ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.k.h;
          ((ARResourceDownload.DownloadInfo)localObject1).e = true;
          localArrayList.add(localObject1);
        }
      }
    }
    label1349:
    if ((paramArCloudConfigInfo.i != null) && (paramArCloudConfigInfo.i.size() > 0))
    {
      localObject2 = new ArrayList();
      localObject3 = paramArCloudConfigInfo.i.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)((Iterator)localObject3).next();
        if (localArVideoResourceInfo.h != 4)
        {
          File localFile = new File(localArVideoResourceInfo.j);
          if (localFile.exists()) {
            localObject1 = PortalUtils.a(localFile.getAbsolutePath());
          } else {
            localObject1 = null;
          }
          if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.e))) && (!((ArrayList)localObject2).contains(localArVideoResourceInfo.i)))
          {
            localObject1 = new ARResourceDownload.DownloadInfo();
            ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
            ((ARResourceDownload.DownloadInfo)localObject1).b = localArVideoResourceInfo.i;
            ((ARResourceDownload.DownloadInfo)localObject1).c = localArVideoResourceInfo.e;
            this.j = (localArVideoResourceInfo.b / 8192L);
            ((ARResourceDownload.DownloadInfo)localObject1).g = localArVideoResourceInfo.b;
            this.p += this.j;
            this.l = System.currentTimeMillis();
            ((ARResourceDownload.DownloadInfo)localObject1).d = localArVideoResourceInfo.j;
            ((ARResourceDownload.DownloadInfo)localObject1).e = false;
            localArrayList.add(localObject1);
            ((ArrayList)localObject2).add(localArVideoResourceInfo.i);
          }
        }
      }
    }
    if ((paramARMarkerResourceCallback != null) && (paramArCloudConfigInfo.b())) {
      paramARMarkerResourceCallback.h();
    }
    if (localArrayList.size() > 0)
    {
      this.t.a(localArrayList, new ARMarkerResourceManager.4(this, paramARMarkerResourceCallback, paramArCloudConfigInfo));
      return;
    }
    paramARMarkerResourceCallback.b(true, paramArCloudConfigInfo);
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "checkAndDeleteExpiredResource  ");
    long l1 = System.currentTimeMillis();
    File[] arrayOfFile = new File(g()).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i1 = 0;
    while (i1 < arrayOfFile.length)
    {
      Object localObject1 = arrayOfFile[i1];
      if ((((int)((l1 - ((File)localObject1).lastModified()) / 86400000L) > 7) || (paramBoolean)) && (((File)localObject1).getName().endsWith("_config.dat")))
      {
        ArCloudConfigInfo localArCloudConfigInfo = ArResourceConfigUtils.a(g(), ((File)localObject1).getName());
        if (localArCloudConfigInfo == null) {
          return;
        }
        a(localArCloudConfigInfo);
        ((File)localObject1).delete();
        if (localArCloudConfigInfo.j != null)
        {
          localObject1 = new File(localArCloudConfigInfo.j.d);
          if (((File)localObject1).exists()) {
            ((File)localObject1).delete();
          }
          Object localObject2;
          if (localArCloudConfigInfo.k != null)
          {
            localObject1 = new File(localArCloudConfigInfo.k.h);
            if (((File)localObject1).exists()) {
              ((File)localObject1).delete();
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(localArCloudConfigInfo.j.e);
            ((StringBuilder)localObject1).append(localArCloudConfigInfo.k.b);
            ((StringBuilder)localObject1).append(File.separator);
            localObject1 = new File(((StringBuilder)localObject1).toString());
            if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
            {
              localObject2 = ((File)localObject1).listFiles();
              if (localObject2 != null)
              {
                int i2 = 0;
                while (i2 < localObject2.length)
                {
                  localObject2[i2].delete();
                  i2 += 1;
                }
              }
              ((File)localObject1).delete();
            }
          }
          if ((localArCloudConfigInfo.i != null) && (localArCloudConfigInfo.i.size() > 0))
          {
            localObject1 = localArCloudConfigInfo.i.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(localArCloudConfigInfo.j.e);
              localStringBuilder.append(((ArVideoResourceInfo)localObject2).e);
              localStringBuilder.append("_model.zip");
              localObject2 = new File(localStringBuilder.toString());
              if (((File)localObject2).exists()) {
                ((File)localObject2).delete();
              }
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public static boolean a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    Object localObject1;
    Object localObject2;
    if (paramArCloudConfigInfo.j != null)
    {
      localObject1 = paramArCloudConfigInfo.j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_marker_feature/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.j.a);
      ((StringBuilder)localObject2).append("_signature.db");
      ((ArFeatureInfo)localObject1).d = ((StringBuilder)localObject2).toString();
      localObject1 = paramArCloudConfigInfo.j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_marker_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((ArFeatureInfo)localObject1).e = ((StringBuilder)localObject2).toString();
    }
    if (paramArCloudConfigInfo.k != null)
    {
      localObject1 = paramArCloudConfigInfo.k;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_marker_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.k.b);
      ((StringBuilder)localObject2).append("_model.zip");
      ((ArModelResource)localObject1).h = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.n == 1) && (paramArCloudConfigInfo.o != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.o.c)))
    {
      localObject1 = paramArCloudConfigInfo.o;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_relationship/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.o.c);
      ((StringBuilder)localObject2).append("_relationship.zip");
      ((ARRelationShip)localObject1).d = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.r != null))
    {
      localObject1 = paramArCloudConfigInfo.r;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_transfer/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.r.h);
      ((StringBuilder)localObject2).append(".zip");
      ((ARTransferDoorConfigInfo)localObject1).i = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.i != null) && (paramArCloudConfigInfo.i.size() > 0))
    {
      localObject1 = paramArCloudConfigInfo.i.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
        if (((ArVideoResourceInfo)localObject2).h == 4)
        {
          ((ArVideoResourceInfo)localObject2).j = AROnlineVideoUtil.a(((ArVideoResourceInfo)localObject2).i);
        }
        else if (paramArCloudConfigInfo.j != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramArCloudConfigInfo.j.e);
          localStringBuilder.append(((ArVideoResourceInfo)localObject2).e);
          localStringBuilder.append("_model.zip");
          ((ArVideoResourceInfo)localObject2).j = localStringBuilder.toString();
        }
      }
    }
    return true;
  }
  
  private boolean a(String paramString, ARCloudMarkerRecogResult paramARCloudMarkerRecogResult)
  {
    if (paramARCloudMarkerRecogResult == null) {
      return false;
    }
    try
    {
      paramARCloudMarkerRecogResult = new String(paramARCloudMarkerRecogResult.g[0].g, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_config.dat");
      paramString = localStringBuilder.toString();
      return ArResourceConfigUtils.a(paramARCloudMarkerRecogResult, g(), paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramARCloudMarkerRecogResult = new StringBuilder();
      paramARCloudMarkerRecogResult.append("saveJsonConfigInfo failed. error msg = ");
      paramARCloudMarkerRecogResult.append(paramString.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARCloudMarkerRecogResult.toString());
    }
    return false;
  }
  
  private void b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo != null)
    {
      int i1 = 0;
      while (i1 < this.s.size())
      {
        if ((paramArCloudConfigInfo.k != null) && (paramArCloudConfigInfo.j.a.equals(((ArCloudConfigInfo)this.s.get(i1)).j.a))) {
          return;
        }
        i1 += 1;
      }
      this.s.add(paramArCloudConfigInfo);
    }
  }
  
  private void b(ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneModelResources");
    if (paramArCloudConfigInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArCloudConfigInfo.m != null) && (paramArCloudConfigInfo.m.a()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(r);
      ((StringBuilder)localObject1).append("pddata/app/offline/html5/");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.m.d);
      ((StringBuilder)localObject1).append(File.separator);
      if ((!new File(((StringBuilder)localObject1).toString()).exists()) && (!TextUtils.isEmpty(paramArCloudConfigInfo.m.d)))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 4;
        ((ARResourceDownload.DownloadInfo)localObject1).b = String.valueOf(paramArCloudConfigInfo.m.d);
        localArrayList.add(localObject1);
      }
    }
    if ((paramArCloudConfigInfo.r != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.r.i))) {
      if (!new File(paramArCloudConfigInfo.r.i).exists())
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 7;
        ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.r.f;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.r.h;
        ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.r.g;
        ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.r.i;
        ((ARResourceDownload.DownloadInfo)localObject1).e = true;
        localArrayList.add(localObject1);
      }
    }
    try
    {
      ArResourceConfigUtils.b(paramArCloudConfigInfo.r.i, ARResouceDir.a(paramArCloudConfigInfo.r.h));
    }
    catch (Exception localException1)
    {
      label283:
      break label283;
    }
    if ((paramArCloudConfigInfo.n == 1) && (paramArCloudConfigInfo.o != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.o.d))) {
      if (!new File(paramArCloudConfigInfo.o.d).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(r);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.o.c);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!new File((String)localObject1).exists()) {}
      }
    }
    try
    {
      ArResourceConfigUtils.b((String)localObject1, ARResouceDir.b());
    }
    catch (Exception localException2)
    {
      label403:
      break label403;
    }
    Object localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).a = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.o.b;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.o.c;
    ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.o.h;
    ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.o.d;
    ((ARResourceDownload.DownloadInfo)localObject1).e = true;
    localArrayList.add(localObject1);
    break label565;
    localObject1 = new ARResourceDownload.DownloadInfo();
    ((ARResourceDownload.DownloadInfo)localObject1).a = 6;
    ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.o.b;
    ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.o.c;
    ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.o.h;
    ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.o.d;
    ((ARResourceDownload.DownloadInfo)localObject1).e = true;
    localArrayList.add(localObject1);
    try
    {
      ArResourceConfigUtils.b(paramArCloudConfigInfo.o.d, ARResouceDir.b());
    }
    catch (Exception localException3)
    {
      label565:
      Object localObject2;
      break label565;
    }
    if ((paramArCloudConfigInfo.e == 0) || (paramArCloudConfigInfo.e == 7) || (paramArCloudConfigInfo.e == 8))
    {
      if (paramArCloudConfigInfo.k != null) {
        localObject1 = new File(paramArCloudConfigInfo.k.h);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
      } else {
        localObject2 = null;
      }
      if ((localObject1 == null) || (!((File)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramArCloudConfigInfo.k.b))) {}
    }
    try
    {
      localObject1 = new File(paramArCloudConfigInfo.k.h);
      localObject2 = paramArCloudConfigInfo.k.h;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((File)localObject1).getParentFile().getAbsolutePath());
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(paramArCloudConfigInfo.k.b);
      ((StringBuilder)localObject3).append(File.separator);
      ArResourceConfigUtils.b((String)localObject2, ((StringBuilder)localObject3).toString());
      paramARMarkerResourceCallback.c(true, paramArCloudConfigInfo);
      QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete.");
    }
    catch (Exception localException4)
    {
      Object localObject3;
      label784:
      break label784;
    }
    new File(paramArCloudConfigInfo.k.h).delete();
    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete. uncompressZip error.");
    paramARMarkerResourceCallback.c(false, paramArCloudConfigInfo);
    return;
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null) && (paramArCloudConfigInfo.e == 7))
    {
      if ((paramArCloudConfigInfo.k != null) && (paramArCloudConfigInfo.k.b != null))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(r);
        ((StringBuilder)localObject1).append("ar_model/0/");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.k.b);
        ((StringBuilder)localObject1).append("_model.zip");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.k.b);
      ((StringBuilder)localObject2).append(File.separator);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject1).exists()) {}
    }
    try
    {
      ArResourceConfigUtils.b((String)localObject1, (String)localObject2);
    }
    catch (Exception localException5)
    {
      label1009:
      break label1009;
    }
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null))
    {
      localObject1 = new ARResourceDownload.DownloadInfo();
      ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
      ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.k.c;
      ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.k.b;
      this.j = (paramArCloudConfigInfo.k.a / 8192L);
      ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.k.a;
      this.p += this.j;
      this.l = System.currentTimeMillis();
      ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.k.h;
      ((ARResourceDownload.DownloadInfo)localObject1).e = true;
      localArrayList.add(localObject1);
      break label1360;
      if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null))
      {
        localObject1 = new ARResourceDownload.DownloadInfo();
        ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
        ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.k.c;
        ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.k.b;
        this.j = (paramArCloudConfigInfo.k.a / 8192L);
        ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.k.a;
        this.p += this.j;
        this.l = System.currentTimeMillis();
        ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.k.h;
        ((ARResourceDownload.DownloadInfo)localObject1).e = true;
        localArrayList.add(localObject1);
        break label1360;
        if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.k != null))
        {
          localObject1 = new ARResourceDownload.DownloadInfo();
          ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
          ((ARResourceDownload.DownloadInfo)localObject1).b = paramArCloudConfigInfo.k.c;
          ((ARResourceDownload.DownloadInfo)localObject1).c = paramArCloudConfigInfo.k.b;
          this.j = (paramArCloudConfigInfo.k.a / 8192L);
          ((ARResourceDownload.DownloadInfo)localObject1).g = paramArCloudConfigInfo.k.a;
          this.p += this.j;
          this.l = System.currentTimeMillis();
          ((ARResourceDownload.DownloadInfo)localObject1).d = paramArCloudConfigInfo.k.h;
          ((ARResourceDownload.DownloadInfo)localObject1).e = true;
          localArrayList.add(localObject1);
        }
      }
    }
    label1360:
    if ((paramArCloudConfigInfo.i != null) && (paramArCloudConfigInfo.i.size() > 0))
    {
      localObject2 = new ArrayList();
      localObject3 = paramArCloudConfigInfo.i.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)((Iterator)localObject3).next();
        if (localArVideoResourceInfo.h != 4)
        {
          File localFile = new File(localArVideoResourceInfo.j);
          if (localFile.exists()) {
            localObject1 = PortalUtils.a(localFile.getAbsolutePath());
          } else {
            localObject1 = null;
          }
          if (((!localFile.exists()) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localArVideoResourceInfo.e))) && (!((ArrayList)localObject2).contains(localArVideoResourceInfo.i)))
          {
            localObject1 = new ARResourceDownload.DownloadInfo();
            ((ARResourceDownload.DownloadInfo)localObject1).a = 3;
            ((ARResourceDownload.DownloadInfo)localObject1).b = localArVideoResourceInfo.i;
            ((ARResourceDownload.DownloadInfo)localObject1).c = localArVideoResourceInfo.e;
            this.j = (localArVideoResourceInfo.b / 8192L);
            ((ARResourceDownload.DownloadInfo)localObject1).g = localArVideoResourceInfo.b;
            this.p += this.j;
            this.l = System.currentTimeMillis();
            ((ARResourceDownload.DownloadInfo)localObject1).d = localArVideoResourceInfo.j;
            ((ARResourceDownload.DownloadInfo)localObject1).e = false;
            localArrayList.add(localObject1);
            ((ArrayList)localObject2).add(localArVideoResourceInfo.i);
          }
        }
      }
    }
    if ((paramARMarkerResourceCallback != null) && (paramArCloudConfigInfo.b())) {
      paramARMarkerResourceCallback.i();
    }
    if (localArrayList.size() > 0)
    {
      this.t.a(localArrayList, new ARMarkerResourceManager.5(this, paramARMarkerResourceCallback, paramArCloudConfigInfo));
      return;
    }
    paramARMarkerResourceCallback.c(true, paramArCloudConfigInfo);
  }
  
  private static boolean c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    Object localObject1;
    Object localObject2;
    if (paramArCloudConfigInfo.j != null)
    {
      localObject1 = paramArCloudConfigInfo.j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((ArFeatureInfo)localObject1).e = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.n == 1) && (paramArCloudConfigInfo.o != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.o.c)))
    {
      localObject1 = paramArCloudConfigInfo.o;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_relationship/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.o.c);
      ((StringBuilder)localObject2).append("_relationship.zip");
      ((ARRelationShip)localObject1).d = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.r != null))
    {
      localObject1 = paramArCloudConfigInfo.r;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_transfer/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.r.h);
      ((StringBuilder)localObject2).append(".zip");
      ((ARTransferDoorConfigInfo)localObject1).i = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.i != null) && (paramArCloudConfigInfo.i.size() > 0))
    {
      localObject1 = paramArCloudConfigInfo.i.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
        if (((ArVideoResourceInfo)localObject2).h == 4)
        {
          ((ArVideoResourceInfo)localObject2).j = AROnlineVideoUtil.a(((ArVideoResourceInfo)localObject2).i);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(r);
          localStringBuilder.append("ar_cloud_classfiy_model/");
          localStringBuilder.append(paramArCloudConfigInfo.e);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(((ArVideoResourceInfo)localObject2).e);
          localStringBuilder.append("_model.zip");
          ((ArVideoResourceInfo)localObject2).j = localStringBuilder.toString();
        }
      }
    }
    if (paramArCloudConfigInfo.k != null)
    {
      localObject1 = paramArCloudConfigInfo.k;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_classfiy_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.k.b);
      ((StringBuilder)localObject2).append("_model.zip");
      ((ArModelResource)localObject1).h = ((StringBuilder)localObject2).toString();
    }
    return true;
  }
  
  private static boolean d(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (paramArCloudConfigInfo == null) {
      return false;
    }
    a();
    Object localObject1;
    Object localObject2;
    if (paramArCloudConfigInfo.j != null)
    {
      localObject1 = paramArCloudConfigInfo.j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_scene_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((ArFeatureInfo)localObject1).e = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.n == 1) && (paramArCloudConfigInfo.o != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.o.c)))
    {
      localObject1 = paramArCloudConfigInfo.o;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_relationship/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.o.c);
      ((StringBuilder)localObject2).append("_relationship.zip");
      ((ARRelationShip)localObject1).d = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.c()) && (paramArCloudConfigInfo.r != null))
    {
      localObject1 = paramArCloudConfigInfo.r;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_transfer/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.r.h);
      ((StringBuilder)localObject2).append(".zip");
      ((ARTransferDoorConfigInfo)localObject1).i = ((StringBuilder)localObject2).toString();
    }
    if ((paramArCloudConfigInfo.i != null) && (paramArCloudConfigInfo.i.size() > 0))
    {
      localObject1 = paramArCloudConfigInfo.i.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
        if (((ArVideoResourceInfo)localObject2).h == 4)
        {
          ((ArVideoResourceInfo)localObject2).j = AROnlineVideoUtil.a(((ArVideoResourceInfo)localObject2).i);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(r);
          localStringBuilder.append("ar_cloud_scene_model/");
          localStringBuilder.append(paramArCloudConfigInfo.e);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(((ArVideoResourceInfo)localObject2).e);
          localStringBuilder.append("_model.zip");
          ((ArVideoResourceInfo)localObject2).j = localStringBuilder.toString();
        }
      }
    }
    if (paramArCloudConfigInfo.k != null)
    {
      localObject1 = paramArCloudConfigInfo.k;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("ar_cloud_scene_model/");
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.e);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramArCloudConfigInfo.k.b);
      ((StringBuilder)localObject2).append("_model.zip");
      ((ArModelResource)localObject1).h = ((StringBuilder)localObject2).toString();
    }
    return true;
  }
  
  private static String g()
  {
    a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(r);
    localStringBuilder.append("ar_cloud_marker_config/");
    return localStringBuilder.toString();
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    a(paramLong);
    a(paramBoolean);
    ARReport.a().b(System.currentTimeMillis() - l1);
  }
  
  public boolean a(ARCloudMarkerRecogResult paramARCloudMarkerRecogResult, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String arg4)
  {
    try
    {
      Object localObject = new String(paramARCloudMarkerRecogResult.g[0].g, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downLoadMarkerConfig. jsonContent = ");
      localStringBuilder.append((String)localObject);
      QLog.i("AREngine_ARMarkerResourceManager", 1, localStringBuilder.toString());
      localObject = ARCloudMarkerJsonParser.a((String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downLoadMarkerConfig. config = ");
      localStringBuilder.append(localObject);
      QLog.i("AREngine_ARMarkerResourceManager", 1, localStringBuilder.toString());
      if ((localObject != null) && (((ArCloudConfigInfo)localObject).j != null))
      {
        if (((ArCloudConfigInfo)localObject).r != null) {
          if ((!ARVideoUtil.a()) && (PromotionDevice.a()))
          {
            if (((ArCloudConfigInfo)localObject).f != null) {
              ReportController.b(null, "CliOper", "", "", "0X80098CB", "0X80098CB", 0, 0, ((ArCloudConfigInfo)localObject).f, "0", "0", "");
            }
          }
          else
          {
            QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig pause because of device not support");
            return false;
          }
        }
        if (((ArCloudConfigInfo)localObject).n == 1)
        {
          ARVideoUtil.a();
          return false;
        }
        if ((paramBoolean) && ((((ArCloudConfigInfo)localObject).n != 1) || (((ArCloudConfigInfo)localObject).o == null) || (TextUtils.isEmpty(((ArCloudConfigInfo)localObject).o.a)) || (!((ArCloudConfigInfo)localObject).o.a.equals(???)))) {
          return false;
        }
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig");
        a((ArCloudConfigInfo)localObject);
        synchronized (this.a)
        {
          a(paramARCloudMarkerRecogResult, paramARMarkerResourceCallback, (ArCloudConfigInfo)localObject);
          return true;
        }
      }
      QLog.i("AREngine_ARMarkerResourceManager", 1, "ARCloud Marker Recog failed.");
      return false;
    }
    catch (Exception paramARCloudMarkerRecogResult)
    {
      paramARMarkerResourceCallback = new StringBuilder();
      paramARMarkerResourceCallback.append("downLoadMarkerConfig. parse json failed. error msg = ");
      paramARMarkerResourceCallback.append(paramARCloudMarkerRecogResult.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARMarkerResourceCallback.toString());
    }
    return false;
  }
  
  public boolean a(ARCloudObjectClassifyCommonInterface paramARCloudObjectClassifyCommonInterface, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String arg4)
  {
    if (paramARCloudObjectClassifyCommonInterface == null) {
      return false;
    }
    paramARCloudObjectClassifyCommonInterface = paramARCloudObjectClassifyCommonInterface.c();
    if (paramARCloudObjectClassifyCommonInterface == null) {
      return false;
    }
    try
    {
      paramARCloudObjectClassifyCommonInterface = new String(paramARCloudObjectClassifyCommonInterface, "utf-8");
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("downLoadMarkerConfig. jsonContent = ");
        ???.append(paramARCloudObjectClassifyCommonInterface);
        QLog.i("AREngine_ARMarkerResourceManager", 2, ???.toString());
      }
      paramARCloudObjectClassifyCommonInterface = ARCloudMarkerJsonParser.a(paramARCloudObjectClassifyCommonInterface);
      ??? = new StringBuilder();
      ???.append("downLoadMarkerConfig. config = ");
      ???.append(paramARCloudObjectClassifyCommonInterface);
      QLog.i("AREngine_ARMarkerResourceManager", 1, ???.toString());
      if (paramARCloudObjectClassifyCommonInterface == null) {
        return false;
      }
      if (paramARCloudObjectClassifyCommonInterface.r != null) {
        if ((!ARVideoUtil.a()) && (PromotionDevice.a()))
        {
          if (paramARCloudObjectClassifyCommonInterface.f != null) {
            ReportController.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramARCloudObjectClassifyCommonInterface.f, "0", "0", "");
          }
        }
        else
        {
          QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectConfig pause because of device not support");
          return false;
        }
      }
      if ((paramARCloudObjectClassifyCommonInterface.n != 1) && (paramARCloudObjectClassifyCommonInterface.e != 7))
      {
        c(paramARCloudObjectClassifyCommonInterface);
        if ((QLog.isDebugVersion()) && (paramARCloudObjectClassifyCommonInterface.d == 0)) {
          ThreadManager.getUIHandler().post(new ARMarkerResourceManager.1(this));
        }
        paramARCloudObjectClassifyCommonInterface.d = Math.max(1, paramARCloudObjectClassifyCommonInterface.d);
        synchronized (this.a)
        {
          a(paramARMarkerResourceCallback, paramARCloudObjectClassifyCommonInterface);
          return true;
        }
      }
      QLog.i("AREngine_ARMarkerResourceManager", 1, "ar card not support");
      return false;
    }
    catch (UnsupportedEncodingException paramARCloudObjectClassifyCommonInterface)
    {
      paramARMarkerResourceCallback = new StringBuilder();
      paramARMarkerResourceCallback.append("processObjectClassifyRecogResult. parse json failed. error msg = ");
      paramARMarkerResourceCallback.append(paramARCloudObjectClassifyCommonInterface.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARMarkerResourceCallback.toString());
    }
    return false;
  }
  
  public boolean a(ARCloudSceneRecogResult paramARCloudSceneRecogResult, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, boolean paramBoolean, String arg4)
  {
    if (paramARCloudSceneRecogResult == null) {
      return false;
    }
    paramARCloudSceneRecogResult = paramARCloudSceneRecogResult.a();
    if (paramARCloudSceneRecogResult == null) {
      return false;
    }
    try
    {
      paramARCloudSceneRecogResult = new String(paramARCloudSceneRecogResult, "utf-8");
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("downLoadSceneConfig. jsonContent = ");
        ???.append(paramARCloudSceneRecogResult);
        QLog.i("AREngine_ARMarkerResourceManager", 2, ???.toString());
      }
      paramARCloudSceneRecogResult = ARCloudMarkerJsonParser.a(paramARCloudSceneRecogResult);
      ??? = new StringBuilder();
      ???.append("downLoadSceneConfig. config = ");
      ???.append(paramARCloudSceneRecogResult);
      QLog.i("AREngine_ARMarkerResourceManager", 1, ???.toString());
      if (paramARCloudSceneRecogResult == null) {
        return false;
      }
      if (paramARCloudSceneRecogResult.r != null) {
        if ((!ARVideoUtil.a()) && (PromotionDevice.a()))
        {
          if (paramARCloudSceneRecogResult.f != null) {
            ReportController.b(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, paramARCloudSceneRecogResult.f, "0", "0", "");
          }
        }
        else
        {
          QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig pause because of device not support");
          return false;
        }
      }
      if (paramARCloudSceneRecogResult.n == 1) {
        try
        {
          ARVideoUtil.a();
          return false;
        }
        catch (Exception ???)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" HotVideoUtils.saveBlurBitmap e = ");
          localStringBuilder.append(???.getMessage());
          QLog.i("AREngine_ARMarkerResourceManager", 1, localStringBuilder.toString());
        }
      }
      if ((paramBoolean) && ((paramARCloudSceneRecogResult.n != 1) || (paramARCloudSceneRecogResult.o == null) || (!paramARCloudSceneRecogResult.b()))) {
        return false;
      }
      d(paramARCloudSceneRecogResult);
      if ((QLog.isDebugVersion()) && (paramARCloudSceneRecogResult.d == 0)) {
        ThreadManager.getUIHandler().post(new ARMarkerResourceManager.2(this));
      }
      paramARCloudSceneRecogResult.d = Math.max(1, paramARCloudSceneRecogResult.d);
      synchronized (this.a)
      {
        b(paramARMarkerResourceCallback, paramARCloudSceneRecogResult);
        return true;
      }
      return false;
    }
    catch (UnsupportedEncodingException paramARCloudSceneRecogResult)
    {
      paramARMarkerResourceCallback = new StringBuilder();
      paramARMarkerResourceCallback.append("processSceneRecogResult. parse json failed. error msg = ");
      paramARMarkerResourceCallback.append(paramARCloudSceneRecogResult.getMessage());
      QLog.i("AREngine_ARMarkerResourceManager", 1, paramARMarkerResourceCallback.toString());
    }
  }
  
  public ArrayList<ArCloudConfigInfo> b()
  {
    return this.s;
  }
  
  public void c()
  {
    synchronized (this.a)
    {
      if (this.t != null) {
        this.t.b();
      }
      return;
    }
  }
  
  public void d()
  {
    ARResourceManagerTools localARResourceManagerTools = this.t;
    if (localARResourceManagerTools != null) {
      localARResourceManagerTools.c();
    }
  }
  
  public void e()
  {
    this.c = 0L;
    this.d = 0L;
    this.e = null;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = -1;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = -1;
    this.n = 0L;
    this.o = -1;
    this.p = 0L;
    this.q = -1;
  }
  
  public void f()
  {
    QLog.i("AREngine_ARMarkerResourceManager", 1, "arCloudDownloadReport start.");
    ARReport.a().a(this.e, this.f, this.g, this.i, this.j, this.k, this.m, this.n, this.o, this.d - this.c, this.p, this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager
 * JD-Core Version:    0.7.0.1
 */