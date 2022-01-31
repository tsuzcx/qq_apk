package com.tencent.biz.pubaccount.readinjoy.viola;

import android.text.TextUtils;
import bbdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import mqq.app.AppRuntime;
import rwa;
import rwc;
import rys;

public final class ViolaAccessHelper$2
  implements Runnable
{
  public void run()
  {
    rwa.a(Integer.toString(3256));
    rwa.a(rys.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547"));
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null)
    {
      localObject1 = bbdj.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ((AppRuntime)localObject1).getAccount());
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
    }
    while ((rwa.a()) && (rwa.b()) && (((!TextUtils.isEmpty(null)) && (new File(null).exists())) || (!TextUtils.isEmpty((CharSequence)localObject1)))) {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          rwa.a((String)localObject1, new rwc(this));
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