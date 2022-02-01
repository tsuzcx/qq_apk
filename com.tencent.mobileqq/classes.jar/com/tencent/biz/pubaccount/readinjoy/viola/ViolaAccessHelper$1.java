package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.app.AppRuntime;
import tto;
import tzr;

public final class ViolaAccessHelper$1
  implements Runnable
{
  public void run()
  {
    tto.b(Integer.toString(3256));
    tto.b(tzr.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547"));
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = FileUtils.readObject("viola_cache_file_viola_qq_page_data_new_main_js_" + ((AppRuntime)localObject).getAccount());
      if (!(localObject instanceof String)) {}
    }
    for (localObject = (String)localObject;; localObject = null)
    {
      tto.b(null, (String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.1
 * JD-Core Version:    0.7.0.1
 */