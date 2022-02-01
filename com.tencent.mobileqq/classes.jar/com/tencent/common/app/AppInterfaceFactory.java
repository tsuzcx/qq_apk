package com.tencent.common.app;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.groupvideo.api.IGroupVideoHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qlink.QlinkHelper;
import cooperation.qqdataline.DatalineHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopPluginHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AppInterfaceFactory
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    String str = paramBaseApplicationImpl.getPackageName();
    if (QLog.isColorLevel()) {
      QLog.d("AppInterfaceFactory", 2, new Object[] { "getAppRuntime processname=", paramString, " package=", str });
    }
    if (str.equals(paramString))
    {
      paramBaseApplicationImpl = new QQAppInterface(paramBaseApplicationImpl, paramString);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append("MSF");
      if (!paramString.equals(((StringBuilder)localObject).toString()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append("notifypush");
        if (!paramString.equals(((StringBuilder)localObject).toString()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("video");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = new VideoAppInterface(paramBaseApplicationImpl, "video");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("qzone");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = QZoneHelper.createQZoneMainRuntime(paramBaseApplicationImpl, "qzone");
            paramBaseApplicationImpl.setAsToolRuntime();
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("qzonevideo");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = QZoneHelper.createQZoneVideoAppInterface(paramBaseApplicationImpl, "qzonevideo");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("qzonelive");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = QZoneHelper.createQZoneLiveMainRuntime(paramBaseApplicationImpl, "qzonelive");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("picture");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = QZoneHelper.createQZonePictureAppInterface(paramBaseApplicationImpl, "picture");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("openSdk");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("photoedit");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = new PluginRuntime();
            ReportController.a(paramBaseApplicationImpl);
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("zebra");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = new PluginRuntime();
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("demoji");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = new PluginRuntime();
            ReportController.a(paramBaseApplicationImpl);
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("map");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = new QQMapActivity.MapRuntime();
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("weiyun");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).createRuntime(paramBaseApplicationImpl);
            if (paramBaseApplicationImpl != null)
            {
              ReportController.a(paramBaseApplicationImpl);
              break label2148;
            }
            QLog.e("AppInterfaceFactory", 1, "WeiyunHelper.createRuntime return null!");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("qwallet");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            localObject = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).createQWalletAppInterface(paramBaseApplicationImpl, "qwallet");
            paramBaseApplicationImpl = (BaseApplicationImpl)localObject;
            if (localObject == null) {
              break label2148;
            }
            ReportController.a((PluginRuntime)localObject);
            paramBaseApplicationImpl = (BaseApplicationImpl)localObject;
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("TMAssistantDownloadSDKService");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            localObject = ((IQQGameCommApi)QRoute.api(IQQGameCommApi.class)).createAppRuntime(paramBaseApplicationImpl, "TMAssistantDownloadSDKService");
            paramBaseApplicationImpl = (BaseApplicationImpl)localObject;
            if (localObject == null) {
              break label2148;
            }
            ReportController.a((PluginRuntime)localObject);
            paramBaseApplicationImpl = (BaseApplicationImpl)localObject;
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("qqfav");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = QfavHelper.a(paramBaseApplicationImpl);
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("qlink");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = QlinkHelper.a(paramBaseApplicationImpl, "qlink");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("miniapp");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            paramBaseApplicationImpl = new MiniAppInterface(paramBaseApplicationImpl, "miniapp");
            break label2148;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini1");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini2");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini3");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini4");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini5");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini6");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini7");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("mini_internal");
          if (paramString.equals(((StringBuilder)localObject).toString())) {
            break label2125;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("qqwifi");
          if (!paramString.equals(((StringBuilder)localObject).toString()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(":");
            ((StringBuilder)localObject).append("qqwifiditu");
            if (!paramString.equals(((StringBuilder)localObject).toString()))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append("dataline");
              if (paramString.equals(((StringBuilder)localObject).toString()))
              {
                paramBaseApplicationImpl = DatalineHelper.a(paramBaseApplicationImpl, "dataline");
                break label2148;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append("smartdevice");
              if (paramString.equals(((StringBuilder)localObject).toString()))
              {
                paramBaseApplicationImpl = SmartDevicePluginLoader.a(paramBaseApplicationImpl, "smartdevice");
                break label2148;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append("readinjoy");
              if (!paramString.equals(((StringBuilder)localObject).toString())) {
                break label1611;
              }
            }
          }
        }
      }
      paramBaseApplicationImpl = null;
      break label2148;
      label1611:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append("troopmemcard");
      if (paramString.equals(((StringBuilder)localObject).toString()))
      {
        paramBaseApplicationImpl = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_member_card_plugin.apk");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append("troopmanage");
        if (paramString.equals(((StringBuilder)localObject).toString()))
        {
          paramBaseApplicationImpl = TroopPluginHelper.a(paramBaseApplicationImpl, "troop_manage_plugin.apk");
          ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append("pluginbridge");
          if (paramString.equals(((StringBuilder)localObject).toString()))
          {
            localObject = BridgeHelper.a(paramBaseApplicationImpl, "pluginbridge");
            paramBaseApplicationImpl = (BaseApplicationImpl)localObject;
            if (localObject != null)
            {
              ReportController.a((PluginRuntime)localObject);
              paramBaseApplicationImpl = (BaseApplicationImpl)localObject;
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(":");
            ((StringBuilder)localObject).append("groupvideo");
            if (paramString.equals(((StringBuilder)localObject).toString()))
            {
              paramBaseApplicationImpl = ((IGroupVideoHelper)QRoute.api(IGroupVideoHelper.class)).createAppInterface(paramBaseApplicationImpl, "groupvideo");
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(":");
              ((StringBuilder)localObject).append("tool");
              if (paramString.equals(((StringBuilder)localObject).toString()))
              {
                paramBaseApplicationImpl = new ToolAppRuntime();
                paramBaseApplicationImpl.setAsToolRuntime();
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(str);
                ((StringBuilder)localObject).append(":");
                ((StringBuilder)localObject).append("peak");
                if (paramString.equals(((StringBuilder)localObject).toString()))
                {
                  paramBaseApplicationImpl = new ToolRuntimePeak();
                  paramBaseApplicationImpl.setAsToolRuntime();
                }
                else
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(str);
                  ((StringBuilder)localObject).append(":");
                  ((StringBuilder)localObject).append("nearby_video");
                  if (paramString.equals(((StringBuilder)localObject).toString()))
                  {
                    paramBaseApplicationImpl = NearbyVideoChatProxyActivity.a(paramBaseApplicationImpl, "nearby_video");
                  }
                  else
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append(str);
                    ((StringBuilder)localObject).append(":");
                    ((StringBuilder)localObject).append("avgame");
                    if (paramString.equals(((StringBuilder)localObject).toString()))
                    {
                      paramBaseApplicationImpl = new AVGameAppInterface(paramBaseApplicationImpl, "avgame");
                    }
                    else
                    {
                      paramBaseApplicationImpl = new StringBuilder();
                      paramBaseApplicationImpl.append(str);
                      paramBaseApplicationImpl.append(":");
                      paramBaseApplicationImpl.append("plugins");
                      if (paramString.equals(paramBaseApplicationImpl.toString()))
                      {
                        paramBaseApplicationImpl = new PluginRuntime();
                        paramBaseApplicationImpl.setAsToolRuntime();
                      }
                      else
                      {
                        paramBaseApplicationImpl = new PluginRuntime();
                        ReportController.a(paramBaseApplicationImpl);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      label2125:
      localObject = paramString.substring(str.length() + 1);
    }
    catch (Exception localException)
    {
      label2139:
      label2148:
      break label2139;
    }
    Object localObject = "mini";
    paramBaseApplicationImpl = QQMiniManager.createMiniAppInterface(paramBaseApplicationImpl, (String)localObject);
    if (paramBaseApplicationImpl != null)
    {
      localObject = MobileQQ.getProcessSuffix(paramString, str);
      paramBaseApplicationImpl.setProcessName((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AppInterfaceFactory", 2, new Object[] { "process ", paramString, " package ", str, " suffix ", localObject });
      }
    }
    return paramBaseApplicationImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.AppInterfaceFactory
 * JD-Core Version:    0.7.0.1
 */