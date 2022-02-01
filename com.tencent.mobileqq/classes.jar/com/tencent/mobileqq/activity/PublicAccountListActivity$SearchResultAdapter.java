package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class PublicAccountListActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List<PublicAccountListActivity.InnerPAInfo> jdField_a_of_type_JavaUtilList;
  
  public PublicAccountListActivity$SearchResultAdapter(List<PublicAccountListActivity.InnerPAInfo> paramList)
  {
    super(paramList, paramList.app, paramList.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
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
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559742, paramViewGroup, false);
      paramView = new PublicAccountListActivity.SearchViewHolder();
      paramView.c = ((ImageView)localView.findViewById(2131368603));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372115));
      localView.setTag(paramView);
      localObject = getItem(paramInt);
      if (localObject != null)
      {
        localObject = (PublicAccountListActivity.InnerPAInfo)localObject;
        if (localObject != null)
        {
          paramView.jdField_a_of_type_JavaLangString = ((PublicAccountListActivity.InnerPAInfo)localObject).a.getUin();
          paramView.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$InnerPAInfo = ((PublicAccountListActivity.InnerPAInfo)localObject);
          paramView.c.setImageBitmap(super.a(paramView.jdField_a_of_type_JavaLangString, 1, (byte)0));
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicAccountListActivity.InnerPAInfo)localObject).a.name);
          if (((PublicAccountListActivity.InnerPAInfo)localObject).a.certifiedGrade <= 0L) {
            break label284;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getResources().getDrawable(2130841947);
            this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
            ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
          }
          paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        localView.setContentDescription(paramView.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (PublicAccountListActivity.SearchViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label284:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */