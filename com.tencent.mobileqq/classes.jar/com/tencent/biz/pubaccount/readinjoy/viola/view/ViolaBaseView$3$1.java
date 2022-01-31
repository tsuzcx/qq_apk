package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bace;
import obz;
import rne;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(rne paramrne) {}
  
  public void run()
  {
    Object localObject = bace.a("viola_cache_file_viola_qq_page_data_main_js_" + obz.a());
    if (localObject == null) {
      bace.a("viola_cache_file_viola_qq_page_data_main_js_" + obz.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    bace.a("viola_cache_file_viola_qq_page_data_main_js_" + obz.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */