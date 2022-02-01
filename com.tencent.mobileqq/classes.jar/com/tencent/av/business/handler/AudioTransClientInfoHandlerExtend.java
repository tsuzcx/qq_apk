package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
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
    Object localObject = (EffectSupportManager)paramVideoAppInterface.a(5);
    int i = 0;
    if (((EffectSupportManager)localObject).a(0, "750") == 1) {
      i = 1;
    }
    long l1 = AudioHelper.a();
    if (i != 0)
    {
      i = 12;
      localObject = (AudioTransClientInfoHandler)paramVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("|");
      localStringBuilder.append(((AudioTransClientInfoHandler)localObject).a());
      localStringBuilder.append("|");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("|");
      localStringBuilder.append(l1);
      localObject = localStringBuilder.toString();
    }
    else
    {
      i = 7;
      localObject = paramString2;
    }
    long l2 = b;
    b = l1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendZimuCmd, id[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], cmdInfo[");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("], autoDetect[");
    localStringBuilder.append(true);
    localStringBuilder.append("], from[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], sendTime[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], sendInterval[");
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append("]");
    QLog.w("AudioTransClientInfoHandler", 1, localStringBuilder.toString());
    paramVideoAppInterface.a().a(i, (String)localObject);
  }
  
  int a()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i = 3;
    if (bool) {
      return 2;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int j = AppNetConnInfo.getMobileInfo();
      if (j != 1)
      {
        if (j == 2) {
          return i;
        }
        if (j == 3) {
          return 5;
        }
      }
      else
      {
        return 4;
      }
    }
    i = 100;
    return i;
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
      return localVideoController.a().c;
    }
    return "";
  }
  
  boolean b()
  {
    return ((EffectZimuManager)((VideoAppInterface)this.a).a(0)).c();
  }
  
  boolean c()
  {
    return ((AudioTransClientInterfaceHandler)this.a.getBusinessHandler(BusinessHandlerFactory.a)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend
 * JD-Core Version:    0.7.0.1
 */