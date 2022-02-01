package com.tencent.luggage.wxa.fz;

import android.os.Bundle;
import android.util.Log;
import com.tencent.luggage.wxa.qz.o;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static Bundle a(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePlayer params:");
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    Log.i("TXLivePlayerJSAdapter", localStringBuilder.toString());
    Object localObject = new Bundle();
    try
    {
      if (paramJSONObject.has("playUrl")) {
        ((Bundle)localObject).putString("playUrl", paramJSONObject.getString("playUrl"));
      }
    }
    catch (JSONException localJSONException1)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "playUrl", localJSONException1.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("mode")) {
        ((Bundle)localObject).putInt("mode", paramJSONObject.getInt("mode"));
      }
    }
    catch (JSONException localJSONException2)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("autoplay")) {
        ((Bundle)localObject).putBoolean("autoplay", paramJSONObject.getBoolean("autoplay"));
      }
    }
    catch (JSONException localJSONException3)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoplay", localJSONException3.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("muted")) {
        ((Bundle)localObject).putBoolean("muted", paramJSONObject.getBoolean("muted"));
      }
    }
    catch (JSONException localJSONException4)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "muted", localJSONException4.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("muteAudio")) {
        ((Bundle)localObject).putBoolean("muteAudio", paramJSONObject.getBoolean("muteAudio"));
      }
    }
    catch (JSONException localJSONException5)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "muteAudio", localJSONException5.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("muteVideo")) {
        ((Bundle)localObject).putBoolean("muteVideo", paramJSONObject.getBoolean("muteVideo"));
      }
    }
    catch (JSONException localJSONException6)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "muteVideo", localJSONException6.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("orientation")) {
        ((Bundle)localObject).putString("orientation", paramJSONObject.getString("orientation"));
      }
    }
    catch (JSONException localJSONException7)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "orientation", localJSONException7.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("objectFit")) {
        ((Bundle)localObject).putString("objectFit", paramJSONObject.getString("objectFit"));
      }
    }
    catch (JSONException localJSONException8)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "objectFit", localJSONException8.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("backgroundMute")) {
        ((Bundle)localObject).putBoolean("backgroundMute", paramJSONObject.getBoolean("backgroundMute"));
      }
    }
    catch (JSONException localJSONException9)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "backgroundMute", localJSONException9.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("minCache")) {
        ((Bundle)localObject).putFloat("minCache", BigDecimal.valueOf(paramJSONObject.getDouble("minCache")).floatValue());
      }
    }
    catch (JSONException localJSONException10)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "minCache", localJSONException10.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("maxCache")) {
        ((Bundle)localObject).putFloat("maxCache", BigDecimal.valueOf(paramJSONObject.getDouble("maxCache")).floatValue());
      }
    }
    catch (JSONException localJSONException11)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "maxCache", localJSONException11.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enableRecvMessage")) {
        ((Bundle)localObject).putBoolean("enableRecvMessage", paramJSONObject.getBoolean("enableRecvMessage"));
      }
    }
    catch (JSONException localJSONException12)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "enableRecvMessage", localJSONException12.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("needEvent")) {
        ((Bundle)localObject).putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
      }
    }
    catch (JSONException localJSONException13)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "needEvent", localJSONException13.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("needAudioVolume")) {
        ((Bundle)localObject).putBoolean("needAudioVolume", paramJSONObject.getBoolean("needAudioVolume"));
      }
    }
    catch (JSONException localJSONException14)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "needAudioVolume", localJSONException14.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("debug")) {
        ((Bundle)localObject).putBoolean("debug", paramJSONObject.getBoolean("debug"));
      }
    }
    catch (JSONException localJSONException15)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "debug", localJSONException15.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("soundMode")) {
        ((Bundle)localObject).putString("soundMode", paramJSONObject.getString("soundMode"));
      }
    }
    catch (JSONException localJSONException16)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "soundMode", localJSONException16.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("autoPauseIfNavigate")) {
        ((Bundle)localObject).putBoolean("autoPauseIfNavigate", paramJSONObject.getBoolean("autoPauseIfNavigate"));
      }
    }
    catch (JSONException localJSONException17)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoPauseIfNavigate", localJSONException17.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("autoPauseIfOpenNative")) {
        ((Bundle)localObject).putBoolean("autoPauseIfOpenNative", paramJSONObject.getBoolean("autoPauseIfOpenNative"));
      }
    }
    catch (JSONException localJSONException18)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoPauseIfOpenNative", localJSONException18.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("referrer")) {
        ((Bundle)localObject).putString("referrer", paramJSONObject.getString("referrer"));
      }
    }
    catch (JSONException localJSONException19)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "referrer", localJSONException19.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("canStartPlay")) {
        ((Bundle)localObject).putBoolean("canStartPlay", paramJSONObject.getBoolean("canStartPlay"));
      }
    }
    catch (JSONException localJSONException20)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "canStartPlay", localJSONException20.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("isVoip"))
      {
        ((Bundle)localObject).putBoolean("isVoip", paramJSONObject.getBoolean("isVoip"));
        return localObject;
      }
    }
    catch (JSONException paramJSONObject)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "isVoip", paramJSONObject.getLocalizedMessage() });
    }
    return localObject;
  }
  
  public static Bundle b(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LivePusher params:");
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    Log.i("TXLivePusherJSAdapter", localStringBuilder.toString());
    Object localObject = new Bundle();
    try
    {
      if (paramJSONObject.has("pushUrl")) {
        ((Bundle)localObject).putString("pushUrl", paramJSONObject.getString("pushUrl"));
      }
    }
    catch (JSONException localJSONException1)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "pushUrl", localJSONException1.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("mode")) {
        ((Bundle)localObject).putInt("mode", paramJSONObject.getInt("mode"));
      }
    }
    catch (JSONException localJSONException2)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("autopush")) {
        ((Bundle)localObject).putBoolean("autopush", paramJSONObject.getBoolean("autopush"));
      }
    }
    catch (JSONException localJSONException3)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "autopush", localJSONException3.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("audioQuality")) {
        ((Bundle)localObject).putString("audioQuality", paramJSONObject.getString("audioQuality"));
      }
    }
    catch (JSONException localJSONException4)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "audioQuality", localJSONException4.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("muted")) {
        ((Bundle)localObject).putBoolean("muted", paramJSONObject.getBoolean("muted"));
      }
    }
    catch (JSONException localJSONException5)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "muted", localJSONException5.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enableCamera")) {
        ((Bundle)localObject).putBoolean("enableCamera", paramJSONObject.getBoolean("enableCamera"));
      }
    }
    catch (JSONException localJSONException6)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableCamera", localJSONException6.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enableMic")) {
        ((Bundle)localObject).putBoolean("enableMic", paramJSONObject.getBoolean("enableMic"));
      }
    }
    catch (JSONException localJSONException7)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableMic", localJSONException7.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enableAGC")) {
        ((Bundle)localObject).putBoolean("enableAGC", paramJSONObject.getBoolean("enableAGC"));
      }
    }
    catch (JSONException localJSONException8)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableAGC", localJSONException8.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enableANS")) {
        ((Bundle)localObject).putBoolean("enableANS", paramJSONObject.getBoolean("enableANS"));
      }
    }
    catch (JSONException localJSONException9)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableANS", localJSONException9.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enableEarMonitor")) {
        ((Bundle)localObject).putBoolean("enableEarMonitor", paramJSONObject.getBoolean("enableEarMonitor"));
      }
    }
    catch (JSONException localJSONException10)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableEarMonitor", localJSONException10.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("audioVolumeType")) {
        ((Bundle)localObject).putString("audioVolumeType", paramJSONObject.getString("audioVolumeType"));
      }
    }
    catch (JSONException localJSONException11)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "audioVolumeType", localJSONException11.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("audioReverbType")) {
        ((Bundle)localObject).putInt("audioReverbType", paramJSONObject.getInt("audioReverbType"));
      }
    }
    catch (JSONException localJSONException12)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "audioReverbType", localJSONException12.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("videoWidth")) {
        ((Bundle)localObject).putInt("videoWidth", paramJSONObject.getInt("videoWidth"));
      }
    }
    catch (JSONException localJSONException13)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "videoWidth", localJSONException13.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("videoHeight")) {
        ((Bundle)localObject).putInt("videoHeight", paramJSONObject.getInt("videoHeight"));
      }
    }
    catch (JSONException localJSONException14)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "videoHeight", localJSONException14.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("focusMode")) {
        ((Bundle)localObject).putInt("focusMode", paramJSONObject.getInt("focusMode"));
      }
    }
    catch (JSONException localJSONException15)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "focusMode", localJSONException15.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("orientation")) {
        ((Bundle)localObject).putString("orientation", paramJSONObject.getString("orientation"));
      }
    }
    catch (JSONException localJSONException16)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "orientation", localJSONException16.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("beauty")) {
        ((Bundle)localObject).putInt("beauty", paramJSONObject.getInt("beauty"));
      }
    }
    catch (JSONException localJSONException17)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "beauty", localJSONException17.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("beautyStyle")) {
        ((Bundle)localObject).putString("beautyStyle", paramJSONObject.getString("beautyStyle"));
      }
    }
    catch (JSONException localJSONException18)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "beautyStyle", localJSONException18.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("filterImage")) {
        ((Bundle)localObject).putString("filterImage", paramJSONObject.getString("filterImage"));
      }
    }
    catch (JSONException localJSONException19)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "filterImage", localJSONException19.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("filterImageMd5")) {
        ((Bundle)localObject).putString("filterImageMd5", paramJSONObject.getString("filterImageMd5"));
      }
    }
    catch (JSONException localJSONException20)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "filterImageMd5", localJSONException20.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("whiteness")) {
        ((Bundle)localObject).putInt("whiteness", paramJSONObject.getInt("whiteness"));
      }
    }
    catch (JSONException localJSONException21)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "whiteness", localJSONException21.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("aspect")) {
        ((Bundle)localObject).putInt("aspect", paramJSONObject.getInt("aspect"));
      }
    }
    catch (JSONException localJSONException22)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "aspect", localJSONException22.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("minBitrate")) {
        ((Bundle)localObject).putInt("minBitrate", paramJSONObject.getInt("minBitrate"));
      }
    }
    catch (JSONException localJSONException23)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "minBitrate", localJSONException23.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("maxBitrate")) {
        ((Bundle)localObject).putInt("maxBitrate", paramJSONObject.getInt("maxBitrate"));
      }
    }
    catch (JSONException localJSONException24)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "maxBitrate", localJSONException24.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("backgroundMute")) {
        ((Bundle)localObject).putBoolean("backgroundMute", paramJSONObject.getBoolean("backgroundMute"));
      }
    }
    catch (JSONException localJSONException25)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "backgroundMute", localJSONException25.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("zoom")) {
        ((Bundle)localObject).putBoolean("zoom", paramJSONObject.getBoolean("zoom"));
      }
    }
    catch (JSONException localJSONException26)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "zoom", localJSONException26.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("needEvent")) {
        ((Bundle)localObject).putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
      }
    }
    catch (JSONException localJSONException27)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needEvent", localJSONException27.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("debug")) {
        ((Bundle)localObject).putBoolean("debug", paramJSONObject.getBoolean("debug"));
      }
    }
    catch (JSONException localJSONException28)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "debug", localJSONException28.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("mirror")) {
        ((Bundle)localObject).putBoolean("mirror", paramJSONObject.getBoolean("mirror"));
      }
    }
    catch (JSONException localJSONException29)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "mirror", localJSONException29.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("remoteMirror")) {
        ((Bundle)localObject).putBoolean("remoteMirror", paramJSONObject.getBoolean("remoteMirror"));
      }
    }
    catch (JSONException localJSONException30)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "remoteMirror", localJSONException30.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("localMirror")) {
        ((Bundle)localObject).putString("localMirror", paramJSONObject.getString("localMirror"));
      }
    }
    catch (JSONException localJSONException31)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "localMirror", localJSONException31.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("watermarkLeft")) {
        ((Bundle)localObject).putFloat("watermarkLeft", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkLeft")).floatValue());
      }
    }
    catch (JSONException localJSONException32)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkLeft", localJSONException32.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("watermarkTop")) {
        ((Bundle)localObject).putFloat("watermarkTop", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkTop")).floatValue());
      }
    }
    catch (JSONException localJSONException33)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkTop", localJSONException33.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("watermarkWidth")) {
        ((Bundle)localObject).putFloat("watermarkWidth", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkWidth")).floatValue());
      }
    }
    catch (JSONException localJSONException34)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkWidth", localJSONException34.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("devicePosition")) {
        ((Bundle)localObject).putString("devicePosition", paramJSONObject.getString("devicePosition"));
      }
    }
    catch (JSONException localJSONException35)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "devicePosition", localJSONException35.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("needBGMEvent")) {
        ((Bundle)localObject).putBoolean("needBGMEvent", paramJSONObject.getBoolean("needBGMEvent"));
      }
    }
    catch (JSONException localJSONException36)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needBGMEvent", localJSONException36.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("needAudioVolume")) {
        ((Bundle)localObject).putBoolean("needAudioVolume", paramJSONObject.getBoolean("needAudioVolume"));
      }
    }
    catch (JSONException localJSONException37)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needAudioVolume", localJSONException37.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("customEffect")) {
        ((Bundle)localObject).putBoolean("customEffect", paramJSONObject.getBoolean("customEffect"));
      }
    }
    catch (JSONException localJSONException38)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "customEffect", localJSONException38.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("skinWhiteness")) {
        ((Bundle)localObject).putFloat("skinWhiteness", BigDecimal.valueOf(paramJSONObject.getDouble("skinWhiteness")).floatValue());
      }
    }
    catch (JSONException localJSONException39)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "skinWhiteness", localJSONException39.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("skinSmoothness")) {
        ((Bundle)localObject).putFloat("skinSmoothness", BigDecimal.valueOf(paramJSONObject.getDouble("skinSmoothness")).floatValue());
      }
    }
    catch (JSONException localJSONException40)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "skinSmoothness", localJSONException40.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("faceThinness")) {
        ((Bundle)localObject).putFloat("faceThinness", BigDecimal.valueOf(paramJSONObject.getDouble("faceThinness")).floatValue());
      }
    }
    catch (JSONException localJSONException41)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "faceThinness", localJSONException41.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("eyeBigness")) {
        ((Bundle)localObject).putFloat("eyeBigness", BigDecimal.valueOf(paramJSONObject.getDouble("eyeBigness")).floatValue());
      }
    }
    catch (JSONException localJSONException42)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "eyeBigness", localJSONException42.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("isVoip"))
      {
        ((Bundle)localObject).putBoolean("isVoip", paramJSONObject.getBoolean("isVoip"));
        return localObject;
      }
    }
    catch (JSONException paramJSONObject)
    {
      o.d("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "isVoip", paramJSONObject.getLocalizedMessage() });
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fz.c
 * JD-Core Version:    0.7.0.1
 */