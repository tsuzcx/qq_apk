package com.tencent.biz.common.offline;

import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.util.NetworkUtil;

class HtmlOffline$6$1
  implements AsyncBack
{
  HtmlOffline$6$1(HtmlOffline.6 param6) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (HtmlOffline.b(this.a.b)) {
        this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.b(this.a.b);
      HtmlOffline.a(this.a.b, paramInt, l, NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 6);
      continue;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 2);
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.6.1
 * JD-Core Version:    0.7.0.1
 */