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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new FilterAdapter.ViewHolder(this, null);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562067, null, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368918));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368917));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380764));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380765));
      localView.setTag(paramView);
      localObject = (FilterAdapter.FilterItemContent)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(((FilterAdapter.FilterItemContent)localObject).jdField_a_of_type_AndroidGraphicsBitmap);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((FilterAdapter.FilterItemContent)localObject).b);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((FilterAdapter.FilterItemContent)localObject).jdField_a_of_type_Int + HardCodeUtil.a(2131704624));
      if (!((FilterAdapter.FilterItemContent)localObject).jdField_a_of_type_Boolean) {
        break label224;
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839335));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (FilterAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label224:
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839337));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.FilterAdapter
 * JD-Core Version:    0.7.0.1
 */