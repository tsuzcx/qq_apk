package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.FileUtils;

class ViolaAccessHelper$5$2$1
  implements Runnable
{
  ViolaAccessHelper$5$2$1(ViolaAccessHelper.5.2 param2, String paramString) {}
  
  public void run()
  {
    Object localObject = FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ReadInJoyUtils.a());
    if (localObject == null) {
      FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ReadInJoyUtils.a(), this.jdField_a_of_type_JavaLangString);
    }
    while ((!(localObject instanceof String)) || (this.jdField_a_of_type_JavaLangString.equals(localObject))) {
      return;
    }
    FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ReadInJoyUtils.a(), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.5.2.1
 * JD-Core Version:    0.7.0.1
 */