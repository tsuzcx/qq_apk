package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONObject;
import smb;
import smf;

public class WSPushStrategyInfo
  extends smb
  implements IWSPushStrategy
{
  public static final Parcelable.Creator<WSPushStrategyInfo> CREATOR = new smf();
  public String mScheme;
  public WSPushOpModel mWSPushModel;
  public WSPushOpDialogModel mWSPushOpDialogModel;
  public WSPushPreloadModel mWSPushPreloadModel;
  
  public WSPushStrategyInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mScheme = paramParcel.readString();
    this.mWSPushOpDialogModel = ((WSPushOpDialogModel)paramParcel.readParcelable(WSPushOpDialogModel.class.getClassLoader()));
    this.mWSPushModel = ((WSPushOpModel)paramParcel.readParcelable(WSPushOpModel.class.getClassLoader()));
  }
  
  private WSPushStrategyInfo(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static WSPushStrategyInfo getInstance(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return new WSPushStrategyInfo(paramJSONObject);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAbTest()
  {
    return this.mAbTest;
  }
  
  public String getScheme()
  {
    return this.mScheme;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    super.parseJson(paramJSONObject);
    this.mScheme = paramJSONObject.optString("scheme");
    this.mWSPushOpDialogModel = WSPushOpDialogModel.parseJson(paramJSONObject.optJSONObject("op_dialog"));
    this.mWSPushModel = WSPushOpModel.a(paramJSONObject.optJSONObject("op_content"));
    this.mWSPushPreloadModel = WSPushPreloadModel.a(paramJSONObject.optJSONObject("preload"));
  }
  
  public String toString()
  {
    return "WSPushStrategyInfo{mScheme='" + this.mScheme + '\'' + ", mType=" + this.mType + ", mAbTest='" + this.mAbTest + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mScheme);
    paramParcel.writeParcelable(this.mWSPushOpDialogModel, paramInt);
    paramParcel.writeParcelable(this.mWSPushModel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo
 * JD-Core Version:    0.7.0.1
 */