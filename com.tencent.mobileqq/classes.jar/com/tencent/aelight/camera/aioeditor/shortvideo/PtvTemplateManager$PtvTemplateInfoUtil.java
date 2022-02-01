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
        localPtvTemplateInfo.jdField_a_of_type_JavaLangString = paramJSONObject.getString("id");
      }
      if (paramJSONObject.has("iconurl")) {
        localPtvTemplateInfo.jdField_b_of_type_JavaLangString = paramJSONObject.getString("iconurl");
      }
      if (paramJSONObject.has("resurl")) {
        localPtvTemplateInfo.jdField_c_of_type_JavaLangString = paramJSONObject.getString("resurl");
      }
      if (paramJSONObject.has("md5")) {
        localPtvTemplateInfo.jdField_d_of_type_JavaLangString = paramJSONObject.getString("md5");
      }
      if (paramJSONObject.has("name")) {
        localPtvTemplateInfo.jdField_e_of_type_JavaLangString = paramJSONObject.getString("name");
      }
      if (paramJSONObject.has("predownload")) {
        localPtvTemplateInfo.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("predownload");
      }
      if (paramJSONObject.has("platform")) {
        localPtvTemplateInfo.jdField_a_of_type_Int = paramJSONObject.getInt("platform");
      }
      if (paramJSONObject.has("businessID")) {
        localPtvTemplateInfo.jdField_b_of_type_Int = paramJSONObject.getInt("businessID");
      }
      if (paramJSONObject.has("categoryId")) {
        localPtvTemplateInfo.jdField_c_of_type_Int = paramJSONObject.getInt("categoryId");
      }
      if (paramJSONObject.has("templateStyle")) {
        localPtvTemplateInfo.jdField_d_of_type_Int = paramJSONObject.getInt("templateStyle");
      }
      if (paramJSONObject.has("needRedDot")) {
        localPtvTemplateInfo.jdField_d_of_type_Boolean = paramJSONObject.getBoolean("needRedDot");
      }
      if (paramJSONObject.has("kind")) {
        localPtvTemplateInfo.jdField_e_of_type_Int = paramJSONObject.getInt("kind");
      }
      if (paramJSONObject.has("displayType")) {
        localPtvTemplateInfo.jdField_f_of_type_Int = paramJSONObject.getInt("displayType");
      }
      if (paramJSONObject.has("qq_camera_top_title")) {
        localPtvTemplateInfo.jdField_f_of_type_JavaLangString = paramJSONObject.getString("qq_camera_top_title");
      }
      if (paramJSONObject.has("qq_camera_scheme")) {
        localPtvTemplateInfo.jdField_g_of_type_JavaLangString = paramJSONObject.getString("qq_camera_scheme");
      }
      if (paramJSONObject.has("activityType")) {
        localPtvTemplateInfo.jdField_g_of_type_Int = paramJSONObject.getInt("activityType");
      }
      if (paramJSONObject.has("category")) {
        localPtvTemplateInfo.jdField_h_of_type_Int = paramJSONObject.getInt("category");
      }
      if (paramJSONObject.has("gestureType")) {
        localPtvTemplateInfo.jdField_i_of_type_JavaLangString = paramJSONObject.getString("gestureType");
      }
      if (paramJSONObject.has("gestureWording")) {
        localPtvTemplateInfo.j = paramJSONObject.getString("gestureWording");
      }
      if (paramJSONObject.has("advertisement")) {
        localPtvTemplateInfo.jdField_e_of_type_Boolean = paramJSONObject.getBoolean("advertisement");
      }
      if (paramJSONObject.has("androidopenurlheader")) {
        localPtvTemplateInfo.k = paramJSONObject.getString("androidopenurlheader");
      }
      if (paramJSONObject.has("openurl")) {
        localPtvTemplateInfo.l = paramJSONObject.getString("openurl");
      }
      if (paramJSONObject.has("storeurl")) {
        localPtvTemplateInfo.m = paramJSONObject.getString("storeurl");
      }
      if (paramJSONObject.has("popup")) {
        localPtvTemplateInfo.jdField_f_of_type_Boolean = paramJSONObject.getBoolean("popup");
      }
      if (paramJSONObject.has("badgeurl")) {
        localPtvTemplateInfo.n = paramJSONObject.getString("badgeurl");
      }
      if (paramJSONObject.has("popupimgurl")) {
        localPtvTemplateInfo.o = paramJSONObject.getString("popupimgurl");
      }
      if (paramJSONObject.has("popupcontent")) {
        localPtvTemplateInfo.p = paramJSONObject.getString("popupcontent");
      }
      if (paramJSONObject.has("popupbtn")) {
        localPtvTemplateInfo.q = paramJSONObject.getString("popupbtn");
      }
      if (paramJSONObject.has("popupcontent2")) {
        localPtvTemplateInfo.r = paramJSONObject.getString("popupcontent2");
      }
      if (paramJSONObject.has("popupbtn2")) {
        localPtvTemplateInfo.s = paramJSONObject.getString("popupbtn2");
      }
      if (paramJSONObject.has("buttonbgcolor")) {
        localPtvTemplateInfo.t = paramJSONObject.getString("buttonbgcolor");
      }
      if (paramJSONObject.has("multivideosupport")) {
        localPtvTemplateInfo.jdField_g_of_type_Boolean = paramJSONObject.getBoolean("multivideosupport");
      }
      if (paramJSONObject.has("sizeFree")) {
        localPtvTemplateInfo.jdField_a_of_type_Double = paramJSONObject.getDouble("sizeFree");
      }
      if (paramJSONObject.has("jump_app")) {
        localPtvTemplateInfo.jdField_h_of_type_JavaLangString = paramJSONObject.getString("jump_app");
      }
      if (paramJSONObject.has("funcType"))
      {
        localPtvTemplateInfo.jdField_i_of_type_Int = paramJSONObject.getInt("funcType");
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
        Long.parseLong(localPtvTemplateInfo.jdField_a_of_type_JavaLangString);
        k = localPtvTemplateInfo.jdField_e_of_type_Int;
        if (k != 1)
        {
          if (k != 12) {
            localArrayList.add(localPtvTemplateInfo);
          } else {
            localArrayList.add(localPtvTemplateInfo);
          }
        }
        else if (!PtvTemplateManager.c()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.PtvTemplateInfoUtil
 * JD-Core Version:    0.7.0.1
 */