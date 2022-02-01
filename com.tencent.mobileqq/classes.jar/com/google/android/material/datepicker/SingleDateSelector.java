package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R.attr;
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
public class SingleDateSelector
  implements DateSelector<Long>
{
  public static final Parcelable.Creator<SingleDateSelector> CREATOR = new SingleDateSelector.2();
  @Nullable
  private Long a;
  
  private void a()
  {
    this.a = null;
  }
  
  public int a(Context paramContext)
  {
    return MaterialAttributes.a(paramContext, R.attr.z, MaterialDatePicker.class.getCanonicalName());
  }
  
  public View a(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle, CalendarConstraints paramCalendarConstraints, @NonNull OnSelectionChangedListener<Long> paramOnSelectionChangedListener)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.B, paramViewGroup, false);
    paramViewGroup = (TextInputLayout)paramLayoutInflater.findViewById(R.id.U);
    paramBundle = paramViewGroup.a();
    if (ManufacturerUtils.d()) {
      paramBundle.setInputType(17);
    }
    SimpleDateFormat localSimpleDateFormat = UtcDates.a();
    String str = UtcDates.a(paramLayoutInflater.getResources(), localSimpleDateFormat);
    paramViewGroup.setPlaceholderText(str);
    Long localLong = this.a;
    if (localLong != null) {
      paramBundle.setText(localSimpleDateFormat.format(localLong));
    }
    paramBundle.addTextChangedListener(new SingleDateSelector.1(this, str, localSimpleDateFormat, paramViewGroup, paramCalendarConstraints, paramOnSelectionChangedListener));
    ViewUtils.a(paramBundle);
    return paramLayoutInflater;
  }
  
  @Nullable
  public Long a()
  {
    return this.a;
  }
  
  @NonNull
  public String a(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    Object localObject = this.a;
    if (localObject == null) {
      return paramContext.getString(R.string.y);
    }
    localObject = DateStrings.a(((Long)localObject).longValue());
    return paramContext.getString(R.string.x, new Object[] { localObject });
  }
  
  @NonNull
  public Collection<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    Long localLong = this.a;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    return localArrayList;
  }
  
  public void a(long paramLong)
  {
    this.a = Long.valueOf(paramLong);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  @NonNull
  public Collection<Pair<Long, Long>> b()
  {
    return new ArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.SingleDateSelector
 * JD-Core Version:    0.7.0.1
 */