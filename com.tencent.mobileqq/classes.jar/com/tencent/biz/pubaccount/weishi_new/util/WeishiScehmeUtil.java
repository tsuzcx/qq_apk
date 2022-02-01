package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import java.util.HashMap;

public class WeishiScehmeUtil
{
  public static final HashMap<String, String> a = new HashMap();
  public static boolean b = false;
  
  static
  {
    a.put("1_1_1", "2020020023");
    a.put("1_1_2", "2020020023");
    a.put("1_1_3", "2020020024");
    a.put("1_1_4", "2020020024");
    a.put("1_1_5", "2020020057");
    a.put("1_1_6", "2020020028");
    a.put("1_1_7", "2020020116");
    a.put("1_1_8", "2020020115");
    a.put("1_1_13", "2020020427");
    a.put("1_1_14", "2020020428");
    a.put("1_1_101", "2020020026");
    a.put("1_1_102", "2020020027");
    a.put("1_1_103", "2020020160");
    a.put("1_1_401", "2020020167");
    a.put("1_2_1", "2020020082");
    a.put("1_2_2", "2020020082");
    a.put("1_2_3", "2020020083");
    a.put("1_2_4", "2020020084");
    a.put("1_2_5", "2020020085");
    a.put("1_2_6", "2020020086");
    a.put("1_2_7", "2020020118");
    a.put("1_2_8", "2020020117");
    a.put("1_2_100", "2020020032");
    a.put("1_2_104", "2020020163");
    a.put("1_2_13", "2020020427");
    a.put("1_2_14", "2020020428");
    a.put("1_2_101", "2020020026");
    a.put("1_2_102", "2020020027");
    a.put("1_2_103", "2020020160");
    a.put("1_2_401", "2020020167");
    a.put("1_3_1", "2020020072");
    a.put("1_3_2", "2020020072");
    a.put("1_3_3", "2020020073");
    a.put("1_3_4", "2020020074");
    a.put("1_3_5", "2020020075");
    a.put("1_3_6", "2020020076");
    a.put("1_3_7", "2020020120");
    a.put("1_3_8", "2020020119");
    a.put("1_3_13", "2020020427");
    a.put("1_3_14", "2020020428");
    a.put("1_4_1", "2020020077");
    a.put("1_4_2", "2020020077");
    a.put("1_4_3", "2020020078");
    a.put("1_4_4", "2020020079");
    a.put("1_4_5", "2020020080");
    a.put("1_4_6", "2020020081");
    a.put("1_4_7", "2020020122");
    a.put("1_4_8", "2020020121");
    a.put("1_4_13", "2020020427");
    a.put("1_4_14", "2020020428");
    a.put("1_4_300", "2020020071");
    a.put("1_4_401", "2020020167");
    a.put("1_5_1", "2020020031");
    a.put("1_5_2", "2020020031");
    a.put("1_5_3", "2020020032");
    a.put("1_5_4", "2020020033");
    a.put("1_5_5", "2020020034");
    a.put("1_5_6", "2020020035");
    a.put("1_5_7", "2020020053");
    a.put("1_5_8", "2020020052");
    a.put("1_5_301", "2020020030");
    a.put("1_5_101", "2020020026");
    a.put("1_5_102", "2020020027");
    a.put("1_5_103", "2020020160");
    a.put("1_6_1", "2020020037");
    a.put("1_6_2", "2020020037");
    a.put("1_6_3", "2020020038");
    a.put("1_6_4", "2020020039");
    a.put("1_6_5", "2020020040");
    a.put("1_6_6", "2020020041");
    a.put("1_6_7", "2020020055");
    a.put("1_6_8", "2020020054");
    a.put("1_6_302", "2020020036");
    a.put("1_6_101", "2020020026");
    a.put("1_6_102", "2020020027");
    a.put("1_6_103", "2020020160");
    a.put("2_0_1", "2020020059");
    a.put("2_0_2", "2020020059");
    a.put("2_0_3", "2020020060");
    a.put("2_0_4", "2020020061");
    a.put("2_0_5", "2020020062");
    a.put("2_0_6", "2020020064");
    a.put("2_0_7", "2020020114");
    a.put("2_0_8", "2020020113");
    a.put("3_0_200", "2020020029");
    a.put("3_0_201", "20200200230");
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 0) {
      paramInt1 = 0;
    }
    if (paramInt2 <= 0) {
      paramInt2 = 0;
    }
    if (paramInt3 <= 0) {
      paramInt3 = 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt3);
    localObject = ((StringBuilder)localObject).toString();
    localObject = (String)a.get(localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    return "2020020063";
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("weishi://feed?feed_id=");
      localStringBuilder.append(paramstSimpleMetaFeed.id);
      return localStringBuilder.toString();
    }
    return "weishi://main";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = WeishiUtils.f(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openWeishi: scheme = ");
    localStringBuilder.append(paramString2);
    WSLog.d("WeishiScehmeUtil", localStringBuilder.toString());
    b = true;
    WeishiGuideUtils.a(paramContext, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = paramString2;
      if (!paramString2.contains("?"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("?");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString2 = (String)localObject;
      if (!((String)localObject).contains("&logsour="))
      {
        paramString2 = a(paramInt1, paramInt2, paramInt3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("&logsour=");
        localStringBuilder.append(paramString2);
        paramString2 = localStringBuilder.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openWeishi final scheme = ");
      ((StringBuilder)localObject).append(paramString2);
      WSLog.c("WeishiScehmeUtil", ((StringBuilder)localObject).toString());
      a(paramContext, paramString1, paramString2);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("openWeishi context = ");
    paramString1.append(paramContext);
    paramString1.append("scheme = ");
    paramString1.append(paramString2);
    WSLog.d("WeishiScehmeUtil", paramString1.toString());
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("weishi://"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil
 * JD-Core Version:    0.7.0.1
 */