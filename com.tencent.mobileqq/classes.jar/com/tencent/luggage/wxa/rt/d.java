package com.tencent.luggage.wxa.rt;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;

public abstract interface d
  extends Parcelable
{
  public abstract ParcelFileDescriptor a(String paramString1, String paramString2);
  
  public abstract OutputStream a(String paramString, boolean paramBoolean);
  
  public abstract ReadableByteChannel a(String paramString);
  
  public abstract void a(CancellationSignal paramCancellationSignal);
  
  public abstract void a(Map<String, String> paramMap);
  
  public abstract boolean a(String paramString1, d paramd, String paramString2);
  
  public abstract int b();
  
  public abstract InputStream b(String paramString);
  
  public abstract Iterable<d.a> b(String paramString, boolean paramBoolean);
  
  public abstract long c(String paramString1, d paramd, String paramString2);
  
  public abstract boolean c(String paramString);
  
  public abstract boolean c(String paramString, boolean paramBoolean);
  
  public abstract d.a d(String paramString);
  
  public abstract String d(String paramString, boolean paramBoolean);
  
  public abstract boolean e(String paramString);
  
  public abstract boolean f(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.d
 * JD-Core Version:    0.7.0.1
 */