package com.tencent.common.app;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.runtime.NowRunTime;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.buscard.BuscardHelper;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.groupvideo.GroupVideoHelper;
import cooperation.jtcode.JtcodeHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qhuanji.QHuanjiHelper;
import cooperation.qlink.QlinkHelper;
import cooperation.qqdataline.DatalineHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.thirdpay.ThirdPayManager;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopPluginHelper;
import cooperation.weiyun.WeiyunHelper;
import mqq.app.AppRuntime;

public class AppInterfaceFactory
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    Object localObject2 = null;
    String str = paramBaseApplicationImpl.getPackageName();
    Object localObject1;
    if (str.equals(paramString)) {
      localObject1 = new QQAppInterface(paramBaseApplicationImpl, paramString);
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (paramString.equals(str + ":msf"));
        localObject1 = localObject2;
      } while (paramString.equals(str + ":notifypush"));
      if (paramString.equals(str + ":video")) {
        return new VideoAppInterface(paramBaseApplicationImpl, "video");
      }
      if (paramString.equals(str + ":qzone"))
      {
        paramBaseApplicationImpl = QZoneHelper.b(paramBaseApplicationImpl, "qzone");
        paramBaseApplicationImpl.setAsToolRuntime();
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":qzonevideo")) {
        return QZoneHelper.e(paramBaseApplicationImpl, "qzonevideo");
      }
      if (paramString.equals(str + ":qzonelive")) {
        return QZoneHelper.c(paramBaseApplicationImpl, "qzonelive");
      }
      if (paramString.equals(str + ":picture")) {
        return QZoneHelper.d(paramBaseApplicationImpl, "picture");
      }
      if (paramString.equals(str + ":openSdk")) {
        return new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
      }
      if (paramString.equals(str + ":photoedit"))
      {
        paramBaseApplicationImpl = new PluginRuntime();
        ReportController.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":zebra")) {
        return new PluginRuntime();
      }
      if (paramString.equals(str + ":demoji"))
      {
        paramBaseApplicationImpl = new PluginRuntime();
        ReportController.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":map")) {
        return new QQMapActivity.MapRuntime();
      }
      if (paramString.equals(str + ":weiyun"))
      {
        paramBaseApplicationImpl = WeiyunHelper.a(paramBaseApplicationImpl);
        ReportController.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (!paramString.equals(str + ":qwallet")) {
        break;
      }
      paramBaseApplicationImpl = QWalletHelper.createQWalletAppInterface(paramBaseApplicationImpl, "qwallet");
      localObject1 = paramBaseApplicationImpl;
    } while (paramBaseApplicationImpl == null);
    ReportController.a((PluginRuntime)paramBaseApplicationImpl);
    return paramBaseApplicationImpl;
    if (paramString.equals(str + ":qqfav")) {
      return QfavHelper.a(paramBaseApplicationImpl);
    }
    if (paramString.equals(str + ":qlink")) {
      return QlinkHelper.a(paramBaseApplicationImpl, "qlink");
    }
    if (paramString.equals(str + ":cardpay"))
    {
      paramString = new PluginRuntime();
      ReportController.a(paramString);
      paramBaseApplicationImpl = ThirdPayManager.a(paramBaseApplicationImpl, "cardpay");
      if (paramBaseApplicationImpl != null) {
        break label1310;
      }
      paramBaseApplicationImpl = paramString;
    }
    label1310:
    for (;;)
    {
      return paramBaseApplicationImpl;
      localObject1 = localObject2;
      if (paramString.equals(str + ":qqwifi")) {
        break;
      }
      localObject1 = localObject2;
      if (paramString.equals(str + ":qqwifiditu")) {
        break;
      }
      if (paramString.equals(str + ":dataline")) {
        return DatalineHelper.a(paramBaseApplicationImpl, "dataline");
      }
      if (paramString.equals(str + ":smartdevice")) {
        return SmartDevicePluginLoader.a(paramBaseApplicationImpl, "smartdevice");
      }
      if (paramString.equals(str + ":buscard"))
      {
        paramBaseApplicationImpl = BuscardHelper.a(paramBaseApplicationImpl, "buscard");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":jtcode"))
      {
        paramBaseApplicationImpl = JtcodeHelper.a(paramBaseApplicationImpl, "jtcode");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      localObject1 = localObject2;
      if (paramString.equals(str + ":readinjoy")) {
        break;
      }
      if (paramString.equals(str + ":dingdong")) {
        return DingdongPluginHelper.a(paramBaseApplicationImpl, "dingdong");
      }
      if (paramString.equals(str + ":troopmemcard"))
      {
        paramBaseApplicationImpl = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_member_card_plugin.apk");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":troopmanage"))
      {
        paramBaseApplicationImpl = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_manage_plugin.apk");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":pluginbridge"))
      {
        paramBaseApplicationImpl = BridgeHelper.a(paramBaseApplicationImpl, "pluginbridge");
        localObject1 = paramBaseApplicationImpl;
        if (paramBaseApplicationImpl == null) {
          break;
        }
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":groupvideo")) {
        return GroupVideoHelper.a(paramBaseApplicationImpl, "groupvideo");
      }
      if (paramString.equals(str + ":tool"))
      {
        paramBaseApplicationImpl = new ToolAppRuntime();
        paramBaseApplicationImpl.setAsToolRuntime();
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":peak"))
      {
        paramBaseApplicationImpl = new ToolRuntimePeak();
        paramBaseApplicationImpl.setAsToolRuntime();
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":now")) {
        return new NowRunTime(paramBaseApplicationImpl, "now");
      }
      if (paramString.equals(str + ":huanji")) {
        return QHuanjiHelper.a(paramBaseApplicationImpl, "huanji");
      }
      if (paramString.equals(str + ":nearby_video")) {
        return NearbyVideoChatProxyActivity.a(paramBaseApplicationImpl, "nearby_video");
      }
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.AppInterfaceFactory
 * JD-Core Version:    0.7.0.1
 */