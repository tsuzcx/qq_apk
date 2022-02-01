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
    if (paramJSONObject == null) {
      return;
    }
    super.parseJson(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONObject("PreGrabActivity");
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("MiniAppEntry");
      this.miniAppEntryData.parseJson(paramJSONObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreGrabActivityData{superData=");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", miniAppEntryData=");
    localStringBuilder.append(this.miniAppEntryData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.PreGrabActivityData
 * JD-Core Version:    0.7.0.1
 */