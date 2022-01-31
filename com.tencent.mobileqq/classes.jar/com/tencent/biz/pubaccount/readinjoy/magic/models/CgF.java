package com.tencent.biz.pubaccount.readinjoy.magic.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import lrr;

public final class CgF
  extends PFile
{
  public static final Parcelable.Creator CREATOR = new lrr();
  public final ArrayList groups;
  
  private CgF(Parcel paramParcel)
  {
    super(paramParcel);
    this.groups = paramParcel.createTypedArrayList(CG.CREATOR);
  }
  
  private CgF(String paramString)
  {
    super(paramString);
    paramString = this.content.split("\n");
    this.groups = new ArrayList();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = paramString[i];
      }
      try
      {
        this.groups.add(new CG(str));
        label58:
        i += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label58;
      }
    }
  }
  
  public static CgF get(int paramInt)
  {
    return new CgF(String.format(Locale.ENGLISH, "/proc/%d/cgroup", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public CG getGroup(String paramString)
  {
    Iterator localIterator = this.groups.iterator();
    while (localIterator.hasNext())
    {
      CG localCG = (CG)localIterator.next();
      String[] arrayOfString = localCG.a.split(",");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          return localCG;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.groups);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.models.CgF
 * JD-Core Version:    0.7.0.1
 */