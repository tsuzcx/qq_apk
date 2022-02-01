package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StickerRecReport
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("00000BXKOY3QZQ1E"));
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("00000BXKOY3QZQ1E", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "expo", true, 0L, 0L, paramHashMap, null);
  }
  
  public static void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("keyword", paramString1);
    localHashMap.put("pic_md5", paramIStickerRecEmoticon.l());
    localHashMap.put("pic_url", paramIStickerRecEmoticon.e());
    localHashMap.put("aio_type", EmoticonPanelUtils.g(paramInt));
    if ((paramIStickerRecEmoticon instanceof StickerRecData))
    {
      paramString1 = (StickerRecData)paramIStickerRecEmoticon;
      String str = paramString1.C();
      if (str != null) {
        localHashMap.put("algo_info", str);
      }
      paramString1 = paramString1.D();
      if (paramString1 != null) {
        localHashMap.put("recom_transfer", paramString1);
      }
    }
    paramString1 = paramIStickerRecEmoticon.m();
    if ((paramString1 != null) && (paramString1.length() > 1) && (paramString1.endsWith("-"))) {
      localHashMap.put("source", paramString1.substring(0, 1));
    }
    if (paramString2 != null) {
      localHashMap.put("target_qq", paramString2);
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramIStickerRecEmoticon.a());
    paramString1.append("");
    localHashMap.put("duration_ms", paramString1.toString());
    paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    paramString1 = paramString2;
    if (!StringUtil.isValideUin(paramString2)) {
      paramString1 = "10000";
    }
    localHashMap.put("report_qq", paramString1);
    if (paramBoolean)
    {
      a(localHashMap);
      return;
    }
    b(localHashMap);
  }
  
  public static void b(HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("00000BXKOY3QZQ1E", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "click", true, 0L, 0L, paramHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecReport
 * JD-Core Version:    0.7.0.1
 */