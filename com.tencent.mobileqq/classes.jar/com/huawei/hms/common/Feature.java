package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Objects.ToStringHelper;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
public class Feature
  extends AbstractSafeParcelable
{
  public static final int ARGS_NAME = 1;
  public static final int ARGS_SVC_VER = 2;
  public static final int ARGS_VER = 3;
  public static final Parcelable.Creator<Feature> CREATOR = new FeatureCreator();
  private static final int SVC_VER = -1;
  private final long apiVersion;
  private final String name;
  @Deprecated
  private final int serviceVersion;
  
  public Feature(String paramString, int paramInt, long paramLong)
  {
    this.name = paramString;
    this.serviceVersion = paramInt;
    this.apiVersion = paramLong;
  }
  
  public Feature(String paramString, long paramLong)
  {
    this(paramString, -1, paramLong);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Feature)) {
      return false;
    }
    paramObject = (Feature)paramObject;
    if (!this.name.equals(paramObject.getName())) {
      return false;
    }
    return getVersion() == paramObject.getVersion();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getVersion()
  {
    long l2 = this.apiVersion;
    long l1 = l2;
    if (-1L == l2) {
      l1 = this.serviceVersion;
    }
    return l1;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { getName(), Long.valueOf(getVersion()) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.serviceVersion);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.Feature
 * JD-Core Version:    0.7.0.1
 */