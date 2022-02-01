package com.tencent.biz.pubaccount.readinjoy.viola;

import android.text.TextUtils;
import bhmi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import mqq.app.AppRuntime;
import tbz;
import tcb;
import thy;

public final class ViolaAccessHelper$2
  implements Runnable
{
  public void run()
  {
    tbz.a(Integer.toString(3256));
    tbz.a(thy.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547"));
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null)
    {
      localObject1 = bhmi.a("viola_cache_file_viola_qq_page_data_new_main_js_" + ((AppRuntime)localObject1).getAccount());
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
    }
    while ((tbz.a()) && (tbz.c()) && (((!TextUtils.isEmpty(null)) && (new File(null).exists())) || (!TextUtils.isEmpty((CharSequence)localObject1)))) {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          tbz.a((String)localObject1, new tcb(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.2
 * JD-Core Version:    0.7.0.1
 */