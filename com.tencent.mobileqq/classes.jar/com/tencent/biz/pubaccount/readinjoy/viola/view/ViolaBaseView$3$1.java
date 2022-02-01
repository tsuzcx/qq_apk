package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.mobileqq.utils.FileUtils;
import pay;
import tos;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(tos paramtos) {}
  
  public void run()
  {
    Object localObject = FileUtils.readObject("viola_cache_file_viola_qq_page_data_new_main_js_" + pay.a());
    if (localObject == null) {
      FileUtils.writeObject("viola_cache_file_viola_qq_page_data_new_main_js_" + pay.a(), ViolaBaseView.a(this.a.a));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.a).equals(localObject))) {
      return;
    }
    FileUtils.writeObject("viola_cache_file_viola_qq_page_data_new_main_js_" + pay.a(), ViolaBaseView.a(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */