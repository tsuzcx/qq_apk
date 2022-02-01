package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class WSPushOpModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushOpModel> CREATOR = new WSPushOpModel.1();
  public int a;
  public String b;
  
  protected WSPushOpModel() {}
  
  protected WSPushOpModel(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
  }
  
  protected static WSPushOpModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushOpModel localWSPushOpModel = new WSPushOpModel();
      localWSPushOpModel.b = paramJSONObject.optString("op_id");
      localWSPushOpModel.a = paramJSONObject.optInt("op_type");
      return localWSPushOpModel;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushOpModel
 * JD-Core Version:    0.7.0.1
 */