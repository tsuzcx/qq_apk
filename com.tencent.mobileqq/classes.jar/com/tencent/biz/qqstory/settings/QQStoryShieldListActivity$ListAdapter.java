package com.tencent.biz.qqstory.settings;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class QQStoryShieldListActivity$ListAdapter
  extends BaseAdapter
{
  List<QQStoryUserInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public QQStoryShieldListActivity$ListAdapter(List<QQStoryUserInfo> paramList)
  {
    Collection localCollection;
    if (localCollection != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(localCollection);
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(List<QQStoryUserInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity).inflate(2131561925, null);
      paramView = new QQStoryShieldListActivity.ListAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366520));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372115));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a.widthPixels - AIOUtils.a(175.0F, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.getResources()));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365656));
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity);
      localView.setTag(paramView);
      localObject = (QQStoryUserInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_JavaLangString = ((QQStoryUserInfo)localObject).uin;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((QQStoryUserInfo)localObject).nick);
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(localObject);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        break label289;
      }
      if (paramInt != 0) {
        break label254;
      }
      localView.setBackgroundResource(2130839591);
      label186:
      localObject = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.app.getFaceBitmap(((QQStoryUserInfo)localObject).uin, true);
      if (localObject == null) {
        break label349;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (QQStoryShieldListActivity.ListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label254:
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        localView.setBackgroundResource(2130839582);
        break label186;
      }
      localView.setBackgroundResource(2130839585);
      break label186;
      label289:
      if (this.jdField_a_of_type_JavaUtilList.size() == 2)
      {
        if (paramInt == 0)
        {
          localView.setBackgroundResource(2130839591);
          break label186;
        }
        localView.setBackgroundResource(2130839582);
        break label186;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label186;
      }
      localView.setBackgroundResource(2130839582);
      break label186;
      label349:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */