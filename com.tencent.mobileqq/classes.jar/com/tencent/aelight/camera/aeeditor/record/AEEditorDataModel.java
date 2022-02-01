package com.tencent.aelight.camera.aeeditor.record;

import com.tencent.aelight.camera.log.AEQLog;
import org.json.JSONObject;

public class AEEditorDataModel
{
  public static final String a = AEEditorDataModel.class.toString();
  public String b;
  public String c;
  public JSONObject d;
  
  public AEEditorDataModel() {}
  
  public AEEditorDataModel(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramJSONObject;
  }
  
  public static AEEditorDataModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      AEEditorDataModel localAEEditorDataModel = new AEEditorDataModel();
      localAEEditorDataModel.b = paramJSONObject.optString("orifilepath");
      localAEEditorDataModel.c = paramJSONObject.optString("outfilepath");
      localAEEditorDataModel.d = paramJSONObject.optJSONObject("effect");
      return localAEEditorDataModel;
    }
    catch (Exception paramJSONObject)
    {
      AEQLog.a(a, paramJSONObject);
    }
    return null;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("orifilepath", this.b);
      localJSONObject.putOpt("outfilepath", this.c);
      localJSONObject.putOpt("effect", this.d);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      AEQLog.a(a, localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorDataModel
 * JD-Core Version:    0.7.0.1
 */