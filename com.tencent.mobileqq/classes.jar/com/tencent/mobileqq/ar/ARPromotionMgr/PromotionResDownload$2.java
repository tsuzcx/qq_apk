package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;

class PromotionResDownload$2
  implements ResDownloadManager.IResDownloadListener
{
  final long a = QQAudioHelper.d();
  long b = System.currentTimeMillis();
  int c = 0;
  
  PromotionResDownload$2(PromotionResDownload paramPromotionResDownload, AppInterface paramAppInterface, String paramString, int paramInt) {}
  
  public void a() {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt != 100) && (paramInt != 0) && (Math.abs(paramInt - this.c) < 10)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    long l = System.currentTimeMillis();
    if (l - this.b >= 1000L) {
      bool2 = true;
    }
    if ((QLog.isDevelopLevel()) && ((bool2) || (bool1)))
    {
      paramString1 = this.g.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadUpdate, md5[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], activityid[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("], index[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("], curPercent[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], lastPercent[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("], needNotify[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], needNotify2[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("]");
      QLog.w(paramString1, 1, localStringBuilder.toString());
    }
    if (bool1) {
      this.c = paramInt;
    }
    if (bool2) {
      this.b = l;
    }
    if ((bool1) || (bool2)) {
      this.g.a(this.e, this.f, paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if ((paramObject instanceof PromotionConfigInfo.ZipItem))
    {
      paramString1 = (PromotionConfigInfo.ZipItem)paramObject;
      paramString1.n = System.currentTimeMillis();
      paramObject = this.d.getAccount();
      boolean bool = false;
      if (paramInt == 0) {
        bool = PromotionResDownload.a(paramString1);
      }
      String str = this.g.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish, md5[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], errCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], check[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], path[");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("], id[");
      localStringBuilder.append(paramString1.f);
      localStringBuilder.append("], request[");
      localStringBuilder.append(paramString1.l);
      localStringBuilder.append("], Begin[");
      localStringBuilder.append(paramString1.m);
      localStringBuilder.append("], End[");
      localStringBuilder.append(paramString1.n);
      localStringBuilder.append("], 调度耗时[");
      localStringBuilder.append(paramString1.m - paramString1.l);
      localStringBuilder.append("], 下载耗时[");
      localStringBuilder.append(paramString1.n - paramString1.m);
      localStringBuilder.append("], fromPreCover[");
      localStringBuilder.append(paramString1.o);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("], Uin[");
      localStringBuilder.append(LogUtil.getSafePrintUin(paramObject));
      localStringBuilder.append("], zipItem[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (paramString1.i == this) {
        paramString1.i = null;
      }
      int i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (!bool) {
          i = -5;
        }
      }
      if (i == 0)
      {
        paramString1.a(2);
        ARPromotionConfigSP.a(paramObject, paramString1.f, paramString1.a, paramString1.c);
        this.g.a(paramString1.f, paramString1.a, 100);
        paramString1.o = -1;
      }
      else if (i == 100)
      {
        paramString1.a(2);
        this.g.a(paramString1.f, paramString1.a, 100);
      }
      else
      {
        paramString1.a(-1);
        this.g.a(paramString1.f, paramString1.a, -1);
      }
      this.g.a(this.d, paramString1.h, paramString1.f, paramString1.a + 1);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    String str = this.g.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZipItem.finalize, activityid[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], index[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.2
 * JD-Core Version:    0.7.0.1
 */