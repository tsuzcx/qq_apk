package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class MultiPicker$ListViewAdapter$1
  implements View.OnClickListener
{
  MultiPicker$ListViewAdapter$1(MultiPicker.ListViewAdapter paramListViewAdapter, int paramInt, h paramh) {}
  
  public void onClick(View paramView)
  {
    if (MultiPicker.c(this.c.a) != null) {
      MultiPicker.c(this.c.a).a(MultiPicker.b(this.c.a).getItem(this.a), this.a);
    }
    if (!this.b.f())
    {
      if (((Boolean)MultiPicker.ListViewAdapter.a(this.c).get(Integer.valueOf(this.a))).booleanValue()) {
        MultiPicker.ListViewAdapter.a(this.c).put(Integer.valueOf(this.a), Boolean.valueOf(false));
      } else {
        MultiPicker.ListViewAdapter.a(this.c).put(Integer.valueOf(this.a), Boolean.valueOf(true));
      }
      MultiPicker.ListViewAdapter localListViewAdapter = this.c;
      localListViewAdapter.setIsSelected(MultiPicker.ListViewAdapter.a(localListViewAdapter));
      this.c.notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MultiPicker.ListViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */