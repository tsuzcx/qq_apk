package com.tencent.luggage.wxa.mh;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.c;
import com.tencent.mm.plugin.appbrand.page.bc;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.kd.b
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("videoPlayerId");
  }
  
  protected View a(e parame, JSONObject paramJSONObject)
  {
    parame = parame.getContext();
    paramJSONObject = new c(parame);
    Object localObject = new com.tencent.luggage.wxa.ma.b(parame);
    ((com.tencent.luggage.wxa.ma.b)localObject).setVideoFooterView(paramJSONObject);
    localObject = new com.tencent.luggage.wxa.ma.a(parame, (View)localObject);
    ((com.tencent.luggage.wxa.ma.a)localObject).a(paramJSONObject);
    return new com.tencent.luggage.wxa.kt.b(parame, (View)localObject);
  }
  
  protected void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.luggage.wxa.ma.a locala = (com.tencent.luggage.wxa.ma.a)((com.tencent.luggage.wxa.kt.b)paramView).a(com.tencent.luggage.wxa.ma.a.class);
    if (locala == null)
    {
      o.b("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
      return;
    }
    Object localObject1 = new a.1(this, locala);
    Object localObject2 = new a.2(this, locala);
    Object localObject3 = new a.3(this, parame, locala);
    Object localObject4 = new a.4(this, locala, parame, (f.d)localObject2, (f.b)localObject3);
    parame.a((f.d)localObject2);
    parame.a((f.b)localObject3);
    parame.a((f.c)localObject4);
    locala.setFullScreenDelegate(new a.5(this, parame, h(paramJSONObject), paramInt, (bc)localObject1));
    locala.setContentDescription(paramView.getContext().getString(2131886752));
    locala.setMute(paramJSONObject.optBoolean("muted", false));
    boolean bool1 = paramJSONObject.optBoolean("needEvent", false);
    boolean bool2 = paramJSONObject.optBoolean("autoplay", false);
    o.d("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    boolean bool3 = paramJSONObject.optBoolean("showDanmuBtn", false);
    boolean bool4 = paramJSONObject.optBoolean("enableDanmu", false);
    paramView = paramJSONObject.optJSONArray("danmuList");
    String str1 = paramJSONObject.optString("objectFit");
    String str2 = paramJSONObject.optString("poster");
    boolean bool5 = paramJSONObject.optBoolean("showBasicControls", true);
    String str3 = paramJSONObject.optString("data");
    paramInt = paramJSONObject.optInt("direction", -1);
    boolean bool6 = paramJSONObject.optBoolean("loop", false);
    boolean bool7 = paramJSONObject.optBoolean("pageGesture", false);
    boolean bool8 = paramJSONObject.optBoolean("pageGestureInFullscreen", true);
    double d = paramJSONObject.optDouble("initialTime", 0.0D);
    boolean bool9 = paramJSONObject.optBoolean("showProgress", true);
    boolean bool10 = paramJSONObject.optBoolean("showProgressInControlMode", true);
    boolean bool11 = paramJSONObject.optBoolean("showFullScreenBtn", true);
    boolean bool12 = paramJSONObject.optBoolean("showPlayBtn", true);
    boolean bool13 = paramJSONObject.optBoolean("showCenterPlayBtn", true);
    boolean bool14 = paramJSONObject.optBoolean("enableProgressGesture", true);
    localObject1 = paramJSONObject.optString("scene", "default");
    boolean bool15 = paramJSONObject.optBoolean("showMuteBtn", false);
    localObject2 = paramJSONObject.optString("title", "");
    boolean bool16 = paramJSONObject.optBoolean("showControlProgress", true);
    localObject3 = paramJSONObject.optString("playBtnPosition", "bottom");
    boolean bool17 = paramJSONObject.optBoolean("enablePlayGesture", false);
    boolean bool18 = paramJSONObject.optBoolean("autoPauseIfNavigate", true);
    boolean bool19 = paramJSONObject.optBoolean("autoPauseIfOpenNative", true);
    localObject4 = paramJSONObject.optString("backgroundColor");
    locala.setComponent(parame);
    locala.setCookieData(str3);
    locala.setIsShowBasicControls(bool5);
    locala.a(str2, str1);
    locala.setFullScreenDirection(paramInt);
    locala.setObjectFit(str1);
    locala.setLoop(bool6);
    locala.setPageGesture(bool7);
    locala.setPageGestureInFullscreen(bool8);
    try
    {
      locala.setVideoPlayerId(a(paramJSONObject));
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[] { localJSONException });
    }
    locala.setAutoPlay(bool2);
    locala.setShowDanmakuBtn(bool3);
    locala.setDanmakuEnable(bool4);
    locala.setDanmakuItemList(paramView);
    locala.setInitialTime(d);
    locala.setShowControlProgress(bool16);
    locala.setShowProgress(bool9);
    locala.setShowProgressBarInControlMode(bool10);
    locala.setShowFullScreenBtn(bool11);
    locala.setShowPlayBtn(bool12);
    locala.setShowCenterPlayBtn(bool13);
    locala.a(bool14);
    if (((String)localObject1).equalsIgnoreCase("default")) {
      locala.setVideoSource(0);
    } else {
      locala.setVideoSource(1);
    }
    locala.setShowMuteBtn(bool15);
    locala.setTitle((String)localObject2);
    locala.setPlayBtnPosition((String)localObject3);
    locala.setEnablePlayGesture(bool17);
    locala.setAutoPauseIfNavigate(bool18);
    locala.setAutoPauseIfOpenNative(bool19);
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      paramInt = -16777216;
      if ("transparent".equals(localObject4)) {
        paramInt = 0;
      }
    }
    try
    {
      int i = Color.parseColor((String)localObject4);
      paramInt = i;
    }
    catch (IllegalArgumentException paramView)
    {
      label770:
      break label770;
    }
    locala.setBackgroundColor(paramInt);
    if (bool1) {
      locala.setCallback(new com.tencent.luggage.wxa.mg.b(locala, parame));
    }
    paramInt = paramJSONObject.optInt("duration", -1);
    parame = paramJSONObject.optString("filePath");
    bool1 = paramJSONObject.optBoolean("live", false);
    o.d("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[] { parame, Boolean.valueOf(bool1) });
    locala.a(parame, bool1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mh.a
 * JD-Core Version:    0.7.0.1
 */