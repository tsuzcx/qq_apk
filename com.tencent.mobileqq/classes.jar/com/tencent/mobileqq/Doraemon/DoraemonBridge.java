package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class DoraemonBridge
{
  AppRuntime a;
  
  public DoraemonBridge(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public static void a(int paramInt, Bundle paramBundle, Callback paramCallback)
  {
    ((IDoraemonClient)QRoute.api(IDoraemonClient.class)).sendToServer(paramInt, paramBundle, paramCallback);
  }
  
  public void a(int paramInt1, Bundle paramBundle, int paramInt2, Messenger paramMessenger)
  {
    paramInt2 = paramBundle.getInt("key_sub_cmd");
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3) {
          return;
        }
        paramMessenger = paramBundle.getString("key");
        paramInt1 = paramBundle.getInt("type");
        localObject = paramBundle.getString("appid");
        paramBundle = paramBundle.getString("api");
        DoraemonFrequenceController.a().b(paramMessenger, paramInt1, (String)localObject, paramBundle);
        return;
      }
      paramMessenger = paramBundle.getString("key");
      paramInt1 = paramBundle.getInt("type");
      paramBundle = paramBundle.getString("appid");
      DoraemonFrequenceController.a().b(paramMessenger, paramInt1, paramBundle);
      return;
    }
    paramBundle.putBundle("key_result", ((IDoraemonApi)QRoute.api(IDoraemonApi.class)).getUserInfo());
    Object localObject = Message.obtain(null, paramInt1);
    ((Message)localObject).setData(paramBundle);
    if (paramMessenger != null) {
      try
      {
        paramMessenger.send((Message)localObject);
        return;
      }
      catch (RemoteException paramBundle)
      {
        if (QLog.isColorLevel())
        {
          paramMessenger = new StringBuilder();
          paramMessenger.append("messeage not sent:");
          paramMessenger.append(paramBundle.getMessage());
          QLog.e("DoraemonBridge", 2, paramMessenger.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonBridge
 * JD-Core Version:    0.7.0.1
 */