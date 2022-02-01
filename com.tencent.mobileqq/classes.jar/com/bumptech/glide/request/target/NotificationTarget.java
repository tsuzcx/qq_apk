package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class NotificationTarget
  extends SimpleTarget<Bitmap>
{
  private final RemoteViews a;
  private final Context b;
  private final int c;
  private final String d;
  private final Notification e;
  private final int f;
  
  private void b()
  {
    ((NotificationManager)Preconditions.a((NotificationManager)this.b.getSystemService("notification"))).notify(this.d, this.c, this.e);
  }
  
  public void a(@NonNull Bitmap paramBitmap, @Nullable Transition<? super Bitmap> paramTransition)
  {
    this.a.setImageViewBitmap(this.f, paramBitmap);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.NotificationTarget
 * JD-Core Version:    0.7.0.1
 */