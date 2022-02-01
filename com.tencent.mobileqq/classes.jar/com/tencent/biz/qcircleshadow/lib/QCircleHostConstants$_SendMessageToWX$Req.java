package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;

public class QCircleHostConstants$_SendMessageToWX$Req
{
  public static int WXSceneFavorite()
  {
    return ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).WXSceneFavorite();
  }
  
  public static int WXSceneSession()
  {
    return ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).WXSceneSession();
  }
  
  public static int WXSceneSpecifiedContact()
  {
    return ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).WXSceneSpecifiedContact();
  }
  
  public static int WXSceneTimeline()
  {
    return ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).WXSceneTimeline();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._SendMessageToWX.Req
 * JD-Core Version:    0.7.0.1
 */