package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class WSPushGloryKingModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushGloryKingModel> CREATOR = new WSPushGloryKingModel.1();
  public int a;
  public String b;
  
  protected WSPushGloryKingModel() {}
  
  protected WSPushGloryKingModel(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
  }
  
  protected static WSPushGloryKingModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushGloryKingModel localWSPushGloryKingModel = new WSPushGloryKingModel();
      localWSPushGloryKingModel.a = paramJSONObject.optInt("material_type");
      localWSPushGloryKingModel.b = paramJSONObject.optString("attach");
      return localWSPushGloryKingModel;
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushGloryKingModel
 * JD-Core Version:    0.7.0.1
 */