package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import UserGrowth.stSchema;
import com.tencent.biz.pubaccount.weishi_new.jump.OnJumpListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

final class WSVerticalJumpUtils$2
  extends OnJumpListener
{
  WSVerticalJumpUtils$2(String paramString1, String paramString2, WSVerticalItemData paramWSVerticalItemData, stSchema paramstSchema, boolean paramBoolean) {}
  
  public void a()
  {
    super.a();
    WSVerticalBeaconReport.a(this.a, this.b, 1000003, this.c, this.d.schema, this.e);
  }
  
  public void b()
  {
    super.b();
    WSVerticalBeaconReport.a(this.a, this.b, 1000007, this.c, this.d.miniAppSchema, this.e);
  }
  
  public void c()
  {
    super.c();
    WSVerticalBeaconReport.a(this.a, this.b, 1000004, this.c, this.d.H5Url, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils.2
 * JD-Core Version:    0.7.0.1
 */