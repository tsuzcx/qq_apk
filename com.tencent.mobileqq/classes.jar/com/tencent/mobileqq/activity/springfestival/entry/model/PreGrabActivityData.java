package com.tencent.mobileqq.activity.springfestival.entry.model;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class PreGrabActivityData
  extends BaseActivityData
{
  public static final String TAG = "shua2021_PreGrabActivityData";
  MiniAppEntryData miniAppEntryData = new MiniAppEntryData();
  
  @NotNull
  public MiniAppEntryData getMiniEntryData()
  {
    return this.miniAppEntryData;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      super.parseJson(paramJSONObject);
      paramJSONObject = paramJSONObject.optJSONObject("PreGrabActivity");
    } while (paramJSONObject == null);
    paramJSONObject = paramJSONObject.optJSONObject("MiniAppEntry");
    this.miniAppEntryData.parseJson(paramJSONObject);
  }
  
  public String toString()
  {
    return "PreGrabActivityData{superData=" + super.toString() + ", miniAppEntryData=" + this.miniAppEntryData + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.PreGrabActivityData
 * JD-Core Version:    0.7.0.1
 */