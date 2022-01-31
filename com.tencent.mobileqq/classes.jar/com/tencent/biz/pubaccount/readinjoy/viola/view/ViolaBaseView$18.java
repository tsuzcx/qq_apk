package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bbdj;
import com.tencent.viola.utils.ViolaUtils;
import onk;

class ViolaBaseView$18
  implements Runnable
{
  ViolaBaseView$18(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    Object localObject = bbdj.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + onk.a());
    if (localObject == null) {
      bbdj.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + onk.a(), ViolaBaseView.b(this.this$0));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.b(this.this$0).equals(localObject))) {
      return;
    }
    bbdj.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + onk.a(), ViolaBaseView.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.18
 * JD-Core Version:    0.7.0.1
 */