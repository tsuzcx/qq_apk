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
    boolean bool1 = true;
    Object localObject = "status=" + paramInt;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        localObject = new JSONObject(paramString);
        if (localObject == null)
        {
          paramString = "rsp=" + paramString;
          Log.w("Debugger", "checkWhiteListFromRemote " + paramString);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("Debugger", "checkWhiteListFromRemote error", localException);
        localStringBuilder = null;
        continue;
        boolean bool2 = localStringBuilder.has("retcode");
        paramInt = localStringBuilder.optInt("retcode");
        if ((bool2) && (paramInt == 0))
        {
          if (localStringBuilder.has("is_white_uin"))
          {
            paramInt = localStringBuilder.optInt("is_white_uin");
            paramString = this.val$moduleId;
            if (paramInt == 1)
            {
              Debugger.access$000(paramString, bool1);
              return;
            }
            bool1 = false;
            continue;
          }
          paramString = "no has white";
          continue;
        }
        localStringBuilder = new StringBuilder().append("retCode=");
        if (!bool2) {}
      }
      for (paramString = Integer.valueOf(paramInt);; paramString = null)
      {
        paramString = paramString;
        break;
      }
      paramString = localStringBuilder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger.1
 * JD-Core Version:    0.7.0.1
 */