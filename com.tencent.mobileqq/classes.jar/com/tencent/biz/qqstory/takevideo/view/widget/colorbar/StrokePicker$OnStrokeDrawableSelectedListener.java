package com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.Stroke;

public abstract interface StrokePicker$OnStrokeDrawableSelectedListener
{
  public abstract void a(@NonNull MotionEvent paramMotionEvent, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @NonNull Stroke paramStroke);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.StrokePicker.OnStrokeDrawableSelectedListener
 * JD-Core Version:    0.7.0.1
 */