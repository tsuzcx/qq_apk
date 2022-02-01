package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSTabBeaconReport
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSopName(paramString).setTestId(WeishiUtils.a(1)).setPushId(WSInitializeHelper.a().a()).setFlush(true);
  }
  
  public static void a(int paramInt, String paramString)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("position", "feeds_tab");
    localHashMap1.put("feed_id", "");
    localHashMap1.put("owner_id", "");
    localHashMap1.put("action_id", String.valueOf(1000001));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("index", String.valueOf(paramInt + 1));
    localHashMap2.put("tab_id", paramString);
    a(a("feeds").addParams(localHashMap1).addExtParams(localHashMap2), "gzh_click");
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(boolean paramBoolean, List<WSTabInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("position", "feeds_tab");
    localHashMap1.put("feed_id", "");
    localHashMap1.put("owner_id", "");
    HashMap localHashMap2 = new HashMap();
    if (paramBoolean) {
      paramList = "1";
    } else {
      paramList = "0";
    }
    localHashMap2.put("is_show", paramList);
    paramList = new StringBuilder();
    int j;
    for (int i = 0; i < ((List)localObject).size(); i = j)
    {
      j = i + 1;
      paramList.append(j);
      paramList.append("_");
      paramList.append(((WSTabInfo)((List)localObject).get(i)).a());
      if (i != ((List)localObject).size() - 1) {
        paramList.append(",");
      }
    }
    localHashMap2.put("feeds_tab_list", paramList.toString());
    a(a("feeds").addParams(localHashMap1).addExtParams(localHashMap2), "gzh_exposure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabBeaconReport
 * JD-Core Version:    0.7.0.1
 */