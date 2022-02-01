package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.lang.reflect.Array;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/AndroidMessage$ProtoAdapterCreator;", "M", "Landroid/os/Parcelable$Creator;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "(Lcom/squareup/wire/ProtoAdapter;)V", "createFromParcel", "input", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/lang/Object;", "newArray", "", "size", "", "(I)[Ljava/lang/Object;", "wire-runtime"}, k=1, mv={1, 1, 16})
final class AndroidMessage$ProtoAdapterCreator<M>
  implements Parcelable.Creator<M>
{
  private final ProtoAdapter<M> adapter;
  
  public AndroidMessage$ProtoAdapterCreator(@NotNull ProtoAdapter<M> paramProtoAdapter)
  {
    this.adapter = paramProtoAdapter;
  }
  
  public M createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "input");
    ProtoAdapter localProtoAdapter = this.adapter;
    paramParcel = paramParcel.createByteArray();
    Intrinsics.checkExpressionValueIsNotNull(paramParcel, "input.createByteArray()");
    return localProtoAdapter.decode(paramParcel);
  }
  
  @NotNull
  public M[] newArray(int paramInt)
  {
    Object localObject = this.adapter.getType();
    if (localObject != null) {
      localObject = JvmClassMappingKt.getJavaObjectType((KClass)localObject);
    } else {
      localObject = null;
    }
    localObject = Array.newInstance((Class)localObject, paramInt);
    if (localObject != null) {
      return (Object[])localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<M>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.AndroidMessage.ProtoAdapterCreator
 * JD-Core Version:    0.7.0.1
 */