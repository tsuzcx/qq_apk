package com.tencent.biz.pubaccount.readinjoy.video.playfeeds;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONObject;

public class GameAdComData
  implements Parcelable
{
  public static final Parcelable.Creator<GameAdComData> CREATOR = new GameAdComData.1();
  public String A;
  public String B;
  public String C;
  public String D;
  public String E = "";
  public String F;
  public int G;
  public int H;
  public GameAdDownloadInfo I;
  public String J;
  public String K;
  public String L;
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  protected GameAdComData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
    this.t = paramParcel.readString();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.x = paramParcel.readString();
    this.y = paramParcel.readString();
    this.z = paramParcel.readString();
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.F = paramParcel.readString();
    this.J = paramParcel.readString();
    this.K = paramParcel.readString();
    this.L = paramParcel.readString();
  }
  
  public GameAdComData(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.a = paramString;
    this.b = paramJSONObject.optString("sAdID", "");
    this.c = paramJSONObject.optInt("sDeliveryMode", 0);
    this.d = paramJSONObject.optString("sGameName", "");
    this.e = paramJSONObject.optString("sPackageName", "");
    this.f = paramJSONObject.optString("sBusiness_type", "");
    this.g = paramJSONObject.optString("sPlat_form", "");
    this.h = paramJSONObject.optString("sAppid", "");
    this.i = paramJSONObject.optString("sAppleid", "");
    this.j = paramJSONObject.optString("sSlogan", "");
    this.k = paramJSONObject.optString("sGameIcon", "");
    this.l = paramJSONObject.optString("sOperType", "");
    this.m = paramJSONObject.optString("sGameStage", "");
    this.n = paramJSONObject.optString("sGameSize", "");
    this.o = paramJSONObject.optString("sGameKind", "");
    this.p = paramJSONObject.optString("sGameSubKind", "");
    this.q = paramJSONObject.optString("sDetailUrl", "");
    this.r = paramJSONObject.optString("sActivityUrl", "");
    this.s = paramJSONObject.optString("sGameStatus", "");
    this.t = paramJSONObject.optString("sComponentType", "");
    this.u = paramJSONObject.optString("stDownloadInfo", "");
    if (TextUtils.isEmpty(this.u)) {
      this.u = new JSONObject().toString();
    }
    this.v = paramJSONObject.optString("sGiftInfo", "");
    if (TextUtils.isEmpty(this.v)) {
      this.v = new JSONObject().toString();
    }
    this.w = paramJSONObject.optString("sButtonDesc", "");
    this.x = paramJSONObject.optString("sWordTitle", "");
    this.y = paramJSONObject.optString("sWordContentWifi", "");
    this.z = paramJSONObject.optString("sWordContentNoWifi", "");
    this.A = paramJSONObject.optString("sWordHighlight", "");
    this.B = paramJSONObject.optString("sWordHighlightColor", "");
    this.F = paramJSONObject.optString("mExtendGameInfo", "");
    if (TextUtils.isEmpty(this.F)) {
      this.F = new JSONObject().toString();
    }
    a();
  }
  
  private void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.F);
      this.J = localJSONObject.optString("liujinReportUrl");
      this.K = localJSONObject.optString("ticket");
      if (TextUtils.isEmpty(this.K)) {
        this.K = localJSONObject.optString("ad_encrypted_ticket");
      }
      this.L = localJSONObject.optString("amsNfbUrl");
      this.C = localJSONObject.optString("nfa_chainId");
      this.D = localJSONObject.optString("gads_txt");
      this.E = localJSONObject.optString("obj_type");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeString(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeString(this.F);
    paramParcel.writeString(this.J);
    paramParcel.writeString(this.K);
    paramParcel.writeString(this.L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData
 * JD-Core Version:    0.7.0.1
 */