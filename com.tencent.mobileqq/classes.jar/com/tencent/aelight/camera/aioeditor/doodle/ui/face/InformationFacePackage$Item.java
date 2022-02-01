package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import org.json.JSONObject;

public class InformationFacePackage$Item
{
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public int f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public int n;
  public int o;
  public boolean p;
  public String q = "";
  public int r = -1;
  public int s = -1;
  public String t;
  private InformationFacePackage.InformationPasterChangeListener u;
  
  public InformationFacePackage$Item() {}
  
  public InformationFacePackage$Item(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("poi_poster_id");
    this.b = paramJSONObject.getString("poster_name");
    this.c = paramJSONObject.getInt("poster_type");
    this.d = paramJSONObject.getString("thumb_url");
    this.f = paramJSONObject.optInt("predownload", 0);
    this.e = paramJSONObject.getString("static_url");
    paramJSONObject = paramJSONObject.getJSONObject("resource");
    this.g = paramJSONObject.optString("resurl", "");
    this.h = paramJSONObject.optString("md5", "");
    this.i = paramJSONObject.optString("name");
    this.j = paramJSONObject.optString("id", "");
    this.p = InformationFaceConstant.a(this.c);
  }
  
  public InformationFacePackage.InformationPasterChangeListener a()
  {
    return this.u;
  }
  
  public void a(InformationFacePackage.InformationPasterChangeListener paramInformationPasterChangeListener)
  {
    this.u = paramInformationPasterChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item
 * JD-Core Version:    0.7.0.1
 */