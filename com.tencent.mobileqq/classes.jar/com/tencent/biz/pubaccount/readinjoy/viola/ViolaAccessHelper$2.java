package com.tencent.biz.pubaccount.readinjoy.viola;

import android.text.TextUtils;
import bdcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import mqq.app.AppRuntime;
import smk;
import smm;
import spw;

public final class ViolaAccessHelper$2
  implements Runnable
{
  public void run()
  {
    smk.a(Integer.toString(3256));
    smk.a(spw.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547"));
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null)
    {
      localObject1 = bdcs.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ((AppRuntime)localObject1).getAccount());
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
    }
    while ((smk.a()) && (smk.b()) && (((!TextUtils.isEmpty(null)) && (new File(null).exists())) || (!TextUtils.isEmpty((CharSequence)localObject1)))) {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          smk.a((String)localObject1, new smm(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.2
 * JD-Core Version:    0.7.0.1
 */