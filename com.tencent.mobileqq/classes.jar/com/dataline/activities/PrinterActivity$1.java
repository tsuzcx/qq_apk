package com.dataline.activities;

import android.view.View;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

class PrinterActivity$1
  implements OverScrollViewListener
{
  PrinterActivity$1(PrinterActivity paramPrinterActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    paramInt = PrinterActivity.a(this.a).e.b();
    if (paramInt > 0)
    {
      PrinterActivity.a(this.a).e.i.d();
      this.a.c.setSelectionFromBottom(paramInt, 0);
      PrinterActivity.a(this.a).e.i.notifyDataSetChanged();
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterActivity.1
 * JD-Core Version:    0.7.0.1
 */