package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import wmd;

public class FilterAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  
  public FilterAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
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
    if (paramView == null)
    {
      paramViewGroup = new wmd(this, null);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970904, null, false);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372159));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372160));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372161));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372162));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      FilterAdapter.FilterItemContent localFilterItemContent = (FilterAdapter.FilterItemContent)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localFilterItemContent.jdField_a_of_type_AndroidGraphicsBitmap);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFilterItemContent.b);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localFilterItemContent.jdField_a_of_type_Int + "个表情");
      if (!localFilterItemContent.jdField_a_of_type_Boolean) {
        break;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838428));
      return paramView;
      paramViewGroup = (wmd)paramView.getTag();
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838430));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.FilterAdapter
 * JD-Core Version:    0.7.0.1
 */