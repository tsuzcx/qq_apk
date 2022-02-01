package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bhmi;
import com.tencent.viola.utils.ViolaUtils;
import ozs;

class ViolaBaseView$18
  implements Runnable
{
  ViolaBaseView$18(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    Object localObject = bhmi.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + ozs.a());
    if (localObject == null) {
      bhmi.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + ozs.a(), ViolaBaseView.b(this.this$0));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.b(this.this$0).equals(localObject))) {
      return;
    }
    bhmi.a("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + ozs.a(), ViolaBaseView.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.18
 * JD-Core Version:    0.7.0.1
 */