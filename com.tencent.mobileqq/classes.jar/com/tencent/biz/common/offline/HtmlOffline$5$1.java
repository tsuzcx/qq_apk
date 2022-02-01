package com.tencent.biz.common.offline;

import com.tencent.biz.common.offline.util.ILog;
import com.tencent.mobileqq.utils.NetworkUtil;

class HtmlOffline$5$1
  implements AsyncBack
{
  HtmlOffline$5$1(HtmlOffline.5 param5) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.e;
    if (HtmlOffline.f.a())
    {
      paramString = HtmlOffline.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("js call downloadUpdate callback:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", time:");
      localStringBuilder.append(l);
      paramString.a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      if (HtmlOffline.b(this.a.c)) {
        this.a.f.loaded(null, 0);
      } else {
        this.a.f.loaded(null, 6);
      }
    }
    else {
      this.a.f.loaded(null, 2);
    }
    BidDownloader.b(this.a.c);
    HtmlOffline.a(this.a.c, paramInt, l, NetworkUtil.getNetWorkType());
  }
  
  public void progress(int paramInt)
  {
    this.a.f.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.5.1
 * JD-Core Version:    0.7.0.1
 */