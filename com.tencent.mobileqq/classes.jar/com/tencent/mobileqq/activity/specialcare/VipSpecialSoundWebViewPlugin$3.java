package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.vas.aidl.IDownloadListener.Stub;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class VipSpecialSoundWebViewPlugin$3
  extends IDownloadListener.Stub
{
  VipSpecialSoundWebViewPlugin$3(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, localStringBuilder.toString());
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 2);
      paramString.put("errorCode", paramInt);
      this.b.callJs(this.a, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: ", paramString);
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 1);
      paramString.put("progress", i);
      this.b.callJs(this.a, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.3
 * JD-Core Version:    0.7.0.1
 */