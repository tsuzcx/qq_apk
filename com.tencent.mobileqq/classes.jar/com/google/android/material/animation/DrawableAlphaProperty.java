package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

public class DrawableAlphaProperty
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> a;
  private final WeakHashMap<Drawable, Integer> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilProperty = new DrawableAlphaProperty();
  }
  
  private DrawableAlphaProperty()
  {
    super(Integer.class, "drawableAlphaCompat");
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  @Nullable
  public Integer a(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Integer.valueOf(paramDrawable.getAlpha());
    }
    if (this.jdField_a_of_type_JavaUtilWeakHashMap.containsKey(paramDrawable)) {
      return (Integer)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramDrawable);
    }
    return Integer.valueOf(255);
  }
  
  public void a(@NonNull Drawable paramDrawable, @NonNull Integer paramInteger)
  {
    if (Build.VERSION.SDK_INT < 19) {
      this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramDrawable, paramInteger);
    }
    paramDrawable.setAlpha(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.animation.DrawableAlphaProperty
 * JD-Core Version:    0.7.0.1
 */