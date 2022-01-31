package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;
import sme;

public class WSPushPreloadModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushPreloadModel> CREATOR = new sme();
  public long a;
  public boolean a;
  public boolean b;
  
  public WSPushPreloadModel() {}
  
  public WSPushPreloadModel(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label48;
      }
    }
    label48:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static WSPushPreloadModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    WSPushPreloadModel localWSPushPreloadModel = new WSPushPreloadModel();
    localWSPushPreloadModel.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("is_preload_data");
    localWSPushPreloadModel.jdField_a_of_type_Long = paramJSONObject.optLong("valid_duration");
    localWSPushPreloadModel.b = paramJSONObject.optBoolean("is_preload_out_valid_duration");
    return localWSPushPreloadModel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      if (!this.b) {
        break label46;
      }
    }
    label46:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel
 * JD-Core Version:    0.7.0.1
 */