package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.graphics.drawable.Drawable;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocationFacePackage$Item
{
  public String a;
  public String b;
  public String c;
  public String d;
  public Drawable e;
  public String f;
  public LocationFacePackage.Item.ItemParams g;
  public String h;
  public String i;
  public int j;
  
  public LocationFacePackage$Item()
  {
    this.g = new LocationFacePackage.Item.ItemParams();
  }
  
  public LocationFacePackage$Item(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.getString("thumb_url");
    this.b = paramJSONObject.getString("poster_name");
    this.d = paramJSONObject.getString("poster_url");
    this.c = paramJSONObject.getString("desc");
    this.f = paramJSONObject.getString("poster_json_layout_desc");
    this.h = paramJSONObject.getString("poi_poster_id");
  }
  
  public boolean a()
  {
    if (this.g == null) {
      this.g = new LocationFacePackage.Item.ItemParams();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.f);
      int k = localJSONObject.getInt("align");
      Object localObject = localJSONObject.getJSONArray("picture_margin");
      int m = ((JSONArray)localObject).getInt(0);
      int n = ((JSONArray)localObject).getInt(1);
      int i1 = ((JSONArray)localObject).getInt(2);
      int i2 = ((JSONArray)localObject).getInt(3);
      localObject = localJSONObject.getString("text_color");
      int i3 = localJSONObject.getInt("text_size");
      int i4 = localJSONObject.getInt("picture_width");
      int i5 = localJSONObject.getInt("picture_height");
      int i6 = localJSONObject.getInt("standard_width");
      int i7 = localJSONObject.getInt("standard_height");
      this.g.a = k;
      this.g.b = new int[] { m, n, i1, i2 };
      this.g.c = ((String)localObject);
      this.g.d = i3;
      this.g.e = i4;
      this.g.f = i5;
      this.g.g = i6;
      this.g.h = i7;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Item{thumbUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageDrawable=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", layoutJson='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item
 * JD-Core Version:    0.7.0.1
 */