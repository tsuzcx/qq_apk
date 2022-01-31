package com.tencent.biz.pubaccount.readinjoy.viola;

import android.text.TextUtils;
import bace;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import mqq.app.AppRuntime;
import rjb;
import rjd;
import rmb;

public final class ViolaAccessHelper$2
  implements Runnable
{
  public void run()
  {
    rjb.a(Integer.toString(3256));
    rjb.a(rmb.a("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/Viola.min.0.3.10.js?v_bid=3547"));
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null)
    {
      localObject1 = bace.a("viola_cache_file_viola_qq_page_data_main_js_" + ((AppRuntime)localObject1).getAccount());
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
    }
    while ((rjb.a()) && (rjb.b()) && (((!TextUtils.isEmpty(null)) && (new File(null).exists())) || (!TextUtils.isEmpty((CharSequence)localObject1)))) {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          rjb.a((String)localObject1, new rjd(this));
          return;
          localObject1 = ViolaUtils.readFile(new File(null));
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.2
 * JD-Core Version:    0.7.0.1
 */