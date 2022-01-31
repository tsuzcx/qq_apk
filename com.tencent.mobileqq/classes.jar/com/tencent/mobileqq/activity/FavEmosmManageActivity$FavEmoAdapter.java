package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class FavEmosmManageActivity$FavEmoAdapter
  extends BaseAdapter
{
  float jdField_a_of_type_Float;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public List a;
  
  public FavEmosmManageActivity$FavEmoAdapter(FavEmosmManageActivity paramFavEmosmManageActivity, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramFavEmosmManageActivity.getLayoutInflater();
    this.jdField_a_of_type_Float = paramFavEmosmManageActivity.getApplicationContext().getResources().getDisplayMetrics().density;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
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
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968965, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.b));
      paramViewGroup = new FavEmosmManageActivity.FavEmoAdapter.Holder(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364485));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364487));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364486);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.getApplicationContext(), this.jdField_a_of_type_Float));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        if (((Byte)this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).byteValue() != 0) {
          break;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return paramView;
      paramViewGroup = (FavEmosmManageActivity.FavEmoAdapter.Holder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity.FavEmoAdapter
 * JD-Core Version:    0.7.0.1
 */