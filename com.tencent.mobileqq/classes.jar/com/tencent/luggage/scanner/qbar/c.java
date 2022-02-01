package com.tencent.luggage.scanner.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qbar.QbarNative.QBarPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/qbar/LuggageQBarPoint;", "Lcom/tencent/qbar/QbarNative$QBarPoint;", "Landroid/os/Parcelable;", "()V", "point", "(Lcom/tencent/qbar/QbarNative$QBarPoint;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends QbarNative.QBarPoint
  implements Parcelable
{
  public static final c.a CREATOR = new c.a(null);
  
  public c() {}
  
  public c(@NotNull Parcel paramParcel)
  {
    this();
    this.point_cnt = paramParcel.readInt();
    this.x0 = paramParcel.readFloat();
    this.x1 = paramParcel.readFloat();
    this.x2 = paramParcel.readFloat();
    this.x3 = paramParcel.readFloat();
    this.y0 = paramParcel.readFloat();
    this.y1 = paramParcel.readFloat();
    this.y2 = paramParcel.readFloat();
    this.y3 = paramParcel.readFloat();
  }
  
  public c(@Nullable QbarNative.QBarPoint paramQBarPoint)
  {
    if (paramQBarPoint != null)
    {
      this.point_cnt = paramQBarPoint.point_cnt;
      this.x0 = paramQBarPoint.x0;
      this.x1 = paramQBarPoint.x1;
      this.x2 = paramQBarPoint.x2;
      this.x3 = paramQBarPoint.x3;
      this.y0 = paramQBarPoint.y0;
      this.y1 = paramQBarPoint.y1;
      this.y2 = paramQBarPoint.y2;
      this.y3 = paramQBarPoint.y3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.point_cnt);
    paramParcel.writeFloat(this.x0);
    paramParcel.writeFloat(this.x1);
    paramParcel.writeFloat(this.x2);
    paramParcel.writeFloat(this.x3);
    paramParcel.writeFloat(this.y0);
    paramParcel.writeFloat(this.y1);
    paramParcel.writeFloat(this.y2);
    paramParcel.writeFloat(this.y3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.c
 * JD-Core Version:    0.7.0.1
 */