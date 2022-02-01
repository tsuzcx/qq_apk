package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec
{
  private final SimpleArrayMap<String, MotionTiming> a = new SimpleArrayMap();
  private final SimpleArrayMap<String, PropertyValuesHolder[]> b = new SimpleArrayMap();
  
  @Nullable
  public static MotionSpec a(@NonNull Context paramContext, @AnimatorRes int paramInt)
  {
    try
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((paramContext instanceof AnimatorSet)) {
        return a(((AnimatorSet)paramContext).getChildAnimations());
      }
      if (paramContext != null)
      {
        localObject = new ArrayList();
        ((List)localObject).add(paramContext);
        paramContext = a((List)localObject);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Can't load animation resource ID #0x");
      ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
      Log.w("MotionSpec", ((StringBuilder)localObject).toString(), paramContext);
    }
    return null;
  }
  
  @Nullable
  public static MotionSpec a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return a(paramContext, paramInt);
      }
    }
    return null;
  }
  
  @NonNull
  private static MotionSpec a(@NonNull List<Animator> paramList)
  {
    MotionSpec localMotionSpec = new MotionSpec();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a(localMotionSpec, (Animator)paramList.get(i));
      i += 1;
    }
    return localMotionSpec;
  }
  
  private static void a(@NonNull MotionSpec paramMotionSpec, Animator paramAnimator)
  {
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      paramMotionSpec.a(paramAnimator.getPropertyName(), paramAnimator.getValues());
      paramMotionSpec.a(paramAnimator.getPropertyName(), MotionTiming.a(paramAnimator));
      return;
    }
    paramMotionSpec = new StringBuilder();
    paramMotionSpec.append("Animator must be an ObjectAnimator: ");
    paramMotionSpec.append(paramAnimator);
    throw new IllegalArgumentException(paramMotionSpec.toString());
  }
  
  @NonNull
  private PropertyValuesHolder[] a(@NonNull PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[paramArrayOfPropertyValuesHolder.length];
    int i = 0;
    while (i < paramArrayOfPropertyValuesHolder.length)
    {
      arrayOfPropertyValuesHolder[i] = paramArrayOfPropertyValuesHolder[i].clone();
      i += 1;
    }
    return arrayOfPropertyValuesHolder;
  }
  
  public long a()
  {
    int j = this.a.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      MotionTiming localMotionTiming = (MotionTiming)this.a.valueAt(i);
      l = Math.max(l, localMotionTiming.a() + localMotionTiming.b());
      i += 1;
    }
    return l;
  }
  
  @NonNull
  public <T> ObjectAnimator a(@NonNull String paramString, @NonNull T paramT, @NonNull Property<T, ?> paramProperty)
  {
    paramT = ObjectAnimator.ofPropertyValuesHolder(paramT, d(paramString));
    paramT.setProperty(paramProperty);
    b(paramString).a(paramT);
    return paramT;
  }
  
  public void a(String paramString, @Nullable MotionTiming paramMotionTiming)
  {
    this.a.put(paramString, paramMotionTiming);
  }
  
  public void a(String paramString, PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    this.b.put(paramString, paramArrayOfPropertyValuesHolder);
  }
  
  public boolean a(String paramString)
  {
    return this.a.get(paramString) != null;
  }
  
  public MotionTiming b(String paramString)
  {
    if (a(paramString)) {
      return (MotionTiming)this.a.get(paramString);
    }
    throw new IllegalArgumentException();
  }
  
  public boolean c(String paramString)
  {
    return this.b.get(paramString) != null;
  }
  
  @NonNull
  public PropertyValuesHolder[] d(String paramString)
  {
    if (c(paramString)) {
      return a((PropertyValuesHolder[])this.b.get(paramString));
    }
    throw new IllegalArgumentException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MotionSpec)) {
      return false;
    }
    paramObject = (MotionSpec)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.animation.MotionSpec
 * JD-Core Version:    0.7.0.1
 */