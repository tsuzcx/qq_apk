package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceHandler;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.utils.AvatarImplUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class NearByFaceDownloader$HeadCostStatRunnable
  implements Runnable
{
  int a = 0;
  int b;
  int c;
  String d;
  int e;
  long f;
  FaceInfo g;
  
  public NearByFaceDownloader$HeadCostStatRunnable(NearByFaceDownloader paramNearByFaceDownloader, int paramInt1, FaceInfo paramFaceInfo, int paramInt2, int paramInt3, String paramString, int paramInt4, long paramLong)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramString;
    this.e = paramInt4;
    this.f = paramLong;
    this.g = paramFaceInfo;
  }
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.g.p.dstUsrType);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(this.g.d);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(this.g.c);
    localObject1 = ((StringBuilder)localObject1).toString();
    this.this$0.b.a((String)localObject1, false);
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      long l1 = this.g.o[FaceInfo.y];
      long l4 = 0L;
      if ((l1 > 0L) && (this.g.o[FaceInfo.x] > 0L)) {
        l1 = this.g.o[FaceInfo.y] - this.g.o[FaceInfo.x];
      } else {
        l1 = 0L;
      }
      long l2;
      if ((this.g.o[FaceInfo.z] > this.g.o[FaceInfo.y]) && (this.g.o[FaceInfo.y] > 0L)) {
        l2 = this.g.o[FaceInfo.z] - this.g.o[FaceInfo.y];
      } else {
        l2 = 0L;
      }
      long l3 = l4;
      if (this.g.o[FaceInfo.A] > 0L)
      {
        l3 = l4;
        if (this.g.o[FaceInfo.z] > 0L) {
          l3 = this.g.o[FaceInfo.A] - this.g.o[FaceInfo.z];
        }
      }
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("key", localObject1);
      ((HashMap)localObject2).put("totalTime", String.valueOf((float)this.f / 1000.0F));
      ((HashMap)localObject2).put("downInfo_time", String.valueOf(l1));
      ((HashMap)localObject2).put("downInfo_stime", String.valueOf((float)l1 / 1000.0F));
      ((HashMap)localObject2).put("interval_time", String.valueOf(l2));
      ((HashMap)localObject2).put("downPic_time", String.valueOf(l3));
      ((HashMap)localObject2).put("downPic_stime", String.valueOf((float)l3 / 1000.0F));
      ((HashMap)localObject2).put("downPic_size", String.valueOf(this.c));
      ((HashMap)localObject2).put("download_url", this.d);
      ((HashMap)localObject2).put("param_FailCode", Integer.toString(this.a));
      ((HashMap)localObject2).put("fail_reason", Integer.toString(this.e));
      ((HashMap)localObject2).put("ssoAndHttp", String.valueOf(this.g.q));
      Object localObject3 = AvatarImplUtil.d(32);
      Object localObject4 = StatisticCollector.getInstance(BaseApplication.getContext());
      String str = this.this$0.a.getCurrentAccountUin();
      boolean bool;
      if (this.a == 0) {
        bool = true;
      } else {
        bool = false;
      }
      l4 = this.f;
      int i = 1;
      ((StatisticCollector)localObject4).collectPerformance(str, (String)localObject3, bool, l4, 0L, (HashMap)localObject2, "");
      localObject3 = StatisticCollector.getInstance(BaseApplication.getContext());
      localObject4 = this.this$0.a.getCurrentAccountUin();
      if (this.a == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((StatisticCollector)localObject3).collectPerformance((String)localObject4, "actGetNearbyHead", bool, this.f, 0L, (HashMap)localObject2, "");
      if ((QLog.isColorLevel()) || (this.f > 3000L))
      {
        localObject2 = new StringBuffer(200);
        ((StringBuffer)localObject2).append("NearByFaceDownloader resultCode=");
        ((StringBuffer)localObject2).append(this.a);
        ((StringBuffer)localObject2).append(", key=");
        ((StringBuffer)localObject2).append((String)localObject1);
        ((StringBuffer)localObject2).append(", totalTime=");
        ((StringBuffer)localObject2).append(String.format("%-5s", new Object[] { Long.valueOf(this.f) }));
        ((StringBuffer)localObject2).append(", downInfoTime=");
        ((StringBuffer)localObject2).append(l1);
        ((StringBuffer)localObject2).append(", intervalTime=");
        ((StringBuffer)localObject2).append(l2);
        ((StringBuffer)localObject2).append(", picSize=");
        ((StringBuffer)localObject2).append(String.valueOf(this.c));
        ((StringBuffer)localObject2).append(", downPicTime=");
        ((StringBuffer)localObject2).append(l3);
        ((StringBuffer)localObject2).append(", reasonCode=");
        ((StringBuffer)localObject2).append(this.e);
        ((StringBuffer)localObject2).append(", downUrl=");
        ((StringBuffer)localObject2).append(this.d);
        if (QLog.isColorLevel()) {
          i = 2;
        }
        QLog.i("Q.qqhead.NearByFaceDownloader", i, ((StringBuffer)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader.HeadCostStatRunnable
 * JD-Core Version:    0.7.0.1
 */