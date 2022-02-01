package com.mojitox.mxflutter.framework.constants;

import com.mojitox.mxflutter.framework.utils.MxLog;
import org.json.JSONException;
import org.json.JSONObject;

public class JsConstant
{
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", "invokeJSMirrorResetData");
    }
    catch (JSONException localJSONException)
    {
      MxLog.b("JsConstant", localJSONException.getMessage());
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.constants.JsConstant
 * JD-Core Version:    0.7.0.1
 */