package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.VideoPackageUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AudioTransClientInterfaceHandlerExtend
  extends AudioTransClientInterfaceHandler
{
  public AudioTransClientInterfaceHandlerExtend(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected void a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2)
  {
    VideoController localVideoController = ((VideoAppInterface)this.appRuntime).b();
    SessionInfo localSessionInfo = localVideoController.k();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestRecordingAudio, isStart[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], sessionid[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], iplist[");
    String str = "null";
    Object localObject;
    if (paramList == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramList.size());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append("], peerUin[");
    if (localSessionInfo == null) {
      localObject = str;
    } else {
      localObject = localSessionInfo.s;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    QLog.w("AudioTransClientInterfaceHandlerExtend.runhw", 1, localStringBuilder.toString());
    if ((localVideoController != null) && (localSessionInfo != null)) {
      localVideoController.a(VideoPackageUtils.a(localSessionInfo.s), paramBoolean, paramList, paramLong2);
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject);
    AVLog.printColorLog("AudioTransClientInterfaceHandlerExtend.runhw", localStringBuilder.toString());
    ((VideoAppInterface)this.appRuntime).a(new Object[] { paramInteger, paramObject });
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(Integer.valueOf(6008), new SentenceInfo(paramString1, paramString2, paramString3, paramInt));
  }
  
  protected boolean a()
  {
    Object localObject = (VideoAppInterface)this.appRuntime;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (((VideoAppInterface)localObject).d(0))
    {
      localObject = (EffectZimuManager)((VideoAppInterface)localObject).c(0);
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = (ZimuItem)((EffectZimuManager)localObject).c();
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          bool1 = bool2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            bool1 = bool2;
            if (((String)localObject).equalsIgnoreCase("film")) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInterfaceHandlerExtend
 * JD-Core Version:    0.7.0.1
 */