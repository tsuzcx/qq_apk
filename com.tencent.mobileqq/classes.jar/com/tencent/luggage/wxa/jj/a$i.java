package com.tencent.luggage.wxa.jj;

import org.json.JSONObject;

public abstract class a$i
{
  static final JSONObject p = new JSONObject();
  private static final i q = new a.i.1();
  public final String a;
  public final String b;
  public final double c = 1.0D;
  public final String d;
  public final String e;
  public final String f;
  public final boolean g;
  public final String h;
  public final boolean i;
  public final boolean j;
  public final boolean k;
  public final String l;
  public final String m;
  public boolean n = false;
  public final a.f o;
  
  private a$i()
  {
    this.a = null;
    this.b = null;
    this.d = "default";
    this.e = "#000000";
    this.f = null;
    this.g = false;
    this.h = null;
    this.i = false;
    this.j = false;
    this.k = false;
    this.l = null;
    this.m = null;
    this.o = new a.f();
  }
  
  public a$i(JSONObject paramJSONObject, i parami)
  {
    this(paramJSONObject, parami, false);
  }
  
  public a$i(JSONObject paramJSONObject, i parami, boolean paramBoolean)
  {
    Object localObject1 = parami;
    if (parami == null) {
      localObject1 = q;
    }
    parami = paramJSONObject;
    if (paramJSONObject == null) {
      parami = p;
    }
    Object localObject2 = parami.optJSONObject("window");
    paramJSONObject = (JSONObject)localObject2;
    if (localObject2 == null) {
      paramJSONObject = p;
    }
    this.a = paramJSONObject.optString("navigationBarTitleText", ((i)localObject1).a);
    this.b = paramJSONObject.optString("navigationBarTextStyle", ((i)localObject1).b);
    if (paramBoolean) {
      localObject2 = "custom";
    } else {
      localObject2 = paramJSONObject.optString("navigationStyle", ((i)localObject1).d);
    }
    this.d = ((String)localObject2);
    this.e = paramJSONObject.optString("navigationBarBackgroundColor", ((i)localObject1).e);
    this.h = paramJSONObject.optString("backgroundColor", ((i)localObject1).h);
    this.j = paramJSONObject.optBoolean("enablePullDownRefresh", ((i)localObject1).j);
    this.l = paramJSONObject.optString("backgroundTextStyle", ((i)localObject1).l);
    this.i = paramJSONObject.optBoolean("enableFullScreen", ((i)localObject1).i);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("navigationBarRightButton");
    localObject2 = localJSONObject;
    if (localJSONObject == null) {
      localObject2 = p;
    }
    this.k = paramJSONObject.optBoolean("disableSwipeBack", ((i)localObject1).k);
    this.g = ((JSONObject)localObject2).optBoolean("hide", ((i)localObject1).g);
    this.f = ((JSONObject)localObject2).optString("customButtonIconData", ((i)localObject1).f);
    this.m = paramJSONObject.optString("pageOrientation", ((i)localObject1).m);
    localObject2 = paramJSONObject.optJSONObject("singlePage");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = parami.optJSONObject("singlePage");
    }
    this.o = a((JSONObject)localObject1);
    this.n = paramJSONObject.optBoolean("resizable", false);
  }
  
  private static a.f a(JSONObject paramJSONObject)
  {
    a.f localf = new a.f();
    if (paramJSONObject == null) {
      return localf;
    }
    localf.a = paramJSONObject.optString("navigationBarFit", null);
    localf.b = paramJSONObject.optString("navigationBarBackgroundColor", "");
    localf.c = paramJSONObject.optDouble("navigationBarBackgroundAlpha", -1.0D);
    localf.d = paramJSONObject.optString("navigationBarTextStyle", "");
    localf.e = paramJSONObject.optString("navigationBarTitleText", "");
    return localf;
  }
  
  public boolean a()
  {
    return "custom".equalsIgnoreCase(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.a.i
 * JD-Core Version:    0.7.0.1
 */