package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterAppInterface;
import com.tencent.mobileqq.imaxad.ImaxAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicHelper;
import cooperation.ilive.IliveAppInterface;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.qqindividuality.QQIndividualityRuntimeHelper;
import cooperation.qqpim.QQPimPluginRuntimeHelper;
import cooperation.qqreader.QReaderHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ToolAppRuntime
  extends ToolRuntimeBase
{
  private AppInterface a = null;
  
  public String getModuleId()
  {
    return "tool";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DtSdkInitStep.initDTSDK(0);
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
        QLog.i("ToolAppRuntime", 2, "moduleId needInitSkin =" + bool + ", appInstance=" + paramString);
      }
      if ((!InitSkin.c) && (bool)) {
        InitSkin.a();
      }
      return paramString;
      if ("comic_plugin.apk".equals(paramString))
      {
        paramString = VipComicHelper.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qqreaderplugin.apk".equals(paramString))
      {
        paramString = QReaderHelper.a(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qqpim_plugin.apk".equals(paramString))
      {
        paramString = QQPimPluginRuntimeHelper.a(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("module_olympic".equals(paramString))
      {
        paramString = new OlympicToolAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qwallet_plugin.apk".equals(paramString))
      {
        paramString = QWalletHelperImpl.createQWalletAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      }
      else if ("qqindividuality_plugin.apk".equals(paramString))
      {
        paramString = QQIndividualityRuntimeHelper.a(localBaseApplicationImpl, MobileQQ.processName);
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
      else if ("ilive_plugin".equals(paramString))
      {
        paramString = new IliveAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool = false;
      }
      else if ("qcircle_flutter".equals(paramString))
      {
        paramString = new QCircleFlutterAppInterface(localBaseApplicationImpl, MobileQQ.processName);
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