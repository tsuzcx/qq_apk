package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bace;
import com.tencent.viola.utils.ViolaUtils;
import obz;

class ViolaBaseView$17
  implements Runnable
{
  ViolaBaseView$17(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    Object localObject = bace.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + obz.a());
    if (localObject == null) {
      bace.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + obz.a(), ViolaBaseView.b(this.this$0));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.b(this.this$0).equals(localObject))) {
      return;
    }
    bace.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + obz.a(), ViolaBaseView.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.17
 * JD-Core Version:    0.7.0.1
 */