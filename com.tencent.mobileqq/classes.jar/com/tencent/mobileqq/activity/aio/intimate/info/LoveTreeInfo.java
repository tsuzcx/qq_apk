package com.tencent.mobileqq.activity.aio.intimate.info;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveTreeInfo;

public class LoveTreeInfo
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public static LoveTreeInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      LoveTreeInfo localLoveTreeInfo = new LoveTreeInfo();
      localLoveTreeInfo.jdField_a_of_type_JavaLangString = paramString.optString("treeIconUrl", "");
      localLoveTreeInfo.jdField_a_of_type_Boolean = paramString.optBoolean("canWatering", false);
      localLoveTreeInfo.b = paramString.optString("wateringAnimUrl", "");
      localLoveTreeInfo.c = paramString.optString("miniAppUrl", "");
      localLoveTreeInfo.d = paramString.optString("h5Url", "");
      localLoveTreeInfo.jdField_a_of_type_Int = paramString.optInt("level", 0);
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
    boolean bool = true;
    if (paramLoveTreeInfo == null) {
      return null;
    }
    LoveTreeInfo localLoveTreeInfo = new LoveTreeInfo();
    if (paramLoveTreeInfo.str_use_tree_icon.has()) {
      localLoveTreeInfo.jdField_a_of_type_JavaLangString = paramLoveTreeInfo.str_use_tree_icon.get();
    }
    if (paramLoveTreeInfo.uint32_lack_water_flag.has()) {
      if (paramLoveTreeInfo.uint32_lack_water_flag.get() != 1) {
        break label149;
      }
    }
    for (;;)
    {
      localLoveTreeInfo.jdField_a_of_type_Boolean = bool;
      if (paramLoveTreeInfo.str_drop_icon.has()) {
        localLoveTreeInfo.b = paramLoveTreeInfo.str_drop_icon.get();
      }
      if (paramLoveTreeInfo.str_jump_url.has()) {
        localLoveTreeInfo.c = paramLoveTreeInfo.str_jump_url.get();
      }
      if (paramLoveTreeInfo.str_jump_h5_url.has()) {
        localLoveTreeInfo.d = paramLoveTreeInfo.str_jump_h5_url.get();
      }
      if (paramLoveTreeInfo.uint32_level.has()) {
        localLoveTreeInfo.jdField_a_of_type_Int = paramLoveTreeInfo.uint32_level.get();
      }
      return localLoveTreeInfo;
      label149:
      bool = false;
    }
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localJSONObject.put("treeIconUrl", this.jdField_a_of_type_JavaLangString);
      }
      localJSONObject.put("canWatering", this.jdField_a_of_type_Boolean);
      if (!TextUtils.isEmpty(this.b)) {
        localJSONObject.put("wateringAnimUrl", this.b);
      }
      if (!TextUtils.isEmpty(this.c)) {
        localJSONObject.put("miniAppUrl", this.c);
      }
      if (!TextUtils.isEmpty(this.d)) {
        localJSONObject.put("h5Url", this.d);
      }
      localJSONObject.put("level", this.jdField_a_of_type_Int);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    return "LoveTreeInfo{treeIconUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", canWatering=" + this.jdField_a_of_type_Boolean + ", wateringAnimUrl='" + this.b + '\'' + ", miniAppUrl='" + this.c + '\'' + ", h5Url='" + this.d + '\'' + ", level=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.LoveTreeInfo
 * JD-Core Version:    0.7.0.1
 */