package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PlusPanelAdapter
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<PluginData> jdField_a_of_type_JavaUtilArrayList;
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.size();
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
    Object localObject1 = BaseApplication.getContext();
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131558842, null);
      paramView = new PlusPanelAdapter.ViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368487));
      paramView.b = ((ImageView)((View)localObject1).findViewById(2131366954));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378476));
      ((View)localObject1).setTag(paramView);
    }
    else
    {
      localObject2 = (PlusPanelAdapter.ViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    Object localObject2 = (PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((PluginData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((PluginData)localObject2).jdField_a_of_type_JavaLangString);
    if (((PluginData)localObject2).jdField_a_of_type_Boolean) {
      paramView.b.setVisibility(0);
    } else {
      paramView.b.setVisibility(8);
    }
    paramView.jdField_a_of_type_Int = ((PluginData)localObject2).jdField_a_of_type_Int;
    ((View)localObject1).setContentDescription(((PluginData)localObject2).b);
    ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanelAdapter
 * JD-Core Version:    0.7.0.1
 */