package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;
import smd;

public class WSPushOpModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushOpModel> CREATOR = new smd();
  public int a;
  public String a;
  
  protected WSPushOpModel() {}
  
  public WSPushOpModel(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  protected static WSPushOpModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushOpModel localWSPushOpModel = new WSPushOpModel();
      localWSPushOpModel.jdField_a_of_type_JavaLangString = paramJSONObject.optString("op_id");
      localWSPushOpModel.jdField_a_of_type_Int = paramJSONObject.optInt("op_type");
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
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushOpModel
 * JD-Core Version:    0.7.0.1
 */