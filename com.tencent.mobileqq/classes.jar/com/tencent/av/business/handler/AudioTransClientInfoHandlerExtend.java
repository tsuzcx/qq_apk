package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class AudioTransClientInfoHandlerExtend
  extends AudioTransClientInfoHandler
{
  static long b;
  private AppInterface a;
  
  public AudioTransClientInfoHandlerExtend(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    int i;
    long l1;
    if (((EffectSupportManager)paramVideoAppInterface.a(5)).a(0, "750") == 1)
    {
      i = 1;
      l1 = AudioHelper.a();
      if (i == 0) {
        break label216;
      }
      i = 12;
      localObject = (AudioTransClientInfoHandler)paramVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.b);
    }
    for (Object localObject = paramString2 + "|" + ((AudioTransClientInfoHandler)localObject).a() + "|" + paramLong + "|" + l1;; localObject = paramString2)
    {
      long l2 = b;
      b = l1;
      QLog.w("AudioTransClientInfoHandler", 1, "sendZimuCmd, id[" + paramString2 + "], cmdInfo[" + (String)localObject + "], autoDetect[" + true + "], from[" + paramString1 + "], seq[" + paramLong + "], sendTime[" + l1 + "], sendInterval[" + (l1 - l2) + "]");
      paramVideoAppInterface.a().a(i, (String)localObject);
      return;
      i = 0;
      break;
      label216:
      i = 7;
    }
  }
  
  int a()
  {
    int i = 100;
    if (AppNetConnInfo.isWifiConn()) {
      i = 2;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 100;
    case 1: 
      return 4;
    case 2: 
      return 3;
    }
    return 5;
  }
  
  void a(long paramLong1, long paramLong2)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)this.a;
    ZimuItem localZimuItem = (ZimuItem)((EffectZimuManager)localVideoAppInterface.a(0)).a();
    if ((localZimuItem != null) && (!TextUtils.isEmpty(localZimuItem.getId()))) {
      a(localVideoAppInterface, "sendToPeer", paramLong1, localZimuItem.getId(), true);
    }
  }
  
  int b()
  {
    return UITools.getQQVersion();
  }
  
  String b()
  {
    VideoController localVideoController = ((VideoAppInterface)this.a).a();
    if ((localVideoController != null) && (localVideoController.a() != null)) {
      return localVideoController.a().d;
    }
    return "";
  }
  
  boolean b()
  {
    return ((EffectZimuManager)((VideoAppInterface)this.a).a(0)).b();
  }
  
  boolean c()
  {
    return ((AudioTransClientInterfaceHandler)this.a.getBusinessHandler(BusinessHandlerFactory.a)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend
 * JD-Core Version:    0.7.0.1
 */