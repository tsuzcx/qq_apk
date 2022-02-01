package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class LockedCategory
  implements Parcelable
{
  public static final Parcelable.Creator<LockedCategory> CREATOR = new LockedCategory.1();
  public int a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  private String d;
  
  public LockedCategory(Parcel paramParcel)
  {
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    this.d = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    if (paramParcel.readByte() == 0) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public LockedCategory(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    this.d = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("comboId");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("introduceUrl");
    this.c = paramJSONObject.optString("backgroundUrl");
    this.d = paramJSONObject.optString("expire_date");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("unlock_type", 1);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    try
    {
      boolean bool = new Date(NetConnInfoCenter.getServerTimeMillis()).after(localSimpleDateFormat.parse(this.d.toString()));
      return bool;
    }
    catch (ParseException localParseException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LockedCategory", 2, localParseException, new Object[0]);
      }
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LockedCategory");
    localStringBuilder.append(":");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.LockedCategory
 * JD-Core Version:    0.7.0.1
 */