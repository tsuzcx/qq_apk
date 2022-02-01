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
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PrinterSubOptionActivity.PrinterItemAdapter.1(this);
  
  public PrinterSubOptionActivity$PrinterItemAdapter(PrinterSubOptionActivity paramPrinterSubOptionActivity) {}
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b != null) && (this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size() > 0)) {
      return this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size();
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b != null) && (paramInt < this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size())) {
      return this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.get(paramInt);
    }
    return new PrinterSubOptionActivity.CloudPrinter(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity, 1, 0L, this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaLangString);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b != null) && (this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.b.size() > 0)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = ((PrinterSubOptionActivity.CloudPrinter)getItem(paramInt)).jdField_a_of_type_JavaLangString;
    Object localObject;
    if (getItemViewType(paramInt) == 0)
    {
      localObject = (PrinterSubOptionActivity.CloudPrinter)getItem(paramInt);
      if (((PrinterSubOptionActivity.CloudPrinter)localObject).jdField_a_of_type_Int == 1)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559698, null);
        localObject = (TextView)paramView.findViewById(2131379105);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setTag(Integer.valueOf(paramInt));
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (((PrinterSubOptionActivity.CloudPrinter)localObject).jdField_a_of_type_Int == 2)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559699, null);
        View localView = paramView.findViewById(2131364471);
        localObject = (TextView)paramView.findViewById(2131364472);
        localView.setClickable(true);
        localView.setEnabled(true);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        continue;
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559143, null);
        paramView.findViewById(2131370518).setVisibility(8);
        localObject = (TextView)paramView.findViewById(2131370519);
        ((TextView)localObject).setTextSize(19.0F);
        ((TextView)localObject).setTextColor(-16777216);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter
 * JD-Core Version:    0.7.0.1
 */