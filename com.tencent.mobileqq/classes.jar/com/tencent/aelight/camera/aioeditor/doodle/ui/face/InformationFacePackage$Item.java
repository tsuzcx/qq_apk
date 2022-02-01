package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import org.json.JSONObject;

public class InformationFacePackage$Item
{
  public int a;
  private InformationFacePackage.InformationPasterChangeListener a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l = "";
  public String m;
  
  public InformationFacePackage$Item()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
  }
  
  public InformationFacePackage$Item(JSONObject paramJSONObject)
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("poi_poster_id");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("poster_name");
    this.jdField_a_of_type_Int = paramJSONObject.getInt("poster_type");
    this.c = paramJSONObject.getString("thumb_url");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("predownload", 0);
    this.d = paramJSONObject.getString("static_url");
    paramJSONObject = paramJSONObject.getJSONObject("resource");
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("resurl", "");
    this.jdField_f_of_type_JavaLangString = paramJSONObject.optString("md5", "");
    this.g = paramJSONObject.optString("name");
    this.h = paramJSONObject.optString("id", "");
    this.jdField_a_of_type_Boolean = InformationFaceConstant.a(this.jdField_a_of_type_Int);
  }
  
  public InformationFacePackage.InformationPasterChangeListener a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$InformationPasterChangeListener;
  }
  
  public void a(InformationFacePackage.InformationPasterChangeListener paramInformationPasterChangeListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$InformationPasterChangeListener = paramInformationPasterChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item
 * JD-Core Version:    0.7.0.1
 */