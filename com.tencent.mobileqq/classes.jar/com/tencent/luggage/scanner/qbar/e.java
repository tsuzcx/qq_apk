package com.tencent.luggage.scanner.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/qbar/ScanDecodeFrameData;", "Landroid/os/Parcelable;", "frameData", "", "width", "", "height", "cameraRotation", "([BIII)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCameraRotation", "()I", "setCameraRotation", "(I)V", "getHeight", "setHeight", "previewData", "getPreviewData", "()[B", "setPreviewData", "([B)V", "getWidth", "setWidth", "describeContents", "writeToParcel", "", "flags", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<e> CREATOR = (Parcelable.Creator)new e.b();
  public static final e.a a = new e.a(null);
  @Nullable
  private byte[] b;
  private int c;
  private int d;
  private int e;
  
  public e(@NotNull Parcel paramParcel)
  {
    this.b = paramParcel.createByteArray();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public e(@Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramArrayOfByte;
    this.d = paramInt1;
    this.e = paramInt2;
    this.c = paramInt3;
  }
  
  @Nullable
  public final byte[] a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeByteArray(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.e
 * JD-Core Version:    0.7.0.1
 */