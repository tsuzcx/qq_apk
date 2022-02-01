package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/AndroidMessage;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Landroid/os/Parcelable;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "ProtoAdapterCreator", "wire-runtime"}, k=1, mv={1, 1, 16})
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>>
  extends Message<M, B>
  implements Parcelable
{
  public static final AndroidMessage.Companion Companion = new AndroidMessage.Companion(null);
  
  protected AndroidMessage(@NotNull ProtoAdapter<M> paramProtoAdapter, @NotNull ByteString paramByteString)
  {
    super(paramProtoAdapter, paramByteString);
  }
  
  @JvmStatic
  @NotNull
  public static final <E> Parcelable.Creator<E> newCreator(@NotNull ProtoAdapter<E> paramProtoAdapter)
  {
    return Companion.newCreator(paramProtoAdapter);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    paramParcel.writeByteArray(encode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.AndroidMessage
 * JD-Core Version:    0.7.0.1
 */