package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONObject;

public class WSRedDotPushMsg
  extends WSBasePushMsg
  implements Parcelable
{
  public static final Parcelable.Creator<WSRedDotPushMsg> CREATOR = new WSRedDotPushMsg.1();
  public String mFeedIds;
  public IWSPushBaseStrategy mStrategyInfo;
  
  protected WSRedDotPushMsg(Parcel paramParcel)
  {
    super(paramParcel);
    this.mFeedIds = paramParcel.readString();
    this.mStrategyInfo = ((IWSPushBaseStrategy)paramParcel.readParcelable(WSPushStrategyInfo.class.getClassLoader()));
  }
  
  private WSRedDotPushMsg(String paramString)
  {
    super(paramString);
  }
  
  public static WSRedDotPushMsg getInstance(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new WSRedDotPushMsg(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void parseJson(JSONObject paramJSONObject)
  {
    super.parseJson(paramJSONObject);
    this.mFeedIds = paramJSONObject.optString("feedids");
    this.mStrategyInfo = WSPushStrategyInfo.getInstance(paramJSONObject.optJSONObject("strategy_info"));
  }
  
  public String toString()
  {
    return "WSRedDotPushMsg{mStrategyInfo=" + this.mStrategyInfo + ", mPushId='" + this.mPushId + '\'' + ", mMsgData='" + this.mMsgData + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mFeedIds);
    paramParcel.writeParcelable(this.mStrategyInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg
 * JD-Core Version:    0.7.0.1
 */