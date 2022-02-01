package com.tencent.biz.common.offline;

import com.tencent.biz.common.offline.util.ILog;
import com.tencent.mobileqq.utils.NetworkUtil;

class HtmlOffline$5$1
  implements AsyncBack
{
  HtmlOffline$5$1(HtmlOffline.5 param5) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (HtmlOffline.a.a())
    {
      paramString = HtmlOffline.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("js call downloadUpdate callback:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", time:");
      localStringBuilder.append(l);
      paramString.a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      if (HtmlOffline.b(this.a.b)) {
        this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 0);
      } else {
        this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 6);
      }
    }
    else {
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 2);
    }
    BidDownloader.b(this.a.b);
    HtmlOffline.a(this.a.b, paramInt, l, NetworkUtil.getNetWorkType());
  }
  
  public void progress(int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.5.1
 * JD-Core Version:    0.7.0.1
 */