package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;

public class AppWidgetTarget
  extends SimpleTarget<Bitmap>
{
  private final int[] a;
  private final ComponentName b;
  private final RemoteViews c;
  private final Context d;
  private final int e;
  
  private void b()
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this.d);
    ComponentName localComponentName = this.b;
    if (localComponentName != null)
    {
      localAppWidgetManager.updateAppWidget(localComponentName, this.c);
      return;
    }
    localAppWidgetManager.updateAppWidget(this.a, this.c);
  }
  
  public void a(@NonNull Bitmap paramBitmap, @Nullable Transition<? super Bitmap> paramTransition)
  {
    this.c.setImageViewBitmap(this.e, paramBitmap);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.AppWidgetTarget
 * JD-Core Version:    0.7.0.1
 */