package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.FileUtils;

class ViolaBaseView$6$1
  implements Runnable
{
  ViolaBaseView$6$1(ViolaBaseView.6 param6) {}
  
  public void run()
  {
    Object localObject = FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ReadInJoyUtils.a());
    if (localObject == null) {
      FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ReadInJoyUtils.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ReadInJoyUtils.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.6.1
 * JD-Core Version:    0.7.0.1
 */