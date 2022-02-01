package com.tencent.luggage.wxa.mh;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.ma.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends d
{
  private static final int CTRL_INDEX = 114;
  public static final String NAME = "operateVideoPlayer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("videoPlayerId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiOperateVideoPlayer", "onOperateView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiOperateVideoPlayer", "view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (a)((b)paramView).a(a.class);
    if (parame == null)
    {
      o.b("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
      return false;
    }
    paramView = paramJSONObject.optString("type");
    o.d("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType=%s", new Object[] { paramView });
    paramInt = paramView.hashCode();
    int i = -1;
    switch (paramInt)
    {
    default: 
      break;
    case 1355420059: 
      if (paramView.equals("playbackRate")) {
        paramInt = 5;
      }
      break;
    case 458133450: 
      if (paramView.equals("requestFullScreen")) {
        paramInt = 3;
      }
      break;
    case 106440182: 
      if (paramView.equals("pause")) {
        paramInt = 1;
      }
      break;
    case 3540994: 
      if (paramView.equals("stop")) {
        paramInt = 2;
      }
      break;
    case 3526264: 
      if (paramView.equals("seek")) {
        paramInt = 6;
      }
      break;
    case 3443508: 
      if (paramView.equals("play")) {
        paramInt = 0;
      }
      break;
    case 1222225: 
      if (paramView.equals("sendDanmu")) {
        paramInt = 7;
      }
      break;
    case -802181223: 
      if (paramView.equals("exitFullScreen")) {
        paramInt = 4;
      }
      break;
    }
    paramInt = -1;
    double d;
    switch (paramInt)
    {
    default: 
      o.c("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType not supported: %s", new Object[] { paramView });
      return false;
    case 7: 
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView != null) && (paramView.length() != 0))
      {
        if (paramView.length() == 1)
        {
          parame.b(paramView.optString(0, ""), "");
          return true;
        }
        parame.b(paramView.optString(0, ""), paramView.optString(1, ""));
        return true;
      }
      o.c("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
      return false;
    case 6: 
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView != null) && (paramView.length() != 0))
      {
        d = paramView.optDouble(0, -1.0D);
        if (d < 0.0D)
        {
          o.d("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %s", new Object[] { Double.valueOf(d) });
          return false;
        }
        parame.a(d);
        return true;
      }
      o.c("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
      return false;
    case 5: 
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView != null) && (paramView.length() != 0))
      {
        d = paramView.optDouble(0, -1.0D);
        if (d < 0.0D)
        {
          o.d("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", new Object[] { Double.valueOf(d) });
          return false;
        }
        parame.a((float)d);
        return true;
      }
      o.c("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
      return false;
    case 4: 
      parame.a(false, -1);
      return true;
    case 3: 
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView != null) && (paramView.length() != 0))
      {
        paramInt = paramView.optInt(0, -1);
      }
      else
      {
        o.c("MicroMsg.JsApiOperateVideoPlayer", "onOperateView directionArr nil");
        paramInt = i;
      }
      parame.a(true, paramInt);
      return true;
    case 2: 
      parame.c();
      return true;
    case 1: 
      parame.b();
      return true;
    }
    parame.a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mh.c
 * JD-Core Version:    0.7.0.1
 */