package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PtvTemplateManager$PtvTemplateInfoUtil
{
  private static PtvTemplateInfo a(JSONObject paramJSONObject)
  {
    PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateInfo();
    try
    {
      if (paramJSONObject.has("id")) {
        localPtvTemplateInfo.a = paramJSONObject.getString("id");
      }
      if (paramJSONObject.has("iconurl")) {
        localPtvTemplateInfo.b = paramJSONObject.getString("iconurl");
      }
      if (paramJSONObject.has("resurl")) {
        localPtvTemplateInfo.c = paramJSONObject.getString("resurl");
      }
      if (paramJSONObject.has("md5")) {
        localPtvTemplateInfo.d = paramJSONObject.getString("md5");
      }
      if (paramJSONObject.has("name")) {
        localPtvTemplateInfo.e = paramJSONObject.getString("name");
      }
      if (paramJSONObject.has("predownload")) {
        localPtvTemplateInfo.f = paramJSONObject.getBoolean("predownload");
      }
      if (paramJSONObject.has("platform")) {
        localPtvTemplateInfo.i = paramJSONObject.getInt("platform");
      }
      if (paramJSONObject.has("businessID")) {
        localPtvTemplateInfo.j = paramJSONObject.getInt("businessID");
      }
      if (paramJSONObject.has("categoryId")) {
        localPtvTemplateInfo.l = paramJSONObject.getInt("categoryId");
      }
      if (paramJSONObject.has("templateStyle")) {
        localPtvTemplateInfo.m = paramJSONObject.getInt("templateStyle");
      }
      if (paramJSONObject.has("needRedDot")) {
        localPtvTemplateInfo.n = paramJSONObject.getBoolean("needRedDot");
      }
      if (paramJSONObject.has("kind")) {
        localPtvTemplateInfo.o = paramJSONObject.getInt("kind");
      }
      if (paramJSONObject.has("displayType")) {
        localPtvTemplateInfo.p = paramJSONObject.getInt("displayType");
      }
      if (paramJSONObject.has("qq_camera_top_title")) {
        localPtvTemplateInfo.q = paramJSONObject.getString("qq_camera_top_title");
      }
      if (paramJSONObject.has("qq_camera_scheme")) {
        localPtvTemplateInfo.r = paramJSONObject.getString("qq_camera_scheme");
      }
      if (paramJSONObject.has("activityType")) {
        localPtvTemplateInfo.t = paramJSONObject.getInt("activityType");
      }
      if (paramJSONObject.has("category")) {
        localPtvTemplateInfo.u = paramJSONObject.getInt("category");
      }
      if (paramJSONObject.has("gestureType")) {
        localPtvTemplateInfo.v = paramJSONObject.getString("gestureType");
      }
      if (paramJSONObject.has("gestureWording")) {
        localPtvTemplateInfo.w = paramJSONObject.getString("gestureWording");
      }
      if (paramJSONObject.has("advertisement")) {
        localPtvTemplateInfo.z = paramJSONObject.getBoolean("advertisement");
      }
      if (paramJSONObject.has("androidopenurlheader")) {
        localPtvTemplateInfo.A = paramJSONObject.getString("androidopenurlheader");
      }
      if (paramJSONObject.has("openurl")) {
        localPtvTemplateInfo.B = paramJSONObject.getString("openurl");
      }
      if (paramJSONObject.has("storeurl")) {
        localPtvTemplateInfo.C = paramJSONObject.getString("storeurl");
      }
      if (paramJSONObject.has("popup")) {
        localPtvTemplateInfo.D = paramJSONObject.getBoolean("popup");
      }
      if (paramJSONObject.has("badgeurl")) {
        localPtvTemplateInfo.E = paramJSONObject.getString("badgeurl");
      }
      if (paramJSONObject.has("popupimgurl")) {
        localPtvTemplateInfo.F = paramJSONObject.getString("popupimgurl");
      }
      if (paramJSONObject.has("popupcontent")) {
        localPtvTemplateInfo.G = paramJSONObject.getString("popupcontent");
      }
      if (paramJSONObject.has("popupbtn")) {
        localPtvTemplateInfo.H = paramJSONObject.getString("popupbtn");
      }
      if (paramJSONObject.has("popupcontent2")) {
        localPtvTemplateInfo.I = paramJSONObject.getString("popupcontent2");
      }
      if (paramJSONObject.has("popupbtn2")) {
        localPtvTemplateInfo.J = paramJSONObject.getString("popupbtn2");
      }
      if (paramJSONObject.has("buttonbgcolor")) {
        localPtvTemplateInfo.K = paramJSONObject.getString("buttonbgcolor");
      }
      if (paramJSONObject.has("multivideosupport")) {
        localPtvTemplateInfo.L = paramJSONObject.getBoolean("multivideosupport");
      }
      if (paramJSONObject.has("sizeFree")) {
        localPtvTemplateInfo.V = paramJSONObject.getDouble("sizeFree");
      }
      if (paramJSONObject.has("jump_app")) {
        localPtvTemplateInfo.s = paramJSONObject.getString("jump_app");
      }
      if (paramJSONObject.has("funcType"))
      {
        localPtvTemplateInfo.x = paramJSONObject.getInt("funcType");
        return localPtvTemplateInfo;
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseContent error=");
        localStringBuilder.append(paramJSONObject.getMessage());
        QLog.e("PtvTemplateManager", 1, localStringBuilder.toString());
      }
    }
    return localPtvTemplateInfo;
  }
  
  public static List<PtvTemplateInfo> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        int j = paramJSONArray.length();
        if (j <= 0) {
          return null;
        }
        localArrayList = new ArrayList(j);
        i = 0;
        if (i < j)
        {
          localPtvTemplateInfo = a(paramJSONArray.getJSONObject(i));
          if (localPtvTemplateInfo == null) {}
        }
      }
      catch (JSONException paramJSONArray)
      {
        ArrayList localArrayList;
        int i;
        PtvTemplateInfo localPtvTemplateInfo;
        int k;
        if (QLog.isDevelopLevel()) {
          paramJSONArray.printStackTrace();
        }
        return null;
      }
      try
      {
        Long.parseLong(localPtvTemplateInfo.a);
        k = localPtvTemplateInfo.o;
        if (k != 1)
        {
          if (k != 12) {
            localArrayList.add(localPtvTemplateInfo);
          } else {
            localArrayList.add(localPtvTemplateInfo);
          }
        }
        else if (!PtvTemplateManager.h()) {
          localArrayList.add(localPtvTemplateInfo);
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PtvTemplateManager", 1, "templateId must be a numeric string!");
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.PtvTemplateInfoUtil
 * JD-Core Version:    0.7.0.1
 */