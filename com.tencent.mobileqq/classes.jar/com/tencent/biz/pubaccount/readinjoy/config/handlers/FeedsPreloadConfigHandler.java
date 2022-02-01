package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FeedsPreloadConfigHandler
  extends SimpleConfigHandler
{
  private static long a(String paramString, long paramLong)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("FeedsPreloadConfigHandler", 2, "parseStringToLong, e ", paramString);
    }
    return paramLong;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    paramString = AladdinParseUtils.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("FeedsPreloadConfigHandler", 1, new Object[] { "key = ", str1, ", value = ", str2 });
      if (TextUtils.equals("switch", str1)) {
        ReadInJoyHelper.a("sp_key_readinjoy_feeds_preload_switch", Boolean.valueOf(TextUtils.equals("1", str2)));
      } else if (TextUtils.equals("preload_interval", str1)) {
        ReadInJoyHelper.a("sp_key_readinjoy_feeds_preload_interval", Long.valueOf(a(str2, 30L)));
      } else if (TextUtils.equals("last_enter_kandian", str1)) {
        ReadInJoyHelper.a("sp_key_readinjoy_feeds_preload_last_enter_kd_day", Long.valueOf(a(str2, 90L)));
      } else if (TextUtils.equals("preload_time_limit", str1)) {
        ReadInJoyHelper.a("sp_key_readinjoy_feeds_preload_time_limit", Long.valueOf(a(str2, 10L)));
      } else if (TextUtils.equals("loading_time", str1)) {
        ReadInJoyHelper.a("sp_key_readinjoy_feeds_preload_loading_time", Long.valueOf(a(str2, 50L)));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("FeedsPreloadConfigHandler", 1, new Object[] { "onWipeConfig, id = ", Integer.valueOf(paramInt) });
    ReadInJoyHelper.a("sp_key_readinjoy_feeds_preload_switch", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.FeedsPreloadConfigHandler
 * JD-Core Version:    0.7.0.1
 */