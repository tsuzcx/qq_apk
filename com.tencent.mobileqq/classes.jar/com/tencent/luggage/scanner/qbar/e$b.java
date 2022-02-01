package com.tencent.luggage.scanner.qbar;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/scanner/qbar/ScanDecodeFrameData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/luggage/scanner/qbar/ScanDecodeFrameData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/luggage/scanner/qbar/ScanDecodeFrameData;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e$b
  implements Parcelable.Creator<e>
{
  @NotNull
  public e a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new e(paramParcel);
  }
  
  @NotNull
  public e[] a(int paramInt)
  {
    return new e[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.e.b
 * JD-Core Version:    0.7.0.1
 */