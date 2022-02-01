package com.tencent.biz.pubaccount.readinjoyAd.ad.diversion;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DiversionUtil
{
  public static void a(Context paramContext, int paramInt)
  {
    boolean bool = PackageUtil.a(paramContext, "com.tencent.rijvideo");
    Object localObject2 = Aladdin.getConfig(514);
    Object localObject1 = "";
    localObject2 = ((AladdinConfig)localObject2).getString("landing_page", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.rijvideo   isAppInstalled = ");
    localStringBuilder.append(bool);
    QLog.d("DiversionUtil", 1, localStringBuilder.toString());
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (!bool) {
          break label223;
        }
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3)
            {
              localObject1 = ((JSONObject)localObject2).getString("video_soft_scheme");
              break label220;
            }
          }
          else
          {
            localObject1 = ((JSONObject)localObject2).getString("feeds_window_scheme");
            break label220;
          }
        }
        else
        {
          localObject1 = ((JSONObject)localObject2).getString("feeds_bar_scheme");
          break label220;
          localObject1 = ((JSONObject)localObject2).getString("video_soft");
          continue;
          localObject1 = ((JSONObject)localObject2).getString("feeds_window");
          continue;
          localObject1 = ((JSONObject)localObject2).getString("feeds_bar");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, (String)localObject1);
        }
        return;
      }
      catch (Exception paramContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("  AladdinConfig read fail ");
        ((StringBuilder)localObject1).append(paramContext.getMessage());
        QLog.d("DiversionUtil", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      label220:
      continue;
      label223:
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3) {}
        }
      }
    }
  }
  
  public static boolean a()
  {
    String str = Aladdin.getConfig(514).getString("ad_flag", "");
    return (!TextUtils.isEmpty(str)) && (str.equals("1"));
  }
  
  public static boolean b()
  {
    String str = Aladdin.getConfig(514).getString("ad_window", "");
    return (!TextUtils.isEmpty(str)) && (str.equals("1"));
  }
  
  public static boolean c()
  {
    String str = Aladdin.getConfig(514).getString("ad_bar", "");
    return (!TextUtils.isEmpty(str)) && (str.equals("1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.diversion.DiversionUtil
 * JD-Core Version:    0.7.0.1
 */