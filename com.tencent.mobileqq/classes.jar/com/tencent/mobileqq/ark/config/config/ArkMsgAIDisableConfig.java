package com.tencent.mobileqq.ark.config.config;

import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkMsgAIDisableConfig
  implements IQStorageSafable<String>
{
  public boolean a = true;
  public boolean b = true;
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("ark_app_manage_panel_disable", 1);
        boolean bool2 = false;
        if (i != 0)
        {
          bool1 = true;
          this.a = bool1;
          bool1 = bool2;
          if (paramString.optInt("ark_download_by_yyb_disable", 1) != 0) {
            bool1 = true;
          }
          this.b = bool1;
          paramString = new StringBuilder("onParse ");
          paramString.append(", ark_app_manage_panel_disable=");
          paramString.append(this.a);
          paramString.append(", ark_download_by_yyb_disable=");
          paramString.append(this.b);
          QLog.i("ArkMsgAIDisableConfig", 1, paramString.toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleArkMsgAIDisableConfig parse config_content exception=");
        localStringBuilder.append(paramString);
        QLog.e("ArkMsgAIDisableConfig", 1, localStringBuilder.toString());
        return;
      }
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.config.ArkMsgAIDisableConfig
 * JD-Core Version:    0.7.0.1
 */