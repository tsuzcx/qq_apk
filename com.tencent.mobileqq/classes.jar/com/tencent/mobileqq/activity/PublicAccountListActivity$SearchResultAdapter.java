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
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import tex;
import tez;

public class PublicAccountListActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public PublicAccountListActivity$SearchResultAdapter(PublicAccountListActivity paramPublicAccountListActivity, List paramList)
  {
    super(paramPublicAccountListActivity, paramPublicAccountListActivity.app, paramPublicAccountListActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969223, paramViewGroup, false);
      paramViewGroup = new tez();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131362701));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362736));
      paramView.setTag(paramViewGroup);
      Object localObject = getItem(paramInt);
      if (localObject != null)
      {
        localObject = (tex)localObject;
        if (localObject != null)
        {
          paramViewGroup.jdField_a_of_type_JavaLangString = ((tex)localObject).a.getUin();
          paramViewGroup.jdField_a_of_type_Tex = ((tex)localObject);
          paramViewGroup.c.setImageBitmap(super.a(paramViewGroup.jdField_a_of_type_JavaLangString, 1, (byte)0));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((tex)localObject).a.name);
          if (((tex)localObject).a.certifiedGrade <= 0L) {
            break label243;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getResources().getDrawable(2130839745);
            this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.b) {
        paramView.setContentDescription(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      return paramView;
      paramViewGroup = (tez)paramView.getTag();
      break;
      label243:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */