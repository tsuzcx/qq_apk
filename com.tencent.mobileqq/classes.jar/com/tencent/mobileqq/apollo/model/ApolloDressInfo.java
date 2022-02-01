package com.tencent.mobileqq.apollo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import org.json.JSONObject;

public class ApolloDressInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ApolloDressInfo> CREATOR = new ApolloDressInfo.1();
  private HashMap<Integer, ApolloDress.Dress> dressMap;
  private String faceJson;
  private String roleDir;
  private String uin;
  
  public ApolloDressInfo() {}
  
  protected ApolloDressInfo(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.roleDir = paramParcel.readString();
    if (this.dressMap == null) {
      this.dressMap = new HashMap();
    }
    paramParcel.readMap(this.dressMap, ApolloDress.Dress.class.getClassLoader());
    this.faceJson = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public HashMap<Integer, ApolloDress.Dress> getDressMap()
  {
    return this.dressMap;
  }
  
  public String getFaceJson()
  {
    return this.faceJson;
  }
  
  public String getRoleDir()
  {
    return this.roleDir;
  }
  
  public void setDressMap(HashMap<Integer, ApolloDress.Dress> paramHashMap)
  {
    this.dressMap = new HashMap(paramHashMap);
  }
  
  public void setFaceJson(JSONObject paramJSONObject)
  {
    this.faceJson = paramJSONObject.toString();
  }
  
  public void setRoleDir(String paramString)
  {
    this.roleDir = paramString;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloDressInfo{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roleDir='");
    localStringBuilder.append(this.roleDir);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dressMap=");
    Object localObject1 = this.dressMap;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Integer.valueOf(((HashMap)localObject1).size());
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", faceJson='");
    localObject1 = this.faceJson;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = Integer.valueOf(((String)localObject1).length());
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeString(this.roleDir);
    paramParcel.writeMap(this.dressMap);
    paramParcel.writeString(this.faceJson);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloDressInfo
 * JD-Core Version:    0.7.0.1
 */