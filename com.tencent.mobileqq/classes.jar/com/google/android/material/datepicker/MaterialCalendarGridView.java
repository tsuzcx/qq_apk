package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.id;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

final class MaterialCalendarGridView
  extends GridView
{
  private final Calendar jdField_a_of_type_JavaUtilCalendar = UtcDates.b();
  private final boolean jdField_a_of_type_Boolean;
  
  public MaterialCalendarGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (MaterialDatePicker.a(getContext()))
    {
      setNextFocusLeftId(R.id.a);
      setNextFocusRightId(R.id.c);
    }
    this.jdField_a_of_type_Boolean = MaterialDatePicker.b(getContext());
    ViewCompat.setAccessibilityDelegate(this, new MaterialCalendarGridView.1(this));
  }
  
  private static int a(@NonNull View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private void a(int paramInt, Rect paramRect)
  {
    if (paramInt == 33)
    {
      setSelection(a().b());
      return;
    }
    if (paramInt == 130)
    {
      setSelection(a().a());
      return;
    }
    super.onFocusChanged(true, paramInt, paramRect);
  }
  
  private static boolean a(@Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Long paramLong4)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramLong1 != null)
    {
      bool1 = bool2;
      if (paramLong2 != null)
      {
        bool1 = bool2;
        if (paramLong3 != null)
        {
          if (paramLong4 == null) {
            return true;
          }
          bool1 = bool2;
          if (paramLong3.longValue() <= paramLong2.longValue())
          {
            if (paramLong4.longValue() < paramLong1.longValue()) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  @NonNull
  public MonthAdapter a()
  {
    return (MonthAdapter)super.getAdapter();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a().notifyDataSetChanged();
  }
  
  protected final void onDraw(@NonNull Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = a();
    Object localObject2 = ((MonthAdapter)localObject1).jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
    CalendarStyle localCalendarStyle = ((MonthAdapter)localObject1).jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle;
    Long localLong1 = ((MonthAdapter)localObject1).a(((MonthAdapter)localObject1).a());
    Long localLong2 = ((MonthAdapter)localObject1).a(((MonthAdapter)localObject1).b());
    Iterator localIterator = ((DateSelector)localObject2).b().iterator();
    for (;;)
    {
      MaterialCalendarGridView localMaterialCalendarGridView = this;
      if (!localIterator.hasNext()) {
        break;
      }
      Pair localPair = (Pair)localIterator.next();
      localObject2 = localObject1;
      if (localPair.first != null)
      {
        if (localPair.second != null)
        {
          long l1 = ((Long)localPair.first).longValue();
          long l2 = ((Long)localPair.second).longValue();
          if (!a(localLong1, localLong2, Long.valueOf(l1), Long.valueOf(l2)))
          {
            boolean bool = ViewUtils.a(this);
            int n;
            int i;
            if (l1 < localLong1.longValue())
            {
              n = ((MonthAdapter)localObject1).a();
              if (((MonthAdapter)localObject1).b(n)) {
                i = 0;
              } else if (!bool) {
                i = localMaterialCalendarGridView.getChildAt(n - 1).getRight();
              } else {
                i = localMaterialCalendarGridView.getChildAt(n - 1).getLeft();
              }
            }
            else
            {
              localMaterialCalendarGridView.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(l1);
              n = ((MonthAdapter)localObject1).b(localMaterialCalendarGridView.jdField_a_of_type_JavaUtilCalendar.get(5));
              i = a(localMaterialCalendarGridView.getChildAt(n));
            }
            int i1;
            int j;
            if (l2 > localLong2.longValue())
            {
              i1 = Math.min(((MonthAdapter)localObject1).b(), getChildCount() - 1);
              if (((MonthAdapter)localObject1).c(i1)) {
                j = getWidth();
              } else if (!bool) {
                j = localMaterialCalendarGridView.getChildAt(i1).getRight();
              } else {
                j = localMaterialCalendarGridView.getChildAt(i1).getLeft();
              }
            }
            else
            {
              localMaterialCalendarGridView.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(l2);
              i1 = ((MonthAdapter)localObject1).b(localMaterialCalendarGridView.jdField_a_of_type_JavaUtilCalendar.get(5));
              j = a(localMaterialCalendarGridView.getChildAt(i1));
            }
            int i2 = (int)((MonthAdapter)localObject1).getItemId(n);
            int i4 = (int)((MonthAdapter)localObject1).getItemId(i1);
            for (;;)
            {
              localObject2 = localObject1;
              if (i2 > i4) {
                break;
              }
              int m = getNumColumns() * i2;
              int i3 = getNumColumns() + m - 1;
              localObject2 = getChildAt(m);
              int i5 = ((View)localObject2).getTop();
              int i6 = localCalendarStyle.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarItemStyle.a();
              int i7 = ((View)localObject2).getBottom();
              int i8 = localCalendarStyle.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarItemStyle.b();
              int k;
              if (!bool)
              {
                if (m > n) {
                  k = 0;
                } else {
                  k = i;
                }
                if (i1 > i3)
                {
                  i3 = getWidth();
                  m = k;
                  k = i3;
                }
                else
                {
                  i3 = j;
                  m = k;
                  k = i3;
                }
              }
              else
              {
                if (i1 > i3) {
                  k = 0;
                } else {
                  k = j;
                }
                if (m > n) {
                  m = getWidth();
                } else {
                  m = i;
                }
                i3 = k;
                k = m;
                m = i3;
              }
              paramCanvas.drawRect(m, i5 + i6, k, i7 - i8, localCalendarStyle.jdField_a_of_type_AndroidGraphicsPaint);
              i2 += 1;
            }
          }
        }
      }
      else {
        localObject1 = localObject2;
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean)
    {
      a(paramInt, paramRect);
      return;
    }
    super.onFocusChanged(false, paramInt, paramRect);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!super.onKeyDown(paramInt, paramKeyEvent)) {
      return false;
    }
    if (getSelectedItemPosition() != -1)
    {
      if (getSelectedItemPosition() >= a().a()) {
        return true;
      }
      if (19 == paramInt)
      {
        setSelection(a().a());
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(16777215, -2147483648));
      getLayoutParams().height = getMeasuredHeight();
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof MonthAdapter))
    {
      super.setAdapter(paramListAdapter);
      return;
    }
    throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[] { MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName() }));
  }
  
  public void setSelection(int paramInt)
  {
    if (paramInt < a().a())
    {
      super.setSelection(a().a());
      return;
    }
    super.setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendarGridView
 * JD-Core Version:    0.7.0.1
 */