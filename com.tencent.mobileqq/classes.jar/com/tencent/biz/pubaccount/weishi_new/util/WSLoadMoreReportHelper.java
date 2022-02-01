package com.tencent.biz.pubaccount.weishi_new.util;

import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;

public class WSLoadMoreReportHelper
{
  private String a;
  private String b;
  private int c;
  private boolean d;
  
  public WSLoadMoreReportHelper(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  public void a()
  {
    this.d = false;
  }
  
  public void a(int paramInt)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    WsBeaconReportPresenter.a().b(this.a, this.b, paramInt);
  }
  
  public void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public void b()
  {
    this.c += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadMore() sopName = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", loadMoreTriggerCnt = ");
    localStringBuilder.append(this.c);
    WSLog.b("LoadMoreReportHelper", localStringBuilder.toString());
  }
  
  public void c()
  {
    if (this.c <= 0) {
      return;
    }
    WsBeaconReportPresenter.a().a(this.a, this.b, this.c);
    this.c = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSLoadMoreReportHelper
 * JD-Core Version:    0.7.0.1
 */