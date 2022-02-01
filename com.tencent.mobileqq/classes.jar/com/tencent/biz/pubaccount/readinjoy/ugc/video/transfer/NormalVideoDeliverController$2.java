package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoMetaInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoMetaInfo.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class NormalVideoDeliverController$2
  implements FileUploadController.FileUploadListener
{
  NormalVideoDeliverController$2(NormalVideoDeliverController paramNormalVideoDeliverController) {}
  
  public void a()
  {
    NormalVideoDeliverController.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      NormalVideoDeliverController.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      NormalVideoDeliverController.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(NormalVideoDeliverController.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(NormalVideoDeliverController.a(this.a)), String.valueOf(NormalVideoDeliverController.b(this.a)), String.valueOf(NormalVideoDeliverController.c(this.a) - NormalVideoDeliverController.d(this.a)), String.valueOf(NormalVideoDeliverController.e(this.a) - NormalVideoDeliverController.f(this.a)));
      NormalVideoDeliverController.a(this.a, 0, NormalVideoDeliverController.a(this.a), NormalVideoDeliverController.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = VideoMetaInfo.a().a(NormalVideoDeliverController.a(this.a)).b(NormalVideoDeliverController.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(NormalVideoDeliverController.b(this.a)).b(NormalVideoDeliverController.g(this.a)).a();
      NormalVideoDeliverController.a(this.a, paramString1);
      return;
    case 1001: 
      NormalVideoDeliverController.b(this.a, 6);
      return;
    case 1002: 
      NormalVideoDeliverController.b(this.a, 5);
      return;
    case 1003: 
      NormalVideoDeliverController.b(this.a, 7);
      return;
    case 1004: 
      NormalVideoDeliverController.b(this.a, 7);
      NormalVideoDeliverController.c(this.a, 1004);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(NormalVideoDeliverController.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(NormalVideoDeliverController.a(this.a)), String.valueOf(NormalVideoDeliverController.b(this.a)), String.valueOf(NormalVideoDeliverController.c(this.a) - NormalVideoDeliverController.d(this.a)), String.valueOf(NormalVideoDeliverController.e(this.a) - NormalVideoDeliverController.f(this.a)));
      return;
    }
    NormalVideoDeliverController.b(this.a, 12);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    NormalVideoDeliverController.a(this.a, (float)paramLong1 * 100.0F / (float)paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.NormalVideoDeliverController.2
 * JD-Core Version:    0.7.0.1
 */