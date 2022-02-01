package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FilterAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<FilterAdapter.FilterItemContent> jdField_a_of_type_JavaUtilList;
  
  public FilterAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(List<FilterAdapter.FilterItemContent> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
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
    FilterAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new FilterAdapter.ViewHolder(this, null);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561902, null, false);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368644));
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368643));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380029));
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380030));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (FilterAdapter.ViewHolder)paramView.getTag();
    }
    FilterAdapter.FilterItemContent localFilterItemContent = (FilterAdapter.FilterItemContent)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localFilterItemContent.jdField_a_of_type_AndroidGraphicsBitmap);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFilterItemContent.b);
    TextView localTextView = localViewHolder.jdField_b_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFilterItemContent.jdField_a_of_type_Int);
    localStringBuilder.append(HardCodeUtil.a(2131704704));
    localTextView.setText(localStringBuilder.toString());
    if (localFilterItemContent.jdField_a_of_type_Boolean) {
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839190));
    } else {
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839192));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.FilterAdapter
 * JD-Core Version:    0.7.0.1
 */