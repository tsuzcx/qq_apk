package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bgmg;
import pha;
import tsl;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(tsl paramtsl) {}
  
  public void run()
  {
    Object localObject = bgmg.a("viola_cache_file_viola_qq_page_data_new_main_js_" + pha.a());
    if (localObject == null) {
      bgmg.a("viola_cache_file_viola_qq_page_data_new_main_js_" + pha.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    bgmg.a("viola_cache_file_viola_qq_page_data_new_main_js_" + pha.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */