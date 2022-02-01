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

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S>
  extends PickerFragment<S>
{
  @VisibleForTesting
  static final Object jdField_a_of_type_JavaLangObject = "MONTHS_VIEW_GROUP_TAG";
  @VisibleForTesting
  static final Object jdField_b_of_type_JavaLangObject = "NAVIGATION_PREV_TAG";
  @VisibleForTesting
  static final Object c = "NAVIGATION_NEXT_TAG";
  @VisibleForTesting
  static final Object d = "SELECTOR_TOGGLE_TAG";
  @StyleRes
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  @Nullable
  private CalendarConstraints jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints;
  private CalendarStyle jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle;
  @Nullable
  private DateSelector<S> jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
  private MaterialCalendar.CalendarSelector jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar$CalendarSelector;
  @Nullable
  private Month jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth;
  private View jdField_b_of_type_AndroidViewView;
  private RecyclerView jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  
  @Px
  static int a(@NonNull Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(R.dimen.R);
  }
  
  @NonNull
  private RecyclerView.ItemDecoration a()
  {
    return new MaterialCalendar.4(this);
  }
  
  @NonNull
  public static <T> MaterialCalendar<T> a(@NonNull DateSelector<T> paramDateSelector, @StyleRes int paramInt, @NonNull CalendarConstraints paramCalendarConstraints)
  {
    MaterialCalendar localMaterialCalendar = new MaterialCalendar();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("GRID_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localBundle.putParcelable("CURRENT_MONTH_KEY", paramCalendarConstraints.c());
    localMaterialCalendar.setArguments(localBundle);
    return localMaterialCalendar;
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.post(new MaterialCalendar.10(this, paramInt));
  }
  
  private void a(@NonNull View paramView, @NonNull MonthsPagerAdapter paramMonthsPagerAdapter)
  {
    MaterialButton localMaterialButton1 = (MaterialButton)paramView.findViewById(R.id.D);
    localMaterialButton1.setTag(d);
    ViewCompat.setAccessibilityDelegate(localMaterialButton1, new MaterialCalendar.5(this));
    MaterialButton localMaterialButton2 = (MaterialButton)paramView.findViewById(R.id.F);
    localMaterialButton2.setTag(jdField_b_of_type_JavaLangObject);
    MaterialButton localMaterialButton3 = (MaterialButton)paramView.findViewById(R.id.E);
    localMaterialButton3.setTag(c);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(R.id.N);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(R.id.I);
    a(MaterialCalendar.CalendarSelector.DAY);
    localMaterialButton1.setText(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a(paramView.getContext()));
    this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.addOnScrollListener(new MaterialCalendar.6(this, paramMonthsPagerAdapter, localMaterialButton1));
    localMaterialButton1.setOnClickListener(new MaterialCalendar.7(this));
    localMaterialButton3.setOnClickListener(new MaterialCalendar.8(this, paramMonthsPagerAdapter));
    localMaterialButton2.setOnClickListener(new MaterialCalendar.9(this, paramMonthsPagerAdapter));
  }
  
  @NonNull
  LinearLayoutManager a()
  {
    return (LinearLayoutManager)this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.getLayoutManager();
  }
  
  @Nullable
  CalendarConstraints a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints;
  }
  
  CalendarStyle a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle;
  }
  
  @Nullable
  public DateSelector<S> a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
  }
  
  @Nullable
  Month a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar$CalendarSelector == MaterialCalendar.CalendarSelector.YEAR)
    {
      a(MaterialCalendar.CalendarSelector.DAY);
      return;
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar$CalendarSelector == MaterialCalendar.CalendarSelector.DAY) {
      a(MaterialCalendar.CalendarSelector.YEAR);
    }
  }
  
  void a(MaterialCalendar.CalendarSelector paramCalendarSelector)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar$CalendarSelector = paramCalendarSelector;
    if (paramCalendarSelector == MaterialCalendar.CalendarSelector.YEAR)
    {
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.getLayoutManager().scrollToPosition(((YearGridAdapter)this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.getAdapter()).a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.b));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (paramCalendarSelector == MaterialCalendar.CalendarSelector.DAY)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth);
    }
  }
  
  void a(Month paramMonth)
  {
    MonthsPagerAdapter localMonthsPagerAdapter = (MonthsPagerAdapter)this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.getAdapter();
    int k = localMonthsPagerAdapter.a(paramMonth);
    int m = k - localMonthsPagerAdapter.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth);
    int i = Math.abs(m);
    int j = 1;
    if (i > 3) {
      i = 1;
    } else {
      i = 0;
    }
    if (m <= 0) {
      j = 0;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth = paramMonth;
    if ((i != 0) && (j != 0))
    {
      this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.scrollToPosition(k - 3);
      a(k);
      return;
    }
    if (i != 0)
    {
      this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.scrollToPosition(k + 3);
      a(k);
      return;
    }
    a(k);
  }
  
  public boolean a(@NonNull OnSelectionChangedListener<S> paramOnSelectionChangedListener)
  {
    return super.a(paramOnSelectionChangedListener);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.jdField_a_of_type_Int = localBundle.getInt("THEME_RES_ID_KEY");
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector = ((DateSelector)localBundle.getParcelable("GRID_SELECTOR_KEY"));
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth = ((Month)localBundle.getParcelable("CURRENT_MONTH_KEY"));
  }
  
  @NonNull
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = new ContextThemeWrapper(getContext(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle = new CalendarStyle(paramBundle);
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramBundle);
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a();
    int j;
    if (MaterialDatePicker.a(paramBundle))
    {
      i = R.layout.x;
      j = 1;
    }
    else
    {
      i = R.layout.v;
      j = 0;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup, false);
    paramViewGroup = (GridView)paramLayoutInflater.findViewById(R.id.J);
    ViewCompat.setAccessibilityDelegate(paramViewGroup, new MaterialCalendar.1(this));
    paramViewGroup.setAdapter(new DaysOfWeekAdapter());
    paramViewGroup.setNumColumns(((Month)localObject).c);
    paramViewGroup.setEnabled(false);
    this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)paramLayoutInflater.findViewById(R.id.M));
    paramViewGroup = new MaterialCalendar.2(this, getContext(), j, false, j);
    this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(paramViewGroup);
    this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.setTag(jdField_a_of_type_JavaLangObject);
    paramViewGroup = new MonthsPagerAdapter(paramBundle, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints, new MaterialCalendar.3(this));
    this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(paramViewGroup);
    int i = paramBundle.getResources().getInteger(R.integer.b);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)paramLayoutInflater.findViewById(R.id.N));
    localObject = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
    if (localObject != null)
    {
      ((RecyclerView)localObject).setHasFixedSize(true);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(new GridLayoutManager(paramBundle, i, 1, false));
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(new YearGridAdapter(this));
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.addItemDecoration(a());
    }
    if (paramLayoutInflater.findViewById(R.id.D) != null) {
      a(paramLayoutInflater, paramViewGroup);
    }
    if (!MaterialDatePicker.a(paramBundle)) {
      new PagerSnapHelper().attachToRecyclerView(this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView);
    }
    this.jdField_b_of_type_AndroidxRecyclerviewWidgetRecyclerView.scrollToPosition(paramViewGroup.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth));
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.jdField_a_of_type_Int);
    paramBundle.putParcelable("GRID_SELECTOR_KEY", this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints);
    paramBundle.putParcelable("CURRENT_MONTH_KEY", this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar
 * JD-Core Version:    0.7.0.1
 */