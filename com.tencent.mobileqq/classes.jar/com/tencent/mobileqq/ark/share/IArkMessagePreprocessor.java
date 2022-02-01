package com.tencent.mobileqq.ark.share;

import org.json.JSONObject;

public abstract interface IArkMessagePreprocessor
{
  public abstract boolean needProcess(JSONObject paramJSONObject);
  
  public abstract void process(JSONObject paramJSONObject, IArkMessagePreprocessorCallback paramIArkMessagePreprocessorCallback, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.IArkMessagePreprocessor
 * JD-Core Version:    0.7.0.1
 */