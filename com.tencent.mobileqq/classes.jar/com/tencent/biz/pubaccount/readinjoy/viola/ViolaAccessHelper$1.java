package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.app.AppRuntime;

final class ViolaAccessHelper$1
  implements Runnable
{
  public void run()
  {
    ViolaAccessHelper.b(Integer.toString(3256));
    ViolaAccessHelper.b(ViolaBizUtils.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547"));
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = FileUtils.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ((AppRuntime)localObject).getAccount());
      if (!(localObject instanceof String)) {}
    }
    for (localObject = (String)localObject;; localObject = null)
    {
      ViolaAccessHelper.b(null, (String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.1
 * JD-Core Version:    0.7.0.1
 */