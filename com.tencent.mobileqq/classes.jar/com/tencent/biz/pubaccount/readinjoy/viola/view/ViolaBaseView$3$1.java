package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bbdx;
import onh;
import rzu;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(rzu paramrzu) {}
  
  public void run()
  {
    Object localObject = bbdx.a("viola_cache_file_viola_qq_page_data_new_main_js_" + onh.a());
    if (localObject == null) {
      bbdx.a("viola_cache_file_viola_qq_page_data_new_main_js_" + onh.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    bbdx.a("viola_cache_file_viola_qq_page_data_new_main_js_" + onh.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */