package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import oeq;
import org.json.JSONObject;

public class VideoInfo$GameAdComData
  implements Parcelable
{
  public static final Parcelable.Creator<GameAdComData> CREATOR = new oeq();
  public String A;
  public String B;
  public int a;
  public VideoInfo.GameAdDownloadInfo a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
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
  
  public VideoInfo$GameAdComData(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.n = paramParcel.readString();
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
  }
  
  public VideoInfo$GameAdComData(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.b = paramJSONObject.optString("sAdID", "");
      this.jdField_a_of_type_Int = paramJSONObject.optInt("sDeliveryMode", 0);
      this.c = paramJSONObject.optString("sGameName", "");
      this.d = paramJSONObject.optString("sPackageName", "");
      this.e = paramJSONObject.optString("sBusiness_type", "");
      this.f = paramJSONObject.optString("sPlat_form", "");
      this.g = paramJSONObject.optString("sAppid", "");
      this.h = paramJSONObject.optString("sAppleid", "");
      this.i = paramJSONObject.optString("sSlogan", "");
      this.j = paramJSONObject.optString("sGameIcon", "");
      this.k = paramJSONObject.optString("sOperType", "");
      this.l = paramJSONObject.optString("sGameStage", "");
      this.m = paramJSONObject.optString("sGameSize", "");
      this.n = paramJSONObject.optString("sGameKind", "");
      this.o = paramJSONObject.optString("sGameSubKind", "");
      this.p = paramJSONObject.optString("sDetailUrl", "");
      this.q = paramJSONObject.optString("sActivityUrl", "");
      this.r = paramJSONObject.optString("sGameStatus", "");
      this.s = paramJSONObject.optString("sComponentType", "");
      this.t = paramJSONObject.optString("stDownloadInfo", "");
      if (TextUtils.isEmpty(this.t)) {
        this.t = new JSONObject().toString();
      }
      this.u = paramJSONObject.optString("sGiftInfo", "");
      if (TextUtils.isEmpty(this.u)) {
        this.u = new JSONObject().toString();
      }
      this.v = paramJSONObject.optString("sButtonDesc", "");
      this.w = paramJSONObject.optString("sWordTitle", "");
      this.x = paramJSONObject.optString("sWordContentWifi", "");
      this.y = paramJSONObject.optString("sWordContentNoWifi", "");
      this.z = paramJSONObject.optString("sWordHighlight", "");
      this.A = paramJSONObject.optString("sWordHighlightColor", "");
      this.B = paramJSONObject.optString("mExtendGameInfo", "");
    } while (!TextUtils.isEmpty(this.B));
    this.B = new JSONObject().toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.n);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.GameAdComData
 * JD-Core Version:    0.7.0.1
 */