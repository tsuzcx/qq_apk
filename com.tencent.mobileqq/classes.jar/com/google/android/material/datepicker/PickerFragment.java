package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class PickerFragment<S>
  extends Fragment
{
  protected final LinkedHashSet<OnSelectionChangedListener<S>> a = new LinkedHashSet();
  
  boolean a(OnSelectionChangedListener<S> paramOnSelectionChangedListener)
  {
    return this.a.add(paramOnSelectionChangedListener);
  }
  
  void b()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.PickerFragment
 * JD-Core Version:    0.7.0.1
 */