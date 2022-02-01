package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPttImpl$1
  implements VoicePlayer.VoicePlayerListener
{
  PublicAccountH5AbilityPttImpl$1(PublicAccountH5AbilityPttImpl paramPublicAccountH5AbilityPttImpl) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = new JSONObject();
    if (paramInt1 == 8) {
      try
      {
        paramString.put("retCode", -1);
        paramString.put("msg", "fail");
        paramString.put("localId", this.a.getLocalIdForPTT());
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    } else if (paramInt1 == 4) {
      try
      {
        paramString.put("retCode", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131708768));
        localStringBuilder.append(this.a.getLocalIdForPTT());
        localStringBuilder.append(HardCodeUtil.a(2131708762));
        paramString.put("msg", localStringBuilder.toString());
        paramString.put("localId", this.a.getLocalIdForPTT());
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.voicePlayEndCallback, new String[] { paramString.toString() });
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2F", "0X8005D2F", 0, 0, "1", "", "", "");
    if (this.a.mPlayer != null) {
      this.a.mPlayer.e();
    }
    this.a.mPlayer = null;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl.1
 * JD-Core Version:    0.7.0.1
 */