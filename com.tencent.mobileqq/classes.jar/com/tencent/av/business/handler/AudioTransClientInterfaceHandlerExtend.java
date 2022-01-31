package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.VideoPackageUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.common.app.AppInterface;
import java.util.List;

public class AudioTransClientInterfaceHandlerExtend
  extends AudioTransClientInterfaceHandler
{
  public AudioTransClientInterfaceHandlerExtend(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected int a()
  {
    Object localObject = (VideoAppInterface)this.a;
    if (((VideoAppInterface)localObject).a(0))
    {
      localObject = (EffectZimuManager)((VideoAppInterface)localObject).a(0);
      if (localObject != null) {
        return ((EffectZimuManager)localObject).b();
      }
    }
    return 4;
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    AVLog.c("AudioTransClientInterfaceHandlerExtend.runhw", "notifyEvent :" + paramInteger + "|" + paramObject);
    ((VideoAppInterface)this.a).a(new Object[] { paramInteger, paramObject });
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(Integer.valueOf(6008), new SentenceInfo(paramString1, paramString2, paramString3, paramInt));
  }
  
  protected void a(boolean paramBoolean, List paramList, long paramLong)
  {
    VideoController localVideoController = ((VideoAppInterface)this.a).a();
    AVLog.c("AudioTransClientInterfaceHandlerExtend.runhw", "requestRecordingAudio:" + localVideoController + "|" + paramBoolean + "|" + paramLong + "|" + paramList);
    if ((localVideoController != null) && (localVideoController.a() != null))
    {
      long l = VideoPackageUtils.a(localVideoController.a().c);
      AVLog.c("AudioTransClientInterfaceHandlerExtend.runhw", "requestRecordingAudio:" + l + "|" + paramBoolean);
      localVideoController.a(l, paramBoolean, paramList, paramLong);
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = false;
    Object localObject = (VideoAppInterface)this.a;
    boolean bool1 = bool2;
    if (((VideoAppInterface)localObject).a(0))
    {
      localObject = (EffectZimuManager)((VideoAppInterface)localObject).a(0);
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = (ZimuItem)((EffectZimuManager)localObject).a();
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equalsIgnoreCase("film"))) {
            break label74;
          }
        }
      }
    }
    label74:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInterfaceHandlerExtend
 * JD-Core Version:    0.7.0.1
 */