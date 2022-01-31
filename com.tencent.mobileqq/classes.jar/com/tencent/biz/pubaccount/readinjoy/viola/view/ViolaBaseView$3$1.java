package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bdcs;
import ors;
import srb;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(srb paramsrb) {}
  
  public void run()
  {
    Object localObject = bdcs.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ors.a());
    if (localObject == null) {
      bdcs.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ors.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    bdcs.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ors.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */