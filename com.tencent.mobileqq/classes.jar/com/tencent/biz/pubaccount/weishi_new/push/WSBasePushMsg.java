package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WSBasePushMsg
{
  public String mMsgData;
  public String mPushId;
  
  protected WSBasePushMsg(Parcel paramParcel)
  {
    this.mPushId = paramParcel.readString();
    this.mMsgData = paramParcel.readString();
  }
  
  protected WSBasePushMsg(String paramString)
  {
    this.mMsgData = paramString;
    try
    {
      parseJson(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WSPushMsgActionData parse failed : ");
      localStringBuilder.append(paramString.getLocalizedMessage());
      WSLog.b(localStringBuilder.toString());
    }
  }
  
  protected void parseJson(JSONObject paramJSONObject)
  {
    this.mPushId = paramJSONObject.optString("pushid");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPushId);
    paramParcel.writeString(this.mMsgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSBasePushMsg
 * JD-Core Version:    0.7.0.1
 */