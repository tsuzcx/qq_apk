package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AdConfigHandler", 1, ((StringBuilder)localObject).toString());
    paramString = AladdinParseUtils.a(paramString);
    localObject = paramString.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)paramString.get(str1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str1);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str2);
      QLog.d("AdConfigHandler", 2, localStringBuilder.toString());
      if (paramInt1 == 185)
      {
        if ((TextUtils.equals(str1, "adcard_style")) && (!TextUtils.isEmpty(str2))) {
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateProteusOfflineBid("sp_key_ad_imax_style", str2.trim());
        }
      }
      else if ((paramInt1 == 188) && (TextUtils.equals(str1, "ad_exposure_supplement")) && (!TextUtils.isEmpty(str2))) {
        ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateProteusOfflineBid("readinjjoy_ad_supplement_config", str2.trim());
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    if (paramInt == 185)
    {
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateProteusOfflineBid("sp_key_ad_imax_style", "0");
      return;
    }
    if (paramInt == 188) {
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateProteusOfflineBid("readinjjoy_ad_supplement_config", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdConfigHandler
 * JD-Core Version:    0.7.0.1
 */