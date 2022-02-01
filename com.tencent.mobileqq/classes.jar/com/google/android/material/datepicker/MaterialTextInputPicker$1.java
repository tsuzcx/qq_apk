package com.google.android.material.datepicker;

import java.util.Iterator;
import java.util.LinkedHashSet;

class MaterialTextInputPicker$1
  extends OnSelectionChangedListener<S>
{
  MaterialTextInputPicker$1(MaterialTextInputPicker paramMaterialTextInputPicker) {}
  
  public void a()
  {
    Iterator localIterator = this.a.e.iterator();
    while (localIterator.hasNext()) {
      ((OnSelectionChangedListener)localIterator.next()).a();
    }
  }
  
  public void a(S paramS)
  {
    Iterator localIterator = this.a.e.iterator();
    while (localIterator.hasNext()) {
      ((OnSelectionChangedListener)localIterator.next()).a(paramS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialTextInputPicker.1
 * JD-Core Version:    0.7.0.1
 */