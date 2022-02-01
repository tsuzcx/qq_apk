package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.util.Collection;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface DateSelector<S>
  extends Parcelable
{
  @StyleRes
  public abstract int a(Context paramContext);
  
  @NonNull
  public abstract View a(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle, @NonNull CalendarConstraints paramCalendarConstraints, @NonNull OnSelectionChangedListener<S> paramOnSelectionChangedListener);
  
  @Nullable
  public abstract S a();
  
  @NonNull
  public abstract String a(Context paramContext);
  
  @NonNull
  public abstract Collection<Long> a();
  
  public abstract void a(long paramLong);
  
  public abstract boolean a();
  
  @NonNull
  public abstract Collection<Pair<Long, Long>> b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.DateSelector
 * JD-Core Version:    0.7.0.1
 */