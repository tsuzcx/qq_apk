package com.dataline.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cp;
import cq;
import java.util.List;

public class PrinterSubOptionActivity$PrinterItemAdapter
  extends BaseAdapter
{
  private View.OnClickListener a;
  
  public PrinterSubOptionActivity$PrinterItemAdapter(PrinterSubOptionActivity paramPrinterSubOptionActivity)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new cq(this);
  }
  
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
    return new cp(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity, 1, 0L, this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaLangString);
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
    String str = ((cp)getItem(paramInt)).jdField_a_of_type_JavaLangString;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = (cp)getItem(paramInt);
      if (paramViewGroup.jdField_a_of_type_Int == 1)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969190, null);
        paramViewGroup = (TextView)paramView.findViewById(2131365558);
      }
    }
    for (;;)
    {
      if (paramViewGroup != null)
      {
        paramViewGroup.setText(str);
        paramViewGroup.setTag(Integer.valueOf(paramInt));
      }
      return paramView;
      if (paramViewGroup.jdField_a_of_type_Int == 2)
      {
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969191, null);
        View localView = paramView.findViewById(2131365560);
        paramViewGroup = (TextView)paramView.findViewById(2131365561);
        localView.setClickable(true);
        localView.setEnabled(true);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        continue;
        paramView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968905, null);
        paramView.findViewById(2131364223).setVisibility(8);
        paramViewGroup = (TextView)paramView.findViewById(2131364224);
        paramViewGroup.setTextSize(19.0F);
        paramViewGroup.setTextColor(-16777216);
      }
      else
      {
        paramViewGroup = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter
 * JD-Core Version:    0.7.0.1
 */