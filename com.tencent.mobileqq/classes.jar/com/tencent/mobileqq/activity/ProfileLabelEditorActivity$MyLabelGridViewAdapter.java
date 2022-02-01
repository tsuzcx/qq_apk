package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ProfileLabelEditorActivity$MyLabelGridViewAdapter
  extends BaseAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ProfileLabelEditorActivity.MyLabelGridViewAdapter.1(this);
  List<ProfileLabelInfo> jdField_a_of_type_JavaUtilList;
  
  public ProfileLabelEditorActivity$MyLabelGridViewAdapter(List<ProfileLabelInfo> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  private void a(ProfileLabelInfo paramProfileLabelInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.a().keySet().iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)localIterator.next();
      if (localProfileLabelInfo.labelId.equals(paramProfileLabelInfo.labelId)) {
        localObject = localProfileLabelInfo;
      }
    }
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.a(localObject)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.c(localObject, this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.a(localObject));
      return;
    }
    a(paramProfileLabelInfo.labelId);
  }
  
  private void a(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.b.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((ProfileLabelTypeInfo)localIterator.next()).labels);
    }
    paramLong = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.a(paramLong, localArrayList);
    if (paramLong != null) {
      paramLong.toggleStatus();
    }
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
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.getLayoutInflater().inflate(2131562910, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Float * 32.0F)));
      paramView = new ProfileLabelEditorActivity.Holder();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378262));
      localView.setTag(paramView);
    }
    else
    {
      ProfileLabelEditorActivity.Holder localHolder = (ProfileLabelEditorActivity.Holder)paramView.getTag();
      localView = paramView;
      paramView = localHolder;
    }
    paramView.jdField_a_of_type_Int = paramInt;
    int i = paramInt % ProfileLabelEditorActivity.jdField_a_of_type_Array2dOfInt.length;
    localView.setBackgroundResource(ProfileLabelEditorActivity.jdField_a_of_type_Array2dOfInt[i][0]);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    i = ProfileLabelEditorActivity.jdField_a_of_type_Array2dOfInt[i][1];
    paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labelName);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labelName);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.MyLabelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */