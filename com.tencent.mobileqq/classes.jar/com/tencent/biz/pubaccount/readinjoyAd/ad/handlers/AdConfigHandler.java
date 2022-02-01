package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("AdConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = AladdinParseUtils.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("AdConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (paramInt1 == 185)
      {
        if ((TextUtils.equals(str1, "adcard_style")) && (!TextUtils.isEmpty(str2))) {
          ReadInJoyHelper.a("sp_key_ad_imax_style", str2.trim());
        }
      }
      else if ((paramInt1 == 188) && (TextUtils.equals(str1, "ad_exposure_supplement")) && (!TextUtils.isEmpty(str2))) {
        ReadInJoyHelper.a("readinjjoy_ad_supplement_config", str2.trim());
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    if (paramInt == 185) {
      ReadInJoyHelper.a("sp_key_ad_imax_style", "0");
    }
    while (paramInt != 188) {
      return;
    }
    ReadInJoyHelper.a("readinjjoy_ad_supplement_config", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdConfigHandler
 * JD-Core Version:    0.7.0.1
 */