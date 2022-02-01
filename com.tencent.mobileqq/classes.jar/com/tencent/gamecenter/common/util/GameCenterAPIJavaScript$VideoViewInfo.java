package com.tencent.gamecenter.common.util;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterAPIJavaScript$VideoViewInfo
{
  public GameCenterVideoViewController a;
  public FrameLayout b;
  public Map<Integer, View> c;
  public int d;
  public int e;
  public int f;
  public String g;
  public String h;
  public int i;
  public String j;
  public boolean k;
  public boolean l;
  public boolean m = false;
  public int n;
  public boolean o = false;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  
  public GameCenterAPIJavaScript$VideoViewInfo(GameCenterVideoViewController paramGameCenterVideoViewController, FrameLayout paramFrameLayout, Map<Integer, View> paramMap)
  {
    this.a = paramGameCenterVideoViewController;
    this.b = paramFrameLayout;
    this.c = paramMap;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.d);
      localJSONObject.put("x", this.f);
      localJSONObject.put("y", this.e);
      localJSONObject.put("vid", this.g);
      localJSONObject.put("url", this.h);
      localJSONObject.put("streamType", this.i);
      localJSONObject.put("protocol", this.j);
      localJSONObject.put("mute", this.a.getOutputMute());
      localJSONObject.put("total", this.a.getDuration());
      localJSONObject.put("current", this.a.getCurrentPostion());
      localJSONObject.put("autoPlay", this.l);
      localJSONObject.put("isFullScreen", this.m);
      localJSONObject.put("progress", this.n);
      localJSONObject.put("danmakuOn", this.o);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.VideoViewInfo
 * JD-Core Version:    0.7.0.1
 */