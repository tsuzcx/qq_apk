package com.tencent.aelight.camera.ae.qipc;

import android.os.Bundle;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import dov.com.qq.im.ae.current.SessionWrap;
import eipc.EIPCResult;
import java.util.Map;

public class AECameraGetInfoServer
  extends QIPCModule
{
  public AECameraGetInfoServer()
  {
    super("AECameraGetInfoServer");
  }
  
  public static AECameraGetInfoServer a()
  {
    return AECameraGetInfoServer.Holder.a;
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (a() == null) {
      return null;
    }
    if ("ACTION_GET_ENV_INFO".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putString("KEY_ENV_INFO", "ProdEnv");
      paramString = EIPCResult.createSuccessResult(paramString);
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("ACTION_SEND_GIF".equals(paramString))
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } else {
        paramString = null;
      }
      if (paramString == null) {
        return null;
      }
      SessionWrap localSessionWrap = new SessionWrap(paramBundle.getString("curFriendUin"), paramBundle.getString("curFriendNick"), paramBundle.getInt("curType"), paramBundle.getString("troopUin"));
      CameraEmoticonInfo localCameraEmoticonInfo = new CameraEmoticonInfo();
      localCameraEmoticonInfo.path = paramBundle.getString("ARG_GIF_PATH");
      localCameraEmoticonInfo.url = localCameraEmoticonInfo.path;
      localCameraEmoticonInfo.contextKey = paramBundle.getString("forward_summary_extra", "");
      localCameraEmoticonInfo.templateId = paramBundle.getString("widgetinfo", "");
      localCameraEmoticonInfo.send(paramString, BaseApplicationImpl.getContext(), null, localSessionWrap.a());
      return null;
    }
    if ("ACTION_DOWNLOAD_AE_RES".equals(paramString))
    {
      paramString = paramBundle.getString("KEY_RES_PREFIX");
      paramString = (AEResInfo)AEResUtil.a.get(paramString);
      paramBundle = new StringBuilder();
      paramBundle.append("[onCall] action=ACTION_DOWNLOAD_AE_RES, aeResInfo=");
      paramBundle.append(paramString);
      AEQLog.b("PreCheckAERes", paramBundle.toString());
      if (paramString != null)
      {
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(paramString, null, false);
        return EIPCResult.createSuccessResult(new Bundle());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.qipc.AECameraGetInfoServer
 * JD-Core Version:    0.7.0.1
 */