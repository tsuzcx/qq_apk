package com.tencent.common.app;

import bezd;
import bfjz;
import bfkz;
import bflp;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.imaxad.ImaxAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ToolAppRuntime
  extends ToolRuntimeBase
{
  public String getModuleId()
  {
    return "tool";
  }
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("ToolAppRuntime", 2, "ToolAppRuntime.onGetSubRuntime() moduleId " + paramString);
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if ("module_nearby".equals(paramString)) {
      paramString = new NearbyAppInterface(localBaseApplicationImpl, MobileQQ.processName);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ToolAppRuntime", 2, "moduleId needInitSkin =" + bool);
      }
      if ((!InitSkin.c) && (bool)) {
        InitSkin.a();
      }
      return paramString;
      if ("comic_plugin.apk".equals(paramString))
      {
        paramString = bezd.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qqreaderplugin.apk".equals(paramString))
      {
        paramString = bflp.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qqpim_plugin.apk".equals(paramString))
      {
        paramString = bfkz.a(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("module_olympic".equals(paramString))
      {
        paramString = new OlympicToolAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qwallet_plugin.apk".equals(paramString))
      {
        paramString = QWalletHelper.createQWalletAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("qqindividuality_plugin.apk".equals(paramString))
      {
        paramString = bfjz.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("modular_web".equals(paramString))
      {
        paramString = new BrowserAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("module_videofeeds".equals(paramString))
      {
        paramString = new VideoFeedsAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("cmshowgame_module".equals(paramString))
      {
        paramString = new CmGameAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("imax".equals(paramString))
      {
        paramString = new ImaxAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("peak".equals(paramString))
      {
        paramString = new PeakAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("LiveRoomPlugin.apk".equals(paramString))
      {
        paramString = LiveRoomHelper.createLiveRoomRuntime(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else
      {
        bool = false;
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.ToolAppRuntime
 * JD-Core Version:    0.7.0.1
 */