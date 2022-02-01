package com.tencent.luggage.wxa.y;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class f
  extends b
{
  public static final Parcelable.Creator<f> CREATOR = new f.1();
  public final List<f.b> a;
  
  private f(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(f.b.a(paramParcel));
      i += 1;
    }
    this.a = Collections.unmodifiableList(localArrayList);
  }
  
  private f(List<f.b> paramList)
  {
    this.a = Collections.unmodifiableList(paramList);
  }
  
  static f a(m paramm)
  {
    int j = paramm.g();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(f.b.a(paramm));
      i += 1;
    }
    return new f(localArrayList);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.a.size();
    paramParcel.writeInt(i);
    paramInt = 0;
    while (paramInt < i)
    {
      f.b.a((f.b)this.a.get(paramInt), paramParcel);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.f
 * JD-Core Version:    0.7.0.1
 */