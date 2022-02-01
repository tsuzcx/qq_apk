package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

final class fg
{
  public static final fg a = new fg();
  public String b;
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
  public final Bundle m = new Bundle();
  
  fg() {}
  
  private fg(fg paramfg)
  {
    if (paramfg.m.size() > 0)
    {
      this.m.putAll(paramfg.m);
      return;
    }
    this.b = paramfg.b;
    this.c = paramfg.c;
    this.d = paramfg.d;
    this.e = paramfg.e;
    this.f = paramfg.f;
    this.g = paramfg.g;
    this.h = paramfg.h;
    this.i = paramfg.i;
    this.j = paramfg.j;
    this.k = paramfg.k;
    this.l = paramfg.l;
  }
  
  public fg(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.has("admin_level_1");
      if (bool)
      {
        str1 = paramJSONObject.getString("nation");
        String str2 = paramJSONObject.getString("admin_level_1");
        String str3 = paramJSONObject.getString("admin_level_2");
        String str4 = paramJSONObject.getString("admin_level_3");
        String str5 = paramJSONObject.getString("locality");
        String str6 = paramJSONObject.getString("sublocality");
        paramJSONObject = paramJSONObject.getString("route");
        this.m.putString("nation", str1);
        this.m.putString("admin_level_1", str2);
        this.m.putString("admin_level_2", str3);
        this.m.putString("admin_level_3", str4);
        this.m.putString("locality", str5);
        this.m.putString("sublocality", str6);
        this.m.putString("route", paramJSONObject);
        return;
      }
      this.c = paramJSONObject.getString("name");
      this.d = paramJSONObject.getString("code");
      this.b = paramJSONObject.getString("nation");
      this.e = paramJSONObject.getString("province");
      this.f = paramJSONObject.getString("city");
      this.g = paramJSONObject.getString("district");
      this.h = paramJSONObject.getString("town");
      this.i = paramJSONObject.getString("village");
      this.j = paramJSONObject.getString("street");
      this.k = paramJSONObject.getString("street_no");
      String str1 = paramJSONObject.optString("mergedname");
      paramJSONObject = paramJSONObject.optString("mergedaddr");
      if (!TextUtils.isEmpty(str1)) {
        this.c = str1;
      }
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.l = paramJSONObject;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw paramJSONObject;
    }
  }
  
  public static fg a(fg paramfg)
  {
    if (paramfg == null) {
      return null;
    }
    return new fg(paramfg);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubnationData{");
    localStringBuilder.append("name=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append("address=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",");
    localStringBuilder.append("code=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append("nation=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append("province=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append("city=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append("district=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append("town=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",");
    localStringBuilder.append("village=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",");
    localStringBuilder.append("street=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",");
    localStringBuilder.append("street_no=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",");
    localStringBuilder.append("bundle");
    localStringBuilder.append(this.m);
    localStringBuilder.append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fg
 * JD-Core Version:    0.7.0.1
 */