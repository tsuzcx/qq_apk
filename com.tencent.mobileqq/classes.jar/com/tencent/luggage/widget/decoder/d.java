package com.tencent.luggage.widget.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;

public abstract interface d
{
  @NonNull
  public abstract Bitmap a(@NonNull Rect paramRect, int paramInt);
  
  @NonNull
  public abstract Point a(Context paramContext, @NonNull Uri paramUri);
  
  public abstract boolean a();
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.decoder.d
 * JD-Core Version:    0.7.0.1
 */