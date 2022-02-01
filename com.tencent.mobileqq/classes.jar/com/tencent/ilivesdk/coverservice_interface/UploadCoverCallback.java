package com.tencent.ilivesdk.coverservice_interface;

import org.json.JSONObject;

public abstract interface UploadCoverCallback
{
  public abstract void onFailed();
  
  public abstract void onSuccess(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.coverservice_interface.UploadCoverCallback
 * JD-Core Version:    0.7.0.1
 */