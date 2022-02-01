package com.tencent.mobileqq.activity.springfestival.entry.model;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class MiniGameActivityData
  extends BaseActivityData
{
  public static final String TAG = "shua2021_MiniGameActivityData";
  public MiniAppEntryData miniAppEntryData = new MiniAppEntryData();
  
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
    paramJSONObject = paramJSONObject.optJSONObject("MiniGameActivity");
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("MiniAppEntry");
      this.miniAppEntryData.parseJson(paramJSONObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniGameActivityData{superData=");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", miniAppEntryData=");
    localStringBuilder.append(this.miniAppEntryData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.MiniGameActivityData
 * JD-Core Version:    0.7.0.1
 */