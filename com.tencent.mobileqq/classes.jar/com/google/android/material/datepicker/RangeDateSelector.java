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
  @Nullable
  private Long jdField_a_of_type_JavaLangLong = null;
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private Long jdField_b_of_type_JavaLangLong = null;
  private final String jdField_b_of_type_JavaLangString = " ";
  @Nullable
  private Long c = null;
  @Nullable
  private Long d = null;
  
  private void a(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2)
  {
    if ((paramTextInputLayout1.e() != null) && (this.jdField_a_of_type_JavaLangString.contentEquals(paramTextInputLayout1.e()))) {
      paramTextInputLayout1.setError(null);
    }
    if ((paramTextInputLayout2.e() != null) && (" ".contentEquals(paramTextInputLayout2.e()))) {
      paramTextInputLayout2.setError(null);
    }
  }
  
  private void a(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener)
  {
    Long localLong = this.c;
    if ((localLong != null) && (this.d != null))
    {
      if (a(localLong.longValue(), this.d.longValue()))
      {
        this.jdField_a_of_type_JavaLangLong = this.c;
        this.jdField_b_of_type_JavaLangLong = this.d;
        paramOnSelectionChangedListener.a(a());
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
    paramTextInputLayout1.setError(this.jdField_a_of_type_JavaLangString);
    paramTextInputLayout2.setError(" ");
  }
  
  public int a(@NonNull Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    int i = localResources.getDimensionPixelSize(R.dimen.V);
    if (Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) > i) {
      i = R.attr.z;
    } else {
      i = R.attr.x;
    }
    return MaterialAttributes.a(paramContext, i, MaterialDatePicker.class.getCanonicalName());
  }
  
  public View a(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle, CalendarConstraints paramCalendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.C, paramViewGroup, false);
    paramViewGroup = (TextInputLayout)paramLayoutInflater.findViewById(R.id.W);
    paramBundle = (TextInputLayout)paramLayoutInflater.findViewById(R.id.V);
    EditText localEditText1 = paramViewGroup.a();
    EditText localEditText2 = paramBundle.a();
    if (ManufacturerUtils.d())
    {
      localEditText1.setInputType(17);
      localEditText2.setInputType(17);
    }
    this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getResources().getString(R.string.D);
    SimpleDateFormat localSimpleDateFormat = UtcDates.a();
    Object localObject = this.jdField_a_of_type_JavaLangLong;
    if (localObject != null)
    {
      localEditText1.setText(localSimpleDateFormat.format(localObject));
      this.c = this.jdField_a_of_type_JavaLangLong;
    }
    localObject = this.jdField_b_of_type_JavaLangLong;
    if (localObject != null)
    {
      localEditText2.setText(localSimpleDateFormat.format(localObject));
      this.d = this.jdField_b_of_type_JavaLangLong;
    }
    localObject = UtcDates.a(paramLayoutInflater.getResources(), localSimpleDateFormat);
    paramViewGroup.setPlaceholderText((CharSequence)localObject);
    paramBundle.setPlaceholderText((CharSequence)localObject);
    localEditText1.addTextChangedListener(new RangeDateSelector.1(this, (String)localObject, localSimpleDateFormat, paramViewGroup, paramCalendarConstraints, paramViewGroup, paramBundle, paramOnSelectionChangedListener));
    localEditText2.addTextChangedListener(new RangeDateSelector.2(this, (String)localObject, localSimpleDateFormat, paramBundle, paramCalendarConstraints, paramViewGroup, paramBundle, paramOnSelectionChangedListener));
    ViewUtils.a(localEditText1);
    return paramLayoutInflater;
  }
  
  @NonNull
  public Pair<Long, Long> a()
  {
    return new Pair(this.jdField_a_of_type_JavaLangLong, this.jdField_b_of_type_JavaLangLong);
  }
  
  @NonNull
  public String a(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    if ((this.jdField_a_of_type_JavaLangLong == null) && (this.jdField_b_of_type_JavaLangLong == null)) {
      return paramContext.getString(R.string.J);
    }
    Object localObject = this.jdField_b_of_type_JavaLangLong;
    if (localObject == null) {
      return paramContext.getString(R.string.H, new Object[] { DateStrings.e(this.jdField_a_of_type_JavaLangLong.longValue()) });
    }
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    if (localLong == null) {
      return paramContext.getString(R.string.G, new Object[] { DateStrings.e(this.jdField_b_of_type_JavaLangLong.longValue()) });
    }
    localObject = DateStrings.a(localLong, (Long)localObject);
    return paramContext.getString(R.string.I, new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
  }
  
  @NonNull
  public Collection<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    localLong = this.jdField_b_of_type_JavaLangLong;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    return localArrayList;
  }
  
  public void a(long paramLong)
  {
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    if (localLong == null)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      return;
    }
    if ((this.jdField_b_of_type_JavaLangLong == null) && (a(localLong.longValue(), paramLong)))
    {
      this.jdField_b_of_type_JavaLangLong = Long.valueOf(paramLong);
      return;
    }
    this.jdField_b_of_type_JavaLangLong = null;
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
  }
  
  public boolean a()
  {
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    return (localLong != null) && (this.jdField_b_of_type_JavaLangLong != null) && (a(localLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue()));
  }
  
  @NonNull
  public Collection<Pair<Long, Long>> b()
  {
    if ((this.jdField_a_of_type_JavaLangLong != null) && (this.jdField_b_of_type_JavaLangLong != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Pair(this.jdField_a_of_type_JavaLangLong, this.jdField_b_of_type_JavaLangLong));
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.jdField_a_of_type_JavaLangLong);
    paramParcel.writeValue(this.jdField_b_of_type_JavaLangLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.RangeDateSelector
 * JD-Core Version:    0.7.0.1
 */