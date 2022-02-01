package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;
import uuj;

public class WSPushGloryKingModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushGloryKingModel> CREATOR = new uuj();
  public int a;
  public String a;
  
  protected WSPushGloryKingModel() {}
  
  public WSPushGloryKingModel(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  protected static WSPushGloryKingModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushGloryKingModel localWSPushGloryKingModel = new WSPushGloryKingModel();
      localWSPushGloryKingModel.jdField_a_of_type_Int = paramJSONObject.optInt("material_type");
      localWSPushGloryKingModel.jdField_a_of_type_JavaLangString = paramJSONObject.optString("attach");
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
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushGloryKingModel
 * JD-Core Version:    0.7.0.1
 */