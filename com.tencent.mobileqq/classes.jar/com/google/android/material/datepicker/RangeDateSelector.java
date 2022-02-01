package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector
  implements DateSelector<Pair<Long, Long>>
{
  public static final Parcelable.Creator<RangeDateSelector> CREATOR = new RangeDateSelector.3();
  private String a;
  private final String b = " ";
  @Nullable
  private Long c = null;
  @Nullable
  private Long d = null;
  @Nullable
  private Long e = null;
  @Nullable
  private Long f = null;
  
  private void a(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2)
  {
    if ((paramTextInputLayout1.getError() != null) && (this.a.contentEquals(paramTextInputLayout1.getError()))) {
      paramTextInputLayout1.setError(null);
    }
    if ((paramTextInputLayout2.getError() != null) && (" ".contentEquals(paramTextInputLayout2.getError()))) {
      paramTextInputLayout2.setError(null);
    }
  }
  
  private void a(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener)
  {
    Long localLong = this.e;
    if ((localLong != null) && (this.f != null))
    {
      if (a(localLong.longValue(), this.f.longValue()))
      {
        this.c = this.e;
        this.d = this.f;
        paramOnSelectionChangedListener.a(e());
        return;
      }
      b(paramTextInputLayout1, paramTextInputLayout2);
      paramOnSelectionChangedListener.a();
      return;
    }
    a(paramTextInputLayout1, paramTextInputLayout2);
    paramOnSelectionChangedListener.a();
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 <= paramLong2;
  }
  
  private void b(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2)
  {
    paramTextInputLayout1.setError(this.a);
    paramTextInputLayout2.setError(" ");
  }
  
  public View a(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle, CalendarConstraints paramCalendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.C, paramViewGroup, false);
    paramViewGroup = (TextInputLayout)paramLayoutInflater.findViewById(R.id.W);
    paramBundle = (TextInputLayout)paramLayoutInflater.findViewById(R.id.V);
    EditText localEditText1 = paramViewGroup.getEditText();
    EditText localEditText2 = paramBundle.getEditText();
    if (ManufacturerUtils.d())
    {
      localEditText1.setInputType(17);
      localEditText2.setInputType(17);
    }
    this.a = paramLayoutInflater.getResources().getString(R.string.D);
    SimpleDateFormat localSimpleDateFormat = UtcDates.d();
    Object localObject = this.c;
    if (localObject != null)
    {
      localEditText1.setText(localSimpleDateFormat.format(localObject));
      this.e = this.c;
    }
    localObject = this.d;
    if (localObject != null)
    {
      localEditText2.setText(localSimpleDateFormat.format(localObject));
      this.f = this.d;
    }
    localObject = UtcDates.a(paramLayoutInflater.getResources(), localSimpleDateFormat);
    paramViewGroup.setPlaceholderText((CharSequence)localObject);
    paramBundle.setPlaceholderText((CharSequence)localObject);
    localEditText1.addTextChangedListener(new RangeDateSelector.1(this, (String)localObject, localSimpleDateFormat, paramViewGroup, paramCalendarConstraints, paramViewGroup, paramBundle, paramOnSelectionChangedListener));
    localEditText2.addTextChangedListener(new RangeDateSelector.2(this, (String)localObject, localSimpleDateFormat, paramBundle, paramCalendarConstraints, paramViewGroup, paramBundle, paramOnSelectionChangedListener));
    ViewUtils.b(localEditText1);
    return paramLayoutInflater;
  }
  
  @NonNull
  public String a(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    if ((this.c == null) && (this.d == null)) {
      return paramContext.getString(R.string.J);
    }
    Object localObject = this.d;
    if (localObject == null) {
      return paramContext.getString(R.string.H, new Object[] { DateStrings.e(this.c.longValue()) });
    }
    Long localLong = this.c;
    if (localLong == null) {
      return paramContext.getString(R.string.G, new Object[] { DateStrings.e(this.d.longValue()) });
    }
    localObject = DateStrings.a(localLong, (Long)localObject);
    return paramContext.getString(R.string.I, new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
  }
  
  public void a(long paramLong)
  {
    Long localLong = this.c;
    if (localLong == null)
    {
      this.c = Long.valueOf(paramLong);
      return;
    }
    if ((this.d == null) && (a(localLong.longValue(), paramLong)))
    {
      this.d = Long.valueOf(paramLong);
      return;
    }
    this.d = null;
    this.c = Long.valueOf(paramLong);
  }
  
  public int b(@NonNull Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    int i = localResources.getDimensionPixelSize(R.dimen.V);
    if (Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) > i) {
      i = R.attr.G;
    } else {
      i = R.attr.E;
    }
    return MaterialAttributes.a(paramContext, i, MaterialDatePicker.class.getCanonicalName());
  }
  
  public boolean b()
  {
    Long localLong = this.c;
    return (localLong != null) && (this.d != null) && (a(localLong.longValue(), this.d.longValue()));
  }
  
  @NonNull
  public Collection<Long> c()
  {
    ArrayList localArrayList = new ArrayList();
    Long localLong = this.c;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    localLong = this.d;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    return localArrayList;
  }
  
  @NonNull
  public Collection<Pair<Long, Long>> d()
  {
    if ((this.c != null) && (this.d != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Pair(this.c, this.d));
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public Pair<Long, Long> e()
  {
    return new Pair(this.c, this.d);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.c);
    paramParcel.writeValue(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.RangeDateSelector
 * JD-Core Version:    0.7.0.1
 */