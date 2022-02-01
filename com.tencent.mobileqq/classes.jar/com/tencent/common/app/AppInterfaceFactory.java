package com.tencent.common.app;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.groupvideo.GroupVideoHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qlink.QlinkHelper;
import cooperation.qqdataline.DatalineHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qzone.QZoneHelper;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopPluginHelper;
import cooperation.weiyun.WeiyunHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AppInterfaceFactory
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    String str1 = null;
    String str2 = paramBaseApplicationImpl.getPackageName();
    Object localObject;
    if (str2.equals(paramString)) {
      localObject = new QQAppInterface(paramBaseApplicationImpl, paramString);
    }
    for (;;)
    {
      if (localObject != null)
      {
        paramBaseApplicationImpl = MobileQQ.getProcessSuffix(paramString, str2);
        ((AppRuntime)localObject).setProcessName(paramBaseApplicationImpl);
        if (QLog.isColorLevel()) {
          QLog.d("AppInterfaceFactory", 2, new Object[] { "process ", paramString, " package ", str2, " suffix ", paramBaseApplicationImpl });
        }
      }
      return localObject;
      localObject = str1;
      if (!paramString.equals(str2 + ":" + "MSF"))
      {
        localObject = str1;
        if (!paramString.equals(str2 + ":" + "notifypush")) {
          if (paramString.equals(str2 + ":" + "video"))
          {
            localObject = new VideoAppInterface(paramBaseApplicationImpl, "video");
          }
          else if (paramString.equals(str2 + ":" + "qzone"))
          {
            localObject = QZoneHelper.createQZoneMainRuntime(paramBaseApplicationImpl, "qzone");
            ((AppRuntime)localObject).setAsToolRuntime();
          }
          else if (paramString.equals(str2 + ":" + "qzonevideo"))
          {
            localObject = QZoneHelper.createQZoneVideoAppInterface(paramBaseApplicationImpl, "qzonevideo");
          }
          else if (paramString.equals(str2 + ":" + "qzonelive"))
          {
            localObject = QZoneHelper.createQZoneLiveMainRuntime(paramBaseApplicationImpl, "qzonelive");
          }
          else if (paramString.equals(str2 + ":" + "picture"))
          {
            localObject = QZoneHelper.createQZonePictureAppInterface(paramBaseApplicationImpl, "picture");
          }
          else if (paramString.equals(str2 + ":" + "openSdk"))
          {
            localObject = new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
          }
          else if (paramString.equals(str2 + ":" + "photoedit"))
          {
            localObject = new PluginRuntime();
            ReportController.a((PluginRuntime)localObject);
          }
          else if (paramString.equals(str2 + ":" + "zebra"))
          {
            localObject = new PluginRuntime();
          }
          else if (paramString.equals(str2 + ":" + "demoji"))
          {
            localObject = new PluginRuntime();
            ReportController.a((PluginRuntime)localObject);
          }
          else if (paramString.equals(str2 + ":" + "map"))
          {
            localObject = new QQMapActivity.MapRuntime();
          }
          else if (paramString.equals(str2 + ":" + "weiyun"))
          {
            localObject = WeiyunHelper.a(paramBaseApplicationImpl);
            if (localObject != null) {
              ReportController.a((PluginRuntime)localObject);
            } else {
              QLog.e("AppInterfaceFactory", 1, "WeiyunHelper.createRuntime return null!");
            }
          }
          else if (paramString.equals(str2 + ":" + "qwallet"))
          {
            paramBaseApplicationImpl = QWalletHelperImpl.createQWalletAppInterface(paramBaseApplicationImpl, "qwallet");
            localObject = paramBaseApplicationImpl;
            if (paramBaseApplicationImpl != null)
            {
              ReportController.a((PluginRuntime)paramBaseApplicationImpl);
              localObject = paramBaseApplicationImpl;
            }
          }
          else if (paramString.equals(str2 + ":" + "qqfav"))
          {
            localObject = QfavHelper.a(paramBaseApplicationImpl);
          }
          else if (paramString.equals(str2 + ":" + "qlink"))
          {
            localObject = QlinkHelper.a(paramBaseApplicationImpl, "qlink");
          }
          else if (paramString.equals(str2 + ":" + "miniapp"))
          {
            localObject = new MiniAppInterface(paramBaseApplicationImpl, "miniapp");
          }
          else if ((paramString.equals(str2 + ":" + "mini")) || (paramString.equals(str2 + ":" + "mini1")) || (paramString.equals(str2 + ":" + "mini2")) || (paramString.equals(str2 + ":" + "mini3")) || (paramString.equals(str2 + ":" + "mini4")) || (paramString.equals(str2 + ":" + "mini5")) || (paramString.equals(str2 + ":" + "mini6")) || (paramString.equals(str2 + ":" + "mini7")) || (paramString.equals(str2 + ":" + "mini_internal")))
          {
            localObject = "mini";
          }
        }
      }
      try
      {
        str1 = paramString.substring(str2.length() + 1);
        localObject = str1;
      }
      catch (Exception localException)
      {
        label1151:
        break label1151;
      }
      localObject = QQMiniManager.createMiniAppInterface(paramBaseApplicationImpl, (String)localObject);
      continue;
      localObject = str1;
      if (!paramString.equals(str2 + ":" + "qqwifi"))
      {
        localObject = str1;
        if (!paramString.equals(str2 + ":" + "qqwifiditu")) {
          if (paramString.equals(str2 + ":" + "dataline"))
          {
            localObject = DatalineHelper.a(paramBaseApplicationImpl, "dataline");
          }
          else if (paramString.equals(str2 + ":" + "smartdevice"))
          {
            localObject = SmartDevicePluginLoader.a(paramBaseApplicationImpl, "smartdevice");
          }
          else
          {
            localObject = str1;
            if (!paramString.equals(str2 + ":" + "readinjoy")) {
              if (paramString.equals(str2 + ":" + "troopmemcard"))
              {
                localObject = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_member_card_plugin.apk");
                ReportController.a((PluginRuntime)localObject);
              }
              else if (paramString.equals(str2 + ":" + "troopmanage"))
              {
                localObject = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_manage_plugin.apk");
                ReportController.a((PluginRuntime)localObject);
              }
              else if (paramString.equals(str2 + ":" + "pluginbridge"))
              {
                paramBaseApplicationImpl = BridgeHelper.a(paramBaseApplicationImpl, "pluginbridge");
                localObject = paramBaseApplicationImpl;
                if (paramBaseApplicationImpl != null)
                {
                  ReportController.a((PluginRuntime)paramBaseApplicationImpl);
                  localObject = paramBaseApplicationImpl;
                }
              }
              else if (paramString.equals(str2 + ":" + "groupvideo"))
              {
                localObject = GroupVideoHelper.a(paramBaseApplicationImpl, "groupvideo");
              }
              else if (paramString.equals(str2 + ":" + "tool"))
              {
                localObject = new ToolAppRuntime();
                ((AppRuntime)localObject).setAsToolRuntime();
              }
              else if (paramString.equals(str2 + ":" + "peak"))
              {
                localObject = new ToolRuntimePeak();
                ((AppRuntime)localObject).setAsToolRuntime();
              }
              else if (paramString.equals(str2 + ":" + "nearby_video"))
              {
                localObject = NearbyVideoChatProxyActivity.a(paramBaseApplicationImpl, "nearby_video");
              }
              else if (paramString.equals(str2 + ":" + "avgame"))
              {
                localObject = new AVGameAppInterface(paramBaseApplicationImpl, "avgame");
              }
              else if (paramString.equals(str2 + ":" + "plugins"))
              {
                localObject = new PluginRuntime();
                ((PluginRuntime)localObject).setAsToolRuntime();
              }
              else
              {
                localObject = new PluginRuntime();
                ReportController.a((PluginRuntime)localObject);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.AppInterfaceFactory
 * JD-Core Version:    0.7.0.1
 */