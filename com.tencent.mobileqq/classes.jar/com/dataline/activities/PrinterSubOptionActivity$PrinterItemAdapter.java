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
    PrinterSubOptionActivity localPrinterSubOptionActivity = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity;
    return new PrinterSubOptionActivity.CloudPrinter(localPrinterSubOptionActivity, 1, 0L, localPrinterSubOptionActivity.jdField_a_of_type_JavaLangString);
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
    int i = getItemViewType(paramInt);
    TextView localTextView = null;
    if (i == 0)
    {
      Object localObject = (PrinterSubOptionActivity.CloudPrinter)getItem(paramInt);
      if (((PrinterSubOptionActivity.CloudPrinter)localObject).jdField_a_of_type_Int == 1)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559574, null);
        localTextView = (TextView)paramView.findViewById(2131378475);
      }
      else if (((PrinterSubOptionActivity.CloudPrinter)localObject).jdField_a_of_type_Int == 2)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559575, null);
        localObject = paramView.findViewById(2131364361);
        localTextView = (TextView)paramView.findViewById(2131364362);
        ((View)localObject).setClickable(true);
        ((View)localObject).setEnabled(true);
        ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559037, null);
      paramView.findViewById(2131370178).setVisibility(8);
      localTextView = (TextView)paramView.findViewById(2131370179);
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