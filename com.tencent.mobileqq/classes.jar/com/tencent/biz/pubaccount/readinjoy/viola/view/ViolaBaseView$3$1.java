package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bhmi;
import ozs;
import tji;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(tji paramtji) {}
  
  public void run()
  {
    Object localObject = bhmi.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ozs.a());
    if (localObject == null) {
      bhmi.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ozs.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    bhmi.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ozs.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */