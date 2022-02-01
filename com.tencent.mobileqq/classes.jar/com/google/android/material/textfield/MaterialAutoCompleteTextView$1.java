package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import androidx.appcompat.widget.ListPopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MaterialAutoCompleteTextView$1
  implements AdapterView.OnItemClickListener
{
  MaterialAutoCompleteTextView$1(MaterialAutoCompleteTextView paramMaterialAutoCompleteTextView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < 0) {
      localObject = MaterialAutoCompleteTextView.a(this.a).getSelectedItem();
    } else {
      localObject = this.a.getAdapter().getItem(paramInt);
    }
    MaterialAutoCompleteTextView.a(this.a, localObject);
    AdapterView.OnItemClickListener localOnItemClickListener = this.a.getOnItemClickListener();
    Object localObject = paramView;
    int i = paramInt;
    long l = paramLong;
    if (localOnItemClickListener != null)
    {
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
      localOnItemClickListener.onItemClick(MaterialAutoCompleteTextView.a(this.a).getListView(), paramView, i, paramLong);
      l = paramLong;
      localObject = paramView;
    }
    MaterialAutoCompleteTextView.a(this.a).dismiss();
    EventCollector.getInstance().onItemClick(paramAdapterView, (View)localObject, i, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.MaterialAutoCompleteTextView.1
 * JD-Core Version:    0.7.0.1
 */