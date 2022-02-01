package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
  implements Parcelable, Comparator<DrmInitData.SchemeData>
{
  public static final Parcelable.Creator<DrmInitData> CREATOR = new DrmInitData.1();
  private int hashCode;
  public final int schemeDataCount;
  private final DrmInitData.SchemeData[] schemeDatas;
  @Nullable
  public final String schemeType;
  
  DrmInitData(Parcel paramParcel)
  {
    this.schemeType = paramParcel.readString();
    this.schemeDatas = ((DrmInitData.SchemeData[])paramParcel.createTypedArray(DrmInitData.SchemeData.CREATOR));
    this.schemeDataCount = this.schemeDatas.length;
  }
  
  public DrmInitData(String paramString, List<DrmInitData.SchemeData> paramList)
  {
    this(paramString, false, (DrmInitData.SchemeData[])paramList.toArray(new DrmInitData.SchemeData[paramList.size()]));
  }
  
  private DrmInitData(@Nullable String paramString, boolean paramBoolean, DrmInitData.SchemeData... paramVarArgs)
  {
    this.schemeType = paramString;
    if (paramBoolean) {}
    for (paramString = (DrmInitData.SchemeData[])paramVarArgs.clone();; paramString = paramVarArgs)
    {
      Arrays.sort(paramString, this);
      this.schemeDatas = paramString;
      this.schemeDataCount = paramString.length;
      return;
    }
  }
  
  public DrmInitData(@Nullable String paramString, DrmInitData.SchemeData... paramVarArgs)
  {
    this(paramString, true, paramVarArgs);
  }
  
  public DrmInitData(List<DrmInitData.SchemeData> paramList)
  {
    this(null, false, (DrmInitData.SchemeData[])paramList.toArray(new DrmInitData.SchemeData[paramList.size()]));
  }
  
  public DrmInitData(DrmInitData.SchemeData... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  private static boolean containsSchemeDataWithUuid(ArrayList<DrmInitData.SchemeData> paramArrayList, int paramInt, UUID paramUUID)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (DrmInitData.SchemeData.access$000((DrmInitData.SchemeData)paramArrayList.get(i)).equals(paramUUID)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @Nullable
  public static DrmInitData createSessionCreationData(@Nullable DrmInitData paramDrmInitData1, @Nullable DrmInitData paramDrmInitData2)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    int k;
    int i;
    if (paramDrmInitData1 != null)
    {
      localObject1 = paramDrmInitData1.schemeType;
      localObject2 = paramDrmInitData1.schemeDatas;
      k = localObject2.length;
      i = 0;
      for (;;)
      {
        paramDrmInitData1 = (DrmInitData)localObject1;
        if (i >= k) {
          break;
        }
        paramDrmInitData1 = localObject2[i];
        if (paramDrmInitData1.hasData()) {
          localArrayList.add(paramDrmInitData1);
        }
        i += 1;
      }
    }
    paramDrmInitData1 = null;
    Object localObject2 = paramDrmInitData1;
    if (paramDrmInitData2 != null)
    {
      localObject1 = paramDrmInitData1;
      if (paramDrmInitData1 == null) {
        localObject1 = paramDrmInitData2.schemeType;
      }
      k = localArrayList.size();
      paramDrmInitData1 = paramDrmInitData2.schemeDatas;
      int m = paramDrmInitData1.length;
      i = j;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= m) {
          break;
        }
        paramDrmInitData2 = paramDrmInitData1[i];
        if ((paramDrmInitData2.hasData()) && (!containsSchemeDataWithUuid(localArrayList, k, DrmInitData.SchemeData.access$000(paramDrmInitData2)))) {
          localArrayList.add(paramDrmInitData2);
        }
        i += 1;
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return new DrmInitData((String)localObject2, localArrayList);
  }
  
  public int compare(DrmInitData.SchemeData paramSchemeData1, DrmInitData.SchemeData paramSchemeData2)
  {
    if (C.UUID_NIL.equals(DrmInitData.SchemeData.access$000(paramSchemeData1)))
    {
      if (C.UUID_NIL.equals(DrmInitData.SchemeData.access$000(paramSchemeData2))) {
        return 0;
      }
      return 1;
    }
    return DrmInitData.SchemeData.access$000(paramSchemeData1).compareTo(DrmInitData.SchemeData.access$000(paramSchemeData2));
  }
  
  public DrmInitData copyWithSchemeType(@Nullable String paramString)
  {
    if (Util.areEqual(this.schemeType, paramString)) {
      return this;
    }
    return new DrmInitData(paramString, false, this.schemeDatas);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DrmInitData)paramObject;
    } while ((Util.areEqual(this.schemeType, paramObject.schemeType)) && (Arrays.equals(this.schemeDatas, paramObject.schemeDatas)));
    return false;
  }
  
  public DrmInitData.SchemeData get(int paramInt)
  {
    return this.schemeDatas[paramInt];
  }
  
  @Deprecated
  public DrmInitData.SchemeData get(UUID paramUUID)
  {
    DrmInitData.SchemeData[] arrayOfSchemeData = this.schemeDatas;
    int j = arrayOfSchemeData.length;
    int i = 0;
    while (i < j)
    {
      DrmInitData.SchemeData localSchemeData = arrayOfSchemeData[i];
      if (localSchemeData.matches(paramUUID)) {
        return localSchemeData;
      }
      i += 1;
    }
    return null;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      if (this.schemeType != null) {
        break label37;
      }
    }
    label37:
    for (int i = 0;; i = this.schemeType.hashCode())
    {
      this.hashCode = (i * 31 + Arrays.hashCode(this.schemeDatas));
      return this.hashCode;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.schemeType);
    paramParcel.writeTypedArray(this.schemeDatas, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData
 * JD-Core Version:    0.7.0.1
 */