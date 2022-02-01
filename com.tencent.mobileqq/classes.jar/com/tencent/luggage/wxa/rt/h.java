package com.tencent.luggage.wxa.rt;

import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Parcelable;
import android.util.Pair;
import java.util.Map;

public abstract interface h
  extends Parcelable
{
  public abstract Pair<d, String> a(h.c paramc, Uri paramUri);
  
  public abstract void a(CancellationSignal paramCancellationSignal);
  
  public abstract void a(Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.h
 * JD-Core Version:    0.7.0.1
 */