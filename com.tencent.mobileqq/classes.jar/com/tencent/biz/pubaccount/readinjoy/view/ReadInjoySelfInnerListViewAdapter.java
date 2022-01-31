package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule.BusinessCountInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.HorizontalListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import mjo;
import mjp;

public class ReadInjoySelfInnerListViewAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List jdField_a_of_type_JavaUtilList;
  
  public ReadInjoySelfInnerListViewAdapter(Context paramContext, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new mjo(this, paramContext));
  }
  
  private void a(SelfInfoModule.BusinessCountInfo paramBusinessCountInfo, View paramView)
  {
    mjp localmjp = (mjp)paramView.getTag();
    Object localObject = paramView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    mjp.a(localmjp).setText(paramBusinessCountInfo.a);
    mjp.b(localmjp).setText(ReadInJoyHelper.a(paramBusinessCountInfo.jdField_c_of_type_Int));
    paramView = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramView.mFailedDrawable = ((Drawable)localObject);
    paramView.mLoadingDrawable = ((Drawable)localObject);
    paramBusinessCountInfo = URLDrawable.getDrawable(paramBusinessCountInfo.jdField_c_of_type_JavaLangString, paramView);
    mjp.a(localmjp).setImageDrawable(paramBusinessCountInfo);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = BaseApplicationImpl.getApplication().getResources();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 2))
    {
      this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - AIOUtils.a(11.0F, paramList) - AIOUtils.a(24, paramList)) * 0.5F));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 3)
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - AIOUtils.a(15.0F, paramList) - AIOUtils.a(24, paramList)) / 3.0F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      }
      else
      {
        this.jdField_a_of_type_Int = ((int)((paramList.getDisplayMetrics().widthPixels - AIOUtils.a(15.0F, paramList) - AIOUtils.a(12, paramList)) / 2.5F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(1);
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970680, paramViewGroup, false);
      paramView = new mjp(this, null);
      mjp.a(paramView, (ImageView)localView.findViewById(2131371629));
      mjp.a(paramView, (TextView)localView.findViewById(2131371630));
      mjp.b(paramView, (TextView)localView.findViewById(2131371631));
      localView.setTag(paramView);
    }
    paramView = (SelfInfoModule.BusinessCountInfo)getItem(paramInt);
    if (paramView != null) {
      a(paramView, localView);
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySelfInnerListViewAdapter
 * JD-Core Version:    0.7.0.1
 */