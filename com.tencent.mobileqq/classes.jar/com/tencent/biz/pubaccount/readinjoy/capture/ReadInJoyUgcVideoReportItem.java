package com.tencent.biz.pubaccount.readinjoy.capture;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axtu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oem;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyUgcVideoReportItem
  implements Parcelable
{
  public static final Parcelable.Creator<ReadInJoyUgcVideoReportItem> CREATOR = new oem();
  public double a;
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public ReadInJoyUgcVideoReportItem() {}
  
  public ReadInJoyUgcVideoReportItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Double = paramParcel.readDouble();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.h = paramParcel.readString();
  }
  
  public static ArrayList<ReadInJoyUgcVideoReportItem> a(List<axtu> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        axtu localaxtu = (axtu)paramList.next();
        ReadInJoyUgcVideoReportItem localReadInJoyUgcVideoReportItem = new ReadInJoyUgcVideoReportItem();
        localReadInJoyUgcVideoReportItem.jdField_a_of_type_Double = localaxtu.jdField_a_of_type_Double;
        localReadInJoyUgcVideoReportItem.jdField_a_of_type_JavaLangString = localaxtu.h;
        localReadInJoyUgcVideoReportItem.b = localaxtu.i;
        localReadInJoyUgcVideoReportItem.c = localaxtu.j;
        localReadInJoyUgcVideoReportItem.d = localaxtu.k;
        localReadInJoyUgcVideoReportItem.e = localaxtu.l;
        localReadInJoyUgcVideoReportItem.f = localaxtu.m;
        localArrayList.add(localReadInJoyUgcVideoReportItem);
      }
    }
    return localArrayList;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("op_duration", this.jdField_a_of_type_Double);
      localJSONObject.put("msg_id", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("msg_feature", this.b);
      localJSONObject.put("content_source", this.c);
      localJSONObject.put("element_type", this.d);
      localJSONObject.put("element_tag", this.e);
      localJSONObject.put("element_id", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyUgcVideoReportItem
 * JD-Core Version:    0.7.0.1
 */