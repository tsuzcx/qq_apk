package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;

class FontSettingActivity$TabListAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  
  public FontSettingActivity$TabListAdapter(FontSettingActivity paramFontSettingActivity, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramFontSettingActivity.getLayoutInflater();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562910, paramViewGroup, false);
    FontSettingActivity.RecentData localRecentData = (FontSettingActivity.RecentData)this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368603);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(localRecentData.jdField_b_of_type_Int, localRecentData.d));
    ((TextView)paramView.findViewById(16908308)).setText(localRecentData.jdField_a_of_type_JavaLangString);
    ((TextView)paramView.findViewById(16908309)).setText(localRecentData.jdField_b_of_type_JavaLangString);
    ((TextView)paramView.findViewById(2131370043)).setText(localRecentData.c);
    FontSettingActivity.TabListAdapter.ViewHolder localViewHolder = new FontSettingActivity.TabListAdapter.ViewHolder(this);
    localViewHolder.jdField_a_of_type_JavaLangString = localRecentData.d;
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$RecentData = localRecentData;
    paramView.setTag(localViewHolder);
    if ((FontSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity)) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.size() - 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.a();
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject1 = null;
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_ComTencentWidgetListView.getChildCount();
    Object localObject2;
    if (paramBitmap != null)
    {
      paramInt1 = 0;
      if (paramInt1 >= paramInt2) {
        break label105;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag();
      if ((localObject2 == null) || (!(localObject2 instanceof FontSettingActivity.TabListAdapter.ViewHolder))) {
        break label98;
      }
      localObject2 = (FontSettingActivity.TabListAdapter.ViewHolder)localObject2;
      localObject1 = localObject2;
      if (!((FontSettingActivity.TabListAdapter.ViewHolder)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label98;
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        ((FontSettingActivity.TabListAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        notifyDataSetChanged();
      }
      return;
      label98:
      paramInt1 += 1;
      break;
      label105:
      localObject2 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.TabListAdapter
 * JD-Core Version:    0.7.0.1
 */