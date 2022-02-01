package com.tencent.luggage.wxa.av;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.image_picker.imagepicker.features.f;
import com.tencent.image_picker.imagepicker.features.h;

public class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  private f a;
  private h b;
  
  public a() {}
  
  protected a(Parcel paramParcel)
  {
    this.a = ((f)paramParcel.readParcelable(f.class.getClassLoader()));
    int i = paramParcel.readInt();
    if (i == -1) {
      paramParcel = null;
    } else {
      paramParcel = h.values()[i];
    }
    this.b = paramParcel;
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  public void a(h paramh)
  {
    this.b = paramh;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public h o()
  {
    return this.b;
  }
  
  public f p()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    h localh = this.b;
    if (localh == null) {
      paramInt = -1;
    } else {
      paramInt = localh.ordinal();
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.av.a
 * JD-Core Version:    0.7.0.1
 */