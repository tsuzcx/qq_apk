package com.tencent.aiosharemusic;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class AioShareMusicIPCWebClient
  extends QIPCModule
{
  private AioShareMusicIPCWebClient.AioShareMusicClient2WebCallback a;
  
  private AioShareMusicIPCWebClient()
  {
    super("AioShareMusicIPCWebClient");
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("AioShareMusicIPCMainClient", paramString, localBundle, paramEIPCResultCallback);
  }
  
  public static AioShareMusicIPCWebClient b()
  {
    return AioShareMusicIPCWebClient.Holder.a();
  }
  
  public void a()
  {
    try
    {
      this.a = null;
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(b());
        if (QLog.isColorLevel())
        {
          QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "unregister real");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "unregister ipc module error.", localException);
    }
  }
  
  public void a(AioShareMusicIPCWebClient.AioShareMusicClient2WebCallback paramAioShareMusicClient2WebCallback)
  {
    if (this.a != null) {
      return;
    }
    try
    {
      AioShareMusicIPCWebClient localAioShareMusicIPCWebClient = b();
      this.a = paramAioShareMusicClient2WebCallback;
      QIPCClientHelper.getInstance().register(localAioShareMusicIPCWebClient);
      if (QLog.isColorLevel())
      {
        QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "register real");
        return;
      }
    }
    catch (Exception paramAioShareMusicClient2WebCallback)
    {
      QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "register ipc module error.", paramAioShareMusicClient2WebCallback);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    try
    {
      paramBundle = new JSONObject(paramBundle.getString("data"));
      if (this.a != null) {
        this.a.a(paramString, paramBundle);
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aiosharemusic.AioShareMusicIPCWebClient
 * JD-Core Version:    0.7.0.1
 */