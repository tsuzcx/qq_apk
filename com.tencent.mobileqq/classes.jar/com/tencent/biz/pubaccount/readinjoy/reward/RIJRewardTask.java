package com.tencent.biz.pubaccount.readinjoy.reward;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "rowKey", "", "contentType", "", "maxTimeInMs", "recordTimeInMs", "(Ljava/lang/String;III)V", "getContentType", "()I", "getMaxTimeInMs", "getRecordTimeInMs", "setRecordTimeInMs", "(I)V", "getRowKey", "()Ljava/lang/String;", "beginTransaction", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$ITransaction;", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "ITransaction", "Transaction", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTask
  implements Parcelable
{
  public static final RIJRewardTask.CREATOR CREATOR = new RIJRewardTask.CREATOR(null);
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int b;
  private int c;
  
  public RIJRewardTask(@NotNull Parcel paramParcel)
  {
    this(str, paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public RIJRewardTask(@NotNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final RIJRewardTask.ITransaction a()
  {
    return (RIJRewardTask.ITransaction)new RIJRewardTask.Transaction(this);
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return "RIJRewardTask(rowKey='" + this.jdField_a_of_type_JavaLangString + "', contentType=" + this.jdField_a_of_type_Int + ", maxTimeInMs=" + this.b + ", currentTimeInMs=" + this.c + ')';
  }
  
  public void writeToParcel(@Nullable Parcel paramParcel, int paramInt)
  {
    if (paramParcel != null) {
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.b);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask
 * JD-Core Version:    0.7.0.1
 */