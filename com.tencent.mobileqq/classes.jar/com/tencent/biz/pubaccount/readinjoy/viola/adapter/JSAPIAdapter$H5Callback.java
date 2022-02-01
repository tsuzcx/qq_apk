package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.H5DataCallback;
import com.tencent.viola.adapter.IJSApiAdapter.OnInovkeCallback;
import org.json.JSONObject;

class JSAPIAdapter$H5Callback
  implements ReadInJoyWebDataManager.H5DataCallback
{
  IJSApiAdapter.OnInovkeCallback a;
  
  public JSAPIAdapter$H5Callback(IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback)
  {
    this.a = paramOnInovkeCallback;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.a != null) {
      this.a.callback(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.JSAPIAdapter.H5Callback
 * JD-Core Version:    0.7.0.1
 */