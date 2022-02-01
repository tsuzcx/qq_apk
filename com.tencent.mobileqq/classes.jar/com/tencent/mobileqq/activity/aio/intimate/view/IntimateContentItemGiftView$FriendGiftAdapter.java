package com.tencent.mobileqq.activity.aio.intimate.view;

import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class IntimateContentItemGiftView$FriendGiftAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private IntimateContentItemGiftView$FriendGiftAdapter(IntimateContentItemGiftView paramIntimateContentItemGiftView) {}
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ((ViewUtils.a() - ViewUtils.a(40.0F) - 80) / ViewUtils.a(60.0F));
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "gif mark max count: " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = 5;
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @RequiresApi(api=16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView.a).inflate(2131559394, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131367580);
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(str, null);
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.z);
        localImageView.setImageDrawable(localURLDrawable);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 1, String.format("Url for friend gift:" + str, new Object[] { localException }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemGiftView.FriendGiftAdapter
 * JD-Core Version:    0.7.0.1
 */