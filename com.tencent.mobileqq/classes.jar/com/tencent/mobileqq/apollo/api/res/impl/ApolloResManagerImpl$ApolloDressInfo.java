package com.tencent.mobileqq.apollo.api.res.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.apollo.api.model.ApolloDress.Dress;
import java.util.HashMap;
import org.json.JSONObject;

public class ApolloResManagerImpl$ApolloDressInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ApolloDressInfo> CREATOR = new ApolloResManagerImpl.ApolloDressInfo.1();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, ApolloDress.Dress> jdField_a_of_type_JavaUtilHashMap;
  private String b;
  private String c;
  
  public ApolloResManagerImpl$ApolloDressInfo() {}
  
  protected ApolloResManagerImpl$ApolloDressInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    paramParcel.readMap(this.jdField_a_of_type_JavaUtilHashMap, ApolloDress.Dress.class.getClassLoader());
    this.c = paramParcel.readString();
  }
  
  public String a()
  {
    return this.c;
  }
  
  public HashMap<Integer, ApolloDress.Dress> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(HashMap<Integer, ApolloDress.Dress> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(paramHashMap);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.c = paramJSONObject.toString();
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("ApolloDressInfo{uin='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", roleDir='").append(this.b).append('\'').append(", dressMap=");
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", faceJson='");
      if (this.c != null) {
        break label111;
      }
    }
    label111:
    for (Object localObject1 = localObject2;; localObject1 = Integer.valueOf(this.c.length()))
    {
      return localObject1 + '\'' + '}';
      localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size());
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilHashMap);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloDressInfo
 * JD-Core Version:    0.7.0.1
 */