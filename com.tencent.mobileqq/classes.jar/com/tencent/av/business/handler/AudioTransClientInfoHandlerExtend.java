package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class AudioTransClientInfoHandlerExtend
  extends AudioTransClientInfoHandler
{
  public AudioTransClientInfoHandlerExtend(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static AudioTransClientInfoHandlerExtend.ZimuCMD a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    int i = 1;
    AudioTransClientInfoHandler localAudioTransClientInfoHandler = (AudioTransClientInfoHandler)paramVideoAppInterface.a(1);
    if (((EffectSupportManager)paramVideoAppInterface.a(5)).a(0, "750") == 1) {
      if (i == 0) {
        break label119;
      }
    }
    label119:
    for (int j = 12;; j = 7)
    {
      paramVideoAppInterface = paramString;
      if (i != 0) {
        paramVideoAppInterface = paramString + "|" + localAudioTransClientInfoHandler.a();
      }
      AVLog.d("AudioTransClientInfoHandler runhw", "getZimuCmd:" + j + "|" + paramVideoAppInterface);
      return new AudioTransClientInfoHandlerExtend.ZimuCMD(j, paramVideoAppInterface);
      i = 0;
      break;
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
  
  void a(long paramLong)
  {
    Object localObject = (VideoAppInterface)this.a;
    ZimuItem localZimuItem = (ZimuItem)((EffectZimuManager)((VideoAppInterface)localObject).a(0)).a();
    if ((localZimuItem != null) && (!TextUtils.isEmpty(localZimuItem.getId())))
    {
      VideoController localVideoController = ((VideoAppInterface)localObject).a();
      localObject = a((VideoAppInterface)localObject, localZimuItem.getId());
      localVideoController.a(((AudioTransClientInfoHandlerExtend.ZimuCMD)localObject).jdField_a_of_type_Int, ((AudioTransClientInfoHandlerExtend.ZimuCMD)localObject).jdField_a_of_type_JavaLangString);
    }
  }
  
  int b()
  {
    return UITools.a();
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
    return ((EffectZimuManager)((VideoAppInterface)this.a).a(0)).b();
  }
  
  boolean c()
  {
    return ((AudioTransClientInterfaceHandler)this.a.getBusinessHandler(0)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend
 * JD-Core Version:    0.7.0.1
 */