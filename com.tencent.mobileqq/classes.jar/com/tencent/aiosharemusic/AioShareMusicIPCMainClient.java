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
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localQQAppInterface = null;
    }
    if (localQQAppInterface != null) {
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
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callWebClient data:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      ((StringBuilder)localObject).append("  isToolRunning:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("AioShareMusic.AioShareMusicIPCMainClient", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("data", paramJSONObject.toString());
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "AioShareMusicIPCWebClient", paramString, (Bundle)localObject, null);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localQQAppInterface = null;
    }
    if (localQQAppInterface != null) {
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
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("checkAioShareMusic".equals(paramString)) {
      b(paramBundle);
    } else if ("startListenAioShareMusic".equals(paramString)) {
      a(paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aiosharemusic.AioShareMusicIPCMainClient
 * JD-Core Version:    0.7.0.1
 */