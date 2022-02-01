package com.squareup.wire;

import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/AndroidMessage$Companion;", "", "()V", "newCreator", "Landroid/os/Parcelable$Creator;", "E", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class AndroidMessage$Companion
{
  @JvmStatic
  @NotNull
  public final <E> Parcelable.Creator<E> newCreator(@NotNull ProtoAdapter<E> paramProtoAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoAdapter, "adapter");
    return (Parcelable.Creator)new AndroidMessage.ProtoAdapterCreator(paramProtoAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.AndroidMessage.Companion
 * JD-Core Version:    0.7.0.1
 */