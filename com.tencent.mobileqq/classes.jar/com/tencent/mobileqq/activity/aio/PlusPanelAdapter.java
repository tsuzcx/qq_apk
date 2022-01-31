package com.tencent.mobileqq.activity.aio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class PlusPanelAdapter
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = BaseApplication.getContext();
    PlusPanel.PluginData localPluginData;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup).inflate(2130968772, null);
      paramViewGroup = new PlusPanelAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363701));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131363702));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362961));
      paramView.setTag(paramViewGroup);
      localPluginData = (PlusPanel.PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPluginData.jdField_a_of_type_JavaLangString);
      if (!localPluginData.jdField_a_of_type_Boolean) {
        break label163;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = localPluginData.jdField_a_of_type_Int;
      paramView.setContentDescription(localPluginData.b);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (PlusPanelAdapter.ViewHolder)paramView.getTag();
      break;
      label163:
      paramViewGroup.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanelAdapter
 * JD-Core Version:    0.7.0.1
 */