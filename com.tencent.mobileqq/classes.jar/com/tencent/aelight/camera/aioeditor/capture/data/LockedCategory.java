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
  public boolean a;
  public String b;
  public String c;
  public String d;
  public int e;
  public boolean f;
  private String g;
  
  public LockedCategory(Parcel paramParcel)
  {
    boolean bool = true;
    this.a = true;
    this.b = null;
    this.c = null;
    this.d = null;
    this.g = null;
    this.f = false;
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.g = paramParcel.readString();
    if (paramParcel.readByte() == 0) {
      bool = false;
    }
    this.a = bool;
  }
  
  public LockedCategory(JSONObject paramJSONObject)
  {
    this.a = true;
    this.b = null;
    this.c = null;
    this.d = null;
    this.g = null;
    this.f = false;
    this.b = paramJSONObject.optString("comboId");
    this.c = paramJSONObject.optString("introduceUrl");
    this.d = paramJSONObject.optString("backgroundUrl");
    this.g = paramJSONObject.optString("expire_date");
    this.e = paramJSONObject.optInt("unlock_type", 1);
    this.a = true;
  }
  
  public boolean a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    try
    {
      boolean bool = new Date(NetConnInfoCenter.getServerTimeMillis()).after(localSimpleDateFormat.parse(this.g.toString()));
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
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.g);
    paramParcel.writeByte((byte)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.LockedCategory
 * JD-Core Version:    0.7.0.1
 */