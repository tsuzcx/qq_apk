package com.tencent.aiosharemusic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

public class AioShareMusicIPCMainClient
  extends QIPCModule
{
  private AioShareMusicIPCMainClient()
  {
    super("AioShareMusicIPCMainClient");
  }
  
  public static AioShareMusicIPCMainClient a()
  {
    return AioShareMusicIPCMainClient.Holder.a();
  }
  
  private void a(Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localQQAppInterface != null) {}
    try
    {
      ((ListenTogetherManager)localQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).c(new JSONObject(paramBundle.getString("data")));
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusic.AioShareMusicIPCMainClient", 2, "callWebClient data:" + paramJSONObject.toString() + "  isToolRunning:" + bool);
    }
    if (bool)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", paramJSONObject.toString());
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "AioShareMusicIPCWebClient", paramString, localBundle, null);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localQQAppInterface != null) {}
    try
    {
      ((ListenTogetherManager)localQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).b(new JSONObject(paramBundle.getString("data")));
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("checkAioShareMusic".equals(paramString)) {
      b(paramBundle);
    }
    for (;;)
    {
      return null;
      if ("startListenAioShareMusic".equals(paramString)) {
        a(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aiosharemusic.AioShareMusicIPCMainClient
 * JD-Core Version:    0.7.0.1
 */