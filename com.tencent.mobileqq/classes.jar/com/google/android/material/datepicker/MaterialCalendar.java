package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.integer;
import com.google.android.material.R.layout;
import com.google.android.material.button.MaterialButton;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S>
  extends PickerFragment<S>
{
  @VisibleForTesting
  static final Object a = "MONTHS_VIEW_GROUP_TAG";
  @VisibleForTesting
  static final Object b = "NAVIGATION_PREV_TAG";
  @VisibleForTesting
  static final Object c = "NAVIGATION_NEXT_TAG";
  @VisibleForTesting
  static final Object d = "SELECTOR_TOGGLE_TAG";
  @StyleRes
  private int f;
  @Nullable
  private DateSelector<S> g;
  @Nullable
  private CalendarConstraints h;
  @Nullable
  private Month i;
  private MaterialCalendar.CalendarSelector j;
  private CalendarStyle k;
  private RecyclerView l;
  private RecyclerView m;
  private View n;
  private View o;
  
  @Px
  static int a(@NonNull Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(R.dimen.R);
  }
  
  @NonNull
  public static <T> MaterialCalendar<T> a(@NonNull DateSelector<T> paramDateSelector, @StyleRes int paramInt, @NonNull CalendarConstraints paramCalendarConstraints)
  {
    MaterialCalendar localMaterialCalendar = new MaterialCalendar();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("GRID_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localBundle.putParcelable("CURRENT_MONTH_KEY", paramCalendarConstraints.d());
    localMaterialCalendar.setArguments(localBundle);
    return localMaterialCalendar;
  }
  
  private void a(int paramInt)
  {
    this.m.post(new MaterialCalendar.10(this, paramInt));
  }
  
  private void a(@NonNull View paramView, @NonNull MonthsPagerAdapter paramMonthsPagerAdapter)
  {
    MaterialButton localMaterialButton1 = (MaterialButton)paramView.findViewById(R.id.D);
    localMaterialButton1.setTag(d);
    ViewCompat.setAccessibilityDelegate(localMaterialButton1, new MaterialCalendar.5(this));
    MaterialButton localMaterialButton2 = (MaterialButton)paramView.findViewById(R.id.F);
    localMaterialButton2.setTag(b);
    MaterialButton localMaterialButton3 = (MaterialButton)paramView.findViewById(R.id.E);
    localMaterialButton3.setTag(c);
    this.n = paramView.findViewById(R.id.N);
    this.o = paramView.findViewById(R.id.I);
    a(MaterialCalendar.CalendarSelector.DAY);
    localMaterialButton1.setText(this.i.a(paramView.getContext()));
    this.m.addOnScrollListener(new MaterialCalendar.6(this, paramMonthsPagerAdapter, localMaterialButton1));
    localMaterialButton1.setOnClickListener(new MaterialCalendar.7(this));
    localMaterialButton3.setOnClickListener(new MaterialCalendar.8(this, paramMonthsPagerAdapter));
    localMaterialButton2.setOnClickListener(new MaterialCalendar.9(this, paramMonthsPagerAdapter));
  }
  
  @NonNull
  private RecyclerView.ItemDecoration h()
  {
    return new MaterialCalendar.4(this);
  }
  
  @Nullable
  Month a()
  {
    return this.i;
  }
  
  void a(MaterialCalendar.CalendarSelector paramCalendarSelector)
  {
    this.j = paramCalendarSelector;
    if (paramCalendarSelector == MaterialCalendar.CalendarSelector.YEAR)
    {
      this.l.getLayoutManager().scrollToPosition(((YearGridAdapter)this.l.getAdapter()).a(this.i.b));
      this.n.setVisibility(0);
      this.o.setVisibility(8);
      return;
    }
    if (paramCalendarSelector == MaterialCalendar.CalendarSelector.DAY)
    {
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      a(this.i);
    }
  }
  
  void a(Month paramMonth)
  {
    MonthsPagerAdapter localMonthsPagerAdapter = (MonthsPagerAdapter)this.m.getAdapter();
    int i3 = localMonthsPagerAdapter.a(paramMonth);
    int i4 = i3 - localMonthsPagerAdapter.a(this.i);
    int i1 = Math.abs(i4);
    int i2 = 1;
    if (i1 > 3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i4 <= 0) {
      i2 = 0;
    }
    this.i = paramMonth;
    if ((i1 != 0) && (i2 != 0))
    {
      this.m.scrollToPosition(i3 - 3);
      a(i3);
      return;
    }
    if (i1 != 0)
    {
      this.m.scrollToPosition(i3 + 3);
      a(i3);
      return;
    }
    a(i3);
  }
  
  public boolean a(@NonNull OnSelectionChangedListener<S> paramOnSelectionChangedListener)
  {
    return super.a(paramOnSelectionChangedListener);
  }
  
  @Nullable
  CalendarConstraints b()
  {
    return this.h;
  }
  
  @Nullable
  public DateSelector<S> c()
  {
    return this.g;
  }
  
  CalendarStyle d()
  {
    return this.k;
  }
  
  void e()
  {
    if (this.j == MaterialCalendar.CalendarSelector.YEAR)
    {
      a(MaterialCalendar.CalendarSelector.DAY);
      return;
    }
    if (this.j == MaterialCalendar.CalendarSelector.DAY) {
      a(MaterialCalendar.CalendarSelector.YEAR);
    }
  }
  
  @NonNull
  LinearLayoutManager f()
  {
    return (LinearLayoutManager)this.m.getLayoutManager();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.f = localBundle.getInt("THEME_RES_ID_KEY");
    this.g = ((DateSelector)localBundle.getParcelable("GRID_SELECTOR_KEY"));
    this.h = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.i = ((Month)localBundle.getParcelable("CURRENT_MONTH_KEY"));
  }
  
  @NonNull
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = new ContextThemeWrapper(getContext(), this.f);
    this.k = new CalendarStyle(paramBundle);
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramBundle);
    Object localObject = this.h.b();
    int i2;
    if (MaterialDatePicker.a(paramBundle))
    {
      i1 = R.layout.x;
      i2 = 1;
    }
    else
    {
      i1 = R.layout.v;
      i2 = 0;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i1, paramViewGroup, false);
    paramViewGroup = (GridView)paramLayoutInflater.findViewById(R.id.J);
    ViewCompat.setAccessibilityDelegate(paramViewGroup, new MaterialCalendar.1(this));
    paramViewGroup.setAdapter(new DaysOfWeekAdapter());
    paramViewGroup.setNumColumns(((Month)localObject).c);
    paramViewGroup.setEnabled(false);
    this.m = ((RecyclerView)paramLayoutInflater.findViewById(R.id.M));
    paramViewGroup = new MaterialCalendar.2(this, getContext(), i2, false, i2);
    this.m.setLayoutManager(paramViewGroup);
    this.m.setTag(a);
    paramViewGroup = new MonthsPagerAdapter(paramBundle, this.g, this.h, new MaterialCalendar.3(this));
    this.m.setAdapter(paramViewGroup);
    int i1 = paramBundle.getResources().getInteger(R.integer.b);
    this.l = ((RecyclerView)paramLayoutInflater.findViewById(R.id.N));
    localObject = this.l;
    if (localObject != null)
    {
      ((RecyclerView)localObject).setHasFixedSize(true);
      this.l.setLayoutManager(new GridLayoutManager(paramBundle, i1, 1, false));
      this.l.setAdapter(new YearGridAdapter(this));
      this.l.addItemDecoration(h());
    }
    if (paramLayoutInflater.findViewById(R.id.D) != null) {
      a(paramLayoutInflater, paramViewGroup);
    }
    if (!MaterialDatePicker.a(paramBundle)) {
      new PagerSnapHelper().attachToRecyclerView(this.m);
    }
    this.m.scrollToPosition(paramViewGroup.a(this.i));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.f);
    paramBundle.putParcelable("GRID_SELECTOR_KEY", this.g);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.h);
    paramBundle.putParcelable("CURRENT_MONTH_KEY", this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar
 * JD-Core Version:    0.7.0.1
 */