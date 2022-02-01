package com.tencent.biz.webviewplugin;

import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class OfflinePlugin$1
  implements AsyncBack
{
  OfflinePlugin$1(OfflinePlugin paramOfflinePlugin) {}
  
  public void loaded(String paramString, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("-->offline:checkOfflineUp. result: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", code: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == 9)
    {
      Object localObject3 = null;
      Object localObject2;
      try
      {
        localObject1 = new JSONObject(paramString);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("-->offline:checkUp loaded err:");
          ((StringBuilder)localObject2).append(paramString);
          QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject2).toString());
          localObject2 = localObject3;
        }
      }
      paramString = this.a.u.obtainMessage();
      paramString.arg1 = 3;
      paramString.obj = localObject2;
      this.a.u.sendMessage(paramString);
      return;
    }
    if (paramInt == -1)
    {
      paramString = this.a.u.obtainMessage();
      paramString.arg1 = 2;
      this.a.u.sendMessage(paramString);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.1
 * JD-Core Version:    0.7.0.1
 */