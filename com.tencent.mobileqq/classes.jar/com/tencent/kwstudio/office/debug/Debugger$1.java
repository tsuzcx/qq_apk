package com.tencent.kwstudio.office.debug;

import android.text.TextUtils;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;
import org.json.JSONObject;

final class Debugger$1
  implements IHostInterface.IHttpListener
{
  Debugger$1(String paramString) {}
  
  public void onResponse(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("status=");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject3 = null;
      try
      {
        localObject1 = new JSONObject(paramString);
      }
      catch (Exception localException)
      {
        Log.e("Debugger", "checkWhiteListFromRemote error", localException);
        localObject2 = null;
      }
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("rsp=");
        ((StringBuilder)localObject2).append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        boolean bool = ((JSONObject)localObject2).has("retcode");
        paramInt = ((JSONObject)localObject2).optInt("retcode");
        if ((bool) && (paramInt == 0))
        {
          if (((JSONObject)localObject2).has("is_white_uin"))
          {
            paramInt = ((JSONObject)localObject2).optInt("is_white_uin");
            paramString = this.val$moduleId;
            bool = true;
            if (paramInt != 1) {
              bool = false;
            }
            Debugger.access$000(paramString, bool);
            return;
          }
          localObject2 = "no has white";
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("retCode=");
          paramString = localObject3;
          if (bool) {
            paramString = Integer.valueOf(paramInt);
          }
          ((StringBuilder)localObject2).append(paramString);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("checkWhiteListFromRemote ");
    paramString.append((String)localObject2);
    Log.w("Debugger", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger.1
 * JD-Core Version:    0.7.0.1
 */