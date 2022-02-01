package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import androidx.appcompat.widget.ListPopupWindow;

class MaterialAutoCompleteTextView$1
  implements AdapterView.OnItemClickListener
{
  MaterialAutoCompleteTextView$1(MaterialAutoCompleteTextView paramMaterialAutoCompleteTextView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < 0) {
      paramAdapterView = MaterialAutoCompleteTextView.a(this.a).getSelectedItem();
    } else {
      paramAdapterView = this.a.getAdapter().getItem(paramInt);
    }
    MaterialAutoCompleteTextView.a(this.a, paramAdapterView);
    paramAdapterView = this.a.getOnItemClickListener();
    if (paramAdapterView != null)
    {
      int i;
      if (paramView != null)
      {
        i = paramInt;
        if (paramInt >= 0) {}
      }
      else
      {
        paramView = MaterialAutoCompleteTextView.a(this.a).getSelectedView();
        i = MaterialAutoCompleteTextView.a(this.a).getSelectedItemPosition();
        paramLong = MaterialAutoCompleteTextView.a(this.a).getSelectedItemId();
      }
      paramAdapterView.onItemClick(MaterialAutoCompleteTextView.a(this.a).getListView(), paramView, i, paramLong);
    }
    MaterialAutoCompleteTextView.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.MaterialAutoCompleteTextView.1
 * JD-Core Version:    0.7.0.1
 */