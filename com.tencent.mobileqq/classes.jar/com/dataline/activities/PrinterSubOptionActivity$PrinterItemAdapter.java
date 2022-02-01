package com.dataline.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class PrinterSubOptionActivity$PrinterItemAdapter
  extends BaseAdapter
{
  private View.OnClickListener b = new PrinterSubOptionActivity.PrinterItemAdapter.1(this);
  
  public PrinterSubOptionActivity$PrinterItemAdapter(PrinterSubOptionActivity paramPrinterSubOptionActivity) {}
  
  public int getCount()
  {
    if ((this.a.h != null) && (this.a.h.size() > 0)) {
      return this.a.h.size();
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a.h != null) && (paramInt < this.a.h.size())) {
      return this.a.h.get(paramInt);
    }
    PrinterSubOptionActivity localPrinterSubOptionActivity = this.a;
    return new PrinterSubOptionActivity.CloudPrinter(localPrinterSubOptionActivity, 1, 0L, localPrinterSubOptionActivity.e);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a.h != null) && (this.a.h.size() > 0)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = ((PrinterSubOptionActivity.CloudPrinter)getItem(paramInt)).b;
    int i = getItemViewType(paramInt);
    TextView localTextView = null;
    if (i == 0)
    {
      Object localObject = (PrinterSubOptionActivity.CloudPrinter)getItem(paramInt);
      if (((PrinterSubOptionActivity.CloudPrinter)localObject).c == 1)
      {
        paramView = this.a.d.inflate(2131625602, null);
        localTextView = (TextView)paramView.findViewById(2131447089);
      }
      else if (((PrinterSubOptionActivity.CloudPrinter)localObject).c == 2)
      {
        paramView = this.a.d.inflate(2131625603, null);
        localObject = paramView.findViewById(2131430389);
        localTextView = (TextView)paramView.findViewById(2131430390);
        ((View)localObject).setClickable(true);
        ((View)localObject).setEnabled(true);
        ((View)localObject).setOnClickListener(this.b);
      }
    }
    else
    {
      paramView = this.a.d.inflate(2131624671, null);
      paramView.findViewById(2131437344).setVisibility(8);
      localTextView = (TextView)paramView.findViewById(2131437345);
      localTextView.setTextSize(19.0F);
      localTextView.setTextColor(-16777216);
    }
    if (localTextView != null)
    {
      localTextView.setText(str);
      localTextView.setTag(Integer.valueOf(paramInt));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter
 * JD-Core Version:    0.7.0.1
 */