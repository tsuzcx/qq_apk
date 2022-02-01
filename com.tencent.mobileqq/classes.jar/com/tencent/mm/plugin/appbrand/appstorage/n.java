package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ba.b;
import com.tencent.mm.plugin.appbrand.appcache.f;
import java.io.Closeable;

public abstract interface n
  extends Parcelable, b, f, Closeable, Comparable<n>
{
  @Nullable
  public abstract String b(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.n
 * JD-Core Version:    0.7.0.1
 */