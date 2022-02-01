package com.tencent.mobileqq.ark.share;

import org.json.JSONObject;

public abstract interface IArkMessagePreprocessor
{
  public abstract void a(JSONObject paramJSONObject, IArkMessagePreprocessorCallback paramIArkMessagePreprocessorCallback, Object paramObject);
  
  public abstract boolean a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.IArkMessagePreprocessor
 * JD-Core Version:    0.7.0.1
 */