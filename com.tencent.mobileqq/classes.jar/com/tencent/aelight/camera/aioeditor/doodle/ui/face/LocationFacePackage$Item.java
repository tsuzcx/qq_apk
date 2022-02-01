package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.graphics.drawable.Drawable;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocationFacePackage$Item
{
  public int a;
  public Drawable a;
  public LocationFacePackage.Item.ItemParams a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public LocationFacePackage$Item()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams = new LocationFacePackage.Item.ItemParams();
  }
  
  public LocationFacePackage$Item(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("thumb_url");
    this.b = paramJSONObject.getString("poster_name");
    this.d = paramJSONObject.getString("poster_url");
    this.c = paramJSONObject.getString("desc");
    this.e = paramJSONObject.getString("poster_json_layout_desc");
    this.f = paramJSONObject.getString("poi_poster_id");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams = new LocationFacePackage.Item.ItemParams();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.e);
      int i = localJSONObject.getInt("align");
      Object localObject = localJSONObject.getJSONArray("picture_margin");
      int j = ((JSONArray)localObject).getInt(0);
      int k = ((JSONArray)localObject).getInt(1);
      int m = ((JSONArray)localObject).getInt(2);
      int n = ((JSONArray)localObject).getInt(3);
      localObject = localJSONObject.getString("text_color");
      int i1 = localJSONObject.getInt("text_size");
      int i2 = localJSONObject.getInt("picture_width");
      int i3 = localJSONObject.getInt("picture_height");
      int i4 = localJSONObject.getInt("standard_width");
      int i5 = localJSONObject.getInt("standard_height");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_ArrayOfInt = new int[] { j, k, m, n };
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.b = i1;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.c = i2;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.d = i3;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.e = i4;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams.f = i5;
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
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuilder.append(", layoutJson='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceLocationFacePackage$Item$ItemParams);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item
 * JD-Core Version:    0.7.0.1
 */