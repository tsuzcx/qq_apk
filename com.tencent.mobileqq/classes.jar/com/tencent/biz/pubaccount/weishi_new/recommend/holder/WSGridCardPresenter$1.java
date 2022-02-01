package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.OnDownloadOpenWeishiGoH5Listener;

class WSGridCardPresenter$1
  implements WeishiUtils.OnDownloadOpenWeishiGoH5Listener
{
  WSGridCardPresenter$1(WSGridCardPresenter paramWSGridCardPresenter, Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void a(String paramString, int paramInt)
  {
    WSGridCardPresenter.a(this.d, this.a, this.b, paramString, this.c, 501);
    WSReportDc00898.a(114, this.c.h5_op_info.type, this.b, this.c.h5_op_info.id);
    WSGridBeaconReport.a("gzh_click", 1000003, this.c, WSGridCardPresenter.a(this.d).l);
  }
  
  public void b(String paramString, int paramInt)
  {
    WSGridCardPresenter.a(this.d, this.a, this.b, this.c);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSGridCardPresenter.a(this.d, this.a, this.c);
    WSReportDc00898.a(115, this.c.h5_op_info.type, this.b, this.c.h5_op_info.id);
    WSGridBeaconReport.a("gzh_click", 1000002, this.c, WSGridCardPresenter.a(this.d).l);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCardPresenter.1
 * JD-Core Version:    0.7.0.1
 */