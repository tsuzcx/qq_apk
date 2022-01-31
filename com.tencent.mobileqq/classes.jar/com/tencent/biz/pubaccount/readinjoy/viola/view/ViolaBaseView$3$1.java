package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bbdj;
import onk;
import rzx;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(rzx paramrzx) {}
  
  public void run()
  {
    Object localObject = bbdj.a("viola_cache_file_viola_qq_page_data_new_main_js_" + onk.a());
    if (localObject == null) {
      bbdj.a("viola_cache_file_viola_qq_page_data_new_main_js_" + onk.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    bbdj.a("viola_cache_file_viola_qq_page_data_new_main_js_" + onk.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */