package com.tencent.luggage.wxa.mh;

import android.view.View;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.ma.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends d
{
  private static final int CTRL_INDEX = 87;
  public static final String NAME = "updateVideoPlayer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("videoPlayerId");
  }
  
  protected boolean a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof com.tencent.luggage.wxa.kt.b))
    {
      o.c("MicroMsg.JsApiUpdateVideoPlayer", "view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    a locala = (a)((com.tencent.luggage.wxa.kt.b)paramView).a(a.class);
    if (locala == null)
    {
      o.b("MicroMsg.JsApiUpdateVideoPlayer", "view not AppBrandVideoView");
      return false;
    }
    try
    {
      if (paramJSONObject.has("showDanmuBtn")) {
        locala.setShowDanmakuBtn(paramJSONObject.getBoolean("showDanmuBtn"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showDanmuBtn", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("danmuList")) {
        locala.setDanmakuItemList(paramJSONObject.getJSONArray("danmuList"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "danmuList", paramView.getLocalizedMessage() });
    }
    String str = null;
    Object localObject = null;
    paramView = localObject;
    View localView;
    try
    {
      if (paramJSONObject.has("objectFit"))
      {
        paramView = localObject;
        str = paramJSONObject.getString("objectFit");
        paramView = str;
        locala.setObjectFit(str);
      }
    }
    catch (JSONException localJSONException)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "objectFit", localJSONException.getLocalizedMessage() });
      localView = paramView;
    }
    try
    {
      if (paramJSONObject.has("autoplay")) {
        locala.setAutoPlay(paramJSONObject.getBoolean("autoplay"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoplay", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showBasicControls")) {
        locala.setIsShowBasicControls(paramJSONObject.getBoolean("showBasicControls"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showBasicControls", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("poster")) {
        locala.a(paramJSONObject.getString("poster"), localView);
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "poster", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("direction")) {
        locala.setFullScreenDirection(paramJSONObject.getInt("direction"));
      }
    }
    catch (Exception paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "direction", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("muted")) {
        locala.setMute(paramJSONObject.getBoolean("muted"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "muted", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("loop")) {
        locala.setLoop(paramJSONObject.getBoolean("loop"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "loop", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("data")) {
        locala.setCookieData(paramJSONObject.getString("data"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "data", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("pageGesture")) {
        locala.setPageGesture(paramJSONObject.getBoolean("pageGesture"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "pageGesture", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("pageGestureInFullscreen")) {
        locala.setPageGestureInFullscreen(paramJSONObject.getBoolean("pageGestureInFullscreen"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "pageGestureInFullscreen", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showControlProgress")) {
        locala.setShowControlProgress(paramJSONObject.getBoolean("showControlProgress"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showControlProgress", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showProgress")) {
        locala.setShowProgress(paramJSONObject.getBoolean("showProgress"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showProgress", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showProgressInControlMode")) {
        locala.setShowProgressBarInControlMode(paramJSONObject.getBoolean("showProgressInControlMode"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showProgressInControlMode", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showFullScreenBtn")) {
        locala.setShowFullScreenBtn(paramJSONObject.getBoolean("showFullScreenBtn"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showFullScreenBtn", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showPlayBtn")) {
        locala.setShowPlayBtn(paramJSONObject.getBoolean("showPlayBtn"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showPlayBtn", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showCenterPlayBtn")) {
        locala.setShowCenterPlayBtn(paramJSONObject.getBoolean("showCenterPlayBtn"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showCenterPlayBtn", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enableProgressGesture")) {
        locala.a(paramJSONObject.getBoolean("enableProgressGesture"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "enableProgressGesture", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("duration")) {
        locala.setDuration(paramJSONObject.getInt("duration"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "disableScroll", paramView.getLocalizedMessage() });
    }
    try
    {
      if ((paramJSONObject.has("hide")) && (paramJSONObject.getBoolean("hide")))
      {
        o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
        locala.c();
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "hide", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("initialTime")) {
        locala.setInitialTime(paramJSONObject.getInt("initialTime"));
      }
    }
    catch (JSONException paramView)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "initialTime", paramView.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("needEvent")) {
        if (!paramJSONObject.getBoolean("needEvent")) {
          locala.setCallback(null);
        } else if (!locala.g()) {
          locala.setCallback(new com.tencent.luggage.wxa.mg.b(locala, parame));
        }
      }
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "needEvent", parame.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("showMuteBtn")) {
        locala.setShowMuteBtn(paramJSONObject.getBoolean("showMuteBtn"));
      }
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showMuteBtn", parame.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("title")) {
        locala.setTitle(paramJSONObject.getString("title"));
      }
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "title", parame.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("playBtnPosition")) {
        locala.setPlayBtnPosition(paramJSONObject.getString("playBtnPosition"));
      }
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "playBtnPosition", parame.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("enablePlayGesture")) {
        locala.setEnablePlayGesture(paramJSONObject.getBoolean("enablePlayGesture"));
      }
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "enablePlayGesture", parame.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("autoPauseIfOpenNative")) {
        locala.setAutoPauseIfOpenNative(paramJSONObject.getBoolean("autoPauseIfOpenNative"));
      }
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoPauseIfOpenNative", parame.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("autoPauseIfNavigate")) {
        locala.setAutoPauseIfNavigate(paramJSONObject.getBoolean("autoPauseIfNavigate"));
      }
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoPauseIfNavigate", parame.getLocalizedMessage() });
    }
    try
    {
      if (paramJSONObject.has("filePath")) {
        locala.a(paramJSONObject.getString("filePath"), paramJSONObject.optBoolean("live"), paramJSONObject.optInt("duration"));
      }
      return true;
    }
    catch (JSONException parame)
    {
      o.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "filePath", parame.getLocalizedMessage() });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mh.e
 * JD-Core Version:    0.7.0.1
 */