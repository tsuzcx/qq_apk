package com.tencent.mobileqq.activity.aio.intimate.info;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveTreeInfo;

public class LoveTreeInfo
{
  public String a;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public int f;
  
  public static LoveTreeInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      LoveTreeInfo localLoveTreeInfo = new LoveTreeInfo();
      localLoveTreeInfo.a = paramString.optString("treeIconUrl", "");
      localLoveTreeInfo.b = paramString.optBoolean("canWatering", false);
      localLoveTreeInfo.c = paramString.optString("wateringAnimUrl", "");
      localLoveTreeInfo.d = paramString.optString("miniAppUrl", "");
      localLoveTreeInfo.e = paramString.optString("h5Url", "");
      localLoveTreeInfo.f = paramString.optInt("level", 0);
      return localLoveTreeInfo;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static LoveTreeInfo a(oidb_0xcf4.LoveTreeInfo paramLoveTreeInfo)
  {
    if (paramLoveTreeInfo == null) {
      return null;
    }
    LoveTreeInfo localLoveTreeInfo = new LoveTreeInfo();
    if (paramLoveTreeInfo.str_use_tree_icon.has()) {
      localLoveTreeInfo.a = paramLoveTreeInfo.str_use_tree_icon.get();
    }
    if (paramLoveTreeInfo.uint32_lack_water_flag.has())
    {
      int i = paramLoveTreeInfo.uint32_lack_water_flag.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localLoveTreeInfo.b = bool;
    }
    if (paramLoveTreeInfo.str_drop_icon.has()) {
      localLoveTreeInfo.c = paramLoveTreeInfo.str_drop_icon.get();
    }
    if (paramLoveTreeInfo.str_jump_url.has()) {
      localLoveTreeInfo.d = paramLoveTreeInfo.str_jump_url.get();
    }
    if (paramLoveTreeInfo.str_jump_h5_url.has()) {
      localLoveTreeInfo.e = paramLoveTreeInfo.str_jump_h5_url.get();
    }
    if (paramLoveTreeInfo.uint32_level.has()) {
      localLoveTreeInfo.f = paramLoveTreeInfo.uint32_level.get();
    }
    return localLoveTreeInfo;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.a)) {
        localJSONObject.put("treeIconUrl", this.a);
      }
      localJSONObject.put("canWatering", this.b);
      if (!TextUtils.isEmpty(this.c)) {
        localJSONObject.put("wateringAnimUrl", this.c);
      }
      if (!TextUtils.isEmpty(this.d)) {
        localJSONObject.put("miniAppUrl", this.d);
      }
      if (!TextUtils.isEmpty(this.e)) {
        localJSONObject.put("h5Url", this.e);
      }
      localJSONObject.put("level", this.f);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoveTreeInfo{treeIconUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", canWatering=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", wateringAnimUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", miniAppUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", h5Url='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.LoveTreeInfo
 * JD-Core Version:    0.7.0.1
 */