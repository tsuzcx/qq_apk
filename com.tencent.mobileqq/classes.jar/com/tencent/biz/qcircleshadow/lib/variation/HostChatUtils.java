package com.tencent.biz.qcircleshadow.lib.variation;

import android.util.Pair;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class HostChatUtils
{
  public static String QCIRCLE_CHAT_HIDE_MENU_KEY()
  {
    return ((IQCircleChatUtilApi)QRoute.api(IQCircleChatUtilApi.class)).QCIRCLE_CHAT_HIDE_MENU_KEY();
  }
  
  public static String QCIRLCE_CHAT_GIFT_INFO_BYTES_KEY()
  {
    return ((IQCircleChatUtilApi)QRoute.api(IQCircleChatUtilApi.class)).QCIRLCE_CHAT_GIFT_INFO_BYTES_KEY();
  }
  
  public static String QCIRLCE_CHAT_SHOW_FUEL_TIPS_KEY()
  {
    return ((IQCircleChatUtilApi)QRoute.api(IQCircleChatUtilApi.class)).QCIRLCE_CHAT_SHOW_FUEL_TIPS_KEY();
  }
  
  public static void clearQCircleChatUnread(List<String> paramList, boolean paramBoolean)
  {
    ((IQCircleChatUtilApi)QRoute.api(IQCircleChatUtilApi.class)).clearQCircleChatUnread(paramList, paramBoolean);
  }
  
  public static String getMaxUnReadCountText(int paramInt)
  {
    return ((IQCircleChatUtilApi)QRoute.api(IQCircleChatUtilApi.class)).getMaxUnReadCountText(paramInt);
  }
  
  public static Pair<Integer, List<String>> getQCircleChatRedPointInfo()
  {
    return ((IQCircleChatUtilApi)QRoute.api(IQCircleChatUtilApi.class)).getQCircleChatRedPointInfo();
  }
  
  public static boolean isQCircleChatType(int paramInt)
  {
    return ((IQCircleChatUtilApi)QRoute.api(IQCircleChatUtilApi.class)).isQCircleChatType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils
 * JD-Core Version:    0.7.0.1
 */