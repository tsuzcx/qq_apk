package com.tencent.aladdin.config.network;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public abstract interface AladdinResponseHandler
  extends Parcelable
{
  public abstract void onReceive(@NonNull byte[] paramArrayOfByte, @NonNull Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.network.AladdinResponseHandler
 * JD-Core Version:    0.7.0.1
 */