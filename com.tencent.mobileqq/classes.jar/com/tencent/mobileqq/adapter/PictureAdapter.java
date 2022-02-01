package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class PictureAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public PictureAdapter(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.endsWith("video=1");
  }
  
  public boolean a(List<String> paramList)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (paramList == localList) {
      return true;
    }
    if (paramList != null)
    {
      if (localList == null) {
        return false;
      }
      if (paramList.size() != this.jdField_a_of_type_JavaUtilList.size()) {
        return false;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (!((String)paramList.get(i)).equals(this.jdField_a_of_type_JavaUtilList.get(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return Math.min(localList.size(), 4);
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt < 4)) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt < 4)) {
      return paramInt;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PictureAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new PictureAdapter.ViewHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558832, null);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131377638));
      localViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368822);
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (PictureAdapter.ViewHolder)paramView.getTag();
    }
    String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.post(new PictureAdapter.1(this, localViewHolder, str));
    if ((!this.jdField_a_of_type_Boolean) && (a(str))) {
      localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PictureAdapter
 * JD-Core Version:    0.7.0.1
 */