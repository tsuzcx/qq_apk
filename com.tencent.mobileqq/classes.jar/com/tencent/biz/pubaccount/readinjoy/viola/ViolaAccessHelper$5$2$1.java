package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.mobileqq.utils.FileUtils;
import pkh;
import ttt;

public class ViolaAccessHelper$5$2$1
  implements Runnable
{
  public ViolaAccessHelper$5$2$1(ttt paramttt, String paramString) {}
  
  public void run()
  {
    Object localObject = FileUtils.readObject("viola_cache_file_viola_qq_page_data_new_main_js_" + pkh.a());
    if (localObject == null) {
      FileUtils.writeObject("viola_cache_file_viola_qq_page_data_new_main_js_" + pkh.a(), this.jdField_a_of_type_JavaLangString);
    }
    while ((!(localObject instanceof String)) || (this.jdField_a_of_type_JavaLangString.equals(localObject))) {
      return;
    }
    FileUtils.writeObject("viola_cache_file_viola_qq_page_data_new_main_js_" + pkh.a(), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.5.2.1
 * JD-Core Version:    0.7.0.1
 */