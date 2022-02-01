package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeGif;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeImage;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeRIJAvatar;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeRichText;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeVideo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSConfig;
import com.tencent.pts.utils.PTSConfig.PTSConfigBuilder;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PTSHelper
{
  private static PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo a()
  {
    return new PTSHelper.3();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      int i = Color.parseColor(paramString);
      paramString = (i << 8 & 0xFFFFFF00 | i >> 24 & 0xFF) + "";
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.e("PTSHelper", 1, "[getRgbaColor] e = " + paramString);
    }
    return "";
  }
  
  public static void a()
  {
    PTSSwitchManager.a.a();
    PTSLiteSwitchManager.a().a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = PTSAppLoader.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", "daily_feeds");
    PTSEngineLoader.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PagePath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!PTSSwitchManager.a.b()) {}
    do
    {
      return false;
      int i = DailyModeConfigHandler.b();
      if (!DailyModeConfigHandler.a(i))
      {
        QLog.i("PTSHelper", 1, "[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = " + i);
        return false;
      }
    } while ((!PTSEngineLoader.a().a()) || (!PTSAppLoader.a().a("daily_feeds")));
    a(paramContext);
    return true;
  }
  
  static void b()
  {
    if (SystemUtil.b())
    {
      PTSDeviceUtil.setTextHeightOffsetPerLine(0.1176471F);
      PTSDeviceUtil.setTextWidthOffsetPerLength(0.02941177F);
    }
    PTSNodeFactory.registerNodeVirtual("img", PTSNodeImage.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-video", PTSNodeVideo.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-gif", PTSNodeGif.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "rij-avatar-view", PTSNodeRIJAvatar.class);
    PTSNodeFactory.registerNodeVirtual("rich-text", PTSNodeRichText.class);
    d();
  }
  
  private static void b(Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[onBindNodeInfoFinished] paramsMap : \n");
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localStringBuilder.append("[").append((String)localEntry.getKey()).append("] = ").append(localEntry.getValue()).append("\n");
      }
      QLog.i("PTSHelper", 2, localStringBuilder.toString());
    }
  }
  
  static void c() {}
  
  private static void d()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSHelper.1 local1 = new PTSHelper.1();
    PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo localINodeVirtualOnBindNodeInfo = a();
    PTSHelper.2 local2 = new PTSHelper.2();
    PTSConfig.init(new PTSConfig.PTSConfigBuilder().withHandlerThread(localHandlerThread).withLogger(new PTSLogQQ()).withPtsReport(local1).withOnBindNodeInfo(localINodeVirtualOnBindNodeInfo).withOnViewClick(local2).build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSHelper
 * JD-Core Version:    0.7.0.1
 */