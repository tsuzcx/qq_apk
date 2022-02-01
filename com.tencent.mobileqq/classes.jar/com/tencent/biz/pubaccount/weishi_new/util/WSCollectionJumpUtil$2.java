package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.jump.OnJumpListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

final class WSCollectionJumpUtil$2
  extends OnJumpListener
{
  WSCollectionJumpUtil$2(int paramInt1, int paramInt2, stCollection paramstCollection, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString) {}
  
  public void a()
  {
    WSGridBeaconReport.a(this.a, this.b, 1000003, this.c, this.d, this.e);
  }
  
  public void b()
  {
    WSGridBeaconReport.a(this.a, this.b, 1000007, this.c, this.d, this.e);
  }
  
  public void c()
  {
    WSGridBeaconReport.a(this.a, this.b, 1000004, this.c, this.d, this.e);
  }
  
  public void d()
  {
    WSGridBeaconReport.a(this.a, this.b, 1000002, this.c, this.d, this.e);
  }
  
  public void e()
  {
    super.e();
    WSGridBeaconReport.a(this.a, this.b, 1000001, this.c, this.d, this.e);
    WSReportUtils.c(String.valueOf(System.currentTimeMillis()));
    WSVerticalBeaconReport.b(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil.2
 * JD-Core Version:    0.7.0.1
 */